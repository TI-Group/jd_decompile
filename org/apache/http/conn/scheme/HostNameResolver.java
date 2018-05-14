package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;

@Deprecated
/* compiled from: TbsSdkJava */
public interface HostNameResolver {
    InetAddress resolve(String str) throws IOException;
}
