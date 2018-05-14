package org.apache.http.conn.routing;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.conn.routing.RouteInfo.LayerType;
import org.apache.http.conn.routing.RouteInfo.TunnelType;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.LangUtils;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public final class RouteTracker implements Cloneable, RouteInfo {
    private boolean connected;
    private LayerType layered;
    private final InetAddress localAddress;
    private HttpHost[] proxyChain;
    private boolean secure;
    private final HttpHost targetHost;
    private TunnelType tunnelled;

    public RouteTracker(HttpHost httpHost, InetAddress inetAddress) {
        Args.notNull(httpHost, "Target host");
        this.targetHost = httpHost;
        this.localAddress = inetAddress;
        this.tunnelled = TunnelType.PLAIN;
        this.layered = LayerType.PLAIN;
    }

    public void reset() {
        this.connected = false;
        this.proxyChain = null;
        this.tunnelled = TunnelType.PLAIN;
        this.layered = LayerType.PLAIN;
        this.secure = false;
    }

    public RouteTracker(HttpRoute httpRoute) {
        this(httpRoute.getTargetHost(), httpRoute.getLocalAddress());
    }

    public final void connectTarget(boolean z) {
        Asserts.check(!this.connected, "Already connected");
        this.connected = true;
        this.secure = z;
    }

    public final void connectProxy(HttpHost httpHost, boolean z) {
        boolean z2;
        Args.notNull(httpHost, "Proxy host");
        if (this.connected) {
            z2 = false;
        } else {
            z2 = true;
        }
        Asserts.check(z2, "Already connected");
        this.connected = true;
        this.proxyChain = new HttpHost[]{httpHost};
        this.secure = z;
    }

    public final void tunnelTarget(boolean z) {
        Asserts.check(this.connected, "No tunnel unless connected");
        Asserts.notNull(this.proxyChain, "No tunnel without proxy");
        this.tunnelled = TunnelType.TUNNELLED;
        this.secure = z;
    }

    public final void tunnelProxy(HttpHost httpHost, boolean z) {
        Args.notNull(httpHost, "Proxy host");
        Asserts.check(this.connected, "No tunnel unless connected");
        Asserts.notNull(this.proxyChain, "No tunnel without proxy");
        Object obj = new HttpHost[(this.proxyChain.length + 1)];
        System.arraycopy(this.proxyChain, 0, obj, 0, this.proxyChain.length);
        obj[obj.length - 1] = httpHost;
        this.proxyChain = obj;
        this.secure = z;
    }

    public final void layerProtocol(boolean z) {
        Asserts.check(this.connected, "No layered protocol unless connected");
        this.layered = LayerType.LAYERED;
        this.secure = z;
    }

    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    public final InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public final int getHopCount() {
        if (!this.connected) {
            return 0;
        }
        if (this.proxyChain == null) {
            return 1;
        }
        return this.proxyChain.length + 1;
    }

    public final HttpHost getHopTarget(int i) {
        Args.notNegative(i, "Hop index");
        int hopCount = getHopCount();
        Args.check(i < hopCount, "Hop index exceeds tracked route length");
        if (i < hopCount - 1) {
            return this.proxyChain[i];
        }
        return this.targetHost;
    }

    public final HttpHost getProxyHost() {
        return this.proxyChain == null ? null : this.proxyChain[0];
    }

    public final boolean isConnected() {
        return this.connected;
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

    public final HttpRoute toRoute() {
        return !this.connected ? null : new HttpRoute(this.targetHost, this.localAddress, this.proxyChain, this.secure, this.tunnelled, this.layered);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RouteTracker)) {
            return false;
        }
        RouteTracker routeTracker = (RouteTracker) obj;
        if (this.connected == routeTracker.connected && this.secure == routeTracker.secure && this.tunnelled == routeTracker.tunnelled && this.layered == routeTracker.layered && LangUtils.equals(this.targetHost, routeTracker.targetHost) && LangUtils.equals(this.localAddress, routeTracker.localAddress) && LangUtils.equals(this.proxyChain, routeTracker.proxyChain)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = LangUtils.hashCode(LangUtils.hashCode(17, this.targetHost), this.localAddress);
        if (this.proxyChain != null) {
            HttpHost[] httpHostArr = this.proxyChain;
            int length = httpHostArr.length;
            int i = 0;
            while (i < length) {
                int hashCode2 = LangUtils.hashCode(hashCode, httpHostArr[i]);
                i++;
                hashCode = hashCode2;
            }
        }
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(hashCode, this.connected), this.secure), this.tunnelled), this.layered);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder((getHopCount() * 30) + 50);
        stringBuilder.append("RouteTracker[");
        if (this.localAddress != null) {
            stringBuilder.append(this.localAddress);
            stringBuilder.append("->");
        }
        stringBuilder.append('{');
        if (this.connected) {
            stringBuilder.append('c');
        }
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
            for (Object append : this.proxyChain) {
                stringBuilder.append(append);
                stringBuilder.append("->");
            }
        }
        stringBuilder.append(this.targetHost);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
