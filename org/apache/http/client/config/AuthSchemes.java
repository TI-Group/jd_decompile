package org.apache.http.client.config;

import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public final class AuthSchemes {
    public static final String BASIC = "Basic";
    public static final String DIGEST = "Digest";
    public static final String KERBEROS = "Kerberos";
    public static final String NTLM = "NTLM";
    public static final String SPNEGO = "negotiate";

    private AuthSchemes() {
    }
}
