package org.apache.http.impl.client;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.protocol.HttpContext;

/* compiled from: TbsSdkJava */
class HttpRequestTaskCallable<V> implements Callable<V> {
    private final FutureCallback<V> callback;
    private final AtomicBoolean cancelled = new AtomicBoolean(false);
    private final HttpContext context;
    private long ended = -1;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics;
    private final HttpUriRequest request;
    private final ResponseHandler<V> responseHandler;
    private final long scheduled = System.currentTimeMillis();
    private long started = -1;

    HttpRequestTaskCallable(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, ResponseHandler<V> responseHandler, FutureCallback<V> futureCallback, FutureRequestExecutionMetrics futureRequestExecutionMetrics) {
        this.httpclient = httpClient;
        this.responseHandler = responseHandler;
        this.request = httpUriRequest;
        this.context = httpContext;
        this.callback = futureCallback;
        this.metrics = futureRequestExecutionMetrics;
    }

    public long getScheduled() {
        return this.scheduled;
    }

    public long getStarted() {
        return this.started;
    }

    public long getEnded() {
        return this.ended;
    }

    public V call() throws Exception {
        if (this.cancelled.get()) {
            throw new IllegalStateException("call has been cancelled for request " + this.request.getURI());
        }
        try {
            this.metrics.getActiveConnections().incrementAndGet();
            this.started = System.currentTimeMillis();
            this.metrics.getScheduledConnections().decrementAndGet();
            V execute = this.httpclient.execute(this.request, this.responseHandler, this.context);
            this.ended = System.currentTimeMillis();
            this.metrics.getSuccessfulConnections().increment(this.started);
            if (this.callback != null) {
                this.callback.completed(execute);
            }
            this.metrics.getRequests().increment(this.started);
            this.metrics.getTasks().increment(this.started);
            this.metrics.getActiveConnections().decrementAndGet();
            return execute;
        } catch (Exception e) {
            this.metrics.getFailedConnections().increment(this.started);
            this.ended = System.currentTimeMillis();
            if (this.callback != null) {
                this.callback.failed(e);
            }
            throw e;
        } catch (Throwable th) {
            this.metrics.getRequests().increment(this.started);
            this.metrics.getTasks().increment(this.started);
            this.metrics.getActiveConnections().decrementAndGet();
        }
    }

    public void cancel() {
        this.cancelled.set(true);
        if (this.callback != null) {
            this.callback.cancelled();
        }
    }
}
