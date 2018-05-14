package com.kepler.sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class af {
    public static String a(Context context) {
        try {
            return ((TelephonyManager) ag.a(context.getSystemService("phone"))).getDeviceId();
        } catch (Throwable th) {
            return "Imei_null";
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            return "version_null";
        }
    }

    public static String a() {
        try {
            return URLEncoder.encode(Build.MODEL, HTTP.UTF_8);
        } catch (Throwable th) {
            return "model_null";
        }
    }

    public static String b() {
        try {
            return URLEncoder.encode(Build.MANUFACTURER, HTTP.UTF_8);
        } catch (Throwable th) {
            return "manufacturer_null";
        }
    }
}
