package org.apache.http.conn.params;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Immutable
@Deprecated
/* compiled from: TbsSdkJava */
public class ConnRouteParams implements ConnRoutePNames {
    public static final HttpHost NO_HOST = new HttpHost("127.0.0.255", 0, "no-host");
    public static final HttpRoute NO_ROUTE = new HttpRoute(NO_HOST);

    private ConnRouteParams() {
    }

    public static HttpHost getDefaultProxy(HttpParams httpParams) {
        Args.notNull(httpParams, "Parameters");
        HttpHost httpHost = (HttpHost) httpParams.getParameter(ConnRoutePNames.DEFAULT_PROXY);
        if (httpHost == null || !NO_HOST.equals(httpHost)) {
            return httpHost;
        }
        return null;
    }

    public static void setDefaultProxy(HttpParams httpParams, HttpHost httpHost) {
        Args.notNull(httpParams, "Parameters");
        httpParams.setParameter(ConnRoutePNames.DEFAULT_PROXY, httpHost);
    }

    public static HttpRoute getForcedRoute(HttpParams httpParams) {
        Args.notNull(httpParams, "Parameters");
        HttpRoute httpRoute = (HttpRoute) httpParams.getParameter(ConnRoutePNames.FORCED_ROUTE);
        if (httpRoute == null || !NO_ROUTE.equals(httpRoute)) {
            return httpRoute;
        }
        return null;
    }

    public static void setForcedRoute(HttpParams httpParams, HttpRoute httpRoute) {
        Args.notNull(httpParams, "Parameters");
        httpParams.setParameter(ConnRoutePNames.FORCED_ROUTE, httpRoute);
    }

    public static InetAddress getLocalAddress(HttpParams httpParams) {
        Args.notNull(httpParams, "Parameters");
        return (InetAddress) httpParams.getParameter(ConnRoutePNames.LOCAL_ADDRESS);
    }

    public static void setLocalAddress(HttpParams httpParams, InetAddress inetAddress) {
        Args.notNull(httpParams, "Parameters");
        httpParams.setParameter(ConnRoutePNames.LOCAL_ADDRESS, inetAddress);
    }
}
