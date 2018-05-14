package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpVersion;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    @Deprecated
    /* compiled from: TbsSdkJava */
    private static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httpRequestHandlerResolver) {
            this.resolver = httpRequestHandlerResolver;
        }

        public HttpRequestHandler lookup(HttpRequest httpRequest) {
            return this.resolver.lookup(httpRequest.getRequestLine().getUri());
        }
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), httpExpectationVerifier);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), null);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper, HttpExpectationVerifier httpExpectationVerifier) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        if (connectionReuseStrategy == null) {
            connectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
        }
        this.connStrategy = connectionReuseStrategy;
        if (httpResponseFactory == null) {
            httpResponseFactory = DefaultHttpResponseFactory.INSTANCE;
        }
        this.responseFactory = httpResponseFactory;
        this.handlerMapper = httpRequestHandlerMapper;
        this.expectationVerifier = httpExpectationVerifier;
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerMapper, null);
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, null, null, httpRequestHandlerMapper, null);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor httpProcessor) {
        Args.notNull(httpProcessor, "HTTP processor");
        this.processor = httpProcessor;
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        this.connStrategy = connectionReuseStrategy;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver);
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    public void handleRequest(HttpServerConnection httpServerConnection, HttpContext httpContext) throws IOException, HttpException {
        HttpResponse newHttpResponse;
        httpContext.setAttribute("http.connection", httpServerConnection);
        try {
            HttpRequest receiveRequestHeader = httpServerConnection.receiveRequestHeader();
            if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                if (((HttpEntityEnclosingRequest) receiveRequestHeader).expectContinue()) {
                    newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, httpContext);
                    if (this.expectationVerifier != null) {
                        try {
                            this.expectationVerifier.verify(receiveRequestHeader, newHttpResponse, httpContext);
                        } catch (HttpException e) {
                            HttpResponse newHttpResponse2 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
                            handleException(e, newHttpResponse2);
                            newHttpResponse = newHttpResponse2;
                        }
                    }
                    if (newHttpResponse.getStatusLine().getStatusCode() < 200) {
                        httpServerConnection.sendResponseHeader(newHttpResponse);
                        httpServerConnection.flush();
                        httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) receiveRequestHeader);
                        newHttpResponse = null;
                    }
                    httpContext.setAttribute("http.request", receiveRequestHeader);
                    if (newHttpResponse == null) {
                        newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, httpContext);
                        this.processor.process(receiveRequestHeader, httpContext);
                        doService(receiveRequestHeader, newHttpResponse, httpContext);
                    }
                    if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                        EntityUtils.consume(((HttpEntityEnclosingRequest) receiveRequestHeader).getEntity());
                    }
                    httpContext.setAttribute("http.response", newHttpResponse);
                    this.processor.process(newHttpResponse, httpContext);
                    httpServerConnection.sendResponseHeader(newHttpResponse);
                    httpServerConnection.sendResponseEntity(newHttpResponse);
                    httpServerConnection.flush();
                    if (!this.connStrategy.keepAlive(newHttpResponse, httpContext)) {
                        httpServerConnection.close();
                    }
                }
                httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) receiveRequestHeader);
            }
            newHttpResponse = null;
            httpContext.setAttribute("http.request", receiveRequestHeader);
            if (newHttpResponse == null) {
                newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, httpContext);
                this.processor.process(receiveRequestHeader, httpContext);
                doService(receiveRequestHeader, newHttpResponse, httpContext);
            }
            if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                EntityUtils.consume(((HttpEntityEnclosingRequest) receiveRequestHeader).getEntity());
            }
        } catch (HttpException e2) {
            HttpException httpException = e2;
            newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
            handleException(httpException, newHttpResponse);
        }
        httpContext.setAttribute("http.response", newHttpResponse);
        this.processor.process(newHttpResponse, httpContext);
        httpServerConnection.sendResponseHeader(newHttpResponse);
        httpServerConnection.sendResponseEntity(newHttpResponse);
        httpServerConnection.flush();
        if (!this.connStrategy.keepAlive(newHttpResponse, httpContext)) {
            httpServerConnection.close();
        }
    }

    protected void handleException(HttpException httpException, HttpResponse httpResponse) {
        if (httpException instanceof MethodNotSupportedException) {
            httpResponse.setStatusCode(501);
        } else if (httpException instanceof UnsupportedHttpVersionException) {
            httpResponse.setStatusCode(505);
        } else if (httpException instanceof ProtocolException) {
            httpResponse.setStatusCode(400);
        } else {
            httpResponse.setStatusCode(500);
        }
        String message = httpException.getMessage();
        if (message == null) {
            message = httpException.toString();
        }
        HttpEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(message));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    protected void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRequestHandler httpRequestHandler = null;
        if (this.handlerMapper != null) {
            httpRequestHandler = this.handlerMapper.lookup(httpRequest);
        }
        if (httpRequestHandler != null) {
            httpRequestHandler.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(501);
        }
    }
}
