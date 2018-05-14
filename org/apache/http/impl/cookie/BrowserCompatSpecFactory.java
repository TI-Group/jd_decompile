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
public class BrowserCompatSpecFactory implements CookieSpecFactory, CookieSpecProvider {
    private final String[] datepatterns;
    private final SecurityLevel securityLevel;

    /* compiled from: TbsSdkJava */
    public enum SecurityLevel {
        SECURITYLEVEL_DEFAULT,
        SECURITYLEVEL_IE_MEDIUM
    }

    public BrowserCompatSpecFactory(String[] strArr, SecurityLevel securityLevel) {
        this.datepatterns = strArr;
        this.securityLevel = securityLevel;
    }

    public BrowserCompatSpecFactory(String[] strArr) {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpecFactory() {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public CookieSpec newInstance(HttpParams httpParams) {
        if (httpParams == null) {
            return new BrowserCompatSpec(null, this.securityLevel);
        }
        String[] strArr;
        Collection collection = (Collection) httpParams.getParameter(CookieSpecPNames.DATE_PATTERNS);
        if (collection != null) {
            strArr = (String[]) collection.toArray(new String[collection.size()]);
        } else {
            strArr = null;
        }
        return new BrowserCompatSpec(strArr, this.securityLevel);
    }

    public CookieSpec create(HttpContext httpContext) {
        return new BrowserCompatSpec(this.datepatterns);
    }
}
