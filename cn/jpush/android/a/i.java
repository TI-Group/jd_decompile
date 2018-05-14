package cn.jpush.android.a;

import cn.jpush.android.d.e;
import java.util.HashMap;

/* compiled from: TbsSdkJava */
public final class i {
    private static final HashMap<Integer, String> a;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 2;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "C\u001c8fRa\u001cszXf\u001d!|\u001du\u001d7m\u001d;R";
        r0 = -1;
        r4 = r3;
    L_0x0008:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
    L_0x0011:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0016:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x007a;
            case 1: goto L_0x007d;
            case 2: goto L_0x0080;
            case 3: goto L_0x0083;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 61;
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
        goto L_0x0016;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0011;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "E\u00062|He1<lX";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        z = r4;
        r3 = new java.util.HashMap;
        r3.<init>();
        a = r3;
        r0 = 995; // 0x3e3 float:1.394E-42 double:4.916E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "[\u0017 {\\q\u0017sBnY<sx\\d\u0001:fZ6\u0001&k^s\u00177";
        r0 = -1;
    L_0x0057:
        r1 = r1.toCharArray();
        r4 = r1.length;
        r5 = 0;
        r6 = 1;
        if (r4 > r6) goto L_0x0094;
    L_0x0060:
        r6 = r1;
        r7 = r5;
        r11 = r4;
        r4 = r1;
        r1 = r11;
    L_0x0065:
        r9 = r4[r5];
        r8 = r7 % 5;
        switch(r8) {
            case 0: goto L_0x0086;
            case 1: goto L_0x0089;
            case 2: goto L_0x008c;
            case 3: goto L_0x008f;
            default: goto L_0x006c;
        };
    L_0x006c:
        r8 = 61;
    L_0x006e:
        r8 = r8 ^ r9;
        r8 = (char) r8;
        r4[r5] = r8;
        r5 = r7 + 1;
        if (r1 != 0) goto L_0x0092;
    L_0x0076:
        r4 = r6;
        r7 = r5;
        r5 = r1;
        goto L_0x0065;
    L_0x007a:
        r9 = 22;
        goto L_0x001f;
    L_0x007d:
        r9 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        goto L_0x001f;
    L_0x0080:
        r9 = 83;
        goto L_0x001f;
    L_0x0083:
        r9 = 8;
        goto L_0x001f;
    L_0x0086:
        r8 = 22;
        goto L_0x006e;
    L_0x0089:
        r8 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        goto L_0x006e;
    L_0x008c:
        r8 = 83;
        goto L_0x006e;
    L_0x008f:
        r8 = 8;
        goto L_0x006e;
    L_0x0092:
        r4 = r1;
        r1 = r6;
    L_0x0094:
        if (r4 > r5) goto L_0x0060;
    L_0x0096:
        r4 = new java.lang.String;
        r4.<init>(r1);
        r1 = r4.intern();
        switch(r0) {
            case 0: goto L_0x00b1;
            case 1: goto L_0x00c0;
            case 2: goto L_0x00cf;
            case 3: goto L_0x00df;
            case 4: goto L_0x00ef;
            case 5: goto L_0x00ff;
            case 6: goto L_0x010f;
            case 7: goto L_0x011f;
            case 8: goto L_0x0130;
            case 9: goto L_0x0141;
            case 10: goto L_0x0152;
            case 11: goto L_0x0163;
            case 12: goto L_0x0174;
            case 13: goto L_0x0185;
            case 14: goto L_0x0196;
            case 15: goto L_0x01a7;
            case 16: goto L_0x01b8;
            case 17: goto L_0x01c9;
            case 18: goto L_0x01da;
            case 19: goto L_0x01eb;
            case 20: goto L_0x01fc;
            case 21: goto L_0x020d;
            case 22: goto L_0x021e;
            case 23: goto L_0x022f;
            case 24: goto L_0x0240;
            case 25: goto L_0x0251;
            case 26: goto L_0x0262;
            case 27: goto L_0x0273;
            default: goto L_0x00a2;
        };
    L_0x00a2:
        r3.put(r2, r1);
        r3 = a;
        r0 = 996; // 0x3e4 float:1.396E-42 double:4.92E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "[\u0017 {\\q\u0017sBnY<sx\\d\u0001:fZ6\u00142aQs\u0016";
        r0 = 0;
        goto L_0x0057;
    L_0x00b1:
        r3.put(r2, r1);
        r3 = a;
        r0 = 997; // 0x3e5 float:1.397E-42 double:4.926E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "[\u0017 {\\q\u0017siQd\u00172lD6\u00006kX\u00046l\u00116\u0015:~X6\u0007#";
        r0 = 1;
        goto L_0x0057;
    L_0x00c0:
        r3.put(r2, r1);
        r3 = a;
        r0 = 998; // 0x3e6 float:1.398E-42 double:4.93E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "[\u0017 {\\q\u0017siQd\u00172lD6\u00006kX\u00046l\u00116\u0001'aQzR#zRu\u0017 {";
        r0 = 2;
        goto L_0x0057;
    L_0x00cf:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "C\u00016z\u001du\u001e:kVs\u0016siSrR<xXx\u00177(I~\u0017sEXe\u00012oX";
        r0 = 3;
        goto L_0x0057;
    L_0x00df:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "[\u0017 {\\q\u0017slRa\u001c?g\\rR }^u\u00176l";
        r0 = 4;
        goto L_0x0057;
    L_0x00ef:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "[\u0017 {\\q\u0017szXu\u0017:~XrR }^u\u00176l";
        r0 = 5;
        goto L_0x0057;
    L_0x00ff:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "[\u0017 {\\q\u0017s{Tz\u0017=kX6\u0016<Sz\u001d2l\u001de\u00070kXs\u0016";
        r0 = 6;
        goto L_0x0057;
    L_0x010f:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "@\u001b7mR6\u0001:dXx\u00116(Yy\u0005=d\\y\u0016s{Hu\u00116mY";
        r0 = 7;
        goto L_0x0057;
    L_0x011f:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1005; // 0x3ed float:1.408E-42 double:4.965E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "C\u00016z\u001du\u001e:kVs\u0016s~Tr\u0017<(\\x\u0016sbH{\u00026l\u001db\u001ds}OzR\u001emNe\u00134m\u001d>\u0010!gJe\u0017!!";
        r0 = 8;
        goto L_0x0057;
    L_0x0130:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "@\u001b7mR6\u001b ([y\u00000m\u001du\u001e<{XrR1q\u001dc\u00016z";
        r0 = 9;
        goto L_0x0057;
    L_0x0141:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "C\u00016z\u001du\u001e:kVs\u0016s/r]U";
        r0 = 10;
        goto L_0x0057;
    L_0x0152:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "C\u00016z\u001du\u001e:kVs\u0016s/~w\u001c0mQ1";
        r0 = 11;
        goto L_0x0057;
    L_0x0163:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1011; // 0x3f3 float:1.417E-42 double:4.995E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "R\u001d$fQy\u00137([w\u001b?mY";
        r0 = 12;
        goto L_0x0057;
    L_0x0174:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1012; // 0x3f4 float:1.418E-42 double:5.0E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "C\u00016z\u001du\u001e:kVs\u0016s|R6\u0016<Sz\u001d2l\u001dw\u00152aS";
        r0 = 13;
        goto L_0x0057;
    L_0x0185:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1013; // 0x3f5 float:1.42E-42 double:5.005E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "B\u001a6([\u001e6(\\z\u00006iYoR6pTe\u0006siSrR iPsR aGs\\sLRxU'(Yy\u0005=dRw\u0016siZw\u001b=&";
        r0 = 14;
        goto L_0x0057;
    L_0x0196:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1100; // 0x44c float:1.541E-42 double:5.435E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "_\u001c%iQ\u0016sx\\d\u0013>(RdR&fXn\u00026kIs\u0016szXe\u0007?|\u0013";
        r0 = 15;
        goto L_0x0057;
    L_0x01a7:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1014; // 0x3f6 float:1.421E-42 double:5.01E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "P\u0013:dXrR'g\u001df\u00006dRw\u0016szXg\u0007:zXrR!mNy\u0007!kX";
        r0 = 16;
        goto L_0x0057;
    L_0x01b8:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1015; // 0x3f7 float:1.422E-42 double:5.015E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "C\u00016z\u001du\u001e:kVs\u0016saSe\u00062dQ6\u0013?mObR<f\u001de\u00062|HeR1iO6\u00135|XdR7gJx\u001e<iY\u001c4([\u001c:{Us\u0016}";
        r0 = 17;
        goto L_0x0057;
    L_0x01c9:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1016; // 0x3f8 float:1.424E-42 double:5.02E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "C\u00016z\u001du\u001e:kVs\u0016s|UsR$m_`\u001b6\u001aeR&zQ";
        r0 = 18;
        goto L_0x0057;
    L_0x01da:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1017; // 0x3f9 float:1.425E-42 double:5.025E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "C\u00016z\u001du\u001e:kVs\u0016sk\\z\u001esi^b\u001b<f";
        r0 = 19;
        goto L_0x0057;
    L_0x01eb:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1018; // 0x3fa float:1.427E-42 double:5.03E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "B\u001a6(ps\u0001 iZsR `RaR:f\u001db\u001a6(Nb\u0013'}N6\u00102z";
        r0 = 20;
        goto L_0x0057;
    L_0x01fc:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1019; // 0x3fb float:1.428E-42 double:5.035E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "U\u001e:kV6\u0013#xQ\u0001'(\\x\u0016s{Uy\u0005s|UsR\u001emNe\u00134m";
        r0 = 21;
        goto L_0x0057;
    L_0x020d:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1020; // 0x3fc float:1.43E-42 double:5.04E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "R\u001d$f\u001d\u001f2oX6\u00142aQs\u0016";
        r0 = 22;
        goto L_0x0057;
    L_0x021e:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1021; // 0x3fd float:1.431E-42 double:5.044E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "R\u001d$f\u001d~\u0006>d\u001dp\u0013:dXr";
        r0 = 23;
        goto L_0x0057;
    L_0x022f:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1022; // 0x3fe float:1.432E-42 double:5.05E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "R\u001d$f\u001d[\u0017 {\\q\u0017sn\\\u001e6l";
        r0 = 24;
        goto L_0x0057;
    L_0x0240:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1030; // 0x406 float:1.443E-42 double:5.09E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "R\u001b k\\d\u0016s|UsR>mNe\u00134m\u001dt\u00170iHe\u0017saI6\u001b (Sy\u0006saS6\u0006;m\u001df\u0007 `\u001db\u001b>m";
        r0 = 25;
        goto L_0x0057;
    L_0x0251:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1031; // 0x407 float:1.445E-42 double:5.094E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "E\u0006<x\u001df\u0007 `\u001de\u0017!~Tu\u0017";
        r0 = 26;
        goto L_0x0057;
    L_0x0262:
        r3.put(r2, r1);
        r3 = a;
        r0 = 1032; // 0x408 float:1.446E-42 double:5.1E-321;
        r2 = java.lang.Integer.valueOf(r0);
        r1 = "D\u0017 }PsR#}N~R mO`\u001b0m";
        r0 = 27;
        goto L_0x0057;
    L_0x0273:
        r3.put(r2, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.i.<clinit>():void");
    }

    public static String a(int i) {
        if (a.containsKey(Integer.valueOf(i))) {
            return (String) a.get(Integer.valueOf(i));
        }
        e.c(z[1], new StringBuilder(z[0]).append(i).toString());
        return "";
    }
}
