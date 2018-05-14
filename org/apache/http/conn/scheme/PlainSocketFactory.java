package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@Immutable
@Deprecated
/* compiled from: TbsSdkJava */
public class PlainSocketFactory implements SchemeSocketFactory, SocketFactory {
    private final HostNameResolver nameResolver;

    public static PlainSocketFactory getSocketFactory() {
        return new PlainSocketFactory();
    }

    @Deprecated
    public PlainSocketFactory(HostNameResolver hostNameResolver) {
        this.nameResolver = hostNameResolver;
    }

    public PlainSocketFactory() {
        this.nameResolver = null;
    }

    public Socket createSocket(HttpParams httpParams) {
        return new Socket();
    }

    public Socket createSocket() {
        return new Socket();
    }

    public Socket connectSocket(Socket socket, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, HttpParams httpParams) throws IOException, ConnectTimeoutException {
        Args.notNull(inetSocketAddress, "Remote address");
        Args.notNull(httpParams, "HTTP parameters");
        if (socket == null) {
            socket = createSocket();
        }
        if (inetSocketAddress2 != null) {
            socket.setReuseAddress(HttpConnectionParams.getSoReuseaddr(httpParams));
            socket.bind(inetSocketAddress2);
        }
        int connectionTimeout = HttpConnectionParams.getConnectionTimeout(httpParams);
        try {
            socket.setSoTimeout(HttpConnectionParams.getSoTimeout(httpParams));
            socket.connect(inetSocketAddress, connectionTimeout);
            return socket;
        } catch (SocketTimeoutException e) {
            throw new ConnectTimeoutException("Connect to " + inetSocketAddress + " timed out");
        }
    }

    public final boolean isSecure(Socket socket) {
        return false;
    }

    @Deprecated
    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
        InetAddress resolve;
        InetSocketAddress inetSocketAddress = null;
        if (inetAddress != null || i2 > 0) {
            if (i2 <= 0) {
                i2 = 0;
            }
            inetSocketAddress = new InetSocketAddress(inetAddress, i2);
        }
        if (this.nameResolver != null) {
            resolve = this.nameResolver.resolve(str);
        } else {
            resolve = InetAddress.getByName(str);
        }
        return connectSocket(socket, new InetSocketAddress(resolve, i), inetSocketAddress, httpParams);
    }
}
