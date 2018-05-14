package cn.jpush.android.e.a;

import android.webkit.WebView;
import cn.jpush.android.api.c;

/* compiled from: TbsSdkJava */
public class b {
    private static final String TAG;
    private static f mWebViewHelper;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = "\u0016sQwd-OAl^;";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        r3 = 1;
        if (r1 > r3) goto L_0x0027;
    L_0x000b:
        r3 = r0;
        r4 = r2;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0010:
        r6 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x0035;
            case 1: goto L_0x0038;
            case 2: goto L_0x003b;
            case 3: goto L_0x003e;
            default: goto L_0x0017;
        };
    L_0x0017:
        r5 = 46;
    L_0x0019:
        r5 = r5 ^ r6;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x0010;
    L_0x0025:
        r1 = r0;
        r0 = r3;
    L_0x0027:
        if (r1 > r2) goto L_0x000b;
    L_0x0029:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        TAG = r0;
        return;
    L_0x0035:
        r5 = 94;
        goto L_0x0019;
    L_0x0038:
        r5 = 28;
        goto L_0x0019;
    L_0x003b:
        r5 = 34;
        goto L_0x0019;
    L_0x003e:
        r5 = 3;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.e.a.b.<clinit>():void");
    }

    public static void click(WebView webView, String str, String str2, String str3) {
        if (mWebViewHelper != null) {
            mWebViewHelper.click(str, str2, str3);
        }
    }

    public static void close(WebView webView) {
        if (mWebViewHelper != null) {
            mWebViewHelper.close();
        }
    }

    public static void createShortcut(WebView webView, String str, String str2, String str3) {
        if (mWebViewHelper != null) {
            mWebViewHelper.createShortcut(str, str2, str3);
        }
    }

    public static void download(WebView webView, String str) {
        if (mWebViewHelper != null) {
            mWebViewHelper.download(str);
        }
    }

    public static void download(WebView webView, String str, String str2) {
        if (mWebViewHelper != null) {
            mWebViewHelper.download(str, str2);
        }
    }

    public static void download(WebView webView, String str, String str2, String str3) {
        if (mWebViewHelper != null) {
            mWebViewHelper.download(str, str2, str3);
        }
    }

    public static void executeMsgMessage(WebView webView, String str) {
        if (mWebViewHelper != null) {
            mWebViewHelper.executeMsgMessage(str);
        }
    }

    public static void setWebViewHelper(f fVar) {
        if (fVar != null) {
            mWebViewHelper = fVar;
        }
    }

    public static void showTitleBar(WebView webView) {
        if (mWebViewHelper != null) {
            mWebViewHelper.showTitleBar();
        }
    }

    public static void showToast(WebView webView, String str) {
        if (mWebViewHelper != null) {
            mWebViewHelper.showToast(str);
        }
    }

    public static void startActivityByIntent(WebView webView, String str, String str2) {
        if (mWebViewHelper != null) {
            mWebViewHelper.startActivityByIntent(str, str2);
        }
    }

    public static void startActivityByName(WebView webView, String str, String str2) {
        if (mWebViewHelper != null) {
            mWebViewHelper.startActivityByName(str, str2);
        }
    }

    public static void startActivityByNameWithSystemAlert(WebView webView, String str, String str2) {
        if (c.a != null) {
            c.a.a(str, str2);
        }
    }

    public static void startMainActivity(WebView webView, String str) {
        if (mWebViewHelper != null) {
            mWebViewHelper.startMainActivity(str);
        }
    }

    public static void startPushActivity(WebView webView, String str) {
        if (mWebViewHelper != null) {
            mWebViewHelper.startPushActivity(str);
        }
    }

    public static void triggerNativeAction(WebView webView, String str) {
        if (mWebViewHelper != null) {
            mWebViewHelper.triggerNativeAction(str);
        }
    }
}
