package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.e;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.v;
import com.tencent.smtt.utils.y;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.cookie.ClientCookie;

public class WebView extends FrameLayout implements OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    private static final Lock c = new ReentrantLock();
    private static OutputStream d = null;
    private static Context j = null;
    public static boolean mSysWebviewCreated = false;
    private static BroadcastReceiver n = null;
    private static y o = null;
    private static Method p = null;
    private static String q = null;
    private static Paint w = null;
    private static boolean x = true;
    int a;
    private final String b;
    private boolean e;
    private IX5WebViewBase f;
    private b g;
    private WebSettings h;
    private Context i;
    private boolean k;
    private an l;
    private boolean m;
    public WebViewCallbackClient mWebViewCallbackClient;
    private final int r;
    private final int s;
    private final int t;
    private final String u;
    private final String v;
    private Object y;
    private OnLongClickListener z;

    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult a;
        private android.webkit.WebView.HitTestResult b;

        public HitTestResult() {
            this.b = null;
            this.a = null;
            this.b = null;
        }

        public HitTestResult(android.webkit.WebView.HitTestResult hitTestResult) {
            this.b = null;
            this.a = null;
            this.b = hitTestResult;
        }

        public HitTestResult(com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult hitTestResult) {
            this.b = null;
            this.a = hitTestResult;
            this.b = null;
        }

        public String getExtra() {
            return this.a != null ? this.a.getExtra() : this.b != null ? this.b.getExtra() : "";
        }

        public int getType() {
            return this.a != null ? this.a.getType() : this.b != null ? this.b.getType() : 0;
        }
    }

    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    public class WebViewTransport {
        final /* synthetic */ WebView a;
        private WebView b;

        public WebViewTransport(WebView webView) {
            this.a = webView;
        }

        public synchronized WebView getWebView() {
            return this.b;
        }

        public synchronized void setWebView(WebView webView) {
            this.b = webView;
        }
    }

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        int apnType = Apn.getApnType(context);
                        long currentTimeMillis = System.currentTimeMillis();
                        synchronized (QbSdk.h) {
                            if (QbSdk.e) {
                                QbSdk.g += currentTimeMillis - QbSdk.f;
                            }
                            QbSdk.f = currentTimeMillis;
                        }
                        TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.g + " apnType=" + apnType);
                        QbSdk.e = apnType == 3;
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    private class b extends android.webkit.WebView {
        final /* synthetic */ WebView a;

        public b(WebView webView, Context context) {
            this(webView, context, null);
        }

        public b(WebView webView, Context context, AttributeSet attributeSet) {
            this.a = webView;
            super(context, attributeSet);
            if (!QbSdk.getIsSysWebViewForcedByOuter() || !TbsShareManager.isThirdPartyApp(context)) {
                CookieSyncManager.createInstance(webView.i).startSync();
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                    declaredMethod.setAccessible(true);
                    ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new r());
                    WebView.mSysWebviewCreated = true;
                } catch (Exception e) {
                }
            }
        }

        public void a() {
            super.computeScroll();
        }

        public void a(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        @TargetApi(9)
        public void a(int i, int i2, boolean z, boolean z2) {
            if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @TargetApi(9)
        public boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }

        public boolean a(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public boolean b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void computeScroll() {
            if (this.a.mWebViewCallbackClient != null) {
                this.a.mWebViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (!WebView.x && WebView.w != null) {
                    canvas.save();
                    canvas.drawPaint(WebView.w);
                    canvas.restore();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return this.a.mWebViewCallbackClient != null ? this.a.mWebViewCallbackClient.dispatchTouchEvent(motionEvent, this) : super.dispatchTouchEvent(motionEvent);
        }

        public WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public void invalidate() {
            super.invalidate();
            if (this.a.mWebViewCallbackClient != null) {
                this.a.mWebViewCallbackClient.invalidate();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return this.a.mWebViewCallbackClient != null ? this.a.mWebViewCallbackClient.onInterceptTouchEvent(motionEvent, this) : super.onInterceptTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            if (this.a.mWebViewCallbackClient != null) {
                this.a.mWebViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
            } else if (VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            if (this.a.mWebViewCallbackClient != null) {
                this.a.mWebViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
                return;
            }
            super.onScrollChanged(i, i2, i3, i4);
            this.a.onScrollChanged(i, i2, i3, i4);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            if (this.a.mWebViewCallbackClient != null) {
                return this.a.mWebViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            return this.a.mWebViewCallbackClient != null ? this.a.mWebViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this) : VERSION.SDK_INT >= 9 ? super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z) : false;
        }
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.a = 0;
        this.k = false;
        this.l = null;
        this.m = false;
        this.r = 1;
        this.s = 2;
        this.t = 3;
        this.u = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.v = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.y = null;
        this.z = null;
        if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
            this.i = context;
            this.f = null;
            this.e = false;
            QbSdk.a(context, "failed to createTBSWebview!");
            this.g = new b(this, context, attributeSet);
            CookieSyncManager.createInstance(this.i).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new r());
                mSysWebviewCreated = true;
            } catch (Exception e) {
            }
            CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new LayoutParams(-1, -1));
            TbsLog.i("WebView", "SystemWebView Created Success! #3");
            TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable());
            return;
        }
        this.l = new an();
        this.l.a("free_ram_begin", a.a(context));
        this.l.a("init_all", (byte) 1);
        this.l.a("tbslog_init", (byte) 1);
        TbsLog.initIfNeed(context);
        this.l.a("tbslog_init", (byte) 2);
        if (context == null) {
            throw new IllegalArgumentException("Invalid context argument");
        }
        if (o == null) {
            o = y.a(context);
        }
        if (o.a) {
            TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
            QbSdk.a(context, "debug.conf force syswebview!");
        }
        a(context, this.l);
        this.i = context;
        if (context != null) {
            j = context.getApplicationContext();
        }
        if (!this.e || QbSdk.a) {
            this.f = null;
            if (TbsShareManager.isThirdPartyApp(this.i)) {
                this.g = new b(this, context, attributeSet);
            } else {
                this.g = new b(this, context);
            }
            TbsLog.i("WebView", "SystemWebView Created Success! #2");
            CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new LayoutParams(-1, -1));
            setDownloadListener(null);
            b(context);
            TbsLog.writeLogToDisk();
            ao.a(context);
        } else {
            this.l.a("init_x5_webview", (byte) 1);
            this.f = bo.b().a(true).a(context);
            this.l.a("init_x5_webview", (byte) 2);
            if (this.f == null || this.f.getView() == null) {
                TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                this.f = null;
                this.e = false;
                QbSdk.a(context, "failed to createTBSWebview!");
                a(context, this.l);
                if (TbsShareManager.isThirdPartyApp(this.i)) {
                    this.g = new b(this, context, attributeSet);
                } else {
                    this.g = new b(this, context);
                }
                TbsLog.i("WebView", "SystemWebView Created Success! #1");
                CookieManager.getInstance().a();
                this.g.setFocusableInTouchMode(true);
                addView(this.g, new LayoutParams(-1, -1));
                try {
                    if (VERSION.SDK_INT >= 11) {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                b(context);
                TbsLog.writeLogToDisk();
                ao.a(context);
                return;
            }
            TbsLog.i("WebView", "X5 WebView Created Success!!");
            this.f.getView().setFocusableInTouchMode(true);
            a(attributeSet);
            addView(this.f.getView(), new LayoutParams(-1, -1));
            this.f.setDownloadListener(new b(this, null, this.e));
            this.f.getX5WebViewExtension().setWebViewClientExtension(new bh(this, bo.b().a(true).k()));
        }
        try {
            if (VERSION.SDK_INT >= 11) {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (("com.tencent.mobileqq".equals(this.i.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.i.getApplicationInfo().packageName)) && q.a(true).h() && VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        if (this.l != null) {
            this.l.a("load_url_gap", (byte) 1);
        }
        if (this.f != null) {
            TbsLog.writeLogToDisk();
        }
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    private void a(Context context, an anVar) {
        if (anVar != null) {
            anVar.a("x5_core_engine_init_sync", (byte) 1);
        }
        bo b = bo.b();
        b.a(context, anVar);
        this.e = b.c();
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                            this.f.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.f.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean a(View view) {
        if (this.i != null && getTbsCoreVersion(this.i) > 36200) {
            return false;
        }
        Object a = v.a(this.y, "onLongClick", new Class[]{View.class}, view);
        return a != null ? ((Boolean) a).booleanValue() : false;
    }

    private void b(Context context) {
        if (n == null) {
            n = new a();
            new bi(this, context).start();
        }
    }

    static void c() {
        new bn().start();
    }

    private boolean c(Context context) {
        try {
            if (context.getPackageName().indexOf("com.tencent.mobileqq") >= 0) {
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private int d(Context context) {
        Exception e;
        Throwable th;
        int i = -1;
        FileOutputStream b = k.b(context, true, "tbslock.txt");
        if (b != null) {
            FileLock a = k.a(context, b);
            if (a != null) {
                if (c.tryLock()) {
                    FileInputStream fileInputStream = null;
                    FileInputStream fileInputStream2;
                    try {
                        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
                        if (file == null || !file.exists()) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2.toString());
                                }
                            }
                            c.unlock();
                            k.a(a, b);
                        } else {
                            Properties properties = new Properties();
                            fileInputStream2 = new FileInputStream(file);
                            try {
                                properties.load(fileInputStream2);
                                fileInputStream2.close();
                                String property = properties.getProperty("PV");
                                if (property == null) {
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e22) {
                                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e22.toString());
                                        }
                                    }
                                    c.unlock();
                                    k.a(a, b);
                                } else {
                                    i = Integer.parseInt(property);
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e222) {
                                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e222.toString());
                                        }
                                    }
                                    c.unlock();
                                    k.a(a, b);
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e2222) {
                                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e2222.toString());
                                        }
                                    }
                                    c.unlock();
                                    k.a(a, b);
                                    return i;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e22222) {
                                            TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e22222.toString());
                                        }
                                    }
                                    c.unlock();
                                    k.a(a, b);
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream2 = fileInputStream;
                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        c.unlock();
                        k.a(a, b);
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        c.unlock();
                        k.a(a, b);
                        throw th;
                    }
                }
                k.a(a, b);
            }
        }
        return i;
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (!bo.b().c()) {
            v.a("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    private void e(Context context) {
        try {
            File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
            if (file != null && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (!bo.b().c()) {
            v.a("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    public static String findAddress(String str) {
        return !bo.b().c() ? android.webkit.WebView.findAddress(str) : null;
    }

    public static String getCrashExtraMessage(Context context) {
        String str = "tbs_core_version:" + QbSdk.getTbsVersion(context) + ";" + "tbs_sdk_version:" + 43200 + ";";
        if (TbsShareManager.isThirdPartyApp(context)) {
            return "nothing return ^-^." + str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(q.a(true).e());
        stringBuilder.append("\n");
        stringBuilder.append(str);
        if (QbSdk.k != null && QbSdk.k.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.k.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            str = "weapp_id:" + QbSdk.k.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + QbSdk.k.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            stringBuilder.append("\n");
            stringBuilder.append(str);
        }
        return stringBuilder.length() > 8192 ? stringBuilder.substring(stringBuilder.length() - 8192) : stringBuilder.toString();
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        Object a;
        synchronized (WebView.class) {
            a = !bo.b().c() ? v.a("android.webkit.WebView", "getPluginList") : null;
        }
        return a;
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        c();
        return q.a(true).f();
    }

    public static int getTbsSDKVersion(Context context) {
        return 43200;
    }

    private long h() {
        long j;
        synchronized (QbSdk.h) {
            if (QbSdk.e) {
                QbSdk.g += System.currentTimeMillis() - QbSdk.f;
                TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.g);
            }
            j = QbSdk.g / 1000;
            QbSdk.g = 0;
            QbSdk.f = System.currentTimeMillis();
        }
        return j;
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        synchronized (WebView.class) {
            if (z != x) {
                x = z;
                if (w == null) {
                    w = new Paint();
                    w.setColor(-16777216);
                }
                if (z) {
                    if (w.getAlpha() != 255) {
                        w.setAlpha(255);
                    }
                } else if (w.getAlpha() != NIGHT_MODE_ALPHA) {
                    w.setAlpha(NIGHT_MODE_ALPHA);
                }
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            try {
                p = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE});
                if (p != null) {
                    p.setAccessible(true);
                    p.invoke(null, new Object[]{Boolean.valueOf(z)});
                }
            } catch (Exception e) {
                TbsLog.e("QbSdk", "Exception:" + e.getStackTrace());
                e.printStackTrace();
            }
        }
    }

    android.webkit.WebView a() {
        return !this.e ? this.g : null;
    }

    void a(Context context) {
        String str;
        int d = d(context);
        if (d != -1) {
            str = "PV=" + String.valueOf(d + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
        if (file != null) {
            try {
                file.getParentFile().mkdirs();
                if (!(file.isFile() && file.exists())) {
                    file.createNewFile();
                }
                d = new FileOutputStream(file, false);
                d.write(str.getBytes());
                if (d != null) {
                    d.flush();
                }
            } catch (Throwable th) {
            }
        }
    }

    void a(android.webkit.WebView webView) {
        if (!this.e) {
        }
    }

    void a(IX5WebViewBase iX5WebViewBase) {
        this.f = iX5WebViewBase;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.e) {
            this.f.addJavascriptInterface(obj, str);
        } else {
            this.g.addJavascriptInterface(obj, str);
        }
    }

    public void addView(View view) {
        if (this.e) {
            View view2 = this.f.getView();
            try {
                Method a = v.a(view2, "addView", View.class);
                a.setAccessible(true);
                a.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.g.addView(view);
    }

    IX5WebViewBase b() {
        return this.f;
    }

    public boolean canGoBack() {
        return !this.e ? this.g.canGoBack() : this.f.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        return !this.e ? this.g.canGoBackOrForward(i) : this.f.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        return !this.e ? this.g.canGoForward() : this.f.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        if (this.e) {
            return this.f.canZoomIn();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = v.a(this.g, "canZoomIn");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @Deprecated
    public boolean canZoomOut() {
        if (this.e) {
            return this.f.canZoomOut();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = v.a(this.g, "canZoomOut");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    @Deprecated
    public Picture capturePicture() {
        if (this.e) {
            return this.f.capturePicture();
        }
        Object a = v.a(this.g, "capturePicture");
        return a == null ? null : (Picture) a;
    }

    public void clearCache(boolean z) {
        if (this.e) {
            this.f.clearCache(z);
        } else {
            this.g.clearCache(z);
        }
    }

    public void clearFormData() {
        if (this.e) {
            this.f.clearFormData();
        } else {
            this.g.clearFormData();
        }
    }

    public void clearHistory() {
        if (this.e) {
            this.f.clearHistory();
        } else {
            this.g.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (this.e) {
            this.f.clearMatches();
        } else {
            this.g.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (this.e) {
            this.f.clearSslPreferences();
        } else {
            this.g.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (this.e) {
            this.f.clearView();
        } else {
            v.a(this.g, "clearView");
        }
    }

    public int computeHorizontalScrollExtent() {
        try {
            Method a;
            if (this.e) {
                a = v.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                a.setAccessible(true);
                return ((Integer) a.invoke(this.f.getView(), null)).intValue();
            }
            a = v.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
            a.setAccessible(true);
            return ((Integer) a.invoke(this.g, null)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int computeHorizontalScrollOffset() {
        try {
            Method a;
            if (this.e) {
                a = v.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                a.setAccessible(true);
                return ((Integer) a.invoke(this.f.getView(), null)).intValue();
            }
            a = v.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
            a.setAccessible(true);
            return ((Integer) a.invoke(this.g, null)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int computeHorizontalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) v.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method a = v.a(this.g, "computeHorizontalScrollRange", new Class[0]);
            a.setAccessible(true);
            return ((Integer) a.invoke(this.g, null)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void computeScroll() {
        if (this.e) {
            this.f.computeScroll();
        } else {
            this.g.computeScroll();
        }
    }

    public int computeVerticalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) v.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
            }
            Method a = v.a(this.g, "computeVerticalScrollRange", new Class[0]);
            a.setAccessible(true);
            return ((Integer) a.invoke(this.g, null)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return this.e ? WebBackForwardList.a(this.f.copyBackForwardList()) : WebBackForwardList.a(this.g.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        Object obj = null;
        if (this.e) {
            try {
                return this.f.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return obj;
            }
        } else if (VERSION.SDK_INT < 21) {
            return obj;
        } else {
            return v.a(this.g, "createPrintDocumentAdapter", new Class[]{String.class}, str);
        }
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        if (this.e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", z);
            bundle.putString(ClientCookie.PATH_ATTR, str);
            getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
        }
    }

    public void destroy() {
        if (!(this.k || this.a == 0)) {
            this.k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.e) {
                Bundle sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if ("com.qzone".equals(this.i.getApplicationInfo().packageName)) {
                int d = d(this.i);
                if (d == -1) {
                    d = this.a;
                }
                this.a = d;
                e(this.i);
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.a, this.e, h());
            this.a = 0;
            this.k = false;
        }
        if (this.e) {
            this.f.destroy();
        } else {
            Object invoke;
            Field declaredField;
            try {
                Class cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", new Class[]{android.webkit.WebView.class});
                method.setAccessible(true);
                invoke = method.invoke(null, new Object[]{this.g});
                if (invoke != null) {
                    Field declaredField2 = cls.getDeclaredField("mListBoxDialog");
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(invoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class cls2 = Class.forName("android.app.Dialog");
                        declaredField = cls2.getDeclaredField("CANCEL");
                        declaredField.setAccessible(true);
                        int intValue = ((Integer) declaredField.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception e) {
            }
            this.g.destroy();
            try {
                declaredField = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField.get(null);
                if (componentCallbacks != null) {
                    declaredField.set(null, null);
                    declaredField = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField.setAccessible(true);
                    invoke = declaredField.get(null);
                    if (invoke != null) {
                        List list = (List) invoke;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (Exception e2) {
            }
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.b());
    }

    public void documentHasImages(Message message) {
        if (this.e) {
            this.f.documentHasImages(message);
        } else {
            this.g.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (this.e) {
            this.f.dumpViewHierarchyWithProperties(bufferedWriter, i);
            return;
        }
        v.a(this.g, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Method a;
        if (this.e) {
            try {
                a = v.a(this.f.getView(), "evaluateJavascript", String.class, ValueCallback.class);
                a.setAccessible(true);
                a.invoke(this.f.getView(), new Object[]{str, valueCallback});
            } catch (Exception e) {
                e.printStackTrace();
                loadUrl(str);
            }
        } else if (VERSION.SDK_INT >= 19) {
            try {
                a = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[]{String.class, ValueCallback.class});
                a.setAccessible(true);
                a.invoke(this.g, new Object[]{str, valueCallback});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (this.e) {
            return this.f.findAll(str);
        }
        Object a = v.a(this.g, "findAll", new Class[]{String.class}, str);
        return a == null ? 0 : ((Integer) a).intValue();
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (this.e) {
            this.f.findAllAsync(str);
        } else if (VERSION.SDK_INT >= 16) {
            v.a(this.g, "findAllAsync", new Class[]{String.class}, str);
        }
    }

    public View findHierarchyView(String str, int i) {
        if (this.e) {
            return this.f.findHierarchyView(str, i);
        }
        return (View) v.a(this.g, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        if (this.e) {
            this.f.findNext(z);
        } else {
            this.g.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (this.e) {
            this.f.flingScroll(i, i2);
        } else {
            this.g.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (this.e) {
            this.f.freeMemory();
        } else {
            v.a(this.g, "freeMemory");
        }
    }

    public SslCertificate getCertificate() {
        return !this.e ? this.g.getCertificate() : this.f.getCertificate();
    }

    public int getContentHeight() {
        return !this.e ? this.g.getContentHeight() : this.f.getContentHeight();
    }

    public int getContentWidth() {
        if (this.e) {
            return this.f.getContentWidth();
        }
        Object a = v.a(this.g, "getContentWidth");
        return a == null ? 0 : ((Integer) a).intValue();
    }

    public Bitmap getFavicon() {
        return !this.e ? this.g.getFavicon() : this.f.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        return !this.e ? new HitTestResult(this.g.getHitTestResult()) : new HitTestResult(this.f.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return !this.e ? this.g.getHttpAuthUsernamePassword(str, str2) : this.f.getHttpAuthUsernamePassword(str, str2);
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        return !this.e ? this.g.getOriginalUrl() : this.f.getOriginalUrl();
    }

    public int getProgress() {
        return !this.e ? this.g.getProgress() : this.f.getProgress();
    }

    @Deprecated
    public float getScale() {
        if (this.e) {
            return this.f.getScale();
        }
        Object a = v.a(this.g, "getScale");
        return a == null ? 0.0f : ((Float) a).floatValue();
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        return getView() == null ? 0 : getView().getScrollBarDefaultDelayBeforeFade();
    }

    public int getScrollBarFadeDuration() {
        return getView() == null ? 0 : getView().getScrollBarFadeDuration();
    }

    public int getScrollBarSize() {
        return getView() == null ? 0 : getView().getScrollBarSize();
    }

    public int getScrollBarStyle() {
        return getView() == null ? 0 : getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        if (this.h != null) {
            return this.h;
        }
        if (this.e) {
            WebSettings webSettings = new WebSettings(this.f.getSettings());
            this.h = webSettings;
            return webSettings;
        }
        webSettings = new WebSettings(this.g.getSettings());
        this.h = webSettings;
        return webSettings;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        return !this.e ? null : this.f.getX5WebViewExtension().getSettingsExtension();
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        return !this.e ? this.g.getTitle() : this.f.getTitle();
    }

    public String getUrl() {
        return !this.e ? this.g.getUrl() : this.f.getUrl();
    }

    public View getView() {
        return !this.e ? this.g : this.f.getView();
    }

    public int getVisibleTitleHeight() {
        if (this.e) {
            return this.f.getVisibleTitleHeight();
        }
        Object a = v.a(this.g, "getVisibleTitleHeight");
        return a == null ? 0 : ((Integer) a).intValue();
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        return !this.e ? null : this.f.getX5WebViewExtension().getWebChromeClientExtension();
    }

    public int getWebScrollX() {
        return this.e ? this.f.getView().getScrollX() : this.g.getScrollX();
    }

    public int getWebScrollY() {
        return this.e ? this.f.getView().getScrollY() : this.g.getScrollY();
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        return !this.e ? null : this.f.getX5WebViewExtension().getWebViewClientExtension();
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        return !this.e ? null : this.f.getX5WebViewExtension();
    }

    @Deprecated
    public View getZoomControls() {
        return !this.e ? (View) v.a(this.g, "getZoomControls") : this.f.getZoomControls();
    }

    public void goBack() {
        if (this.e) {
            this.f.goBack();
        } else {
            this.g.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (this.e) {
            this.f.goBackOrForward(i);
        } else {
            this.g.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (this.e) {
            this.f.goForward();
        } else {
            this.g.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (this.e) {
            this.f.invokeZoomPicker();
        } else {
            this.g.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return x;
    }

    public boolean isPrivateBrowsingEnabled() {
        if (this.e) {
            return this.f.isPrivateBrowsingEnable();
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object a = v.a(this.g, "isPrivateBrowsingEnabled");
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public void loadData(String str, String str2, String str3) {
        if (this.e) {
            this.f.loadData(str, str2, str3);
        } else {
            this.g.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.e) {
            this.f.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (!(!this.e || this.l == null || this.m)) {
            this.l.a("load_url_gap", (byte) 2);
            this.l.a("init_all", (byte) 2);
            this.l.a("free_ram_end", a.a(this.i));
            if (this.l.a(this.f.hashCode(), str)) {
                this.m = true;
            }
        }
        if (str != null && !showDebugView(str)) {
            if (this.e) {
                this.f.loadUrl(str);
            } else {
                this.g.loadUrl(str);
            }
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (!(!this.e || this.l == null || this.m)) {
            this.l.a("load_url_gap", (byte) 2);
            this.l.a("init_all", (byte) 2);
            this.l.a("free_ram_end", a.a(this.i));
            if (this.l.a(this.f.hashCode(), str)) {
                this.m = true;
            }
        }
        if (str != null && !showDebugView(str)) {
            if (this.e) {
                this.f.loadUrl(str, map);
            } else if (VERSION.SDK_INT >= 8) {
                this.g.loadUrl(str, map);
            }
        }
    }

    protected void onDetachedFromWindow() {
        if (!(this.k || this.a == 0)) {
            this.k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.e) {
                Bundle sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                if (sdkQBStatisticsInfo != null) {
                    str = sdkQBStatisticsInfo.getString("guid");
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
            }
            if ("com.qzone".equals(this.i.getApplicationInfo().packageName)) {
                int d = d(this.i);
                if (d == -1) {
                    d = this.a;
                }
                this.a = d;
                e(this.i);
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.a, this.e, h());
            this.a = 0;
            this.k = false;
        }
        super.onDetachedFromWindow();
    }

    public boolean onLongClick(View view) {
        return this.z != null ? !this.z.onLongClick(view) ? a(view) : true : a(view);
    }

    public void onPause() {
        if (this.e) {
            this.f.onPause();
        } else {
            v.a(this.g, "onPause");
        }
    }

    public void onResume() {
        if (this.e) {
            this.f.onResume();
        } else {
            v.a(this.g, "onResume");
        }
    }

    @TargetApi(11)
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (VERSION.SDK_INT >= 21 && c(this.i) && isHardwareAccelerated() && i > 0 && i2 > 0 && getLayerType() != 0 && this.f != null && this.f.getView() != null) {
            this.f.getView().setLayerType(0, null);
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        if (this.i == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (q == null) {
            q = this.i.getApplicationInfo().packageName;
        }
        if (q == null || !(q.equals("com.tencent.mm") || q.equals("com.tencent.mobileqq"))) {
            if (!(i == 0 || this.k || this.a == 0)) {
                this.k = true;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (this.e) {
                    Bundle sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
                    if (sdkQBStatisticsInfo != null) {
                        str = sdkQBStatisticsInfo.getString("guid");
                        str2 = sdkQBStatisticsInfo.getString("qua2");
                        str3 = sdkQBStatisticsInfo.getString("lc");
                    }
                }
                if ("com.qzone".equals(this.i.getApplicationInfo().packageName)) {
                    int d = d(this.i);
                    if (d == -1) {
                        d = this.a;
                    }
                    this.a = d;
                    e(this.i);
                }
                com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.a, this.e, h());
                this.a = 0;
                this.k = false;
            }
            super.onVisibilityChanged(view, i);
            return;
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        return !this.e ? this.g.overlayHorizontalScrollbar() : this.f.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        return this.e ? this.f.overlayVerticalScrollbar() : this.g.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        return !this.e ? this.g.pageDown(z) : this.f.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        return !this.e ? this.g.pageUp(z) : this.f.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (this.e) {
            this.f.pauseTimers();
        } else {
            this.g.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (this.e) {
            this.f.postUrl(str, bArr);
        } else {
            this.g.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (this.e) {
            this.f.refreshPlugins(z);
            return;
        }
        v.a(this.g, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void reload() {
        if (this.e) {
            this.f.reload();
        } else {
            this.g.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (!this.e) {
            if (VERSION.SDK_INT >= 11) {
                v.a(this.g, "removeJavascriptInterface", new Class[]{String.class}, str);
                return;
            }
            this.f.removeJavascriptInterface(str);
        }
    }

    public void removeView(View view) {
        if (this.e) {
            View view2 = this.f.getView();
            try {
                Method a = v.a(view2, "removeView", View.class);
                a.setAccessible(true);
                a.invoke(view2, new Object[]{view});
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.g.removeView(view);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.e) {
            View view2 = this.f.getView();
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (view != this) {
                view2 = view;
            }
            return viewGroup.requestChildRectangleOnScreen(view2, rect, z);
        }
        android.webkit.WebView webView = this.g;
        if (view == this) {
            view = this.g;
        }
        return webView.requestChildRectangleOnScreen(view, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (this.e) {
            this.f.requestFocusNodeHref(message);
        } else {
            this.g.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (this.e) {
            this.f.requestImageRef(message);
        } else {
            this.g.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (this.e) {
            return this.f.restorePicture(bundle, file);
        }
        Object a = v.a(this.g, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        return !this.e ? WebBackForwardList.a(this.g.restoreState(bundle)) : WebBackForwardList.a(this.f.restoreState(bundle));
    }

    public void resumeTimers() {
        if (this.e) {
            this.f.resumeTimers();
        } else {
            this.g.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (this.e) {
            this.f.savePassword(str, str2, str3);
            return;
        }
        v.a(this.g, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (this.e) {
            return this.f.savePicture(bundle, file);
        }
        Object a = v.a(this.g, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public WebBackForwardList saveState(Bundle bundle) {
        return !this.e ? WebBackForwardList.a(this.g.saveState(bundle)) : WebBackForwardList.a(this.f.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (this.e) {
            this.f.saveWebArchive(str);
        } else if (VERSION.SDK_INT >= 11) {
            v.a(this.g, "saveWebArchive", new Class[]{String.class}, str);
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        if (this.e) {
            this.f.saveWebArchive(str, z, valueCallback);
        } else if (VERSION.SDK_INT >= 11) {
            v.a(this.g, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, str, Boolean.valueOf(z), valueCallback);
        }
    }

    public void setARModeEnable(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setARModeEnable(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setBackgroundColor(int i) {
        if (this.e) {
            this.f.setBackgroundColor(i);
        } else {
            this.g.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (this.e) {
            this.f.setCertificate(sslCertificate);
        } else {
            this.g.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        if (this.e) {
            this.f.setDownloadListener(new b(this, downloadListener, this.e));
        } else {
            this.g.setDownloadListener(new bk(this, downloadListener));
        }
    }

    @TargetApi(16)
    public void setFindListener(FindListener findListener) {
        if (this.e) {
            this.f.setFindListener(findListener);
        } else if (VERSION.SDK_INT >= 16) {
            this.g.setFindListener(new bj(this, findListener));
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (this.e) {
            this.f.setHorizontalScrollbarOverlay(z);
        } else {
            this.g.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (this.e) {
            this.f.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (this.e) {
            this.f.setInitialScale(i);
        } else {
            this.g.setInitialScale(i);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (this.e) {
            this.f.setMapTrackballToArrowKeys(z);
            return;
        }
        v.a(this.g, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public void setNetworkAvailable(boolean z) {
        if (this.e) {
            this.f.setNetworkAvailable(z);
        } else if (VERSION.SDK_INT >= 3) {
            this.g.setNetworkAvailable(z);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.e) {
            View view = this.f.getView();
            try {
                if (this.y == null) {
                    Method a = v.a(view, "getListenerInfo", new Class[0]);
                    a.setAccessible(true);
                    Object invoke = a.invoke(view, (Object[]) null);
                    Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                    declaredField.setAccessible(true);
                    this.y = declaredField.get(invoke);
                }
                this.z = onLongClickListener;
                getView().setOnLongClickListener(this);
                return;
            } catch (Throwable th) {
                return;
            }
        }
        this.g.setOnLongClickListener(onLongClickListener);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    public void setPictureListener(PictureListener pictureListener) {
        if (this.e) {
            if (pictureListener == null) {
                this.f.setPictureListener(null);
            } else {
                this.f.setPictureListener(new bm(this, pictureListener));
            }
        } else if (pictureListener == null) {
            this.g.setPictureListener(null);
        } else {
            this.g.setPictureListener(new bl(this, pictureListener));
        }
    }

    public void setScrollBarStyle(int i) {
        if (this.e) {
            this.f.getView().setScrollBarStyle(i);
        } else {
            this.g.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (this.e) {
            this.f.setVerticalScrollbarOverlay(z);
        } else {
            this.g.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getView() != null) {
            getView().setVisibility(i);
        }
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebChromeClient webChromeClient2 = null;
        if (this.e) {
            IX5WebChromeClient sVar;
            IX5WebViewBase iX5WebViewBase = this.f;
            if (webChromeClient != null) {
                sVar = new s(bo.b().a(true).i(), this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(sVar);
            return;
        }
        android.webkit.WebView webView = this.g;
        if (webChromeClient != null) {
            webChromeClient2 = new SystemWebChromeClient(this, webChromeClient);
        }
        webView.setWebChromeClient(webChromeClient2);
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (this.e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        WebViewClient webViewClient2 = null;
        if (this.e) {
            IX5WebViewClient xVar;
            IX5WebViewBase iX5WebViewBase = this.f;
            if (webViewClient != null) {
                xVar = new x(bo.b().a(true).j(), this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(xVar);
            return;
        }
        android.webkit.WebView webView = this.g;
        if (webViewClient != null) {
            webViewClient2 = new ae(this, webViewClient);
        }
        webView.setWebViewClient(webViewClient2);
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            e.a(this.i).a(toLowerCase, this, this.i, am.a().getLooper());
            return true;
        } else if (!toLowerCase.startsWith("http://debugx5.qq.com") || this.e) {
            return false;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!DOCTYPE html><html><body>");
            stringBuilder.append("<head>");
            stringBuilder.append("<title>无法打开debugx5</title>");
            stringBuilder.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
            stringBuilder.append("</head>");
            stringBuilder.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
            stringBuilder.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
            stringBuilder.append("</body></html>");
            loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", CommonUtil.UTF8, null);
            return true;
        }
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (this.e) {
            this.f.stopLoading();
        } else {
            this.g.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (this.e) {
            try {
                v.a(this.f.getView(), "super_computeScroll");
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.g.a();
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.b(motionEvent);
        }
        try {
            Object a = v.a(this.f.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.c(motionEvent);
        }
        try {
            Object a = v.a(this.f.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (this.e) {
            try {
                v.a(this.f.getView(), "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.g.a(i, i2, z, z2);
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.e) {
            try {
                v.a(this.f.getView(), "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.g.a(i, i2, i3, i4);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.a(motionEvent);
        }
        try {
            Object a = v.a(this.f.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!this.e) {
            return this.g.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        try {
            Object a = v.a(this.f.getView(), "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z));
            return a == null ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public void switchNightMode(boolean z) {
        if (z != x) {
            x = z;
            if (x) {
                TbsLog.e("QB_SDK", "deleteNightMode");
                loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
                return;
            }
            TbsLog.e("QB_SDK", "nightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (!x) {
            TbsLog.e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public boolean zoomIn() {
        return !this.e ? this.g.zoomIn() : this.f.zoomIn();
    }

    public boolean zoomOut() {
        return !this.e ? this.g.zoomOut() : this.f.zoomOut();
    }
}
