package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.protocol.HttpContext;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class DefaultManagedHttpClientConnection extends DefaultBHttpClientConnection implements ManagedHttpClientConnection, HttpContext {
    private final Map<String, Object> attributes;
    private final String id;
    private volatile boolean shutdown;

    public DefaultManagedHttpClientConnection(String str, int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2, httpMessageWriterFactory, httpMessageParserFactory);
        this.id = str;
        this.attributes = new ConcurrentHashMap();
    }

    public DefaultManagedHttpClientConnection(String str, int i) {
        this(str, i, i, null, null, null, null, null, null, null);
    }

    public String getId() {
        return this.id;
    }

    public void shutdown() throws IOException {
        this.shutdown = true;
        super.shutdown();
    }

    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    public Object removeAttribute(String str) {
        return this.attributes.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        this.attributes.put(str, obj);
    }

    public void bind(Socket socket) throws IOException {
        if (this.shutdown) {
            socket.close();
            throw new InterruptedIOException("Connection already shutdown");
        } else {
            super.bind(socket);
        }
    }

    public Socket getSocket() {
        return super.getSocket();
    }

    public SSLSession getSSLSession() {
        Socket socket = super.getSocket();
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).getSession();
        }
        return null;
    }
}
