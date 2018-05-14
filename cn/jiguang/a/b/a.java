package cn.jiguang.a.b;

import android.content.Context;
import cn.jiguang.b.a.d;

public final class a {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "D\u0014]\\\u0013M\u0006Aq\u0015w\u0018At";
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
            case 0: goto L_0x0070;
            case 1: goto L_0x0073;
            case 2: goto L_0x0076;
            case 3: goto L_0x0079;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 97;
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
        r1 = "Z\u0013^l\u0013\\)Bl\u0002I\u0002Gl\u000fw\u0010\\f\u0010]\u0013@`\u0018";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "D\u0014]\\\u0013M\u0006Aq\u0015w\u0013@b\u0003D\u0013";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "F\u0014qv\u0011D\u0019Og";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "F\u0003Ca\u0004Z)Os\u0011[\u0013Mq\u0004\\";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u001a\u0014\u00173\u0005MFH2\u0007\u0010NKb\u0007\u001cO\u001b:RNGJ;S\u001f\u0014\u001f:\u0002\u001eE";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "Z\u0013^l\u0013\\)Oq\u0011A\u0018Hl>N\u0004Kr\u0014M\u0018Mz";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0070:
        r9 = 40;
        goto L_0x001f;
    L_0x0073:
        r9 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        goto L_0x001f;
    L_0x0076:
        r9 = 46;
        goto L_0x001f;
    L_0x0079:
        r9 = 3;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.b.a.<clinit>():void");
    }

    public static long a(Context context) {
        long longValue = ((Long) d.b(context, z[1], Long.valueOf(3600000))).longValue();
        return longValue > 0 ? longValue : 3600000;
    }

    public static void a(Context context, boolean z) {
        d.a(context, z[2], Boolean.valueOf(z));
    }

    public static String b(Context context) {
        return cn.jiguang.b.a.a.b(context, z[4], z[5]);
    }

    public static void b(Context context, boolean z) {
        d.a(context, z[0], Boolean.valueOf(z));
    }

    public static long c(Context context) {
        return ((Long) d.b(context, z[6], Long.valueOf(0))).longValue();
    }

    public static void c(Context context, boolean z) {
        d.a(context, z[3], Boolean.valueOf(z));
    }
}
