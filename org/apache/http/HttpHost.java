package org.apache.http;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
/* compiled from: TbsSdkJava */
public final class HttpHost implements Serializable, Cloneable {
    public static final String DEFAULT_SCHEME_NAME = "http";
    private static final long serialVersionUID = -7529410654042457626L;
    protected final InetAddress address;
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(String str, int i, String str2) {
        this.hostname = (String) Args.notBlank(str, "Host name");
        this.lcHostname = str.toLowerCase(Locale.ENGLISH);
        if (str2 != null) {
            this.schemeName = str2.toLowerCase(Locale.ENGLISH);
        } else {
            this.schemeName = DEFAULT_SCHEME_NAME;
        }
        this.port = i;
        this.address = null;
    }

    public HttpHost(String str, int i) {
        this(str, i, null);
    }

    public HttpHost(String str) {
        this(str, -1, null);
    }

    public HttpHost(InetAddress inetAddress, int i, String str) {
        this.address = (InetAddress) Args.notNull(inetAddress, "Inet address");
        this.hostname = inetAddress.getHostAddress();
        this.lcHostname = this.hostname.toLowerCase(Locale.ENGLISH);
        if (str != null) {
            this.schemeName = str.toLowerCase(Locale.ENGLISH);
        } else {
            this.schemeName = DEFAULT_SCHEME_NAME;
        }
        this.port = i;
    }

    public HttpHost(InetAddress inetAddress, int i) {
        this(inetAddress, i, null);
    }

    public HttpHost(InetAddress inetAddress) {
        this(inetAddress, -1, null);
    }

    public HttpHost(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        this.hostname = httpHost.hostname;
        this.lcHostname = httpHost.lcHostname;
        this.schemeName = httpHost.schemeName;
        this.port = httpHost.port;
        this.address = httpHost.address;
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public String toURI() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.schemeName);
        stringBuilder.append("://");
        stringBuilder.append(this.hostname);
        if (this.port != -1) {
            stringBuilder.append(':');
            stringBuilder.append(Integer.toString(this.port));
        }
        return stringBuilder.toString();
    }

    public String toHostString() {
        if (this.port == -1) {
            return this.hostname;
        }
        StringBuilder stringBuilder = new StringBuilder(this.hostname.length() + 6);
        stringBuilder.append(this.hostname);
        stringBuilder.append(":");
        stringBuilder.append(Integer.toString(this.port));
        return stringBuilder.toString();
    }

    public String toString() {
        return toURI();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpHost)) {
            return false;
        }
        HttpHost httpHost = (HttpHost) obj;
        if (this.lcHostname.equals(httpHost.lcHostname) && this.port == httpHost.port && this.schemeName.equals(httpHost.schemeName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.lcHostname), this.port), this.schemeName);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
