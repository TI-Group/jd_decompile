package org.apache.http.conn.params;

import org.apache.http.conn.routing.HttpRoute;

@Deprecated
/* compiled from: TbsSdkJava */
public interface ConnPerRoute {
    int getMaxForRoute(HttpRoute httpRoute);
}
