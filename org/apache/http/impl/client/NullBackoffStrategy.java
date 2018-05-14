package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.ConnectionBackoffStrategy;

/* compiled from: TbsSdkJava */
public class NullBackoffStrategy implements ConnectionBackoffStrategy {
    public boolean shouldBackoff(Throwable th) {
        return false;
    }

    public boolean shouldBackoff(HttpResponse httpResponse) {
        return false;
    }
}
