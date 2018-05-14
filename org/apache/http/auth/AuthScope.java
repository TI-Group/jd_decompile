package org.apache.http.auth;

import java.util.Locale;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class AuthScope {
    public static final AuthScope ANY = new AuthScope(ANY_HOST, -1, ANY_REALM, ANY_SCHEME);
    public static final String ANY_HOST = null;
    public static final int ANY_PORT = -1;
    public static final String ANY_REALM = null;
    public static final String ANY_SCHEME = null;
    private final String host;
    private final int port;
    private final String realm;
    private final String scheme;

    public AuthScope(String str, int i, String str2, String str3) {
        this.host = str == null ? ANY_HOST : str.toLowerCase(Locale.ENGLISH);
        if (i < 0) {
            i = -1;
        }
        this.port = i;
        if (str2 == null) {
            str2 = ANY_REALM;
        }
        this.realm = str2;
        this.scheme = str3 == null ? ANY_SCHEME : str3.toUpperCase(Locale.ENGLISH);
    }

    public AuthScope(HttpHost httpHost, String str, String str2) {
        this(httpHost.getHostName(), httpHost.getPort(), str, str2);
    }

    public AuthScope(HttpHost httpHost) {
        this(httpHost, ANY_REALM, ANY_SCHEME);
    }

    public AuthScope(String str, int i, String str2) {
        this(str, i, str2, ANY_SCHEME);
    }

    public AuthScope(String str, int i) {
        this(str, i, ANY_REALM, ANY_SCHEME);
    }

    public AuthScope(AuthScope authScope) {
        Args.notNull(authScope, "Scope");
        this.host = authScope.getHost();
        this.port = authScope.getPort();
        this.realm = authScope.getRealm();
        this.scheme = authScope.getScheme();
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getRealm() {
        return this.realm;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int match(AuthScope authScope) {
        int i = 0;
        if (LangUtils.equals(this.scheme, authScope.scheme)) {
            i = 1;
        } else if (!(this.scheme == ANY_SCHEME || authScope.scheme == ANY_SCHEME)) {
            return -1;
        }
        if (LangUtils.equals(this.realm, authScope.realm)) {
            i += 2;
        } else if (!(this.realm == ANY_REALM || authScope.realm == ANY_REALM)) {
            return -1;
        }
        if (this.port == authScope.port) {
            i += 4;
        } else if (!(this.port == -1 || authScope.port == -1)) {
            return -1;
        }
        if (LangUtils.equals(this.host, authScope.host)) {
            return i + 8;
        }
        if (this.host == ANY_HOST || authScope.host == ANY_HOST) {
            return i;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthScope)) {
            return super.equals(obj);
        }
        AuthScope authScope = (AuthScope) obj;
        if (LangUtils.equals(this.host, authScope.host) && this.port == authScope.port && LangUtils.equals(this.realm, authScope.realm) && LangUtils.equals(this.scheme, authScope.scheme)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.scheme != null) {
            stringBuilder.append(this.scheme.toUpperCase(Locale.ENGLISH));
            stringBuilder.append(' ');
        }
        if (this.realm != null) {
            stringBuilder.append('\'');
            stringBuilder.append(this.realm);
            stringBuilder.append('\'');
        } else {
            stringBuilder.append("<any realm>");
        }
        if (this.host != null) {
            stringBuilder.append('@');
            stringBuilder.append(this.host);
            if (this.port >= 0) {
                stringBuilder.append(':');
                stringBuilder.append(this.port);
            }
        }
        return stringBuilder.toString();
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.host), this.port), this.realm), this.scheme);
    }
}
