package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.http.Consts;
import org.apache.http.annotation.Immutable;
import org.apache.http.io.EofSensor;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;

@Immutable
@Deprecated
/* compiled from: TbsSdkJava */
public class LoggingSessionInputBuffer implements EofSensor, SessionInputBuffer {
    private final String charset;
    private final EofSensor eofSensor;
    private final SessionInputBuffer in;
    private final Wire wire;

    public LoggingSessionInputBuffer(SessionInputBuffer sessionInputBuffer, Wire wire, String str) {
        this.in = sessionInputBuffer;
        this.eofSensor = sessionInputBuffer instanceof EofSensor ? (EofSensor) sessionInputBuffer : null;
        this.wire = wire;
        if (str == null) {
            str = Consts.ASCII.name();
        }
        this.charset = str;
    }

    public LoggingSessionInputBuffer(SessionInputBuffer sessionInputBuffer, Wire wire) {
        this(sessionInputBuffer, wire, null);
    }

    public boolean isDataAvailable(int i) throws IOException {
        return this.in.isDataAvailable(i);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (this.wire.enabled() && read > 0) {
            this.wire.input(bArr, i, read);
        }
        return read;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (this.wire.enabled() && read != -1) {
            this.wire.input(read);
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        int read = this.in.read(bArr);
        if (this.wire.enabled() && read > 0) {
            this.wire.input(bArr, 0, read);
        }
        return read;
    }

    public String readLine() throws IOException {
        String readLine = this.in.readLine();
        if (this.wire.enabled() && readLine != null) {
            this.wire.input((readLine + "\r\n").getBytes(this.charset));
        }
        return readLine;
    }

    public int readLine(CharArrayBuffer charArrayBuffer) throws IOException {
        int readLine = this.in.readLine(charArrayBuffer);
        if (this.wire.enabled() && readLine >= 0) {
            this.wire.input((new String(charArrayBuffer.buffer(), charArrayBuffer.length() - readLine, readLine) + "\r\n").getBytes(this.charset));
        }
        return readLine;
    }

    public HttpTransportMetrics getMetrics() {
        return this.in.getMetrics();
    }

    public boolean isEof() {
        if (this.eofSensor != null) {
            return this.eofSensor.isEof();
        }
        return false;
    }
}
