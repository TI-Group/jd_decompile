package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* compiled from: TbsSdkJava */
public class DeflateInputStream extends InputStream {
    private InputStream sourceStream;

    /* compiled from: TbsSdkJava */
    static class DeflateStream extends InflaterInputStream {
        private boolean closed = false;

        public DeflateStream(InputStream inputStream, Inflater inflater) {
            super(inputStream, inflater);
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                this.inf.end();
                super.close();
            }
        }
    }

    public DeflateInputStream(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[6];
        InputStream pushbackInputStream = new PushbackInputStream(inputStream, bArr.length);
        int read = pushbackInputStream.read(bArr);
        if (read == -1) {
            throw new IOException("Unable to read the response");
        }
        byte[] bArr2 = new byte[1];
        Inflater inflater = new Inflater();
        while (true) {
            int inflate = inflater.inflate(bArr2);
            if (inflate != 0) {
                break;
            } else if (inflater.finished()) {
                throw new IOException("Unable to read the response");
            } else if (inflater.needsDictionary()) {
                break;
            } else {
                try {
                    if (inflater.needsInput()) {
                        inflater.setInput(bArr);
                    }
                } catch (DataFormatException e) {
                    pushbackInputStream.unread(bArr, 0, read);
                    this.sourceStream = new DeflateStream(pushbackInputStream, new Inflater(true));
                } finally {
                    inflater.end();
                }
            }
        }
        if (inflate == -1) {
            throw new IOException("Unable to read the response");
        }
        pushbackInputStream.unread(bArr, 0, read);
        this.sourceStream = new DeflateStream(pushbackInputStream, new Inflater());
    }

    public int read() throws IOException {
        return this.sourceStream.read();
    }

    public int read(byte[] bArr) throws IOException {
        return this.sourceStream.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.sourceStream.read(bArr, i, i2);
    }

    public long skip(long j) throws IOException {
        return this.sourceStream.skip(j);
    }

    public int available() throws IOException {
        return this.sourceStream.available();
    }

    public void mark(int i) {
        this.sourceStream.mark(i);
    }

    public void reset() throws IOException {
        this.sourceStream.reset();
    }

    public boolean markSupported() {
        return this.sourceStream.markSupported();
    }

    public void close() throws IOException {
        this.sourceStream.close();
    }
}
