package com.sina.weibo.sdk.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.os.EnvironmentCompat;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

/* compiled from: TbsSdkJava */
public class f {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo c = c(context);
        if (c == null || !c.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo c = c(context);
        if (c != null && 1 == c.getType() && c.isConnected()) {
            return true;
        }
        return false;
    }

    public static NetworkInfo c(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static void d(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public static String e(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Android");
        stringBuilder.append("__");
        stringBuilder.append("weibo");
        stringBuilder.append("__");
        stringBuilder.append("sdk");
        stringBuilder.append("__");
        try {
            stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", "_"));
        } catch (Exception e) {
            stringBuilder.append(EnvironmentCompat.MEDIA_UNKNOWN);
        }
        return stringBuilder.toString();
    }
}
