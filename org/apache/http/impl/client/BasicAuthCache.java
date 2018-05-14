package org.apache.http.impl.client;

import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.auth.AuthScheme;
import org.apache.http.client.AuthCache;
import org.apache.http.conn.SchemePortResolver;
import org.apache.http.conn.UnsupportedSchemeException;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.apache.http.util.Args;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BasicAuthCache implements AuthCache {
    private final HashMap<HttpHost, AuthScheme> map;
    private final SchemePortResolver schemePortResolver;

    public BasicAuthCache(SchemePortResolver schemePortResolver) {
        this.map = new HashMap();
        if (schemePortResolver == null) {
            schemePortResolver = DefaultSchemePortResolver.INSTANCE;
        }
        this.schemePortResolver = schemePortResolver;
    }

    public BasicAuthCache() {
        this(null);
    }

    protected HttpHost getKey(HttpHost httpHost) {
        if (httpHost.getPort() > 0) {
            return httpHost;
        }
        try {
            return new HttpHost(httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpHost.getSchemeName());
        } catch (UnsupportedSchemeException e) {
            return httpHost;
        }
    }

    public void put(HttpHost httpHost, AuthScheme authScheme) {
        Args.notNull(httpHost, "HTTP host");
        this.map.put(getKey(httpHost), authScheme);
    }

    public AuthScheme get(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        return (AuthScheme) this.map.get(getKey(httpHost));
    }

    public void remove(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        this.map.remove(getKey(httpHost));
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }
}
