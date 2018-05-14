package org.apache.http.impl.conn.tsccm;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Deprecated
/* compiled from: TbsSdkJava */
public class ConnPoolByRoute extends AbstractConnPool {
    protected final ConnPerRoute connPerRoute;
    private final long connTTL;
    private final TimeUnit connTTLTimeUnit;
    protected final Queue<BasicPoolEntry> freeConnections;
    protected final Set<BasicPoolEntry> leasedConnections;
    private final Log log;
    protected volatile int maxTotalConnections;
    protected volatile int numConnections;
    protected final ClientConnectionOperator operator;
    private final Lock poolLock;
    protected final Map<HttpRoute, RouteSpecificPool> routeToPool;
    protected volatile boolean shutdown;
    protected final Queue<WaitingThread> waitingThreads;

    public ConnPoolByRoute(ClientConnectionOperator clientConnectionOperator, ConnPerRoute connPerRoute, int i) {
        this(clientConnectionOperator, connPerRoute, i, -1, TimeUnit.MILLISECONDS);
    }

    public ConnPoolByRoute(ClientConnectionOperator clientConnectionOperator, ConnPerRoute connPerRoute, int i, long j, TimeUnit timeUnit) {
        this.log = LogFactory.getLog(getClass());
        Args.notNull(clientConnectionOperator, "Connection operator");
        Args.notNull(connPerRoute, "Connections per route");
        this.poolLock = this.poolLock;
        this.leasedConnections = this.leasedConnections;
        this.operator = clientConnectionOperator;
        this.connPerRoute = connPerRoute;
        this.maxTotalConnections = i;
        this.freeConnections = createFreeConnQueue();
        this.waitingThreads = createWaitingThreadQueue();
        this.routeToPool = createRouteToPoolMap();
        this.connTTL = j;
        this.connTTLTimeUnit = timeUnit;
    }

    protected Lock getLock() {
        return this.poolLock;
    }

    @Deprecated
    public ConnPoolByRoute(ClientConnectionOperator clientConnectionOperator, HttpParams httpParams) {
        this(clientConnectionOperator, ConnManagerParams.getMaxConnectionsPerRoute(httpParams), ConnManagerParams.getMaxTotalConnections(httpParams));
    }

    protected Queue<BasicPoolEntry> createFreeConnQueue() {
        return new LinkedList();
    }

    protected Queue<WaitingThread> createWaitingThreadQueue() {
        return new LinkedList();
    }

    protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
        return new HashMap();
    }

    protected RouteSpecificPool newRouteSpecificPool(HttpRoute httpRoute) {
        return new RouteSpecificPool(httpRoute, this.connPerRoute);
    }

    protected WaitingThread newWaitingThread(Condition condition, RouteSpecificPool routeSpecificPool) {
        return new WaitingThread(condition, routeSpecificPool);
    }

    private void closeConnection(BasicPoolEntry basicPoolEntry) {
        OperatedClientConnection connection = basicPoolEntry.getConnection();
        if (connection != null) {
            try {
                connection.close();
            } catch (Throwable e) {
                this.log.debug("I/O error closing connection", e);
            }
        }
    }

    protected RouteSpecificPool getRoutePool(HttpRoute httpRoute, boolean z) {
        this.poolLock.lock();
        try {
            RouteSpecificPool routeSpecificPool = (RouteSpecificPool) this.routeToPool.get(httpRoute);
            if (routeSpecificPool == null && z) {
                routeSpecificPool = newRouteSpecificPool(httpRoute);
                this.routeToPool.put(httpRoute, routeSpecificPool);
            }
            this.poolLock.unlock();
            return routeSpecificPool;
        } catch (Throwable th) {
            this.poolLock.unlock();
        }
    }

    public int getConnectionsInPool(HttpRoute httpRoute) {
        int i = 0;
        this.poolLock.lock();
        try {
            RouteSpecificPool routePool = getRoutePool(httpRoute, false);
            if (routePool != null) {
                i = routePool.getEntryCount();
            }
            this.poolLock.unlock();
            return i;
        } catch (Throwable th) {
            this.poolLock.unlock();
        }
    }

    public int getConnectionsInPool() {
        this.poolLock.lock();
        try {
            int i = this.numConnections;
            return i;
        } finally {
            this.poolLock.unlock();
        }
    }

    public PoolEntryRequest requestPoolEntry(final HttpRoute httpRoute, final Object obj) {
        final WaitingThreadAborter waitingThreadAborter = new WaitingThreadAborter();
        return new PoolEntryRequest() {
            public void abortRequest() {
                ConnPoolByRoute.this.poolLock.lock();
                try {
                    waitingThreadAborter.abort();
                } finally {
                    ConnPoolByRoute.this.poolLock.unlock();
                }
            }

            public BasicPoolEntry getPoolEntry(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
                return ConnPoolByRoute.this.getEntryBlocking(httpRoute, obj, j, timeUnit, waitingThreadAborter);
            }
        };
    }

    protected BasicPoolEntry getEntryBlocking(HttpRoute httpRoute, Object obj, long j, TimeUnit timeUnit, WaitingThreadAborter waitingThreadAborter) throws ConnectionPoolTimeoutException, InterruptedException {
        Date date = null;
        if (j > 0) {
            date = new Date(System.currentTimeMillis() + timeUnit.toMillis(j));
        }
        BasicPoolEntry basicPoolEntry = null;
        this.poolLock.lock();
        RouteSpecificPool routePool = getRoutePool(httpRoute, true);
        WaitingThread waitingThread = null;
        while (basicPoolEntry == null) {
            Asserts.check(!this.shutdown, "Connection pool shut down");
            if (this.log.isDebugEnabled()) {
                this.log.debug("[" + httpRoute + "] total kept alive: " + this.freeConnections.size() + ", total issued: " + this.leasedConnections.size() + ", total allocated: " + this.numConnections + " out of " + this.maxTotalConnections);
            }
            basicPoolEntry = getFreeEntry(routePool, obj);
            if (basicPoolEntry != null) {
                break;
            }
            try {
                Object obj2 = routePool.getCapacity() > 0 ? 1 : null;
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Available capacity: " + routePool.getCapacity() + " out of " + routePool.getMaxEntries() + " [" + httpRoute + "][" + obj + "]");
                }
                if (obj2 != null && this.numConnections < this.maxTotalConnections) {
                    basicPoolEntry = createEntry(routePool, this.operator);
                } else if (obj2 == null || this.freeConnections.isEmpty()) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Need to wait for connection [" + httpRoute + "][" + obj + "]");
                    }
                    if (waitingThread == null) {
                        waitingThread = newWaitingThread(this.poolLock.newCondition(), routePool);
                        waitingThreadAborter.setWaitingThread(waitingThread);
                    }
                    routePool.queueThread(waitingThread);
                    this.waitingThreads.add(waitingThread);
                    boolean await = waitingThread.await(date);
                    routePool.removeThread(waitingThread);
                    this.waitingThreads.remove(waitingThread);
                    if (!(await || date == null || date.getTime() > System.currentTimeMillis())) {
                        throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
                    }
                } else {
                    deleteLeastUsedEntry();
                    routePool = getRoutePool(httpRoute, true);
                    basicPoolEntry = createEntry(routePool, this.operator);
                }
            } catch (Throwable th) {
                this.poolLock.unlock();
            }
        }
        this.poolLock.unlock();
        return basicPoolEntry;
    }

    public void freeEntry(BasicPoolEntry basicPoolEntry, boolean z, long j, TimeUnit timeUnit) {
        HttpRoute plannedRoute = basicPoolEntry.getPlannedRoute();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Releasing connection [" + plannedRoute + "][" + basicPoolEntry.getState() + "]");
        }
        this.poolLock.lock();
        try {
            if (this.shutdown) {
                closeConnection(basicPoolEntry);
                return;
            }
            this.leasedConnections.remove(basicPoolEntry);
            RouteSpecificPool routePool = getRoutePool(plannedRoute, true);
            if (!z || routePool.getCapacity() < 0) {
                closeConnection(basicPoolEntry);
                routePool.dropEntry();
                this.numConnections--;
            } else {
                if (this.log.isDebugEnabled()) {
                    String str;
                    if (j > 0) {
                        str = "for " + j + " " + timeUnit;
                    } else {
                        str = "indefinitely";
                    }
                    this.log.debug("Pooling connection [" + plannedRoute + "][" + basicPoolEntry.getState() + "]; keep alive " + str);
                }
                routePool.freeEntry(basicPoolEntry);
                basicPoolEntry.updateExpiry(j, timeUnit);
                this.freeConnections.add(basicPoolEntry);
            }
            notifyWaitingThread(routePool);
            this.poolLock.unlock();
        } finally {
            this.poolLock.unlock();
        }
    }

    protected BasicPoolEntry getFreeEntry(RouteSpecificPool routeSpecificPool, Object obj) {
        BasicPoolEntry basicPoolEntry = null;
        this.poolLock.lock();
        Object obj2 = null;
        while (obj2 == null) {
            try {
                basicPoolEntry = routeSpecificPool.allocEntry(obj);
                if (basicPoolEntry != null) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Getting free connection [" + routeSpecificPool.getRoute() + "][" + obj + "]");
                    }
                    this.freeConnections.remove(basicPoolEntry);
                    if (basicPoolEntry.isExpired(System.currentTimeMillis())) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Closing expired free connection [" + routeSpecificPool.getRoute() + "][" + obj + "]");
                        }
                        closeConnection(basicPoolEntry);
                        routeSpecificPool.dropEntry();
                        this.numConnections--;
                    } else {
                        this.leasedConnections.add(basicPoolEntry);
                        obj2 = 1;
                    }
                } else if (this.log.isDebugEnabled()) {
                    this.log.debug("No free connections [" + routeSpecificPool.getRoute() + "][" + obj + "]");
                    obj2 = 1;
                } else {
                    obj2 = 1;
                }
            } catch (Throwable th) {
                this.poolLock.unlock();
            }
        }
        this.poolLock.unlock();
        return basicPoolEntry;
    }

    protected BasicPoolEntry createEntry(RouteSpecificPool routeSpecificPool, ClientConnectionOperator clientConnectionOperator) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Creating new connection [" + routeSpecificPool.getRoute() + "]");
        }
        BasicPoolEntry basicPoolEntry = new BasicPoolEntry(clientConnectionOperator, routeSpecificPool.getRoute(), this.connTTL, this.connTTLTimeUnit);
        this.poolLock.lock();
        try {
            routeSpecificPool.createdEntry(basicPoolEntry);
            this.numConnections++;
            this.leasedConnections.add(basicPoolEntry);
            return basicPoolEntry;
        } finally {
            basicPoolEntry = this.poolLock;
            basicPoolEntry.unlock();
        }
    }

    protected void deleteEntry(BasicPoolEntry basicPoolEntry) {
        HttpRoute plannedRoute = basicPoolEntry.getPlannedRoute();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Deleting connection [" + plannedRoute + "][" + basicPoolEntry.getState() + "]");
        }
        this.poolLock.lock();
        try {
            closeConnection(basicPoolEntry);
            RouteSpecificPool routePool = getRoutePool(plannedRoute, true);
            routePool.deleteEntry(basicPoolEntry);
            this.numConnections--;
            if (routePool.isUnused()) {
                this.routeToPool.remove(plannedRoute);
            }
            this.poolLock.unlock();
        } catch (Throwable th) {
            this.poolLock.unlock();
        }
    }

    protected void deleteLeastUsedEntry() {
        this.poolLock.lock();
        try {
            BasicPoolEntry basicPoolEntry = (BasicPoolEntry) this.freeConnections.remove();
            if (basicPoolEntry != null) {
                deleteEntry(basicPoolEntry);
            } else if (this.log.isDebugEnabled()) {
                this.log.debug("No free connection to delete");
            }
            this.poolLock.unlock();
        } catch (Throwable th) {
            this.poolLock.unlock();
        }
    }

    protected void handleLostEntry(HttpRoute httpRoute) {
        this.poolLock.lock();
        try {
            RouteSpecificPool routePool = getRoutePool(httpRoute, true);
            routePool.dropEntry();
            if (routePool.isUnused()) {
                this.routeToPool.remove(httpRoute);
            }
            this.numConnections--;
            notifyWaitingThread(routePool);
        } finally {
            this.poolLock.unlock();
        }
    }

    protected void notifyWaitingThread(RouteSpecificPool routeSpecificPool) {
        WaitingThread waitingThread = null;
        this.poolLock.lock();
        if (routeSpecificPool != null) {
            try {
                if (routeSpecificPool.hasThread()) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Notifying thread waiting on pool [" + routeSpecificPool.getRoute() + "]");
                    }
                    waitingThread = routeSpecificPool.nextThread();
                    if (waitingThread != null) {
                        waitingThread.wakeup();
                    }
                    this.poolLock.unlock();
                }
            } catch (Throwable th) {
                this.poolLock.unlock();
            }
        }
        if (!this.waitingThreads.isEmpty()) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Notifying thread waiting on any pool");
            }
            waitingThread = (WaitingThread) this.waitingThreads.remove();
        } else if (this.log.isDebugEnabled()) {
            this.log.debug("Notifying no-one, there are no waiting threads");
        }
        if (waitingThread != null) {
            waitingThread.wakeup();
        }
        this.poolLock.unlock();
    }

    public void deleteClosedConnections() {
        this.poolLock.lock();
        try {
            Iterator it = this.freeConnections.iterator();
            while (it.hasNext()) {
                BasicPoolEntry basicPoolEntry = (BasicPoolEntry) it.next();
                if (!basicPoolEntry.getConnection().isOpen()) {
                    it.remove();
                    deleteEntry(basicPoolEntry);
                }
            }
        } finally {
            this.poolLock.unlock();
        }
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        if (j <= 0) {
            j = 0;
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("Closing connections idle longer than " + j + " " + timeUnit);
        }
        long currentTimeMillis = System.currentTimeMillis() - timeUnit.toMillis(j);
        this.poolLock.lock();
        try {
            Iterator it = this.freeConnections.iterator();
            while (it.hasNext()) {
                BasicPoolEntry basicPoolEntry = (BasicPoolEntry) it.next();
                if (basicPoolEntry.getUpdated() <= currentTimeMillis) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Closing connection last used @ " + new Date(basicPoolEntry.getUpdated()));
                    }
                    it.remove();
                    deleteEntry(basicPoolEntry);
                }
            }
        } finally {
            this.poolLock.unlock();
        }
    }

    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        long currentTimeMillis = System.currentTimeMillis();
        this.poolLock.lock();
        try {
            Iterator it = this.freeConnections.iterator();
            while (it.hasNext()) {
                BasicPoolEntry basicPoolEntry = (BasicPoolEntry) it.next();
                if (basicPoolEntry.isExpired(currentTimeMillis)) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Closing connection expired @ " + new Date(basicPoolEntry.getExpiry()));
                    }
                    it.remove();
                    deleteEntry(basicPoolEntry);
                }
            }
        } finally {
            this.poolLock.unlock();
        }
    }

    public void shutdown() {
        this.poolLock.lock();
        try {
            if (!this.shutdown) {
                BasicPoolEntry basicPoolEntry;
                this.shutdown = true;
                Iterator it = this.leasedConnections.iterator();
                while (it.hasNext()) {
                    basicPoolEntry = (BasicPoolEntry) it.next();
                    it.remove();
                    closeConnection(basicPoolEntry);
                }
                it = this.freeConnections.iterator();
                while (it.hasNext()) {
                    basicPoolEntry = (BasicPoolEntry) it.next();
                    it.remove();
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Closing connection [" + basicPoolEntry.getPlannedRoute() + "][" + basicPoolEntry.getState() + "]");
                    }
                    closeConnection(basicPoolEntry);
                }
                it = this.waitingThreads.iterator();
                while (it.hasNext()) {
                    WaitingThread waitingThread = (WaitingThread) it.next();
                    it.remove();
                    waitingThread.wakeup();
                }
                this.routeToPool.clear();
                this.poolLock.unlock();
            }
        } finally {
            this.poolLock.unlock();
        }
    }

    public void setMaxTotalConnections(int i) {
        this.poolLock.lock();
        try {
            this.maxTotalConnections = i;
        } finally {
            this.poolLock.unlock();
        }
    }

    public int getMaxTotalConnections() {
        return this.maxTotalConnections;
    }
}
