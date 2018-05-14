package com.kepler.sdk;

import android.os.Build.VERSION;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.login.KeplerApiManager;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;
import uk.co.chrisjenx.calligraphy.BuildConfig;

/* compiled from: TbsSdkJava */
public class v {
    String a;

    public void a(final FaceCommonCallBack<String> faceCommonCallBack) {
        String a = a();
        Map hashtable = new Hashtable();
        hashtable.put("p", a);
        new aa(new ab("https://mapi.m.jd.com/ksdk/updlist.json", hashtable, "post"), "static_html_config", 7, new ad(this) {
            final /* synthetic */ v b;

            public void a(ac acVar) {
                faceCommonCallBack.callBack(acVar.b());
            }

            public void a(int i, String str) {
                p.a("suwg", "get html failed" + i + ":" + str);
            }
        }).c();
    }

    private String a() {
        if (this.a == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceId", af.a(KeplerApiManager.getWebViewService().getApplicatonContext()));
                jSONObject.put("os", 2);
                jSONObject.put("appves", af.b(KeplerApiManager.getWebViewService().getApplicatonContext()));
                jSONObject.put("lastuptime", 0);
                jSONObject.put("model", af.a());
                jSONObject.put("osves", VERSION.RELEASE);
                jSONObject.put("wid", "");
                jSONObject.put("brand", af.b());
                jSONObject.put("kepler_version", ar.f(BuildConfig.VERSION_NAME));
            } catch (Throwable th) {
                p.a(th);
                l.a(th, "2016_4_22_17_12_22");
            }
            this.a = jSONObject.toString();
        }
        return this.a;
    }
}
