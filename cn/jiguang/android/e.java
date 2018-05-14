package cn.jiguang.android;

import java.io.Serializable;
import java.util.HashSet;

final class e implements Serializable {
    static e b = new e(1);
    static e c = new e(2);
    static e d = new e(3);
    static e e = new e(4);
    static e f = new e(5);
    static e g = new e(6);
    static e h = new e(0);
    private static final String[] z;
    int a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 8;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "@vU3\\@|\u0003&IY}";
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
            case 0: goto L_0x00b1;
            case 1: goto L_0x00b5;
            case 2: goto L_0x00b9;
            case 3: goto L_0x00bd;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 48;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "gmO>\u0010EwM5";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "gmO>\u0010OtL3D";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "gmO>\u0010KwL>UHv";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "gmO>\u0010zlQ;^N8L \u0010zlQ;^NKF&";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "gmO>\u0010zlQ;^NKF&";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "gmO>\u0010@vW";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "gmO>\u0010zlQ;^N";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        z = r4;
        r0 = new cn.jiguang.android.e;
        r1 = 1;
        r0.<init>(r1);
        b = r0;
        r0 = new cn.jiguang.android.e;
        r1 = 2;
        r0.<init>(r1);
        c = r0;
        r0 = new cn.jiguang.android.e;
        r1 = 3;
        r0.<init>(r1);
        d = r0;
        r0 = new cn.jiguang.android.e;
        r1 = 4;
        r0.<init>(r1);
        e = r0;
        r0 = new cn.jiguang.android.e;
        r1 = 5;
        r0.<init>(r1);
        f = r0;
        r0 = new cn.jiguang.android.e;
        r1 = 6;
        r0.<init>(r1);
        g = r0;
        r0 = new cn.jiguang.android.e;
        r1 = 0;
        r0.<init>(r1);
        h = r0;
        return;
    L_0x00b1:
        r9 = 41;
        goto L_0x0020;
    L_0x00b5:
        r9 = 24;
        goto L_0x0020;
    L_0x00b9:
        r9 = 35;
        goto L_0x0020;
    L_0x00bd:
        r9 = 82;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.android.e.<clinit>():void");
    }

    private e(int i) {
        this.a = i;
    }

    public static e a(int i) {
        switch (i) {
            case 0:
                return h;
            case 1:
                return b;
            case 2:
                return c;
            case 3:
                return d;
            case 4:
                return e;
            case 5:
                return f;
            case 6:
                return g;
            default:
                throw new IllegalArgumentException(z[0]);
        }
    }

    static /* synthetic */ e a(Serializable serializable) {
        return serializable instanceof String ? b : serializable instanceof Integer ? c : serializable instanceof Boolean ? d : serializable instanceof Long ? e : serializable instanceof Float ? f : serializable instanceof HashSet ? g : serializable instanceof e ? (e) serializable : h;
    }

    public final String toString() {
        switch (this.a) {
            case 0:
                return z[4];
            case 1:
                return z[7];
            case 2:
                return z[6];
            case 3:
                return z[3];
            case 4:
                return z[1];
            case 5:
                return z[2];
            case 6:
                return z[5];
            default:
                return super.toString();
        }
    }
}
