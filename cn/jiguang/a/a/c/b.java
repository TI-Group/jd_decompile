package cn.jiguang.a.a.c;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import cn.jiguang.b.d.o;
import cn.jiguang.c.d;
import cn.jiguang.e.a;
import cn.jiguang.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    private static final String a = b.class.getSimpleName();
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 24;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "k\u0013m\u0016\u0014^\u0007}\u0013\u0015b\u0006G\f\u0012g\f";
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
            case 0: goto L_0x012e;
            case 1: goto L_0x0131;
            case 2: goto L_0x0135;
            case 3: goto L_0x0139;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "e\u0006n\f\u001fd<k\u0000\u000fr\nw\u000b";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "r\u0007s:\nd\u0011k\f\u0013o";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "b\u0013m:\u0015o\u0005w";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "m\u0002v\u0002\t`\u0004}";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "r\nu:\u000fm\fl\u0016";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "l\u0002{";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "r\u0000j\u0000\u0019o\u0010q\u001f\u0019";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "s\u0006k\n\u0010t\u0017q\n\u0012";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "e\u0006n\f\u001fd\u00108\f\u0012g\f\"";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "u\nu\u0000\u0006n\r}";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "l\f|\u0000\u0010";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "$M)\u0003";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "n\u0010G\u0013\u0019s\u0010q\n\u0012";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "s\u0006h\n\u000euC|\u0000\nh\u0000}E\u0015o\u0005wE\u001a`\nt\u0000\u0018-\u0006j\u0017\u0013sY";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "`\u0000l\f\u0013oYj\u0000\fn\u0011l!\u0019w\n{\u00005o\u0005w";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "u\u001ah\u0000";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "e\u0006n\f\u001fd<q\u000b\u001an";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "h\u0017q\b\u0019";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "e\u0006n\f\u001fd<q\u000b\u001anY";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "e\u0006n\f\u001fd*v\u0003\u0013R\u0017jE\u000b`\u00108\u000b\tm\u000f";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "0M)KJ";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "r\u0002u\u0000\\e\u0006n\f\u001fdCq\u000b\u001anO8\u000b\u0019v'}\u0013\u0015b\u0006K\u0000\u000fr\nw\u000bF";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "0R.";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        z = r4;
        r0 = cn.jiguang.a.a.c.b.class;
        r0 = r0.getSimpleName();
        a = r0;
        return;
    L_0x012e:
        r9 = 1;
        goto L_0x0020;
    L_0x0131:
        r9 = 99;
        goto L_0x0020;
    L_0x0135:
        r9 = 24;
        goto L_0x0020;
    L_0x0139:
        r9 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.b.<clinit>():void");
    }

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            Object b = a.b();
            Object a = a.a(context);
            Object format = String.format(Locale.ENGLISH, z[12], new Object[]{Double.valueOf(a.o(context))});
            Object obj = VERSION.RELEASE;
            Object obj2 = Build.MODEL;
            Object locale = context.getResources().getConfiguration().locale.toString();
            Object c = a.c(cn.jiguang.b.a.e, "");
            long rawOffset = (long) (TimeZone.getDefault().getRawOffset() / DateUtils.MILLIS_IN_HOUR);
            r4 = rawOffset > 0 ? "+" + rawOffset : rawOffset < 0 ? "-" + rawOffset : rawOffset;
            String str = z[3];
            if (j.a((String) b)) {
                b = "";
            }
            jSONObject.put(str, b);
            String str2 = z[8];
            if (j.a((String) a)) {
                a = "";
            }
            jSONObject.put(str2, a);
            String str3 = z[13];
            if (j.a((String) obj)) {
                obj = "";
            }
            jSONObject.put(str3, obj);
            String str4 = z[4];
            if (j.a((String) locale)) {
                locale = "";
            }
            jSONObject.put(str4, locale);
            String str5 = z[10];
            if (j.a((String) r4)) {
                r4 = "";
            }
            jSONObject.put(str5, r4);
            String str6 = z[11];
            if (j.a((String) obj2)) {
                obj2 = "";
            }
            jSONObject.put(str6, obj2);
            String str7 = z[7];
            if (j.a((String) format)) {
                format = "";
            }
            jSONObject.put(str7, format);
            String str8 = z[6];
            if (j.a((String) c)) {
                c = "";
            }
            jSONObject.put(str8, c);
            ArrayList a2 = cn.jiguang.e.b.b.a().a(context.getApplicationContext());
            JSONArray jSONArray = new JSONArray();
            if (a2 != null) {
                Iterator it = a2.iterator();
                while (it.hasNext()) {
                    cn.jiguang.e.b.a aVar = (cn.jiguang.e.b.a) it.next();
                    if (aVar != null) {
                        JSONObject a3 = aVar.a();
                        if (a3 != null) {
                            jSONArray.put(a3);
                        }
                    }
                }
            }
            jSONObject.put(z[5], jSONArray);
            d.c(a, new StringBuilder(z[9]).append(jSONObject.toString()).toString());
            return jSONObject;
        } catch (Throwable th) {
            d.i(a, th.getMessage());
            return null;
        }
    }

    public static void a(Context context, String str) {
        Editor edit = context.getSharedPreferences(z[0], 0).edit();
        edit.putString(z[2], str);
        edit.commit();
    }

    public static String b(Context context) {
        return context.getSharedPreferences(z[0], 0).getString(z[2], null);
    }

    public static void b(Context context, String str) {
        Editor edit = context.getSharedPreferences(z[0], 0).edit();
        edit.putString(z[1], str);
        edit.commit();
    }

    public static void c(Context context) {
        d.c(a, z[15]);
        if (cn.jiguang.b.a.d.f(context)) {
            JSONObject a = a(context);
            if (a != null) {
                Object jSONObject = a.toString();
                if (TextUtils.isEmpty(jSONObject)) {
                    d.g(a, z[20]);
                    return;
                }
                CharSequence charSequence;
                StringBuilder append = new StringBuilder().append(jSONObject);
                String d = cn.jiguang.b.a.a.d("");
                String i = cn.jiguang.b.a.d.i(context);
                CharSequence charSequence2 = cn.jiguang.b.a.h;
                CharSequence charSequence3 = cn.jiguang.b.a.g;
                CharSequence charSequence4 = z[21];
                CharSequence charSequence5 = z[23];
                CharSequence charSequence6 = cn.jiguang.b.a.c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(d);
                stringBuilder.append(",");
                if (TextUtils.isEmpty(i)) {
                    i = "";
                }
                stringBuilder.append(i);
                stringBuilder.append(",");
                if (TextUtils.isEmpty(charSequence2)) {
                    i = "";
                } else {
                    charSequence = charSequence2;
                }
                stringBuilder.append(i);
                stringBuilder.append(",");
                if (TextUtils.isEmpty(charSequence3)) {
                    i = "";
                } else {
                    charSequence = charSequence3;
                }
                stringBuilder.append(i);
                stringBuilder.append(",");
                if (TextUtils.isEmpty(charSequence4)) {
                    i = "";
                } else {
                    charSequence = charSequence4;
                }
                stringBuilder.append(i);
                stringBuilder.append(",");
                if (TextUtils.isEmpty(charSequence5)) {
                    i = "";
                } else {
                    charSequence = charSequence5;
                }
                stringBuilder.append(i);
                stringBuilder.append(",");
                if (TextUtils.isEmpty(charSequence6)) {
                    i = "";
                } else {
                    charSequence = charSequence6;
                }
                stringBuilder.append(i);
                i = j.b(append.append(stringBuilder.toString()).toString());
                if (i == null || TextUtils.equals(i, context.getSharedPreferences(z[0], 0).getString(z[1], null))) {
                    d.c(a, new StringBuilder(z[22]).append(i).toString());
                    return;
                }
                try {
                    a.put(z[18], cn.jiguang.b.a.a.q());
                    a.put(z[16], z[17]);
                    d.c(a, new StringBuilder(z[19]).append(a.toString()).toString());
                    o.a(context, new JSONArray().put(a), new c(context, i));
                } catch (Throwable th) {
                    d.i(a, new StringBuilder(z[14]).append(th).toString());
                }
            }
        }
    }
}
