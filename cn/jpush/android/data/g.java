package cn.jpush.android.data;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.a.d;
import cn.jpush.android.a.f;
import cn.jpush.android.api.b;
import cn.jpush.android.d.a;
import cn.jpush.android.d.c;
import cn.jpush.android.d.e;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public final class g extends b {
    private static final String[] Q;
    private static final long serialVersionUID = 2748721849169550485L;
    public String I;
    public int J;
    public int K;
    public int L;
    public ArrayList<String> M;
    public String N;
    public String O;
    public String P;
    public String a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 13;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "7&\u0000{m";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
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
            case 0: goto L_0x00ac;
            case 1: goto L_0x00b0;
            case 2: goto L_0x00b4;
            case 3: goto L_0x00b8;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 1;
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
        goto L_0x0017;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0012;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004b;
            case 2: goto L_0x0053;
            case 3: goto L_0x005b;
            case 4: goto L_0x0063;
            case 5: goto L_0x006b;
            case 6: goto L_0x0073;
            case 7: goto L_0x007c;
            case 8: goto L_0x0086;
            case 9: goto L_0x0091;
            case 10: goto L_0x009c;
            case 11: goto L_0x00a7;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "4\u000b\u001ad^<\f\u0018";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0013\u001d\u0011)i&\r\u0005)u=Y\u001bfo\t\u0007lg;\u0001U|s>CU";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "7&\u0007`b:&\u0001pq7";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "7&\u001f|l\"&\u0018fe7";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "3\u001a\u0001`n<CUy` \n\u0010),r\u001a\u001agu7\u0017\u0001";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "7&\u0006an%";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "7&\u0001`u>\u001c";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0001\u0011\u001a~D<\r\u001c}x";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        r2 = 9;
        r1 = ":\r\u0001y;}V";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0086:
        r3[r2] = r1;
        r2 = 10;
        r1 = "7&\u0010{d!";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0091:
        r3[r2] = r1;
        r2 = 11;
        r1 = "&\u0016*gt?";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009c:
        r3[r2] = r1;
        r2 = 12;
        r1 = "3\u001a\u0001`n<C\u0005{n1\u001c\u0006z";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a7:
        r3[r2] = r1;
        Q = r4;
        return;
    L_0x00ac:
        r9 = 82;
        goto L_0x001f;
    L_0x00b0:
        r9 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x001f;
    L_0x00b4:
        r9 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        goto L_0x001f;
    L_0x00b8:
        r9 = 9;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.g.<clinit>():void");
    }

    public g() {
        this.M = new ArrayList();
        this.N = "";
        this.O = "";
        this.p = 0;
    }

    public final void a(final Context context) {
        e.a(Q[8], Q[12]);
        new Thread(this) {
            private static final String[] z;
            final /* synthetic */ g c;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            static {
                /*
                r0 = 20;
                r3 = new java.lang.String[r0];
                r2 = 0;
                r1 = "9\u000b=UC";
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
                    case 0: goto L_0x00fa;
                    case 1: goto L_0x00fe;
                    case 2: goto L_0x0102;
                    case 3: goto L_0x0106;
                    default: goto L_0x001e;
                };
            L_0x001e:
                r9 = 47;
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
                    default: goto L_0x003c;
                };
            L_0x003c:
                r3[r2] = r1;
                r2 = 1;
                r1 = "~\u000e.\u0018\\e\u0000t\u001a";
                r0 = 0;
                r3 = r4;
                goto L_0x0009;
            L_0x0044:
                r3[r2] = r1;
                r2 = 2;
                r1 = "d\u000b&Ojy\u0017 LV7\u0013;WLr\u0010:\u0018\\c\u0002;L\u000fe\u0016'\u0019\u000fd\u000b&Obx\u0007,\u0018\u00127";
                r0 = 1;
                r3 = r4;
                goto L_0x0009;
            L_0x004c:
                r3[r2] = r1;
                r2 = 3;
                r1 = "P\u0006=\u0018Ar\u0017>W]|C9QLc\u0016;]\u000fq\u0002 TJsOiKGx\u0014iZNd\n*\u0018Ax\u0017 ^Ft\u0002=Q@yC&VCnM";
                r0 = 2;
                r3 = r4;
                goto L_0x0009;
            L_0x0054:
                r3[r2] = r1;
                r2 = 4;
                r1 = "v\r-J@~\u0007gHJe\u000e K\\~\f'\u0016}R\"\rgjO7\fjaV/\u0016k{X1\bj";
                r0 = 3;
                r3 = r4;
                goto L_0x0009;
            L_0x005c:
                r3[r2] = r1;
                r2 = 5;
                r1 = "D\u000b&Ojy\u0017 LV";
                r0 = 4;
                r3 = r4;
                goto L_0x0009;
            L_0x0064:
                r3[r2] = r1;
                r2 = 6;
                r1 = "[\f(\\\\7\u0011 [G7\u0013<KG7\u0011,K@b\u0011*]\\7\u0010<[Lr\u0006-\u0014\u000f`\u0006+nFr\u0014iOF{\u000fiW_r\ri[Nt\u000b,\u0019";
                r0 = 5;
                r3 = r4;
                goto L_0x0009;
            L_0x006c:
                r3[r2] = r1;
                r2 = 7;
                r1 = "Y,\u001d}\u00157\u0005(QCr\u0007iL@7\u0007&OA{\f(\\\u000f\u0017$T\u000fg\u0002.]\u00017$ NJ7\u00169\u0018[\n:\u0016";
                r0 = 6;
                r3 = r4;
                goto L_0x0009;
            L_0x0074:
                r3[r2] = r1;
                r2 = 8;
                r1 = "P\u0006=\u0018Kr\u0015,T@g\u0006;\u0018_~\u0000=M]rC/YF{\u0006-\u0014\u000fd\u000b&O\u000fu\u0002:QL7\r&LFq\n*Y[~\f'\u0018@y\u000f0\u0016";
                r0 = 7;
                r3 = r4;
                goto L_0x0009;
            L_0x007d:
                r3[r2] = r1;
                r2 = 9;
                r1 = "E\n*P\u0002g\u0016:P\u000fy\u0006,\\\\7\u0017!]\u000fg\u0006;UFd\u0010 WA7\f/\u0018xE*\u001d}pR;\u001d}}Y\"\u0005g|C,\u001byhROiHCr\u0002:]\u000fe\u00068MJd\u0017iQ[9";
                r0 = 8;
                r3 = r4;
                goto L_0x0009;
            L_0x0087:
                r3[r2] = r1;
                r2 = 10;
                r1 = "Y\fiHJe\u000e K\\~\f'\u0018[xC>JFc\u0006iJJd\f<JLrC=W\u000fd\u0017&JNp\u0006e\u0018\\\f>\u0018Mv\u0010 [\u000fy\f=QI~\u0000(LFx\riWA{\u001ag";
                r0 = 9;
                r3 = r4;
                goto L_0x0009;
            L_0x0092:
                r3[r2] = r1;
                r2 = 11;
                r1 = "[\f(\\\\7\u0011 [G7\u0013<KG7\u0011,K@b\u0011*]\\7\u0005(QCr\u0007e\u0018Xr\u0001\u001fQJ`C>QC{C&HJyC<JC6";
                r0 = 10;
                r3 = r4;
                goto L_0x0009;
            L_0x009d:
                r3[r2] = r1;
                r2 = 12;
                r1 = ";C#MBg.&\\J7^i";
                r0 = 11;
                r3 = r4;
                goto L_0x0009;
            L_0x00a8:
                r3[r2] = r1;
                r2 = 13;
                r1 = "\u0017=H\u00158L";
                r0 = 12;
                r3 = r4;
                goto L_0x0009;
            L_0x00b3:
                r3[r2] = r1;
                r2 = 14;
                r1 = "Y\fiHJe\u000e K\\~\f'\u0018[xC;]NsC;]\\x\u0016;[J7\u0005;WB7\u0010=W]v\u0004,\u0014\u000fd\u000b&O\u000fu\u0002:QL7\r&LFq\n*Y[~\f'\u0018@y\u000f0\u0016";
                r0 = 13;
                r3 = r4;
                goto L_0x0009;
            L_0x00be:
                r3[r2] = r1;
                r2 = 15;
                r1 = "q\n%]\u00158L";
                r0 = 14;
                r3 = r4;
                goto L_0x0009;
            L_0x00c9:
                r3[r2] = r1;
                r2 = 16;
                r1 = "B\r,@_r\u0000=]K-C<VDy\f>V\u000fd\u000b&O\u000f7\u000e&\\J7Ni";
                r0 = 15;
                r3 = r4;
                goto L_0x0009;
            L_0x00d4:
                r3[r2] = r1;
                r2 = 17;
                r1 = "v\r-J@~\u0007gHJe\u000e K\\~\f'\u0016xE*\u001d}pR;\u001d}}Y\"\u0005g|C,\u001byhR";
                r0 = 16;
                r3 = r4;
                goto L_0x0009;
            L_0x00df:
                r3[r2] = r1;
                r2 = 18;
                r1 = ";C;QL70HJ7^i";
                r0 = 17;
                r3 = r4;
                goto L_0x0009;
            L_0x00ea:
                r3[r2] = r1;
                r2 = 19;
                r1 = "\u0017=H\\-Lf";
                r0 = 18;
                r3 = r4;
                goto L_0x0009;
            L_0x00f5:
                r3[r2] = r1;
                z = r4;
                return;
            L_0x00fa:
                r9 = 23;
                goto L_0x0020;
            L_0x00fe:
                r9 = 99;
                goto L_0x0020;
            L_0x0102:
                r9 = 73;
                goto L_0x0020;
            L_0x0106:
                r9 = 56;
                goto L_0x0020;
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.g.1.<clinit>():void");
            }

            public final void run() {
                e.a(z[5], new StringBuilder(z[2]).append(this.c.L).append(z[18]).append(this.c.K).append(z[12]).append(this.c.J).toString());
                if (this.c.L != 0) {
                    e.c(z[5], new StringBuilder(z[16]).append(this.c.L).toString());
                    return;
                }
                String str = this.c;
                String str2 = this.a;
                String str3 = this.x;
                if (this.K == 0) {
                    if (this.v == 3 && !TextUtils.isEmpty(str3)) {
                        Object a;
                        if (str3.startsWith(z[13]) || str3.startsWith(z[19])) {
                            if (a.b(context, z[17])) {
                                a = b.a(context, str3, str);
                                if (TextUtils.isEmpty(a)) {
                                    e.h(z[5], z[3]);
                                } else {
                                    this.x = a;
                                }
                            } else {
                                e.h(z[5], z[10]);
                            }
                        } else if (a.b(context, z[4])) {
                            a = c.c(context, str3);
                            if (TextUtils.isEmpty(a)) {
                                e.h(z[5], z[8]);
                            } else {
                                this.x = a;
                            }
                        } else {
                            e.h(z[5], z[14]);
                        }
                    }
                    d.a(str, TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, context);
                    b.a(context, this);
                } else if (4 == this.K) {
                    this.P = str2;
                    d.a(str, TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, context);
                    b.a(context, this);
                } else if (a.b(context, z[17])) {
                    int i;
                    String responseBody;
                    for (i = 0; i < 4; i++) {
                        HttpResponse a2 = cn.jpush.android.b.a.a(str2, 5, 5000);
                        if (a2 != null && a2.getResponseCode() == 200) {
                            responseBody = a2.getResponseBody();
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    responseBody = null;
                    String b = c.b(context, str);
                    if (i != 0) {
                        str3 = b + str + z[0];
                        String substring = str2.substring(0, str2.lastIndexOf(HttpUtils.PATHS_SEPARATOR) + 1);
                        if (this.M.isEmpty()) {
                            this.P = this.a;
                            b.a(context, this);
                            return;
                        } else if (b.a(this.M, context, substring, str, this.a())) {
                            e.c(z[5], z[6]);
                            if (c.a(str3, responseBody.replaceAll(new StringBuilder(z[1]).append(substring).toString(), new StringBuilder(z[1]).append(b).toString()), context)) {
                                this.P = new StringBuilder(z[15]).append(str3).toString();
                                d.a(str, TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, context);
                                b.a(context, this);
                                return;
                            }
                            d.a(str, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null, context);
                            return;
                        } else {
                            e.c(z[5], z[11]);
                            d.a(str, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null, context);
                            b.a(context, this);
                            return;
                        }
                    }
                    e.g(z[5], z[7]);
                    d.a(str, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null, context);
                    d.a(str, 1021, a.a(context, str2), context);
                } else {
                    e.j(z[5], z[9]);
                    d.a(str, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null, context);
                }
            }
        }.start();
    }

    public final boolean a(JSONObject jSONObject) {
        e.a(Q[8], Q[5]);
        this.a = jSONObject.optString(Q[0], "").trim();
        this.I = jSONObject.optString(Q[7], "").trim();
        if (!f.a(this.a)) {
            this.a = new StringBuilder(Q[9]).append(this.a).toString();
            e.e(Q[8], new StringBuilder(Q[2]).append(this.a).toString());
        }
        this.K = jSONObject.optInt(Q[3], 0);
        this.J = jSONObject.optInt(Q[4], 0);
        this.L = jSONObject.optInt(Q[6], 0);
        if (3 == this.K || 2 == this.K || 1 == this.K) {
            this.M = cn.jpush.android.d.b.a(jSONObject.optJSONArray(Q[10]));
        }
        this.N = jSONObject.optString(Q[1], "");
        this.O = jSONObject.optString(Q[11], "");
        return true;
    }
}
