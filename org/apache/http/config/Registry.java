package org.apache.http.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
/* compiled from: TbsSdkJava */
public final class Registry<I> implements Lookup<I> {
    private final Map<String, I> map;

    Registry(Map<String, I> map) {
        this.map = new ConcurrentHashMap(map);
    }

    public I lookup(String str) {
        if (str == null) {
            return null;
        }
        return this.map.get(str.toLowerCase(Locale.US));
    }

    public String toString() {
        return this.map.toString();
    }
}
