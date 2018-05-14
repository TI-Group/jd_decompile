package org.apache.http.impl.io;

import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.MessageConstraints;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;

@Immutable
/* compiled from: TbsSdkJava */
public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory<HttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    public DefaultHttpResponseParserFactory(LineParser lineParser, HttpResponseFactory httpResponseFactory) {
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        this.lineParser = lineParser;
        if (httpResponseFactory == null) {
            httpResponseFactory = DefaultHttpResponseFactory.INSTANCE;
        }
        this.responseFactory = httpResponseFactory;
    }

    public DefaultHttpResponseParserFactory() {
        this(null, null);
    }

    public HttpMessageParser<HttpResponse> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpResponseParser(sessionInputBuffer, this.lineParser, this.responseFactory, messageConstraints);
    }
}
