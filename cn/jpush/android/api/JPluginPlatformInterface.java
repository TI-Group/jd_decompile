package cn.jpush.android.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.c.c;
import cn.jpush.android.c.g;
import cn.jpush.android.d.e;

/* compiled from: TbsSdkJava */
public class JPluginPlatformInterface {
    public static final int JPLUGIN_REQUEST_CODE = 10001;
    private static final String[] z;
    private c a;

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
        r4 = 1;
        r1 = 0;
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = "y;U6cZ\u0005i/eG\rV1iz\u0005M&vU\nZ&";
        r0 = -1;
        r5 = r3;
        r6 = r3;
        r3 = r1;
    L_0x000b:
        r2 = r2.toCharArray();
        r7 = r2.length;
        if (r7 > r4) goto L_0x0056;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r2;
        r10 = r8;
        r13 = r7;
        r7 = r2;
        r2 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x004a;
            case 1: goto L_0x004d;
            case 2: goto L_0x0050;
            case 3: goto L_0x0053;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 4;
    L_0x0020:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r2 != 0) goto L_0x002c;
    L_0x0028:
        r7 = r9;
        r10 = r8;
        r8 = r2;
        goto L_0x0018;
    L_0x002c:
        r7 = r2;
        r2 = r9;
    L_0x002e:
        if (r7 > r8) goto L_0x0013;
    L_0x0030:
        r7 = new java.lang.String;
        r7.<init>(r2);
        r2 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0045;
            default: goto L_0x003c;
        };
    L_0x003c:
        r5[r3] = r2;
        r0 = "]\u000eNcNc\u0007L$m];U\"pU\u0004K.M]\u001f\\1bR\b\\cbR\u0002U&`\t";
        r2 = r0;
        r3 = r4;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0045:
        r5[r3] = r2;
        z = r6;
        return;
    L_0x004a:
        r11 = 51;
        goto L_0x0020;
    L_0x004d:
        r11 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        goto L_0x0020;
    L_0x0050:
        r11 = 57;
        goto L_0x0020;
    L_0x0053:
        r11 = 67;
        goto L_0x0020;
    L_0x0056:
        r8 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.JPluginPlatformInterface.<clinit>():void");
    }

    public JPluginPlatformInterface(Context context) {
        try {
            if (g.a().f(context) == (byte) 2) {
                this.a = new c(context);
            }
        } catch (Throwable th) {
            e.h(z[0], new StringBuilder(z[1]).append(th).toString());
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (this.a != null) {
            this.a.a(activity, i, i2);
        }
    }

    public void onStart(Activity activity) {
        if (this.a != null) {
            this.a.a(activity);
        }
    }

    public void onStop(Activity activity) {
        if (this.a != null) {
            this.a.b(activity);
        }
    }
}
