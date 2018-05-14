package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: TbsSdkJava */
public class IgnoreSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    public CookieSpec newInstance(HttpParams httpParams) {
        return new IgnoreSpec();
    }

    public CookieSpec create(HttpContext httpContext) {
        return new IgnoreSpec();
    }
}
