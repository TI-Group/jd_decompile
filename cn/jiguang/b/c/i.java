package cn.jiguang.b.c;

import java.util.HashMap;

final class i {
    private static Integer[] a = new Integer[64];
    private static final String z;
    private HashMap b = new HashMap();
    private HashMap c = new HashMap();
    private String d;
    private int e = 3;
    private String f;
    private int g = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private boolean h;

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
        r7 = 64;
        r3 = 0;
        r0 = "%34\u0019\u00068`{\u0010S>!z\u0011\u0016";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 1;
        if (r1 > r2) goto L_0x0058;
    L_0x000d:
        r2 = r3;
    L_0x000e:
        r4 = r0;
        r5 = r2;
        r9 = r1;
        r1 = r0;
        r0 = r9;
    L_0x0013:
        r8 = r1[r2];
        r6 = r5 % 5;
        switch(r6) {
            case 0: goto L_0x004c;
            case 1: goto L_0x004f;
            case 2: goto L_0x0051;
            case 3: goto L_0x0054;
            default: goto L_0x001a;
        };
    L_0x001a:
        r6 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
    L_0x001c:
        r6 = r6 ^ r8;
        r6 = (char) r6;
        r1[r2] = r6;
        r2 = r5 + 1;
        if (r0 != 0) goto L_0x0028;
    L_0x0024:
        r1 = r4;
        r5 = r2;
        r2 = r0;
        goto L_0x0013;
    L_0x0028:
        r1 = r0;
        r0 = r4;
    L_0x002a:
        if (r1 > r2) goto L_0x000e;
    L_0x002c:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        z = r0;
        r0 = new java.lang.Integer[r7];
        a = r0;
    L_0x003b:
        r0 = a;
        r0 = r0.length;
        if (r3 >= r0) goto L_0x0057;
    L_0x0040:
        r0 = a;
        r1 = new java.lang.Integer;
        r1.<init>(r3);
        r0[r3] = r1;
        r3 = r3 + 1;
        goto L_0x003b;
    L_0x004c:
        r6 = 76;
        goto L_0x001c;
    L_0x004f:
        r6 = r7;
        goto L_0x001c;
    L_0x0051:
        r6 = 20;
        goto L_0x001c;
    L_0x0054:
        r6 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        goto L_0x001c;
    L_0x0057:
        return;
    L_0x0058:
        r2 = r3;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.i.<clinit>():void");
    }

    public i(String str, int i) {
        this.d = str;
    }

    private static Integer c(int i) {
        return (i < 0 || i >= a.length) ? new Integer(i) : a[i];
    }

    private void d(int i) {
        if (i < 0 || i > this.g) {
            throw new IllegalArgumentException(this.d + " " + i + z);
        }
    }

    public final void a(int i) {
        this.g = 3;
    }

    public final void a(int i, String str) {
        Object toUpperCase;
        d(i);
        Integer c = c(i);
        if (this.e == 2) {
            toUpperCase = str.toUpperCase();
        } else if (this.e == 3) {
            toUpperCase = str.toLowerCase();
        }
        this.b.put(toUpperCase, c);
        this.c.put(c, toUpperCase);
    }

    public final void a(boolean z) {
        this.h = true;
    }

    public final String b(int i) {
        d(i);
        String str = (String) this.c.get(c(i));
        if (str != null) {
            return str;
        }
        str = Integer.toString(i);
        return this.f != null ? this.f + str : str;
    }
}
