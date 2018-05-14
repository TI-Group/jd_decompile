package com.sina.weibo.sdk.b;

import org.json.JSONObject;

/* compiled from: TbsSdkJava */
class e {
    private String a;
    private String b;
    private long c;

    public e(JSONObject jSONObject) {
        a(jSONObject);
    }

    protected void a(JSONObject jSONObject) {
        this.a = jSONObject.optString("notification_text");
        this.b = jSONObject.optString("notification_title");
        this.c = jSONObject.optLong("notification_delay");
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public long g() {
        return this.c;
    }
}
