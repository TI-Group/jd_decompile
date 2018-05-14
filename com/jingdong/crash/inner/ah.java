package com.jingdong.crash.inner;

import android.util.Log;

public class ah {
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    private static boolean f = false;

    public static void a(String str, String str2) {
        if (f) {
            if (str2 == null) {
                str2 = "message : ";
            }
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f) {
            if (str2 == null) {
                str2 = "message : ";
            }
            Log.i(str, str2);
        }
    }
}
