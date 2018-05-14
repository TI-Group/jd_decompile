package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
class HttpClientConnectionOperator {
    static final String SOCKET_FACTORY_REGISTRY = "http.socket-factory-registry";
    private final DnsResolver dnsResolver;
    private final Log log = LogFactory.getLog(getClass());
    private final SchemePortResolver schemePortResolver;
    private final Lookup<ConnectionSocketFactory> socketFactoryRegistry;

    HttpClientConnectionOperator(Lookup<ConnectionSocketFactory> lookup, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        Args.notNull(lookup, "Socket factory registry");
        this.socketFactoryRegistry = lookup;
        if (schemePortResolver == null) {
            schemePortResolver = DefaultSchemePortResolver.INSTANCE;
        }
        this.schemePortResolver = schemePortResolver;
        if (dnsResolver == null) {
            dnsResolver = SystemDefaultDnsResolver.INSTANCE;
        }
        this.dnsResolver = dnsResolver;
    }

    private Lookup<ConnectionSocketFactory> getSocketFactoryRegistry(HttpContext httpContext) {
        Lookup<ConnectionSocketFactory> lookup = (Lookup) httpContext.getAttribute("http.socket-factory-registry");
        if (lookup == null) {
            return this.socketFactoryRegistry;
        }
        return lookup;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(org.apache.http.conn.ManagedHttpClientConnection r13, org.apache.http.HttpHost r14, java.net.InetSocketAddress r15, int r16, org.apache.http.config.SocketConfig r17, org.apache.http.protocol.HttpContext r18) throws java.io.IOException {
        /*
        r12 = this;
        r0 = r18;
        r1 = r12.getSocketFactoryRegistry(r0);
        r2 = r14.getSchemeName();
        r1 = r1.lookup(r2);
        r1 = (org.apache.http.conn.socket.ConnectionSocketFactory) r1;
        if (r1 != 0) goto L_0x002f;
    L_0x0012:
        r1 = new org.apache.http.conn.UnsupportedSchemeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r14.getSchemeName();
        r2 = r2.append(r3);
        r3 = " protocol is not supported";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
    L_0x002f:
        r2 = r12.dnsResolver;
        r3 = r14.getHostName();
        r10 = r2.resolve(r3);
        r2 = r12.schemePortResolver;
        r11 = r2.resolve(r14);
        r2 = 0;
        r8 = r2;
    L_0x0041:
        r2 = r10.length;
        if (r8 >= r2) goto L_0x00d0;
    L_0x0044:
        r4 = r10[r8];
        r2 = r10.length;
        r2 = r2 + -1;
        if (r8 != r2) goto L_0x00d1;
    L_0x004b:
        r2 = 1;
        r9 = r2;
    L_0x004d:
        r0 = r18;
        r3 = r1.createSocket(r0);
        r2 = r17.getSoTimeout();
        r3.setSoTimeout(r2);
        r2 = r17.isSoReuseAddress();
        r3.setReuseAddress(r2);
        r2 = r17.isTcpNoDelay();
        r3.setTcpNoDelay(r2);
        r2 = r17.isSoKeepAlive();
        r3.setKeepAlive(r2);
        r5 = r17.getSoLinger();
        if (r5 < 0) goto L_0x007b;
    L_0x0075:
        if (r5 <= 0) goto L_0x00d5;
    L_0x0077:
        r2 = 1;
    L_0x0078:
        r3.setSoLinger(r2, r5);
    L_0x007b:
        r13.bind(r3);
        r5 = new java.net.InetSocketAddress;
        r5.<init>(r4, r11);
        r2 = r12.log;
        r2 = r2.isDebugEnabled();
        if (r2 == 0) goto L_0x00a3;
    L_0x008b:
        r2 = r12.log;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "Connecting to ";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r2.debug(r4);
    L_0x00a3:
        r2 = r16;
        r4 = r14;
        r6 = r15;
        r7 = r18;
        r2 = r1.connectSocket(r2, r3, r4, r5, r6, r7);	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        r13.bind(r2);	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        r2 = r12.log;	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        r2 = r2.isDebugEnabled();	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        if (r2 == 0) goto L_0x00d0;
    L_0x00b8:
        r2 = r12.log;	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        r3.<init>();	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        r4 = "Connection established ";
        r3 = r3.append(r4);	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        r3 = r3.append(r13);	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        r3 = r3.toString();	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
        r2.debug(r3);	 Catch:{ SocketTimeoutException -> 0x00d7, ConnectException -> 0x00e0 }
    L_0x00d0:
        return;
    L_0x00d1:
        r2 = 0;
        r9 = r2;
        goto L_0x004d;
    L_0x00d5:
        r2 = 0;
        goto L_0x0078;
    L_0x00d7:
        r2 = move-exception;
        if (r9 == 0) goto L_0x00fb;
    L_0x00da:
        r1 = new org.apache.http.conn.ConnectTimeoutException;
        r1.<init>(r2, r14, r10);
        throw r1;
    L_0x00e0:
        r2 = move-exception;
        if (r9 == 0) goto L_0x00fb;
    L_0x00e3:
        r1 = r2.getMessage();
        r3 = "Connection timed out";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x00f5;
    L_0x00ef:
        r1 = new org.apache.http.conn.ConnectTimeoutException;
        r1.<init>(r2, r14, r10);
        throw r1;
    L_0x00f5:
        r1 = new org.apache.http.conn.HttpHostConnectException;
        r1.<init>(r2, r14, r10);
        throw r1;
    L_0x00fb:
        r2 = r12.log;
        r2 = r2.isDebugEnabled();
        if (r2 == 0) goto L_0x0127;
    L_0x0103:
        r2 = r12.log;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Connect to ";
        r3 = r3.append(r4);
        r3 = r3.append(r5);
        r4 = " timed out. ";
        r3 = r3.append(r4);
        r4 = "Connection will be retried using another IP address";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.debug(r3);
    L_0x0127:
        r2 = r8 + 1;
        r8 = r2;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.HttpClientConnectionOperator.connect(org.apache.http.conn.ManagedHttpClientConnection, org.apache.http.HttpHost, java.net.InetSocketAddress, int, org.apache.http.config.SocketConfig, org.apache.http.protocol.HttpContext):void");
    }

    public void upgrade(ManagedHttpClientConnection managedHttpClientConnection, HttpHost httpHost, HttpContext httpContext) throws IOException {
        ConnectionSocketFactory connectionSocketFactory = (ConnectionSocketFactory) getSocketFactoryRegistry(HttpClientContext.adapt(httpContext)).lookup(httpHost.getSchemeName());
        if (connectionSocketFactory == null) {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol is not supported");
        } else if (connectionSocketFactory instanceof LayeredConnectionSocketFactory) {
            managedHttpClientConnection.bind(((LayeredConnectionSocketFactory) connectionSocketFactory).createLayeredSocket(managedHttpClientConnection.getSocket(), httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpContext));
        } else {
            throw new UnsupportedSchemeException(httpHost.getSchemeName() + " protocol does not support connection upgrade");
        }
    }
}
