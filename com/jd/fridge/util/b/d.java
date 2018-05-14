package com.jd.fridge.util.b;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.jd.fridge.util.p;
import com.tencent.open.SocialConstants;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class d {
    private static String b = d.class.getSimpleName();
    private static String c = "jd-socket";
    Map<String, Object> a = new HashMap();
    private Activity d;
    private WebView e;
    private a f;
    private List<String> g = new ArrayList();
    private long h = 0;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(JSONObject jSONObject, String str);

        void b(String str);

        void c(String str);
    }

    public d(Activity activity, WebView webView, a aVar) {
        this.d = activity;
        this.e = webView;
        this.f = aVar;
    }

    @JavascriptInterface
    public void _handleMessageFromJs(String str, String str2, String str3, String str4, String str5) {
        p.a(b, "_handleMessageFromJs :   \n" + str + "\n  responseId: " + str2 + "\n responseData: " + str3 + "\n callbackId: " + str4 + "\n handlerName: " + str5);
        if (str4 != null) {
            this.g.add(str4);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            CharSequence optString = jSONObject.optString(SocialConstants.PARAM_TYPE);
            if (TextUtils.equals(optString, "controlDevice")) {
                p.a(c, "request-控制");
                this.f.a(jSONObject, str4);
            } else if (TextUtils.equals(optString, "getSnapshot")) {
                p.a(c, "request-快照");
                this.f.b(str4);
            } else if (TextUtils.equals(optString, "messageToast")) {
                this.f.c(jSONObject.optJSONObject("data").optString("message"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        if (this.g.contains(str)) {
            Map hashMap = new HashMap();
            hashMap.put("responseId", str);
            hashMap.put("responseData", str2);
            a(hashMap);
            this.g.remove(str);
        }
    }

    private void a(Map<String, String> map) {
        String format = String.format("javascript:WebViewJavascriptBridge._handleMessageFromJava('%s');", new Object[]{c(new JSONObject(map).toString())});
        p.a(b, "call js _handleMessageFromJava: " + format);
        b(format);
    }

    public void a(String str) {
        String format = String.format("javascript:onReceive('%s');", new Object[]{c(str)});
        p.a(b, "call js onReceive: " + format);
        b(format);
    }

    private void b(final String str) {
        this.d.runOnUiThread(new Runnable(this) {
            final /* synthetic */ d b;

            public void run() {
                this.b.e.loadUrl(str);
            }
        });
    }

    private String c(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"").replace("'", "\\'").replace("\n", "\\n").replace("\r", "\\r").replace("\f", "\\f");
    }
}
