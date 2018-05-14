package cn.jiguang.b.b;

import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.b.a.a;
import cn.jiguang.b.d.b;
import cn.jiguang.b.d.c;
import cn.jiguang.b.d.h;
import cn.jiguang.b.d.j;
import cn.jiguang.c.d;
import cn.jiguang.service.Protocol;
import com.kepler.jd.login.KeplerApiManager;
import java.lang.ref.WeakReference;

public final class e {
    private static boolean d = false;
    private static final Object j = new Object();
    private static volatile e l;
    private static final String[] z;
    private g a;
    private f b;
    private HandlerThread c;
    private int e = 0;
    private int f = 0;
    private long g;
    private Context h;
    private boolean i = false;
    private WeakReference<Service> k;
    private int m;
    private int n;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 53;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0003woI\u0016\u0016g?\n\u0012\u0018gzI\u001c\u000e4~\n\n\u001ebz";
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
            case 0: goto L_0x026f;
            case 1: goto L_0x0273;
            case 2: goto L_0x0277;
            case 3: goto L_0x027b;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0005`|6\u001a\u0012x~\u0010";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "=}x\u001c\u001f\u0019sK\n\u000e:uq\b\u0019\u0012f";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0005`|";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "6wk\u0000\u0011\u001942I\f\u0012gk\b\f\u0003Zz\u001d\t\u0018ft\u0000\u0010\u0010Ws\u0000\u001b\u0019`3I\u000e\u001ep%";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u001b{x\u0000\u0010Wr~\u0000\u0012\u0012p%XNE8x\u0000\b\u00124j\u0019^\u0004`~\u001b\nWwp\u0007\u0010\u0012wk\u0000\u0011\u00194k\u0001\f\u0012u{G\f\u0012gz\u001d^\u0011fp\u0004^\u0019qg\u001d^\u0016doI\r\u0003um\u001d";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "9{?\u0007\u001b\u0003cp\u001b\u0015Wwp\u0007\u0010\u0012wk\u0000\u0011\u0019:?.\u0017\u0001q?\u001c\u000eW`pI\r\u0003um\u001d^\u0014{q\u0007\u001b\u0014`v\u0006\u0010W`w\u001b\u001b\u0016p1";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001egM\u001c\u0010\u0019}q\u000eD";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0018zS\u0006\u0019\u001ezY\b\u0017\u001bq{ISWwp\u0007\u0010\u0012wk\u0000\u0011\u0019.";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "[4m\f\r\u0007Wp\r\u001bM";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "6xm\f\u001f\u0013m?\u0005\u0011\u0010sz\r^\u001ez1I9\u001ebzI\u000b\u00074k\u0006^\u0005ql\u001d\u001f\u0005`1";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = ">g?\n\u0011\u0019zz\n\n\u001ezxI\u0010\u0018c1I9\u001ebzI\u000b\u00074k\u0006^\u0005ql\u001d\u001f\u0005`1";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "6wk\u0000\u0011\u001942I\f\u0012gk\b\f\u0003@w\f\u0010?q~\u001b\n\u0015q~\u001d";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "6wk\u0000\u0011\u001942I\u0011\u0019Xp\u000e\u0019\u0012pV\u0007^Z4|\u0006\u0010\u0019q|\u001d\u0017\u0018z%";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "6xm\f\u001f\u0013m?\u0005\u0011\u0010sz\r^\u001ez1I9\u001ebzI\u000b\u00074k\u0006^\u0005qk\u001b\u0007Y";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = ">g?\n\u0011\u0019zz\n\n\u001ezxI\u0010\u0018c1I9\u001ebzI\u000b\u00074k\u0006^\u0005qk\u001b\u0007Y";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u0018zW\f\u001f\u0005`}\f\u001f\u0003@v\u0004\u001b\u0018akE^\u0013{?\u0007\u0011\u00034q\f\u001b\u00134w\f\u001f\u0005`}\f\u001f\u00035";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "6wk\u0000\u0011\u001942I\u0011\u0019\\z\b\f\u0003vz\b\n#}r\f\u0011\u0002`?D^\u0003}r\f\u0011\u0002`K\u0000\u0013\u0012g%";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "J)\"TCJ)\"TCJ)\"TCJ)\"TCJ)\"TCJ)\"TCJ)\"TCJ)\"TCJ)\"TCJ)\"TCJ)\"TCJ)\"TC";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "6wk\u0000\u0011\u001942I\u0011\u0019Pv\u001a\u001d\u0018zq\f\u001d\u0003q{ISWwp\u0007\u0010\u0012wk\u0000\u0011\u0019.";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0007al\u0001^\u0016xm\f\u001f\u0013m?\u001a\n\u0018do\f\u001aV5>";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "[4y\u0005\u001f\u0010.";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "9{?\u0007\u001b\u0012p?\u001d\u0011Wfk\nRWVz\n\u001f\u0002gzI\u0017\u00034w\b\b\u00124l\u001c\u001d\u0014qz\r^\u0005q|\f\u0010\u0003xf";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u001fq~\u001b\n\u0015q~\u001d^Z4u\u001c\u0017\u0013.";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "\u0004qq\r^\u001fv?\u000f\u001f\u001exz\rD\u0004qq\r:\u0016`~I\u0017\u00044q\u001c\u0012\u001b";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "\u0004{|\u0002\u001b\u00034v\u001a^\u0014xp\u001a\u001b\u00134p\u001b^\u0007al\u0001^\u001egqN\nWxp\u000e\u0017\u0019";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "$qq\r^\u001fq~\u001b\nWvz\b\n";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "?q~\u001b\n\u0015q~\u001d^\u0004a|\n\u001b\u0012p?\n\u0011\u0019zz\n\n\u001e{qI\u0017\u00044~\u0005\f\u0012u{\u0010^\u0018akD\u001a\u0016`z\rPW]x\u0007\u0011\u0005q?\u0000\nY";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "6wk\u0000\u0011\u001942I\u0011\u0019\\z\b\f\u0003vz\b\n$a|\n\u001b\u0012p?D^\u0014{q\u0007\u001b\u0014`v\u0006\u0010M";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "6wk\u0000\u0011\u0019.?\u0001\u001f\u0019ps\f-\u0003{o9\u000b\u0004|?D^\u0014uqN\nWgk\u0006\u000eW`|\u0019";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "\u0004`p\u0019^\u0004qm\u001f\u0017\u0014q";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "6wk\u0000\u0011\u0019.?\u0001\u001f\u0019ps\f-\u0003{o9\u000b\u0004|?D^\u0016do\"\u001b\u000e.";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "\u001d}x\u001c\u001f\u0019s?\u001a\u001b\u0005bv\n\u001bWus\u001b\u001b\u0016pfI\r\u0003{o\f\u001a";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "8`w\f\fWwp\u0007\u0010\u0012wk\u0000\u0011\u00194l\u001d\u001f\u0003q";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "?uq\r\u0012\u00124|\u0006\u0010\u0019q|\u001d\u001b\u00134l\u001d\u001f\u0003q1";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "\"zz\u0011\u000e\u0012wk\f\u001aW9?\n\u0011\u0019zz\n\n\u001e{q:\n\u0016`zI\u001d\u0016zq\u0006\nWvzI\u0010\u0002xs";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "\u0014{q\u0007\u001b\u0014`v\u0006\u0010Zgk\b\n\u0012";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "?uq\r\u0012\u00124{\u0000\r\u0014{q\u0007\u001b\u0014`z\r^\u0004`~\u001d\u001bY";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "\u0018z[\u0000\r\u0014{q\u0007\u001b\u0014`z\r^\u0016z{I\f\u0012`m\u0010^\u0005ql\u001d\u001f\u0005`?\n\u0011\u0019z?D^\u0013qs\b\u0007M";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "\u0019qk\u001e\u0011\u0005?\u0000\rWzp\u001d^\u0014{q\u0007\u001b\u0014`?\u0006\fW|}I\u0017\u00044p\u0007\u001bWp~\u0010V\u0002gz\u001b^\u0004`p\u0019^\u0004qm\u001f\u0017\u0014q6I";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "6wk\u0000\u0011\u001942I\f\u0012`m\u0010=\u0018zq\f\u001d\u000342I\u001a\u001eg|\u0006\u0010\u0019q|\u001d\u001b\u0013@v\u0004\u001b\u0004.";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "6xm\f\u001f\u0013m?\u0001\u001f\u00044R:9(FZ:*6FK6=8ZQ";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "0}i\f^\u0002d?\u001d\u0011Wfz\u001d\f\u000e4|\u0006\u0010\u0019q|\u001dP";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "\u001ezv\u001d^\u0014{q\u001d\u001b\u000f`?\u0000\rWzj\u0005\u0012";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "=Wp\u001b\u001b";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "\u001ezv\u001d^\u0003woI\u0013\u0016z~\u000e\u001b\u0005:1G";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "#|zI\u0010\u0012`h\u0006\f\u001c}q\u000e^\u0014xv\f\u0010\u00034v\u001a^\u0014{q\u0007\u001b\u0014`z\rPWSv\u001f\u001bWaoG";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "6wk\u0000\u0011\u0019.?\u0001\u001f\u0019ps\f,\u0012gj\u0004\u001b'al\u0001";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = "\u001d}x\u001c\u001f\u0019s?\u001a\u001b\u0005bv\n\u001bWus\u001b\u001b\u0016pfI\r\u0003um\u001d\u001b\u0013";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "6wk\u0000\u0011\u001942I\u001a\u0012gk\u0006\f\u000e";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        r2 = 50;
        r1 = "\"zt\u0007\u0011\u0000z?(\u001d\u001c4m\f\u000f\u0002ql\u001d^Z4|\u0004\u001aM";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x024a:
        r3[r2] = r1;
        r2 = 51;
        r1 = "#uxI\u001f\u001b}~\u001a^\u0016wtI\r\u0002w|\f\u001b\u00135?";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0255:
        r3[r2] = r1;
        r2 = 52;
        r1 = "?q~\u001b\n\u0015q~\u001d^\u0016wtI\r\u0002w|\f\u001b\u00135?";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x0260:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        d = r0;
        r0 = new java.lang.Object;
        r0.<init>();
        j = r0;
        return;
    L_0x026f:
        r9 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        goto L_0x0020;
    L_0x0273:
        r9 = 20;
        goto L_0x0020;
    L_0x0277:
        r9 = 31;
        goto L_0x0020;
    L_0x027b:
        r9 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.b.e.<clinit>():void");
    }

    private e() {
    }

    public static e a() {
        if (l == null) {
            synchronized (j) {
                if (l == null) {
                    l = new e();
                }
            }
        }
        return l;
    }

    static /* synthetic */ void a(e eVar, long j) {
        d.d(z[2], new StringBuilder(z[13]).append(j).toString());
        d = true;
        eVar.e = 0;
        eVar.f = 0;
        c.a(eVar.h.getApplicationContext(), a.a);
        eVar.b.sendEmptyMessageDelayed(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist, 15000);
        h.a().c();
        eVar.b.sendEmptyMessageDelayed(1032, 2000);
        cn.jiguang.a.c.c.d(eVar.h);
        b.a();
        b.a(eVar.h, j, 1);
    }

    static /* synthetic */ void a(e eVar, boolean z) {
        if (z || System.currentTimeMillis() - eVar.g >= 18000) {
            d.d(z[2], z[26]);
            eVar.b.removeMessages(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist);
            if (g.b.get() || !d) {
                d.a(z[2], z[25]);
                return;
            }
            Long valueOf = Long.valueOf(a.g());
            int a = cn.jiguang.b.a.d.a();
            long e = cn.jiguang.b.a.d.e(eVar.h);
            short c = h.a().c();
            d.c(z[2], new StringBuilder(z[23]).append(e).append(z[21]).append(c).toString());
            long longValue = valueOf.longValue();
            OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
            outputDataUtil.writeU16(0);
            outputDataUtil.writeU8(4);
            outputDataUtil.writeU8(2);
            outputDataUtil.writeU64(longValue);
            outputDataUtil.writeU32((long) a);
            outputDataUtil.writeU64(e);
            outputDataUtil.writeU8(c);
            outputDataUtil.writeU16At(outputDataUtil.current(), 0);
            byte[] a2 = cn.jiguang.b.e.a.a.b.a(outputDataUtil.toByteArray(), 1);
            if (a2 != null) {
                Protocol.SendData(g.a.get(), a2, 3);
            } else {
                d.h(z[2], z[24]);
            }
            if (!eVar.b.hasMessages(KeplerApiManager.KeplerApiManagerActionErr_TokenLast)) {
                eVar.b.sendEmptyMessageDelayed(KeplerApiManager.KeplerApiManagerActionErr_TokenLast, 10000);
                return;
            }
            return;
        }
        d.a(z[2], z[22]);
    }

    public static void a(String str, Object obj) {
        h.a().a(str, obj);
    }

    public static void a(byte[] bArr, String str, int i) {
        h.a().a(bArr, str, i);
    }

    static /* synthetic */ void b(e eVar) {
        if (!(eVar.k == null || eVar.k.get() == null)) {
            d.c(z[2], z[30]);
            ((Service) eVar.k.get()).stopSelf();
        }
        cn.jiguang.e.a.i(eVar.h);
        j.a();
        j.c();
        eVar.c();
    }

    static /* synthetic */ void b(e eVar, long j) {
        d.d(z[2], new StringBuilder(z[19]).append(j).toString());
        d = false;
        h.a().b();
        if (g.a.get() == 0 && cn.jiguang.b.a.d.k(eVar.h)) {
            d.c(z[2], z[20]);
            return;
        }
        b.a();
        b.a(eVar.h, j, -1);
        eVar.f = 0;
        c.a(eVar.h.getApplicationContext(), a.b);
        if (eVar.a != null) {
            eVar.a.c();
        }
        if (cn.jiguang.e.a.b(eVar.h.getApplicationContext())) {
            eVar.j();
        }
        eVar.e++;
    }

    static /* synthetic */ void c(e eVar, long j) {
        d.d(z[2], new StringBuilder(z[28]).append(j).toString());
        if (j != g.a.get()) {
            d.c(z[2], z[27]);
            return;
        }
        if (eVar.b.hasMessages(KeplerApiManager.KeplerApiManagerActionErr_TokenLast)) {
            eVar.b.removeMessages(KeplerApiManager.KeplerApiManagerActionErr_TokenLast);
        }
        eVar.g = System.currentTimeMillis();
        eVar.f = 0;
        b.a();
        b.a(eVar.h, j, 19);
    }

    static /* synthetic */ void d(e eVar) {
        if (h.a().g()) {
            eVar.f++;
            d.d(z[2], new StringBuilder(z[17]).append(eVar.f).toString());
            d.b(z[2], z[18]);
            if (i()) {
                d.d(z[2], z[15]);
                eVar.b.sendEmptyMessageDelayed(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist, 10000);
                return;
            } else if (!d || eVar.h()) {
                if (eVar.a != null) {
                    eVar.a.a();
                }
                eVar.j();
                return;
            } else {
                d.d(z[2], z[14]);
                eVar.b.sendEmptyMessageDelayed(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist, 5000);
                return;
            }
        }
        d.a(z[2], z[16]);
    }

    public static boolean d() {
        return d;
    }

    public static long g() {
        return g.a.get();
    }

    private boolean h() {
        return this.f > 1;
    }

    private static boolean i() {
        return (g.a.get() == 0 || d) ? false : true;
    }

    private void j() {
        d.d(z[2], new StringBuilder(z[40]).append(this.e).toString());
        if (!cn.jiguang.e.a.b(this.h.getApplicationContext()) || c.a()) {
            d.d(z[2], z[39]);
            return;
        }
        int d = cn.jiguang.e.a.d(this.h.getApplicationContext());
        int pow = (int) ((Math.pow(2.0d, (double) this.e) * 3.0d) * 1000.0d);
        int h = a.h();
        if (pow > (h * 1000) / 2) {
            pow = (h * 1000) / 2;
        }
        if (this.e >= 5 && d != 1) {
            d.c(z[2], z[42]);
        } else if (this.b.hasMessages(PointerIconCompat.TYPE_COPY)) {
            d.c(z[2], z[41]);
        } else {
            d.d(z[2], new StringBuilder(z[38]).append(pow).toString());
            this.b.sendEmptyMessageDelayed(PointerIconCompat.TYPE_COPY, (long) pow);
        }
    }

    public final void a(int i) {
        this.m = i;
    }

    public final void a(Service service) {
        if (service != null) {
            this.k = new WeakReference(service);
        }
    }

    public final void a(Context context) {
        if (!this.i) {
            if (context == null) {
                d.c(z[2], z[43]);
                return;
            }
            d.c(z[2], z[45]);
            this.h = context.getApplicationContext();
            if (!cn.jiguang.b.a.d.k(context)) {
                cn.jiguang.e.a.h(this.h);
            }
            try {
                if (this.c == null || !this.c.isAlive()) {
                    this.c = new HandlerThread(z[44]);
                    this.c.start();
                }
                this.b = new f(this, this.c.getLooper() == null ? Looper.getMainLooper() : this.c.getLooper());
            } catch (Exception e) {
                this.b = new f(this, Looper.getMainLooper());
            }
            j.a().a(this.h);
            h.a().a(this.h, this.b);
            this.i = true;
        }
    }

    public final void a(Bundle bundle) {
        if (cn.jiguang.b.a.d.k(this.h)) {
            d.g(z[2], z[0]);
            return;
        }
        cn.jiguang.e.a.j(this.h);
        String string = bundle.getString(z[36]);
        if (cn.jiguang.e.j.a(string)) {
            d.c(z[2], z[35]);
        } else if (string.equals(a.a.name())) {
            d.c(z[2], z[34]);
            if (g.a.get() == 0) {
                e();
            } else {
                this.b.sendEmptyMessage(PointerIconCompat.TYPE_CELL);
            }
        } else if (string.equals(a.b.name())) {
            d.c(z[2], z[37]);
        } else {
            d.c(z[2], z[33]);
        }
        cn.jiguang.e.a.a();
    }

    public final void a(JResponse jResponse, long j) {
        int a = ((cn.jiguang.b.e.a.a) jResponse).a();
        if (a == 2) {
            d.c(z[2], z[52]);
            c.a(Message.obtain(this.b, 7303), j);
        } else if (a == 10) {
            d.c(z[2], z[51]);
            jResponse.getHead().a(Long.valueOf(-1));
        } else {
            d.g(z[2], new StringBuilder(z[50]).append(a).toString());
        }
    }

    public final void a(String str, Bundle bundle) {
        d.c(z[2], z[47]);
        b.a();
        b.a(this.h, str, g.a.get(), bundle, this.b);
        if (cn.jiguang.b.a.d.k(this.h)) {
            b.a(this.h, true);
            cn.jiguang.b.a.d.b(this.h, false);
            if (g.a.get() == 0) {
                f();
                return;
            } else {
                d.c(z[2], z[46]);
                return;
            }
        }
        d.d(z[2], z[48]);
    }

    public final void a(String str, Bundle bundle, String str2) {
        d.c(z[2], new StringBuilder(z[31]).append(str2).toString());
        b.a();
        b.a(this.h, str, g.a.get(), bundle, this.b);
        if (cn.jiguang.b.a.d.k(this.h)) {
            d.d(z[2], z[32]);
            return;
        }
        h.a();
        if (h.f()) {
            b.a(this.h, false);
            cn.jiguang.b.a.d.b(this.h, true);
            if (!(this.k == null || this.k.get() == null)) {
                d.c(z[2], z[30]);
                ((Service) this.k.get()).stopSelf();
            }
            c();
            return;
        }
        d.c(z[2], z[29]);
    }

    public final Handler b() {
        return this.b;
    }

    public final void b(int i) {
        this.n = i;
    }

    public final void b(Bundle bundle) {
        if (cn.jiguang.b.a.d.k(this.h)) {
            d.d(z[2], z[0]);
            return;
        }
        cn.jiguang.e.a.j(this.h);
        if (g.a.get() == 0) {
            e();
        } else {
            int i = bundle.getInt(z[1], 0);
            if (cn.jiguang.e.j.a(bundle.getString(z[3]))) {
                this.b.sendEmptyMessage(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist);
            } else if (i == 0) {
                this.b.removeMessages(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist);
                if (!this.b.hasMessages(1004)) {
                    this.b.sendEmptyMessage(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist);
                }
            } else {
                this.b.removeMessages(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist);
                this.b.removeMessages(1004);
                this.b.sendEmptyMessageDelayed(1004, (long) i);
            }
        }
        cn.jiguang.e.a.a();
    }

    public final void c() {
        d.c(z[2], z[49]);
        d = false;
        this.e = 0;
        this.f = 0;
        c.a(this.h, a.b);
        if (this.a != null) {
            this.a.c();
        }
    }

    public final void e() {
        d.b(z[2], z[12]);
        if (i()) {
            d.d(z[2], z[11]);
        } else if (!d || h()) {
            this.b.removeMessages(PointerIconCompat.TYPE_COPY);
            this.b.removeMessages(KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist);
            f();
        } else {
            d.d(z[2], z[10]);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = z;	 Catch:{ all -> 0x0050 }
        r1 = 2;
        r0 = r0[r1];	 Catch:{ all -> 0x0050 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0050 }
        r2 = z;	 Catch:{ all -> 0x0050 }
        r3 = 4;
        r2 = r2[r3];	 Catch:{ all -> 0x0050 }
        r1.<init>(r2);	 Catch:{ all -> 0x0050 }
        r2 = android.os.Process.myPid();	 Catch:{ all -> 0x0050 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0050 }
        r1 = r1.toString();	 Catch:{ all -> 0x0050 }
        cn.jiguang.c.d.d(r0, r1);	 Catch:{ all -> 0x0050 }
        r0 = r4.h;	 Catch:{ all -> 0x0050 }
        r0 = r0.getApplicationContext();	 Catch:{ all -> 0x0050 }
        r0 = cn.jiguang.e.a.b(r0);	 Catch:{ all -> 0x0050 }
        if (r0 != 0) goto L_0x003a;
    L_0x002b:
        r0 = z;	 Catch:{ all -> 0x0050 }
        r1 = 2;
        r0 = r0[r1];	 Catch:{ all -> 0x0050 }
        r1 = z;	 Catch:{ all -> 0x0050 }
        r2 = 6;
        r1 = r1[r2];	 Catch:{ all -> 0x0050 }
        cn.jiguang.c.d.f(r0, r1);	 Catch:{ all -> 0x0050 }
    L_0x0038:
        monitor-exit(r4);
        return;
    L_0x003a:
        r0 = r4.h;	 Catch:{ all -> 0x0050 }
        r0 = cn.jiguang.b.a.d.k(r0);	 Catch:{ all -> 0x0050 }
        if (r0 == 0) goto L_0x0053;
    L_0x0042:
        r0 = z;	 Catch:{ all -> 0x0050 }
        r1 = 2;
        r0 = r0[r1];	 Catch:{ all -> 0x0050 }
        r1 = z;	 Catch:{ all -> 0x0050 }
        r2 = 0;
        r1 = r1[r2];	 Catch:{ all -> 0x0050 }
        cn.jiguang.c.d.d(r0, r1);	 Catch:{ all -> 0x0050 }
        goto L_0x0038;
    L_0x0050:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x0053:
        r0 = r4.m;	 Catch:{ all -> 0x0050 }
        r1 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r0 != r1) goto L_0x0067;
    L_0x0059:
        r0 = z;	 Catch:{ all -> 0x0050 }
        r1 = 2;
        r0 = r0[r1];	 Catch:{ all -> 0x0050 }
        r1 = z;	 Catch:{ all -> 0x0050 }
        r2 = 5;
        r1 = r1[r2];	 Catch:{ all -> 0x0050 }
        cn.jiguang.c.d.h(r0, r1);	 Catch:{ all -> 0x0050 }
        goto L_0x0038;
    L_0x0067:
        r0 = r4.a;	 Catch:{ all -> 0x0050 }
        if (r0 == 0) goto L_0x0093;
    L_0x006b:
        r0 = z;	 Catch:{ all -> 0x0050 }
        r1 = 2;
        r0 = r0[r1];	 Catch:{ all -> 0x0050 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0050 }
        r2 = z;	 Catch:{ all -> 0x0050 }
        r3 = 7;
        r2 = r2[r3];	 Catch:{ all -> 0x0050 }
        r1.<init>(r2);	 Catch:{ all -> 0x0050 }
        r2 = r4.a;	 Catch:{ all -> 0x0050 }
        r2 = r2.e();	 Catch:{ all -> 0x0050 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0050 }
        r1 = r1.toString();	 Catch:{ all -> 0x0050 }
        cn.jiguang.c.d.d(r0, r1);	 Catch:{ all -> 0x0050 }
        r0 = r4.a;	 Catch:{ all -> 0x0050 }
        r0 = r0.e();	 Catch:{ all -> 0x0050 }
        if (r0 != 0) goto L_0x0038;
    L_0x0093:
        r0 = r4.a;	 Catch:{ all -> 0x0050 }
        if (r0 == 0) goto L_0x009f;
    L_0x0097:
        r0 = r4.a;	 Catch:{ all -> 0x0050 }
        r0.c();	 Catch:{ all -> 0x0050 }
        r0 = 0;
        r4.a = r0;	 Catch:{ all -> 0x0050 }
    L_0x009f:
        r0 = new cn.jiguang.b.b.g;	 Catch:{ all -> 0x0050 }
        r1 = r4.h;	 Catch:{ all -> 0x0050 }
        r1 = r1.getApplicationContext();	 Catch:{ all -> 0x0050 }
        r2 = r4.b;	 Catch:{ all -> 0x0050 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0050 }
        r4.a = r0;	 Catch:{ all -> 0x0050 }
        r0 = r4.a;	 Catch:{ all -> 0x0050 }
        r0.b();	 Catch:{ all -> 0x0050 }
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.b.e.f():void");
    }
}
