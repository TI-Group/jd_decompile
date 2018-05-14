package org.apache.http.conn;

import org.apache.http.HttpHost;

/* compiled from: TbsSdkJava */
public interface SchemePortResolver {
    int resolve(HttpHost httpHost) throws UnsupportedSchemeException;
}
