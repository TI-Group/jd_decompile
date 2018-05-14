package org.apache.http.impl.execchain;

import java.io.IOException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class ProtocolExec implements ClientExecChain {
    private final HttpProcessor httpProcessor;
    private final Log log = LogFactory.getLog(getClass());
    private final ClientExecChain requestExecutor;

    public ProtocolExec(ClientExecChain clientExecChain, HttpProcessor httpProcessor) {
        Args.notNull(clientExecChain, "HTTP client request executor");
        Args.notNull(httpProcessor, "HTTP protocol processor");
        this.requestExecutor = clientExecChain;
        this.httpProcessor = httpProcessor;
    }

    void rewriteRequestURI(HttpRequestWrapper httpRequestWrapper, HttpRoute httpRoute) throws ProtocolException {
        try {
            URI uri = httpRequestWrapper.getURI();
            if (uri != null) {
                if (httpRoute.getProxyHost() == null || httpRoute.isTunnelled()) {
                    if (uri.isAbsolute()) {
                        uri = URIUtils.rewriteURI(uri, null, true);
                    } else {
                        uri = URIUtils.rewriteURI(uri);
                    }
                } else if (uri.isAbsolute()) {
                    uri = URIUtils.rewriteURI(uri);
                } else {
                    uri = URIUtils.rewriteURI(uri, httpRoute.getTargetHost(), true);
                }
                httpRequestWrapper.setURI(uri);
            }
        } catch (Throwable e) {
            throw new ProtocolException("Invalid URI: " + httpRequestWrapper.getRequestLine().getUri(), e);
        }
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        URI uri;
        HttpHost targetHost;
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        HttpRequest original = httpRequestWrapper.getOriginal();
        if (original instanceof HttpUriRequest) {
            uri = ((HttpUriRequest) original).getURI();
        } else {
            String uri2 = original.getRequestLine().getUri();
            try {
                uri = URI.create(uri2);
            } catch (Throwable e) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Unable to parse '" + uri2 + "' as a valid URI; " + "request URI and Host header may be inconsistent", e);
                }
                uri = null;
            }
        }
        httpRequestWrapper.setURI(uri);
        rewriteRequestURI(httpRequestWrapper, httpRoute);
        HttpHost httpHost = (HttpHost) httpRequestWrapper.getParams().getParameter(ClientPNames.VIRTUAL_HOST);
        if (httpHost != null && httpHost.getPort() == -1) {
            int port = httpRoute.getTargetHost().getPort();
            if (port != -1) {
                httpHost = new HttpHost(httpHost.getHostName(), port, httpHost.getSchemeName());
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug("Using virtual host" + httpHost);
            }
        }
        if (httpHost == null) {
            if (uri == null || !uri.isAbsolute() || uri.getHost() == null) {
                httpHost = null;
            } else {
                httpHost = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
            }
        }
        if (httpHost == null) {
            targetHost = httpRoute.getTargetHost();
        } else {
            targetHost = httpHost;
        }
        if (uri != null) {
            String userInfo = uri.getUserInfo();
            if (userInfo != null) {
                CredentialsProvider credentialsProvider = httpClientContext.getCredentialsProvider();
                if (credentialsProvider == null) {
                    credentialsProvider = new BasicCredentialsProvider();
                    httpClientContext.setCredentialsProvider(credentialsProvider);
                }
                credentialsProvider.setCredentials(new AuthScope(targetHost), new UsernamePasswordCredentials(userInfo));
            }
        }
        httpClientContext.setAttribute("http.target_host", targetHost);
        httpClientContext.setAttribute("http.route", httpRoute);
        httpClientContext.setAttribute("http.request", httpRequestWrapper);
        this.httpProcessor.process(httpRequestWrapper, httpClientContext);
        CloseableHttpResponse execute = this.requestExecutor.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
        try {
            httpClientContext.setAttribute("http.response", execute);
            this.httpProcessor.process(execute, httpClientContext);
            return execute;
        } catch (RuntimeException e2) {
            execute.close();
            throw e2;
        } catch (IOException e3) {
            execute.close();
            throw e3;
        } catch (HttpException e4) {
            execute.close();
            throw e4;
        }
    }
}
