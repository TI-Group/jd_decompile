package com.kepler.sdk;

import android.app.Activity;
import android.content.Context;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.login.KeplerApiManager;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class h {
    private String a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private String f;
    private f g;
    private g h;
    private String i;

    /* compiled from: TbsSdkJava */
    static class a {
        private static final h a = new h();
    }

    private h() {
        this.e = false;
    }

    public static final h a() {
        return a.a;
    }

    public String b() {
        return b(this.b, k.b().a());
    }

    public void a(final FaceCommonCallBack faceCommonCallBack) {
        final Context applicatonContext = KeplerApiManager.getWebViewService().getApplicatonContext();
        if (applicatonContext == null) {
            p.a("suwg", "code get token,context==null");
            if (faceCommonCallBack != null) {
                faceCommonCallBack.callBack(this.h, Boolean.valueOf(false), null);
                return;
            }
            return;
        }
        ab abVar = new ab(am.j + "grant_type=authorization_code&app_key=" + j() + "&redirect_uri=" + k.b().a() + "&code=" + this.d + "&app_secret=" + this.c + "&state=12345", null, "get");
        abVar.a(i());
        new aa(abVar, "auth", 19, new ad(this) {
            final /* synthetic */ h c;

            public void a(ac acVar) {
                List a = acVar.a(SM.SET_COOKIE);
                if (a == null || a.size() <= 0) {
                    p.a("suwg", "code get token err, req cont is null:");
                    l.a("get token err ,server return data " + this.c.d, "2016053013484");
                } else {
                    try {
                        String b = acVar.b();
                        JSONObject jSONObject = new JSONObject(b);
                        p.a("suwg", "code get token,get req String :" + b);
                        int optInt = jSONObject.optInt("code");
                        if (optInt == 0) {
                            m.a().a(applicatonContext, "acc_code", optInt);
                            m.a().a(applicatonContext, "acc_exprise", jSONObject.optLong(Constants.PARAM_EXPIRES_IN));
                            m.a().a(applicatonContext, "acc_time", jSONObject.optLong("time"));
                            m.a().a(applicatonContext, "acc_refresh_token", jSONObject.getString("refresh_token"));
                            b = jSONObject.optString(Constants.PARAM_ACCESS_TOKEN);
                            m.a().a(applicatonContext, "kepler_token", b);
                            m.a().a(applicatonContext, "acc_token_type", jSONObject.optString("token_type"));
                            m.a().a(applicatonContext, "uid", jSONObject.optString("uid"));
                            i iVar = new i(b, a);
                            if (faceCommonCallBack != null) {
                                faceCommonCallBack.callBack(this.c.h, Boolean.valueOf(true), iVar);
                            }
                            p.a("suwg", "code get token,ok" + b);
                            this.c.a(iVar);
                            return;
                        }
                        p.a("suwg", "codeget token err, code:" + optInt);
                        l.a("get token err  " + optInt, "201605301348");
                    } catch (JSONException e) {
                        p.a("suwg", "code get token err, JSONException:" + e.getMessage());
                        l.a("get token err " + this.c.d, "201605301348");
                    }
                }
                if (faceCommonCallBack != null) {
                    faceCommonCallBack.callBack(this.c.h, Boolean.valueOf(false), null);
                }
                this.c.a(-1);
            }

            public void a(int i, String str) {
                if (faceCommonCallBack != null) {
                    faceCommonCallBack.callBack(this.c.h, Boolean.valueOf(false), null);
                }
                p.a("suwg", "code get token err, errorCode " + i + " " + str);
                this.c.a(i);
            }
        }).c();
    }

    public void a(Activity activity, g gVar) {
        this.h = gVar;
        this.g = new f();
        this.g.b(activity, gVar);
    }

    public boolean c() {
        return this.g == null && this.h == null;
    }

    public String d() {
        String str = this.i;
        this.i = null;
        return str;
    }

    public void a(Activity activity, String... strArr) {
        if (this.g == null || !this.g.a() || this.h == null) {
            if (o.t && strArr != null && strArr.length > 0) {
                String str = strArr[0];
                if (!aq.b(str)) {
                    this.i = str;
                    this.g.b(activity, this.h);
                    return;
                }
            }
            if (this.h != null) {
                this.h.openH5authPage();
                return;
            }
            return;
        }
        this.g.a(false);
        this.g.b(activity, this.h);
    }

    protected void a(i iVar) {
        if (this.h != null) {
            this.h.authSuccess(iVar);
        }
        this.h = null;
        this.g = null;
    }

    public void a(int i) {
        if (this.h != null) {
            this.h.authFailed(i);
        }
        this.h = null;
        this.g = null;
    }

    public void a(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public boolean a(Context context) {
        boolean a = new ak().a(context, j());
        this.e = a;
        return a;
    }

    private String j() {
        return this.b;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public void a(String str) {
        this.d = str;
    }

    public boolean h() {
        return this.e;
    }

    public void b(String str) {
        this.f = str;
    }

    public String i() {
        return this.f;
    }

    public String b(String str, String str2, String str3) {
        return "http://plogin.m.jd.com/cgi-bin/m/qblogin?appid=100&returnurl=" + ar.f("http://kploauth.jd.com/oauth/wuxian/authorize?client_id=" + this.b + "&redirect_uri=http://kepler.jd.com/oauth/code.do&response_type=code") + "&type=" + str + "&ticket=" + str2 + "&jmpkepler=" + str3;
    }

    private static String b(String str, String str2) {
        return am.g + "clientId=" + str + "&&returnUrl=" + a(str, str2) + "&view=wap";
    }

    public static String a(String str, String str2) {
        String str3 = am.h + "?client_id=" + str + "&redirect_uri=" + str2 + "&state=" + ai.a() + "&view=wap";
        String str4 = "";
        try {
            str4 = URLEncoder.encode(str3, CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str4;
    }
}
