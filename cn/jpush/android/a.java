package cn.jpush.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.SdkType;
import cn.jpush.android.d.e;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TbsSdkJava */
public final class a {
    public static final String a = SdkType.JPUSH.name();
    public static int b;
    public static String c;
    public static String d;
    public static Context e;
    public static boolean f = false;
    private static AtomicBoolean g = new AtomicBoolean(false);
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "j&517e(61elx\u000bn771;n";
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
            case 0: goto L_0x0083;
            case 1: goto L_0x0086;
            case 2: goto L_0x0089;
            case 3: goto L_0x008c;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 88;
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
        r1 = "f 59<j1 bxH$/x6d1a?=e\u0000((g,\"9,b*/x1h*/txr*4x/b)-x:ne/7,+$#4=+1.x+c*6x6d1(>1h$517ee%-=+1.x,c a9({)(;9,.6xb&.6xb6a6-g)o";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "b+794b!$x*~+/16lia(4n$2=xh-$;3+<.-*+( 61m 2,xh*/>1l6";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "A\u00154+0L).:9g";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "A\u00154+0+& 66d1a:=+,/1,b$-1\"n!a;7f5-=,n)8x<~ a,7+\u000b\u0014\u0014\u0014+$1(\u0011e#.v";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "l 5x5J5141h$517e\u000b 5=+ 3*7y";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "^+$ (n&5=<1e'91g %x,de&=,+&4**n+5x9{5-1;j1(76+,/>7";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        r0 = cn.jiguang.api.SdkType.JPUSH;
        r0 = r0.name();
        a = r0;
        r0 = new java.util.concurrent.atomic.AtomicBoolean;
        r1 = 0;
        r0.<init>(r1);
        g = r0;
        r0 = 0;
        f = r0;
        return;
    L_0x0083:
        r9 = 11;
        goto L_0x001f;
    L_0x0086:
        r9 = 69;
        goto L_0x001f;
    L_0x0089:
        r9 = 65;
        goto L_0x001f;
    L_0x008c:
        r9 = 88;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.<clinit>():void");
    }

    public static synchronized boolean a(Context context) {
        boolean z = true;
        synchronized (a.class) {
            if (!g.get()) {
                if (cn.jpush.android.d.a.e(context)) {
                    e.c(z[3], z[0]);
                    c = context.getPackageName();
                    e = context.getApplicationContext();
                    ApplicationInfo b = b(context);
                    if (b == null) {
                        e.j(z[3], z[4]);
                        z = false;
                    } else {
                        b = b.icon;
                        if (b == 0) {
                            e.j(z[3], z[1]);
                        }
                        try {
                            d = context.getPackageManager().getApplicationLabel(b).toString();
                        } catch (Throwable th) {
                            e.d(z[3], new StringBuilder(z[5]).append(th.getMessage()).toString());
                        }
                        if (JCoreInterface.init(context, false)) {
                            g.set(true);
                        } else {
                            z = false;
                        }
                    }
                } else {
                    e.g(z[3], z[2]);
                    z = false;
                }
            }
        }
        return z;
    }

    private static ApplicationInfo b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Throwable th) {
            e.e(z[3], z[6], th);
            return null;
        }
    }
}
