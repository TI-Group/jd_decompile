package cn.jpush.android.c;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.d.e;
import com.meizu.cloud.pushsdk.PushManager;

/* compiled from: TbsSdkJava */
public final class d extends e {
    private static final String[] z;
    private String a;
    private String b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u00141\u0017@GM\u001d\u0002Yt\\f";
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
        r9 = 61;
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
        r1 = "u\u0019;shg\u001d\"yt|";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "h0\u0007NTV\u0011\u0017@GM\f\u001eHI]:\u001d[Py?\u0006@RV";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "[3\u001c]X@(R^\\K|\u001c\\QT";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "U9\u001bSHy,\u0002bXAf";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "u\u0019;shg\u001d\"yv}\u0005";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u001b)\u001cLEH9\u0011]X\\|_\tO];\u001bZI].RLOJ3\u0000\u0013";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "j9\u0015@NL9\u0000\t\u0010\u0018?\u001dGI]$\u0006\tJY/RGHT0";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "U9\u001bSH\u0018/\u0016B\u001dY,\u0002BXA|\u001d[\u001dY,\u0002@Y\u0018+\u0013Z\u001d]1\u0002]D\u0014,\u001eL\\K9RJU]?\u0019\tDW)\u0000\tPY2\u001bOXK(RJRV:\u001bN";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "_9\u0006\tMM/\u001a`Y\u0018)\u001cLEH9\u0011]X\\|\u0017[OW.";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x008c:
        r9 = 56;
        goto L_0x0020;
    L_0x008f:
        r9 = 92;
        goto L_0x0020;
    L_0x0092:
        r9 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        goto L_0x0020;
    L_0x0095:
        r9 = 41;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.d.<clinit>():void");
    }

    public d(Context context) {
        if (context == null) {
            e.h(z[2], z[3]);
        }
        this.a = i.a(context, z[5]);
        this.b = i.a(context, z[1]);
        e.c(z[2], new StringBuilder(z[4]).append(String.valueOf(this.a)).append(z[0]).append(String.valueOf(this.b)).toString());
    }

    protected final void a(Context context) {
        if (context == null) {
            e.i(z[2], z[7]);
            return;
        }
        try {
            if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
                e.j(z[2], z[8]);
            } else {
                PushManager.register(context, this.b, this.a);
            }
        } catch (Throwable th) {
            e.d(z[2], z[6], th);
        }
    }

    protected final void b(Context context) {
    }

    protected final String c(Context context) {
        String str = null;
        try {
            str = PushManager.getPushId(context);
        } catch (Throwable th) {
            e.i(z[2], z[9]);
        }
        return str;
    }

    protected final void d(Context context) {
    }
}
