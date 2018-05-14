package com.kepler.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class t {
    long a;
    private Context b;
    private String c;
    private HashMap<String, u> d = new HashMap();

    public t(Context context) {
        this.b = context;
    }

    public w a(String str) {
        if (aq.b(str)) {
            return null;
        }
        HashMap hashMap = (HashMap) this.d.clone();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("updateTime");
            if (aq.b(optString) || optString.equals(this.c)) {
                return null;
            }
            this.c = optString;
            JSONArray optJSONArray = jSONObject.optJSONArray("updateList");
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    jSONObject = optJSONArray.optJSONObject(i);
                    optString = jSONObject.optString("url");
                    u uVar = new u(optString, jSONObject.optString("targetUrl"), jSONObject.optString("md5"), jSONObject.optString("version"), jSONObject.optString("updateTime"), jSONObject.optString("mime"), jSONObject.optString("encoding"));
                    u uVar2 = (u) hashMap.remove(optString);
                    if (uVar2 == null) {
                        arrayList.add(uVar);
                    } else if (uVar2.equals(uVar)) {
                        arrayList2.add(uVar);
                    } else {
                        arrayList.add(uVar);
                    }
                }
            }
            if (hashMap.size() > 0) {
                for (Object obj : hashMap.keySet()) {
                    arrayList3.add((u) hashMap.get(obj));
                }
            }
            ap.a(this.b, "AccelerateCacheJsonKey", str);
            return new w(arrayList, arrayList2, arrayList3);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public w a() {
        return a(ap.b(this.b, "AccelerateCacheJsonKey", null));
    }

    public long b() {
        if (this.a <= 0) {
            this.a = ap.b(this.b, "AccelerateCacheLastTimeNet", -1);
        }
        return this.a;
    }

    public void a(long j) {
        ap.a(this.b, "AccelerateCacheLastTimeNet", j);
        this.a = j;
    }

    public void a(HashMap<String, u> hashMap) {
        if (hashMap != null) {
            this.d = hashMap;
        }
    }

    public u b(String str) {
        if (this.d != null) {
            return (u) this.d.get(str);
        }
        return null;
    }
}
