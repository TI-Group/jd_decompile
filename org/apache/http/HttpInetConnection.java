package org.apache.http;

import java.net.InetAddress;

/* compiled from: TbsSdkJava */
public interface HttpInetConnection extends HttpConnection {
    InetAddress getLocalAddress();

    int getLocalPort();

    InetAddress getRemoteAddress();

    int getRemotePort();
}
