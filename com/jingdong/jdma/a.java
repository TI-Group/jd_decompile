package com.jingdong.jdma;

import android.content.Context;
import com.jingdong.jdma.e.b;
import com.jingdong.jdma.minterface.MaInitCommonInfo;

/* compiled from: TbsSdkJava */
public class a {
    private static com.jingdong.jdma.e.a a;

    protected a(int i, Context context, MaInitCommonInfo maInitCommonInfo) {
        if (i == 0) {
            a = new b(context, maInitCommonInfo);
        } else if (i != 1) {
        }
    }

    public static synchronized com.jingdong.jdma.e.a a(int i, Context context, MaInitCommonInfo maInitCommonInfo) {
        com.jingdong.jdma.e.a aVar;
        synchronized (a.class) {
            if (a == null) {
                a aVar2;
                if (context != null && context.getApplicationContext() != null) {
                    aVar2 = new a(i, context.getApplicationContext(), maInitCommonInfo);
                } else if (context != null) {
                    aVar2 = new a(i, context, maInitCommonInfo);
                }
            }
            aVar = a;
        }
        return aVar;
    }

    public static synchronized void a() {
        synchronized (a.class) {
            if (a != null) {
                a.b();
            }
            a = null;
        }
    }
}
