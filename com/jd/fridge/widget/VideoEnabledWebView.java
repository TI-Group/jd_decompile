package com.jd.fridge.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.Map;

/* compiled from: TbsSdkJava */
public class VideoEnabledWebView extends WebView {
    private c a;
    private boolean b = false;

    /* compiled from: TbsSdkJava */
    public class a {
        final /* synthetic */ VideoEnabledWebView a;

        public a(VideoEnabledWebView videoEnabledWebView) {
            this.a = videoEnabledWebView;
        }

        @JavascriptInterface
        public void notifyVideoEnd() {
            Log.d("___", "GOT IT");
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public void run() {
                    if (this.a.a.a != null) {
                        this.a.a.a.onHideCustomView();
                    }
                }
            });
        }
    }

    public VideoEnabledWebView(Context context) {
        super(context);
    }

    public VideoEnabledWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoEnabledWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        getSettings().setJavaScriptEnabled(true);
        if (webChromeClient instanceof c) {
            this.a = (c) webChromeClient;
        }
        super.setWebChromeClient(webChromeClient);
    }

    public void loadData(String str, String str2, String str3) {
        a();
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        a();
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        a();
        super.loadUrl(str);
    }

    public void loadUrl(String str, Map<String, String> map) {
        a();
        super.loadUrl(str, map);
    }

    private void a() {
        if (!this.b) {
            addJavascriptInterface(new a(this), "_VideoEnabledWebView");
            this.b = true;
        }
    }
}
