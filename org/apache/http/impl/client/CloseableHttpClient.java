package org.apache.http.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@ThreadSafe
/* compiled from: TbsSdkJava */
public abstract class CloseableHttpClient implements Closeable, HttpClient {
    private final Log log = LogFactory.getLog(getClass());

    protected abstract CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException;

    public CloseableHttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        return doExecute(httpHost, httpRequest, httpContext);
    }

    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        Args.notNull(httpUriRequest, "HTTP request");
        return doExecute(determineTarget(httpUriRequest), httpUriRequest, httpContext);
    }

    private static HttpHost determineTarget(HttpUriRequest httpUriRequest) throws ClientProtocolException {
        HttpHost httpHost = null;
        URI uri = httpUriRequest.getURI();
        if (uri.isAbsolute()) {
            httpHost = URIUtils.extractHost(uri);
            if (httpHost == null) {
                throw new ClientProtocolException("URI does not specify a valid host name: " + uri);
            }
        }
        return httpHost;
    }

    public CloseableHttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
        return execute(httpUriRequest, (HttpContext) null);
    }

    public CloseableHttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
        return doExecute(httpHost, httpRequest, (HttpContext) null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(httpUriRequest, (ResponseHandler) responseHandler, null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return execute(determineTarget(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, responseHandler, null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        Args.notNull(responseHandler, "Response handler");
        HttpResponse execute = execute(httpHost, httpRequest, httpContext);
        try {
            T handleResponse = responseHandler.handleResponse(execute);
            EntityUtils.consume(execute.getEntity());
            return handleResponse;
        } catch (Throwable e) {
            try {
                EntityUtils.consume(execute.getEntity());
            } catch (Throwable e2) {
                this.log.warn("Error consuming content after an exception.", e2);
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            } else if (e instanceof IOException) {
                throw ((IOException) e);
            } else {
                throw new UndeclaredThrowableException(e);
            }
        }
    }
}
