package org.apache.http.impl.conn.tsccm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.IdleConnectionHandler;
import org.apache.http.util.Args;

@Deprecated
/* compiled from: TbsSdkJava */
public abstract class AbstractConnPool {
    protected IdleConnectionHandler idleConnHandler = new IdleConnectionHandler();
    protected volatile boolean isShutDown;
    protected Set<BasicPoolEntryRef> issuedConnections;
    @GuardedBy("poolLock")
    protected Set<BasicPoolEntry> leasedConnections = new HashSet();
    private final Log log = LogFactory.getLog(getClass());
    @GuardedBy("poolLock")
    protected int numConnections;
    protected final Lock poolLock = new ReentrantLock();
    protected ReferenceQueue<Object> refQueue;

    public abstract void deleteClosedConnections();

    public abstract void freeEntry(BasicPoolEntry basicPoolEntry, boolean z, long j, TimeUnit timeUnit);

    protected abstract void handleLostEntry(HttpRoute httpRoute);

    public abstract PoolEntryRequest requestPoolEntry(HttpRoute httpRoute, Object obj);

    protected AbstractConnPool() {
    }

    public void enableConnectionGC() throws IllegalStateException {
    }

    public final BasicPoolEntry getEntry(HttpRoute httpRoute, Object obj, long j, TimeUnit timeUnit) throws ConnectionPoolTimeoutException, InterruptedException {
        return requestPoolEntry(httpRoute, obj).getPoolEntry(j, timeUnit);
    }

    public void handleReference(Reference<?> reference) {
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        this.poolLock.lock();
        try {
            this.idleConnHandler.closeIdleConnections(timeUnit.toMillis(j));
        } finally {
            this.poolLock.unlock();
        }
    }

    public void closeExpiredConnections() {
        this.poolLock.lock();
        try {
            this.idleConnHandler.closeExpiredConnections();
        } finally {
            this.poolLock.unlock();
        }
    }

    public void shutdown() {
        this.poolLock.lock();
        try {
            if (!this.isShutDown) {
                Iterator it = this.leasedConnections.iterator();
                while (it.hasNext()) {
                    BasicPoolEntry basicPoolEntry = (BasicPoolEntry) it.next();
                    it.remove();
                    closeConnection(basicPoolEntry.getConnection());
                }
                this.idleConnHandler.removeAll();
                this.isShutDown = true;
                this.poolLock.unlock();
            }
        } finally {
            this.poolLock.unlock();
        }
    }

    protected void closeConnection(OperatedClientConnection operatedClientConnection) {
        if (operatedClientConnection != null) {
            try {
                operatedClientConnection.close();
            } catch (Throwable e) {
                this.log.debug("I/O error closing connection", e);
            }
        }
    }
}
