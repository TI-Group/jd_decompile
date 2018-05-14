package org.apache.http.client.methods;

import cn.jiguang.net.HttpUtils;
import java.net.URI;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.params.HttpProtocolParams;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public abstract class HttpRequestBase extends AbstractExecutionAwareRequest implements Configurable, HttpUriRequest {
    private RequestConfig config;
    private URI uri;
    private ProtocolVersion version;

    public abstract String getMethod();

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.version != null ? this.version : HttpProtocolParams.getVersion(getParams());
    }

    public URI getURI() {
        return this.uri;
    }

    public RequestLine getRequestLine() {
        String method = getMethod();
        ProtocolVersion protocolVersion = getProtocolVersion();
        URI uri = getURI();
        String str = null;
        if (uri != null) {
            str = uri.toASCIIString();
        }
        if (str == null || str.length() == 0) {
            str = HttpUtils.PATHS_SEPARATOR;
        }
        return new BasicRequestLine(method, str, protocolVersion);
    }

    public RequestConfig getConfig() {
        return this.config;
    }

    public void setConfig(RequestConfig requestConfig) {
        this.config = requestConfig;
    }

    public void setURI(URI uri) {
        this.uri = uri;
    }

    public void started() {
    }

    public void releaseConnection() {
        reset();
    }

    public String toString() {
        return getMethod() + " " + getURI() + " " + getProtocolVersion();
    }
}
