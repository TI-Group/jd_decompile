package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.a.b;
import cn.jpush.android.d.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public final class k {
    private static volatile k a;
    private static final Object b = new Object();
    private static final String[] z;
    private ConcurrentHashMap<Long, a> c = new ConcurrentHashMap();

    /* compiled from: TbsSdkJava */
    private class a {
        private static final String[] z;
        public int a;
        public int b;
        public long c;
        public ArrayList<String> d;
        public String e;
        public int f = -1;
        public int g = -1;
        public int h = 0;
        public int i = 0;
        final /* synthetic */ k j;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static {
            /*
            r0 = 8;
            r3 = new java.lang.String[r0];
            r2 = 0;
            r1 = "Oa\u001f%x\u0011\u0011\u001d7o^";
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
                case 0: goto L_0x0079;
                case 1: goto L_0x007c;
                case 2: goto L_0x007f;
                case 3: goto L_0x0082;
                default: goto L_0x001e;
            };
        L_0x001e:
            r9 = 10;
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
                default: goto L_0x003c;
            };
        L_0x003c:
            r3[r2] = r1;
            r2 = 1;
            r1 = "Oa\u001d<c\u00022Aw";
            r0 = 0;
            r3 = r4;
            goto L_0x0009;
        L_0x0044:
            r3[r2] = r1;
            r2 = 2;
            r1 = "7 \u001b\u0011f\n \u000f\u0013k\u0000)\u0019\u0012o\u0002/\u0007 x\f5\u0013\u0004s\u0013$A";
            r0 = 1;
            r3 = r4;
            goto L_0x0009;
        L_0x004c:
            r3[r2] = r1;
            r2 = 3;
            r1 = "Oa\u000e5~\u00118??\r5A";
            r0 = 2;
            r3 = r4;
            goto L_0x0009;
        L_0x0054:
            r3[r2] = r1;
            r2 = 4;
            r1 = "Oa\b?~\u0002-,1m\u0006|";
            r0 = 3;
            r3 = r4;
            goto L_0x0009;
        L_0x005c:
            r3[r2] = r1;
            r2 = 5;
            r1 = "Oa\u001d3~\n.\u0012\u0004s\u0013$A";
            r0 = 4;
            r3 = r4;
            goto L_0x0009;
        L_0x0064:
            r3[r2] = r1;
            r2 = 6;
            r1 = "Oa\u000f5{*\u0005A";
            r0 = 5;
            r3 = r4;
            goto L_0x0009;
        L_0x006c:
            r3[r2] = r1;
            r2 = 7;
            r1 = "Oa\b1m\u0010|";
            r0 = 6;
            r3 = r4;
            goto L_0x0009;
        L_0x0074:
            r3[r2] = r1;
            z = r4;
            return;
        L_0x0079:
            r9 = 99;
            goto L_0x0020;
        L_0x007c:
            r9 = 65;
            goto L_0x0020;
        L_0x007f:
            r9 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
            goto L_0x0020;
        L_0x0082:
            r9 = 80;
            goto L_0x0020;
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.k.a.<clinit>():void");
        }

        public a(k kVar, int i, int i2, long j, ArrayList<String> arrayList, String str) {
            this.j = kVar;
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = arrayList;
            if (i == 1 && this.d == null) {
                this.d = new ArrayList();
            }
            this.e = str;
            this.i = 1;
        }

        public final String toString() {
            return new StringBuilder(z[2]).append(this.a).append(z[5]).append(this.b).append(z[6]).append(this.c).append(z[7]).append(this.d).append(z[1]).append(this.e).append('\'').append(z[4]).append(this.f).append(z[0]).append(this.g).append(z[3]).append(this.h).append('}').toString();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 45;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "O2%\u000ejr21\u0001cl\u00030 rt\u0001';tb\u001b'#v~!";
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
            case 0: goto L_0x0213;
            case 1: goto L_0x0217;
            case 2: goto L_0x021b;
            case 3: goto L_0x021f;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 6;
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
            case 14: goto L_0x00c8;
            case 15: goto L_0x00d3;
            case 16: goto L_0x00de;
            case 17: goto L_0x00e9;
            case 18: goto L_0x00f4;
            case 19: goto L_0x00ff;
            case 20: goto L_0x010a;
            case 21: goto L_0x0115;
            case 22: goto L_0x0120;
            case 23: goto L_0x012b;
            case 24: goto L_0x0136;
            case 25: goto L_0x0141;
            case 26: goto L_0x014c;
            case 27: goto L_0x0157;
            case 28: goto L_0x0162;
            case 29: goto L_0x016d;
            case 30: goto L_0x0178;
            case 31: goto L_0x0183;
            case 32: goto L_0x018e;
            case 33: goto L_0x0199;
            case 34: goto L_0x01a4;
            case 35: goto L_0x01af;
            case 36: goto L_0x01ba;
            case 37: goto L_0x01c5;
            case 38: goto L_0x01d0;
            case 39: goto L_0x01db;
            case 40: goto L_0x01e6;
            case 41: goto L_0x01f1;
            case 42: goto L_0x01fc;
            case 43: goto L_0x0207;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "z06&iusooei6#;cU65\fgx;'\u0001i6norz4\u0003#oz \u0001.es6\f b~i";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "Q\u00037<nX</\"iu";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "O\u0012\u0004=c~)'\nh\u0007+\"c";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "r=! ti6!;&o:/*uo2/?";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "o2%`gw:#<&z06&ius5.u;50*ca6&";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "O\u0012\u0004=c~)'\u001cco\u0007+\"c";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "k20<c;'#(&w:1;&}2+#csooci!-=<";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "|66";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        r2 = 9;
        r1 = "z06&iusooiu\u00062+go6\u0001.es6\f b~0*uk<,<cQ -!<";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0086:
        r3[r2] = r1;
        r2 = 10;
        r1 = "t#";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0091:
        r3[r2] = r1;
        r2 = 11;
        r1 = "o2%\u000ejr21\fgx;'\u0001i6b8ghs,:jw";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009c:
        r3[r2] = r1;
        r2 = 12;
        r1 = "z?+.u";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a7:
        r3[r2] = r1;
        r2 = 13;
        r1 = "7'#(Gw:#<Ez0**Ht7'u";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b2:
        r3[r2] = r1;
        r2 = 14;
        r1 = "o2%<";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00bd:
        r3[r2] = r1;
        r2 = 15;
        r1 = "h6,+&i63:ch'b<sx0'<u";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c8:
        r3[r2] = r1;
        r2 = 16;
        r1 = "n=1:vk<0;&k!-;i;';?c";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d3:
        r3[r2] = r1;
        r2 = 17;
        r1 = "h2/*&o2%`gw:#<&i63:ch'b;ov61oai6#;c;'*.h;ar";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00de:
        r3[r2] = r1;
        r2 = 18;
        r1 = "t=\u0011*h\u0012%.ousoorz4\u0003#oz \u0001.es6\f b~s5.u;=7#j";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00e9:
        r3[r2] = r1;
        r2 = 19;
        r1 = "z06&iusooiu\u0000'!bZ4#&h7s6.aZ?+.uX2!'cU<&*<";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f4:
        r3[r2] = r1;
        r2 = 20;
        r1 = "v22?cs'=tt!\u0001 b~i";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x00ff:
        r3[r2] = r1;
        r2 = 21;
        r1 = "m2.&bz''+";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010a:
        r3[r2] = r1;
        r2 = 22;
        r1 = "}!'*|~s'!b;'+\"c;$#<&r=! ti6!;'";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0115:
        r3[r2] = r1;
        r2 = 23;
        r1 = "l2+;";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0120:
        r3[r2] = r1;
        r2 = 24;
        r1 = "z?.orz41oou5-oqz b#iz7'+";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012b:
        r3[r2] = r1;
        r2 = 25;
        r1 = "z06&iusooEs6!$Gu7\u0011*h\u0012%.oub*ti<0\fi6x";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0136:
        r3[r2] = r1;
        r2 = 26;
        r1 = "o2%\u000ejr21\fgx;'\u0001i6x";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0141:
        r3[r2] = r1;
        r2 = 27;
        r1 = "o<6.j";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014c:
        r3[r2] = r1;
        r2 = 28;
        r1 = "7:,;cu'x";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0157:
        r3[r2] = r1;
        r2 = 29;
        r1 = "o2%\u000ejr21oez0**&l21ohn?.";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0162:
        r3[r2] = r1;
        r2 = 30;
        r1 = "n=1:vk<0;&;#0 rts66v~";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016d:
        r3[r2] = r1;
        r2 = 31;
        r1 = "7'-;gw\u0003#(c!";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0178:
        r3[r2] = r1;
        r2 = 32;
        r1 = "760=ii\u0010-+c!";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0183:
        r3[r2] = r1;
        r2 = 33;
        r1 = "w<#+&u6:;&k2%**;07=tk2%*<";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018e:
        r3[r2] = r1;
        r2 = 34;
        r1 = "; ',iu71";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x0199:
        r3[r2] = r1;
        r2 = 35;
        r1 = "z06&iusooiu\u0007#(Gw:#<T~ 2 hh6nou~\"\u000b\u000b<";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a4:
        r3[r2] = r1;
        r2 = 36;
        r1 = "h66orz4m.jr21ogx'+ h;$+#j;50*ca6b";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01af:
        r3[r2] = r1;
        r2 = 37;
        r1 = "|66oh~+6ovz4'ot~\"7*uos5.u; '!b~7";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01ba:
        r3[r2] = r1;
        r2 = 38;
        r1 = "z06&iusooiu\u0007#(Gw:#<T~ 2 hh6norz4\u0003#oz \u0001.es6\f b~i";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c5:
        r3[r2] = r1;
        r2 = 39;
        r1 = "o2%.jr21\u0010ci!-=et7'";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d0:
        r3[r2] = r1;
        r2 = 40;
        r1 = "}!'*|~s'!b;'+\"c;$#<&|!'.r~s6'gus*.j}s#!&s<7=";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01db:
        r3[r2] = r1;
        r2 = 41;
        r1 = "x&0=";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e6:
        r3[r2] = r1;
        r2 = 42;
        r1 = "i66=;2!;ot=b8ghs1*h6&";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f1:
        r3[r2] = r1;
        r2 = 43;
        r1 = "t=\u0016.aZ?+.uO:/*In'n=cv<4*b;0#,n~=-+c!";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fc:
        r3[r2] = r1;
        r2 = 44;
        r1 = "z06&iusooiu\u0007#(Gw:#<Rr>'\u0000sosx";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0207:
        r3[r2] = r1;
        z = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        b = r0;
        return;
    L_0x0213:
        r9 = 27;
        goto L_0x001f;
    L_0x0217:
        r9 = 83;
        goto L_0x001f;
    L_0x021b:
        r9 = 66;
        goto L_0x001f;
    L_0x021f:
        r9 = 79;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.k.<clinit>():void");
    }

    private static a a(JSONObject jSONObject, a aVar) {
        e.c(z[0], new StringBuilder(z[9]).append(jSONObject).append(z[13]).append(aVar).toString());
        if (aVar == null) {
            e.g(z[0], z[11]);
            return null;
        } else if (!TextUtils.equals(jSONObject.optString(z[10]), z[8])) {
            return aVar;
        } else {
            if (aVar.a == 1) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray(z[14]);
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        return aVar;
                    }
                    Collection arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.getString(i));
                    }
                    if (arrayList.size() <= 0) {
                        return aVar;
                    }
                    aVar.d.addAll(arrayList);
                    return aVar;
                } catch (Throwable th) {
                    e.i(z[0], new StringBuilder(z[7]).append(th).toString());
                    return aVar;
                }
            }
            String optString = jSONObject.optString(z[12]);
            if (optString == null) {
                return aVar;
            }
            aVar.e = optString;
            return aVar;
        }
    }

    public static k a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new k();
                }
            }
        }
        return a;
    }

    protected static boolean a(Context context, int i, long j) {
        if (i == 1 || i == 2) {
            Object obj;
            long j2 = MultiSpHelper.getLong(context, z[3], -1);
            if (j2 > 1800) {
                j2 = 0;
            }
            long j3 = MultiSpHelper.getLong(context, z[6], -1);
            if (j2 == -1 || j3 == -1) {
                obj = null;
            } else if (System.currentTimeMillis() - j3 < 0 || System.currentTimeMillis() - j3 > j2) {
                MultiSpHelper.commitLong(context, z[6], -1);
                MultiSpHelper.commitLong(context, z[3], -1);
                e.g(z[2], z[4]);
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                e.g(z[0], z[5]);
                j.a(context, i, cn.jpush.android.api.JPushInterface.a.u, j);
                return true;
            }
        }
        return false;
    }

    private boolean a(Context context, a aVar) {
        e.c(z[0], new StringBuilder(z[19]).append(aVar).toString());
        if (aVar == null) {
            e.g(z[0], z[18]);
            return false;
        }
        b a;
        if (aVar.a == 1) {
            a = j.a(context, aVar.d, aVar.c, aVar.b, aVar.g);
        } else if (aVar.a == 2) {
            a = j.a(context, aVar.e, aVar.c, aVar.a);
        } else {
            e.c(z[0], z[16]);
            return false;
        }
        if (a == null) {
            return false;
        }
        if (aVar.h > 200) {
            this.c.remove(Long.valueOf(aVar.c));
            j.a(context, aVar.a, cn.jpush.android.api.JPushInterface.a.o, aVar.c);
            e.c(z[0], z[17]);
        } else {
            j.a(context, a);
            aVar.h++;
            this.c.put(Long.valueOf(aVar.c), aVar);
            e.c(z[0], z[15]);
        }
        return true;
    }

    public final int a(long j) {
        e.c(z[0], new StringBuilder(z[44]).append(j).toString());
        a aVar = (a) this.c.remove(Long.valueOf(j));
        e.c(z[0], new StringBuilder(z[43]).append(aVar).toString());
        return aVar != null ? aVar.a : 0;
    }

    public final Intent a(Context context, long j, int i, JSONObject jSONObject, Intent intent) {
        e.c(z[0], new StringBuilder(z[35]).append(j).append(z[32]).append(i).append(z[28]).append(intent).toString());
        a aVar = (a) this.c.get(Long.valueOf(j));
        e.c(z[0], new StringBuilder(z[26]).append(aVar).toString());
        this.c.remove(Long.valueOf(j));
        if (aVar == null) {
            e.g(z[0], z[11]);
            return intent;
        }
        Object obj;
        long optLong;
        e.c(z[0], new StringBuilder(z[25]).append(i).append(z[13]).append(aVar).toString());
        if (i == 1 && aVar.h == 0) {
            aVar.h++;
            if (a(context, aVar.a, aVar.c)) {
                obj = 1;
            } else if (a(context, aVar)) {
                obj = 1;
            }
            if (obj != null) {
                e.c(z[0], z[42]);
                return null;
            } else if (i == 0) {
                if (i == 100) {
                    optLong = jSONObject.optLong(z[23], -1);
                    e.h(z[0], new StringBuilder(z[36]).append(optLong).append(z[34]).toString());
                    if (optLong > 0) {
                        if (optLong >= 0) {
                            e.g(z[2], z[22]);
                        } else {
                            if (optLong > 1800) {
                                e.e(z[2], z[40]);
                                optLong = 1800;
                            }
                            MultiSpHelper.commitLong(context, z[6], System.currentTimeMillis());
                            MultiSpHelper.commitLong(context, z[3], optLong * 1000);
                        }
                    }
                }
                if (aVar.a != 0) {
                    switch (i) {
                        case 1:
                        case 2:
                            i = cn.jpush.android.api.JPushInterface.a.o;
                            break;
                        case 3:
                            i = cn.jpush.android.api.JPushInterface.a.p;
                            break;
                        case 4:
                            i = cn.jpush.android.api.JPushInterface.a.q;
                            break;
                        case 5:
                            i = cn.jpush.android.api.JPushInterface.a.r;
                            break;
                        case 6:
                            i = cn.jpush.android.api.JPushInterface.a.s;
                            break;
                        case 7:
                        case 8:
                            i = cn.jpush.android.api.JPushInterface.a.t;
                            break;
                        case 100:
                            i = cn.jpush.android.api.JPushInterface.a.u;
                            break;
                    }
                }
                intent.putExtra(z[39], i);
                e.c(z[0], new StringBuilder(z[20]).append(i).toString());
                return intent;
            } else {
                aVar.h = 0;
                if (aVar.b == 5) {
                    aVar.f = jSONObject.optInt(z[27], -1);
                    aVar.g = jSONObject.optInt(z[41], -1);
                    a(jSONObject, aVar);
                }
                if (aVar != null) {
                    e.c(z[0], z[29]);
                    obj = null;
                } else {
                    e.c(z[0], new StringBuilder(z[38]).append(aVar).toString());
                    if (aVar.g < aVar.f) {
                        e.c(z[0], z[24]);
                        obj = null;
                    } else {
                        obj = 1;
                    }
                }
                if (obj != null) {
                    aVar.g++;
                    e.c(z[0], new StringBuilder(z[33]).append(aVar.g).append(z[31]).append(aVar.f).toString());
                    if (a(context, aVar.a, aVar.c)) {
                        return null;
                    }
                    if (a(context, aVar)) {
                        e.c(z[0], z[37]);
                        return null;
                    }
                }
                if (aVar.b != 5) {
                    if (aVar.a != 1) {
                        if (aVar.d.size() > 0) {
                            return intent;
                        }
                        intent.putStringArrayListExtra(z[14], aVar.d);
                        return intent;
                    } else if (aVar.a != 2 && aVar.e != null) {
                        intent.putExtra(z[12], aVar.e);
                        return intent;
                    }
                } else if (aVar.b == 6) {
                    return intent;
                } else {
                    if (aVar.a != 1) {
                        intent.putExtra(z[21], jSONObject.optBoolean(z[21], false));
                        return intent;
                    }
                    e.g(z[0], z[30]);
                    return intent;
                }
            }
        }
        obj = null;
        if (obj != null) {
            e.c(z[0], z[42]);
            return null;
        } else if (i == 0) {
            aVar.h = 0;
            if (aVar.b == 5) {
                aVar.f = jSONObject.optInt(z[27], -1);
                aVar.g = jSONObject.optInt(z[41], -1);
                a(jSONObject, aVar);
            }
            if (aVar != null) {
                e.c(z[0], new StringBuilder(z[38]).append(aVar).toString());
                if (aVar.g < aVar.f) {
                    obj = 1;
                } else {
                    e.c(z[0], z[24]);
                    obj = null;
                }
            } else {
                e.c(z[0], z[29]);
                obj = null;
            }
            if (obj != null) {
                aVar.g++;
                e.c(z[0], new StringBuilder(z[33]).append(aVar.g).append(z[31]).append(aVar.f).toString());
                if (a(context, aVar.a, aVar.c)) {
                    return null;
                }
                if (a(context, aVar)) {
                    e.c(z[0], z[37]);
                    return null;
                }
            }
            if (aVar.b != 5) {
                if (aVar.b == 6) {
                    return intent;
                }
                if (aVar.a != 1) {
                    e.g(z[0], z[30]);
                    return intent;
                }
                intent.putExtra(z[21], jSONObject.optBoolean(z[21], false));
                return intent;
            } else if (aVar.a != 1) {
                return aVar.a != 2 ? intent : intent;
            } else {
                if (aVar.d.size() > 0) {
                    return intent;
                }
                intent.putStringArrayListExtra(z[14], aVar.d);
                return intent;
            }
        } else {
            if (i == 100) {
                optLong = jSONObject.optLong(z[23], -1);
                e.h(z[0], new StringBuilder(z[36]).append(optLong).append(z[34]).toString());
                if (optLong > 0) {
                    if (optLong >= 0) {
                        if (optLong > 1800) {
                            e.e(z[2], z[40]);
                            optLong = 1800;
                        }
                        MultiSpHelper.commitLong(context, z[6], System.currentTimeMillis());
                        MultiSpHelper.commitLong(context, z[3], optLong * 1000);
                    } else {
                        e.g(z[2], z[22]);
                    }
                }
            }
            if (aVar.a != 0) {
                switch (i) {
                    case 1:
                    case 2:
                        i = cn.jpush.android.api.JPushInterface.a.o;
                        break;
                    case 3:
                        i = cn.jpush.android.api.JPushInterface.a.p;
                        break;
                    case 4:
                        i = cn.jpush.android.api.JPushInterface.a.q;
                        break;
                    case 5:
                        i = cn.jpush.android.api.JPushInterface.a.r;
                        break;
                    case 6:
                        i = cn.jpush.android.api.JPushInterface.a.s;
                        break;
                    case 7:
                    case 8:
                        i = cn.jpush.android.api.JPushInterface.a.t;
                        break;
                    case 100:
                        i = cn.jpush.android.api.JPushInterface.a.u;
                        break;
                }
            }
            intent.putExtra(z[39], i);
            e.c(z[0], new StringBuilder(z[20]).append(i).toString());
            return intent;
        }
    }

    public final void a(int i, int i2, long j, ArrayList<String> arrayList, String str) {
        a aVar = new a(this, i, i2, j, arrayList, str);
        e.c(z[0], new StringBuilder(z[1]).append(aVar).toString());
        this.c.put(Long.valueOf(j), aVar);
    }

    public final boolean a(int i) {
        if (!(this.c == null || this.c.isEmpty())) {
            for (Entry value : this.c.entrySet()) {
                a aVar = (a) value.getValue();
                if (aVar != null && aVar.a == i) {
                    return false;
                }
            }
        }
        return true;
    }
}
