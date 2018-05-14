package org.apache.http.protocol;

import cn.jiguang.net.HttpUtils;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@ThreadSafe
/* compiled from: TbsSdkJava */
public class UriHttpRequestHandlerMapper implements HttpRequestHandlerMapper {
    private final UriPatternMatcher<HttpRequestHandler> matcher;

    protected UriHttpRequestHandlerMapper(UriPatternMatcher<HttpRequestHandler> uriPatternMatcher) {
        this.matcher = (UriPatternMatcher) Args.notNull(uriPatternMatcher, "Pattern matcher");
    }

    public UriHttpRequestHandlerMapper() {
        this(new UriPatternMatcher());
    }

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        Args.notNull(str, "Pattern");
        Args.notNull(httpRequestHandler, "Handler");
        this.matcher.register(str, httpRequestHandler);
    }

    public void unregister(String str) {
        this.matcher.unregister(str);
    }

    protected String getRequestPath(HttpRequest httpRequest) {
        String uri = httpRequest.getRequestLine().getUri();
        int indexOf = uri.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR);
        if (indexOf != -1) {
            return uri.substring(0, indexOf);
        }
        indexOf = uri.indexOf("#");
        if (indexOf != -1) {
            return uri.substring(0, indexOf);
        }
        return uri;
    }

    public HttpRequestHandler lookup(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        return (HttpRequestHandler) this.matcher.lookup(getRequestPath(httpRequest));
    }
}
