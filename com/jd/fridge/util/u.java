package com.jd.fridge.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: TbsSdkJava */
public class u {
    private static DisplayMetrics g(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int a(Context context) {
        return g(context).heightPixels;
    }

    public static float b(Context context) {
        return g(context).density;
    }

    public static int c(Context context) {
        return (int) (((float) a(context)) / b(context));
    }

    public static int d(Context context) {
        int i = 0;
        Display defaultDisplay = f(context).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
            return displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static int e(Context context) {
        return d(context) - a(context);
    }

    public static WindowManager f(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static float a(Resources resources, float f) {
        return (resources.getDisplayMetrics().density * f) + 0.5f;
    }
}
