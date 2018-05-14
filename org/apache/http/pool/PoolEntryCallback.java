package org.apache.http.pool;

/* compiled from: TbsSdkJava */
public interface PoolEntryCallback<T, C> {
    void process(PoolEntry<T, C> poolEntry);
}
