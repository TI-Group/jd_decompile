package org.apache.http.impl.auth;

import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: TbsSdkJava */
public class NTLMSchemeFactory implements AuthSchemeFactory, AuthSchemeProvider {
    public AuthScheme newInstance(HttpParams httpParams) {
        return new NTLMScheme();
    }

    public AuthScheme create(HttpContext httpContext) {
        return new NTLMScheme();
    }
}
