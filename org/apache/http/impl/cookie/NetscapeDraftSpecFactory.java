package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: TbsSdkJava */
public class NetscapeDraftSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    private final String[] datepatterns;

    public NetscapeDraftSpecFactory(String[] strArr) {
        this.datepatterns = strArr;
    }

    public NetscapeDraftSpecFactory() {
        this(null);
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams == null) {
            return new NetscapeDraftSpec();
        }
        String[] strArr;
        Collection collection = (Collection) httpParams.getParameter(CookieSpecPNames.DATE_PATTERNS);
        if (collection != null) {
            strArr = (String[]) collection.toArray(new String[collection.size()]);
        } else {
            strArr = null;
        }
        return new NetscapeDraftSpec(strArr);
    }

    public CookieSpec create(HttpContext httpContext) {
        return new NetscapeDraftSpec(this.datepatterns);
    }
}
