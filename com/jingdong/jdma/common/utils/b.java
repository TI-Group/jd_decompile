package com.jingdong.jdma.common.utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;

/* compiled from: TbsSdkJava */
public class b {
    public static String a = "jd_ma_sdk";

    public static String a(String str, Context context) {
        String str2 = "";
        return context.getSharedPreferences(a, 0).getString(str, "");
    }

    public static void a(String str, String str2, Context context) {
        Editor edit = context.getSharedPreferences(a, 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
