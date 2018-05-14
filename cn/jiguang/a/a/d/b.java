package cn.jiguang.a.a.d;

import android.app.Application;
import android.content.Context;
import cn.jiguang.a.b.c;
import cn.jiguang.b.a.d;
import cn.jiguang.b.d.o;
import cn.jiguang.e.a;
import cn.jiguang.e.j;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public static boolean a = false;
    public static boolean b = false;
    private static volatile b c = null;
    private static final String[] z;
    private ExecutorService d = Executors.newSingleThreadExecutor();
    private String e = null;
    private String f = null;
    private ArrayList<a> g = new ArrayList();
    private long h = 30;
    private long i = 0;
    private long j = 0;
    private boolean k = false;
    private boolean l = true;
    private boolean m = true;
    private boolean n = false;
    private boolean o = true;
    private long p = 0;
    private WeakReference<JSONObject> q = null;
    private JSONObject r = null;
    private final Object s = new Object();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 30;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "'\u0018+6v;\u0018-1L";
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
            case 0: goto L_0x0171;
            case 1: goto L_0x0175;
            case 2: goto L_0x0179;
            case 3: goto L_0x017d;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "%\u001c/bZ?\u0018,+Z?\u0010;1\t8\u001c+1@$\u0017";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\"\r1/L";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "?\u0000('";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "8\u001c+1@$\u0017\u0007+M";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0001)-1A\u00188";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "*\u001a,+_.&,'[&\u00106#].";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "!\t-1A\u0014\n,#]\u0014\u001a9!A.W21F%";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u001e\u0017=:Y.\u001a,'MgY\u0012\u0012\\8\u0011x7G9\u001c?+Z?\u001c*'M";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "8\r96@8\r1!Zk\n,#[?";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "(\f*\u001dZ.\u001c++F%&=,M";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = ">\r>o\u0011";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "*\u001a,+_\"\r1'Z";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "/\f*#]\"\u00166";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "(\f*\u001dZ.\n++F%&+6H9\r";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u0001:70L\u0002\u0017,'[-\u0018;'\u0007$\u0017\n'Z>\u0014=j\u0000k\u0014-1]k\u001b=bJ*\u00154'Mk\u0018>6L9Y;#E'\u001c<bc\b\u0016*'`%\r=0O*\u001a=lF%)97Z.Qqb@%Y4#Z?Y\u0019!]\"\u000f16Pk\u0016*bo9\u0018?/L%\r";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\b\u001666L3\rx1A$\f4&\t)\u001cx#Gk8;6@=\u0010,;\t$\u0017x6A\"\nx/L?\u00117&\tqY";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "(\u001666L3\rx+Zk\u0017-.E";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "8\r96\t-\f6!]\"\u00166bA*\nx L.\u0017x&@8\u0018:.L/";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "$\u0017\b#\\8\u001c";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0001:70L\u0002\u0017,'[-\u0018;'\u0007$\u0017\b#\\8\u001cpk\t&\f+6\t)\u001cx!H'\u0015=&\t*\u001f,'[k\u001a9.E.\u001dx\bj$\u000b=\u000bG?\u001c*$H(\u001cv-G\u0019\u001c+7D.QqbH%\u001dx\by>\n0\u000bG?\u001c*$H(\u001cv-G\u001b\u0018-1Lk\n0-\\'\u001dx,F?Y:'\t(\u00184.L/Y5-[.Y,+D.Y1,\t?\u001111\t\n\u001a,+_\"\r!bF9Y\u001e0H,\u0014=,]kBx";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "?\u0011=bH(\r14@?\u0000x2H8\nx Pk\u00166\u0012H>\n=bM\"\u001d6e]k\u001496J#Y4#Z?Y7,Lk\t91Z.\u001dx Pk\u00166\u0010L8\f5'";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "/\u0018,'";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "?\u00105'";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "*\u001a,+_.&4#\\%\u001a0";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "\"\u0017.#E\"\u001dx0L,\u0010+6L9\u001c<bM.\u000f1!LqY;#G%\u0016,b[.\t70]k\u0018;6@=\u001c\u0007.H>\u0017;*";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = ";\u0018?'\t%\u00185'\t/\u0010<,\u000e?Y5#](\u0011x6A.Y4#Z?Y7,Lk\t91Z.\u001dx Pk\u00166\u0010L8\f5'";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "\u0001:70L\u0002\u0017,'[-\u0018;'\u0007$\u0017\b#\\8\u001cpk\t&\f+6\t)\u001cx!H'\u0015=&\t*\u001f,'[k\u001a9.E.\u001dx\bj$\u000b=\u000bG?\u001c*$H(\u001cv-G\u0019\u001c+7D.Qqb@%Y,*@8Y\u0019!]\"\u000f16Pk\u0016*bo9\u0018?/L%\r";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "$\u0017\n'Z>\u0014=";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "\u0001:70L\u0002\u0017,'[-\u0018;'\u0007$\u0017\n'Z>\u0014=j\u0000k\u0014-1]k\u001b=bJ*\u00154'Mk\u0018>6L9Y;#E'\u001c<bc\b\u0016*'`%\r=0O*\u001a=lF%)97Z.QqbH%\u001dx\by>\n0\u000bG?\u001c*$H(\u001cv-G\u0019\u001c+7D.Y+*F>\u0015<bG$\rx Lk\u001a9.E.\u001dx/F9\u001cx6@&\u001cx+Gk\u001591]k8;6@=\u0010,;\t$\u000bx\u0004[*\u001e5'G?Yx";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        c = r0;
        r0 = 0;
        a = r0;
        r0 = 0;
        b = r0;
        return;
    L_0x0171:
        r9 = 75;
        goto L_0x0020;
    L_0x0175:
        r9 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x0020;
    L_0x0179:
        r9 = 88;
        goto L_0x0020;
    L_0x017d:
        r9 = 66;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.d.b.<clinit>():void");
    }

    private b() {
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                c = new b();
            }
        }
        return c;
    }

    private JSONObject a(Context context, long j) {
        c.a().b(context, z[14], this.i);
        StringBuilder stringBuilder = new StringBuilder();
        String k = a.k(context);
        if (!j.a(k)) {
            stringBuilder.append(k);
        }
        k = a.g(context);
        if (!j.a(k)) {
            stringBuilder.append(k);
        }
        stringBuilder.append(j);
        this.f = a.a(stringBuilder.toString());
        c.a().b(context, z[4], this.f);
        JSONObject jSONObject = new JSONObject();
        try {
            if (d.f(context)) {
                a(jSONObject);
                jSONObject.put(z[2], cn.jiguang.b.a.a.q());
                jSONObject.put(z[4], this.f);
                jSONObject.put(z[3], z[24]);
                return jSONObject;
            }
            cn.jiguang.c.d.g(z[5], z[25]);
            return null;
        } catch (JSONException e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(cn.jiguang.a.a.d.b r10, android.content.Context r11) {
        /*
        r6 = -1;
        r1 = 1;
        r9 = 0;
        r8 = 5;
        r0 = 0;
        r2 = cn.jiguang.b.a.d.f(r11);
        if (r2 != 0) goto L_0x001a;
    L_0x000c:
        r0 = z;
        r0 = r0[r8];
        r1 = z;
        r2 = 8;
        r1 = r1[r2];
        cn.jiguang.c.d.g(r0, r1);
    L_0x0019:
        return;
    L_0x001a:
        r2 = r10.l;
        if (r2 == 0) goto L_0x00b6;
    L_0x001e:
        r10.l = r0;
        r2 = z;
        r2 = r2[r8];
        r3 = z;
        r4 = 9;
        r3 = r3[r4];
        cn.jiguang.c.d.c(r2, r3);
        r2 = cn.jiguang.a.b.c.a();
        r3 = z;
        r3 = r3[r0];
        r2 = r2.a(r11, r3, r6);
        r4 = r10.i;
        r4 = r4 - r2;
        r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x00c4;
    L_0x0040:
        r2 = r10.h;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 * r6;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 > 0) goto L_0x00c4;
    L_0x0049:
        r10.k = r0;
        r0 = r10.k;
        if (r0 == 0) goto L_0x00c9;
    L_0x004f:
        r0 = z;
        r0 = r0[r8];
        r2 = z;
        r1 = r2[r1];
        cn.jiguang.c.d.c(r0, r1);
        r0 = new org.json.JSONArray;
        r0.<init>();
        r2 = r10.i;
        r1 = r10.a(r11, r2);
        if (r1 == 0) goto L_0x006a;
    L_0x0067:
        r0.put(r1);
    L_0x006a:
        r1 = r10.s;
        monitor-enter(r1);
        r2 = r10.d(r11);	 Catch:{ all -> 0x00c6 }
        if (r2 == 0) goto L_0x00a5;
    L_0x0073:
        r3 = r2.length();	 Catch:{ all -> 0x00c6 }
        if (r3 <= 0) goto L_0x00a5;
    L_0x0079:
        r3 = z;	 Catch:{ Exception -> 0x00da }
        r4 = 3;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00da }
        r4 = z;	 Catch:{ Exception -> 0x00da }
        r5 = 6;
        r4 = r4[r5];	 Catch:{ Exception -> 0x00da }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x00da }
        r3 = z;	 Catch:{ Exception -> 0x00da }
        r4 = 2;
        r3 = r3[r4];	 Catch:{ Exception -> 0x00da }
        r4 = cn.jiguang.b.a.a.q();	 Catch:{ Exception -> 0x00da }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x00da }
    L_0x0092:
        r3 = z;	 Catch:{ all -> 0x00c6 }
        r4 = 7;
        r3 = r3[r4];	 Catch:{ all -> 0x00c6 }
        r4 = 0;
        cn.jiguang.b.d.o.a(r11, r3, r4);	 Catch:{ all -> 0x00c6 }
        r3 = 0;
        r10.r = r3;	 Catch:{ all -> 0x00c6 }
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x00c6 }
        r3.<init>();	 Catch:{ all -> 0x00c6 }
        r10.g = r3;	 Catch:{ all -> 0x00c6 }
    L_0x00a5:
        monitor-exit(r1);	 Catch:{ all -> 0x00c6 }
        if (r2 == 0) goto L_0x00b1;
    L_0x00a8:
        r1 = r2.length();
        if (r1 <= 0) goto L_0x00b1;
    L_0x00ae:
        r0.put(r2);
    L_0x00b1:
        cn.jiguang.b.d.o.a(r11, r0);
        goto L_0x0019;
    L_0x00b6:
        r2 = r10.i;
        r4 = r10.j;
        r2 = r2 - r4;
        r4 = r10.h;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r6;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0049;
    L_0x00c4:
        r0 = r1;
        goto L_0x0049;
    L_0x00c6:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00c6 }
        throw r0;
    L_0x00c9:
        r0 = cn.jiguang.a.b.c.a();
        r1 = z;
        r2 = 4;
        r1 = r1[r2];
        r0 = r0.a(r11, r1, r9);
        r10.f = r0;
        goto L_0x0019;
    L_0x00da:
        r3 = move-exception;
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.d.b.a(cn.jiguang.a.a.d.b, android.content.Context):void");
    }

    private static void a(JSONObject jSONObject) {
        String a = cn.jiguang.b.f.a.a();
        Object obj = a.split("_")[0];
        Object obj2 = a.split("_")[1];
        jSONObject.put(z[22], obj);
        jSONObject.put(z[23], obj2);
    }

    static /* synthetic */ void b(b bVar, Context context) {
        int i = 0;
        if (context != null) {
            synchronized (bVar.s) {
                JSONArray optJSONArray;
                c.a().b(context, z[0], bVar.j);
                c.a().b(context, z[10], bVar.j);
                if (bVar.m) {
                    bVar.m = false;
                    if (!(bVar.k || bVar.d(context) == null)) {
                        optJSONArray = bVar.d(context).optJSONArray(z[12]);
                        if (optJSONArray != null) {
                            Collection arrayList = new ArrayList();
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                try {
                                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                                    if (optJSONObject != null) {
                                        Iterator keys = optJSONObject.keys();
                                        if (keys.hasNext()) {
                                            String str = (String) keys.next();
                                            arrayList.add(new a(str, optJSONObject.getLong(str)));
                                        }
                                    }
                                } catch (Exception e) {
                                    cn.jiguang.c.d.i(z[5], e.getMessage());
                                }
                            }
                            arrayList.addAll(bVar.g);
                            bVar.g = new ArrayList();
                            bVar.g.addAll(arrayList);
                        }
                    }
                }
                JSONObject d = bVar.d(context);
                JSONObject jSONObject = d == null ? new JSONObject() : d;
                optJSONArray = new JSONArray();
                while (i < bVar.g.size()) {
                    a aVar = (a) bVar.g.get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(aVar.a, aVar.b);
                        optJSONArray.put(jSONObject2);
                    } catch (JSONException e2) {
                    }
                    i++;
                }
                if (optJSONArray.length() > 0) {
                    try {
                        jSONObject.put(z[12], optJSONArray);
                    } catch (JSONException e3) {
                    }
                }
                if (jSONObject.length() > 0) {
                    try {
                        long a = c.a().a(context, z[14], 0);
                        long j = 10;
                        if (a == 0) {
                            a = bVar.j - bVar.p;
                            if (a > 0) {
                                j = a / 1000;
                            }
                            c.a().b(context, z[14], bVar.p);
                        } else {
                            j = (bVar.j - a) / 1000;
                        }
                        jSONObject.put(z[13], j);
                        jSONObject.put(z[2], cn.jiguang.b.a.a.q());
                        jSONObject.put(z[4], bVar.f);
                        a(jSONObject);
                    } catch (Exception e4) {
                    }
                    bVar.r = jSONObject;
                    if (bVar.r != null) {
                        try {
                            o.a(context, bVar.r.toString().getBytes(z[11]).length);
                        } catch (UnsupportedEncodingException e5) {
                        } catch (Exception e6) {
                            cn.jiguang.c.d.i(z[5], e6.getMessage());
                        }
                    }
                    o.a(context, z[7], jSONObject);
                }
            }
        }
    }

    private boolean c(Context context, String str) {
        if (!this.o) {
            cn.jiguang.c.d.e(z[5], z[18]);
            return false;
        } else if (context == null) {
            cn.jiguang.c.d.e(z[5], z[17]);
            return false;
        } else if (!(context instanceof Application)) {
            return true;
        } else {
            cn.jiguang.c.d.j(z[5], new StringBuilder(z[16]).append(str).toString());
            return false;
        }
    }

    private JSONObject d(Context context) {
        if (this.r == null) {
            this.r = o.a(context, z[7]);
        }
        return this.r;
    }

    public final void a(Context context) {
        if (c(context, z[28])) {
            a = true;
            try {
                this.n = false;
            } catch (ClassCastException e) {
            } catch (Exception e2) {
            }
            if (this.n) {
                cn.jiguang.c.d.c(z[5], z[29]);
                return;
            }
            this.n = true;
            this.i = System.currentTimeMillis();
            this.e = context.getClass().getName();
            try {
                this.d.execute(new e(this, context));
            } catch (Exception e3) {
            }
        }
    }

    public final void a(Context context, String str) {
        if (this.n) {
            cn.jiguang.c.d.c(z[5], z[15]);
            return;
        }
        this.n = true;
        this.e = str;
        this.i = System.currentTimeMillis();
        try {
            this.d.execute(new c(this, context));
        } catch (Exception e) {
        }
    }

    public final void b(Context context) {
        if (c(context, z[19])) {
            b = true;
            try {
                this.n = true;
            } catch (ClassCastException e) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.n) {
                this.n = false;
                if (this.e == null || !this.e.equals(context.getClass().getName())) {
                    cn.jiguang.c.d.e(z[5], z[21]);
                    return;
                }
                this.j = System.currentTimeMillis();
                this.g.add(new a(this.e, (this.j - this.i) / 1000));
                this.p = this.i;
                try {
                    this.d.execute(new f(this, context));
                    return;
                } catch (Exception e3) {
                    return;
                }
            }
            cn.jiguang.c.d.c(z[5], z[20]);
        }
    }

    public final void b(Context context, String str) {
        if (this.n) {
            this.n = false;
            if (this.e == null || !this.e.equals(str)) {
                cn.jiguang.c.d.j(z[5], z[26]);
                return;
            }
            this.j = System.currentTimeMillis();
            this.g.add(new a(this.e, (this.j - this.i) / 1000));
            try {
                this.d.execute(new d(this, context));
                return;
            } catch (Exception e) {
                return;
            }
        }
        cn.jiguang.c.d.c(z[5], z[27]);
    }

    public final void c(Context context) {
        try {
            if (this.e != null && this.n) {
                this.j = System.currentTimeMillis();
                this.g.add(new a(this.e, (this.j - this.i) / 1000));
                try {
                    this.d.execute(new g(this, context));
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
    }
}
