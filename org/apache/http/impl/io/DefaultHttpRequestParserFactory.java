package org.apache.http.impl.io;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpRequestFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;

@Immutable
/* compiled from: TbsSdkJava */
public class DefaultHttpRequestParserFactory implements HttpMessageParserFactory<HttpRequest> {
    public static final DefaultHttpRequestParserFactory INSTANCE = new DefaultHttpRequestParserFactory();
    private final LineParser lineParser;
    private final HttpRequestFactory requestFactory;

    public DefaultHttpRequestParserFactory(LineParser lineParser, HttpRequestFactory httpRequestFactory) {
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        this.lineParser = lineParser;
        if (httpRequestFactory == null) {
            httpRequestFactory = DefaultHttpRequestFactory.INSTANCE;
        }
        this.requestFactory = httpRequestFactory;
    }

    public DefaultHttpRequestParserFactory() {
        this(null, null);
    }

    public HttpMessageParser<HttpRequest> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpRequestParser(sessionInputBuffer, this.lineParser, this.requestFactory, messageConstraints);
    }
}
