package org.apache.http.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public final class RegistryBuilder<I> {
    private final Map<String, I> items = new HashMap();

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder();
    }

    RegistryBuilder() {
    }

    public RegistryBuilder<I> register(String str, I i) {
        Args.notEmpty((CharSequence) str, "ID");
        Args.notNull(i, "Item");
        this.items.put(str.toLowerCase(Locale.US), i);
        return this;
    }

    public Registry<I> build() {
        return new Registry(this.items);
    }

    public String toString() {
        return this.items.toString();
    }
}
