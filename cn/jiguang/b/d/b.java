package cn.jiguang.b.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.SdkType;
import cn.jiguang.b.b.e;
import cn.jiguang.b.b.g;
import cn.jiguang.b.e.a.a.c;
import cn.jiguang.c.d;
import cn.jiguang.e.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static HashMap<String, JAction> a = new HashMap();
    public static HashMap<String, JActionExtra> b = new HashMap();
    private static volatile b c;
    private static final Object d = new Object();
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 23;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "L8;\u001d#c\u0016.\u001a-j>=";
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
            case 0: goto L_0x013b;
            case 1: goto L_0x013f;
            case 2: goto L_0x0143;
            case 3: goto L_0x0147;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 76;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "n4=\u0011\u0013~?$+:h)";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "~3.\u0006)R(+\u001f\u0013{>=";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "~?$+:h)";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "z).\u0004\u001fi0\u0019\u0011>~2 \u001a\u0005c= T*l2#\u0011(-w,\u001b\"y:&\u001a){&\u0007lc.#\u0018";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "~/.\u0000%~/&\u0017?R(+\u001f\u0013{>=";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "!:,\u0000%b5u";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "d(\u000e\u0018 b,\u000e\u00178d4!T)) \u0006v";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "d(\u000e\u0018 b,\u000e\u00178d4!T-n/&\u001b\"Y\"?\u0011v";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "!(+\u001f8t+*N";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "!:,\u0000%b5\n\f8:u";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "..!\u00114n>?\u0000)i{bT%c(;\u0015\"n>o";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "-8#\u0015?~{)\u0015%a>+N";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "l?+5/y2 \u001a\tu/=\u0015lk:&\u0018)iw;\u001c)-:,\u0000%b5\u0001\u0015!h{&\u0007lc4;T--\u0011\u000e\u00178d4!14y).T#o1*\u00178";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "l?+5/y2 \u001a\tu/=\u0015ly\"?\u0011v";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "e:<T?l6*T8t+*T-n/&\u001b\"->7\u0000>l";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "-(+\u001fll8;\u001d#c{<\u0010'{>=\u0007%b5u";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "-(+\u001fll8;\u001d#c{&\u0007lc.#\u0018";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "-(+\u001fld(o\u001a9a7";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "e:<T?l6*T8t+*T-n/&\u001b\"";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "l?+5/y2 \u001aly\"?\u0011v";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "b5\u001c\u0011\"i>+T8t+*N";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "..!\u00114n>?\u0000)ivo\u001d\"{4$\u0011l`>;\u001c#i{*\u0006>b)u";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        z = r4;
        r0 = new java.util.HashMap;
        r0.<init>();
        a = r0;
        r0 = new java.util.HashMap;
        r0.<init>();
        b = r0;
        r0 = cn.jiguang.b.a.a;
        r1 = cn.jiguang.b.d.i.class;
        r1 = r1.getName();
        a(r0, r1);
        r0 = new java.lang.Object;
        r0.<init>();
        d = r0;
        return;
    L_0x013b:
        r9 = 13;
        goto L_0x0020;
    L_0x013f:
        r9 = 91;
        goto L_0x0020;
    L_0x0143:
        r9 = 79;
        goto L_0x0020;
    L_0x0147:
        r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.b.<clinit>():void");
    }

    private b() {
    }

    public static b a() {
        if (c == null) {
            synchronized (d) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    private static Object a(JActionExtra jActionExtra, Context context, int i, String str, int i2) {
        if (jActionExtra == null) {
            return null;
        }
        if (i2 != 0) {
            return i2 == 1 ? jActionExtra.beforLogin(context, i, str) : null;
        } else {
            try {
                return jActionExtra.beforRegister(context, i, str);
            } catch (Throwable th) {
                d.h(z[0], new StringBuilder(z[22]).append(th).toString());
                return null;
            }
        }
    }

    public static void a(Context context, long j, int i) {
        for (Entry value : a.entrySet()) {
            JAction jAction = (JAction) value.getValue();
            if (jAction != null) {
                jAction.onEvent(context, j, i);
            }
        }
    }

    public static void a(Context context, c cVar, ByteBuffer byteBuffer) {
        for (Entry entry : a.entrySet()) {
            JAction jAction = (JAction) entry.getValue();
            if (jAction != null && jAction.isSupportedCMD(cVar.a())) {
                cVar.a(Long.valueOf(jAction.dispatchMessage(context, g.a.get(), cVar.a(), cVar, byteBuffer)));
                e.a();
                e.a((String) entry.getKey(), (Object) cVar);
                return;
            }
        }
    }

    public static void a(Context context, String str, long j, Bundle bundle, Handler handler) {
        JAction jAction = (JAction) a.get(str);
        if (jAction != null) {
            jAction.onActionRun(context, j, bundle, handler);
        }
    }

    public static void a(Context context, String str, Object obj) {
        d.a(z[0], new StringBuilder(z[21]).append(str).toString());
        if (j.a(str)) {
            for (Entry value : a.entrySet()) {
                JAction jAction = (JAction) value.getValue();
                e.a();
                jAction.handleMessage(context, e.g(), obj);
            }
            return;
        }
        jAction = (JAction) a.get(str);
        if (jAction != null) {
            e.a();
            jAction.handleMessage(context, e.g(), obj);
        }
    }

    public static void a(String str, String str2) {
        d.a(z[0], new StringBuilder(z[20]).append(str).append(z[6]).append(str2).toString());
        if (!TextUtils.isEmpty(str2)) {
            if (a.containsKey(str)) {
                d.c(z[0], z[19]);
                return;
            }
            try {
                Object newInstance = Class.forName(str2).newInstance();
                if (newInstance instanceof JAction) {
                    a.put(str, (JAction) newInstance);
                }
            } catch (Throwable th) {
                d.h(z[0], new StringBuilder(z[11]).append(str2).append(z[12]).append(th).toString());
            }
        }
    }

    public static boolean a(int i) {
        for (Entry entry : b.entrySet()) {
            JActionExtra jActionExtra = (JActionExtra) entry.getValue();
            if (jActionExtra != null) {
                try {
                    d.d(z[0], new StringBuilder(z[8]).append(0).append(z[9]).append((String) entry.getKey()).append(z[6]).append(jActionExtra.checkAction(0)).toString());
                    if (!jActionExtra.checkAction(0)) {
                        return false;
                    }
                } catch (Throwable th) {
                    d.g(z[0], new StringBuilder(z[7]).append(th.getMessage()).toString());
                }
            }
        }
        return true;
    }

    public static void b(Context context, long j, int i) {
        for (Entry value : a.entrySet()) {
            JAction jAction = (JAction) value.getValue();
            if (jAction != null) {
                jAction.dispatchTimeOutMessage(context, g.a.get(), j, i);
            }
        }
    }

    public static void b(String str, String str2) {
        d.a(z[0], new StringBuilder(z[14]).append(str).append(z[10]).append(str2).toString());
        if (b.containsKey(str)) {
            d.c(z[0], z[15]);
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (newInstance instanceof JActionExtra) {
                b.put(str, (JActionExtra) newInstance);
            } else {
                d.c(z[0], z[13]);
            }
        } catch (Throwable th) {
            d.h(z[0], new StringBuilder(z[11]).append(str2).append(z[12]).append(th).toString());
        }
    }

    public static IBinder c(String str, String str2) {
        JAction jAction = (JAction) a.get(str);
        return jAction != null ? jAction.getBinderByType(str2) : null;
    }

    public static String d(String str, String str2) {
        if (a.containsKey(str)) {
            JAction jAction = (JAction) a.get(str);
            if (jAction == null) {
                d.a(z[0], str + z[17]);
                return str2;
            } else if (!TextUtils.isEmpty(jAction.getSdkVersion())) {
                return jAction.getSdkVersion();
            } else {
                d.a(z[0], str + z[16] + jAction.getSdkVersion());
                return str2;
            }
        }
        d.a(z[0], str + z[18]);
        return str2;
    }

    public final ArrayList<Object> a(Context context, String str, int i, String str2, int i2) {
        ArrayList<Object> arrayList = new ArrayList();
        Object a;
        if (j.a(str)) {
            for (Entry value : b.entrySet()) {
                a = a((JActionExtra) value.getValue(), context, 17, str2, 1);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        } else {
            a = a((JActionExtra) b.get(str), context, 17, str2, 1);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public final boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            d.g(z[0], z[4]);
            return false;
        }
        try {
            jSONObject.put(z[3], d(SdkType.JPUSH.name(), ""));
            jSONObject.put(z[1], d(SdkType.JCORE.name(), ""));
            jSONObject.put(z[2], d(SdkType.JSHARE.name(), ""));
            jSONObject.put(z[5], d(SdkType.JANALYTICS.name(), ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }
}
