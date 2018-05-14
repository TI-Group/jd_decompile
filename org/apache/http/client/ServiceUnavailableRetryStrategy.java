package org.apache.http.client;

import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* compiled from: TbsSdkJava */
public interface ServiceUnavailableRetryStrategy {
    long getRetryInterval();

    boolean retryRequest(HttpResponse httpResponse, int i, HttpContext httpContext);
}
