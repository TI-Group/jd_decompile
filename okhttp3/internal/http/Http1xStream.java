package okhttp3.internal.http;

import b.c;
import b.d;
import b.e;
import b.j;
import b.m;
import b.r;
import b.s;
import b.t;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.io.RealConnection;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public final class Http1xStream implements HttpStream {
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private HttpEngine httpEngine;
    private final d sink;
    private final e source;
    private int state = 0;
    private final StreamAllocation streamAllocation;

    /* compiled from: TbsSdkJava */
    private abstract class AbstractSource implements s {
        protected boolean closed;
        protected final j timeout;

        private AbstractSource() {
            this.timeout = new j(Http1xStream.this.source.timeout());
        }

        public t timeout() {
            return this.timeout;
        }

        protected final void endOfInput(boolean z) throws IOException {
            if (Http1xStream.this.state != 6) {
                if (Http1xStream.this.state != 5) {
                    throw new IllegalStateException("state: " + Http1xStream.this.state);
                }
                Http1xStream.this.detachTimeout(this.timeout);
                Http1xStream.this.state = 6;
                if (Http1xStream.this.streamAllocation != null) {
                    Http1xStream.this.streamAllocation.streamFinished(!z, Http1xStream.this);
                }
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private final class ChunkedSink implements r {
        private boolean closed;
        private final j timeout;

        private ChunkedSink() {
            this.timeout = new j(Http1xStream.this.sink.timeout());
        }

        public t timeout() {
            return this.timeout;
        }

        public void write(c cVar, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                Http1xStream.this.sink.k(j);
                Http1xStream.this.sink.b("\r\n");
                Http1xStream.this.sink.write(cVar, j);
                Http1xStream.this.sink.b("\r\n");
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.closed) {
                Http1xStream.this.sink.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                Http1xStream.this.sink.b("0\r\n\r\n");
                Http1xStream.this.detachTimeout(this.timeout);
                Http1xStream.this.state = 3;
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpEngine httpEngine;

        ChunkedSource(HttpEngine httpEngine) throws IOException {
            super();
            this.httpEngine = httpEngine;
        }

        public long read(c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                if (this.bytesRemainingInChunk == 0 || this.bytesRemainingInChunk == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                long read = Http1xStream.this.source.read(cVar, Math.min(j, this.bytesRemainingInChunk));
                if (read == -1) {
                    endOfInput(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.bytesRemainingInChunk -= read;
                return read;
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1xStream.this.source.s();
            }
            try {
                this.bytesRemainingInChunk = Http1xStream.this.source.p();
                String trim = Http1xStream.this.source.s().trim();
                if (this.bytesRemainingInChunk < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + trim + "\"");
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    this.httpEngine.receiveHeaders(Http1xStream.this.readHeaders());
                    endOfInput(true);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false);
                }
                this.closed = true;
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private final class FixedLengthSink implements r {
        private long bytesRemaining;
        private boolean closed;
        private final j timeout;

        private FixedLengthSink(long j) {
            this.timeout = new j(Http1xStream.this.sink.timeout());
            this.bytesRemaining = j;
        }

        public t timeout() {
            return this.timeout;
        }

        public void write(c cVar, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(cVar.a(), 0, j);
            if (j > this.bytesRemaining) {
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
            }
            Http1xStream.this.sink.write(cVar, j);
            this.bytesRemaining -= j;
        }

        public void flush() throws IOException {
            if (!this.closed) {
                Http1xStream.this.sink.flush();
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                Http1xStream.this.detachTimeout(this.timeout);
                Http1xStream.this.state = 3;
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (this.bytesRemaining == 0) {
                endOfInput(true);
            }
        }

        public long read(c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.bytesRemaining == 0) {
                return -1;
            } else {
                long read = Http1xStream.this.source.read(cVar, Math.min(this.bytesRemaining, j));
                if (read == -1) {
                    endOfInput(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.bytesRemaining -= read;
                if (this.bytesRemaining == 0) {
                    endOfInput(true);
                }
                return read;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!(this.bytesRemaining == 0 || Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
                    endOfInput(false);
                }
                this.closed = true;
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
            super();
        }

        public long read(c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = Http1xStream.this.source.read(cVar, j);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(true);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    endOfInput(false);
                }
                this.closed = true;
            }
        }
    }

    public Http1xStream(StreamAllocation streamAllocation, e eVar, d dVar) {
        this.streamAllocation = streamAllocation;
        this.source = eVar;
        this.sink = dVar;
    }

    public void setHttpEngine(HttpEngine httpEngine) {
        this.httpEngine = httpEngine;
    }

    public r createRequestBody(Request request, long j) throws IOException {
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newFixedLengthSink(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public void writeRequestHeaders(Request request) throws IOException {
        this.httpEngine.writingRequestHeaders();
        writeRequest(request.headers(), RequestLine.get(request, this.httpEngine.getConnection().route().proxy().type()));
    }

    public Builder readResponseHeaders() throws IOException {
        return readResponse();
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), m.a(getTransferStream(response)));
    }

    private s getTransferStream(Response response) throws IOException {
        if (!HttpEngine.hasBody(response)) {
            return newFixedLengthSource(0);
        }
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return newChunkedSource(this.httpEngine);
        }
        long contentLength = OkHeaders.contentLength(response);
        if (contentLength != -1) {
            return newFixedLengthSource(contentLength);
        }
        return newUnknownLengthSource();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.sink.b(str).b("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.b(headers.name(i)).b(": ").b(headers.value(i)).b("\r\n");
        }
        this.sink.b("\r\n");
        this.state = 1;
    }

    public Builder readResponse() throws IOException {
        if (this.state == 1 || this.state == 3) {
            Builder headers;
            StatusLine parse;
            do {
                try {
                    parse = StatusLine.parse(this.source.s());
                    headers = new Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(readHeaders());
                } catch (Throwable e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.streamAllocation);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (parse.code == 100);
            this.state = 4;
            return headers;
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String s = this.source.s();
            if (s.length() == 0) {
                return builder.build();
            }
            Internal.instance.addLenient(builder, s);
        }
    }

    public r newChunkedSink() {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new ChunkedSink();
    }

    public r newFixedLengthSink(long j) {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new FixedLengthSink(j);
    }

    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 3;
        retryableSink.writeToSocket(this.sink);
    }

    public s newFixedLengthSource(long j) throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new FixedLengthSource(j);
    }

    public s newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new ChunkedSource(httpEngine);
    }

    public s newUnknownLengthSource() throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        } else if (this.streamAllocation == null) {
            throw new IllegalStateException("streamAllocation == null");
        } else {
            this.state = 5;
            this.streamAllocation.noNewStreams();
            return new UnknownLengthSource();
        }
    }

    private void detachTimeout(j jVar) {
        t a = jVar.a();
        jVar.a(t.NONE);
        a.clearDeadline();
        a.clearTimeout();
    }
}
