package cn.jiguang.e;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.support.v4.media.TransportMediator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import cn.jiguang.b.a.c;
import cn.jiguang.b.d.h;
import cn.jiguang.b.f.b;
import cn.jiguang.b.f.e;
import cn.jiguang.c.d;
import cn.jpush.android.service.AlarmReceiver;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.service.PushService;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.security.auth.x500.X500Principal;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static int a = 1;
    private static List<String> b;
    private static long c = 0;
    private static final ArrayList<String> d = new ArrayList();
    private static final ArrayList<String> e = new ArrayList();
    private static final ArrayList<String> f;
    private static PushReceiver g;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 167; // 0xa7 float:2.34E-43 double:8.25E-322;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "*='";
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
            case 0: goto L_0x077a;
            case 1: goto L_0x077e;
            case 2: goto L_0x0782;
            case 3: goto L_0x0786;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
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
            case 123: goto L_0x0578;
            case 124: goto L_0x0583;
            case 125: goto L_0x058e;
            case 126: goto L_0x0599;
            case 127: goto L_0x05a4;
            case 128: goto L_0x05af;
            case 129: goto L_0x05ba;
            case 130: goto L_0x05c5;
            case 131: goto L_0x05d0;
            case 132: goto L_0x05db;
            case 133: goto L_0x05e6;
            case 134: goto L_0x05f1;
            case 135: goto L_0x05fc;
            case 136: goto L_0x0607;
            case 137: goto L_0x0612;
            case 138: goto L_0x061d;
            case 139: goto L_0x0628;
            case 140: goto L_0x0633;
            case 141: goto L_0x063e;
            case 142: goto L_0x0649;
            case 143: goto L_0x0654;
            case 144: goto L_0x065f;
            case 145: goto L_0x066a;
            case 146: goto L_0x0675;
            case 147: goto L_0x0680;
            case 148: goto L_0x068b;
            case 149: goto L_0x0696;
            case 150: goto L_0x06a1;
            case 151: goto L_0x06ac;
            case 152: goto L_0x06b7;
            case 153: goto L_0x06c2;
            case 154: goto L_0x06cd;
            case 155: goto L_0x06d8;
            case 156: goto L_0x06e3;
            case 157: goto L_0x06ee;
            case 158: goto L_0x06f9;
            case 159: goto L_0x0704;
            case 160: goto L_0x070f;
            case 161: goto L_0x071a;
            case 162: goto L_0x0725;
            case 163: goto L_0x0730;
            case 164: goto L_0x073b;
            case 165: goto L_0x0746;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = " \u001cf^##L2\u001b\u001c\u0015\u0016`";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "&\u0017v\f\u0001\u000e\u001dG\n\u0007\u000b";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "$\u000bw\u001f\u001a\u0002Yt\u0017\u0002\u0002Y{\u0010N\u0014\u001dq\u001f\u001c\u0003Yw\f\u001c\b\u000b";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\n\u0012v\u0017\u001cG\u0010|^\u001d\u0003\u001as\f\nG\u001c`\f\u0001\u0015";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0010\u000b{\n\u000bG\u001dw\b\u0007\u0004\u001c{\u001aN\u0002\u000b`\u0011\u001c";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0000\u001cf^\u001d\u0003\u001as\f\nG\u001ds\n\u000fG\ts\n\u0006G\u001f{\u001f\u0002";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "4\u0018d\u001b\nG\u001dw\b\u0007\u0004\u001c{\u001aN\u000e\u0017f\u0011N\u0001\u0010~\u001b";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "I\tg\r\u00068\u001dw\b\u0007\u0004\u001c{\u001a";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0000\u001cf^\n\u0002\u000f{\u001d\u000bG\u0010v^N\u0014\u001d2\u001d\u000f\u0015\u001d2\u0018\u0007\u000b\u001c2\u000e\u000f\u0013\u00112\u0018\u000f\u000e\u0015";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0005\u000bs\u0010\nGD2";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "1N<O";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "PW#^\u0019\u000e\u0015~^\u0000\b\r2\u0019\u000b\u0013Ye\u0017\b\u000eY~\u0017\u001d\u0013";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "?\u0010s\u0011\u0003\u000e";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0015\u0016<\u001c\u001b\u000e\u0015vP\u0018\u0002\u000ba\u0017\u0001\tW{\u0010\r\u0015\u001c\u001b\u0000\u0013\u0018~";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u0015\u0016<\u000e\u001c\b\u001dg\u001d\u001aI\u001b`\u001f\u0000\u0003";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u0015\u0016<\u0013\u0007\u0012\u0010<\u000b\u0007I\u000fw\f\u001d\u000e\u0016|P\u0000\u0006\u0014w";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u000f\u0018a,\u000b\u0004\u001c{\b\u000b\u0015Yw\f\u001c\b\u000b(";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "*8Q^\u000f\u0003\u001d`^\u0007\t\u001f}SCJT2";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\u0013\u0000b\u001b";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u000e\r{\u0013\u000b";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\u0003\u0018f\u001f";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0002\u0014b\n\u0017G\ts\f\u000f\n\n";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u000f\u0018a.\u000b\u0015\u0014{\r\u001d\u000e\u0016|:\u000b\u0001\u0010|\u001b\nG\u001c`\f\u0001\u0015C";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "H\t`\u0011\rH\u001ab\u000b\u0007\t\u001f}";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "7\u000b}\u001d\u000b\u0014\n}\f";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "(DS\u0010\n\u0015\u0016{\u001a";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "$7/?\u0000\u0003\u000b}\u0017\nG=w\u001c\u001b\u0000";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "?W'NW";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "$DG-";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "$7/?\u0000\u0003\u000b}\u0017\nG=w\u001c\u001b\u0000U]C/\t\u001d`\u0011\u0007\u0003UQC;4";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "\n\n<";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "\u0006\u0015s\f\u0003";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "/\u001cs\f\u001a\u0005\u001cs\nN\u000e\u0017f\u001b\u001c\u0011\u0018~^SG";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "5\u001ca\u001b\u001aG\u0011w\u001f\u001c\u0013\u001bw\u001f\u001aG\u0018~\u001f\u001c\nW";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "\u0004\u0018|Y\u001aG\r`\u0017\t\u0000\u001c`^\u000f\u000b\u0018`\u0013N\u0004\u0018g\r\u000bG\u001bk^\u000b\u001f\u001aw\u000e\u001a\u000e\u0016|D";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "^N%J\nROvHVU\u001c'JW\u0004";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "$\u0018|\u001d\u000b\u000bYz\u001b\u000f\u0015\rp\u001b\u000f\u0013Ys\u0012\u000f\u0015\u00142\u0018\u000f\u000e\u0015w\u001a@";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = " \u0016f^\u001d\u0003\u001as\f\nG\u001f{\u0012\u000bG\ns\b\u000b\u0003Yv\u001b\u0018\u000e\u001aw7\nGT2";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "\u0012\rtSV";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P<\"8V!+?-W, &5M-:(+S9+";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P950F;1\"!F;<)8^!=36@?)\"";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "$\u0018|^\u0000\b\r2\u000b\u001d\u0002Yw\u0006\u001a\u0002\u000b|\u001f\u0002G\nf\u0011\u001c\u0002\u001ew";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "4=Q\u001f\u001c\u0003Y{\rN\t\u0016f^\u0003\b\f|\n\u000b\u0003";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "\n\u0016g\u0010\u001a\u0002\u001d";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "\u0017\u0011}\u0010\u000b";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "\u0000\u001cf^\u0003\u0006\u001a2\u0018\u001c\b\u00142\t\u0007\u0001\u0010_\u001f\u0000\u0006\u001ew\fN\u0001\u0018{\u0012\u000b\u0003Y";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "\n\u0018q^\u000f\u0003\u001d`\u001b\u001d\u0014Yt\f\u0001\nYE\u0017\b\u000e4s\u0010\u000f\u0000\u001c`D";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P/$:W-=8.[8'8*F?:\"";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "\u0010\u0010t\u0017";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        r2 = 50;
        r1 = "5\u001c~\u001b\u000f\u0014\u001c2\t\u000f\f\u001c2\u0012\u0001\u0004\u00122\u001b\u0016\u0004\u001cb\n\u0007\b\u0017";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x024a:
        r3[r2] = r1;
        r2 = 51;
        r1 = "&\u0017v\f\u0001\u000e\u001dG\n\u0007\u000bY`\u001b\u0002\u0002\u0018a\u001b9\u0006\u0012w\u0012\u0001\u0004\u001227\u0002\u000b\u001cu\u001f\u00024\rs\n\u000b\"\u0001q\u001b\u001e\u0013\u0010}\u0010N\u0002\u000b`\u0010\u0001";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0255:
        r3[r2] = r1;
        r2 = 52;
        r1 = "0\u0018y\u001b\u0002\b\u001ay^\u0007\u0014Y|\u0011\u001aG\u0011w\u0012\nIY\\\u0011N\t\u001cw\u001aN\u0013\u00162\f\u000b\u000b\u001cs\r\u000bI";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x0260:
        r3[r2] = r1;
        r2 = 53;
        r1 = "&\u0017v\f\u0001\u000e\u001dG\n\u0007\u000bY`\u001b\u0002\u0002\u0018a\u001b9\u0006\u0012w\u0012\u0001\u0004\u00122\u001b\u001c\u0015\u0017}";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026b:
        r3[r2] = r1;
        r2 = 54;
        r1 = "5\u001c~\u001b\u000f\u0014\u001cv^\u0019\u0006\u0012w^\u0002\b\u001ay^CG\u0014{\u0012\u0002\u000e\nw\u001d\u0001\t\u001daD";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0276:
        r3[r2] = r1;
        r2 = 55;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P<\"8V!>/6\\;14-S*+";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0281:
        r3[r2] = r1;
        r2 = 56;
        r1 = "\u0004\u0016|\u0010\u000b\u0004\r{\b\u0007\u0013\u0000";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028c:
        r3[r2] = r1;
        r2 = 57;
        r1 = "<IOT";
        r0 = 56;
        r3 = r4;
        goto L_0x0009;
    L_0x0297:
        r3[r2] = r1;
        r2 = 58;
        r1 = " \u001cf^\u0007\n\u001c{^\u0001\fY3";
        r0 = 57;
        r3 = r4;
        goto L_0x0009;
    L_0x02a2:
        r3[r2] = r1;
        r2 = 59;
        r1 = "3\u0011w^\u0007\n\u001c{^\u0007\u0014Yw\u0013\u001e\u0013\u00003";
        r0 = 58;
        r3 = r4;
        goto L_0x0009;
    L_0x02ad:
        r3[r2] = r1;
        r2 = 60;
        r1 = "<\u0018?\u0018^J@SS(:\u0002#J\u0013";
        r0 = 59;
        r3 = r4;
        goto L_0x0009;
    L_0x02b8:
        r3[r2] = r1;
        r2 = 61;
        r1 = "<I?G3\u001cH'\u0003";
        r0 = 60;
        r3 = r4;
        goto L_0x0009;
    L_0x02c3:
        r3[r2] = r1;
        r2 = 62;
        r1 = " \u001cf^\u0007\n\u001c{^\u0007\u0014Ys\u0012\u0002GI2_";
        r0 = 61;
        r3 = r4;
        goto L_0x0009;
    L_0x02ce:
        r3[r2] = r1;
        r2 = 63;
        r1 = " \u001cf^\u0003\u0002\u0010v^\u000f\u0014Ys^\u0007\n\u001c{^O";
        r0 = 62;
        r3 = r4;
        goto L_0x0009;
    L_0x02d9:
        r3[r2] = r1;
        r2 = 64;
        r1 = "&\u001af\u0017\u0001\tCu\u001b\u001a4\u0018d\u001b\n2\f{\u001a";
        r0 = 63;
        r3 = r4;
        goto L_0x0009;
    L_0x02e4:
        r3[r2] = r1;
        r2 = 65;
        r1 = "7\u000bw\u0018\u001d!\u0010~\u001b";
        r0 = 64;
        r3 = r4;
        goto L_0x0009;
    L_0x02ef:
        r3[r2] = r1;
        r2 = 66;
        r1 = "\f\u001ck";
        r0 = 65;
        r3 = r4;
        goto L_0x0009;
    L_0x02fa:
        r3[r2] = r1;
        r2 = 67;
        r1 = "4\u0018d\u001b\nG\fv\u0017\nG\u0010|\n\u0001G\u001f{\u0012\u000b";
        r0 = 66;
        r3 = r4;
        goto L_0x0009;
    L_0x0305:
        r3[r2] = r1;
        r2 = 68;
        r1 = "\u0012\u001d{\u001aN\u0001\u0010~\u001bN\u0017\u0018f\u0016N\u000e\n2\u0010\u001b\u000b\u0015";
        r0 = 67;
        r3 = r4;
        goto L_0x0009;
    L_0x0310:
        r3[r2] = r1;
        r2 = 69;
        r1 = "\u0010\u000b{\n\u000bG\u001f{\u0012\u000bG\u001c`\f\u0001\u0015";
        r0 = 68;
        r3 = r4;
        goto L_0x0009;
    L_0x031b:
        r3[r2] = r1;
        r2 = 70;
        r1 = " \u0016f^\u001d\u0003\u001as\f\nG\u001f{\u0012\u000bG\ns\b\u000b\u0003Yg\u001a\u0007\u0003Y?^";
        r0 = 69;
        r3 = r4;
        goto L_0x0009;
    L_0x0326:
        r3[r2] = r1;
        r2 = 71;
        r1 = "I\tg\r\u00068\fv\u0017\n";
        r0 = 70;
        r3 = r4;
        goto L_0x0009;
    L_0x0331:
        r3[r2] = r1;
        r2 = 72;
        r1 = "$\u0018|^\u0000\b\r2\f\u000b\u0006\u001d2\u0018\u001c\b\u00142\r\u000b\u0013\r{\u0010\t\u0014";
        r0 = 71;
        r3 = r4;
        goto L_0x0009;
    L_0x033c:
        r3[r2] = r1;
        r2 = 73;
        r1 = "\u0003\u001cd\u001d\u0007\u0002&{\u001a1\u0000\u001c|\u001b\u001c\u0006\rw\u001a";
        r0 = 72;
        r3 = r4;
        goto L_0x0009;
    L_0x0347:
        r3[r2] = r1;
        r2 = 74;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P950F;14<F*')>A";
        r0 = 73;
        r3 = r4;
        goto L_0x0009;
    L_0x0352:
        r3[r2] = r1;
        r2 = 75;
        r1 = "$\u0015w\u001f\u001cG\u000bw\u0019\u0007\u0014\rw\f\u000b\u0003Yv\u001f\u001a\u0006Ys\u0010\nG\u001dw\b\u0007\u0004\u001c2\u0017\nG";
        r0 = 74;
        r3 = r4;
        goto L_0x0009;
    L_0x035d:
        r3[r2] = r1;
        r2 = 76;
        r1 = "2\tv\u001f\u001a\u0002Yt\f\u0001\nYs^\u0018\u0002\u000ba\u0017\u0001\tYw\u001f\u001c\u000b\u0010w\fN\u0013\u0011s\u0010NVA\"^B\b\u000b2\u0018\u0007\u0014\r2\n\u0007\n\u001c2\u0017\u0000\u0014\rs\u0012\u0002G3B\u000b\u001d\u000f*V5@";
        r0 = 75;
        r3 = r4;
        goto L_0x0009;
    L_0x0368:
        r3[r2] = r1;
        r2 = 77;
        r1 = ")\u001ce:\u000b\u0011\u0010q\u001bT.4W7N\b\u000b2?\u0000\u0003\u000b}\u0017\n.\u001d2\u0016\u000f\u0003Yq\u0016\u000f\t\u001ew\u001aO";
        r0 = 76;
        r3 = r4;
        goto L_0x0009;
    L_0x0373:
        r3[r2] = r1;
        r2 = 78;
        r1 = "4\u0018\u001bN.4W7N\u0006\u0017v^\u000f\t\u001d`\u0011\u0007\u00030v_";
        r0 = 77;
        r3 = r4;
        goto L_0x0009;
    L_0x037e:
        r3[r2] = r1;
        r2 = 79;
        r1 = "7\fa\u0016<\u0002\u001aw\u0017\u0018\u0002\u000b2\r\u0006\b\f~\u001aN\t\u0016f^\u0006\u0006\u000fw^\u0007\t\rw\u0010\u001aG\u001f{\u0012\u001a\u0002\u000b2SCG\u0018|\u001a\u001c\b\u0010vP\u0007\t\rw\u0010\u001aI\u0018q\n\u0007\b\u0017<<!(-M=!*)^;:\"=>^>\u000b\u001cs\r\u000bG\u000bw\u0013\u0001\u0011\u001c2\n\u0006\u0002Y{\u0010\u001a\u0002\u0017f^\b\u000e\u0015f\u001b\u001cG\u0010|^/\t\u001d`\u0011\u0007\u00034s\u0010\u0007\u0001\u001ca\n@\u001f\u0014~";
        r0 = 78;
        r3 = r4;
        goto L_0x0009;
    L_0x0389:
        r3[r2] = r1;
        r2 = 80;
        r1 = "&\u0017v\f\u0001\u000e\u001d_\u001f\u0000\u000e\u001fw\r\u001aI\u0001\u0012N\n\u0010a\r\u0007\t\u001e2\f\u000b\u0016\f{\f\u000b\u0003Y`\u001b\r\u0002\u0010d\u001b\u001c]Y";
        r0 = 79;
        r3 = r4;
        goto L_0x0009;
    L_0x0394:
        r3[r2] = r1;
        r2 = 81;
        r1 = "3\u0011w^\u001e\u0002\u000b\u0017\u001d\u0014\u0016{\u0010N\u000e\n2\f\u000b\u0016\f{\f\u000b\u0003Y?^\u000f\t\u001d`\u0011\u0007\u0003Wb\u001b\u001c\n\u0010a\r\u0007\b\u0017<)<.-W!+?-W, &5M-:(+S9+";
        r0 = 80;
        r3 = r4;
        goto L_0x0009;
    L_0x039f:
        r3[r2] = r1;
        r2 = 82;
        r1 = "\u0006\u001af\u0017\u0001\tCq\u0016\u000b\u0004\u0012D\u001f\u0002\u000e\u001d_\u001f\u0000\u000e\u001fw\r\u001a";
        r0 = 81;
        r3 = r4;
        goto L_0x0009;
    L_0x03aa:
        r3[r2] = r1;
        r2 = 83;
        r1 = "3\u0011w^\u001e\u0002\u000b\u0017\u001d\u0014\u0016{\u0010N\u000e\n2\f\u000b\u0016\f{\f\u000b\u0003Y?^\u000f\t\u001d`\u0011\u0007\u0003Wb\u001b\u001c\n\u0010a\r\u0007\b\u0017<)<.-W!=\"-F7  *";
        r0 = 82;
        r3 = r4;
        goto L_0x0009;
    L_0x03b5:
        r3[r2] = r1;
        r2 = 84;
        r1 = "3\u0011w^\u001e\u0002\u000b\u0017\u001d\u0014\u0010}\u0010N\u0014\u0011}\u000b\u0002\u0003Yp\u001bN\u0003\u001ct\u0017\u0000\u0002\u001d2SN";
        r0 = 83;
        r3 = r4;
        goto L_0x0009;
    L_0x03c0:
        r3[r2] = r1;
        r2 = 85;
        r1 = "KY}\n\u0006\u0002\u000be\u0017\u001d\u0002Yk\u0011\u001bG\u001as\u0010N\t\u0016f^\u0002\b\u001as\n\u000bG\rz\u001bN\u0003\u001cd\u0017\r\u0002\n<";
        r0 = 84;
        r3 = r4;
        goto L_0x0009;
    L_0x03cb:
        r3[r2] = r1;
        r2 = 86;
        r1 = "0\u001c2\f\u000b\u0004\u0016\u0013\u000b\t\u001d2\u0007\u0001\u0012Ys\u001a\nG\rz\u001bN\u0017\u001c`\u0013\u0007\u0014\n{\u0011\u0000GT2";
        r0 = 85;
        r3 = r4;
        goto L_0x0009;
    L_0x03d6:
        r3[r2] = r1;
        r2 = 87;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u0017\u0000\u0013\u001c|\n@\u0006\u001af\u0017\u0001\tWP1!3&Q1#75W*+#";
        r0 = 86;
        r3 = r4;
        goto L_0x0009;
    L_0x03e1:
        r3[r2] = r1;
        r2 = 88;
        r1 = "&\u0017v\f\u0001\u000e\u001d_\u001f\u0000\u000e\u001fw\r\u001aI\u0001\u0012N\n\u0010a\r\u0007\t\u001e2\f\u000b\u0016\f{\f\u000b\u0003Ya\u001b\u001c\u0011\u0010q\u001bTG";
        r0 = 87;
        r3 = r4;
        goto L_0x0009;
    L_0x03ec:
        r3[r2] = r1;
        r2 = 89;
        r1 = "I\tw\f\u0003\u000e\na\u0017\u0001\tWX.;41M3+4*S9+";
        r0 = 88;
        r3 = r4;
        goto L_0x0009;
    L_0x03f7:
        r3[r2] = r1;
        r2 = 90;
        r1 = "7\fa\u0016=\u0002\u000bd\u0017\r\u0002Y{\u0010N\n\u0018{\u0010N\u0017\u000b}\u001d\u000b\u0014\n";
        r0 = 89;
        r3 = r4;
        goto L_0x0009;
    L_0x0402:
        r3[r2] = r1;
        r2 = 91;
        r1 = "3\u0011w^\u001e\u0002\u000b\u0017\u001d\u0014\u0016{\u0010N\u000e\n2\f\u000b\u0016\f{\f\u000b\u0003Y?^";
        r0 = 90;
        r3 = r4;
        goto L_0x0009;
    L_0x040d:
        r3[r2] = r1;
        r2 = 92;
        r1 = "7\fa\u0016=\u0002\u000bd\u0017\r\u0002Y{\u0010N\b\rz\u001b\u001cG\t`\u0011\r\u0002\na";
        r0 = 91;
        r3 = r4;
        goto L_0x0009;
    L_0x0418:
        r3[r2] = r1;
        r2 = 93;
        r1 = "\u0004\u0017<\u0014\u001e\u0012\nzP\u000f\t\u001d`\u0011\u0007\u0003WS.>,<K";
        r0 = 92;
        r3 = r4;
        goto L_0x0009;
    L_0x0423:
        r3[r2] = r1;
        r2 = 94;
        r1 = "K\u0018q\n\u0007\b\u0017(";
        r0 = 93;
        r3 = r4;
        goto L_0x0009;
    L_0x042e:
        r3[r2] = r1;
        r2 = 95;
        r1 = "%\f|\u001a\u0002\u0002Ya\u0016\u0001\u0012\u0015v^\u0000\b\r2\u001c\u000bG\u0017g\u0012\u0002G\u001f}\fN\u0014\u001c|\u001a,\u0015\u0016s\u001a\r\u0006\nfP";
        r0 = 94;
        r3 = r4;
        goto L_0x0009;
    L_0x0439:
        r3[r2] = r1;
        r2 = 96;
        r1 = "\u0014\u001c|\u001a,\u0015\u0016s\u001a\r\u0006\nf^\u000b\u0015\u000b}\fT";
        r0 = 95;
        r3 = r4;
        goto L_0x0009;
    L_0x0444:
        r3[r2] = r1;
        r2 = 97;
        r1 = "$\f`\f\u000b\t\r2\u000e\u0005G\u0010|\r\u001a\u0006\u0015~\u001b\nG\ts\n\u0006]Y";
        r0 = 96;
        r3 = r4;
        goto L_0x0009;
    L_0x044f:
        r3[r2] = r1;
        r2 = 98;
        r1 = "H\u001ds\n\u000fH\u0018b\u000eA";
        r0 = 97;
        r3 = r4;
        goto L_0x0009;
    L_0x045a:
        r3[r2] = r1;
        r2 = 99;
        r1 = "2\u0017w\u0006\u001e\u0002\u001af\u001b\n]Yq\u001f\u0000\t\u0016f^\t\u0002\r2\u000e\u0005G\u0010|\r\u001a\u0006\u0015~\u001b\nG\ts\n\u0006";
        r0 = 98;
        r3 = r4;
        goto L_0x0009;
    L_0x0465:
        r3[r2] = r1;
        r2 = 100;
        r1 = "C]";
        r0 = 99;
        r3 = r4;
        goto L_0x0009;
    L_0x0470:
        r3[r2] = r1;
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r1 = "\u0005\u0018a\u001b\f\u0006\u0017v";
        r0 = 100;
        r3 = r4;
        goto L_0x0009;
    L_0x047b:
        r3[r2] = r1;
        r2 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r1 = ")6F;TG\rz\u001bN\u0017\u00122\u001a\u0001\u0002\n2\u0010\u0001\u0013Y{\u0010\u001d\u0013\u0018~\u0012\u000b\u0003Y{\u0010N\u0014\u0000a\n\u000b\nVv\u001f\u001a\u0006W2";
        r0 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0486:
        r3[r2] = r1;
        r2 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r1 = "H\nk\r\u001a\u0002\u0014=\u001f\u001e\u0017V";
        r0 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0491:
        r3[r2] = r1;
        r2 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r1 = "\u0000\nP\u0018\u0002\u000ba\u0017\u0001\tWp\u001f\u001d\u0002\u001bs\u0010\n";
        r0 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x049c:
        r3[r2] = r1;
        r2 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r1 = "\u0017\u0015g\u0019\t\u0002\u001d";
        r0 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04a7:
        r3[r2] = r1;
        r2 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u0017\u0000\u0013\u001c|\n@\u0006\u001af\u0017\u0001\tWP?:3<@'1$1S0)\"=";
        r0 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04b2:
        r3[r2] = r1;
        r2 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r1 = "\u0014\rs\n\u001b\u0014";
        r0 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04bd:
        r3[r2] = r1;
        r2 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r1 = "\n\u0018q^\u000f\u0003\u001d`\u001b\u001d\u0014Y{\rN\n\u0018f\u001d\u0006\u0002\u001d>^\u0019\u000f\u0010q\u0016N\u000e\n2";
        r0 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04c8:
        r3[r2] = r1;
        r2 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        r1 = "\u0010\u0015s\u0010^";
        r0 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04d3:
        r3[r2] = r1;
        r2 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r1 = "\n\u0018q^\u000f\u0003\u001d`\u001b\u001d\u0014Yt\f\u0001\nY\\\u001b\u001a\u0010\u0016`\u0015'\t\rw\f\b\u0006\u001awD";
        r0 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04de:
        r3[r2] = r1;
        r2 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r1 = "BI \u0006T";
        r0 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04e9:
        r3[r2] = r1;
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r1 = "\n\u0018q^\u000f\u0003\u001d`\u001b\u001d\u0014Y{\rN\u0003\u000b}\u000e\u001e\u0002\u001d>^\u0019\u000f\u0010q\u0016N\u000e\n2";
        r0 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04f4:
        r3[r2] = r1;
        r2 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r1 = "\u0000\u001cf^\u0003\u0006\u001a2\u0018\u001c\b\u001420\u000b\u0013\u000e}\f\u0005.\u0017f\u001b\u001c\u0001\u0018q\u001bN\u0001\u0018{\u0012\u000b\u0003";
        r0 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x04ff:
        r3[r2] = r1;
        r2 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        r1 = "\u0017\u000b}\u001d\u000b\u0014\n2\u0010\u000f\n\u001c(";
        r0 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x050a:
        r3[r2] = r1;
        r2 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r1 = "\u0004\u0018|^\u0000\b\r2\u0018\u0007\t\u001d2";
        r0 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0515:
        r3[r2] = r1;
        r2 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        r1 = "$\u0018|^\u0000\b\r2\t\u001c\u000e\rw^\u001d\u0002\rf\u0017\u0000\u0000\n";
        r0 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0520:
        r3[r2] = r1;
        r2 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001dM\u0017\n";
        r0 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x052b:
        r3[r2] = r1;
        r2 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        r1 = "\u000f\u0018a=\u0001\n\t}\u0010\u000b\t\r2\u001b\u001c\u0015\u0016`D";
        r0 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0536:
        r3[r2] = r1;
        r2 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        r1 = "-)G-&88B.%\" ";
        r0 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0541:
        r3[r2] = r1;
        r2 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r1 = "\u0000\u001cf.\u0006\b\u0017w7\u001e]";
        r0 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x054c:
        r3[r2] = r1;
        r2 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        r1 = "\u0014\u001c|\u001a,\u0015\u0016s\u001a\r\u0006\nf^\b\u0006\u0010~\u001b\nG\u0018u\u001f\u0007\tC2\f\u000b\u0004\u001c{\b\u000b\u0015Y|\u0011\u001aG\u001f}\u000b\u0000\u0003U2\u001f\r\u0013\u0010}\u0010T";
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0557:
        r3[r2] = r1;
        r2 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        r1 = "\u0014\u001c|\u001a,\u0015\u0016s\u001a\r\u0006\nf^\b\u0006\u0010~\u001b\nG\u0018u\u001f\u0007\tC";
        r0 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0562:
        r3[r2] = r1;
        r2 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r1 = "KYs\u001d\u001a\u000e\u0016|D";
        r0 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x056d:
        r3[r2] = r1;
        r2 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r1 = "\u0004\u0017<\u0014\u001e\u0012\nzP\u000f\t\u001d`\u0011\u0007\u0003W{\u0010\u001a\u0002\u0017fP-(7\\;-30]0";
        r0 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0578:
        r3[r2] = r1;
        r2 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r1 = "\u0017\u0016{\u0010\u001aI\u0000";
        r0 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0583:
        r3[r2] = r1;
        r2 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r1 = "\u0003\u0014<\u0006\n\u0017\u00102DN";
        r0 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x058e:
        r3[r2] = r1;
        r2 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r1 = "\u0003\u0014<\t\u0007\u0003\rz.\u0007\u001f\u001c~\rN]Y";
        r0 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0599:
        r3[r2] = r1;
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1 = "G\u001dP\u0017\u0003\t{D";
        r0 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x05a4:
        r3[r2] = r1;
        r2 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        r1 = "\u0017\u0016{\u0010\u001aI\u0001(";
        r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x05af:
        r3[r2] = r1;
        r2 = 130; // 0x82 float:1.82E-43 double:6.4E-322;
        r1 = "4\u001a`\u001b\u000b\tY{\u0010\r\u000f\u001ca^TG";
        r0 = 129; // 0x81 float:1.81E-43 double:6.37E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x05ba:
        r3[r2] = r1;
        r2 = 131; // 0x83 float:1.84E-43 double:6.47E-322;
        r1 = "G\u001dP\u0006\u0002\u0010u\u0016\u001a7\u0010j\u001b\u0002\u0014C";
        r0 = 130; // 0x82 float:1.82E-43 double:6.4E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x05c5:
        r3[r2] = r1;
        r2 = 132; // 0x84 float:1.85E-43 double:6.5E-322;
        r1 = ";W";
        r0 = 131; // 0x83 float:1.84E-43 double:6.47E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x05d0:
        r3[r2] = r1;
        r2 = 133; // 0x85 float:1.86E-43 double:6.57E-322;
        r1 = "H\u001ds\n\u000fH";
        r0 = 132; // 0x84 float:1.85E-43 double:6.5E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x05db:
        r3[r2] = r1;
        r2 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r1 = "JT,^(\u0012\u0015~^\u001c\u0002\nb\u0011\u0000\u0014\u001c2\t\u000f\u0014C2";
        r0 = 133; // 0x85 float:1.86E-43 double:6.57E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x05e6:
        r3[r2] = r1;
        r2 = 135; // 0x87 float:1.89E-43 double:6.67E-322;
        r1 = "JT,^\"\u000e\u0017w^\u001c\u0002\u001aw\u0017\u0018\u0002\u001d(^";
        r0 = 134; // 0x86 float:1.88E-43 double:6.6E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x05f1:
        r3[r2] = r1;
        r2 = 136; // 0x88 float:1.9E-43 double:6.7E-322;
        r1 = "\u0001\u0018{\u0012\u000b\u0003Yf\u0011N\u0000\u001cf^\u000f\u0017\t~\u0017\r\u0006\r{\u0011\u0000G\u0010|\u0018\u0001G\u0018|\u001aN\u000e\u001a}\u0010@";
        r0 = 135; // 0x87 float:1.89E-43 double:6.67E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x05fc:
        r3[r2] = r1;
        r2 = 137; // 0x89 float:1.92E-43 double:6.77E-322;
        r1 = "讐剉2.\u0001\u0015\rs\u0012N乭菎叄惖盪卢呴咞?\u001e\u00172w\u0007帘暓旉S\u0010\n\u0015\u0016{\u001a#\u0006\u0017{\u0018\u000b\u0014\r盪廪嬹毒";
        r0 = 136; // 0x88 float:1.9E-43 double:6.7E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0607:
        r3[r2] = r1;
        r2 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u001f\u001e\u0017W\\\u0011\u001a\u000e\u001f{\u001d\u000f\u0013\u0010}\u0010";
        r0 = 137; // 0x89 float:1.92E-43 double:6.77E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0612:
        r3[r2] = r1;
        r2 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        r1 = "\u0004\u0017<\u0014\u001e\u0012\nzP\u000f\t\u001d`\u0011\u0007\u0003W{\u0010\u001a\u0002\u0017fP (-[8'$8F7!)&].+)<V!>56J'";
        r0 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x061d:
        r3[r2] = r1;
        r2 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
        r1 = "\u0003\u001cp\u000b\t8\u0017}\n\u0007\u0001\u0010q\u001f\u001a\u000e\u0016|";
        r0 = 139; // 0x8b float:1.95E-43 double:6.87E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0628:
        r3[r2] = r1;
        r2 = 141; // 0x8d float:1.98E-43 double:6.97E-322;
        r1 = "\u0013\u0016s\r\u001a3\u001cj\n";
        r0 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0633:
        r3[r2] = r1;
        r2 = 142; // 0x8e float:1.99E-43 double:7.0E-322;
        r1 = "\t\u0016f^\n\u0002\u001bg\u0019\t\u0006\u001b~\u001b";
        r0 = 141; // 0x8d float:1.98E-43 double:6.97E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x063e:
        r3[r2] = r1;
        r2 = 143; // 0x8f float:2.0E-43 double:7.07E-322;
        r1 = "\u0014\u001cf2\u000f\u0013\u001ca\n+\u0011\u001c|\n'\t\u001f}";
        r0 = 142; // 0x8e float:1.99E-43 double:7.0E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0649:
        r3[r2] = r1;
        r2 = 144; // 0x90 float:2.02E-43 double:7.1E-322;
        r1 = "-\u0010u\u000b\u000f\t\u001e揂祄ｴ卢呴咞?\u001e\u00172w\u0007乣卞鄴";
        r0 = 143; // 0x8f float:2.0E-43 double:7.07E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0654:
        r3[r2] = r1;
        r2 = 145; // 0x91 float:2.03E-43 double:7.16E-322;
        r1 = "\u0006\u001af\u0017\u0001\tCa\u0016\u0001\u0010)w\f\u0003\u0006\u0017w\u0010\u001a)\u0016f\u0017\b\u000e\u001as\n\u0007\b\u0017";
        r0 = 144; // 0x90 float:2.02E-43 double:7.1E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x065f:
        r3[r2] = r1;
        r2 = 146; // 0x92 float:2.05E-43 double:7.2E-322;
        r1 = "\t\u0016f\u0017\b\u000e\u001as\n\u0007\b\u0017";
        r0 = 145; // 0x91 float:2.03E-43 double:7.16E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x066a:
        r3[r2] = r1;
        r2 = 147; // 0x93 float:2.06E-43 double:7.26E-322;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u0017\u0000\u0013\u001c|\n@\u0006\u001af\u0017\u0001\tWG-+5&B,+4<\\*";
        r0 = 146; // 0x92 float:2.05E-43 double:7.2E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0675:
        r3[r2] = r1;
        r2 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        r1 = "\u0004\u0017<\u0014\u001e\u0012\nzP\u000f\t\u001d`\u0011\u0007\u0003W{\u0010\u001a\u0002\u0017fP (-[8'$8F7!)&@;-\"0D;*8)@16>";
        r0 = 147; // 0x93 float:2.06E-43 double:7.26E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0680:
        r3[r2] = r1;
        r2 = 149; // 0x95 float:2.09E-43 double:7.36E-322;
        r1 = "5\u001cu\u0017\u001d\u0013\u001c`^>\u0012\nz,\u000b\u0004\u001c{\b\u000b\u0015Y{\u0010N\u0004\u0016v\u001bNG\u001fs\u0017\u0002\u0002\u001d(";
        r0 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x068b:
        r3[r2] = r1;
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u0017\u0000\u0013\u001c|\n@\u0006\u001af\u0017\u0001\tWB?-,8U;15<_18\"=";
        r0 = 149; // 0x95 float:2.09E-43 double:7.36E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0696:
        r3[r2] = r1;
        r2 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u0017\u0000\u0013\u001c|\n@\u0006\u001af\u0017\u0001\tWB?-,8U;1&=V;*";
        r0 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x06a1:
        r3[r2] = r1;
        r2 = 152; // 0x98 float:2.13E-43 double:7.5E-322;
        r1 = "\u000f\u0018a^\u001c\u0002\u001e{\r\u001a\u0002\u000b2\u0017\u0000G\u001a}\u001a\u000b";
        r0 = 151; // 0x97 float:2.12E-43 double:7.46E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x06ac:
        r3[r2] = r1;
        r2 = 153; // 0x99 float:2.14E-43 double:7.56E-322;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u0010\u000b\u0013Wq\u0011\u0000\tWQ1 )<Q*'10F'1$1S0)\"";
        r0 = 152; // 0x98 float:2.13E-43 double:7.5E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x06b7:
        r3[r2] = r1;
        r2 = 154; // 0x9a float:2.16E-43 double:7.6E-322;
        r1 = "#\u00162\u0010\u0001\u0013Yz\u001f\u0018\u0002YB\u000b\u001d\u000f+w\u001d\u000b\u000e\u000fw\fBG+w\u0019\u0007\u0014\rw\fN\u000e\r2\u0017\u0000G\u001a}\u001a\u000b";
        r0 = 153; // 0x99 float:2.14E-43 double:7.56E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x06c2:
        r3[r2] = r1;
        r2 = 155; // 0x9b float:2.17E-43 double:7.66E-322;
        r1 = "\u0017\u0018q\u0015\u000f\u0000\u001c";
        r0 = 154; // 0x9a float:2.16E-43 double:7.6E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x06cd:
        r3[r2] = r1;
        r2 = 156; // 0x9c float:2.19E-43 double:7.7E-322;
        r1 = "2\u0017y\u0010\u0001\u0010\u0017";
        r0 = 155; // 0x9b float:2.17E-43 double:7.66E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x06d8:
        r3[r2] = r1;
        r2 = 157; // 0x9d float:2.2E-43 double:7.76E-322;
        r1 = "WS\"";
        r0 = 156; // 0x9c float:2.19E-43 double:7.7E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x06e3:
        r3[r2] = r1;
        r2 = 158; // 0x9e float:2.21E-43 double:7.8E-322;
        r1 = "&\u0017v\f\u0001\u000e\u001dG\n\u0007\u000bYs\u001d\u001f\u0012\u0010`\u001b\n0\u0018y\u001b\u0002\b\u001ay^'\u000b\u0015w\u0019\u000f\u000b*f\u001f\u001a\u0002<j\u001d\u000b\u0017\r{\u0011\u0000G\u001c`\f\u0000\b";
        r0 = 157; // 0x9d float:2.2E-43 double:7.76E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x06ee:
        r3[r2] = r1;
        r2 = 159; // 0x9f float:2.23E-43 double:7.86E-322;
        r1 = "0\u0018y\u001b\u0002\b\u001ay^\u0007\u0014Ys\u0012\u001c\u0002\u0018v\u0007N\u000f\u001c~\u001a@G7}^\u0000\u0002\u001cv^\u001a\bYs\u001d\u001f\u0012\u0010`\u001b@";
        r0 = 158; // 0x9e float:2.21E-43 double:7.8E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x06f9:
        r3[r2] = r1;
        r2 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r1 = "83B\u000b\u001d\u000f";
        r0 = 159; // 0x9f float:2.23E-43 double:7.86E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0704:
        r3[r2] = r1;
        r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r1 = "&\u001ac\u000b\u0007\u0015\u001cv^9\u0006\u0012w\u0012\u0001\u0004\u0012";
        r0 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x070f:
        r3[r2] = r1;
        r2 = 162; // 0xa2 float:2.27E-43 double:8.0E-322;
        r1 = "\u0017\u0016e\u001b\u001c";
        r0 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x071a:
        r3[r2] = r1;
        r2 = 163; // 0xa3 float:2.28E-43 double:8.05E-322;
        r1 = "&\u0017v\f\u0001\u000e\u001dG\n\u0007\u000bYs\u001d\u001f\u0012\u0010`\u001b\n0\u0018y\u001b\u0002\b\u001ay^\u000b\u0015\u000b|\u0011";
        r0 = 162; // 0xa2 float:2.27E-43 double:8.0E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0725:
        r3[r2] = r1;
        r2 = 164; // 0xa4 float:2.3E-43 double:8.1E-322;
        r1 = "4\u0018\u001bN\u0006\u0017v\f\u0001\u000e\u001d[\u001aN\u0006\u0017v^\u0003\u0006\u001aS\u001a\n\u0015\u001ca\rO";
        r0 = 163; // 0xa3 float:2.28E-43 double:8.05E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0730:
        r3[r2] = r1;
        r2 = 165; // 0xa5 float:2.31E-43 double:8.15E-322;
        r1 = ")\u001ce:\u000b\u0011\u0010q\u001bT&\u0017v\f\u0001\u000e\u001d[\u001aN\b\u000b23\u000f\u0004Yz\u001f\nG\u001az\u001f\u0000\u0000\u001cv_";
        r0 = 164; // 0xa4 float:2.3E-43 double:8.1E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x073b:
        r3[r2] = r1;
        r2 = 166; // 0xa6 float:2.33E-43 double:8.2E-322;
        r1 = "\u000f\u0018a,\u000b\u0004\u001c{\b\u000b\u00150|\n\u000b\t\rT\u0017\u0002\u0013\u001c`.\u000f\u0004\u0012s\u0019\u000bG\u001c`\f\u0001\u0015C";
        r0 = 165; // 0xa5 float:2.31E-43 double:8.15E-322;
        r3 = r4;
        goto L_0x0009;
    L_0x0746:
        r3[r2] = r1;
        z = r4;
        r0 = 1;
        a = r0;
        r2 = new java.util.ArrayList;
        r2.<init>();
        b = r2;
        r1 = "TL*HYTI#MY^L*G[";
        r0 = -1;
    L_0x0757:
        r1 = r1.toCharArray();
        r3 = r1.length;
        r4 = 0;
        r5 = 1;
        if (r3 > r5) goto L_0x0798;
    L_0x0760:
        r5 = r1;
        r6 = r4;
        r11 = r3;
        r3 = r1;
        r1 = r11;
    L_0x0765:
        r8 = r3[r4];
        r7 = r6 % 5;
        switch(r7) {
            case 0: goto L_0x078a;
            case 1: goto L_0x078d;
            case 2: goto L_0x0790;
            case 3: goto L_0x0793;
            default: goto L_0x076c;
        };
    L_0x076c:
        r7 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
    L_0x076e:
        r7 = r7 ^ r8;
        r7 = (char) r7;
        r3[r4] = r7;
        r4 = r6 + 1;
        if (r1 != 0) goto L_0x0796;
    L_0x0776:
        r3 = r5;
        r6 = r4;
        r4 = r1;
        goto L_0x0765;
    L_0x077a:
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x0020;
    L_0x077e:
        r9 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x0020;
    L_0x0782:
        r9 = 18;
        goto L_0x0020;
    L_0x0786:
        r9 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        goto L_0x0020;
    L_0x078a:
        r7 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x076e;
    L_0x078d:
        r7 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x076e;
    L_0x0790:
        r7 = 18;
        goto L_0x076e;
    L_0x0793:
        r7 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        goto L_0x076e;
    L_0x0796:
        r3 = r1;
        r1 = r5;
    L_0x0798:
        if (r3 > r4) goto L_0x0760;
    L_0x079a:
        r3 = new java.lang.String;
        r3.<init>(r1);
        r1 = r3.intern();
        switch(r0) {
            case 0: goto L_0x081b;
            case 1: goto L_0x0825;
            case 2: goto L_0x082f;
            case 3: goto L_0x0839;
            case 4: goto L_0x0843;
            case 5: goto L_0x0852;
            case 6: goto L_0x085c;
            case 7: goto L_0x0866;
            default: goto L_0x07a6;
        };
    L_0x07a6:
        r2.add(r1);
        r2 = b;
        r1 = "WI&GW^I#NXSI\"N^";
        r0 = -1;
    L_0x07ae:
        r1 = r1.toCharArray();
        r3 = r1.length;
        r4 = 0;
        r5 = 1;
        if (r3 > r5) goto L_0x07df;
    L_0x07b7:
        r5 = r1;
        r6 = r4;
        r11 = r3;
        r3 = r1;
        r1 = r11;
    L_0x07bc:
        r8 = r3[r4];
        r7 = r6 % 5;
        switch(r7) {
            case 0: goto L_0x07d1;
            case 1: goto L_0x07d4;
            case 2: goto L_0x07d7;
            case 3: goto L_0x07da;
            default: goto L_0x07c3;
        };
    L_0x07c3:
        r7 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
    L_0x07c5:
        r7 = r7 ^ r8;
        r7 = (char) r7;
        r3[r4] = r7;
        r4 = r6 + 1;
        if (r1 != 0) goto L_0x07dd;
    L_0x07cd:
        r3 = r5;
        r6 = r4;
        r4 = r1;
        goto L_0x07bc;
    L_0x07d1:
        r7 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x07c5;
    L_0x07d4:
        r7 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x07c5;
    L_0x07d7:
        r7 = 18;
        goto L_0x07c5;
    L_0x07da:
        r7 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        goto L_0x07c5;
    L_0x07dd:
        r3 = r1;
        r1 = r5;
    L_0x07df:
        if (r3 > r4) goto L_0x07b7;
    L_0x07e1:
        r3 = new java.lang.String;
        r3.<init>(r1);
        r1 = r3.intern();
        switch(r0) {
            case 0: goto L_0x07f6;
            case 1: goto L_0x07ff;
            default: goto L_0x07ed;
        };
    L_0x07ed:
        r2.add(r1);
        r2 = b;
        r1 = "WI\"N^WI\"N^WI\"N";
        r0 = 0;
        goto L_0x07ae;
    L_0x07f6:
        r2.add(r1);
        r2 = b;
        r1 = "WI\"N^WI\"N^WI\"N^";
        r0 = 1;
        goto L_0x07ae;
    L_0x07ff:
        r2.add(r1);
        r0 = 0;
        c = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        d = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        e = r0;
        r2 = d;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P')-W, \"-";
        r0 = 0;
        goto L_0x0757;
    L_0x081b:
        r2.add(r1);
        r2 = d;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P9&2W!\"(:Y";
        r0 = 1;
        goto L_0x0757;
    L_0x0825:
        r2.add(r1);
        r2 = d;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P/$:W-=87W*9(+Y!=38F;";
        r0 = 2;
        goto L_0x0757;
    L_0x082f:
        r2.add(r1);
        r2 = e;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P8.;@?:\"";
        r0 = 3;
        goto L_0x0757;
    L_0x0839:
        r2.add(r1);
        r2 = e;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P-/8\\9+8.[8'8*F?:\"";
        r0 = 4;
        goto L_0x0757;
    L_0x0843:
        r2.add(r1);
        r2 = new java.util.ArrayList;
        r2.<init>();
        f = r2;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P/$:W-=8?[0+85]=/30]0";
        r0 = 5;
        goto L_0x0757;
    L_0x0852:
        r2.add(r1);
        r2 = f;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P/$:W-=8:]?<4<M2!$8F7!)";
        r0 = 6;
        goto L_0x0757;
    L_0x085c:
        r2.add(r1);
        r2 = f;
        r1 = "\u0006\u0017v\f\u0001\u000e\u001d<\u000e\u000b\u0015\u0014{\r\u001d\u000e\u0016|P/$:W-=85]=/30]01\"!F,/8:]3#&7V-";
        r0 = 7;
        goto L_0x0757;
    L_0x0866:
        r2.add(r1);
        r0 = f;
        r1 = z;
        r2 = 48;
        r1 = r1[r2];
        r0.add(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.a.<clinit>():void");
    }

    private static boolean A(Context context) {
        d.e(z[2], z[154]);
        try {
            if (g == null) {
                g = new PushReceiver();
                context.registerReceiver(g, new IntentFilter(z[147]));
                context.registerReceiver(g, new IntentFilter(z[153]));
                IntentFilter intentFilter = new IntentFilter(z[151]);
                intentFilter.addDataScheme(z[155]);
                IntentFilter intentFilter2 = new IntentFilter(z[150]);
                intentFilter2.addDataScheme(z[155]);
                context.registerReceiver(g, intentFilter);
                context.registerReceiver(g, intentFilter2);
                intentFilter = new IntentFilter(z[148]);
                intentFilter.setPriority(1000);
                intentFilter.addCategory(context.getPackageName());
                context.registerReceiver(g, intentFilter);
                return true;
            }
            d.d(z[2], z[152]);
            return true;
        } catch (Exception e) {
            d.h(z[2], new StringBuilder(z[149]).append(e.getMessage()).toString());
            return false;
        }
    }

    public static int a(byte b) {
        return b & 255;
    }

    public static String a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            return z[157];
        }
        int i = displayMetrics.widthPixels;
        return i + "*" + displayMetrics.heightPixels;
    }

    public static String a(Context context, String str) {
        Object obj;
        String str2 = VERSION.RELEASE + "," + Integer.toString(VERSION.SDK_INT);
        String str3 = Build.MODEL;
        String a = k.a(context, z[104], z[101]);
        String str4 = Build.DEVICE;
        if (TextUtils.isEmpty(str3)) {
            str3 = " ";
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = " ";
        }
        if (TextUtils.isEmpty(a)) {
            a = " ";
        }
        StringBuilder append = new StringBuilder().append(str2).append(z[100]).append(str3).append(z[100]).append(a).append(z[100]).append(str4).append(z[100]).append(cn.jiguang.b.a.a.d(" ")).append(z[100]).append(str).append(z[100]);
        str3 = context.getApplicationInfo().sourceDir;
        if (j.a(str3)) {
            d.i(z[2], z[99]);
            obj = null;
        } else {
            d.c(z[2], new StringBuilder(z[97]).append(str3).toString());
            if (str3.startsWith(z[103])) {
                int i = 1;
            } else if (str3.startsWith(z[98])) {
                obj = null;
            } else {
                d.e(z[2], z[102]);
                obj = null;
            }
        }
        return append.append(obj != null ? 1 : 0).append(z[100]).append(a(context)).toString();
    }

    public static String a(String str) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance(z[0]);
            char[] toCharArray = str.toCharArray();
            byte[] bArr = new byte[toCharArray.length];
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                bArr[i2] = (byte) toCharArray[i2];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            while (i < digest.length) {
                int i3 = digest[i] & 255;
                if (i3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i3));
                i++;
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            d.c(z[2], z[1]);
            return "";
        }
    }

    public static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance(z[0]).digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            d.c(z[2], z[1]);
            return "";
        }
    }

    public static ArrayList<String> a(String[] strArr) {
        ArrayList<String> arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        d.c(z[2], new StringBuilder(z[135]).append(readLine).toString());
                        arrayList.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return null;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            }
            bufferedReader.close();
            d.c(z[2], new StringBuilder(z[134]).append(arrayList).toString());
            return arrayList;
        } catch (Exception e5) {
            return null;
        }
    }

    private static List<String> a(Context context, Intent intent, String str) {
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

    public static List<String> a(Context context, String[] strArr) {
        List arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (!b(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static JSONObject a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[21], str2);
            jSONObject.put(z[19], str);
            jSONObject.put(z[20], cn.jiguang.b.a.a.q());
            return jSONObject;
        } catch (Exception e) {
            d.i(z[2], e.getMessage());
            return null;
        }
    }

    public static JSONObject a(String str, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[21], jSONArray);
            jSONObject.put(z[19], str);
            jSONObject.put(z[20], cn.jiguang.b.a.a.q());
            return jSONObject;
        } catch (Exception e) {
            d.i(z[2], e.getMessage());
            return null;
        }
    }

    public static void a() {
        try {
            WakeLock b = e.a().b();
            if (b == null) {
                return;
            }
            if (b.isHeld()) {
                try {
                    b.release();
                    long currentTimeMillis = System.currentTimeMillis() - c;
                    c = 0;
                    d.a(z[2], new StringBuilder(z[54]).append(currentTimeMillis).toString());
                    return;
                } catch (Throwable e) {
                    d.c(z[2], z[50], e);
                    return;
                }
            }
            d.a(z[2], z[52]);
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            d.c(z[2], z[51]);
        } catch (Exception e3) {
            e3.printStackTrace();
            d.c(z[2], z[53]);
        }
    }

    public static void a(Context context, String str, int i) {
        if (!v(context)) {
            d.a(z[2], z[142]);
        } else if (a(context, PushReceiver.class)) {
            int i2;
            Notification notification;
            d.c(z[2], z[145]);
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction(z[139]);
            intent.addCategory(context.getPackageName());
            intent.putExtra(z[140], true);
            intent.putExtra(z[141], str);
            intent.putExtra(z[19], -1);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(z[146]);
            try {
                i2 = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 0).icon;
            } catch (Throwable th) {
                d.f(z[2], z[136], th);
                i2 = 17301586;
            }
            CharSequence charSequence = z[144];
            CharSequence charSequence2 = z[137];
            long currentTimeMillis = System.currentTimeMillis();
            if (VERSION.SDK_INT >= 11) {
                notification = new Builder(context.getApplicationContext()).setContentTitle(charSequence).setContentText(charSequence2).setContentIntent(broadcast).setSmallIcon(i2).setTicker(str).setWhen(currentTimeMillis).getNotification();
                notification.flags = 34;
            } else {
                Notification notification2 = new Notification(i2, str, currentTimeMillis);
                notification2.flags = 34;
                try {
                    Class.forName(z[138]).getDeclaredMethod(z[143], new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class}).invoke(notification2, new Object[]{context, charSequence, charSequence2, broadcast});
                    notification = notification2;
                } catch (Exception e) {
                    e.printStackTrace();
                    notification = notification2;
                }
            }
            if (notification != null) {
                notificationManager.notify(str.hashCode(), notification);
            }
        } else {
            new Handler(Looper.getMainLooper()).post(new b(context, str));
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            d.j(z[2], z[95]);
            return;
        }
        Intent intent = new Intent(str);
        try {
            bundle.putString(z[93], cn.jiguang.b.a.d.i(context));
            intent.putExtras(bundle);
            intent.addCategory(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            d.h(z[2], new StringBuilder(z[96]).append(th.getMessage()).append(z[94]).append(str).toString());
            b(context, intent, null);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        if (str2 != null) {
            bundle.putString(str2, str3);
        }
        a(context, str, bundle);
    }

    private static boolean a(Context context, Class<?> cls) {
        boolean z = false;
        try {
            if (!context.getPackageManager().queryBroadcastReceivers(new Intent(context, cls), 0).isEmpty()) {
                z = true;
            }
        } catch (Throwable th) {
        }
        return !z ? c(context, (Class) cls) : z;
    }

    private static boolean a(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.name.equals(str)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            d.h(z[2], new StringBuilder(z[166]).append(th.getMessage()).toString());
        }
        return false;
    }

    private static boolean a(String str, String str2, String str3, String str4) {
        if (j.a(str3) || j.a(str4)) {
            return str.equals(str2);
        }
        if (str.equals(str2) && str3.equalsIgnoreCase(str4)) {
            d.e(z[2], z[164]);
            return true;
        }
        d.e(z[2], z[165]);
        return false;
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (new File(z[24]).exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(z[24])));
                Object obj = null;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.contains(z[25])) {
                        int indexOf = readLine.indexOf(":");
                        if (indexOf >= 0 && indexOf < readLine.length() - 1) {
                            obj = readLine.substring(indexOf + 1).trim();
                        }
                        if (!(obj == null || stringBuffer.toString().contains(obj))) {
                            stringBuffer.append(obj);
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(z[0]).digest(str.getBytes(z[39]));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            d.c(z[2], z[1]);
            return "";
        }
    }

    private static void b(Context context, Intent intent, String str) {
        String action = intent.getAction();
        if (z[ErrorCode.DOWNLOAD_REDIRECT_EMPTY].equals(action)) {
            List<String> a = a(context, intent, null);
            if (a.isEmpty()) {
                d.h(z[2], new StringBuilder(z[ErrorCode.THREAD_INIT_ERROR]).append(action).toString());
                return;
            }
            for (String componentName : a) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), componentName));
                    if (TextUtils.isEmpty(null)) {
                        context.sendBroadcast(intent2);
                    } else {
                        context.sendBroadcast(intent2, null);
                    }
                } catch (Exception e) {
                    d.h(z[2], new StringBuilder(z[ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR]).append(e.getMessage()).append(z[ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED]).append(action).toString());
                }
            }
        }
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(z[56])).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean b(Context context, Class<?> cls) {
        boolean z = false;
        try {
            if (!context.getPackageManager().queryIntentServices(new Intent(context, cls), 0).isEmpty()) {
                z = true;
            }
        } catch (Throwable th) {
        }
        return !z ? c(context, (Class) cls) : z;
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
        throw new IllegalArgumentException(z[22]);
    }

    public static int c(String str) {
        String[] split = str.split(z[132]);
        return Integer.parseInt(split[2]) + ((Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8));
    }

    public static String c() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (Exception e) {
            d.g(z[2], z[ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR]);
            e.printStackTrace();
        }
        return "";
    }

    public static String c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(z[56])).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return z[156];
            }
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            return typeName == null ? z[156] : !j.a(subtypeName) ? typeName + "," + subtypeName : typeName;
        } catch (Exception e) {
            e.printStackTrace();
            return z[156];
        }
    }

    public static String c(Context context, String str) {
        String s = s(context);
        if (!j.e(s)) {
            s = t(context);
        }
        return !j.e(s) ? str : s;
    }

    private static boolean c(Context context, Class<?> cls) {
        try {
            ComponentInfo[] componentInfoArr;
            int i = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), i);
            switch (i) {
                case 1:
                    componentInfoArr = packageInfo.activities;
                    break;
                case 2:
                    componentInfoArr = packageInfo.receivers;
                    break;
                case 4:
                    componentInfoArr = packageInfo.services;
                    break;
                case 8:
                    componentInfoArr = packageInfo.providers;
                    break;
                default:
                    componentInfoArr = null;
                    break;
            }
            if (componentInfoArr == null) {
                return false;
            }
            String name = cls.getName();
            for (ComponentInfo componentInfo : componentInfoArr) {
                if (name.equals(componentInfo.name)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            d.h(z[2], new StringBuilder(z[118]).append(th.getMessage()).toString());
            return false;
        }
    }

    public static int d(Context context) {
        Intent intent = null;
        if (context == null) {
            return -1;
        }
        Intent registerReceiver;
        try {
            registerReceiver = context.registerReceiver(null, new IntentFilter(z[106]));
        } catch (SecurityException e) {
            e.printStackTrace();
            registerReceiver = intent;
        } catch (Exception e2) {
            e2.printStackTrace();
            registerReceiver = intent;
        }
        if (registerReceiver == null) {
            return -1;
        }
        int intExtra = registerReceiver.getIntExtra(z[107], -1);
        Object obj = (intExtra == 2 || intExtra == 5) ? 1 : null;
        return obj != null ? registerReceiver.getIntExtra(z[105], -1) : -1;
    }

    public static String d(Context context, String str) {
        try {
            if (b(context, z[55])) {
                str = ((TelephonyManager) context.getSystemService(z[45])).getSimSerialNumber();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private static boolean d() {
        boolean equals = Environment.getExternalStorageState().equals(z[44]);
        if (!equals) {
            d.c(z[2], z[43]);
        }
        return equals;
    }

    private static boolean d(String str) {
        if (!j.d(str) || str.length() < 10) {
            return false;
        }
        int i = 0;
        while (i < b.size()) {
            if (str.equals(b.get(i)) || str.startsWith((String) b.get(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static String e() {
        String str = null;
        try {
            str = Environment.getExternalStorageDirectory().getPath();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
        return !j.a(str) ? str + z[133] : str;
    }

    public static String e(Context context) {
        String b = cn.jiguang.b.a.a.b(context);
        if (d(b)) {
            return b;
        }
        b = w(context);
        cn.jiguang.b.a.a.b(context, b);
        return b;
    }

    public static String e(Context context, String str) {
        String deviceId;
        try {
            deviceId = ((TelephonyManager) context.getSystemService(z[45])).getDeviceId();
        } catch (Exception e) {
            d.i(z[2], e.getMessage());
            deviceId = null;
        }
        return j.d(deviceId) ? deviceId : str;
    }

    private static String e(String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        String e2 = e();
        if (j.a(e2)) {
            d.i(z[2], z[6]);
            return null;
        }
        File file = new File(e2);
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (Throwable e3) {
                d.e(z[2], z[4], e3);
            }
        }
        if (j.a(f())) {
            d.j(z[2], z[9]);
            return null;
        }
        File file2 = new File(e2 + z[8]);
        if (file2.exists()) {
            try {
                file2.delete();
            } catch (SecurityException e4) {
                return null;
            }
        }
        try {
            file2.createNewFile();
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.flush();
                    d.e(z[2], z[7]);
                    if (fileOutputStream == null) {
                        return str;
                    }
                    try {
                        fileOutputStream.close();
                        return str;
                    } catch (IOException e5) {
                        return str;
                    }
                } catch (IOException e6) {
                    e = e6;
                    try {
                        d.e(z[2], z[5], e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e9) {
                e = e9;
                fileOutputStream = null;
                d.e(z[2], z[5], e);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable e10) {
                fileOutputStream = null;
                th = e10;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable e102) {
            d.e(z[2], z[3], e102);
            return null;
        }
    }

    private static int f(String str) {
        if (j.a(str)) {
            d.g(z[2], z[59]);
            return 0;
        } else if (Pattern.matches(z[57], str)) {
            d.e(z[2], z[62]);
            return 0;
        } else if (Pattern.matches(z[61], str)) {
            d.e(z[2], z[58]);
            return 1;
        } else if (!Pattern.matches(z[60], str)) {
            return 0;
        } else {
            d.e(z[2], z[63]);
            return 2;
        }
    }

    private static String f() {
        String e = e();
        return e == null ? null : e + z[8];
    }

    public static String f(Context context) {
        String str = "";
        try {
            str = Secure.getString(context.getContentResolver(), z[117]);
        } catch (SecurityException e) {
        } catch (Exception e2) {
        }
        return j.d(str) ? str : "";
    }

    public static String f(Context context, String str) {
        try {
            if (b(context, z[55])) {
                str = ((TelephonyManager) context.getSystemService(z[45])).getSubscriberId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private static String g() {
        String f = f();
        if (j.a(f)) {
            d.j(z[2], z[9]);
            return null;
        }
        File file = new File(f);
        if (file.exists()) {
            try {
                ArrayList a = f.a(new FileInputStream(file));
                if (a.size() > 0) {
                    f = (String) a.get(0);
                    d.e(z[2], new StringBuilder(z[38]).append(f).toString());
                    return f;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static String g(Context context) {
        String str = null;
        String d = cn.jiguang.b.a.d.d(context);
        if (j.d(d)) {
            a = c.d - 1;
            return d;
        }
        d = l(context, d);
        if (j.d(d)) {
            a = c.b - 1;
            k(context, d);
            cn.jiguang.b.a.d.a(context, d);
            return d;
        }
        if (!d()) {
            d.i(z[2], z[42]);
        } else if (b(context, z[41]) && (VERSION.SDK_INT < 23 || (b(context, z[41]) && b(context, z[40])))) {
            str = g();
        }
        if (j.d(str)) {
            a = c.c - 1;
            m(context, str);
            cn.jiguang.b.a.d.a(context, str);
            return str;
        }
        str = VERSION.SDK_INT < 23 ? e(context, str) : "";
        String f = f(context);
        String c = c(context, "");
        d = UUID.randomUUID().toString();
        str = a(str + f + c + d);
        if (j.a(str)) {
            str = d;
        }
        cn.jiguang.b.a.d.a(context, str);
        a = c.a - 1;
        m(context, str);
        k(context, str);
        return str;
    }

    public static void g(Context context, String str) {
        if (!j.a(str)) {
            m(context, str);
            k(context, str);
            cn.jiguang.b.a.d.a(context, str);
        }
    }

    public static void h(Context context) {
        d.c(z[2], z[34]);
        long h = (long) (cn.jiguang.b.a.a.h() * 1000);
        long currentTimeMillis = System.currentTimeMillis() + h;
        d.e(z[2], new StringBuilder(z[33]).append(h).append(z[31]).toString());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(z[32]);
        try {
            if (VERSION.SDK_INT >= 19) {
                alarmManager.setWindow(0, currentTimeMillis, 0, broadcast);
            } else {
                alarmManager.setInexactRepeating(0, currentTimeMillis, h, broadcast);
            }
        } catch (Exception e) {
            d.h(z[2], new StringBuilder(z[35]).append(e.getMessage()).toString());
        }
    }

    public static boolean h(Context context, String str) {
        if (j.a(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void i(Context context) {
        try {
            ((AlarmManager) context.getSystemService(z[32])).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0));
        } catch (Exception e) {
            d.g(z[2], z[37]);
        }
    }

    private static boolean i(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(z[22]);
        }
        try {
            context.getPackageManager().getPermissionInfo(str, 128);
            return true;
        } catch (Throwable th) {
            d.h(z[2], new StringBuilder(z[23]).append(th.getMessage()).toString());
            return false;
        }
    }

    public static void j(Context context) {
        a();
        try {
            WakeLock newWakeLock = ((PowerManager) context.getSystemService(z[162])).newWakeLock(1, cn.jiguang.b.a.c + z[160]);
            newWakeLock.setReferenceCounted(false);
            e.a().a(newWakeLock);
            if (e.a().b().isHeld()) {
                d.a(z[2], z[159]);
                return;
            }
            e.a().b().acquire();
            c = System.currentTimeMillis();
            d.a(z[2], z[161]);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            d.c(z[2], z[158]);
        } catch (Exception e2) {
            e2.printStackTrace();
            d.c(z[2], z[163]);
        }
    }

    private static boolean j(Context context, String str) {
        try {
            context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128);
            return true;
        } catch (Throwable th) {
            d.h(z[2], new StringBuilder(z[17]).append(th.getMessage()).toString());
            return false;
        }
    }

    public static String k(Context context) {
        String i = cn.jiguang.b.a.d.i(context);
        if (j.a(i)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    i = applicationInfo.metaData.getString(z[119]);
                }
            } catch (Throwable th) {
            }
        }
        return i;
    }

    private static String k(Context context, String str) {
        return (d() && b(context, z[41])) ? VERSION.SDK_INT < 23 ? e(str) : (b(context, z[41]) && b(context, z[40])) ? e(str) : null : null;
    }

    private static String l(Context context, String str) {
        if (b(context, z[74])) {
            try {
                str = System.getString(context.getContentResolver(), z[73]);
            } catch (Exception e) {
                d.i(z[2], z[72]);
            }
        }
        return str;
    }

    public static void l(Context context) {
        boolean z = true;
        c t = cn.jiguang.b.a.a.t();
        if (t.d()) {
            d.e(z[2], z[76]);
            return;
        }
        String a = t.a();
        String b = t.b();
        String c = t.c();
        String e = e(context, "");
        String f = f(context);
        if (j.a(f)) {
            f = " ";
        }
        String c2 = c(context, "");
        if (j.a(c2)) {
            c2 = " ";
        }
        int f2 = f(a);
        int f3 = f(e);
        if (f2 == 0 || f3 == 0) {
            z = a(f, b, c2, c);
        } else if (!((1 == f2 && 2 == f3) || (2 == f2 && 1 == f3))) {
            if (f2 != f3) {
                z = false;
            } else if (e.equals(a)) {
                boolean z2;
                if (e.equals(a) && f.equals(b)) {
                    d.e(z[2], z[78]);
                    z2 = true;
                } else {
                    d.e(z[2], z[77]);
                    z2 = false;
                }
                z = z2;
            } else {
                z = a(f, b, c2, c);
            }
        }
        if (!z) {
            m(context);
        }
    }

    private static String m(Context context, String str) {
        if (b(context, z[74])) {
            try {
                if (System.putString(context.getContentResolver(), z[73], str)) {
                    return str;
                }
            } catch (Exception e) {
                d.i(z[2], z[116]);
            }
        }
        return null;
    }

    public static void m(Context context) {
        d.c(z[2], z[75]);
        cn.jiguang.b.a.d.h(context);
        m(context, "");
        k(context, "");
        b.e().b(context);
    }

    public static boolean n(Context context) {
        CharSequence a = k.a(context, z[15]);
        d.c(z[2], new StringBuilder(z[10]).append(a).toString());
        CharSequence a2 = k.a(context, z[16]);
        if (!(TextUtils.isEmpty(a) || !z[13].equals(a) || TextUtils.isEmpty(a2))) {
            Object a3 = k.a(context, z[14]);
            if (!TextUtils.isEmpty(a3) && a3.startsWith(z[11])) {
                d.g(z[2], z[12]);
                return false;
            }
        }
        return true;
    }

    private static boolean n(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128);
            d.a(z[2], new StringBuilder(z[114]).append(serviceInfo.processName).toString());
            if (serviceInfo.processName.contains(context.getPackageName() + ":")) {
                return true;
            }
        } catch (NameNotFoundException e) {
        } catch (NullPointerException e2) {
            d.a(z[2], new StringBuilder(z[115]).append(str).toString());
        }
        return false;
    }

    public static double o(Context context) {
        double pow;
        double pow2;
        Point point = new Point();
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else if (VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
            d.c(z[2], new StringBuilder(z[129]).append(point.x).append(z[ErrorCode.DOWNLOAD_THROWABLE]).append(point.y).toString());
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        d.c(z[2], new StringBuilder(z[TransportMediator.KEYCODE_MEDIA_PLAY]).append(displayMetrics.xdpi).append(z[128]).append(displayMetrics.ydpi).toString());
        if (context instanceof Activity) {
            pow = Math.pow((double) (((float) point.x) / displayMetrics.xdpi), 2.0d);
            pow2 = Math.pow((double) (((float) point.y) / displayMetrics.ydpi), 2.0d);
        } else {
            d.c(z[2], new StringBuilder(z[TransportMediator.KEYCODE_MEDIA_PAUSE]).append(displayMetrics.widthPixels).append(z[131]).append(displayMetrics.heightPixels).toString());
            pow = Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d);
            pow2 = Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d);
        }
        pow2 = Math.sqrt(pow2 + pow);
        d.c(z[2], new StringBuilder(z[TransportMediator.KEYCODE_MEDIA_RECORD]).append(pow2).toString());
        return pow2;
    }

    public static boolean p(Context context) {
        return b(context, PushService.class);
    }

    public static boolean q(Context context) {
        String str;
        d.d(z[2], z[82]);
        if (h.a().g()) {
            boolean z;
            if (b(context, PushService.class)) {
                z = true;
            } else {
                d.j(z[2], new StringBuilder(z[88]).append(PushService.class.getCanonicalName()).toString());
                z = false;
            }
            if (!z) {
                return false;
            }
            if (n(context, PushService.class.getCanonicalName())) {
                d.a(z[2], z[92]);
                cn.jiguang.b.a.i = true;
            } else {
                d.a(z[2], z[90]);
                cn.jiguang.b.a.i = false;
            }
            if (!cn.jiguang.b.a.d.k(context)) {
                cn.jiguang.b.b.b.a(context, true);
                if (a(context, AlarmReceiver.class)) {
                    if (!a(context, PushReceiver.class)) {
                        d.j(z[2], new StringBuilder(z[80]).append(PushReceiver.class.getCanonicalName()).toString());
                        if (!A(context)) {
                            return false;
                        }
                    }
                    if (a(context, PushReceiver.class.getCanonicalName(), z[87])) {
                        d.h(z[2], z[79]);
                    }
                } else {
                    d.j(z[2], new StringBuilder(z[80]).append(AlarmReceiver.class.getCanonicalName()).toString());
                    return false;
                }
            }
            str = context.getPackageName() + z[89];
            if (i(context, str)) {
                d.add(str);
            } else {
                d.j(z[2], new StringBuilder(z[84]).append(str).toString());
                return false;
            }
        }
        Iterator it = d.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (!b(context.getApplicationContext(), str)) {
                d.j(z[2], new StringBuilder(z[91]).append(str).toString());
                return false;
            }
        }
        if (VERSION.SDK_INT < 23) {
            if (!b(context.getApplicationContext(), z[41])) {
                d.j(z[2], z[81]);
                return false;
            } else if (!b(context.getApplicationContext(), z[74])) {
                d.j(z[2], z[83]);
                return false;
            }
        }
        Iterator it2 = e.iterator();
        while (it2.hasNext()) {
            str = (String) it2.next();
            if (!b(context.getApplicationContext(), str)) {
                d.g(z[2], new StringBuilder(z[86]).append(str).toString());
            }
        }
        it2 = f.iterator();
        while (it2.hasNext()) {
            str = (String) it2.next();
            if (!b(context.getApplicationContext(), str)) {
                d.g(z[2], new StringBuilder(z[86]).append(str).append(z[85]).toString());
            }
        }
        return true;
    }

    public static void r(Context context) {
        if (g != null && !j(context, PushReceiver.class.getCanonicalName())) {
            try {
                context.unregisterReceiver(g);
                g = null;
            } catch (Exception e) {
                d.i(z[2], e.getMessage());
            }
        }
    }

    private static String s(Context context) {
        Throwable e;
        String str = "";
        if (VERSION.SDK_INT >= 23 || !b(context, z[48])) {
            return str;
        }
        String macAddress;
        try {
            macAddress = ((WifiManager) context.getSystemService(z[49])).getConnectionInfo().getMacAddress();
            try {
                d.c(z[2], new StringBuilder(z[47]).append(macAddress).toString());
                return macAddress;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            macAddress = str;
            e = th;
            d.c(z[2], z[46], e);
            return macAddress;
        }
    }

    private static String t(Context context) {
        String str;
        boolean equals;
        String str2 = "";
        boolean isWifiEnabled = b(context, z[48]) ? ((WifiManager) context.getSystemService(z[49])).isWifiEnabled() : false;
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (z[109].equalsIgnoreCase(networkInterface.getName())) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            stringBuilder.append(String.format(Locale.ENGLISH, z[111], new Object[]{Byte.valueOf(b)}));
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        str2 = stringBuilder.toString();
                        d.c(z[2], new StringBuilder(z[110]).append(str2).toString());
                        str = str2;
                        if (!isWifiEnabled) {
                            return str;
                        }
                        Object o = cn.jiguang.b.a.a.o();
                        equals = (TextUtils.isEmpty(o) || TextUtils.isEmpty(str)) ? false : o.equals(a(str.toLowerCase() + Build.MODEL));
                        if (equals) {
                            d.c(z[2], new StringBuilder(z[112]).append(str).toString());
                            return "";
                        }
                        d.c(z[2], new StringBuilder(z[108]).append(str).toString());
                        return str;
                    }
                }
            }
            str = str2;
        } catch (Throwable e) {
            d.c(z[2], z[113], e);
            str = str2;
        }
        if (!isWifiEnabled) {
            return str;
        }
        Object o2 = cn.jiguang.b.a.a.o();
        if (!TextUtils.isEmpty(o2)) {
        }
        if (equals) {
            d.c(z[2], new StringBuilder(z[112]).append(str).toString());
            return "";
        }
        d.c(z[2], new StringBuilder(z[108]).append(str).toString());
        return str;
    }

    private static String u(Context context) {
        String str = null;
        try {
            String c = c(context, "");
            if (!(c == null || c.equals(""))) {
                d.e(z[2], new StringBuilder(z[18]).append(c).toString());
                str = a(c.toLowerCase() + Build.MODEL);
            }
        } catch (Throwable e) {
            d.e(z[2], "", e);
        }
        return str;
    }

    private static boolean v(Context context) {
        boolean z = false;
        try {
            X500Principal x500Principal = new X500Principal(z[30]);
            String[] strArr = new String[]{z[27], z[26], z[29]};
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            CertificateFactory instance = CertificateFactory.getInstance(z[28]);
            for (Signature toByteArray : signatureArr) {
                X509Certificate x509Certificate = (X509Certificate) instance.generateCertificate(new ByteArrayInputStream(toByteArray.toByteArray()));
                z = x509Certificate.getSubjectX500Principal().equals(x500Principal);
                if (z) {
                    return z;
                }
                String name;
                try {
                    name = x509Certificate.getSubjectX500Principal().getName();
                } catch (Exception e) {
                    name = null;
                }
                if (name != null) {
                    try {
                        if (name.contains(strArr[0]) && name.contains(strArr[1]) && name.contains(strArr[2])) {
                            return true;
                        }
                    } catch (NameNotFoundException e2) {
                        return z;
                    } catch (Throwable th) {
                        return z;
                    }
                }
            }
            return z;
        } catch (NameNotFoundException e3) {
            return false;
        } catch (Throwable th2) {
            return false;
        }
    }

    private static String w(Context context) {
        String e;
        try {
            e = e(context, "");
            if (d(e)) {
                return e;
            }
            e = f(context);
            if (d(e) && !z[36].equals(e.toLowerCase(Locale.getDefault()))) {
                return e;
            }
            e = u(context);
            if (!d(e)) {
                e = x(context);
                if (e == null) {
                    e = " ";
                }
            }
            return !d(e) ? "" : e;
        } catch (Throwable e2) {
            d.e(z[2], "", e2);
            e = x(context);
            return !d(e) ? "" : e;
        }
    }

    private static String x(Context context) {
        d.c(z[2], z[64]);
        String string = context.getSharedPreferences(z[65], 0).getString(z[66], null);
        if (!j.a(string)) {
            return string;
        }
        if (!d()) {
            return z(context);
        }
        Object a = cn.jiguang.b.a.a.a(context);
        return TextUtils.isEmpty(a) ? (VERSION.SDK_INT < 23 || (b(context, z[41]) && b(context, z[40]))) ? y(context) : z(context) : a;
    }

    private static String y(Context context) {
        FileOutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        String e2 = e();
        e2 = e2 == null ? null : e2 + z[71];
        File file = !j.a(e2) ? new File(e2) : null;
        if (file != null) {
            try {
                if (file.exists()) {
                    ArrayList a = f.a(new FileInputStream(file));
                    if (a.size() > 0) {
                        e2 = (String) a.get(0);
                        cn.jiguang.b.a.a.a(context, e2);
                        d.e(z[2], new StringBuilder(z[70]).append(e2).toString());
                        return e2;
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        e2 = j.b(UUID.nameUUIDFromBytes((System.currentTimeMillis()).getBytes()).toString());
        cn.jiguang.b.a.a.a(context, e2);
        if (file != null) {
            try {
                file.createNewFile();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(e2.getBytes());
                        fileOutputStream.flush();
                        d.e(z[2], z[67]);
                        if (fileOutputStream == null) {
                            return e2;
                        }
                        try {
                            fileOutputStream.close();
                            return e2;
                        } catch (IOException e4) {
                            return e2;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        try {
                            d.e(z[2], z[69], e);
                            if (fileOutputStream != null) {
                                return e2;
                            }
                            try {
                                fileOutputStream.close();
                                return e2;
                            } catch (IOException e6) {
                                return e2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable e8) {
                    Throwable th3 = e8;
                    fileOutputStream = null;
                    e = th3;
                    d.e(z[2], z[69], e);
                    if (fileOutputStream != null) {
                        return e2;
                    }
                    fileOutputStream.close();
                    return e2;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable e9) {
                d.e(z[2], z[3], e9);
                return e2;
            }
        }
        d.i(z[2], z[68]);
        return e2;
    }

    private static String z(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(z[65], 0);
        String string = sharedPreferences.getString(z[66], null);
        if (string != null) {
            return string;
        }
        string = UUID.randomUUID().toString();
        Editor edit = sharedPreferences.edit();
        edit.putString(z[66], string);
        edit.commit();
        return string;
    }
}
