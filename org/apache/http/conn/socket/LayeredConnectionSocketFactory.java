package org.apache.http.conn.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.protocol.HttpContext;

/* compiled from: TbsSdkJava */
public interface LayeredConnectionSocketFactory extends ConnectionSocketFactory {
    Socket createLayeredSocket(Socket socket, String str, int i, HttpContext httpContext) throws IOException, UnknownHostException;
}
