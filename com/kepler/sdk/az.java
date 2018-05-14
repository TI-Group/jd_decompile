package com.kepler.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import com.jingdong.jdma.JDMaInterface;
import com.kepler.jd.login.KeplerApiManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import jd.wjlogin_sdk.util.NetworkType;

/* compiled from: TbsSdkJava */
public class az {
    public static final String a = KeplerApiManager.getKeplerVersion();
    private static Context c;
    private av b = new av();

    /* compiled from: TbsSdkJava */
    static class a {
        static final az a = new az();
    }

    public static az a() {
        return a.a;
    }

    az() {
    }

    public az a(Context context, String str, String str2) {
        aw.a(context);
        if (context == null) {
            throw new IllegalArgumentException("valid context is required");
        } else if (!b(str)) {
            throw new IllegalArgumentException("valid serverURL is required");
        } else if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("valid appKey is required");
        } else {
            this.b.b(str);
            this.b.a(str2);
            c = context;
            this.b.a(context);
            return this;
        }
    }

    public static String b() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.getSystemService("connectivity");
            String toLowerCase = connectivityManager.getActiveNetworkInfo().getTypeName().toLowerCase(Locale.US);
            if (toLowerCase.equals(NetworkType.WIFI_STRING)) {
                return toLowerCase;
            }
            return connectivityManager.getNetworkInfo(0).getExtraInfo();
        } catch (Exception e) {
            return "";
        }
    }

    public synchronized void c() {
        d();
    }

    void d() {
        this.b.b();
    }

    public void a(String str) {
        a(str, null, null, 1, JDMaInterface.PV_UPPERLIMIT, true);
    }

    public void a(String str, String str2) {
        a(str, str2, null, 1, JDMaInterface.PV_UPPERLIMIT, false);
    }

    public synchronized void a(String str, String str2, Map<String, String> map, int i, double d, boolean z) {
        if (str != null) {
            if (str.length() != 0) {
                if (i < 1) {
                    throw new IllegalArgumentException("KeplerWxManager event count should be greater than zero");
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        if (str3 == null || str3.length() == 0) {
                            throw new IllegalArgumentException("KeplerWxManager event segmentation key cannot be null or empty");
                        }
                        if (map.get(str3) != null) {
                            if (((String) map.get(str3)).length() == 0) {
                            }
                        }
                        throw new IllegalArgumentException("KeplerWxManager event segmentation value cannot be null or empty");
                    }
                }
                ay ayVar = new ay();
                ayVar.a = str;
                ayVar.i = str2;
                ayVar.b = map;
                ayVar.e = e();
                ayVar.f = f();
                ayVar.g = g();
                ayVar.c = i;
                ayVar.d = d;
                ayVar.h = b();
                a("[" + ayVar.a().toString() + "]", z);
            }
        }
        throw new IllegalArgumentException("Valid KeplerWxManager event key is required");
    }

    void a(String str, boolean z) {
        this.b.a(URLEncoder.encode(str), z);
    }

    static int e() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    static int f() {
        return Calendar.getInstance().get(11);
    }

    static int g() {
        switch (Calendar.getInstance().get(7)) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            default:
                return 0;
        }
    }

    public static boolean b(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            URL url = new URL(str);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
