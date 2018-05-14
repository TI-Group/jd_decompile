package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import cn.jpush.android.a;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.e;

/* compiled from: TbsSdkJava */
public class DaemonService extends Service {
    private static final String[] z;

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
        r1 = 0;
        r2 = 1;
        r0 = 3;
        r4 = new java.lang.String[r0];
        r3 = "\u0010\u001cwlG:.ws^=\u001ew!G:>`dI \u00182gI=\u0011we\u0012";
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
            case 1: goto L_0x0058;
            case 2: goto L_0x005b;
            case 3: goto L_0x005e;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 40;
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
        r0 = "5\u001efhG:]}ok&\u0018suM";
        r3 = r0;
        r4 = r2;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r4] = r3;
        r3 = 2;
        r0 = "\u001e-gr@\u0010\u001cwlG:.ws^=\u001ew";
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
        r11 = 84;
        goto L_0x0021;
    L_0x0058:
        r11 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        goto L_0x0021;
    L_0x005b:
        r11 = 18;
        goto L_0x0021;
    L_0x005e:
        r11 = r2;
        goto L_0x0021;
    L_0x0060:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.DaemonService.<clinit>():void");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        e.c(z[2], z[1]);
        try {
            super.onCreate();
            if (a.a(getApplicationContext())) {
                JPushInterface.init(this);
            } else {
                stopSelf();
            }
        } catch (Throwable th) {
            e.h(z[2], new StringBuilder(z[0]).append(th.getMessage()).toString());
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
