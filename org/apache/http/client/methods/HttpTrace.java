package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class HttpTrace extends HttpRequestBase {
    public static final String METHOD_NAME = "TRACE";

    public HttpTrace(URI uri) {
        setURI(uri);
    }

    public HttpTrace(String str) {
        setURI(URI.create(str));
    }

    public String getMethod() {
        return METHOD_NAME;
    }
}
