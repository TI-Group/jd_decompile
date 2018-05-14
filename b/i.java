package b;

import java.io.IOException;

/* compiled from: TbsSdkJava */
public abstract class i implements s {
    private final s delegate;

    public i(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = sVar;
    }

    public final s delegate() {
        return this.delegate;
    }

    public long read(c cVar, long j) throws IOException {
        return this.delegate.read(cVar, j);
    }

    public t timeout() {
        return this.delegate.timeout();
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
