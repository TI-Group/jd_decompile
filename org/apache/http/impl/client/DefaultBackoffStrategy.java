package org.apache.http.impl.client;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ConnectionBackoffStrategy;

/* compiled from: TbsSdkJava */
public class DefaultBackoffStrategy implements ConnectionBackoffStrategy {
    public boolean shouldBackoff(Throwable th) {
        return (th instanceof SocketTimeoutException) || (th instanceof ConnectException);
    }

    public boolean shouldBackoff(HttpResponse httpResponse) {
        return httpResponse.getStatusLine().getStatusCode() == 503;
    }
}
