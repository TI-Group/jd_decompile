package org.apache.http.conn.params;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;

@Deprecated
@ThreadSafe
/* compiled from: TbsSdkJava */
public final class ConnPerRouteBean implements ConnPerRoute {
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;
    private volatile int defaultMax;
    private final ConcurrentHashMap<HttpRoute, Integer> maxPerHostMap;

    public ConnPerRouteBean(int i) {
        this.maxPerHostMap = new ConcurrentHashMap();
        setDefaultMaxPerRoute(i);
    }

    public ConnPerRouteBean() {
        this(2);
    }

    public int getDefaultMax() {
        return this.defaultMax;
    }

    public int getDefaultMaxPerRoute() {
        return this.defaultMax;
    }

    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Defautl max per route");
        this.defaultMax = i;
    }

    public void setMaxForRoute(HttpRoute httpRoute, int i) {
        Args.notNull(httpRoute, "HTTP route");
        Args.positive(i, "Max per route");
        this.maxPerHostMap.put(httpRoute, Integer.valueOf(i));
    }

    public int getMaxForRoute(HttpRoute httpRoute) {
        Args.notNull(httpRoute, "HTTP route");
        Integer num = (Integer) this.maxPerHostMap.get(httpRoute);
        if (num != null) {
            return num.intValue();
        }
        return this.defaultMax;
    }

    public void setMaxForRoutes(Map<HttpRoute, Integer> map) {
        if (map != null) {
            this.maxPerHostMap.clear();
            this.maxPerHostMap.putAll(map);
        }
    }

    public String toString() {
        return this.maxPerHostMap.toString();
    }
}
