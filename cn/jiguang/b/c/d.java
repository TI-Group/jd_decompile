package cn.jiguang.b.c;

import android.support.v4.internal.view.SupportMenu;
import java.nio.ByteBuffer;

public final class d {
    private static final String[] z;
    private ByteBuffer a;
    private int b = -1;
    private int c = -1;

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
        r4 = "\u0017D[Az\u001c]\u0012^}\n\u000b\bEi\rN";
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
        r12 = 8;
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
        r0 = "\u001aJ\u0015_g\r\u000b\u0011De\t\u000b\u000bP{\r\u000b\u001e_lYD\u001d\u0011a\u0017[\u000eE";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000c;
    L_0x0047:
        r6[r5] = r4;
        r0 = "\u001aJ\u0015_g\r\u000b\bT|YJ\u0018Ea\u000fN[Cm\u001eB\u0014_(\tJ\bE(\u001cE\u001f\u0011g\u001f\u000b\u0012_x\f_";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000c;
    L_0x0050:
        r6[r5] = r4;
        r4 = 3;
        r0 = "\u001cE\u001f\u0011g\u001f\u000b\u0012_x\f_";
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
        r12 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x0022;
    L_0x0062:
        r12 = 43;
        goto L_0x0022;
    L_0x0065:
        r12 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        goto L_0x0022;
    L_0x0068:
        r12 = 49;
        goto L_0x0022;
    L_0x006b:
        r9 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.d.<clinit>():void");
    }

    public d(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    private void c(int i) {
        if (i > this.a.remaining()) {
            throw new t(z[3]);
        }
    }

    public final int a() {
        return this.a.position();
    }

    public final void a(int i) {
        if (i > this.a.capacity() - this.a.position()) {
            throw new IllegalArgumentException(z[2]);
        }
        this.a.limit(this.a.position() + i);
    }

    public final void a(byte[] bArr, int i, int i2) {
        c(i2);
        this.a.get(bArr, 1, i2);
    }

    public final int b() {
        return this.a.remaining();
    }

    public final void b(int i) {
        if (i >= this.a.capacity()) {
            throw new IllegalArgumentException(z[1]);
        }
        this.a.position(i);
        this.a.limit(this.a.capacity());
    }

    public final void c() {
        this.a.limit(this.a.capacity());
    }

    public final void d() {
        this.b = this.a.position();
        this.c = this.a.limit();
    }

    public final void e() {
        if (this.b < 0) {
            throw new IllegalStateException(z[0]);
        }
        this.a.position(this.b);
        this.a.limit(this.c);
        this.b = -1;
        this.c = -1;
    }

    public final int f() {
        c(1);
        return this.a.get() & 255;
    }

    public final int g() {
        c(2);
        return this.a.getShort() & SupportMenu.USER_MASK;
    }

    public final long h() {
        c(4);
        return ((long) this.a.getInt()) & 4294967295L;
    }
}
