package org.apache.http.impl.client;

import java.security.Principal;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpConnection;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: TbsSdkJava */
public class DefaultUserTokenHandler implements UserTokenHandler {
    public static final DefaultUserTokenHandler INSTANCE = new DefaultUserTokenHandler();

    public Object getUserToken(HttpContext httpContext) {
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        Principal principal = null;
        AuthState targetAuthState = adapt.getTargetAuthState();
        if (targetAuthState != null) {
            principal = getAuthPrincipal(targetAuthState);
            if (principal == null) {
                principal = getAuthPrincipal(adapt.getProxyAuthState());
            }
        }
        if (principal == null) {
            HttpConnection connection = adapt.getConnection();
            if (connection.isOpen() && (connection instanceof ManagedHttpClientConnection)) {
                SSLSession sSLSession = ((ManagedHttpClientConnection) connection).getSSLSession();
                if (sSLSession != null) {
                    return sSLSession.getLocalPrincipal();
                }
            }
        }
        return principal;
    }

    private static Principal getAuthPrincipal(AuthState authState) {
        AuthScheme authScheme = authState.getAuthScheme();
        if (authScheme != null && authScheme.isComplete() && authScheme.isConnectionBased()) {
            Credentials credentials = authState.getCredentials();
            if (credentials != null) {
                return credentials.getUserPrincipal();
            }
        }
        return null;
    }
}
