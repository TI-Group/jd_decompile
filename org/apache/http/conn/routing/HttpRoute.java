package org.apache.http.conn.routing;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.conn.routing.RouteInfo.LayerType;
import org.apache.http.conn.routing.RouteInfo.TunnelType;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
/* compiled from: TbsSdkJava */
public final class HttpRoute implements Cloneable, RouteInfo {
    private final LayerType layered;
    private final InetAddress localAddress;
    private final List<HttpHost> proxyChain;
    private final boolean secure;
    private final HttpHost targetHost;
    private final TunnelType tunnelled;

    private HttpRoute(HttpHost httpHost, InetAddress inetAddress, List<HttpHost> list, boolean z, TunnelType tunnelType, LayerType layerType) {
        Args.notNull(httpHost, "Target host");
        this.targetHost = httpHost;
        this.localAddress = inetAddress;
        if (list == null || list.isEmpty()) {
            this.proxyChain = null;
        } else {
            this.proxyChain = new ArrayList(list);
        }
        if (tunnelType == TunnelType.TUNNELLED) {
            Args.check(this.proxyChain != null, "Proxy required if tunnelled");
        }
        this.secure = z;
        if (tunnelType == null) {
            tunnelType = TunnelType.PLAIN;
        }
        this.tunnelled = tunnelType;
        if (layerType == null) {
            layerType = LayerType.PLAIN;
        }
        this.layered = layerType;
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost[] httpHostArr, boolean z, TunnelType tunnelType, LayerType layerType) {
        this(httpHost, inetAddress, httpHostArr != null ? Arrays.asList(httpHostArr) : null, z, tunnelType, layerType);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost httpHost2, boolean z, TunnelType tunnelType, LayerType layerType) {
        this(httpHost, inetAddress, httpHost2 != null ? Collections.singletonList(httpHost2) : null, z, tunnelType, layerType);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, boolean z) {
        this(httpHost, inetAddress, Collections.emptyList(), z, TunnelType.PLAIN, LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost) {
        this(httpHost, null, Collections.emptyList(), false, TunnelType.PLAIN, LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost, InetAddress inetAddress, HttpHost httpHost2, boolean z) {
        this(httpHost, inetAddress, Collections.singletonList(Args.notNull(httpHost2, "Proxy host")), z, z ? TunnelType.TUNNELLED : TunnelType.PLAIN, z ? LayerType.LAYERED : LayerType.PLAIN);
    }

    public HttpRoute(HttpHost httpHost, HttpHost httpHost2) {
        this(httpHost, null, httpHost2, false);
    }

    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public final InetSocketAddress getLocalSocketAddress() {
        return this.localAddress != null ? new InetSocketAddress(this.localAddress, 0) : null;
    }

    public final int getHopCount() {
        return this.proxyChain != null ? this.proxyChain.size() + 1 : 1;
    }

    public final HttpHost getHopTarget(int i) {
        Args.notNegative(i, "Hop index");
        int hopCount = getHopCount();
        Args.check(i < hopCount, "Hop index exceeds tracked route length");
        if (i < hopCount - 1) {
            return (HttpHost) this.proxyChain.get(i);
        }
        return this.targetHost;
    }

    public final HttpHost getProxyHost() {
        return (this.proxyChain == null || this.proxyChain.isEmpty()) ? null : (HttpHost) this.proxyChain.get(0);
    }

    public final TunnelType getTunnelType() {
        return this.tunnelled;
    }

    public final boolean isTunnelled() {
        return this.tunnelled == TunnelType.TUNNELLED;
    }

    public final LayerType getLayerType() {
        return this.layered;
    }

    public final boolean isLayered() {
        return this.layered == LayerType.LAYERED;
    }

    public final boolean isSecure() {
        return this.secure;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRoute)) {
            return false;
        }
        HttpRoute httpRoute = (HttpRoute) obj;
        if (this.secure == httpRoute.secure && this.tunnelled == httpRoute.tunnelled && this.layered == httpRoute.layered && LangUtils.equals(this.targetHost, httpRoute.targetHost) && LangUtils.equals(this.localAddress, httpRoute.localAddress) && LangUtils.equals(this.proxyChain, httpRoute.proxyChain)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
        if (this.proxyChain != null) {
            i = hashCode;
            for (Object hashCode2 : this.proxyChain) {
                i = LangUtils.hashCode(i, hashCode2);
            }
        } else {
            i = hashCode;
        }
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(i, this.secure), this.tunnelled), this.layered);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder((getHopCount() * 30) + 50);
        if (this.localAddress != null) {
            stringBuilder.append(this.localAddress);
            stringBuilder.append("->");
        }
        stringBuilder.append('{');
        if (this.tunnelled == TunnelType.TUNNELLED) {
            stringBuilder.append('t');
        }
        if (this.layered == LayerType.LAYERED) {
            stringBuilder.append('l');
        }
        if (this.secure) {
            stringBuilder.append('s');
        }
        stringBuilder.append("}->");
        if (this.proxyChain != null) {
            for (HttpHost append : this.proxyChain) {
                stringBuilder.append(append);
                stringBuilder.append("->");
            }
        }
        stringBuilder.append(this.targetHost);
        return stringBuilder.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
