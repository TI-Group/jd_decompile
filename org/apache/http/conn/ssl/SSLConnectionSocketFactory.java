package org.apache.http.conn.ssl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@ThreadSafe
/* compiled from: TbsSdkJava */
public class SSLConnectionSocketFactory implements LayeredConnectionSocketFactory {
    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER = new AllowAllHostnameVerifier();
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final String SSL = "SSL";
    public static final String SSLV2 = "SSLv2";
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
    public static final String TLS = "TLS";
    private final X509HostnameVerifier hostnameVerifier;
    private final SSLSocketFactory socketfactory;
    private final String[] supportedCipherSuites;
    private final String[] supportedProtocols;

    public static SSLConnectionSocketFactory getSocketFactory() throws SSLInitializationException {
        return new SSLConnectionSocketFactory(SSLContexts.createDefault(), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    private static String[] split(String str) {
        if (TextUtils.isBlank(str)) {
            return null;
        }
        return str.split(" *, *");
    }

    public static SSLConnectionSocketFactory getSystemSocketFactory() throws SSLInitializationException {
        return new SSLConnectionSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault(), split(System.getProperty("https.protocols")), split(System.getProperty("https.cipherSuites")), BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext) {
        this(sSLContext, BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext, X509HostnameVerifier x509HostnameVerifier) {
        this(((SSLContext) Args.notNull(sSLContext, "SSL context")).getSocketFactory(), null, null, x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(SSLContext sSLContext, String[] strArr, String[] strArr2, X509HostnameVerifier x509HostnameVerifier) {
        this(((SSLContext) Args.notNull(sSLContext, "SSL context")).getSocketFactory(), strArr, strArr2, x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        this(sSLSocketFactory, null, null, x509HostnameVerifier);
    }

    public SSLConnectionSocketFactory(SSLSocketFactory sSLSocketFactory, String[] strArr, String[] strArr2, X509HostnameVerifier x509HostnameVerifier) {
        this.socketfactory = (SSLSocketFactory) Args.notNull(sSLSocketFactory, "SSL socket factory");
        this.supportedProtocols = strArr;
        this.supportedCipherSuites = strArr2;
        if (x509HostnameVerifier == null) {
            x509HostnameVerifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
        }
        this.hostnameVerifier = x509HostnameVerifier;
    }

    protected void prepareSocket(SSLSocket sSLSocket) throws IOException {
    }

    public Socket createSocket(HttpContext httpContext) throws IOException {
        return SocketFactory.getDefault().createSocket();
    }

    public Socket connectSocket(int i, Socket socket, HttpHost httpHost, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpContext httpContext) throws IOException {
        Args.notNull(httpHost, "HTTP host");
        Args.notNull(inetSocketAddress, "Remote address");
        Socket createSocket = socket != null ? socket : createSocket(httpContext);
        if (inetSocketAddress2 != null) {
            createSocket.bind(inetSocketAddress2);
        }
        try {
            createSocket.connect(inetSocketAddress, i);
            if (!(createSocket instanceof SSLSocket)) {
                return createLayeredSocket(createSocket, httpHost.getHostName(), inetSocketAddress.getPort(), httpContext);
            }
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            sSLSocket.startHandshake();
            verifyHostname(sSLSocket, httpHost.getHostName());
            return createSocket;
        } catch (IOException e) {
            try {
                createSocket.close();
            } catch (IOException e2) {
            }
            throw e;
        }
    }

    public Socket createLayeredSocket(Socket socket, String str, int i, HttpContext httpContext) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.socketfactory.createSocket(socket, str, i, true);
        if (this.supportedProtocols != null) {
            sSLSocket.setEnabledProtocols(this.supportedProtocols);
        }
        if (this.supportedCipherSuites != null) {
            sSLSocket.setEnabledCipherSuites(this.supportedCipherSuites);
        }
        prepareSocket(sSLSocket);
        sSLSocket.startHandshake();
        verifyHostname(sSLSocket, str);
        return sSLSocket;
    }

    X509HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    private void verifyHostname(SSLSocket sSLSocket, String str) throws IOException {
        try {
            this.hostnameVerifier.verify(str, sSLSocket);
        } catch (IOException e) {
            try {
                sSLSocket.close();
            } catch (Exception e2) {
            }
            throw e;
        }
    }
}
