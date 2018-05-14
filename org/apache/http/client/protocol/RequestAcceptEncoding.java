package org.apache.http.client.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: TbsSdkJava */
public class RequestAcceptEncoding implements HttpRequestInterceptor {
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        if (!httpRequest.containsHeader(HttpHeaders.ACCEPT_ENCODING)) {
            httpRequest.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip,deflate");
        }
    }
}
