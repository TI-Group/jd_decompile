package jd.wjlogin_sdk.util;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;
import java.util.List;

/* compiled from: TbsSdkJava */
public class NetworkManager {
    private static ConnectivityManager conManager;

    public static int getAPNType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        int type = activeNetworkInfo.getType();
        int subtype = activeNetworkInfo.getSubtype();
        subtype = type == 0 ? (subtype == 1 || subtype == 4 || subtype == 2) ? 2 : 1 : type == 1 ? 0 : -1;
        return subtype;
    }

    public static String getAPNTypeString(Context context) {
        int aPNType = getAPNType(context);
        String str = NetworkType.WIFI_STRING;
        switch (aPNType) {
            case 0:
                return NetworkType.WIFI_STRING;
            case 1:
                return NetworkType.NET3G_STRING;
            case 2:
                return NetworkType.NET2G_STRING;
            default:
                return str;
        }
    }

    public static boolean isWifiEnabled(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().getState() == State.CONNECTED) || ((TelephonyManager) context.getSystemService("phone")).getNetworkType() == 3;
    }

    public static boolean isNetworkAvailable(Context context) {
        if (conManager == null) {
            if (context == null) {
                return true;
            }
            conManager = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (conManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = conManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isGpsEnabled(Context context) {
        List providers = ((LocationManager) context.getSystemService("location")).getProviders(true);
        return providers != null && providers.size() > 0;
    }
}
