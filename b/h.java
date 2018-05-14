package b;

import java.io.IOException;

/* compiled from: TbsSdkJava */
public abstract class h implements r {
    private final r delegate;

    public h(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = rVar;
    }

    public final r delegate() {
        return this.delegate;
    }

    public void write(c cVar, long j) throws IOException {
        this.delegate.write(cVar, j);
    }

    public void flush() throws IOException {
        this.delegate.flush();
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
