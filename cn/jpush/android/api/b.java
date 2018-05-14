package cn.jpush.android.api;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a;
import cn.jpush.android.a.d;
import cn.jpush.android.a.h;
import cn.jpush.android.d.c;
import cn.jpush.android.d.e;
import cn.jpush.android.data.g;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.ui.PopWinActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.Adler32;

/* compiled from: TbsSdkJava */
public final class b {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 62;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "~1\"aT\\p?b\u0011_5?-C]#kdU\u00186$\u0011V1&h\u001f";
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
            case 0: goto L_0x02c8;
            case 1: goto L_0x02cc;
            case 2: goto L_0x02d0;
            case 3: goto L_0x02d4;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 49;
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
            case 49: goto L_0x024a;
            case 50: goto L_0x0255;
            case 51: goto L_0x0260;
            case 52: goto L_0x026b;
            case 53: goto L_0x0276;
            case 54: goto L_0x0281;
            case 55: goto L_0x028c;
            case 56: goto L_0x0297;
            case 57: goto L_0x02a2;
            case 58: goto L_0x02ad;
            case 59: goto L_0x02b8;
            case 60: goto L_0x02c3;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "v??dWQ3*yXW>\u0003h]H59";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "H19l\\]$.\u0011J58YHH5kbC\u00186\"h]\\\u001e*`TKp.CW\"e";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0016\u0002";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "Y3?d^Vj,hEv?-dEQ3*yXW>\u0002I\u0011\u0015p.`AL)k`TK#*jTq4";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "l88-\\K7\u0002i\u0011Q#kc^Lp*-XV$.jTJ";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "Q#\u0005bEQ6\"nPL9$c";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "[>egAM###PV49bX\\~\"cE]>?#w\u0004\u0002Kx{\u0011\u001fD~v\u000f\u0004]tv\u0015\u000fRaj\u001f\u0013T\u001f";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "J%%cXV7kk]Y7q";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "V??dWQ3*yXW>";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "??-m\u001c\u0007-_W$\"kX[1?d^V~kJXN5kxA\u0018$$-BP?<#";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "[>egAM###PV49bX\\~\u0005Beq\u0016\u0002Npl\u0019\u0004Cn|\u0015\u001dH}w\u0000\u000e_ny\u0002\f=";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "M>#l_\\<.-TV$\"yH\u00185%yXL)";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "[>egAM###PV49bX\\~\"cE]>?#w\u0004\u0002Kx{\u0011\u001fD~v\u000f\u0004]tv\u0015\u000f";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "K4 yHH5";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "L8.-aM##_T[5\"{TJp\"c\u0011U1%dW]#?-XKp/h]]$.i\u0011Z)k~^U5kbEP59-PH 8!F]p8e^M</-B]>/-EP5koCW1/nPK$kiXJ5(y]A~";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "Y ;";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "Y3?d^Vj8e^O\u001e$yX^9(lEQ?%";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\\5'dG]\"2-CQ3#-AM##-EA .7\u0011";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "Q>?h_Lp<lB\u0018>>a]\u0018|kiCW kX[8kc^L9-dRY$\"b_";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "[>egAM###PV49bX\\~\u0005Beq\u0016\u0002Npl\u0019\u0004Cnl\t\u001bH";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "[>egAM###PV49bX\\~\u0003Y|t\u000f\u0019Hb";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0016 .\\Q#8d^V~\u0001]dk\u0018\u0014@tk\u0003\nJt";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "^9'h\u000b\u0017";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "K5%iW$\"kX[1?d^V\u0002.nTQ&.isJ?*iRY#?-TJ\"$\u000b";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "[>egAM###PV49bX\\~\u0003Y|t\u000f\u001bLep";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "[>egAM###PV49bX\\~\"cE]>?#w\u0004\u0002Kx{\u0011\u001fD~v\u000f\u0019Hr}\u0019\u001dHu";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "k5%i\u0011H%8e\u0011J5(hXN5/-SJ?*iRY#?-EWp/hG]<$}TJp/hWQ>.i\u0011J5(hXN59";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "P$?}\u000b\u0017";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "Z?/t";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "[?%yT@$kzPKp%x]T";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "]>?dEAj";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "K$*E\u0018>.z\u0011L89hP\\";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "U%'yXg$2}T";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "[>egAM###PV49bX\\~\"cE]>?#|m\u001c\u001fDnh\u0002\u0004Ntk\u0003";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "Y3?d^V";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "{1%-_W$ka^Y4kTK?>R]jkgAM##R_W$\"kX[1?d^V\u000f\"n^V";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "R >~Yg>$yX^9(lEQ?%RX[?%";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "jt/PO1)aT";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "253yCY\u001a8b_\u0002";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "[>egAM###PV49bX\\~\u0005Beq\u000f\bLe}\u0017\u0004_h";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "2>$yX^9(lEQ?%]CQ?9dEAj";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "[>egAM###PV49bX\\~\u0005Beq\u000f\u001b_xw\u0002\u0002Yh";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "[>egAM###PV49bX\\~\u000eUej\u0011";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "[>egAM###PV49bX\\~\u0006^vg\u0019\u000f";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "[>egAM###PV49bX\\~\tDvg\u0004\u000eUe";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "[>egAM###PV49bX\\~\u0005Beq\u0016\u0002Npl\u0019\u0004Cn{\u001f\u0005Ytv\u0004\u0014Yxl\u001c\u000e";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "2>$yX^9(lEQ?%^EA<.7";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = "2>$yX^9(lEQ?%YXL<.";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "2>$yX^9(lEQ?%L]]\"?YHH5q";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        r2 = 50;
        r1 = "2>$yX^9(lEQ?%OX_\u0004.uE\u0002";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x024a:
        r3[r2] = r1;
        r2 = 51;
        r1 = "2>$yX^9(lEQ?%D_Z?37";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0255:
        r3[r2] = r1;
        r2 = 52;
        r1 = "[>egAM###PV49bX\\~\nAtj\u0004";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x0260:
        r3[r2] = r1;
        r2 = 53;
        r1 = "2>$yX^9(lEQ?%NPL5,bCAj";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026b:
        r3[r2] = r1;
        r2 = 54;
        r1 = "[>egAM###PV49bX\\~\u0002Csw\b";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0276:
        r3[r2] = r1;
        r2 = 55;
        r1 = "[>egAM###PV49bX\\~\tDvg\u0000\u0002Nnh\u0011\u001fE";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0281:
        r3[r2] = r1;
        r2 = 56;
        r1 = "2>$yX^9(lEQ?%OX_\u0000\"naY$#7";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028c:
        r3[r2] = r1;
        r2 = 57;
        r1 = "V??dWQ3*yXW>\bb_L5%y\u000b";
        r0 = 56;
        r3 = r4;
        goto L_0x0009;
    L_0x0297:
        r3[r2] = r1;
        r2 = 58;
        r1 = "[>egAM###PV49bX\\~\nAtj\u0004\u0014Yhh\u0015";
        r0 = 57;
        r3 = r4;
        goto L_0x0009;
    L_0x02a2:
        r3[r2] = r1;
        r2 = 59;
        r1 = "Y3?d^Vj(aTY>\u0005bEQ6\"nPL9$c\u0011\u0015p&hBK1,hx\\j";
        r0 = 58;
        r3 = r4;
        goto L_0x0009;
    L_0x02ad:
        r3[r2] = r1;
        r2 = 60;
        r1 = "Y3?d^Vj(aTY>\u0005bEQ6\"nPL9$c\u0011\u0015p%bEQ6\"nPL9$cx\\j";
        r0 = 59;
        r3 = r4;
        goto L_0x0009;
    L_0x02b8:
        r3[r2] = r1;
        r2 = 61;
        r1 = "[>egAM###PV49bX\\~\u0005Beq\u0016\u0002Npl\u0019\u0004Cnq\u0014";
        r0 = 60;
        r3 = r4;
        goto L_0x0009;
    L_0x02c3:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x02c8:
        r9 = 56;
        goto L_0x0020;
    L_0x02cc:
        r9 = 80;
        goto L_0x0020;
    L_0x02d0:
        r9 = 75;
        goto L_0x0020;
    L_0x02d4:
        r9 = 13;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.b.<clinit>():void");
    }

    public static int a(int i) {
        switch (i) {
            case -1:
                int intValue;
                try {
                    intValue = ((Integer) a(z[38], new String[]{z[37]}).get(z[37])).intValue();
                } catch (Exception e) {
                    e.i(z[1], z[36]);
                    intValue = 0;
                }
                return intValue <= 0 ? 17301618 : intValue;
            case 0:
                return 17301647;
            case 2:
                return 17301618;
            case 3:
                return 17301567;
            default:
                return 17301586;
        }
    }

    private static int a(cn.jpush.android.data.b bVar, int i) {
        String str = bVar.c;
        if (!TextUtils.isEmpty(bVar.d)) {
            str = bVar.d;
        }
        return a(str, i);
    }

    private static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            e.c(z[1], z[4]);
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception e) {
            e.g(z[1], z[5]);
            Adler32 adler32 = new Adler32();
            adler32.update(str.getBytes());
            int value = (int) adler32.getValue();
            if (value < 0) {
                value = Math.abs(value);
            }
            value += 13889152 * i;
            return value < 0 ? Math.abs(value) : value;
        }
    }

    private static HashMap<String, Integer> a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException(z[2]);
        }
        HashMap<String, Integer> hashMap = new HashMap();
        try {
            int i;
            for (Class cls : Class.forName(a.e.getPackageName() + z[3]).getDeclaredClasses()) {
                if (cls.getName().contains(str)) {
                    for (i = 0; i <= 0; i++) {
                        String str2 = strArr[0];
                        hashMap.put(str2, Integer.valueOf(cls.getDeclaredField(str2).getInt(str2)));
                    }
                    return hashMap;
                }
            }
        } catch (Throwable e) {
            e.b(z[1], z[0], e);
        }
        return hashMap;
    }

    public static Map<String, String> a(cn.jpush.android.data.b bVar) {
        Map<String, String> hashMap = new HashMap();
        if (bVar != null) {
            e.a(z[1], new StringBuilder(z[57]).append(bVar.u).append(z[48]).append(bVar.t).append(z[47]).append(bVar.v).append(z[41]).append(bVar.z).append(z[50]).append(bVar.w).append(z[56]).append(bVar.x).append(z[51]).append(bVar.y).append(z[53]).append(bVar.A).append(z[49]).append(bVar.k).append(z[39]).append(bVar.m).toString());
            hashMap.put(z[44], bVar.c);
            hashMap.put(z[52], bVar.u);
            hashMap.put(z[58], bVar.k);
            if (!TextUtils.isEmpty(bVar.t)) {
                hashMap.put(z[46], bVar.t);
            }
            if (!TextUtils.isEmpty(bVar.m)) {
                hashMap.put(z[43], bVar.m);
            }
            if (bVar.v == 1 && !TextUtils.isEmpty(bVar.w)) {
                hashMap.put(z[45], bVar.w);
            } else if (bVar.v == 2 && !TextUtils.isEmpty(bVar.y)) {
                hashMap.put(z[54], bVar.y);
            } else if (bVar.v == 3 && !TextUtils.isEmpty(bVar.x)) {
                hashMap.put(z[55], bVar.x);
            }
            if (bVar.z != 0) {
                hashMap.put(z[42], bVar.z);
            }
            if (!TextUtils.isEmpty(bVar.A)) {
                hashMap.put(z[40], bVar.A);
            }
        }
        return hashMap;
    }

    public static void a(Context context, int i) {
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                Integer valueOf = Integer.valueOf(h.a());
                if (valueOf.intValue() != 0) {
                    b(context, valueOf.intValue());
                }
            }
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (!h.b(i)) {
            h.a(i);
        }
        if (h.b() > cn.jpush.android.b.a(context)) {
            int a = h.a();
            if (a != 0) {
                b(context, a);
            }
        }
    }

    public static void a(final Context context, final cn.jpush.android.data.b bVar) {
        e.e(z[1], z[32]);
        new Thread(new Runnable() {
            public final void run() {
                b.b(context, bVar);
            }
        }).start();
    }

    public static void a(Context context, cn.jpush.android.data.b bVar, int i) {
        e.c(z[1], new StringBuilder(z[59]).append(bVar.c).toString());
        if (context == null) {
            context = a.e;
        }
        ((NotificationManager) context.getSystemService(z[9])).cancel(a(bVar, 0));
    }

    public static void a(Context context, Map<String, String> map, int i, String str, String str2, cn.jpush.android.data.b bVar) {
        Intent intent = new Intent(z[26]);
        try {
            e.d(z[1], z[27]);
            a(intent, (Map) map, i);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(z[11], str);
            }
            if (bVar.a() && (bVar instanceof g)) {
                g gVar = (g) bVar;
                if (!(gVar.K == 0 || gVar.K == 4)) {
                    if (gVar.P != null && gVar.P.startsWith(z[23])) {
                        gVar.P = gVar.P.replaceFirst(z[23], "");
                        intent.putExtra(z[25], gVar.P);
                    }
                    if (gVar.M != null && gVar.M.size() > 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String b = c.b(context, bVar.c);
                        Iterator it = gVar.M.iterator();
                        while (it.hasNext()) {
                            String str3 = (String) it.next();
                            if (str3.startsWith(z[28])) {
                                str3 = c.a(str3);
                            }
                            if (TextUtils.isEmpty(stringBuilder.toString())) {
                                stringBuilder.append(b).append(str3);
                            } else {
                                stringBuilder.append(",").append(b).append(str3);
                            }
                        }
                        intent.putExtra(z[21], stringBuilder.toString());
                    }
                }
            }
            intent.addCategory(str2);
            context.sendBroadcast(intent, str2 + z[22]);
        } catch (Throwable th) {
            e.h(z[1], new StringBuilder(z[24]).append(th.getMessage()).toString());
            cn.jpush.android.d.a.b(context, intent, str2 + z[22]);
        }
    }

    public static void a(Context context, boolean z) {
        if (z) {
            while (true) {
                Integer valueOf = Integer.valueOf(h.a());
                if (valueOf.intValue() != 0) {
                    b(context, valueOf.intValue());
                } else {
                    return;
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(z[35], z[34]);
        bundle.putInt(z[33], 10);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static void a(Intent intent, Map<String, String> map, int i) {
        for (String str : map.keySet()) {
            intent.putExtra(str, (String) map.get(str));
        }
        if (i != 0) {
            intent.putExtra(z[61], i);
        }
    }

    private static void b(Context context, int i) {
        e.c(z[1], new StringBuilder(z[60]).append(i).toString());
        if (context == null) {
            context = a.e;
        }
        ((NotificationManager) context.getSystemService(z[9])).cancel(i);
    }

    public static void b(Context context, cn.jpush.android.data.b bVar) {
        e.a(z[1], z[17]);
        int a = a(bVar, 0);
        if (bVar.h && bVar.e) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(z[9]);
            if (bVar instanceof g) {
                Map a2 = a(bVar);
                String packageName = TextUtils.isEmpty(bVar.n) ? context.getPackageName() : bVar.n;
                if (TextUtils.isEmpty(bVar.u)) {
                    a(context, a2, 0, "", packageName, bVar);
                    return;
                }
                PushNotificationBuilder b = JPushInterface.b(bVar.f);
                String developerArg0 = b.getDeveloperArg0();
                Notification buildNotification = b.buildNotification(a2);
                if (buildNotification == null || TextUtils.isEmpty(bVar.u)) {
                    e.h(z[1], z[10]);
                    return;
                }
                PendingIntent activity;
                Intent c;
                if (bVar.a()) {
                    e.e(z[1], new StringBuilder(z[18]).append(((g) bVar).K).toString());
                    c = c(context, bVar);
                    if (c == null) {
                        e.i(z[1], z[19]);
                        return;
                    }
                    activity = PendingIntent.getActivity(context, a, c, 134217728);
                } else {
                    e.d(z[1], new StringBuilder(z[8]).append(JCoreInterface.getRuningFlag()).toString());
                    if (cn.jpush.android.d.a.c(context, PushReceiver.class.getCanonicalName())) {
                        c = new Intent(new StringBuilder(z[7]).append(UUID.randomUUID().toString()).toString());
                        c.putExtra(z[20], bVar.g);
                        if (JCoreInterface.getRuningFlag()) {
                            c.setClass(context, PopWinActivity.class);
                            c.putExtra(z[6], true);
                        } else {
                            c.setClass(context, PushReceiver.class);
                        }
                    } else {
                        e.e(z[1], z[15]);
                        Intent intent = new Intent(z[13]);
                        intent.addCategory(packageName);
                        if ((VERSION.SDK_INT >= 25 || VERSION.SDK_INT < 21) && z[13].equals(intent.getAction())) {
                            List a3 = cn.jpush.android.d.a.a(context, intent, null);
                            if (!a3.isEmpty()) {
                                intent.setComponent(new ComponentName(context, (String) a3.get(0)));
                            }
                        }
                        c = intent;
                    }
                    c.putExtra(z[14], a.a);
                    a(c, a2, a);
                    c.putExtra(z[16], packageName);
                    if (!TextUtils.isEmpty(developerArg0)) {
                        c.putExtra(z[11], developerArg0);
                    }
                    activity = JCoreInterface.getRuningFlag() ? PendingIntent.getActivity(context, 0, c, 1073741824) : PendingIntent.getBroadcast(context, 0, c, 1073741824);
                }
                buildNotification.contentIntent = activity;
                if (!JPushInterface.a(bVar.f)) {
                    if (1 == bVar.g) {
                        bVar.s = 1;
                    }
                    int i = 1;
                    switch (bVar.s) {
                        case 0:
                            i = 1;
                            break;
                        case 1:
                            i = 16;
                            break;
                        case 2:
                            i = 32;
                            break;
                    }
                    buildNotification.flags = i | 1;
                }
                if (cn.jpush.android.d.a.d(context)) {
                    buildNotification.defaults = 0;
                }
                if (buildNotification != null) {
                    notificationManager.notify(a, buildNotification);
                }
                if (1 != bVar.g) {
                    a(context, a, true);
                    d.a(bVar.c, PointerIconCompat.TYPE_ZOOM_IN, null, context);
                }
                a(context, a2, a, developerArg0, packageName, bVar);
                return;
            }
            e.g(z[1], z[12]);
        }
    }

    public static Intent c(Context context, cn.jpush.android.data.b bVar) {
        if (context == null) {
            e.h(z[1], z[30]);
            return null;
        }
        e.a(z[1], new StringBuilder(z[31]).append(bVar).toString());
        if (bVar != null) {
            if (3 == ((g) bVar).K || 4 == ((g) bVar).K || ((g) bVar).K == 0) {
                return cn.jpush.android.d.a.a(context, bVar, false);
            }
            if (2 == ((g) bVar).K) {
                Intent intent = new Intent(context, PopWinActivity.class);
                intent.putExtra(z[29], bVar);
                intent.addFlags(335544320);
                return intent;
            }
        }
        return cn.jpush.android.d.a.a(context, bVar, false);
    }
}
