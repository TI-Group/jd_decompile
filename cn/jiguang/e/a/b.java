package cn.jiguang.e.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.text.TextUtils;
import cn.jiguang.android.ShareValues;
import cn.jiguang.android.a;
import cn.jiguang.c.d;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class b {
    private static Map<String, b> b = new HashMap(2);
    private static final String[] z;
    protected final ShareValues a = new ShareValues();
    private final String c;
    private SharedPreferences d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 8;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0011'\t\u000e'\u000e7\u0016\u0015\"*7\u0017";
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
            case 0: goto L_0x0081;
            case 1: goto L_0x0084;
            case 2: goto L_0x0087;
            case 3: goto L_0x008a;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 78;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = ",'\u0011Z=43\u0017\u001f\u001e.7\u0003Vn";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "/7\u0011Z-=1\r\u001fb|";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = ";7\u0011<<3?(\u000f\"(;5\b!?7\u0016\tn.7\b\u0015:9r\u0000\u0002-9\"\u0011\u0013!2";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u001d\u001b!6n5!E4;0>E\r&9<E\u001d+(\u0005\f\u000e&\u0011'\t\u000e'\f \n\u0019+/!";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = ")\"\u0001\u001b:9\u0010\u001c7;0&\f*<31\u0000\t=| \u0000\u0017!(7E\u001f6?7\u0015\u000e'3<";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u001d\u001b!6n5!E4;0>E\r&9<E\r<5&\u0000";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = ".7\u0004\u001en: \n\u0017n?3\u0006\u0012+pr";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        z = r4;
        r0 = new java.util.HashMap;
        r1 = 2;
        r0.<init>(r1);
        b = r0;
        return;
    L_0x0081:
        r9 = 92;
        goto L_0x0020;
    L_0x0084:
        r9 = 82;
        goto L_0x0020;
    L_0x0087:
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x0020;
    L_0x008a:
        r9 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.a.b.<clinit>():void");
    }

    protected b(Context context, String str) {
        this.c = str;
        this.d = context.getSharedPreferences(str, 0);
    }

    public static void a(b bVar) {
        if (bVar != null) {
            b.put(bVar.c, bVar);
        }
    }

    private static boolean a(int i) {
        return (i & 3) == 0;
    }

    private static boolean a(int i, int i2) {
        return (i & i2) == i2;
    }

    public static b b(String str) {
        return (TextUtils.isEmpty(str) || b == null) ? null : (b) b.get(str);
    }

    private void e(ShareValues shareValues, int i) {
        if (a(i, 1)) {
            this.a.a(shareValues, true);
            d.a(z[0], new StringBuilder(z[2]).append(shareValues).toString());
        }
    }

    public final boolean a(ShareValues shareValues, int i) {
        if (shareValues == null || a(i)) {
            return false;
        }
        e(shareValues, i);
        if (!a(i, 2)) {
            return true;
        }
        d.a(z[0], new StringBuilder(z[1]).append(shareValues).toString());
        return shareValues.a(this.d, true);
    }

    public final <T extends Serializable> boolean a(String str, T t, int i) {
        return a(i) ? false : b(new ShareValues().b(str, t), i);
    }

    public final <T extends Serializable> T b(String str, T t, int i) {
        return a(i) ? t : d(new ShareValues().b(str, t), i).a(str, (Serializable) t);
    }

    public final boolean b(ShareValues shareValues, int i) {
        boolean z = false;
        a b = a.b();
        if (b != null) {
            try {
                z = b.a(this.c, shareValues, true, i);
            } catch (RemoteException e) {
                d.g(z[z], new StringBuilder(z[5]).append(e.getMessage()).toString());
            }
        } else {
            d.g(z[z], new StringBuilder(z[6]).append(shareValues).toString());
            a(shareValues, i);
        }
        return z;
    }

    public final ShareValues c(ShareValues shareValues, int i) {
        if (shareValues == null || a(i)) {
            return shareValues;
        }
        ShareValues a = new ShareValues(shareValues).a();
        if (a(i, 1)) {
            a = a.a(this.a);
            if (a.b()) {
                d.a(z[0], new StringBuilder(z[7]).append(a).toString());
                return a;
            }
        }
        if (a(i, 2)) {
            a = a.a(this.d);
        }
        a = new ShareValues(shareValues).a(a, false);
        e(a, i);
        return a;
    }

    public final ShareValues d(ShareValues shareValues, int i) {
        a b = a.b();
        if (b == null || shareValues == null) {
            d.g(z[0], z[4]);
        } else {
            try {
                return b.a(this.c, shareValues, i);
            } catch (RemoteException e) {
                d.g(z[0], new StringBuilder(z[3]).append(e.getMessage()).toString());
            }
        }
        return c(shareValues, i);
    }

    public final void m(Context context) {
        if (context != null) {
            if (VERSION.SDK_INT >= 11) {
                context.getSharedPreferences(this.c, 4);
            }
            this.d = context.getSharedPreferences(this.c, 0);
            this.a.a(this.d);
        }
    }
}
