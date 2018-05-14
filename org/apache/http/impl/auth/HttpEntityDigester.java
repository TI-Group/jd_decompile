package org.apache.http.impl.auth;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* compiled from: TbsSdkJava */
class HttpEntityDigester extends OutputStream {
    private boolean closed;
    private byte[] digest;
    private final MessageDigest digester;

    HttpEntityDigester(MessageDigest messageDigest) {
        this.digester = messageDigest;
        this.digester.reset();
    }

    public void write(int i) throws IOException {
        if (this.closed) {
            throw new IOException("Stream has been already closed");
        }
        this.digester.update((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IOException("Stream has been already closed");
        }
        this.digester.update(bArr, i, i2);
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.digest = this.digester.digest();
            super.close();
        }
    }

    public byte[] getDigest() {
        return this.digest;
    }
}
