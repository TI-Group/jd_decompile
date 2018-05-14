package org.apache.http.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import org.apache.http.HttpInetConnection;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.io.SocketInputBuffer;
import org.apache.http.impl.io.SocketOutputBuffer;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@NotThreadSafe
@Deprecated
/* compiled from: TbsSdkJava */
public class SocketHttpClientConnection extends AbstractHttpClientConnection implements HttpInetConnection {
    private volatile boolean open;
    private volatile Socket socket = null;

    protected void assertNotOpen() {
        Asserts.check(!this.open, "Connection is already open");
    }

    protected void assertOpen() {
        Asserts.check(this.open, "Connection is not open");
    }

    protected SessionInputBuffer createSessionInputBuffer(Socket socket, int i, HttpParams httpParams) throws IOException {
        return new SocketInputBuffer(socket, i, httpParams);
    }

    protected SessionOutputBuffer createSessionOutputBuffer(Socket socket, int i, HttpParams httpParams) throws IOException {
        return new SocketOutputBuffer(socket, i, httpParams);
    }

    protected void bind(Socket socket, HttpParams httpParams) throws IOException {
        Args.notNull(socket, "Socket");
        Args.notNull(httpParams, "HTTP parameters");
        this.socket = socket;
        int intParameter = httpParams.getIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, -1);
        init(createSessionInputBuffer(socket, intParameter, httpParams), createSessionOutputBuffer(socket, intParameter, httpParams), httpParams);
        this.open = true;
    }

    public boolean isOpen() {
        return this.open;
    }

    protected Socket getSocket() {
        return this.socket;
    }

    public InetAddress getLocalAddress() {
        if (this.socket != null) {
            return this.socket.getLocalAddress();
        }
        return null;
    }

    public int getLocalPort() {
        if (this.socket != null) {
            return this.socket.getLocalPort();
        }
        return -1;
    }

    public InetAddress getRemoteAddress() {
        if (this.socket != null) {
            return this.socket.getInetAddress();
        }
        return null;
    }

    public int getRemotePort() {
        if (this.socket != null) {
            return this.socket.getPort();
        }
        return -1;
    }

    public void setSocketTimeout(int i) {
        assertOpen();
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(i);
            } catch (SocketException e) {
            }
        }
    }

    public int getSocketTimeout() {
        int i = -1;
        if (this.socket != null) {
            try {
                i = this.socket.getSoTimeout();
            } catch (SocketException e) {
            }
        }
        return i;
    }

    public void shutdown() throws IOException {
        this.open = false;
        Socket socket = this.socket;
        if (socket != null) {
            socket.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
        r2 = this;
        r0 = r2.open;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 0;
        r2.open = r0;
        r1 = r2.socket;
        r2.doFlush();	 Catch:{ all -> 0x0017 }
        r1.shutdownOutput();	 Catch:{ IOException -> 0x001c, UnsupportedOperationException -> 0x0020 }
    L_0x0010:
        r1.shutdownInput();	 Catch:{ IOException -> 0x001e, UnsupportedOperationException -> 0x0020 }
    L_0x0013:
        r1.close();
        goto L_0x0004;
    L_0x0017:
        r0 = move-exception;
        r1.close();
        throw r0;
    L_0x001c:
        r0 = move-exception;
        goto L_0x0010;
    L_0x001e:
        r0 = move-exception;
        goto L_0x0013;
    L_0x0020:
        r0 = move-exception;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.SocketHttpClientConnection.close():void");
    }

    private static void formatAddress(StringBuilder stringBuilder, SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            stringBuilder.append(inetSocketAddress.getAddress() != null ? inetSocketAddress.getAddress().getHostAddress() : inetSocketAddress.getAddress()).append(':').append(inetSocketAddress.getPort());
            return;
        }
        stringBuilder.append(socketAddress);
    }

    public String toString() {
        if (this.socket == null) {
            return super.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        SocketAddress remoteSocketAddress = this.socket.getRemoteSocketAddress();
        SocketAddress localSocketAddress = this.socket.getLocalSocketAddress();
        if (!(remoteSocketAddress == null || localSocketAddress == null)) {
            formatAddress(stringBuilder, localSocketAddress);
            stringBuilder.append("<->");
            formatAddress(stringBuilder, remoteSocketAddress);
        }
        return stringBuilder.toString();
    }
}
