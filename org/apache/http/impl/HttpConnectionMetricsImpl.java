package org.apache.http.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.HttpTransportMetrics;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
    public static final String REQUEST_COUNT = "http.request-count";
    public static final String RESPONSE_COUNT = "http.response-count";
    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
    private final HttpTransportMetrics inTransportMetric;
    private Map<String, Object> metricsCache;
    private final HttpTransportMetrics outTransportMetric;
    private long requestCount = 0;
    private long responseCount = 0;

    public HttpConnectionMetricsImpl(HttpTransportMetrics httpTransportMetrics, HttpTransportMetrics httpTransportMetrics2) {
        this.inTransportMetric = httpTransportMetrics;
        this.outTransportMetric = httpTransportMetrics2;
    }

    public long getReceivedBytesCount() {
        if (this.inTransportMetric != null) {
            return this.inTransportMetric.getBytesTransferred();
        }
        return -1;
    }

    public long getSentBytesCount() {
        if (this.outTransportMetric != null) {
            return this.outTransportMetric.getBytesTransferred();
        }
        return -1;
    }

    public long getRequestCount() {
        return this.requestCount;
    }

    public void incrementRequestCount() {
        this.requestCount++;
    }

    public long getResponseCount() {
        return this.responseCount;
    }

    public void incrementResponseCount() {
        this.responseCount++;
    }

    public Object getMetric(String str) {
        Object obj;
        if (this.metricsCache != null) {
            obj = this.metricsCache.get(str);
        } else {
            obj = null;
        }
        if (obj != null) {
            return obj;
        }
        if (REQUEST_COUNT.equals(str)) {
            return Long.valueOf(this.requestCount);
        }
        if (RESPONSE_COUNT.equals(str)) {
            return Long.valueOf(this.responseCount);
        }
        if (RECEIVED_BYTES_COUNT.equals(str)) {
            return this.inTransportMetric != null ? Long.valueOf(this.inTransportMetric.getBytesTransferred()) : null;
        } else {
            if (SENT_BYTES_COUNT.equals(str)) {
                return this.outTransportMetric != null ? Long.valueOf(this.outTransportMetric.getBytesTransferred()) : null;
            } else {
                return obj;
            }
        }
    }

    public void setMetric(String str, Object obj) {
        if (this.metricsCache == null) {
            this.metricsCache = new HashMap();
        }
        this.metricsCache.put(str, obj);
    }

    public void reset() {
        if (this.outTransportMetric != null) {
            this.outTransportMetric.reset();
        }
        if (this.inTransportMetric != null) {
            this.inTransportMetric.reset();
        }
        this.requestCount = 0;
        this.responseCount = 0;
        this.metricsCache = null;
    }
}
