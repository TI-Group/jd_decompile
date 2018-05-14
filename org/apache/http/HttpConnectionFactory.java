package org.apache.http;

import java.io.IOException;
import java.net.Socket;

/* compiled from: TbsSdkJava */
public interface HttpConnectionFactory<T extends HttpConnection> {
    T createConnection(Socket socket) throws IOException;
}
