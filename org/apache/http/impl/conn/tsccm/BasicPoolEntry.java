package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.util.Args;

@Deprecated
/* compiled from: TbsSdkJava */
public class BasicPoolEntry extends AbstractPoolEntry {
    private final long created;
    private long expiry;
    private long updated;
    private final long validUntil;

    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute, ReferenceQueue<Object> referenceQueue) {
        super(clientConnectionOperator, httpRoute);
        Args.notNull(httpRoute, "HTTP route");
        this.created = System.currentTimeMillis();
        this.validUntil = Long.MAX_VALUE;
        this.expiry = this.validUntil;
    }

    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute) {
        this(clientConnectionOperator, httpRoute, -1, TimeUnit.MILLISECONDS);
    }

    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute, long j, TimeUnit timeUnit) {
        super(clientConnectionOperator, httpRoute);
        Args.notNull(httpRoute, "HTTP route");
        this.created = System.currentTimeMillis();
        if (j > 0) {
            this.validUntil = this.created + timeUnit.toMillis(j);
        } else {
            this.validUntil = Long.MAX_VALUE;
        }
        this.expiry = this.validUntil;
    }

    protected final OperatedClientConnection getConnection() {
        return this.connection;
    }

    protected final HttpRoute getPlannedRoute() {
        return this.route;
    }

    protected final BasicPoolEntryRef getWeakRef() {
        return null;
    }

    protected void shutdownEntry() {
        super.shutdownEntry();
    }

    public long getCreated() {
        return this.created;
    }

    public long getUpdated() {
        return this.updated;
    }

    public long getExpiry() {
        return this.expiry;
    }

    public long getValidUntil() {
        return this.validUntil;
    }

    public void updateExpiry(long j, TimeUnit timeUnit) {
        long toMillis;
        this.updated = System.currentTimeMillis();
        if (j > 0) {
            toMillis = this.updated + timeUnit.toMillis(j);
        } else {
            toMillis = Long.MAX_VALUE;
        }
        this.expiry = Math.min(this.validUntil, toMillis);
    }

    public boolean isExpired(long j) {
        return j >= this.expiry;
    }
}
