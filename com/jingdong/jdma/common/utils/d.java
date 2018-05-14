package com.jingdong.jdma.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;
import jd.wjlogin_sdk.util.NetworkType;

/* compiled from: TbsSdkJava */
public class d {
    public static boolean a = true;
    public static int b = 0;
    private static String c = "";

    /* compiled from: TbsSdkJava */
    public static class a {
        Integer a;
        String b;
        String c;
        String d;
        String e;
        private String f;
        private int g = 0;

        public a(int i, String str, Context context) {
            this.g = i;
            this.f = str;
            a(context);
        }

        private void a(Context context) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            try {
                this.a = Integer.valueOf(telephonyManager.getSimState());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                this.e = telephonyManager.getNetworkOperatorName();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                this.d = telephonyManager.getNetworkOperator();
            } catch (Throwable th22) {
                th22.printStackTrace();
            }
            try {
                int networkType = telephonyManager.getNetworkType();
                this.b = "" + networkType;
                this.c = a(networkType);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }

        @SuppressLint({"NewApi"})
        public String a(int i) {
            switch (i) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "CDMA - EvDo rev. 0";
                case 6:
                    return "CDMA - EvDo rev. A";
                case 7:
                    return "CDMA - 1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                default:
                    return "UNKNOWN";
            }
        }
    }

    public static a a(Context context) {
        ConnectivityManager connectivityManager;
        a aVar = new a();
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return aVar;
        }
        if (!b(connectivityManager)) {
            return aVar;
        }
        NetworkInfo activeNetworkInfo;
        int a = a(connectivityManager);
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            activeNetworkInfo = null;
        }
        return new a(a, a(activeNetworkInfo), context);
    }

    private static boolean b(ConnectivityManager connectivityManager) {
        NetworkInfo[] allNetworkInfo;
        NetworkInfo[] networkInfoArr = null;
        try {
            allNetworkInfo = connectivityManager.getAllNetworkInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            allNetworkInfo = networkInfoArr;
        }
        if (allNetworkInfo != null) {
            for (NetworkInfo state : allNetworkInfo) {
                boolean z;
                try {
                    if (state.getState() == State.CONNECTED) {
                        z = true;
                    } else {
                        z = false;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    z = false;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int a(ConnectivityManager connectivityManager) {
        State state;
        State state2 = null;
        try {
            state = connectivityManager.getNetworkInfo(0).getState();
        } catch (Throwable th) {
            th.printStackTrace();
            state = state2;
        }
        try {
            state2 = connectivityManager.getNetworkInfo(1).getState();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (state2 == State.CONNECTED || state2 == State.CONNECTING) {
            return 1;
        }
        return (state == State.CONNECTED || state == State.CONNECTING) ? 2 : 0;
    }

    public static String a(NetworkInfo networkInfo) {
        String str = "";
        try {
            str = networkInfo.getExtraInfo();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str;
    }

    public static String b(Context context) {
        return c(context);
    }

    public static String c(Context context) {
        a a = a(context);
        if (a.g == 1) {
            return NetworkType.WIFI_STRING;
        }
        if (a.g != 2) {
            return "UNKNOW";
        }
        int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        if (4 == networkType || 1 == networkType || 2 == networkType) {
            return NetworkType.NET3G_STRING;
        }
        if (13 == networkType) {
            return "4g";
        }
        return NetworkType.NET2G_STRING;
    }

    public static boolean d(Context context) {
        if (a(context).g == 1) {
            return true;
        }
        return false;
    }
}
