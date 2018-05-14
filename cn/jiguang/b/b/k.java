package cn.jiguang.b.b;

final class k {
    private static final String[] z;
    String a;
    int b;

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
        r13 = 79;
        r3 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 4;
        r5 = new java.lang.String[r0];
        r4 = ". \u0015\u0017o\u0017<G\r*\u001b+\u0002\u0007o\u0018 \u0015C.^9\u0006\u000f&\u001ao\u0006\u0007+\f*\u0014\u0010c^<\u0017\u000f&\no\u0005\u001aoD";
        r0 = -1;
        r6 = r5;
        r7 = r5;
        r5 = r1;
    L_0x000e:
        r4 = r4.toCharArray();
        r8 = r4.length;
        if (r8 > r2) goto L_0x006b;
    L_0x0015:
        r9 = r1;
    L_0x0016:
        r10 = r4;
        r11 = r9;
        r15 = r8;
        r8 = r4;
        r4 = r15;
    L_0x001b:
        r14 = r8[r9];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x0060;
            case 1: goto L_0x0063;
            case 2: goto L_0x0065;
            case 3: goto L_0x0068;
            default: goto L_0x0022;
        };
    L_0x0022:
        r12 = r13;
    L_0x0023:
        r12 = r12 ^ r14;
        r12 = (char) r12;
        r8[r9] = r12;
        r9 = r11 + 1;
        if (r4 != 0) goto L_0x002f;
    L_0x002b:
        r8 = r10;
        r11 = r9;
        r9 = r4;
        goto L_0x001b;
    L_0x002f:
        r8 = r4;
        r4 = r10;
    L_0x0031:
        if (r8 > r9) goto L_0x0016;
    L_0x0033:
        r8 = new java.lang.String;
        r8.<init>(r4);
        r4 = r8.intern();
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0051;
            case 2: goto L_0x005b;
            default: goto L_0x003f;
        };
    L_0x003f:
        r6[r5] = r4;
        r0 = "7!\u0011\u0002#\u0017+G\u0013 \f;GNoN";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000e;
    L_0x0048:
        r6[r5] = r4;
        r0 = "7!\u0011\u0002#\u0017+G\n?^bG";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000e;
    L_0x0051:
        r6[r5] = r4;
        r4 = 3;
        r0 = "7!\u0011\u0002#\u0017+G\u0013 \f;GNo";
        r5 = r4;
        r6 = r7;
        r4 = r0;
        r0 = r3;
        goto L_0x000e;
    L_0x005b:
        r6[r5] = r4;
        z = r7;
        return;
    L_0x0060:
        r12 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        goto L_0x0023;
    L_0x0063:
        r12 = r13;
        goto L_0x0023;
    L_0x0065:
        r12 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x0023;
    L_0x0068:
        r12 = 99;
        goto L_0x0023;
    L_0x006b:
        r9 = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.b.k.<clinit>():void");
    }

    public k(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            throw new Exception(z[0]);
        }
        this.a = str.substring(0, indexOf);
        if (j.c(this.a)) {
            String substring = str.substring(indexOf + 1);
            try {
                this.b = Integer.parseInt(substring);
                if (this.b == 0) {
                    throw new Exception(z[1]);
                }
                return;
            } catch (Exception e) {
                throw new Exception(new StringBuilder(z[3]).append(substring).toString());
            }
        }
        throw new Exception(new StringBuilder(z[2]).append(this.a).toString());
    }

    public final String toString() {
        return this.a + ":" + this.b;
    }
}
