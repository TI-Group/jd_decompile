package com.kepler.sdk;

import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class ar {
    private static String g(String str) {
        try {
            String trim = str.trim();
            String[] split = trim.split("[?]");
            if (trim.length() <= 1 || split.length <= 1 || split[1] == null) {
                return null;
            }
            return split[1];
        } catch (Throwable e) {
            l.a(e, "20165301348");
            return null;
        }
    }

    public static Map<String, String> a(String str) {
        Map<String, String> hashMap = new HashMap();
        try {
            String g = g(str);
            if (g != null) {
                for (String split : g.split("[&]")) {
                    String[] split2 = split.split("[=]");
                    if (split2.length > 1) {
                        hashMap.put(split2[0], split2[1]);
                    } else if (split2[0] != "") {
                        hashMap.put(split2[0], "");
                    }
                }
            }
        } catch (Throwable e) {
            l.a(e, "20165301348");
        }
        return hashMap;
    }

    public static String b(String str) {
        try {
            return new JSONObject(str).optString("skuId", "");
        } catch (Throwable e) {
            l.a(e, "20165301348");
            return "";
        }
    }

    public static String c(String str) {
        try {
            String host = Uri.parse(str).getHost();
            if (host == null) {
                return "";
            }
            return host;
        } catch (Throwable e) {
            l.a(e, "20165301348");
            return "";
        }
    }

    public static String d(String str) {
        try {
            str = str.replaceAll("【", "[").replaceAll("】", "]").replaceAll("！", "!");
            return Pattern.compile("[『』]").matcher(str).replaceAll("").trim();
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = str;
            l.a(th, "20165301348");
            return str2;
        }
    }

    public static String e(String str) {
        return Uri.decode(str);
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, CommonUtil.UTF8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        if (map != null) {
            Set<String> keySet = map.keySet();
            if (keySet != null) {
                Object obj = 1;
                for (String str : keySet) {
                    if (obj == null) {
                        stringBuffer.append(HttpUtils.PARAMETERS_SEPARATOR);
                    }
                    obj = null;
                    stringBuffer.append(str);
                    stringBuffer.append(HttpUtils.EQUAL_SIGN);
                    stringBuffer.append((String) map.get(str));
                }
            }
        }
        return stringBuffer.toString();
    }
}
