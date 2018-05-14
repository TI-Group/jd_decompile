package cn.jiguang.b.c;

import android.support.v4.internal.view.SupportMenu;
import java.util.Random;

public final class g implements Cloneable {
    private static Random d = new Random();
    private static final String[] z;
    private int a;
    private int b;
    private int[] c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "pCC\u001bn|";
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
            case 0: goto L_0x0077;
            case 1: goto L_0x007a;
            case 2: goto L_0x007d;
            case 3: goto L_0x0080;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 84;
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
        r1 = "gC";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "fC";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "gX\nRjb+o>\u0010\u00191\u0016Cy|";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "|\nY_;)\u0017\n\u00102|\u0011K\u001139";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0018-y_99\u0010Y\u001e39Cc;t";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0018-y_'9\u0000^\u0016;2CI\u0010!2\u0017\n\u001c52\rE\u000bt>\u0006\n\u0016:?\u0011O\u001212\u0017O\u001b";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        r0 = new java.util.Random;
        r0.<init>();
        d = r0;
        return;
    L_0x0077:
        r9 = 92;
        goto L_0x001f;
    L_0x007a:
        r9 = 99;
        goto L_0x001f;
    L_0x007d:
        r9 = 42;
        goto L_0x001f;
    L_0x0080:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.g.<clinit>():void");
    }

    public g() {
        this.b = 256;
        b();
    }

    private g(int i) {
        this.b = 256;
        b();
        if (i < 0 || i > SupportMenu.USER_MASK) {
            throw new IllegalArgumentException(new StringBuilder(z[5]).append(i).append(z[4]).toString());
        }
        this.a = i;
    }

    g(d dVar) {
        this(dVar.g());
        this.b = dVar.g();
        for (int i = 0; i < this.c.length; i++) {
            this.c[i] = dVar.g();
        }
    }

    private void b() {
        this.c = new int[4];
        this.b = 256;
        this.a = -1;
    }

    private int c() {
        if (this.a >= 0) {
            return this.a;
        }
        int i;
        synchronized (this) {
            if (this.a < 0) {
                this.a = d.nextInt(SupportMenu.USER_MASK);
            }
            i = this.a;
        }
        return i;
    }

    final int a() {
        return this.b;
    }

    final void a(int i) {
        if (this.c[i] == 65535) {
            throw new IllegalStateException(z[6]);
        }
        int[] iArr = this.c;
        iArr[i] = iArr[i] + 1;
    }

    final void a(e eVar) {
        eVar.c(c());
        eVar.c(this.b);
        for (int c : this.c) {
            eVar.c(c);
        }
    }

    public final int b(int i) {
        return this.c[i];
    }

    public final Object clone() {
        g gVar = new g();
        gVar.a = this.a;
        gVar.b = this.b;
        System.arraycopy(this.c, 0, gVar.c, 0, this.c.length);
        return gVar;
    }

    public final String toString() {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(z[3]);
        stringBuffer.append(new StringBuilder(z[0]).append(c()).toString());
        stringBuffer.append("\n");
        stringBuffer.append(z[1]);
        while (i < 4) {
            stringBuffer.append(q.a(i) + z[2] + this.c[i] + " ");
            i++;
        }
        return stringBuffer.toString();
    }
}
