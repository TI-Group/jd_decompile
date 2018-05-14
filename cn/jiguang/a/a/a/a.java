package cn.jiguang.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.c.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public final class a {
    private static a b = null;
    private static final Object c = new Object();
    private static final String[] z;
    private HashMap<String, Long> a = null;
    private File d = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 9;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "l|XN\u0006lvTl)r|\u0019O2lvK\u0010";
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "_kIi!}q\\4wu";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "_kIi!}q\\";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "mxOO\tp_PF%>|KX/l#";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = ">zXI({9WE4>|AC3j7";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = ">zXI({9\u0003I5lk\\D4JpTO";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = ">KO1k|WI9$";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = ">zXI({MPG%$";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "u|@\u0010";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        b = r0;
        r0 = new java.lang.Object;
        r0.<init>();
        c = r0;
        return;
    L_0x008c:
        r9 = 30;
        goto L_0x0020;
    L_0x008f:
        r9 = 25;
        goto L_0x0020;
    L_0x0092:
        r9 = 57;
        goto L_0x0020;
    L_0x0095:
        r9 = 42;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.a.a.<clinit>():void");
    }

    private a() {
    }

    public static long a(Context context) {
        return cn.jiguang.a.b.a.c(context);
    }

    public static a a() {
        if (b == null) {
            synchronized (c) {
                b = new a();
            }
        }
        return b;
    }

    private void b(Context context) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        if (this.d == null && context != null) {
            this.d = new File(context.getCacheDir(), z[2]);
            try {
                if (this.d != null && this.a != null && this.d.exists()) {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(this.d));
                    this.a = (HashMap) objectInputStream.readObject();
                    objectInputStream.close();
                }
            } catch (Exception e) {
                d.i(z[1], new StringBuilder(z[0]).append(e.toString()).toString());
            }
        }
    }

    public final void a(Context context, String str) {
        b(context);
        if (!TextUtils.isEmpty(str)) {
            this.a.put(cn.jiguang.e.a.a(str), Long.valueOf(System.currentTimeMillis()));
            try {
                if (this.d != null && this.a != null) {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.d));
                    objectOutputStream.writeObject(this.a);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
            } catch (Exception e) {
                d.i(z[1], new StringBuilder(z[3]).append(e.toString()).toString());
            }
        }
    }

    public final boolean b(Context context, String str) {
        b(context);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String a = cn.jiguang.e.a.a(str);
        Long l = (Long) this.a.get(a);
        if (l == null) {
            d.c(z[1], new StringBuilder(z[8]).append(a).append(z[4]).toString());
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long longValue = l.longValue();
        long c = cn.jiguang.a.b.a.c(context);
        d.c(z[1], new StringBuilder(z[8]).append(a).append(z[5]).append(currentTimeMillis).append(z[7]).append(longValue).append(z[6]).append(c).toString());
        return c != 0 && Math.abs(currentTimeMillis - longValue) > c;
    }
}
