package com.kepler.sdk;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: TbsSdkJava */
public class p {
    public static void a(String str, String str2) {
        int i;
        int i2 = 1;
        boolean booleanValue = o.a.booleanValue();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            i = 1;
        }
        i &= booleanValue;
        if (TextUtils.isEmpty(str2)) {
            i2 = 0;
        }
        if ((i & i2) != 0) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2) {
        int i;
        int i2 = 1;
        boolean booleanValue = o.a.booleanValue();
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            i = 1;
        }
        i &= booleanValue;
        if (TextUtils.isEmpty(str2)) {
            i2 = 0;
        }
        if ((i & i2) != 0) {
            Log.w(str, str2);
        }
    }

    public static void a(Throwable th) {
        if (o.a.booleanValue() && th != null) {
            th.printStackTrace();
        }
    }

    public static void a(Throwable th, String str) {
        if (!aq.b(str)) {
            Log.w("kepler_exception_info", str);
        }
        if (th != null) {
            th.printStackTrace();
        }
    }
}
