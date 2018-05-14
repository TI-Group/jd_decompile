package org.apache.http.auth;

import org.apache.http.params.HttpParams;

@Deprecated
/* compiled from: TbsSdkJava */
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
