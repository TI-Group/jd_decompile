package com.jingdong.jdma.d;

import android.content.Context;

/* compiled from: TbsSdkJava */
public class f extends d {
    public static f a;

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f(context);
            }
            fVar = a;
        }
        return fVar;
    }

    public f(Context context) {
        super(context, "session.info", "sessioninfo");
    }
}
