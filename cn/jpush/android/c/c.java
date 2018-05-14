package cn.jpush.android.c;

import android.app.Activity;
import android.content.Context;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.e;
import com.huawei.hms.api.HuaweiApiAvailability;

/* compiled from: TbsSdkJava */
public final class c {
    private static final String[] z;
    protected Activity a;
    a b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 13;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "veM)L,mZ$\u001f";
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
            case 0: goto L_0x00ad;
            case 1: goto L_0x00b1;
            case 2: goto L_0x00b4;
            case 3: goto L_0x00b8;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 37;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "5j})J*$C\u001cF.mX4Q#>";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\nh[:L4L[<R?m~(V2M@)@(bO>@";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = ";gZ4S3pW}R;w\u000e3P6h";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "9k@)@\"p\u000e*D)$@(I6";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "5jo>Q3rG)\\\ba](I.$O>Q3rG)\\zsO.\u00054qB1";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "5jo>Q3rG)\\\ba](I.$K/W\u0019kJ8\u001f";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "vvK.P6pm2A?>";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "5jo>Q3rG)\\\ba](I.>";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "5jo>Q3rG)\\\ba](I.$K/W5v\u0014";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "5jo>Q3rG)\\\ba](I.$M<I6$M2K4aM)\u0005<eG1@>$F(D-aG\u001cU3GB4@4p\u0014";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "5j})D(p\u000e0d9pG+L.}\u0014";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "5j})D(p\u000ep\u0005?v\\2W`";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00ad:
        r9 = 90;
        goto L_0x0020;
    L_0x00b1:
        r9 = 4;
        goto L_0x0020;
    L_0x00b4:
        r9 = 46;
        goto L_0x0020;
    L_0x00b8:
        r9 = 93;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.c.<clinit>():void");
    }

    public c(Context context) {
        if (context == null) {
            e.h(z[2], z[4]);
        } else if (i.a(context) == (byte) 2) {
            this.b = new a(context, this);
        }
    }

    public final void a(Activity activity) {
        e.d(z[2], new StringBuilder(z[11]).append(this.a).append(z[0]).append(activity).toString());
        if (activity == null) {
            e.h(z[2], z[3]);
            return;
        }
        try {
            if (this.b.a != null) {
                this.a = activity;
                if (!JPushInterface.isPushStopped(activity.getApplicationContext())) {
                    this.b.a.connect();
                }
            }
        } catch (Throwable th) {
            e.i(z[2], new StringBuilder(z[12]).append(th).toString());
        }
    }

    public final void a(Context context, int i, int i2) {
        e.c(z[2], new StringBuilder(z[8]).append(i).append(z[7]).append(i2).toString());
        if (i != 10001) {
            return;
        }
        if (context != null) {
            try {
                int isHuaweiMobileServicesAvailable = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context.getApplicationContext());
                e.f(z[2], new StringBuilder(z[6]).append(isHuaweiMobileServicesAvailable).toString());
                if (isHuaweiMobileServicesAvailable != 0) {
                    return;
                }
                if (this.b.a == null || this.b.a.isConnecting() || this.b.a.isConnected()) {
                    e.f(z[2], new StringBuilder(z[10]).append(this.b.a).toString());
                    return;
                } else {
                    this.b.a.connect();
                    return;
                }
            } catch (Throwable th) {
                e.h(z[2], new StringBuilder(z[9]).append(th).toString());
                return;
            }
        }
        e.h(z[2], z[5]);
    }

    public final void b(Activity activity) {
        e.d(z[2], new StringBuilder(z[1]).append(this.a).append(z[0]).append(activity).toString());
        if (activity == null) {
            e.h(z[2], z[3]);
        }
        this.a = null;
    }
}
