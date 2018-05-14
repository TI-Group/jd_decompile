package cn.jiguang.b.c;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class l implements Serializable {
    private static final String[] z;
    private List a;
    private short b;
    private short c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 6;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "Cu";
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
            case 0: goto L_0x0068;
            case 1: goto L_0x006b;
            case 2: goto L_0x006e;
            case 3: goto L_0x0071;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 78;
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
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0018&Ip=\u0002u";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "C0Mg:A(";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0018(";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "J'Sr:\u0018<S7+U%Tn";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "J0Cx<\\uDx+KuNx:\u00188Ac-PuRe=]!";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0068:
        r9 = 56;
        goto L_0x001f;
    L_0x006b:
        r9 = 85;
        goto L_0x001f;
    L_0x006e:
        r9 = 32;
        goto L_0x001f;
    L_0x0071:
        r9 = 23;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.l.<clinit>():void");
    }

    public l() {
        this.a = new ArrayList(1);
        this.b = (short) 0;
        this.c = (short) 0;
    }

    public l(m mVar) {
        this();
        b(mVar);
    }

    private static String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            stringBuffer.append("[");
            stringBuffer.append(mVar.a());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private synchronized Iterator a(boolean z, boolean z2) {
        Iterator it;
        int i = 0;
        synchronized (this) {
            int size = this.a.size();
            short s = z ? size - this.b : this.b;
            if (s == (short) 0) {
                it = Collections.EMPTY_LIST.iterator();
            } else {
                if (!z) {
                    i = size - this.b;
                } else if (z2) {
                    if (this.c >= s) {
                        this.c = (short) 0;
                    }
                    i = this.c;
                    this.c = (short) (i + 1);
                }
                List arrayList = new ArrayList(s);
                if (z) {
                    arrayList.addAll(this.a.subList(i, s));
                    if (i != 0) {
                        arrayList.addAll(this.a.subList(0, i));
                    }
                } else {
                    arrayList.addAll(this.a.subList(i, size));
                }
                it = arrayList.iterator();
            }
        }
        return it;
    }

    private void b(m mVar) {
        if (this.b == (short) 0) {
            this.a.add(mVar);
        } else {
            this.a.add(this.a.size() - this.b, mVar);
        }
    }

    private synchronized long c() {
        return b().f();
    }

    public final synchronized Iterator a() {
        return a(true, true);
    }

    public final synchronized void a(m mVar) {
        if (this.a.size() == 0) {
            b(mVar);
        } else {
            m b = b();
            if (mVar.a(b)) {
                if (mVar.f() != b.f()) {
                    if (mVar.f() > b.f()) {
                        mVar = mVar.g();
                        mVar.a(b.f());
                    } else {
                        for (int i = 0; i < this.a.size(); i++) {
                            b = ((m) this.a.get(i)).g();
                            b.a(mVar.f());
                            this.a.set(i, b);
                        }
                    }
                }
                if (!this.a.contains(mVar)) {
                    b(mVar);
                }
            } else {
                throw new IllegalArgumentException(z[5]);
            }
        }
    }

    public final synchronized m b() {
        if (this.a.size() == 0) {
            throw new IllegalStateException(z[4]);
        }
        return (m) this.a.get(0);
    }

    public final String toString() {
        if (this.a.size() == 0) {
            return z[2];
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(z[0]);
        stringBuffer.append(b().b() + " ");
        stringBuffer.append(c() + " ");
        stringBuffer.append(a(a(true, false)));
        if (this.b > (short) 0) {
            stringBuffer.append(z[1]);
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(z[3]);
        return stringBuffer.toString();
    }
}
