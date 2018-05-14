package cn.jiguang.a.c;

import android.content.Context;
import cn.jiguang.a.a.b.f;
import cn.jiguang.a.a.c.a;
import cn.jiguang.a.a.c.h;
import cn.jiguang.a.b.b;
import cn.jiguang.android.ShareValues;
import cn.jiguang.b.d.o;
import cn.jiguang.c.d;
import cn.jiguang.e.n;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static int a = 20480;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 38;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "N\u001cWr\u001ahYrn\rnYfm\u0018oYti\th\fT";
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
            case 0: goto L_0x01c4;
            case 1: goto L_0x01c8;
            case 2: goto L_0x01cc;
            case 3: goto L_0x01d0;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
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
            case 27: goto L_0x0158;
            case 28: goto L_0x0163;
            case 29: goto L_0x016e;
            case 30: goto L_0x0179;
            case 31: goto L_0x0184;
            case 32: goto L_0x018f;
            case 33: goto L_0x019a;
            case 34: goto L_0x01a5;
            case 35: goto L_0x01b0;
            case 36: goto L_0x01bb;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "N\u001cWr\u001ah1Bq\u0018y\u000b";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "N\u001cWr\u001ahYkr\u000b}\rNr\u0006<\u0010I{\u0007";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "n\u001cWr\u001ah5H~\th\u0010Hs!r\u001fH=\u000e}\u0010Kx\f<\u001cUo\u0007nC";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "}\u001aSt\u0007rCUx\u0018s\u000bSR\u0018y\u000bFi\u0001s\u0017\u00070H\u0016Ii\rr\r\u001d";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "R,kQH\u0016Ii\rd\r";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "Z\u0018NqHh\u0016\u0007n\u001c}\u000bS=\u0007h\u0011BoH}\tW=\u000b}\fTx\f<\u001b^='i\rh{%y\u0014Ho\u00112";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "K0aT";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "p\u0018Ti7n\u001cWr\u001ah&Cx\u001eu\u001aBB\u0001r\u001fH";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "V8I|\u0004e\rN~\u001b_\u0016Jp\u0007r:Hs\u000eu\u001eT";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "}\tWB\u001ai\u0017It\u0006{&Dr\u0004p\u001cDi7l\u000bH~\ro\nxi\u0011l\u001c";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "n\u001cWr\u001ah4F~$u\nST\u0006z\u0016\u0007x\u001as\u0016U3";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "}\tWB\u001ai\u0017It\u0006{&Dr\u0004p\u001cDi7}\tWB\u001ce\tB";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "r\u001bxq\to\rSt\u0005y";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "p\u0018Ti7\u0016Kq\r\rNr\u0006C\u0015H~\th\u0010Hs";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "l\u001cUt\u0007x-Fn\u0003oYA|\u0001p\u001cC1\u0001o/Fq\u0001x+Bz\u0001o\rBo\rxCA|\u0004o\u001c";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "}\tWB\u001ai\u0017It\u0006{&Dr\u0004p\u001cDi7y\u0017F\u0004y";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "l\u001cUt\u0007x-Fn\u0003oW\t3";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "r\u001bxh\u0018p\u0016Fy";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "0\u0017HjR";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "}\tWB\u001ai\u0017It\u0006{&K|\u001bh&Dr\u0004p\u001cDi7h\u0010Jx";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "p\u0016D|\u001cu\u0016IB\u000bs\u0015Kx\u000bh&Ao\rm\fBs\u000be";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "}\tWB\u001ai\u0017It\u0006{&Dr\u0004p\u001cDi7u\u0017Sx\u001aj\u0018K";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u0018I=\u0006s\r\u0007|\u0004p\u0016P=\u000fy\r\u0007p\u0007~\u0010KxHl\u0011Hs\r<\u0017Rp\ny\u000b";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "p\u001bTB\u001ay\tHo\u001cC\u001cI|\np\u001c";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "p\u0018Ti7\u0011B~\u0003C\fTx\u001a}\tWB\u001bh\u0018Sh\u001b";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "u\ndr\u0004p\u001cDi\u0001s\u0017kr\u000b}\rNr\u0006R\u001cBy\rxYK|\u001bhC";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "0YC|\u001c}YTt\u0012yC\u00070H";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "l\u0018Dv\t{\u001c\u0007t\u0006z\u0016\u0007i\u0007h\u0018K=\u0006i\u0014\u00070H";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "I\u0017Be\u0018y\u001aSx\f=YmM\u001do\u0011\u0007u\to\u0017\u0000iH~\u001cBsHn\u001c@t\u001bh\u001cU1H{\u0010QxHi\t\u0007i\u0000u\n\u0007o\rl\u0016Ui";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "\u0016Ii\rd\r\u0007y\u0001xYIr\u001c<\u0010It\u001c0YUx\u001ci\u000bI";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "[\u0016S=\"O6iX\u0010\u001cWi\u0001s\u0017\u0007j\u0000y\u0017\u0007o\rl\u0016UiH}\tWq\u0001o\r\t";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "}\tWB\u0004u\nS";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "}\u0017Co\u0007u\u001dxm\rn\u0014Nn\u001bu\u0016In";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "_\u0018I=\u0006s\r\u0007z\rhYFs\u0011<\tBp\u0001o\nNr\u0006";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "g[Sr\u001c}\u0015\u0005'MxU\u0005m\t{\u001c\u0005'MxU\u0005n\rr\u001dBo\u0001x[\u001d?Mo[\u000b?\u001du\u001d\u0005'MoU\u0005m\rn\u0014Nn\u001bu\u0016IB\u0004u\nS?R9\nZ";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "}\u001aSt\u0007rCUx\u0018s\u000bSM\rn\u0014Nn\u001bu\u0016IT\u0006z\u0016";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "0[";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        z = r4;
        r0 = 20480; // 0x5000 float:2.8699E-41 double:1.01185E-319;
        a = r0;
        return;
    L_0x01c4:
        r9 = 28;
        goto L_0x0020;
    L_0x01c8:
        r9 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x0020;
    L_0x01cc:
        r9 = 39;
        goto L_0x0020;
    L_0x01d0:
        r9 = 29;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.c.c.<clinit>():void");
    }

    public static void a(Context context) {
        d.c(z[1], z[2]);
        try {
            f.a(context);
        } catch (Throwable th) {
            d.i(z[1], new StringBuilder(z[3]).append(th).toString());
        }
    }

    public static void a(Context context, String str) {
        d.c(z[1], z[0]);
        new a(context, str).start();
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (!cn.jiguang.b.a.d.f(context)) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException(z[5]);
        } else if (jSONObject != null && jSONObject.length() > 0) {
            o.a(context, jSONObject);
            d.c(z[1], new StringBuilder(z[4]).append(jSONObject.toString()).toString());
        }
    }

    public static void b(Context context) {
        if (!cn.jiguang.b.a.d.f(context)) {
            d.g(z[1], z[29]);
        } else if (context == null) {
            d.g(z[1], z[30]);
        } else {
            JSONArray b = cn.jiguang.a.a.c.d.b(context);
            if (b != null && b.length() != 0) {
                int length = b.length();
                int length2 = b.toString().length();
                d.e(z[1], new StringBuilder(z[28]).append(length).append(z[27]).append(length2).toString());
                JSONObject a;
                if (length2 <= a) {
                    a = cn.jiguang.e.a.a(z[32], b);
                    if (a != null && a.length() > 0) {
                        o.a(context, a);
                        return;
                    }
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                while (i < length) {
                    try {
                        jSONArray.put(b.getJSONObject(i));
                    } catch (JSONException e) {
                        d.i(z[1], z[31]);
                    }
                    if (jSONArray.toString().length() > a || length - 1 == i) {
                        a = cn.jiguang.e.a.a(z[32], jSONArray);
                        if (a != null && a.length() > 0) {
                            o.a(context, a);
                        }
                        jSONArray = new JSONArray();
                    }
                    i++;
                }
            }
        }
    }

    public static void c(Context context) {
        d.a(z[1], z[36]);
        String[] a = cn.jiguang.a.a.c.d.a(context);
        if (a == null || a.length == 0) {
            d.i(z[1], z[34]);
            return;
        }
        int length = a.length;
        String str = "[";
        String i = cn.jiguang.b.a.d.i(context);
        long e = cn.jiguang.b.a.d.e(context);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            String str2 = a[i2];
            str = i3 == 0 ? str + "\"" + str2 + "\"" : str + z[37] + str2 + "\"";
            int i5 = i2 + 1;
            i2 = i3 + 1;
            if (i2 >= 50 || str.length() > 1000 || i5 == length) {
                String str3 = str + "]";
                str3 = String.format(Locale.ENGLISH, z[35], new Object[]{Integer.valueOf(length), Integer.valueOf(i4), i, Long.valueOf(e), str3});
                d.c(z[1], str3);
                o.a(context, cn.jiguang.e.a.a(z[33], str3));
                str = "[";
                i4++;
                i2 = 0;
            }
            i3 = i2;
            i2 = i5;
        }
    }

    public static void d(Context context) {
        d.f(z[1], z[17]);
        if (cn.jiguang.b.a.d.f(context)) {
            ShareValues b = cn.jiguang.b.a.d.b(context, new ShareValues().b(z[8], Long.valueOf(0)).b(z[24], Boolean.valueOf(true)).b(z[14], Long.valueOf(0)).b(z[21], Long.valueOf(900000)).b(z[25], Long.valueOf(0)).b(z[18], Boolean.valueOf(false)).b(z[13], Long.valueOf(0)).b(z[16], Boolean.valueOf(true)).b(z[22], Long.valueOf(900000)).b(z[20], Long.valueOf(0)).b(z[12], Integer.valueOf(1)).b(z[10], Integer.valueOf(1)));
            ShareValues shareValues = new ShareValues();
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = currentTimeMillis - ((Long) b.a(z[8], Long.valueOf(0))).longValue() > 86400000;
            boolean booleanValue = ((Boolean) b.a(z[24], Boolean.valueOf(true))).booleanValue();
            Object obj = null;
            if (booleanValue) {
                long longValue = ((Long) b.a(z[14], Long.valueOf(0))).longValue();
                d.c(z[9], new StringBuilder(z[26]).append(longValue).append(z[19]).append(currentTimeMillis).toString());
                if (longValue <= 0) {
                    shareValues.b(z[14], Long.valueOf(currentTimeMillis));
                } else if (currentTimeMillis - longValue >= ((Long) b.a(z[21], Long.valueOf(900000))).longValue()) {
                    shareValues.b(z[14], Long.valueOf(currentTimeMillis));
                    int i = 1;
                }
            }
            boolean z2 = false;
            if (currentTimeMillis - ((Long) b.a(z[25], Long.valueOf(0))).longValue() > 3600000) {
                shareValues.b(z[25], Long.valueOf(currentTimeMillis));
                z2 = true;
            }
            boolean booleanValue2 = ((Boolean) b.a(z[18], Boolean.valueOf(false))).booleanValue();
            if (booleanValue2) {
                booleanValue2 = cn.jiguang.e.a.c(context).toUpperCase().startsWith(z[7]);
                if (booleanValue2) {
                    booleanValue2 = currentTimeMillis - ((Long) b.a(z[13], Long.valueOf(0))).longValue() > 3600000;
                }
            } else {
                d.a(z[9], z[23]);
            }
            boolean booleanValue3 = ((Boolean) b.a(z[16], Boolean.valueOf(true))).booleanValue();
            int i2 = 1;
            int i3 = 1;
            if (booleanValue3) {
                long longValue2 = ((Long) b.a(z[20], Long.valueOf(0))).longValue();
                if (longValue2 <= 0) {
                    booleanValue3 = false;
                    shareValues.b(z[20], Long.valueOf(currentTimeMillis));
                } else if (currentTimeMillis - longValue2 >= ((Long) b.a(z[22], Long.valueOf(900000))).longValue()) {
                    i2 = ((Integer) b.a(z[12], Integer.valueOf(1))).intValue();
                    i3 = ((Integer) b.a(z[10], Integer.valueOf(1))).intValue();
                    booleanValue3 = (i2 == 0 && i3 == 0) ? false : true;
                    if (booleanValue3) {
                        shareValues.b(z[20], Long.valueOf(currentTimeMillis));
                    }
                } else {
                    booleanValue3 = false;
                }
            }
            cn.jiguang.b.a.d.a(context, shareValues);
            boolean z3 = booleanValue && obj != null;
            b bVar = new b(z, z3, z2, booleanValue2, booleanValue3, i2, i3);
            if (bVar.a) {
                cn.jiguang.a.a.c.b.c(context);
            }
            if (cn.jiguang.b.a.a.a()) {
                cn.jiguang.b.f.c.a(context);
            }
            if (bVar.b) {
                a(context);
            }
            if (bVar.c) {
                a(context, null);
            }
            if (bVar.d) {
                h.a(context);
            }
            if (cn.jiguang.e.a.b(context) && cn.jiguang.e.a.c(context).toUpperCase().startsWith(z[7])) {
                try {
                    cn.jiguang.a.a.a.c.a(context);
                } catch (Throwable th) {
                    d.i(z[1], new StringBuilder(z[11]).append(th.getMessage()).toString());
                }
            }
            if (bVar.e) {
                cn.jiguang.e.d.a(context, bVar.f, bVar.g);
                return;
            }
            return;
        }
        d.c(z[1], z[15]);
    }

    public static void e(Context context) {
        d(context);
        try {
            n.a(context, 3600);
        } catch (OutOfMemoryError e) {
            d.g(z[1], z[6]);
        }
    }
}
