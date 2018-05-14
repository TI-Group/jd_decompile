package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JActionExtra;
import cn.jpush.android.c.i;
import cn.jpush.android.d.e;

/* compiled from: TbsSdkJava */
public class c extends JActionExtra {
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
        r3 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 4;
        r5 = new java.lang.String[r0];
        r4 = "\u000f8(Bx\u0010&$Bg\u000f1";
        r0 = -1;
        r6 = r5;
        r7 = r5;
        r5 = r1;
    L_0x000c:
        r4 = r4.toCharArray();
        r8 = r4.length;
        if (r8 > r2) goto L_0x006b;
    L_0x0013:
        r9 = r1;
    L_0x0014:
        r10 = r4;
        r11 = r9;
        r14 = r8;
        r8 = r4;
        r4 = r14;
    L_0x0019:
        r13 = r8[r9];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x005f;
            case 1: goto L_0x0062;
            case 2: goto L_0x0065;
            case 3: goto L_0x0068;
            default: goto L_0x0020;
        };
    L_0x0020:
        r12 = 30;
    L_0x0022:
        r12 = r12 ^ r13;
        r12 = (char) r12;
        r8[r9] = r12;
        r9 = r11 + 1;
        if (r4 != 0) goto L_0x002e;
    L_0x002a:
        r8 = r10;
        r11 = r9;
        r9 = r4;
        goto L_0x0019;
    L_0x002e:
        r8 = r4;
        r4 = r10;
    L_0x0030:
        if (r8 > r9) goto L_0x0014;
    L_0x0032:
        r8 = new java.lang.String;
        r8.<init>(r4);
        r4 = r8.intern();
        switch(r0) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0050;
            case 2: goto L_0x005a;
            default: goto L_0x003e;
        };
    L_0x003e:
        r6[r5] = r4;
        r0 = "_2 Z{\u001bt'Ws\u001at>Wm_1$Fj\u0006";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000c;
    L_0x0047:
        r6[r5] = r4;
        r0 = "\u001c;'B{\u0007 iA\ft'Cr\u0013";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000c;
    L_0x0050:
        r6[r5] = r4;
        r4 = 3;
        r0 = "5\u0004<Ev/&&Bq\u001c;%w}\u000b=&X";
        r5 = r4;
        r6 = r7;
        r4 = r0;
        r0 = r3;
        goto L_0x000c;
    L_0x005a:
        r6[r5] = r4;
        z = r7;
        return;
    L_0x005f:
        r12 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x0022;
    L_0x0062:
        r12 = 84;
        goto L_0x0022;
    L_0x0065:
        r12 = 73;
        goto L_0x0022;
    L_0x0068:
        r12 = 54;
        goto L_0x0022;
    L_0x006b:
        r9 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.c.<clinit>():void");
    }

    public Object beforLogin(Context context, int i, String str) {
        if (context == null) {
            e.i(z[3], z[2]);
            return null;
        } else if (!TextUtils.isEmpty(str)) {
            return (!z[0].equals(str) || i < 16) ? null : Byte.valueOf(i.a(context));
        } else {
            e.i(z[3], z[1]);
            return null;
        }
    }
}
