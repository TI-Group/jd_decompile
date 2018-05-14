package org.apache.http.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.util.Args;

/* compiled from: TbsSdkJava */
public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private volatile Exception ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isDone() {
        return this.completed;
    }

    private T getResult() throws ExecutionException {
        if (this.ex == null) {
            return this.result;
        }
        throw new ExecutionException(this.ex);
    }

    public synchronized T get() throws InterruptedException, ExecutionException {
        while (!this.completed) {
            wait();
        }
        return getResult();
    }

    public synchronized T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        T result;
        Args.notNull(timeUnit, "Time unit");
        long toMillis = timeUnit.toMillis(j);
        long currentTimeMillis = toMillis <= 0 ? 0 : System.currentTimeMillis();
        if (this.completed) {
            result = getResult();
        } else if (toMillis <= 0) {
            throw new TimeoutException();
        } else {
            long j2 = toMillis;
            do {
                wait(j2);
                if (this.completed) {
                    result = getResult();
                } else {
                    j2 = toMillis - (System.currentTimeMillis() - currentTimeMillis);
                }
            } while (j2 > 0);
            throw new TimeoutException();
        }
        return result;
    }

    public boolean completed(T t) {
        boolean z = true;
        synchronized (this) {
            if (this.completed) {
                z = false;
            } else {
                this.completed = true;
                this.result = t;
                notifyAll();
                if (this.callback != null) {
                    this.callback.completed(t);
                }
            }
        }
        return z;
    }

    public boolean failed(Exception exception) {
        boolean z = true;
        synchronized (this) {
            if (this.completed) {
                z = false;
            } else {
                this.completed = true;
                this.ex = exception;
                notifyAll();
                if (this.callback != null) {
                    this.callback.failed(exception);
                }
            }
        }
        return z;
    }

    public boolean cancel(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (this.completed) {
                z2 = false;
            } else {
                this.completed = true;
                this.cancelled = true;
                notifyAll();
                if (this.callback != null) {
                    this.callback.cancelled();
                }
            }
        }
        return z2;
    }

    public boolean cancel() {
        return cancel(true);
    }
}
