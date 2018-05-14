package okhttp3.internal.http;

import b.c;
import b.d;
import b.e;
import b.k;
import b.m;
import b.r;
import b.s;
import b.t;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.CacheStrategy.Factory;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.cookie.SM;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody() {
        public MediaType contentType() {
            return null;
        }

        public long contentLength() {
            return 0;
        }

        public e source() {
            return new c();
        }
    };
    public static final int MAX_FOLLOW_UPS = 20;
    public final boolean bufferRequestBody;
    private d bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    private final boolean forWebSocket;
    private HttpStream httpStream;
    private Request networkRequest;
    private final Response priorResponse;
    private r requestBodyOut;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    public final StreamAllocation streamAllocation;
    private boolean transparentGzip;
    private final Request userRequest;
    private Response userResponse;

    /* compiled from: TbsSdkJava */
    class NetworkInterceptorChain implements Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int i, Request request) {
            this.index = i;
            this.request = request;
        }

        public Connection connection() {
            return HttpEngine.this.streamAllocation.connection();
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request) throws IOException {
            Interceptor interceptor;
            this.calls++;
            if (this.index > 0) {
                interceptor = (Interceptor) HttpEngine.this.client.networkInterceptors().get(this.index - 1);
                Address address = connection().route().address();
                if (!request.url().host().equals(address.url().host()) || request.url().port() != address.url().port()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                } else if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
                Object networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, request);
                interceptor = (Interceptor) HttpEngine.this.client.networkInterceptors().get(this.index);
                Response intercept = interceptor.intercept(networkInterceptorChain);
                if (networkInterceptorChain.calls != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept != null) {
                    return intercept;
                } else {
                    throw new NullPointerException("network interceptor " + interceptor + " returned null");
                }
            }
            HttpEngine.this.httpStream.writeRequestHeaders(request);
            HttpEngine.this.networkRequest = request;
            if (HttpEngine.this.permitsRequestBody(request) && request.body() != null) {
                d a = m.a(HttpEngine.this.httpStream.createRequestBody(request, request.body().contentLength()));
                request.body().writeTo(a);
                a.close();
            }
            Response access$200 = HttpEngine.this.readNetworkResponse();
            int code = access$200.code();
            if ((code != 204 && code != 205) || access$200.body().contentLength() <= 0) {
                return access$200;
            }
            throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + access$200.body().contentLength());
        }
    }

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z, boolean z2, boolean z3, StreamAllocation streamAllocation, RetryableSink retryableSink, Response response) {
        this.client = okHttpClient;
        this.userRequest = request;
        this.bufferRequestBody = z;
        this.callerWritesRequestBody = z2;
        this.forWebSocket = z3;
        if (streamAllocation == null) {
            streamAllocation = new StreamAllocation(okHttpClient.connectionPool(), createAddress(okHttpClient, request));
        }
        this.streamAllocation = streamAllocation;
        this.requestBodyOut = retryableSink;
        this.priorResponse = response;
    }

    public void sendRequest() throws RequestException, RouteException, IOException {
        if (this.cacheStrategy == null) {
            if (this.httpStream != null) {
                throw new IllegalStateException();
            }
            Request networkRequest = networkRequest(this.userRequest);
            InternalCache internalCache = Internal.instance.internalCache(this.client);
            Response response = internalCache != null ? internalCache.get(networkRequest) : null;
            this.cacheStrategy = new Factory(System.currentTimeMillis(), networkRequest, response).get();
            this.networkRequest = this.cacheStrategy.networkRequest;
            this.cacheResponse = this.cacheStrategy.cacheResponse;
            if (internalCache != null) {
                internalCache.trackResponse(this.cacheStrategy);
            }
            if (response != null && this.cacheResponse == null) {
                Util.closeQuietly(response.body());
            }
            if (this.networkRequest == null && this.cacheResponse == null) {
                this.userResponse = new Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
            } else if (this.networkRequest == null) {
                this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
                this.userResponse = unzip(this.userResponse);
            } else {
                try {
                    this.httpStream = connect();
                    this.httpStream.setHttpEngine(this);
                    if (writeRequestHeadersEagerly()) {
                        long contentLength = OkHeaders.contentLength(networkRequest);
                        if (!this.bufferRequestBody) {
                            this.httpStream.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = this.httpStream.createRequestBody(this.networkRequest, contentLength);
                        } else if (contentLength > 2147483647L) {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        } else if (contentLength != -1) {
                            this.httpStream.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = new RetryableSink((int) contentLength);
                        } else {
                            this.requestBodyOut = new RetryableSink();
                        }
                    }
                } catch (Throwable th) {
                    if (response != null) {
                        Util.closeQuietly(response.body());
                    }
                }
            }
        }
    }

    private boolean writeRequestHeadersEagerly() {
        return this.callerWritesRequestBody && permitsRequestBody(this.networkRequest) && this.requestBodyOut == null;
    }

    private HttpStream connect() throws RouteException, RequestException, IOException {
        return this.streamAllocation.newStream(this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis(), this.client.retryOnConnectionFailure(), !this.networkRequest.method().equals("GET"));
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    public void writingRequestHeaders() {
        if (this.sentRequestMillis != -1) {
            throw new IllegalStateException();
        }
        this.sentRequestMillis = System.currentTimeMillis();
    }

    boolean permitsRequestBody(Request request) {
        return HttpMethod.permitsRequestBody(request.method());
    }

    public r getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public d getBufferedRequestBody() {
        d dVar = this.bufferedRequestBody;
        if (dVar != null) {
            return dVar;
        }
        r requestBody = getRequestBody();
        if (requestBody == null) {
            return null;
        }
        dVar = m.a(requestBody);
        this.bufferedRequestBody = dVar;
        return dVar;
    }

    public boolean hasResponse() {
        return this.userResponse != null;
    }

    public Request getRequest() {
        return this.userRequest;
    }

    public Response getResponse() {
        if (this.userResponse != null) {
            return this.userResponse;
        }
        throw new IllegalStateException();
    }

    public Connection getConnection() {
        return this.streamAllocation.connection();
    }

    public HttpEngine recover(IOException iOException, r rVar) {
        if (!this.streamAllocation.recover(iOException, rVar) || !this.client.retryOnConnectionFailure()) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), (RetryableSink) rVar, this.priorResponse);
    }

    public HttpEngine recover(IOException iOException) {
        return recover(iOException, this.requestBodyOut);
    }

    private void maybeCache() throws IOException {
        InternalCache internalCache = Internal.instance.internalCache(this.client);
        if (internalCache != null) {
            if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
                this.storeRequest = internalCache.put(stripBody(this.userResponse));
            } else if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
                try {
                    internalCache.remove(this.networkRequest);
                } catch (IOException e) {
                }
            }
        }
    }

    public void releaseStreamAllocation() throws IOException {
        this.streamAllocation.release();
    }

    public void cancel() {
        this.streamAllocation.cancel();
    }

    public StreamAllocation close() {
        if (this.bufferedRequestBody != null) {
            Util.closeQuietly(this.bufferedRequestBody);
        } else if (this.requestBodyOut != null) {
            Util.closeQuietly(this.requestBodyOut);
        }
        if (this.userResponse != null) {
            Util.closeQuietly(this.userResponse.body());
        } else {
            this.streamAllocation.connectionFailed(null);
        }
        return this.streamAllocation;
    }

    private Response unzip(Response response) throws IOException {
        if (!this.transparentGzip || !"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        s kVar = new k(response.body().source());
        Headers build = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(build).body(new RealResponseBody(build, m.a(kVar))).build();
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(HttpHead.METHOD_NAME)) {
            return false;
        }
        int code = response.code();
        if ((code < 100 || code >= 200) && code != 204 && code != 304) {
            return true;
        }
        if (OkHeaders.contentLength(response) != -1 || HTTP.CHUNK_CODING.equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return true;
        }
        return false;
    }

    private Request networkRequest(Request request) throws IOException {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.hostHeader(request.url(), false));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", HTTP.CONN_KEEP_ALIVE);
        }
        if (request.header(HttpHeaders.ACCEPT_ENCODING) == null) {
            this.transparentGzip = true;
            newBuilder.header(HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        List loadForRequest = this.client.cookieJar().loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(SM.COOKIE, cookieHeader(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        return newBuilder.build();
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            Cookie cookie = (Cookie) list.get(i);
            stringBuilder.append(cookie.name()).append('=').append(cookie.value());
        }
        return stringBuilder.toString();
    }

    public void readResponse() throws IOException {
        if (this.userResponse == null) {
            if (this.networkRequest == null && this.cacheResponse == null) {
                throw new IllegalStateException("call sendRequest() first!");
            } else if (this.networkRequest != null) {
                Response readNetworkResponse;
                if (this.forWebSocket) {
                    this.httpStream.writeRequestHeaders(this.networkRequest);
                    readNetworkResponse = readNetworkResponse();
                } else if (this.callerWritesRequestBody) {
                    if (this.bufferedRequestBody != null && this.bufferedRequestBody.b().a() > 0) {
                        this.bufferedRequestBody.d();
                    }
                    if (this.sentRequestMillis == -1) {
                        if (OkHeaders.contentLength(this.networkRequest) == -1 && (this.requestBodyOut instanceof RetryableSink)) {
                            this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(((RetryableSink) this.requestBodyOut).contentLength())).build();
                        }
                        this.httpStream.writeRequestHeaders(this.networkRequest);
                    }
                    if (this.requestBodyOut != null) {
                        if (this.bufferedRequestBody != null) {
                            this.bufferedRequestBody.close();
                        } else {
                            this.requestBodyOut.close();
                        }
                        if (this.requestBodyOut instanceof RetryableSink) {
                            this.httpStream.writeRequestBody((RetryableSink) this.requestBodyOut);
                        }
                    }
                    readNetworkResponse = readNetworkResponse();
                } else {
                    readNetworkResponse = new NetworkInterceptorChain(0, this.networkRequest).proceed(this.networkRequest);
                }
                receiveHeaders(readNetworkResponse.headers());
                if (this.cacheResponse != null) {
                    if (validate(this.cacheResponse, readNetworkResponse)) {
                        this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), readNetworkResponse.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(readNetworkResponse)).build();
                        readNetworkResponse.body().close();
                        releaseStreamAllocation();
                        InternalCache internalCache = Internal.instance.internalCache(this.client);
                        internalCache.trackConditionalCacheHit();
                        internalCache.update(this.cacheResponse, stripBody(this.userResponse));
                        this.userResponse = unzip(this.userResponse);
                        return;
                    }
                    Util.closeQuietly(this.cacheResponse.body());
                }
                this.userResponse = readNetworkResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(readNetworkResponse)).build();
                if (hasBody(this.userResponse)) {
                    maybeCache();
                    this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
                }
            }
        }
    }

    private Response readNetworkResponse() throws IOException {
        this.httpStream.finishRequest();
        Response build = this.httpStream.readResponseHeaders().request(this.networkRequest).handshake(this.streamAllocation.connection().handshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            build = build.newBuilder().body(this.httpStream.openResponseBody(build)).build();
        }
        if ("close".equalsIgnoreCase(build.request().header("Connection")) || "close".equalsIgnoreCase(build.header("Connection"))) {
            this.streamAllocation.noNewStreams();
        }
        return build;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        r body = cacheRequest.body();
        if (body == null) {
            return response;
        }
        final e source = response.body().source();
        final d a = m.a(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), m.a(new s() {
            boolean cacheRequestClosed;

            public long read(c cVar, long j) throws IOException {
                try {
                    long read = source.read(cVar, j);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            a.close();
                        }
                        return -1;
                    }
                    cVar.a(a.b(), cVar.a() - read, read);
                    a.w();
                    return read;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public t timeout() {
                return source.timeout();
            }

            public void close() throws IOException {
                if (!(this.cacheRequestClosed || Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        }))).build();
    }

    private static boolean validate(Response response, Response response2) {
        if (response2.code() == 304) {
            return true;
        }
        Date date = response.headers().getDate(HttpHeaders.LAST_MODIFIED);
        if (date != null) {
            Date date2 = response2.headers().getDate(HttpHeaders.LAST_MODIFIED);
            if (date2 != null && date2.getTime() < date.getTime()) {
                return true;
            }
        }
        return false;
    }

    private static Headers combine(Headers headers, Headers headers2) throws IOException {
        int i;
        int i2 = 0;
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (!(HttpHeaders.WARNING.equalsIgnoreCase(name) && value.startsWith("1")) && (!OkHeaders.isEndToEnd(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        i = headers2.size();
        while (i2 < i) {
            String name2 = headers2.name(i2);
            if (!"Content-Length".equalsIgnoreCase(name2) && OkHeaders.isEndToEnd(name2)) {
                builder.add(name2, headers2.value(i2));
            }
            i2++;
        }
        return builder.build();
    }

    public void receiveHeaders(Headers headers) throws IOException {
        if (this.client.cookieJar() != CookieJar.NO_COOKIES) {
            List parseAll = Cookie.parseAll(this.userRequest.url(), headers);
            if (!parseAll.isEmpty()) {
                this.client.cookieJar().saveFromResponse(this.userRequest.url(), parseAll);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Request followUpRequest() throws java.io.IOException {
        /*
        r5 = this;
        r1 = 0;
        r0 = r5.userResponse;
        if (r0 != 0) goto L_0x000b;
    L_0x0005:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x000b:
        r0 = r5.streamAllocation;
        r0 = r0.connection();
        if (r0 == 0) goto L_0x0027;
    L_0x0013:
        r0 = r0.route();
    L_0x0017:
        r2 = r5.userResponse;
        r2 = r2.code();
        r3 = r5.userRequest;
        r3 = r3.method();
        switch(r2) {
            case 300: goto L_0x0063;
            case 301: goto L_0x0063;
            case 302: goto L_0x0063;
            case 303: goto L_0x0063;
            case 307: goto L_0x0053;
            case 308: goto L_0x0053;
            case 401: goto L_0x0046;
            case 407: goto L_0x0029;
            case 408: goto L_0x00dc;
            default: goto L_0x0026;
        };
    L_0x0026:
        return r1;
    L_0x0027:
        r0 = r1;
        goto L_0x0017;
    L_0x0029:
        if (r0 == 0) goto L_0x003f;
    L_0x002b:
        r1 = r0.proxy();
    L_0x002f:
        r1 = r1.type();
        r2 = java.net.Proxy.Type.HTTP;
        if (r1 == r2) goto L_0x0046;
    L_0x0037:
        r0 = new java.net.ProtocolException;
        r1 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        r0.<init>(r1);
        throw r0;
    L_0x003f:
        r1 = r5.client;
        r1 = r1.proxy();
        goto L_0x002f;
    L_0x0046:
        r1 = r5.client;
        r1 = r1.authenticator();
        r2 = r5.userResponse;
        r1 = r1.authenticate(r0, r2);
        goto L_0x0026;
    L_0x0053:
        r0 = "GET";
        r0 = r3.equals(r0);
        if (r0 != 0) goto L_0x0063;
    L_0x005b:
        r0 = "HEAD";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0026;
    L_0x0063:
        r0 = r5.client;
        r0 = r0.followRedirects();
        if (r0 == 0) goto L_0x0026;
    L_0x006b:
        r0 = r5.userResponse;
        r2 = "Location";
        r0 = r0.header(r2);
        if (r0 == 0) goto L_0x0026;
    L_0x0075:
        r2 = r5.userRequest;
        r2 = r2.url();
        r0 = r2.resolve(r0);
        if (r0 == 0) goto L_0x0026;
    L_0x0081:
        r2 = r0.scheme();
        r4 = r5.userRequest;
        r4 = r4.url();
        r4 = r4.scheme();
        r2 = r2.equals(r4);
        if (r2 != 0) goto L_0x009d;
    L_0x0095:
        r2 = r5.client;
        r2 = r2.followSslRedirects();
        if (r2 == 0) goto L_0x0026;
    L_0x009d:
        r2 = r5.userRequest;
        r2 = r2.newBuilder();
        r4 = okhttp3.internal.http.HttpMethod.permitsRequestBody(r3);
        if (r4 == 0) goto L_0x00c3;
    L_0x00a9:
        r4 = okhttp3.internal.http.HttpMethod.redirectsToGet(r3);
        if (r4 == 0) goto L_0x00d8;
    L_0x00af:
        r3 = "GET";
        r2.method(r3, r1);
    L_0x00b4:
        r1 = "Transfer-Encoding";
        r2.removeHeader(r1);
        r1 = "Content-Length";
        r2.removeHeader(r1);
        r1 = "Content-Type";
        r2.removeHeader(r1);
    L_0x00c3:
        r1 = r5.sameConnection(r0);
        if (r1 != 0) goto L_0x00ce;
    L_0x00c9:
        r1 = "Authorization";
        r2.removeHeader(r1);
    L_0x00ce:
        r0 = r2.url(r0);
        r1 = r0.build();
        goto L_0x0026;
    L_0x00d8:
        r2.method(r3, r1);
        goto L_0x00b4;
    L_0x00dc:
        r0 = r5.requestBodyOut;
        if (r0 == 0) goto L_0x00e6;
    L_0x00e0:
        r0 = r5.requestBodyOut;
        r0 = r0 instanceof okhttp3.internal.http.RetryableSink;
        if (r0 == 0) goto L_0x00f1;
    L_0x00e6:
        r0 = 1;
    L_0x00e7:
        r2 = r5.callerWritesRequestBody;
        if (r2 == 0) goto L_0x00ed;
    L_0x00eb:
        if (r0 == 0) goto L_0x0026;
    L_0x00ed:
        r1 = r5.userRequest;
        goto L_0x0026;
    L_0x00f1:
        r0 = 0;
        goto L_0x00e7;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpEngine.followUpRequest():okhttp3.Request");
    }

    public boolean sameConnection(HttpUrl httpUrl) {
        HttpUrl url = this.userRequest.url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    private static Address createAddress(OkHttpClient okHttpClient, Request request) {
        SSLSocketFactory sslSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner = null;
        if (request.isHttps()) {
            sslSocketFactory = okHttpClient.sslSocketFactory();
            hostnameVerifier = okHttpClient.hostnameVerifier();
            certificatePinner = okHttpClient.certificatePinner();
        } else {
            hostnameVerifier = null;
            sslSocketFactory = null;
        }
        return new Address(request.url().host(), request.url().port(), okHttpClient.dns(), okHttpClient.socketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.proxyAuthenticator(), okHttpClient.proxy(), okHttpClient.protocols(), okHttpClient.connectionSpecs(), okHttpClient.proxySelector());
    }
}
