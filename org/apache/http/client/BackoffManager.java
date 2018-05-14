package org.apache.http.client;

import org.apache.http.conn.routing.HttpRoute;

/* compiled from: TbsSdkJava */
public interface BackoffManager {
    void backOff(HttpRoute httpRoute);

    void probe(HttpRoute httpRoute);
}
