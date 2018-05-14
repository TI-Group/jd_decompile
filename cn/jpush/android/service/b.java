package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.a.d;
import cn.jpush.android.d.a;
import cn.jpush.android.d.e;

/* compiled from: TbsSdkJava */
public final class b {
    private static b a;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0018\u000eZK \u000e\u0013\u001c\u000f1\u0015\u0004\u0006N9\u001fN\u001dO$\u001e\u000e\u0000\u000f\u001e44=g\u00198! h\u001f5?;q\u00155%0";
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
            case 0: goto L_0x008c;
            case 1: goto L_0x008f;
            case 2: goto L_0x0092;
            case 3: goto L_0x0095;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 80;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "5\u000fT`\u0013/);o\u000f5/ h\u00162#5u\u00194.+n\u0000>.1ep\u001f\u0005\u0012H>\u001e\u0004TH>[\r\u0015O9\u001d\u0005\u0007U|[\u000f\u0004D>[\u0014\u001cDp\u001f\u0005\u0012@%\u0017\u0014TL1\u0012\u000eT@3\u000f\t\u0002H$\u0002";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "U\u0010\u0011S=\u0012\u0013\u0007H?\u0015N>q\u0005((+l\u0015(35f\u0015";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u001a\u0010\u0004";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0014\u000e:N$\u0012\u0006\u001dB1\u000f\t\u001bO\u001f\u000b\u0005\u001a\u0001#\u001e\u000e\u0010c\"\u0014\u0003\u0015Up\u001e\u0012\u0006N\"A";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\b\u0014\u0006o\u0004\u0002\u0010\u0011\u0001m[";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "+\u0015\u0007I\u0002\u001e\u0003\u0011H&\u001e\u00127N\"\u001e";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u0018\u000eZK \u000e\u0013\u001c\u000f1\u0015\u0004\u0006N9\u001fN:n\u00042&=b\u0011/);o\u000f/9$d";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0018\u000eZK \u000e\u0013\u001c\u000f1\u0015\u0004\u0006N9\u001fN9r\u0017$)0";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "(\u0005\u001aEp\u0019\u0012\u001b@4\u0018\u0001\u0007Up\u000f\u000fT@ \u000bZT";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x008c:
        r9 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        goto L_0x0020;
    L_0x008f:
        r9 = 96;
        goto L_0x0020;
    L_0x0092:
        r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        goto L_0x0020;
    L_0x0095:
        r9 = 33;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.b.<clinit>():void");
    }

    private b() {
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public static void a(Context context, Intent intent) {
        Object stringExtra = intent.getStringExtra(z[8]);
        if (!TextUtils.isEmpty(stringExtra)) {
            String stringExtra2 = intent.getStringExtra(z[7]);
            e.c(z[6], new StringBuilder(z[5]).append(stringExtra2).toString());
            boolean z = stringExtra2 != null && "1".equals(stringExtra2);
            if (true != z) {
                d.a(stringExtra, 1000, null, context);
            }
        }
        if (a.a(context, z[0], true)) {
            Intent intent2 = new Intent(z[0]);
            String str = "";
            try {
                intent2.putExtras(intent.getExtras());
                str = intent.getStringExtra(z[3]);
                if (TextUtils.isEmpty(str)) {
                    str = context.getPackageName();
                }
                intent2.addCategory(str);
                e.e(z[6], new StringBuilder(z[9]).append(str).toString());
                context.sendBroadcast(intent2, str + z[2]);
                return;
            } catch (Throwable th) {
                e.h(z[6], new StringBuilder(z[4]).append(th.getMessage()).toString());
                a.b(context, intent2, str + z[2]);
                return;
            }
        }
        e.d(z[6], z[1]);
        a.b(context);
    }
}
