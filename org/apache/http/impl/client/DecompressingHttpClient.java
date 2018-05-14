package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

@Deprecated
/* compiled from: TbsSdkJava */
public class DecompressingHttpClient implements HttpClient {
    private final HttpRequestInterceptor acceptEncodingInterceptor;
    private final HttpClient backend;
    private final HttpResponseInterceptor contentEncodingInterceptor;

    public DecompressingHttpClient() {
        this(new DefaultHttpClient());
    }

    public DecompressingHttpClient(HttpClient httpClient) {
        this(httpClient, new RequestAcceptEncoding(), new ResponseContentEncoding());
    }

    DecompressingHttpClient(HttpClient httpClient, HttpRequestInterceptor httpRequestInterceptor, HttpResponseInterceptor httpResponseInterceptor) {
        this.backend = httpClient;
        this.acceptEncodingInterceptor = httpRequestInterceptor;
        this.contentEncodingInterceptor = httpResponseInterceptor;
    }

    public HttpParams getParams() {
        return this.backend.getParams();
    }

    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), (HttpRequest) httpUriRequest, (HttpContext) null);
    }

    public HttpClient getHttpClient() {
        return this.backend;
    }

    HttpHost getHttpHost(HttpUriRequest httpUriRequest) {
        return URIUtils.extractHost(httpUriRequest.getURI());
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), (HttpRequest) httpUriRequest, httpContext);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        HttpResponse execute;
        if (httpContext == null) {
            httpContext = new BasicHttpContext();
        }
        try {
            HttpRequest entityEnclosingRequestWrapper;
            if (httpRequest instanceof HttpEntityEnclosingRequest) {
                entityEnclosingRequestWrapper = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest);
            } else {
                entityEnclosingRequestWrapper = new RequestWrapper(httpRequest);
            }
            this.acceptEncodingInterceptor.process(entityEnclosingRequestWrapper, httpContext);
            execute = this.backend.execute(httpHost, entityEnclosingRequestWrapper, httpContext);
            this.contentEncodingInterceptor.process(execute, httpContext);
            if (Boolean.TRUE.equals(httpContext.getAttribute(ResponseContentEncoding.UNCOMPRESSED))) {
                execute.removeHeaders("Content-Length");
                execute.removeHeaders("Content-Encoding");
                execute.removeHeaders(HttpHeaders.CONTENT_MD5);
            }
            return execute;
        } catch (HttpException e) {
            EntityUtils.consume(execute.getEntity());
            throw e;
        } catch (IOException e2) {
            EntityUtils.consume(execute.getEntity());
            throw e2;
        } catch (RuntimeException e3) {
            EntityUtils.consume(execute.getEntity());
            throw e3;
        } catch (Throwable e4) {
            throw new ClientProtocolException(e4);
        }
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), (HttpRequest) httpUriRequest, (ResponseHandler) responseHandler);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return execute(getHttpHost(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, responseHandler, null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        HttpResponse execute = execute(httpHost, httpRequest, httpContext);
        try {
            T handleResponse = responseHandler.handleResponse(execute);
            return handleResponse;
        } finally {
            HttpEntity entity = execute.getEntity();
            if (entity != null) {
                EntityUtils.consume(entity);
            }
        }
    }
}
