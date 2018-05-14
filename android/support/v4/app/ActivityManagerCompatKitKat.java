package android.support.v4.app;

import android.app.ActivityManager;

/* compiled from: TbsSdkJava */
class ActivityManagerCompatKitKat {
    ActivityManagerCompatKitKat() {
    }

    public static boolean isLowRamDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
