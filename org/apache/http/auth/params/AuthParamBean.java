package org.apache.http.auth.params;

import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
/* compiled from: TbsSdkJava */
public class AuthParamBean extends HttpAbstractParamBean {
    public AuthParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setCredentialCharset(String str) {
        AuthParams.setCredentialCharset(this.params, str);
    }
}
