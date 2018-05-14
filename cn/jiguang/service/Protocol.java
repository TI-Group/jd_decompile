package cn.jiguang.service;

public class Protocol {
    private static final String z;

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
        r10 = 92;
        r8 = 82;
        r9 = 30;
        r12 = 1;
        r1 = 0;
        r2 = "\u0001\u0003m(\u0001?Tr3\u000566w>\u00163\bgf^8\u0019q.\u0001cK(";
        r0 = -1;
    L_0x000b:
        r2 = r2.toCharArray();
        r3 = r2.length;
        if (r3 > r12) goto L_0x00a9;
    L_0x0012:
        r4 = r1;
    L_0x0013:
        r5 = r2;
        r6 = r4;
        r13 = r3;
        r3 = r2;
        r2 = r13;
    L_0x0018:
        r11 = r3[r4];
        r7 = r6 % 5;
        switch(r7) {
            case 0: goto L_0x0044;
            case 1: goto L_0x0046;
            case 2: goto L_0x0049;
            case 3: goto L_0x004b;
            default: goto L_0x001f;
        };
    L_0x001f:
        r7 = 100;
    L_0x0021:
        r7 = r7 ^ r11;
        r7 = (char) r7;
        r3[r4] = r7;
        r4 = r6 + 1;
        if (r2 != 0) goto L_0x002d;
    L_0x0029:
        r3 = r5;
        r6 = r4;
        r4 = r2;
        goto L_0x0018;
    L_0x002d:
        r3 = r2;
        r2 = r5;
    L_0x002f:
        if (r3 > r4) goto L_0x0013;
    L_0x0031:
        r3 = new java.lang.String;
        r3.<init>(r2);
        r2 = r3.intern();
        switch(r0) {
            case 0: goto L_0x00a1;
            default: goto L_0x003d;
        };
    L_0x003d:
        z = r2;
        r0 = "8\u0019q.\u0001cK(";	 Catch:{ Throwable -> 0x004d }
        r2 = r0;
        r0 = r1;
        goto L_0x000b;
    L_0x0044:
        r7 = r8;
        goto L_0x0021;
    L_0x0046:
        r7 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        goto L_0x0021;
    L_0x0049:
        r7 = r9;
        goto L_0x0021;
    L_0x004b:
        r7 = r10;
        goto L_0x0021;
    L_0x004d:
        r0 = move-exception;
        r6 = r0;
        r0 = "\u0002\u000fm44 \u0015j3\u0007=\u0016";
        r0 = r0.toCharArray();
        r2 = r0.length;
        if (r2 > r12) goto L_0x00a5;
    L_0x0058:
        r13 = r2;
        r2 = r1;
        r1 = r13;
    L_0x005b:
        r3 = r0;
        r4 = r2;
        r13 = r1;
        r1 = r0;
        r0 = r13;
    L_0x0060:
        r7 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x0075;
            case 1: goto L_0x0077;
            case 2: goto L_0x007a;
            case 3: goto L_0x007c;
            default: goto L_0x0067;
        };
    L_0x0067:
        r5 = 100;
    L_0x0069:
        r5 = r5 ^ r7;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x007e;
    L_0x0071:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x0060;
    L_0x0075:
        r5 = r8;
        goto L_0x0069;
    L_0x0077:
        r5 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        goto L_0x0069;
    L_0x007a:
        r5 = r9;
        goto L_0x0069;
    L_0x007c:
        r5 = r10;
        goto L_0x0069;
    L_0x007e:
        r1 = r0;
        r0 = r3;
    L_0x0080:
        if (r1 > r2) goto L_0x005b;
    L_0x0082:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        r1 = new java.lang.StringBuilder;
        r2 = z;
        r1.<init>(r2);
        r1 = r1.append(r6);
        r1 = r1.toString();
        cn.jiguang.c.d.i(r0, r1);
        r6.printStackTrace();
    L_0x00a0:
        return;
    L_0x00a1:
        java.lang.System.loadLibrary(r2);	 Catch:{ Throwable -> 0x004d }
        goto L_0x00a0;
    L_0x00a5:
        r13 = r2;
        r2 = r1;
        r1 = r13;
        goto L_0x0080;
    L_0x00a9:
        r4 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.service.Protocol.<clinit>():void");
    }

    public static native synchronized int Close(long j);

    public static native int GetSdkVersion();

    public static native synchronized long InitConn();

    public static native int InitPush(long j, String str, int i);

    public static native int LogPush(long j, byte[] bArr, byte[] bArr2, int i);

    public static native int RecvPush(long j, byte[] bArr, int i);

    public static native int SendData(long j, byte[] bArr, int i);

    public static native int Stop(long j);
}
