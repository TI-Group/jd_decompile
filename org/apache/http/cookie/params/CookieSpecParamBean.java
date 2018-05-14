package org.apache.http.cookie.params;

import java.util.Collection;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@NotThreadSafe
@Deprecated
/* compiled from: TbsSdkJava */
public class CookieSpecParamBean extends HttpAbstractParamBean {
    public CookieSpecParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setDatePatterns(Collection<String> collection) {
        this.params.setParameter(CookieSpecPNames.DATE_PATTERNS, collection);
    }

    public void setSingleHeader(boolean z) {
        this.params.setBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, z);
    }
}
