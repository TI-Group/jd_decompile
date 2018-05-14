package cn.jiguang.b.c;

import android.support.v4.media.TransportMediator;
import java.io.Serializable;
import java.text.DecimalFormat;
import jd.wjlogin_sdk.util.ReplyCode;
import org.apache.commons.lang.ClassUtils;

public final class j implements Serializable, Comparable {
    public static final j a;
    public static final j b;
    private static final byte[] f = new byte[]{(byte) 0};
    private static final byte[] g = new byte[]{(byte) 1, (byte) 42};
    private static final DecimalFormat h = new DecimalFormat();
    private static final byte[] i = new byte[256];
    private static final j j;
    private static final String[] z;
    private byte[] c;
    private long d;
    private int e;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 12;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "!#Xb\u000b\u001b-Z'G\u0000,R";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002e;
    L_0x0012:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0017:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x00db;
            case 1: goto L_0x00df;
            case 2: goto L_0x00e3;
            case 3: goto L_0x00e7;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 43;
    L_0x0020:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0017;
    L_0x002c:
        r5 = r1;
        r1 = r7;
    L_0x002e:
        if (r5 > r6) goto L_0x0012;
    L_0x0030:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x004c;
            case 2: goto L_0x0054;
            case 3: goto L_0x005c;
            case 4: goto L_0x0064;
            case 5: goto L_0x006c;
            case 6: goto L_0x0074;
            case 7: goto L_0x007d;
            case 8: goto L_0x0087;
            case 9: goto L_0x0092;
            case 10: goto L_0x009d;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u000e6AbF\u001f6Pc\u000b\u001b-\u0015uN\u0002-Cb\u000b\u001b-Z'F\u000e,L'G\u000e PkX";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0006,CfG\u0006&\u0015kJ\r'Y";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0003#WbGO-@s\u000b\u0000$\u0015uJ\u0001%P";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0003#WbGO6Zh\u000b\u0003-[`";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\r#Q'N\u001c!TwN";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0006,CfG\u0006&\u0015bF\u001f6L'G\u000e Pk";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\n/EsRO,TjN";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u001b-Z'F\u000e,L'G\u000e PkX";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\r#Q'G\u000e Pk\u000b\u001b;Eb";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\r#Q'H\u0000/EuN\u001c1\\hE";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "Hx\u0015";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        z = r4;
        r0 = 1;
        r0 = new byte[r0];
        r1 = 0;
        r2 = 0;
        r0[r1] = r2;
        f = r0;
        r0 = 2;
        r0 = new byte[r0];
        r0 = {1, 42};
        g = r0;
        r0 = new java.text.DecimalFormat;
        r0.<init>();
        h = r0;
        r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0 = new byte[r0];
        i = r0;
        r0 = h;
        r1 = 3;
        r0.setMinimumIntegerDigits(r1);
        r0 = 0;
    L_0x00c6:
        r1 = i;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x00f4;
    L_0x00cb:
        r1 = 65;
        if (r0 < r1) goto L_0x00d3;
    L_0x00cf:
        r1 = 90;
        if (r0 <= r1) goto L_0x00ea;
    L_0x00d3:
        r1 = i;
        r2 = (byte) r0;
        r1[r0] = r2;
    L_0x00d8:
        r0 = r0 + 1;
        goto L_0x00c6;
    L_0x00db:
        r9 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        goto L_0x0020;
    L_0x00df:
        r9 = 66;
        goto L_0x0020;
    L_0x00e3:
        r9 = 53;
        goto L_0x0020;
    L_0x00e7:
        r9 = 7;
        goto L_0x0020;
    L_0x00ea:
        r1 = i;
        r2 = r0 + -65;
        r2 = r2 + 97;
        r2 = (byte) r2;
        r1[r0] = r2;
        goto L_0x00d8;
    L_0x00f4:
        r0 = new cn.jiguang.b.c.j;
        r0.<init>();
        a = r0;
        r1 = f;
        r2 = 0;
        r3 = 1;
        r0.b(r1, r2, r3);
        r0 = new cn.jiguang.b.c.j;
        r0.<init>();
        b = r0;
        r1 = 0;
        r1 = new byte[r1];
        r0.c = r1;
        r0 = new cn.jiguang.b.c.j;
        r0.<init>();
        j = r0;
        r1 = g;
        r2 = 0;
        r3 = 1;
        r0.b(r1, r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.j.<clinit>():void");
    }

    private j() {
    }

    public j(d dVar) {
        byte[] bArr = new byte[64];
        int i = 0;
        int i2 = 0;
        while (i2 == 0) {
            int f = dVar.f();
            switch (f & 192) {
                case 0:
                    if (c() < 128) {
                        if (f != 0) {
                            bArr[0] = (byte) f;
                            dVar.a(bArr, 1, f);
                            a(bArr, 0, 1);
                            break;
                        }
                        a(f, 0, 1);
                        i2 = 1;
                        break;
                    }
                    throw new t(z[8]);
                case 192:
                    f = ((f & -193) << 8) + dVar.f();
                    if (f < dVar.a() - 2) {
                        if (i == 0) {
                            dVar.d();
                            i = 1;
                        }
                        dVar.b(f);
                        break;
                    }
                    throw new t(z[10]);
                default:
                    throw new t(z[9]);
            }
        }
        if (i != 0) {
            dVar.e();
        }
    }

    private j(j jVar, int i) {
        int c = jVar.c();
        if (i > c) {
            throw new IllegalArgumentException(z[1]);
        }
        this.c = jVar.c;
        b(c - i);
        int i2 = 0;
        while (i2 < 7 && i2 < c - i) {
            a(i2, jVar.a(i2 + i));
            i2++;
        }
    }

    private j(String str, j jVar) {
        if (str.equals("")) {
            throw a(str, z[7]);
        } else if (str.equals("@")) {
            if (jVar == null) {
                b(b, this);
            } else {
                b(jVar, this);
            }
        } else if (str.equals(".")) {
            b(a, this);
        } else {
            int i = -1;
            int i2 = 1;
            byte[] bArr = new byte[64];
            Object obj = null;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < str.length(); i5++) {
                byte charAt = (byte) str.charAt(i5);
                if (obj != null) {
                    byte b;
                    if (charAt >= (byte) 48 && charAt <= ReplyCode.reply0x39 && i3 < 3) {
                        i3++;
                        i4 = (i4 * 10) + (charAt - 48);
                        if (i4 > 255) {
                            throw a(str, z[5]);
                        } else if (i3 >= 3) {
                            b = (byte) i4;
                        } else {
                            continue;
                        }
                    } else if (i3 <= 0 || i3 >= 3) {
                        b = charAt;
                    } else {
                        throw a(str, z[5]);
                    }
                    if (i2 > 63) {
                        throw a(str, z[4]);
                    }
                    i = i2 + 1;
                    bArr[i2] = b;
                    obj = null;
                    int i6 = i;
                    i = i2;
                    i2 = i6;
                } else if (charAt == (byte) 92) {
                    obj = 1;
                    i3 = 0;
                    i4 = 0;
                } else if (charAt != (byte) 46) {
                    int i7 = i == -1 ? i5 : i;
                    if (i2 > 63) {
                        throw a(str, z[4]);
                    }
                    i = i2 + 1;
                    bArr[i2] = charAt;
                    i2 = i;
                    i = i7;
                } else if (i == -1) {
                    throw a(str, z[6]);
                } else {
                    bArr[0] = (byte) (i2 - 1);
                    a(str, bArr, 0, 1);
                    i = -1;
                    i2 = 1;
                }
            }
            if (i3 > 0 && i3 < 3) {
                throw a(str, z[5]);
            } else if (obj != null) {
                throw a(str, z[5]);
            } else {
                Object obj2;
                if (i == -1) {
                    a(str, f, 0, 1);
                    obj2 = 1;
                } else {
                    bArr[0] = (byte) (i2 - 1);
                    a(str, bArr, 0, 1);
                    obj2 = null;
                }
                if (jVar != null && r0 == null) {
                    a(str, jVar.c, jVar.a(0), jVar.c());
                }
            }
        }
    }

    private final int a(int i) {
        if (i == 0 && c() == 0) {
            return 0;
        }
        if (i < 0 || i >= c()) {
            throw new IllegalArgumentException(z[3]);
        } else if (i < 7) {
            return ((int) (this.d >>> ((7 - i) * 8))) & 255;
        } else {
            int a = a(6);
            int i2 = 6;
            while (i2 < i) {
                i2++;
                a = (this.c[a] + 1) + a;
            }
            return a;
        }
    }

    public static j a(j jVar, j jVar2) {
        if (jVar.a()) {
            return jVar;
        }
        j jVar3 = new j();
        b(jVar, jVar3);
        jVar3.a(jVar2.c, jVar2.a(0), jVar2.c());
        return jVar3;
    }

    public static j a(String str) {
        return a(str, null);
    }

    public static j a(String str, j jVar) {
        return (!str.equals("@") || jVar == null) ? str.equals(".") ? a : new j(str, jVar) : jVar;
    }

    private static s a(String str, String str2) {
        return new s("'" + str + z[11] + str2);
    }

    private static String a(byte[] bArr, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i + 1;
        byte b = bArr[i];
        for (int i3 = i2; i3 < i2 + b; i3++) {
            int i4 = bArr[i3] & 255;
            if (i4 <= 32 || i4 >= TransportMediator.KEYCODE_MEDIA_PAUSE) {
                stringBuffer.append('\\');
                stringBuffer.append(h.format((long) i4));
            } else if (i4 == 34 || i4 == 40 || i4 == 41 || i4 == 46 || i4 == 59 || i4 == 92 || i4 == 64 || i4 == 36) {
                stringBuffer.append('\\');
                stringBuffer.append((char) i4);
            } else {
                stringBuffer.append((char) i4);
            }
        }
        return stringBuffer.toString();
    }

    private final void a(int i, int i2) {
        if (i < 7) {
            int i3 = (7 - i) * 8;
            this.d &= (255 << i3) ^ -1;
            this.d = (((long) i2) << i3) | this.d;
        }
    }

    private final void a(String str, byte[] bArr, int i, int i2) {
        try {
            a(bArr, i, i2);
        } catch (k e) {
            throw a(str, z[0]);
        }
    }

    private final void a(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = 0;
        int length = this.c == null ? 0 : this.c.length - a(0);
        int i5 = i;
        int i6 = 0;
        for (i3 = 0; i3 < i2; i3++) {
            byte b = bArr[i5];
            if (b > (byte) 63) {
                throw new IllegalStateException(z[2]);
            }
            int i7 = b + 1;
            i5 += i7;
            i6 += i7;
        }
        i5 = length + i6;
        if (i5 > 255) {
            throw new k();
        }
        i3 = c();
        i7 = i3 + i2;
        if (i7 > 128) {
            throw new IllegalStateException(z[8]);
        }
        Object obj = new byte[i5];
        if (length != 0) {
            System.arraycopy(this.c, a(0), obj, 0, length);
        }
        System.arraycopy(bArr, i, obj, length, i6);
        this.c = obj;
        while (i4 < i2) {
            a(i3 + i4, length);
            length += obj[length] + 1;
            i4++;
        }
        b(i7);
    }

    private final void b(int i) {
        this.d &= -256;
        this.d |= (long) i;
    }

    private static final void b(j jVar, j jVar2) {
        int i = 0;
        if (jVar.a(0) == 0) {
            jVar2.c = jVar.c;
            jVar2.d = jVar.d;
            return;
        }
        int a = jVar.a(0);
        int length = jVar.c.length - a;
        int c = jVar.c();
        jVar2.c = new byte[length];
        System.arraycopy(jVar.c, a, jVar2.c, 0, length);
        while (i < c && i < 7) {
            jVar2.a(i, jVar.a(i) - a);
            i++;
        }
        jVar2.b(c);
    }

    private final void b(byte[] bArr, int i, int i2) {
        try {
            a(bArr, 0, 1);
        } catch (k e) {
        }
    }

    private final int c() {
        return (int) (this.d & 255);
    }

    public final void a(e eVar) {
        byte[] bArr;
        int c = c();
        if (c == 0) {
            bArr = new byte[0];
        } else {
            bArr = new byte[(this.c.length - a(0))];
            int a = a(0);
            int i = 0;
            for (int i2 = 0; i2 < c; i2++) {
                byte b = this.c[a];
                if (b > (byte) 63) {
                    throw new IllegalStateException(z[2]);
                }
                int i3 = i + 1;
                int i4 = a + 1;
                bArr[i] = this.c[a];
                a = i4;
                i4 = i3;
                byte b2 = (byte) 0;
                while (b2 < b) {
                    i = i4 + 1;
                    int i5 = a + 1;
                    bArr[i4] = i[this.c[a] & 255];
                    b2++;
                    i4 = i;
                    a = i5;
                }
                i = i4;
            }
        }
        eVar.a(bArr);
    }

    public final void a(e eVar, b bVar) {
        int c = c();
        int i = 0;
        while (i < c - 1) {
            j jVar = i == 0 ? this : new j(this, i);
            int i2 = -1;
            if (bVar != null) {
                i2 = bVar.a(jVar);
            }
            if (i2 >= 0) {
                eVar.c(i2 | 49152);
                return;
            }
            if (bVar != null) {
                bVar.a(eVar.a(), jVar);
            }
            i2 = a(i);
            eVar.a(this.c, i2, this.c[i2] + 1);
            i++;
        }
        eVar.b(0);
    }

    public final void a(e eVar, b bVar, boolean z) {
        if (z) {
            a(eVar);
        } else {
            a(eVar, null);
        }
    }

    public final boolean a() {
        int c = c();
        return c != 0 && this.c[a(c - 1)] == (byte) 0;
    }

    public final int b() {
        return c();
    }

    public final int compareTo(Object obj) {
        j jVar = (j) obj;
        if (this == jVar) {
            return 0;
        }
        int c = c();
        int c2 = jVar.c();
        int i = c > c2 ? c2 : c;
        for (int i2 = 1; i2 <= i; i2++) {
            int a = a(c - i2);
            int a2 = jVar.a(c2 - i2);
            byte b = this.c[a];
            byte b2 = jVar.c[a2];
            byte b3 = (byte) 0;
            while (b3 < b && b3 < b2) {
                int i3 = i[this.c[(b3 + a) + 1] & 255] - i[jVar.c[(b3 + a2) + 1] & 255];
                if (i3 != 0) {
                    return i3;
                }
                b3++;
            }
            if (b != b2) {
                return b - b2;
            }
        }
        return c - c2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.e == 0) {
            jVar.hashCode();
        }
        if (this.e == 0) {
            hashCode();
        }
        if (jVar.e != this.e) {
            return false;
        }
        if (jVar.c() != c()) {
            return false;
        }
        byte[] bArr = jVar.c;
        int a = jVar.a(0);
        int c = c();
        int a2 = a(0);
        for (int i = 0; i < c; i++) {
            if (this.c[a2] != bArr[a]) {
                return false;
            }
            int i2 = a2 + 1;
            byte b = this.c[a2];
            a2 = a + 1;
            if (b > (byte) 63) {
                throw new IllegalStateException(z[2]);
            }
            a = a2;
            a2 = i2;
            byte b2 = (byte) 0;
            while (b2 < b) {
                int i3 = a2 + 1;
                byte b3 = i[this.c[a2] & 255];
                a2 = a + 1;
                if (b3 != i[bArr[a] & 255]) {
                    return false;
                }
                b2++;
                a = a2;
                a2 = i3;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        if (this.e != 0) {
            return this.e;
        }
        for (int a = a(0); a < this.c.length; a++) {
            i += (i << 3) + i[this.c[a] & 255];
        }
        this.e = i;
        return this.e;
    }

    public final String toString() {
        int i = 0;
        int c = c();
        if (c == 0) {
            return "@";
        }
        if (c == 1 && this.c[a(0)] == (byte) 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int a = a(0);
        while (i < c) {
            byte b = this.c[a];
            if (b > (byte) 63) {
                throw new IllegalStateException(z[2]);
            } else if (b == (byte) 0) {
                stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                break;
            } else {
                if (i > 0) {
                    stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
                stringBuffer.append(a(this.c, a));
                a += b + 1;
                i++;
            }
        }
        return stringBuffer.toString();
    }
}
