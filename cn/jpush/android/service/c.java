package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a.j;
import cn.jpush.android.b;
import cn.jpush.android.c.f;
import cn.jpush.android.d.e;
import cn.jpush.android.data.JPushLocalNotification;

/* compiled from: TbsSdkJava */
public final class c {
    private static c b;
    private static final String[] z;
    private Context a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 23;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "T\tl91e\u000ba<r\u0002v.6b\u0002$9<u\u000ek6,G";
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
            case 0: goto L_0x011b;
            case 1: goto L_0x011e;
            case 2: goto L_0x0122;
            case 3: goto L_0x0125;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 95;
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
            case 11: goto L_0x00a8;
            case 12: goto L_0x00b3;
            case 13: goto L_0x00be;
            case 14: goto L_0x00c9;
            case 15: goto L_0x00d4;
            case 16: goto L_0x00df;
            case 17: goto L_0x00ea;
            case 18: goto L_0x00f5;
            case 19: goto L_0x0100;
            case 20: goto L_0x010b;
            case 21: goto L_0x0116;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "l\u0012h,6^\u0013}(:";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "b\t*2/t\u0014lv>o\u0003v76eIm6+d\tpv/m\u0012c11/\u0017h9+g\bv5qS\"B\n\u001aR4L\u0007\rD M\u001c";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "r\u000eh=1b\u0002[(*r\u000f[,6l\u0002";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "o\bp19h\u0004e,6n\t[:*h\u0003h=-^\u000e`";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "R\u0002v.6b\u0002$:*o\u0003h=,G";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "o\bp19h\u0004e,6n\t[:*h\u0003h=-";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "r\u0002v.6b\u0002[++n\u0017a<";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "c\u0012j<3d]";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "n\tE;+h\bj\n*oGf-1e\u000bax6rGj-3m";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "o\bp19h\u0004e,6n\t[1;";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "`\u0004p10o";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "b\t*2/t\u0014lv>o\u0003v76eIm6+d\tpv\fU(T\b\nR/";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "o\bp19h\u0004e,6n\t[5>y\tq5";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "b\t*2/t\u0014lv>o\u0003v76eIm6+d\tpv\rD4P\u0017\rD7Q\u000b\u0017";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "b\t*2/t\u0014lv>o\u0003v76eIm6+d\tpv\u0012T+P\u0011\u0000Q5K\u001b\u001aR4";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "b\t*2/t\u0014lv>o\u0003v76eIm6+d\tpv\u001eM.E\u000b\u0000U&C\u000b";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "d\te:3d8t-,i8p12d";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "m\bg93^\tk,6g\u000eg9+h\bj\u00076e";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "m\bg93^\tk,6g\u000eg9+h\bj";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "@\u0004p10oG)x7`\t`4:R\u0002v.6b\u0002E;+h\bjxr!\u0006g,6n\t>";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "Q\u0012w0\fd\u0015r1<d$k*:";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "I\u0006j<3dGe;+h\bjx9n\u0015$5*m\u0013mx+x\u0017axe!";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x011b:
        r9 = 1;
        goto L_0x0020;
    L_0x011e:
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x0020;
    L_0x0122:
        r9 = 4;
        goto L_0x0020;
    L_0x0125:
        r9 = 88;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.c.<clinit>():void");
    }

    private c(Context context) {
        this.a = context;
    }

    public static c a(Context context) {
        if (b == null) {
            b = new c(context);
        }
        return b;
    }

    public final void a() {
        a.a(this.a).d(this.a);
    }

    public final void a(Bundle bundle, Handler handler) {
        e.d(z[21], new StringBuilder(z[8]).append(bundle != null ? bundle.toString() : "").toString());
        if (bundle != null) {
            e.a(z[21], new StringBuilder(z[5]).append(bundle.toString()).toString());
            String string = bundle.getString(z[11]);
            if (string != null && bundle != null) {
                e.d(z[21], new StringBuilder(z[20]).append(string).toString());
                if (z[15].equals(string)) {
                    int i = bundle.getInt(z[1]);
                    e.a(z[21], new StringBuilder(z[22]).append(i).toString());
                    switch (i) {
                        case 1:
                            b.a(this.a, bundle.getString(z[4]), bundle.getString(z[6]), true);
                            return;
                        case 2:
                            b.a(this.a, bundle.getInt(z[13]), true);
                            return;
                        case 3:
                            b.b(this.a, bundle.getString(z[17]), true);
                            return;
                        case 4:
                            b.a(this.a, bundle.getString(z[3]), true);
                            return;
                        case 6:
                            a.a(this.a).a(this.a, (JPushLocalNotification) bundle.getSerializable(z[19]), true);
                            return;
                        case 7:
                            a.a(this.a).a(this.a, bundle.getLong(z[18]));
                            return;
                        case 8:
                            a.a(this.a).b(this.a);
                            return;
                        case 9:
                            cn.jpush.android.api.b.a(this.a, bundle.getInt(z[10]), true);
                            return;
                        case 10:
                            cn.jpush.android.api.b.a(this.a, true);
                            return;
                        default:
                            return;
                    }
                } else if (z[12].equals(string)) {
                    MultiSpHelper.commitInt(this.a, z[7], 1);
                    return;
                } else if (string.equals(z[14])) {
                    MultiSpHelper.commitInt(this.a, z[7], 0);
                    return;
                } else if (z[16].equals(string)) {
                    j.a(this.a, bundle);
                    return;
                } else if (z[2].equals(string)) {
                    f.a().a(this.a, bundle);
                    return;
                } else {
                    e.g(z[21], new StringBuilder(z[0]).append(string).toString());
                    return;
                }
            }
            return;
        }
        e.g(z[21], z[9]);
    }
}
