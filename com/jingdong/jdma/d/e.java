package com.jingdong.jdma.d;

import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class e {
    private String a = "";
    private String b = "";

    public static String a(HashMap<String, String> hashMap) {
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject();
            for (Entry entry : hashMap.entrySet()) {
                try {
                    String str2 = ((String) entry.getKey()) + "";
                    String str3 = ((String) entry.getValue()) + "";
                    if (!("".equals(str2) || "".equals(str3))) {
                        jSONObject.put(str2, str3);
                    }
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(HashMap<String, String> hashMap) {
        this.b = a((HashMap) hashMap);
    }

    public String b() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }
}
