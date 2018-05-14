package org.apache.http.impl.execchain;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.http.HttpClientConnection;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.Cancellable;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.conn.HttpClientConnectionManager;

@ThreadSafe
/* compiled from: TbsSdkJava */
class ConnectionHolder implements Closeable, Cancellable, ConnectionReleaseTrigger {
    private final Log log;
    private final HttpClientConnection managedConn;
    private final HttpClientConnectionManager manager;
    private volatile boolean released;
    private volatile boolean reusable;
    private volatile Object state;
    private volatile TimeUnit tunit;
    private volatile long validDuration;

    public ConnectionHolder(Log log, HttpClientConnectionManager httpClientConnectionManager, HttpClientConnection httpClientConnection) {
        this.log = log;
        this.manager = httpClientConnectionManager;
        this.managedConn = httpClientConnection;
    }

    public boolean isReusable() {
        return this.reusable;
    }

    public void markReusable() {
        this.reusable = true;
    }

    public void markNonReusable() {
        this.reusable = false;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public void setValidFor(long j, TimeUnit timeUnit) {
        synchronized (this.managedConn) {
            this.validDuration = j;
            this.tunit = timeUnit;
        }
    }

    public void releaseConnection() {
        synchronized (this.managedConn) {
            if (this.released) {
                return;
            }
            this.released = true;
            if (this.reusable) {
                this.manager.releaseConnection(this.managedConn, this.state, this.validDuration, this.tunit);
            } else {
                try {
                    this.managedConn.close();
                    this.log.debug("Connection discarded");
                } catch (Throwable e) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug(e.getMessage(), e);
                    }
                } finally {
                    this.manager.releaseConnection(this.managedConn, null, 0, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public void abortConnection() {
        synchronized (this.managedConn) {
            if (this.released) {
                return;
            }
            this.released = true;
            try {
                this.managedConn.shutdown();
                this.log.debug("Connection discarded");
            } catch (Throwable e) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug(e.getMessage(), e);
                }
            } finally {
                this.manager.releaseConnection(this.managedConn, null, 0, TimeUnit.MILLISECONDS);
            }
        }
    }

    public boolean cancel() {
        boolean z = this.released;
        this.log.debug("Cancelling request execution");
        abortConnection();
        return !z;
    }

    public boolean isReleased() {
        return this.released;
    }

    public void close() throws IOException {
        abortConnection();
    }
}
