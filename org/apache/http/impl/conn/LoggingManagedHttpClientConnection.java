package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.commons.logging.Log;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;

@NotThreadSafe
/* compiled from: TbsSdkJava */
class LoggingManagedHttpClientConnection extends DefaultManagedHttpClientConnection {
    private final Log headerlog;
    private final Log log;
    private final Wire wire;

    public LoggingManagedHttpClientConnection(String str, Log log, Log log2, Log log3, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(str, i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.log = log;
        this.headerlog = log2;
        this.wire = new Wire(log3, str);
    }

    public void close() throws IOException {
        if (this.log.isDebugEnabled()) {
            this.log.debug(getId() + ": Close connection");
        }
        super.close();
    }

    public void shutdown() throws IOException {
        if (this.log.isDebugEnabled()) {
            this.log.debug(getId() + ": Shutdown connection");
        }
        super.shutdown();
    }

    protected InputStream getSocketInputStream(Socket socket) throws IOException {
        InputStream socketInputStream = super.getSocketInputStream(socket);
        if (this.wire.enabled()) {
            return new LoggingInputStream(socketInputStream, this.wire);
        }
        return socketInputStream;
    }

    protected OutputStream getSocketOutputStream(Socket socket) throws IOException {
        OutputStream socketOutputStream = super.getSocketOutputStream(socket);
        if (this.wire.enabled()) {
            return new LoggingOutputStream(socketOutputStream, this.wire);
        }
        return socketOutputStream;
    }

    protected void onResponseReceived(HttpResponse httpResponse) {
        if (httpResponse != null && this.headerlog.isDebugEnabled()) {
            this.headerlog.debug(getId() + " << " + httpResponse.getStatusLine().toString());
            for (Object obj : httpResponse.getAllHeaders()) {
                this.headerlog.debug(getId() + " << " + obj.toString());
            }
        }
    }

    protected void onRequestSubmitted(HttpRequest httpRequest) {
        if (httpRequest != null && this.headerlog.isDebugEnabled()) {
            this.headerlog.debug(getId() + " >> " + httpRequest.getRequestLine().toString());
            for (Object obj : httpRequest.getAllHeaders()) {
                this.headerlog.debug(getId() + " >> " + obj.toString());
            }
        }
    }
}
