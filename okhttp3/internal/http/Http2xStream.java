package okhttp3.internal.http;

import b.f;
import b.i;
import b.m;
import b.r;
import b.s;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.framed.FramedStream;
import okhttp3.internal.framed.Header;

/* compiled from: TbsSdkJava */
public final class Http2xStream implements HttpStream {
    private static final f CONNECTION = f.encodeUtf8("connection");
    private static final f ENCODING = f.encodeUtf8("encoding");
    private static final f HOST = f.encodeUtf8("host");
    private static final List<f> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION);
    private static final List<f> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);
    private static final f KEEP_ALIVE = f.encodeUtf8("keep-alive");
    private static final f PROXY_CONNECTION = f.encodeUtf8("proxy-connection");
    private static final List<f> SPDY_3_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION);
    private static final List<f> SPDY_3_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING);
    private static final f TE = f.encodeUtf8("te");
    private static final f TRANSFER_ENCODING = f.encodeUtf8("transfer-encoding");
    private static final f UPGRADE = f.encodeUtf8("upgrade");
    private final FramedConnection framedConnection;
    private HttpEngine httpEngine;
    private FramedStream stream;
    private final StreamAllocation streamAllocation;

    /* compiled from: TbsSdkJava */
    class StreamFinishingSource extends i {
        public StreamFinishingSource(s sVar) {
            super(sVar);
        }

        public void close() throws IOException {
            Http2xStream.this.streamAllocation.streamFinished(false, Http2xStream.this);
            super.close();
        }
    }

    public Http2xStream(StreamAllocation streamAllocation, FramedConnection framedConnection) {
        this.streamAllocation = streamAllocation;
        this.framedConnection = framedConnection;
    }

    public void setHttpEngine(HttpEngine httpEngine) {
        this.httpEngine = httpEngine;
    }

    public r createRequestBody(Request request, long j) throws IOException {
        return this.stream.getSink();
    }

    public void writeRequestHeaders(Request request) throws IOException {
        if (this.stream == null) {
            List http2HeadersList;
            this.httpEngine.writingRequestHeaders();
            boolean permitsRequestBody = this.httpEngine.permitsRequestBody(request);
            if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
                http2HeadersList = http2HeadersList(request);
            } else {
                http2HeadersList = spdy3HeadersList(request);
            }
            this.stream = this.framedConnection.newStream(http2HeadersList, permitsRequestBody, true);
            this.stream.readTimeout().timeout((long) this.httpEngine.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.stream.writeTimeout().timeout((long) this.httpEngine.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        retryableSink.writeToSocket(this.stream.getSink());
    }

    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public Builder readResponseHeaders() throws IOException {
        if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
            return readHttp2HeadersList(this.stream.getResponseHeaders());
        }
        return readSpdy3HeadersList(this.stream.getResponseHeaders());
    }

    public static List<Header> spdy3HeadersList(Request request) {
        Headers headers = request.headers();
        List<Header> arrayList = new ArrayList(headers.size() + 5);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        arrayList.add(new Header(Header.VERSION, "HTTP/1.1"));
        arrayList.add(new Header(Header.TARGET_HOST, Util.hostHeader(request.url(), false)));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        Set linkedHashSet = new LinkedHashSet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            f encodeUtf8 = f.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!SPDY_3_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                String value = headers.value(i);
                if (linkedHashSet.add(encodeUtf8)) {
                    arrayList.add(new Header(encodeUtf8, value));
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (((Header) arrayList.get(i2)).name.equals(encodeUtf8)) {
                            arrayList.set(i2, new Header(encodeUtf8, joinOnNull(((Header) arrayList.get(i2)).value.utf8(), value)));
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static String joinOnNull(String str, String str2) {
        return '\u0000' + str2;
    }

    public static List<Header> http2HeadersList(Request request) {
        int i = 0;
        Headers headers = request.headers();
        List<Header> arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        arrayList.add(new Header(Header.TARGET_AUTHORITY, Util.hostHeader(request.url(), false)));
        arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        while (i < size) {
            f encodeUtf8 = f.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(encodeUtf8)) {
                arrayList.add(new Header(encodeUtf8, headers.value(i)));
            }
            i++;
        }
        return arrayList;
    }

    public static Builder readSpdy3HeadersList(List<Header> list) throws IOException {
        String str = null;
        String str2 = "HTTP/1.1";
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        int i = 0;
        while (i < size) {
            f fVar = ((Header) list.get(i)).name;
            String utf8 = ((Header) list.get(i)).value.utf8();
            String str3 = str2;
            int i2 = 0;
            while (i2 < utf8.length()) {
                int indexOf = utf8.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = utf8.length();
                }
                str2 = utf8.substring(i2, indexOf);
                if (!fVar.equals(Header.RESPONSE_STATUS)) {
                    if (fVar.equals(Header.VERSION)) {
                        str3 = str2;
                        str2 = str;
                    } else {
                        if (!SPDY_3_SKIPPED_RESPONSE_HEADERS.contains(fVar)) {
                            builder.add(fVar.utf8(), str2);
                        }
                        str2 = str;
                    }
                }
                str = str2;
                i2 = indexOf + 1;
            }
            i++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine parse = StatusLine.parse(str2 + " " + str);
        return new Builder().protocol(Protocol.SPDY_3).code(parse.code).message(parse.message).headers(builder.build());
    }

    public static Builder readHttp2HeadersList(List<Header> list) throws IOException {
        String str = null;
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        int i = 0;
        while (i < size) {
            f fVar = ((Header) list.get(i)).name;
            String utf8 = ((Header) list.get(i)).value.utf8();
            if (!fVar.equals(Header.RESPONSE_STATUS)) {
                if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(fVar)) {
                    builder.add(fVar.utf8(), utf8);
                }
                utf8 = str;
            }
            i++;
            str = utf8;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine parse = StatusLine.parse("HTTP/1.1 " + str);
        return new Builder().protocol(Protocol.HTTP_2).code(parse.code).message(parse.message).headers(builder.build());
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), m.a(new StreamFinishingSource(this.stream.getSource())));
    }

    public void cancel() {
        if (this.stream != null) {
            this.stream.closeLater(ErrorCode.CANCEL);
        }
    }
}
