package org.apache.http.impl.conn;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.http.conn.DnsResolver;

/* compiled from: TbsSdkJava */
public class SystemDefaultDnsResolver implements DnsResolver {
    public static final SystemDefaultDnsResolver INSTANCE = new SystemDefaultDnsResolver();

    public InetAddress[] resolve(String str) throws UnknownHostException {
        return InetAddress.getAllByName(str);
    }
}
