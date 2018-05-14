package com.jd.fridge.util.a;

import android.content.Context;
import android.content.Intent;
import cn.jiguang.net.HttpConstants;
import cn.jpush.android.api.JPushInterface;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.google.gson.Gson;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.BaseJsonBean;
import com.jd.fridge.bean.Event;
import com.jd.fridge.bean.requestBody.CancelRegisterAudienceByUser;
import com.jd.fridge.login.LoginActivity;
import com.jd.fridge.util.e.b;
import com.jd.fridge.util.k;
import com.jd.fridge.util.q;
import com.jd.fridge.util.r;
import com.jd.fridge.util.t;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.kepler.jd.login.KeplerApiManager;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import jd.wjlogin_sdk.common.listener.OnCommonCallback;
import jd.wjlogin_sdk.model.FailResult;
import org.apache.http.protocol.HTTP;
import org.greenrobot.eventbus.c;

/* compiled from: TbsSdkJava */
public class d<T> extends Request<T> {
    private final String a;
    private Listener<T> b;
    private a c;
    private Gson d;
    private Class<T> e;
    private t f;
    private Context g;
    private Map<String, String> h;
    private String i;
    private String j;
    private String k;
    private String l;
    private a m;
    private boolean n;
    private Timer o;
    private TimerTask p;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(String str);
    }

    public d(Context context, int i, String str, Class<T> cls, Listener<T> listener, a aVar, Map<String, String> map) {
        super(i, str, aVar);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = "";
        this.j = "application/json";
        this.k = HTTP.UTF_8;
        this.l = "GET";
        this.n = true;
        this.o = new Timer();
        this.p = new TimerTask(this) {
            final /* synthetic */ d a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.n = true;
            }
        };
        k.a("HTTPURL=" + str);
        r.c("infos", "HTTPURL==" + str);
        this.a = str;
        this.e = cls;
        this.b = listener;
        this.c = aVar;
        this.f = new t(context);
        this.g = context;
        this.h = map;
        if (i == 1) {
            this.l = "POST";
        }
        this.d = new Gson();
        setRetryPolicy(new DefaultRetryPolicy(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT, 0, 1.0f));
    }

    public d(Context context, int i, String str, Class<T> cls, Listener<T> listener, a aVar, Map<String, String> map, a aVar2) {
        this(context, i, str, cls, listener, aVar, map);
        this.m = aVar2;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("pin", URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        hashMap.put("tgt", com.jd.fridge.util.c.a.b().getA2());
        if (this.h != null && this.h.size() > 0) {
            this.i = (String) this.h.get("body");
            this.k = (String) this.h.get("charset");
            this.j = (String) this.h.get("content-type");
        }
        hashMap.put("Authorization", q.a(this.a, this.l, this.i));
        if (this.a.contains("/api/OauthCode/getCode.json") || this.a.contains("/api/recommend/goodsList.json")) {
            hashMap.put("wskey", com.jd.fridge.util.c.a.b().getA2());
        }
        if (this.a.contains("api/recipe/hot_keys.json") || this.a.contains("api/recipe/search_tips.json")) {
            hashMap.put("wskey", com.jd.fridge.util.c.a.b().getA2());
            hashMap.put("fid", GlobalVariable.C());
        }
        return hashMap;
    }

    public byte[] getBody() throws AuthFailureError {
        byte[] bArr = null;
        try {
            if (this.i != null) {
                bArr = this.i.getBytes(this.k);
            }
        } catch (UnsupportedEncodingException e) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.i, this.k);
        }
        return bArr;
    }

    public String getBodyContentType() {
        return String.format("%s; charset=%s", new Object[]{this.j, this.k});
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        if (this.h == null) {
            this.h = new HashMap();
        }
        k.a("params===" + this.h.toString());
        return this.h;
    }

    public void deliverError(VolleyError volleyError) {
        volleyError.getMessage();
        super.deliverError(volleyError);
    }

    protected void deliverResponse(T t) {
        if (t instanceof BaseJsonBean) {
            BaseJsonBean baseJsonBean = (BaseJsonBean) t;
            r.c("infos", "bean.error===" + baseJsonBean.getError());
            k.a("bean.error===" + baseJsonBean.getError());
            if (baseJsonBean.getError() == null) {
                this.b.onResponse(t);
                c.a().c(Event.newEvent(3, null));
                return;
            } else if (baseJsonBean.getError() != null) {
                r.b("infos", "errorCode==" + baseJsonBean.getError().getErrorCode());
                if (baseJsonBean.getError().getErrorCode() == 1003) {
                    this.b.onResponse(t);
                    return;
                } else if (baseJsonBean.getError().getErrorCode() == HttpConstants.NET_TIMEOUT_CODE || baseJsonBean.getError().getErrorCode() == 2011 || baseJsonBean.getError().getErrorCode() == 2007 || baseJsonBean.getError().getErrorCode() == 2008) {
                    this.b.onResponse(t);
                    return;
                } else if (baseJsonBean.getError().getErrorCode() == 2001 || baseJsonBean.getError().getErrorCode() == 2003) {
                    if (this.n) {
                        this.f.a(this.g.getString(R.string.error_message_unbind_fridge));
                        this.n = false;
                        this.o.schedule(this.p, 5000);
                    }
                    GlobalVariable.c("");
                    b.a().a(false);
                    this.g.sendBroadcast(new Intent("BR_ACTION_FRIDGE_UNBINDED_2001"));
                    this.c.a(true);
                    this.c.onErrorResponse(new c(String.valueOf(baseJsonBean.getError().getErrorCode())));
                    return;
                } else if (baseJsonBean.getError().getErrorCode() == 2004) {
                    this.c.a(true);
                    this.c.onErrorResponse(new c(String.valueOf(baseJsonBean.getError().getErrorCode())));
                    return;
                } else if (baseJsonBean.getError().getErrorCode() == -4) {
                    if (this.n) {
                        this.f.a(this.g.getString(R.string.error_message_login_overtime));
                        this.n = false;
                        this.o.schedule(this.p, 5000);
                    }
                    if (b.a().e()) {
                        com.jd.fridge.a.a().a(new CancelRegisterAudienceByUser(GlobalVariable.I(), Long.parseLong(GlobalVariable.C()), JPushInterface.getRegistrationID(this.g)));
                    }
                    com.jd.fridge.util.c.a.b().exitLogin(new OnCommonCallback(this) {
                        final /* synthetic */ d a;

                        {
                            this.a = r1;
                        }

                        public void onSuccess() {
                            this.a.a();
                        }

                        public void onError(String str) {
                            this.a.a();
                        }

                        public void onFail(FailResult failResult) {
                            this.a.a();
                        }
                    });
                    this.c.a(true);
                    this.c.onErrorResponse(new c(baseJsonBean.getError().getErrorInfo()));
                    return;
                } else if (baseJsonBean.getError().getErrorCode() == 3002) {
                    this.c.a(true);
                    this.c.onErrorResponse(new c(baseJsonBean.getError().getErrorInfo()));
                    return;
                } else if (baseJsonBean.getError().getErrorCode() == -1) {
                    k.a("===return=菜谱首页推荐信息查询错误==");
                    return;
                } else if (baseJsonBean.getError().getErrorCode() == -201) {
                    this.c.a(true);
                    this.c.onErrorResponse(new c(String.valueOf(baseJsonBean.getError().getErrorCode())));
                    return;
                } else if (baseJsonBean.getError().getErrorCode() == 2006) {
                    this.c.a(true);
                    this.c.onErrorResponse(new c(String.valueOf(baseJsonBean.getError().getErrorInfo())));
                    return;
                } else {
                    this.c.a(false);
                    this.c.onErrorResponse(new c(baseJsonBean.getError().getErrorInfo()));
                    return;
                }
            } else {
                return;
            }
        }
        this.b.onResponse(t);
    }

    protected VolleyError parseNetworkError(VolleyError volleyError) {
        return super.parseNetworkError(volleyError);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected com.android.volley.Response<T> parseNetworkResponse(com.android.volley.NetworkResponse r7) {
        /*
        r6 = this;
        r5 = 1;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "StatusCode=";
        r0 = r0.append(r1);
        r1 = r7.statusCode;
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.jd.fridge.util.k.a(r0);
        r0 = "infoss";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "code==";
        r1 = r1.append(r2);
        r2 = r7.statusCode;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.jd.fridge.util.r.c(r0, r1);
        r2 = "";
        r0 = r7.statusCode;
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r1) goto L_0x013e;
    L_0x003b:
        r0 = org.greenrobot.eventbus.c.a();
        r1 = 3;
        r3 = 0;
        r1 = com.jd.fridge.bean.Event.newEvent(r1, r3);
        r0.c(r1);
        r1 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x00f0, Exception -> 0x0114 }
        r0 = r7.data;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x00f0, Exception -> 0x0114 }
        r3 = r7.headers;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x00f0, Exception -> 0x0114 }
        r3 = com.android.volley.toolbox.HttpHeaderParser.parseCharset(r3);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x00f0, Exception -> 0x0114 }
        r1.<init>(r0, r3);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x00f0, Exception -> 0x0114 }
        r0 = r6.m;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        if (r0 == 0) goto L_0x005e;
    L_0x0059:
        r0 = r6.m;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r0.a(r1);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
    L_0x005e:
        r0 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r2 = "jsonStr===";
        r0 = r0.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r0 = r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r0 = r0.toString();	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        com.jd.fridge.util.k.a(r0);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r0 = "infoss";
        r2 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r2.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r3 = "jsonStr==";
        r2 = r2.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r2 = r2.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        com.jd.fridge.util.r.c(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r0 = "infoss";
        r2 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r2.<init>();	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r3 = "gson==";
        r2 = r2.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r3 = r6.d;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r4 = r6.e;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r3 = r3.fromJson(r1, r4);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r2 = r2.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        com.jd.fridge.util.r.c(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r0 = r6.d;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r2 = r6.e;	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r0 = r0.fromJson(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r2 = com.android.volley.toolbox.HttpHeaderParser.parseCacheHeaders(r7);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
        r0 = com.android.volley.Response.success(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x00bd, JsonSyntaxException -> 0x0187, Exception -> 0x0114 }
    L_0x00bc:
        return r0;
    L_0x00bd:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = r6.f;
        r1.a(r5);
        r1 = new com.jd.fridge.util.a.c;
        r1.<init>(r0);
        com.android.volley.Response.error(r1);
        r1 = "infoss";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "jsonStr=1111111=";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.jd.fridge.util.r.c(r1, r0);
    L_0x00e6:
        r0 = new com.jd.fridge.util.a.c;
        r0.<init>(r7);
        r0 = com.android.volley.Response.error(r0);
        goto L_0x00bc;
    L_0x00f0:
        r0 = move-exception;
        r1 = r2;
    L_0x00f2:
        r2 = r6.c;
        if (r2 == 0) goto L_0x00fb;
    L_0x00f6:
        r2 = r6.c;
        r2.a(r1);
    L_0x00fb:
        r1 = "infoss";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "JsonSyntaxException=222=";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.jd.fridge.util.r.c(r1, r0);
        goto L_0x00e6;
    L_0x0114:
        r0 = move-exception;
        r0.printStackTrace();
        r1 = r6.f;
        r1.a(r5);
        r1 = new com.jd.fridge.util.a.c;
        r1.<init>(r0);
        com.android.volley.Response.error(r1);
        r1 = "infoss";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "jsonStr=333=";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.jd.fridge.util.r.c(r1, r0);
        goto L_0x00e6;
    L_0x013e:
        r0 = "infos";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "response fail: ";
        r1 = r1.append(r2);
        r2 = r7.data;
        r2 = r2.toString();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.jd.fridge.util.r.c(r0, r1);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "result=";
        r0 = r0.append(r1);
        r1 = r7.data;
        r1 = r1.toString();
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.jd.fridge.util.k.a(r0);
        r0 = r6.f;
        r0.a(r5);
        r0 = new com.jd.fridge.util.a.c;
        r0.<init>(r7);
        com.android.volley.Response.error(r0);
        goto L_0x00e6;
    L_0x0187:
        r0 = move-exception;
        goto L_0x00f2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.fridge.util.a.d.parseNetworkResponse(com.android.volley.NetworkResponse):com.android.volley.Response<T>");
    }

    private void a() {
        Intent intent = new Intent(this.g.getApplicationContext(), LoginActivity.class);
        intent.setFlags(268468224);
        this.g.startActivity(intent);
        b.a().h();
        GlobalVariable.a().k();
        b.a().a(false);
        GlobalVariable.c("");
        GlobalVariable.d("");
        GlobalVariable.d(-1);
        GlobalVariable.e("");
        b.a().c("");
        KeplerApiManager.getWebViewService().cancelAuth(this.g.getApplicationContext());
        JPushInterface.stopPush(this.g.getApplicationContext());
    }
}
