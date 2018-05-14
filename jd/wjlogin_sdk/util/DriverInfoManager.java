package jd.wjlogin_sdk.util;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

/* compiled from: TbsSdkJava */
public class DriverInfoManager {
    public static String getDriverModel() {
        return Build.MODEL;
    }

    public static TelephonyManager getDriverInfo(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }
}
