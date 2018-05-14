package org.apache.http.params;

import org.apache.http.HttpVersion;

@Deprecated
/* compiled from: TbsSdkJava */
public class HttpProtocolParamBean extends HttpAbstractParamBean {
    public HttpProtocolParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setHttpElementCharset(String str) {
        HttpProtocolParams.setHttpElementCharset(this.params, str);
    }

    public void setContentCharset(String str) {
        HttpProtocolParams.setContentCharset(this.params, str);
    }

    public void setVersion(HttpVersion httpVersion) {
        HttpProtocolParams.setVersion(this.params, httpVersion);
    }

    public void setUserAgent(String str) {
        HttpProtocolParams.setUserAgent(this.params, str);
    }

    public void setUseExpectContinue(boolean z) {
        HttpProtocolParams.setUseExpectContinue(this.params, z);
    }
}
