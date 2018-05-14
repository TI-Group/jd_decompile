package org.apache.http.conn;

import org.apache.http.HttpConnection;
import org.apache.http.config.ConnectionConfig;

/* compiled from: TbsSdkJava */
public interface HttpConnectionFactory<T, C extends HttpConnection> {
    C create(T t, ConnectionConfig connectionConfig);
}
