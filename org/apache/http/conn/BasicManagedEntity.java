package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@NotThreadSafe
@Deprecated
/* compiled from: TbsSdkJava */
public class BasicManagedEntity extends HttpEntityWrapper implements ConnectionReleaseTrigger, EofSensorWatcher {
    protected final boolean attemptReuse;
    protected ManagedClientConnection managedConn;

    public BasicManagedEntity(HttpEntity httpEntity, ManagedClientConnection managedClientConnection, boolean z) {
        super(httpEntity);
        Args.notNull(managedClientConnection, "Connection");
        this.managedConn = managedClientConnection;
        this.attemptReuse = z;
    }

    public boolean isRepeatable() {
        return false;
    }

    public InputStream getContent() throws IOException {
        return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
    }

    private void ensureConsumed() throws IOException {
        if (this.managedConn != null) {
            try {
                if (this.attemptReuse) {
                    EntityUtils.consume(this.wrappedEntity);
                    this.managedConn.markReusable();
                } else {
                    this.managedConn.unmarkReusable();
                }
                releaseManagedConnection();
            } catch (Throwable th) {
                releaseManagedConnection();
            }
        }
    }

    @Deprecated
    public void consumeContent() throws IOException {
        ensureConsumed();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(outputStream);
        ensureConsumed();
    }

    public void releaseConnection() throws IOException {
        ensureConsumed();
    }

    public void abortConnection() throws IOException {
        if (this.managedConn != null) {
            try {
                this.managedConn.abortConnection();
            } finally {
                this.managedConn = null;
            }
        }
    }

    public boolean eofDetected(InputStream inputStream) throws IOException {
        try {
            if (this.managedConn != null) {
                if (this.attemptReuse) {
                    inputStream.close();
                    this.managedConn.markReusable();
                } else {
                    this.managedConn.unmarkReusable();
                }
            }
            releaseManagedConnection();
            return false;
        } catch (Throwable th) {
            releaseManagedConnection();
        }
    }

    public boolean streamClosed(InputStream inputStream) throws IOException {
        boolean isOpen;
        try {
            if (this.managedConn != null) {
                if (this.attemptReuse) {
                    isOpen = this.managedConn.isOpen();
                    inputStream.close();
                    this.managedConn.markReusable();
                } else {
                    this.managedConn.unmarkReusable();
                }
            }
        } catch (SocketException e) {
            if (isOpen) {
                throw e;
            }
        } catch (Throwable th) {
            releaseManagedConnection();
        }
        releaseManagedConnection();
        return false;
    }

    public boolean streamAbort(InputStream inputStream) throws IOException {
        if (this.managedConn != null) {
            this.managedConn.abortConnection();
        }
        return false;
    }

    protected void releaseManagedConnection() throws IOException {
        if (this.managedConn != null) {
            try {
                this.managedConn.releaseConnection();
            } finally {
                this.managedConn = null;
            }
        }
    }
}
