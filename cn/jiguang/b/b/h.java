package cn.jiguang.b.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.b.e.a.a.b;
import cn.jiguang.b.e.a.a.c;
import cn.jiguang.c.d;
import cn.jiguang.service.Protocol;
import com.kepler.jd.login.KeplerApiManager;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public final class h {
    private static h f;
    private static final String[] z;
    private Map<String, i> a = new ConcurrentHashMap();
    private Deque<i> b = new LinkedBlockingDeque();
    private Deque<i> c = new LinkedBlockingDeque();
    private Handler d;
    private Context e;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 50;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "vjw\u0016,Y)._&YmQ\u001a2Blp\u000b\u0017^df\u00106C3";
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
            case 0: goto L_0x0244;
            case 1: goto L_0x0248;
            case 2: goto L_0x024c;
            case 3: goto L_0x024f;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 67;
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
            case 39: goto L_0x01dc;
            case 40: goto L_0x01e7;
            case 41: goto L_0x01f2;
            case 42: goto L_0x01fd;
            case 43: goto L_0x0208;
            case 44: goto L_0x0213;
            case 45: goto L_0x021e;
            case 46: goto L_0x0229;
            case 47: goto L_0x0234;
            case 48: goto L_0x023f;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "elr\n&D}@\u001e _lN\u001e-Vnf\r";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "Rgg-&F|f\f7c`n\u001a,B}#\r&F|f\f7^gd_*D)m\n/[";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "bgf\u00073Rjw\u001a'\u0017$#\u0019\"^ef\u001bcCf#\r&Zfu\u001acElr\n&D}j\u0011$\u0017oq\u0010.\u0017jb\u001c+R'";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "Dlm\u001b\u0011Rxv\u001a0C@m\u000b&Egb\u0013cQhj\u0013&S%`\u001e _l#\u00160\u0017ov\u0013/";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u001b)w\u00171Rhg6'\r";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u001bzg\u0014\u0017NyfE";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001b)w\u0016.Rfv\u000by";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "vjw\u0016,Y)._0Chq\u000b\u0011Rxv\u001a0C]j\u0012&X|w";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "vjw\u0016,Y)._0Rgg-&F|f\f7~gw\u001a1Yho_n\u0017jl\u0011-Rjw\u0016,Y3";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "Dlm\u001b\u0011Rxv\u001a0C@m\u000b&Egb\u0013cQhj\u0013&S%q\u001a2Blp\u000bcShw\u001ec^z#\u00116[e";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "Rgr\n&dlm\u000b\u0012Blv\u001acElr\n&D}j\u0011$\u0017`p_-Beo";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "vjw\u0016,Y)._&Yxv\u001a\u0010Rgw.6R|f";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "Tfm\u0011&T}j\u0010-";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "Elr\n&D}\\\f'\\}z\u000f&";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "Elr\n&D}\\\u000b*Zll\n7";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "Dlm\u001b\u0011Rxv\u001a0C)e\u001e*[lgS1Rxv\u001a0C)g\u001e7V)j\fcY|o\u0013";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "Elr\n&D}\\\u001b\"Ch";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "vjw\u0016,Y)._'Rxv\u001a\u0010Rgw.6R|f";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "D}b\r7dlm\u000b\u0017^df\u00106C)e\u001e*[lgS1Rxv\u001a0C`m\u0018c^z#\u00116[e";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "vjw\u0016,Y)._0Chq\u000b\u0010Rgw+*Zll\n7\u00173";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "Dlm\u001b\u0000Xdn\u001e-S^j\u000b+{fd\u0018&S@m_%V`o\u001a'\rzf\u0011'shw\u001ec^z#\u00116[e";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "Vjw\u0016,Y)._ X{q\u001a CMb\u000b\"d`g>-S\\j\u001boD`gE";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u001b|j\u001by";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "tfq\u001a\u0013Vjh\u001e$R";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "Dlm\u001b\u0000Xdn\u001e-S^j\u000b+{fd\u0018&S@m_%V`o\u001a'\u001b{f\u000e6Rzw\u0016-P)j\fcY|o\u0013";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "dlm\u001bcShw\u001ecQhj\u0013&S)._&E{l\ry";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "elw\r:\u0017}l_0Rgg_1Rxv\u001a0C)._";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "XgP\u001a-C]j\u0012&X|w_1Rxv\u001a0C`m\u0018c^z#\u00116[e";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "`hm\u000bcElw\r:\u0017}l_0Rgg_!B}#\u0011,C)o\u0010$Plg_*Y'#,&Y}#\u0012,Al#\u000b,\u0017[f\u000e6Rzw\u0016-PXv\u001a6R";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "Yfw_%X|m\u001bcDlm\u000bcElr\n&D}#\u0016-\u0017Zf\u00117f|f\n&\u001b)g\r,G)j\u000b";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "vjw\u0016,Y)._,YZf\u00117c`n\u001a,B}#Rc";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "vjw\u0016,Y)._1Rzw\u00101RZf\u00117f|f\n&\u0017$#\f&Y}R\n&BlP\u00169R3";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "\u001b~j\u0013/\u0017mj\f3V}`\u0017\u0017^df\u00106C[f\u000e6Rzw_7X)l\u000b+R{p";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "Dmh\u000b:Gl#\u00160\u0017gv\u0013/\u001b~j\u0013/\u0017mj\f3V}`\u0017\u0017^df\u00106C[f\u000e6Rzw_7X)l\u000b+R{p";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "vjw\u0016,Y)._,Y[f\u000e6Rzw+*Zll\n7\u0017$#";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "vjw\u0016,YDb\u0011\"Plq";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "Thm_-X}#\u0019,Bgg_\"T}j\u0010-\u0017~j\u000b+";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "XgQ\u001a2Blp\u000b\u0017^df\u00106C)q\u001a2Blp\u000b*Yn#\u00160\u0017gv\u0013/";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "vjw\u0016,Y)._1Rzf\u0011'elr\n&D}j\u0011$f|f\n&\u0017$#\f*Ml9";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "elp\u000f,Yzf_ Xgm\u001a C`l\u0011c^z#\u00106C$g\u001e7Rm-_";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "vjw\u0016,Y)._&YmP\u001a-C]j\u0012&X|w_n\u0017{f\u000e6Rzw4&N3";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "\u001b)q\u001a0Gfm\f&\r";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "_hm\u001b/R[f\f3Xgp\u001a\nY}f\r-Ve#\u0010!])#\u00160\u0017gv\u0013/";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "yfw_%X|m\u001bcElr\n&D}j\u0011$\u0017`m_\u0011Rxv\u001a0C`m\u0018\u0000Vjk\u001ac@af\u0011cElp\u000f,YzfQ";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "\u001bzg\u00147NyfE";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "vjw\u0016,Y)._+Vgg\u0013&elp\u000f,Yzf6-Clq\u0011\"[)._ Xgm\u001a C`l\u0011y";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "yfw_%X|m\u001bcCaf_1Rxv\u001a0C)j\u0011cdlm\u000b\u0012Blv\u001ac@af\u0011cElp\u000f,YzfQ";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = "_hm\u001b/R[f\f3Xgp\u001a\nY}f\r-Ve#\u0010!])#\u00160\u0017gl\u000bc}Af\u001e'";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "Rgg,&Y}W\u0016.Rfv\u000bcQhj\u0013&S%q\u001a2Blp\u000b*Yn#\u00160\u0017gv\u0013/";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0244:
        r9 = 55;
        goto L_0x0020;
    L_0x0248:
        r9 = 9;
        goto L_0x0020;
    L_0x024c:
        r9 = 3;
        goto L_0x0020;
    L_0x024f:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.b.h.<clinit>():void");
    }

    public static h a() {
        if (f == null) {
            f = new h();
        }
        return f;
    }

    private synchronized i a(String str) {
        i iVar;
        d.a(z[1], z[18]);
        iVar = null;
        for (i iVar2 : this.c) {
            i iVar22;
            if (str.equals(iVar22.a())) {
                this.c.remove(iVar22);
            } else {
                iVar22 = iVar;
            }
            iVar = iVar22;
        }
        return iVar;
    }

    private static String b(long j, String str) {
        return j + "|" + str;
    }

    private synchronized void c(i iVar) {
        d.a(z[1], z[12]);
        if (iVar == null) {
            d.g(z[1], z[11]);
        } else {
            Object obj;
            for (i a : this.c) {
                if (a.a().equals(iVar.a())) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                this.c.offerLast(iVar);
            }
        }
    }

    private void d(i iVar) {
        if (iVar == null) {
            d.g(z[1], z[2]);
            return;
        }
        d.a(z[1], new StringBuilder(z[0]).append(iVar.a()).toString());
        if (((i) this.a.remove(iVar.a())) == null) {
            d.g(z[1], z[3]);
        }
        this.b.remove(iVar);
        this.d.removeMessages(7403, iVar);
    }

    private void e(i iVar) {
        if (iVar == null) {
            d.c(z[1], z[25]);
            return;
        }
        try {
            int a = cn.jiguang.b.a.d.a();
            long e = cn.jiguang.b.a.d.e(null);
            byte[] bArr = iVar.d;
            d.c(z[24], new StringBuilder(z[22]).append(a).append(z[23]).append(e).toString());
            OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
            outputDataUtil.writeByteArray(bArr);
            outputDataUtil.writeU32At((long) a, 12);
            if (e != 0) {
                outputDataUtil.writeU64At(e, 16);
            }
            byte[] a2 = b.a(outputDataUtil.toByteArray(), 1);
            if (a2 == null || g.a.get() == 0) {
                d.h(z[1], z[21]);
                c(iVar);
                if (iVar != null) {
                    d.g(z[1], z[19]);
                }
                d.a(z[1], new StringBuilder(z[20]).append(iVar.a()).toString());
                this.d.sendMessageDelayed(Message.obtain(this.d, 7404, iVar), 9800);
                return;
            }
            Protocol.SendData(g.a.get(), a2, iVar.e);
            c(iVar);
            if (iVar != null) {
                d.a(z[1], new StringBuilder(z[20]).append(iVar.a()).toString());
                this.d.sendMessageDelayed(Message.obtain(this.d, 7404, iVar), 9800);
                return;
            }
            d.g(z[1], z[19]);
        } catch (Throwable th) {
            d.g(z[1], new StringBuilder(z[26]).append(th).toString());
        }
    }

    public final void a(long j, String str, Object obj) {
        if (obj == null) {
            d.g(z[1], z[43]);
        } else if (obj instanceof c) {
            c cVar = (c) obj;
            d.c(z[1], new StringBuilder(z[46]).append(j).append(z[42]).append(cVar.toString()).append(z[45]).append(str).toString());
            if (j != g.a.get()) {
                d.g(z[1], z[40]);
            }
            i a = a(b(cVar.b().longValue(), str));
            if (a == null) {
                d.g(z[1], z[47]);
                return;
            }
            if (a == null) {
                d.g(z[1], z[49]);
            } else {
                d.a(z[1], new StringBuilder(z[41]).append(a.a()).toString());
                this.d.removeMessages(7404, a);
            }
            a = (i) this.a.get(a.a());
            if (a != null) {
                d(a);
            } else {
                d.g(z[1], z[44]);
            }
        } else {
            d.g(z[1], z[48]);
        }
    }

    public final void a(Context context, Handler handler) {
        this.e = context;
        this.d = handler;
    }

    public final void a(i iVar) {
        if (iVar == null) {
            d.g(z[1], z[28]);
            return;
        }
        d.a(z[1], new StringBuilder(z[31]).append(iVar.toString()).toString());
        if (a(iVar.a()) == null) {
            d.g(z[1], z[30]);
        } else if (iVar.a > 0) {
            e.a();
            if (e.d()) {
                d.a(z[1], new StringBuilder(z[27]).append(iVar.toString()).toString());
                iVar.a -= 10000;
                iVar.b++;
                e(iVar);
            } else {
                d.a(z[1], z[29]);
                this.b.offerFirst(iVar);
            }
            if (iVar.b >= 2) {
                this.d.sendEmptyMessageDelayed(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist, 2000);
            }
        } else {
            b(iVar);
        }
    }

    public final void a(String str, Object obj) {
        Message obtain = Message.obtain(this.d, 7402, obj);
        Bundle bundle = new Bundle();
        bundle.putLong(z[13], g.a.get());
        bundle.putString(z[14], str);
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    public final void a(byte[] bArr, String str, int i) {
        if (bArr == null) {
            d.g(z[1], z[16]);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(z[15], i);
        bundle.putByteArray(z[17], bArr);
        bundle.putString(z[14], str);
        Message obtain = Message.obtain(this.d, 7401);
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    public final void b() {
        d.c(z[1], new StringBuilder(z[32]).append(this.c.size()).toString());
        this.d.removeMessages(7404);
        while (true) {
            i iVar = (i) this.c.pollLast();
            if (iVar != null) {
                this.b.offerFirst(iVar);
            } else {
                return;
            }
        }
    }

    public final void b(i iVar) {
        if (iVar == null) {
            d.g(z[1], z[38]);
            return;
        }
        d.a(z[1], new StringBuilder(z[35]).append(iVar.toString()).toString());
        d(iVar);
        cn.jiguang.b.d.b.a();
        Context context = this.e;
        Object obj = iVar.f;
        long j = iVar.c;
        int i = iVar.e;
        if (TextUtils.isEmpty(obj)) {
            d.c(z[36], z[34]);
            cn.jiguang.b.d.b.b(context, j, i);
            return;
        }
        JAction jAction = (JAction) cn.jiguang.b.d.b.a.get(obj);
        if (jAction == null) {
            d.c(z[36], new StringBuilder(z[37]).append(obj).append(z[33]).toString());
            cn.jiguang.b.d.b.b(context, j, i);
            return;
        }
        jAction.dispatchTimeOutMessage(context, g.a.get(), j, i);
    }

    public final void b(byte[] bArr, String str, int i) {
        d.d(z[1], new StringBuilder(z[9]).append(g.a.get()).append(z[7]).append(i).append(z[6]).append(str).append(z[5]).append(Thread.currentThread().getId()).toString());
        if (bArr == null) {
            d.g(z[1], z[10]);
        } else if (this.a.size() > 200) {
            d.h(z[1], z[4]);
        } else {
            i iVar = new i(bArr, str, i);
            this.a.put(iVar.a(), iVar);
            if (i > 10000) {
                d.a(z[1], z[8]);
                this.d.sendMessageDelayed(Message.obtain(this.d, 7403, iVar), (long) iVar.a);
            }
            e(iVar);
        }
    }

    public final void c() {
        d.a(z[1], new StringBuilder(z[39]).append(this.b.size()).toString());
        while (true) {
            i iVar = (i) this.b.pollFirst();
            if (iVar == null) {
                return;
            }
            if (iVar.e == 2) {
                this.b.remove(iVar);
                this.a.remove(iVar.a());
            } else {
                e(iVar);
            }
        }
    }
}
