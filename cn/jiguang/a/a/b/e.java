package cn.jiguang.a.a.b;

import android.text.TextUtils;
import cn.jiguang.c.d;
import org.json.JSONException;
import org.json.JSONObject;

final class e {
    private static final String[] z;
    private double a;
    private double b;
    private double c;
    private float d;
    private float e;
    private String f;
    private long g;
    private boolean h;
    private String i;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 11;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\ni%;d";
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
            case 0: goto L_0x0096;
            case 1: goto L_0x0099;
            case 2: goto L_0x009c;
            case 3: goto L_0x009f;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 1;
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
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u000f|8";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = ")N\u0003\u0018D\u001b~)&u\nr\"v";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0002q8";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "$m?\u001fo\u0005r\u00017o\u0002z)$";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u000fs+";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0002~/";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u0017|+";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0001x-$";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\nn\u00007r\u0017V\"9v\r";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0086:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0005|%:d\u0007=.3b\u0002h?3!Y=";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0091:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0096:
        r9 = 99;
        goto L_0x001f;
    L_0x0099:
        r9 = 29;
        goto L_0x001f;
    L_0x009c:
        r9 = 76;
        goto L_0x001f;
    L_0x009f:
        r9 = 86;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.e.<clinit>():void");
    }

    public e(double d, double d2, double d3, float f, float f2, String str, long j, boolean z) {
        this.a = d;
        this.b = d2;
        this.c = d3;
        this.d = f;
        this.e = f2;
        this.f = str;
        this.g = j;
        this.h = z;
    }

    public e(String str) {
        this.i = str;
    }

    static /* synthetic */ boolean a(double d, double d2) {
        return d > -90.0d && d < 90.0d && d2 > -180.0d && d2 < 180.0d;
    }

    public final JSONObject a() {
        if (TextUtils.isEmpty(this.i)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(z[1], this.a);
                jSONObject.put(z[5], this.b);
                jSONObject.put(z[3], this.c);
                jSONObject.put(z[8], (double) this.d);
                jSONObject.put(z[6], (double) this.e);
                jSONObject.put(z[7], this.f);
                jSONObject.put(z[0], this.g);
                return jSONObject;
            } catch (JSONException e) {
                d.g(z[4], e.getMessage());
                this.i = new StringBuilder(z[2]).append(e.getMessage()).toString();
            }
        }
        return null;
    }

    public final String b() {
        JSONObject a = a();
        if (a == null || a.length() <= 0) {
            return new StringBuilder(z[10]).append(this.i).toString();
        }
        try {
            a.put(z[0], c.b(this.g * 1000));
            a.put(z[9], this.h);
        } catch (JSONException e) {
            d.g(z[4], e.getMessage());
        }
        return a.toString();
    }
}
