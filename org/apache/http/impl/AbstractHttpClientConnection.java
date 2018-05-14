package org.apache.http.impl;

import java.io.IOException;
import java.net.SocketTimeoutException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.DefaultHttpResponseParser;
import org.apache.http.impl.io.HttpRequestWriter;
import org.apache.http.io.EofSensor;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@NotThreadSafe
@Deprecated
/* compiled from: TbsSdkJava */
public abstract class AbstractHttpClientConnection implements HttpClientConnection {
    private final EntityDeserializer entitydeserializer = createEntityDeserializer();
    private final EntitySerializer entityserializer = createEntitySerializer();
    private EofSensor eofSensor = null;
    private SessionInputBuffer inbuffer = null;
    private HttpConnectionMetricsImpl metrics = null;
    private SessionOutputBuffer outbuffer = null;
    private HttpMessageWriter<HttpRequest> requestWriter = null;
    private HttpMessageParser<HttpResponse> responseParser = null;

    protected abstract void assertOpen() throws IllegalStateException;

    protected EntityDeserializer createEntityDeserializer() {
        return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    protected EntitySerializer createEntitySerializer() {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    protected HttpResponseFactory createHttpResponseFactory() {
        return DefaultHttpResponseFactory.INSTANCE;
    }

    protected HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer sessionInputBuffer, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        return new DefaultHttpResponseParser(sessionInputBuffer, null, httpResponseFactory, httpParams);
    }

    protected HttpMessageWriter<HttpRequest> createRequestWriter(SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        return new HttpRequestWriter(sessionOutputBuffer, null, httpParams);
    }

    protected HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics httpTransportMetrics, HttpTransportMetrics httpTransportMetrics2) {
        return new HttpConnectionMetricsImpl(httpTransportMetrics, httpTransportMetrics2);
    }

    protected void init(SessionInputBuffer sessionInputBuffer, SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        this.inbuffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Input session buffer");
        this.outbuffer = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Output session buffer");
        if (sessionInputBuffer instanceof EofSensor) {
            this.eofSensor = (EofSensor) sessionInputBuffer;
        }
        this.responseParser = createResponseParser(sessionInputBuffer, createHttpResponseFactory(), httpParams);
        this.requestWriter = createRequestWriter(sessionOutputBuffer, httpParams);
        this.metrics = createConnectionMetrics(sessionInputBuffer.getMetrics(), sessionOutputBuffer.getMetrics());
    }

    public boolean isResponseAvailable(int i) throws IOException {
        assertOpen();
        try {
            return this.inbuffer.isDataAvailable(i);
        } catch (SocketTimeoutException e) {
            return false;
        }
    }

    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        assertOpen();
        this.requestWriter.write(httpRequest);
        this.metrics.incrementRequestCount();
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        assertOpen();
        if (httpEntityEnclosingRequest.getEntity() != null) {
            this.entityserializer.serialize(this.outbuffer, httpEntityEnclosingRequest, httpEntityEnclosingRequest.getEntity());
        }
    }

    protected void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    public void flush() throws IOException {
        assertOpen();
        doFlush();
    }

    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        assertOpen();
        HttpResponse httpResponse = (HttpResponse) this.responseParser.parse();
        if (httpResponse.getStatusLine().getStatusCode() >= 200) {
            this.metrics.incrementResponseCount();
        }
        return httpResponse;
    }

    public void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        assertOpen();
        httpResponse.setEntity(this.entitydeserializer.deserialize(this.inbuffer, httpResponse));
    }

    protected boolean isEof() {
        return this.eofSensor != null && this.eofSensor.isEof();
    }

    public boolean isStale() {
        boolean z = true;
        if (!isOpen() || isEof()) {
            return z;
        }
        try {
            this.inbuffer.isDataAvailable(1);
            return isEof();
        } catch (SocketTimeoutException e) {
            return false;
        } catch (IOException e2) {
            return z;
        }
    }

    public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }
}
