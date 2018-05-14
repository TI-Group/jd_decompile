package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.sina.weibo.sdk.c.a;
import com.sina.weibo.sdk.d.j;

/* compiled from: TbsSdkJava */
class b extends k {
    private Activity b;
    private a c;
    private com.sina.weibo.sdk.a.b d;
    private boolean e = false;

    public b(Activity activity, a aVar) {
        this.b = activity;
        this.c = aVar;
        this.d = this.c.b();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.a != null) {
            this.a.a(webView, str, bitmap);
        }
        if (!str.startsWith(this.c.a().a()) || this.e) {
            super.onPageStarted(webView, str, bitmap);
            return;
        }
        this.e = true;
        a(str);
        webView.stopLoading();
        WeiboSdkBrowser.a(this.b, this.c.c(), null);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.a != null) {
            this.a.a(webView, str);
        }
        if (str.startsWith("sms:")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", str.replace("sms:", ""));
            intent.setType("vnd.android-dir/mms-sms");
            this.b.startActivity(intent);
            return true;
        } else if (!str.startsWith("sinaweibo://browser/close")) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            if (this.d != null) {
                this.d.a();
            }
            WeiboSdkBrowser.a(this.b, this.c.c(), null);
            return true;
        }
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

    private void a(String str) {
        Bundle a = j.a(str);
        String string = a.getString("error");
        String string2 = a.getString("error_code");
        String string3 = a.getString("error_description");
        if (string == null && string2 == null) {
            if (this.d != null) {
                this.d.a(a);
            }
        } else if (this.d != null) {
            this.d.a(new a(string2, string, string3));
        }
    }
}
