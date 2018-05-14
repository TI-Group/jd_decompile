package com.jd.fridge.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* compiled from: TbsSdkJava */
public final class v {

    /* compiled from: TbsSdkJava */
    public static final class a {
        private Editor a;
        private SharedPreferences b;

        public a(Context context) {
            this(context, context.getPackageName());
        }

        public a(Context context, String str) {
            this(context, str, 0);
        }

        public a(Context context, String str, int i) {
            this.b = context.getSharedPreferences(str, i);
            this.a = this.b.edit();
        }

        public boolean a(String str, boolean z) {
            return this.a.putBoolean(str, z).commit();
        }

        public boolean b(String str, boolean z) {
            return this.b.getBoolean(str, z);
        }

        public boolean a(String str) {
            return this.a.remove(str).commit();
        }
    }

    public static a a(Context context) {
        return new a(context);
    }
}
