package cn.jiguang.a.a.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import cn.jiguang.a.c.c;
import cn.jiguang.api.BasePreferenceManager;
import cn.jiguang.b.d.o;
import cn.jiguang.c.d;
import cn.jiguang.e.a;
import cn.jiguang.e.f;
import cn.jiguang.e.j;
import cn.jiguang.net.HttpUtils;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends Thread {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static Object b = new Object();
    private static AtomicInteger c = new AtomicInteger();
    private static CookieManager j;
    private static final String[] z;
    private String d;
    private String e;
    private String f;
    private Context g;
    private int h = 0;
    private String i;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "x`\u0012[;Dj\r\u001f\u001d";
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
            case 0: goto L_0x0586;
            case 1: goto L_0x058a;
            case 2: goto L_0x058d;
            case 3: goto L_0x0591;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
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
            case 64: goto L_0x02ef;
            case 65: goto L_0x02fa;
            case 66: goto L_0x0305;
            case 67: goto L_0x0310;
            case 68: goto L_0x031b;
            case 69: goto L_0x0326;
            case 70: goto L_0x0331;
            case 71: goto L_0x033c;
            case 72: goto L_0x0347;
            case 73: goto L_0x0352;
            case 74: goto L_0x035d;
            case 75: goto L_0x0368;
            case 76: goto L_0x0373;
            case 77: goto L_0x037e;
            case 78: goto L_0x0389;
            case 79: goto L_0x0394;
            case 80: goto L_0x039f;
            case 81: goto L_0x03aa;
            case 82: goto L_0x03b5;
            case 83: goto L_0x03c0;
            case 84: goto L_0x03cb;
            case 85: goto L_0x03d6;
            case 86: goto L_0x03e1;
            case 87: goto L_0x03ec;
            case 88: goto L_0x03f7;
            case 89: goto L_0x0402;
            case 90: goto L_0x040d;
            case 91: goto L_0x0418;
            case 92: goto L_0x0423;
            case 93: goto L_0x042e;
            case 94: goto L_0x0439;
            case 95: goto L_0x0444;
            case 96: goto L_0x044f;
            case 97: goto L_0x045a;
            case 98: goto L_0x0465;
            case 99: goto L_0x0470;
            case 100: goto L_0x047b;
            case 101: goto L_0x0486;
            case 102: goto L_0x0491;
            case 103: goto L_0x049c;
            case 104: goto L_0x04a7;
            case 105: goto L_0x04b2;
            case 106: goto L_0x04bd;
            case 107: goto L_0x04c8;
            case 108: goto L_0x04d3;
            case 109: goto L_0x04de;
            case 110: goto L_0x04e9;
            case 111: goto L_0x04f4;
            case 112: goto L_0x04ff;
            case 113: goto L_0x050a;
            case 114: goto L_0x0515;
            case 115: goto L_0x0520;
            case 116: goto L_0x052b;
            case 117: goto L_0x0536;
            case 118: goto L_0x0541;
            case 119: goto L_0x054c;
            case 120: goto L_0x0557;
            case 121: goto L_0x0562;
            case 122: goto L_0x056d;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "{m\t\u0018\u001dep\u000b\u0014\u001dYP\u0012\u001f\u0014";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "Fj\u0014\u0013X_m\u0007\u0018XDk\u0003V\u0014Dd\u0002V\bCj\b\u0013\u0016^h\u0004\u0013\n\u000bq\u000e\u0004\u001dJaF\u001f\u000b\u000bw\u0013\u0018\u0016Bk\u0001";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "jf\u0012\u001f\u0017E%KV\u0014Dd\u0002&\u0010Dk\u00038\rFg\u0003\u0004";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "Xl\u0001\u0018B";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "_w\u0003\u00135Ju0\u0017\u0014^`\\";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "_w\u0003\u00135JuF\u001f\u000b\u000bk\u0013\u001a\u0014";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "Ju\u0016%\u001dHw\u0003\u0002B";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "Hj\b\u0002\u001dSqF\u001f\u000b\u000bk\u0013\u001a\u0014";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "Y`\u0012L";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "Bq\u000f\u001b\u001d";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "Bh\u0015\u001f";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "Ep\u000b\u0014\u001dYZ\b\u0003\u0015";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "Nk%\u0004\b_|%\u0019\u0016_`\b\u0002B";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "Hj\b\u0002\u001dEq";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "Bf\u0005\u001f\u001c";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "jf\u0012\u0019\u0016\u000b(F\u0019\u0016o`\u0012\u0015\u0010{m\t\u0018\u001dep\u000b\u0014\u001dY%\u0016\u001e\u0017E`(\u0003\u0015I`\u0014L";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "^k\u0003\u000e\u001bNu\u0012\u001f\u0017E";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "Y`\u0016\u0004\u0017_%\u0005\u0019\u0016_`\b\u0002B";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "Eg";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "Ep\u000b";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "_|\u0016\u0013";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "Bh\u0003\u001f";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "Ep\u000b\u0014\u001dYZ\u0010\u0013\nXl\t\u0018";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "~Q [@";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "\u001a+UXH";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "Ju\u0016)\u0011O";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "Y`\u0015\u0006VQl\u0016";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "\u000bw\u0015\u0006<Jq\u0007L";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "]`\u0014\u0005\u0011Dk";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "\u000bv\u0012\u0017\f^v%\u0019\u001cN?";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "Xl\u0001\u0018";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "Y`\u0017)\fBh\u0003";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "^w\nL";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "Hj\u0002\u0013";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "\u000bl\u000b\u0005\u0011\u0011";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "\u000bl\u0005\u0015\u0011O?";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "Xq\u0007\u0002\u0011Xq\u000f\u0015WZp\u0003\u0004\u0001\u0014";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "jf\u0012\u001f\u0017E%KV\u001fNq6\u001e\u0017E`(\u0003\u0015I`\u0014V\u0011F`\u000fL";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "Ep\u000b\u0014\u001dYZ\u0007\u0006\bBa";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "Y`\u0015\u0006VYd\u0011";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "jf\u0012\u001f\u0017E%KV\u001fNq6\u001e\u0017E`(\u0003\u0015I`\u0014!\u0011_m'\u0018\u0019G|\u0015\u001f\u000b~w\nV\rYi\\";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "Y`\u0015\u0006'Od\u0012\u0017";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "^w\nV\u0011X%\u0003\u001b\b_|";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "Xd\u0010\u0013XGj\u0001V\u0011E%\u0011\u0004\u0011_`.\u001f\u000b_j\u0014\u000f4Db";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "&\u000fk|";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "Hd\bQ\f\u000br\u0014\u001f\fN%";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "\u0011%";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = "\u0007%";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "ml\n\u0013\bJq\u000eV\u001dYw\t\u0004XDcF-";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        r2 = 50;
        r1 = "Hd\bQ\f\u000b`\b\u0015\u0017Ol\b\u0011X";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x024a:
        r3[r2] = r1;
        r2 = 51;
        r1 = "\u000b)F\u0011\u0011]`F\u0003\b\u000bv\u0007\u0000\u001d\u000b?";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0255:
        r3[r2] = r1;
        r2 = 52;
        r1 = "v%JV\u001fBs\u0003V\r[%\u0015\u0017\u000eN%\\";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x0260:
        r3[r2] = r1;
        r2 = 53;
        r1 = "Hd\bQ\f\u000bj\u0016\u0013\u0016\u000b";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026b:
        r3[r2] = r1;
        r2 = 54;
        r1 = "Xd\u0010\u0013XGj\u0001V\u0011E%\u0011\u0004\u0011_`.\u001f\u000b_j\u0014\u000f4Db\\|";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0276:
        r3[r2] = r1;
        r2 = 55;
        r1 = "Hj\b\u0002\u001dSqF\u0012\u0011O%\b\u0019\f\u000bl\b\u001f\f\u0007%\u0014\u0013\f^w\b";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0281:
        r3[r2] = r1;
        r2 = 56;
        r1 = "\u000bj\u0013\u0002\b^q5\u0002\nNd\u000bZXLl\u0010\u0013X^uF\u0005\u0019]`FL";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028c:
        r3[r2] = r1;
        r2 = 57;
        r1 = "dq\u000e\u0013\n\u000br\u0014\u0019\u0016L%\u0014\u0013\u000b[j\b\u0005\u001d\u000bv\u0012\u0017\f^vF[X";
        r0 = 56;
        r3 = r4;
        goto L_0x0009;
    L_0x0297:
        r3[r2] = r1;
        r2 = 58;
        r1 = "y`\u0017\u0003\u001dXqF\u0006\u0019_mF\u0012\u0017NvF\u0018\u0017_%\u0003\u000e\u0011Xq\\VL\u001b1F[X";
        r0 = 57;
        r3 = r4;
        goto L_0x0009;
    L_0x02a2:
        r3[r2] = r1;
        r2 = 59;
        r1 = "^w\n\u0005B";
        r0 = 58;
        r3 = r4;
        goto L_0x0009;
    L_0x02ad:
        r3[r2] = r1;
        r2 = 60;
        r1 = "\u0010g\t\u0003\u0016Od\u0014\u000fE";
        r0 = 59;
        r3 = r4;
        goto L_0x0009;
    L_0x02b8:
        r3[r2] = r1;
        r2 = 61;
        r1 = "hj\t\u001d\u0011N";
        r0 = 60;
        r3 = r4;
        goto L_0x0009;
    L_0x02c3:
        r3[r2] = r1;
        r2 = 62;
        r1 = "X`\u0014\u0000\u001dY%\u0000\u0017\u0011G";
        r0 = 61;
        r3 = r4;
        goto L_0x0009;
    L_0x02ce:
        r3[r2] = r1;
        r2 = 63;
        r1 = "[d\u0014\u0005\u001d\u000b`\b\u0002\u0011_|F\u0013\nYj\u0014";
        r0 = 62;
        r3 = r4;
        goto L_0x0009;
    L_0x02d9:
        r3[r2] = r1;
        r2 = 64;
        r1 = "fj\u001c\u001f\u0014GdICV\u001b%N:\u0011Ep\u001eMXjk\u0002\u0004\u0017BaFCV\u001a+WMXe`\u001e\u0003\u000b\u000b3F4\rBi\u0002Y4r_TN=\u0002%'\u0006\bG`1\u0013\u001a`l\u0012YM\u00182HEN\u000b-->,fIJV\u0014Bn\u0003V?Nf\r\u0019Q\u000bF\u000e\u0004\u0017F`IB@\u00055HDM\u001d1HDK\u000bH\t\u0014\u0011G`F%\u0019Md\u0014\u001fW\u001e6QXK\u001d";
        r0 = 63;
        r3 = r4;
        goto L_0x0009;
    L_0x02e4:
        r3[r2] = r1;
        r2 = 65;
        r1 = "Y`\u0017\u0003\u001dXqF\u0002\u0011F`\t\u0003\f\u00111VNX\u0006%";
        r0 = 64;
        r3 = r4;
        goto L_0x0009;
    L_0x02ef:
        r3[r2] = r1;
        r2 = 66;
        r1 = "x`\u0014\u0000\u001dY%\u0003\u0004\nDwF[X";
        r0 = 65;
        r3 = r4;
        goto L_0x0009;
    L_0x02fa:
        r3[r2] = r1;
        r2 = 67;
        r1 = "hm\u0007\u0004\u000bNq";
        r0 = 66;
        r3 = r4;
        goto L_0x0009;
    L_0x0305:
        r3[r2] = r1;
        r2 = 68;
        r1 = "\u0006(";
        r0 = 67;
        r3 = r4;
        goto L_0x0009;
    L_0x0310:
        r3[r2] = r1;
        r2 = 69;
        r1 = "Md\n\u0005\u001d";
        r0 = 68;
        r3 = r4;
        goto L_0x0009;
    L_0x031b:
        r3[r2] = r1;
        r2 = 70;
        r1 = "\u000bl\u0015\"\u001dFu\t\u0004\u0019Y|4\u0013\u001cBw\u0003\u0015\f\u0011";
        r0 = 69;
        r3 = r4;
        goto L_0x0009;
    L_0x0326:
        r3[r2] = r1;
        r2 = 71;
        r1 = "Ml\n\u0013B";
        r0 = 70;
        r3 = r4;
        goto L_0x0009;
    L_0x0331:
        r3[r2] = r1;
        r2 = 72;
        r1 = "!%\u0000\u001f\u0014N?";
        r0 = 71;
        r3 = r4;
        goto L_0x0009;
    L_0x033c:
        r3[r2] = r1;
        r2 = 73;
        r1 = "Ej\u0012V\u0019Hf\u0003\u0006\fJg\n\u0013B\u001f5PVU\u000b";
        r0 = 72;
        r3 = r4;
        goto L_0x0009;
    L_0x0347:
        r3[r2] = r1;
        r2 = 74;
        r1 = "x`\u0014\u0000\u001dY%\u0014\u0013\u000b[j\b\u0005\u001d\u000bc\u0007\u001f\u0014^w\u0003LL\u001b5F[X";
        r0 = 73;
        r3 = r4;
        goto L_0x0009;
    L_0x0352:
        r3[r2] = r1;
        r2 = 75;
        r1 = "hj\b\u0002\u001dEqK\"\u0001[`\\Ö\u0019[u\n\u001f\u001bJq\u000f\u0019\u0016\u0004j\u0005\u0002\u001d_(\u0015\u0002\nNd\u000bMØHm\u0007\u0004\u000bNq[#,m(^";
        r0 = 74;
        r3 = r4;
        goto L_0x0009;
    L_0x035d:
        r3[r2] = r1;
        r2 = 76;
        r1 = "\u00179\u0000\u0017\u0011G`\u0002)\u000fBq\u000e)\nNq\u0014\u001f\u001dX;X";
        r0 = 75;
        r3 = r4;
        goto L_0x0009;
    L_0x0368:
        r3[r2] = r1;
        r2 = 77;
        r1 = "hd\u0012\u0015\u0010\u000bD\u0015\u0005\u001dYq\u000f\u0019\u0016nw\u0014\u0019\n\u000bq\tV\u0019]j\u000f\u0012XCq\u0012\u0006XHi\t\u0005\u001d\u000bf\u0014\u0017\u000bC%KV";
        r0 = 76;
        r3 = r4;
        goto L_0x0009;
    L_0x0373:
        r3[r2] = r1;
        r2 = 78;
        r1 = "hj\b\u0002\u001dEqK\"\u0001[`";
        r0 = 77;
        r3 = r4;
        goto L_0x0009;
    L_0x037e:
        r3[r2] = r1;
        r2 = 79;
        r1 = "&\u000f";
        r0 = 78;
        r3 = r4;
        goto L_0x0009;
    L_0x0389:
        r3[r2] = r1;
        r2 = 80;
        r1 = "\u000b%\u0000\u001f\u0014Nk\u0007\u001b\u001d\u0011";
        r0 = 79;
        r3 = r4;
        goto L_0x0009;
    L_0x0394:
        r3[r2] = r1;
        r2 = 81;
        r1 = "Yv\u00165\u0017O`\\";
        r0 = 80;
        r3 = r4;
        goto L_0x0009;
    L_0x039f:
        r3[r2] = r1;
        r2 = 82;
        r1 = "\u0007%\u0013\u0004\u0014\u0011";
        r0 = 81;
        r3 = r4;
        goto L_0x0009;
    L_0x03aa:
        r3[r2] = r1;
        r2 = 83;
        r1 = "Cq\u0012\u0006XHi\u000f\u0013\u0016_%\u0003\u000e\u001dHp\u0012\u0013XNw\u0014\u0019\n";
        r0 = 82;
        r3 = r4;
        goto L_0x0009;
    L_0x03b5:
        r3[r2] = r1;
        r2 = 84;
        r1 = "Fp\n\u0002\u0011[d\u0014\u0002WMj\u0014\u001bUOd\u0012\u0017";
        r0 = 83;
        r3 = r4;
        goto L_0x0009;
    L_0x03c0:
        r3[r2] = r1;
        r2 = 85;
        r1 = "hd\u0012\u0015\u0010\u000bV5:(N`\u0014#\u0016]`\u0014\u001f\u001eB`\u00023\u0000H`\u0016\u0002\u0011DkJV\u0010_q\u0016V\u001bGl\u0003\u0018\f\u000b`\u001e\u0013\u001b^q\u0003V\u001dYw\t\u0004Y";
        r0 = 84;
        r3 = r4;
        goto L_0x0009;
    L_0x03cb:
        r3[r2] = r1;
        r2 = 86;
        r1 = "~v\u0003\u0004Ujb\u0003\u0018\f";
        r0 = 85;
        r3 = r4;
        goto L_0x0009;
    L_0x03d6:
        r3[r2] = r1;
        r2 = 87;
        r1 = "y`\u0017\u0003\u001dXqF\u0018\u0017_%\u0007\u0003\fCj\u0014\u001f\u0002Na\\BH\u001a%KV";
        r0 = 86;
        r3 = r4;
        goto L_0x0009;
    L_0x03e1:
        r3[r2] = r1;
        r2 = 88;
        r1 = "\u000bn\u0003\u000f\u000bNq\\";
        r0 = 87;
        r3 = r4;
        goto L_0x0009;
    L_0x03ec:
        r3[r2] = r1;
        r2 = 89;
        r1 = "{J5\"";
        r0 = 88;
        r3 = r4;
        goto L_0x0009;
    L_0x03f7:
        r3[r2] = r1;
        r2 = 90;
        r1 = "jf\u0012\u001f\u0017E%KV\u0010_q\u0016&\u0017Xq \u001f\u0014N%";
        r0 = 89;
        r3 = r4;
        goto L_0x0009;
    L_0x0402:
        r3[r2] = r1;
        r2 = 91;
        r1 = "Cq\u0012\u0006V@`\u0003\u00069Gl\u0010\u0013";
        r0 = 90;
        r3 = r4;
        goto L_0x0009;
    L_0x040d:
        r3[r2] = r1;
        r2 = 92;
        r1 = "\t>Æ\u0010\u0011G`\b\u0017\u0015N8D";
        r0 = 91;
        r3 = r4;
        goto L_0x0009;
    L_0x0418:
        r3[r2] = r1;
        r2 = 93;
        r1 = "\u00179\u0003\u0004\nDwXH";
        r0 = 92;
        r3 = r4;
        goto L_0x0009;
    L_0x0423:
        r3[r2] = r1;
        r2 = 94;
        r1 = "Gj\u0005\u0017\fBj\bL";
        r0 = 93;
        r3 = r4;
        goto L_0x0009;
    L_0x042e:
        r3[r2] = r1;
        r2 = 95;
        r1 = "hj\b\u0002\u001dEqK2\u0011Xu\t\u0005\u0011_l\t\u0018Bc\t\u0004\u0015\u0006a\u0007\u0002\u0019\u0010¥\b\u0017\u0015N8D";
        r0 = 94;
        r3 = r4;
        goto L_0x0009;
    L_0x0439:
        r3[r2] = r1;
        r2 = 96;
        r1 = "~k\u0003\u000e\bNf\u0012\u0013\u001c\u0011%\u0015\u0013\n]`\u0014V\nNv\u0016\u0019\u0016X`\u0002V6~I*";
        r0 = 95;
        r3 = r4;
        goto L_0x0009;
    L_0x0444:
        r3[r2] = r1;
        r2 = 97;
        r1 = "gj\u0005\u0017\fBj\b";
        r0 = 96;
        r3 = r4;
        goto L_0x0009;
    L_0x044f:
        r3[r2] = r1;
        r2 = 98;
        r1 = "Hj\b\u0010\u0014Bf\u0012LL\u001b<F[X";
        r0 = 97;
        r3 = r4;
        goto L_0x0009;
    L_0x045a:
        r3[r2] = r1;
        r2 = 99;
        r1 = "Id\u0015\u0013X^w\nL";
        r0 = 98;
        r3 = r4;
        goto L_0x0009;
    L_0x0465:
        r3[r2] = r1;
        r2 = 100;
        r1 = "Cq\u0012\u0006B\u0004*WNJ\u0005<TXJ\u001b+WNA\u0011<VOA\u0004";
        r0 = 99;
        r3 = r4;
        goto L_0x0009;
    L_0x0470:
        r3[r2] = r1;
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r1 = "Ep\u000b\u0014\u001dYZ\u0013\u0004\u0014";
        r0 = 100;
        r3 = r4;
        goto L_0x0009;
    L_0x047b:
        r3[r2] = r1;
        r2 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r1 = "~k\u0003\u000e\bNf\u0012\u0013\u001c\u000b(F\u0010\u0019Bi\u0003\u0012X_jF7=x%\u0002\u0013\u001bY|\u0016\u0002VN?";
        r0 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0486:
        r3[r2] = r1;
        r2 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r1 = "\u001f3VFI";
        r0 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0491:
        r3[r2] = r1;
        r2 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r1 = "\u001f3VFH";
        r0 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x049c:
        r3[r2] = r1;
        r2 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r1 = "\u001f3VFJ";
        r0 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04a7:
        r3[r2] = r1;
        r2 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r1 = "\u001f3VF@";
        r0 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04b2:
        r3[r2] = r1;
        r2 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r1 = "\u001f3VFK";
        r0 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04bd:
        r3[r2] = r1;
        r2 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r1 = "Eg9\u001a\u0019Xq\u0012\u001f\u0015N";
        r0 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04c8:
        r3[r2] = r1;
        r2 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        r1 = "\u001f3VFO";
        r0 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04d3:
        r3[r2] = r1;
        r2 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r1 = "Xd\u000b\u0013X\\l\u0012\u001eXGd\u0015\u0002\u001dO%\u0007\u0015\u001bNv\u0015V\rYi";
        r0 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04de:
        r3[r2] = r1;
        r2 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r1 = "[w\t\u0000\u0011O`\u0014\u00051Ea\u0003\u000eB";
        r0 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04e9:
        r3[r2] = r1;
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r1 = "\u001f3VFA";
        r0 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04f4:
        r3[r2] = r1;
        r2 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r1 = "Eg9\u0003\bGj\u0007\u0012";
        r0 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04ff:
        r3[r2] = r1;
        r2 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        r1 = "\u001f3VGI";
        r0 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x050a:
        r3[r2] = r1;
        r2 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r1 = "\u001f3VFM";
        r0 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0515:
        r3[r2] = r1;
        r2 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        r1 = "Ji\nV\bJw\u0007\u001bXBvF\u001f\u0016]d\n\u001f\u001cN";
        r0 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0520:
        r3[r2] = r1;
        r2 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r1 = "\u001f3VFN";
        r0 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x052b:
        r3[r2] = r1;
        r2 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        r1 = "hm\u000f\u0018\u0019fj\u0004\u001f\u0014N";
        r0 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0536:
        r3[r2] = r1;
        r2 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        r1 = "hm\u000f\u0018\u0019~k\u000f\u0015\u0017F";
        r0 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0541:
        r3[r2] = r1;
        r2 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r1 = "hm\u000f\u0018\u0019`\n\u0013\u001bDh";
        r0 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x054c:
        r3[r2] = r1;
        r2 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        r1 = "Bk\u0010\u0017\u0014Ba\u0003V\bCj\b\u0013XEp\u000b\u0014\u001dY";
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0557:
        r3[r2] = r1;
        r2 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        r1 = "O`\u0005\u0019\u001cNU\u000e\u0019\u0016NK\u0013\u001b\u001aNwF\u0012\u001dHw\u001f\u0006\f\u000ba\u0007\u0002\u0019\u0011";
        r0 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0562:
        r3[r2] = r1;
        r2 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r1 = "Jc\u0012\u0013\n\u000ba\u0003\u0015\nRu\u0012\u0013\u001c\u0007%\u0016\u001e\u0017E`(\u0003\u0015I`\u0014V\u0011X%\b\u0003\u0014G";
        r0 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x056d:
        r3[r2] = r1;
        z = r4;
        r0 = java.util.concurrent.Executors.newSingleThreadExecutor();
        a = r0;
        r0 = new java.lang.Object;
        r0.<init>();
        b = r0;
        r0 = new java.util.concurrent.atomic.AtomicInteger;
        r0.<init>();
        c = r0;
        return;
    L_0x0586:
        r9 = 43;
        goto L_0x0020;
    L_0x058a:
        r9 = 5;
        goto L_0x0020;
    L_0x058d:
        r9 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        goto L_0x0020;
    L_0x0591:
        r9 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.h.<clinit>():void");
    }

    private h() {
    }

    private h(Context context) {
        String e = a.e(context, this.d);
        String d = a.d(context, this.e);
        String f = a.f(context, this.f);
        CookieManager cookieManager = new CookieManager();
        j = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(j);
        this.g = context;
        this.d = e;
        this.e = d;
        this.f = f;
    }

    public static int a(String str) {
        return j.a(str) ? -1 : str.equalsIgnoreCase(z[ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR]) ? 2 : str.equalsIgnoreCase(z[118]) ? 0 : str.equalsIgnoreCase(z[119]) ? 1 : -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private cn.jiguang.a.a.c.i a(android.content.Context r23, java.lang.String r24, int r25, long r26, boolean r28, java.io.File r29, java.lang.String r30) {
        /*
        r22 = this;
        r2 = z;
        r3 = 1;
        r2 = r2[r3];
        r3 = z;
        r4 = 90;
        r3 = r3[r4];
        cn.jiguang.c.d.a(r2, r3);
        r2 = z;
        r3 = 1;
        r3 = r2[r3];
        r2 = new java.lang.StringBuilder;
        r4 = z;
        r5 = 59;
        r4 = r4[r5];
        r2.<init>(r4);
        r0 = r24;
        r2 = r2.append(r0);
        r4 = z;
        r5 = 72;
        r4 = r4[r5];
        r4 = r2.append(r4);
        if (r29 == 0) goto L_0x0240;
    L_0x0030:
        r2 = r29.getAbsolutePath();
    L_0x0034:
        r2 = r4.append(r2);
        r4 = z;
        r5 = 88;
        r4 = r4[r5];
        r2 = r2.append(r4);
        r0 = r30;
        r2 = r2.append(r0);
        r4 = z;
        r5 = 80;
        r4 = r4[r5];
        r4 = r2.append(r4);
        if (r29 == 0) goto L_0x0244;
    L_0x0054:
        r2 = r29.getName();
    L_0x0058:
        r2 = r4.append(r2);
        r4 = z;
        r5 = 70;
        r4 = r4[r5];
        r2 = r2.append(r4);
        r0 = r28;
        r2 = r2.append(r0);
        r2 = r2.toString();
        cn.jiguang.c.d.a(r3, r2);
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = (r26 > r2 ? 1 : (r26 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0080;
    L_0x0079:
        r2 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r2 = (r26 > r2 ? 1 : (r26 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0082;
    L_0x0080:
        r26 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
    L_0x0082:
        r2 = java.util.UUID.randomUUID();
        r17 = r2.toString();
        r2 = z;
        r3 = 68;
        r18 = r2[r3];
        r2 = z;
        r3 = 79;
        r19 = r2[r3];
        r2 = z;
        r3 = 84;
        r20 = r2[r3];
        r4 = 0;
        r14 = 0;
        r13 = 0;
        r11 = 0;
        r3 = 0;
        r2 = -1;
        r5 = j;
        if (r5 != 0) goto L_0x00ad;
    L_0x00a6:
        r5 = new java.net.CookieManager;
        r5.<init>();
        j = r5;
    L_0x00ad:
        r16 = r3;
        r3 = r4;
    L_0x00b0:
        r15 = cn.jiguang.net.HttpUtils.getHttpURLConnectionWithProxy(r23, r24);	 Catch:{ SSLPeerUnverifiedException -> 0x05b9, Exception -> 0x059d, AssertionError -> 0x058b, all -> 0x0587 }
        r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r15.setConnectTimeout(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r15.setReadTimeout(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = 1;
        r15.setDoInput(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = 1;
        r15.setDoOutput(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = 0;
        r15.setUseCaches(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = 89;
        r3 = r3[r4];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r15.setRequestMethod(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = 67;
        r3 = r3[r4];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = 24;
        r4 = r4[r5];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r15.setRequestProperty(r3, r4);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = 86;
        r3 = r3[r4];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = 64;
        r4 = r4[r5];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r15.addRequestProperty(r3, r4);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = android.os.Build.VERSION.SDK;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = 8;
        if (r3 >= r4) goto L_0x010a;
    L_0x00fb:
        r3 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = 91;
        r3 = r3[r4];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = 69;
        r4 = r4[r5];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        java.lang.System.setProperty(r3, r4);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
    L_0x010a:
        r3 = j;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = r3.getCookieStore();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = r3.getCookies();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = r3.size();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        if (r3 <= 0) goto L_0x0133;
    L_0x011a:
        r3 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = 61;
        r3 = r3[r4];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = ";";
        r5 = j;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = r5.getCookieStore();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = r5.getCookies();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = android.text.TextUtils.join(r4, r5);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r15.setRequestProperty(r3, r4);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
    L_0x0133:
        r0 = r28;
        r15.setInstanceFollowRedirects(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = 1;
        r3 = r3[r4];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r6 = 71;
        r5 = r5[r6];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4.<init>(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r29;
        r4 = r4.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = r4.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        cn.jiguang.c.d.a(r3, r4);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        if (r29 == 0) goto L_0x0280;
    L_0x0157:
        r3 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = 78;
        r3 = r3[r4];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4.<init>();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r20;
        r4 = r4.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r6 = 60;
        r5 = r5[r6];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = r4.append(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r17;
        r4 = r4.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = r4.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r15.setRequestProperty(r3, r4);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = r15.getOutputStream();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4 = new java.io.DataOutputStream;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4.<init>(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = new java.lang.StringBuffer;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3.<init>();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r18;
        r3.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r17;
        r3.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r19;
        r3.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r6 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r7 = 95;
        r6 = r6[r7];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5.<init>(r6);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r30;
        r5 = r5.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r6 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r7 = 92;
        r6 = r6[r7];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = r5.append(r6);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r6 = r29.getName();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = r5.append(r6);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r6 = "\"";
        r5 = r5.append(r6);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r19;
        r5 = r5.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = r5.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3.append(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r6 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r7 = 75;
        r6 = r6[r7];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5.<init>(r6);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r19;
        r5 = r5.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = r5.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3.append(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r19;
        r3.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = r3.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = r3.getBytes();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4.write(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = new java.io.FileInputStream;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r29;
        r3.<init>(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r5];	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
    L_0x0205:
        r6 = r3.read(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r7 = -1;
        if (r6 == r7) goto L_0x0248;
    L_0x020c:
        r7 = 0;
        r4.write(r5, r7, r6);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        goto L_0x0205;
    L_0x0211:
        r3 = move-exception;
        r3 = r13;
        r4 = r14;
        r5 = r15;
    L_0x0215:
        r6 = z;	 Catch:{ all -> 0x057f }
        r7 = 1;
        r6 = r6[r7];	 Catch:{ all -> 0x057f }
        r7 = z;	 Catch:{ all -> 0x057f }
        r8 = 85;
        r7 = r7[r8];	 Catch:{ all -> 0x057f }
        cn.jiguang.c.d.i(r6, r7);	 Catch:{ all -> 0x057f }
        if (r4 == 0) goto L_0x0228;
    L_0x0225:
        r4.close();	 Catch:{ IOException -> 0x0368 }
    L_0x0228:
        if (r5 == 0) goto L_0x05d4;
    L_0x022a:
        r5.disconnect();
        r13 = r3;
        r14 = r4;
        r4 = r5;
    L_0x0230:
        r3 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r2 == r3) goto L_0x023e;
    L_0x0234:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 == r3) goto L_0x03d9;
    L_0x0238:
        r3 = cn.jiguang.e.a.b(r23);
        if (r3 != 0) goto L_0x03d9;
    L_0x023e:
        r2 = 0;
    L_0x023f:
        return r2;
    L_0x0240:
        r2 = r29;
        goto L_0x0034;
    L_0x0244:
        r2 = r29;
        goto L_0x0058;
    L_0x0248:
        r3.close();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = r19.getBytes();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4.write(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3.<init>();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r18;
        r3 = r3.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r17;
        r3 = r3.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r18;
        r3 = r3.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r0 = r19;
        r3 = r3.append(r0);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = r3.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r3 = r3.getBytes();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4.write(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4.flush();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r4.close();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
    L_0x0280:
        r12 = r15.getResponseCode();	 Catch:{ SSLPeerUnverifiedException -> 0x0211, Exception -> 0x05a3, AssertionError -> 0x0591 }
        r2 = r15.getHeaderFields();	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        a(r2);	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r2 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3 = 1;
        r2 = r2[r3];	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r4 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r5 = 81;
        r4 = r4[r5];	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3.<init>(r4);	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3 = r3.append(r12);	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3 = r3.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        cn.jiguang.c.d.a(r2, r3);	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r2 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r12 != r2) goto L_0x0304;
    L_0x02aa:
        r2 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3 = 97;
        r2 = r2[r3];	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r4 = r15.getHeaderField(r2);	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r2 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3 = 1;
        r2 = r2[r3];	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r5 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r6 = 94;
        r5 = r5[r6];	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3.<init>(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3 = r3.append(r4);	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r3 = r3.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        cn.jiguang.c.d.a(r2, r3);	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        if (r25 < 0) goto L_0x02f2;
    L_0x02d1:
        r5 = r25 + -1;
        r6 = 0;
        r9 = 0;
        r10 = 0;
        r2 = r22;
        r3 = r23;
        r8 = r28;
        r2 = r2.a(r3, r4, r5, r6, r8, r9, r10);	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        if (r14 == 0) goto L_0x02e6;
    L_0x02e3:
        r14.close();	 Catch:{ IOException -> 0x02ed }
    L_0x02e6:
        if (r15 == 0) goto L_0x023f;
    L_0x02e8:
        r15.disconnect();
        goto L_0x023f;
    L_0x02ed:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x02e6;
    L_0x02f2:
        if (r14 == 0) goto L_0x02f7;
    L_0x02f4:
        r14.close();	 Catch:{ IOException -> 0x02ff }
    L_0x02f7:
        if (r15 == 0) goto L_0x02fc;
    L_0x02f9:
        r15.disconnect();
    L_0x02fc:
        r2 = 0;
        goto L_0x023f;
    L_0x02ff:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x02f7;
    L_0x0304:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r12 != r2) goto L_0x0355;
    L_0x0308:
        r3 = r15.getInputStream();	 Catch:{ SSLPeerUnverifiedException -> 0x05bf, Exception -> 0x05a8, AssertionError -> 0x0596 }
        r4 = r15.getHeaderFields();	 Catch:{ SSLPeerUnverifiedException -> 0x05c6, Exception -> 0x05ab, AssertionError -> 0x0599, all -> 0x03c7 }
        r2 = new java.lang.String;	 Catch:{ SSLPeerUnverifiedException -> 0x05af, Exception -> 0x036e, AssertionError -> 0x0392, all -> 0x03c7 }
        r5 = cn.jiguang.e.i.a(r3);	 Catch:{ SSLPeerUnverifiedException -> 0x05af, Exception -> 0x036e, AssertionError -> 0x0392, all -> 0x03c7 }
        r6 = z;	 Catch:{ SSLPeerUnverifiedException -> 0x05af, Exception -> 0x036e, AssertionError -> 0x0392, all -> 0x03c7 }
        r7 = 24;
        r6 = r6[r7];	 Catch:{ SSLPeerUnverifiedException -> 0x05af, Exception -> 0x036e, AssertionError -> 0x0392, all -> 0x03c7 }
        r2.<init>(r5, r6);	 Catch:{ SSLPeerUnverifiedException -> 0x05af, Exception -> 0x036e, AssertionError -> 0x0392, all -> 0x03c7 }
        if (r3 == 0) goto L_0x0324;
    L_0x0321:
        r3.close();	 Catch:{ IOException -> 0x0350 }
    L_0x0324:
        if (r15 == 0) goto L_0x0329;
    L_0x0326:
        r15.disconnect();
    L_0x0329:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r12 < r3) goto L_0x0413;
    L_0x032d:
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r12 >= r3) goto L_0x0413;
    L_0x0331:
        if (r2 != 0) goto L_0x0348;
    L_0x0333:
        r2 = z;	 Catch:{ Exception -> 0x03fc }
        r3 = 1;
        r2 = r2[r3];	 Catch:{ Exception -> 0x03fc }
        r3 = z;	 Catch:{ Exception -> 0x03fc }
        r5 = 96;
        r3 = r3[r5];	 Catch:{ Exception -> 0x03fc }
        r5 = 0;
        cn.jiguang.c.d.b(r2, r3, r5);	 Catch:{ Exception -> 0x03fc }
        r2 = z;	 Catch:{ Exception -> 0x03fc }
        r3 = 93;
        r2 = r2[r3];	 Catch:{ Exception -> 0x03fc }
    L_0x0348:
        r3 = new cn.jiguang.a.a.c.i;
        r3.<init>(r12, r4, r2);
        r2 = r3;
        goto L_0x023f;
    L_0x0350:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0324;
    L_0x0355:
        if (r14 == 0) goto L_0x035a;
    L_0x0357:
        r14.close();	 Catch:{ IOException -> 0x0363 }
    L_0x035a:
        if (r15 == 0) goto L_0x05d0;
    L_0x035c:
        r15.disconnect();
        r2 = r12;
        r4 = r15;
        goto L_0x0230;
    L_0x0363:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x035a;
    L_0x0368:
        r6 = move-exception;
        r6.printStackTrace();
        goto L_0x0228;
    L_0x036e:
        r2 = move-exception;
        r13 = r4;
        r14 = r3;
    L_0x0371:
        r3 = z;	 Catch:{ all -> 0x0584 }
        r4 = 1;
        r3 = r3[r4];	 Catch:{ all -> 0x0584 }
        r4 = z;	 Catch:{ all -> 0x0584 }
        r5 = 83;
        r4 = r4[r5];	 Catch:{ all -> 0x0584 }
        cn.jiguang.c.d.b(r3, r4, r2);	 Catch:{ all -> 0x0584 }
        if (r14 == 0) goto L_0x0384;
    L_0x0381:
        r14.close();	 Catch:{ IOException -> 0x038d }
    L_0x0384:
        if (r15 == 0) goto L_0x05d0;
    L_0x0386:
        r15.disconnect();
        r2 = r12;
        r4 = r15;
        goto L_0x0230;
    L_0x038d:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0384;
    L_0x0392:
        r2 = move-exception;
        r13 = r4;
        r14 = r3;
    L_0x0395:
        r3 = z;	 Catch:{ all -> 0x0584 }
        r4 = 1;
        r3 = r3[r4];	 Catch:{ all -> 0x0584 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0584 }
        r5 = z;	 Catch:{ all -> 0x0584 }
        r6 = 77;
        r5 = r5[r6];	 Catch:{ all -> 0x0584 }
        r4.<init>(r5);	 Catch:{ all -> 0x0584 }
        r2 = r2.toString();	 Catch:{ all -> 0x0584 }
        r2 = r4.append(r2);	 Catch:{ all -> 0x0584 }
        r2 = r2.toString();	 Catch:{ all -> 0x0584 }
        cn.jiguang.c.d.i(r3, r2);	 Catch:{ all -> 0x0584 }
        if (r14 == 0) goto L_0x03b9;
    L_0x03b6:
        r14.close();	 Catch:{ IOException -> 0x03c2 }
    L_0x03b9:
        if (r15 == 0) goto L_0x05d0;
    L_0x03bb:
        r15.disconnect();
        r2 = r12;
        r4 = r15;
        goto L_0x0230;
    L_0x03c2:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x03b9;
    L_0x03c7:
        r2 = move-exception;
        r14 = r3;
    L_0x03c9:
        if (r14 == 0) goto L_0x03ce;
    L_0x03cb:
        r14.close();	 Catch:{ IOException -> 0x03d4 }
    L_0x03ce:
        if (r15 == 0) goto L_0x03d3;
    L_0x03d0:
        r15.disconnect();
    L_0x03d3:
        throw r2;
    L_0x03d4:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x03ce;
    L_0x03d9:
        r3 = 3;
        r0 = r16;
        if (r0 < r3) goto L_0x03ec;
    L_0x03de:
        r2 = new cn.jiguang.a.a.c.i;
        r3 = -1;
        r4 = z;
        r5 = 76;
        r4 = r4[r5];
        r2.<init>(r3, r13, r4);
        goto L_0x023f;
    L_0x03ec:
        r3 = r16 + 1;
        java.lang.Thread.sleep(r26);	 Catch:{ InterruptedException -> 0x03f6 }
        r16 = r3;
        r3 = r4;
        goto L_0x00b0;
    L_0x03f6:
        r5 = move-exception;
        r16 = r3;
        r3 = r4;
        goto L_0x00b0;
    L_0x03fc:
        r2 = move-exception;
        r3 = z;
        r5 = 1;
        r3 = r3[r5];
        r5 = z;
        r6 = 63;
        r5 = r5[r6];
        cn.jiguang.c.d.a(r3, r5, r2);
        r2 = z;
        r3 = 93;
        r2 = r2[r3];
        goto L_0x0348;
    L_0x0413:
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r12 < r2) goto L_0x0511;
    L_0x0417:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r12 >= r2) goto L_0x0511;
    L_0x041b:
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r2 != r12) goto L_0x0444;
    L_0x041f:
        r2 = z;
        r3 = 1;
        r2 = r2[r3];
        r3 = new java.lang.StringBuilder;
        r5 = z;
        r6 = 74;
        r5 = r5[r6];
        r3.<init>(r5);
        r0 = r24;
        r3 = r3.append(r0);
        r3 = r3.toString();
        cn.jiguang.c.d.c(r2, r3);
        r2 = z;
        r3 = 62;
        r2 = r2[r3];
        goto L_0x0348;
    L_0x0444:
        r2 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r2 != r12) goto L_0x046d;
    L_0x0448:
        r2 = z;
        r3 = 1;
        r2 = r2[r3];
        r3 = new java.lang.StringBuilder;
        r5 = z;
        r6 = 87;
        r5 = r5[r6];
        r3.<init>(r5);
        r0 = r24;
        r3 = r3.append(r0);
        r3 = r3.toString();
        cn.jiguang.c.d.c(r2, r3);
        r2 = z;
        r3 = 93;
        r2 = r2[r3];
        goto L_0x0348;
    L_0x046d:
        r2 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r2 != r12) goto L_0x0496;
    L_0x0471:
        r2 = z;
        r3 = 1;
        r2 = r2[r3];
        r3 = new java.lang.StringBuilder;
        r5 = z;
        r6 = 58;
        r5 = r5[r6];
        r3.<init>(r5);
        r0 = r24;
        r3 = r3.append(r0);
        r3 = r3.toString();
        cn.jiguang.c.d.c(r2, r3);
        r2 = z;
        r3 = 93;
        r2 = r2[r3];
        goto L_0x0348;
    L_0x0496:
        r2 = 406; // 0x196 float:5.69E-43 double:2.006E-321;
        if (r2 != r12) goto L_0x04bf;
    L_0x049a:
        r2 = z;
        r3 = 1;
        r2 = r2[r3];
        r3 = new java.lang.StringBuilder;
        r5 = z;
        r6 = 73;
        r5 = r5[r6];
        r3.<init>(r5);
        r0 = r24;
        r3 = r3.append(r0);
        r3 = r3.toString();
        cn.jiguang.c.d.c(r2, r3);
        r2 = z;
        r3 = 93;
        r2 = r2[r3];
        goto L_0x0348;
    L_0x04bf:
        r2 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        if (r2 != r12) goto L_0x04e8;
    L_0x04c3:
        r2 = z;
        r3 = 1;
        r2 = r2[r3];
        r3 = new java.lang.StringBuilder;
        r5 = z;
        r6 = 65;
        r5 = r5[r6];
        r3.<init>(r5);
        r0 = r24;
        r3 = r3.append(r0);
        r3 = r3.toString();
        cn.jiguang.c.d.c(r2, r3);
        r2 = z;
        r3 = 93;
        r2 = r2[r3];
        goto L_0x0348;
    L_0x04e8:
        r2 = 409; // 0x199 float:5.73E-43 double:2.02E-321;
        if (r2 != r12) goto L_0x05cd;
    L_0x04ec:
        r2 = z;
        r3 = 1;
        r2 = r2[r3];
        r3 = new java.lang.StringBuilder;
        r5 = z;
        r6 = 98;
        r5 = r5[r6];
        r3.<init>(r5);
        r0 = r24;
        r3 = r3.append(r0);
        r3 = r3.toString();
        cn.jiguang.c.d.c(r2, r3);
        r2 = z;
        r3 = 93;
        r2 = r2[r3];
        goto L_0x0348;
    L_0x0511:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r12 < r2) goto L_0x054c;
    L_0x0515:
        r2 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r12 >= r2) goto L_0x054c;
    L_0x0519:
        r2 = z;
        r3 = 1;
        r2 = r2[r3];
        r3 = new java.lang.StringBuilder;
        r5 = z;
        r6 = 66;
        r5 = r5[r6];
        r3.<init>(r5);
        r3 = r3.append(r12);
        r5 = z;
        r6 = 82;
        r5 = r5[r6];
        r3 = r3.append(r5);
        r0 = r24;
        r3 = r3.append(r0);
        r3 = r3.toString();
        cn.jiguang.c.d.c(r2, r3);
        r2 = z;
        r3 = 93;
        r2 = r2[r3];
        goto L_0x0348;
    L_0x054c:
        r2 = z;
        r3 = 1;
        r2 = r2[r3];
        r3 = new java.lang.StringBuilder;
        r5 = z;
        r6 = 57;
        r5 = r5[r6];
        r3.<init>(r5);
        r3 = r3.append(r12);
        r5 = z;
        r6 = 82;
        r5 = r5[r6];
        r3 = r3.append(r5);
        r0 = r24;
        r3 = r3.append(r0);
        r3 = r3.toString();
        cn.jiguang.c.d.c(r2, r3);
        r2 = z;
        r3 = 93;
        r2 = r2[r3];
        goto L_0x0348;
    L_0x057f:
        r2 = move-exception;
        r14 = r4;
        r15 = r5;
        goto L_0x03c9;
    L_0x0584:
        r2 = move-exception;
        goto L_0x03c9;
    L_0x0587:
        r2 = move-exception;
        r15 = r3;
        goto L_0x03c9;
    L_0x058b:
        r4 = move-exception;
        r12 = r2;
        r15 = r3;
        r2 = r4;
        goto L_0x0395;
    L_0x0591:
        r3 = move-exception;
        r12 = r2;
        r2 = r3;
        goto L_0x0395;
    L_0x0596:
        r2 = move-exception;
        goto L_0x0395;
    L_0x0599:
        r2 = move-exception;
        r14 = r3;
        goto L_0x0395;
    L_0x059d:
        r4 = move-exception;
        r12 = r2;
        r15 = r3;
        r2 = r4;
        goto L_0x0371;
    L_0x05a3:
        r3 = move-exception;
        r12 = r2;
        r2 = r3;
        goto L_0x0371;
    L_0x05a8:
        r2 = move-exception;
        goto L_0x0371;
    L_0x05ab:
        r2 = move-exception;
        r14 = r3;
        goto L_0x0371;
    L_0x05af:
        r2 = move-exception;
        r2 = r12;
        r5 = r15;
        r21 = r3;
        r3 = r4;
        r4 = r21;
        goto L_0x0215;
    L_0x05b9:
        r4 = move-exception;
        r4 = r14;
        r5 = r3;
        r3 = r13;
        goto L_0x0215;
    L_0x05bf:
        r2 = move-exception;
        r2 = r12;
        r3 = r13;
        r4 = r14;
        r5 = r15;
        goto L_0x0215;
    L_0x05c6:
        r2 = move-exception;
        r2 = r12;
        r4 = r3;
        r5 = r15;
        r3 = r13;
        goto L_0x0215;
    L_0x05cd:
        r2 = r11;
        goto L_0x0348;
    L_0x05d0:
        r2 = r12;
        r4 = r15;
        goto L_0x0230;
    L_0x05d4:
        r13 = r3;
        r14 = r4;
        r4 = r5;
        goto L_0x0230;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.h.a(android.content.Context, java.lang.String, int, long, boolean, java.io.File, java.lang.String):cn.jiguang.a.a.c.i");
    }

    private String a(int i) {
        String b = (i < 0 || i >= 3) ? z[100] : cn.jiguang.b.a.a.b(this.g, new StringBuilder(z[101]).append(i).toString(), z[100]);
        this.i = b;
        d.a(z[1], new StringBuilder(z[99]).append(this.i).toString());
        return this.i;
    }

    private String a(String str, i iVar) {
        return a(this.g, iVar) ? d(str) : null;
    }

    private String a(TreeMap<String, String> treeMap) {
        if (treeMap.size() == 0) {
            d.g(z[1], z[6]);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry value : treeMap.entrySet()) {
            stringBuilder.append(value.getValue());
        }
        String b = cn.jiguang.a.b.a.b(this.g);
        d.a(z[1], new StringBuilder(z[7]).append(b).toString());
        b = a.a(stringBuilder.toString() + b).toUpperCase();
        d.a(z[1], new StringBuilder(z[5]).append(stringBuilder).toString());
        d.a(z[1], new StringBuilder(z[4]).append(b).toString());
        return b;
    }

    public static void a(Context context) {
        d.a(z[1], z[3]);
        if (c.get() >= 2) {
            d.a(z[1], z[2]);
        } else {
            a.execute(new h(context));
        }
    }

    private static void a(Map<String, List<String>> map) {
        List<String> list = (List) map.get(z[0]);
        if (list != null) {
            for (String parse : list) {
                j.getCookieStore().add(null, (HttpCookie) HttpCookie.parse(parse).get(0));
            }
        }
    }

    private static boolean a(Context context, i iVar) {
        Throwable e;
        Closeable openFileOutput;
        IOException e2;
        FileNotFoundException e3;
        UnsupportedEncodingException e4;
        NullPointerException e5;
        if (context == null) {
            d.g(z[1], z[55]);
            return false;
        } else if (iVar == null) {
            return false;
        } else {
            try {
                d.a(z[1], new StringBuilder(z[54]).append(iVar).toString());
            } catch (Throwable e6) {
                d.c(z[1], z[44], e6);
            }
            String str = z[40];
            StringBuilder stringBuilder = new StringBuilder("");
            if (iVar.c != null && iVar.c.size() > 0) {
                for (Entry entry : iVar.c.entrySet()) {
                    if (entry.getKey() != null) {
                        stringBuilder.append((String) entry.getKey()).append(z[47]);
                    }
                    Iterator it = ((List) entry.getValue()).iterator();
                    if (it.hasNext()) {
                        stringBuilder.append((String) it.next());
                        while (it.hasNext()) {
                            stringBuilder.append(z[48]).append((String) it.next());
                        }
                    }
                    stringBuilder.append("\n");
                }
            }
            stringBuilder.append(z[45]);
            if (!TextUtils.isEmpty(iVar.b)) {
                stringBuilder.append(iVar.b);
            }
            try {
                context.deleteFile(str);
                openFileOutput = context.openFileOutput(str, 0);
                try {
                    boolean z;
                    openFileOutput.write(stringBuilder.toString().getBytes(z[24]));
                    o.a(openFileOutput);
                    try {
                        String str2 = z[27];
                        context.deleteFile(str2);
                        String str3 = context.getFilesDir() + File.separator;
                        Collection arrayList = new ArrayList();
                        arrayList.add(new File(str3 + z[40]));
                        f.a(arrayList, new File(str3 + str2));
                        z = true;
                    } catch (IOException e22) {
                        e22.printStackTrace();
                        z = false;
                    }
                    return z;
                } catch (FileNotFoundException e7) {
                    e3 = e7;
                    try {
                        d.c(z[1], new StringBuilder(z[53]).append(str).append(z[56]).append(e3.getMessage()).toString());
                        o.a(openFileOutput);
                        return false;
                    } catch (Throwable th) {
                        e6 = th;
                        o.a(openFileOutput);
                        throw e6;
                    }
                } catch (UnsupportedEncodingException e8) {
                    e4 = e8;
                    d.c(z[1], new StringBuilder(z[50]).append(str).append(z[51]).append(e4.getMessage()).toString());
                    o.a(openFileOutput);
                    return false;
                } catch (IOException e9) {
                    e22 = e9;
                    d.c(z[1], new StringBuilder(z[46]).append(str).append(z[51]).append(e22.getMessage()).toString());
                    o.a(openFileOutput);
                    return false;
                } catch (NullPointerException e10) {
                    e5 = e10;
                    d.c(z[1], new StringBuilder(z[49]).append(str).append(z[52]).append(e5.getMessage()).toString());
                    o.a(openFileOutput);
                    return false;
                }
            } catch (FileNotFoundException e11) {
                e3 = e11;
                openFileOutput = null;
                d.c(z[1], new StringBuilder(z[53]).append(str).append(z[56]).append(e3.getMessage()).toString());
                o.a(openFileOutput);
                return false;
            } catch (UnsupportedEncodingException e12) {
                e4 = e12;
                openFileOutput = null;
                d.c(z[1], new StringBuilder(z[50]).append(str).append(z[51]).append(e4.getMessage()).toString());
                o.a(openFileOutput);
                return false;
            } catch (IOException e13) {
                e22 = e13;
                openFileOutput = null;
                d.c(z[1], new StringBuilder(z[46]).append(str).append(z[51]).append(e22.getMessage()).toString());
                o.a(openFileOutput);
                return false;
            } catch (NullPointerException e14) {
                e5 = e14;
                openFileOutput = null;
                d.c(z[1], new StringBuilder(z[49]).append(str).append(z[52]).append(e5.getMessage()).toString());
                o.a(openFileOutput);
                return false;
            } catch (Throwable th2) {
                e6 = th2;
                openFileOutput = null;
                o.a(openFileOutput);
                throw e6;
            }
        }
    }

    private boolean a(String str, String str2, String str3) {
        d.a(z[1], new StringBuilder(z[38]).append(str).append(z[36]).append(str2).append(z[35]).append(str3).toString());
        TreeMap treeMap = new TreeMap();
        if (!j.a(str)) {
            treeMap.put(z[22], str);
        }
        if (!j.a(str2)) {
            treeMap.put(z[15], str2);
        }
        if (!j.a(str3)) {
            treeMap.put(z[11], str3);
        }
        treeMap.put(z[29], cn.jiguang.b.a.a.b(this.g, z[23], z[25]));
        treeMap.put(z[26], cn.jiguang.b.a.a.b(this.g, z[39], "7"));
        treeMap.put(z[32], cn.jiguang.b.f.a.b());
        treeMap.put(z[31], a(treeMap));
        String str4 = "";
        for (Entry entry : treeMap.entrySet()) {
            try {
                str4 = str4 + HttpUtils.PARAMETERS_SEPARATOR + ((String) entry.getKey()) + HttpUtils.EQUAL_SIGN + URLEncoder.encode((String) entry.getValue(), z[24]);
            } catch (UnsupportedEncodingException e) {
            }
        }
        d.a(z[1], new StringBuilder(z[33]).append(str4).toString());
        try {
            i a = a(this.g, this.i + z[37] + str4, 10, 30000, false, null, null);
            d.a(z[1], new StringBuilder(z[30]).append(a.a).append(z[28]).append(a.b).toString());
            if (a.a != 200) {
                return false;
            }
            Object b;
            JSONObject c = c(a.b);
            if (c != null) {
                if (c.optInt(z[34], -1) != 200) {
                    return false;
                }
                b = b(c.optString(z[20]));
            } else if (a.c == null && TextUtils.isEmpty(a.b)) {
                b = null;
            } else {
                synchronized (b) {
                    this.h = 0;
                    try {
                        b = a(str4, a);
                    } catch (Throwable th) {
                        b = null;
                    }
                    this.g.deleteFile(z[40]);
                    this.g.deleteFile(z[27]);
                }
            }
            if (TextUtils.isEmpty(b)) {
                return false;
            }
            e(b);
            return true;
        } catch (Throwable th2) {
            return false;
        }
    }

    public static String b(Context context) {
        if (context == null) {
            d.g(z[1], z[8]);
            return "";
        }
        String e = a.e(context, "");
        String d = a.d(context, "");
        e = a.a(e + d + a.f(context, ""));
        d.a(z[1], new StringBuilder(z[9]).append(e).toString());
        return e;
    }

    private String b(String str) {
        String f = f(str);
        d.a(z[1], new StringBuilder(z[ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR]).append(f).toString());
        if (j.a(f)) {
            d.g(z[1], z[ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED]);
            return null;
        } else if (Patterns.PHONE.matcher(f).matches()) {
            return f;
        } else {
            d.g(z[1], z[ErrorCode.THREAD_INIT_ERROR]);
            return null;
        }
    }

    private static JSONObject c(String str) {
        try {
            return !TextUtils.isEmpty(str) ? new JSONObject(str) : null;
        } catch (JSONException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private String d(String str) {
        d.c(z[1], new StringBuilder(z[41]).append(str).toString());
        if (TextUtils.isEmpty(str)) {
            d.g(z[1], z[43]);
            return null;
        }
        try {
            i a = a(this.g, this.i + z[37] + str, 10, 30000, false, new File(this.g.getFilesDir() + File.separator + z[27]), z[42]);
            d.a(z[1], new StringBuilder(z[30]).append(a.a).append(z[28]).append(a.b).toString());
            if (a.a != 200) {
                return null;
            }
            String a2;
            JSONObject c = c(a.b);
            if (c == null) {
                if (!(a.c == null && TextUtils.isEmpty(a.b))) {
                    if (this.h > 4) {
                        return null;
                    }
                    this.h++;
                    try {
                        a2 = a(str, a);
                    } catch (Throwable th) {
                    }
                }
                a2 = null;
            } else if (c.optInt(z[34], -1) != 200) {
                return null;
            } else {
                a2 = b(c.optString(z[20]));
            }
            return a2;
        } catch (Throwable th2) {
            return null;
        }
    }

    private void e(String str) {
        d.a(z[1], new StringBuilder(z[16]).append(str).toString());
        Context context = this.g;
        String b = b(context);
        if (j.a(b)) {
            b = z[12];
        }
        cn.jiguang.b.a.a.a(context, b, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(z[20], str);
            if (!j.a(this.d)) {
                jSONObject.put(z[22], this.d);
            }
            if (!j.a(this.f)) {
                jSONObject.put(z[11], this.f);
            }
            if (!j.a(this.e)) {
                jSONObject.put(z[15], this.e);
            }
            try {
                b = BasePreferenceManager.getEncryptedString(jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!j.a(b)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(z[14], b);
                jSONObject2.put(z[10], cn.jiguang.b.a.a.q());
                jSONObject2.put(z[21], z[19]);
                d.a(z[1], new StringBuilder(z[13]).append(b).toString());
                d.a(z[1], new StringBuilder(z[18]).append(jSONObject2.toString()).toString());
                c.a(this.g, jSONObject2);
                cn.jiguang.a.b.a.c(this.g, false);
            }
        } catch (Throwable e2) {
            d.e(z[1], z[17], e2);
        }
    }

    private String f(String str) {
        try {
            return cn.jiguang.b.f.a.a.b(str, cn.jiguang.a.b.a.b(this.g).substring(0, 16));
        } catch (Exception e) {
            d.g(z[1], new StringBuilder(z[102]).append(e.getMessage()).toString());
            return null;
        }
    }

    public final void run() {
        int i = 0;
        c.incrementAndGet();
        try {
            if (j.a(this.d) && j.a(this.e) && j.a(this.f)) {
                d.g(z[1], z[116]);
                return;
            }
            Context context = this.g;
            String b = b(context);
            if (j.a(b)) {
                b = z[12];
            }
            String b2 = cn.jiguang.b.a.a.b(context, b, "");
            if (j.a(b2) || ((Boolean) cn.jiguang.b.a.d.b(this.g, z[113], Boolean.valueOf(false))).booleanValue()) {
                int i2;
                cn.jiguang.b.a.d.a(this.g, z[108], Long.valueOf(System.currentTimeMillis()));
                b = this.f;
                if (!j.a(b)) {
                    if (b.startsWith(z[104]) || b.startsWith(z[105]) || b.startsWith(z[109]) || b.startsWith(z[106])) {
                        i2 = 0;
                        d.a(z[1], new StringBuilder(z[111]).append(i2).toString());
                        if (i2 == -1) {
                            a(i2);
                            if (!j.a(this.i)) {
                                a(this.d, this.e, this.f);
                            }
                        } else {
                            b = "";
                            while (i < 3) {
                                a(i);
                                d.a(z[1], new StringBuilder(z[111]).append(i).toString());
                                i++;
                                if (!j.a(this.i) || r0.equals(this.i)) {
                                    d.a(z[1], z[110]);
                                } else {
                                    b = this.i;
                                    if (a(this.d, this.e, this.f)) {
                                        break;
                                    }
                                }
                            }
                        }
                        c.decrementAndGet();
                    } else if (b.startsWith(z[103]) || b.startsWith(z[117]) || b.startsWith(z[112])) {
                        i2 = 1;
                        d.a(z[1], new StringBuilder(z[111]).append(i2).toString());
                        if (i2 == -1) {
                            b = "";
                            while (i < 3) {
                                a(i);
                                d.a(z[1], new StringBuilder(z[111]).append(i).toString());
                                i++;
                                if (j.a(this.i)) {
                                }
                                d.a(z[1], z[110]);
                            }
                        } else {
                            a(i2);
                            if (j.a(this.i)) {
                                a(this.d, this.e, this.f);
                            }
                        }
                        c.decrementAndGet();
                    } else if (b.startsWith(z[107]) || b.startsWith(z[115]) || b.startsWith(z[114])) {
                        i2 = 2;
                        d.a(z[1], new StringBuilder(z[111]).append(i2).toString());
                        if (i2 == -1) {
                            a(i2);
                            if (j.a(this.i)) {
                                a(this.d, this.e, this.f);
                            }
                        } else {
                            b = "";
                            while (i < 3) {
                                a(i);
                                d.a(z[1], new StringBuilder(z[111]).append(i).toString());
                                i++;
                                if (j.a(this.i)) {
                                }
                                d.a(z[1], z[110]);
                            }
                        }
                        c.decrementAndGet();
                    }
                }
                i2 = -1;
                d.a(z[1], new StringBuilder(z[111]).append(i2).toString());
                if (i2 == -1) {
                    b = "";
                    while (i < 3) {
                        a(i);
                        d.a(z[1], new StringBuilder(z[111]).append(i).toString());
                        i++;
                        if (j.a(this.i)) {
                        }
                        d.a(z[1], z[110]);
                    }
                } else {
                    a(i2);
                    if (j.a(this.i)) {
                        a(this.d, this.e, this.f);
                    }
                }
                c.decrementAndGet();
            }
            e(b2);
            c.decrementAndGet();
        } catch (Exception e) {
        }
    }
}
