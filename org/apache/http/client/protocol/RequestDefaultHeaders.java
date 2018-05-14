package org.apache.http.client.protocol;

import java.io.IOException;
import java.util.Collection;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class RequestDefaultHeaders implements HttpRequestInterceptor {
    private final Collection<? extends Header> defaultHeaders;

    public RequestDefaultHeaders(Collection<? extends Header> collection) {
        this.defaultHeaders = collection;
    }

    public RequestDefaultHeaders() {
        this(null);
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
            Collection collection = (Collection) httpRequest.getParams().getParameter(ClientPNames.DEFAULT_HEADERS);
            if (collection == null) {
                collection = this.defaultHeaders;
            }
            if (r0 != null) {
                for (Header addHeader : r0) {
                    httpRequest.addHeader(addHeader);
                }
            }
        }
    }
}
