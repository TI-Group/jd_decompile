package cn.jiguang.net;

public class HttpConstants {
    public static final String CACHE_CONTROL;
    public static final String EXPIRES;
    public static final int NET_ERROR_CODE = 2998;
    public static final int NET_MALTFORMED_ERROR = 3004;
    public static final int NET_SSL_EXECPTION = 3005;
    public static final int NET_TIMEOUT_CODE = 3001;
    public static final int NET_UNKNOW_HOST = 3003;
    public static final int STACK_OVER_EXECPTION = 3007;
    public static final int UNKNOW_EXECPTION = 3006;

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
        r1 = 0;
        r2 = "\u0003\u0006s\u0004\nM\u0004\u0002\u001b\u0012\b|";
        r0 = -1;
    L_0x0004:
        r2 = r2.toCharArray();
        r3 = r2.length;
        r4 = 1;
        if (r3 > r4) goto L_0x004d;
    L_0x000c:
        r4 = r1;
    L_0x000d:
        r5 = r2;
        r6 = r4;
        r9 = r3;
        r3 = r2;
        r2 = r9;
    L_0x0012:
        r8 = r3[r4];
        r7 = r6 % 5;
        switch(r7) {
            case 0: goto L_0x0041;
            case 1: goto L_0x0044;
            case 2: goto L_0x0047;
            case 3: goto L_0x004a;
            default: goto L_0x0019;
        };
    L_0x0019:
        r7 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
    L_0x001b:
        r7 = r7 ^ r8;
        r7 = (char) r7;
        r3[r4] = r7;
        r4 = r6 + 1;
        if (r2 != 0) goto L_0x0027;
    L_0x0023:
        r3 = r5;
        r6 = r4;
        r4 = r2;
        goto L_0x0012;
    L_0x0027:
        r3 = r2;
        r2 = r5;
    L_0x0029:
        if (r3 > r4) goto L_0x000d;
    L_0x002b:
        r3 = new java.lang.String;
        r3.<init>(r2);
        r2 = r3.intern();
        switch(r0) {
            case 0: goto L_0x003e;
            default: goto L_0x0037;
        };
    L_0x0037:
        CACHE_CONTROL = r2;
        r0 = "\u0005\u001f`\u0005\u001d\u0005\u0014";
        r2 = r0;
        r0 = r1;
        goto L_0x0004;
    L_0x003e:
        EXPIRES = r2;
        return;
    L_0x0041:
        r7 = 96;
        goto L_0x001b;
    L_0x0044:
        r7 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x001b;
    L_0x0047:
        r7 = 16;
        goto L_0x001b;
    L_0x004a:
        r7 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        goto L_0x001b;
    L_0x004d:
        r4 = r1;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.net.HttpConstants.<clinit>():void");
    }
}
