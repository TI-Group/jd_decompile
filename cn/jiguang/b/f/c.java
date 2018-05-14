package cn.jiguang.b.f;

import android.content.Context;
import android.database.Cursor;
import cn.jiguang.b.a.a;
import cn.jiguang.b.a.g;
import cn.jiguang.b.a.h;
import cn.jiguang.b.d.o;
import cn.jiguang.c.d;
import cn.jiguang.e.j;
import cn.jiguang.e.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 34;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0000\u0005Q\u0013=\u0018\u000fZ]";
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
            case 0: goto L_0x0194;
            case 1: goto L_0x0198;
            case 2: goto L_0x019c;
            case 3: goto L_0x01a0;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 98;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "SJ\u0003G\u000e\u001c\rJ\t=\u0010\u0005P\u0013\u000b\u001e\u000f\u0019G";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "S\u0004L\u0013B\u0016\u0012J\u0014\u0016\u0000J\u0019G\u000b\u001d\u0019F\u0015\u0016";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "S\u0003PG\u0007\u000b\u0003P\u0013\u0011SP\u0003\u0012\u0012\u0017\u000bW\u0002";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u001a\u0004P\u0002\u0010\u0007.B\u0013\u0003";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0000\u0005Q\u0013=\u0018\u000fZGXS";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = ":\u0004G\u0002\u001a \u001eB\u0013\u0011";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001a\u0004P\u0002\u0010\u0007.B\u0013\u0003S\u000f[\u0004\u0007\u0003\u001eJ\b\fI";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0010\u0005V\t\u0016,Y|";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0000\u0005V\u0015\u0001\u0016";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u001d\u000fW";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u0010\u0005V\t\u0016,[|T";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0010\u0005M\t=\u001a\u001a";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0000\u001f@\u0004\u0007\u0000\u0019|\u0003\u0007\u0007\u000bJ\u000b\u0011";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0010\u0005V\t\u0016,Z|V";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u0007\u0003N\u0002\u0011";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u001f\u0005@\u0006\u000e,\u000eM\u0014";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u001f\u0005D\u000e\f,\fB\u000e\u000e\u0016\u000e";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\u0017\u000bW\u0002";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\u0015\u000bJ\u000b\u0007\u00175W\b\u0012";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0011\u001fJ\u000b\u0006 \u001eB\u0013\u000b\u0000\u001eJ\u0004\u00112\u0004G5\u0007\u0003\u0005Q\u0013B\u0016\u0012@\u0002\u0012\u0007\u0003L\tX";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\u0011\u001fJ\u000b\u0006 \u001eB\u0013\u000b\u0000\u001eJ\u0004\u00112\u0004G5\u0007\u0003\u0005Q\u0013B\u0016\u0012@\u0002\u0012\u0007\u0003L\tXS\u000eAG\r\u0003\u000fMG\u0004\u0012\u0003O\u0002\u0006";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0007\u0013S\u0002";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u001f\u0005D\u000e\f,\u001eL\u0013\u0003\u001f";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "\u0000\u001f@\u0004\u0007\u0016\u000e|\u0013\r\u0003";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = " \u001f@\u0004\u0007\u0016\u000ew\b\u0012@JJ\u0014B\u001d\u001fO\u000bB";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "\n\u0013Z\u001eO>'\u000e\u0003\u0006";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "\u001a\u001eJ\n\u0007";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "5\u000bJ\u000b\u0007\u0017>L\u0017QS\u0003PG\f\u0006\u0006OG";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "\u0000\u000eH8\u000b\u001d\u000eF\u001f";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = " \u001eB\u0013\u000b\u0000\u001eJ\u0004\u00117(";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "\u0017\u000fO\u0002\u0016\u0016JE\u0015\r\u001eJI\u0017\u0017\u0000\u0002|\u0014\u0016\u0012\u001eJ\u0014\u0016\u001a\tP";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "\u0017\u000fO\u0002\u0016\u0016>B\u0005\u000e\u0016JF\u001f\u0001\u0016\u001aW\u000e\r\u001dP";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "\u0017\u000fO\u0002\u0016\u0016>B\u0005\u000e\u0016JF\u001f\u0001\u0016\u001aW\u000e\r\u001dP\u0003\u0003\u0000S\u0005S\u0002\fS\fB\u000e\u000e\u0016\u000e";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0194:
        r9 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        goto L_0x0020;
    L_0x0198:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        goto L_0x0020;
    L_0x019c:
        r9 = 35;
        goto L_0x0020;
    L_0x01a0:
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.f.c.<clinit>():void");
    }

    private static JSONObject a(h hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[10], hVar.b());
            jSONObject.put(z[12], hVar.c());
            jSONObject.put(z[16], hVar.d());
            jSONObject.put(z[9], hVar.e());
            jSONObject.put(z[15], hVar.g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(z[14], hVar.h());
            jSONObject2.put(z[11], hVar.i());
            jSONObject2.put(z[8], hVar.j());
            jSONObject.put(z[13], jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static void a(Context context) {
        if (context != null) {
            b(context);
            c(context);
        }
    }

    public static synchronized void a(Context context, int i, long j, int i2) {
        synchronized (c.class) {
            d.e(z[6], z[4]);
            String a = l.a(context);
            String c = a.c();
            if (c == null) {
                c = "";
            }
            String str = a + "_" + i + "_" + c + "_" + cn.jiguang.e.a.c();
            d.c(z[6], new StringBuilder(z[5]).append(str).append(z[1]).append(j).toString());
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            if (i2 == 0) {
                if (j <= 1000) {
                    i3 = 1;
                }
                if (j > 1000 && j <= 3000) {
                    i4 = 1;
                }
                if (j > 3000) {
                    i5 = 1;
                }
            }
            try {
                g a2 = g.a(context);
                h a3 = a2.a(str);
                if (a3 != null) {
                    d.e(z[6], new StringBuilder(z[0]).append(str).append(z[3]).toString());
                    a2.b(str, a, c, cn.jiguang.e.a.c(), i, a3.f() + i2, a3.g() + 1, i3 + a3.h(), i4 + a3.i(), i5 + a3.j(), a3.k() + 0);
                } else {
                    d.e(z[6], new StringBuilder(z[0]).append(str).append(z[2]).toString());
                    a2.a(str, a, c, cn.jiguang.e.a.c(), i, i2, 1, i3, i4, i5, 0);
                }
            } catch (Exception e) {
                d.g(z[6], new StringBuilder(z[7]).append(e.getMessage()).toString());
            }
        }
    }

    private static JSONObject b(h hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[10], hVar.b());
            jSONObject.put(z[12], hVar.c());
            jSONObject.put(z[16], hVar.d());
            jSONObject.put(z[9], hVar.e());
            jSONObject.put(z[15], hVar.g());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static synchronized void b(Context context) {
        synchronized (c.class) {
            if (cn.jiguang.b.a.d.f(context)) {
                g a = g.a(context);
                if (a.a(false)) {
                    Cursor cursor = null;
                    try {
                        h a2;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(z[27], a.q());
                        jSONObject.put(z[22], z[29]);
                        jSONObject.put(z[18], new SimpleDateFormat(z[26], Locale.ENGLISH).format(new Date(a.b())));
                        jSONObject.put(z[23], a.c(true));
                        jSONObject.put(z[17], a.c(false));
                        JSONArray jSONArray = new JSONArray();
                        cursor = a.a();
                        if (cursor != null) {
                            do {
                                a2 = g.a(cursor);
                                if (a2 == null || j.a(a2.a())) {
                                    d.c(z[6], z[28]);
                                } else {
                                    jSONArray.put(b(a2));
                                }
                            } while (cursor.moveToNext());
                            cursor.close();
                        }
                        jSONObject.put(z[19], jSONArray);
                        jSONArray = new JSONArray();
                        cursor = a.b();
                        if (cursor != null) {
                            do {
                                a2 = g.a(cursor);
                                if (a2 == null || j.a(a2.a())) {
                                    d.c(z[6], z[25]);
                                } else {
                                    jSONArray.put(a(a2));
                                }
                            } while (cursor.moveToNext());
                            cursor.close();
                        }
                        jSONObject.put(z[24], jSONArray);
                        o.a(context, jSONObject);
                        if (cursor != null) {
                            cursor.close();
                        }
                        a.b(false);
                    } catch (JSONException e) {
                        d.i(z[6], new StringBuilder(z[20]).append(e.getMessage()).toString());
                        if (cursor != null) {
                            cursor.close();
                        }
                        a.b(false);
                    } catch (Exception e2) {
                        d.i(z[6], new StringBuilder(z[20]).append(e2.getMessage()).toString());
                        if (cursor != null) {
                            cursor.close();
                        }
                        a.b(false);
                    } catch (Throwable th) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        a.b(false);
                    }
                } else {
                    d.i(z[6], z[21]);
                }
            }
        }
    }

    private static synchronized void c(Context context) {
        synchronized (c.class) {
            g a = g.a(context);
            if (a.a(true)) {
                try {
                    a.getWritableDatabase().execSQL(z[31]);
                    a.b(true);
                } catch (Exception e) {
                    d.i(z[30], new StringBuilder(z[32]).append(e.getMessage()).toString());
                    a.b(true);
                } catch (Throwable th) {
                    a.b(true);
                }
            } else {
                d.i(z[30], z[33]);
            }
        }
    }
}
