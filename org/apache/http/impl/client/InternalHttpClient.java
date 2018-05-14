package org.apache.http.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthState;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.Configurable;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.HttpClientParamConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpParamsNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@ThreadSafe
/* compiled from: TbsSdkJava */
class InternalHttpClient extends CloseableHttpClient {
    private final Lookup<AuthSchemeProvider> authSchemeRegistry;
    private final List<Closeable> closeables;
    private final HttpClientConnectionManager connManager;
    private final Lookup<CookieSpecProvider> cookieSpecRegistry;
    private final CookieStore cookieStore;
    private final CredentialsProvider credentialsProvider;
    private final RequestConfig defaultConfig;
    private final ClientExecChain execChain;
    private final Log log = LogFactory.getLog(getClass());
    private final HttpRoutePlanner routePlanner;

    public InternalHttpClient(ClientExecChain clientExecChain, HttpClientConnectionManager httpClientConnectionManager, HttpRoutePlanner httpRoutePlanner, Lookup<CookieSpecProvider> lookup, Lookup<AuthSchemeProvider> lookup2, CookieStore cookieStore, CredentialsProvider credentialsProvider, RequestConfig requestConfig, List<Closeable> list) {
        Args.notNull(clientExecChain, "HTTP client exec chain");
        Args.notNull(httpClientConnectionManager, "HTTP connection manager");
        Args.notNull(httpRoutePlanner, "HTTP route planner");
        this.execChain = clientExecChain;
        this.connManager = httpClientConnectionManager;
        this.routePlanner = httpRoutePlanner;
        this.cookieSpecRegistry = lookup;
        this.authSchemeRegistry = lookup2;
        this.cookieStore = cookieStore;
        this.credentialsProvider = credentialsProvider;
        this.defaultConfig = requestConfig;
        this.closeables = list;
    }

    private HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        HttpHost httpHost2;
        if (httpHost == null) {
            httpHost2 = (HttpHost) httpRequest.getParams().getParameter(ClientPNames.DEFAULT_HOST);
        } else {
            httpHost2 = httpHost;
        }
        return this.routePlanner.determineRoute(httpHost2, httpRequest, httpContext);
    }

    private void setupContext(HttpClientContext httpClientContext) {
        if (httpClientContext.getAttribute("http.auth.target-scope") == null) {
            httpClientContext.setAttribute("http.auth.target-scope", new AuthState());
        }
        if (httpClientContext.getAttribute("http.auth.proxy-scope") == null) {
            httpClientContext.setAttribute("http.auth.proxy-scope", new AuthState());
        }
        if (httpClientContext.getAttribute("http.authscheme-registry") == null) {
            httpClientContext.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        }
        if (httpClientContext.getAttribute("http.cookiespec-registry") == null) {
            httpClientContext.setAttribute("http.cookiespec-registry", this.cookieSpecRegistry);
        }
        if (httpClientContext.getAttribute("http.cookie-store") == null) {
            httpClientContext.setAttribute("http.cookie-store", this.cookieStore);
        }
        if (httpClientContext.getAttribute("http.auth.credentials-provider") == null) {
            httpClientContext.setAttribute("http.auth.credentials-provider", this.credentialsProvider);
        }
        if (httpClientContext.getAttribute("http.request-config") == null) {
            httpClientContext.setAttribute("http.request-config", this.defaultConfig);
        }
    }

    protected CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        HttpExecutionAware httpExecutionAware;
        RequestConfig requestConfig = null;
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest instanceof HttpExecutionAware) {
            httpExecutionAware = (HttpExecutionAware) httpRequest;
        } else {
            httpExecutionAware = null;
        }
        try {
            RequestConfig requestConfig2;
            Object wrap = HttpRequestWrapper.wrap(httpRequest);
            if (httpContext == null) {
                httpContext = new BasicHttpContext();
            }
            Object adapt = HttpClientContext.adapt(httpContext);
            if (httpRequest instanceof Configurable) {
                requestConfig = ((Configurable) httpRequest).getConfig();
            }
            if (requestConfig == null) {
                HttpParams params = httpRequest.getParams();
                if (!(params instanceof HttpParamsNames)) {
                    requestConfig2 = HttpClientParamConfig.getRequestConfig(params);
                } else if (!((HttpParamsNames) params).getNames().isEmpty()) {
                    requestConfig2 = HttpClientParamConfig.getRequestConfig(params);
                }
                if (requestConfig2 != null) {
                    adapt.setRequestConfig(requestConfig2);
                }
                setupContext(adapt);
                return this.execChain.execute(determineRoute(httpHost, wrap, adapt), wrap, adapt, httpExecutionAware);
            }
            requestConfig2 = requestConfig;
            if (requestConfig2 != null) {
                adapt.setRequestConfig(requestConfig2);
            }
            setupContext(adapt);
            return this.execChain.execute(determineRoute(httpHost, wrap, adapt), wrap, adapt, httpExecutionAware);
        } catch (Throwable e) {
            throw new ClientProtocolException(e);
        }
    }

    public void close() {
        this.connManager.shutdown();
        if (this.closeables != null) {
            for (Closeable close : this.closeables) {
                try {
                    close.close();
                } catch (Throwable e) {
                    this.log.error(e.getMessage(), e);
                }
            }
        }
    }

    public HttpParams getParams() {
        throw new UnsupportedOperationException();
    }

    public ClientConnectionManager getConnectionManager() {
        return new ClientConnectionManager() {
            public void shutdown() {
                InternalHttpClient.this.connManager.shutdown();
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
                InternalHttpClient.this.connManager.closeIdleConnections(j, timeUnit);
            }

            public void closeExpiredConnections() {
                InternalHttpClient.this.connManager.closeExpiredConnections();
            }
        };
    }
}
