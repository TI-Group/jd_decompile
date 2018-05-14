package org.apache.http.client.methods;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class HttpOptions extends HttpRequestBase {
    public static final String METHOD_NAME = "OPTIONS";

    public HttpOptions(URI uri) {
        setURI(uri);
    }

    public HttpOptions(String str) {
        setURI(URI.create(str));
    }

    public String getMethod() {
        return METHOD_NAME;
    }

    public Set<String> getAllowedMethods(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        HeaderIterator headerIterator = httpResponse.headerIterator(HttpHeaders.ALLOW);
        Set<String> hashSet = new HashSet();
        while (headerIterator.hasNext()) {
            for (HeaderElement name : headerIterator.nextHeader().getElements()) {
                hashSet.add(name.getName());
            }
        }
        return hashSet;
    }
}
