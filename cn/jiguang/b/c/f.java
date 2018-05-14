package cn.jiguang.b.c;

import android.support.v4.internal.view.SupportMenu;
import cn.jiguang.c.d;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u000f%G\u001et-&RK|<`CQb<3\u0013[b:/A\u001eg!4[\u001eD-8Gnq:3V{h+%CJy'.";
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
            case 0: goto L_0x0070;
            case 1: goto L_0x0073;
            case 2: goto L_0x0076;
            case 3: goto L_0x0079;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 16;
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
        r1 = ";2E\u0004";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u000f%G\u001et-&RK|<`CQb<3\u0013[b:/A\u001eg!4[\u001eY\u0007\u0005K]u84ZQ~r";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u000f%G\u001et-&RK|<`CQb<3\u0013[b:/A\u001eg!4[\u001e^)-Vj'\f\\Pw\r8P[`<)\\P";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u000f%G\u001et-&RK|<`CQb<3\u0013[b:/A\u001eg!4[\u001eE&+]Qg&\b\\Md\r8P[`<)\\P*";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\f\u000e`mb>\u0015GW|;";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u000f%G\u001et-&RK|<`CQb<3\u0013[b:/A\u001eg!4[\u001eU0#VNd!/]";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0070:
        r9 = 72;
        goto L_0x001f;
    L_0x0073:
        r9 = 64;
        goto L_0x001f;
    L_0x0076:
        r9 = 51;
        goto L_0x001f;
    L_0x0079:
        r9 = 62;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.c.f.<clinit>():void");
    }

    public static List<p> a(String str) {
        List<p> arrayList = new ArrayList();
        try {
            String[] a = o.b().a();
            byte[] b = h.a(m.a(j.a(j.a(str), j.a), 33, 1)).b(SupportMenu.USER_MASK);
            int length = a.length;
            int i = 0;
            while (i < length) {
                try {
                    h hVar = new h(r.a(null, new InetSocketAddress(InetAddress.getByName(a[i]), 53), b, System.currentTimeMillis() + 1000));
                    m a2 = hVar.a();
                    if (a2 == null) {
                        break;
                    }
                    l[] a3 = hVar.a(1);
                    for (int i2 = 0; i2 < a3.length; i2++) {
                        if (a3[i2].b().e() == a2.e()) {
                            int d = a3[i2].b().d();
                            j b2 = a3[i2].b().b();
                            if (d == a2.c() && b2.equals(a2.b())) {
                                Iterator a4 = a3[i2].a();
                                while (a4.hasNext()) {
                                    p pVar = (p) a4.next();
                                    if (pVar.h() > 0) {
                                        arrayList.add(pVar);
                                    }
                                    d.c(z[5], new StringBuilder(z[1]).append(pVar.toString()).toString());
                                }
                            }
                        }
                    }
                    i++;
                } catch (UnknownHostException e) {
                    d.h(z[5], new StringBuilder(z[4]).append(e.getMessage()).toString());
                } catch (IOException e2) {
                    d.h(z[5], new StringBuilder(z[2]).append(e2.getMessage()).toString());
                }
            }
        } catch (s e3) {
            d.h(z[5], z[0]);
        } catch (k e4) {
            d.h(z[5], z[3]);
        } catch (Exception e5) {
            d.h(z[5], z[6]);
        }
        return arrayList;
    }
}
