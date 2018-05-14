package b;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: TbsSdkJava */
public class j extends t {
    private t a;

    public j(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = tVar;
    }

    public final t a() {
        return this.a;
    }

    public final j a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = tVar;
        return this;
    }

    public t timeout(long j, TimeUnit timeUnit) {
        return this.a.timeout(j, timeUnit);
    }

    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    public t deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }

    public t clearTimeout() {
        return this.a.clearTimeout();
    }

    public t clearDeadline() {
        return this.a.clearDeadline();
    }

    public void throwIfReached() throws IOException {
        this.a.throwIfReached();
    }
}
