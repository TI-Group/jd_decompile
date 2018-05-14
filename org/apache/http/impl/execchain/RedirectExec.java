package org.apache.http.impl.execchain;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.client.RedirectException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@ThreadSafe
/* compiled from: TbsSdkJava */
public class RedirectExec implements ClientExecChain {
    private final Log log = LogFactory.getLog(getClass());
    private final RedirectStrategy redirectStrategy;
    private final ClientExecChain requestExecutor;
    private final HttpRoutePlanner routePlanner;

    public RedirectExec(ClientExecChain clientExecChain, HttpRoutePlanner httpRoutePlanner, RedirectStrategy redirectStrategy) {
        Args.notNull(clientExecChain, "HTTP client request executor");
        Args.notNull(httpRoutePlanner, "HTTP route planner");
        Args.notNull(redirectStrategy, "HTTP redirect strategy");
        this.requestExecutor = clientExecChain;
        this.routePlanner = httpRoutePlanner;
        this.redirectStrategy = redirectStrategy;
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        int maxRedirects;
        CloseableHttpResponse execute;
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        List redirectLocations = httpClientContext.getRedirectLocations();
        if (redirectLocations != null) {
            redirectLocations.clear();
        }
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        if (requestConfig.getMaxRedirects() > 0) {
            maxRedirects = requestConfig.getMaxRedirects();
        } else {
            maxRedirects = 50;
        }
        int i = 0;
        HttpRequest httpRequest = httpRequestWrapper;
        while (true) {
            execute = this.requestExecutor.execute(httpRoute, httpRequest, httpClientContext, httpExecutionAware);
            try {
                if (!requestConfig.isRedirectsEnabled() || !this.redirectStrategy.isRedirected(httpRequest, execute, httpClientContext)) {
                    return execute;
                }
                if (i >= maxRedirects) {
                    throw new RedirectException("Maximum redirects (" + maxRedirects + ") exceeded");
                }
                int i2 = i + 1;
                HttpRequest redirect = this.redirectStrategy.getRedirect(httpRequest, execute, httpClientContext);
                if (!redirect.headerIterator().hasNext()) {
                    redirect.setHeaders(httpRequestWrapper.getOriginal().getAllHeaders());
                }
                httpRequest = HttpRequestWrapper.wrap(redirect);
                if (httpRequest instanceof HttpEntityEnclosingRequest) {
                    RequestEntityProxy.enhance((HttpEntityEnclosingRequest) httpRequest);
                }
                URI uri = httpRequest.getURI();
                HttpHost extractHost = URIUtils.extractHost(uri);
                if (extractHost == null) {
                    throw new ProtocolException("Redirect URI does not specify a valid host name: " + uri);
                }
                if (!httpRoute.getTargetHost().equals(extractHost)) {
                    AuthState targetAuthState = httpClientContext.getTargetAuthState();
                    if (targetAuthState != null) {
                        this.log.debug("Resetting target auth state");
                        targetAuthState.reset();
                    }
                    targetAuthState = httpClientContext.getProxyAuthState();
                    if (targetAuthState != null) {
                        AuthScheme authScheme = targetAuthState.getAuthScheme();
                        if (authScheme != null && authScheme.isConnectionBased()) {
                            this.log.debug("Resetting proxy auth state");
                            targetAuthState.reset();
                        }
                    }
                }
                httpRoute = this.routePlanner.determineRoute(extractHost, httpRequest, httpClientContext);
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Redirecting to '" + uri + "' via " + httpRoute);
                }
                EntityUtils.consume(execute.getEntity());
                execute.close();
                i = i2;
            } catch (RuntimeException e) {
                execute.close();
                throw e;
            } catch (IOException e2) {
                execute.close();
                throw e2;
            } catch (Object e3) {
                try {
                    EntityUtils.consume(execute.getEntity());
                } catch (Throwable e4) {
                    this.log.debug("I/O error while releasing connection", e4);
                    throw e3;
                } finally {
                    execute.close();
                }
                throw e3;
            }
        }
        return execute;
    }
}
