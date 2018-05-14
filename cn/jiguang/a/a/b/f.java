package cn.jiguang.a.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import cn.jiguang.b.a.a;
import cn.jiguang.b.d.o;
import cn.jiguang.c.d;
import cn.jiguang.e.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    private static volatile f b;
    private static final Object c = new Object();
    private static final String[] z;
    protected Handler a;
    private Context d;
    private String e = z[28];
    private boolean f = true;
    private String g = null;
    private String h = null;
    private String i = null;
    private boolean j = false;
    private a k;
    private c l;
    private h m;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 39;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "3%P$,++C4,++A}e)\"Mpj&-N5hgi\u00025~5+Pj";
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
            case 0: goto L_0x01d2;
            case 1: goto L_0x01d6;
            case 2: goto L_0x01da;
            case 3: goto L_0x01de;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 80;
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
            case 37: goto L_0x01c6;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "/2*G(o\"4V5hgi\u00023c)0G(xg3C#,)1N<";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "`('C$e(*";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "A>\bM3m3-M>A&*C7i5";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "4-F";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "o\"(Nph(dL?xg'J1b !F";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "`%7}\"i7+P$S)+U";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "b\"0U?~,\u001bV)|\"";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "`&7V\u000f~\"4M\"x\u0018(M3m3-M>";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "M+(\u0002?jg(M3m3-M>,.*D?,0%Qpb2(N|, -T5,24\u0002\"i7+P$";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "o(*V5b3";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "`('}9b!+";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "x>4G";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "@('C$e(*\u0002>c3dA8m)#G4 g#K&ig1Rp~\"4M\"x";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "{.\"K";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "o\"(N\u0004c0*G\",}";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "h\"(G$ig\"K<ig7W3o\"7Q|,!-N5b&)Gjf71Q8S+&Q\u000fe)\"M~f4+L";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "k77";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "{.\"K\u0004c0!Pp6";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "k77c4h5!Q#6";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "e3-O5";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "o\"(N";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "`('C<S#*Q";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "f71Q8S+&Q\u000fe)\"M~f4+L";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "y)!Z i$0G4,(*\u0002<n4dP5|(6V\u0000~\"4C\"i";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "h\"(G$ig\"K<ig\"C9`\" \u000epj.(G>m*!\u0018:|27J\u000f`%7}9b!+\f:(*";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "`%7\u000f9b!+\u0002<c dA<i&6\u0002#y$'G5h";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "m) P?e#jR5~*-Q#e(*\f\u0011O\u0004\u0001q\u0003S\u0004\u000bc\u0002_\u0002\u001bn\u001fO\u0006\u0010k\u001fB";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "m+(";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "/2*G(o\"4V5hgi\u0002<c(4G\",61K$,!%K<i#dA1y4!\u00022ug~";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "[.\"Kp`\"*E$d}d";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "M$0K?bgi\u0002?b\u0004+N<i$0e\u0000_\u0003+L5";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "@('C$e(*\u0018p";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "`('}3i+(";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "o\"(N\u000fx(3G\"";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "K\"0\u00025~5+Pp`('\u00029b!+";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "`('}'e!-";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "{.\"K\u000fx(3G\"";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "`('}7|4";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        z = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        c = r0;
        return;
    L_0x01d2:
        r9 = 12;
        goto L_0x0020;
    L_0x01d6:
        r9 = 71;
        goto L_0x0020;
    L_0x01da:
        r9 = 68;
        goto L_0x0020;
    L_0x01de:
        r9 = 34;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.f.<clinit>():void");
    }

    private f(Context context) {
        this.d = context;
        this.k = new a(context, this);
        this.m = new h(context, this);
        this.l = new c(context, this);
    }

    public static void a(Context context) {
        if (context == null) {
            d.g(z[3], z[1]);
            return;
        }
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new f(context);
                }
            }
        }
        f fVar = b;
        try {
            if (fVar.a == null) {
                HandlerThread handlerThread = new HandlerThread(z[2]);
                handlerThread.start();
                fVar.a = new g(fVar, handlerThread.getLooper());
            }
            fVar.a.sendEmptyMessage(1000);
        } catch (Throwable th) {
            d.i(z[3], new StringBuilder(z[0]).append(th).toString());
        }
    }

    private boolean a(JSONArray jSONArray, JSONArray jSONArray2, String str) {
        if (j.a(str)) {
            if (!j.a(this.i)) {
                return false;
            }
        } else if (!str.equals(this.i)) {
            return false;
        }
        if (j.a(this.h)) {
            if (!(jSONArray2 == null || jSONArray2.length() == 0)) {
                return false;
            }
        } else if (jSONArray2 == null) {
            return false;
        } else {
            if (jSONArray2.length() == 0) {
                return false;
            }
            if (!this.h.equals(jSONArray2.toString())) {
                return false;
            }
            d.e(z[3], z[5]);
        }
        if (j.a(this.g)) {
            if (!(jSONArray == null || jSONArray.length() == 0)) {
                return false;
            }
        } else if (jSONArray == null) {
            return false;
        } else {
            if (jSONArray.length() == 0) {
                return false;
            }
            try {
                String optString = ((JSONObject) jSONArray.get(0)).optString(z[4]);
                if (!(j.a(optString) || optString.equals(this.g))) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ void b(f fVar) {
        fVar.k.c();
        fVar.m.a();
        fVar.l.b();
    }

    private void c() {
        JSONArray jSONArray = null;
        if (cn.jiguang.b.a.d.f(this.d)) {
            JSONArray c = this.m.c();
            JSONArray b = this.k.b();
            e d = d();
            d.c(z[3], new StringBuilder(z[19]).append(d != null ? d.b() : "").toString());
            d.c(z[3], new StringBuilder(z[18]).append(String.valueOf(c)).toString());
            d.c(z[3], new StringBuilder(z[15]).append(String.valueOf(b)).toString());
            JSONObject a = d != null ? d.a() : null;
            if (a == null && b == null && c == null) {
                d.c(z[3], z[9]);
                return;
            }
            String jSONObject = a != null ? a.toString() : "";
            if (a(c, b, jSONObject)) {
                d.e(z[3], z[13]);
                return;
            }
            JSONArray jSONArray2;
            if (a != null && a.length() > 0) {
                jSONArray2 = new JSONArray();
                jSONArray2.put(a);
                jSONArray = jSONArray2;
            }
            a = new JSONObject();
            try {
                a.put(z[12], z[11]);
                a.put(z[20], a.q());
                a.put(z[7], cn.jiguang.e.a.c(this.d));
                a.put(z[22], cn.jiguang.e.a.c());
                if (c != null && c.length() > 0) {
                    a.put(z[14], c);
                    this.g = ((JSONObject) c.get(0)).optString(z[4]);
                }
                if (b != null && b.length() > 0) {
                    a.put(z[21], b);
                    this.h = b.toString();
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    a.put(z[17], jSONArray);
                    this.i = jSONObject;
                }
                Context context = this.d;
                JSONObject a2 = o.a(context, z[23]);
                JSONObject jSONObject2 = a2 == null ? new JSONObject() : a2;
                jSONArray2 = jSONObject2.optJSONArray(z[10]);
                JSONArray jSONArray3 = jSONArray2 == null ? new JSONArray() : jSONArray2;
                try {
                    Object obj;
                    jSONArray3.put(a);
                    long longValue = ((Long) cn.jiguang.b.a.d.b(context, z[8], Long.valueOf(0))).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue > cn.jiguang.a.b.a.a(context)) {
                        cn.jiguang.b.a.d.a(context, z[8], Long.valueOf(currentTimeMillis));
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null || ((Boolean) cn.jiguang.b.a.d.b(context, z[6], Boolean.valueOf(false))).booleanValue()) {
                        cn.jiguang.a.b.a.b(context, false);
                        cn.jiguang.b.a.d.a(context, z[8], Long.valueOf(System.currentTimeMillis()));
                        o.a(context, jSONArray3);
                        if (o.a(context, z[23], null)) {
                            d.c(z[3], z[26]);
                            return;
                        } else if (context.deleteFile(z[23])) {
                            d.c(z[3], z[16]);
                            return;
                        } else {
                            d.g(z[3], z[25]);
                            return;
                        }
                    }
                    jSONObject2.put(z[10], jSONArray3);
                    o.a(context, z[23], jSONObject2);
                } catch (Throwable e) {
                    d.d(z[3], z[24], e);
                }
            } catch (JSONException e2) {
            }
        }
    }

    static /* synthetic */ void c(f fVar) {
        if (cn.jiguang.e.a.b(fVar.d, z[27])) {
            fVar.k.a();
        } else {
            fVar.a();
        }
    }

    private e d() {
        return this.l != null ? this.l.a() : null;
    }

    protected final void a() {
        this.m.b();
        this.l.a(this.d);
    }

    protected final void b() {
        d.c(z[3], z[31]);
        try {
            if (this.f) {
                JSONObject a;
                if (this.e.equals(z[34])) {
                    if (cn.jiguang.b.a.d.f(this.d)) {
                        a = cn.jiguang.e.a.a(z[33], this.k.b());
                        if (a != null && a.length() > 0) {
                            o.a(this.d, a);
                            d.e(z[3], new StringBuilder(z[32]).append(a).toString());
                        }
                    }
                } else if (this.e.equals(z[37])) {
                    if (cn.jiguang.b.a.d.f(this.d)) {
                        a = cn.jiguang.e.a.a(z[36], this.m.c());
                        if (a != null && a.length() > 0) {
                            o.a(this.d, a);
                            d.e(z[3], new StringBuilder(z[30]).append(a.toString().getBytes().length).toString());
                            d.e(z[3], new StringBuilder(z[32]).append(a).toString());
                        }
                    }
                } else if (this.e.equals(z[17])) {
                    if (cn.jiguang.b.a.d.f(this.d)) {
                        e d = d();
                        a = d != null ? d.a() : null;
                        if (a != null && a.length() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(a);
                            a = cn.jiguang.e.a.a(z[38], jSONArray);
                            if (a != null && a.length() > 0) {
                                o.a(this.d, a);
                                d.e(z[3], new StringBuilder(z[32]).append(a).toString());
                            }
                        }
                    }
                } else if (this.e.equals(z[28])) {
                    c();
                }
                this.j = false;
            }
        } catch (Throwable e) {
            d.e(z[3], z[35], e);
        } finally {
            this.j = false;
        }
        if (this.a != null) {
            this.a.removeCallbacksAndMessages(null);
            try {
                this.a.getLooper().quit();
            } catch (Exception e2) {
                d.i(z[3], new StringBuilder(z[29]).append(e2.getMessage()).toString());
            }
            this.a = null;
        }
    }
}
