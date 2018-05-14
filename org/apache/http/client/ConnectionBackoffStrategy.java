package org.apache.http.client;

import org.apache.http.HttpResponse;

/* compiled from: TbsSdkJava */
public interface ConnectionBackoffStrategy {
    boolean shouldBackoff(Throwable th);

    boolean shouldBackoff(HttpResponse httpResponse);
}
