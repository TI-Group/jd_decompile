package org.apache.http.impl.client;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.params.HttpClientParamConfig;
import org.apache.http.client.protocol.RequestClientConnControl;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteInfo.LayerType;
import org.apache.http.conn.routing.RouteInfo.TunnelType;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.auth.HttpAuthenticator;
import org.apache.http.impl.auth.KerberosSchemeFactory;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.execchain.TunnelRefusedException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

/* compiled from: TbsSdkJava */
public class ProxyClient {
    private final AuthSchemeRegistry authSchemeRegistry;
    private final HttpAuthenticator authenticator;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    private final ConnectionConfig connectionConfig;
    private final HttpProcessor httpProcessor;
    private final AuthState proxyAuthState;
    private final ProxyAuthenticationStrategy proxyAuthStrategy;
    private final RequestConfig requestConfig;
    private final HttpRequestExecutor requestExec;
    private final ConnectionReuseStrategy reuseStrategy;

    public ProxyClient(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> httpConnectionFactory, ConnectionConfig connectionConfig, RequestConfig requestConfig) {
        if (httpConnectionFactory == null) {
            httpConnectionFactory = ManagedHttpClientConnectionFactory.INSTANCE;
        }
        this.connFactory = httpConnectionFactory;
        if (connectionConfig == null) {
            connectionConfig = ConnectionConfig.DEFAULT;
        }
        this.connectionConfig = connectionConfig;
        if (requestConfig == null) {
            requestConfig = RequestConfig.DEFAULT;
        }
        this.requestConfig = requestConfig;
        this.httpProcessor = new ImmutableHttpProcessor(new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent());
        this.requestExec = new HttpRequestExecutor();
        this.proxyAuthStrategy = new ProxyAuthenticationStrategy();
        this.authenticator = new HttpAuthenticator();
        this.proxyAuthState = new AuthState();
        this.authSchemeRegistry = new AuthSchemeRegistry();
        this.authSchemeRegistry.register("Basic", new BasicSchemeFactory());
        this.authSchemeRegistry.register("Digest", new DigestSchemeFactory());
        this.authSchemeRegistry.register("NTLM", new NTLMSchemeFactory());
        this.authSchemeRegistry.register("negotiate", new SPNegoSchemeFactory());
        this.authSchemeRegistry.register("Kerberos", new KerberosSchemeFactory());
        this.reuseStrategy = new DefaultConnectionReuseStrategy();
    }

    @Deprecated
    public ProxyClient(HttpParams httpParams) {
        this(null, HttpParamConfig.getConnectionConfig(httpParams), HttpClientParamConfig.getRequestConfig(httpParams));
    }

    public ProxyClient(RequestConfig requestConfig) {
        this(null, null, requestConfig);
    }

    public ProxyClient() {
        this(null, null, null);
    }

    @Deprecated
    public HttpParams getParams() {
        return new BasicHttpParams();
    }

    @Deprecated
    public AuthSchemeRegistry getAuthSchemeRegistry() {
        return this.authSchemeRegistry;
    }

    public Socket tunnel(HttpHost httpHost, HttpHost httpHost2, Credentials credentials) throws IOException, HttpException {
        HttpHost httpHost3;
        Args.notNull(httpHost, "Proxy host");
        Args.notNull(httpHost2, "Target host");
        Args.notNull(credentials, "Credentials");
        if (httpHost2.getPort() <= 0) {
            httpHost3 = new HttpHost(httpHost2.getHostName(), 80, httpHost2.getSchemeName());
        } else {
            httpHost3 = httpHost2;
        }
        HttpRoute httpRoute = new HttpRoute(httpHost3, this.requestConfig.getLocalAddress(), httpHost, false, TunnelType.TUNNELLED, LayerType.PLAIN);
        ManagedHttpClientConnection managedHttpClientConnection = (ManagedHttpClientConnection) this.connFactory.create(httpRoute, this.connectionConfig);
        HttpContext basicHttpContext = new BasicHttpContext();
        HttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", httpHost3.toHostString(), HttpVersion.HTTP_1_1);
        BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
        basicCredentialsProvider.setCredentials(new AuthScope(httpHost), credentials);
        basicHttpContext.setAttribute("http.target_host", httpHost2);
        basicHttpContext.setAttribute("http.connection", managedHttpClientConnection);
        basicHttpContext.setAttribute("http.request", basicHttpRequest);
        basicHttpContext.setAttribute("http.route", httpRoute);
        basicHttpContext.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
        basicHttpContext.setAttribute("http.auth.credentials-provider", basicCredentialsProvider);
        basicHttpContext.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        basicHttpContext.setAttribute("http.request-config", this.requestConfig);
        this.requestExec.preProcess(basicHttpRequest, this.httpProcessor, basicHttpContext);
        while (true) {
            if (!managedHttpClientConnection.isOpen()) {
                managedHttpClientConnection.bind(new Socket(httpHost.getHostName(), httpHost.getPort()));
            }
            this.authenticator.generateAuthResponse(basicHttpRequest, this.proxyAuthState, basicHttpContext);
            HttpResponse execute = this.requestExec.execute(basicHttpRequest, managedHttpClientConnection, basicHttpContext);
            if (execute.getStatusLine().getStatusCode() >= 200) {
                if (!this.authenticator.isAuthenticationRequested(httpHost, execute, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContext)) {
                    break;
                }
                if (!this.authenticator.handleAuthChallenge(httpHost, execute, this.proxyAuthStrategy, this.proxyAuthState, basicHttpContext)) {
                    break;
                }
                if (this.reuseStrategy.keepAlive(execute, basicHttpContext)) {
                    EntityUtils.consume(execute.getEntity());
                } else {
                    managedHttpClientConnection.close();
                }
                basicHttpRequest.removeHeaders("Proxy-Authorization");
            } else {
                throw new HttpException("Unexpected response to CONNECT request: " + execute.getStatusLine());
            }
        }
        if (execute.getStatusLine().getStatusCode() <= 299) {
            return managedHttpClientConnection.getSocket();
        }
        HttpEntity entity = execute.getEntity();
        if (entity != null) {
            execute.setEntity(new BufferedHttpEntity(entity));
        }
        managedHttpClientConnection.close();
        throw new TunnelRefusedException("CONNECT refused by proxy: " + execute.getStatusLine(), execute);
    }
}
