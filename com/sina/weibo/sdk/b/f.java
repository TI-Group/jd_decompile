package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.c.b;
import com.sina.weibo.sdk.d.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
class f {
    private static final String a = e.class.getName();
    private List<a> b;
    private List<c> c;
    private int d;

    public f(String str) throws b {
        a(str);
    }

    private void a(String str) throws b {
        int i = 0;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("error") || jSONObject.has("error_code")) {
                    d.d(a, "load cmd api has error !!!");
                    throw new b("load cmd api has error !!!");
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("cmd");
                if (optJSONObject != null) {
                    this.d = optJSONObject.optInt("frequency");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("app_install");
                    if (optJSONArray != null) {
                        this.b = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            this.b.add(new a(optJSONArray.getJSONObject(i2)));
                        }
                    }
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("app_invoke");
                    if (optJSONArray2 != null) {
                        this.c = new ArrayList();
                        while (i < optJSONArray2.length()) {
                            this.c.add(new c(optJSONArray2.getJSONObject(i)));
                            i++;
                        }
                    }
                }
            } catch (JSONException e) {
                d.a(a, "parse NotificationInfo error: " + e.getMessage());
            }
        }
    }

    public List<a> a() {
        return this.b;
    }

    public List<c> b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }
}
