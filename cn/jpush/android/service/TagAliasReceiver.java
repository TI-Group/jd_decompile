package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.d.e;

/* compiled from: TbsSdkJava */
public class TagAliasReceiver extends BroadcastReceiver {
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
        r4 = 3;
        r3 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 5;
        r6 = new java.lang.String[r0];
        r5 = "NG\u001d5TSG\t\u000bK_W\u00130";
        r0 = -1;
        r7 = r6;
        r8 = r6;
        r6 = r1;
    L_0x000d:
        r5 = r5.toCharArray();
        r9 = r5.length;
        if (r9 > r2) goto L_0x0075;
    L_0x0014:
        r10 = r1;
    L_0x0015:
        r11 = r5;
        r12 = r10;
        r15 = r9;
        r9 = r5;
        r5 = r15;
    L_0x001a:
        r14 = r9[r10];
        r13 = r12 % 5;
        switch(r13) {
            case 0: goto L_0x0069;
            case 1: goto L_0x006c;
            case 2: goto L_0x006f;
            case 3: goto L_0x0072;
            default: goto L_0x0021;
        };
    L_0x0021:
        r13 = 56;
    L_0x0023:
        r13 = r13 ^ r14;
        r13 = (char) r13;
        r9[r10] = r13;
        r10 = r12 + 1;
        if (r5 != 0) goto L_0x002f;
    L_0x002b:
        r9 = r11;
        r12 = r10;
        r10 = r5;
        goto L_0x001a;
    L_0x002f:
        r9 = r5;
        r5 = r11;
    L_0x0031:
        if (r9 > r10) goto L_0x0015;
    L_0x0033:
        r9 = new java.lang.String;
        r9.<init>(r5);
        r5 = r9.intern();
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0051;
            case 2: goto L_0x005a;
            case 3: goto L_0x0064;
            default: goto L_0x003f;
        };
    L_0x003f:
        r7[r6] = r5;
        r0 = "nG\u001d\u0015TSG\t\u001bH_T\u001b WH\u0006\u0015:j_E\u001f=N_\u0006\u0013:L_H\u000etQI\u0006\u0014!TV";
        r5 = r0;
        r6 = r2;
        r7 = r8;
        r0 = r1;
        goto L_0x000d;
    L_0x0048:
        r7[r6] = r5;
        r0 = "nG\u001d\u0015TSG\t\u0006]YC\u0013\"]H";
        r5 = r0;
        r6 = r3;
        r7 = r8;
        r0 = r2;
        goto L_0x000d;
    L_0x0051:
        r7[r6] = r5;
        r0 = "NG\u001d5TSG\t\u000b]HT\u0015&[UB\u001f";
        r5 = r0;
        r6 = r4;
        r7 = r8;
        r0 = r3;
        goto L_0x000d;
    L_0x005a:
        r7[r6] = r5;
        r5 = 4;
        r0 = "nG\u001d\u0015TSG\t\u001bH_T\u001b WH\u0006\u0015:j_E\u001f=N_\u0006\b=\\\u001aO\ttQTP\u001b8Q^C";
        r6 = r5;
        r7 = r8;
        r5 = r0;
        r0 = r4;
        goto L_0x000d;
    L_0x0064:
        r7[r6] = r5;
        z = r8;
        return;
    L_0x0069:
        r13 = 58;
        goto L_0x0023;
    L_0x006c:
        r13 = 38;
        goto L_0x0023;
    L_0x006f:
        r13 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        goto L_0x0023;
    L_0x0072:
        r13 = 84;
        goto L_0x0023;
    L_0x0075:
        r10 = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.TagAliasReceiver.<clinit>():void");
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            e.h(z[2], z[1]);
            return;
        }
        long longExtra = intent.getLongExtra(z[0], -1);
        int intExtra = intent.getIntExtra(z[3], 0);
        if (longExtra == -1) {
            e.g(z[2], z[4]);
        } else {
            d.a().a(context.getApplicationContext(), longExtra, intExtra, intent);
        }
    }
}
