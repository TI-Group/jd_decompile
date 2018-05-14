package com.jingdong.jdma.d;

import android.content.Context;

/* compiled from: TbsSdkJava */
public class b extends d {
    public static b a;

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(context);
            }
            bVar = a;
        }
        return bVar;
    }

    public b(Context context) {
        super(context, "cache.info", "cacheinfo");
    }
}
