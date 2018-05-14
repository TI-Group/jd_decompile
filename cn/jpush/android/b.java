package cn.jpush.android;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a.h;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.e;

/* compiled from: TbsSdkJava */
public final class b {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 17;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0005y\u0011\u0000c\u0018{:\u0007c\u001ay\u000b\u0017o)l\u0010\u0007b)h\f\u0019o";
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
            case 0: goto L_0x00d9;
            case 1: goto L_0x00dd;
            case 2: goto L_0x00e1;
            case 3: goto L_0x00e5;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 10;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0005u\t\u0011d\u0015y:\u0004\u0005t:\u0000c\u001by";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u001bi\t\u0000c)h\u001c\u0004o";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0015rK\u001ez\u0003o\rZk\u0018x\u0017\u001bc\u00122\f\u001a~\u0013r\u0011ZG#P1=U&N*7O%O";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0017\u0011\u001de\u0018";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0006p\u0010\u0013c\u0018L\t\u0015~\u0010s\u0017\u0019X\u0013{\f\u0010";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0018s\u0011\u001dl\u001f\u0004\u0000c\u0019r:\u0016\u001fx\t\u0011x)u\u0001";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001cl\u0010\u0007b)o\u0004\u0002o)\u0010\u0007~\u0019q:\u0016\u001fp\u0001\u0011x";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0018s\u0011\u001dl\u001f\u0004\u0000c\u0019r:\u0016\u001fx\t\u0011x";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0012y\u0006\u0006o\u0017o\u0000:e\u0002u\u0003\u001di\u0017h\f\u001bdL";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "<L\u0010\u0007b5s\b\u0019e\u0018";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u0018s\u0011\u001dl\u001f\u0004\u0000c\u0019r:\u001a\u001b";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0018i\b\u0016o\u0004<\f\u001a*\u0007i\u0000\u0001oL<";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0018s\u0011\u001dl\u001f\u0004\u0000c\u0019r:\u0019k\u000er\u0010\u0019";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0013r\u0004\u0016f\u0013C\u0015\u0001y\u001eC\u0011\u001dg\u0013";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u0005y\u0011\u0000c\u0018{:\u0004\u0005t:\u0000c\u001by";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u001b}\u001dTd\u0019h\f\u0012c\u0015}\u0011\u001de\u0018&";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00d9:
        r9 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        goto L_0x0020;
    L_0x00dd:
        r9 = 28;
        goto L_0x0020;
    L_0x00e1:
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x0020;
    L_0x00e5:
        r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.b.<clinit>():void");
    }

    public static int a(Context context) {
        int i = MultiSpHelper.getInt(context, z[11], JPushInterface.a);
        e.a(z[10], new StringBuilder(z[16]).append(i).toString());
        return i;
    }

    public static void a(Context context, int i, String str) {
        MultiSpHelper.commitString(context, new StringBuilder(z[5]).append(i).toString(), str);
    }

    public static void a(Context context, int i, boolean z) {
        if (z) {
            int b = h.b();
            e.a(z[10], new StringBuilder(z[12]).append(b).toString());
            if (i < b) {
                b -= i;
                e.a(z[10], new StringBuilder(z[9]).append(b).toString());
                cn.jpush.android.api.b.a(context, b);
            }
            MultiSpHelper.commitInt(context, z[11], i);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(z[4], z[3]);
        bundle.putInt(z[2], 2);
        bundle.putInt(z[13], i);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (z || JCoreInterface.canCallDirect()) {
            MultiSpHelper.commitString(context, new StringBuilder(z[7]).append(str).toString(), str2);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(z[4], z[3]);
        bundle.putInt(z[2], 1);
        bundle.putString(z[6], str);
        bundle.putString(z[8], str2);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static void a(Context context, String str, boolean z) {
        if (z || JCoreInterface.canCallDirect()) {
            MultiSpHelper.commitString(context, z[0], str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(z[4], z[3]);
        bundle.putInt(z[2], 4);
        bundle.putString(z[1], str);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static String b(Context context) {
        return MultiSpHelper.getString(context, z[15], "");
    }

    public static void b(Context context, String str, boolean z) {
        if (z || JCoreInterface.canCallDirect()) {
            MultiSpHelper.commitString(context, z[15], str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(z[4], z[3]);
        bundle.putInt(z[2], 3);
        bundle.putString(z[14], str);
        JCoreInterface.sendAction(context, a.a, bundle);
    }
}
