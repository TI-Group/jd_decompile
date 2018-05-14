package org.apache.http.impl.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@Deprecated
@ThreadSafe
/* compiled from: TbsSdkJava */
public class AutoRetryHttpClient implements HttpClient {
    private final HttpClient backend;
    private final Log log;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public AutoRetryHttpClient(HttpClient httpClient, ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this.log = LogFactory.getLog(getClass());
        Args.notNull(httpClient, "HttpClient");
        Args.notNull(serviceUnavailableRetryStrategy, "ServiceUnavailableRetryStrategy");
        this.backend = httpClient;
        this.retryStrategy = serviceUnavailableRetryStrategy;
    }

    public AutoRetryHttpClient() {
        this(new DefaultHttpClient(), new DefaultServiceUnavailableRetryStrategy());
    }

    public AutoRetryHttpClient(ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this(new DefaultHttpClient(), serviceUnavailableRetryStrategy);
    }

    public AutoRetryHttpClient(HttpClient httpClient) {
        this(httpClient, new DefaultServiceUnavailableRetryStrategy());
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return execute(httpHost, httpRequest, null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return execute(httpHost, httpRequest, responseHandler, null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return responseHandler.handleResponse(execute(httpHost, httpRequest, httpContext));
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return execute(httpUriRequest, null);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        URI uri = httpUriRequest.getURI();
        return execute(new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), (HttpRequest) httpUriRequest, httpContext);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return execute(httpUriRequest, (ResponseHandler) responseHandler, null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return responseHandler.handleResponse(execute(httpUriRequest, httpContext));
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        int i = 1;
        while (true) {
            HttpResponse execute = this.backend.execute(httpHost, httpRequest, httpContext);
            try {
                if (!this.retryStrategy.retryRequest(execute, i, httpContext)) {
                    return execute;
                }
                EntityUtils.consume(execute.getEntity());
                long retryInterval = this.retryStrategy.getRetryInterval();
                this.log.trace("Wait for " + retryInterval);
                Thread.sleep(retryInterval);
                i++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            } catch (RuntimeException e2) {
                try {
                    EntityUtils.consume(execute.getEntity());
                } catch (Throwable e3) {
                    this.log.warn("I/O error consuming response content", e3);
                }
                throw e2;
            }
        }
    }

    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    public HttpParams getParams() {
        return this.backend.getParams();
    }
}
