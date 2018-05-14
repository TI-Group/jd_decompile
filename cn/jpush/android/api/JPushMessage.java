package cn.jpush.android.api;

import java.io.Serializable;
import java.util.Set;

/* compiled from: TbsSdkJava */
public class JPushMessage implements Serializable {
    private static final long serialVersionUID = 1;
    private static final String[] z;
    private String a;
    private Set<String> b;
    private String c;
    private int d;
    private boolean e;
    private boolean f;
    private int g;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "*wa?~s2|9j;";
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
            case 1: goto L_0x0072;
            case 2: goto L_0x0075;
            case 3: goto L_0x0078;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 15;
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
        r1 = "*wq2je<F;h;p";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "*wf;huj";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "*w{)[g0Q2je<]*jt6f5};";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "L\u0007g)gK2a)na2i;co6ag(";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "*wf;hE?w9dU#s.jT2a/crj";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "*ww(}i%Q5kcj";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0070:
        r9 = 6;
        goto L_0x001f;
    L_0x0072:
        r9 = 87;
        goto L_0x001f;
    L_0x0075:
        r9 = 18;
        goto L_0x001f;
    L_0x0078:
        r9 = 90;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.JPushMessage.<clinit>():void");
    }

    public String getAlias() {
        return this.a;
    }

    public String getCheckTag() {
        return this.c;
    }

    public int getErrorCode() {
        return this.d;
    }

    public int getSequence() {
        return this.g;
    }

    public boolean getTagCheckStateResult() {
        return this.e;
    }

    public Set<String> getTags() {
        return this.b;
    }

    public boolean isTagCheckOperator() {
        return this.f;
    }

    public void setAlias(String str) {
        this.a = str;
    }

    public void setCheckTag(String str) {
        this.c = str;
    }

    public void setErrorCode(int i) {
        this.d = i;
    }

    public void setSequence(int i) {
        this.g = i;
    }

    public void setTagCheckOperator(boolean z) {
        this.f = z;
    }

    public void setTagCheckStateResult(boolean z) {
        this.e = z;
    }

    public void setTags(Set<String> set) {
        this.b = set;
    }

    public String toString() {
        return new StringBuilder(z[4]).append(this.a).append('\'').append(z[2]).append(this.b).append(z[1]).append(this.c).append('\'').append(z[6]).append(this.d).append(z[5]).append(this.e).append(z[3]).append(this.f).append(z[0]).append(this.g).append('}').toString();
    }
}
