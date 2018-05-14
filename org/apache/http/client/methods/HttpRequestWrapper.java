package org.apache.http.client.methods;

import cn.jiguang.net.HttpUtils;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class HttpRequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    private final String method;
    private final HttpRequest original;
    private URI uri;
    private ProtocolVersion version;

    /* compiled from: TbsSdkJava */
    static class HttpEntityEnclosingRequestWrapper extends HttpRequestWrapper implements HttpEntityEnclosingRequest {
        private HttpEntity entity;

        public HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
            super(httpEntityEnclosingRequest);
            this.entity = httpEntityEnclosingRequest.getEntity();
        }

        public HttpEntity getEntity() {
            return this.entity;
        }

        public void setEntity(HttpEntity httpEntity) {
            this.entity = httpEntity;
        }

        public boolean expectContinue() {
            Header firstHeader = getFirstHeader("Expect");
            return firstHeader != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(firstHeader.getValue());
        }
    }

    private HttpRequestWrapper(HttpRequest httpRequest) {
        this.original = httpRequest;
        this.version = this.original.getRequestLine().getProtocolVersion();
        this.method = this.original.getRequestLine().getMethod();
        if (httpRequest instanceof HttpUriRequest) {
            this.uri = ((HttpUriRequest) httpRequest).getURI();
        } else {
            this.uri = null;
        }
        setHeaders(httpRequest.getAllHeaders());
    }

    public ProtocolVersion getProtocolVersion() {
        return this.version != null ? this.version : this.original.getProtocolVersion();
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    public URI getURI() {
        return this.uri;
    }

    public void setURI(URI uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return this.method;
    }

    public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public boolean isAborted() {
        return false;
    }

    public RequestLine getRequestLine() {
        String toASCIIString;
        if (this.uri != null) {
            toASCIIString = this.uri.toASCIIString();
        } else {
            toASCIIString = this.original.getRequestLine().getUri();
        }
        if (toASCIIString == null || toASCIIString.length() == 0) {
            toASCIIString = HttpUtils.PATHS_SEPARATOR;
        }
        return new BasicRequestLine(this.method, toASCIIString, getProtocolVersion());
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    public String toString() {
        return getRequestLine() + " " + this.headergroup;
    }

    public static HttpRequestWrapper wrap(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return null;
        }
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            return new HttpEntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest);
        }
        return new HttpRequestWrapper(httpRequest);
    }

    @Deprecated
    public HttpParams getParams() {
        if (this.params == null) {
            this.params = this.original.getParams().copy();
        }
        return this.params;
    }
}
