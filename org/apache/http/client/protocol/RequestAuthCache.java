package org.apache.http.client.protocol;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.routing.RouteInfo;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class RequestAuthCache implements HttpRequestInterceptor {
    private final Log log = LogFactory.getLog(getClass());

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        AuthCache authCache = adapt.getAuthCache();
        if (authCache == null) {
            this.log.debug("Auth cache not set in the context");
            return;
        }
        CredentialsProvider credentialsProvider = adapt.getCredentialsProvider();
        if (credentialsProvider == null) {
            this.log.debug("Credentials provider not set in the context");
            return;
        }
        RouteInfo httpRoute = adapt.getHttpRoute();
        if (httpRoute == null) {
            this.log.debug("Route info not set in the context");
            return;
        }
        HttpHost targetHost = adapt.getTargetHost();
        if (targetHost == null) {
            this.log.debug("Target host not set in the context");
            return;
        }
        HttpHost httpHost;
        if (targetHost.getPort() < 0) {
            httpHost = new HttpHost(targetHost.getHostName(), httpRoute.getTargetHost().getPort(), targetHost.getSchemeName());
        } else {
            httpHost = targetHost;
        }
        AuthState targetAuthState = adapt.getTargetAuthState();
        if (targetAuthState != null && targetAuthState.getState() == AuthProtocolState.UNCHALLENGED) {
            AuthScheme authScheme = authCache.get(httpHost);
            if (authScheme != null) {
                doPreemptiveAuth(httpHost, authScheme, targetAuthState, credentialsProvider);
            }
        }
        httpHost = httpRoute.getProxyHost();
        targetAuthState = adapt.getProxyAuthState();
        if (httpHost != null && targetAuthState != null && targetAuthState.getState() == AuthProtocolState.UNCHALLENGED) {
            AuthScheme authScheme2 = authCache.get(httpHost);
            if (authScheme2 != null) {
                doPreemptiveAuth(httpHost, authScheme2, targetAuthState, credentialsProvider);
            }
        }
    }

    private void doPreemptiveAuth(HttpHost httpHost, AuthScheme authScheme, AuthState authState, CredentialsProvider credentialsProvider) {
        String schemeName = authScheme.getSchemeName();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Re-using cached '" + schemeName + "' auth scheme for " + httpHost);
        }
        Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost, AuthScope.ANY_REALM, schemeName));
        if (credentials != null) {
            if ("BASIC".equalsIgnoreCase(authScheme.getSchemeName())) {
                authState.setState(AuthProtocolState.CHALLENGED);
            } else {
                authState.setState(AuthProtocolState.SUCCESS);
            }
            authState.update(authScheme, credentials);
            return;
        }
        this.log.debug("No credentials for preemptive authentication");
    }
}
