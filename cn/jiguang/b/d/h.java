package cn.jiguang.b.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.b.a.a;
import cn.jiguang.b.a.d;
import cn.jiguang.b.b.e;
import java.util.HashMap;
import java.util.Map;

public final class h {
    private static volatile h e;
    private static final Object f = new Object();
    private static final String[] z;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private Map<Long, String> g;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 28;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "=\u0004D6<<\u0005M\u0017\n+\u0014D7\fh\u0005H E";
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
            case 0: goto L_0x0159;
            case 1: goto L_0x015d;
            case 2: goto L_0x0161;
            case 3: goto L_0x0165;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
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
            case 25: goto L_0x0142;
            case 26: goto L_0x014d;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "=\u0004D6<<\u0005M\u0017\n+\u0014D7\fh\u0015T0_&\u0018Ud\u0019'\u0002O _;\u0013J2\u001a:\u0004H+\u0011h\u0015Xd\f,\u001cu=\u000f-M";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "d\u0004E/+1\u0007D~";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u00024M-\u001a&\u0003R\f\u001a$\u0007D6";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "=\u0004D6<<\u0005M\u0017\n+\u0014D7\fh\u0015T0_&\u0018Ud\u0019'\u0002O _:\u001eE~";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "&\u0012D _&\u0018Ud";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "&\u0002M(";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "h\u0002R!\r+\u0003S(S&\u0012V!\f<WW!\r;\u001eN*E";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "d\u0012S6\u0010:4N \u001ar";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "'\u0019t7\u001a:4U6\u0013\u000e\u0016H(\u001a,WC1\u000bh\u0019N0_.\u0018T*\u001bh\u0005H E";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "'\u0019t7\u001a:4U6\u0013\u000e\u0016H(\u001a,WC1\u000bh\u0019N0_.\u0018T*\u001bh\u0004E/\t-\u0005R-\u0010&WC=_;\u0013J\u0010\u00068\u0012\u001b";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "'\u0019t7\u001a:4U6\u0013\u000e\u0016H(\u001a,WS-\u001br";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "'\u0019t7\u001a:4U6\u0013\u001c\u001eL!\u0010=\u0003\u00016\u0016,M";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "!\u0004q(\n/\u001eO\u000e\u001e&\u0016M=\u000b!\u0014R\u0017;\u0003M";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "+\u0019\u000f.\u0016/\u0002@*\u0018f\u0016O%\u00131\u0003H'\ff\u0016O \r'\u001eEj\u001e8\u001e\u000f\u000e>&\u0016M=\u000b!\u0014R\r\u0011<\u0012S\"\u001e+\u0012";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = ";\u0012O *;\u0012S\u0007\u000b:\u001bh*\u0019'WR \u0014\u001c\u000eQ!E";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "d\u0007S+\u000f-\u0005U=E";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "d\u0001D66&\u0011N~";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = " \u0016O \u0013-\"R!\r\u000b\u0003S(_.\u0016H(\u001a,[B+\u0011<\u0012Y0_!\u0004\u0001*\n$\u001b";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "!\u0004q(\n/\u001eO\u000e\u000f=\u0004I\u0017;\u0003M";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "+\u0019\u000f.\u000f=\u0004Ij\u001e&\u0013S+\u0016,Y@4\u0016f=q1\f >O0\u001a:\u0011@'\u001a";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "/\u0012Ud\u0016;9D!\u001b\u001d\u0004D6<<\u0005Md\u0019)\u001eM!\u001bd\u0014N*\u000b-\u000fUd\u0016;WO1\u0013$";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u00051";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u001d1";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "!\u0004q(\n/\u001eO\u000e\f \u0016S!,\f<\u001b";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "+\u0019\u000f.\u0016/\u0002@*\u0018f\u0004I%\r-Y@*\u001b:\u0018H Q)\u0007Hj5\u001b\u001f@6\u001a\u0001\u0019U!\r.\u0016B!";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "+\u0019\u000f.\u000f=\u0004Ij\u0016%Y@*\u001b:\u0018H Q)\u0007Hj5\u0005\u0012R7\u001e/\u0012b(\u0016-\u0019U";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "!\u0004q(\n/\u001eO\u000e2-\u0004R%\u0018-$e\u000fE";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        z = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        f = r0;
        return;
    L_0x0159:
        r9 = 72;
        goto L_0x0020;
    L_0x015d:
        r9 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        goto L_0x0020;
    L_0x0161:
        r9 = 33;
        goto L_0x0020;
    L_0x0165:
        r9 = 68;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.h.<clinit>():void");
    }

    private h() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.g = new HashMap();
        this.a = h();
        this.b = i();
        this.c = j();
        this.d = k();
    }

    public static h a() {
        if (e == null) {
            synchronized (f) {
                if (e == null) {
                    e = new h();
                }
            }
        }
        return e;
    }

    private static String a(Context context, String str) {
        b.a();
        String d = b.d(str, "");
        String c = d.c(context, str);
        if (!TextUtils.isEmpty(d) && !d.equals(c)) {
            return d;
        }
        c = z[3];
        StringBuilder append = new StringBuilder(z[5]).append(str).append(z[7]);
        if (TextUtils.isEmpty(d)) {
            d = z[6];
        }
        cn.jiguang.c.d.a(c, append.append(d).toString());
        return "";
    }

    private void a(short s, String str, String str2) {
        cn.jiguang.c.d.c(z[3], new StringBuilder(z[15]).append(str2).append(z[16]).append(s).append(z[17]).append(str).toString());
        long e = d.e(null);
        int a = d.a();
        long g = a.g();
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(0);
        outputDataUtil.writeU8(26);
        outputDataUtil.writeU64(g);
        outputDataUtil.writeU32((long) a);
        outputDataUtil.writeU64(e);
        outputDataUtil.writeU8(s);
        outputDataUtil.writeU8(1);
        outputDataUtil.writeByteArrayincludeLength(str.getBytes());
        outputDataUtil.writeU16At(outputDataUtil.current(), 0);
        byte[] toByteArray = outputDataUtil.toByteArray();
        e.a();
        e.a(toByteArray, SdkType.JCORE.name(), 0);
        this.g.put(Long.valueOf(g), str2);
    }

    public static boolean f() {
        b.a();
        return b.a(0);
    }

    private static boolean h() {
        boolean z = false;
        try {
            Class.forName(z[20]);
            z = true;
        } catch (ClassNotFoundException e) {
            cn.jiguang.c.d.a(z[3], new StringBuilder(z[19]).append(e.getMessage()).toString());
        }
        cn.jiguang.c.d.a(z[3], new StringBuilder(z[19]).append(z).toString());
        return z;
    }

    private static boolean i() {
        boolean z = false;
        try {
            Class.forName(z[26]);
            z = true;
        } catch (ClassNotFoundException e) {
            cn.jiguang.c.d.a(z[3], new StringBuilder(z[27]).append(e.getMessage()).toString());
        }
        cn.jiguang.c.d.a(z[3], new StringBuilder(z[27]).append(z).toString());
        return z;
    }

    private static boolean j() {
        boolean z = false;
        try {
            Class.forName(z[14]);
            z = true;
        } catch (ClassNotFoundException e) {
            cn.jiguang.c.d.a(z[3], new StringBuilder(z[13]).append(e.getMessage()).toString());
        }
        cn.jiguang.c.d.a(z[3], new StringBuilder(z[13]).append(z).toString());
        return z;
    }

    private static boolean k() {
        boolean z = false;
        try {
            Class.forName(z[25]);
            z = true;
        } catch (ClassNotFoundException e) {
            cn.jiguang.c.d.a(z[3], new StringBuilder(z[24]).append(e.getMessage()).toString());
        }
        cn.jiguang.c.d.a(z[3], new StringBuilder(z[24]).append(z).toString());
        return z;
    }

    public final void a(Context context) {
        if (context == null) {
            cn.jiguang.c.d.g(z[3], z[18]);
            return;
        }
        String a = a(context, SdkType.JPUSH.name());
        String a2 = a(context, SdkType.JMESSAGE.name());
        String a3 = a(context, SdkType.JANALYTICS.name());
        String a4 = a(context, SdkType.JSHARE.name());
        if (!TextUtils.isEmpty(a)) {
            a((short) 1, a, SdkType.JPUSH.name());
        }
        if (!TextUtils.isEmpty(a2)) {
            a((short) 2, a2, SdkType.JMESSAGE.name());
        }
        if (!TextUtils.isEmpty(a3)) {
            a((short) 4, a3, SdkType.JANALYTICS.name());
        }
        if (!TextUtils.isEmpty(a4)) {
            a((short) 5, a4, SdkType.JSHARE.name());
        }
    }

    public final void a(Context context, long j) {
        String str = (String) this.g.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.c.d.c(z[3], new StringBuilder(z[4]).append(j).toString());
        } else {
            cn.jiguang.c.d.c(z[3], new StringBuilder(z[0]).append(j).append(z[2]).append(str).toString());
            b.a();
            String d = b.d(str, "");
            if (TextUtils.isEmpty(d)) {
                cn.jiguang.c.d.c(z[3], new StringBuilder(z[1]).append(str).toString());
            } else {
                d.a(context, str, d);
            }
        }
        if (!b(context)) {
            e.a().c();
        }
    }

    public final void a(Context context, long j, int i) {
        String str = (String) this.g.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.c.d.c(z[3], new StringBuilder(z[9]).append(j).toString());
        } else {
            cn.jiguang.c.d.c(z[3], new StringBuilder(z[11]).append(j).append(z[2]).append(str).append(z[8]).append(i).toString());
            b.a();
            if (TextUtils.isEmpty(b.d(str, ""))) {
                cn.jiguang.c.d.c(z[3], new StringBuilder(z[10]).append(str).toString());
            }
        }
        if ((this.g == null || this.g.isEmpty()) && !this.b && !this.a) {
            e.a().c();
        }
    }

    public final String b() {
        return this.b ? z[22] : z[23];
    }

    public final void b(Context context, long j) {
        cn.jiguang.c.d.c(z[3], new StringBuilder(z[12]).append(j).toString());
        this.g.remove(Long.valueOf(j));
        if ((this.g == null || this.g.isEmpty()) && !this.b && !this.a) {
            e.a().c();
        }
    }

    public final boolean b(Context context) {
        if (!(this.b || this.a)) {
            boolean z;
            if (context == null) {
                cn.jiguang.c.d.h(z[3], z[21]);
            } else if (this.c && !TextUtils.isEmpty(a(context, SdkType.JANALYTICS.name()))) {
                z = true;
                if (!z) {
                    return false;
                }
            } else if (this.d && !TextUtils.isEmpty(a(context, SdkType.JSHARE.name()))) {
                z = true;
                if (z) {
                    return false;
                }
            } else if (this.a && !TextUtils.isEmpty(a(context, SdkType.JPUSH.name()))) {
                z = true;
                if (z) {
                    return false;
                }
            } else if (this.b && !TextUtils.isEmpty(a(context, SdkType.JMESSAGE.name()))) {
                z = true;
                if (z) {
                    return false;
                }
            }
            z = false;
            if (z) {
                return false;
            }
        }
        return true;
    }

    public final short c() {
        short s = (short) 0;
        if (this.a) {
            s = (short) 1;
        }
        return this.b ? (a.v() >= 0 || a.u()) ? (short) (s | 32) : (short) (s | 64) : s;
    }

    public final short d() {
        short s = (short) 0;
        if (this.a) {
            s = (short) 1;
        }
        if (this.c) {
            s = (short) (s | 4);
        }
        if (this.d) {
            s = (short) (s | 8);
        }
        return this.b ? (short) (s | 32) : s;
    }

    public final short e() {
        short s = (short) 0;
        if (this.a) {
            s = (short) 1;
        }
        if (this.b) {
            s = (a.v() >= 0 || a.u()) ? (short) (s | 32) : (short) (s | 64);
        }
        if (this.c) {
            s = (short) (s | 4);
        }
        return this.d ? (short) (s | 8) : s;
    }

    public final boolean g() {
        return this.b || this.a;
    }
}
