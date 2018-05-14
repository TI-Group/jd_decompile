package com.jd.fridge.util.a;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.jd.fridge.bean.BaseJsonBean;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.k;
import com.jd.fridge.util.p;
import com.jd.fridge.util.q;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class e<T> extends Request<T> {
    private static final String a = e.class.getSimpleName();
    private final String b;
    private Listener<T> c = null;
    private b d = null;
    private Gson e = null;
    private Class<T> f = null;
    private Context g = null;
    private Map<String, String> h = null;
    private String i = "";
    private String j = "application/json";
    private String k = HTTP.UTF_8;
    private String l = "GET";

    public e(Context context, int i, String str, Class<T> cls, Listener<T> listener, b bVar, Map<String, String> map) {
        super(i, str, bVar);
        k.a("HTTPURL=" + str);
        this.b = str;
        this.f = cls;
        this.c = listener;
        this.d = bVar;
        this.g = context;
        this.h = map;
        if (i == 1) {
            this.l = "POST";
        }
        this.e = new Gson();
        setRetryPolicy(new DefaultRetryPolicy(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT, 0, 1.0f));
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> hashMap = new HashMap();
        try {
            hashMap.put("pin", URLEncoder.encode(a.b().getPin(), CommonUtil.UTF8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        hashMap.put("tgt", a.b().getA2());
        if (this.h != null && this.h.size() > 0) {
            this.i = (String) this.h.get("body");
            this.k = (String) this.h.get("charset");
            this.j = (String) this.h.get("content-type");
        }
        hashMap.put("Authorization", q.a(this.b, this.l, this.i));
        if (this.b.contains("/api/OauthCode/getCode.json")) {
            hashMap.put("wskey", a.b().getA2());
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
        k.a("mparams==" + this.h.toString());
        return this.h;
    }

    public void deliverError(VolleyError volleyError) {
        volleyError.getMessage();
        super.deliverError(volleyError);
    }

    protected void deliverResponse(T t) {
        if (t instanceof BaseJsonBean) {
            BaseJsonBean baseJsonBean = (BaseJsonBean) t;
            if (baseJsonBean.getError() == null) {
                this.c.onResponse(t);
                return;
            } else if (baseJsonBean.getError() == null) {
                return;
            } else {
                if (baseJsonBean.getError().getErrorCode() == 1003) {
                    this.c.onResponse(t);
                    return;
                } else if (baseJsonBean.getError().getErrorCode() == 2001 || baseJsonBean.getError().getErrorCode() == 2003) {
                    this.d.onErrorResponse(new c(String.valueOf(baseJsonBean.getError().getErrorCode())));
                    return;
                } else {
                    this.d.onErrorResponse(new c(baseJsonBean.getError().getErrorInfo()));
                    return;
                }
            }
        }
        this.c.onResponse(t);
    }

    protected VolleyError parseNetworkError(VolleyError volleyError) {
        return super.parseNetworkError(volleyError);
    }

    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        k.a("StatusCode=" + networkResponse.statusCode);
        if (networkResponse.statusCode == 200) {
            try {
                String str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
                p.a(a, "jsonStr: " + str);
                k.a("jsonStr--" + str);
                return Response.success(this.e.fromJson(str, this.f), HttpHeaderParser.parseCacheHeaders(networkResponse));
            } catch (Throwable e) {
                e.printStackTrace();
                Response.error(new c(e));
            } catch (Throwable e2) {
                e2.printStackTrace();
                Response.error(new c(e2));
            }
        } else {
            k.a("result=" + networkResponse.data.toString());
            Response.error(new c(networkResponse));
            return Response.error(new c(networkResponse));
        }
    }
}
