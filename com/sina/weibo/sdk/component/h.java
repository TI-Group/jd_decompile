package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.a.b;
import com.sina.weibo.sdk.d.j;

/* compiled from: TbsSdkJava */
class h extends k {
    private Activity b;
    private g c;
    private b d;

    public h(Activity activity, g gVar) {
        this.b = activity;
        this.c = gVar;
        this.d = gVar.c();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.a != null) {
            this.a.a(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.a != null) {
            this.a.a(webView, str);
        }
        if (!str.startsWith("sinaweibo://browser/close")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        Bundle b = j.b(str);
        if (!(b.isEmpty() || this.d == null)) {
            this.d.a(b);
        }
        CharSequence string = b.getString("code");
        String string2 = b.getString("msg");
        if (TextUtils.isEmpty(string)) {
            this.c.a(this.b);
        } else if ("0".equals(string)) {
            this.c.b(this.b);
        } else {
            this.c.a(this.b, string2);
        }
        WeiboSdkBrowser.a(this.b, this.c.h(), null);
        return true;
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.a != null) {
            this.a.b(webView, str);
        }
        super.onPageFinished(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.a != null) {
            this.a.a(webView, i, str, str2);
        }
        this.c.a(this.b, str);
        WeiboSdkBrowser.a(this.b, this.c.h(), null);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.a != null) {
            this.a.a(webView, sslErrorHandler, sslError);
        }
        sslErrorHandler.cancel();
        this.c.a(this.b, "ReceivedSslError");
        WeiboSdkBrowser.a(this.b, this.c.h(), null);
    }
}
