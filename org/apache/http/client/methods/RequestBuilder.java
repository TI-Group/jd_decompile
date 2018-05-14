package org.apache.http.client.methods;

import cn.jiguang.net.HttpUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.HeaderGroup;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class RequestBuilder {
    private RequestConfig config;
    private HttpEntity entity;
    private HeaderGroup headergroup;
    private String method;
    private LinkedList<NameValuePair> parameters;
    private URI uri;
    private ProtocolVersion version;

    /* compiled from: TbsSdkJava */
    static class InternalEntityEclosingRequest extends HttpEntityEnclosingRequestBase {
        private final String method;

        InternalEntityEclosingRequest(String str) {
            this.method = str;
        }

        public String getMethod() {
            return this.method;
        }
    }

    /* compiled from: TbsSdkJava */
    static class InternalRequest extends HttpRequestBase {
        private final String method;

        InternalRequest(String str) {
            this.method = str;
        }

        public String getMethod() {
            return this.method;
        }
    }

    RequestBuilder(String str) {
        this.method = str;
    }

    RequestBuilder() {
        this(null);
    }

    public static RequestBuilder create(String str) {
        Args.notBlank(str, "HTTP method");
        return new RequestBuilder(str);
    }

    public static RequestBuilder get() {
        return new RequestBuilder("GET");
    }

    public static RequestBuilder head() {
        return new RequestBuilder(HttpHead.METHOD_NAME);
    }

    public static RequestBuilder post() {
        return new RequestBuilder("POST");
    }

    public static RequestBuilder put() {
        return new RequestBuilder(HttpPut.METHOD_NAME);
    }

    public static RequestBuilder delete() {
        return new RequestBuilder(HttpDelete.METHOD_NAME);
    }

    public static RequestBuilder trace() {
        return new RequestBuilder(HttpTrace.METHOD_NAME);
    }

    public static RequestBuilder options() {
        return new RequestBuilder(HttpOptions.METHOD_NAME);
    }

    public static RequestBuilder copy(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        return new RequestBuilder().doCopy(httpRequest);
    }

    private RequestBuilder doCopy(HttpRequest httpRequest) {
        if (httpRequest != null) {
            this.method = httpRequest.getRequestLine().getMethod();
            this.version = httpRequest.getRequestLine().getProtocolVersion();
            if (httpRequest instanceof HttpUriRequest) {
                this.uri = ((HttpUriRequest) httpRequest).getURI();
            } else {
                this.uri = URI.create(httpRequest.getRequestLine().getUri());
            }
            if (this.headergroup == null) {
                this.headergroup = new HeaderGroup();
            }
            this.headergroup.clear();
            this.headergroup.setHeaders(httpRequest.getAllHeaders());
            if (httpRequest instanceof HttpEntityEnclosingRequest) {
                this.entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            } else {
                this.entity = null;
            }
            if (httpRequest instanceof Configurable) {
                this.config = ((Configurable) httpRequest).getConfig();
            } else {
                this.config = null;
            }
            this.parameters = null;
        }
        return this;
    }

    public String getMethod() {
        return this.method;
    }

    public ProtocolVersion getVersion() {
        return this.version;
    }

    public RequestBuilder setVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
        return this;
    }

    public URI getUri() {
        return this.uri;
    }

    public RequestBuilder setUri(URI uri) {
        this.uri = uri;
        return this;
    }

    public RequestBuilder setUri(String str) {
        this.uri = str != null ? URI.create(str) : null;
        return this;
    }

    public Header getFirstHeader(String str) {
        return this.headergroup != null ? this.headergroup.getFirstHeader(str) : null;
    }

    public Header getLastHeader(String str) {
        return this.headergroup != null ? this.headergroup.getLastHeader(str) : null;
    }

    public Header[] getHeaders(String str) {
        return this.headergroup != null ? this.headergroup.getHeaders(str) : null;
    }

    public RequestBuilder addHeader(Header header) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.addHeader(header);
        return this;
    }

    public RequestBuilder addHeader(String str, String str2) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.addHeader(new BasicHeader(str, str2));
        return this;
    }

    public RequestBuilder removeHeader(Header header) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.removeHeader(header);
        return this;
    }

    public RequestBuilder removeHeaders(String str) {
        if (!(str == null || this.headergroup == null)) {
            HeaderIterator it = this.headergroup.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.nextHeader().getName())) {
                    it.remove();
                }
            }
        }
        return this;
    }

    public RequestBuilder setHeader(Header header) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.updateHeader(header);
        return this;
    }

    public RequestBuilder setHeader(String str, String str2) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.updateHeader(new BasicHeader(str, str2));
        return this;
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public RequestBuilder setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
        return this;
    }

    public List<NameValuePair> getParameters() {
        return this.parameters != null ? new ArrayList(this.parameters) : new ArrayList();
    }

    public RequestBuilder addParameter(NameValuePair nameValuePair) {
        Args.notNull(nameValuePair, "Name value pair");
        if (this.parameters == null) {
            this.parameters = new LinkedList();
        }
        this.parameters.add(nameValuePair);
        return this;
    }

    public RequestBuilder addParameter(String str, String str2) {
        return addParameter(new BasicNameValuePair(str, str2));
    }

    public RequestBuilder addParameters(NameValuePair... nameValuePairArr) {
        for (NameValuePair addParameter : nameValuePairArr) {
            addParameter(addParameter);
        }
        return this;
    }

    public RequestConfig getConfig() {
        return this.config;
    }

    public RequestBuilder setConfig(RequestConfig requestConfig) {
        this.config = requestConfig;
        return this;
    }

    public HttpUriRequest build() {
        URI uri;
        HttpUriRequest internalRequest;
        URI create = this.uri != null ? this.uri : URI.create(HttpUtils.PATHS_SEPARATOR);
        HttpEntity httpEntity = this.entity;
        if (this.parameters == null || this.parameters.isEmpty()) {
            uri = create;
        } else if (httpEntity == null && ("POST".equalsIgnoreCase(this.method) || HttpPut.METHOD_NAME.equalsIgnoreCase(this.method))) {
            httpEntity = new UrlEncodedFormEntity(this.parameters, HTTP.DEF_CONTENT_CHARSET);
            uri = create;
        } else {
            try {
                uri = new URIBuilder(create).addParameters(this.parameters).build();
            } catch (URISyntaxException e) {
                uri = create;
            }
        }
        if (httpEntity == null) {
            internalRequest = new InternalRequest(this.method);
        } else {
            internalRequest = new InternalEntityEclosingRequest(this.method);
            internalRequest.setEntity(httpEntity);
        }
        internalRequest.setProtocolVersion(this.version);
        internalRequest.setURI(uri);
        if (this.headergroup != null) {
            internalRequest.setHeaders(this.headergroup.getAllHeaders());
        }
        internalRequest.setConfig(this.config);
        return internalRequest;
    }
}
