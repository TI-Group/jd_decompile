package org.apache.http.impl.conn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeLayeredSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Deprecated
@ThreadSafe
/* compiled from: TbsSdkJava */
public class DefaultClientConnectionOperator implements ClientConnectionOperator {
    protected final DnsResolver dnsResolver;
    private final Log log = LogFactory.getLog(getClass());
    protected final SchemeRegistry schemeRegistry;

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry) {
        Args.notNull(schemeRegistry, "Scheme registry");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = new SystemDefaultDnsResolver();
    }

    public DefaultClientConnectionOperator(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        Args.notNull(schemeRegistry, "Scheme registry");
        Args.notNull(dnsResolver, "DNS resolver");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = dnsResolver;
    }

    public OperatedClientConnection createConnection() {
        return new DefaultClientConnection();
    }

    private SchemeRegistry getSchemeRegistry(HttpContext httpContext) {
        SchemeRegistry schemeRegistry = (SchemeRegistry) httpContext.getAttribute(ClientContext.SCHEME_REGISTRY);
        if (schemeRegistry == null) {
            return this.schemeRegistry;
        }
        return schemeRegistry;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openConnection(org.apache.http.conn.OperatedClientConnection r14, org.apache.http.HttpHost r15, java.net.InetAddress r16, org.apache.http.protocol.HttpContext r17, org.apache.http.params.HttpParams r18) throws java.io.IOException {
        /*
        r13 = this;
        r2 = "Connection";
        org.apache.http.util.Args.notNull(r14, r2);
        r2 = "Target host";
        org.apache.http.util.Args.notNull(r15, r2);
        r2 = "HTTP parameters";
        r0 = r18;
        org.apache.http.util.Args.notNull(r0, r2);
        r2 = r14.isOpen();
        if (r2 != 0) goto L_0x00a0;
    L_0x0017:
        r2 = 1;
    L_0x0018:
        r3 = "Connection must not be open";
        org.apache.http.util.Asserts.check(r2, r3);
        r0 = r17;
        r2 = r13.getSchemeRegistry(r0);
        r3 = r15.getSchemeName();
        r2 = r2.getScheme(r3);
        r6 = r2.getSchemeSocketFactory();
        r3 = r15.getHostName();
        r7 = r13.resolveHostname(r3);
        r3 = r15.getPort();
        r8 = r2.resolvePort(r3);
        r2 = 0;
    L_0x0040:
        r3 = r7.length;
        if (r2 >= r3) goto L_0x009f;
    L_0x0043:
        r4 = r7[r2];
        r3 = r7.length;
        r3 = r3 + -1;
        if (r2 != r3) goto L_0x00a3;
    L_0x004a:
        r3 = 1;
    L_0x004b:
        r0 = r18;
        r5 = r6.createSocket(r0);
        r14.opening(r5, r15);
        r9 = new org.apache.http.conn.HttpInetSocketAddress;
        r9.<init>(r15, r4, r8);
        r4 = 0;
        if (r16 == 0) goto L_0x0064;
    L_0x005c:
        r4 = new java.net.InetSocketAddress;
        r10 = 0;
        r0 = r16;
        r4.<init>(r0, r10);
    L_0x0064:
        r10 = r13.log;
        r10 = r10.isDebugEnabled();
        if (r10 == 0) goto L_0x0084;
    L_0x006c:
        r10 = r13.log;
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = "Connecting to ";
        r11 = r11.append(r12);
        r11 = r11.append(r9);
        r11 = r11.toString();
        r10.debug(r11);
    L_0x0084:
        r0 = r18;
        r4 = r6.connectSocket(r5, r9, r4, r0);	 Catch:{ ConnectException -> 0x00a5, ConnectTimeoutException -> 0x00a9 }
        if (r5 == r4) goto L_0x00dd;
    L_0x008c:
        r14.opening(r4, r15);	 Catch:{ ConnectException -> 0x00a5, ConnectTimeoutException -> 0x00a9 }
    L_0x008f:
        r0 = r17;
        r1 = r18;
        r13.prepareSocket(r4, r0, r1);	 Catch:{ ConnectException -> 0x00a5, ConnectTimeoutException -> 0x00a9 }
        r4 = r6.isSecure(r4);	 Catch:{ ConnectException -> 0x00a5, ConnectTimeoutException -> 0x00a9 }
        r0 = r18;
        r14.openCompleted(r4, r0);	 Catch:{ ConnectException -> 0x00a5, ConnectTimeoutException -> 0x00a9 }
    L_0x009f:
        return;
    L_0x00a0:
        r2 = 0;
        goto L_0x0018;
    L_0x00a3:
        r3 = 0;
        goto L_0x004b;
    L_0x00a5:
        r4 = move-exception;
        if (r3 == 0) goto L_0x00ad;
    L_0x00a8:
        throw r4;
    L_0x00a9:
        r4 = move-exception;
        if (r3 == 0) goto L_0x00ad;
    L_0x00ac:
        throw r4;
    L_0x00ad:
        r3 = r13.log;
        r3 = r3.isDebugEnabled();
        if (r3 == 0) goto L_0x00d9;
    L_0x00b5:
        r3 = r13.log;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Connect to ";
        r4 = r4.append(r5);
        r4 = r4.append(r9);
        r5 = " timed out. ";
        r4 = r4.append(r5);
        r5 = "Connection will be retried using another IP address";
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.debug(r4);
    L_0x00d9:
        r2 = r2 + 1;
        goto L_0x0040;
    L_0x00dd:
        r4 = r5;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.DefaultClientConnectionOperator.openConnection(org.apache.http.conn.OperatedClientConnection, org.apache.http.HttpHost, java.net.InetAddress, org.apache.http.protocol.HttpContext, org.apache.http.params.HttpParams):void");
    }

    public void updateSecureConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, HttpContext httpContext, HttpParams httpParams) throws IOException {
        Args.notNull(operatedClientConnection, "Connection");
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpParams, "Parameters");
        Asserts.check(operatedClientConnection.isOpen(), "Connection must be open");
        Scheme scheme = getSchemeRegistry(httpContext).getScheme(httpHost.getSchemeName());
        Asserts.check(scheme.getSchemeSocketFactory() instanceof SchemeLayeredSocketFactory, "Socket factory must implement SchemeLayeredSocketFactory");
        SchemeLayeredSocketFactory schemeLayeredSocketFactory = (SchemeLayeredSocketFactory) scheme.getSchemeSocketFactory();
        Socket createLayeredSocket = schemeLayeredSocketFactory.createLayeredSocket(operatedClientConnection.getSocket(), httpHost.getHostName(), scheme.resolvePort(httpHost.getPort()), httpParams);
        prepareSocket(createLayeredSocket, httpContext, httpParams);
        operatedClientConnection.update(createLayeredSocket, httpHost, schemeLayeredSocketFactory.isSecure(createLayeredSocket), httpParams);
    }

    protected void prepareSocket(Socket socket, HttpContext httpContext, HttpParams httpParams) throws IOException {
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(httpParams));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(httpParams));
        int linger = HttpConnectionParams.getLinger(httpParams);
        if (linger >= 0) {
            socket.setSoLinger(linger > 0, linger);
        }
    }

    protected InetAddress[] resolveHostname(String str) throws UnknownHostException {
        return this.dnsResolver.resolve(str);
    }
}
