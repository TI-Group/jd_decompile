package org.apache.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@NotThreadSafe
/* compiled from: TbsSdkJava */
abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>> {
    private final LinkedList<E> available = new LinkedList();
    private final Set<E> leased = new HashSet();
    private final LinkedList<PoolEntryFuture<E>> pending = new LinkedList();
    private final T route;

    protected abstract E createEntry(C c);

    RouteSpecificPool(T t) {
        this.route = t;
    }

    public final T getRoute() {
        return this.route;
    }

    public int getLeasedCount() {
        return this.leased.size();
    }

    public int getPendingCount() {
        return this.pending.size();
    }

    public int getAvailableCount() {
        return this.available.size();
    }

    public int getAllocatedCount() {
        return this.available.size() + this.leased.size();
    }

    public E getFree(Object obj) {
        if (!this.available.isEmpty()) {
            Iterator it;
            PoolEntry poolEntry;
            if (obj != null) {
                it = this.available.iterator();
                while (it.hasNext()) {
                    poolEntry = (PoolEntry) it.next();
                    if (obj.equals(poolEntry.getState())) {
                        it.remove();
                        this.leased.add(poolEntry);
                        return poolEntry;
                    }
                }
            }
            it = this.available.iterator();
            while (it.hasNext()) {
                poolEntry = (PoolEntry) it.next();
                if (poolEntry.getState() == null) {
                    it.remove();
                    this.leased.add(poolEntry);
                    return poolEntry;
                }
            }
        }
        return null;
    }

    public E getLastUsed() {
        if (this.available.isEmpty()) {
            return null;
        }
        return (PoolEntry) this.available.getLast();
    }

    public boolean remove(E e) {
        Args.notNull(e, "Pool entry");
        if (this.available.remove(e) || this.leased.remove(e)) {
            return true;
        }
        return false;
    }

    public void free(E e, boolean z) {
        Args.notNull(e, "Pool entry");
        Asserts.check(this.leased.remove(e), "Entry %s has not been leased from this pool", e);
        if (z) {
            this.available.addFirst(e);
        }
    }

    public E add(C c) {
        E createEntry = createEntry(c);
        this.leased.add(createEntry);
        return createEntry;
    }

    public void queue(PoolEntryFuture<E> poolEntryFuture) {
        if (poolEntryFuture != null) {
            this.pending.add(poolEntryFuture);
        }
    }

    public PoolEntryFuture<E> nextPending() {
        return (PoolEntryFuture) this.pending.poll();
    }

    public void unqueue(PoolEntryFuture<E> poolEntryFuture) {
        if (poolEntryFuture != null) {
            this.pending.remove(poolEntryFuture);
        }
    }

    public void shutdown() {
        Iterator it = this.pending.iterator();
        while (it.hasNext()) {
            ((PoolEntryFuture) it.next()).cancel(true);
        }
        this.pending.clear();
        it = this.available.iterator();
        while (it.hasNext()) {
            ((PoolEntry) it.next()).close();
        }
        this.available.clear();
        for (PoolEntry close : this.leased) {
            close.close();
        }
        this.leased.clear();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[route: ");
        stringBuilder.append(this.route);
        stringBuilder.append("][leased: ");
        stringBuilder.append(this.leased.size());
        stringBuilder.append("][available: ");
        stringBuilder.append(this.available.size());
        stringBuilder.append("][pending: ");
        stringBuilder.append(this.pending.size());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
