package org.apache.http.auth.params;

import org.apache.http.annotation.Immutable;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

@Immutable
@Deprecated
/* compiled from: TbsSdkJava */
public final class AuthParams {
    private AuthParams() {
    }

    public static String getCredentialCharset(HttpParams httpParams) {
        Args.notNull(httpParams, "HTTP parameters");
        String str = (String) httpParams.getParameter(AuthPNames.CREDENTIAL_CHARSET);
        if (str == null) {
            return HTTP.DEF_PROTOCOL_CHARSET.name();
        }
        return str;
    }

    public static void setCredentialCharset(HttpParams httpParams, String str) {
        Args.notNull(httpParams, "HTTP parameters");
        httpParams.setParameter(AuthPNames.CREDENTIAL_CHARSET, str);
    }
}
