package cn.jiguang.a.a.d.a.a;

import cn.jiguang.d.c;

final class b implements Runnable {
    private static final String z;
    final /* synthetic */ Object a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = "<RZ9v1Si(g6QA?j\u000bOZ.r;";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        r3 = 1;
        if (r1 > r3) goto L_0x0027;
    L_0x000b:
        r3 = r0;
        r4 = r2;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0010:
        r6 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x0035;
            case 1: goto L_0x0038;
            case 2: goto L_0x003b;
            case 3: goto L_0x003e;
            default: goto L_0x0017;
        };
    L_0x0017:
        r5 = 19;
    L_0x0019:
        r5 = r5 ^ r6;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x0010;
    L_0x0025:
        r1 = r0;
        r0 = r3;
    L_0x0027:
        if (r1 > r2) goto L_0x000b;
    L_0x0029:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        z = r0;
        return;
    L_0x0035:
        r5 = 95;
        goto L_0x0019;
    L_0x0038:
        r5 = 39;
        goto L_0x0019;
    L_0x003b:
        r5 = 40;
        goto L_0x0019;
    L_0x003e:
        r5 = 75;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.d.a.a.b.<clinit>():void");
    }

    b(Object obj) {
        this.a = obj;
    }

    public final void run() {
        try {
            a.a = c.a(a.b(), z, new Object[0]);
            synchronized (this.a) {
                this.a.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
            synchronized (this.a) {
                this.a.notify();
            }
        } catch (Throwable th) {
            synchronized (this.a) {
                this.a.notify();
            }
        }
    }
}
