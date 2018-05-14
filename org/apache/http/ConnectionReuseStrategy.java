package org.apache.http;

import org.apache.http.protocol.HttpContext;

/* compiled from: TbsSdkJava */
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext);
}
