package org.apache.http.client.utils;

import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class Punycode {
    private static final Idn impl;

    static {
        Idn jdkIdn;
        try {
            jdkIdn = new JdkIdn();
        } catch (Exception e) {
            jdkIdn = new Rfc3492Idn();
        }
        impl = jdkIdn;
    }

    public static String toUnicode(String str) {
        return impl.toUnicode(str);
    }
}
