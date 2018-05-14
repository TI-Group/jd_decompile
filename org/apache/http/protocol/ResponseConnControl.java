package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class ResponseConnControl implements HttpResponseInterceptor {
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        HttpCoreContext adapt = HttpCoreContext.adapt(httpContext);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 400 || statusCode == 408 || statusCode == 411 || statusCode == 413 || statusCode == 414 || statusCode == 503 || statusCode == 501) {
            httpResponse.setHeader("Connection", HTTP.CONN_CLOSE);
            return;
        }
        Header firstHeader = httpResponse.getFirstHeader("Connection");
        if (firstHeader == null || !HTTP.CONN_CLOSE.equalsIgnoreCase(firstHeader.getValue())) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
                if (entity.getContentLength() < 0 && (!entity.isChunked() || protocolVersion.lessEquals(HttpVersion.HTTP_1_0))) {
                    httpResponse.setHeader("Connection", HTTP.CONN_CLOSE);
                    return;
                }
            }
            HttpRequest request = adapt.getRequest();
            if (request != null) {
                firstHeader = request.getFirstHeader("Connection");
                if (firstHeader != null) {
                    httpResponse.setHeader("Connection", firstHeader.getValue());
                } else if (request.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    httpResponse.setHeader("Connection", HTTP.CONN_CLOSE);
                }
            }
        }
    }
}
