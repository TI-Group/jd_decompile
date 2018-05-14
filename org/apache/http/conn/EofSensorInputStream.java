package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class EofSensorInputStream extends InputStream implements ConnectionReleaseTrigger {
    private final EofSensorWatcher eofWatcher;
    private boolean selfClosed = false;
    protected InputStream wrappedStream;

    public EofSensorInputStream(InputStream inputStream, EofSensorWatcher eofSensorWatcher) {
        Args.notNull(inputStream, "Wrapped stream");
        this.wrappedStream = inputStream;
        this.eofWatcher = eofSensorWatcher;
    }

    boolean isSelfClosed() {
        return this.selfClosed;
    }

    InputStream getWrappedStream() {
        return this.wrappedStream;
    }

    protected boolean isReadAllowed() throws IOException {
        if (!this.selfClosed) {
            return this.wrappedStream != null;
        } else {
            throw new IOException("Attempted read on closed stream.");
        }
    }

    public int read() throws IOException {
        if (!isReadAllowed()) {
            return -1;
        }
        try {
            int read = this.wrappedStream.read();
            checkEOF(read);
            return read;
        } catch (IOException e) {
            checkAbort();
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!isReadAllowed()) {
            return -1;
        }
        try {
            int read = this.wrappedStream.read(bArr, i, i2);
            checkEOF(read);
            return read;
        } catch (IOException e) {
            checkAbort();
            throw e;
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int available() throws IOException {
        int i = 0;
        if (isReadAllowed()) {
            try {
                i = this.wrappedStream.available();
            } catch (IOException e) {
                checkAbort();
                throw e;
            }
        }
        return i;
    }

    public void close() throws IOException {
        this.selfClosed = true;
        checkClose();
    }

    protected void checkEOF(int i) throws IOException {
        if (this.wrappedStream != null && i < 0) {
            boolean z = true;
            try {
                if (this.eofWatcher != null) {
                    z = this.eofWatcher.eofDetected(this.wrappedStream);
                }
                if (z) {
                    this.wrappedStream.close();
                }
                this.wrappedStream = null;
            } catch (Throwable th) {
                this.wrappedStream = null;
            }
        }
    }

    protected void checkClose() throws IOException {
        if (this.wrappedStream != null) {
            boolean z = true;
            try {
                if (this.eofWatcher != null) {
                    z = this.eofWatcher.streamClosed(this.wrappedStream);
                }
                if (z) {
                    this.wrappedStream.close();
                }
                this.wrappedStream = null;
            } catch (Throwable th) {
                this.wrappedStream = null;
            }
        }
    }

    protected void checkAbort() throws IOException {
        if (this.wrappedStream != null) {
            boolean z = true;
            try {
                if (this.eofWatcher != null) {
                    z = this.eofWatcher.streamAbort(this.wrappedStream);
                }
                if (z) {
                    this.wrappedStream.close();
                }
                this.wrappedStream = null;
            } catch (Throwable th) {
                this.wrappedStream = null;
            }
        }
    }

    public void releaseConnection() throws IOException {
        close();
    }

    public void abortConnection() throws IOException {
        this.selfClosed = true;
        checkAbort();
    }
}
