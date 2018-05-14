package com.jingdong.crash.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.jingdong.crash.inner.ag;
import com.jingdong.crash.inner.p;

public class b {
    public static long a;
    public static String[] b = null;
    public static String c = "1.3.0";

    public static void a(Context context, String str, String str2, String str3, String str4) {
        if (context != null) {
            if (!TextUtils.isEmpty(str4)) {
                p.f = str4;
            }
            if (!TextUtils.isEmpty(str3)) {
                p.g = str3;
            }
            if (!TextUtils.isEmpty(str)) {
                p.d = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                p.c = str2;
            }
            p.a(context, str4, str3);
            if (p.b()) {
                if (!TextUtils.isEmpty(str3) && str3.equals(c)) {
                    p.a(context);
                }
                a = SystemClock.elapsedRealtime();
                Thread.setDefaultUncaughtExceptionHandler(new ag(context));
            }
        }
    }
}
