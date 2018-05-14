package org.apache.http.impl.conn;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: TbsSdkJava */
public class SystemDefaultRoutePlanner extends DefaultRoutePlanner {
    private final ProxySelector proxySelector;

    /* compiled from: TbsSdkJava */
    /* renamed from: org.apache.http.impl.conn.SystemDefaultRoutePlanner$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$net$Proxy$Type = new int[Type.values().length];

        static {
            try {
                $SwitchMap$java$net$Proxy$Type[Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$java$net$Proxy$Type[Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$net$Proxy$Type[Type.SOCKS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public SystemDefaultRoutePlanner(SchemePortResolver schemePortResolver, ProxySelector proxySelector) {
        super(schemePortResolver);
        if (proxySelector == null) {
            proxySelector = ProxySelector.getDefault();
        }
        this.proxySelector = proxySelector;
    }

    public SystemDefaultRoutePlanner(ProxySelector proxySelector) {
        this(null, proxySelector);
    }

    protected HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        try {
            Proxy chooseProxy = chooseProxy(this.proxySelector.select(new URI(httpHost.toURI())));
            if (chooseProxy.type() != Type.HTTP) {
                return null;
            }
            if (chooseProxy.address() instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) chooseProxy.address();
                return new HttpHost(getHost(inetSocketAddress), inetSocketAddress.getPort());
            }
            throw new HttpException("Unable to handle non-Inet proxy address: " + chooseProxy.address());
        } catch (Throwable e) {
            throw new HttpException("Cannot convert host to URI: " + httpHost, e);
        }
    }

    private String getHost(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.isUnresolved() ? inetSocketAddress.getHostName() : inetSocketAddress.getAddress().getHostAddress();
    }

    private Proxy chooseProxy(List<Proxy> list) {
        Proxy proxy = null;
        int i = 0;
        while (proxy == null && i < list.size()) {
            Proxy proxy2 = (Proxy) list.get(i);
            switch (AnonymousClass1.$SwitchMap$java$net$Proxy$Type[proxy2.type().ordinal()]) {
                case 1:
                case 2:
                    break;
                default:
                    proxy2 = proxy;
                    break;
            }
            i++;
            proxy = proxy2;
        }
        if (proxy == null) {
            return Proxy.NO_PROXY;
        }
        return proxy;
    }
}
