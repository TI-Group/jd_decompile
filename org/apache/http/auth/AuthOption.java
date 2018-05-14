package org.apache.http.auth;

import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public final class AuthOption {
    private final AuthScheme authScheme;
    private final Credentials creds;

    public AuthOption(AuthScheme authScheme, Credentials credentials) {
        Args.notNull(authScheme, "Auth scheme");
        Args.notNull(credentials, "User credentials");
        this.authScheme = authScheme;
        this.creds = credentials;
    }

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    public Credentials getCredentials() {
        return this.creds;
    }

    public String toString() {
        return this.authScheme.toString();
    }
}
