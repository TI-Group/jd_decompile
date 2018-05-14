package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class RequestExpectContinue implements HttpRequestInterceptor {
    private final boolean activeByDefault;

    @Deprecated
    public RequestExpectContinue() {
        this(false);
    }

    public RequestExpectContinue(boolean z) {
        this.activeByDefault = z;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.containsHeader("Expect") && (httpRequest instanceof HttpEntityEnclosingRequest)) {
            ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity != null && entity.getContentLength() != 0 && !protocolVersion.lessEquals(HttpVersion.HTTP_1_0) && httpRequest.getParams().getBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, this.activeByDefault)) {
                httpRequest.addHeader("Expect", HTTP.EXPECT_CONTINUE);
            }
        }
    }
}
