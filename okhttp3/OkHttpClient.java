package okhttp3;

import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call.Factory;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Platform;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.tls.TrustRootIndex;

/* compiled from: TbsSdkJava */
public class OkHttpClient implements Cloneable, Factory {
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT);
    private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);
    final Authenticator authenticator;
    final Cache cache;
    final CertificatePinner certificatePinner;
    final int connectTimeout;
    final ConnectionPool connectionPool;
    final List<ConnectionSpec> connectionSpecs;
    final CookieJar cookieJar;
    final Dispatcher dispatcher;
    final Dns dns;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;
    final InternalCache internalCache;
    final List<Interceptor> networkInterceptors;
    final List<Protocol> protocols;
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final TrustRootIndex trustRootIndex;
    final int writeTimeout;

    /* compiled from: TbsSdkJava */
    public static final class Builder {
        Authenticator authenticator;
        Cache cache;
        CertificatePinner certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<ConnectionSpec> connectionSpecs;
        CookieJar cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;
        InternalCache internalCache;
        final List<Interceptor> networkInterceptors;
        List<Protocol> protocols;
        Proxy proxy;
        Authenticator proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;
        SSLSocketFactory sslSocketFactory;
        TrustRootIndex trustRootIndex;
        int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.proxySelector = ProxySelector.getDefault();
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.proxyAuthenticator = Authenticator.NONE;
            this.authenticator = Authenticator.NONE;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
        }

        Builder(OkHttpClient okHttpClient) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = okHttpClient.dispatcher;
            this.proxy = okHttpClient.proxy;
            this.protocols = okHttpClient.protocols;
            this.connectionSpecs = okHttpClient.connectionSpecs;
            this.interceptors.addAll(okHttpClient.interceptors);
            this.networkInterceptors.addAll(okHttpClient.networkInterceptors);
            this.proxySelector = okHttpClient.proxySelector;
            this.cookieJar = okHttpClient.cookieJar;
            this.internalCache = okHttpClient.internalCache;
            this.cache = okHttpClient.cache;
            this.socketFactory = okHttpClient.socketFactory;
            this.sslSocketFactory = okHttpClient.sslSocketFactory;
            this.trustRootIndex = okHttpClient.trustRootIndex;
            this.hostnameVerifier = okHttpClient.hostnameVerifier;
            this.certificatePinner = okHttpClient.certificatePinner;
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator;
            this.authenticator = okHttpClient.authenticator;
            this.connectionPool = okHttpClient.connectionPool;
            this.dns = okHttpClient.dns;
            this.followSslRedirects = okHttpClient.followSslRedirects;
            this.followRedirects = okHttpClient.followRedirects;
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
            this.connectTimeout = okHttpClient.connectTimeout;
            this.readTimeout = okHttpClient.readTimeout;
            this.writeTimeout = okHttpClient.writeTimeout;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(j);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || j <= 0) {
                    this.connectTimeout = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(j);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || j <= 0) {
                    this.readTimeout = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(j);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || j <= 0) {
                    this.writeTimeout = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        public Builder proxy(Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            if (cookieJar == null) {
                throw new NullPointerException("cookieJar == null");
            }
            this.cookieJar = cookieJar;
            return this;
        }

        void setInternalCache(InternalCache internalCache) {
            this.internalCache = internalCache;
            this.cache = null;
        }

        public Builder cache(Cache cache) {
            this.cache = cache;
            this.internalCache = null;
            return this;
        }

        public Builder dns(Dns dns) {
            if (dns == null) {
                throw new NullPointerException("dns == null");
            }
            this.dns = dns;
            return this;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new NullPointerException("socketFactory == null");
            }
            this.socketFactory = socketFactory;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.sslSocketFactory = sSLSocketFactory;
            this.trustRootIndex = null;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            if (certificatePinner == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        public Builder authenticator(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.authenticator = authenticator;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.proxyAuthenticator = authenticator;
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            if (connectionPool == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.connectionPool = connectionPool;
            return this;
        }

        public Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.dispatcher = dispatcher;
            return this;
        }

        public Builder protocols(List<Protocol> list) {
            List immutableList = Util.immutableList((List) list);
            if (!immutableList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + immutableList);
            } else if (immutableList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + immutableList);
            } else if (immutableList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            } else {
                this.protocols = Util.immutableList(immutableList);
                return this;
            }
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = Util.immutableList((List) list);
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public OkHttpClient build() {
            return new OkHttpClient();
        }
    }

    static {
        Internal.instance = new Internal() {
            public void addLenient(okhttp3.Headers.Builder builder, String str) {
                builder.addLenient(str);
            }

            public void addLenient(okhttp3.Headers.Builder builder, String str, String str2) {
                builder.addLenient(str, str2);
            }

            public void setCache(Builder builder, InternalCache internalCache) {
                builder.setInternalCache(internalCache);
            }

            public InternalCache internalCache(OkHttpClient okHttpClient) {
                return okHttpClient.internalCache();
            }

            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.connectionBecameIdle(realConnection);
            }

            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.get(address, streamAllocation);
            }

            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.put(realConnection);
            }

            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.routeDatabase;
            }

            public void callEnqueue(Call call, Callback callback, boolean z) {
                ((RealCall) call).enqueue(callback, z);
            }

            public StreamAllocation callEngineGetStreamAllocation(Call call) {
                return ((RealCall) call).engine.streamAllocation;
            }

            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.apply(sSLSocket, z);
            }

            public HttpUrl getHttpUrlChecked(String str) throws MalformedURLException, UnknownHostException {
                return HttpUrl.getChecked(str);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    private OkHttpClient(Builder builder) {
        this.dispatcher = builder.dispatcher;
        this.proxy = builder.proxy;
        this.protocols = builder.protocols;
        this.connectionSpecs = builder.connectionSpecs;
        this.interceptors = Util.immutableList(builder.interceptors);
        this.networkInterceptors = Util.immutableList(builder.networkInterceptors);
        this.proxySelector = builder.proxySelector;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.internalCache = builder.internalCache;
        this.socketFactory = builder.socketFactory;
        Object obj = null;
        for (ConnectionSpec connectionSpec : this.connectionSpecs) {
            Object obj2;
            if (obj != null || connectionSpec.isTls()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            obj = obj2;
        }
        if (builder.sslSocketFactory != null || obj == null) {
            this.sslSocketFactory = builder.sslSocketFactory;
        } else {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.sslSocketFactory = instance.getSocketFactory();
            } catch (GeneralSecurityException e) {
                throw new AssertionError();
            }
        }
        if (this.sslSocketFactory == null || builder.trustRootIndex != null) {
            this.trustRootIndex = builder.trustRootIndex;
            this.certificatePinner = builder.certificatePinner;
        } else {
            X509TrustManager trustManager = Platform.get().trustManager(this.sslSocketFactory);
            if (trustManager == null) {
                throw new IllegalStateException("Unable to extract the trust manager on " + Platform.get() + ", sslSocketFactory is " + this.sslSocketFactory.getClass());
            }
            this.trustRootIndex = Platform.get().trustRootIndex(trustManager);
            this.certificatePinner = builder.certificatePinner.newBuilder().trustRootIndex(this.trustRootIndex).build();
        }
        this.hostnameVerifier = builder.hostnameVerifier;
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.authenticator = builder.authenticator;
        this.connectionPool = builder.connectionPool;
        this.dns = builder.dns;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public Cache cache() {
        return this.cache;
    }

    InternalCache internalCache() {
        return this.cache != null ? this.cache.internalCache : this.internalCache;
    }

    public Dns dns() {
        return this.dns;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public Authenticator authenticator() {
        return this.authenticator;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Call newCall(Request request) {
        return new RealCall(this, request);
    }

    public Builder newBuilder() {
        return new Builder(this);
    }
}
