package com.jd.fridge.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import cn.jiguang.net.HttpUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.k;
import com.jd.fridge.util.r;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebSettings.PluginState;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLEncoder;

/* compiled from: TbsSdkJava */
public class X5WebView extends WebView {
    @SuppressLint({"SetJavaScriptEnabled"})
    public X5WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
        getView().setClickable(true);
    }

    private void h() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(false);
        settings.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setPluginState(PluginState.ON_DEMAND);
        settings.setCacheMode(2);
        settings.setMixedContentMode(0);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccessFromFileURLs(false);
    }

    public X5WebView(Context context) {
        super(context);
        setBackgroundColor(85621);
    }

    public void a(Context context, String str) {
        h();
        getView().setClickable(true);
        b(context, str);
    }

    private void b(Context context, String str) {
        k.a("cookies.url===" + str + "==fid==" + GlobalVariable.C() + "==wskey==" + a.b().getA2() + "===pin==" + a.b().getPin());
        r.b("infos", "cookies==" + str + "==fid==" + GlobalVariable.C() + "==wskey==" + a.b().getA2() + "===pin==" + a.b().getPin());
        if (VERSION.SDK_INT >= 21) {
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptThirdPartyCookies(this, true);
            a(instance, str);
            instance.flush();
            return;
        }
        CookieSyncManager.createInstance(context);
        instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        a(instance, str);
        CookieSyncManager.getInstance().sync();
    }

    private void a(CookieManager cookieManager, String str) {
        HttpCookie httpCookie = new HttpCookie("fid", GlobalVariable.C());
        httpCookie.setDomain(GlobalVariable.B().g());
        httpCookie.setPath(HttpUtils.PATHS_SEPARATOR);
        httpCookie.setMaxAge(2147483647L);
        cookieManager.setCookie(str, httpCookie.toString());
        httpCookie = new HttpCookie("wskey", a.b().getA2());
        httpCookie.setDomain(GlobalVariable.B().g());
        httpCookie.setPath(HttpUtils.PATHS_SEPARATOR);
        httpCookie.setMaxAge(2147483647L);
        cookieManager.setCookie(str, httpCookie.toString());
        try {
            httpCookie = new HttpCookie("pin", URLEncoder.encode(a.b().getPin(), CommonUtil.UTF8));
            httpCookie.setDomain(GlobalVariable.B().g());
            httpCookie.setPath(HttpUtils.PATHS_SEPARATOR);
            httpCookie.setMaxAge(2147483647L);
            cookieManager.setCookie(str, httpCookie.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
