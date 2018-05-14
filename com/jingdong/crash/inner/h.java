package com.jingdong.crash.inner;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class h extends aj {
    h() {
    }

    public void a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("configs");
        Iterator keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (str2 != null) {
                if (str2.equals("isPost")) {
                    if (optJSONObject.optInt("isPost") == 1) {
                        g.b(true);
                    } else {
                        g.b(false);
                    }
                } else if (str2.equals("isInitSdk")) {
                    if (optJSONObject.optInt("isInitSdk") == 1) {
                        g.a(true);
                    } else {
                        g.a(false);
                    }
                } else if (str2.equals("crashLimit")) {
                    int optInt = optJSONObject.optInt("crashLimit");
                    if (optInt > 0) {
                        g.a(optInt);
                    }
                }
            }
        }
    }

    public void a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("version", str2);
        } catch (JSONException e) {
            if (ah.b) {
                e.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("keplerInfo", jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("body", jSONObject2.toString());
        if (ah.b) {
            ah.a("NetWorkHelper", "body is ........" + jSONObject2.toString());
        }
        a(new i(this), hashMap, "sdkConfig");
    }
}
