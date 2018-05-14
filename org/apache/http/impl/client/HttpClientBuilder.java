package org.apache.http.impl.client;

import java.io.Closeable;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.BackoffManager;
import org.apache.http.client.ConnectionBackoffStrategy;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.client.protocol.RequestAuthCache;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.client.protocol.RequestExpectContinue;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Lookup;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.auth.KerberosSchemeFactory;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.DefaultRoutePlanner;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.impl.cookie.IgnoreSpecFactory;
import org.apache.http.impl.cookie.NetscapeDraftSpecFactory;
import org.apache.http.impl.cookie.RFC2109SpecFactory;
import org.apache.http.impl.cookie.RFC2965SpecFactory;
import org.apache.http.impl.execchain.BackoffStrategyExec;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.impl.execchain.MainClientExec;
import org.apache.http.impl.execchain.ProtocolExec;
import org.apache.http.impl.execchain.RedirectExec;
import org.apache.http.impl.execchain.RetryExec;
import org.apache.http.impl.execchain.ServiceUnavailableRetryExec;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpProcessorBuilder;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.TextUtils;
import org.apache.http.util.VersionInfo;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class HttpClientBuilder {
    static final String DEFAULT_USER_AGENT;
    private boolean authCachingDisabled;
    private Lookup<AuthSchemeProvider> authSchemeRegistry;
    private boolean automaticRetriesDisabled;
    private BackoffManager backoffManager;
    private List<Closeable> closeables;
    private HttpClientConnectionManager connManager;
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    private boolean connectionStateDisabled;
    private boolean contentCompressionDisabled;
    private boolean cookieManagementDisabled;
    private Lookup<CookieSpecProvider> cookieSpecRegistry;
    private CookieStore cookieStore;
    private CredentialsProvider credentialsProvider;
    private ConnectionConfig defaultConnectionConfig;
    private Collection<? extends Header> defaultHeaders;
    private RequestConfig defaultRequestConfig;
    private SocketConfig defaultSocketConfig;
    private X509HostnameVerifier hostnameVerifier;
    private HttpProcessor httpprocessor;
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private int maxConnPerRoute = 0;
    private int maxConnTotal = 0;
    private HttpHost proxy;
    private AuthenticationStrategy proxyAuthStrategy;
    private boolean redirectHandlingDisabled;
    private RedirectStrategy redirectStrategy;
    private HttpRequestExecutor requestExec;
    private LinkedList<HttpRequestInterceptor> requestFirst;
    private LinkedList<HttpRequestInterceptor> requestLast;
    private LinkedList<HttpResponseInterceptor> responseFirst;
    private LinkedList<HttpResponseInterceptor> responseLast;
    private HttpRequestRetryHandler retryHandler;
    private ConnectionReuseStrategy reuseStrategy;
    private HttpRoutePlanner routePlanner;
    private SchemePortResolver schemePortResolver;
    private ServiceUnavailableRetryStrategy serviceUnavailStrategy;
    private LayeredConnectionSocketFactory sslSocketFactory;
    private SSLContext sslcontext;
    private boolean systemProperties;
    private AuthenticationStrategy targetAuthStrategy;
    private String userAgent;
    private UserTokenHandler userTokenHandler;

    static {
        VersionInfo loadVersionInfo = VersionInfo.loadVersionInfo("org.apache.http.client", HttpClientBuilder.class.getClassLoader());
        DEFAULT_USER_AGENT = "Apache-HttpClient/" + (loadVersionInfo != null ? loadVersionInfo.getRelease() : VersionInfo.UNAVAILABLE) + " (java 1.5)";
    }

    public static HttpClientBuilder create() {
        return new HttpClientBuilder();
    }

    protected HttpClientBuilder() {
    }

    public final HttpClientBuilder setRequestExecutor(HttpRequestExecutor httpRequestExecutor) {
        this.requestExec = httpRequestExecutor;
        return this;
    }

    public final HttpClientBuilder setHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.hostnameVerifier = x509HostnameVerifier;
        return this;
    }

    public final HttpClientBuilder setSslcontext(SSLContext sSLContext) {
        this.sslcontext = sSLContext;
        return this;
    }

    public final HttpClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory layeredConnectionSocketFactory) {
        this.sslSocketFactory = layeredConnectionSocketFactory;
        return this;
    }

    public final HttpClientBuilder setMaxConnTotal(int i) {
        this.maxConnTotal = i;
        return this;
    }

    public final HttpClientBuilder setMaxConnPerRoute(int i) {
        this.maxConnPerRoute = i;
        return this;
    }

    public final HttpClientBuilder setDefaultSocketConfig(SocketConfig socketConfig) {
        this.defaultSocketConfig = socketConfig;
        return this;
    }

    public final HttpClientBuilder setDefaultConnectionConfig(ConnectionConfig connectionConfig) {
        this.defaultConnectionConfig = connectionConfig;
        return this;
    }

    public final HttpClientBuilder setConnectionManager(HttpClientConnectionManager httpClientConnectionManager) {
        this.connManager = httpClientConnectionManager;
        return this;
    }

    public final HttpClientBuilder setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.reuseStrategy = connectionReuseStrategy;
        return this;
    }

    public final HttpClientBuilder setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        return this;
    }

    public final HttpClientBuilder setTargetAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.targetAuthStrategy = authenticationStrategy;
        return this;
    }

    public final HttpClientBuilder setProxyAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.proxyAuthStrategy = authenticationStrategy;
        return this;
    }

    public final HttpClientBuilder setUserTokenHandler(UserTokenHandler userTokenHandler) {
        this.userTokenHandler = userTokenHandler;
        return this;
    }

    public final HttpClientBuilder disableConnectionState() {
        this.connectionStateDisabled = true;
        return this;
    }

    public final HttpClientBuilder setSchemePortResolver(SchemePortResolver schemePortResolver) {
        this.schemePortResolver = schemePortResolver;
        return this;
    }

    public final HttpClientBuilder setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    public final HttpClientBuilder setDefaultHeaders(Collection<? extends Header> collection) {
        this.defaultHeaders = collection;
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor != null) {
            if (this.responseFirst == null) {
                this.responseFirst = new LinkedList();
            }
            this.responseFirst.addFirst(httpResponseInterceptor);
        }
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor != null) {
            if (this.responseLast == null) {
                this.responseLast = new LinkedList();
            }
            this.responseLast.addLast(httpResponseInterceptor);
        }
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor != null) {
            if (this.requestFirst == null) {
                this.requestFirst = new LinkedList();
            }
            this.requestFirst.addFirst(httpRequestInterceptor);
        }
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor != null) {
            if (this.requestLast == null) {
                this.requestLast = new LinkedList();
            }
            this.requestLast.addLast(httpRequestInterceptor);
        }
        return this;
    }

    public final HttpClientBuilder disableCookieManagement() {
        this.cookieManagementDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableContentCompression() {
        this.contentCompressionDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableAuthCaching() {
        this.authCachingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setHttpProcessor(HttpProcessor httpProcessor) {
        this.httpprocessor = httpProcessor;
        return this;
    }

    public final HttpClientBuilder setRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler) {
        this.retryHandler = httpRequestRetryHandler;
        return this;
    }

    public final HttpClientBuilder disableAutomaticRetries() {
        this.automaticRetriesDisabled = true;
        return this;
    }

    public final HttpClientBuilder setProxy(HttpHost httpHost) {
        this.proxy = httpHost;
        return this;
    }

    public final HttpClientBuilder setRoutePlanner(HttpRoutePlanner httpRoutePlanner) {
        this.routePlanner = httpRoutePlanner;
        return this;
    }

    public final HttpClientBuilder setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
        return this;
    }

    public final HttpClientBuilder disableRedirectHandling() {
        this.redirectHandlingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setConnectionBackoffStrategy(ConnectionBackoffStrategy connectionBackoffStrategy) {
        this.connectionBackoffStrategy = connectionBackoffStrategy;
        return this;
    }

    public final HttpClientBuilder setBackoffManager(BackoffManager backoffManager) {
        this.backoffManager = backoffManager;
        return this;
    }

    public final HttpClientBuilder setServiceUnavailableRetryStrategy(ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this.serviceUnavailStrategy = serviceUnavailableRetryStrategy;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        return this;
    }

    public final HttpClientBuilder setDefaultCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
        return this;
    }

    public final HttpClientBuilder setDefaultAuthSchemeRegistry(Lookup<AuthSchemeProvider> lookup) {
        this.authSchemeRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieSpecRegistry(Lookup<CookieSpecProvider> lookup) {
        this.cookieSpecRegistry = lookup;
        return this;
    }

    public final HttpClientBuilder setDefaultRequestConfig(RequestConfig requestConfig) {
        this.defaultRequestConfig = requestConfig;
        return this;
    }

    public final HttpClientBuilder useSystemProperties() {
        this.systemProperties = true;
        return this;
    }

    protected ClientExecChain decorateMainExec(ClientExecChain clientExecChain) {
        return clientExecChain;
    }

    protected ClientExecChain decorateProtocolExec(ClientExecChain clientExecChain) {
        return clientExecChain;
    }

    protected void addCloseable(Closeable closeable) {
        if (closeable != null) {
            if (this.closeables == null) {
                this.closeables = new ArrayList();
            }
            this.closeables.add(closeable);
        }
    }

    private static String[] split(String str) {
        if (TextUtils.isBlank(str)) {
            return null;
        }
        return str.split(" *, *");
    }

    public CloseableHttpClient build() {
        ClientExecChain clientExecChain;
        ClientExecChain clientExecChain2;
        RequestConfig requestConfig;
        List list = null;
        HttpRequestExecutor httpRequestExecutor = this.requestExec;
        if (httpRequestExecutor == null) {
            httpRequestExecutor = new HttpRequestExecutor();
        }
        HttpClientConnectionManager httpClientConnectionManager = this.connManager;
        if (httpClientConnectionManager == null) {
            Object obj = this.sslSocketFactory;
            if (obj == null) {
                String[] split;
                X509HostnameVerifier x509HostnameVerifier;
                String[] split2 = this.systemProperties ? split(System.getProperty("https.protocols")) : null;
                if (this.systemProperties) {
                    split = split(System.getProperty("https.cipherSuites"));
                } else {
                    split = null;
                }
                X509HostnameVerifier x509HostnameVerifier2 = this.hostnameVerifier;
                if (x509HostnameVerifier2 == null) {
                    x509HostnameVerifier = SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
                } else {
                    x509HostnameVerifier = x509HostnameVerifier2;
                }
                if (this.sslcontext != null) {
                    obj = new SSLConnectionSocketFactory(this.sslcontext, split2, split, x509HostnameVerifier);
                } else if (this.systemProperties) {
                    SSLConnectionSocketFactory sSLConnectionSocketFactory = new SSLConnectionSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault(), split2, split, x509HostnameVerifier);
                } else {
                    obj = new SSLConnectionSocketFactory(SSLContexts.createDefault(), x509HostnameVerifier);
                }
            }
            httpClientConnectionManager = new PoolingHttpClientConnectionManager(RegistryBuilder.create().register(HttpHost.DEFAULT_SCHEME_NAME, PlainConnectionSocketFactory.getSocketFactory()).register("https", obj).build());
            if (this.defaultSocketConfig != null) {
                httpClientConnectionManager.setDefaultSocketConfig(this.defaultSocketConfig);
            }
            if (this.defaultConnectionConfig != null) {
                httpClientConnectionManager.setDefaultConnectionConfig(this.defaultConnectionConfig);
            }
            if (this.systemProperties) {
                if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
                    int parseInt = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
                    httpClientConnectionManager.setDefaultMaxPerRoute(parseInt);
                    httpClientConnectionManager.setMaxTotal(parseInt * 2);
                }
            }
            if (this.maxConnTotal > 0) {
                httpClientConnectionManager.setMaxTotal(this.maxConnTotal);
            }
            if (this.maxConnPerRoute > 0) {
                httpClientConnectionManager.setDefaultMaxPerRoute(this.maxConnPerRoute);
            }
        }
        ConnectionReuseStrategy connectionReuseStrategy = this.reuseStrategy;
        if (connectionReuseStrategy == null) {
            if (this.systemProperties) {
                DefaultConnectionReuseStrategy defaultConnectionReuseStrategy;
                if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
                    defaultConnectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
                } else {
                    defaultConnectionReuseStrategy = NoConnectionReuseStrategy.INSTANCE;
                }
                connectionReuseStrategy = defaultConnectionReuseStrategy;
            } else {
                connectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
            }
        }
        ConnectionKeepAliveStrategy connectionKeepAliveStrategy = this.keepAliveStrategy;
        if (connectionKeepAliveStrategy == null) {
            connectionKeepAliveStrategy = DefaultConnectionKeepAliveStrategy.INSTANCE;
        }
        AuthenticationStrategy authenticationStrategy = this.targetAuthStrategy;
        if (authenticationStrategy == null) {
            authenticationStrategy = TargetAuthenticationStrategy.INSTANCE;
        }
        AuthenticationStrategy authenticationStrategy2 = this.proxyAuthStrategy;
        if (authenticationStrategy2 == null) {
            authenticationStrategy2 = ProxyAuthenticationStrategy.INSTANCE;
        }
        UserTokenHandler userTokenHandler = this.userTokenHandler;
        if (userTokenHandler == null) {
            if (this.connectionStateDisabled) {
                userTokenHandler = NoopUserTokenHandler.INSTANCE;
            } else {
                userTokenHandler = DefaultUserTokenHandler.INSTANCE;
            }
        }
        ClientExecChain decorateMainExec = decorateMainExec(new MainClientExec(httpRequestExecutor, httpClientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, authenticationStrategy, authenticationStrategy2, userTokenHandler));
        HttpProcessor httpProcessor = this.httpprocessor;
        if (httpProcessor == null) {
            String str;
            HttpProcessorBuilder create;
            Iterator it;
            Iterator it2;
            String str2 = this.userAgent;
            if (str2 == null) {
                if (this.systemProperties) {
                    str2 = System.getProperty("http.agent");
                }
                if (str2 == null) {
                    str = DEFAULT_USER_AGENT;
                    create = HttpProcessorBuilder.create();
                    if (this.requestFirst != null) {
                        it = this.requestFirst.iterator();
                        while (it.hasNext()) {
                            create.addFirst((HttpRequestInterceptor) it.next());
                        }
                    }
                    if (this.responseFirst != null) {
                        it = this.responseFirst.iterator();
                        while (it.hasNext()) {
                            create.addFirst((HttpResponseInterceptor) it.next());
                        }
                    }
                    create.addAll(new RequestDefaultHeaders(this.defaultHeaders), new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(str), new RequestExpectContinue());
                    if (!this.cookieManagementDisabled) {
                        create.add(new RequestAddCookies());
                    }
                    if (!this.contentCompressionDisabled) {
                        create.add(new RequestAcceptEncoding());
                    }
                    if (!this.authCachingDisabled) {
                        create.add(new RequestAuthCache());
                    }
                    if (!this.cookieManagementDisabled) {
                        create.add(new ResponseProcessCookies());
                    }
                    if (!this.contentCompressionDisabled) {
                        create.add(new ResponseContentEncoding());
                    }
                    if (this.requestLast != null) {
                        it2 = this.requestLast.iterator();
                        while (it2.hasNext()) {
                            create.addLast((HttpRequestInterceptor) it2.next());
                        }
                    }
                    if (this.responseLast != null) {
                        it2 = this.responseLast.iterator();
                        while (it2.hasNext()) {
                            create.addLast((HttpResponseInterceptor) it2.next());
                        }
                    }
                    httpProcessor = create.build();
                }
            }
            str = str2;
            create = HttpProcessorBuilder.create();
            if (this.requestFirst != null) {
                it = this.requestFirst.iterator();
                while (it.hasNext()) {
                    create.addFirst((HttpRequestInterceptor) it.next());
                }
            }
            if (this.responseFirst != null) {
                it = this.responseFirst.iterator();
                while (it.hasNext()) {
                    create.addFirst((HttpResponseInterceptor) it.next());
                }
            }
            create.addAll(new RequestDefaultHeaders(this.defaultHeaders), new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(str), new RequestExpectContinue());
            if (this.cookieManagementDisabled) {
                create.add(new RequestAddCookies());
            }
            if (this.contentCompressionDisabled) {
                create.add(new RequestAcceptEncoding());
            }
            if (this.authCachingDisabled) {
                create.add(new RequestAuthCache());
            }
            if (this.cookieManagementDisabled) {
                create.add(new ResponseProcessCookies());
            }
            if (this.contentCompressionDisabled) {
                create.add(new ResponseContentEncoding());
            }
            if (this.requestLast != null) {
                it2 = this.requestLast.iterator();
                while (it2.hasNext()) {
                    create.addLast((HttpRequestInterceptor) it2.next());
                }
            }
            if (this.responseLast != null) {
                it2 = this.responseLast.iterator();
                while (it2.hasNext()) {
                    create.addLast((HttpResponseInterceptor) it2.next());
                }
            }
            httpProcessor = create.build();
        }
        decorateMainExec = decorateProtocolExec(new ProtocolExec(decorateMainExec, httpProcessor));
        if (this.automaticRetriesDisabled) {
            clientExecChain = decorateMainExec;
        } else {
            HttpRequestRetryHandler httpRequestRetryHandler = this.retryHandler;
            if (httpRequestRetryHandler == null) {
                httpRequestRetryHandler = DefaultHttpRequestRetryHandler.INSTANCE;
            }
            clientExecChain = new RetryExec(decorateMainExec, httpRequestRetryHandler);
        }
        HttpRoutePlanner httpRoutePlanner = this.routePlanner;
        if (httpRoutePlanner == null) {
            SchemePortResolver schemePortResolver = this.schemePortResolver;
            if (schemePortResolver == null) {
                schemePortResolver = DefaultSchemePortResolver.INSTANCE;
            }
            if (this.proxy != null) {
                httpRoutePlanner = new DefaultProxyRoutePlanner(this.proxy, schemePortResolver);
            } else if (this.systemProperties) {
                httpRoutePlanner = new SystemDefaultRoutePlanner(schemePortResolver, ProxySelector.getDefault());
            } else {
                httpRoutePlanner = new DefaultRoutePlanner(schemePortResolver);
            }
        }
        if (!this.redirectHandlingDisabled) {
            RedirectStrategy redirectStrategy = this.redirectStrategy;
            if (redirectStrategy == null) {
                redirectStrategy = DefaultRedirectStrategy.INSTANCE;
            }
            clientExecChain = new RedirectExec(clientExecChain, httpRoutePlanner, redirectStrategy);
        }
        ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy = this.serviceUnavailStrategy;
        if (serviceUnavailableRetryStrategy != null) {
            clientExecChain = new ServiceUnavailableRetryExec(clientExecChain, serviceUnavailableRetryStrategy);
        }
        BackoffManager backoffManager = this.backoffManager;
        ConnectionBackoffStrategy connectionBackoffStrategy = this.connectionBackoffStrategy;
        if (backoffManager == null || connectionBackoffStrategy == null) {
            clientExecChain2 = clientExecChain;
        } else {
            clientExecChain2 = new BackoffStrategyExec(clientExecChain, connectionBackoffStrategy, backoffManager);
        }
        Lookup lookup = this.authSchemeRegistry;
        if (lookup == null) {
            lookup = RegistryBuilder.create().register("Basic", new BasicSchemeFactory()).register("Digest", new DigestSchemeFactory()).register("NTLM", new NTLMSchemeFactory()).register("negotiate", new SPNegoSchemeFactory()).register("Kerberos", new KerberosSchemeFactory()).build();
        }
        Lookup lookup2 = this.cookieSpecRegistry;
        if (lookup2 == null) {
            lookup2 = RegistryBuilder.create().register("best-match", new BestMatchSpecFactory()).register(CookieSpecs.STANDARD, new RFC2965SpecFactory()).register("compatibility", new BrowserCompatSpecFactory()).register("netscape", new NetscapeDraftSpecFactory()).register("ignoreCookies", new IgnoreSpecFactory()).register(CookiePolicy.RFC_2109, new RFC2109SpecFactory()).register(CookiePolicy.RFC_2965, new RFC2965SpecFactory()).build();
        }
        CookieStore cookieStore = this.cookieStore;
        if (cookieStore == null) {
            cookieStore = new BasicCookieStore();
        }
        CredentialsProvider credentialsProvider = this.credentialsProvider;
        if (credentialsProvider == null) {
            if (this.systemProperties) {
                credentialsProvider = new SystemDefaultCredentialsProvider();
            } else {
                credentialsProvider = new BasicCredentialsProvider();
            }
        }
        if (this.defaultRequestConfig != null) {
            requestConfig = this.defaultRequestConfig;
        } else {
            requestConfig = RequestConfig.DEFAULT;
        }
        if (this.closeables != null) {
            list = new ArrayList(this.closeables);
        }
        return new InternalHttpClient(clientExecChain2, httpClientConnectionManager, httpRoutePlanner, lookup2, lookup, cookieStore, credentialsProvider, requestConfig, list);
    }
}
