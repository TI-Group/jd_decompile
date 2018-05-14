package cn.jpush.android.api;

import java.util.Set;

/* compiled from: TbsSdkJava */
public final class a {
    private static final String[] z;
    public String a;
    public Set<String> b;
    public TagAliasCallback c;
    public int d;
    public int e = 0;
    public int f = 0;
    private long g;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "v8\u0002;\u0010.w&0\u000f?%";
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
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
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
        r1 = "v8\u0013*\u000b3w\u001ct";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "v8\u0013%\u0016;kOn";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "v8\u0006(\u0018)%";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "v8\u0001,\u000e/}\u001c*\u001ag";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "v8\u0006(\u0018\u001bt\u001b(\f\u0019y\u001e%=;{\u0019t";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0019y\u001e%=;{\u0019\u0019\u001e(y\u001f:\u0004)}\u001c-+3u\u0017t";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0070:
        r9 = 90;
        goto L_0x001f;
    L_0x0073:
        r9 = 24;
        goto L_0x001f;
    L_0x0076:
        r9 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        goto L_0x001f;
    L_0x0079:
        r9 = 73;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.a.<clinit>():void");
    }

    public a(int i, String str, long j, int i2, int i3) {
        this.d = i;
        this.a = str;
        this.g = j;
        this.e = i2;
        this.f = i3;
    }

    public a(int i, Set<String> set, long j, int i2, int i3) {
        this.d = i;
        this.b = set;
        this.g = j;
        this.e = i2;
        this.f = i3;
    }

    public a(String str, Set<String> set, TagAliasCallback tagAliasCallback, long j, int i, int i2) {
        this.a = str;
        this.b = set;
        this.c = tagAliasCallback;
        this.g = j;
        this.e = i;
        this.f = i2;
    }

    public final boolean a(long j) {
        return this.e == 0 && System.currentTimeMillis() - this.g > 30000;
    }

    public final String toString() {
        return new StringBuilder(z[6]).append(this.g).append(z[2]).append(this.a).append('\'').append(z[3]).append(this.b).append(z[5]).append(this.c).append(z[4]).append(this.d).append(z[0]).append(this.e).append(z[1]).append(this.f).append('}').toString();
    }
}
