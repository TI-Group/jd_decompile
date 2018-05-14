package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.smtt.utils.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CookieManager {
    private static CookieManager b;
    ArrayList<a> a;
    private boolean c = false;

    class a {
        int a;
        String b;
        String c;
        ValueCallback<Boolean> d;
        final /* synthetic */ CookieManager e;

        a(CookieManager cookieManager) {
            this.e = cookieManager;
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (b == null) {
            synchronized (CookieManager.class) {
                if (b == null) {
                    b = new CookieManager();
                }
            }
        }
        return b;
    }

    synchronized void a() {
        this.c = true;
        if (!(this.a == null || this.a.size() == 0)) {
            bo b = bo.b();
            Iterator it;
            a aVar;
            if (b != null && b.c()) {
                it = this.a.iterator();
                while (it.hasNext()) {
                    aVar = (a) it.next();
                    switch (aVar.a) {
                        case 1:
                            setCookie(aVar.b, aVar.c, aVar.d);
                            break;
                        case 2:
                            setCookie(aVar.b, aVar.c);
                            break;
                        default:
                            break;
                    }
                }
            }
            it = this.a.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                switch (aVar.a) {
                    case 1:
                        if (VERSION.SDK_INT < 21) {
                            break;
                        }
                        v.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, aVar.b, aVar.c, aVar.d);
                        break;
                    case 2:
                        android.webkit.CookieManager.getInstance().setCookie(aVar.b, aVar.c);
                        break;
                    default:
                        break;
                }
            }
            this.a.clear();
        }
    }

    public boolean acceptCookie() {
        bo b = bo.b();
        return (b == null || !b.c()) ? android.webkit.CookieManager.getInstance().acceptCookie() : b.d().d();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        boolean booleanValue;
        bo b = bo.b();
        Object invokeStaticMethod;
        if (b != null && b.c()) {
            invokeStaticMethod = b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : true;
        } else if (VERSION.SDK_INT < 21) {
            booleanValue = true;
        } else {
            invokeStaticMethod = v.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : false;
        }
        return booleanValue;
    }

    public void flush() {
        bo b = bo.b();
        if (b != null && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (VERSION.SDK_INT >= 21) {
            v.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        bo b = bo.b();
        if (b != null && b.c()) {
            return b.d().a(str);
        }
        String str2 = null;
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public boolean hasCookies() {
        bo b = bo.b();
        return (b == null || !b.c()) ? android.webkit.CookieManager.getInstance().hasCookies() : b.d().h();
    }

    public void removeAllCookie() {
        if (this.a != null) {
            this.a.clear();
        }
        bo b = bo.b();
        if (b == null || !b.c()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            b.d().e();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        if (this.a != null) {
            this.a.clear();
        }
        bo b = bo.b();
        if (b != null && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
        } else if (VERSION.SDK_INT >= 21) {
            v.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
        }
    }

    public void removeExpiredCookie() {
        bo b = bo.b();
        if (b == null || !b.c()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookie() {
        bo b = bo.b();
        if (b == null || !b.c()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        bo b = bo.b();
        if (b != null && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
        } else if (VERSION.SDK_INT >= 21) {
            v.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        if (!z) {
            bo b = bo.b();
            if (b == null || !b.c()) {
                try {
                    android.webkit.CookieManager.getInstance().setAcceptCookie(z);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            }
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        bo b = bo.b();
        if (b != null && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else if (VERSION.SDK_INT >= 21) {
            v.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public synchronized void setCookie(String str, String str2) {
        bo b = bo.b();
        if (b == null || !b.c()) {
            if (this.c) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!bo.b().e()) {
                a aVar = new a(this);
                aVar.a = 2;
                aVar.b = str;
                aVar.c = str2;
                aVar.d = null;
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.add(aVar);
            }
        } else {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
        }
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        bo b = bo.b();
        if (b == null || !b.c()) {
            if (!bo.b().e()) {
                a aVar = new a(this);
                aVar.a = 1;
                aVar.b = str;
                aVar.c = str2;
                aVar.d = valueCallback;
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.add(aVar);
            }
            if (this.c && VERSION.SDK_INT >= 21) {
                v.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
            }
        } else {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
        }
    }

    public void setCookies(Map<String, String[]> map) {
        bo b = bo.b();
        boolean a = (b == null || !b.c()) ? false : b.d().a((Map) map);
        if (!a) {
            for (String str : map.keySet()) {
                for (String cookie : (String[]) map.get(str)) {
                    setCookie(str, cookie);
                }
            }
        }
    }
}
