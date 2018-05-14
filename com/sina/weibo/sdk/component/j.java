package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.a.b;

/* compiled from: TbsSdkJava */
class j extends k {
    private Activity b;
    private f c;
    private b d = this.c.a();

    public j(Activity activity, f fVar) {
        this.b = activity;
        this.c = fVar;
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
        Bundle b = com.sina.weibo.sdk.d.j.b(str);
        if (!(b.isEmpty() || this.d == null)) {
            this.d.a(b);
        }
        WeiboSdkBrowser.a(this.b, this.c.b(), null);
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
        super.onReceivedError(webView, i, str, str2);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.a != null) {
            this.a.a(webView, sslErrorHandler, sslError);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }
}
