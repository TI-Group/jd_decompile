package cn.jiguang.b.d;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.a.c.b;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JResponse;
import cn.jiguang.b.b.e;
import cn.jiguang.b.e.a.a.a;
import cn.jiguang.b.e.a.a.c;
import cn.jiguang.c.d;
import java.nio.ByteBuffer;

public class i implements JAction {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 15;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "d`\u0000!4";
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
            case 0: goto L_0x00c2;
            case 1: goto L_0x00c6;
            case 2: goto L_0x00ca;
            case 3: goto L_0x00ce;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 2;
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
            case 8: goto L_0x0086;
            case 9: goto L_0x0091;
            case 10: goto L_0x009c;
            case 11: goto L_0x00a7;
            case 12: goto L_0x00b2;
            case 13: goto L_0x00bd;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = ": czl\u0014-Efm;nSzl1\"T/k&n_zn9";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "6 \u001fer =Y!c;*C`k1`Xav0 E!P\u0010\u001e~]V";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "'+A`p!`Twv'/\u001ffl3!";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "4-Efm;";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0006+Cyk6+\u0011mw;*]j\"xn";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0014\u001cDaC6:X`l";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "u>Zh8";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "'+A`p!";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        r2 = 9;
        r1 = "7;_kn0t";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0086:
        r3[r2] = r1;
        r2 = 10;
        r1 = "&+_kV:\u001aYfp1nCjq%!_|gu-^bo4 U//u";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0091:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u001f\r^}g\u0014-Efm;";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009c:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0014-Efm;n\u001c/p0-Tft0*r`o8/_k\"  Twa0>Ejfuc\u0011}g&>^aq0nFnqu Dcn";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a7:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0007+Rjk#+U/g'<^}\"'+Bm;=T//u-^kgo";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b2:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0014-Efm;n\u001c/j4 U]g&>^aq0n\u0011}g&>^aq0t";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00bd:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00c2:
        r9 = 85;
        goto L_0x001f;
    L_0x00c6:
        r9 = 78;
        goto L_0x001f;
    L_0x00ca:
        r9 = 49;
        goto L_0x001f;
    L_0x00ce:
        r9 = 15;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.i.<clinit>():void");
    }

    public long dispatchMessage(Context context, long j, int i, Object obj, ByteBuffer byteBuffer) {
        JResponse a = a.a((c) obj, byteBuffer);
        if (a != null) {
            d.b(z[11], new StringBuilder(z[14]).append(a.toString()).toString());
            if (a.code == 0) {
                switch (a.getCommand()) {
                    case 19:
                        e.a().a(a, j);
                        break;
                    case 25:
                        cn.jiguang.a.c.a.a(context, e.a().b(), j, a);
                        break;
                    case 26:
                        if (a.code != 0) {
                            h.a().a(context, a.getRid().longValue(), a.code);
                            break;
                        }
                        h.a().a(context, a.getRid().longValue());
                        break;
                    default:
                        d.g(z[11], new StringBuilder(z[10]).append(a.getCommand()).toString());
                        break;
                }
            }
            d.h(z[11], new StringBuilder(z[13]).append(a.code).toString());
        } else {
            d.g(z[11], z[12]);
        }
        return a.getHead().b().longValue();
    }

    public void dispatchTimeOutMessage(Context context, long j, long j2, int i) {
        if (i == 26) {
            h.a().b(context, j2);
        }
    }

    public IBinder getBinderByType(String str) {
        return null;
    }

    public String getSdkVersion() {
        return z[0];
    }

    public void handleMessage(Context context, long j, Object obj) {
    }

    public boolean isSupportedCMD(int i) {
        return i == 0 || i == 1 || i == 19 || i == 25 || i == 26;
    }

    public void onActionRun(Context context, long j, Bundle bundle, Object obj) {
        b.a();
        d.d(z[6], new StringBuilder(z[7]).append(cn.jiguang.b.a.c).toString());
        d.d(z[6], new StringBuilder(z[9]).append(bundle).toString() != null ? bundle.toString() : "");
        if (bundle != null) {
            d.a(z[6], new StringBuilder(z[5]).append(bundle.toString()).toString());
            if (z[2].equals(bundle.getString(z[4]))) {
                String string = bundle.getString(z[8]);
                String string2 = bundle.getString(z[3]);
                cn.jiguang.a.a.c.e.a();
                cn.jiguang.a.a.c.e.a(context, string, string2);
                return;
            }
            return;
        }
        d.c(z[6], z[1]);
    }

    public void onEvent(Context context, long j, int i) {
    }
}
