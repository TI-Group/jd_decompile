package org.apache.http.conn.params;

import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
/* compiled from: TbsSdkJava */
public class ConnConnectionParamBean extends HttpAbstractParamBean {
    public ConnConnectionParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    @Deprecated
    public void setMaxStatusLineGarbage(int i) {
        this.params.setIntParameter(ConnConnectionPNames.MAX_STATUS_LINE_GARBAGE, i);
    }
}
