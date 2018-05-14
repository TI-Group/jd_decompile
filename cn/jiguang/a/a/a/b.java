package cn.jiguang.a.a.a;

public final class b {
    private static final String[] z;
    private String a;
    private String b;
    private String c;
    private String d;

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
        r4 = "_%#\u0016<\u00148b";
        r0 = -1;
        r6 = r5;
        r7 = r5;
        r5 = r1;
    L_0x000c:
        r4 = r4.toCharArray();
        r8 = r4.length;
        if (r8 > r2) goto L_0x006a;
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
            case 2: goto L_0x0064;
            case 3: goto L_0x0067;
            default: goto L_0x0020;
        };
    L_0x0020:
        r12 = 93;
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
        r0 = "2w533\u0015j>\u0013-,D!\u001e/N\"";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000c;
    L_0x0047:
        r6[r5] = r4;
        r0 = "_%-\r\u0002\u0007|5\u001f`T";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000c;
    L_0x0050:
        r6[r5] = r4;
        r4 = 3;
        r0 = "_%-\r\u0002\u0012a!\b`T";
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
        r12 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        goto L_0x0022;
    L_0x0062:
        r12 = 5;
        goto L_0x0022;
    L_0x0064:
        r12 = 69;
        goto L_0x0022;
    L_0x0067:
        r12 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        goto L_0x0022;
    L_0x006a:
        r9 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.a.b.<clinit>():void");
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.c;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String c() {
        return this.d;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final void d(String str) {
        this.d = str;
    }

    public final String toString() {
        return new StringBuilder(z[1]).append(this.a).append('\'').append(z[2]).append(this.b).append('\'').append(z[0]).append(this.c).append('\'').append(z[3]).append(this.d).append('\'').append('}').toString();
    }
}
