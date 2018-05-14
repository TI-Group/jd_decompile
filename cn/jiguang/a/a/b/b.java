package cn.jiguang.a.a.b;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import cn.jiguang.c.d;
import org.json.JSONArray;

final class b extends PhoneStateListener {
    private static final String[] z;
    final /* synthetic */ a a;

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = 1;
        r1 = 0;
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = "6\t-\tA7\u0006\u00123R+\u0002\u0010\u0007R1\u0014=\bG7\u0000\u001b\u0004\u001c";
        r0 = -1;
        r5 = r3;
        r6 = r3;
        r3 = r1;
    L_0x000b:
        r2 = r2.toCharArray();
        r7 = r2.length;
        if (r7 > r4) goto L_0x0057;
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
            case 2: goto L_0x0051;
            case 3: goto L_0x0054;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 38;
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
        r0 = "\u001a\u0002\u0012\fo7\u0001\u0011-G7\u0006\u0019\u0005T";
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
        r11 = 89;
        goto L_0x0021;
    L_0x004e:
        r11 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x0021;
    L_0x0051:
        r11 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        goto L_0x0021;
    L_0x0054:
        r11 = 96;
        goto L_0x0021;
    L_0x0057:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.b.<clinit>():void");
    }

    public b(a aVar) {
        this.a = aVar;
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        this.a.h = signalStrength.getGsmSignalStrength();
        a.a(this.a, new JSONArray());
        d.g(z[1], new StringBuilder(z[0]).append(this.a.h).toString());
        this.a.d();
    }
}
