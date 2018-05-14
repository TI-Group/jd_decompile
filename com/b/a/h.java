package com.b.a;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: TbsSdkJava */
public class h {
    private static String[] a = new String[2];

    public static String[] a(Context context) {
        if (!TextUtils.isEmpty(a[0]) && !TextUtils.isEmpty(a[1])) {
            return a;
        }
        if (context != null) {
            String[] a = k.a(context).a();
            if (a != null) {
                a[0] = a[0];
                a[1] = a[1];
                return a;
            }
        }
        return null;
    }
}
