package org.apache.http.auth;

import org.apache.http.protocol.HttpContext;

/* compiled from: TbsSdkJava */
public interface AuthSchemeProvider {
    AuthScheme create(HttpContext httpContext);
}
