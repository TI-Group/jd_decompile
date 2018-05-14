package cn.jiguang.b.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import cn.jiguang.b.a.a;
import cn.jiguang.c.d;

public final class j {
    private static boolean a = false;
    private static Handler b;
    private static j d;
    private static final String[] z;
    private Context c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 9;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "C\u0014\u0000WrI\u0014\u0000QNn\u001d\u0011@t";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
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
            case 0: goto L_0x0084;
            case 1: goto L_0x0087;
            case 2: goto L_0x008a;
            case 3: goto L_0x008d;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 6;
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
        goto L_0x0017;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0012;
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
            case 6: goto L_0x0073;
            case 7: goto L_0x007c;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "(\u0004\u000f@~h\u0014\u0011Qod\u001fA\b&x\u0005\u000eU&m\u0010\bIcoQ[";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "b\u001f\bQ&m\u0010\bIco]\u0002Jh\u0014\u0019Q&b\u0002AKsg\u001dA";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "b\u001f\bQ&a\u0019\u0004DtQ\u0003@gQ\u0007Dog\u0014\u0005\u0005++\u0014\u0013WiyK";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "A9\u0004Dt3\u0004DrC\u0014\rUcy";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "x\u0014\u000fANn\u0010\u0013QDn\u0010\u0015\u0005cy\u0003\u000eW<";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "y\u0005\u0002";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "h\u001fOOv~\u0002\t\u000bge\u0015\u0013Joo_\bKrn\u001f\u0015\u000bT_2";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "y\u0005\u0002zbn\u001d\u0000\\";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        a = r0;
        return;
    L_0x0084:
        r9 = 11;
        goto L_0x001f;
    L_0x0087:
        r9 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        goto L_0x001f;
    L_0x008a:
        r9 = 97;
        goto L_0x001f;
    L_0x008d:
        r9 = 37;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.j.<clinit>():void");
    }

    public static j a() {
        if (d == null) {
            d = new j();
        }
        return d;
    }

    public static void b() {
        if (b != null && !b.hasMessages(8000)) {
            b.sendEmptyMessageDelayed(8000, (long) (a.h() * 1000));
        }
    }

    public static void b(Context context) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(z[8], 0);
            bundle.putString(z[6], z[6]);
            m.a().b(context, z[7], bundle);
        } catch (Throwable th) {
            d.h(z[0], new StringBuilder(z[5]).append(th.getMessage()).toString());
        }
    }

    public static void c() {
        a = false;
        try {
            if (b != null) {
                b.removeCallbacksAndMessages(null);
                b.getLooper().quit();
            }
            b = null;
        } catch (Throwable th) {
            d.g(z[0], new StringBuilder(z[1]).append(th.getMessage()).toString());
        }
    }

    public final void a(Context context) {
        if (!a) {
            if (context == null) {
                d.h(z[0], z[2]);
                return;
            }
            a = true;
            this.c = context;
            try {
                HandlerThread handlerThread = new HandlerThread(z[4]);
                handlerThread.start();
                b = new k(this, handlerThread.getLooper());
                b();
            } catch (Throwable th) {
                d.i(z[0], new StringBuilder(z[3]).append(th).toString());
            }
        }
    }
}
