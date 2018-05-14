package okhttp3.internal.http;

import b.r;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.io.RealConnection;

/* compiled from: TbsSdkJava */
public final class StreamAllocation {
    public final Address address;
    private boolean canceled;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    private boolean released;
    private Route route;
    private RouteSelector routeSelector;
    private HttpStream stream;

    public StreamAllocation(ConnectionPool connectionPool, Address address) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.routeSelector = new RouteSelector(address, routeDatabase());
    }

    public HttpStream newStream(int i, int i2, int i3, boolean z, boolean z2) throws RouteException, IOException {
        try {
            HttpStream http2xStream;
            RealConnection findHealthyConnection = findHealthyConnection(i, i2, i3, z, z2);
            if (findHealthyConnection.framedConnection != null) {
                http2xStream = new Http2xStream(this, findHealthyConnection.framedConnection);
            } else {
                findHealthyConnection.socket().setSoTimeout(i2);
                findHealthyConnection.source.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
                findHealthyConnection.sink.timeout().timeout((long) i3, TimeUnit.MILLISECONDS);
                http2xStream = new Http1xStream(this, findHealthyConnection.source, findHealthyConnection.sink);
            }
            synchronized (this.connectionPool) {
                this.stream = http2xStream;
            }
            return http2xStream;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    private RealConnection findHealthyConnection(int i, int i2, int i3, boolean z, boolean z2) throws IOException, RouteException {
        RealConnection findConnection;
        while (true) {
            findConnection = findConnection(i, i2, i3, z);
            synchronized (this.connectionPool) {
                if (findConnection.successCount != 0) {
                    if (findConnection.isHealthy(z2)) {
                        break;
                    }
                    connectionFailed(new IOException());
                } else {
                    break;
                }
            }
        }
        return findConnection;
    }

    private RealConnection findConnection(int i, int i2, int i3, boolean z) throws IOException, RouteException {
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            if (this.released) {
                throw new IllegalStateException("released");
            } else if (this.stream != null) {
                throw new IllegalStateException("stream != null");
            } else if (this.canceled) {
                throw new IOException("Canceled");
            } else {
                realConnection = this.connection;
                if (realConnection == null || realConnection.noNewStreams) {
                    realConnection = Internal.instance.get(this.connectionPool, this.address, this);
                    if (realConnection != null) {
                        this.connection = realConnection;
                    } else {
                        Route route;
                        Route route2 = this.route;
                        if (route2 == null) {
                            route2 = this.routeSelector.next();
                            synchronized (this.connectionPool) {
                                this.route = route2;
                            }
                            route = route2;
                        } else {
                            route = route2;
                        }
                        realConnection = new RealConnection(route);
                        acquire(realConnection);
                        synchronized (this.connectionPool) {
                            Internal.instance.put(this.connectionPool, realConnection);
                            this.connection = realConnection;
                            if (this.canceled) {
                                throw new IOException("Canceled");
                            }
                        }
                        realConnection.connect(i, i2, i3, this.address.connectionSpecs(), z);
                        routeDatabase().connected(realConnection.route());
                    }
                }
            }
        }
        return realConnection;
    }

    public void streamFinished(boolean z, HttpStream httpStream) {
        synchronized (this.connectionPool) {
            if (httpStream != null) {
                if (httpStream == this.stream) {
                    if (!z) {
                        RealConnection realConnection = this.connection;
                        realConnection.successCount++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.stream + " but was " + httpStream);
        }
        deallocate(z, false, true);
    }

    public HttpStream stream() {
        HttpStream httpStream;
        synchronized (this.connectionPool) {
            httpStream = this.stream;
        }
        return httpStream;
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public void release() {
        deallocate(false, true, false);
    }

    public void noNewStreams() {
        deallocate(true, false, false);
    }

    private void deallocate(boolean z, boolean z2, boolean z3) {
        RealConnection realConnection = null;
        synchronized (this.connectionPool) {
            if (z3) {
                this.stream = null;
            }
            if (z2) {
                this.released = true;
            }
            if (this.connection != null) {
                if (z) {
                    this.connection.noNewStreams = true;
                }
                if (this.stream == null && (this.released || this.connection.noNewStreams)) {
                    release(this.connection);
                    if (this.connection.allocations.isEmpty()) {
                        this.connection.idleAtNanos = System.nanoTime();
                        if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                            realConnection = this.connection;
                        }
                    }
                    this.connection = null;
                }
            }
        }
        if (realConnection != null) {
            Util.closeQuietly(realConnection.socket());
        }
    }

    public void cancel() {
        synchronized (this.connectionPool) {
            this.canceled = true;
            HttpStream httpStream = this.stream;
            RealConnection realConnection = this.connection;
        }
        if (httpStream != null) {
            httpStream.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public void connectionFailed(IOException iOException) {
        synchronized (this.connectionPool) {
            if (this.connection != null && this.connection.successCount == 0) {
                if (!(this.route == null || iOException == null)) {
                    this.routeSelector.connectFailed(this.route, iOException);
                }
                this.route = null;
            }
        }
        deallocate(true, false, true);
    }

    public void acquire(RealConnection realConnection) {
        realConnection.allocations.add(new WeakReference(this));
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) realConnection.allocations.get(i)).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public boolean recover(IOException iOException, r rVar) {
        if (this.connection != null) {
            connectionFailed(iOException);
        }
        boolean z = rVar == null || (rVar instanceof RetryableSink);
        if ((this.routeSelector == null || this.routeSelector.hasNext()) && isRecoverable(iOException) && z) {
            return true;
        }
        return false;
    }

    private boolean isRecoverable(IOException iOException) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return iOException instanceof SocketTimeoutException;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.address.toString();
    }
}
