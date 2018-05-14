package com.jingdong.jdma.common.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.jingdong.jdma.common.utils.e.b;
import java.net.NetworkInterface;
import java.util.Collections;
import jd.wjlogin_sdk.util.NetworkType;

/* compiled from: TbsSdkJava */
public class f {
    private static String a;
    private static boolean b;
    private static String c;
    private static a d = new a() {
        public void a(String str) {
            synchronized (this) {
                f.a = str;
                f.b = true;
                notifyAll();
            }
        }
    };

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(String str);
    }

    public static synchronized String a(Context context) {
        String c;
        synchronized (f.class) {
            c = c(context);
            if (c == null) {
                c = b(context);
                if (b(c)) {
                    b.a(CommonUtil.UUID_KEY, c, context);
                }
            }
        }
        return c;
    }

    private static String c(Context context) {
        if (!TextUtils.isEmpty(c) && b(c)) {
            return c;
        }
        String a = b.a(CommonUtil.UUID_KEY, context);
        if (!b(a)) {
            return null;
        }
        c = a;
        return c;
    }

    private static boolean b(String str) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("-");
        if (split.length <= 1) {
            return false;
        }
        if (TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
            z = false;
        }
        return z;
    }

    public static String b(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        final TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        final String[] strArr = new String[]{""};
        e.a(context, "android.permission.READ_PHONE_STATE", new b() {
            public Object a() {
                strArr[0] = telephonyManager.getDeviceId();
                return null;
            }
        }, new com.jingdong.jdma.common.utils.e.a() {
            public Object a() {
                strArr[0] = "";
                return null;
            }
        });
        if (!TextUtils.isEmpty(strArr[0])) {
            strArr[0] = strArr[0].trim().replaceAll("-", "");
        }
        Object obj = a;
        if (obj == null) {
            a(d, context);
            synchronized (d) {
                try {
                    if (!b) {
                        d.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (a == null) {
                obj = "";
            } else {
                obj = a;
            }
        }
        if (!TextUtils.isEmpty(obj)) {
            obj = obj.trim().replaceAll("-|\\.|:", "");
        }
        if (!TextUtils.isEmpty(strArr[0])) {
            stringBuilder.append(strArr[0]);
        }
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(obj)) {
            stringBuilder.append(obj);
        }
        return stringBuilder.toString();
    }

    public static synchronized void a(final a aVar, Context context) {
        synchronized (f.class) {
            try {
                final WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkType.WIFI_STRING);
                if (wifiManager == null) {
                    aVar.a(null);
                } else {
                    String macAddress = wifiManager.getConnectionInfo().getMacAddress();
                    if (VERSION.SDK_INT >= 23 || macAddress.equals("02:00:00:00:00:00")) {
                        macAddress = a();
                    }
                    if ("".equals(macAddress)) {
                        final Object obj = new Object();
                        new Thread() {
                            public void run() {
                                String macAddress;
                                int i = 0;
                                while (true) {
                                    macAddress = wifiManager.getConnectionInfo().getMacAddress();
                                    if (macAddress != null || i >= 5) {
                                        aVar.a(macAddress);
                                    } else {
                                        i++;
                                        synchronized (obj) {
                                            try {
                                                obj.wait(500);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                aVar.a(macAddress);
                            }
                        }.start();
                    } else {
                        aVar.a(macAddress);
                    }
                }
            } catch (Exception e) {
                aVar.a(null);
                e.printStackTrace();
            }
        }
    }

    @TargetApi(9)
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
            e.printStackTrace();
        }
        return "";
    }
}
