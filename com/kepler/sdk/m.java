package com.kepler.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: TbsSdkJava */
public class m {
    public static final List<String> a = new ArrayList();

    /* compiled from: TbsSdkJava */
    static final class a {
        private static m a = new m();
    }

    private m() {
    }

    public static final m a() {
        return a.a;
    }

    static {
        a.add("kepler=\"\"");
        a.add("os=\"\"");
        a.add("osversion=\"\"");
        a.add("version=\"\"");
        a.add("appversion=\"\"");
        a.add("token=\"\"");
    }

    public void a(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("auth_shared", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public void a(Context context, String str, long j) {
        Editor edit = context.getSharedPreferences("auth_shared", 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public long a(Context context, String str) {
        return context.getSharedPreferences("auth_shared", 0).getLong(str, 0);
    }

    public void a(Context context, String str, int i) {
        Editor edit = context.getSharedPreferences("auth_shared", 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public String b(Context context, String str) {
        return context.getSharedPreferences("auth_shared", 0).getString(str, "");
    }
}
