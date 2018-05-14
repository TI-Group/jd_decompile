package com.b.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.aq;

/* compiled from: TbsSdkJava */
public class a {
    public static String a = null;
    public static String b = null;
    public static int c;
    public static String d = "";
    public static String e = "";
    public static boolean f = false;
    public static int g;
    public static boolean h = true;
    public static boolean i = true;
    public static boolean j = true;
    public static boolean k = true;
    public static long l = 30000;
    private static String m = null;
    private static String n = null;
    private static double[] o = null;

    public static String a(Context context) {
        if (TextUtils.isEmpty(m)) {
            m = aq.j(context);
            if (TextUtils.isEmpty(m)) {
                m = k.a(context).b();
            }
        }
        return m;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(n)) {
            n = aq.n(context);
        }
        return n;
    }

    public static String a() {
        if (c == 1) {
            return "5.6.7.0";
        }
        return "5.6.7";
    }
}
