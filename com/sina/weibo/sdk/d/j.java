package com.sina.weibo.sdk.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import cn.jiguang.net.HttpUtils;
import com.sina.weibo.sdk.d.b.a;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class j {
    public static Bundle a(String str) {
        try {
            URL url = new URL(str);
            Bundle c = c(url.getQuery());
            c.putAll(c(url.getRef()));
            return c;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static Bundle b(String str) {
        try {
            return c(new URI(str).getQuery());
        } catch (Exception e) {
            return new Bundle();
        }
    }

    public static Bundle c(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split(HttpUtils.PARAMETERS_SEPARATOR)) {
                String[] split2 = split.split(HttpUtils.EQUAL_SIGN);
                try {
                    bundle.putString(URLDecoder.decode(split2[0], HTTP.UTF_8), URLDecoder.decode(split2[1], HTTP.UTF_8));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (Signature toByteArray : packageInfo.signatures) {
                byte[] toByteArray2 = toByteArray.toByteArray();
                if (toByteArray2 != null) {
                    return e.a(toByteArray2);
                }
            }
            return null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static String b(Context context, String str) {
        a b = b.a(context).b(str);
        if (b != null) {
            return b.a();
        }
        return "";
    }

    public static String a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
        stringBuilder.append("_");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("_");
        stringBuilder.append("weibosdk");
        stringBuilder.append("_");
        stringBuilder.append("0031205000");
        stringBuilder.append("_android");
        return stringBuilder.toString();
    }
}
