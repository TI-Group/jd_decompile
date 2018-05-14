package cn.jiguang.d;

import java.util.Locale;

final class e {
    static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, str, objArr));
        }
    }
}
