package com.jingdong.jdma.d;

import android.content.Context;

/* compiled from: TbsSdkJava */
public class a extends d {
    public static a a;

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a(context);
            }
            aVar = a;
        }
        return aVar;
    }

    public a(Context context) {
        super(context, "advert.info", "advertinfo");
    }
}
