package cn.jpush.android.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a.d;
import cn.jpush.android.data.b;
import cn.jpush.android.service.DaemonService;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public final class a {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 82;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "^OD\u0015ivEu\u0013os";
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
            case 0: goto L_0x03a3;
            case 1: goto L_0x03a7;
            case 2: goto L_0x03ab;
            case 3: goto L_0x03af;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 6;
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
            case 56: goto L_0x0296;
            case 57: goto L_0x02a1;
            case 58: goto L_0x02ac;
            case 59: goto L_0x02b7;
            case 60: goto L_0x02c2;
            case 61: goto L_0x02cd;
            case 62: goto L_0x02d8;
            case 63: goto L_0x02e3;
            case 64: goto L_0x02ee;
            case 65: goto L_0x02f9;
            case 66: goto L_0x0304;
            case 67: goto L_0x030f;
            case 68: goto L_0x031a;
            case 69: goto L_0x0325;
            case 70: goto L_0x0330;
            case 71: goto L_0x033b;
            case 72: goto L_0x0346;
            case 73: goto L_0x0351;
            case 74: goto L_0x035c;
            case 75: goto L_0x0367;
            case 76: goto L_0x0372;
            case 77: goto L_0x037d;
            case 78: goto L_0x0388;
            case 79: goto L_0x0393;
            case 80: goto L_0x039e;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\\@N@r?FE\u0013&s@U\tew\u0001I\trzOTG`pS\u0000\u0013nvR\u0000\u0017g|JA\u0000c>";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "KIEGv~BK\u0006az\u0001W\u000erw\u0001T\u000fc?FI\u0011cq\u0001N\u0006kz\u0001C\u0006hqNTGdz\u0001F\bsqE\u0001";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "lUA\u0015rR@I\tG|UI\u0011okX\u0000\u0002tmNR]";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "w@S4cmWI\u0004cVOT\u0002hkgI\u000brzS\u0000\u0002tmNR]";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "}ND\u001e";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "vRu\u0017b~UE1cmRI\bh";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000fU\u000e(OTS\u000fG|UI\u0011okX";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "C";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        r2 = 9;
        r1 = "qNT\u000e`vBA\u0013opO\u0002h~CL\u0002b";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0086:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\\TR\u0015cqU\u0000\u0013orD\u0000\u000eu?NU\u0013&pG\u0000\u0013nz\u0001P\u0012uw\u0001T\u000ekz\u0001\rG";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0091:
        r3[r2] = r1;
        r2 = 11;
        r1 = "oTS\u000f&kHM\u0002&vR\u0000ｽ";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009c:
        r3[r2] = r1;
        r2 = 12;
        r1 = "qN\u0000\u0013orD\u0000\u000borHT\u0002b";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a7:
        r3[r2] = r1;
        r2 = 13;
        r1 = "QNT\u000e`vBA\u0013opO\u0000\u0010gl\u0001D\u000eu~CL\u0002b?CYGLOTS\u000fOqUE\u0015`~BEIuzUp\u0012uwuI\nc?\u0000";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b2:
        r3[r2] = r1;
        r2 = 14;
        r1 = "JufJ>";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00bd:
        r3[r2] = r1;
        r2 = 15;
        r1 = "w@S&ekHV\u000erfsE\u0014isWE\u0014&zSR\bt%";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c8:
        r3[r2] = r1;
        r2 = 16;
        r1 = "~BC\u0002ulHB\u000ejvUY";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d3:
        r3[r2] = r1;
        r2 = 17;
        r1 = "lDA\u0015ewcO\u001fL~WA%tvEG\u0002Y";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00de:
        r3[r2] = r1;
        r2 = 18;
        r1 = "~BC\u0002ulHB\u000ejvUY3t~WE\u0015u~M";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00e9:
        r3[r2] = r1;
        r2 = 19;
        r1 = "FNUGqvMLGsq@B\u000bc?UOGslD\u0000\u0017io\fW\u000eh{NWGtvBHGvjRHGrfQEI";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f4:
        r3[r2] = r1;
        r2 = 20;
        r1 = "^OD\u0015ivEm\u0006hvGE\u0014r1YM\u000b&rHS\u0014oqF\u0000\u0015cnTI\u0015c{\u0001A\u0004rvWI\u0013%\u0001";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x00ff:
        r3[r2] = r1;
        r2 = 21;
        r1 = "^OD\u0015ivEm\u0006hvGE\u0014r1YM\u000b&rHS\u0014oqF\u0000\u000ehkDN\u0013&yHL\u0013cm\u0001F\bt?eA\u0002kpOs\u0002tiHC\u0002<?";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010a:
        r3[r2] = r1;
        r2 = 22;
        r1 = "^OD\u0015ivEm\u0006hvGE\u0014r1YM\u000b&rHS\u0014oqF\u0000\u0015cnTI\u0015c{\u0001S\u0002tiHC\u0002<?";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0115:
        r3[r2] = r1;
        r2 = 23;
        r1 = "~BT\u000eiq\u001bC\u000fc|Jv\u0006jvEm\u0006hvGE\u0014r";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0120:
        r3[r2] = r1;
        r2 = 24;
        r1 = "^OD\u0015ivEm\u0006hvGE\u0014r1YM\u000b&rHS\u0014oqF\u0000\u0006ekHV\u000erf\u001b\u0000";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012b:
        r3[r2] = r1;
        r2 = 25;
        r1 = "^OD\u0015ivEm\u0006hvGE\u0014r1YM\u000b&rHS\u0014oqF\u0000\u0015cnTI\u0015c{\u0001I\trzOTG`vMT\u0002t?GO\u0015&OTS\u000fG|UI\u0011okX\u001aGeq\u000fJ\u0017slI\u000e\u0006h{SO\u000eb1TIIVjRH&ekHV\u000erf";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0136:
        r3[r2] = r1;
        r2 = 26;
        r1 = "|NN\tc|UI\u0011okX";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0141:
        r3[r2] = r1;
        r2 = 27;
        r1 = "JOK\tihO";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014c:
        r3[r2] = r1;
        r2 = 28;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000ff.JZ~p&RW";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0157:
        r3[r2] = r1;
        r2 = 29;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000fI\trzOTIKZrs&AZ~r\"EZhv\"B";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0162:
        r3[r2] = r1;
        r2 = 30;
        r1 = "\u0015DN\u0013okX\u000e\u0006vohD]";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016d:
        r3[r2] = r1;
        r2 = 31;
        r1 = ":R\u000e\u0017cmLI\u0014uvNNILOts/YRds4GXd";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0178:
        r3[r2] = r1;
        r2 = 32;
        r1 = "LDN\u0003&}SO\u0006b|@S\u0013&kN\u0000\u0006vo\u001b\u0000";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0183:
        r3[r2] = r1;
        r2 = 33;
        r1 = "\u0015DN\u0013okX\u000e\u0013okME]";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018e:
        r3[r2] = r1;
        r2 = 34;
        r1 = "lDN\u0003DmNA\u0003e~RT3i^QPGcmSO\u0015<";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x0199:
        r3[r2] = r1;
        r2 = 35;
        r1 = "\u0015DN\u0013okX\u000e\u0002~kSA\u0014<";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a4:
        r3[r2] = r1;
        r2 = 36;
        r1 = "\u0015DN\u0013okX\u000e\u0004iqUE\trKXP\u0002<";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01af:
        r3[r2] = r1;
        r2 = 37;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000fe?RM`";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01ba:
        r3[r2] = r1;
        r2 = 38;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000fa7VTdy";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c5:
        r3[r2] = r1;
        r2 = 39;
        r1 = "\u0015DN\u0013okX\u000e\u0015o|Ip\u0012uwrA\u0011c{qA\u0013n%";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d0:
        r3[r2] = r1;
        r2 = 40;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000fm\"UL`g\"";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01db:
        r3[r2] = r1;
        r2 = 41;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000fm4A@hd";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e6:
        r3[r2] = r1;
        r2 = 42;
        r1 = "zOT\u000erf\u000fS\u0002h{DR.b%";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f1:
        r3[r2] = r1;
        r2 = 43;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000ft.RSd";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fc:
        r3[r2] = r1;
        r2 = 44;
        r1 = "\u0015DN\u0013okX\u000e\nclRA\u0000cVE\u001a";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0207:
        r3[r2] = r1;
        r2 = 45;
        r1 = "\u0015DN\u0013okX\u000e\nclRA\u0000c%";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0212:
        r3[r2] = r1;
        r2 = 46;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000fc(HKdn3YKxp\"";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021d:
        r3[r2] = r1;
        r2 = 47;
        r1 = "]TN\u0003jz\u0001S\u000fijMDGhpU\u0000\u0005c?OU\u000bj?GO\u0015&lDN\u0003DmNA\u0003e~RTI";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0228:
        r3[r2] = r1;
        r2 = 48;
        r1 = "3@C\u0013opO\u001a";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0233:
        r3[r2] = r1;
        r2 = 49;
        r1 = "lDN\u0003DmNA\u0003e~RTGcmSO\u0015<";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023e:
        r3[r2] = r1;
        r2 = 50;
        r1 = "Lec\u0006t{\u0001I\u0014&qNTGkpTN\u0013c{";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x0249:
        r3[r2] = r1;
        r2 = 51;
        r1 = "rNU\trzE";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0254:
        r3[r2] = r1;
        r2 = 52;
        r1 = "lDN\u0003DmNA\u0003e~RTG`~HL\u0002b?@G\u0006oq\u001b";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x025f:
        r3[r2] = r1;
        r2 = 53;
        r1 = "3\u0001A\u0004rvNN]";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026a:
        r3[r2] = r1;
        r2 = 54;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000fI\trzOTIHPui!O\\`t.IQ~o7CQdd";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0275:
        r3[r2] = r1;
        r2 = 55;
        r1 = "|O\u000e\rvjRHIgqER\bo{\u000fI\trzOTIHPui!O\\`t.IQ~r\"EZhv\"B";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0280:
        r3[r2] = r1;
        r2 = 56;
        r1 = "lDN\u0003DmNA\u0003e~RTG`~HL\u0002b?@G\u0006oq\u001b\u0000\u0015c|DI\u0011cm\u0001N\br?GO\u0012h{\r\u0000\u0006ekHO\t<";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028b:
        r3[r2] = r1;
        r2 = 57;
        r1 = "jSL";
        r0 = 56;
        r3 = r4;
        goto L_0x0009;
    L_0x0296:
        r3[r2] = r1;
        r2 = 58;
        r1 = "}@S\u0002d~OD";
        r0 = 57;
        r3 = r4;
        goto L_0x0009;
    L_0x02a1:
        r3[r2] = r1;
        r2 = 59;
        r1 = "|IA\thzM";
        r0 = 58;
        r3 = r4;
        goto L_0x0009;
    L_0x02ac:
        r3[r2] = r1;
        r2 = 60;
        r1 = "{DV\u000eez";
        r0 = 59;
        r3 = r4;
        goto L_0x0009;
    L_0x02b7:
        r3[r2] = r1;
        r2 = 61;
        r1 = "~OD\u0015ivEs\u0003mIDR\u0014opO";
        r0 = 60;
        r3 = r4;
        goto L_0x0009;
    L_0x02c2:
        r3[r2] = r1;
        r2 = 62;
        r1 = "qDT\u0010imJ";
        r0 = 61;
        r3 = r4;
        goto L_0x0009;
    L_0x02cd:
        r3[r2] = r1;
        r2 = 63;
        r1 = "rND\u0002j";
        r0 = 62;
        r3 = r4;
        goto L_0x0009;
    L_0x02d8:
        r3[r2] = r1;
        r2 = 64;
        r1 = "xRMIpzSS\u000eiq\u000fB\u0006uzCA\tb";
        r0 = 63;
        r3 = r4;
        goto L_0x0009;
    L_0x02e3:
        r3[r2] = r1;
        r2 = 65;
        r1 = "w@S5c|DI\u0011cmhN\u0013cqUf\u000ejkDRGcmSO\u0015<";
        r0 = 64;
        r3 = r4;
        goto L_0x0009;
    L_0x02ee:
        r3[r2] = r1;
        r2 = 66;
        r1 = "zLP\u0013?QA\u0015grR";
        r0 = 65;
        r3 = r4;
        goto L_0x0009;
    L_0x02f9:
        r3[r2] = r1;
        r2 = 67;
        r1 = "~BT\u000epvUY";
        r0 = 66;
        r3 = r4;
        goto L_0x0009;
    L_0x0304:
        r3[r2] = r1;
        r2 = 68;
        r1 = "3\u0001S\u0013gmUh\bsm\u001b";
        r0 = 67;
        r3 = r4;
        goto L_0x0009;
    L_0x030f:
        r3[r2] = r1;
        r2 = 69;
        r1 = "zOD/ijS";
        r0 = 68;
        r3 = r4;
        goto L_0x0009;
    L_0x031a:
        r3[r2] = r1;
        r2 = 70;
        r1 = "zOD\u0013KvOS";
        r0 = 69;
        r3 = r4;
        goto L_0x0009;
    L_0x0325:
        r3[r2] = r1;
        r2 = 71;
        r1 = "?_\u0000";
        r0 = 70;
        r3 = r4;
        goto L_0x0009;
    L_0x0330:
        r3[r2] = r1;
        r2 = 72;
        r1 = "lUA\u0015rRHN\u0014";
        r0 = 71;
        r3 = r4;
        goto L_0x0009;
    L_0x033b:
        r3[r2] = r1;
        r2 = 73;
        r1 = "lDT\u0013oqF\u0014osDN\u0004c@QU\u0014n@UI\nc";
        r0 = 72;
        r3 = r4;
        goto L_0x0009;
    L_0x0346:
        r3[r2] = r1;
        r2 = 74;
        r1 = "qNW/ijS\u001a";
        r0 = 73;
        r3 = r4;
        goto L_0x0009;
    L_0x0351:
        r3[r2] = r1;
        r2 = 75;
        r1 = "3\u0001N\bqRHN]";
        r0 = 74;
        r3 = r4;
        goto L_0x0009;
    L_0x035c:
        r3[r2] = r1;
        r2 = 76;
        r1 = "3\u0001E\tbRHN]";
        r0 = 75;
        r3 = r4;
        goto L_0x0009;
    L_0x0367:
        r3[r2] = r1;
        r2 = 77;
        r1 = "3\u0001E\tbWNU\u0015<";
        r0 = 76;
        r3 = r4;
        goto L_0x0009;
    L_0x0372:
        r3[r2] = r1;
        r2 = 78;
        r1 = "\\TR\u0015cqU\u0000\u0013orD\u0000\u000eu?HNGrwD\u0000\u0015gqFEGiy\u0001S\u000ejzOC\u0002&kHM\u0002&2\u0001";
        r0 = 77;
        r3 = r4;
        goto L_0x0009;
    L_0x037d:
        r3[r2] = r1;
        r2 = 79;
        r1 = "3\u0001S\u0013gmUm\u000eh%";
        r0 = 78;
        r3 = r4;
        goto L_0x0009;
    L_0x0388:
        r3[r2] = r1;
        r2 = 80;
        r1 = "lUA\u0015rWNU\u0015";
        r0 = 79;
        r3 = r4;
        goto L_0x0009;
    L_0x0393:
        r3[r2] = r1;
        r2 = 81;
        r1 = "w@S&ekHV\u000erfhN\u0013cqUf\u000ejkDRGcmSO\u0015<";
        r0 = 80;
        r3 = r4;
        goto L_0x0009;
    L_0x039e:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x03a3:
        r9 = 31;
        goto L_0x001f;
    L_0x03a7:
        r9 = 33;
        goto L_0x001f;
    L_0x03ab:
        r9 = 32;
        goto L_0x001f;
    L_0x03af:
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.d.a.<clinit>():void");
    }

    public static Intent a(Context context, b bVar, boolean z) {
        Intent intent = new Intent();
        intent.putExtra(z[6], false);
        intent.putExtra(z[5], bVar);
        intent.setAction(z[7]);
        intent.addCategory(context.getPackageName());
        intent.addFlags(536870912);
        if (!g(context)) {
            intent.addFlags(32768);
        }
        a(context, intent);
        return intent;
    }

    public static String a(Context context, String str) {
        String str2 = VERSION.RELEASE + "," + Integer.toString(VERSION.SDK_INT);
        String str3 = Build.MODEL;
        String a = h.a(context, z[64], z[58]);
        String str4 = Build.DEVICE;
        Object channel = JCoreInterface.getChannel();
        if (TextUtils.isEmpty(channel)) {
            channel = " ";
        }
        String f = f(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[61], str2);
            jSONObject.put(z[63], str3);
            jSONObject.put(z[58], a);
            jSONObject.put(z[60], str4);
            jSONObject.put(z[59], channel);
            jSONObject.put(z[62], f);
            jSONObject.put(z[57], str);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public static List<String> a(Context context, Intent intent, String str) {
        List<String> arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null) {
                    CharSequence charSequence = resolveInfo.activityInfo.name;
                    if (!TextUtils.isEmpty(charSequence)) {
                        Object obj;
                        if (TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) == 0) {
                            int i = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            arrayList.add(charSequence);
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
        return arrayList;
    }

    private static void a(Context context, Intent intent) {
        if (VERSION.SDK_INT < 21) {
            try {
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                    if (resolveInfo.activityInfo != null) {
                        Object obj = resolveInfo.activityInfo.name;
                        if (!TextUtils.isEmpty(obj)) {
                            intent.setComponent(new ComponentName(context, obj));
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(Context context, b bVar) {
        try {
            Intent intent = new Intent(z[29]);
            e.a(z[0], new StringBuilder(z[42]).append(bVar.o).append(z[45]).append(bVar.i).append(z[36]).append(bVar.j).append(z[33]).append(bVar.l).append(z[35]).append(bVar.m).append(z[44]).append(bVar.c).append(z[39]).append(bVar.H).append(z[30]).append(bVar.n).toString());
            intent.putExtra(z[38], bVar.o);
            intent.putExtra(z[40], bVar.i);
            intent.putExtra(z[46], bVar.j);
            intent.putExtra(z[43], bVar.l);
            intent.putExtra(z[37], bVar.m);
            intent.putExtra(z[41], bVar.c);
            if (bVar.a()) {
                intent.putExtra(z[28], bVar.H);
            }
            intent.addCategory(bVar.n);
            context.sendBroadcast(intent, String.format(Locale.ENGLISH, z[31], new Object[]{bVar.n}));
            e.e(z[0], new StringBuilder(z[32]).append(String.format(Locale.ENGLISH, z[31], new Object[]{bVar.n})).toString());
            d.a(bVar.c, PointerIconCompat.TYPE_ZOOM_IN, null, context);
        } catch (Throwable th) {
            e.i(z[0], new StringBuilder(z[34]).append(th.getMessage()).toString());
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            e.j(z[0], z[47]);
            return;
        }
        try {
            Intent intent = new Intent(str);
            bundle.putString(z[38], JCoreInterface.getAppKey());
            intent.putExtras(bundle);
            intent.addCategory(context.getPackageName());
            context.sendBroadcast(intent, String.format(Locale.ENGLISH, z[31], new Object[]{r1}));
        } catch (Exception e) {
            e.h(z[0], new StringBuilder(z[49]).append(e.getMessage()).append(z[48]).append(str).toString());
        }
    }

    public static void a(WebSettings webSettings) {
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName(z[14]);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        if (VERSION.SDK_INT >= 11) {
            webSettings.setDisplayZoomControls(false);
        }
        webSettings.setCacheMode(2);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
    }

    public static void a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            webView.removeJavascriptInterface(z[17]);
            webView.removeJavascriptInterface(z[16]);
            webView.removeJavascriptInterface(z[18]);
        }
    }

    public static boolean a() {
        boolean equals = Environment.getExternalStorageState().equals(z[51]);
        if (!equals) {
            e.c(z[0], z[50]);
        }
        return equals;
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(z[26])).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean a(Context context, Class<?> cls) {
        try {
            return !context.getPackageManager().queryIntentServices(new Intent(context, cls), 0).isEmpty();
        } catch (Throwable th) {
            e.d(z[0], new StringBuilder(z[4]).append(th.getMessage()).toString());
            return false;
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return !packageManager.queryBroadcastReceivers(intent, 0).isEmpty();
        } catch (Throwable th) {
            e.d(z[0], new StringBuilder(z[65]).append(th.getMessage()).toString());
            return false;
        }
    }

    public static void b(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getApplicationContext().getPackageName();
            if (packageName.isEmpty()) {
                e.h(z[0], z[2]);
                return;
            }
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
            if (launchIntentForPackage == null) {
                e.h(z[0], z[1]);
                return;
            }
            launchIntentForPackage.addFlags(268468224);
            context.startActivity(launchIntentForPackage);
        } catch (Throwable th) {
            e.d(z[0], new StringBuilder(z[3]).append(th.getMessage()).toString());
        }
    }

    public static void b(Context context, Intent intent, String str) {
        String action = intent.getAction();
        if (z[55].equals(action) || z[54].equals(action)) {
            List<String> a = a(context, intent, str);
            if (a.isEmpty()) {
                e.h(z[0], new StringBuilder(z[56]).append(intent.getAction()).toString());
                return;
            }
            for (String action2 : a) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), action2));
                    if (TextUtils.isEmpty(str)) {
                        context.sendBroadcast(intent2);
                    } else {
                        context.sendBroadcast(intent2, str);
                    }
                } catch (Exception e) {
                    e.h(z[0], new StringBuilder(z[52]).append(e.getMessage()).append(z[53]).append(intent.getAction()).toString());
                }
            }
        }
    }

    private static boolean b(Context context, Class<?> cls) {
        try {
            return !context.getPackageManager().queryIntentActivities(new Intent(context, cls), 0).isEmpty();
        } catch (Throwable th) {
            e.d(z[0], new StringBuilder(z[15]).append(th.getMessage()).toString());
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        throw new IllegalArgumentException(z[66]);
    }

    private static boolean b(Context context, String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Throwable th) {
            e.d(z[0], new StringBuilder(z[4]).append(th.getMessage()).toString());
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            if (MultiSpHelper.getBoolean(context, z[9], true)) {
                String b = cn.jpush.android.b.b(context);
                if (TextUtils.isEmpty(b)) {
                    e.e(z[0], z[12]);
                    return true;
                }
                e.e(z[0], new StringBuilder(z[11]).append(b).toString());
                String[] split = b.split("_");
                String str = split[0];
                String str2 = split[1];
                char[] toCharArray = str.toCharArray();
                String[] split2 = str2.split(z[8]);
                Calendar instance = Calendar.getInstance();
                int i = instance.get(7);
                int i2 = instance.get(11);
                for (char valueOf : toCharArray) {
                    if (i == Integer.valueOf(String.valueOf(valueOf)).intValue() + 1) {
                        int intValue = Integer.valueOf(split2[0]).intValue();
                        int intValue2 = Integer.valueOf(split2[1]).intValue();
                        if (i2 >= intValue && i2 <= intValue2) {
                            return true;
                        }
                    }
                }
                e.f(z[0], new StringBuilder(z[10]).append(b).toString());
                return false;
            }
            e.f(z[0], z[13]);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean c(Context context, String str) {
        try {
            context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean d(Context context) {
        Object string = MultiSpHelper.getString(context, z[73], "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int optInt = jSONObject.optInt(z[80], -1);
            int optInt2 = jSONObject.optInt(z[72], -1);
            int optInt3 = jSONObject.optInt(z[69], -1);
            int optInt4 = jSONObject.optInt(z[70], -1);
            if (optInt < 0 || optInt2 < 0 || optInt3 < 0 || optInt4 < 0 || optInt2 > 59 || optInt4 > 59 || optInt3 > 23 || optInt > 23) {
                return false;
            }
            Calendar instance = Calendar.getInstance();
            int i = instance.get(11);
            int i2 = instance.get(12);
            e.a(z[0], new StringBuilder(z[74]).append(i).append(z[75]).append(i2).append(z[68]).append(optInt).append(z[79]).append(optInt2).append(z[77]).append(optInt3).append(z[76]).append(optInt4).toString());
            if (optInt < optInt3) {
                if ((i <= optInt || i >= optInt3) && ((i != optInt || i2 < optInt2) && (i != optInt3 || i2 > optInt4))) {
                    return false;
                }
            } else if (optInt == optInt3) {
                if (optInt2 >= optInt4) {
                    if (i == optInt && i2 > optInt4 && i2 < optInt2) {
                        return false;
                    }
                } else if (i != optInt || i2 < optInt2) {
                    return false;
                } else {
                    if (i2 > optInt4) {
                        return false;
                    }
                }
            } else if (optInt <= optInt3) {
                return false;
            } else {
                if ((i <= optInt || i > 23) && ((i < 0 || i >= optInt3) && (i != optInt || i2 < optInt2))) {
                    if (i != optInt3) {
                        return false;
                    }
                    if (i2 > optInt4) {
                        return false;
                    }
                }
            }
            e.f(z[0], new StringBuilder(z[78]).append(optInt).append(":").append(optInt2).append(z[71]).append(optInt3).append(":").append(optInt4).toString());
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    private static boolean d(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            if (packageManager.queryIntentActivities(intent, 0).isEmpty()) {
                return false;
            }
        } catch (Throwable th) {
            e.d(z[0], new StringBuilder(z[81]).append(th.getMessage()).toString());
        }
        return true;
    }

    public static boolean e(Context context) {
        e.d(z[0], z[23]);
        if (!a(context, DaemonService.class)) {
            e.h(z[0], new StringBuilder(z[22]).append(DaemonService.class.getCanonicalName()).toString());
            JCoreInterface.setCanLaunchedStoppedService(false);
        } else if (b(context, JCoreInterface.getDaemonAction(), true)) {
            JCoreInterface.setCanLaunchedStoppedService(true);
        } else {
            e.h(z[0], new StringBuilder(z[21]).append(JCoreInterface.getDaemonAction()).toString());
            JCoreInterface.setCanLaunchedStoppedService(false);
        }
        if (b(context, PushActivity.class)) {
            if (!b(context, PopWinActivity.class)) {
                e.h(z[0], new StringBuilder(z[24]).append(PopWinActivity.class.getCanonicalName()).toString());
                e.h(z[0], z[19]);
            }
            if (d(context, z[7])) {
                return true;
            }
            e.j(z[0], z[25]);
            return false;
        }
        e.j(z[0], new StringBuilder(z[20]).append(PushActivity.class.getCanonicalName()).toString());
        return false;
    }

    private static String f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(z[26])).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return z[27];
            }
            String typeName = activeNetworkInfo.getTypeName();
            Object subtypeName = activeNetworkInfo.getSubtypeName();
            return typeName == null ? z[27] : !TextUtils.isEmpty(subtypeName) ? typeName + "," + subtypeName : typeName;
        } catch (Exception e) {
            e.printStackTrace();
            return z[27];
        }
    }

    private static boolean g(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(z[67])).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }
}
