package cn.jiguang.b.c;

public final class e {
    private static final String[] z;
    private byte[] a;
    private int b;
    private int c;

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
        r4 = "(9M\u0006I~:H\u0007\f";
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
        r12 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
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
        r0 = "(4Q\u0006Ig=\u0004\u0000\bf<AR\u000fg)\u0004";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000c;
    L_0x0047:
        r6[r5] = r4;
        r0 = "k:J\u001c\u0006|{S\u0000\u0000|>\u0004\u0002\b{/\u0004\u0017\u0007l{K\u0014Il:P\u0013";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000c;
    L_0x0050:
        r6[r5] = r4;
        r4 = 3;
        r0 = "k:J\u001c\u0006|{N\u0007\u0004x{T\u0013\u001a|{A\u001c\r(4BR\ri/E";
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
        r12 = 8;
        goto L_0x0022;
    L_0x0062:
        r12 = 91;
        goto L_0x0022;
    L_0x0065:
        r12 = 36;
        goto L_0x0022;
    L_0x0068:
        r12 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        goto L_0x0022;
    L_0x006b:
        r9 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.e.<clinit>():void");
    }

    public e() {
        this(32);
    }

    private e(int i) {
        this.a = new byte[32];
        this.b = 0;
        this.c = -1;
    }

    private static void a(long j, int i) {
        long j2 = 1 << i;
        if (j < 0 || j > j2) {
            throw new IllegalArgumentException(j + z[1] + i + z[0]);
        }
    }

    private void d(int i) {
        if (this.a.length - this.b < i) {
            int length = this.a.length * 2;
            if (length < this.b + i) {
                length = this.b + i;
            }
            Object obj = new byte[length];
            System.arraycopy(this.a, 0, obj, 0, this.b);
            this.a = obj;
        }
    }

    public final int a() {
        return this.b;
    }

    public final void a(int i) {
        if (i > this.b) {
            throw new IllegalArgumentException(z[3]);
        }
        this.b = i;
    }

    public final void a(int i, int i2) {
        a((long) i, 16);
        if (i2 > this.b - 2) {
            throw new IllegalArgumentException(z[2]);
        }
        int i3 = i2 + 1;
        this.a[i2] = (byte) ((i >>> 8) & 255);
        this.a[i3] = (byte) (i & 255);
    }

    public final void a(long j) {
        a(j, 32);
        d(4);
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 24) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 16) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 8) & 255));
        bArr = this.a;
        i = this.b;
        this.b = i + 1;
        bArr[i] = (byte) ((int) (j & 255));
    }

    public final void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    public final void a(byte[] bArr, int i, int i2) {
        d(i2);
        System.arraycopy(bArr, i, this.a, this.b, i2);
        this.b += i2;
    }

    public final void b(int i) {
        a(0, 8);
        d(1);
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) 0;
    }

    public final byte[] b() {
        Object obj = new byte[this.b];
        System.arraycopy(this.a, 0, obj, 0, this.b);
        return obj;
    }

    public final void c(int i) {
        a((long) i, 16);
        d(2);
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr = this.a;
        i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }
}
