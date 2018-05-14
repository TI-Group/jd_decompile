package com.jingdong.crash.inner;

import android.content.Context;

class w {
    public static void a(Context context) {
        int i = ab.a(context).getInt("shared_local_saved_times", 0);
        if (i < 10) {
            ab.b(context).putInt("shared_local_saved_times", i + 1).commit();
        }
    }

    public static void b(Context context) {
        ab.b(context).putInt("shared_local_saved_times", 0).commit();
    }

    public static boolean c(Context context) {
        return d(context) < 10;
    }

    private static int d(Context context) {
        return ab.a(context).getInt("shared_local_saved_times", 0);
    }
}
