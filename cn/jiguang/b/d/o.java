package cn.jiguang.b.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.api.SdkType;
import cn.jiguang.b.a.d;
import cn.jiguang.e.a;
import cn.jiguang.e.j;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class o {
    public static JSONObject a = null;
    private static final String b = o.class.getSimpleName();
    private static String c = "";
    private static String d;
    private static String e;
    private static final String f = new StringBuilder(z[8]).append(d).toString();
    private static ExecutorService g = Executors.newSingleThreadExecutor();
    private static Object h = new Object();
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 65;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "k.s]c";
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
            case 0: goto L_0x031a;
            case 1: goto L_0x031e;
            case 2: goto L_0x0322;
            case 3: goto L_0x0326;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 91;
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
            case 61: goto L_0x02ce;
            case 62: goto L_0x02d9;
            case 63: goto L_0x02e4;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\\\u001bF\u00198\u001e\u001b@\u00043Q\b\\\n:J\u0013Z\u001e{[\u0014V\u001f?[ZS\u00112R\u001fQ";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "Y\u001fA2:M\u0013V1.J\u0012Z\u00022D\u001bA\u00194P";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "T\n@\u00033a\tA\u0011/a\u0019T\u00133[%]\u0019(J\u0015G\tuT\tZ\u001e";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "]\u0015[\u0004>P\u000e";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "K\u000eS]c";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "K\u0014P\b+[\u0019A\u0015?\u001f";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "V\u000eA\u0000(\u0004U\u001a";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "M\u000eT\u0004(\u0010\u0010E\u0005(VTV\u001e";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "I\bT\u0000{]\u0015[\u0004:W\u0014P\u0002{[\u0002V\u0015+J\u0013Z\u001ew\u001e\u001d\\\u0006>\u001e\u000fEP([\u0014QP7Q\u001d\u000f";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "]\u0015[\u0004>F\u000e\u000f";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "M\u001f[\u0014{R\u0015RP(R\u0013V\u0015a";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u001e\u0013A\u00156M@";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0019A\u00194PZ\u0018P([\u0014Q<4Y(Z\u0005/W\u0014PP,W\u000e]P)[\nZ\u0002/\u001e9T\u001c7|\u001bV\u001b";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "R\u0015RP(W\u0000PJ";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "N\u000fAP8Q\u0014A\u00155JZP\b8[\nA\u00194PV\u0015\u00172H\u001f\u0015\u0005+\u001e\tP\u001e?\u001e\u0016Z\u0017a";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u001e\u0017\\\u0003(\u001e\u000f\\\u0014wY\u001f[\u0015)_\u000ePP)[\nZ\u0002/\u001e\u000eZ\u001b>PZS\u00112R\u001fQ";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u001e\u0018Z\u0014\"\u001e\u0013FP5K\u0016Y\\<[\u0014P\u0002:J\u001f\u0015\u0002>N\u0015G\u0004{J\u0015^\u00155\u001e\u001cT\u00197[\u001e";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "M\u0013FP)[\nZ\u0002/\u001e\u000fG\u001ca";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "K\u0014P\b+[\u0019A\u0015?\u0012ZG\u0015+Q\bAP2NZ\\\u0003{P\u000fY\u001c";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "V\u000eA\u0000a\u0011U";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "_\nE/0[\u0003";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "S\u0013F\u0003{K\u0013QP,V\u001f[P,L\u001bEP8Q\u0014A\u00112P\u001fGP2P\u001cZ";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "_\nE/-[\bF\u00194P";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "\u000fT\u0004^m";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "S\u0013F\u0003{_\nE/0[\u0003\u0015\u00073[\u0014\u0015\u0007)_\n\u0015\u00134P\u000eT\u00195[\b\u0015\u00195X\u0015";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "]\u0012T\u001e5[\u0016";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "]\u0015G\u0015\u0004M\u001e^/-[\b";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "S\u0013F\u0003{]\u0012T\u001e5[\u0016\u0015\u00073[\u0014\u0015\u0007)_\n\u0015\u00134P\u000eT\u00195[\b\u0015\u00195X\u0015\u0019\u0012.JZV\u001f5J\u0013[\u0005>\u001e\bP\u00004L\u000e\u001b^u";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "S\u0013F\u0003{_\nEP-[\bF\u00194PZB\u0018>PZB\u0002:NZV\u001f5J\u001b\\\u001e>LZ\\\u001e=QVW\u0005/\u001e\u0019Z\u001e/W\u0014@\u0015{L\u001fE\u001f)JT\u001b^";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "K\u0013Q";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "N\u0016T\u0004=Q\bX";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "\u001e\u0013[\u0000.J)A\u0002>_\u0017\u0019P<W\fPP.NZG\u0015:ZZ\u0015J";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "X\u0013Y\u0015\u0004P\u001bX\u0015{W\t\u0015\u001e.R\u0016\u0015\\{Y\u0013C\u0015{K\n\u0015\u0002>_\u001e\u0015";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "]\u001b[W/\u001e\u0018@\u00197ZZ";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "\u001e\u0013FP5K\u0016Y\\{L\u001fA\u0005)PZ[\u00057R";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "]\u001b[W/\u001e\bP\u0011?\u001e";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "]\u001b[W/\u001e\u001f[\u00134Z\u0013[\u0017{";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "]\u001b[W/\u001e\u0015E\u00155\u001e";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "]\u0015[\u0004>F\u000e\u0015\u0019(\u001e\u0014@\u001c7\u001eV\u0015\u00172H\u001f\u0015\u0005+\u001e\bP\u0011?\u001e";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "\u001e\u0013[\u00044\u001e0F\u001f5q\u0018_\u00158JV\u0015\u00172H\u001f\u0015\u0005+\u001e\bP\u0011?\u001e@";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "\u0012ZR\u0019-[Z@\u0000{L\u001fT\u0014{\u0004";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "]\u0016P\u0011)l\u001fE\u001f)J6Z\u0017\u001dW\u0016PP,W\u000e]P:N\n^\u0015\"\u001e\u0019]\u00115Y\u001fQP";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "T\n@\u00033a\tA\u0011/a\u0019T\u00133[T_\u00034P";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "\u001e\u0017\\\u0003(\u001e\u000f\\\u0014w\u001e\u001dP\u001e>L\u001bA\u0015{L\u001fE\u001f)JZA\u001f0[\u0014\u0015\u0016:W\u0016P\u0014";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "X\u0013Y\u0015\u0004P\u001bX\u0015{W\t\u0015\u001e.R\u0016\u0015\\{Y\u0013C\u0015{K\n\u0015\u0003:H\u001f\u0015";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "]\u001b[W/\u001e\rG\u0019/[Z";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "]\u0015[\u0004>F\u000e\u0015\u0019(\u001e\u0014@\u001c7\u001eV\u0015\u00172H\u001f\u0015\u0005+\u001e\tT\u0006>\u001e";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = "\u001e\u0015@\u0004+K\u000ef\u0004)[\u001bX\\{Y\u0013C\u0015{K\n\u0015\u0003:H\u001f\u0015J";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "x\u0013Y\u0015+_\u000e]P>L\bZ\u0002{Q\u001c\u0015+";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        r2 = 50;
        r1 = "M\u001bC\u0015{R\u0015RP2PZB\u00022J\u001f}\u0019(J\u0015G\t\u0017Q\u001d";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x024a:
        r3[r2] = r1;
        r2 = 51;
        r1 = "M\u001bC\u0015{R\u0015RP2PZB\u00022J\u001f}\u0019(J\u0015G\t\u0017Q\u001d\u000fz";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0255:
        r3[r2] = r1;
        r2 = 52;
        r1 = "\u001eV\u0015\u00172H\u001f\u0015\u0005+\u001e\tT\u0006>\u001e@";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x0260:
        r3[r2] = r1;
        r2 = 53;
        r1 = "cZ\u0019P<W\fPP.NZF\u0011-[Z\u000f";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026b:
        r3[r2] = r1;
        r2 = 54;
        r1 = "\u001e\nT\u0002/M";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0276:
        r3[r2] = r1;
        r2 = 55;
        r1 = "R\u0015RP?W\f\\\u0014>ZZ\\\u001e/QZ";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0281:
        r3[r2] = r1;
        r2 = 56;
        r1 = "M\u000fV\u0013>M\t";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028c:
        r3[r2] = r1;
        r2 = 57;
        r1 = "\u0012\bP\u00004L\u000e\u0015";
        r0 = 56;
        r3 = r4;
        goto L_0x0009;
    L_0x0297:
        r3[r2] = r1;
        r2 = 58;
        r1 = "X\u001b\\\u001c>Z";
        r0 = 57;
        r3 = r4;
        goto L_0x0009;
    L_0x02a2:
        r3[r2] = r1;
        r2 = 59;
        r1 = "]\u0016P\u0011)v\u0013F\u00044J\u0003s\u00197[9Z\u001e/[\u0014AP>\u0004";
        r0 = 58;
        r3 = r4;
        goto L_0x0009;
    L_0x02ad:
        r3[r2] = r1;
        r2 = 60;
        r1 = "Z\u001fY\u0015/[ZS\u00197[ZF\u00058]\u001fF\u0003{X\u0013Y\u00155_\u0017PJ";
        r0 = 59;
        r3 = r4;
        goto L_0x0009;
    L_0x02b8:
        r3[r2] = r1;
        r2 = 61;
        r1 = "]\u0015[\u0004>F\u000e\u0015\u0019(\u001e\u0014@\u001c7\u001eV\u0015\u00172H\u001f\u0015\u0005+\u001e\tP\u001e?\u001e\u0016Z\u0017";
        r0 = 60;
        r3 = r4;
        goto L_0x0009;
    L_0x02c3:
        r3[r2] = r1;
        r2 = 62;
        r1 = "W\u000eP\u001d{W\t\u0015\u001e.R\u0016\u0015\\{Y\u0013C\u0015{K\n\u0015\u0003>P\u001e\u0015\u001c4Y";
        r0 = 61;
        r3 = r4;
        goto L_0x0009;
    L_0x02ce:
        r3[r2] = r1;
        r2 = 63;
        r1 = "V\u0013F\u00044L\u0003j\u00162R\u001f";
        r0 = 62;
        r3 = r4;
        goto L_0x0009;
    L_0x02d9:
        r3[r2] = r1;
        r2 = 64;
        r1 = "]\u000fG\u0002>P\u000ej\u0003>M\t\\\u001f5a\u001c\\\u001c>";
        r0 = 63;
        r3 = r4;
        goto L_0x0009;
    L_0x02e4:
        r3[r2] = r1;
        z = r4;
        r0 = cn.jiguang.b.d.o.class;
        r0 = r0.getSimpleName();
        b = r0;
        r0 = "";
        c = r0;
        r1 = "\u0011\f\u0004_)[\nZ\u0002/";
        r0 = -1;
    L_0x02f7:
        r1 = r1.toCharArray();
        r2 = r1.length;
        r3 = 0;
        r4 = 1;
        if (r2 > r4) goto L_0x0338;
    L_0x0300:
        r4 = r1;
        r5 = r3;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x0305:
        r7 = r2[r3];
        r6 = r5 % 5;
        switch(r6) {
            case 0: goto L_0x032a;
            case 1: goto L_0x032d;
            case 2: goto L_0x0330;
            case 3: goto L_0x0333;
            default: goto L_0x030c;
        };
    L_0x030c:
        r6 = 91;
    L_0x030e:
        r6 = r6 ^ r7;
        r6 = (char) r6;
        r2[r3] = r6;
        r3 = r5 + 1;
        if (r1 != 0) goto L_0x0336;
    L_0x0316:
        r2 = r4;
        r5 = r3;
        r3 = r1;
        goto L_0x0305;
    L_0x031a:
        r9 = 62;
        goto L_0x0020;
    L_0x031e:
        r9 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        goto L_0x0020;
    L_0x0322:
        r9 = 53;
        goto L_0x0020;
    L_0x0326:
        r9 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        goto L_0x0020;
    L_0x032a:
        r6 = 62;
        goto L_0x030e;
    L_0x032d:
        r6 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        goto L_0x030e;
    L_0x0330:
        r6 = 53;
        goto L_0x030e;
    L_0x0333:
        r6 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        goto L_0x030e;
    L_0x0336:
        r2 = r1;
        r1 = r4;
    L_0x0338:
        if (r2 > r3) goto L_0x0300;
    L_0x033a:
        r2 = new java.lang.String;
        r2.<init>(r1);
        r1 = r2.intern();
        switch(r0) {
            case 0: goto L_0x034c;
            default: goto L_0x0346;
        };
    L_0x0346:
        d = r1;
        r1 = "\u0011\f\u0007_)[\nZ\u0002/";
        r0 = 0;
        goto L_0x02f7;
    L_0x034c:
        e = r1;
        r0 = new java.lang.StringBuilder;
        r1 = z;
        r2 = 8;
        r1 = r1[r2];
        r0.<init>(r1);
        r1 = d;
        r0 = r0.append(r1);
        r0 = r0.toString();
        f = r0;
        r0 = java.util.concurrent.Executors.newSingleThreadExecutor();
        g = r0;
        r0 = 0;
        a = r0;
        r0 = new java.lang.Object;
        r0.<init>();
        h = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.o.<clinit>():void");
    }

    public static String a() {
        long e = d.e(null);
        if (e == 0) {
            cn.jiguang.c.d.c(b, z[44]);
            return null;
        }
        String b = a.b(e + a.b(d.g(null)));
        return !j.a(b) ? e + ":" + b : null;
    }

    public static String a(int i) {
        try {
            InetAddress.getByName(z[8]);
            return new StringBuilder(z[7]).append(z[8]).append(e).toString();
        } catch (Throwable e) {
            cn.jiguang.c.d.c(b, z[6], e);
            return b();
        }
    }

    public static String a(String str) {
        if (j.a(str)) {
            cn.jiguang.c.d.g(b, z[19]);
            return "";
        }
        if (!str.startsWith(z[20])) {
            str = new StringBuilder(z[20]).append(str).toString();
        }
        if (!str.endsWith(e)) {
            str = str + e;
        }
        c = str;
        cn.jiguang.c.d.a(b, new StringBuilder(z[18]).append(c).toString());
        return c;
    }

    public static String a(String str, int i) {
        if (j.a(str)) {
            cn.jiguang.c.d.c(b, z[17]);
            return null;
        }
        String e = e(str);
        long e2 = d.e(null);
        if (e2 == 0) {
            cn.jiguang.c.d.c(b, z[16]);
            return null;
        }
        e = a.b(e2 + a.b(d.g(null)) + e);
        return !j.a(e) ? e2 + ":" + e : null;
    }

    private static ArrayList<JSONArray> a(JSONArray jSONArray, int i) {
        Exception exception;
        JSONArray jSONArray2;
        int i2;
        Exception exception2;
        int i3;
        JSONArray jSONArray3;
        ArrayList<JSONArray> arrayList = new ArrayList();
        JSONArray jSONArray4 = new JSONArray();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length() - 1;
            int i4 = 0;
            int i5 = 0;
            while (length >= 0) {
                int i6;
                JSONObject optJSONObject = jSONArray.optJSONObject(length);
                if (optJSONObject != null) {
                    try {
                        int length2 = optJSONObject.toString().getBytes(z[0]).length;
                        i6 = i5 + length2;
                        if (i6 > 204800) {
                            try {
                                jSONArray4.put(optJSONObject);
                                arrayList.add(jSONArray4);
                                return arrayList;
                            } catch (Exception e) {
                                exception = e;
                                jSONArray2 = jSONArray4;
                                i2 = i6;
                                i6 = i4;
                            }
                        } else if (i4 + length2 > 40960) {
                            try {
                                arrayList.add(jSONArray4);
                                jSONArray2 = new JSONArray();
                            } catch (Exception e2) {
                                exception2 = e2;
                                jSONArray2 = jSONArray4;
                                i2 = i6;
                                i6 = length2;
                                exception = exception2;
                                cn.jiguang.c.d.i(b, exception.getMessage());
                                length--;
                                i4 = i6;
                                i3 = i2;
                                jSONArray4 = jSONArray2;
                                i5 = i3;
                            }
                            try {
                                jSONArray2.put(optJSONObject);
                                i2 = i6;
                                i6 = length2;
                            } catch (Exception e3) {
                                exception2 = e3;
                                i2 = i6;
                                i6 = length2;
                                exception = exception2;
                                cn.jiguang.c.d.i(b, exception.getMessage());
                                length--;
                                i4 = i6;
                                i3 = i2;
                                jSONArray4 = jSONArray2;
                                i5 = i3;
                            }
                        } else {
                            i5 = i4 + length2;
                            try {
                                jSONArray4.put(optJSONObject);
                                jSONArray3 = jSONArray4;
                                i2 = i6;
                                i6 = i5;
                                jSONArray2 = jSONArray3;
                            } catch (Exception e4) {
                                exception = e4;
                                jSONArray3 = jSONArray4;
                                i2 = i6;
                                i6 = i5;
                                jSONArray2 = jSONArray3;
                                cn.jiguang.c.d.i(b, exception.getMessage());
                                length--;
                                i4 = i6;
                                i3 = i2;
                                jSONArray4 = jSONArray2;
                                i5 = i3;
                            }
                        }
                    } catch (Exception e5) {
                        exception = e5;
                        i6 = i4;
                        i3 = i5;
                        jSONArray2 = jSONArray4;
                        i2 = i3;
                        cn.jiguang.c.d.i(b, exception.getMessage());
                        length--;
                        i4 = i6;
                        i3 = i2;
                        jSONArray4 = jSONArray2;
                        i5 = i3;
                    }
                } else {
                    i6 = i4;
                    i3 = i5;
                    jSONArray2 = jSONArray4;
                    i2 = i3;
                }
                length--;
                i4 = i6;
                i3 = i2;
                jSONArray4 = jSONArray2;
                i5 = i3;
            }
            if (jSONArray4.length() > 0) {
                arrayList.add(jSONArray4);
            }
        }
        return arrayList;
    }

    public static JSONObject a(Context context, String str) {
        FileNotFoundException e;
        Throwable th;
        IOException e2;
        if (str == null || str.length() <= 0) {
            cn.jiguang.c.d.c(b, z[33]);
            return null;
        }
        String f = f(str);
        if (context == null) {
            cn.jiguang.c.d.c(b, new StringBuilder(z[39]).append(f).toString());
            return null;
        }
        Closeable openFileInput;
        try {
            openFileInput = context.openFileInput(str);
            try {
                byte[] bArr = new byte[(openFileInput.available() + 1)];
                openFileInput.read(bArr);
                a(openFileInput);
                try {
                    String str2 = new String(bArr, z[0]);
                    if (!j.a(str2)) {
                        return new JSONObject(str2);
                    }
                    cn.jiguang.c.d.c(b, f + z[35]);
                    return null;
                } catch (UnsupportedEncodingException e3) {
                    cn.jiguang.c.d.c(b, new StringBuilder(z[37]).append(f).append(z[41]).append(e3.getMessage()).toString());
                    return null;
                } catch (JSONException e4) {
                    cn.jiguang.c.d.c(b, new StringBuilder(z[34]).append(f).append(z[40]).append(e4.getMessage()).toString());
                    return null;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                try {
                    cn.jiguang.c.d.c(b, new StringBuilder(z[38]).append(f).append(z[32]).append(e.getMessage()).toString());
                    a(openFileInput);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    a(openFileInput);
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                cn.jiguang.c.d.c(b, new StringBuilder(z[36]).append(f).append(z[41]).append(e2.getMessage()).toString());
                a(openFileInput);
                return null;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            openFileInput = null;
            cn.jiguang.c.d.c(b, new StringBuilder(z[38]).append(f).append(z[32]).append(e.getMessage()).toString());
            a(openFileInput);
            return null;
        } catch (IOException e8) {
            e2 = e8;
            openFileInput = null;
            cn.jiguang.c.d.c(b, new StringBuilder(z[36]).append(f).append(z[41]).append(e2.getMessage()).toString());
            a(openFileInput);
            return null;
        } catch (Throwable th3) {
            openFileInput = null;
            th = th3;
            a(openFileInput);
            throw th;
        }
    }

    public static void a(Context context) {
        cn.jiguang.c.d.c(b, z[42]);
        a(context, z[43], null);
        b(context);
        a(context, z[3], null);
    }

    public static void a(Context context, int i) {
        int i2 = 0;
        if (a != null) {
            JSONObject jSONObject = a;
            if (i >= 204800) {
                b(context);
                return;
            }
            int length;
            try {
                length = jSONObject.toString().getBytes(z[5]).length;
            } catch (UnsupportedEncodingException e) {
                length = 0;
            }
            int i3 = (length + i) - 204800;
            if (i3 > 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray(z[4]);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    try {
                        JSONObject jSONObject2;
                        JSONArray jSONArray = new JSONArray();
                        for (length = 0; length < optJSONArray.length(); length++) {
                            JSONObject jSONObject3 = optJSONArray.getJSONObject(length);
                            if (jSONObject3 != null) {
                                if (i2 >= i3) {
                                    jSONArray.put(jSONObject3);
                                }
                                i2 += jSONObject3.toString().getBytes(z[5]).length;
                            }
                        }
                        if (jSONArray.length() > 0) {
                            jSONObject.put(z[4], jSONArray);
                            jSONObject2 = jSONObject;
                        } else {
                            jSONObject2 = null;
                        }
                        a = jSONObject2;
                        a(context, z[3], jSONObject2);
                    } catch (JSONException e2) {
                    } catch (UnsupportedEncodingException e3) {
                    }
                }
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray) {
        a(context, jSONArray, "");
    }

    public static void a(Context context, JSONArray jSONArray, p pVar) {
        int i = -1;
        cn.jiguang.c.d.a(b, z[13]);
        JSONObject jSONObject = new JSONObject();
        if (context == null || jSONArray == null || jSONArray.length() <= 0) {
            cn.jiguang.c.d.g(b, new StringBuilder(z[10]).append(context).append(z[12]).append(jSONArray).toString());
            if (pVar != null) {
                pVar.a(-1);
                return;
            }
            return;
        }
        try {
            cn.jiguang.c.d.c(b, new StringBuilder(z[14]).append(jSONArray.toString().getBytes(z[5]).length).toString());
        } catch (UnsupportedEncodingException e) {
        }
        try {
            jSONObject.put(z[4], jSONArray);
            try {
                if (a(jSONObject, context)) {
                    try {
                        cn.jiguang.c.d.e(b, new StringBuilder(z[11]).append(jSONObject.toString(1)).toString());
                    } catch (JSONException e2) {
                        cn.jiguang.c.d.e(b, new StringBuilder(z[11]).append(jSONObject.toString()).toString());
                    }
                    int a = l.a(context, jSONObject, true);
                    if (pVar != null) {
                        if (a == 200) {
                            i = 0;
                        }
                        pVar.a(i);
                    }
                } else if (pVar != null) {
                    pVar.a(-1);
                }
            } catch (Exception e3) {
                cn.jiguang.c.d.c(b, new StringBuilder(z[9]).append(e3).toString());
                if (pVar != null) {
                    pVar.a(-1);
                }
            }
        } catch (JSONException e4) {
            cn.jiguang.c.d.c(b, new StringBuilder(z[15]).append(e4).toString());
            if (pVar != null) {
                pVar.a(-1);
            }
        }
    }

    public static void a(Context context, JSONArray jSONArray, String str) {
        if (context == null) {
            cn.jiguang.c.d.c(b, z[61]);
        } else if (jSONArray == null || jSONArray.length() <= 0) {
            cn.jiguang.c.d.c(b, z[62]);
        } else {
            g.execute(new q(context, jSONArray, str));
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        a(context, new JSONArray().put(jSONObject), "");
    }

    public static void a(Context context, JSONObject jSONObject, String str) {
        a(context, new JSONArray().put(jSONObject), str);
    }

    private static void a(Context context, JSONObject jSONObject, ArrayList<JSONArray> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList.size() <= 0) {
            b(context);
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                JSONArray jSONArray2 = (JSONArray) arrayList.get(i);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    if (jSONArray2.optJSONObject(i2) != null) {
                        jSONArray.put(jSONArray2.optJSONObject(i2));
                    }
                }
            }
        }
        try {
            jSONObject.put(z[4], jSONArray);
        } catch (JSONException e) {
        }
        a = jSONObject;
        a(context, z[3], jSONObject);
    }

    private static void a(Context context, JSONObject jSONObject, JSONArray jSONArray, ArrayList<JSONArray> arrayList) {
        if (arrayList.size() == 1) {
            b(context);
        } else if (jSONArray != null && arrayList.size() > 1) {
            arrayList.remove(jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                JSONArray jSONArray3 = (JSONArray) arrayList.get(i);
                for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                    if (jSONArray3.optJSONObject(i2) != null) {
                        jSONArray2.put(jSONArray3.optJSONObject(i2));
                    }
                }
            }
            try {
                jSONObject.put(z[4], jSONArray2);
            } catch (JSONException e) {
            }
            a = jSONObject;
            a(context, z[3], jSONObject);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r9, java.lang.String r10, org.json.JSONObject r11) {
        /*
        r2 = 1;
        r1 = 0;
        r0 = cn.jiguang.e.j.a(r10);
        if (r0 == 0) goto L_0x0015;
    L_0x0008:
        r0 = b;
        r2 = z;
        r3 = 45;
        r2 = r2[r3];
        cn.jiguang.c.d.c(r0, r2);
        r0 = r1;
    L_0x0014:
        return r0;
    L_0x0015:
        r4 = f(r10);
        if (r9 != 0) goto L_0x0035;
    L_0x001b:
        r0 = b;
        r2 = new java.lang.StringBuilder;
        r3 = z;
        r5 = 47;
        r3 = r3[r5];
        r2.<init>(r3);
        r2 = r2.append(r4);
        r2 = r2.toString();
        cn.jiguang.c.d.c(r0, r2);
        r0 = r1;
        goto L_0x0014;
    L_0x0035:
        r5 = h;
        monitor-enter(r5);
        r0 = "";
        if (r11 == 0) goto L_0x0068;
    L_0x003c:
        r0 = r11.toString();	 Catch:{ all -> 0x008d }
        r3 = z;	 Catch:{ all -> 0x008d }
        r6 = 3;
        r3 = r3[r6];	 Catch:{ all -> 0x008d }
        r3 = r10.equals(r3);	 Catch:{ all -> 0x008d }
        if (r3 == 0) goto L_0x0068;
    L_0x004b:
        r3 = b;	 Catch:{ Exception -> 0x0080 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0080 }
        r7 = z;	 Catch:{ Exception -> 0x0080 }
        r8 = 51;
        r7 = r7[r8];	 Catch:{ Exception -> 0x0080 }
        r6.<init>(r7);	 Catch:{ Exception -> 0x0080 }
        r7 = 1;
        r7 = r11.toString(r7);	 Catch:{ Exception -> 0x0080 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0080 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0080 }
        cn.jiguang.c.d.a(r3, r6);	 Catch:{ Exception -> 0x0080 }
    L_0x0068:
        r3 = 0;
        r6 = 0;
        r3 = r9.openFileOutput(r10, r6);	 Catch:{ FileNotFoundException -> 0x0090, UnsupportedEncodingException -> 0x00c3, IOException -> 0x00f5, NullPointerException -> 0x0127 }
        r6 = z;	 Catch:{ FileNotFoundException -> 0x0161, UnsupportedEncodingException -> 0x00c3, IOException -> 0x00f5, NullPointerException -> 0x0127 }
        r7 = 0;
        r6 = r6[r7];	 Catch:{ FileNotFoundException -> 0x0161, UnsupportedEncodingException -> 0x00c3, IOException -> 0x00f5, NullPointerException -> 0x0127 }
        r0 = r0.getBytes(r6);	 Catch:{ FileNotFoundException -> 0x0161, UnsupportedEncodingException -> 0x00c3, IOException -> 0x00f5, NullPointerException -> 0x0127 }
        r3.write(r0);	 Catch:{ FileNotFoundException -> 0x0161, UnsupportedEncodingException -> 0x00c3, IOException -> 0x00f5, NullPointerException -> 0x0127 }
        a(r3);	 Catch:{ all -> 0x008d }
        monitor-exit(r5);	 Catch:{ all -> 0x008d }
        r0 = r2;
        goto L_0x0014;
    L_0x0080:
        r3 = move-exception;
        r6 = b;	 Catch:{ all -> 0x008d }
        r7 = z;	 Catch:{ all -> 0x008d }
        r8 = 50;
        r7 = r7[r8];	 Catch:{ all -> 0x008d }
        cn.jiguang.c.d.c(r6, r7, r3);	 Catch:{ all -> 0x008d }
        goto L_0x0068;
    L_0x008d:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x008d }
        throw r0;
    L_0x0090:
        r0 = move-exception;
        r2 = r3;
    L_0x0092:
        r3 = b;	 Catch:{ all -> 0x015e }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x015e }
        r7 = z;	 Catch:{ all -> 0x015e }
        r8 = 38;
        r7 = r7[r8];	 Catch:{ all -> 0x015e }
        r6.<init>(r7);	 Catch:{ all -> 0x015e }
        r4 = r6.append(r4);	 Catch:{ all -> 0x015e }
        r6 = z;	 Catch:{ all -> 0x015e }
        r7 = 48;
        r6 = r6[r7];	 Catch:{ all -> 0x015e }
        r4 = r4.append(r6);	 Catch:{ all -> 0x015e }
        r0 = r0.getMessage();	 Catch:{ all -> 0x015e }
        r0 = r4.append(r0);	 Catch:{ all -> 0x015e }
        r0 = r0.toString();	 Catch:{ all -> 0x015e }
        cn.jiguang.c.d.c(r3, r0);	 Catch:{ all -> 0x015e }
        a(r2);	 Catch:{ all -> 0x008d }
        monitor-exit(r5);	 Catch:{ all -> 0x008d }
        r0 = r1;
        goto L_0x0014;
    L_0x00c3:
        r0 = move-exception;
        r2 = b;	 Catch:{ all -> 0x0159 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0159 }
        r7 = z;	 Catch:{ all -> 0x0159 }
        r8 = 37;
        r7 = r7[r8];	 Catch:{ all -> 0x0159 }
        r6.<init>(r7);	 Catch:{ all -> 0x0159 }
        r4 = r6.append(r4);	 Catch:{ all -> 0x0159 }
        r6 = z;	 Catch:{ all -> 0x0159 }
        r7 = 52;
        r6 = r6[r7];	 Catch:{ all -> 0x0159 }
        r4 = r4.append(r6);	 Catch:{ all -> 0x0159 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0159 }
        r0 = r4.append(r0);	 Catch:{ all -> 0x0159 }
        r0 = r0.toString();	 Catch:{ all -> 0x0159 }
        cn.jiguang.c.d.c(r2, r0);	 Catch:{ all -> 0x0159 }
        a(r3);	 Catch:{ all -> 0x008d }
        monitor-exit(r5);	 Catch:{ all -> 0x008d }
        r0 = r1;
        goto L_0x0014;
    L_0x00f5:
        r0 = move-exception;
        r2 = b;	 Catch:{ all -> 0x0159 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0159 }
        r7 = z;	 Catch:{ all -> 0x0159 }
        r8 = 46;
        r7 = r7[r8];	 Catch:{ all -> 0x0159 }
        r6.<init>(r7);	 Catch:{ all -> 0x0159 }
        r4 = r6.append(r4);	 Catch:{ all -> 0x0159 }
        r6 = z;	 Catch:{ all -> 0x0159 }
        r7 = 52;
        r6 = r6[r7];	 Catch:{ all -> 0x0159 }
        r4 = r4.append(r6);	 Catch:{ all -> 0x0159 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0159 }
        r0 = r4.append(r0);	 Catch:{ all -> 0x0159 }
        r0 = r0.toString();	 Catch:{ all -> 0x0159 }
        cn.jiguang.c.d.c(r2, r0);	 Catch:{ all -> 0x0159 }
        a(r3);	 Catch:{ all -> 0x008d }
        monitor-exit(r5);	 Catch:{ all -> 0x008d }
        r0 = r1;
        goto L_0x0014;
    L_0x0127:
        r0 = move-exception;
        r2 = b;	 Catch:{ all -> 0x0159 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0159 }
        r7 = z;	 Catch:{ all -> 0x0159 }
        r8 = 49;
        r7 = r7[r8];	 Catch:{ all -> 0x0159 }
        r6.<init>(r7);	 Catch:{ all -> 0x0159 }
        r4 = r6.append(r4);	 Catch:{ all -> 0x0159 }
        r6 = z;	 Catch:{ all -> 0x0159 }
        r7 = 53;
        r6 = r6[r7];	 Catch:{ all -> 0x0159 }
        r4 = r4.append(r6);	 Catch:{ all -> 0x0159 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0159 }
        r0 = r4.append(r0);	 Catch:{ all -> 0x0159 }
        r0 = r0.toString();	 Catch:{ all -> 0x0159 }
        cn.jiguang.c.d.c(r2, r0);	 Catch:{ all -> 0x0159 }
        a(r3);	 Catch:{ all -> 0x008d }
        monitor-exit(r5);	 Catch:{ all -> 0x008d }
        r0 = r1;
        goto L_0x0014;
    L_0x0159:
        r0 = move-exception;
    L_0x015a:
        a(r3);	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x015e:
        r0 = move-exception;
        r3 = r2;
        goto L_0x015a;
    L_0x0161:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.o.a(android.content.Context, java.lang.String, org.json.JSONObject):boolean");
    }

    private static boolean a(JSONObject jSONObject, Context context) {
        jSONObject.put(z[31], "a");
        long e = d.e(context);
        if (e == 0) {
            cn.jiguang.c.d.i(b, z[22]);
            return false;
        }
        jSONObject.put(z[30], e);
        String k = a.k(context);
        if (j.a(k)) {
            cn.jiguang.c.d.i(b, z[25]);
            return false;
        }
        jSONObject.put(z[21], k);
        b.a().a(jSONObject);
        jSONObject.put(z[27], z[24]);
        String d = cn.jiguang.b.a.a.d("");
        if (j.a(d)) {
            cn.jiguang.c.d.h(b, z[28]);
        } else {
            jSONObject.put(z[26], d);
        }
        if (j.a(cn.jiguang.b.a.h)) {
            cn.jiguang.c.d.h(b, z[29]);
        } else {
            jSONObject.put(z[23], cn.jiguang.b.a.h);
        }
        return true;
    }

    private static String b() {
        if (j.a(c)) {
            a(d.c());
        }
        return c;
    }

    private static void b(Context context) {
        a = null;
        if (!a(context, z[3], null)) {
            try {
                if (context.deleteFile(f(z[3]))) {
                    cn.jiguang.c.d.i(b, new StringBuilder(z[60]).append(f(z[3])).toString());
                }
            } catch (IllegalArgumentException e) {
                cn.jiguang.c.d.i(b, new StringBuilder(z[59]).append(e.getMessage()).toString());
            } catch (Exception e2) {
                cn.jiguang.c.d.i(b, new StringBuilder(z[59]).append(e2.getMessage()).toString());
            }
        }
    }

    static /* synthetic */ void b(Context context, JSONArray jSONArray, String str) {
        int i = 0;
        String str2 = z[3];
        if (a == null) {
            a = a(context, str2);
        }
        JSONObject jSONObject = a;
        JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
        JSONArray optJSONArray = jSONObject2.optJSONArray(z[4]);
        JSONArray jSONArray2 = optJSONArray == null ? new JSONArray() : optJSONArray;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        jSONArray2.put(jSONArray.get(i2));
                    }
                }
            } catch (JSONException e) {
            }
        }
        if (!a.b(context)) {
            jSONObject2.put(z[4], jSONArray2);
            a(context, z[3], jSONObject2);
            return;
        }
        if (jSONArray2.length() > 0) {
            ArrayList a = a(jSONArray2, 40960);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a);
            try {
                cn.jiguang.c.d.c(b, new StringBuilder(z[14]).append(jSONArray2.toString().getBytes(z[5]).length).toString());
            } catch (UnsupportedEncodingException e2) {
            }
            cn.jiguang.c.d.c(b, new StringBuilder(z[55]).append(a.size()).append(z[54]).toString());
            int i3 = 0;
            while (i < a.size()) {
                optJSONArray = (JSONArray) a.get(i);
                if (i3 == 0) {
                    if (optJSONArray.length() <= 0) {
                        arrayList.remove(optJSONArray);
                    } else {
                        try {
                            jSONObject2.put(z[4], optJSONArray);
                            try {
                                if (a(jSONObject2, context)) {
                                    if (jSONObject2 != null) {
                                        try {
                                            cn.jiguang.c.d.e(b, new StringBuilder(z[11]).append(jSONObject2.toString(1)).toString());
                                        } catch (JSONException e3) {
                                            cn.jiguang.c.d.e(b, new StringBuilder(z[11]).append(jSONObject2.toString()).toString());
                                        }
                                    }
                                    int a2 = l.a(context, jSONObject2, true);
                                    if (!TextUtils.isEmpty(str) && str.equals(SdkType.JANALYTICS.name())) {
                                        cn.jiguang.c.d.d(b, str + z[57] + (a2 == 200 ? z[56] : z[58]));
                                    }
                                    switch (a2) {
                                        case -5:
                                        case -4:
                                        case -3:
                                        case -2:
                                            a(context, jSONObject2, optJSONArray, arrayList);
                                            break;
                                        case -1:
                                        case 404:
                                        case 429:
                                        case 500:
                                            a(context, jSONObject2, arrayList);
                                            break;
                                        case 200:
                                            a(context, jSONObject2, optJSONArray, arrayList);
                                            break;
                                        case 401:
                                            b(context);
                                            boolean z = true;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                b(context, jSONObject2);
                                return;
                            } catch (Exception e4) {
                                cn.jiguang.c.d.c(b, new StringBuilder(z[9]).append(e4).toString());
                                b(context, jSONObject2);
                                return;
                            }
                        } catch (JSONException e5) {
                            cn.jiguang.c.d.c(b, new StringBuilder(z[15]).append(e5).toString());
                            a(context, jSONObject2, optJSONArray, arrayList);
                        }
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static void b(Context context, JSONObject jSONObject) {
        a = jSONObject;
        a(context, z[3], jSONObject);
    }

    public static boolean b(String str) {
        c = b();
        return (j.a(str) || j.a(c)) ? false : str.equals(c);
    }

    public static String c(String str) {
        try {
            InetAddress.getByName(z[8]);
            return new StringBuilder(z[7]).append(z[8]).append(str).toString();
        } catch (Exception e) {
            return b();
        }
    }

    public static String d(String str) {
        String str2 = null;
        try {
            str2 = Base64.encodeToString(str.getBytes(), 10);
        } catch (Exception e) {
            cn.jiguang.c.d.i(z[2], z[1]);
        }
        return str2;
    }

    private static String e(String str) {
        String str2 = null;
        try {
            byte[] bytes = str.getBytes(z[0]);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
            bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            str2 = a.a(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    private static String f(String str) {
        if (!j.a(str)) {
            return str.equals(z[3]) ? z[63] : z[64];
        } else {
            cn.jiguang.c.d.c(b, z[45]);
            return null;
        }
    }
}
