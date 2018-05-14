package com.jingdong.crash.inner;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;

class k {
    public static m a = new l();
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static boolean f;

    public static String a() {
        if (TextUtils.isEmpty(b)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("&uuid=").append(b());
            stringBuffer.append(c());
            b = stringBuffer.toString();
            if (ah.b) {
                ah.a("Temp", "getParamStr() create -->> " + b);
            }
            return b;
        }
        if (ah.b) {
            ah.a("StatisticsReportUtil", "getParamStr() -->> " + b);
        }
        return b;
    }

    public static String a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        Object a = n.a(context);
        if (!TextUtils.isEmpty(a)) {
            a = a.trim().replaceAll("-", "");
        }
        Object obj = e;
        if (obj == null) {
            n.a(a, context);
            synchronized (a) {
                try {
                    if (!f) {
                        if (ah.b) {
                            ah.a("Temp", "mac wait start -->> ");
                        }
                        a.wait();
                        if (ah.b) {
                            ah.a("Temp", "mac wait end -->> ");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            obj = e == null ? "" : e;
        }
        if (!TextUtils.isEmpty(obj)) {
            obj = obj.trim().replaceAll("-|\\.|:", "");
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(a);
        }
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(obj)) {
            stringBuilder.append(obj);
        }
        return stringBuilder.toString();
    }

    private static String a(String str, int i) {
        if (str != null) {
            try {
                if (str.length() > i) {
                    str = str.substring(0, i);
                }
            } catch (Exception e) {
                if (ah.e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    public static synchronized String b() {
        String d;
        synchronized (k.class) {
            d = d();
            if (d == null) {
                if (ah.b) {
                    ah.a("Temp", "readDeviceUUID() create -->> ");
                }
                d = a(q.d());
                if (b(d)) {
                    if (ah.b) {
                        ah.a("Temp", "readDeviceUUID() write -->> ");
                    }
                    try {
                        ab.a(q.d()).edit().putString("uuid", d).commit();
                    } catch (Exception e) {
                        if (ah.b) {
                            e.printStackTrace();
                        }
                    }
                }
                if (ah.b) {
                    ah.a("Temp", "readDeviceUUID() create deivceUUID -->> " + d);
                }
            } else if (ah.b) {
                ah.a("Temp", "readDeviceUUID() read deivceUUID -->> " + d);
            }
        }
        return d;
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

    private static String c() {
        try {
            if (TextUtils.isEmpty(c)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("&clientVersion=").append("1.0.1");
                stringBuffer.append("&client=").append("crsdkandr");
                stringBuffer.append("&build=").append(p.e);
                stringBuffer.append("&appName=").append(p.d);
                try {
                    stringBuffer.append("&d_brand=").append(a(Build.MANUFACTURER, 12).replaceAll(" ", ""));
                    stringBuffer.append("&d_model=").append(a(Build.MODEL, 12).replaceAll(" ", ""));
                } catch (Exception e) {
                    if (ah.e) {
                        e.printStackTrace();
                    }
                }
                stringBuffer.append("&osVersion=").append(a(VERSION.RELEASE, 12));
                Display defaultDisplay = ((WindowManager) q.d().getSystemService("window")).getDefaultDisplay();
                stringBuffer.append("&screen=").append(defaultDisplay.getHeight() + "*" + defaultDisplay.getWidth());
                stringBuffer.append("&partner=").append(p.a);
                c = stringBuffer.toString();
                if (ah.b) {
                    ah.a("Temp", "getParamStrWithOutDeviceUUID() create -->> " + c);
                }
                return c;
            }
            if (ah.b) {
                ah.a("Temp", "getParamStrWithOutDeviceUUID() -->> " + c);
            }
            return c;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String d() {
        if (!TextUtils.isEmpty(d) && b(d)) {
            return d;
        }
        String string = ab.a(q.d()).getString("uuid", null);
        if (!b(string)) {
            return null;
        }
        d = string;
        return d;
    }
}
