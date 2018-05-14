package org.apache.http.protocol;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@ThreadSafe
/* compiled from: TbsSdkJava */
public class UriPatternMatcher<T> {
    @GuardedBy("this")
    private final Map<String, T> map = new HashMap();

    public synchronized void register(String str, T t) {
        Args.notNull(str, "URI request pattern");
        this.map.put(str, t);
    }

    public synchronized void unregister(String str) {
        if (str != null) {
            this.map.remove(str);
        }
    }

    @Deprecated
    public synchronized void setHandlers(Map<String, T> map) {
        Args.notNull(map, "Map of handlers");
        this.map.clear();
        this.map.putAll(map);
    }

    @Deprecated
    public synchronized void setObjects(Map<String, T> map) {
        Args.notNull(map, "Map of handlers");
        this.map.clear();
        this.map.putAll(map);
    }

    @Deprecated
    public synchronized Map<String, T> getObjects() {
        return this.map;
    }

    public synchronized T lookup(String str) {
        T t;
        Args.notNull(str, "Request path");
        t = this.map.get(str);
        if (t == null) {
            String str2 = null;
            for (String str3 : this.map.keySet()) {
                String str32;
                T t2;
                if (matchUriRequestPattern(str32, str) && (str2 == null || str2.length() < str32.length() || (str2.length() == str32.length() && str32.endsWith("*")))) {
                    t2 = this.map.get(str32);
                } else {
                    str32 = str2;
                    t2 = t;
                }
                t = t2;
                str2 = str32;
            }
        }
        return t;
    }

    protected boolean matchUriRequestPattern(String str, String str2) {
        boolean z = false;
        if (str.equals("*")) {
            return true;
        }
        if ((str.endsWith("*") && str2.startsWith(str.substring(0, str.length() - 1))) || (str.startsWith("*") && str2.endsWith(str.substring(1, str.length())))) {
            z = true;
        }
        return z;
    }

    public String toString() {
        return this.map.toString();
    }
}
