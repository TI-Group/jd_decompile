package org.apache.http.impl.auth;

import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.params.HttpParams;

@Deprecated
/* compiled from: TbsSdkJava */
public class NegotiateSchemeFactory implements AuthSchemeFactory {
    private final SpnegoTokenGenerator spengoGenerator;
    private final boolean stripPort;

    public NegotiateSchemeFactory(SpnegoTokenGenerator spnegoTokenGenerator, boolean z) {
        this.spengoGenerator = spnegoTokenGenerator;
        this.stripPort = z;
    }

    public NegotiateSchemeFactory(SpnegoTokenGenerator spnegoTokenGenerator) {
        this(spnegoTokenGenerator, false);
    }

    public NegotiateSchemeFactory() {
        this(null, false);
    }

    public AuthScheme newInstance(HttpParams httpParams) {
        return new NegotiateScheme(this.spengoGenerator, this.stripPort);
    }

    public boolean isStripPort() {
        return this.stripPort;
    }

    public SpnegoTokenGenerator getSpengoGenerator() {
        return this.spengoGenerator;
    }
}
