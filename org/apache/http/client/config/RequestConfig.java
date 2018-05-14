package org.apache.http.client.config;

import java.net.InetAddress;
import java.util.Collection;
import org.apache.http.HttpHost;

/* compiled from: TbsSdkJava */
public class RequestConfig implements Cloneable {
    public static final RequestConfig DEFAULT = new Builder().build();
    private final boolean authenticationEnabled;
    private final boolean circularRedirectsAllowed;
    private final int connectTimeout;
    private final int connectionRequestTimeout;
    private final String cookieSpec;
    private final boolean expectContinueEnabled;
    private final InetAddress localAddress;
    private final int maxRedirects;
    private final HttpHost proxy;
    private final Collection<String> proxyPreferredAuthSchemes;
    private final boolean redirectsEnabled;
    private final boolean relativeRedirectsAllowed;
    private final int socketTimeout;
    private final boolean staleConnectionCheckEnabled;
    private final Collection<String> targetPreferredAuthSchemes;

    /* compiled from: TbsSdkJava */
    public static class Builder {
        private boolean authenticationEnabled = true;
        private boolean circularRedirectsAllowed;
        private int connectTimeout = -1;
        private int connectionRequestTimeout = -1;
        private String cookieSpec;
        private boolean expectContinueEnabled;
        private InetAddress localAddress;
        private int maxRedirects = 50;
        private HttpHost proxy;
        private Collection<String> proxyPreferredAuthSchemes;
        private boolean redirectsEnabled = true;
        private boolean relativeRedirectsAllowed = true;
        private int socketTimeout = -1;
        private boolean staleConnectionCheckEnabled = true;
        private Collection<String> targetPreferredAuthSchemes;

        Builder() {
        }

        public Builder setExpectContinueEnabled(boolean z) {
            this.expectContinueEnabled = z;
            return this;
        }

        public Builder setProxy(HttpHost httpHost) {
            this.proxy = httpHost;
            return this;
        }

        public Builder setLocalAddress(InetAddress inetAddress) {
            this.localAddress = inetAddress;
            return this;
        }

        public Builder setStaleConnectionCheckEnabled(boolean z) {
            this.staleConnectionCheckEnabled = z;
            return this;
        }

        public Builder setCookieSpec(String str) {
            this.cookieSpec = str;
            return this;
        }

        public Builder setRedirectsEnabled(boolean z) {
            this.redirectsEnabled = z;
            return this;
        }

        public Builder setRelativeRedirectsAllowed(boolean z) {
            this.relativeRedirectsAllowed = z;
            return this;
        }

        public Builder setCircularRedirectsAllowed(boolean z) {
            this.circularRedirectsAllowed = z;
            return this;
        }

        public Builder setMaxRedirects(int i) {
            this.maxRedirects = i;
            return this;
        }

        public Builder setAuthenticationEnabled(boolean z) {
            this.authenticationEnabled = z;
            return this;
        }

        public Builder setTargetPreferredAuthSchemes(Collection<String> collection) {
            this.targetPreferredAuthSchemes = collection;
            return this;
        }

        public Builder setProxyPreferredAuthSchemes(Collection<String> collection) {
            this.proxyPreferredAuthSchemes = collection;
            return this;
        }

        public Builder setConnectionRequestTimeout(int i) {
            this.connectionRequestTimeout = i;
            return this;
        }

        public Builder setConnectTimeout(int i) {
            this.connectTimeout = i;
            return this;
        }

        public Builder setSocketTimeout(int i) {
            this.socketTimeout = i;
            return this;
        }

        public RequestConfig build() {
            return new RequestConfig(this.expectContinueEnabled, this.proxy, this.localAddress, this.staleConnectionCheckEnabled, this.cookieSpec, this.redirectsEnabled, this.relativeRedirectsAllowed, this.circularRedirectsAllowed, this.maxRedirects, this.authenticationEnabled, this.targetPreferredAuthSchemes, this.proxyPreferredAuthSchemes, this.connectionRequestTimeout, this.connectTimeout, this.socketTimeout);
        }
    }

    RequestConfig(boolean z, HttpHost httpHost, InetAddress inetAddress, boolean z2, String str, boolean z3, boolean z4, boolean z5, int i, boolean z6, Collection<String> collection, Collection<String> collection2, int i2, int i3, int i4) {
        this.expectContinueEnabled = z;
        this.proxy = httpHost;
        this.localAddress = inetAddress;
        this.staleConnectionCheckEnabled = z2;
        this.cookieSpec = str;
        this.redirectsEnabled = z3;
        this.relativeRedirectsAllowed = z4;
        this.circularRedirectsAllowed = z5;
        this.maxRedirects = i;
        this.authenticationEnabled = z6;
        this.targetPreferredAuthSchemes = collection;
        this.proxyPreferredAuthSchemes = collection2;
        this.connectionRequestTimeout = i2;
        this.connectTimeout = i3;
        this.socketTimeout = i4;
    }

    public boolean isExpectContinueEnabled() {
        return this.expectContinueEnabled;
    }

    public HttpHost getProxy() {
        return this.proxy;
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public boolean isStaleConnectionCheckEnabled() {
        return this.staleConnectionCheckEnabled;
    }

    public String getCookieSpec() {
        return this.cookieSpec;
    }

    public boolean isRedirectsEnabled() {
        return this.redirectsEnabled;
    }

    public boolean isRelativeRedirectsAllowed() {
        return this.relativeRedirectsAllowed;
    }

    public boolean isCircularRedirectsAllowed() {
        return this.circularRedirectsAllowed;
    }

    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    public boolean isAuthenticationEnabled() {
        return this.authenticationEnabled;
    }

    public Collection<String> getTargetPreferredAuthSchemes() {
        return this.targetPreferredAuthSchemes;
    }

    public Collection<String> getProxyPreferredAuthSchemes() {
        return this.proxyPreferredAuthSchemes;
    }

    public int getConnectionRequestTimeout() {
        return this.connectionRequestTimeout;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    protected RequestConfig clone() throws CloneNotSupportedException {
        return (RequestConfig) super.clone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", expectContinueEnabled=").append(this.expectContinueEnabled);
        stringBuilder.append(", proxy=").append(this.proxy);
        stringBuilder.append(", localAddress=").append(this.localAddress);
        stringBuilder.append(", staleConnectionCheckEnabled=").append(this.staleConnectionCheckEnabled);
        stringBuilder.append(", cookieSpec=").append(this.cookieSpec);
        stringBuilder.append(", redirectsEnabled=").append(this.redirectsEnabled);
        stringBuilder.append(", relativeRedirectsAllowed=").append(this.relativeRedirectsAllowed);
        stringBuilder.append(", maxRedirects=").append(this.maxRedirects);
        stringBuilder.append(", circularRedirectsAllowed=").append(this.circularRedirectsAllowed);
        stringBuilder.append(", authenticationEnabled=").append(this.authenticationEnabled);
        stringBuilder.append(", targetPreferredAuthSchemes=").append(this.targetPreferredAuthSchemes);
        stringBuilder.append(", proxyPreferredAuthSchemes=").append(this.proxyPreferredAuthSchemes);
        stringBuilder.append(", connectionRequestTimeout=").append(this.connectionRequestTimeout);
        stringBuilder.append(", connectTimeout=").append(this.connectTimeout);
        stringBuilder.append(", socketTimeout=").append(this.socketTimeout);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(RequestConfig requestConfig) {
        return new Builder().setExpectContinueEnabled(requestConfig.isExpectContinueEnabled()).setProxy(requestConfig.getProxy()).setLocalAddress(requestConfig.getLocalAddress()).setStaleConnectionCheckEnabled(requestConfig.isStaleConnectionCheckEnabled()).setCookieSpec(requestConfig.getCookieSpec()).setRedirectsEnabled(requestConfig.isRedirectsEnabled()).setRelativeRedirectsAllowed(requestConfig.isRelativeRedirectsAllowed()).setCircularRedirectsAllowed(requestConfig.isCircularRedirectsAllowed()).setMaxRedirects(requestConfig.getMaxRedirects()).setAuthenticationEnabled(requestConfig.isAuthenticationEnabled()).setTargetPreferredAuthSchemes(requestConfig.getTargetPreferredAuthSchemes()).setProxyPreferredAuthSchemes(requestConfig.getProxyPreferredAuthSchemes()).setConnectionRequestTimeout(requestConfig.getConnectionRequestTimeout()).setConnectTimeout(requestConfig.getConnectTimeout()).setSocketTimeout(requestConfig.getSocketTimeout());
    }
}
