package com.jd.fridge.util;

import android.util.Log;

/* compiled from: TbsSdkJava */
public class r {
    private static boolean a = true;
    private static boolean b = false;
    private static boolean c = false;
    private static int d = 2000;

    public static void a(boolean z) {
        a = z;
    }

    public static void a(String str, String str2) {
        int i = 0;
        if (str2 == null) {
            str2 = "";
        }
        f(str, str2);
        if (a) {
            int length = str2.length();
            int i2 = d;
            int i3 = 0;
            while (i < 100) {
                if (length > i2) {
                    Log.d(str, str2.substring(i3, i2));
                    i++;
                    i3 = i2;
                    i2 = d + i2;
                } else {
                    Log.d(str, str2.substring(i3, length));
                    return;
                }
            }
        }
    }

    public static void b(String str, String str2) {
        int i = 0;
        if (str2 == null) {
            str2 = "";
        }
        e(str, str2);
        if (a) {
            int length = str2.length();
            int i2 = d;
            int i3 = 0;
            while (i < 100) {
                if (length > i2) {
                    Log.e(str, str2.substring(i3, i2));
                    i++;
                    i3 = i2;
                    i2 = d + i2;
                } else {
                    Log.e(str, str2.substring(i3, length));
                    return;
                }
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        int i = 0;
        if (str2 == null) {
            str2 = "";
        }
        e(str, str2);
        if (a) {
            int length = str2.length();
            int i2 = d;
            int i3 = 0;
            while (i < 100) {
                if (length > i2) {
                    Log.e(str, str2.substring(i3, i2), th);
                    i++;
                    i3 = i2;
                    i2 = d + i2;
                } else {
                    Log.e(str, str2.substring(i3, length), th);
                    return;
                }
            }
        }
    }

    public static void c(String str, String str2) {
        int i = 0;
        if (str2 == null) {
            str2 = "";
        }
        if (a) {
            int length = str2.length();
            int i2 = d;
            int i3 = 0;
            while (i < 100) {
                if (length > i2) {
                    Log.i(str, str2.substring(i3, i2));
                    i++;
                    i3 = i2;
                    i2 = d + i2;
                } else {
                    Log.i(str, str2.substring(i3, length));
                    return;
                }
            }
        }
    }

    public static void d(String str, String str2) {
        int i = 0;
        if (a) {
            int length = str2.length();
            int i2 = d;
            int i3 = 0;
            while (i < 100) {
                if (length > i2) {
                    Log.w(str, str2.substring(i3, i2));
                    i++;
                    i3 = i2;
                    i2 = d + i2;
                } else {
                    Log.w(str, str2.substring(i3, length));
                    return;
                }
            }
        }
    }

    public static int a(String str, Throwable th) {
        return a ? Log.w(str, th) : 99;
    }

    public static void b(String str, String str2, Throwable th) {
        int i = 0;
        if (a) {
            int length = str2.length();
            int i2 = d;
            int i3 = 0;
            while (i < 100) {
                if (length > i2) {
                    Log.w(str, str2.substring(i3, i2), th);
                    i++;
                    i3 = i2;
                    i2 = d + i2;
                } else {
                    Log.w(str, str2.substring(i3, length), th);
                    return;
                }
            }
        }
    }

    public static void e(String str, String str2) {
    }

    public static void f(String str, String str2) {
    }
}
