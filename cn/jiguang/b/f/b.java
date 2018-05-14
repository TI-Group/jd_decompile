package cn.jiguang.b.f;

import android.content.Context;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jiguang.b.d.r;
import cn.jiguang.c.d;
import cn.jiguang.e.a;
import cn.jiguang.e.j;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b {
    private static volatile b i;
    private static final Object j = new Object();
    private static final String[] z;
    private transient AtomicBoolean a = new AtomicBoolean(false);
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private byte h = (byte) 0;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0006?\u0001B%'\u0013\u0019M)";
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
            case 0: goto L_0x0077;
            case 1: goto L_0x007a;
            case 2: goto L_0x007d;
            case 3: goto L_0x0080;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 70;
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
        r1 = "26\u0016_ -(\u001a_?2?";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "b*\u001b^!+4'G'6<\u0018Y+\u0016#\u0007Nfoz";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "#4\u0013Y)+>(B\"";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "!5\u0019_#:.WB5b4\u0002G*";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "74\u001cE)54";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "f~";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        j = r0;
        return;
    L_0x0077:
        r9 = 66;
        goto L_0x001f;
    L_0x007a:
        r9 = 90;
        goto L_0x001f;
    L_0x007d:
        r9 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        goto L_0x001f;
    L_0x0080:
        r9 = 43;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.f.b.<clinit>():void");
    }

    private b() {
    }

    public static b e() {
        if (i == null) {
            synchronized (j) {
                if (i == null) {
                    i = new b();
                }
            }
        }
        return i;
    }

    public final String a() {
        return this.d;
    }

    public final void a(Context context) {
        if (!this.a.get() && context != null) {
            b(context);
            this.a.set(true);
        }
    }

    public final String b() {
        return this.e;
    }

    public final void b(Context context) {
        if (context == null) {
            d.h(z[0], z[4]);
            return;
        }
        this.c = a.e(context, this.c);
        try {
            this.b = Secure.getString(context.getContentResolver(), z[3]);
        } catch (Exception e) {
        }
        if (TextUtils.isEmpty(this.b)) {
            this.b = "";
        }
        String e2 = a.e(context);
        String f = a.f(context, "");
        if (TextUtils.isEmpty(e2)) {
            e2 = " ";
        }
        if (TextUtils.isEmpty(f)) {
            f = " ";
        }
        this.d = e2 + z[6] + f + z[6] + context.getPackageName() + z[6] + cn.jiguang.b.a.d.i(context);
        this.g = r.a(context);
        cn.jiguang.b.d.b.a();
        this.e = a.a(context, ((("" + cn.jiguang.b.d.b.d(SdkType.JPUSH.name(), " ") + "|") + cn.jiguang.b.d.b.d(SdkType.JANALYTICS.name(), " ") + "|") + cn.jiguang.b.d.b.d(SdkType.JSHARE.name(), " ") + "|") + cn.jiguang.b.d.b.d(SdkType.JCORE.name(), " "));
        e2 = a.g(context);
        f = a.f(context);
        String c = a.c(context, " ");
        String e3 = a.e(context, " ");
        String str = Build.SERIAL;
        if (j.a(e2)) {
            e2 = " ";
        }
        if (j.a(f)) {
            f = " ";
        }
        if (!j.e(c)) {
            c = " ";
        }
        if (j.a(e3)) {
            e3 = " ";
        }
        if (j.a(str) || z[5].equalsIgnoreCase(str)) {
            str = " ";
        }
        cn.jiguang.b.a.a.a(e3, f, c);
        this.f = a.a + z[6] + e2 + z[6] + e3 + z[6] + f + z[6] + c + z[6] + str;
    }

    public final byte c(Context context) {
        ArrayList a = cn.jiguang.b.d.b.a().a(context, SdkType.JPUSH.name(), 17, z[1], 1);
        Object obj = a.size() > 0 ? a.get(0) : null;
        if (obj != null && (obj instanceof Byte)) {
            this.h = ((Byte) obj).byteValue();
        }
        d.a(z[0], new StringBuilder(z[2]).append(this.h).toString());
        return this.h;
    }

    public final String c() {
        return this.f;
    }

    public final String d() {
        return this.g;
    }
}
