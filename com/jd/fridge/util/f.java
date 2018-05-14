package com.jd.fridge.util;

import android.content.Context;

/* compiled from: TbsSdkJava */
public class f {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String c(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("channel");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean a(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if ('?' > charAt || charAt > '?') {
                if ('℀' <= charAt && charAt <= '⟿' && charAt != '☻') {
                    return true;
                }
                if ('⬅' <= charAt && charAt <= '⬇') {
                    return true;
                }
                if ('⤴' <= charAt && charAt <= '⤵') {
                    return true;
                }
                if (('㊗' <= charAt && charAt <= '㊙') || charAt == '©' || charAt == '®' || charAt == '〽' || charAt == '〰' || charAt == '⭕' || charAt == '⬜' || charAt == '⬛' || charAt == '⭐' || charAt == '⌚') {
                    return true;
                }
                if (str.length() > 1 && i < str.length() - 1 && str.charAt(i + 1) == '⃣') {
                    return true;
                }
            } else if (str.length() > 1) {
                int charAt2 = (((charAt - 55296) * 1024) + (str.charAt(i + 1) - 56320)) + 65536;
                if (118784 <= charAt2 && charAt2 <= 128895) {
                    return true;
                }
            } else {
                continue;
            }
            i++;
        }
        return false;
    }
}
