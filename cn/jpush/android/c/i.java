package cn.jpush.android.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.b;
import cn.jpush.android.d.a;
import cn.jpush.android.d.e;
import com.huawei.hms.support.api.push.HuaweiPush;
import com.xiaomi.mipush.sdk.MiPushClient;

/* compiled from: TbsSdkJava */
public final class i {
    private static final String a;
    private static final String b;
    private static final String c;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 39;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "F\u0001D81\\\u000bK15M\u0014@n";
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
            case 0: goto L_0x01f0;
            case 1: goto L_0x01f4;
            case 2: goto L_0x01f8;
            case 3: goto L_0x01fc;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 97;
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
            case 22: goto L_0x0121;
            case 23: goto L_0x012c;
            case 24: goto L_0x0137;
            case 25: goto L_0x0142;
            case 26: goto L_0x014d;
            case 27: goto L_0x0158;
            case 28: goto L_0x0163;
            case 29: goto L_0x016e;
            case 30: goto L_0x0179;
            case 31: goto L_0x0184;
            case 32: goto L_0x018f;
            case 33: goto L_0x019a;
            case 34: goto L_0x01a5;
            case 35: goto L_0x01b0;
            case 36: goto L_0x01bb;
            case 37: goto L_0x01c6;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0014\u000eu8\u0014S\rK\u0004\rU\u0010C;\u0013Y0\\$\u0004\u000e";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "y%k\u0001'u'q\u00013q6\u0005#\u0000GD@9\u0011@\u001d";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "S\u0001Qt,u*p\u0012 w0p\u0006$fDC5\bX\u0001AtL\u0014\u0001W&\u000eF^";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "W\u000bK \u0004L\u0010\u0005#\u0000GDK!\rX";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "d\bP3\bZ3M=\u0002\\4I5\u0015R\u000bW9";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "W\n\u000b>\u0011A\u0017Mz\u0000Z\u0000W;\bPJV1\u0013B\rF1Od\bP3\bZ,P5\u0016Q\ru8\u0000@\u0002J&\fG6@7\u0004]\u0012@&";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "u\nA&\u000e]\u0000h5\u000f]\u0002@'\u0015\u001a\u001cH8AY\rV'\bZ\u0003\u0005&\u0004W\u0001L\"\u0004F^\u00057\u000f\u001a\u000eU!\u0012\\JD:\u0005F\u000bL0OG\u0001W\"\bW\u0001\u000b\u0004\rA\u0003L:)A\u0005R1\bd\bD \u0007[\u0016H'3Q\u0007@=\u0017Q\u0016";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "d\b@5\u0012QDF<\u0004W\u000f\u0005~O^\u0005Wt\u0007]\b@'AM\u000bP&AD\u0016J>\u0004W\u0010\u00050\u0004D\u0001K0\u0012\u0014\u000bKz";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "d\b@5\u0012QDF<\u0004W\u000f\u0005~O^\u0005Wt\u0007]\b@'AM\u000bP&AD\u0016J>\u0004W\u0010\u00050\u0004D\u0001K0\u0012\u0014\u000bKxAW\u0005Ks\u0015\u0014\bJ5\u0005\u0014\u0007I5\u0012GD\bt\u0002[\t\u000b<\u0014U\u0013@=O\\\tVz\u0012A\u0014U;\u0013@JD$\b\u001a\u0014P'\t\u001a,P5\u0016Q\ru!\u0012\\D/1\u0013F\u000bWn";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "Q\tP=AB\u0001W'\b[\n\u00059\u0014G\u0010\u00058\u0000F\u0003@t\u0015\\\u0005KtU\u001aT";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "R\b\\9\u0004\u0014\u0012@&\u0012]\u000bKt]\u0014Q\u000beO\u0005U\u000be \u0014H\u0005\u0007\t[\u0011I0AZ\u000bQt\u0014G\u0001\u0005\u0019\u0004]\u001eP\u0004\u0014G\f";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "W\n\u000b>\u0011A\u0017Mz\u0000Z\u0000W;\bPJV1\u0013B\rF1Od\bP3\bZ)@=\u001bA4I5\u0015R\u000bW9\u0012f\u0001F1\bB\u0001W";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "u\nA&\u000e]\u0000h5\u000f]\u0002@'\u0015\u001a\u001cH8AY\rV'\bZ\u0003\u0005&\u0004W\u0001L\"\u0004F^\u00057\u000f\u001a\u000eU!\u0012\\JD:\u0005F\u000bL0OG\u0001W\"\bW\u0001\u000b\u0004\rA\u0003L:,Q\r_!1X\u0005Q2\u000eF\tV\u0006\u0004W\u0001L\"\u0004F";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "d\b@5\u0012QDF<\u0004W\u000f\u0005~OU\u0005Wt\u0007]\b@'AM\u000bP&AD\u0016J>\u0004W\u0010\u00050\u0004D\u0001K0\u0012\u0014\u000bKz";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "d\b@5\u0012QDF<\u0004W\u000f\u0005~O^\u0005Wt\u0007]\b@'AM\u000bP&AD\u0016J>\u0004W\u0010\u00050\u0004D\u0001K0\u0012\u0014\u000bKxAW\u0005Ks\u0015\u0014\bJ5\u0005\u0014\u0007I5\u0012GD\bt\u0002[\t\u000b9\u0004]\u001ePz\u0002X\u000bP0OD\u0011V<\u0012P\u000f\u000b\u0004\u0014G\fh5\u000fU\u0003@&A>\u0001W&\u000eF^";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "S\u0001Qt$y1lt\u0017Q\u0016V=\u000eZDL'[";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u0014\u0003@ $Y\u0011L\u0002\u0004F\u0017L;\u000f\u0014\u0013W;\u000fSD@&\u0013[\u0016\u001f";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "q\tJ \b[\np\u001d>\u0000J\u0014";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "F\u000b\u000b6\u0014]\bAz\u0017Q\u0016V=\u000eZJ@9\u0014]";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "S\u0001Q";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "U\nA&\u000e]\u0000\u000b;\u0012\u001a7\\'\u0015Q\tu&\u000eD\u0001W \bQ\u0017";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "d\b@5\u0012QDF<\u0004W\u000f\u0005~O^\u0005Wt\u0007]\b@'AM\u000bP&AD\u0016J>\u0004W\u0010\u00050\u0004D\u0001K0\u0012\u0014\u000bKxAW\u0005Ks\u0015\u0014\bJ5\u0005\u0014\u0007I5\u0012GD\bt\u0002[\t\u000b,\bU\u000bH=OY\rU!\u0012\\JV0\n\u001a)L\u0004\u0014G\ff8\bQ\nQtkQ\u0016W;\u0013\u000e";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "W\n\u000b>\u0011A\u0017Mz\u0000Z\u0000W;\bPJV1\u0013B\rF1Od\bP3\bZ<L5\u000eY\ru8\u0000@\u0002J&\fG6@7\u0004]\u0012@&";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "u\nA&\u000e]\u0000h5\u000f]\u0002@'\u0015\u001a\u001cH8AY\rV'\bZ\u0003\u0005&\u0004W\u0001L\"\u0004F^\u00057\u000f\u001a\u000eU!\u0012\\JD:\u0005F\u000bL0OG\u0001W\"\bW\u0001\u000b\u0004\rA\u0003L:9]\u0005J9\bd\bD \u0007[\u0016H'3Q\u0007@=\u0017Q\u0016";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "G\fJ!\rPDK;\u0015\u00141V1Ay-p\u001d1A\u0017M";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "\u0014I\u0005:\u000e@DA1\u0007]\n@0A]\n\u00059\u0000Z\rC1\u0012@";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "Y\u0001Q5\u0005U\u0010DnA";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "Y\u0001Q5\u0005U\u0010DnAw\u0005Kt\u000f[\u0010\u00053\u0004@DH1\u0015U D \u0000\u0014\u0002W;\f\u0014%U$\r]\u0007D \b[\nl:\u0007[";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "\u0014\u0012D8\u0014Q^";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "X\u000bD0AD\bP3\bZDV0\n\u0014\u0007J:\u0007]\u0003\u0005=\u000fR\u000b\u00051\u0013F\u000bWn";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "u\u0007Q=\u000eZD\bt\u0006Q\u0010u8\u0014S\rK\u0004\rU\u0010C;\u0013Y'J:\u0007]\u0003l:\u0007[^";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "z+\u00059\u0004@\u0005\u00050\u0000@\u0005\u00050\u0004R\rK1\u0005\u0014\rKt\fU\nL2\u0004G\u0010\u000b";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "r\b\\9\u0004\u0014+vtT\u001aU\u000beP\u001aUd";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "S\u0001Qt\u0007X\u001dH1AB\u0001W'\b[\n\u0005=\u0012\u000e";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "r\b\\9\u0004\u0014Q\u000beO\u0005U\u000be ";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "F\u000b\u000b6\u0014]\bAz\u0005]\u0017U8\u0000MJL0";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "{7";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "\u0014\u0003@ 'X\u001dH17Q\u0016V=\u000eZDR&\u000eZ\u0003\u00051\u0013F\u000bWn";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        z = r4;
        r1 = "l\rD;\f]";
        r0 = -1;
    L_0x01cd:
        r1 = r1.toCharArray();
        r2 = r1.length;
        r3 = 0;
        r4 = 1;
        if (r2 > r4) goto L_0x020e;
    L_0x01d6:
        r4 = r1;
        r5 = r3;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x01db:
        r7 = r2[r3];
        r6 = r5 % 5;
        switch(r6) {
            case 0: goto L_0x0200;
            case 1: goto L_0x0203;
            case 2: goto L_0x0206;
            case 3: goto L_0x0209;
            default: goto L_0x01e2;
        };
    L_0x01e2:
        r6 = 97;
    L_0x01e4:
        r6 = r6 ^ r7;
        r6 = (char) r6;
        r2[r3] = r6;
        r3 = r5 + 1;
        if (r1 != 0) goto L_0x020c;
    L_0x01ec:
        r2 = r4;
        r5 = r3;
        r3 = r1;
        goto L_0x01db;
    L_0x01f0:
        r9 = 52;
        goto L_0x0020;
    L_0x01f4:
        r9 = 100;
        goto L_0x0020;
    L_0x01f8:
        r9 = 37;
        goto L_0x0020;
    L_0x01fc:
        r9 = 84;
        goto L_0x0020;
    L_0x0200:
        r6 = 52;
        goto L_0x01e4;
    L_0x0203:
        r6 = 100;
        goto L_0x01e4;
    L_0x0206:
        r6 = 37;
        goto L_0x01e4;
    L_0x0209:
        r6 = 84;
        goto L_0x01e4;
    L_0x020c:
        r2 = r1;
        r1 = r4;
    L_0x020e:
        if (r2 > r3) goto L_0x01d6;
    L_0x0210:
        r2 = new java.lang.String;
        r2.<init>(r1);
        r1 = r2.intern();
        switch(r0) {
            case 0: goto L_0x0226;
            case 1: goto L_0x0230;
            default: goto L_0x021c;
        };
    L_0x021c:
        r0 = r1.toLowerCase();
        a = r0;
        r1 = "\\\u0011D#\u0004]";
        r0 = 0;
        goto L_0x01cd;
    L_0x0226:
        r0 = r1.toLowerCase();
        b = r0;
        r1 = "y\u0001L.\u0014";
        r0 = 1;
        goto L_0x01cd;
    L_0x0230:
        r0 = r1.toLowerCase();
        c = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.i.<clinit>():void");
    }

    public static byte a(Context context) {
        int i = 2;
        if (context == null) {
            e.h(z[5], z[4]);
            return (byte) 0;
        }
        String str = null;
        try {
            str = Build.MANUFACTURER;
        } catch (Throwable th) {
            e.h(z[5], new StringBuilder(z[3]).append(th).toString());
        }
        if (TextUtils.isEmpty(str)) {
            e.h(z[5], z[2]);
            return (byte) 0;
        }
        byte b;
        if (TextUtils.equals(a, str.toLowerCase())) {
            if (c(context)) {
                b = (byte) 1;
                i = 1;
            } else {
                b = (byte) 0;
                i = 1;
            }
        } else if (TextUtils.equals(b, str.toLowerCase())) {
            b = d(context) ? (byte) 2 : (byte) 0;
        } else if (!TextUtils.equals(c, str.toLowerCase())) {
            b = (byte) 0;
            i = 0;
        } else if (b(context)) {
            b = (byte) 3;
            i = 3;
        } else {
            b = (byte) 0;
            i = 3;
        }
        e.a(z[5], new StringBuilder(z[0]).append(i).append(z[1]).append(b).toString());
        if (b == (byte) 0) {
            b.a(context, i, null);
        }
        return b;
    }

    public static String a(Context context, String str) {
        String str2 = null;
        e.a(z[5], new StringBuilder(z[31]).append(str).toString());
        if (context == null) {
            e.h(z[5], z[4]);
        } else {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null) {
                    Bundle bundle = applicationInfo.metaData;
                    if (bundle != null) {
                        String string = bundle.getString(str);
                        if (TextUtils.isEmpty(string) || string.length() <= 3) {
                            e.h(z[5], new StringBuilder(z[27]).append(str).append(z[26]).toString());
                        } else {
                            str2 = string.substring(3, string.length());
                        }
                        e.c(z[5], str + z[29] + str2);
                    } else {
                        e.d(z[5], z[32]);
                    }
                } else {
                    e.h(z[5], z[28]);
                }
            } catch (Throwable th) {
                e.h(z[5], new StringBuilder(z[30]).append(th).toString());
            }
        }
        return str2;
    }

    private static boolean a() {
        try {
            Class[] clsArr = new Class[]{String.class};
            Object[] objArr = new Object[]{z[36]};
            Class cls = Class.forName(z[21]);
            String str = (String) cls.getDeclaredMethod(z[20], clsArr).invoke(cls, objArr);
            e.e(z[5], new StringBuilder(z[34]).append(str).toString());
            if (!TextUtils.isEmpty(str)) {
                return (!str.contains(z[37]) && str.compareToIgnoreCase(z[35]) >= 0) || (str.contains(z[37]) && str.compareToIgnoreCase(z[33]) >= 0);
            }
        } catch (Throwable th) {
            e.i(z[5], new StringBuilder(z[38]).append(th).toString());
        }
        return false;
    }

    private static boolean b() {
        try {
            Class[] clsArr = new Class[]{String.class};
            Object[] objArr = new Object[]{z[19]};
            Class cls = Class.forName(z[21]);
            String str = (String) cls.getDeclaredMethod(z[20], clsArr).invoke(cls, objArr);
            e.e(z[5], new StringBuilder(z[16]).append(str).toString());
            if (!TextUtils.isEmpty(str)) {
                return str.compareToIgnoreCase(z[18]) >= 0;
            }
        } catch (Throwable th) {
            e.i(z[5], new StringBuilder(z[17]).append(th).toString());
        }
        return false;
    }

    private static boolean b(Context context) {
        if (VERSION.SDK_INT < 11 || !a.c(context, z[12])) {
            e.c(z[5], z[13]);
            return false;
        }
        try {
            if (a()) {
                return true;
            }
            e.d(z[5], z[11]);
            return false;
        } catch (Throwable th) {
            e.j(z[5], new StringBuilder(z[15]).append(th).toString());
            if (!JCoreInterface.getDebugMode()) {
                return false;
            }
            RuntimeException runtimeException = new RuntimeException(z[14], th);
        }
    }

    private static boolean c(Context context) {
        if (a.c(context, z[23])) {
            try {
                if (MiPushClient.shouldUseMIUIPush(context)) {
                    return true;
                }
                e.d(z[5], z[25]);
                return false;
            } catch (Throwable th) {
                e.j(z[5], new StringBuilder(z[22]).append(th).toString());
                if (!JCoreInterface.getDebugMode()) {
                    return false;
                }
                RuntimeException runtimeException = new RuntimeException(z[8], th);
            }
        } else {
            e.c(z[5], z[24]);
            return false;
        }
    }

    private static boolean d(Context context) {
        if (VERSION.SDK_INT < 14 || !a.c(context, z[6])) {
            e.c(z[5], z[7]);
            return false;
        }
        try {
            if (b()) {
                if (HuaweiPush.HuaweiPushApi != null) {
                    return true;
                }
            }
            e.d(z[5], z[10]);
            return false;
        } catch (Throwable th) {
            e.j(z[5], new StringBuilder(z[9]).append(th).toString());
            if (!JCoreInterface.getDebugMode()) {
                return false;
            }
            RuntimeException runtimeException = new RuntimeException(z[8], th);
        }
    }
}
