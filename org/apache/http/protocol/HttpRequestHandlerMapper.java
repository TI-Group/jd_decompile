package org.apache.http.protocol;

import org.apache.http.HttpRequest;

/* compiled from: TbsSdkJava */
public interface HttpRequestHandlerMapper {
    HttpRequestHandler lookup(HttpRequest httpRequest);
}
