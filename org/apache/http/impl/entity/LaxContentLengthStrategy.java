package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class LaxContentLengthStrategy implements ContentLengthStrategy {
    public static final LaxContentLengthStrategy INSTANCE = new LaxContentLengthStrategy();
    private final int implicitLen;

    public LaxContentLengthStrategy(int i) {
        this.implicitLen = i;
    }

    public LaxContentLengthStrategy() {
        this(-1);
    }

    public long determineLength(HttpMessage httpMessage) throws HttpException {
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            try {
                HeaderElement[] elements = firstHeader.getElements();
                int length = elements.length;
                if (!HTTP.IDENTITY_CODING.equalsIgnoreCase(firstHeader.getValue()) && length > 0 && HTTP.CHUNK_CODING.equalsIgnoreCase(elements[length - 1].getName())) {
                    return -2;
                }
                return -1;
            } catch (Throwable e) {
                throw new ProtocolException("Invalid Transfer-Encoding header value: " + firstHeader, e);
            }
        } else if (httpMessage.getFirstHeader("Content-Length") == null) {
            return (long) this.implicitLen;
        } else {
            long parseLong;
            Header[] headers = httpMessage.getHeaders("Content-Length");
            int length2 = headers.length - 1;
            while (length2 >= 0) {
                try {
                    parseLong = Long.parseLong(headers[length2].getValue());
                    break;
                } catch (NumberFormatException e2) {
                    length2--;
                }
            }
            parseLong = -1;
            if (parseLong >= 0) {
                return parseLong;
            }
            return -1;
        }
    }
}
