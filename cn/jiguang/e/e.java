package cn.jiguang.e;

import android.text.TextUtils;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private static final Pattern e;
    private static final Pattern f;
    private static final String[] z;
    public String a;
    private String b;
    private String c;
    private String d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 15;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "7\u0007w";
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
            case 0: goto L_0x00e8;
            case 1: goto L_0x00ec;
            case 2: goto L_0x00f0;
            case 3: goto L_0x00f4;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 75;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "2\u0007w";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "2\u001c|]\u0014,\u000f~[";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "2\u001ezZ";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\f/^{";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0017=Vl";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0012'W";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001e\u001d8";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0012>Zz";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0012\u001c|].1\u001dZP--\u0015fM.0S4";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "nNcN\"&S4";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "nNcW/I";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "nNcL$! rS.I";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0003\u001ecm?#\u001aFJ\".\u001d";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "2\u000faM.b\u001e`\u001e;0\u0007}J\u00186\u001czP,b\u000baLgb";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        z = r4;
        r1 = "\u001c5R\u0013\u0011#Cic\u0010\u0003CI_f8^>\u0007\u0014\u001fDH\u0010\u0016iFHf\u0018\u000f>D\u0016\u0019/>d*o\u0014#\u0013r\u001dT=cakD7";
        r0 = -1;
    L_0x00c5:
        r1 = r1.toCharArray();
        r2 = r1.length;
        r3 = 0;
        r4 = 1;
        if (r2 > r4) goto L_0x0106;
    L_0x00ce:
        r4 = r1;
        r5 = r3;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x00d3:
        r7 = r2[r3];
        r6 = r5 % 5;
        switch(r6) {
            case 0: goto L_0x00f8;
            case 1: goto L_0x00fb;
            case 2: goto L_0x00fe;
            case 3: goto L_0x0101;
            default: goto L_0x00da;
        };
    L_0x00da:
        r6 = 75;
    L_0x00dc:
        r6 = r6 ^ r7;
        r6 = (char) r6;
        r2[r3] = r6;
        r3 = r5 + 1;
        if (r1 != 0) goto L_0x0104;
    L_0x00e4:
        r2 = r4;
        r5 = r3;
        r3 = r1;
        goto L_0x00d3;
    L_0x00e8:
        r9 = 66;
        goto L_0x0020;
    L_0x00ec:
        r9 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        goto L_0x0020;
    L_0x00f0:
        r9 = 19;
        goto L_0x0020;
    L_0x00f4:
        r9 = 62;
        goto L_0x0020;
    L_0x00f8:
        r6 = 66;
        goto L_0x00dc;
    L_0x00fb:
        r6 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        goto L_0x00dc;
    L_0x00fe:
        r6 = 19;
        goto L_0x00dc;
    L_0x0101:
        r6 = 62;
        goto L_0x00dc;
    L_0x0104:
        r2 = r1;
        r1 = r4;
    L_0x0106:
        if (r2 > r3) goto L_0x00ce;
    L_0x0108:
        r2 = new java.lang.String;
        r2.<init>(r1);
        r1 = r2.intern();
        switch(r0) {
            case 0: goto L_0x011e;
            default: goto L_0x0114;
        };
    L_0x0114:
        r0 = java.util.regex.Pattern.compile(r1);
        e = r0;
        r1 = "\u001c\u0014jY$6\u000bH\u000ef{39\u001a";
        r0 = 0;
        goto L_0x00c5;
    L_0x011e:
        r0 = java.util.regex.Pattern.compile(r1);
        f = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.e.<clinit>():void");
    }

    private static int a(LinkedList<String> linkedList, String str, int i) {
        int indexOf = linkedList.indexOf(str);
        if (indexOf == -1) {
            indexOf = linkedList.indexOf(str.toLowerCase(Locale.ENGLISH));
        }
        return indexOf == -1 ? i : indexOf;
    }

    public static e a(String str, Map<String, Integer> map) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(z[7]);
        int length = split.length;
        if (length < 3) {
            return null;
        }
        try {
            e eVar = new e();
            if (map == null || map.isEmpty()) {
                eVar.b = split[0];
                eVar.c = split[1];
                eVar.d = split[2];
                eVar.a = split[length - 1];
            } else {
                eVar.b = split[((Integer) map.get(z[5])).intValue()];
                eVar.c = split[((Integer) map.get(z[6])).intValue()];
                eVar.d = split[((Integer) map.get(z[8])).intValue()];
                eVar.a = split[((Integer) map.get(z[4])).intValue()];
            }
            return eVar;
        } catch (Throwable th) {
            Log.w(z[13], new StringBuilder(z[14]).append(th.getMessage()).toString());
            return null;
        }
    }

    public static Map<String, Integer> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Collections.addAll(linkedList, str.split(z[7]));
        int size = linkedList.size() - 1;
        return (a(linkedList, z[5], 0) == 0 && a(linkedList, z[6], 1) == 1 && a(linkedList, z[8], 2) == 2 && a(linkedList, z[4], size) == size) ? null : new HashMap();
    }

    public final JSONObject a(int i) {
        try {
            return new JSONObject().put(z[0], this.b).put(z[1], this.c).put(z[3], this.d).put(z[2], j.a(this.a, 128));
        } catch (JSONException e) {
            return null;
        }
    }

    public final boolean a() {
        return this.d.equals("0") || this.d.equals("1") || this.d.equals("2");
    }

    public final boolean b() {
        return f.matcher(this.a).matches();
    }

    public final String toString() {
        return new StringBuilder(z[9]).append(this.b).append('\'').append(z[11]).append(this.c).append('\'').append(z[10]).append(this.d).append('\'').append(z[12]).append(this.a).append('\'').append('}').toString();
    }
}
