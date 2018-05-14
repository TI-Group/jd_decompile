package com.kepler.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.net.URLEncoder;
import java.util.Locale;
import jd.wjlogin_sdk.util.NetworkType;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
class ax {
    static String a() {
        return "Android";
    }

    static String b() {
        return VERSION.RELEASE;
    }

    static String c() {
        return Build.MODEL;
    }

    static String a(Context context) {
        String str = "";
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        } catch (Throwable th) {
            p.a(th);
            return str;
        }
    }

    static String b(Context context) {
        String str = "";
        switch (context.getResources().getDisplayMetrics().densityDpi) {
            case ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR /*120*/:
                return "LDPI";
            case 160:
                return "MDPI";
            case ErrorCode.COPY_SRCDIR_ERROR /*213*/:
                return "TVDPI";
            case 240:
                return "HDPI";
            case 320:
                return "XHDPI";
            case 400:
                return "XMHDPI";
            case 480:
                return "XXHDPI";
            case 640:
                return "XXXHDPI";
            default:
                return str;
        }
    }

    static String d() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    static String c(Context context) {
        String str = "1.0";
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            p.a(e);
            return str;
        }
    }

    static String d(Context context) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "_dev", c(), "_o", a(), "_oV", b(), "_r", a(context), "_d", b(context), "_l", d());
        String jSONObject2 = jSONObject.toString();
        try {
            jSONObject2 = URLEncoder.encode(jSONObject2, HTTP.UTF_8);
        } catch (Throwable e) {
            p.a(e);
        }
        return jSONObject2;
    }

    static String e(Context context) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "_nt", f(context));
        String jSONObject2 = jSONObject.toString();
        try {
            jSONObject2 = URLEncoder.encode(jSONObject2, HTTP.UTF_8);
        } catch (Throwable e) {
            p.a(e);
        }
        return jSONObject2;
    }

    public static String f(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            String toLowerCase = connectivityManager.getActiveNetworkInfo().getTypeName().toLowerCase(Locale.US);
            if (toLowerCase.equals(NetworkType.WIFI_STRING)) {
                return toLowerCase;
            }
            return connectivityManager.getNetworkInfo(0).getExtraInfo();
        } catch (Throwable e) {
            p.a(e);
            return "";
        }
    }

    static void a(JSONObject jSONObject, String... strArr) {
        try {
            if (strArr.length > 0 && strArr.length % 2 == 0) {
                for (int i = 0; i < strArr.length; i += 2) {
                    String str = strArr[i];
                    String str2 = strArr[i + 1];
                    if (str2 != null && str2.length() > 0) {
                        jSONObject.put(str, str2);
                    }
                }
            }
        } catch (Throwable e) {
            p.a(e);
        }
    }
}
