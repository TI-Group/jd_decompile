package com.jingdong.crash.inner;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class y extends Thread {
    final /* synthetic */ CrashService a;

    y(CrashService crashService) {
        this.a = crashService;
    }

    public void run() {
        super.run();
        if (TextUtils.isEmpty(a.a)) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.a.c.d.put("battery", a.a);
        try {
            this.a.a = new JSONObject(this.a.c.toString());
            if (ah.b) {
                ah.a("Crash", this.a.c.toString());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            q.a(this.a.a, new z(this));
        } catch (Exception e3) {
            this.a.a();
            if (ah.b) {
                e3.printStackTrace();
            }
        }
    }
}
