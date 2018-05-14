package cn.jpush.android.e.a;

import android.os.Build.VERSION;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import cn.jpush.android.d.e;

/* compiled from: TbsSdkJava */
public class c extends WebChromeClient {
    private static final String[] z;
    private final String a = z[1];
    private d b;
    private boolean c;

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = 1;
        r1 = 0;
        r0 = 3;
        r4 = new java.lang.String[r0];
        r3 = "Ft(|:n~l}1l::k'ts#`uk?}0u:8f4i:}9y'P-x4–P?.<in)|4dnll,'s\"d0dn%a;&";
        r0 = -1;
        r5 = r4;
        r6 = r4;
        r4 = r1;
    L_0x000b:
        r3 = r3.toCharArray();
        r7 = r3.length;
        if (r7 > r2) goto L_0x0060;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r3;
        r10 = r8;
        r13 = r7;
        r7 = r3;
        r3 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x0055;
            case 1: goto L_0x0057;
            case 2: goto L_0x005a;
            case 3: goto L_0x005d;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 85;
    L_0x0021:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r3 != 0) goto L_0x002d;
    L_0x0029:
        r7 = r9;
        r10 = r8;
        r8 = r3;
        goto L_0x0018;
    L_0x002d:
        r7 = r3;
        r3 = r9;
    L_0x002f:
        if (r7 > r8) goto L_0x0013;
    L_0x0031:
        r7 = new java.lang.String;
        r7.<init>(r3);
        r3 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0046;
            case 1: goto L_0x0050;
            default: goto L_0x003d;
        };
    L_0x003d:
        r5[r4] = r3;
        r0 = "Nt&k6s(M=uu!k\u0016ks)`!";
        r3 = r0;
        r4 = r2;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r4] = r3;
        r3 = 2;
        r0 = "'s\"d0dnld&'s\"z0u|-m0'y#c%k8k9~:#`uwh#i'bi?.";
        r4 = r3;
        r5 = r6;
        r3 = r0;
        r0 = r2;
        goto L_0x000b;
    L_0x0050:
        r5[r4] = r3;
        z = r6;
        return;
    L_0x0055:
        r11 = 7;
        goto L_0x0021;
    L_0x0057:
        r11 = 26;
        goto L_0x0021;
    L_0x005a:
        r11 = 76;
        goto L_0x0021;
    L_0x005d:
        r11 = 14;
        goto L_0x0021;
    L_0x0060:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.e.a.c.<clinit>():void");
    }

    public c(String str, Class cls) {
        this.b = new d(str, cls);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (VERSION.SDK_INT < 17) {
            jsPromptResult.confirm(this.b.a(webView, str2));
        }
        return true;
    }

    public void onProgressChanged(WebView webView, int i) {
        webView.getSettings().setSavePassword(false);
        if (VERSION.SDK_INT < 17) {
            if (i <= 25) {
                this.c = false;
            } else if (!this.c) {
                e.d(z[1], z[0]);
                webView.loadUrl(this.b.a());
                this.c = true;
                e.c(z[1], new StringBuilder(z[2]).append(i).toString());
            }
        }
        super.onProgressChanged(webView, i);
    }
}
