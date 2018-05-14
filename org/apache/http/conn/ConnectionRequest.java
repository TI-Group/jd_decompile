package org.apache.http.conn;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpClientConnection;
import org.apache.http.concurrent.Cancellable;

/* compiled from: TbsSdkJava */
public interface ConnectionRequest extends Cancellable {
    HttpClientConnection get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException;
}
