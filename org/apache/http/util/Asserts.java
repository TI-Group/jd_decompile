package org.apache.http.util;

/* compiled from: TbsSdkJava */
public class Asserts {
    public static void check(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void check(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalStateException(str + " is null");
        }
    }

    public static void notEmpty(CharSequence charSequence, String str) {
        if (TextUtils.isEmpty(charSequence)) {
            throw new IllegalStateException(str + " is empty");
        }
    }

    public static void notBlank(CharSequence charSequence, String str) {
        if (TextUtils.isBlank(charSequence)) {
            throw new IllegalStateException(str + " is blank");
        }
    }
}
