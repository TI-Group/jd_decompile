package org.apache.http.conn.params;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@NotThreadSafe
@Deprecated
/* compiled from: TbsSdkJava */
public class ConnRouteParamBean extends HttpAbstractParamBean {
    public ConnRouteParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setDefaultProxy(HttpHost httpHost) {
        this.params.setParameter(ConnRoutePNames.DEFAULT_PROXY, httpHost);
    }

    public void setLocalAddress(InetAddress inetAddress) {
        this.params.setParameter(ConnRoutePNames.LOCAL_ADDRESS, inetAddress);
    }

    public void setForcedRoute(HttpRoute httpRoute) {
        this.params.setParameter(ConnRoutePNames.FORCED_ROUTE, httpRoute);
    }
}
