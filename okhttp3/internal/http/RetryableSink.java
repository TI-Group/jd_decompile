package okhttp3.internal.http;

import b.c;
import b.r;
import b.t;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.Util;

/* compiled from: TbsSdkJava */
public final class RetryableSink implements r {
    private boolean closed;
    private final c content;
    private final int limit;

    public RetryableSink(int i) {
        this.content = new c();
        this.limit = i;
    }

    public RetryableSink() {
        this(-1);
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (this.content.a() < ((long) this.limit)) {
                throw new ProtocolException("content-length promised " + this.limit + " bytes, but received " + this.content.a());
            }
        }
    }

    public void write(c cVar, long j) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Util.checkOffsetAndCount(cVar.a(), 0, j);
        if (this.limit == -1 || this.content.a() <= ((long) this.limit) - j) {
            this.content.write(cVar, j);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.limit + " bytes");
    }

    public void flush() throws IOException {
    }

    public t timeout() {
        return t.NONE;
    }

    public long contentLength() throws IOException {
        return this.content.a();
    }

    public void writeToSocket(r rVar) throws IOException {
        c cVar = new c();
        this.content.a(cVar, 0, this.content.a());
        rVar.write(cVar, cVar.a());
    }
}
