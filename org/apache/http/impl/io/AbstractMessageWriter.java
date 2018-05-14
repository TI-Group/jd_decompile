package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public abstract class AbstractMessageWriter<T extends HttpMessage> implements HttpMessageWriter<T> {
    protected final CharArrayBuffer lineBuf;
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    protected abstract void writeHeadLine(T t) throws IOException;

    @Deprecated
    public AbstractMessageWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter, HttpParams httpParams) {
        Args.notNull(sessionOutputBuffer, "Session input buffer");
        this.sessionBuffer = sessionOutputBuffer;
        this.lineBuf = new CharArrayBuffer(128);
        if (lineFormatter == null) {
            lineFormatter = BasicLineFormatter.INSTANCE;
        }
        this.lineFormatter = lineFormatter;
    }

    public AbstractMessageWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        this.sessionBuffer = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session input buffer");
        if (lineFormatter == null) {
            lineFormatter = BasicLineFormatter.INSTANCE;
        }
        this.lineFormatter = lineFormatter;
        this.lineBuf = new CharArrayBuffer(128);
    }

    public void write(T t) throws IOException, HttpException {
        Args.notNull(t, "HTTP message");
        writeHeadLine(t);
        HeaderIterator headerIterator = t.headerIterator();
        while (headerIterator.hasNext()) {
            this.sessionBuffer.writeLine(this.lineFormatter.formatHeader(this.lineBuf, headerIterator.nextHeader()));
        }
        this.lineBuf.clear();
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
