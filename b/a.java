package b;

import java.io.IOException;
import java.io.InterruptedIOException;

/* compiled from: TbsSdkJava */
public class a extends t {
    private static a head;
    private boolean inQueue;
    private a next;
    private long timeoutAt;

    /* compiled from: TbsSdkJava */
    private static final class a extends Thread {
        public a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public void run() {
            while (true) {
                try {
                    a access$000 = a.awaitTimeout();
                    if (access$000 != null) {
                        access$000.timedOut();
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            this.inQueue = true;
            scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    private static synchronized void scheduleTimeout(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (head == null) {
                head = new a();
                new a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.timeoutAt = Math.min(j, aVar.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (j != 0) {
                aVar.timeoutAt = nanoTime + j;
            } else if (z) {
                aVar.timeoutAt = aVar.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = aVar.remainingNanos(nanoTime);
            a aVar2 = head;
            while (aVar2.next != null && remainingNanos >= aVar2.next.remainingNanos(nanoTime)) {
                aVar2 = aVar2.next;
            }
            aVar.next = aVar2.next;
            aVar2.next = aVar;
            if (aVar2 == head) {
                a.class.notify();
            }
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return cancelScheduledTimeout(this);
    }

    private static synchronized boolean cancelScheduledTimeout(a aVar) {
        boolean z;
        synchronized (a.class) {
            for (a aVar2 = head; aVar2 != null; aVar2 = aVar2.next) {
                if (aVar2.next == aVar) {
                    aVar2.next = aVar.next;
                    aVar.next = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    protected void timedOut() {
    }

    public final r sink(final r rVar) {
        return new r(this) {
            final /* synthetic */ a b;

            public void write(c cVar, long j) throws IOException {
                this.b.enter();
                try {
                    rVar.write(cVar, j);
                    this.b.exit(true);
                } catch (IOException e) {
                    throw this.b.exit(e);
                } catch (Throwable th) {
                    this.b.exit(false);
                }
            }

            public void flush() throws IOException {
                this.b.enter();
                try {
                    rVar.flush();
                    this.b.exit(true);
                } catch (IOException e) {
                    throw this.b.exit(e);
                } catch (Throwable th) {
                    this.b.exit(false);
                }
            }

            public void close() throws IOException {
                this.b.enter();
                try {
                    rVar.close();
                    this.b.exit(true);
                } catch (IOException e) {
                    throw this.b.exit(e);
                } catch (Throwable th) {
                    this.b.exit(false);
                }
            }

            public t timeout() {
                return this.b;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + rVar + ")";
            }
        };
    }

    public final s source(final s sVar) {
        return new s(this) {
            final /* synthetic */ a b;

            public long read(c cVar, long j) throws IOException {
                this.b.enter();
                try {
                    long read = sVar.read(cVar, j);
                    this.b.exit(true);
                    return read;
                } catch (IOException e) {
                    throw this.b.exit(e);
                } catch (Throwable th) {
                    this.b.exit(false);
                }
            }

            public void close() throws IOException {
                try {
                    sVar.close();
                    this.b.exit(true);
                } catch (IOException e) {
                    throw this.b.exit(e);
                } catch (Throwable th) {
                    this.b.exit(false);
                }
            }

            public t timeout() {
                return this.b;
            }

            public String toString() {
                return "AsyncTimeout.source(" + sVar + ")";
            }
        };
    }

    final void exit(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    final IOException exit(IOException iOException) throws IOException {
        return !exit() ? iOException : newTimeoutException(iOException);
    }

    protected IOException newTimeoutException(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    private static synchronized a awaitTimeout() throws InterruptedException {
        a aVar = null;
        synchronized (a.class) {
            a aVar2 = head.next;
            if (aVar2 == null) {
                a.class.wait();
            } else {
                long remainingNanos = aVar2.remainingNanos(System.nanoTime());
                if (remainingNanos > 0) {
                    long j = remainingNanos / 1000000;
                    a.class.wait(j, (int) (remainingNanos - (1000000 * j)));
                } else {
                    head.next = aVar2.next;
                    aVar2.next = null;
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }
}
