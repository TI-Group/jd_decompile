package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.a.d;
import cn.jpush.android.a.f;
import cn.jpush.android.b.a;
import cn.jpush.android.d.c;
import cn.jpush.android.d.e;
import com.tencent.smtt.utils.TbsLog;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public abstract class b implements Serializable {
    private static final String[] I;
    private static final long serialVersionUID = 8653272927271926594L;
    public String A;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public int F = -1;
    public ArrayList<String> G = null;
    public String H;
    private boolean a = false;
    public int b;
    public String c;
    public String d;
    public boolean e;
    public int f;
    public int g = 0;
    public boolean h;
    public String i;
    public String j;
    public int k = -1;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public boolean q;
    public List<String> r = null;
    public int s;
    public String t;
    public String u;
    public int v;
    public String w;
    public String x;
    public String y;
    public int z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 26;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "),9iA\u000f(| G]%|9]\u001e0);Q]69:[\b6?,GS";
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
            case 0: goto L_0x013c;
            case 1: goto L_0x0140;
            case 2: goto L_0x0144;
            case 3: goto L_0x0148;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 52;
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
            case 12: goto L_0x00b3;
            case 13: goto L_0x00be;
            case 14: goto L_0x00c9;
            case 15: goto L_0x00d4;
            case 16: goto L_0x00df;
            case 17: goto L_0x00ea;
            case 18: goto L_0x00f5;
            case 19: goto L_0x0100;
            case 20: goto L_0x010b;
            case 21: goto L_0x0116;
            case 22: goto L_0x0121;
            case 23: goto L_0x012c;
            case 24: goto L_0x0137;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "?-;iD\u0014'(<F\u0018d2&@\u0014\"5*U\t-3'\u0014\u000f!/&A\u000f'9iD\u001c04s\u0014";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "8*( @\u0004";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "),9iA\u000f(| G]*3=\u0014\u001cd, W\t1.,\u0014\u000f!/&A\u000f'9:\u001a";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "S.,.";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "S42.";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u00150(9\u000eRk";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "*65=Q]7(&F\u001c#9iQ\u000f63;\u0018]d?;Q\u001c09i]\u0010#|/]\u0011!|/U\u0014(r";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = ".1?*Q\u0018 |=[](3(P]-1(S\u0018dqi";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u001c'( [\u0013~0&U\u0019\f($X4)=.Q/!/&A\u000f'9:\u0014Pd);X-69/]\u0005~";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0013\u001b=%Q\u000f0\u0003=M\r!";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u001c \u0003*[\u001309'@";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0013\u001b> S\"45*k\r%(!";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0013\u001b?&Z\t!2=";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0013\u001b91@\u000f%/";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u001b10%k\u000e'.,Q\u0013";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u0013\u001b,;]\u001265=M";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "4**(X\u0014 |d\u0014\u0018),=M]*3=]\u001b-?(@\u0014+2i@\u001400,\u0014\u001b+.i]\u001309;Z\u001c(";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\u0013\u001b:%U\u001a";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\u0013\u001b/=M\u0011!";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0013\u001b( @\u0011!";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\u0013\u001b> S\"091@";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0013\u001b?(@\u0018#3;M";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "3+(iR\u001212-\u0014\u0013+( R\u0014'= @\u0012*|=]\t(9iR\u00126|-Q\u000b!0&D\u00186|$[\u0019!ria\u000e!|=\\\u0018d=9D\u0011-?(@\u0014+2iZ\u001c)9g";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "\u0013\u001b5'V\u0012<";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "\u001c'( [\u0013~|9U\u000f79i\u0019]&=:Q]!2=]\t=";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        I = r4;
        return;
    L_0x013c:
        r9 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        goto L_0x0020;
    L_0x0140:
        r9 = 68;
        goto L_0x0020;
    L_0x0144:
        r9 = 92;
        goto L_0x0020;
    L_0x0148:
        r9 = 73;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.b.<clinit>():void");
    }

    static String a(Context context, String str, String str2) {
        if (str.endsWith(I[4]) || str.endsWith(I[5])) {
            e.e(I[2], I[0]);
            String str3 = c.b(context, str2) + (str2 + str.substring(str.lastIndexOf(".")));
            e.e(I[2], new StringBuilder(I[1]).append(str3).toString());
            byte[] a = a.a(str, 5, 5000, 4);
            if (a == null) {
                return "";
            }
            try {
                c.a(str3, a);
                return str3;
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
        e.e(I[2], I[3]);
        return "";
    }

    static boolean a(ArrayList<String> arrayList, Context context, String str, String str2, boolean z) {
        e.a(I[2], new StringBuilder(I[9]).append(str).toString());
        if (!f.a(str) || context == null || arrayList.size() <= 0 || TextUtils.isEmpty(str2)) {
            return true;
        }
        Iterator it = arrayList.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            String str3 = (String) it.next();
            String str4 = (str3 == null || str3.startsWith(I[6])) ? str3 : str + str3;
            byte[] a = a.a(str4, 5, 5000, 4);
            if (a != null) {
                try {
                    if (str3.startsWith(I[6])) {
                        str3 = c.a(str3);
                    }
                    str3 = !z ? c.a(context, str2) + str3 : c.b(context, str2) + str3;
                    c.a(str3, a);
                    e.a(I[2], new StringBuilder(I[8]).append(str3).toString());
                } catch (Throwable e) {
                    e.c(I[2], I[7], e);
                    z2 = false;
                }
            } else {
                d.a(str2, 1020, cn.jpush.android.d.a.a(context, str4), context);
                z2 = false;
            }
        }
        return z2;
    }

    public abstract void a(Context context);

    public final boolean a() {
        return this.a;
    }

    public final boolean a(Context context, JSONObject jSONObject) {
        e.a(I[2], I[25]);
        this.q = jSONObject.optInt(I[15], 0) > 0;
        this.s = jSONObject.optInt(I[18], 0);
        this.t = jSONObject.optString(I[20], "");
        this.u = jSONObject.optString(I[13], "");
        this.v = jSONObject.optInt(I[19], 0);
        this.w = jSONObject.optString(I[21], "");
        this.x = jSONObject.optString(I[12], "");
        this.y = jSONObject.optString(I[24], "");
        this.m = jSONObject.optString(I[14], "");
        this.z = jSONObject.optInt(I[16], 0);
        this.A = jSONObject.optString(I[22], "");
        this.k = jSONObject.optInt(I[10], -1);
        if (TextUtils.isEmpty(this.t)) {
            if (this.h) {
                e.c(I[2], I[23]);
                this.t = cn.jpush.android.a.d;
            } else {
                e.c(I[2], I[17]);
                d.a(this.c, TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
                return false;
            }
        }
        JSONObject a = f.a(context, this.c, jSONObject, I[11]);
        if (a == null) {
            return this.h && this.e;
        } else {
            if (this.h && this.e) {
                this.a = true;
            }
            return a(a);
        }
    }

    protected abstract boolean a(JSONObject jSONObject);
}
