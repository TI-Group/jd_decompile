package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpResponse;
import cn.jpush.android.d.e;
import cn.jpush.android.data.a;
import cn.jpush.android.data.b;
import cn.jpush.android.data.g;
import com.tencent.smtt.utils.TbsLog;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public final class f {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 40;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "M@k\u0015vmJ=\u0001hh\u000e0T";
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
            case 0: goto L_0x01d6;
            case 1: goto L_0x01d9;
            case 2: goto L_0x01dd;
            case 3: goto L_0x01e1;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 26;
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
            case 38: goto L_0x01d1;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "T\\r\u0000ugAq<h^x\u0006";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "Zuu\u0000ntRu\u0000nt]@_ +\u00013^";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "jAi\u001d|mM|\u001dujqi\rja";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "gAs\u0000jZB\u0000ctK";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "jq\u0001shJx\u0006EmJ";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "jqr\u001av}";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "i]z+s`";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "pGi\u0018";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "eJB\u001d~";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "eMi\u001duj\u0014m\u0006TOo\u0007K\\t\u0013sjOq9iccx\u0007ieIxT7$Ao\u001d}m@|\u0018PwAsN\u0010";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "ACm\u0000c$Ao\u001d}m@|\u0018:n]r\u001a:pVi";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "t\\x${v]x;hmIt\u001a{hcn\u0013Wa]n\u0015}a\u000ep\u0007}MJ=I:";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "aVi\u0006{w";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "iKn\u0007{cK";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "kXx\u0006hmJx+wwIB\u001d~";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "pAm>ik@R\u0016paMiT'9\u000es\u0001vh";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "Ja=9ICgY";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "wFr\u0003EpWm\u0011";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "J{Q8:gAs\u0000|Z";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "JaB9ICgY";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "tOo\u0007$Dn\u001bt$Ko\u0006uv";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "J{Q8:n]r\u001a:kLw\u0011yp";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "cKiTpwAsTufDx\u0017n$Ko\u0006uv";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "ACm\u0000c$Dn\u001bt$@|\u0019$ZrT}aZ";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "Q@v\u001aus\u000ep\u0007}$Zd\u0004$Oy+n$\u0013=";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "WFr\u0003_jZt\u0000c*^o\u001bya]nTurKoZ";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "PFxTiaMr\u001a~N]r\u001aUfDx\u0017n$GnTtqBqU";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "Q@v\u001aus@=9IC\u000em\u0006upA~\u001bv$Xx\u0006imAsZ:CGk\u0011:q^=Y:";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "iq~\u001btpKs\u0000";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "eJB\u0000";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "eMi\u001duj\u0014m\u0015hwKP\u0007}IKn\u0007{cK";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "A@i\u001dn}\u0000m\u0015hwK=\u0000ra\u000en\u0011yk@yTpwAsTufDx\u0017n$Ak\u0011h*";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "T[n\u001c:iKn\u0007{cK=\u0004{v]t\u001a}$H|\u001dvaJ3T]mXxTot\u000em\u0006ugKn\u0007sjI3";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "eMi\u001duj\u0014m\u0015hwKR\u0006scGs\u0015vI]z9w]|\u0013$\u0003=\u001bhmIt\u001a{hdn\u001bt>$";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "BOt\u0018`\u000ei\u001b:cKiTpwAsT|vApTovB=\u0016gOh\u0007kH=\u001dtrOq\u001d~$[o\u0018:)\u000e";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "eMi\u001duj\u0014q\u001b{`cn\u0013PwAs2hkCH\u0006v$\u0003=";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "TOo\u0007$Ks\u0010";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "Q@v\u001aus\u000ep\u0007}$Zd\u0004$\u0003=";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "T\\r\u0017w]=\u0011t`";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x01d6:
        r9 = 4;
        goto L_0x0020;
    L_0x01d9:
        r9 = 46;
        goto L_0x0020;
    L_0x01dd:
        r9 = 29;
        goto L_0x0020;
    L_0x01e1:
        r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.f.<clinit>():void");
    }

    public static a a(Context context, String str, String str2, String str3, String str4) {
        e.c(z[1], new StringBuilder(z[10]).append(str).toString());
        if (context == null) {
            throw new IllegalArgumentException(z[19]);
        } else if (TextUtils.isEmpty(str)) {
            e.i(z[1], z[11]);
            d.a(z[17], TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
            return null;
        } else {
            JSONObject a = a(context, z[20], str);
            if (a == null) {
                e.c(z[1], z[16]);
                return null;
            }
            CharSequence optString = a.optString(z[7], "");
            if (!TextUtils.isEmpty(optString)) {
                CharSequence charSequence = optString;
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = a.optString(z[9], "");
            }
            e.c(z[1], new StringBuilder(z[12]).append(str4).toString());
            boolean z = a.optInt(z[6], 0) == 1;
            int optInt = z ? a.optInt(z[5], 0) : 0;
            a aVar = new a();
            aVar.c = str4;
            aVar.a = a;
            aVar.b = a.optInt(z[18], 3);
            aVar.e = z;
            aVar.f = optInt;
            aVar.g = a.optInt(z[3], 0);
            aVar.i = a.optString(z[14], "");
            aVar.j = a.optString(z[4], "");
            aVar.l = a.optString(z[8], "");
            aVar.m = a.optString(z[13], "");
            aVar.n = str2;
            aVar.o = str3;
            aVar.d = a.optString(z[15], "");
            return aVar;
        }
    }

    private static JSONObject a(Context context, String str, String str2) {
        try {
            return new JSONObject(str2);
        } catch (Throwable e) {
            e.d(z[1], z[21], e);
            d.a(str, TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
            return null;
        }
    }

    public static JSONObject a(Context context, String str, JSONObject jSONObject, String str2) {
        JSONObject jSONObject2 = null;
        if (jSONObject == null) {
            e.g(z[1], z[22]);
            d.a(str, TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
        } else if (TextUtils.isEmpty(str2)) {
            e.g(z[1], z[24]);
        } else {
            try {
                if (!jSONObject.isNull(str2)) {
                    jSONObject2 = jSONObject.getJSONObject(str2);
                }
            } catch (Throwable e) {
                e.d(z[1], z[23], e);
                d.a(str, TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
            }
        }
        return jSONObject2;
    }

    public static void a(Context context, a aVar) {
        e.a(z[1], z[31]);
        if (context == null) {
            throw new IllegalArgumentException(z[19]);
        }
        int i = aVar.b;
        JSONObject jSONObject = aVar.a;
        String str = aVar.c;
        if (i == 3 || i == 4) {
            jSONObject = a(context, str, jSONObject, z[29]);
            if (jSONObject == null) {
                e.g(z[1], z[27]);
                return;
            }
            int optInt = jSONObject.optInt(z[30], -1);
            if (optInt == 0) {
                b gVar = new g();
                gVar.c = str;
                gVar.b = i;
                gVar.p = optInt;
                gVar.h = aVar.h;
                gVar.e = aVar.e;
                gVar.f = aVar.f;
                gVar.n = aVar.n;
                gVar.d = aVar.d;
                gVar.g = aVar.g;
                boolean a = gVar.a(context, jSONObject);
                e.a(z[1], z[32]);
                if (a) {
                    gVar.a(context);
                    e.a(z[1], z[26]);
                    return;
                }
                e.g(z[1], z[33]);
                return;
            }
            e.g(z[1], new StringBuilder(z[25]).append(optInt).toString());
            d.a(str, TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
            return;
        }
        e.c(z[1], new StringBuilder(z[28]).append(i).toString());
        d.a(str, TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
    }

    public static void a(final Context context, String str) {
        e.a(z[1], new StringBuilder(z[34]).append(str).toString());
        if (context == null) {
            throw new IllegalArgumentException(z[19]);
        } else if (TextUtils.isEmpty(str)) {
            e.i(z[1], z[11]);
        } else {
            JSONObject a = a(context, z[17], str);
            if (a != null) {
                String optString = a.optString(z[7], "");
                if (TextUtils.isEmpty(optString)) {
                    optString = a.optString(z[9], "");
                }
                int optInt = a.optInt(z[18], -1);
                if (optInt == 2) {
                    final String trim = a.optString(z[29], "").trim();
                    if (a(trim)) {
                        e.a(z[1], new StringBuilder(z[36]).append(trim).toString());
                        if (context == null) {
                            throw new IllegalArgumentException(z[19]);
                        }
                        new Thread() {
                            private static final String[] z;

                            static {
                                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                                /*
                                r4 = 1;
                                r1 = 0;
                                r0 = 2;
                                r3 = new java.lang.String[r0];
                                r2 = "i8\b7\u0019Ky\u00154\\C6\u0000?\\E*\u000e5\\I+\u000e6\\Z+\r";
                                r0 = -1;
                                r5 = r3;
                                r6 = r3;
                                r3 = r1;
                            L_0x000b:
                                r2 = r2.toCharArray();
                                r7 = r2.length;
                                if (r7 > r4) goto L_0x0057;
                            L_0x0012:
                                r8 = r1;
                            L_0x0013:
                                r9 = r2;
                                r10 = r8;
                                r13 = r7;
                                r7 = r2;
                                r2 = r13;
                            L_0x0018:
                                r12 = r7[r8];
                                r11 = r10 % 5;
                                switch(r11) {
                                    case 0: goto L_0x004b;
                                    case 1: goto L_0x004e;
                                    case 2: goto L_0x0051;
                                    case 3: goto L_0x0054;
                                    default: goto L_0x001f;
                                };
                            L_0x001f:
                                r11 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
                            L_0x0021:
                                r11 = r11 ^ r12;
                                r11 = (char) r11;
                                r7[r8] = r11;
                                r8 = r10 + 1;
                                if (r2 != 0) goto L_0x002d;
                            L_0x0029:
                                r7 = r9;
                                r10 = r8;
                                r8 = r2;
                                goto L_0x0018;
                            L_0x002d:
                                r7 = r2;
                                r2 = r9;
                            L_0x002f:
                                if (r7 > r8) goto L_0x0013;
                            L_0x0031:
                                r7 = new java.lang.String;
                                r7.<init>(r2);
                                r2 = r7.intern();
                                switch(r0) {
                                    case 0: goto L_0x0046;
                                    default: goto L_0x003d;
                                };
                            L_0x003d:
                                r5[r3] = r2;
                                r0 = "+\u000e/\u0013L6\r\u0013\u0019C)\u0004)";
                                r2 = r0;
                                r3 = r4;
                                r5 = r6;
                                r0 = r1;
                                goto L_0x000b;
                            L_0x0046:
                                r5[r3] = r2;
                                z = r6;
                                return;
                            L_0x004b:
                                r11 = 47;
                                goto L_0x0021;
                            L_0x004e:
                                r11 = 89;
                                goto L_0x0021;
                            L_0x0051:
                                r11 = 97;
                                goto L_0x0021;
                            L_0x0054:
                                r11 = 91;
                                goto L_0x0021;
                            L_0x0057:
                                r8 = r1;
                                goto L_0x002f;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.f.1.<clinit>():void");
                            }

                            public final void run() {
                                String responseBody;
                                int i = 0;
                                while (i < 4) {
                                    i++;
                                    HttpResponse a = cn.jpush.android.b.a.a(trim, 5, 8000);
                                    if (a != null && a.getResponseCode() == 200) {
                                        responseBody = a.getResponseBody();
                                        i = 1;
                                        break;
                                    }
                                }
                                i = 0;
                                responseBody = null;
                                if (i == 0 || TextUtils.isEmpty(responseBody)) {
                                    d.a(optString, 1021, cn.jpush.android.d.a.a(context, trim), context);
                                    d.a(optString, TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
                                    e.c(z[1], z[0]);
                                    return;
                                }
                                f.a(context, responseBody);
                            }
                        }.start();
                        return;
                    }
                    e.c(z[1], new StringBuilder(z[35]).append(trim).toString());
                    d.a(optString, TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
                    return;
                }
                a = optInt == 1 ? a(context, optString, a, z[29]) : null;
                if (a != null) {
                    int optInt2 = a.optInt(z[30], -1);
                    switch (optInt2) {
                        case 0:
                            b gVar = new g();
                            boolean a2 = gVar.a(context, a);
                            e.a(z[1], z[37]);
                            gVar.c = optString;
                            gVar.b = optInt;
                            gVar.p = optInt2;
                            if (a2) {
                                gVar.a(context);
                                e.a(z[1], z[39]);
                                return;
                            }
                            e.g(z[1], z[33]);
                            return;
                        default:
                            e.g(z[1], new StringBuilder(z[38]).append(optInt2).toString());
                            d.a(optString, TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, context);
                            return;
                    }
                }
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        boolean matches = trim.matches(z[2]);
        if (!matches) {
            e.g(z[1], new StringBuilder(z[0]).append(trim).toString());
        }
        return matches;
    }
}
