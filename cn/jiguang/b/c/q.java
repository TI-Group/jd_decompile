package cn.jiguang.b.c;

public final class q {
    private static i a = new i(z, 3);
    private static String[] b = new String[4];
    private static String[] c = new String[4];
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
        r13 = 4;
        r9 = 3;
        r7 = 2;
        r3 = 0;
        r8 = 1;
        r0 = "\u0001g\n /+gY\u0000+/v\u0010< ";
        r0 = r0.toCharArray();
        r1 = r0.length;
        if (r1 > r8) goto L_0x016a;
    L_0x000e:
        r2 = r3;
    L_0x000f:
        r4 = r0;
        r5 = r2;
        r15 = r1;
        r1 = r0;
        r0 = r15;
    L_0x0014:
        r10 = r1[r2];
        r6 = r5 % 5;
        switch(r6) {
            case 0: goto L_0x007c;
            case 1: goto L_0x007f;
            case 2: goto L_0x0081;
            case 3: goto L_0x0084;
            default: goto L_0x001b;
        };
    L_0x001b:
        r6 = 78;
    L_0x001d:
        r6 = r6 ^ r10;
        r6 = (char) r6;
        r1[r2] = r6;
        r2 = r5 + 1;
        if (r0 != 0) goto L_0x0029;
    L_0x0025:
        r1 = r4;
        r5 = r2;
        r2 = r0;
        goto L_0x0014;
    L_0x0029:
        r1 = r0;
        r0 = r4;
    L_0x002b:
        if (r1 > r2) goto L_0x000f;
    L_0x002d:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        z = r0;
        r0 = new cn.jiguang.b.c.i;
        r1 = z;
        r0.<init>(r1, r9);
        a = r0;
        r0 = new java.lang.String[r13];
        b = r0;
        r0 = new java.lang.String[r13];
        c = r0;
        r0 = a;
        r0.a(r9);
        r0 = a;
        r0.a(r8);
        r2 = a;
        r1 = "=f";
        r0 = -1;
        r4 = r2;
        r2 = r3;
    L_0x005a:
        r1 = r1.toCharArray();
        r5 = r1.length;
        if (r5 > r8) goto L_0x0167;
    L_0x0061:
        r6 = r3;
    L_0x0062:
        r10 = r1;
        r11 = r6;
        r15 = r5;
        r5 = r1;
        r1 = r15;
    L_0x0067:
        r14 = r5[r6];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x00d9;
            case 1: goto L_0x00dc;
            case 2: goto L_0x00de;
            case 3: goto L_0x00e1;
            default: goto L_0x006e;
        };
    L_0x006e:
        r12 = 78;
    L_0x0070:
        r12 = r12 ^ r14;
        r12 = (char) r12;
        r5[r6] = r12;
        r6 = r11 + 1;
        if (r1 != 0) goto L_0x00e4;
    L_0x0078:
        r5 = r10;
        r11 = r6;
        r6 = r1;
        goto L_0x0067;
    L_0x007c:
        r6 = 76;
        goto L_0x001d;
    L_0x007f:
        r6 = r7;
        goto L_0x001d;
    L_0x0081:
        r6 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x001d;
    L_0x0084:
        r6 = 83;
        goto L_0x001d;
    L_0x0087:
        r4.a(r2, r1);
        r2 = b;
        r1 = "\u001dW<\u0000\u001a\u0005M7\u0000";
        r0 = -1;
        r4 = r2;
        r2 = r3;
    L_0x0091:
        r1 = r1.toCharArray();
        r5 = r1.length;
        if (r5 > r8) goto L_0x0164;
    L_0x0098:
        r6 = r3;
    L_0x0099:
        r10 = r1;
        r11 = r6;
        r15 = r5;
        r5 = r1;
        r1 = r15;
    L_0x009e:
        r14 = r5[r6];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x00b3;
            case 1: goto L_0x00b6;
            case 2: goto L_0x00b8;
            case 3: goto L_0x00bb;
            default: goto L_0x00a5;
        };
    L_0x00a5:
        r12 = 78;
    L_0x00a7:
        r12 = r12 ^ r14;
        r12 = (char) r12;
        r5[r6] = r12;
        r6 = r11 + 1;
        if (r1 != 0) goto L_0x00be;
    L_0x00af:
        r5 = r10;
        r11 = r6;
        r6 = r1;
        goto L_0x009e;
    L_0x00b3:
        r12 = 76;
        goto L_0x00a7;
    L_0x00b6:
        r12 = r7;
        goto L_0x00a7;
    L_0x00b8:
        r12 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x00a7;
    L_0x00bb:
        r12 = 83;
        goto L_0x00a7;
    L_0x00be:
        r5 = r1;
        r1 = r10;
    L_0x00c0:
        if (r5 > r6) goto L_0x0099;
    L_0x00c2:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x011b;
            case 1: goto L_0x0127;
            case 2: goto L_0x0133;
            case 3: goto L_0x013f;
            case 4: goto L_0x014b;
            case 5: goto L_0x0156;
            case 6: goto L_0x0161;
            default: goto L_0x00ce;
        };
    L_0x00ce:
        r4[r2] = r1;
        r1 = b;
        r0 = "\rL*\u0004\u000b\u001eQ";
        r2 = r8;
        r4 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x0091;
    L_0x00d9:
        r12 = 76;
        goto L_0x0070;
    L_0x00dc:
        r12 = r7;
        goto L_0x0070;
    L_0x00de:
        r12 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x0070;
    L_0x00e1:
        r12 = 83;
        goto L_0x0070;
    L_0x00e4:
        r5 = r1;
        r1 = r10;
    L_0x00e6:
        if (r5 > r6) goto L_0x0062;
    L_0x00e8:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0101;
            case 1: goto L_0x010e;
            case 2: goto L_0x0087;
            default: goto L_0x00f4;
        };
    L_0x00f4:
        r4.a(r2, r1);
        r1 = a;
        r0 = "-l";
        r2 = r8;
        r4 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x005a;
    L_0x0101:
        r4.a(r2, r1);
        r1 = a;
        r0 = "-w";
        r2 = r7;
        r4 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x005a;
    L_0x010e:
        r4.a(r2, r1);
        r1 = a;
        r0 = "-f";
        r2 = r9;
        r4 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x005a;
    L_0x011b:
        r4[r2] = r1;
        r1 = b;
        r0 = "\rW-\u001b\u0001\u001eK-\nn\u001eG:\u001c\u001c\bQ";
        r2 = r7;
        r4 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0091;
    L_0x0127:
        r4[r2] = r1;
        r1 = b;
        r0 = "\rF=\u001a\u001a\u0005M7\u0012\u0002lP<\u0010\u0001\u001eF*";
        r2 = r9;
        r4 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0091;
    L_0x0133:
        r4[r2] = r1;
        r1 = c;
        r0 = "\u0016M7\u0016";
        r2 = r3;
        r4 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0091;
    L_0x013f:
        r4[r2] = r1;
        r1 = c;
        r0 = "\u001cP<\u0001\u000b\u001dW0\u0000\u0007\u0018G*";
        r2 = r8;
        r4 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0091;
    L_0x014b:
        r4[r2] = r1;
        r2 = c;
        r1 = "\u0019R=\u0012\u001a\t\"+\u0016\r\u0003P=\u0000";
        r0 = 5;
        r4 = r2;
        r2 = r7;
        goto L_0x0091;
    L_0x0156:
        r4[r2] = r1;
        r2 = c;
        r1 = "\rF=\u001a\u001a\u0005M7\u0012\u0002lP<\u0010\u0001\u001eF*";
        r0 = 6;
        r4 = r2;
        r2 = r9;
        goto L_0x0091;
    L_0x0161:
        r4[r2] = r1;
        return;
    L_0x0164:
        r6 = r3;
        goto L_0x00c0;
    L_0x0167:
        r6 = r3;
        goto L_0x00e6;
    L_0x016a:
        r2 = r3;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.q.<clinit>():void");
    }

    public static String a(int i) {
        return a.b(i);
    }
}
