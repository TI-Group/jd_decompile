package com.jd.fridge.util;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

/* compiled from: TbsSdkJava */
public class x {
    private static Toast a = null;

    public static void a(Context context, String str) {
        if (context != null && a()) {
            if (a == null) {
                a = Toast.makeText(context, str, 0);
            } else {
                a.setText(str);
                a.setDuration(0);
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                a.show();
            }
        }
    }

    public static void a(Context context, int i) {
        if (context != null && a()) {
            if (a == null) {
                a = Toast.makeText(context, context.getResources().getString(i), 0);
            } else {
                a.setText(context.getResources().getString(i));
                a.setDuration(0);
            }
            if (!TextUtils.isEmpty(context.getResources().getString(i))) {
                a.show();
            }
        }
    }

    public static void b(Context context, String str) {
        if (context != null && a()) {
            if (a == null) {
                a = Toast.makeText(context, str, 1);
            } else {
                a.setText(str);
                a.setDuration(0);
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                a.show();
            }
        }
    }

    private static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
