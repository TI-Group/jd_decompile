package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@NotThreadSafe
@Deprecated
/* compiled from: TbsSdkJava */
public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    public SocketOutputBuffer(Socket socket, int i, HttpParams httpParams) throws IOException {
        int sendBufferSize;
        int i2 = 1024;
        Args.notNull(socket, "Socket");
        if (i < 0) {
            sendBufferSize = socket.getSendBufferSize();
        } else {
            sendBufferSize = i;
        }
        if (sendBufferSize >= 1024) {
            i2 = sendBufferSize;
        }
        init(socket.getOutputStream(), i2, httpParams);
    }
}
