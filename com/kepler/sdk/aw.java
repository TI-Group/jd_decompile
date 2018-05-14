package com.kepler.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

/* compiled from: TbsSdkJava */
public class aw {
    private static Context a = null;
    private static String b = null;
    private static SharedPreferences c;

    private aw(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context  is required");
        }
        c = context.getSharedPreferences("deviceid_prefs", 0);
        a = context;
    }

    private static void e() {
        try {
            b = Secure.getString(a.getContentResolver(), "android_id");
        } catch (Exception e) {
        }
        if (b == null || b.equals("9774d56d682e549c") || b.length() < 15) {
            b = new BigInteger(64, new SecureRandom()).toString(16);
        }
    }

    private static void f() {
        Editor edit = c.edit();
        edit.putString("kepler_deviceid", b);
        edit.commit();
    }

    public static void a(String str) {
        Editor edit = c.edit();
        edit.putInt(str, new Date().getDate());
        edit.commit();
    }

    private static int c(String str) {
        int i = -1;
        try {
            i = c.getInt(str, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public static boolean a(String str, int i) {
        return i != c(str);
    }

    public static boolean a() {
        return !c.getBoolean("kepler_start", false);
    }

    public static void b() {
        Editor edit = c.edit();
        edit.putBoolean("kepler_start", true);
        edit.commit();
    }

    public static void c() {
        String string = c.getString("kepler_sku_arr", "");
        if (!TextUtils.isEmpty(string)) {
            String[] split = string.split("-");
            if (split != null && split.length >= 3) {
                az.a().a("sku", string);
                Editor edit = c.edit();
                edit.putString("kepler_sku_arr", "");
                edit.commit();
            }
        }
    }

    public static void b(String str) {
        Object string = c.getString("kepler_sku_arr", "");
        if (!TextUtils.isEmpty(string)) {
            str = string + "-" + str;
        }
        Editor edit = c.edit();
        edit.putString("kepler_sku_arr", str);
        edit.commit();
    }

    public static void a(Context context) {
        aw awVar = new aw(context);
        b = c.getString("kepler_deviceid", null);
        if (b == null) {
            e();
            f();
        }
    }

    public static String d() {
        return b;
    }
}
