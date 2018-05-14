package com.kepler.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Random;

/* compiled from: TbsSdkJava */
public class ai {
    private static String a;
    private static int b = -1;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(android.content.Context r5) {
        /*
        r4 = this;
        r1 = "";
        r0 = "wifi";
        r0 = r5.getSystemService(r0);	 Catch:{ Exception -> 0x004b, Error -> 0x003f }
        r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ Exception -> 0x004b, Error -> 0x003f }
        if (r0 != 0) goto L_0x0036;
    L_0x000c:
        r0 = com.kepler.sdk.m.a();	 Catch:{ Exception -> 0x004b, Error -> 0x003f }
        r2 = "kepler_mac";
        r0 = r0.b(r5, r2);	 Catch:{ Exception -> 0x004b, Error -> 0x003f }
        if (r0 == 0) goto L_0x0021;
    L_0x0018:
        r1 = "";
        r1 = r1.equals(r0);	 Catch:{ Exception -> 0x002f, Error -> 0x0049 }
        if (r1 != 0) goto L_0x0021;
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = a();	 Catch:{ Exception -> 0x002f, Error -> 0x0049 }
        r1 = com.kepler.sdk.m.a();	 Catch:{ Exception -> 0x002f, Error -> 0x0049 }
        r2 = "kepler_mac";
        r1.a(r5, r2, r0);	 Catch:{ Exception -> 0x002f, Error -> 0x0049 }
        goto L_0x0020;
    L_0x002f:
        r1 = move-exception;
    L_0x0030:
        r2 = "2016_4_22_17_10323";
        com.kepler.sdk.l.a(r1, r2);
        goto L_0x0020;
    L_0x0036:
        r0 = r0.getConnectionInfo();	 Catch:{ Exception -> 0x004b, Error -> 0x003f }
        r0 = r0.getMacAddress();	 Catch:{ Exception -> 0x004b, Error -> 0x003f }
        goto L_0x0020;
    L_0x003f:
        r0 = move-exception;
        r3 = r0;
        r0 = r1;
        r1 = r3;
    L_0x0043:
        r2 = "2016_4_22_17_10323333";
        com.kepler.sdk.l.a(r1, r2);
        goto L_0x0020;
    L_0x0049:
        r1 = move-exception;
        goto L_0x0043;
    L_0x004b:
        r0 = move-exception;
        r3 = r0;
        r0 = r1;
        r1 = r3;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kepler.sdk.ai.a(android.content.Context):java.lang.String");
    }

    public String b(Context context) {
        String b;
        Throwable e;
        Throwable th;
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getDeviceId();
            }
            b = m.a().b(context, "kepler_imei");
            if (b == null) {
                return b;
            }
            try {
                if ("".equals(b)) {
                    return b;
                }
                b = a();
                m.a().a(context, "kepler_imei", b);
                return b;
            } catch (Exception e2) {
                e = e2;
                l.a(e, "2016_4_22_17_12320");
                return b;
            } catch (Error e3) {
                e = e3;
                l.a(e, "2016_4_22_17_1232033");
                return b;
            }
        } catch (Throwable e4) {
            th = e4;
            b = str;
            e = th;
            l.a(e, "2016_4_22_17_12320");
            return b;
        } catch (Throwable e42) {
            th = e42;
            b = str;
            e = th;
            l.a(e, "2016_4_22_17_1232033");
            return b;
        }
    }

    private Signature[] l(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr == null) {
                return null;
            }
            return signatureArr;
        } catch (Throwable e) {
            l.a(e, "2016_4_22_17_103434");
            return null;
        } catch (Throwable e2) {
            l.a(e2, "2016_4_22_17_103435");
            return null;
        }
    }

    public String c(Context context) {
        try {
            String b = m.a().b(context, "md5sign");
            if (b != null && !"".equals(b)) {
                return b;
            }
            Signature[] l = l(context);
            if (l != null) {
                b = new an().a(l[0].toByteArray());
                if (!(b == null || "".equals(b))) {
                    m.a().a(context, "md5sign", b);
                    return b;
                }
            }
            return "";
        } catch (Throwable e) {
            l.a(e, "2016_4_22_17_103422");
        }
    }

    public String d(Context context) {
        try {
            String b = m.a().b(context, "shasign");
            if (b != null && !"".equals(b)) {
                return b;
            }
            Signature[] l = l(context);
            if (l != null) {
                b = new an().c(l[0].toByteArray());
                if (!(b == null || "".equals(b))) {
                    m.a().a(context, "shasign", b);
                    return b;
                }
            }
            return "";
        } catch (Throwable e) {
            l.a(e, "2016_4_22_17_10545");
        }
    }

    public static String a() {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(random.nextInt());
        }
        return stringBuffer.toString();
    }

    public static int e(Context context) {
        if (context == null) {
            return 0;
        }
        PackageInfo a = a(context, "com.jingdong.app.mall");
        if (a != null) {
            return a.versionCode;
        }
        return 0;
    }

    private static void m(Context context) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                    if (packageInfo != null) {
                        a = packageInfo.packageName;
                        b = packageInfo.versionCode;
                        c = packageInfo.versionName;
                    }
                }
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null) {
                    return;
                }
                if (applicationInfo.labelRes != 0) {
                    d = context.getResources().getString(applicationInfo.labelRes);
                    return;
                }
                String str;
                if (applicationInfo.nonLocalizedLabel == null) {
                    str = null;
                } else {
                    str = applicationInfo.nonLocalizedLabel.toString();
                }
                d = str;
            } catch (Exception e) {
            }
        }
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(a)) {
            m(context);
        }
        return a;
    }

    public static String g(Context context) {
        if (TextUtils.isEmpty(c)) {
            m(context);
        }
        return c;
    }

    public static int h(Context context) {
        if (b == -1) {
            m(context);
        }
        return b;
    }

    public static PackageInfo a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 1);
                if (packageInfo != null) {
                    return packageInfo;
                }
            } catch (NameNotFoundException e) {
                return null;
            }
        }
        return null;
    }

    public static String i(Context context) {
        if (TextUtils.isEmpty(e)) {
            if (VERSION.RELEASE.length() <= 0) {
                return "";
            }
            e = VERSION.RELEASE;
        }
        return e;
    }

    public static String j(Context context) {
        if (TextUtils.isEmpty(f)) {
            f = Build.BRAND;
        }
        return f;
    }

    public static String k(Context context) {
        if (TextUtils.isEmpty(g)) {
            g = Build.MODEL;
        }
        return g;
    }
}
