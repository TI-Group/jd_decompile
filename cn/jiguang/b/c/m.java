package cn.jiguang.b.c;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class m implements Serializable, Cloneable, Comparable {
    private static final DecimalFormat e;
    private static final String[] z;
    protected j a;
    protected int b;
    protected int c;
    protected long d;

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
        r4 = 1;
        r1 = 0;
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = "KP<)!^V,#bMG*(0[";
        r0 = -1;
        r5 = r3;
        r6 = r3;
        r3 = r1;
    L_0x000b:
        r2 = r2.toCharArray();
        r7 = r2.length;
        if (r7 > r4) goto L_0x0062;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r2;
        r10 = r8;
        r13 = r7;
        r7 = r2;
        r2 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x0056;
            case 1: goto L_0x0059;
            case 2: goto L_0x005c;
            case 3: goto L_0x005f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 66;
    L_0x0021:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r2 != 0) goto L_0x002d;
    L_0x0029:
        r7 = r9;
        r10 = r8;
        r8 = r2;
        goto L_0x0018;
    L_0x002d:
        r7 = r2;
        r2 = r9;
    L_0x002f:
        if (r7 > r8) goto L_0x0013;
    L_0x0031:
        r7 = new java.lang.String;
        r7.<init>(r2);
        r2 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0046;
            default: goto L_0x003d;
        };
    L_0x003d:
        r5[r3] = r2;
        r0 = "VL?&.VFi5'\\M;#bSG' 6W";
        r2 = r0;
        r3 = r4;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r3] = r2;
        z = r6;
        r0 = new java.text.DecimalFormat;
        r0.<init>();
        e = r0;
        r1 = 3;
        r0.setMinimumIntegerDigits(r1);
        return;
    L_0x0056:
        r11 = 63;
        goto L_0x0021;
    L_0x0059:
        r11 = 34;
        goto L_0x0021;
    L_0x005c:
        r11 = 73;
        goto L_0x0021;
    L_0x005f:
        r11 = 71;
        goto L_0x0021;
    L_0x0062:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.m.<clinit>():void");
    }

    protected m() {
    }

    static m a(d dVar, int i) {
        j jVar = new j(dVar);
        int g = dVar.g();
        int g2 = dVar.g();
        if (i == 0) {
            return a(jVar, g, g2);
        }
        long h = dVar.h();
        int g3 = dVar.g();
        m a = a(jVar, g, g2, h);
        if (dVar == null) {
            return a;
        }
        if (dVar.b() < g3) {
            throw new t(z[0]);
        }
        dVar.a(g3);
        a.a(dVar);
        if (dVar.b() > 0) {
            throw new t(z[1]);
        }
        dVar.c();
        return a;
    }

    public static m a(j jVar, int i, int i2) {
        if (jVar.a()) {
            return a(jVar, i, i2, 0);
        }
        throw new n(jVar);
    }

    private static final m a(j jVar, int i, int i2, long j) {
        m pVar = new p();
        pVar.a = jVar;
        pVar.b = i;
        pVar.c = i2;
        pVar.d = j;
        return pVar;
    }

    private byte[] h() {
        e eVar = new e();
        a(eVar, true);
        return eVar.b();
    }

    abstract String a();

    final void a(long j) {
        this.d = j;
    }

    abstract void a(d dVar);

    final void a(e eVar, b bVar) {
        this.a.a(eVar, bVar);
        eVar.c(this.b);
        eVar.c(this.c);
    }

    abstract void a(e eVar, boolean z);

    public final boolean a(m mVar) {
        return this.b == mVar.b && this.c == mVar.c && this.a.equals(mVar.a);
    }

    public final j b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public int compareTo(Object obj) {
        int i = 0;
        m mVar = (m) obj;
        if (this == mVar) {
            return 0;
        }
        int compareTo = this.a.compareTo(mVar.a);
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this.c - mVar.c;
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = this.b - mVar.b;
        if (compareTo != 0) {
            return compareTo;
        }
        byte[] h = h();
        byte[] h2 = mVar.h();
        while (i < h.length && i < h2.length) {
            compareTo = (h[i] & 255) - (h2[i] & 255);
            if (compareTo != 0) {
                return compareTo;
            }
            i++;
        }
        return h.length - h2.length;
    }

    public final int d() {
        return this.b;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return (this.b == mVar.b && this.c == mVar.c && this.a.equals(mVar.a)) ? Arrays.equals(h(), mVar.h()) : false;
    }

    public final long f() {
        return this.d;
    }

    final m g() {
        try {
            return (m) clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException();
        }
    }

    public int hashCode() {
        int i = 0;
        e eVar = new e();
        this.a.a(eVar);
        eVar.c(this.b);
        eVar.c(this.c);
        eVar.a(0);
        int a = eVar.a();
        eVar.c(0);
        a(eVar, true);
        eVar.a((eVar.a() - a) - 2, a);
        byte[] b = eVar.b();
        int i2 = 0;
        while (i < b.length) {
            i2 += (i2 << 3) + (b[i] & 255);
            i++;
        }
        return i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.a);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        String a = a();
        if (!a.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(a);
        }
        return stringBuffer.toString();
    }
}
