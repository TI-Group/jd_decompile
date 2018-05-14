package com.kepler.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.List;

/* compiled from: TbsSdkJava */
public class ap {
    @SuppressLint({"NewApi"})
    public static void a(Context context, String str, long j) {
        try {
            context.getSharedPreferences("kepler_public", 0).edit().putLong(str, j).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long b(Context context, String str, long j) {
        try {
            j = context.getSharedPreferences("kepler_public", 0).getLong(str, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kepler_public", 0).edit().putString(str, str2).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String b(Context context, String str, String str2) {
        try {
            str2 = context.getSharedPreferences("kepler_public", 0).getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public static boolean a(Context context, String str, List<String> list) {
        if (list == null) {
            return false;
        }
        try {
            a(context, str, aq.a((List) list));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<String> a(Context context, String str) {
        List<String> list = null;
        String b = b(context, str, (String) list);
        if (b != null) {
            try {
                list = aq.c(b);
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return list;
    }
}
