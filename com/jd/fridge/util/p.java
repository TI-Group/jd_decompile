package com.jd.fridge.util;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.jd.fridge.GlobalVariable;
import java.io.IOException;

/* compiled from: TbsSdkJava */
public class p {
    public static String a = (Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + GlobalVariable.B().getPackageName() + "/log/");
    private static boolean b = false;
    private static j c;
    private static int d = 2;
    private static int e = 3;
    private static int f = 4;
    private static int g = 5;
    private static int h = 6;

    static {
        try {
            c = new j();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        if (b) {
            Log.d(str, str2 + "");
            a(e, str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (b) {
            Log.i(str, str2 + "");
            a(f, str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (b) {
            Log.e(str, str2 + "");
            a(h, str, str2);
        }
    }

    private static void a(int i, String str, String str2) {
        if (a(str)) {
            if (c == null) {
                try {
                    c = new j();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            c.a(3, str, str2);
        }
    }

    private static boolean a(String str) {
        if (TextUtils.equals(str, "jd-socket")) {
            return true;
        }
        return false;
    }
}
