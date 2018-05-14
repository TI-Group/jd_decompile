package com.tencent.a.a.a.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.tencent.wxop.stat.common.f;
import jd.wjlogin_sdk.util.NetworkType;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

public final class h {
    static String a(Context context) {
        try {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
            Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
        } catch (Throwable th) {
            Log.w("MID", th);
        }
        return "";
    }

    private static void a(String str, Throwable th) {
        Log.e("MID", str, th);
    }

    static void a(JSONObject jSONObject, String str, String str2) {
        if (b(str2)) {
            jSONObject.put(str, str2);
        }
    }

    static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            a("checkPermission error", th);
            return false;
        }
    }

    static String b(Context context) {
        if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkType.WIFI_STRING);
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                Log.i("MID", "get wifi address error" + e);
                return "";
            }
        }
        Log.i("MID", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
        return "";
    }

    static boolean b(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static boolean c(String str) {
        return str != null && str.trim().length() >= 40;
    }

    static String f(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(f.b(Base64.decode(str.getBytes(HTTP.UTF_8), 0)), HTTP.UTF_8).trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            a("decode error", th);
            return str;
        }
    }

    static String g(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(f.a(str.getBytes(HTTP.UTF_8)), 0), HTTP.UTF_8).trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            a("decode error", th);
            return str;
        }
    }
}
