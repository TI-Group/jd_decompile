package com.kepler.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import cn.jiguang.net.HttpUtils;
import com.kepler.jd.Listener.FaceCommonCallBack;
import java.lang.reflect.Method;

/* compiled from: TbsSdkJava */
public class y extends WebView {
    public a a;
    public FaceCommonCallBack b;
    WebSettings c;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(int i, int i2, int i3, int i4);
    }

    public y(Context context) {
        super(context);
        a();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.b != null) {
            this.b.callBack(new Object[0]);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void addJavascriptInterface(Object obj, String str) {
        try {
            l.a(new Exception("this is cc"), "1234567890000");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() {
        this.c = getSettings();
        this.c.setJavaScriptEnabled(true);
        this.c.setCacheMode(2);
        this.c.setBuiltInZoomControls(false);
        this.c.setGeolocationEnabled(true);
        this.c.setAllowFileAccess(true);
        this.c.setAppCacheEnabled(true);
        this.c.setDomStorageEnabled(true);
        this.c.setDatabaseEnabled(true);
        this.c.setAppCacheMaxSize(104857600);
        try {
            this.c.setRenderPriority(RenderPriority.HIGH);
        } catch (Throwable e) {
            p.a(e);
        }
        if (o.a.booleanValue() && VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.c.setSavePassword(false);
        this.c.setPluginState(PluginState.ON);
        if (VERSION.SDK_INT >= 21) {
            this.c.setMixedContentMode(0);
        }
        this.c.setSupportZoom(true);
        this.c.setLoadWithOverviewMode(true);
        requestFocusFromTouch();
        setScrollBarStyle(33554432);
        if (!o.i) {
            this.c.setUserAgentString(this.c.getUserAgentString() + ";" + "keplerm" + HttpUtils.EQUAL_SIGN + "keplerm");
        }
        a((WebView) this);
    }

    @TargetApi(11)
    public static void a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
                return;
            } catch (Throwable th) {
            }
        }
        try {
            Method method = webView.getClass().getMethod("removeJavascriptInterface", new Class[]{String.class});
            if (method != null) {
                method.invoke(webView, new Object[]{"searchBoxJavaBridge_"});
                method.invoke(webView, new Object[]{"accessibility"});
                method.invoke(webView, new Object[]{"accessibilityTraversal"});
            }
        } catch (Throwable th2) {
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.a != null) {
            this.a.a(i, i2, i3, i4);
        }
    }

    public void loadUrl(String str) {
        if (!aq.a(str)) {
            if (!str.startsWith("javascript:") || VERSION.SDK_INT < 19) {
                try {
                    super.loadUrl(str);
                    return;
                } catch (Throwable th) {
                    p.a(th, "webview  err");
                    l.a(th, "201711131623");
                    return;
                }
            }
            evaluateJavascript(str.replace("javascript:", ""), null);
        }
    }

    public void a(FaceCommonCallBack faceCommonCallBack) {
        this.b = faceCommonCallBack;
    }

    @SuppressLint({"JavascriptInterface"})
    public void a(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }
}
