package cn.jiguang.a.a.b;

import android.net.wifi.ScanResult;
import cn.jiguang.b.a.a;
import cn.jiguang.c.d;
import cn.jiguang.e.j;
import org.json.JSONObject;

public final class i implements Comparable<i> {
    private static final String[] z;
    public final String a;
    public final int b;
    public final String c;
    final /* synthetic */ h d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0015q\t8]l]";
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
        r9 = 22;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "n8\u001c\"_W7\u00150tJ\"\u0013/+\u001e";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0015q\u001e\t{\u0004";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "P%\u0013&s";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "X6\u001f";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "J\"\u0013/";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "T0\u0019\u0014w]5\b.eJ";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "n8\u001c\"_W7\u0015\u0006wW0\u001d.d";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "J8\u001d%wU\u000e\t?d\\?\u001d?~";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "N8\u001c\"IM>\r.d\u0003";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x008c:
        r9 = 57;
        goto L_0x0020;
    L_0x008f:
        r9 = 81;
        goto L_0x0020;
    L_0x0092:
        r9 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        goto L_0x0020;
    L_0x0095:
        r9 = 75;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.i.<clinit>():void");
    }

    public i(h hVar, ScanResult scanResult) {
        this.d = hVar;
        this.a = scanResult.BSSID;
        this.b = scanResult.level;
        this.c = j.c(scanResult.SSID);
    }

    public i(h hVar, String str, int i, String str2) {
        this.d = hVar;
        this.a = str;
        this.b = i;
        this.c = j.c(str2);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[6], this.a);
            jSONObject.put(z[8], this.b);
            jSONObject.put(z[5], this.c);
            jSONObject.put(z[4], 0);
            jSONObject.put(z[3], a.q());
        } catch (Throwable e) {
            d.e(z[7], z[9], e);
        }
        return jSONObject;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return ((i) obj).b - this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.c != null && this.c.equals(iVar.c) && this.a != null && this.a.equals(iVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() ^ this.a.hashCode();
    }

    public final String toString() {
        return new StringBuilder(z[1]).append(this.a).append('\'').append(z[2]).append(this.b).append(z[0]).append(this.c).append('\'').append('}').toString();
    }
}
