package cn.jiguang.e;

import android.text.TextUtils;
import cn.jiguang.b.a.a;
import cn.jiguang.c.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    private static final HashMap<Integer, String> a;
    private static long b = 0;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = ".;\u0005`";
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
            case 0: goto L_0x00bd;
            case 1: goto L_0x00c1;
            case 2: goto L_0x00c5;
            case 3: goto L_0x00c9;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 100;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = ";!\u0001l\u000b4";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "3,\u0006q\u00056.*q\u001d*'";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = ";2\u0005Z\u0005>&*w\t,";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "36\u001ch\u0001";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = ";&\u0011";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = ";2\u0005l\u0000";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u000f,\u001ek\u000b-,U`\u0016(-\u0007%\u00075&\u0010%Iz";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\t6\u0014q\u0011)\u0001\u001aa\u0001";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "(/\u0003";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        r3 = new java.util.HashMap;
        r3.<init>();
        a = r3;
        r0 = 0;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u0015\t";
        r0 = -1;
    L_0x009a:
        r1 = r1.toCharArray();
        r4 = r1.length;
        r5 = 0;
        r6 = 1;
        if (r4 > r6) goto L_0x00d9;
    L_0x00a3:
        r6 = r1;
        r7 = r5;
        r11 = r4;
        r4 = r1;
        r1 = r11;
    L_0x00a8:
        r9 = r4[r5];
        r8 = r7 % 5;
        switch(r8) {
            case 0: goto L_0x00cc;
            case 1: goto L_0x00cf;
            case 2: goto L_0x00d2;
            case 3: goto L_0x00d5;
            default: goto L_0x00af;
        };
    L_0x00af:
        r8 = 100;
    L_0x00b1:
        r8 = r8 ^ r9;
        r8 = (char) r8;
        r4[r5] = r8;
        r5 = r7 + 1;
        if (r1 != 0) goto L_0x00d7;
    L_0x00b9:
        r4 = r6;
        r7 = r5;
        r5 = r1;
        goto L_0x00a8;
    L_0x00bd:
        r9 = 90;
        goto L_0x0020;
    L_0x00c1:
        r9 = 66;
        goto L_0x0020;
    L_0x00c5:
        r9 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        goto L_0x0020;
    L_0x00c9:
        r9 = 5;
        goto L_0x0020;
    L_0x00cc:
        r8 = 90;
        goto L_0x00b1;
    L_0x00cf:
        r8 = 66;
        goto L_0x00b1;
    L_0x00d2:
        r8 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        goto L_0x00b1;
    L_0x00d5:
        r8 = 5;
        goto L_0x00b1;
    L_0x00d7:
        r4 = r1;
        r1 = r6;
    L_0x00d9:
        if (r4 > r5) goto L_0x00a3;
    L_0x00db:
        r4 = new java.lang.String;
        r4.<init>(r1);
        r1 = r4.intern();
        switch(r0) {
            case 0: goto L_0x00f6;
            case 1: goto L_0x0105;
            case 2: goto L_0x0114;
            case 3: goto L_0x0124;
            case 4: goto L_0x0134;
            case 5: goto L_0x0144;
            case 6: goto L_0x0154;
            case 7: goto L_0x0164;
            case 8: goto L_0x0175;
            case 9: goto L_0x0186;
            case 10: goto L_0x0197;
            case 11: goto L_0x01a8;
            case 12: goto L_0x01b9;
            case 13: goto L_0x01ca;
            case 14: goto L_0x01db;
            default: goto L_0x00e7;
        };
    L_0x00e7:
        r3.put(r2, r1);
        r3 = a;
        r0 = -1001; // 0xfffffffffffffc17 float:NaN double:NaN;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u001f:\u0016`\u0001>b\u0017p\u0002<'\u0007%\u001738\u0010+D\n.\u0010d\u0017?b\u0016j\n.#\u0016qD)7\u0005u\u000b(6[";
        r0 = 0;
        goto L_0x009a;
    L_0x00f6:
        r3.put(r2, r1);
        r3 = a;
        r0 = -1000; // 0xfffffffffffffc18 float:NaN double:NaN;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u0019-\u001bk\u000196\u001cj\nz$\u0014l\b?&[%46'\u0014v\u0001z!\u001d`\u00071b\fj\u0011(b\u0016j\n4'\u0016q\r5,Ud\n>b\u0007`\u0010(;Ui\u0005.'\u0007$";
        r0 = 1;
        goto L_0x009a;
    L_0x0105:
        r3.put(r2, r1);
        r3 = a;
        r0 = -998; // 0xfffffffffffffc1a float:NaN double:NaN;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\t'\u001ba\r4%Uc\u00053.\u0010aD50Uq\r7'\u001ap\u0010tb%i\u0001;1\u0010%6?6\u0007|D6#\u0001`\u0016{";
        r0 = 2;
        goto L_0x009a;
    L_0x0114:
        r3.put(r2, r1);
        r3 = a;
        r0 = -997; // 0xfffffffffffffc1b float:NaN double:NaN;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\b'\u0016`\r,+\u001bbD<#\u001ci\u0001>b\u001awD.+\u0018`\u000b/6[%46'\u0014v\u0001z\u0010\u0010q\u0016#b\u0019d\u0010?0T";
        r0 = 3;
        goto L_0x009a;
    L_0x0124:
        r3.put(r2, r1);
        r3 = a;
        r0 = -996; // 0xfffffffffffffc1c float:NaN double:NaN;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u0019-\u001bk\u000196\u001cj\nz+\u0006%\u00076-\u0006`\u0000tb%i\u0001;1\u0010%6?6\u0007|D6#\u0001`\u0016{";
        r0 = 4;
        goto L_0x009a;
    L_0x0134:
        r3.put(r2, r1);
        r3 = a;
        r0 = -994; // 0xfffffffffffffc1e float:NaN double:NaN;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\b'\u0006u\u000b41\u0010%\u00103/\u0010j\u0011.lUU\b?#\u0006`D\b'\u0001w\u001dz.\u0014q\u0001(c";
        r0 = 5;
        goto L_0x009a;
    L_0x0144:
        r3.put(r2, r1);
        r3 = a;
        r0 = -993; // 0xfffffffffffffc1f float:NaN double:NaN;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u0013,\u0003d\b3&Uv\u000b9)\u0010qJz\u0012\u0019`\u0005)'UW\u0001.0\f%\b;6\u0010wE";
        r0 = 6;
        goto L_0x009a;
    L_0x0154:
        r3.put(r2, r1);
        r3 = a;
        r0 = 11;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u001c#\u001ci\u0001>b\u0001jD('\u0012l\u0017.'\u0007$";
        r0 = 7;
        goto L_0x009a;
    L_0x0164:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1005; // 0x3ed float:1.408E-42 double:4.965E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u0003-\u0000wD;2\u0005N\u0001#b\u0014k\u0000z#\u001ba\u00165+\u0011%\u0014;!\u001ed\u0003?b\u001bd\t?b\u0014w\u0001z,\u001aqD7#\u0001f\f?&[%46'\u0014v\u0001z&\u001ap\u00066'Uf\f?!\u001e%\u00102'\u0018%\u00059!\u001aw\u00003,\u0012%\u00105b4u\u00146+\u0016d\u00103-\u001b%\u001d57Uf\u0016?#\u0001`\u0000z-\u001b%450\u0001d\bt";
        r0 = 8;
        goto L_0x009a;
    L_0x0175:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u0003-\u0000%\u00054&\u0007j\r>b\u0005d\u00071#\u0012`D4#\u0018`D31Uk\u000b.b\u0010}\r)6Y%46'\u0014v\u0001z0\u0010b\r)6\u0010wD#-\u0000wD*#\u0016d\u000f='Uk\u00057'Ul\nz\u0012\u001aw\u0010;.[";
        r0 = 9;
        goto L_0x009a;
    L_0x0186:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u0013,\u0003d\b3&UL\t?+Y%6?%\u001cv\u0010?0Ud\u0003;+\u001b+";
        r0 = 10;
        goto L_0x009a;
    L_0x0197:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1009; // 0x3f1 float:1.414E-42 double:4.985E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\u0003-\u0000wD;2\u0005N\u0001#b\u001cvD('\u0019d\u0010?&Uq\u000bz#Uk\u000b4o4k\u0000(-\u001caD\u001b2\u0005+46'\u0014v\u0001z7\u0006`D#-\u0000wD\u001b,\u0011w\u000b3&UD\u0014*e\u0006%\u0005*2>`\u001dvb\u001awD;&\u0011%\u00054b4k\u0000(-\u001caD;2\u0005%\u000250Uq\f31Ud\u0014*\t\u0010|J";
        r0 = 11;
        goto L_0x009a;
    L_0x01a8:
        r3.put(r2, r1);
        r3 = a;
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "\b'\u0016`\r,'\u0007%\u0000;6\u0014%\u0014;0\u0006`D?0\u0007j\u0016";
        r0 = 12;
        goto L_0x009a;
    L_0x01b9:
        r3.put(r2, r1);
        r3 = a;
        r0 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "krG%Iz\u000b\u001bf\u000b(0\u0010f\u0010z2\u0014v\u0017--\u0007a";
        r0 = 13;
        goto L_0x009a;
    L_0x01ca:
        r3.put(r2, r1);
        r3 = a;
        r0 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "krM%Iz\u000b\u001bf\u000b(0\u0010f\u0010z7\u001ca";
        r0 = 14;
        goto L_0x009a;
    L_0x01db:
        r3.put(r2, r1);
        r0 = 0;
        b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.h.<clinit>():void");
    }

    public static String a(int i) {
        if (a.containsKey(Integer.valueOf(i))) {
            return (String) a.get(Integer.valueOf(i));
        }
        d.c(z[8], new StringBuilder(z[7]).append(i).toString());
        return null;
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(z[1], z[9]);
            jSONObject.put(z[6], str);
            jSONObject.put(z[4], a.q());
            jSONObject.put(z[0], z[3]);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public static JSONObject a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(z[1], z[5]);
            jSONObject.put(z[6], str);
            jSONObject.put(z[4], a.q());
            jSONObject.put(z[0], z[3]);
            jSONObject.put(z[2], i);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
