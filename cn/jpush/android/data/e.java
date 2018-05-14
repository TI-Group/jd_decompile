package cn.jpush.android.data;

/* compiled from: TbsSdkJava */
public final class e {
    private static final String[] z;
    private long a;
    private int b;
    private int c;
    private int d;
    private String e;
    private long f;
    private long g;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "S\r!U\b\rH T!\u001a\u0010";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
    L_0x0011:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0016:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x0070;
            case 1: goto L_0x0073;
            case 2: goto L_0x0076;
            case 3: goto L_0x0079;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 87;
    L_0x001f:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0016;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0011;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004b;
            case 2: goto L_0x0053;
            case 3: goto L_0x005b;
            case 4: goto L_0x0063;
            case 5: goto L_0x006b;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "S\r!U\b\u000bT=^j";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "S\r!U\b\u001eI)d#\u0016@(\u0006";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "S\r!U\b\u000b_$\\0\u001a_\u0012O>\u0012Hp";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "S\r!U\b\u001aU9I6B";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "S\r!U\b\u001cB8U#B";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "3B.Z;1B9R1\u0016N,O>\u0010C\ty\u0013\u001eY,\u001b\f\u0013C\u0012R3B";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0070:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x001f;
    L_0x0073:
        r9 = 45;
        goto L_0x001f;
    L_0x0076:
        r9 = 77;
        goto L_0x001f;
    L_0x0079:
        r9 = 59;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.e.<clinit>():void");
    }

    public e() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = 0;
        this.g = 0;
    }

    public final long a() {
        return this.a;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final int b() {
        return this.b;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final void b(long j) {
        this.g = j;
    }

    public final int c() {
        return this.c;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final void c(long j) {
        this.f = j;
    }

    public final String d() {
        return this.e;
    }

    public final long e() {
        return this.g;
    }

    public final long f() {
        return this.f;
    }

    public final String toString() {
        return new StringBuilder(z[6]).append(this.a).append(z[5]).append(this.b).append(z[0]).append(this.c).append(z[1]).append(this.d).append(z[4]).append(this.e).append(z[3]).append(this.f).append(z[2]).append(this.g).append("]").toString();
    }
}
