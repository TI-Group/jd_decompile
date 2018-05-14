package org.apache.http.impl.conn.tsccm;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;

@Deprecated
/* compiled from: TbsSdkJava */
public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {
    protected BasicPooledConnAdapter(ThreadSafeClientConnManager threadSafeClientConnManager, AbstractPoolEntry abstractPoolEntry) {
        super(threadSafeClientConnManager, abstractPoolEntry);
        markReusable();
    }

    protected ClientConnectionManager getManager() {
        return super.getManager();
    }

    protected AbstractPoolEntry getPoolEntry() {
        return super.getPoolEntry();
    }

    protected void detach() {
        super.detach();
    }
}
