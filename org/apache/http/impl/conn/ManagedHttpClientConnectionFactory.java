package org.apache.http.impl.conn;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

@Immutable
/* compiled from: TbsSdkJava */
public class ManagedHttpClientConnectionFactory implements HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> {
    private static final AtomicLong COUNTER = new AtomicLong();
    public static final ManagedHttpClientConnectionFactory INSTANCE = new ManagedHttpClientConnectionFactory();
    private final Log headerlog;
    private final Log log;
    private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
    private final HttpMessageParserFactory<HttpResponse> responseParserFactory;
    private final Log wirelog;

    public ManagedHttpClientConnectionFactory(HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        this.log = LogFactory.getLog(DefaultManagedHttpClientConnection.class);
        this.headerlog = LogFactory.getLog("org.apache.http.headers");
        this.wirelog = LogFactory.getLog("org.apache.http.wire");
        if (httpMessageWriterFactory == null) {
            httpMessageWriterFactory = DefaultHttpRequestWriterFactory.INSTANCE;
        }
        this.requestWriterFactory = httpMessageWriterFactory;
        if (httpMessageParserFactory == null) {
            httpMessageParserFactory = DefaultHttpResponseParserFactory.INSTANCE;
        }
        this.responseParserFactory = httpMessageParserFactory;
    }

    public ManagedHttpClientConnectionFactory(HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        this(null, httpMessageParserFactory);
    }

    public ManagedHttpClientConnectionFactory() {
        this(null, null);
    }

    public ManagedHttpClientConnection create(HttpRoute httpRoute, ConnectionConfig connectionConfig) {
        if (connectionConfig == null) {
            connectionConfig = ConnectionConfig.DEFAULT;
        }
        CharsetDecoder charsetDecoder = null;
        CharsetEncoder charsetEncoder = null;
        Charset charset = connectionConfig.getCharset();
        CodingErrorAction malformedInputAction = connectionConfig.getMalformedInputAction() != null ? connectionConfig.getMalformedInputAction() : CodingErrorAction.REPORT;
        CodingErrorAction unmappableInputAction = connectionConfig.getUnmappableInputAction() != null ? connectionConfig.getUnmappableInputAction() : CodingErrorAction.REPORT;
        if (charset != null) {
            charsetDecoder = charset.newDecoder();
            charsetDecoder.onMalformedInput(malformedInputAction);
            charsetDecoder.onUnmappableCharacter(unmappableInputAction);
            charsetEncoder = charset.newEncoder();
            charsetEncoder.onMalformedInput(malformedInputAction);
            charsetEncoder.onUnmappableCharacter(unmappableInputAction);
        }
        return new LoggingManagedHttpClientConnection("http-outgoing-" + Long.toString(COUNTER.getAndIncrement()), this.log, this.headerlog, this.wirelog, connectionConfig.getBufferSize(), connectionConfig.getFragmentSizeHint(), charsetDecoder, charsetEncoder, connectionConfig.getMessageConstraints(), null, null, this.requestWriterFactory, this.responseParserFactory);
    }
}
