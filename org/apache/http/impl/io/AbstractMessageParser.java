package org.apache.http.impl.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.MessageConstraintException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List<CharArrayBuffer> headerLines;
    protected final LineParser lineParser;
    private T message;
    private final MessageConstraints messageConstraints;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    protected abstract T parseHead(SessionInputBuffer sessionInputBuffer) throws IOException, HttpException, ParseException;

    @Deprecated
    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpParams httpParams) {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(httpParams, "HTTP parameters");
        this.sessionBuffer = sessionInputBuffer;
        this.messageConstraints = HttpParamConfig.getMessageConstraints(httpParams);
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        this.lineParser = lineParser;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, MessageConstraints messageConstraints) {
        this.sessionBuffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        this.lineParser = lineParser;
        if (messageConstraints == null) {
            messageConstraints = MessageConstraints.DEFAULT;
        }
        this.messageConstraints = messageConstraints;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser) throws HttpException, IOException {
        List arrayList = new ArrayList();
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        return parseHeaders(sessionInputBuffer, i, i2, lineParser, arrayList);
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser, List<CharArrayBuffer> list) throws HttpException, IOException {
        Header[] headerArr;
        int i3 = 0;
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(lineParser, "Line parser");
        Args.notNull(list, "Header line list");
        CharArrayBuffer charArrayBuffer = null;
        CharArrayBuffer charArrayBuffer2 = null;
        while (true) {
            if (charArrayBuffer2 == null) {
                charArrayBuffer2 = new CharArrayBuffer(64);
            } else {
                charArrayBuffer2.clear();
            }
            if (sessionInputBuffer.readLine(charArrayBuffer2) == -1 || charArrayBuffer2.length() < 1) {
                headerArr = new Header[list.size()];
            } else {
                CharArrayBuffer charArrayBuffer3;
                if ((charArrayBuffer2.charAt(0) == ' ' || charArrayBuffer2.charAt(0) == '\t') && charArrayBuffer != null) {
                    int i4 = 0;
                    while (i4 < charArrayBuffer2.length()) {
                        char charAt = charArrayBuffer2.charAt(i4);
                        if (charAt != ' ' && charAt != '\t') {
                            break;
                        }
                        i4++;
                    }
                    if (i2 <= 0 || ((charArrayBuffer.length() + 1) + charArrayBuffer2.length()) - i4 <= i2) {
                        charArrayBuffer.append(' ');
                        charArrayBuffer.append(charArrayBuffer2, i4, charArrayBuffer2.length() - i4);
                        charArrayBuffer3 = charArrayBuffer2;
                        charArrayBuffer2 = charArrayBuffer;
                    } else {
                        throw new MessageConstraintException("Maximum line length limit exceeded");
                    }
                }
                list.add(charArrayBuffer2);
                charArrayBuffer3 = null;
                if (i <= 0 || list.size() < i) {
                    charArrayBuffer = charArrayBuffer2;
                    charArrayBuffer2 = charArrayBuffer3;
                } else {
                    throw new MessageConstraintException("Maximum header count exceeded");
                }
            }
        }
        headerArr = new Header[list.size()];
        while (i3 < list.size()) {
            try {
                headerArr[i3] = lineParser.parseHeader((CharArrayBuffer) list.get(i3));
                i3++;
            } catch (ParseException e) {
                throw new ProtocolException(e.getMessage());
            }
        }
        return headerArr;
    }

    public T parse() throws IOException, HttpException {
        switch (this.state) {
            case 0:
                try {
                    this.message = parseHead(this.sessionBuffer);
                    this.state = 1;
                    break;
                } catch (Throwable e) {
                    throw new ProtocolException(e.getMessage(), e);
                }
            case 1:
                break;
            default:
                throw new IllegalStateException("Inconsistent parser state");
        }
        this.message.setHeaders(parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines));
        T t = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return t;
    }
}
