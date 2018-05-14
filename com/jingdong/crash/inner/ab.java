package com.jingdong.crash.inner;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class ab {
    private static SharedPreferences a;

    ab() {
    }

    public static SharedPreferences a(Context context) {
        if (a != null) {
            return a;
        }
        SharedPreferences sharedPreferences;
        synchronized (ab.class) {
            a = context.getSharedPreferences("crash_sp", 0);
            sharedPreferences = a;
        }
        return sharedPreferences;
    }

    public static Editor b(Context context) {
        return a(context).edit();
    }
}
