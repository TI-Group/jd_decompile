package org.apache.http.impl.conn;

import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class DefaultSchemePortResolver implements SchemePortResolver {
    public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();

    public int resolve(HttpHost httpHost) throws UnsupportedSchemeException {
        Args.notNull(httpHost, "HTTP host");
        int port = httpHost.getPort();
        if (port > 0) {
            return port;
        }
        String schemeName = httpHost.getSchemeName();
        if (schemeName.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (schemeName.equalsIgnoreCase("https")) {
            return 443;
        }
        throw new UnsupportedSchemeException(schemeName + " protocol is not supported");
    }
}
