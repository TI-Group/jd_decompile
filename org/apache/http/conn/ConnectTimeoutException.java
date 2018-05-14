package org.apache.http.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.util.Arrays;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class ConnectTimeoutException extends InterruptedIOException {
    private static final long serialVersionUID = -4816682903149535989L;
    private final HttpHost host;

    public ConnectTimeoutException() {
        this.host = null;
    }

    public ConnectTimeoutException(String str) {
        super(str);
        this.host = null;
    }

    public ConnectTimeoutException(IOException iOException, HttpHost httpHost, InetAddress... inetAddressArr) {
        StringBuilder append = new StringBuilder().append("Connect to ").append(httpHost != null ? httpHost.toHostString() : "remote host");
        String str = (inetAddressArr == null || inetAddressArr.length <= 0) ? "" : " " + Arrays.asList(inetAddressArr);
        append = append.append(str);
        str = (iOException == null || iOException.getMessage() == null) ? " timed out" : " failed: " + iOException.getMessage();
        super(append.append(str).toString());
        this.host = httpHost;
        initCause(iOException);
    }

    public HttpHost getHost() {
        return this.host;
    }
}
