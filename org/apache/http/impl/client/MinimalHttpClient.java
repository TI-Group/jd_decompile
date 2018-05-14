package org.apache.http.impl.client;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.Configurable;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.execchain.MinimalClientExec;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.Args;

@ThreadSafe
/* compiled from: TbsSdkJava */
class MinimalHttpClient extends CloseableHttpClient {
    private final HttpClientConnectionManager connManager;
    private final HttpParams params = new BasicHttpParams();
    private final MinimalClientExec requestExecutor;

    public MinimalHttpClient(HttpClientConnectionManager httpClientConnectionManager) {
        this.connManager = (HttpClientConnectionManager) Args.notNull(httpClientConnectionManager, "HTTP connection manager");
        this.requestExecutor = new MinimalClientExec(new HttpRequestExecutor(), httpClientConnectionManager, DefaultConnectionReuseStrategy.INSTANCE, DefaultConnectionKeepAliveStrategy.INSTANCE);
    }

    protected CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        HttpExecutionAware httpExecutionAware;
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest instanceof HttpExecutionAware) {
            httpExecutionAware = (HttpExecutionAware) httpRequest;
        } else {
            httpExecutionAware = null;
        }
        try {
            RequestConfig config;
            HttpRequestWrapper wrap = HttpRequestWrapper.wrap(httpRequest);
            if (httpContext == null) {
                httpContext = new BasicHttpContext();
            }
            HttpClientContext adapt = HttpClientContext.adapt(httpContext);
            HttpRoute httpRoute = new HttpRoute(httpHost);
            if (httpRequest instanceof Configurable) {
                config = ((Configurable) httpRequest).getConfig();
            } else {
                config = null;
            }
            if (config != null) {
                adapt.setRequestConfig(config);
            }
            return this.requestExecutor.execute(httpRoute, wrap, adapt, httpExecutionAware);
        } catch (Throwable e) {
            throw new ClientProtocolException(e);
        }
    }

    public HttpParams getParams() {
        return this.params;
    }

    public void close() {
        this.connManager.shutdown();
    }

    public ClientConnectionManager getConnectionManager() {
        return new ClientConnectionManager() {
            public void shutdown() {
                MinimalHttpClient.this.connManager.shutdown();
            }

            public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
                throw new UnsupportedOperationException();
            }

            public void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit) {
                throw new UnsupportedOperationException();
            }

            public SchemeRegistry getSchemeRegistry() {
                throw new UnsupportedOperationException();
            }

            public void closeIdleConnections(long j, TimeUnit timeUnit) {
                MinimalHttpClient.this.connManager.closeIdleConnections(j, timeUnit);
            }

            public void closeExpiredConnections() {
                MinimalHttpClient.this.connManager.closeExpiredConnections();
            }
        };
    }
}
