package com.tencent.smtt.sdk;

import android.webkit.MimeTypeMap;

public class c {
    private static c a;

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    public String a(String str) {
        bo b = bo.b();
        return (b == null || !b.c()) ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : b.d().f(str);
    }
}
