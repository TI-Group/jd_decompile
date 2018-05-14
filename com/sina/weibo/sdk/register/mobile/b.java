package com.sina.weibo.sdk.register.mobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class b implements Serializable {
    private static final long serialVersionUID = 1;
    public List<a> countries;

    public b(String str) {
        a(str);
    }

    private void a(String str) {
        try {
            initFromJsonObject(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void initFromJsonObject(JSONObject jSONObject) throws com.sina.weibo.sdk.c.b {
        try {
            this.countries = new ArrayList();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                String string = optJSONObject.getString("code");
                JSONArray optJSONArray = optJSONObject.optJSONObject("rule").optJSONArray("mcc");
                String[] strArr = new String[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    strArr[i] = optJSONArray.getString(i);
                }
                a aVar = new a(str, string);
                aVar.setMccs(strArr);
                this.countries.add(aVar);
            }
        } catch (Throwable e) {
            e.printStackTrace();
            throw new com.sina.weibo.sdk.c.b(e);
        }
    }
}
