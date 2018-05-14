package org.apache.http.conn;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: TbsSdkJava */
public interface DnsResolver {
    InetAddress[] resolve(String str) throws UnknownHostException;
}
