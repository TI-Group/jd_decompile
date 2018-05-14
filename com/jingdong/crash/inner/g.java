package com.jingdong.crash.inner;

import android.util.Log;

class g {
    public static void a(int i) {
        ab.b(q.d()).putInt("shared_byte_limit", i).commit();
    }

    public static void a(boolean z) {
        ab.b(q.d()).putBoolean("shared_sdk_is_open", z).commit();
    }

    public static boolean a() {
        boolean z = ab.a(q.d()).getBoolean("shared_sdk_is_open", true);
        Log.d("ServerConfig", "Server config sdk open " + z);
        return z;
    }

    public static int b() {
        return ab.a(q.d()).getInt("shared_byte_limit", 30720);
    }

    public static void b(boolean z) {
        ab.b(q.d()).putBoolean("shared_post_is_open", z).commit();
    }
}
