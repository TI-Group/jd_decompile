package org.apache.http.conn;

import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class ConnectionPoolTimeoutException extends ConnectTimeoutException {
    private static final long serialVersionUID = -7898874842020245128L;

    public ConnectionPoolTimeoutException(String str) {
        super(str);
    }
}
