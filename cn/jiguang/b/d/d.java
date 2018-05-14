package cn.jiguang.b.d;

import java.net.InetAddress;

final class d extends Thread {
    private static final String[] z;
    private String a = null;
    private InetAddress b = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 5;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "}p:\u0004J|yo\u0010N5tj\u0012NtgiB_z5r\u0003]p5x\u0007N{5{BGtvqBDs5S,PGT'54";
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
            case 0: goto L_0x0060;
            case 1: goto L_0x0063;
            case 2: goto L_0x0066;
            case 3: goto L_0x0069;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 98;
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
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "hz{t\u0007Ha|t\u0005cpyj\u0007Y";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "Ypfu\u000e]pq:&eF57BCzfnX";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "~{~t\r\\{5r\rXa5\u001aHpen\u000bD{4";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "ypfu\u000e]pq:&eF5|\u0003By5|\u0010Dx5r\rXa/:";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0060:
        r9 = 43;
        goto L_0x001f;
    L_0x0063:
        r9 = 21;
        goto L_0x001f;
    L_0x0066:
        r9 = 21;
        goto L_0x001f;
    L_0x0069:
        r9 = 26;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.d.<clinit>():void");
    }

    public d(String str) {
        this.a = str;
    }

    public final synchronized InetAddress a() {
        InetAddress inetAddress;
        if (this.b != null) {
            inetAddress = this.b;
        } else {
            cn.jiguang.c.d.g(z[1], new StringBuilder(z[4]).append(this.a).toString());
            inetAddress = null;
        }
        return inetAddress;
    }

    public final void run() {
        try {
            cn.jiguang.c.d.e(z[1], new StringBuilder(z[2]).append(this.a).toString());
            this.b = InetAddress.getByName(this.a);
        } catch (Throwable e) {
            cn.jiguang.c.d.d(z[1], z[3], e);
        } catch (Throwable e2) {
            cn.jiguang.c.d.d(z[1], z[0], e2);
        }
    }
}
