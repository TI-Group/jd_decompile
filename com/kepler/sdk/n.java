package com.kepler.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.kepler.jd.Listener.ActionCallBck;
import com.kepler.jd.Listener.OpenAppAction;
import com.kepler.jd.login.KeplerApiManager;
import com.kepler.jd.sdk.bean.KelperTask;
import com.kepler.jd.sdk.bean.KeplerAttachParameter;
import com.kepler.jd.sdk.bean.KeplerGlobalParameter;
import com.kepler.jd.sdk.exception.KeplerBufferOverflowException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;
import uk.co.chrisjenx.calligraphy.BuildConfig;

/* compiled from: TbsSdkJava */
public class n {
    ActionCallBck a = new ActionCallBck(this) {
        final /* synthetic */ n a;

        {
            this.a = r1;
        }

        public boolean onDateCall(int i, String str) {
            if (this.a.i.isCancel()) {
                return false;
            }
            try {
                this.a.a(3);
                this.a.a(str);
            } catch (Throwable th) {
                p.a(th, "kepler open app ");
                l.a(th, "201710191720");
                onErrCall(-1, th.getMessage());
            }
            return true;
        }

        public boolean onErrCall(int i, String str) {
            if (this.a.i.isCancel()) {
                return false;
            }
            this.a.a(2);
            this.a.c();
            return true;
        }
    };
    private String b;
    private String c;
    private boolean d;
    private KeplerAttachParameter e;
    private OpenAppAction f;
    private int g;
    private Context h;
    private KelperTask i = null;

    public n(Context context, String str, String str2, boolean z, KeplerAttachParameter keplerAttachParameter, OpenAppAction openAppAction, int i) {
        this.h = context;
        this.b = str;
        this.e = keplerAttachParameter;
        this.c = str2;
        this.d = z;
        this.f = openAppAction;
        this.g = i;
    }

    public KelperTask a() {
        if (this.i != null) {
            return null;
        }
        this.i = new KelperTask();
        try {
            a(1);
            b();
        } catch (Throwable e) {
            p.a(e, "kepler ");
            this.a.onErrCall(-1, e.getMessage());
        }
        return this.i;
    }

    private void a(int i) {
        if (this.f != null) {
            this.f.onStatus(i);
        }
    }

    private void b() throws UnsupportedEncodingException {
        Map hashtable = new Hashtable();
        ai aiVar = new ai();
        hashtable.put("kepler_os", ar.f("android"));
        hashtable.put("kepler_version", ar.f(BuildConfig.VERSION_NAME));
        hashtable.put("kepler_imei", ar.f(aiVar.b(al.a())));
        hashtable.put("appkey", h.a().f());
        hashtable.put("appkey2", KeplerGlobalParameter.getSingleton().getVirtualAppkey());
        hashtable.put("mopenbp7", KeplerGlobalParameter.getSingleton().getJDappBackTagID());
        hashtable.put("mopenbp5", this.e.get("keplerCustomerInfo"));
        this.e.add2Map(hashtable);
        hashtable.put("actId", KeplerGlobalParameter.getSingleton().getActId());
        hashtable.put("ext", KeplerGlobalParameter.getSingleton().getExt());
        hashtable.put("sku", aq.a(this.c) ? "null" : this.c);
        hashtable.put("url", ar.f(this.b));
        ab abVar = new ab("https://mapi.m.jd.com/ksdk/scheme.json", hashtable, "post");
        abVar.a(this.g);
        aa aaVar = new aa(abVar, "get_open_scheme", 19, new ad(this) {
            final /* synthetic */ n a;

            {
                this.a = r1;
            }

            public void a(ac acVar) {
                try {
                    JSONObject jSONObject = new JSONObject(acVar.b());
                    int optInt = jSONObject.optInt("code");
                    String optString = jSONObject.optString("appScheme");
                    if (optInt != 0 || aq.b(optString)) {
                        throw new Exception("the openScheme is null");
                    } else if (this.a.a != null) {
                        this.a.a.onDateCall(1, optString);
                    }
                } catch (Throwable th) {
                    l.a(th, "2016611348");
                    if (this.a.a != null) {
                        this.a.a.onErrCall(-1, th == null ? "" : th.getMessage());
                    }
                }
            }

            public void a(int i, String str) {
                if (this.a.a != null) {
                    this.a.a.onErrCall(i, str);
                }
            }
        });
        this.i.setNetLinker(aaVar);
        aaVar.c();
    }

    private void c() {
        try {
            KeplerApiManager.getWebViewService().openWebViewPage(this.b, this.c, false, this.e, true);
        } catch (KeplerBufferOverflowException e) {
            e.printStackTrace();
        }
    }

    private void a(String str) throws Throwable {
        if (str.startsWith("weixin:") || str.startsWith("openapp.jdmobile:")) {
            p.b("suwg", str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(805306368);
            this.h.startActivity(intent);
            return;
        }
        throw new Exception("scheme is not support" + str);
    }
}
