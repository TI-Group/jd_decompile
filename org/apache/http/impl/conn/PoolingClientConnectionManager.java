package org.apache.http.impl.conn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolStats;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Deprecated
@ThreadSafe
/* compiled from: TbsSdkJava */
public class PoolingClientConnectionManager implements ClientConnectionManager, ConnPoolControl<HttpRoute> {
    private final DnsResolver dnsResolver;
    private final Log log;
    private final ClientConnectionOperator operator;
    private final HttpConnPool pool;
    private final SchemeRegistry schemeRegistry;

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry) {
        this(schemeRegistry, -1, TimeUnit.MILLISECONDS);
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        this(schemeRegistry, -1, TimeUnit.MILLISECONDS, dnsResolver);
    }

    public PoolingClientConnectionManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit) {
        this(schemeRegistry, j, timeUnit, new SystemDefaultDnsResolver());
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j, TimeUnit timeUnit, DnsResolver dnsResolver) {
        this.log = LogFactory.getLog(getClass());
        Args.notNull(schemeRegistry, "Scheme registry");
        Args.notNull(dnsResolver, "DNS resolver");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = dnsResolver;
        this.operator = createConnectionOperator(schemeRegistry);
        this.pool = new HttpConnPool(this.log, this.operator, 2, 20, j, timeUnit);
    }

    protected void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry, this.dnsResolver);
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
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

    private String format(HttpPoolEntry httpPoolEntry) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[id: ").append(httpPoolEntry.getId()).append("]");
        stringBuilder.append("[route: ").append(httpPoolEntry.getRoute()).append("]");
        Object state = httpPoolEntry.getState();
        if (state != null) {
            stringBuilder.append("[state: ").append(state).append("]");
        }
        return stringBuilder.toString();
    }

    public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        Args.notNull(httpRoute, "HTTP route");
        if (this.log.isDebugEnabled()) {
            this.log.debug("Connection request: " + format(httpRoute, obj) + formatStats(httpRoute));
        }
        final Future lease = this.pool.lease(httpRoute, obj);
        return new ClientConnectionRequest() {
            public void abortRequest() {
                lease.cancel(true);
            }

            public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
                return PoolingClientConnectionManager.this.leaseConnection(lease, j, timeUnit);
            }
        };
    }

    ManagedClientConnection leaseConnection(Future<HttpPoolEntry> future, long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
        try {
            HttpPoolEntry httpPoolEntry = (HttpPoolEntry) future.get(j, timeUnit);
            if (httpPoolEntry == null || future.isCancelled()) {
                throw new InterruptedException();
            }
            Asserts.check(httpPoolEntry.getConnection() != null, "Pool entry with no connection");
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection leased: " + format(httpPoolEntry) + formatStats((HttpRoute) httpPoolEntry.getRoute()));
            }
            return new ManagedClientConnectionImpl(this, this.operator, httpPoolEntry);
        } catch (ExecutionException e) {
            Throwable e2 = e;
            Throwable cause = e2.getCause();
            if (cause != null) {
                e2 = cause;
            }
            this.log.error("Unexpected exception leasing connection from pool", e2);
            throw new InterruptedException();
        } catch (TimeoutException e3) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releaseConnection(org.apache.http.conn.ManagedClientConnection r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
        r6 = this;
        r0 = r7 instanceof org.apache.http.impl.conn.ManagedClientConnectionImpl;
        r1 = "Connection class mismatch, connection not obtained from this manager";
        org.apache.http.util.Args.check(r0, r1);
        r7 = (org.apache.http.impl.conn.ManagedClientConnectionImpl) r7;
        r0 = r7.getManager();
        if (r0 != r6) goto L_0x001e;
    L_0x000f:
        r0 = 1;
    L_0x0010:
        r1 = "Connection not obtained from this manager";
        org.apache.http.util.Asserts.check(r0, r1);
        monitor-enter(r7);
        r1 = r7.detach();	 Catch:{ all -> 0x00ca }
        if (r1 != 0) goto L_0x0020;
    L_0x001c:
        monitor-exit(r7);	 Catch:{ all -> 0x00ca }
    L_0x001d:
        return;
    L_0x001e:
        r0 = 0;
        goto L_0x0010;
    L_0x0020:
        r0 = r7.isOpen();	 Catch:{ all -> 0x00df }
        if (r0 == 0) goto L_0x002f;
    L_0x0026:
        r0 = r7.isMarkedReusable();	 Catch:{ all -> 0x00df }
        if (r0 != 0) goto L_0x002f;
    L_0x002c:
        r7.shutdown();	 Catch:{ IOException -> 0x00cd }
    L_0x002f:
        r0 = r7.isMarkedReusable();	 Catch:{ all -> 0x00df }
        if (r0 == 0) goto L_0x008c;
    L_0x0035:
        if (r10 == 0) goto L_0x00ea;
    L_0x0037:
        r0 = r10;
    L_0x0038:
        r1.updateExpiry(r8, r0);	 Catch:{ all -> 0x00df }
        r0 = r6.log;	 Catch:{ all -> 0x00df }
        r0 = r0.isDebugEnabled();	 Catch:{ all -> 0x00df }
        if (r0 == 0) goto L_0x008c;
    L_0x0043:
        r2 = 0;
        r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00ee;
    L_0x0049:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00df }
        r0.<init>();	 Catch:{ all -> 0x00df }
        r2 = "for ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x00df }
        r0 = r0.append(r8);	 Catch:{ all -> 0x00df }
        r2 = " ";
        r0 = r0.append(r2);	 Catch:{ all -> 0x00df }
        r0 = r0.append(r10);	 Catch:{ all -> 0x00df }
        r0 = r0.toString();	 Catch:{ all -> 0x00df }
    L_0x0066:
        r2 = r6.log;	 Catch:{ all -> 0x00df }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00df }
        r3.<init>();	 Catch:{ all -> 0x00df }
        r4 = "Connection ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00df }
        r4 = r6.format(r1);	 Catch:{ all -> 0x00df }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00df }
        r4 = " can be kept alive ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00df }
        r0 = r3.append(r0);	 Catch:{ all -> 0x00df }
        r0 = r0.toString();	 Catch:{ all -> 0x00df }
        r2.debug(r0);	 Catch:{ all -> 0x00df }
    L_0x008c:
        r0 = r6.pool;	 Catch:{ all -> 0x00ca }
        r2 = r7.isMarkedReusable();	 Catch:{ all -> 0x00ca }
        r0.release(r1, r2);	 Catch:{ all -> 0x00ca }
        r0 = r6.log;	 Catch:{ all -> 0x00ca }
        r0 = r0.isDebugEnabled();	 Catch:{ all -> 0x00ca }
        if (r0 == 0) goto L_0x00c7;
    L_0x009d:
        r2 = r6.log;	 Catch:{ all -> 0x00ca }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ca }
        r0.<init>();	 Catch:{ all -> 0x00ca }
        r3 = "Connection released: ";
        r0 = r0.append(r3);	 Catch:{ all -> 0x00ca }
        r3 = r6.format(r1);	 Catch:{ all -> 0x00ca }
        r3 = r0.append(r3);	 Catch:{ all -> 0x00ca }
        r0 = r1.getRoute();	 Catch:{ all -> 0x00ca }
        r0 = (org.apache.http.conn.routing.HttpRoute) r0;	 Catch:{ all -> 0x00ca }
        r0 = r6.formatStats(r0);	 Catch:{ all -> 0x00ca }
        r0 = r3.append(r0);	 Catch:{ all -> 0x00ca }
        r0 = r0.toString();	 Catch:{ all -> 0x00ca }
        r2.debug(r0);	 Catch:{ all -> 0x00ca }
    L_0x00c7:
        monitor-exit(r7);	 Catch:{ all -> 0x00ca }
        goto L_0x001d;
    L_0x00ca:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x00ca }
        throw r0;
    L_0x00cd:
        r0 = move-exception;
        r2 = r6.log;	 Catch:{ all -> 0x00df }
        r2 = r2.isDebugEnabled();	 Catch:{ all -> 0x00df }
        if (r2 == 0) goto L_0x002f;
    L_0x00d6:
        r2 = r6.log;	 Catch:{ all -> 0x00df }
        r3 = "I/O exception shutting down released connection";
        r2.debug(r3, r0);	 Catch:{ all -> 0x00df }
        goto L_0x002f;
    L_0x00df:
        r0 = move-exception;
        r2 = r6.pool;	 Catch:{ all -> 0x00ca }
        r3 = r7.isMarkedReusable();	 Catch:{ all -> 0x00ca }
        r2.release(r1, r3);	 Catch:{ all -> 0x00ca }
        throw r0;	 Catch:{ all -> 0x00ca }
    L_0x00ea:
        r0 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00df }
        goto L_0x0038;
    L_0x00ee:
        r0 = "indefinitely";
        goto L_0x0066;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.PoolingClientConnectionManager.releaseConnection(org.apache.http.conn.ManagedClientConnection, long, java.util.concurrent.TimeUnit):void");
    }

    public void shutdown() {
        this.log.debug("Connection manager is shutting down");
        try {
            this.pool.shutdown();
        } catch (Throwable e) {
            this.log.debug("I/O exception shutting down connection manager", e);
        }
        this.log.debug("Connection manager shut down");
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
}
