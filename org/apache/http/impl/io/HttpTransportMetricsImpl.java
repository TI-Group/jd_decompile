package org.apache.http.impl.io;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.HttpTransportMetrics;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred = 0;

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(long j) {
        this.bytesTransferred = j;
    }

    public void incrementBytesTransferred(long j) {
        this.bytesTransferred += j;
    }

    public void reset() {
        this.bytesTransferred = 0;
    }
}
