package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@ThreadSafe
/* compiled from: TbsSdkJava */
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final LinkedList<E> available = new LinkedList();
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set<E> leased = new HashSet();
    private final Lock lock = new ReentrantLock();
    private final Map<T, Integer> maxPerRoute = new HashMap();
    private volatile int maxTotal;
    private final LinkedList<PoolEntryFuture<E>> pending = new LinkedList();
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool = new HashMap();

    protected abstract E createEntry(T t, C c);

    public AbstractConnPool(ConnFactory<T, C> connFactory, int i, int i2) {
        this.connFactory = (ConnFactory) Args.notNull(connFactory, "Connection factory");
        this.defaultMaxPerRoute = Args.notNegative(i, "Max per route value");
        this.maxTotal = Args.notNegative(i2, "Max total value");
    }

    protected void onLease(E e) {
    }

    protected void onRelease(E e) {
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    public void shutdown() throws IOException {
        if (!this.isShutDown) {
            this.isShutDown = true;
            this.lock.lock();
            try {
                Iterator it = this.available.iterator();
                while (it.hasNext()) {
                    ((PoolEntry) it.next()).close();
                }
                for (PoolEntry close : this.leased) {
                    close.close();
                }
                for (RouteSpecificPool shutdown : this.routeToPool.values()) {
                    shutdown.shutdown();
                }
                this.routeToPool.clear();
                this.leased.clear();
                this.available.clear();
            } finally {
                this.lock.unlock();
            }
        }
    }

    private RouteSpecificPool<T, C, E> getPool(final T t) {
        RouteSpecificPool<T, C, E> routeSpecificPool = (RouteSpecificPool) this.routeToPool.get(t);
        if (routeSpecificPool != null) {
            return routeSpecificPool;
        }
        RouteSpecificPool anonymousClass1 = new RouteSpecificPool<T, C, E>(t) {
            protected E createEntry(C c) {
                return AbstractConnPool.this.createEntry(t, c);
            }
        };
        this.routeToPool.put(t, anonymousClass1);
        return anonymousClass1;
    }

    public Future<E> lease(T t, Object obj, FutureCallback<E> futureCallback) {
        Args.notNull(t, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        final T t2 = t;
        final Object obj2 = obj;
        return new PoolEntryFuture<E>(this.lock, futureCallback) {
            public E getPoolEntry(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, IOException {
                E access$000 = AbstractConnPool.this.getPoolEntryBlocking(t2, obj2, j, timeUnit, this);
                AbstractConnPool.this.onLease(access$000);
                return access$000;
            }
        };
    }

    public Future<E> lease(T t, Object obj) {
        return lease(t, obj, null);
    }

    private E getPoolEntryBlocking(T t, Object obj, long j, TimeUnit timeUnit, PoolEntryFuture<E> poolEntryFuture) throws IOException, InterruptedException, TimeoutException {
        Date date = null;
        if (j > 0) {
            date = new Date(System.currentTimeMillis() + timeUnit.toMillis(j));
        }
        this.lock.lock();
        RouteSpecificPool pool = getPool(t);
        PoolEntry poolEntry = null;
        while (poolEntry == null) {
            Asserts.check(!this.isShutDown, "Connection pool shut down");
            while (true) {
                E free = pool.getFree(obj);
                if (free != null) {
                    if (!free.isClosed() && !free.isExpired(System.currentTimeMillis())) {
                        break;
                    }
                    free.close();
                    this.available.remove(free);
                    pool.free(free, false);
                } else {
                    break;
                }
            }
            if (free != null) {
                this.available.remove(free);
                this.leased.add(free);
                this.lock.unlock();
                return free;
            }
            int i;
            int max = getMax(t);
            int max2 = Math.max(0, (pool.getAllocatedCount() + 1) - max);
            if (max2 > 0) {
                for (i = 0; i < max2; i++) {
                    PoolEntry lastUsed = pool.getLastUsed();
                    if (lastUsed == null) {
                        break;
                    }
                    lastUsed.close();
                    this.available.remove(lastUsed);
                    pool.remove(lastUsed);
                }
            }
            if (pool.getAllocatedCount() < max) {
                i = Math.max(this.maxTotal - this.leased.size(), 0);
                if (i > 0) {
                    if (this.available.size() > i - 1 && !this.available.isEmpty()) {
                        PoolEntry poolEntry2 = (PoolEntry) this.available.removeLast();
                        poolEntry2.close();
                        getPool(poolEntry2.getRoute()).remove(poolEntry2);
                    }
                    E add = pool.add(this.connFactory.create(t));
                    this.leased.add(add);
                    this.lock.unlock();
                    return add;
                }
            }
            try {
                pool.queue(poolEntryFuture);
                this.pending.add(poolEntryFuture);
                boolean await = poolEntryFuture.await(date);
                pool.unqueue(poolEntryFuture);
                this.pending.remove(poolEntryFuture);
                if (!await && date != null && date.getTime() <= System.currentTimeMillis()) {
                    break;
                }
            } catch (Throwable th) {
                this.lock.unlock();
            }
        }
        throw new TimeoutException("Timeout waiting for connection");
    }

    public void release(E e, boolean z) {
        this.lock.lock();
        try {
            if (this.leased.remove(e)) {
                RouteSpecificPool pool = getPool(e.getRoute());
                pool.free(e, z);
                if (!z || this.isShutDown) {
                    e.close();
                } else {
                    this.available.addFirst(e);
                    onRelease(e);
                }
                PoolEntryFuture nextPending = pool.nextPending();
                if (nextPending != null) {
                    this.pending.remove(nextPending);
                } else {
                    nextPending = (PoolEntryFuture) this.pending.poll();
                }
                if (nextPending != null) {
                    nextPending.wakeup();
                }
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    private int getMax(T t) {
        Integer num = (Integer) this.maxPerRoute.get(t);
        if (num != null) {
            return num.intValue();
        }
        return this.defaultMaxPerRoute;
    }

    public void setMaxTotal(int i) {
        Args.notNegative(i, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = i;
        } finally {
            this.lock.unlock();
        }
    }

    public int getMaxTotal() {
        this.lock.lock();
        try {
            int i = this.maxTotal;
            return i;
        } finally {
            this.lock.unlock();
        }
    }

    public void setDefaultMaxPerRoute(int i) {
        Args.notNegative(i, "Max per route value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i;
        } finally {
            this.lock.unlock();
        }
    }

    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            int i = this.defaultMaxPerRoute;
            return i;
        } finally {
            this.lock.unlock();
        }
    }

    public void setMaxPerRoute(T t, int i) {
        Args.notNull(t, "Route");
        Args.notNegative(i, "Max per route value");
        this.lock.lock();
        try {
            this.maxPerRoute.put(t, Integer.valueOf(i));
        } finally {
            this.lock.unlock();
        }
    }

    public int getMaxPerRoute(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            int max = getMax(t);
            return max;
        } finally {
            this.lock.unlock();
        }
    }

    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            PoolStats poolStats = new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
            return poolStats;
        } finally {
            this.lock.unlock();
        }
    }

    public PoolStats getStats(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        PoolStats poolStats;
        try {
            RouteSpecificPool pool = getPool(t);
            poolStats = new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(t));
            return poolStats;
        } finally {
            poolStats = this.lock;
            poolStats.unlock();
        }
    }

    protected void enumAvailable(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator it = this.available.iterator();
            while (it.hasNext()) {
                PoolEntry poolEntry = (PoolEntry) it.next();
                poolEntryCallback.process(poolEntry);
                if (poolEntry.isClosed()) {
                    getPool(poolEntry.getRoute()).remove(poolEntry);
                    it.remove();
                }
            }
            purgePoolMap();
        } finally {
            this.lock.unlock();
        }
    }

    protected void enumLeased(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            for (PoolEntry process : this.leased) {
                poolEntryCallback.process(process);
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void purgePoolMap() {
        Iterator it = this.routeToPool.entrySet().iterator();
        while (it.hasNext()) {
            RouteSpecificPool routeSpecificPool = (RouteSpecificPool) ((Entry) it.next()).getValue();
            if (routeSpecificPool.getAllocatedCount() + routeSpecificPool.getPendingCount() == 0) {
                it.remove();
            }
        }
    }

    public void closeIdle(long j, TimeUnit timeUnit) {
        long j2 = 0;
        Args.notNull(timeUnit, "Time unit");
        long toMillis = timeUnit.toMillis(j);
        if (toMillis >= 0) {
            j2 = toMillis;
        }
        j2 = System.currentTimeMillis() - j2;
        enumAvailable(new PoolEntryCallback<T, C>() {
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.getUpdated() <= j2) {
                    poolEntry.close();
                }
            }
        });
    }

    public void closeExpired() {
        final long currentTimeMillis = System.currentTimeMillis();
        enumAvailable(new PoolEntryCallback<T, C>() {
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.isExpired(currentTimeMillis)) {
                    poolEntry.close();
                }
            }
        });
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[leased: ");
        stringBuilder.append(this.leased);
        stringBuilder.append("][available: ");
        stringBuilder.append(this.available);
        stringBuilder.append("][pending: ");
        stringBuilder.append(this.pending);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
