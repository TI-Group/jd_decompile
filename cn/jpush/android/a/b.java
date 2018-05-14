package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JResponse;
import cn.jpush.a.c;
import cn.jpush.a.d;
import cn.jpush.android.a;
import cn.jpush.android.c.f;
import cn.jpush.android.c.g;
import cn.jpush.android.d.e;
import cn.jpush.android.service.ServiceInterface;
import java.nio.ByteBuffer;

/* compiled from: TbsSdkJava */
public class b implements JAction {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 57;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "NK|]n-IzJlkNv_qdH{\u001evhIq|wbFq]d~S5\u0004";
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
            case 0: goto L_0x0290;
            case 1: goto L_0x0294;
            case 2: goto L_0x0298;
            case 3: goto L_0x029c;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 5;
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
            case 12: goto L_0x00b2;
            case 13: goto L_0x00bd;
            case 14: goto L_0x00c8;
            case 15: goto L_0x00d3;
            case 16: goto L_0x00de;
            case 17: goto L_0x00e9;
            case 18: goto L_0x00f4;
            case 19: goto L_0x00ff;
            case 20: goto L_0x010a;
            case 21: goto L_0x0115;
            case 22: goto L_0x0120;
            case 23: goto L_0x012b;
            case 24: goto L_0x0136;
            case 25: goto L_0x0141;
            case 26: goto L_0x014c;
            case 27: goto L_0x0157;
            case 28: goto L_0x0162;
            case 29: goto L_0x016d;
            case 30: goto L_0x0178;
            case 31: goto L_0x0183;
            case 32: goto L_0x018e;
            case 33: goto L_0x0199;
            case 34: goto L_0x01a4;
            case 35: goto L_0x01af;
            case 36: goto L_0x01ba;
            case 37: goto L_0x01c5;
            case 38: goto L_0x01d0;
            case 39: goto L_0x01db;
            case 40: goto L_0x01e6;
            case 41: goto L_0x01f1;
            case 42: goto L_0x01fc;
            case 43: goto L_0x0207;
            case 44: goto L_0x0212;
            case 45: goto L_0x021d;
            case 46: goto L_0x0228;
            case 47: goto L_0x0233;
            case 48: goto L_0x023e;
            case 49: goto L_0x0249;
            case 50: goto L_0x0254;
            case 51: goto L_0x025f;
            case 52: goto L_0x026a;
            case 53: goto L_0x0275;
            case 54: goto L_0x0280;
            case 55: goto L_0x028b;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "eF{ZihjpMvl@p\u001epcL{Qrc\u0007z\\ohDa\u001e";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "XIpFuhDa[a7\u0007`PmlIqR`i\u0007xMb-\n5";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "LDaWjc\u00078\u001emlIqR`@BfMdjB5Kkh_v[uyBq\u0012%oR{Zih\u0007b_v-I`Ri";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "YUtPvkHgS%cHaWcdDtJlbI5]jcSpPq-Sz\u001eGlT|]@cS|J|-AtWihC4";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "]RfVVhUcWfhdzL`";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "}RfV%eFf\u001evyHe[a";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "#WpLhdTfWjc\t_nP^oJs@^tTy@";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "nI;TuxT}\u0010dcCgQli\t|PqhIa\u0010KBs\\xLNfAwJCxG{FHnC{ARwGq]T";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        r2 = 9;
        r1 = "#\u0007QQ%cHaVlc@;";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0086:
        r3[r2] = r1;
        r2 = 10;
        r1 = "`Trali";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0091:
        r3[r2] = r1;
        r2 = 11;
        r1 = "lIqLjdC;WkyB{J+lDaWjc\tEFFfR{ZLcQ{A";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009c:
        r3[r2] = r1;
        r2 = 12;
        r1 = "JHa\u001edc\u0007pSuy^5PjyNsWflS|Qk!\u0007qQk*S5MmbP5Wq,";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a7:
        r3[r2] = r1;
        r2 = 13;
        r1 = "NH{P`nS|Qk-Ta_qh\u0007vVdc@pZ%yH5\u0013%";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b2:
        r3[r2] = r1;
        r2 = 14;
        r1 = "nI;TuxT}\u0010dcCgQli\t|PqhIa\u0010uaRrWk#Wy_qkHgS+_bSl@^t]aWH`\\z";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00bd:
        r3[r2] = r1;
        r2 = 15;
        r1 = "LDaWjc\u00078\u001emlIqR`@BfMdjB5\u0012%gW`Mm-N{Wq-AtWihC";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c8:
        r3[r2] = r1;
        r2 = 16;
        r1 = "cHVQkcBvJl{NaG";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d3:
        r3[r2] = r1;
        r2 = 17;
        r1 = "zOtJ";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00de:
        r3[r2] = r1;
        r2 = 18;
        r1 = "nI;TuxT}\u0010dcCgQli\t|PqhIa\u0010KBs\\xLNfAwJCxZn@CbQaU_hMg";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00e9:
        r3[r2] = r1;
        r2 = 19;
        r1 = "@jF\u001ej\u0007FkUA\u0007{[qzHgU%~StJ`-D}_kjB9\u001eqb\u0007qQ%cHaVlc@4";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f4:
        r3[r2] = r1;
        r2 = 20;
        r1 = "CBaIjL5Wv-C|MfbI{[fyBq\u0010";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x00ff:
        r3[r2] = r1;
        r2 = 21;
        r1 = "Gw`MmIFa_DnS|Qk";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010a:
        r3[r2] = r1;
        r2 = 22;
        r1 = "cHaWcdDtWjcxaGuh";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0115:
        r3[r2] = r1;
        r2 = 23;
        r1 = "~B{Z`nq";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0120:
        r3[r2] = r1;
        r2 = 24;
        r1 = "]RfVWhDpWshUVQwh";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012b:
        r3[r2] = r1;
        r2 = 25;
        r1 = "lIqLjdC;P`y\tvQkc\tVqKCbVjL[nAgZNoTpBH";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0136:
        r3[r2] = r1;
        r2 = 26;
        r1 = "nI;TuxT}\u0010dcCgQli\t|PqhIa\u0010KBs\\xLNfAwJCxVrLNlJFYnZp";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0141:
        r3[r2] = r1;
        r2 = 27;
        r1 = "CHa\u001ecbR{Z%cBaIjL\\Pcb";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014c:
        r3[r2] = r1;
        r2 = 28;
        r1 = "nI;TuxT}\u0010dcCgQli\t[qQDa\\FLs\\qKRfVjLBiJ{]YuT";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0157:
        r3[r2] = r1;
        r2 = 29;
        r1 = "`BfMdjB";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0162:
        r3[r2] = r1;
        r2 = 30;
        r1 = "CBaIjL5Wv-DzPkhDa[a#";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016d:
        r3[r2] = r1;
        r2 = 31;
        r1 = "LdAwJCx[qQDa\\}DYnZpZ_bV{L[bQaU_hMg%-\u0007{QqdA|]dyNzPZy^e[%0\u0007";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0178:
        r3[r2] = r1;
        r2 = 32;
        r1 = "cBaIjL\\Pcb";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0183:
        r3[r2] = r1;
        r2 = 33;
        r1 = "eF{ZihjpMvl@p\u0004";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018e:
        r3[r2] = r1;
        r2 = 34;
        r1 = "bS}[w-IpJrbU~\u001evyFa[% \u0007";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x0199:
        r3[r2] = r1;
        r2 = 35;
        r1 = "CH5_kt\u0007{[qzHgU%dT5]jcIp]qhC";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a4:
        r3[r2] = r1;
        r2 = 36;
        r1 = "_Bv[l{Bq\u001ekb\u0007t]qdH{\u001elcSpPq-EgQdiDtMq#\u0007RWsh\u0007`N%}Uz]`~T|Pb#";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01af:
        r3[r2] = r1;
        r2 = 37;
        r1 = "nI;TuxT}\u0010dcCgQli\t|PqhIa\u0010KBs\\xLNfAwJCxVrLNlJFYnZpZ]uZf\\";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01ba:
        r3[r2] = r1;
        r2 = 38;
        r1 = "NK|]n-IzJlkNv_qdH{\u001ednS|Qk-P|Jm-BmJwl\u001d5";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c5:
        r3[r2] = r1;
        r2 = 39;
        r1 = "_Bv[l{Bq\u001ekxKy\u001elcSpPq-EgQdiDtMq#\u0007RWsh\u0007`N%}Uz]`~T|Pb#";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d0:
        r3[r2] = r1;
        r2 = 40;
        r1 = "bIG[fhNc[% \u0007";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01db:
        r3[r2] = r1;
        r2 = 41;
        r1 = "lWewa";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e6:
        r3[r2] = r1;
        r2 = 42;
        r1 = "LDaWjc\u00078\u001ejcbc[ky\u00079\u001eo}RfV%dI|J%kF|R`i";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f1:
        r3[r2] = r1;
        r2 = 43;
        r1 = "xI}_kiKp\u001efbJx_ki";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fc:
        r3[r2] = r1;
        r2 = 44;
        r1 = "iNfNdyD}jl`BZKq@BfMdjB";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0207:
        r3[r2] = r1;
        r2 = 45;
        r1 = "LDaWjc\u00078\u001eadTe_qnOAWhhh`JHhTf_bh\u00079\u001eo}RfV%dI|J%kF|R`i";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0212:
        r3[r2] = r1;
        r2 = 46;
        r1 = "BfNjcTp\u0004";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021d:
        r3[r2] = r1;
        r2 = 47;
        r1 = "LDaWjc\u00078\u001ejcbc[ky\u00079\u001eO]RfV%dI|J%kF|R`i";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0228:
        r3[r2] = r1;
        r2 = 48;
        r1 = "NH{J`cSC_ixBf";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0233:
        r3[r2] = r1;
        r2 = 49;
        r1 = "LDaWjc\u00078\u001eadTe_qnOX[v~Fr[";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023e:
        r3[r2] = r1;
        r2 = 50;
        r1 = "XI~PjzI5]j`JtPa-AzL%}FgMlc@5WkoH`Pa#";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x0249:
        r3[r2] = r1;
        r2 = 51;
        r1 = "^OzKii\u0007{Qq-BmWvy\u00078\u001eljIzL`-StY%lK|_v-UpMubIf[+";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0254:
        r3[r2] = r1;
        r2 = 52;
        r1 = "XI}_kiKpZ%BfNjcTp\u001efbJx_ki\u00078\u001e";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x025f:
        r3[r2] = r1;
        r2 = 53;
        r1 = "Gw`Mm-PtM%~SzN`i";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026a:
        r3[r2] = r1;
        r2 = 54;
        r1 = ">\t%\u0010=";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0275:
        r3[r2] = r1;
        r2 = 55;
        r1 = "LDaWjc\u00078\u001ejcfvJlbIGKk-\u000b5tUxT}\u001elcNa\u001eclNy[a";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0280:
        r3[r2] = r1;
        r2 = 56;
        r1 = "LDaWjc\u00078\u001ejcfvJlbIGKk";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028b:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0290:
        r9 = 13;
        goto L_0x001f;
    L_0x0294:
        r9 = 39;
        goto L_0x001f;
    L_0x0298:
        r9 = 21;
        goto L_0x001f;
    L_0x029c:
        r9 = 62;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.b.<clinit>():void");
    }

    public long dispatchMessage(Context context, long j, int i, Object obj, ByteBuffer byteBuffer) {
        e.c(z[21], z[49]);
        if (a.a(context)) {
            JResponse aVar;
            switch (i) {
                case 3:
                    aVar = new cn.jpush.a.a(obj, byteBuffer);
                    break;
                case 10:
                case 28:
                case 29:
                    aVar = new c(obj, byteBuffer);
                    break;
                case 27:
                    aVar = new d(obj, byteBuffer);
                    break;
                default:
                    e.g(z[48], z[50]);
                    aVar = null;
                    break;
            }
            if (ServiceInterface.c(context)) {
                e.c(z[21], z[53]);
                if (!(aVar == null || !(aVar instanceof cn.jpush.a.a) || ((cn.jpush.a.a) aVar).a() == 20)) {
                    return -1;
                }
            }
            if (aVar != null) {
                e.d(z[21], new StringBuilder(z[46]).append(aVar.toString()).toString());
                switch (aVar.getCommand()) {
                    case 3:
                        return g.a(a.e, j, aVar);
                    case 10:
                        e.g(z[21], z[51]);
                        break;
                    case 27:
                        if (aVar.code != 0) {
                            f.a().a(context, aVar.getRid().longValue(), aVar.code);
                            break;
                        }
                        f.a().a(context, aVar.getRid().longValue());
                        break;
                    case 28:
                    case 29:
                        return j.a(context, ((c) aVar).a(), aVar.getCommand() == 28 ? 1 : 2, aVar.getRid().longValue());
                    default:
                        e.g(z[21], new StringBuilder(z[52]).append(aVar.getCommand()).toString());
                        break;
                }
            }
            return aVar.getRid().longValue();
        }
        e.g(z[21], z[47]);
        return -1;
    }

    public void dispatchTimeOutMessage(Context context, long j, long j2, int i) {
        e.c(z[21], z[44]);
        if (a.a(context)) {
            switch (i) {
                case 10:
                case 28:
                case 29:
                    e.a(context).a(j2);
                    return;
                case 27:
                    f.a().b(context, j2);
                    return;
                default:
                    e.c(z[21], z[43]);
                    return;
            }
        }
        e.g(z[21], z[45]);
    }

    public IBinder getBinderByType(String str) {
        return null;
    }

    public String getSdkVersion() {
        return z[54];
    }

    public void handleMessage(Context context, long j, Object obj) {
        if (!a.a(context)) {
            e.g(z[21], z[15]);
        } else if (obj == null) {
        } else {
            if (obj instanceof Bundle) {
                cn.jpush.android.service.c.a(context);
                Bundle bundle = (Bundle) obj;
                if (bundle == null) {
                    e.a(z[5], z[3]);
                    return;
                }
                e.a(z[5], new StringBuilder(z[33]).append(bundle.toString()).toString());
                bundle.getInt(z[17]);
                e.a(z[5], new StringBuilder(z[2]).append(bundle.toString()).toString());
            } else if (obj instanceof Intent) {
                cn.jpush.android.service.b.a();
                Intent intent = (Intent) obj;
                if (intent == null) {
                    e.h(z[24], z[39]);
                    return;
                }
                try {
                    String action = intent.getAction();
                    e.d(z[24], new StringBuilder(z[40]).append(action).toString());
                    if (a.a(context.getApplicationContext()) && action != null) {
                        if (z[14].equals(action)) {
                            g.a().e(context);
                        } else if (action.startsWith(z[8])) {
                            try {
                                if (ServiceInterface.d(context)) {
                                    e.g(z[24], z[6]);
                                    return;
                                }
                                e.c(z[24], new StringBuilder(z[31]).append(intent.getIntExtra(z[22], 0)).toString());
                                Object stringExtra = intent.getStringExtra(z[29]);
                                if (TextUtils.isEmpty(stringExtra)) {
                                    e.h(z[24], z[12]);
                                    return;
                                }
                                cn.jpush.android.data.a a = f.a(context, stringExtra, intent.getStringExtra(z[41]), intent.getStringExtra(z[23]), intent.getStringExtra(z[10]));
                                if (a == null) {
                                    e.g(z[24], z[4]);
                                    return;
                                }
                                a.h = true;
                                f.a(context, a);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (!action.equals(z[11])) {
                            if (action.equalsIgnoreCase(z[25])) {
                                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra(z[32]);
                                if (networkInfo == null) {
                                    e.g(z[24], z[27]);
                                    return;
                                }
                                e.c(z[24], new StringBuilder(z[13]).append(networkInfo.toString()).toString());
                                if (2 == networkInfo.getType() || 3 == networkInfo.getType()) {
                                    e.c(z[24], z[19]);
                                } else if (intent.getBooleanExtra(z[16], false)) {
                                    e.c(z[24], z[35]);
                                } else if (State.CONNECTED == networkInfo.getState()) {
                                    e.c(z[24], z[30]);
                                } else if (State.DISCONNECTED == networkInfo.getState()) {
                                    e.c(z[24], z[20]);
                                } else {
                                    e.c(z[24], new StringBuilder(z[34]).append(networkInfo.getState()).append(z[9]).toString());
                                }
                            } else if (action.startsWith(z[18])) {
                                cn.jpush.android.service.b.a(context, intent);
                            } else if (action.startsWith(z[37])) {
                                e.e(z[24], new StringBuilder(z[38]).append(intent.getExtras().getString(z[28])).toString());
                                try {
                                    Intent intent2 = new Intent(z[26]);
                                    intent2.putExtras(intent.getExtras());
                                    intent2.addCategory(context.getPackageName());
                                    context.sendBroadcast(intent2, context.getPackageName() + z[7]);
                                } catch (Throwable th) {
                                    e.h(z[24], new StringBuilder(z[0]).append(th.getMessage()).toString());
                                }
                            }
                        }
                    }
                } catch (NullPointerException e2) {
                    e.h(z[24], z[36]);
                }
            } else {
                e.d(z[21], z[1]);
            }
        }
    }

    public boolean isSupportedCMD(int i) {
        return i == 3 || i == 10 || i == 27 || i == 28 || i == 29;
    }

    public void onActionRun(Context context, long j, Bundle bundle, Object obj) {
        e.d(z[21], z[56]);
        if (a.a(context)) {
            cn.jpush.android.service.c.a(context).a(bundle, (Handler) obj);
        } else {
            e.g(z[21], z[55]);
        }
    }

    public void onEvent(Context context, long j, int i) {
        if (a.a(context)) {
            switch (i) {
                case 0:
                    return;
                case 1:
                    g.a().a(context);
                    g.a().d(context.getApplicationContext());
                    return;
                case 19:
                    cn.jpush.android.service.c.a(context).a();
                    return;
                default:
                    return;
            }
        }
        e.g(z[21], z[42]);
    }
}
