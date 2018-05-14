package org.apache.http.impl.client;

import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.params.AuthPNames;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
@Deprecated
/* compiled from: TbsSdkJava */
public class DefaultProxyAuthenticationHandler extends AbstractAuthenticationHandler {
    public boolean isAuthenticationRequested(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        return httpResponse.getStatusLine().getStatusCode() == 407;
    }

    public Map<String, Header> getChallenges(HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        Args.notNull(httpResponse, "HTTP response");
        return parseChallenges(httpResponse.getHeaders("Proxy-Authenticate"));
    }

    protected List<String> getAuthPreferences(HttpResponse httpResponse, HttpContext httpContext) {
        List<String> list = (List) httpResponse.getParams().getParameter(AuthPNames.PROXY_AUTH_PREF);
        return list != null ? list : super.getAuthPreferences(httpResponse, httpContext);
    }
}
