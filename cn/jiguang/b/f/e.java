package cn.jiguang.b.f;

import android.os.PowerManager.WakeLock;

public final class e {
    private static e a = null;
    private WakeLock b = null;

    private e() {
    }

    public static e a() {
        if (a == null) {
            a = new e();
        }
        return a;
    }

    public final void a(WakeLock wakeLock) {
        this.b = wakeLock;
    }

    public final WakeLock b() {
        return this.b;
    }
}
