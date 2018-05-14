package org.apache.http.client.params;

import java.net.InetAddress;
import java.util.Collection;
import org.apache.http.HttpHost;
import org.apache.http.auth.params.AuthPNames;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;

@Deprecated
/* compiled from: TbsSdkJava */
public final class HttpClientParamConfig {
    private HttpClientParamConfig() {
    }

    public static RequestConfig getRequestConfig(HttpParams httpParams) {
        return RequestConfig.custom().setSocketTimeout(httpParams.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0)).setStaleConnectionCheckEnabled(httpParams.getBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true)).setConnectTimeout(httpParams.getIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 0)).setExpectContinueEnabled(httpParams.getBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false)).setProxy((HttpHost) httpParams.getParameter(ConnRoutePNames.DEFAULT_PROXY)).setLocalAddress((InetAddress) httpParams.getParameter(ConnRoutePNames.LOCAL_ADDRESS)).setProxyPreferredAuthSchemes((Collection) httpParams.getParameter(AuthPNames.PROXY_AUTH_PREF)).setTargetPreferredAuthSchemes((Collection) httpParams.getParameter(AuthPNames.TARGET_AUTH_PREF)).setAuthenticationEnabled(httpParams.getBooleanParameter(ClientPNames.HANDLE_AUTHENTICATION, true)).setCircularRedirectsAllowed(httpParams.getBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, false)).setConnectionRequestTimeout((int) httpParams.getLongParameter("http.conn-manager.timeout", 0)).setCookieSpec((String) httpParams.getParameter(ClientPNames.COOKIE_POLICY)).setMaxRedirects(httpParams.getIntParameter(ClientPNames.MAX_REDIRECTS, 50)).setRedirectsEnabled(httpParams.getBooleanParameter(ClientPNames.HANDLE_REDIRECTS, true)).setRelativeRedirectsAllowed(!httpParams.getBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, false)).build();
    }
}
