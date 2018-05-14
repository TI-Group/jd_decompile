package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class HttpDelete extends HttpRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public HttpDelete(URI uri) {
        setURI(uri);
    }

    public HttpDelete(String str) {
        setURI(URI.create(str));
    }

    public String getMethod() {
        return METHOD_NAME;
    }
}
