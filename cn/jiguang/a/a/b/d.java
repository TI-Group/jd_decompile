package cn.jiguang.a.a.b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

final class d implements LocationListener {
    private static final String[] z;
    final /* synthetic */ c a;

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
        r4 = 3;
        r2 = 1;
        r1 = 0;
        r0 = 5;
        r6 = new java.lang.String[r0];
        r5 = "USP?NNHp\bG[Sd.K\u001aNw*[ON9";
        r0 = -1;
        r7 = r6;
        r8 = r6;
        r6 = r1;
    L_0x000d:
        r5 = r5.toCharArray();
        r9 = r5.length;
        if (r9 > r2) goto L_0x0074;
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
            case 3: goto L_0x0071;
            default: goto L_0x0021;
        };
    L_0x0021:
        r13 = 47;
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
        r0 = "}Mp\u0002A\\RN*A[Zf9";
        r5 = r0;
        r6 = r2;
        r7 = r8;
        r0 = r1;
        goto L_0x000d;
    L_0x0048:
        r7[r6] = r5;
        r0 = "USS9@LTg.]~Tp*MVXgq";
        r5 = r0;
        r6 = r3;
        r7 = r8;
        r0 = r2;
        goto L_0x000d;
    L_0x0051:
        r7[r6] = r5;
        r0 = "]XwkCU^b?FUS#-]UP#";
        r5 = r0;
        r6 = r4;
        r7 = r8;
        r0 = r3;
        goto L_0x000d;
    L_0x005a:
        r7[r6] = r5;
        r5 = 4;
        r0 = "USS9@LTg.]Sb)C_Y9";
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
        r13 = 61;
        goto L_0x0023;
    L_0x006f:
        r13 = r4;
        goto L_0x0023;
    L_0x0071:
        r13 = 75;
        goto L_0x0023;
    L_0x0074:
        r10 = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.d.<clinit>():void");
    }

    d(c cVar) {
        this.a = cVar;
    }

    public final void onLocationChanged(Location location) {
        cn.jiguang.c.d.c(z[1], new StringBuilder(z[3]).append(this.a.c).append(":").append(location).toString());
        if (location != null) {
            this.a.a(location, this.a.c, false);
        }
        this.a.d();
    }

    public final void onProviderDisabled(String str) {
        cn.jiguang.c.d.c(z[1], new StringBuilder(z[2]).append(str).toString());
        this.a.d();
    }

    public final void onProviderEnabled(String str) {
        cn.jiguang.c.d.c(z[1], new StringBuilder(z[4]).append(str).toString());
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
        cn.jiguang.c.d.c(z[1], new StringBuilder(z[0]).append(i).toString());
        if (i == 0) {
            this.a.d();
        }
    }
}
