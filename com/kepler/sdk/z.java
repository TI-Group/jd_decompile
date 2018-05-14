package com.kepler.sdk;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jiguang.net.HttpUtils;
import java.io.FileInputStream;

/* compiled from: TbsSdkJava */
public class z extends WebViewClient {
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (o.a.booleanValue()) {
            sslErrorHandler.proceed();
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (VERSION.SDK_INT <= 21) {
            WebResourceResponse speedUp = speedUp(str, null);
            if (speedUp != null) {
                return speedUp;
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (!(webResourceRequest == null || webResourceRequest.getUrl() == null)) {
            WebResourceResponse speedUp = speedUp(webResourceRequest.getUrl().toString(), webResourceRequest);
            if (speedUp != null) {
                return speedUp;
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @TargetApi(11)
    private WebResourceResponse speedUp(String str, WebResourceRequest webResourceRequest) {
        if (aq.a(str)) {
            return null;
        }
        if (!o.c.booleanValue() && am.b) {
            String str2 = "";
            int indexOf = str.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR);
            if (indexOf == -1) {
                str2 = str;
            } else {
                str2 = str.substring(0, indexOf);
            }
            u a = x.a().a(str2);
            if (a != null) {
                if (o.h) {
                    p.b("suwg", "get static file" + a.b);
                }
                try {
                    if (a.f == null) {
                        indexOf = str.lastIndexOf(".");
                        if (indexOf > 0) {
                            a.f = str.substring(indexOf + 1);
                        }
                    }
                    return new WebResourceResponse(a.f, a.g, new FileInputStream(a.h));
                } catch (Throwable th) {
                    str2 = "can not  find html item" + a.b;
                    p.b("suwg", str2);
                    l.a(str2, "2017-10-18-2037");
                }
            } else if (str.contains("favicon")) {
                return new WebResourceResponse("", "", null);
            }
        }
        if (o.r) {
            r.a().a(str);
        }
        return null;
    }
}
