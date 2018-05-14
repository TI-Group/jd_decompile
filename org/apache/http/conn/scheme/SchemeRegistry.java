package org.apache.http.conn.scheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpHost;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@Deprecated
@ThreadSafe
/* compiled from: TbsSdkJava */
public final class SchemeRegistry {
    private final ConcurrentHashMap<String, Scheme> registeredSchemes = new ConcurrentHashMap();

    public final Scheme getScheme(String str) {
        Scheme scheme = get(str);
        if (scheme != null) {
            return scheme;
        }
        throw new IllegalStateException("Scheme '" + str + "' not registered.");
    }

    public final Scheme getScheme(HttpHost httpHost) {
        Args.notNull(httpHost, "Host");
        return getScheme(httpHost.getSchemeName());
    }

    public final Scheme get(String str) {
        Args.notNull(str, "Scheme name");
        return (Scheme) this.registeredSchemes.get(str);
    }

    public final Scheme register(Scheme scheme) {
        Args.notNull(scheme, "Scheme");
        return (Scheme) this.registeredSchemes.put(scheme.getName(), scheme);
    }

    public final Scheme unregister(String str) {
        Args.notNull(str, "Scheme name");
        return (Scheme) this.registeredSchemes.remove(str);
    }

    public final List<String> getSchemeNames() {
        return new ArrayList(this.registeredSchemes.keySet());
    }

    public void setItems(Map<String, Scheme> map) {
        if (map != null) {
            this.registeredSchemes.clear();
            this.registeredSchemes.putAll(map);
        }
    }
}
