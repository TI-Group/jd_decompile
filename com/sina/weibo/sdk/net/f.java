package com.sina.weibo.sdk.net;

import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.sina.weibo.sdk.d.d;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Set;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class f {
    private LinkedHashMap<String, Object> a = new LinkedHashMap();
    private String b;

    public f(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public void a(String str, String str2) {
        this.a.put(str, str2);
    }

    public Object a(String str) {
        return this.a.get(str);
    }

    public void b(String str) {
        if (this.a.containsKey(str)) {
            this.a.remove(str);
            this.a.remove(this.a.get(str));
        }
    }

    public Set<String> b() {
        return this.a.keySet();
    }

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : this.a.keySet()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
            } else {
                stringBuilder.append(HttpUtils.PARAMETERS_SEPARATOR);
                obj2 = obj;
            }
            obj = this.a.get(str);
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        stringBuilder.append(URLEncoder.encode(str, HTTP.UTF_8) + HttpUtils.EQUAL_SIGN + URLEncoder.encode(str2, HTTP.UTF_8));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                d.b("encodeUrl", stringBuilder.toString());
            }
            obj = obj2;
        }
        return stringBuilder.toString();
    }

    public boolean d() {
        for (String str : this.a.keySet()) {
            Object obj = this.a.get(str);
            if (!(obj instanceof ByteArrayOutputStream)) {
                if (obj instanceof Bitmap) {
                }
            }
            return true;
        }
        return false;
    }
}
