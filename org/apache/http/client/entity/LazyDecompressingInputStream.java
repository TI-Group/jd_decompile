package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* compiled from: TbsSdkJava */
class LazyDecompressingInputStream extends InputStream {
    private final DecompressingEntity decompressingEntity;
    private final InputStream wrappedStream;
    private InputStream wrapperStream;

    public LazyDecompressingInputStream(InputStream inputStream, DecompressingEntity decompressingEntity) {
        this.wrappedStream = inputStream;
        this.decompressingEntity = decompressingEntity;
    }

    private void initWrapper() throws IOException {
        if (this.wrapperStream == null) {
            this.wrapperStream = this.decompressingEntity.decorate(this.wrappedStream);
        }
    }

    public int read() throws IOException {
        initWrapper();
        return this.wrapperStream.read();
    }

    public int read(byte[] bArr) throws IOException {
        initWrapper();
        return this.wrapperStream.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        initWrapper();
        return this.wrapperStream.read(bArr, i, i2);
    }

    public long skip(long j) throws IOException {
        initWrapper();
        return this.wrapperStream.skip(j);
    }

    public boolean markSupported() {
        return false;
    }

    public int available() throws IOException {
        initWrapper();
        return this.wrapperStream.available();
    }

    public void close() throws IOException {
        try {
            if (this.wrapperStream != null) {
                this.wrapperStream.close();
            }
            this.wrappedStream.close();
        } catch (Throwable th) {
            this.wrappedStream.close();
        }
    }
}
