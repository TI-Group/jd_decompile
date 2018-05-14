package cn.jpush.android.c;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.d.e;
import com.xiaomi.mipush.sdk.MiPushClient;

/* compiled from: TbsSdkJava */
public final class j extends e {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 11;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "2OIP%)T\u0007S!\"\u0000IQ,=";
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
            case 0: goto L_0x0097;
            case 1: goto L_0x009a;
            case 2: goto L_0x009d;
            case 3: goto L_0x00a0;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 64;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0001LRC)?xNE/<IwH!%FHV-\u0010CSM/?";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "#ETQ-4pRW(";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\tifk\r\u0018ft\u0010\u001ae~";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "}XNE/<IfT08D\u001d";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = ")IFK-8aWT\u000b4Y\u001d";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\tifk\r\u0018ft\u0010\u0018d";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = ")IFK-8\u0000T@+qAWT+4Y\u0007K2qAWT)5\u0000PE3qEJT4(\fWH%0SB\u0004#9EDO`(ORV`<AIM&4SS\u0004#>NAM'";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0003E@M3%EU\u0004mqCHJ44XS\u000470S\u0007J5=L";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "rUIA8!EDP%5\u0000\n\u000424GNW44R\u0007A2#OU\u001e";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\"THT\u0010$SO";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0097:
        r9 = 81;
        goto L_0x0020;
    L_0x009a:
        r9 = 32;
        goto L_0x0020;
    L_0x009d:
        r9 = 39;
        goto L_0x0020;
    L_0x00a0:
        r9 = 36;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.j.<clinit>():void");
    }

    protected final void a(Context context) {
        if (context == null) {
            e.i(z[1], z[8]);
            return;
        }
        try {
            Object a = i.a(context, z[3]);
            Object a2 = i.a(context, z[6]);
            e.a(z[1], new StringBuilder(z[5]).append(a).append(z[4]).append(a2).toString());
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) {
                e.j(z[1], z[7]);
            } else {
                MiPushClient.registerPush(context, a2, a);
            }
        } catch (Throwable th) {
            e.d(z[1], z[9], th);
        }
    }

    protected final void b(Context context) {
        e.c(z[1], z[2]);
        if (context == null) {
            e.i(z[1], z[0]);
        } else {
            MiPushClient.enablePush(context);
        }
    }

    protected final String c(Context context) {
        return MiPushClient.getRegId(context);
    }

    protected final void d(Context context) {
        e.c(z[1], z[10]);
        if (context == null) {
            e.i(z[1], z[0]);
        } else {
            MiPushClient.disablePush(context);
        }
    }
}
