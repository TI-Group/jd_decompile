package org.apache.http.conn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Immutable
@Deprecated
/* compiled from: TbsSdkJava */
public final class MultihomePlainSocketFactory implements SocketFactory {
    private static final MultihomePlainSocketFactory DEFAULT_FACTORY = new MultihomePlainSocketFactory();

    public static MultihomePlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    private MultihomePlainSocketFactory() {
    }

    public Socket createSocket() {
        return new Socket();
    }

    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException {
        Socket createSocket;
        Args.notNull(str, "Target host");
        Args.notNull(httpParams, "HTTP parameters");
        if (socket == null) {
            createSocket = createSocket();
        } else {
            createSocket = socket;
        }
        if (inetAddress != null || i2 > 0) {
            if (i2 <= 0) {
                i2 = 0;
            }
            createSocket.bind(new InetSocketAddress(inetAddress, i2));
        }
        int connectionTimeout = HttpConnectionParams.getConnectionTimeout(httpParams);
        InetAddress[] allByName = InetAddress.getAllByName(str);
        List<InetAddress> arrayList = new ArrayList(allByName.length);
        arrayList.addAll(Arrays.asList(allByName));
        Collections.shuffle(arrayList);
        Socket socket2 = createSocket;
        IOException iOException = null;
        for (InetAddress inetAddress2 : arrayList) {
            try {
                socket2.connect(new InetSocketAddress(inetAddress2, i), connectionTimeout);
                break;
            } catch (SocketTimeoutException e) {
                throw new ConnectTimeoutException("Connect to " + inetAddress2 + " timed out");
            } catch (IOException e2) {
                socket2 = new Socket();
                iOException = e2;
            }
        }
        if (iOException == null) {
            return socket2;
        }
        throw iOException;
    }

    public final boolean isSecure(Socket socket) throws IllegalArgumentException {
        boolean z;
        Args.notNull(socket, "Socket");
        if (socket.isClosed()) {
            z = false;
        } else {
            z = true;
        }
        Asserts.check(z, "Socket is closed");
        return false;
    }
}
