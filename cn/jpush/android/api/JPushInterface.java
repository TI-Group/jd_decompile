package cn.jpush.android.api;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a.d;
import cn.jpush.android.a.j;
import cn.jpush.android.b;
import cn.jpush.android.c.g;
import cn.jpush.android.d.e;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.service.ServiceInterface;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: TbsSdkJava */
public class JPushInterface {
    public static final String ACTION_ACTIVITY_OPENDED;
    public static final String ACTION_CONNECTION_CHANGE;
    public static final String ACTION_MESSAGE_RECEIVED;
    public static final String ACTION_NOTIFICATION_CLICK_ACTION;
    public static final String ACTION_NOTIFICATION_OPENED;
    public static final String ACTION_NOTIFICATION_RECEIVED;
    public static final String ACTION_NOTIFICATION_RECEIVED_PROXY;
    public static final String ACTION_REGISTRATION_ID;
    public static final String ACTION_RESTOREPUSH;
    public static final String ACTION_RICHPUSH_CALLBACK;
    public static final String ACTION_STATUS;
    public static final String ACTION_STOPPUSH;
    public static final String EXTRA_ACTIVITY_PARAM;
    public static final String EXTRA_ALERT;
    public static final String EXTRA_ALERT_TYPE;
    public static final String EXTRA_APP_KEY;
    public static final String EXTRA_BIG_PIC_PATH;
    public static final String EXTRA_BIG_TEXT;
    public static final String EXTRA_CONNECTION_CHANGE;
    public static final String EXTRA_CONTENT_TYPE;
    public static final String EXTRA_EXTRA;
    public static final String EXTRA_INBOX;
    public static final String EXTRA_MESSAGE;
    public static final String EXTRA_MSG_ID;
    public static final String EXTRA_NOTIFICATION_ACTION_EXTRA;
    public static final String EXTRA_NOTIFICATION_DEVELOPER_ARG0;
    public static final String EXTRA_NOTIFICATION_ID;
    public static final String EXTRA_NOTIFICATION_TITLE;
    public static final String EXTRA_NOTI_CATEGORY;
    public static final String EXTRA_NOTI_PRIORITY;
    public static final String EXTRA_NOTI_TYPE;
    public static final String EXTRA_PUSH_ID;
    public static final String EXTRA_REGISTRATION_ID;
    public static final String EXTRA_RICHPUSH_FILE_PATH;
    public static final String EXTRA_RICHPUSH_FILE_TYPE;
    public static final String EXTRA_RICHPUSH_HTML_PATH;
    public static final String EXTRA_RICHPUSH_HTML_RES;
    public static final String EXTRA_STATUS;
    public static final String EXTRA_TITLE;
    public static int a = 5;
    private static final Integer b = Integer.valueOf(0);
    private static final String[] z;

    /* compiled from: TbsSdkJava */
    public static class a {
        public static int a = 0;
        public static int b = 6001;
        public static int c = 6002;
        public static int d = 6003;
        public static int e = 6004;
        public static int f = 6005;
        public static int g = 6006;
        public static int h = 6007;
        public static int i = 6008;
        public static int j = 6009;
        public static int k = 6010;
        public static int l = 6011;
        public static int m = 6012;
        public static int n = 6013;
        public static int o = 6014;
        public static int p = 6015;
        public static int q = 6016;
        public static int r = 6017;
        public static int s = 6018;
        public static int t = 6019;
        public static int u = 6020;
        public static int v = 6021;
        public static int w = 6022;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 54;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMXjPX\"Rj";
        r0 = 53;
        r4 = r3;
    L_0x000a:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x0158;
    L_0x0013:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0018:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x03bb;
            case 1: goto L_0x03bf;
            case 2: goto L_0x03c3;
            case 3: goto L_0x03c7;
            default: goto L_0x001f;
        };
    L_0x001f:
        r9 = 3;
    L_0x0020:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x0156;
    L_0x0028:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0018;
    L_0x002c:
        EXTRA_MESSAGE = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001BH7\\`MT\"V{J]*Av\\D3PaGN'";
        r0 = 54;
        goto L_0x000a;
    L_0x0033:
        ACTION_ACTIVITY_OPENDED = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMSfON<EnWC";
        r0 = 55;
        goto L_0x000a;
    L_0x003a:
        EXTRA_RICHPUSH_FILE_PATH = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001P_,EVX+";
        r0 = 56;
        goto L_0x000a;
    L_0x0041:
        ACTION_STOPPUSH = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001NN0FnDN<Gj@N*CjG";
        r0 = 57;
        goto L_0x000a;
    L_0x0048:
        ACTION_MESSAGE_RECEIVED = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMTcFY7J{Z[&";
        r0 = 58;
        goto L_0x000a;
    L_0x004f:
        EXTRA_ALERT_TYPE = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM]{NG<GjP";
        r0 = 59;
        goto L_0x000a;
    L_0x0056:
        EXTRA_RICHPUSH_HTML_RES = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMX|DT*Q";
        r0 = 60;
        goto L_0x000a;
    L_0x005d:
        EXTRA_MSG_ID = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMV`M_&[{\\_:Ej";
        r0 = 61;
        goto L_0x000a;
    L_0x0064:
        EXTRA_CONTENT_TYPE = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMTS@&L";
        r0 = 62;
        goto L_0x000a;
    L_0x006b:
        EXTRA_APP_KEY = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001MD7\\iJH\"AfLE<ZFE&Q";
        r0 = 63;
        goto L_0x000a;
    L_0x0072:
        ACTION_NOTIFICATION_OPENED = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM\\aAD;";
        r0 = 64;
        goto L_0x000a;
    L_0x0079:
        EXTRA_INBOX = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001MD7\\iJH\"AfLE<VcJH(Jn@_*Za";
        r0 = 65;
        goto L_0x000a;
    L_0x0080:
        ACTION_NOTIFICATION_CLICK_ACTION = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM]{NG<EnWC";
        r0 = 66;
        goto L_0x000a;
    L_0x0087:
        EXTRA_RICHPUSH_HTML_PATH = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001MD7\\iJH\"AfLE<Gj@N*CjG";
        r0 = 67;
        goto L_0x000a;
    L_0x008f:
        ACTION_NOTIFICATION_RECEIVED = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMTlWB5\\{ZT3T}BF";
        r0 = 68;
        goto L_0x000a;
    L_0x0097:
        EXTRA_ACTIVITY_PARAM = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001QN0A`QN3@|K";
        r0 = 69;
        goto L_0x000a;
    L_0x009f:
        ACTION_RESTOREPUSH = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001MD7\\iJH\"AfLE<Gj@N*CjGT3G`[R";
        r0 = 70;
        goto L_0x000a;
    L_0x00a7:
        ACTION_NOTIFICATION_RECEIVED_PROXY = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM[`WB<VnWN$Z}Z";
        r0 = 71;
        goto L_0x000a;
    L_0x00af:
        EXTRA_NOTI_CATEGORY = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001P_\"AzP";
        r0 = 72;
        goto L_0x000a;
    L_0x00b7:
        ACTION_STATUS = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMPwWY\"";
        r0 = 73;
        goto L_0x000a;
    L_0x00bf:
        EXTRA_EXTRA = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMF{B_6F";
        r0 = 74;
        goto L_0x000a;
    L_0x00c7:
        EXTRA_STATUS = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM[`WB%\\lB_*Za\\O&CjOD3P}\\J1R\u001f";
        r0 = 75;
        goto L_0x000a;
    L_0x00cf:
        EXTRA_NOTIFICATION_DEVELOPER_ARG0 = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM[`WB%\\lB_*Za\\B'";
        r0 = 76;
        goto L_0x000a;
    L_0x00d7:
        EXTRA_NOTIFICATION_ID = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM[`WB%\\n@J7\\`MT\"V{JD-Jj[_1T";
        r0 = 77;
        goto L_0x000a;
    L_0x00df:
        EXTRA_NOTIFICATION_ACTION_EXTRA = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM[`WB<E}JD1\\{Z";
        r0 = 78;
        goto L_0x000a;
    L_0x00e7:
        EXTRA_NOTI_PRIORITY = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMAfWG&";
        r0 = 79;
        goto L_0x000a;
    L_0x00ef:
        EXTRA_TITLE = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001QN$\\|WY\"AfLE";
        r0 = 80;
        goto L_0x000a;
    L_0x00f7:
        ACTION_REGISTRATION_ID = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM[`WB%\\lB_*Za\\_:Ej";
        r0 = 81;
        goto L_0x000a;
    L_0x00ff:
        EXTRA_NOTI_TYPE = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMEzPC<\\k";
        r0 = 82;
        goto L_0x000a;
    L_0x0107:
        EXTRA_PUSH_ID = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM[`WB%\\lB_*Za\\H,[{FE7J{J_/P";
        r0 = 83;
        goto L_0x000a;
    L_0x010f:
        EXTRA_NOTIFICATION_TITLE = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMSfON<AvSN";
        r0 = 84;
        goto L_0x000a;
    L_0x0117:
        EXTRA_RICHPUSH_FILE_TYPE = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMGjDB0A}B_*Za\\B'";
        r0 = 85;
        goto L_0x000a;
    L_0x011f:
        EXTRA_REGISTRATION_ID = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001@D-[j@_*Za";
        r0 = 86;
        goto L_0x000a;
    L_0x0127:
        ACTION_CONNECTION_CHANGE = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001BH7\\`MT1\\lK[6Fg\\H\"YcAJ ^";
        r0 = 87;
        goto L_0x000a;
    L_0x012f:
        ACTION_RICHPUSH_CALLBACK = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMWfDT3\\l\\[\"Ag";
        r0 = 88;
        goto L_0x000a;
    L_0x0137:
        EXTRA_BIG_PIC_PATH = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMV`ME&V{JD-JlKJ-Rj";
        r0 = 89;
        goto L_0x000a;
    L_0x013f:
        EXTRA_CONNECTION_CHANGE = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMTcFY7";
        r0 = 90;
        goto L_0x000a;
    L_0x0147:
        EXTRA_ALERT = r1;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joMWfDT7PwW";
        r0 = 91;
        goto L_0x000a;
    L_0x014f:
        EXTRA_BIG_TEXT = r1;
        r1 = "#8%\u00025V\u0018%\u00034vJJ\u0007+";
        r0 = -1;
        goto L_0x000a;
    L_0x0156:
        r5 = r1;
        r1 = r7;
    L_0x0158:
        if (r5 > r6) goto L_0x0013;
    L_0x015a:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x016f;
            case 1: goto L_0x0178;
            case 2: goto L_0x0181;
            case 3: goto L_0x018a;
            case 4: goto L_0x0193;
            case 5: goto L_0x019c;
            case 6: goto L_0x01a5;
            case 7: goto L_0x01af;
            case 8: goto L_0x01ba;
            case 9: goto L_0x01c5;
            case 10: goto L_0x01d0;
            case 11: goto L_0x01db;
            case 12: goto L_0x01e6;
            case 13: goto L_0x01f1;
            case 14: goto L_0x01fc;
            case 15: goto L_0x0207;
            case 16: goto L_0x0212;
            case 17: goto L_0x021d;
            case 18: goto L_0x0228;
            case 19: goto L_0x0233;
            case 20: goto L_0x023e;
            case 21: goto L_0x0249;
            case 22: goto L_0x0254;
            case 23: goto L_0x025f;
            case 24: goto L_0x026a;
            case 25: goto L_0x0275;
            case 26: goto L_0x0280;
            case 27: goto L_0x028b;
            case 28: goto L_0x0296;
            case 29: goto L_0x02a1;
            case 30: goto L_0x02ac;
            case 31: goto L_0x02b7;
            case 32: goto L_0x02c2;
            case 33: goto L_0x02cd;
            case 34: goto L_0x02d8;
            case 35: goto L_0x02e3;
            case 36: goto L_0x02ee;
            case 37: goto L_0x02f9;
            case 38: goto L_0x0304;
            case 39: goto L_0x030f;
            case 40: goto L_0x031a;
            case 41: goto L_0x0325;
            case 42: goto L_0x0330;
            case 43: goto L_0x033b;
            case 44: goto L_0x0346;
            case 45: goto L_0x0351;
            case 46: goto L_0x035c;
            case 47: goto L_0x0367;
            case 48: goto L_0x0372;
            case 49: goto L_0x037d;
            case 50: goto L_0x0388;
            case 51: goto L_0x0393;
            case 52: goto L_0x039e;
            case 53: goto L_0x002c;
            case 54: goto L_0x0033;
            case 55: goto L_0x003a;
            case 56: goto L_0x0041;
            case 57: goto L_0x0048;
            case 58: goto L_0x004f;
            case 59: goto L_0x0056;
            case 60: goto L_0x005d;
            case 61: goto L_0x0064;
            case 62: goto L_0x006b;
            case 63: goto L_0x0072;
            case 64: goto L_0x0079;
            case 65: goto L_0x0080;
            case 66: goto L_0x0087;
            case 67: goto L_0x008f;
            case 68: goto L_0x0097;
            case 69: goto L_0x009f;
            case 70: goto L_0x00a7;
            case 71: goto L_0x00af;
            case 72: goto L_0x00b7;
            case 73: goto L_0x00bf;
            case 74: goto L_0x00c7;
            case 75: goto L_0x00cf;
            case 76: goto L_0x00d7;
            case 77: goto L_0x00df;
            case 78: goto L_0x00e7;
            case 79: goto L_0x00ef;
            case 80: goto L_0x00f7;
            case 81: goto L_0x00ff;
            case 82: goto L_0x0107;
            case 83: goto L_0x010f;
            case 84: goto L_0x0117;
            case 85: goto L_0x011f;
            case 86: goto L_0x0127;
            case 87: goto L_0x012f;
            case 88: goto L_0x0137;
            case 89: goto L_0x013f;
            case 90: goto L_0x0147;
            case 91: goto L_0x014f;
            default: goto L_0x0166;
        };
    L_0x0166:
        r3[r2] = r1;
        r2 = 1;
        r1 = "J\u000fgJbo\u001a5|f3`\\k_\nxJ/+\u0004|Yf+\u0016e\u000f.+";
        r0 = 0;
        r3 = r4;
        goto L_0x000a;
    L_0x016f:
        r3[r2] = r1;
        r2 = 2;
        r1 = "e\faFeb\u0000t[jd\rJJmj\u0001yJg";
        r0 = 1;
        r3 = r4;
        goto L_0x000a;
    L_0x0178:
        r3[r2] = r1;
        r2 = 3;
        r1 = "&J>\u0007";
        r0 = 2;
        r3 = r4;
        goto L_0x000a;
    L_0x0181:
        r3[r2] = r1;
        r2 = 4;
        r1 = "'CeZpc7|Bf1";
        r0 = 3;
        r3 = r4;
        goto L_0x000a;
    L_0x018a:
        r3[r2] = r1;
        r2 = 5;
        r1 = "j\u0000aFleYfJw[\u0016fGWb\u000ep\u000f.+\u0000y@pn\u0007";
        r0 = 4;
        r3 = r4;
        goto L_0x000a;
    L_0x0193:
        r3[r2] = r1;
        r2 = 6;
        r1 = "J\u0000aFleYpAbi\u000fpal\nsF`j\u0017|@m";
        r0 = 5;
        r3 = r4;
        goto L_0x000a;
    L_0x019c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\"J";
        r0 = 6;
        r3 = r4;
        goto L_0x000a;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\"\u001f=";
        r0 = 7;
        r3 = r4;
        goto L_0x000a;
    L_0x01af:
        r3[r2] = r1;
        r2 = 9;
        r1 = "B\rcNob\u00075[jf\u00065Ily\u000et[#&C";
        r0 = 8;
        r3 = r4;
        goto L_0x000a;
    L_0x01ba:
        r3[r2] = r1;
        r2 = 10;
        r1 = "j\u0000aFleYfJw[\u0016fGWb\u000ep\u000f.+\u0006{Nag\u0006q\u0015";
        r0 = 9;
        r3 = r4;
        goto L_0x000a;
    L_0x01c5:
        r3[r2] = r1;
        r2 = 11;
        r1 = "A3`\\kB\raJqm\u0002vJ";
        r0 = 10;
        r3 = r4;
        goto L_0x000a;
    L_0x01d0:
        r3[r2] = r1;
        r2 = 12;
        r1 = "#8%\u0002:V\u001f$t3&ZHS1PS8\u001c^\"?K\u0007X;N,r:8%\u0002:V\u001f't3&PH\u0006";
        r0 = 11;
        r3 = r4;
        goto L_0x000a;
    L_0x01db:
        r3[r2] = r1;
        r2 = 13;
        r1 = "f\u0002mavfCfGl~\u000fq\u000f=+S9\u000fDb\u0015p\u000fv{CtLwb\f{\u0001-";
        r0 = 12;
        r3 = r4;
        goto L_0x000a;
    L_0x01e6:
        r3[r2] = r1;
        r2 = 14;
        r1 = "j\u0000aFleYfJwG\u0002aJp-z[jm\nvNwb\f{avf\u0001p]#1C";
        r0 = 13;
        r3 = r4;
        goto L_0x000a;
    L_0x01f1:
        r3[r2] = r1;
        r2 = 15;
        r1 = "'CwZjg\u0007\\K98T,";
        r0 = 14;
        r3 = r4;
        goto L_0x000a;
    L_0x01fc:
        r3[r2] = r1;
        r2 = 16;
        r1 = "j\u0000aFleY|AjC8\u000fpo\bCJqx\nzA9";
        r0 = 15;
        r3 = r4;
        goto L_0x000a;
    L_0x0207:
        r3[r2] = r1;
        r2 = 17;
        r1 = "棋洨別彼剎沪杪罄绳、镴辽掰尩圫朂缲绉旙臩劣纄绸廕竈〉";
        r0 = 16;
        r3 = r4;
        goto L_0x000a;
    L_0x0212:
        r3[r2] = r1;
        r2 = 18;
        r1 = "j\u0000aFleYf[l{3`\\k";
        r0 = 17;
        r3 = r4;
        goto L_0x000a;
    L_0x021d:
        r3[r2] = r1;
        r2 = 19;
        r1 = "_\u000bp\u000fa~\nyKfyCbFwcC|K9";
        r0 = 18;
        r3 = r4;
        goto L_0x000a;
    L_0x0228:
        r3[r2] = r1;
        r2 = 20;
        r1 = "+\u000bt\\#e\fa\u000fan\u0006{\u000fpn\u00175Fm+\u001azZq+\u0002e_/+\u0016fJ#o\u0006sNvg\u00175Mvb\u000fqJq*";
        r0 = 19;
        r3 = r4;
        goto L_0x000a;
    L_0x0233:
        r3[r2] = r1;
        r2 = 21;
        r1 = "E6Yc#h\f{[fs\u0017";
        r0 = 20;
        r3 = r4;
        goto L_0x000a;
    L_0x023e:
        r3[r2] = r1;
        r2 = 22;
        r1 = "H\u0016f[lf\noJg+\u0001`Foo\u0006g\u000fey\fx\u000fpj\u0015pK#{\u0011pIfy\u0006{Lf+N5";
        r0 = 21;
        r3 = r4;
        goto L_0x000a;
    L_0x0249:
        r3[r2] = r1;
        r2 = 23;
        r1 = "h\u0016f[lf";
        r0 = 22;
        r3 = r4;
        goto L_0x000a;
    L_0x0254:
        r3[r2] = r1;
        r2 = 24;
        r1 = "l\u0006a}fh\fgKS~\u0010}al\nsF`j\u0017|@mI\u0016|Cgn\u00115\u0002#";
        r0 = 23;
        r3 = r4;
        goto L_0x000a;
    L_0x025f:
        r3[r2] = r1;
        r2 = 25;
        r1 = "a\u0013`\\kT\u0010tYfT\u0000`\\wd\u000eJMvb\u000fqJq";
        r0 = 24;
        r3 = r4;
        goto L_0x000a;
    L_0x026a:
        r3[r2] = r1;
        r2 = 26;
        r1 = "i\u0002fF`";
        r0 = 25;
        r3 = r4;
        goto L_0x000a;
    L_0x0275:
        r3[r2] = r1;
        r2 = 27;
        r1 = "j\u0000aFle";
        r0 = 26;
        r3 = r4;
        goto L_0x000a;
    L_0x0280:
        r3[r2] = r1;
        r2 = 28;
        r1 = "f\u0016y[jT\u0017l_f";
        r0 = 27;
        r3 = r4;
        goto L_0x000a;
    L_0x028b:
        r3[r2] = r1;
        r2 = 29;
        r1 = "h\r;Es~\u0010}\u0001be\u0007g@joM|Awn\ra\u0001N^/Af\\[1ZlFX0";
        r0 = 28;
        r3 = r4;
        goto L_0x000a;
    L_0x0296:
        r3[r2] = r1;
        r2 = 30;
        r1 = "Y\u0006x@unCaGf+\u0010|Cfe\u0000p\u000fwb\u000ep\u000e";
        r0 = 29;
        r3 = r4;
        goto L_0x000a;
    L_0x02a1:
        r3[r2] = r1;
        r2 = 31;
        r1 = "X\u0006a\u000fPb\u000fpA`nCEZpc7|Bf+%tFon\u0007";
        r0 = 30;
        r3 = r4;
        goto L_0x000a;
    L_0x02ac:
        r3[r2] = r1;
        r2 = 32;
        r1 = "B\rcNob\u00075_by\u0002xJwn\u00115Ily\u000et[/+\u0010aNq+zZq+\u0002{K#n\rqgl~\u00115\\kd\u0016yK#i\u0006aXfn\r5\u001f#uC'\u001c/+\u0010aNq.|Ap+\u0002{K#n\rqbje\u00105\\kd\u0016yK#i\u0006aXfn\r5\u001f#uC \u0016-+";
        r0 = 31;
        r3 = r4;
        goto L_0x000a;
    L_0x02b7:
        r3[r2] = r1;
        r2 = 33;
        r1 = "+N8\u000f";
        r0 = 32;
        r3 = r4;
        goto L_0x000a;
    L_0x02c2:
        r3[r2] = r1;
        r2 = 34;
        r1 = "+Y5";
        r0 = 33;
        r3 = r4;
        goto L_0x000a;
    L_0x02cd:
        r3[r2] = r1;
        r2 = 35;
        r1 = "X\u0006a\u000fPb\u000fpA`nCEZpc7|Bf+N5";
        r0 = 34;
        r3 = r4;
        goto L_0x000a;
    L_0x02d8:
        r3[r2] = r1;
        r2 = 36;
        r1 = "莼厵讥彺a~\nyKfy写锌\u000e";
        r0 = 35;
        r3 = r4;
        goto L_0x000a;
    L_0x02e3:
        r3[r2] = r1;
        r2 = 37;
        r1 = "E\f5Kf}\u0006y@sn\u00115Lvx\u0017zBjq\u0006q\u000fa~\nyKfyM5zpnCqJej\u0016y[#d\rp\u0001";
        r0 = 36;
        r3 = r4;
        goto L_0x000a;
    L_0x02ee:
        r3[r2] = r1;
        r2 = 38;
        r1 = "j\u0000aFleYrJw[\u0016fGMd\u0017|Ijh\u0002aFle!`Foo\u0006g\u000f9+";
        r0 = 37;
        r3 = r4;
        goto L_0x000a;
    L_0x02f9:
        r3[r2] = r1;
        r2 = 39;
        r1 = "B\rcNob\u00075KbrCs@qf\u0002a\u000f.+";
        r0 = 38;
        r3 = r4;
        goto L_0x000a;
    L_0x0304:
        r3[r2] = r1;
        r2 = 40;
        r1 = "棋洨別彼剎沪杪罄绳、歯勋佉尩圫朂缲绉旙臩劣纄绸扈衏〉";
        r0 = 39;
        r3 = r4;
        goto L_0x000a;
    L_0x030f:
        r3[r2] = r1;
        r2 = 41;
        r1 = "B\rcNob\u00075[jf\u00065Ily\u000et[#&Cf[by\u0017]@vyCfGl~\u000fq\u000fon\u0010f\u000fwc\u0002{\u000ffe\u0007]@vy";
        r0 = 40;
        r3 = r4;
        goto L_0x000a;
    L_0x031a:
        r3[r2] = r1;
        r2 = 42;
        r1 = ";R'\u001c7>UJ\u001f]9P";
        r0 = 41;
        r3 = r4;
        goto L_0x000a;
    L_0x0325:
        r3[r2] = r1;
        r2 = 43;
        r1 = "g\fvNoT\rz[jm\nvNwb\f{pjo";
        r0 = 42;
        r3 = r4;
        goto L_0x000a;
    L_0x0330:
        r3[r2] = r1;
        r2 = 44;
        r1 = "j\u0000aFleYgJp~\u000epvx\u000b";
        r0 = 43;
        r3 = r4;
        goto L_0x000a;
    L_0x033b:
        r3[r2] = r1;
        r2 = 45;
        r1 = "e\faFeb\u0000t[jd\r";
        r0 = 44;
        r3 = r4;
        goto L_0x000a;
    L_0x0346:
        r3[r2] = r1;
        r2 = 46;
        r1 = "x\u0006f\\fb\f{\u000fwb\u000ep@vCyJpxCaGbeC$\u001fp";
        r0 = 45;
        r3 = r4;
        goto L_0x000a;
    L_0x0351:
        r3[r2] = r1;
        r2 = 47;
        r1 = "x\u0006f\\fb\f{\u000fwb\u000ep@vCyNql\u0006g\u000fwc\u0002{\u000f2o\u0002l";
        r0 = 46;
        r3 = r4;
        goto L_0x000a;
    L_0x035c:
        r3[r2] = r1;
        r2 = 48;
        r1 = "E6Yc#e\faFeb\u0000t[jd\r";
        r0 = 47;
        r3 = r4;
        goto L_0x000a;
    L_0x0367:
        r3[r2] = r1;
        r2 = 49;
        r1 = "P\u0011p^vn\u0010afy\u000e|\\pb\f{r#~\rpW`n\u0013aJg+N5Lle\u0017pWw+\u0014t\\#e\u0016yC";
        r0 = 48;
        r3 = r4;
        goto L_0x000a;
    L_0x0372:
        r3[r2] = r1;
        r2 = 50;
        r1 = "_\u000bp\u000fnx\u0004\\K#b\u00105AlCcNob\u00075\u0002#";
        r0 = 49;
        r3 = r4;
        goto L_0x000a;
    L_0x037d:
        r3[r2] = r1;
        r2 = 51;
        r1 = "b\u00075\\kd\u0016yK#i\u00065Cby\u0004p]#\u000btA#;";
        r0 = 50;
        r3 = r4;
        goto L_0x000a;
    L_0x0388:
        r3[r2] = r1;
        r2 = 52;
        r1 = "E6Yc#{\u0016fGMd\u0017|Ijh\u0002aFle!`Foo\u0006g";
        r0 = 51;
        r3 = r4;
        goto L_0x000a;
    L_0x0393:
        r3[r2] = r1;
        r2 = 53;
        r1 = "j\u0000aFleYfJw[\u0016fGMd\u0017|Ijh\u0002aFle!`Foo\u0006g\u000f.+\nq\u0015";
        r0 = 52;
        r3 = r4;
        goto L_0x000a;
    L_0x039e:
        r3[r2] = r1;
        z = r4;
        r0 = 5;
        a = r0;
        r0 = 0;
        r0 = java.lang.Integer.valueOf(r0);
        b = r0;
        r0 = cn.jpush.android.a.a;
        r1 = cn.jpush.android.a.c.class;
        cn.jiguang.api.JCoreInterface.initActionExtra(r0, r1);
        r0 = cn.jpush.android.a.a;
        r1 = cn.jpush.android.a.b.class;
        cn.jiguang.api.JCoreInterface.initAction(r0, r1);
        return;
    L_0x03bb:
        r9 = 11;
        goto L_0x0020;
    L_0x03bf:
        r9 = 99;
        goto L_0x0020;
    L_0x03c3:
        r9 = 21;
        goto L_0x0020;
    L_0x03c7:
        r9 = 47;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.JPushInterface.<clinit>():void");
    }

    private static PushNotificationBuilder a(String str) throws NumberFormatException {
        e.a(z[11], new StringBuilder(z[24]).append(str).toString());
        String string = MultiSpHelper.getString(cn.jpush.android.a.e, new StringBuilder(z[25]).append(str).toString(), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        e.a(z[11], new StringBuilder(z[22]).append(string).toString());
        return (string.startsWith(z[26]) || string.startsWith(z[23])) ? BasicPushNotificationBuilder.a(string) : MultiActionsNotificationBuilder.parseFromPreference(string);
    }

    private static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException(z[21]);
        }
    }

    private static void a(Context context, boolean z, String str) {
        e.c(z[11], z[6]);
        MultiSpHelper.commitBoolean(context, z[2], z);
        if (z) {
            String str2 = z[12];
            if (Pattern.compile(new StringBuilder(z[0]).append(str2).append(z[8]).append(str2).append(z[3]).append(str2).append(z[7]).toString()).matcher(str).matches()) {
                str2 = b.b(context);
                if (str.equals(str2)) {
                    e.d(z[11], new StringBuilder(z[1]).append(str2).toString());
                    return;
                }
                e.d(z[11], new StringBuilder(z[10]).append(z).append(z[4]).append(str).toString());
                b.b(context, str, false);
                return;
            }
            e.j(z[11], new StringBuilder(z[9]).append(str).toString());
            return;
        }
        e.d(z[11], z[5]);
    }

    static boolean a(int i) {
        if (i <= 0) {
            return false;
        }
        if (a(i) != null) {
            return true;
        }
        e.h(z[11], new StringBuilder(z[19]).append(i).append(z[20]).toString());
        return false;
    }

    public static void addLocalNotification(Context context, JPushLocalNotification jPushLocalNotification) {
        a(context);
        cn.jpush.android.service.a.a(context).a(context, jPushLocalNotification, false);
    }

    public static void addTags(Context context, int i, Set<String> set) {
        a(context);
        j.a(context, i, (Set) set, 1, 1);
    }

    static PushNotificationBuilder b(int i) {
        PushNotificationBuilder a;
        e.b(z[11], new StringBuilder(z[38]).append(i).toString());
        if (i <= 0) {
            i = b.intValue();
        }
        try {
            a = a(i);
        } catch (Throwable e) {
            e.a(z[11], z[36], e);
            a = null;
        }
        if (a != null) {
            return a;
        }
        e.c(z[11], z[37]);
        return new DefaultPushNotificationBuilder();
    }

    public static void checkTagBindState(Context context, int i, String str) {
        a(context);
        Set set = null;
        if (!TextUtils.isEmpty(str)) {
            set = new HashSet();
            set.add(str);
        }
        j.a(context, i, set, 1, 6);
    }

    public static void cleanTags(Context context, int i) {
        a(context);
        j.a(context, i, new HashSet(), 1, 4);
    }

    public static void clearAllNotifications(Context context) {
        a(context);
        ServiceInterface.b(context);
    }

    public static void clearLocalNotifications(Context context) {
        a(context);
        Bundle bundle = new Bundle();
        bundle.putString(z[27], z[29]);
        bundle.putInt(z[28], 8);
        JCoreInterface.sendAction(context, cn.jpush.android.a.a, bundle);
    }

    public static void clearNotificationById(Context context, int i) {
        a(context);
        ((NotificationManager) context.getSystemService(z[45])).cancel(i);
    }

    public static void deleteAlias(Context context, int i) {
        a(context);
        j.a(context, i, null, 2, 3);
    }

    public static void deleteTags(Context context, int i, Set<String> set) {
        a(context);
        j.a(context, i, (Set) set, 1, 3);
    }

    public static Set<String> filterValidTags(Set<String> set) {
        return j.a((Set) set);
    }

    public static void getAlias(Context context, int i) {
        a(context);
        j.a(context, i, null, 2, 5);
    }

    public static void getAllTags(Context context, int i) {
        a(context);
        j.a(context, i, new HashSet(), 1, 5);
    }

    public static boolean getConnectionState(Context context) {
        a(context);
        return JCoreInterface.getConnectionState(context);
    }

    public static String getRegistrationID(Context context) {
        a(context);
        return JCoreInterface.getRegistrationID(context);
    }

    public static String getStringTags(Set<String> set) {
        return j.b(set);
    }

    public static String getUdid(Context context) {
        a(context);
        return JCoreInterface.getDeviceId(context);
    }

    public static void init(Context context) {
        e.d(z[11], new StringBuilder(z[16]).append(ServiceInterface.a()).append(z[15]).toString());
        a(context);
        if (cn.jpush.android.a.a(context)) {
            if (JCoreInterface.getDebugMode() && !cn.jpush.android.d.a.a(context)) {
                e.d(z[11], z[17]);
            }
            if (b.a(context) == -1) {
                setLatestNotificationNumber(context, a);
            }
            ServiceInterface.a(context);
        }
    }

    public static void initCrashHandler(Context context) {
        a(context);
        JCoreInterface.initCrashHandler(context);
    }

    public static boolean isPushStopped(Context context) {
        a(context);
        return ServiceInterface.c(context);
    }

    public static void onFragmentPause(Context context, String str) {
        a(context);
        JCoreInterface.onFragmentPause(context, str);
    }

    public static void onFragmentResume(Context context, String str) {
        a(context);
        JCoreInterface.onFragmentResume(context, str);
    }

    public static void onKillProcess(Context context) {
        JCoreInterface.onKillProcess(context);
    }

    public static void onPause(Context context) {
        a(context);
        JCoreInterface.onPause(context);
    }

    public static void onResume(Context context) {
        a(context);
        JCoreInterface.onResume(context);
    }

    public static void removeLocalNotification(Context context, long j) {
        a(context);
        Bundle bundle = new Bundle();
        bundle.putString(z[27], z[29]);
        bundle.putInt(z[28], 7);
        bundle.putLong(z[43], j);
        JCoreInterface.sendAction(context, cn.jpush.android.a.a, bundle);
    }

    public static void reportNotificationOpened(Context context, String str) {
        a(context);
        if (TextUtils.isEmpty(str)) {
            e.j(z[11], new StringBuilder(z[50]).append(str).toString());
        }
        d.a(str, 1028, null, context);
    }

    public static void requestPermission(Context context) {
        if (context == null) {
            e.h(z[11], z[49]);
        } else {
            JCoreInterface.requestPermission(context);
        }
    }

    public static void resumePush(Context context) {
        e.d(z[11], z[44]);
        a(context);
        ServiceInterface.b(context, 1);
        g.a().b(context);
    }

    public static void setAlias(Context context, int i, String str) {
        a(context);
        j.a(context, i, str, 2, 2);
    }

    @Deprecated
    public static void setAlias(Context context, String str, TagAliasCallback tagAliasCallback) {
        a(context);
        setAliasAndTags(context, str, null, tagAliasCallback);
    }

    @Deprecated
    public static void setAliasAndTags(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback) {
        a(context);
        j.a(context, str, set, tagAliasCallback, 0, 0);
    }

    public static void setDaemonAction(String str) {
        JCoreInterface.setDaemonAction(str);
    }

    public static void setDebugMode(boolean z) {
        JCoreInterface.setDebugMode(z);
    }

    public static void setDefaultPushNotificationBuilder(DefaultPushNotificationBuilder defaultPushNotificationBuilder) {
        if (defaultPushNotificationBuilder == null) {
            throw new IllegalArgumentException(z[48]);
        }
        ServiceInterface.a(cn.jpush.android.a.e, b, defaultPushNotificationBuilder);
    }

    public static void setLatestNotificationNumber(Context context, int i) {
        a(context);
        e.d(z[11], new StringBuilder(z[14]).append(i).toString());
        if (i <= 0) {
            e.j(z[11], z[13]);
        } else {
            ServiceInterface.c(context, i);
        }
    }

    public static void setPushNotificationBuilder(Integer num, DefaultPushNotificationBuilder defaultPushNotificationBuilder) {
        e.b(z[11], new StringBuilder(z[53]).append(num).toString());
        if (defaultPushNotificationBuilder == null) {
            throw new IllegalArgumentException(z[52]);
        } else if (num.intValue() <= 0) {
            e.j(z[11], z[51]);
        } else {
            ServiceInterface.a(cn.jpush.android.a.e, num, defaultPushNotificationBuilder);
        }
    }

    public static void setPushTime(Context context, Set<Integer> set, int i, int i2) {
        a(context);
        if (JCoreInterface.getDebugMode() && !cn.jpush.android.d.a.a(context)) {
            e.d(z[11], z[40]);
        }
        if (set == null) {
            a(context, true, z[42]);
        } else if (set.size() == 0 || set.isEmpty()) {
            a(context, false, z[42]);
        } else if (i > i2) {
            e.j(z[11], z[41]);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer num : set) {
                if (num.intValue() > 6 || num.intValue() < 0) {
                    e.j(z[11], new StringBuilder(z[39]).append(num).toString());
                    return;
                }
                stringBuilder.append(num);
            }
            stringBuilder.append("_");
            stringBuilder.append(i);
            stringBuilder.append("^");
            stringBuilder.append(i2);
            a(context, true, stringBuilder.toString());
        }
    }

    public static void setSilenceTime(Context context, int i, int i2, int i3, int i4) {
        a(context);
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || i2 > 59 || i4 > 59 || i3 > 23 || i > 23) {
            e.j(z[11], z[32]);
        } else if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            ServiceInterface.a(context, "");
            e.d(z[11], z[30]);
        } else if (ServiceInterface.a(context, i, i2, i3, i4)) {
            e.d(z[11], new StringBuilder(z[35]).append(i).append(z[34]).append(i2).append(z[33]).append(i3).append(z[34]).append(i4).toString());
        } else {
            e.j(z[11], z[31]);
        }
    }

    public static void setStatisticsEnable(boolean z) {
    }

    public static void setStatisticsSessionTimeout(long j) {
        if (j < 10) {
            e.h(z[11], z[46]);
        } else if (j > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            e.h(z[11], z[47]);
        }
    }

    public static void setTags(Context context, int i, Set<String> set) {
        a(context);
        j.a(context, i, (Set) set, 1, 2);
    }

    @Deprecated
    public static void setTags(Context context, Set<String> set, TagAliasCallback tagAliasCallback) {
        a(context);
        setAliasAndTags(context, null, set, tagAliasCallback);
    }

    public static void stopCrashHandler(Context context) {
        a(context);
        JCoreInterface.stopCrashHandler(context);
    }

    public static void stopPush(Context context) {
        e.d(z[11], z[18]);
        a(context);
        ServiceInterface.a(context, 1);
        g.a().c(context);
    }

    @Deprecated
    public void setAliasAndTags(Context context, String str, Set<String> set) {
        a(context);
        j.a(context, str, set, null, 0, 0);
    }
}
