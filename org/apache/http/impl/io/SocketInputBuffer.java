package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.EofSensor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@NotThreadSafe
@Deprecated
/* compiled from: TbsSdkJava */
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private boolean eof = false;
    private final Socket socket;

    public SocketInputBuffer(Socket socket, int i, HttpParams httpParams) throws IOException {
        int receiveBufferSize;
        int i2 = 1024;
        Args.notNull(socket, "Socket");
        this.socket = socket;
        if (i < 0) {
            receiveBufferSize = socket.getReceiveBufferSize();
        } else {
            receiveBufferSize = i;
        }
        if (receiveBufferSize >= 1024) {
            i2 = receiveBufferSize;
        }
        init(socket.getInputStream(), i2, httpParams);
    }

    protected int fillBuffer() throws IOException {
        int fillBuffer = super.fillBuffer();
        this.eof = fillBuffer == -1;
        return fillBuffer;
    }

    public boolean isDataAvailable(int i) throws IOException {
        boolean hasBufferedData = hasBufferedData();
        if (!hasBufferedData) {
            int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(i);
                fillBuffer();
                hasBufferedData = hasBufferedData();
            } finally {
                this.socket.setSoTimeout(soTimeout);
            }
        }
        return hasBufferedData;
    }

    public boolean isEof() {
        return this.eof;
    }
}
