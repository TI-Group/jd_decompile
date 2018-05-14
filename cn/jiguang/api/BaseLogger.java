package cn.jiguang.api;

import cn.jiguang.c.a;
import cn.jiguang.c.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public abstract class BaseLogger {
    public static boolean a = true;
    private static b c = new a();
    private static final SimpleDateFormat d = new SimpleDateFormat(z[2], Locale.ENGLISH);
    private static ArrayList<String> e = new ArrayList();
    private static boolean f = false;
    private static boolean g = false;
    private static final String[] z;
    private String b;

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 3;
        r4 = new java.lang.String[r0];
        r3 = "e|";
        r0 = -1;
        r6 = r4;
        r7 = r4;
        r4 = r1;
    L_0x000c:
        r3 = r3.toCharArray();
        r8 = r3.length;
        if (r8 > r2) goto L_0x0082;
    L_0x0013:
        r9 = r1;
    L_0x0014:
        r10 = r3;
        r11 = r9;
        r14 = r8;
        r8 = r3;
        r3 = r14;
    L_0x0019:
        r13 = r8[r9];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x0076;
            case 1: goto L_0x0079;
            case 2: goto L_0x007c;
            case 3: goto L_0x007f;
            default: goto L_0x0020;
        };
    L_0x0020:
        r12 = 21;
    L_0x0022:
        r12 = r12 ^ r13;
        r12 = (char) r12;
        r8[r9] = r12;
        r9 = r11 + 1;
        if (r3 != 0) goto L_0x002e;
    L_0x002a:
        r8 = r10;
        r11 = r9;
        r9 = r3;
        goto L_0x0019;
    L_0x002e:
        r8 = r3;
        r3 = r10;
    L_0x0030:
        if (r8 > r9) goto L_0x0014;
    L_0x0032:
        r8 = new java.lang.String;
        r8.<init>(r3);
        r3 = r8.intern();
        switch(r0) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0050;
            default: goto L_0x003e;
        };
    L_0x003e:
        r6[r4] = r3;
        r0 = "r\u0015\t#Tv\u001bc";
        r3 = r0;
        r4 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000c;
    L_0x0047:
        r6[r4] = r3;
        r0 = "u\u0011`\u0012qg\u0014\u0006LxUf=\u0005Jk\u000f\u001d";
        r3 = r0;
        r4 = r5;
        r6 = r7;
        r0 = r2;
        goto L_0x000c;
    L_0x0050:
        r6[r4] = r3;
        z = r7;
        r0 = new cn.jiguang.c.a;
        r0.<init>();
        c = r0;
        a = r2;
        r0 = new java.text.SimpleDateFormat;
        r2 = z;
        r2 = r2[r5];
        r3 = java.util.Locale.ENGLISH;
        r0.<init>(r2, r3);
        d = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        e = r0;
        f = r1;
        g = r1;
        return;
    L_0x0076:
        r12 = 56;
        goto L_0x0022;
    L_0x0079:
        r12 = 92;
        goto L_0x0022;
    L_0x007c:
        r12 = 78;
        goto L_0x0022;
    L_0x007f:
        r12 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        goto L_0x0022;
    L_0x0082:
        r9 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.BaseLogger.<clinit>():void");
    }

    public BaseLogger() {
        this.b = "";
        this.b = new StringBuilder(z[1]).append(getCommonTag()).toString();
    }

    private static boolean a(int i) {
        return i >= 3;
    }

    public static void flushCached2File() {
    }

    public static void setDelegate(b bVar) {
        c = bVar;
    }

    public void _d(String str, String str2, Object... objArr) {
    }

    public void d(String str, String str2) {
    }

    public void d(String str, String str2, Throwable th) {
    }

    public void dd(String str, String str2) {
        if (cn.jiguang.b.a.b && a && a(3)) {
            c.b(this.b, "[" + str + z[0] + str2);
        }
    }

    public void dd(String str, String str2, Throwable th) {
        if (cn.jiguang.b.a.b && a && a(3)) {
            c.b(this.b, "[" + str + z[0] + str2, th);
        }
    }

    public void e(String str, String str2) {
    }

    public void e(String str, String str2, Throwable th) {
    }

    public void ee(String str, String str2) {
        if (a && a(6)) {
            c.e(this.b, "[" + str + z[0] + str2);
        }
    }

    public void ee(String str, String str2, Throwable th) {
        if (a && a(6)) {
            c.e(this.b, "[" + str + z[0] + str2, th);
        }
    }

    public abstract String getCommonTag();

    public void i(String str, String str2) {
    }

    public void i(String str, String str2, Throwable th) {
    }

    public void ii(String str, String str2) {
        if (cn.jiguang.b.a.b && a && a(4)) {
            c.c(this.b, "[" + str + z[0] + str2);
        }
    }

    public void ii(String str, String str2, Throwable th) {
        if (cn.jiguang.b.a.b && a && a(4)) {
            c.c(this.b, "[" + str + z[0] + str2, th);
        }
    }

    public void v(String str, String str2) {
    }

    public void v(String str, String str2, Throwable th) {
    }

    public void vv(String str, String str2) {
        if (cn.jiguang.b.a.b && a && a(2)) {
            c.a(this.b, "[" + str + z[0] + str2);
        }
    }

    public void vv(String str, String str2, Throwable th) {
        if (cn.jiguang.b.a.b && a && a(2)) {
            c.a(this.b, "[" + str + z[0] + str2, th);
        }
    }

    public void w(String str, String str2) {
    }

    public void w(String str, String str2, Throwable th) {
    }

    public void ww(String str, String str2) {
        if (a && a(5)) {
            c.d(this.b, "[" + str + z[0] + str2);
        }
    }

    public void ww(String str, String str2, Throwable th) {
        if (cn.jiguang.b.a.b && a && a(5)) {
            c.d(this.b, "[" + str + z[0] + str2, th);
        }
    }
}
