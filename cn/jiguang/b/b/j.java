package cn.jiguang.b.b;

import cn.jiguang.b.a.a;
import cn.jiguang.c.d;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    private static j j = null;
    private static Pattern k;
    private static final String[] z;
    List<String> a = new ArrayList();
    List<String> b = new ArrayList();
    String c;
    String d;
    int e;
    List<String> f = new ArrayList();
    List<Integer> g = new ArrayList();
    String h;
    boolean i = false;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 13;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "zzgi^X;zj\u001bLz|v^\u001cr~v\u0016\r;#%V]r`%RL5";
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
            case 0: goto L_0x00d4;
            case 1: goto L_0x00d8;
            case 2: goto L_0x00dc;
            case 3: goto L_0x00e0;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 59;
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
        r1 = "iuk}KYxz`_\u001c6.lUJzbl_\u001chgv\u001b\u0011;guH\u001cz|wZE;b`U\u001cr}%\u000b";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "iuk}KYxz`_\u001c6.LUJzbl_\u001chgv\u001b\u0011;`j\u001bUk}%PYb ";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "or}LUZt";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "zzgi^X;zj\u001bLz|v^\u001ct~ZXSu`%\u0016\u001c";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "rt.jK\u001cxakU\u0012";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "SkQfTRu}?";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "SkQfTRu}";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "SkQfTRu}%RO;`pWP";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "Uk}?";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "Uk}%RO;`pWP";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "Uk}";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "iuk}KYxz`_\u001d:/%qoT@@C_~~qRSu4";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        j = r0;
        r0 = "\u00143U5\u0016\rF1^\u000b\u0011\"S~\n\u0010)sY\u0015\u0015g&7`\f6:X`\f67Xg\u00122r-\t\t@>(\u000eaG ,\u0012G(s-\u0013g+#4f\u0003@>(\u0002a`?)\tA2r-\tg+#1fg+#<f\u0015g&7\u000eg+#0f\u00152";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        r3 = 1;
        if (r1 > r3) goto L_0x00f0;
    L_0x00ba:
        r3 = r0;
        r4 = r2;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x00bf:
        r6 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x00e3;
            case 1: goto L_0x00e6;
            case 2: goto L_0x00e9;
            case 3: goto L_0x00ec;
            default: goto L_0x00c6;
        };
    L_0x00c6:
        r5 = 59;
    L_0x00c8:
        r5 = r5 ^ r6;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x00ee;
    L_0x00d0:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x00bf;
    L_0x00d4:
        r9 = 60;
        goto L_0x0020;
    L_0x00d8:
        r9 = 27;
        goto L_0x0020;
    L_0x00dc:
        r9 = 14;
        goto L_0x0020;
    L_0x00e0:
        r9 = 5;
        goto L_0x0020;
    L_0x00e3:
        r5 = 60;
        goto L_0x00c8;
    L_0x00e6:
        r5 = 27;
        goto L_0x00c8;
    L_0x00e9:
        r5 = 14;
        goto L_0x00c8;
    L_0x00ec:
        r5 = 5;
        goto L_0x00c8;
    L_0x00ee:
        r1 = r0;
        r0 = r3;
    L_0x00f0:
        if (r1 > r2) goto L_0x00ba;
    L_0x00f2:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        r0 = java.util.regex.Pattern.compile(r0);
        k = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.b.j.<clinit>():void");
    }

    public static boolean c(String str) {
        return k.matcher(str).matches();
    }

    public final String a() {
        return this.d;
    }

    public final void a(String str) {
        int i = 0;
        if (cn.jiguang.e.j.a(str)) {
            str = a.n();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray(z[11]);
            if (jSONArray == null || jSONArray.length() == 0) {
                d.g(z[3], z[10]);
                return;
            }
            d.a(z[3], new StringBuilder(z[9]).append(jSONArray.toString()).toString());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.a.add(jSONArray.optString(i2));
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(z[7]);
            if (jSONArray2 == null || jSONArray2.length() == 0) {
                d.g(z[3], z[8]);
            }
            if (jSONArray2 != null) {
                d.a(z[3], new StringBuilder(z[6]).append(jSONArray2.toString()).toString());
                while (i < jSONArray2.length()) {
                    this.b.add(jSONArray2.optString(i));
                    i++;
                }
            }
        } catch (Throwable e) {
            d.c(z[3], z[12], e);
        }
    }

    public final int b() {
        return this.e;
    }

    public final void b(String str) {
        this.h = str;
        if (this.a == null) {
            d.j(z[3], z[2]);
            this.i = true;
        } else if (this.a.size() == 0) {
            d.j(z[3], z[1]);
            this.i = true;
        } else {
            try {
                k kVar = new k((String) this.a.get(0));
                this.d = kVar.a;
                this.e = kVar.b;
                if (this.b == null) {
                    d.c(z[3], z[5]);
                    return;
                }
                for (String str2 : this.b) {
                    try {
                        kVar = new k(str2);
                        this.f.add(kVar.a);
                        this.g.add(Integer.valueOf(kVar.b));
                    } catch (Throwable e) {
                        d.e(z[3], new StringBuilder(z[4]).append(str2).toString(), e);
                    }
                }
            } catch (Throwable e2) {
                d.d(z[3], z[0], e2);
                this.i = true;
            }
        }
    }

    public final List<String> c() {
        return this.f;
    }

    public final List<Integer> d() {
        return this.g;
    }

    public final boolean e() {
        return this.i;
    }
}
