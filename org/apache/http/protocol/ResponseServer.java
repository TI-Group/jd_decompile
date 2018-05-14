package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class ResponseServer implements HttpResponseInterceptor {
    private final String originServer;

    public ResponseServer(String str) {
        this.originServer = str;
    }

    public ResponseServer() {
        this(null);
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        if (!httpResponse.containsHeader("Server") && this.originServer != null) {
            httpResponse.addHeader("Server", this.originServer);
        }
    }
}
