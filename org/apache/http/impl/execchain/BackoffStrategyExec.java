package org.apache.http.impl.execchain;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.BackoffManager;
import org.apache.http.client.ConnectionBackoffStrategy;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class BackoffStrategyExec implements ClientExecChain {
    private final BackoffManager backoffManager;
    private final ConnectionBackoffStrategy connectionBackoffStrategy;
    private final ClientExecChain requestExecutor;

    public BackoffStrategyExec(ClientExecChain clientExecChain, ConnectionBackoffStrategy connectionBackoffStrategy, BackoffManager backoffManager) {
        Args.notNull(clientExecChain, "HTTP client request executor");
        Args.notNull(connectionBackoffStrategy, "Connection backoff strategy");
        Args.notNull(backoffManager, "Backoff manager");
        this.requestExecutor = clientExecChain;
        this.connectionBackoffStrategy = connectionBackoffStrategy;
        this.backoffManager = backoffManager;
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            HttpResponse execute = this.requestExecutor.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
            if (this.connectionBackoffStrategy.shouldBackoff(execute)) {
                this.backoffManager.backOff(httpRoute);
            } else {
                this.backoffManager.probe(httpRoute);
            }
            return execute;
        } catch (Throwable e) {
            if (closeableHttpResponse != null) {
                closeableHttpResponse.close();
            }
            if (this.connectionBackoffStrategy.shouldBackoff(e)) {
                this.backoffManager.backOff(httpRoute);
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            } else if (e instanceof HttpException) {
                throw ((HttpException) e);
            } else if (e instanceof IOException) {
                throw ((IOException) e);
            } else {
                throw new UndeclaredThrowableException(e);
            }
        }
    }
}
