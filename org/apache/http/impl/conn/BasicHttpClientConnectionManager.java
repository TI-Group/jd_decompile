package org.apache.http.impl.conn;

import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.LangUtils;

@ThreadSafe
/* compiled from: TbsSdkJava */
public class BasicHttpClientConnectionManager implements Closeable, HttpClientConnectionManager {
    @GuardedBy("this")
    private ManagedHttpClientConnection conn;
    @GuardedBy("this")
    private ConnectionConfig connConfig;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    private final HttpClientConnectionOperator connectionOperator;
    @GuardedBy("this")
    private long expiry;
    private final AtomicBoolean isShutdown;
    @GuardedBy("this")
    private boolean leased;
    private final Log log;
    @GuardedBy("this")
    private HttpRoute route;
    @GuardedBy("this")
    private SocketConfig socketConfig;
    @GuardedBy("this")
    private Object state;
    @GuardedBy("this")
    private long updated;

    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
        return RegistryBuilder.create().register(HttpHost.DEFAULT_SCHEME_NAME, PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        this.log = LogFactory.getLog(getClass());
        this.connectionOperator = new HttpClientConnectionOperator(lookup, schemePortResolver, dnsResolver);
        if (httpConnectionFactory == null) {
            httpConnectionFactory = ManagedHttpClientConnectionFactory.INSTANCE;
        }
        this.connFactory = httpConnectionFactory;
        this.expiry = Long.MAX_VALUE;
        this.socketConfig = SocketConfig.DEFAULT;
        this.connConfig = ConnectionConfig.DEFAULT;
        this.isShutdown = new AtomicBoolean(false);
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(lookup, httpConnectionFactory, null, null);
    }

    public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> lookup) {
        this(lookup, null, null, null);
    }

    public BasicHttpClientConnectionManager() {
        this(getDefaultRegistry(), null, null, null);
    }

    protected void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public void close() {
        shutdown();
    }

    HttpRoute getRoute() {
        return this.route;
    }

    Object getState() {
        return this.state;
    }

    public synchronized SocketConfig getSocketConfig() {
        return this.socketConfig;
    }

    public synchronized void setSocketConfig(SocketConfig socketConfig) {
        if (socketConfig == null) {
            socketConfig = SocketConfig.DEFAULT;
        }
        this.socketConfig = socketConfig;
    }

    public synchronized ConnectionConfig getConnectionConfig() {
        return this.connConfig;
    }

    public synchronized void setConnectionConfig(ConnectionConfig connectionConfig) {
        if (connectionConfig == null) {
            connectionConfig = ConnectionConfig.DEFAULT;
        }
        this.connConfig = connectionConfig;
    }

    public final ConnectionRequest requestConnection(final HttpRoute httpRoute, final Object obj) {
        Args.notNull(httpRoute, "Route");
        return new ConnectionRequest() {
            public boolean cancel() {
                return false;
            }

            public HttpClientConnection get(long j, TimeUnit timeUnit) {
                return BasicHttpClientConnectionManager.this.getConnection(httpRoute, obj);
            }
        };
    }

    private void closeConnection() {
        if (this.conn != null) {
            this.log.debug("Closing connection");
            try {
                this.conn.close();
            } catch (Throwable e) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("I/O exception closing connection", e);
                }
            }
            this.conn = null;
        }
    }

    private void shutdownConnection() {
        if (this.conn != null) {
            this.log.debug("Shutting down connection");
            try {
                this.conn.shutdown();
            } catch (Throwable e) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("I/O exception shutting down connection", e);
                }
            }
            this.conn = null;
        }
    }

    private void checkExpiry() {
        if (this.conn != null && System.currentTimeMillis() >= this.expiry) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection expired @ " + new Date(this.expiry));
            }
            closeConnection();
        }
    }

    synchronized HttpClientConnection getConnection(HttpRoute httpRoute, Object obj) {
        HttpClientConnection httpClientConnection;
        boolean z = true;
        synchronized (this) {
            Asserts.check(!this.isShutdown.get(), "Connection manager has been shut down");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Get connection for route " + httpRoute);
            }
            if (this.leased) {
                z = false;
            }
            Asserts.check(z, "Connection is still allocated");
            if (!(LangUtils.equals(this.route, (Object) httpRoute) && LangUtils.equals(this.state, obj))) {
                closeConnection();
            }
            this.route = httpRoute;
            this.state = obj;
            checkExpiry();
            if (this.conn == null) {
                this.conn = (ManagedHttpClientConnection) this.connFactory.create(httpRoute, this.connConfig);
            }
            this.leased = true;
            httpClientConnection = this.conn;
        }
        return httpClientConnection;
    }

    public synchronized void releaseConnection(HttpClientConnection httpClientConnection, Object obj, long j, TimeUnit timeUnit) {
        boolean z = false;
        synchronized (this) {
            Args.notNull(httpClientConnection, "Connection");
            if (httpClientConnection == this.conn) {
                z = true;
            }
            Asserts.check(z, "Connection not obtained from this manager");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Releasing connection " + httpClientConnection);
            }
            if (!this.isShutdown.get()) {
                try {
                    this.updated = System.currentTimeMillis();
                    ManagedHttpClientConnection isOpen = this.conn.isOpen();
                    if (isOpen == null) {
                        this.conn = isOpen;
                        this.route = null;
                        this.conn = null;
                        this.expiry = Long.MAX_VALUE;
                        this.leased = false;
                    } else {
                        this.state = obj;
                        if (this.log.isDebugEnabled()) {
                            String str;
                            if (j > 0) {
                                str = "for " + j + " " + timeUnit;
                            } else {
                                str = "indefinitely";
                            }
                            this.log.debug("Connection can be kept alive " + str);
                        }
                        if (j > 0) {
                            this.expiry = this.updated + timeUnit.toMillis(j);
                        } else {
                            this.expiry = Long.MAX_VALUE;
                        }
                        this.leased = false;
                    }
                } finally {
                    this.leased = false;
                }
            }
        }
    }

    public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext) throws IOException {
        HttpHost proxyHost;
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        if (httpRoute.getProxyHost() != null) {
            proxyHost = httpRoute.getProxyHost();
        } else {
            proxyHost = httpRoute.getTargetHost();
        }
        this.connectionOperator.connect(this.conn, proxyHost, httpRoute.getLocalSocketAddress(), i, this.socketConfig, httpContext);
    }

    public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Connection");
        Args.notNull(httpRoute, "HTTP route");
        Asserts.check(httpClientConnection == this.conn, "Connection not obtained from this manager");
        this.connectionOperator.upgrade(this.conn, httpRoute.getTargetHost(), httpContext);
    }

    public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
    }

    public synchronized void closeExpiredConnections() {
        if (!this.isShutdown.get()) {
            if (!this.leased) {
                checkExpiry();
            }
        }
    }

    public synchronized void closeIdleConnections(long j, TimeUnit timeUnit) {
        long j2 = 0;
        synchronized (this) {
            Args.notNull(timeUnit, "Time unit");
            if (!this.isShutdown.get()) {
                if (!this.leased) {
                    long toMillis = timeUnit.toMillis(j);
                    if (toMillis >= 0) {
                        j2 = toMillis;
                    }
                    if (this.updated <= System.currentTimeMillis() - j2) {
                        closeConnection();
                    }
                }
            }
        }
    }

    public synchronized void shutdown() {
        if (this.isShutdown.compareAndSet(false, true)) {
            shutdownConnection();
        }
    }
}
