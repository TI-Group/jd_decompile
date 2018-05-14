package org.apache.http.impl.auth;

import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: TbsSdkJava */
public class KerberosSchemeFactory implements AuthSchemeFactory, AuthSchemeProvider {
    private final boolean stripPort;

    public KerberosSchemeFactory(boolean z) {
        this.stripPort = z;
    }

    public KerberosSchemeFactory() {
        this(false);
    }

    public boolean isStripPort() {
        return this.stripPort;
    }

    public AuthScheme newInstance(HttpParams httpParams) {
        return new KerberosScheme(this.stripPort);
    }

    public AuthScheme create(HttpContext httpContext) {
        return new KerberosScheme(this.stripPort);
    }
}
