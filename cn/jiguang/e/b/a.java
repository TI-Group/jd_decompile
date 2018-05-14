package cn.jiguang.e.b;

import android.text.TextUtils;
import org.json.JSONObject;

public final class a {
    private static final String[] z;
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "X}1\u0001M";
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
        r9 = 41;
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
        r1 = "Xs7\u0001";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "Xs!\u0001";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u001d>\"\u0000F_{\u0006\u0011YT#";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "bw?!GWq)\fLGw1\rvXzoO";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u001d>!\u0001D~n7\u001a]^l\u001c\tDT#u";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u001d>;\u0005ZX#u";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001d><\r]Fq \u0003fA{ \t]^l\u001c\tDT#u";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u001d>;\u000bJXzoO";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u001d>;\u0005LX#u";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x008c:
        r9 = 49;
        goto L_0x0020;
    L_0x008f:
        r9 = 30;
        goto L_0x0020;
    L_0x0092:
        r9 = 82;
        goto L_0x0020;
    L_0x0095:
        r9 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.b.a.<clinit>():void");
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[1], TextUtils.isEmpty(this.b) ? "" : this.b);
            jSONObject.put(z[0], TextUtils.isEmpty(this.e) ? "" : this.e);
            jSONObject.put(z[2], TextUtils.isEmpty(this.c) ? "" : this.c);
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    public final String toString() {
        return new StringBuilder(z[4]).append(this.a).append('\'').append(z[9]).append(this.b).append('\'').append(z[6]).append(this.c).append('\'').append(z[3]).append(this.d).append(z[8]).append(this.e).append('\'').append(z[5]).append(this.f).append('\'').append(z[7]).append(this.g).append('\'').append('}').toString();
    }
}
