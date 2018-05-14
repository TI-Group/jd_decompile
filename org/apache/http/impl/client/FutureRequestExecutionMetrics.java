package org.apache.http.impl.client;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: TbsSdkJava */
public final class FutureRequestExecutionMetrics {
    private final AtomicLong activeConnections = new AtomicLong();
    private final DurationCounter failedConnections = new DurationCounter();
    private final DurationCounter requests = new DurationCounter();
    private final AtomicLong scheduledConnections = new AtomicLong();
    private final DurationCounter successfulConnections = new DurationCounter();
    private final DurationCounter tasks = new DurationCounter();

    /* compiled from: TbsSdkJava */
    static class DurationCounter {
        private final AtomicLong count = new AtomicLong(0);
        private final AtomicLong cumulativeDuration = new AtomicLong(0);

        DurationCounter() {
        }

        public void increment(long j) {
            this.count.incrementAndGet();
            this.cumulativeDuration.addAndGet(System.currentTimeMillis() - j);
        }

        public long count() {
            return this.count.get();
        }

        public long averageDuration() {
            long j = this.count.get();
            if (j > 0) {
                return this.cumulativeDuration.get() / j;
            }
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[count=").append(count()).append(", averageDuration=").append(averageDuration()).append("]");
            return stringBuilder.toString();
        }
    }

    FutureRequestExecutionMetrics() {
    }

    AtomicLong getActiveConnections() {
        return this.activeConnections;
    }

    AtomicLong getScheduledConnections() {
        return this.scheduledConnections;
    }

    DurationCounter getSuccessfulConnections() {
        return this.successfulConnections;
    }

    DurationCounter getFailedConnections() {
        return this.failedConnections;
    }

    DurationCounter getRequests() {
        return this.requests;
    }

    DurationCounter getTasks() {
        return this.tasks;
    }

    public long getActiveConnectionCount() {
        return this.activeConnections.get();
    }

    public long getScheduledConnectionCount() {
        return this.scheduledConnections.get();
    }

    public long getSuccessfulConnectionCount() {
        return this.successfulConnections.count();
    }

    public long getSuccessfulConnectionAverageDuration() {
        return this.successfulConnections.averageDuration();
    }

    public long getFailedConnectionCount() {
        return this.failedConnections.count();
    }

    public long getFailedConnectionAverageDuration() {
        return this.failedConnections.averageDuration();
    }

    public long getRequestCount() {
        return this.requests.count();
    }

    public long getRequestAverageDuration() {
        return this.requests.averageDuration();
    }

    public long getTaskCount() {
        return this.tasks.count();
    }

    public long getTaskAverageDuration() {
        return this.tasks.averageDuration();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[activeConnections=").append(this.activeConnections).append(", scheduledConnections=").append(this.scheduledConnections).append(", successfulConnections=").append(this.successfulConnections).append(", failedConnections=").append(this.failedConnections).append(", requests=").append(this.requests).append(", tasks=").append(this.tasks).append("]");
        return stringBuilder.toString();
    }
}
