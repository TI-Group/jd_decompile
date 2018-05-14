package org.apache.http.conn;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.util.Arrays;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class HttpHostConnectException extends ConnectException {
    private static final long serialVersionUID = -3194482710275220224L;
    private final HttpHost host;

    @Deprecated
    public HttpHostConnectException(HttpHost httpHost, ConnectException connectException) {
        this(connectException, httpHost, null);
    }

    public HttpHostConnectException(IOException iOException, HttpHost httpHost, InetAddress... inetAddressArr) {
        StringBuilder append = new StringBuilder().append("Connect to ").append(httpHost != null ? httpHost.toHostString() : "remote host");
        String str = (inetAddressArr == null || inetAddressArr.length <= 0) ? "" : " " + Arrays.asList(inetAddressArr);
        append = append.append(str);
        str = (iOException == null || iOException.getMessage() == null) ? " refused" : " failed: " + iOException.getMessage();
        super(append.append(str).toString());
        this.host = httpHost;
        initCause(iOException);
    }

    public HttpHost getHost() {
        return this.host;
    }
}
