package org.apache.http.auth;

import java.util.Collection;
import java.util.Queue;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class AuthState {
    private Queue<AuthOption> authOptions;
    private AuthScheme authScheme;
    private AuthScope authScope;
    private Credentials credentials;
    private AuthProtocolState state = AuthProtocolState.UNCHALLENGED;

    public void reset() {
        this.state = AuthProtocolState.UNCHALLENGED;
        this.authOptions = null;
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
    }

    public AuthProtocolState getState() {
        return this.state;
    }

    public void setState(AuthProtocolState authProtocolState) {
        if (authProtocolState == null) {
            authProtocolState = AuthProtocolState.UNCHALLENGED;
        }
        this.state = authProtocolState;
    }

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public void update(AuthScheme authScheme, Credentials credentials) {
        Args.notNull(authScheme, "Auth scheme");
        Args.notNull(credentials, "Credentials");
        this.authScheme = authScheme;
        this.credentials = credentials;
        this.authOptions = null;
    }

    public Queue<AuthOption> getAuthOptions() {
        return this.authOptions;
    }

    public boolean hasAuthOptions() {
        return (this.authOptions == null || this.authOptions.isEmpty()) ? false : true;
    }

    public void update(Queue<AuthOption> queue) {
        Args.notEmpty((Collection) queue, "Queue of auth options");
        this.authOptions = queue;
        this.authScheme = null;
        this.credentials = null;
    }

    @Deprecated
    public void invalidate() {
        reset();
    }

    @Deprecated
    public boolean isValid() {
        return this.authScheme != null;
    }

    @Deprecated
    public void setAuthScheme(AuthScheme authScheme) {
        if (authScheme == null) {
            reset();
        } else {
            this.authScheme = authScheme;
        }
    }

    @Deprecated
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Deprecated
    public AuthScope getAuthScope() {
        return this.authScope;
    }

    @Deprecated
    public void setAuthScope(AuthScope authScope) {
        this.authScope = authScope;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state:").append(this.state).append(";");
        if (this.authScheme != null) {
            stringBuilder.append("auth scheme:").append(this.authScheme.getSchemeName()).append(";");
        }
        if (this.credentials != null) {
            stringBuilder.append("credentials present");
        }
        return stringBuilder.toString();
    }
}
