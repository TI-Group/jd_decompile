package cn.jiguang.a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import cn.jiguang.a.a.a.c;
import cn.jiguang.a.a.c.h;
import cn.jiguang.a.a.c.j;
import cn.jiguang.android.ShareValues;
import cn.jiguang.api.BasePreferenceManager;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.b.b.e;
import cn.jiguang.b.e.a.b;
import cn.jiguang.c.d;
import cn.jiguang.net.HttpUtils;
import cn.jiguang.service.Protocol;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 73;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "21`\u0002\u0019?*";
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
            case 0: goto L_0x0341;
            case 1: goto L_0x0345;
            case 2: goto L_0x0349;
            case 3: goto L_0x034d;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0012*|\u001a14-}\u0017\u001b4\u000e|\u0019\u001f4-}\u0019\u000e";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u001b\u001f`\u0017\u0010(*g\u0015\u000f\u00121c\u001b\u0013?\u001da\u0018\u001a89}";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "=1m\u0017\b81`)\u001f>2b\u0013\u001f%\u0001h\u0004\u0019 +k\u0018\u001f(";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "$0k\u000e\f4=z\u0013\u0018p";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = ";-a\u0018?>0z\u0013\u0012%d";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "80z\u0013\u000e'?b";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "0=z\u001f\u0013?~#V\f#1m\u0013\u000f\"\u0012a\u0015\u001d%7a\u0018?>2b\u0013\u001f%";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "$0k\u000e\f4=z\u0013\u0018p~f\u0017\u000fq)|\u0019\u00126~y\u001f\b9~D%3\u001f\u001bv\u0015\u0019!*g\u0019\u0012";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "0.~)\u000e$0`\u001f\u00126\u0001m\u0019\u0010=;m\u0002#!,a\u0015\u0019\"-Q\u0002\u0005!;";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "0.~)\u000e$0`\u001f\u00126\u0001m\u0019\u0010=;m\u0002#80z\u0013\u000e'?b";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "21`\u0010\u00156\fk\u0006\u0013#*\\\u0003\u0012?7`\u0011=!..\u0013\u00042;~\u0002\u0015>04";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "0.~)\u000e$0`\u001f\u00126\u0001m\u0019\u0010=;m\u0002#0.~)\b(.k";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "0.~)\b(.k";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "0.~)\u000e$0`\u001f\u00126\u0001m\u0019\u0010=;m\u0002#40o\u0014\u00104";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "!,a\u0015\u0019\"-Q\u0002\u0005!;";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "!,a\u0015\u0019\"-M\u0002\u000e=\fk\u0006\u0013#*.\u0013\u00042;~\u0002\u0015>04";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u00040k\u000e\f4=z\u0013\u0018k~{\u0018\u0017?1y\u0018\\!+}\u001e\\<-iV\b(.kVQ";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "!,a\u0015\u0019\"-M\u0002\u000e=\fk\u0006\u0013#*L\u000f?<:.\u0010\u001d82k\u0012\\3;m\u0017\t\";.<?>,kX\u0011\u0010.~\u001a\u00152?z\u001f\u0013?\u001da\u0018\b4&zV\u0015\"~`\u0003\u0010=";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "7,k\u0007\t40m\u000f";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "=<}V\u0019??l\u001a\u00195p X";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "57}\u0017\u001e=;";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "=<}V\u00188-o\u0014\u00104: XR";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "#;~\u0019\u000e%\u0001b\u0019\u001f0*g\u0019\u0012\u000e8|\u0013\r$;`\u0015\u0005";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "?+c\u0014\u0019#\u0001o\u0006\f8:";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "0.~)\u000f4=|\u0013\b";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "9*z\u0006F~q";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "$,b";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "';|\u0005\u0015>04";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "q.|\u0019\n8:k\u0004\u0015?:k\u000eF";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "2?|\u0004\u00154,}";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "0.~)\u00155";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "\u0006\u0017H?";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "[~o\u0006\f\u0002;m\u0004\u0019%d";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "[~o\u0006\f\u0018\u001a4";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "0=z\u001f\u0013?~#V\t!:o\u0002\u0019\u0015;z\u0015\u0014\u00016a\u0018\u0019\u001f+c\u0014\u0019#\u001da\u0018\u001a89";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "$.b\u0019\u001d50{\u001b\u001e4,";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "2?|\u0004\u00154,4";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "?+c\u0014\u0019#\u0001o\u0006\f\";m\u0004\u0019%";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "?+c\u0014\u0019#\u0001{\u0004\u0010";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "[~|\u0013\f>,z\u0018\t<<k\u0004F";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "?+c\u0014\u0019#\u0001x\u0013\u000e\"7a\u0018";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "';|\u0005\u0015>0";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "q+|\u001aF";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "2?|\u0004\u00154,";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "#;~\u0019\u000e%\u0001o\u0004\f80h\u0019#7,k\u0007\t40m\u000f";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "0,~\u001f\u001271Q\u0004\u0019!1|\u0002#40o\u0014\u00104";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "#;~\u0019\u000e%\u0013o\u001508-z?\u001271.\u0013\u000e#1|L";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = ";-a\u0018334k\u0015\bk";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "\u00040k\u000e\f4=z\u0013\u0018k~{\u0018\u0017?1y\u0018\\%'~\u0013F";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        r2 = 50;
        r1 = "%'~\u0013";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x024a:
        r3[r2] = r1;
        r2 = 51;
        r1 = "\u0012?`V\u0012>*.\u0005\b0,zV,$-f%\u0019#(g\u0015\u0019q:{\u0013\\%1.%\u00192+|\u001f\b(\u001bv\u0015\u0019!*g\u0019\u0012";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0255:
        r3[r2] = r1;
        r2 = 52;
        r1 = "\";|\u0000\u00152;@\u0017\u00114";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x0260:
        r3[r2] = r1;
        r2 = 53;
        r1 = "\"*o\u0004\b\u0005'~\u0013F";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026b:
        r3[r2] = r1;
        r2 = 54;
        r1 = "}~m\u0019\u0011!1`\u0013\u0012%\u0010o\u001b\u0019k~`\u0003\u0010=";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0276:
        r3[r2] = r1;
        r2 = 55;
        r1 = "!5i8\u001d<;";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0281:
        r3[r2] = r1;
        r2 = 56;
        r1 = "\"*o\u0004\bq.{\u0005\u0014q-k\u0004\n8=kXR";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028c:
        r3[r2] = r1;
        r2 = 57;
        r1 = "0=z\u001f\u0013?~#V\f#1m\u0013\u000f\"\rz\u0017\u000e%\nf\u001f\u000e5\rk\u0004\n8=k";
        r0 = 56;
        r3 = r4;
        goto L_0x0009;
    L_0x0297:
        r3[r2] = r1;
        r2 = 58;
        r1 = "\"+m\u0015\u00194:.\u0002\u0013q-z\u0017\u000e%~y\u001f\b9~g\u0018\b40zL";
        r0 = 57;
        r3 = r4;
        goto L_0x0009;
    L_0x02a2:
        r3[r2] = r1;
        r2 = 59;
        r1 = "}~m\u0019\u0011!1`\u0013\u0012%\u0010o\u001b\u0019k";
        r0 = 58;
        r3 = r4;
        goto L_0x0009;
    L_0x02ad:
        r3[r2] = r1;
        r2 = 60;
        r1 = "7?g\u001a\u00195~z\u0019\\\"*o\u0004\bq)g\u0002\u0014q7`\u0002\u0019?*4";
        r0 = 59;
        r3 = r4;
        goto L_0x0009;
    L_0x02b8:
        r3[r2] = r1;
        r2 = 61;
        r1 = "37`\u0012\\#;c\u0019\b4~}\u0013\u000e'7m\u0013";
        r0 = 60;
        r3 = r4;
        goto L_0x0009;
    L_0x02c3:
        r3[r2] = r1;
        r2 = 62;
        r1 = "0=z\u001f\u0013?~#V\f#1m\u0013\u000f\"\u0012a\u0015\u001d%7a\u0018";
        r0 = 61;
        r3 = r4;
        goto L_0x0009;
    L_0x02ce:
        r3[r2] = r1;
        r2 = 63;
        r1 = "\u0017?g\u001a\u00195~z\u0019\\#;~\u0019\u000e%~|\u0013\u001f47x\u0013\u0018qs.";
        r0 = 62;
        r3 = r4;
        goto L_0x0009;
    L_0x02d9:
        r3[r2] = r1;
        r2 = 64;
        r1 = "0=z\u001f\u0013?~#V\f#1m\u0013\u000f\"\u0012a\u0015\u001d%7a\u0018Pq3}\u0011?>0z\u0013\u0012%d";
        r0 = 63;
        r3 = r4;
        goto L_0x0009;
    L_0x02e4:
        r3[r2] = r1;
        r2 = 65;
        r1 = "0=z\u001f\u0013?~#V\f0,}\u0013?%,b$\u0019\".a\u0018\u000f4";
        r0 = 64;
        r3 = r4;
        goto L_0x0009;
    L_0x02ef:
        r3[r2] = r1;
        r2 = 66;
        r1 = "\u00040k\u000e\f4=z\u0013\u0018k~{\u0018\u0017?1y\u0018\\!+}\u001e\\2*|\u001a\\23jL\\";
        r0 = 65;
        r3 = r4;
        goto L_0x0009;
    L_0x02fa:
        r3[r2] = r1;
        r2 = 67;
        r1 = "\u0002+m\u0015\u00194:.\u0002\u0013q,k\u0006\u0013#*.\u0004\u00192;g\u0000\u00195~#V";
        r0 = 66;
        r3 = r4;
        goto L_0x0009;
    L_0x0305:
        r3[r2] = r1;
        r2 = 68;
        r1 = "23j";
        r0 = 67;
        r3 = r4;
        goto L_0x0009;
    L_0x0310:
        r3[r2] = r1;
        r2 = 69;
        r1 = "<-i5\u0013?*k\u0018\bq7}V\u0012$2b";
        r0 = 68;
        r3 = r4;
        goto L_0x0009;
    L_0x031b:
        r3[r2] = r1;
        r2 = 70;
        r1 = "2*|\u001a\\|~m\u001b\u0018k";
        r0 = 69;
        r3 = r4;
        goto L_0x0009;
    L_0x0326:
        r3[r2] = r1;
        r2 = 71;
        r1 = "#;~\u0019\u000e%\u001dz\u0004\u0010\u0003;m\u0013\u0015';jV\b>~|\u0013\f>,zV\u000e4=k\u001f\n4:.\u0010\u001d82k\u0012\\|~";
        r0 = 70;
        r3 = r4;
        goto L_0x0009;
    L_0x0331:
        r3[r2] = r1;
        r2 = 72;
        r1 = "#;~\u0019\u000e%\u001dz\u0004\u0010\u0003;m\u0013\u0015';jVQq,k\u0002F";
        r0 = 71;
        r3 = r4;
        goto L_0x0009;
    L_0x033c:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0341:
        r9 = 81;
        goto L_0x0020;
    L_0x0345:
        r9 = 94;
        goto L_0x0020;
    L_0x0349:
        r9 = 14;
        goto L_0x0020;
    L_0x034d:
        r9 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.c.a.<clinit>():void");
    }

    private static JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            JSONObject jSONObject;
            JSONException jSONException = e;
            try {
                jSONObject = new JSONObject(BasePreferenceManager.getDecryptString(str, ""));
            } catch (Exception e2) {
                jSONException.printStackTrace();
                jSONObject = null;
            }
            d.a(z[1], new StringBuilder(z[48]).append(jSONObject).toString());
            return jSONObject;
        } catch (Exception e3) {
            return null;
        }
    }

    public static void a(int i) {
        try {
            if (cn.jiguang.b.a.e == null) {
                d.h(z[1], z[18]);
                return;
            }
            switch (i) {
                case 4:
                    c.b(cn.jiguang.b.a.e);
                    return;
                case 5:
                    Context context = cn.jiguang.b.a.e;
                    a(e.a().b());
                    return;
                case 6:
                case 21:
                case 22:
                    return;
                case 9:
                    c.c(cn.jiguang.b.a.e);
                    return;
                case 44:
                    j.a(cn.jiguang.b.a.e);
                    return;
                default:
                    d.c(z[1], new StringBuilder(z[17]).append(i).toString());
                    return;
            }
            d.h(z[1], new StringBuilder(z[16]).append(e.getMessage()).toString());
        } catch (Exception e) {
            d.h(z[1], new StringBuilder(z[16]).append(e.getMessage()).toString());
        }
    }

    public static void a(Context context, Handler handler, long j, JResponse jResponse) {
        Object obj;
        d.a(z[1], z[65]);
        b bVar = (b) jResponse;
        long a = bVar.a();
        long e = cn.jiguang.b.a.d.e(null);
        long g = cn.jiguang.b.a.a.g();
        int a2 = cn.jiguang.b.a.d.a();
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(0);
        outputDataUtil.writeU8(25);
        outputDataUtil.writeU64(g);
        outputDataUtil.writeU32((long) a2);
        outputDataUtil.writeU64(e);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU64(a);
        outputDataUtil.writeU16At(outputDataUtil.current(), 0);
        byte[] a3 = cn.jiguang.b.e.a.a.b.a(outputDataUtil.toByteArray(), 1);
        if (a3 == null) {
            d.h(z[1], new StringBuilder(z[71]).append(a).toString());
            obj = -1;
        } else {
            int SendData = Protocol.SendData(j, a3, 25);
            d.a(z[1], new StringBuilder(z[72]).append(SendData).toString());
            if (SendData != 0) {
                d.h(z[1], new StringBuilder(z[63]).append(a).toString());
            } else {
                d.c(z[1], new StringBuilder(z[67]).append(a).toString());
            }
            obj = null;
        }
        if (obj == null) {
            String b = bVar.b();
            d.c(z[1], new StringBuilder(z[64]).append(b).toString());
            if (cn.jiguang.e.j.a(b)) {
                d.g(z[1], z[69]);
                return;
            }
            try {
                JSONObject a4 = a(b);
                int optInt = a4.optInt(z[68]);
                d.c(z[1], new StringBuilder(z[70]).append(optInt).toString());
                switch (optInt) {
                    case 4:
                        c.b(context);
                        return;
                    case 5:
                        a(context, handler, a4);
                        return;
                    case 6:
                    case 21:
                    case 22:
                        return;
                    case 9:
                        c.c(context);
                        return;
                    case 44:
                        j.a(context);
                        return;
                    case 45:
                        b(context, a4);
                        return;
                    case 50:
                        c(context, a4);
                        return;
                    case 51:
                        d(context, a4);
                        return;
                    case 52:
                        e(context, a4);
                        return;
                    case 54:
                        a(context, a4);
                        return;
                    default:
                        d.g(z[1], new StringBuilder(z[66]).append(optInt).toString());
                        return;
                }
            } catch (Throwable e2) {
                d.f(z[1], z[4], e2);
            }
            d.f(z[1], z[4], e2);
        }
    }

    private static void a(Context context, Handler handler, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(z[0]);
            d.c(z[1], new StringBuilder(z[5]).append(jSONObject2).toString());
            if (jSONObject2.optBoolean(z[21])) {
                d.d(z[1], z[22]);
                cn.jiguang.a.b.a.a(context, false);
                return;
            }
            d.d(z[1], z[20]);
            cn.jiguang.a.b.a.a(context, true);
            cn.jiguang.a.b.a.b(context, true);
            long optLong = jSONObject2.optLong(z[19], 0);
            cn.jiguang.b.a.d.a(context, z[23], Long.valueOf(optLong > 0 ? optLong * 1000 : cn.jiguang.a.b.a.a(context)));
            a(handler);
        } catch (Throwable e) {
            d.d(z[1], z[8], e);
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            long j = jSONObject.getLong(z[6]);
            if (j < 0) {
                cn.jiguang.b.a.d.a(context, z[14], Boolean.valueOf(false));
                return;
            }
            int optInt = jSONObject.optInt(z[13], 0);
            int optInt2 = jSONObject.optInt(z[15], 0);
            if (j > 0) {
                cn.jiguang.b.a.d.a(context, new ShareValues().b(z[14], Boolean.valueOf(true)).b(z[10], Long.valueOf(j)).b(z[12], Integer.valueOf(optInt)).b(z[9], Integer.valueOf(optInt2)));
            } else {
                cn.jiguang.e.d.a(context, optInt, optInt2);
            }
        } catch (Exception e) {
            d.g(z[1], new StringBuilder(z[11]).append(e.getMessage()).toString());
        }
    }

    private static void a(Handler handler) {
        d.a(z[1], z[62]);
        Message.obtain(handler, PointerIconCompat.TYPE_HAND).sendToTarget();
    }

    private static void b(Context context, JSONObject jSONObject) {
        d.c(z[1], z[7]);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(z[0]);
            d.c(z[1], new StringBuilder(z[5]).append(jSONObject2).toString());
            long optLong = jSONObject2.optLong(z[6], 0);
            if (optLong <= 0 || optLong > cn.jiguang.a.b.a.a(context) / 1000) {
                d.g(z[2], z[4]);
                return;
            }
            cn.jiguang.b.a.d.a(context, z[3], Long.valueOf(optLong * 1000));
        } catch (Throwable e) {
            d.d(z[1], z[8], e);
        }
    }

    private static void c(Context context, JSONObject jSONObject) {
        d.c(z[1], z[57]);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(z[0]);
            d.c(z[1], new StringBuilder(z[5]).append(jSONObject2).toString());
            int optInt = jSONObject2.optInt(z[50]);
            d.a(z[1], new StringBuilder(z[53]).append(optInt).toString());
            cn.jiguang.b.d.e a = cn.jiguang.b.d.e.a();
            a.a(context);
            switch (optInt) {
                case 1:
                    String optString = jSONObject2.optString(z[55]);
                    String optString2 = jSONObject2.optString(z[52]);
                    a.a(optString, optString2, 1);
                    Intent intent = new Intent();
                    intent.setClassName(optString, optString2);
                    ComponentName startService = context.startService(intent);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (startService == null) {
                        arrayList2.add(new ComponentName(optString, optString2));
                        d.h(z[1], new StringBuilder(z[60]).append(intent).append(z[54]).toString());
                    } else {
                        arrayList.add(startService);
                        d.d(z[1], new StringBuilder(z[58]).append(intent).append(z[59]).append(startService).toString());
                    }
                    a.a(arrayList, arrayList2);
                    return;
                case 2:
                    a.a(jSONObject2.optString(z[55]), jSONObject2.optString(z[52]), 2);
                    d.c(z[1], z[61]);
                    return;
                case 10:
                    d.c(z[1], z[56]);
                    return;
                default:
                    d.c(z[1], new StringBuilder(z[49]).append(optInt).toString());
                    return;
            }
        } catch (SecurityException e) {
            d.h(z[1], z[51]);
            e.printStackTrace();
        } catch (Throwable e2) {
            d.f(z[1], z[8], e2);
        } catch (Throwable e22) {
            d.f(z[1], z[4], e22);
        }
    }

    private static void d(Context context, JSONObject jSONObject) {
        d.c(z[1], z[35]);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(z[0]);
            d.c(z[1], new StringBuilder(z[5]).append(jSONObject2).toString());
            boolean optBoolean = jSONObject2.optBoolean(z[36], false);
            String optString = jSONObject2.optString(z[42], "");
            String optString2 = jSONObject2.optString(z[31], "");
            String optString3 = jSONObject2.optString(z[25], "");
            JSONArray optJSONArray = jSONObject2.optJSONArray(z[30]);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    if (jSONObject3 != null) {
                        String optString4 = jSONObject3.optString(z[44], "");
                        String optString5 = jSONObject3.optString(z[27], "");
                        if (!(cn.jiguang.e.j.a(optString4) || cn.jiguang.e.j.a(optString5))) {
                            int a = h.a(optString4);
                            if (!optString5.startsWith(z[26])) {
                                optString5 = new StringBuilder(z[26]).append(optString5).toString();
                            }
                            if (!optString5.endsWith(HttpUtils.PATHS_SEPARATOR)) {
                                optString5 = optString5 + HttpUtils.PATHS_SEPARATOR;
                            }
                            if (a != -1 && a >= 0 && a < 3) {
                                cn.jiguang.b.a.a.a(context, new StringBuilder(z[39]).append(a).toString(), optString5);
                            }
                            d.a(z[1], new StringBuilder(z[37]).append(optString4).append(z[43]).append(optString5).append(z[29]).append(a).toString());
                        }
                    }
                }
            }
            if (!cn.jiguang.e.j.a(optString)) {
                cn.jiguang.b.a.a.a(context, z[41], optString);
            }
            if (cn.jiguang.e.j.a(optString2)) {
                cn.jiguang.b.a.a.a(context, z[24], optString2);
            }
            if (cn.jiguang.e.j.a(optString3)) {
                cn.jiguang.b.a.a.a(context, z[38], optString3);
            }
            d.c(z[1], new StringBuilder(z[28]).append(optString).append(z[34]).append(optString2).append(z[33]).append(optString3).append(z[40]).append(optBoolean).toString());
            if (optBoolean) {
                cn.jiguang.a.b.a.c(context, true);
                if (!cn.jiguang.e.a.c(context).toUpperCase().startsWith(z[32])) {
                    h.a(context);
                }
            }
        } catch (Throwable e) {
            d.f(z[1], z[4], e);
        }
    }

    private static void e(Context context, JSONObject jSONObject) {
        long j = 0;
        boolean z = false;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(z[0]);
            d.c(z[1], new StringBuilder(z[5]).append(jSONObject2).toString());
            boolean optBoolean = jSONObject2.optBoolean(z[21]);
            if (!optBoolean && jSONObject2.has(z[19])) {
                j = jSONObject2.optLong(z[19], 0);
            }
            if (!optBoolean) {
                z = true;
            }
            cn.jiguang.b.a.d.a(context, z[46], Boolean.valueOf(z));
            cn.jiguang.b.a.d.a(context, z[45], Long.valueOf(j * 1000));
            if (!optBoolean) {
                try {
                    c.a(context);
                } catch (Throwable th) {
                    d.i(z[1], new StringBuilder(z[47]).append(th.getMessage()).toString());
                }
            }
        } catch (Throwable th2) {
            d.d(z[1], z[8], th2);
        }
    }
}
