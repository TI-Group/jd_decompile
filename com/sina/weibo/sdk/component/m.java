package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.a.b;
import com.sina.weibo.sdk.component.l.a;
import com.sina.weibo.sdk.d.j;

/* compiled from: TbsSdkJava */
class m extends k {
    private Activity b;
    private l c;
    private b d;
    private a e;

    public m(Activity activity, l lVar) {
        this.b = activity;
        this.c = lVar;
        this.e = lVar.c();
        this.d = lVar.a();
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
        boolean startsWith = str.startsWith("sinaweibo://browser/close");
        if (!str.startsWith("sinaweibo://browser/close") && !str.startsWith("sinaweibo://browser/datatransfer")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        Bundle b = j.b(str);
        if (!(b.isEmpty() || this.d == null)) {
            this.d.a(b);
        }
        if (this.e != null) {
            this.e.a(str);
        }
        if (startsWith) {
            WeiboSdkBrowser.a(this.b, this.c.b(), this.c.h());
        }
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
