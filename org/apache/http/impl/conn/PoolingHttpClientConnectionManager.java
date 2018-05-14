package org.apache.http.impl.conn;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionPoolTimeoutException;
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
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@ThreadSafe
/* compiled from: TbsSdkJava */
public class PoolingHttpClientConnectionManager implements Closeable, HttpClientConnectionManager, ConnPoolControl<HttpRoute> {
    private final ConfigData configData;
    private final HttpClientConnectionOperator connectionOperator;
    private final AtomicBoolean isShutDown;
    private final Log log;
    private final CPool pool;

    /* compiled from: TbsSdkJava */
    static class ConfigData {
        private final Map<HttpHost, ConnectionConfig> connectionConfigMap = new ConcurrentHashMap();
        private volatile ConnectionConfig defaultConnectionConfig;
        private volatile SocketConfig defaultSocketConfig;
        private final Map<HttpHost, SocketConfig> socketConfigMap = new ConcurrentHashMap();

        ConfigData() {
        }

        public SocketConfig getDefaultSocketConfig() {
            return this.defaultSocketConfig;
        }

        public void setDefaultSocketConfig(SocketConfig socketConfig) {
            this.defaultSocketConfig = socketConfig;
        }

        public ConnectionConfig getDefaultConnectionConfig() {
            return this.defaultConnectionConfig;
        }

        public void setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
            this.defaultConnectionConfig = connectionConfig;
        }

        public SocketConfig getSocketConfig(HttpHost httpHost) {
            return (SocketConfig) this.socketConfigMap.get(httpHost);
        }

        public void setSocketConfig(HttpHost httpHost, SocketConfig socketConfig) {
            this.socketConfigMap.put(httpHost, socketConfig);
        }

        public ConnectionConfig getConnectionConfig(HttpHost httpHost) {
            return (ConnectionConfig) this.connectionConfigMap.get(httpHost);
        }

        public void setConnectionConfig(HttpHost httpHost, ConnectionConfig connectionConfig) {
            this.connectionConfigMap.put(httpHost, connectionConfig);
        }
    }

    /* compiled from: TbsSdkJava */
    static class InternalConnectionFactory implements ConnFactory<HttpRoute, ManagedHttpClientConnection> {
        private final ConfigData configData;
        private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;

        InternalConnectionFactory(ConfigData configData, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
            if (configData == null) {
                configData = new ConfigData();
            }
            this.configData = configData;
            if (httpConnectionFactory == null) {
                httpConnectionFactory = ManagedHttpClientConnectionFactory.INSTANCE;
            }
            this.connFactory = httpConnectionFactory;
        }

        public ManagedHttpClientConnection create(HttpRoute httpRoute) throws IOException {
            ConnectionConfig connectionConfig = null;
            if (httpRoute.getProxyHost() != null) {
                connectionConfig = this.configData.getConnectionConfig(httpRoute.getProxyHost());
            }
            if (connectionConfig == null) {
                connectionConfig = this.configData.getConnectionConfig(httpRoute.getTargetHost());
            }
            if (connectionConfig == null) {
                connectionConfig = this.configData.getDefaultConnectionConfig();
            }
            if (connectionConfig == null) {
                connectionConfig = ConnectionConfig.DEFAULT;
            }
            return (ManagedHttpClientConnection) this.connFactory.create(httpRoute, connectionConfig);
        }
    }

    private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
        return RegistryBuilder.create().register(HttpHost.DEFAULT_SCHEME_NAME, PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
    }

    public PoolingHttpClientConnectionManager() {
        this(getDefaultRegistry());
    }

    public PoolingHttpClientConnectionManager(long j, TimeUnit timeUnit) {
        this(getDefaultRegistry(), null, null, null, j, timeUnit);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry) {
        this(registry, null, null);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, DnsResolver dnsResolver) {
        this(registry, null, dnsResolver);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(registry, httpConnectionFactory, null);
    }

    public PoolingHttpClientConnectionManager(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory) {
        this(getDefaultRegistry(), httpConnectionFactory, null);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, DnsResolver dnsResolver) {
        this(registry, httpConnectionFactory, null, dnsResolver, -1, TimeUnit.MILLISECONDS);
    }

    public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> registry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, SchemePortResolver schemePortResolver, DnsResolver dnsResolver, long j, TimeUnit timeUnit) {
        this.log = LogFactory.getLog(getClass());
        this.configData = new ConfigData();
        this.pool = new CPool(new InternalConnectionFactory(this.configData, httpConnectionFactory), 2, 20, j, timeUnit);
        this.connectionOperator = new HttpClientConnectionOperator(registry, schemePortResolver, dnsResolver);
        this.isShutDown = new AtomicBoolean(false);
    }

    PoolingHttpClientConnectionManager(CPool cPool, Lookup<ConnectionSocketFactory> lookup, SchemePortResolver schemePortResolver, DnsResolver dnsResolver) {
        this.log = LogFactory.getLog(getClass());
        this.configData = new ConfigData();
        this.pool = cPool;
        this.connectionOperator = new HttpClientConnectionOperator(lookup, schemePortResolver, dnsResolver);
        this.isShutDown = new AtomicBoolean(false);
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

    private String format(HttpRoute httpRoute, Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[route: ").append(httpRoute).append("]");
        if (obj != null) {
            stringBuilder.append("[state: ").append(obj).append("]");
        }
        return stringBuilder.toString();
    }

    private String formatStats(HttpRoute httpRoute) {
        StringBuilder stringBuilder = new StringBuilder();
        PoolStats totalStats = this.pool.getTotalStats();
        PoolStats stats = this.pool.getStats(httpRoute);
        stringBuilder.append("[total kept alive: ").append(totalStats.getAvailable()).append("; ");
        stringBuilder.append("route allocated: ").append(stats.getLeased() + stats.getAvailable());
        stringBuilder.append(" of ").append(stats.getMax()).append("; ");
        stringBuilder.append("total allocated: ").append(totalStats.getLeased() + totalStats.getAvailable());
        stringBuilder.append(" of ").append(totalStats.getMax()).append("]");
        return stringBuilder.toString();
    }

    private String format(CPoolEntry cPoolEntry) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[id: ").append(cPoolEntry.getId()).append("]");
        stringBuilder.append("[route: ").append(cPoolEntry.getRoute()).append("]");
        Object state = cPoolEntry.getState();
        if (state != null) {
            stringBuilder.append("[state: ").append(state).append("]");
        }
        return stringBuilder.toString();
    }

    public ConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        Args.notNull(httpRoute, "HTTP route");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Connection request: " + format(httpRoute, obj) + formatStats(httpRoute));
        }
        final Future lease = this.pool.lease(httpRoute, obj, null);
        return new ConnectionRequest() {
            public boolean cancel() {
                return lease.cancel(true);
            }

            public HttpClientConnection get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
                return PoolingHttpClientConnectionManager.this.leaseConnection(lease, j, timeUnit);
            }
        };
    }

    protected HttpClientConnection leaseConnection(Future<CPoolEntry> future, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
        try {
            CPoolEntry cPoolEntry = (CPoolEntry) future.get(j, timeUnit);
            if (cPoolEntry == null || future.isCancelled()) {
                throw new InterruptedException();
            }
            Asserts.check(cPoolEntry.getConnection() != null, "Pool entry with no connection");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection leased: " + format(cPoolEntry) + formatStats((HttpRoute) cPoolEntry.getRoute()));
            }
            return CPoolProxy.newProxy(cPoolEntry);
        } catch (TimeoutException e) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releaseConnection(org.apache.http.HttpClientConnection r16, java.lang.Object r17, long r18, java.util.concurrent.TimeUnit r20) {
        /*
        r15 = this;
        r6 = 1;
        r7 = 0;
        r4 = "Managed connection";
        r0 = r16;
        org.apache.http.util.Args.notNull(r0, r4);
        monitor-enter(r16);
        r8 = org.apache.http.impl.conn.CPoolProxy.detach(r16);	 Catch:{ all -> 0x00c8 }
        if (r8 != 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r16);	 Catch:{ all -> 0x00c8 }
    L_0x0011:
        return;
    L_0x0012:
        r4 = r8.getConnection();	 Catch:{ all -> 0x00c8 }
        r4 = (org.apache.http.conn.ManagedHttpClientConnection) r4;	 Catch:{ all -> 0x00c8 }
        r5 = r4.isOpen();	 Catch:{ all -> 0x00d4 }
        if (r5 == 0) goto L_0x0082;
    L_0x001e:
        r0 = r17;
        r8.setState(r0);	 Catch:{ all -> 0x00d4 }
        if (r20 == 0) goto L_0x00cb;
    L_0x0025:
        r0 = r18;
        r2 = r20;
        r8.updateExpiry(r0, r2);	 Catch:{ all -> 0x00d4 }
        r5 = r15.log;	 Catch:{ all -> 0x00d4 }
        r5 = r5.isDebugEnabled();	 Catch:{ all -> 0x00d4 }
        if (r5 == 0) goto L_0x0082;
    L_0x0034:
        r10 = 0;
        r5 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x00cf;
    L_0x003a:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d4 }
        r5.<init>();	 Catch:{ all -> 0x00d4 }
        r9 = "for ";
        r5 = r5.append(r9);	 Catch:{ all -> 0x00d4 }
        r0 = r18;
        r10 = (double) r0;	 Catch:{ all -> 0x00d4 }
        r12 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r10 = r10 / r12;
        r5 = r5.append(r10);	 Catch:{ all -> 0x00d4 }
        r9 = " seconds";
        r5 = r5.append(r9);	 Catch:{ all -> 0x00d4 }
        r5 = r5.toString();	 Catch:{ all -> 0x00d4 }
    L_0x005c:
        r9 = r15.log;	 Catch:{ all -> 0x00d4 }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d4 }
        r10.<init>();	 Catch:{ all -> 0x00d4 }
        r11 = "Connection ";
        r10 = r10.append(r11);	 Catch:{ all -> 0x00d4 }
        r11 = r15.format(r8);	 Catch:{ all -> 0x00d4 }
        r10 = r10.append(r11);	 Catch:{ all -> 0x00d4 }
        r11 = " can be kept alive ";
        r10 = r10.append(r11);	 Catch:{ all -> 0x00d4 }
        r5 = r10.append(r5);	 Catch:{ all -> 0x00d4 }
        r5 = r5.toString();	 Catch:{ all -> 0x00d4 }
        r9.debug(r5);	 Catch:{ all -> 0x00d4 }
    L_0x0082:
        r5 = r15.pool;	 Catch:{ all -> 0x00c8 }
        r4 = r4.isOpen();	 Catch:{ all -> 0x00c8 }
        if (r4 == 0) goto L_0x00d2;
    L_0x008a:
        r4 = r8.isRouteComplete();	 Catch:{ all -> 0x00c8 }
        if (r4 == 0) goto L_0x00d2;
    L_0x0090:
        r5.release(r8, r6);	 Catch:{ all -> 0x00c8 }
        r4 = r15.log;	 Catch:{ all -> 0x00c8 }
        r4 = r4.isDebugEnabled();	 Catch:{ all -> 0x00c8 }
        if (r4 == 0) goto L_0x00c5;
    L_0x009b:
        r5 = r15.log;	 Catch:{ all -> 0x00c8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r4.<init>();	 Catch:{ all -> 0x00c8 }
        r6 = "Connection released: ";
        r4 = r4.append(r6);	 Catch:{ all -> 0x00c8 }
        r6 = r15.format(r8);	 Catch:{ all -> 0x00c8 }
        r6 = r4.append(r6);	 Catch:{ all -> 0x00c8 }
        r4 = r8.getRoute();	 Catch:{ all -> 0x00c8 }
        r4 = (org.apache.http.conn.routing.HttpRoute) r4;	 Catch:{ all -> 0x00c8 }
        r4 = r15.formatStats(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r6.append(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c8 }
        r5.debug(r4);	 Catch:{ all -> 0x00c8 }
    L_0x00c5:
        monitor-exit(r16);	 Catch:{ all -> 0x00c8 }
        goto L_0x0011;
    L_0x00c8:
        r4 = move-exception;
        monitor-exit(r16);	 Catch:{ all -> 0x00c8 }
        throw r4;
    L_0x00cb:
        r20 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00d4 }
        goto L_0x0025;
    L_0x00cf:
        r5 = "indefinitely";
        goto L_0x005c;
    L_0x00d2:
        r6 = r7;
        goto L_0x0090;
    L_0x00d4:
        r5 = move-exception;
        r9 = r15.pool;	 Catch:{ all -> 0x00c8 }
        r4 = r4.isOpen();	 Catch:{ all -> 0x00c8 }
        if (r4 == 0) goto L_0x011a;
    L_0x00dd:
        r4 = r8.isRouteComplete();	 Catch:{ all -> 0x00c8 }
        if (r4 == 0) goto L_0x011a;
    L_0x00e3:
        r4 = r6;
    L_0x00e4:
        r9.release(r8, r4);	 Catch:{ all -> 0x00c8 }
        r4 = r15.log;	 Catch:{ all -> 0x00c8 }
        r4 = r4.isDebugEnabled();	 Catch:{ all -> 0x00c8 }
        if (r4 == 0) goto L_0x0119;
    L_0x00ef:
        r6 = r15.log;	 Catch:{ all -> 0x00c8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r4.<init>();	 Catch:{ all -> 0x00c8 }
        r7 = "Connection released: ";
        r4 = r4.append(r7);	 Catch:{ all -> 0x00c8 }
        r7 = r15.format(r8);	 Catch:{ all -> 0x00c8 }
        r7 = r4.append(r7);	 Catch:{ all -> 0x00c8 }
        r4 = r8.getRoute();	 Catch:{ all -> 0x00c8 }
        r4 = (org.apache.http.conn.routing.HttpRoute) r4;	 Catch:{ all -> 0x00c8 }
        r4 = r15.formatStats(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r7.append(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c8 }
        r6.debug(r4);	 Catch:{ all -> 0x00c8 }
    L_0x0119:
        throw r5;	 Catch:{ all -> 0x00c8 }
    L_0x011a:
        r4 = r7;
        goto L_0x00e4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.PoolingHttpClientConnectionManager.releaseConnection(org.apache.http.HttpClientConnection, java.lang.Object, long, java.util.concurrent.TimeUnit):void");
    }

    public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext) throws IOException {
        ManagedHttpClientConnection managedHttpClientConnection;
        HttpHost proxyHost;
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            managedHttpClientConnection = (ManagedHttpClientConnection) CPoolProxy.getPoolEntry(httpClientConnection).getConnection();
        }
        if (httpRoute.getProxyHost() != null) {
            proxyHost = httpRoute.getProxyHost();
        } else {
            proxyHost = httpRoute.getTargetHost();
        }
        InetSocketAddress localSocketAddress = httpRoute.getLocalSocketAddress();
        SocketConfig socketConfig = this.configData.getSocketConfig(proxyHost);
        if (socketConfig == null) {
            socketConfig = this.configData.getDefaultSocketConfig();
        }
        if (socketConfig == null) {
            socketConfig = SocketConfig.DEFAULT;
        }
        this.connectionOperator.connect(managedHttpClientConnection, proxyHost, localSocketAddress, i, socketConfig, httpContext);
    }

    public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        ManagedHttpClientConnection managedHttpClientConnection;
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            managedHttpClientConnection = (ManagedHttpClientConnection) CPoolProxy.getPoolEntry(httpClientConnection).getConnection();
        }
        this.connectionOperator.upgrade(managedHttpClientConnection, httpRoute.getTargetHost(), httpContext);
    }

    public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {
        Args.notNull(httpClientConnection, "Managed Connection");
        Args.notNull(httpRoute, "HTTP route");
        synchronized (httpClientConnection) {
            CPoolProxy.getPoolEntry(httpClientConnection).markRouteComplete();
        }
    }

    public void shutdown() {
        if (this.isShutDown.compareAndSet(false, true)) {
            this.log.debug("Connection manager is shutting down");
            try {
                this.pool.shutdown();
            } catch (Throwable e) {
                this.log.debug("I/O exception shutting down connection manager", e);
            }
            this.log.debug("Connection manager shut down");
        }
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + j + " " + timeUnit);
        }
        this.pool.closeIdle(j, timeUnit);
    }

    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpired();
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    public void setMaxTotal(int i) {
        this.pool.setMaxTotal(i);
    }

    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    public void setDefaultMaxPerRoute(int i) {
        this.pool.setDefaultMaxPerRoute(i);
    }

    public int getMaxPerRoute(HttpRoute httpRoute) {
        return this.pool.getMaxPerRoute(httpRoute);
    }

    public void setMaxPerRoute(HttpRoute httpRoute, int i) {
        this.pool.setMaxPerRoute(httpRoute, i);
    }

    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    public PoolStats getStats(HttpRoute httpRoute) {
        return this.pool.getStats(httpRoute);
    }

    public SocketConfig getDefaultSocketConfig() {
        return this.configData.getDefaultSocketConfig();
    }

    public void setDefaultSocketConfig(SocketConfig socketConfig) {
        this.configData.setDefaultSocketConfig(socketConfig);
    }

    public ConnectionConfig getDefaultConnectionConfig() {
        return this.configData.getDefaultConnectionConfig();
    }

    public void setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
        this.configData.setDefaultConnectionConfig(connectionConfig);
    }

    public SocketConfig getSocketConfig(HttpHost httpHost) {
        return this.configData.getSocketConfig(httpHost);
    }

    public void setSocketConfig(HttpHost httpHost, SocketConfig socketConfig) {
        this.configData.setSocketConfig(httpHost, socketConfig);
    }

    public ConnectionConfig getConnectionConfig(HttpHost httpHost) {
        return this.configData.getConnectionConfig(httpHost);
    }

    public void setConnectionConfig(HttpHost httpHost, ConnectionConfig connectionConfig) {
        this.configData.setConnectionConfig(httpHost, connectionConfig);
    }
}
