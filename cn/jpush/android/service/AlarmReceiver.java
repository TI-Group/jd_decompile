package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.b.b.b;
import cn.jiguang.b.d.j;
import cn.jiguang.c.d;
import cn.jiguang.e.a;

public class AlarmReceiver extends BroadcastReceiver {
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
        r4 = 1;
        r1 = 0;
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = "sh=\u000e\u0000yo\u0019\u000e";
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
            case 0: goto L_0x004b;
            case 1: goto L_0x004e;
            case 2: goto L_0x0050;
            case 3: goto L_0x0053;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 99;
    L_0x0021:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r2 != 0) goto L_0x002d;
    L_0x0029:
        r7 = r9;
        r10 = r8;
        r8 = r2;
        goto L_0x0018;
    L_0x002d:
        r7 = r2;
        r2 = r9;
    L_0x002f:
        if (r7 > r8) goto L_0x0013;
    L_0x0031:
        r7 = new java.lang.String;
        r7.<init>(r2);
        r2 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0046;
            default: goto L_0x003d;
        };
    L_0x003d:
        r5[r3] = r2;
        r0 = "]j\u000e\u0019\u000eNc\f\u000e\njc\u001d";
        r2 = r0;
        r3 = r4;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r3] = r2;
        z = r6;
        return;
    L_0x004b:
        r11 = 28;
        goto L_0x0021;
    L_0x004e:
        r11 = 6;
        goto L_0x0021;
    L_0x0050:
        r11 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        goto L_0x0021;
    L_0x0053:
        r11 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        goto L_0x0021;
    L_0x0056:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.AlarmReceiver.<clinit>():void");
    }

    public void onReceive(Context context, Intent intent) {
        d.c(z[1], z[0]);
        if (!JCoreInterface.init(context.getApplicationContext(), false)) {
            return;
        }
        if (cn.jiguang.b.a.d.k(context)) {
            b.a(context, false);
            return;
        }
        if (VERSION.SDK_INT >= 19) {
            a.h(context.getApplicationContext());
        }
        j.a();
        j.b(context);
    }
}
