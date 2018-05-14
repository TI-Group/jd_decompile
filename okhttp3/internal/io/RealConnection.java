package okhttp3.internal.io;

import b.d;
import b.e;
import b.m;
import b.s;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.ConnectionSpecSelector;
import okhttp3.internal.Platform;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedConnection.Builder;
import okhttp3.internal.framed.FramedConnection.Listener;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.http.Http1xStream;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.RouteException;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.tls.OkHostnameVerifier;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public final class RealConnection extends Listener implements Connection {
    public int allocationLimit;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    public volatile FramedConnection framedConnection;
    private Handshake handshake;
    public long idleAtNanos = Long.MAX_VALUE;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    public d sink;
    public Socket socket;
    public e source;
    public int successCount;

    public RealConnection(Route route) {
        this.route = route;
    }

    public void connect(int i, int i2, int i3, List<ConnectionSpec> list, boolean z) throws RouteException {
        if (this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        if (this.route.address().sslSocketFactory() != null || list.contains(ConnectionSpec.CLEARTEXT)) {
            RouteException routeException = null;
            while (this.protocol == null) {
                Socket createSocket;
                if (proxy.type() == Type.DIRECT || proxy.type() == Type.HTTP) {
                    createSocket = address.socketFactory().createSocket();
                } else {
                    try {
                        createSocket = new Socket(proxy);
                    } catch (IOException e) {
                        Util.closeQuietly(this.socket);
                        Util.closeQuietly(this.rawSocket);
                        this.socket = null;
                        this.rawSocket = null;
                        this.source = null;
                        this.sink = null;
                        this.handshake = null;
                        this.protocol = null;
                        if (routeException == null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.addConnectException(e);
                        }
                        if (!z || !connectionSpecSelector.connectionFailed(e)) {
                            throw routeException;
                        }
                    }
                }
                this.rawSocket = createSocket;
                connectSocket(i, i2, i3, connectionSpecSelector);
            }
            return;
        }
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
    }

    private void connectSocket(int i, int i2, int i3, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
            this.source = m.a(m.b(this.rawSocket));
            this.sink = m.a(m.a(this.rawSocket));
            if (this.route.address().sslSocketFactory() != null) {
                connectTls(i2, i3, connectionSpecSelector);
            } else {
                this.protocol = Protocol.HTTP_1_1;
                this.socket = this.rawSocket;
            }
            if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
                this.socket.setSoTimeout(0);
                FramedConnection build = new Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).protocol(this.protocol).listener(this).build();
                build.sendConnectionPreface();
                this.allocationLimit = build.maxConcurrentStreams();
                this.framedConnection = build;
                return;
            }
            this.allocationLimit = 1;
        } catch (ConnectException e) {
            throw new ConnectException("Failed to connect to " + this.route.socketAddress());
        }
    }

    private void connectTls(int i, int i2, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Throwable th;
        Socket socket;
        Throwable th2;
        String str = null;
        if (this.route.requiresTunnel()) {
            createTunnel(i, i2);
        }
        Address address = this.route.address();
        try {
            Socket socket2 = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(socket2);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.get().configureTlsExtensions(socket2, address.url().host(), address.protocols());
                }
                socket2.startHandshake();
                Handshake handshake = Handshake.get(socket2.getSession());
                if (address.hostnameVerifier().verify(address.url().host(), socket2.getSession())) {
                    address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        str = Platform.get().getSelectedProtocol(socket2);
                    }
                    this.socket = socket2;
                    this.source = m.a(m.b(this.socket));
                    this.sink = m.a(m.a(this.socket));
                    this.handshake = handshake;
                    this.protocol = str != null ? Protocol.get(str) : Protocol.HTTP_1_1;
                    if (socket2 != null) {
                        Platform.get().afterHandshake(socket2);
                        return;
                    }
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:" + "\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
            } catch (Throwable e) {
                th = e;
                socket = socket2;
                th2 = th;
                try {
                    if (Util.isAndroidGetsocknameError(th2)) {
                        throw new IOException(th2);
                    }
                    throw th2;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } catch (Throwable e2) {
                th = e2;
                socket = socket2;
                th2 = th;
                if (socket != null) {
                    Platform.get().afterHandshake(socket);
                }
                Util.closeQuietly(socket);
                throw th2;
            }
        } catch (AssertionError e3) {
            th2 = e3;
            if (Util.isAndroidGetsocknameError(th2)) {
                throw new IOException(th2);
            }
            throw th2;
        }
    }

    private void createTunnel(int i, int i2) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        String str = "CONNECT " + Util.hostHeader(createTunnelRequest.url(), true) + " HTTP/1.1";
        do {
            Http1xStream http1xStream = new Http1xStream(null, this.source, this.sink);
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1xStream.writeRequest(createTunnelRequest.headers(), str);
            http1xStream.finishRequest();
            Response build = http1xStream.readResponse().request(createTunnelRequest).build();
            long contentLength = OkHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            s newFixedLengthSource = http1xStream.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            switch (build.code()) {
                case 200:
                    if (!this.source.b().e() || !this.sink.b().e()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    return;
                case 407:
                    createTunnelRequest = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
        } while (createTunnelRequest != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private Request createTunnelRequest() throws IOException {
        return new Request.Builder().url(this.route.address().url()).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).header("User-Agent", Version.userAgent()).build();
    }

    boolean isConnected() {
        return this.protocol != null;
    }

    public Route route() {
        return this.route;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    public Socket socket() {
        return this.socket;
    }

    public boolean isHealthy(boolean z) {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.framedConnection != null || !z) {
            return true;
        }
        int soTimeout;
        try {
            soTimeout = this.socket.getSoTimeout();
            this.socket.setSoTimeout(1);
            if (this.source.e()) {
                this.socket.setSoTimeout(soTimeout);
                return false;
            }
            this.socket.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            this.socket.setSoTimeout(soTimeout);
        }
    }

    public void onStream(FramedStream framedStream) throws IOException {
        framedStream.close(ErrorCode.REFUSED_STREAM);
    }

    public void onSettings(FramedConnection framedConnection) {
        this.allocationLimit = framedConnection.maxConcurrentStreams();
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isMultiplexed() {
        return this.framedConnection != null;
    }

    public Protocol protocol() {
        if (this.framedConnection == null) {
            return this.protocol != null ? this.protocol : Protocol.HTTP_1_1;
        } else {
            return this.framedConnection.getProtocol();
        }
    }

    public String toString() {
        return "Connection{" + this.route.address().url().host() + ":" + this.route.address().url().port() + ", proxy=" + this.route.proxy() + " hostAddress=" + this.route.socketAddress() + " cipherSuite=" + (this.handshake != null ? this.handshake.cipherSuite() : "none") + " protocol=" + this.protocol + '}';
    }
}
