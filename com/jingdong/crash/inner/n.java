package com.jingdong.crash.inner;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.net.NetworkInterface;
import java.util.Collections;
import jd.wjlogin_sdk.util.NetworkType;

class n {
    private static final String a = n.class.getSimpleName();

    n() {
    }

    public static String a() {
        try {
            String str = "wlan0";
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    return stringBuilder.toString();
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String a(Context context) {
        return !c.a("android.permission.READ_PHONE_STATE") ? "" : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    public static synchronized void a(m mVar, Context context) {
        synchronized (n.class) {
            try {
                if (ah.b) {
                    ah.a(a, "getMacAddress() -->> ");
                }
                String str = "";
                str = b(context);
                if (ah.b) {
                    ah.a(a, "getMacAddress()--->" + str);
                }
                if (str != null) {
                    mVar.a(str);
                } else {
                    new o(context, new Object(), mVar).start();
                }
            } catch (Exception e) {
                mVar.a(null);
                e.printStackTrace();
                if (ah.b) {
                    ah.a(a, "getLocalMacAddress exception -->>" + e.getMessage());
                }
            }
        }
    }

    public static String b(Context context) {
        String str;
        String str2 = "";
        if (context == null) {
            try {
                throw new NullPointerException("getMacAddressStr(), context is null");
            } catch (Exception e) {
                Exception exception = e;
                str = str2;
                Exception exception2 = exception;
                exception2.printStackTrace();
                return str;
            }
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkType.WIFI_STRING);
        if (wifiManager == null) {
            throw new IllegalStateException("Can't get WifiManager.");
        }
        str = wifiManager.getConnectionInfo().getMacAddress();
        try {
            if (VERSION.SDK_INT >= 23 || str.equals("02:00:00:00:00:00")) {
                str = a();
            }
        } catch (Exception e2) {
            exception2 = e2;
            exception2.printStackTrace();
            return str;
        }
        return str;
    }
}
