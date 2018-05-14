package com.jd.fridge.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: TbsSdkJava */
public class z {

    @TargetApi(16)
    /* compiled from: TbsSdkJava */
    static class a {
        public static void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            a.a(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }
}
