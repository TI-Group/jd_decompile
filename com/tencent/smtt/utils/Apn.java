package com.tencent.smtt.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.os.EnvironmentCompat;
import jd.wjlogin_sdk.util.NetworkType;

public class Apn {
    public static final int APN_2G = 1;
    public static final int APN_3G = 2;
    public static final int APN_4G = 4;
    public static final int APN_UNKNOWN = 0;
    public static final int APN_WIFI = 3;

    public static String getApnInfo(Context context) {
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                    return activeNetworkInfo.getExtraInfo();
                case 1:
                    return NetworkType.WIFI_STRING;
            }
        }
        return str;
    }

    public static int getApnType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return 0;
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 2;
                    case 13:
                        return 4;
                    default:
                        return 0;
                }
            case 1:
                return 3;
            default:
                return 0;
        }
    }

    public static String getWifiSSID(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService(NetworkType.WIFI_STRING)).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : null;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo == null ? false : activeNetworkInfo.isConnected() || activeNetworkInfo.isAvailable();
    }
}
