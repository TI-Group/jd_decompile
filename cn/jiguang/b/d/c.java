package cn.jiguang.b.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.b.a.a;
import cn.jiguang.b.b.e;
import cn.jiguang.b.b.g;
import cn.jiguang.b.c.f;
import cn.jiguang.b.c.p;
import cn.jiguang.b.f.b;
import cn.jiguang.c.d;
import cn.jiguang.e.h;
import cn.jiguang.e.j;
import cn.jiguang.e.l;
import cn.jiguang.service.Protocol;
import com.kepler.jd.login.KeplerApiManager;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static final LinkedHashMap<String, Boolean> a;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 89;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "O>[ j`g\u000f:`z\u000f[*Qa\u0019N0Qg0J:Rf8A\u001b`i4\\=`|\u001bN ik9";
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
            case 0: goto L_0x041b;
            case 1: goto L_0x041f;
            case 2: goto L_0x0423;
            case 3: goto L_0x0427;
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
            case 81: goto L_0x03a9;
            case 82: goto L_0x03b4;
            case 83: goto L_0x03bf;
            case 84: goto L_0x03ca;
            case 85: goto L_0x03d5;
            case 86: goto L_0x03e0;
            case 87: goto L_0x03eb;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "M2A'`m)F'bF8C9`|";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "m3\u0001#u{.Ggd`9]&ljs}\fBG\u000e{\u001bDZ\u0014`\u0007ZG\u0019";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\\8H vz8]ico4C,a.p\u000f;`zg";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\\8H vz8]iv{>L,`j}\u0002io{4Ks";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\"/J.%l(\\ kk.\\s";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\\8H vz8]ico4C,a.p\u000f q.4\\ika)\u000f;`i4\\=`|}],v~2A:` ";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\"}J1qE8Vs";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "m3\u0001#u{.Ggd`9]&ljsF'qk3[gWK\u001af\u001aQ\\\u001c{\u0000J@";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\"}N9nX8]:la3\u0015";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0086:
        r3[r2] = r1;
        r2 = 10;
        r1 = "~<\\:ra/Ks";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0091:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\"}],bg.[;dz4@'Ljg";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009c:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\\8H vz8]ico4C,a.p\u000f<ke3@>k.>@$ho3K";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a7:
        r3[r2] = r1;
        r2 = 13;
        r1 = "[3J1uk>[,a4}],bg.[;dz4@'LjrE<lj}\\!j{1Kika)\u000f+`.8B9qws\u000f";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b2:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\"}K,sg>J\u0000a4";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00bd:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\"}L%lk3[\u0000kh2\u0015";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c8:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\\8H vz8]irg)Gs%e8Vs";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d3:
        r3[r2] = r1;
        r2 = 17;
        r1 = "})N=`.4\\ika)\u000f*mo3H,a.p\u000f";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00de:
        r3[r2] = r1;
        r2 = 18;
        r1 = "O>[ j`}\u0002ivk3K\nj`3J*qg2A\nmo3H,a";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00e9:
        r3[r2] = r1;
        r2 = 19;
        r1 = "m3\u0001#u{.Ggd`9]&ljsF'qk3[gFA\u0013a\fFZ\u0014`\u0007";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f4:
        r3[r2] = r1;
        r2 = 20;
        r1 = "m2A'`m)J-";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x00ff:
        r3[r2] = r1;
        r2 = 21;
        r1 = "m3\u0001#u{.Ggd`9]&ljsl\u0006K@\u0018l\u001dLA\u0013p\nMO\u0013h\f";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010a:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\"}N9uE8Vs";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0115:
        r3[r2] = r1;
        r2 = 23;
        r1 = "B2H k.*F=m.p\u000f#pg9\u0015";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0120:
        r3[r2] = r1;
        r2 = 24;
        r1 = "~(\\!Zb2H kQ.J;sk/p=lc8";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012b:
        r3[r2] = r1;
        r2 = 25;
        r1 = "b2H k.p\u000f#pg9\u0015";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0136:
        r3[r2] = r1;
        r2 = 26;
        r1 = "\"}\\-nX8]:la3\u0015";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0141:
        r3[r2] = r1;
        r2 = 27;
        r1 = "~(\\!Zb2H kQ1@*db\u0002[ hk";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014c:
        r3[r2] = r1;
        r2 = 28;
        r1 = "\"}_<vf\u000bJ;vg2As";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0157:
        r3[r2] = r1;
        r2 = 29;
        r1 = "\"}_%pi4A\u0019io)I&wc\tV9`4";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0162:
        r3[r2] = r1;
        r2 = 30;
        r1 = ".1@.l`\u000fJ:ua3\\,%g.\u000f'pb1";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016d:
        r3[r2] = r1;
        r2 = 31;
        r1 = "m3\u0001#u{.GglcsN'a|2F-+o>[ j`sf\u0004Z\\\u0018|\u0019J@\u000ej";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0178:
        r3[r2] = r1;
        r2 = 32;
        r1 = "~(\\!Zz2p hQ9N=d";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0183:
        r3[r2] = r1;
        r2 = 33;
        r1 = ".q\\!d|8y,w}4@'?";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018e:
        r3[r2] = r1;
        r2 = 34;
        r1 = "\"}N'db$[ f}\u000bJ;vg2As";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x0199:
        r3[r2] = r1;
        r2 = 35;
        r1 = "B2H k.;N ik9\u000f>lz5\u000f:`|+J;%k/]&w.p\u000f*jj8\u0015";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a4:
        r3[r2] = r1;
        r2 = 36;
        r1 = "B2H k..Z*fk8Ki(..F-?";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01af:
        r3[r2] = r1;
        r2 = 37;
        r1 = "B2H k.;N ik9\u000f>lz5\u000f;`z(]'%m2K,?";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01ba:
        r3[r2] = r1;
        r2 = 38;
        r1 = "\"}\\,wx8]\u001dlc8\u0014";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c5:
        r3[r2] = r1;
        r2 = 39;
        r1 = "d.@'@v>J9qg2Ai(.";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d0:
        r3[r2] = r1;
        r2 = 40;
        r1 = "O>[ j`}\u0002ivk3K\u001a`|+J;Qg0J;";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01db:
        r3[r2] = r1;
        r2 = 41;
        r1 = "\"}I%dig";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e6:
        r3[r2] = r1;
        r2 = 42;
        r1 = "B2H k.;N ik9\u000f>lz5\u000f\u0005jm<Ci`|/@;%#}L&akg";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f1:
        r3[r2] = r1;
        r2 = 43;
        r1 = "m2A'`m)F&k";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fc:
        r3[r2] = r1;
        r2 = 44;
        r1 = "g0\u0019}+d-Z:m >A";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0207:
        r3[r2] = r1;
        r2 = 45;
        r1 = "\"}_&wzg";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0212:
        r3[r2] = r1;
        r2 = 46;
        r1 = "A-J'%m2A'`m)F&k.*F=m.9J/d{1[i(.4_s";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021d:
        r3[r2] = r1;
        r2 = 47;
        r1 = "A-J'%m2A'`m)F&k.*F=m.9J/d{1[ima.[i(.4_s";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0228:
        r3[r2] = r1;
        r2 = 48;
        r1 = "A-J'%m2A'`m)F&k.*F=m.5N;am2K,a.5@:q.p\u000f u4";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0233:
        r3[r2] = r1;
        r2 = 49;
        r1 = "Q4B1 \u0002[*u 7_<vfsL'";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023e:
        r3[r2] = r1;
        r2 = 50;
        r1 = "K%L,uz4@'%z2\u000f*j`3J*q.5@:q.p\u000f h8i\u0001#u{.Ggf`";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x0249:
        r3[r2] = r1;
        r2 = 51;
        r1 = "G3Y(ig9\u000f-`h<Z%q.>@'k ";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0254:
        r3[r2] = r1;
        r2 = 52;
        r1 = "](L*`k9\u000f=j.2_,k.>@'kk>[ j`}\u0002il~g";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x025f:
        r3[r2] = r1;
        r2 = 53;
        r1 = "O>[ j`g\u000f;`})@;`\\)L\u001emk3},bg.[,w](L*`k9";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026a:
        r3[r2] = r1;
        r2 = 54;
        r1 = "A-J'%m2A'`m)F&k.*F=m.2_=la3\\i(.4_s";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0275:
        r3[r2] = r1;
        r2 = 55;
        r1 = "G3Y(ig9\u000f$dg3\u000f*j`3";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0280:
        r3[r2] = r1;
        r2 = 56;
        r1 = "H<F%`j}X qf}N%i.>@'k}s";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028b:
        r3[r2] = r1;
        r2 = 57;
        r1 = "\"}F'ak%\u0015";
        r0 = 56;
        r3 = r4;
        goto L_0x0009;
    L_0x0296:
        r3[r2] = r1;
        r2 = 58;
        r1 = "A-J'%m2A'`m)F&k.*F=m.1N:q.:@&a.p\u000f u4";
        r0 = 57;
        r3 = r4;
        goto L_0x0009;
    L_0x02a1:
        r3[r2] = r1;
        r2 = 59;
        r1 = "A-J'%m2A'`m)F&k.*F=m.0N k.p\u000f u4";
        r0 = 58;
        r3 = r4;
        goto L_0x0009;
    L_0x02ac:
        r3[r2] = r1;
        r2 = 60;
        r1 = "~5@'`";
        r0 = 59;
        r3 = r4;
        goto L_0x0009;
    L_0x02b7:
        r3[r2] = r1;
        r2 = 61;
        r1 = "?s\u001eg3";
        r0 = 60;
        r3 = r4;
        goto L_0x0009;
    L_0x02c2:
        r3[r2] = r1;
        r2 = 62;
        r1 = "J\u0013|iff8L\"l`:\u000f=m|8N-%f<\\igk8Ai@v>J9qg2Ai`|/@;?";
        r0 = 61;
        r3 = r4;
        goto L_0x0009;
    L_0x02cd:
        r3[r2] = r1;
        r2 = 63;
        r1 = "J\u0013|iff8L\"l`:\u000f=m|8N-%f<\\igk8Ail`)J;w{-[,a.|";
        r0 = 62;
        r3 = r4;
        goto L_0x0009;
    L_0x02d8:
        r3[r2] = r1;
        r2 = 64;
        r1 = "M<Aika)\u000f.`z}\\ v.4A/j.;]&h.5@:q4}";
        r0 = 63;
        r3 = r4;
        goto L_0x0009;
    L_0x02e3:
        r3[r2] = r1;
        r2 = 65;
        r1 = "\"}_&wzg\u001ep5>m";
        r0 = 64;
        r3 = r4;
        goto L_0x0009;
    L_0x02ee:
        r3[r2] = r1;
        r2 = 66;
        r1 = "J2\u000f'jz}A,`j}|\u0000V.<H(l`}X qf4Ai6.0F'v }z:`.1N:q.:@&a..F:%|8\\9j`.Jg%";
        r0 = 65;
        r3 = r4;
        goto L_0x0009;
    L_0x02f9:
        r3[r2] = r1;
        r2 = 67;
        r1 = "K%L,uz4@'%y5J'%m1@:`.(K9%}2L\"`z}\u0002i";
        r0 = 66;
        r3 = r4;
        goto L_0x0009;
    L_0x0304:
        r3[r2] = r1;
        r2 = 68;
        r1 = "I8[ivg.\u000f kh2\u000f:pm>J,a.*F=m.5@:q4}";
        r0 = 67;
        r3 = r4;
        goto L_0x0009;
    L_0x030f:
        r3[r2] = r1;
        r2 = 69;
        r1 = "]\u0014|iWk>J sg3Hg+ ";
        r0 = 68;
        r3 = r4;
        goto L_0x0009;
    L_0x031a:
        r3[r2] = r1;
        r2 = 70;
        r1 = "Z2\u000f.`z}\\ v.p\u000f!j})\u0015";
        r0 = 69;
        r3 = r4;
        goto L_0x0009;
    L_0x0325:
        r3[r2] = r1;
        r2 = 71;
        r1 = "H<F%`j}[&%|8\\&ix8\u000f!j})\u000f-k}}\u0002i";
        r0 = 70;
        r3 = r4;
        goto L_0x0009;
    L_0x0330:
        r3[r2] = r1;
        r2 = 72;
        r1 = "]\u0014|iWk>J sk9\u000f\u001aq|4A.?.";
        r0 = 71;
        r3 = r4;
        goto L_0x0009;
    L_0x033b:
        r3[r2] = r1;
        r2 = 73;
        r1 = "I8[ivg.\u000f kh2\u000f,w|2]i(..F:Ma.[s";
        r0 = 72;
        r3 = r4;
        goto L_0x0009;
    L_0x0346:
        r3[r2] = r1;
        r2 = 74;
        r1 = "A-J'%m2A'`m)F&k.;N ik9\u000fd%|8[s";
        r0 = 73;
        r3 = r4;
        goto L_0x0009;
    L_0x0351:
        r3[r2] = r1;
        r2 = 75;
        r1 = "o>[ j`}\u0002il`7J*qM2A'`m)F&k\"}Z'`v-J*qk9\u0001g+";
        r0 = 74;
        r3 = r4;
        goto L_0x0009;
    L_0x035c:
        r3[r2] = r1;
        r2 = 76;
        r1 = "~<]:`]4\\\u0000kh2\u000f*wo.Gs";
        r0 = 75;
        r3 = r4;
        goto L_0x0009;
    L_0x0367:
        r3[r2] = r1;
        r2 = 77;
        r1 = "匋呐\u0015i";
        r0 = 76;
        r3 = r4;
        goto L_0x0009;
    L_0x0372:
        r3[r2] = r1;
        r2 = 78;
        r1 = "\\8H vz8]iCo4C,a.*F=m..J;sk/\u000f,w|2]i(.>@-`4";
        r0 = 77;
        r3 = r4;
        goto L_0x0009;
    L_0x037d:
        r3[r2] = r1;
        r2 = 79;
        r1 = ".晲族攁皁O-_\u0002`wq诘砧计一\u0017f\u000ePO\u0013hirk?竀盍D~-d,|与膩";
        r0 = 78;
        r3 = r4;
        goto L_0x0009;
    L_0x0388:
        r3[r2] = r1;
        r2 = 80;
        r1 = "[3G(kj1J-%}8]?`|}],v~2A:`.8];j|}L&ak}\u0002i";
        r0 = 79;
        r3 = r4;
        goto L_0x0009;
    L_0x0393:
        r3[r2] = r1;
        r2 = 81;
        r1 = "B2L(i.8];j|}K,vm/F9qg2As%";
        r0 = 80;
        r3 = r4;
        goto L_0x0009;
    L_0x039e:
        r3[r2] = r1;
        r2 = 82;
        r1 = "七卤酢";
        r0 = 81;
        r3 = r4;
        goto L_0x0009;
    L_0x03a9:
        r3[r2] = r1;
        r2 = 83;
        r1 = ".乐孷坡";
        r0 = 82;
        r3 = r4;
        goto L_0x0009;
    L_0x03b4:
        r3[r2] = r1;
        r2 = 84;
        r1 = ".\u001c_9Nk$\u0015";
        r0 = 83;
        r3 = r4;
        goto L_0x0009;
    L_0x03bf:
        r3[r2] = r1;
        r2 = 85;
        r1 = ".杷圇$d`4I,vz买酢缧D~-d,|";
        r0 = 84;
        r3 = r4;
        goto L_0x0009;
    L_0x03ca:
        r3[r2] = r1;
        r2 = 86;
        r1 = ".霃N'a|2F-%O-_\u0002`w";
        r0 = 85;
        r3 = r4;
        goto L_0x0009;
    L_0x03d5:
        r3[r2] = r1;
        r2 = 87;
        r1 = ".乓\u000f\bu~\u0016J0?";
        r0 = 86;
        r3 = r4;
        goto L_0x0009;
    L_0x03e0:
        r3[r2] = r1;
        r2 = 88;
        r1 = "G\u0010j\u0000%g.\u000f-p~1F*dz8Kiwk-@;qk9\u000f+|..J;sk/\u0001iBg+Jip~}A&r }";
        r0 = 87;
        r3 = r4;
        goto L_0x0009;
    L_0x03eb:
        r3[r2] = r1;
        z = r4;
        r2 = new java.util.LinkedHashMap;
        r2.<init>();
        a = r2;
        r1 = "}sE9p}5\u0001*k";
        r0 = -1;
    L_0x03f9:
        r1 = r1.toCharArray();
        r3 = r1.length;
        r4 = 0;
        r5 = 1;
        if (r3 > r5) goto L_0x0439;
    L_0x0402:
        r5 = r1;
        r6 = r4;
        r11 = r3;
        r3 = r1;
        r1 = r11;
    L_0x0407:
        r8 = r3[r4];
        r7 = r6 % 5;
        switch(r7) {
            case 0: goto L_0x042b;
            case 1: goto L_0x042e;
            case 2: goto L_0x0431;
            case 3: goto L_0x0434;
            default: goto L_0x040e;
        };
    L_0x040e:
        r7 = 5;
    L_0x040f:
        r7 = r7 ^ r8;
        r7 = (char) r7;
        r3[r4] = r7;
        r4 = r6 + 1;
        if (r1 != 0) goto L_0x0437;
    L_0x0417:
        r3 = r5;
        r6 = r4;
        r4 = r1;
        goto L_0x0407;
    L_0x041b:
        r9 = 14;
        goto L_0x001f;
    L_0x041f:
        r9 = 93;
        goto L_0x001f;
    L_0x0423:
        r9 = 47;
        goto L_0x001f;
    L_0x0427:
        r9 = 73;
        goto L_0x001f;
    L_0x042b:
        r7 = 14;
        goto L_0x040f;
    L_0x042e:
        r7 = 93;
        goto L_0x040f;
    L_0x0431:
        r7 = 47;
        goto L_0x040f;
    L_0x0434:
        r7 = 73;
        goto L_0x040f;
    L_0x0437:
        r3 = r1;
        r1 = r5;
    L_0x0439:
        if (r3 > r4) goto L_0x0402;
    L_0x043b:
        r3 = new java.lang.String;
        r3.<init>(r1);
        r1 = r3.intern();
        switch(r0) {
            case 0: goto L_0x0455;
            case 1: goto L_0x0463;
            default: goto L_0x0447;
        };
    L_0x0447:
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);
        r2.put(r1, r0);
        r2 = a;
        r1 = "}4\\go~(\\!+g2";
        r0 = 0;
        goto L_0x03f9;
    L_0x0455:
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);
        r2.put(r1, r0);
        r2 = a;
        r1 = "k<\\0qa0J:vo:Jgfa0";
        r0 = 1;
        goto L_0x03f9;
    L_0x0463:
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);
        r2.put(r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.c.<clinit>():void");
    }

    private static int a(g gVar, long j) {
        int a;
        String str;
        int i;
        int i2 = 0;
        String str2 = null;
        int i3 = -1;
        try {
            List<p> a2 = f.a(z[49]);
            if (a2.size() > 0) {
                for (p pVar : a2) {
                    if (!TextUtils.isEmpty(pVar.i().toString())) {
                        InetAddress inetAddress = null;
                        try {
                            inetAddress = b(pVar.i().toString());
                        } catch (Exception e) {
                        }
                        if (inetAddress != null) {
                            str2 = inetAddress.getHostAddress();
                            i2 = pVar.h();
                            d.d(z[1], new StringBuilder(z[48]).append(str2).append(z[45]).append(i2).toString());
                            if (!j.a(str2) && i2 != 0) {
                                a = a(gVar, j, str2, i2);
                                if (a == 0) {
                                    str = str2;
                                    i = i2;
                                    break;
                                }
                            }
                            a = i3;
                            i3 = a;
                        } else {
                            continue;
                        }
                    }
                }
                a = i3;
                str = str2;
                i = i2;
            } else {
                InetAddress b = b(z[44]);
                if (b == null) {
                    return -1;
                }
                str2 = b.getHostAddress();
                if (TextUtils.isEmpty(str2)) {
                    return -1;
                }
                int[] iArr = new int[9];
                iArr = new int[]{7000, 7002, 7003, 7004, 7005, 7006, 7007, 7008, 7009};
                a = -1;
                i3 = 0;
                i2 = 0;
                while (i2 < 9) {
                    try {
                        i3 = iArr[i2];
                        d.d(z[1], new StringBuilder(z[47]).append(str2).append(z[45]).append(i3).toString());
                        a = a(gVar, j, str2, i3);
                        if (a == 0) {
                            break;
                        }
                        i2++;
                    } catch (Exception e2) {
                        i2 = i3;
                        i3 = a;
                    }
                }
                String str3 = str2;
                i = i3;
                str = str3;
            }
        } catch (Exception e3) {
        }
        if (a != 0) {
            str = a.l();
            i = a.m();
            d.d(z[1], new StringBuilder(z[46]).append(str).append(z[45]).append(i).toString());
            if (!j.a(str) || i == 0) {
                d.d(z[1], z[51]);
                return -1;
            }
            a = a(gVar, j, str, i);
        }
        if (a == 0) {
            return a;
        }
        a.a(str, i);
        d.f(z[1], new StringBuilder(z[52]).append(str).append(z[45]).append(i).toString());
        return a;
        d.c(z[1], z[50]);
        a = i3;
        str = str2;
        i = i2;
        if (a != 0) {
            str = a.l();
            i = a.m();
            d.d(z[1], new StringBuilder(z[46]).append(str).append(z[45]).append(i).toString());
            if (j.a(str)) {
            }
            d.d(z[1], z[51]);
            return -1;
        }
        if (a == 0) {
            return a;
        }
        a.a(str, i);
        d.f(z[1], new StringBuilder(z[52]).append(str).append(z[45]).append(i).toString());
        return a;
    }

    private static int a(g gVar, long j, String str, int i) {
        if (gVar.d()) {
            d.g(z[1], z[75]);
            return -991;
        }
        int InitPush = Protocol.InitPush(j, str, i);
        if (InitPush == 0) {
            return InitPush;
        }
        if (gVar.d()) {
            d.a(z[1], new StringBuilder(z[74]).append(InitPush).toString());
            return InitPush;
        }
        d.d(z[1], new StringBuilder(z[74]).append(InitPush).toString());
        return InitPush;
    }

    public static synchronized cn.jiguang.b.b.j a(Context context) {
        String str;
        cn.jiguang.b.b.j a;
        Throwable e;
        String str2;
        synchronized (c.class) {
            if (a.a(l.a(context)) || a.e()) {
                String str3 = "";
                DatagramSocket datagramSocket = null;
                DatagramSocket datagramSocket2;
                try {
                    datagramSocket2 = new DatagramSocket();
                    try {
                        byte[] a2 = a(context, cn.jiguang.b.a.d.i(context), cn.jiguang.b.a.d.e(context));
                        for (Entry entry : a.entrySet()) {
                            str = (String) entry.getKey();
                            try {
                                d.d(z[1], new StringBuilder(z[70]).append(str).append(z[65]).toString());
                                Boolean bool = (Boolean) entry.getValue();
                                InetAddress b = (bool == null || !bool.booleanValue()) ? b(str) : InetAddress.getByName(str);
                                if (b == null) {
                                    d.d(z[1], new StringBuilder(z[73]).append(str).toString(), new Exception(new StringBuilder(z[71]).append(str).toString()));
                                    str3 = str;
                                } else {
                                    DatagramPacket datagramPacket = new DatagramPacket(a2, 128, b, 19000);
                                    try {
                                        datagramSocket2.setSoTimeout(6000);
                                        datagramSocket2.send(datagramPacket);
                                        datagramPacket = new DatagramPacket(new byte[1024], 1024);
                                        d.d(z[1], z[69]);
                                        datagramSocket2.receive(datagramPacket);
                                        Object obj = new byte[datagramPacket.getLength()];
                                        System.arraycopy(datagramPacket.getData(), 0, obj, 0, obj.length);
                                        str3 = new String(obj);
                                        d.e(z[1], new StringBuilder(z[72]).append(str3).toString());
                                        a = a(str3);
                                        if (a != null) {
                                            d.f(z[1], new StringBuilder(z[68]).append(str).toString());
                                            a.f();
                                            if (datagramSocket2 != null) {
                                                try {
                                                    datagramSocket2.close();
                                                } catch (AssertionError e2) {
                                                    d.i(z[1], new StringBuilder(z[67]).append(e2.toString()).toString());
                                                }
                                            }
                                        } else {
                                            d.h(z[1], new StringBuilder(z[64]).append(str).toString());
                                            str3 = str;
                                        }
                                    } catch (Throwable e3) {
                                        d.d(z[1], new StringBuilder(z[64]).append(str).toString(), e3);
                                        str3 = str;
                                    }
                                }
                            } catch (AssertionError e4) {
                                e3 = e4;
                                DatagramSocket datagramSocket3 = datagramSocket2;
                                str2 = str;
                                datagramSocket = datagramSocket3;
                            } catch (Throwable th) {
                                e3 = th;
                            }
                        }
                        if (datagramSocket2 != null) {
                            try {
                                datagramSocket2.close();
                            } catch (AssertionError e5) {
                                d.i(z[1], new StringBuilder(z[67]).append(e5.toString()).toString());
                            }
                        }
                    } catch (AssertionError e6) {
                        e3 = e6;
                        datagramSocket = datagramSocket2;
                        str2 = str3;
                        try {
                            d.d(z[1], new StringBuilder(z[73]).append(str2).toString(), e3);
                            if (datagramSocket != null) {
                                try {
                                    datagramSocket.close();
                                } catch (AssertionError e52) {
                                    d.i(z[1], new StringBuilder(z[67]).append(e52.toString()).toString());
                                }
                            }
                            a = null;
                            return a;
                        } catch (Throwable th2) {
                            e3 = th2;
                            datagramSocket2 = datagramSocket;
                            if (datagramSocket2 != null) {
                                try {
                                    datagramSocket2.close();
                                } catch (AssertionError e22) {
                                    d.i(z[1], new StringBuilder(z[67]).append(e22.toString()).toString());
                                }
                            }
                            throw e3;
                        }
                    } catch (Throwable th3) {
                        e3 = th3;
                        str = str3;
                        try {
                            d.d(z[1], new StringBuilder(z[73]).append(str).toString(), e3);
                            if (datagramSocket2 != null) {
                                try {
                                    datagramSocket2.close();
                                } catch (AssertionError e522) {
                                    d.i(z[1], new StringBuilder(z[67]).append(e522.toString()).toString());
                                }
                            }
                            a = null;
                            return a;
                        } catch (Throwable th4) {
                            e3 = th4;
                            if (datagramSocket2 != null) {
                                datagramSocket2.close();
                            }
                            throw e3;
                        }
                    }
                } catch (AssertionError e7) {
                    e3 = e7;
                    str2 = str3;
                    d.d(z[1], new StringBuilder(z[73]).append(str2).toString(), e3);
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                    a = null;
                    return a;
                } catch (Throwable th5) {
                    e3 = th5;
                    datagramSocket2 = null;
                    if (datagramSocket2 != null) {
                        datagramSocket2.close();
                    }
                    throw e3;
                }
                a = null;
            } else {
                d.e(z[1], z[66]);
                a = a(a.n());
            }
        }
        return a;
    }

    private static cn.jiguang.b.b.j a(String str) {
        try {
            cn.jiguang.b.b.j jVar = new cn.jiguang.b.b.j();
            jVar.a(str);
            jVar.b(str);
            if (!jVar.e()) {
                return jVar;
            }
        } catch (Throwable e) {
            d.d(z[1], z[76], e);
        }
        return null;
    }

    public static void a(Context context, int i, boolean z) {
        if (z) {
            d.j(z[1], new StringBuilder(z[78]).append(i).toString());
            Object a = h.a(i);
            if (!TextUtils.isEmpty(a)) {
                d.h(z[1], new StringBuilder(z[81]).append(a).toString());
            }
        }
        String i2 = cn.jiguang.b.a.d.i(context);
        if (PointerIconCompat.TYPE_CELL == i) {
            cn.jiguang.e.a.a(context, new StringBuilder(z[77]).append(cn.jiguang.b.a.c).append(z[83]).toString(), -1);
            c();
        } else if (PointerIconCompat.TYPE_CROSSHAIR == i) {
            d.e(z[1], z[88]);
        } else if (KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist == i) {
            cn.jiguang.e.a.a(context, new StringBuilder(z[77]).append(cn.jiguang.b.a.c).append(z[87]).append(i2).append(z[82]).toString(), -1);
            c();
        } else if (PointerIconCompat.TYPE_VERTICAL_TEXT == i) {
            cn.jiguang.e.a.a(context, new StringBuilder(z[84]).append(i2).append(z[86]).toString(), -1);
            c();
        } else if (PointerIconCompat.TYPE_TEXT == i) {
            cn.jiguang.e.a.a(context, new StringBuilder(z[84]).append(i2).append(z[79]).toString(), -1);
        } else if (10001 == i) {
            cn.jiguang.e.a.a(context, z[85], -1);
        } else {
            d.e(z[1], new StringBuilder(z[80]).append(i).toString());
        }
    }

    public static void a(Context context, cn.jiguang.b.b.a aVar) {
        d.d(z[1], z[18]);
        if (aVar == cn.jiguang.b.a.d.j(context)) {
            d.a(z[1], new StringBuilder(z[17]).append(aVar).toString());
            return;
        }
        cn.jiguang.b.a.d.a(context, aVar);
        Bundle bundle = new Bundle();
        bundle.putBoolean(z[21], aVar.name().equals(z[20]));
        cn.jiguang.e.a.a(context, z[19], bundle);
    }

    public static void a(Message message, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong(z[43], j);
        message.setData(bundle);
        message.sendToTarget();
    }

    public static boolean a() {
        return a.k();
    }

    public static boolean a(Context context, long j) {
        byte[] bArr = new byte[128];
        String a = b.e().a();
        String d = b.e().d();
        String b = b.e().b();
        String c = b.e().c();
        short d2 = h.a().d();
        d.c(z[1], new StringBuilder(z[16]).append(a).append(z[9]).append(d).append(z[15]).append(b).append(z[7]).append(c).append(z[5]).append(d2).toString());
        long g = a.g();
        int abs = Math.abs(new Random().nextInt());
        cn.jiguang.b.f.a.a.a(abs);
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(13);
        outputDataUtil.writeU8(0);
        outputDataUtil.writeU64(g);
        outputDataUtil.writeU32((long) abs);
        outputDataUtil.writeU64(0);
        outputDataUtil.writeByteArrayincludeLength(a.getBytes());
        outputDataUtil.writeByteArrayincludeLength(d.getBytes());
        outputDataUtil.writeByteArrayincludeLength(b.getBytes());
        outputDataUtil.writeU8(0);
        outputDataUtil.writeByteArrayincludeLength(c.getBytes());
        h.a().e();
        outputDataUtil.writeU8(d2);
        outputDataUtil.writeU16At(outputDataUtil.current(), 0);
        byte[] a2 = cn.jiguang.b.e.a.a.b.a(outputDataUtil.toByteArray(), 0);
        if (a2 == null) {
            return false;
        }
        if (Protocol.SendData(j, a2, 0) == -991) {
            return false;
        }
        int RecvPush = Protocol.RecvPush(j, bArr, 30);
        if (RecvPush > 0) {
            JResponse a3 = cn.jiguang.b.e.a.a.a.a(bArr);
            if (a3 == null) {
                d.i(z[1], z[12]);
                return false;
            }
            d.c(z[1], a3.toString());
            if (a3.getCommand() != 0) {
                d.i(z[1], z[6]);
                return false;
            }
            cn.jiguang.b.e.a.d dVar = (cn.jiguang.b.e.a.d) a3;
            RecvPush = dVar.code;
            a.a(context, RecvPush);
            e.a().b(RecvPush);
            if (RecvPush == 0) {
                long juid = dVar.getJuid();
                c = dVar.a();
                String b2 = dVar.b();
                String c2 = dVar.c();
                d.f(z[1], new StringBuilder(z[4]).append(juid).append(z[11]).append(b2).append(z[14]).append(c2).toString());
                d.a(z[1], new StringBuilder(z[10]).append(c).toString());
                if (j.a(b2) || 0 == juid) {
                    d.j(z[1], z[13]);
                }
                cn.jiguang.e.a.g(context, c2);
                cn.jiguang.b.a.d.a(context, juid, c, b2, c2);
                cn.jiguang.e.a.a(context, z[8], z[2], b2);
                return true;
            }
            a(context, RecvPush, true);
        } else {
            d.j(z[1], new StringBuilder(z[3]).append(RecvPush).toString());
        }
        return false;
    }

    public static synchronized boolean a(g gVar, long j, cn.jiguang.b.b.j jVar) {
        boolean z;
        synchronized (c.class) {
            String c;
            int d;
            if (jVar == null) {
                c = a.c();
                d = a.d();
                if (c != null) {
                    d.d(z[1], new StringBuilder(z[58]).append(c).append(z[45]).append(d).toString());
                    if (a(gVar, j, c, d) == 0) {
                        z = true;
                    }
                }
                z = a(gVar, j) == 0;
            } else {
                int i;
                String a = jVar.a();
                d = jVar.b();
                d.d(z[1], new StringBuilder(z[59]).append(a).append(z[45]).append(d).toString());
                if (a == null || d == 0) {
                    i = -1;
                    d.h(z[1], z[55]);
                } else {
                    i = a(gVar, j, a, d);
                }
                if (i != 0) {
                    int i2 = 0;
                    for (String c2 : jVar.c()) {
                        int intValue = ((Integer) jVar.d().get(i2)).intValue();
                        d.d(z[1], new StringBuilder(z[54]).append(c2).append(z[45]).append(intValue).append(z[57]).append(i2).toString());
                        d = a(gVar, j, c2, intValue);
                        int i3;
                        if (d == 0) {
                            i3 = d;
                            d = intValue;
                            a = c2;
                            i = i3;
                            break;
                        }
                        i2++;
                        i3 = d;
                        d = intValue;
                        a = c2;
                        i = i3;
                    }
                }
                if (i == 0) {
                    a.a(a, d);
                    d.f(z[1], new StringBuilder(z[52]).append(a).append(z[45]).append(d).toString());
                    z = true;
                } else {
                    if (i != 0) {
                        i = a(gVar, j);
                    }
                    if (i == 0) {
                        z = true;
                    } else {
                        d.h(z[1], z[56]);
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    private static byte[] a(Context context, String str, long j) {
        String networkOperator;
        int intValue;
        String c = cn.jiguang.e.a.c(context);
        String str2 = "";
        try {
            networkOperator = ((TelephonyManager) context.getSystemService(z[60])).getNetworkOperator();
        } catch (Exception e) {
            e.printStackTrace();
            networkOperator = str2;
        }
        str2 = h.a().b() + c;
        try {
            intValue = Integer.valueOf(networkOperator).intValue();
        } catch (Exception e2) {
            intValue = 0;
        }
        Object obj = new byte[128];
        System.arraycopy(new byte[]{(byte) 0, Byte.MIN_VALUE}, 0, obj, 0, 2);
        ProtocolUtil.fillStringData(obj, str2, 2);
        ProtocolUtil.fillIntData(obj, intValue, 34);
        ProtocolUtil.fillIntData(obj, Integer.parseInt(((int) (2147483647L & j))), 38);
        if (str.length() > 50) {
            str = str.substring(0, 49);
        }
        ProtocolUtil.fillStringData(obj, str, 42);
        ProtocolUtil.fillStringData(obj, z[61], 92);
        ProtocolUtil.fillIntData(obj, 0, 102);
        return obj;
    }

    public static int b(Context context, long j) {
        byte[] bArr = new byte[128];
        long e = cn.jiguang.b.a.d.e(context);
        String b = j.b(cn.jiguang.b.a.d.g(context));
        if (b == null) {
            b = "";
        }
        String i = cn.jiguang.b.a.d.i(context);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        b.a();
        String d = b.d(SdkType.JCORE.name(), "");
        if (!TextUtils.isEmpty(d)) {
            i2 = cn.jiguang.e.a.c(d);
        }
        b.a();
        d = b.d(SdkType.JANALYTICS.name(), "");
        if (!TextUtils.isEmpty(d)) {
            i3 = cn.jiguang.e.a.c(d);
        }
        b.a();
        d = b.d(SdkType.JSHARE.name(), "");
        if (!TextUtils.isEmpty(d)) {
            i4 = cn.jiguang.e.a.c(d);
        }
        b.a();
        d = b.d(SdkType.JPUSH.name(), "");
        if (!TextUtils.isEmpty(d)) {
            i5 = cn.jiguang.e.a.c(d);
        }
        byte c = b.e().c(context);
        d.f(z[1], new StringBuilder(z[23]).append(e).append(z[22]).append(i).append(z[26]).append(i2).append(z[28]).append(i5).append(z[34]).append(i3).append(z[33]).append(i4).append(z[29]).append(c).toString());
        long currentTimeMillis = System.currentTimeMillis();
        short e2 = h.a().e();
        d.c(z[1], new StringBuilder(z[25]).append(e).append(z[41]).append(e2).toString());
        long g = a.g();
        long j2 = (long) i2;
        long j3 = (long) i5;
        long j4 = (long) i3;
        long j5 = (long) i4;
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(17);
        outputDataUtil.writeU8(1);
        outputDataUtil.writeU64(g);
        outputDataUtil.writeU32(0);
        outputDataUtil.writeU64(e);
        outputDataUtil.writeU8(97);
        outputDataUtil.writeU8(0);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeByteArrayincludeLength(b.getBytes());
        outputDataUtil.writeU32(j3);
        outputDataUtil.writeU32(j4);
        outputDataUtil.writeU32(j5);
        outputDataUtil.writeU32(j2);
        outputDataUtil.writeByteArrayincludeLength(i.getBytes());
        outputDataUtil.writeU8(0);
        outputDataUtil.writeU8(e2);
        outputDataUtil.writeU8(c);
        outputDataUtil.writeU16At(outputDataUtil.current(), 0);
        byte[] a = cn.jiguang.b.e.a.a.b.a(outputDataUtil.toByteArray(), 1);
        if (a == null || a.length <= 0) {
            return -1;
        }
        int i6;
        i2 = Protocol.LogPush(j, bArr, a, 0);
        e = System.currentTimeMillis();
        if (i2 == 0 || i2 == 9999) {
            JResponse a2 = cn.jiguang.b.e.a.a.a.a(bArr);
            cn.jiguang.b.e.a.c cVar = null;
            if (a2 instanceof cn.jiguang.b.e.a.c) {
                cVar = (cn.jiguang.b.e.a.c) a2;
            }
            if (cVar == null) {
                d.h(z[1], new StringBuilder(z[37]).append(i2).append(z[30]).toString());
                cn.jiguang.b.f.c.a(context, i2, e - currentTimeMillis, 1);
                return -1;
            }
            d.c(z[1], cVar.toString());
            i6 = cVar.code;
            e.a().a(i6);
            if (i6 == 0) {
                i2 = cVar.getSid();
                j5 = ((long) cVar.a()) * 1000;
                cn.jiguang.b.a.d.a(context, i2);
                a.b(j5);
                d.f(z[1], new StringBuilder(z[36]).append(i2).append(z[38]).append(j5).toString());
                d.d(z[1], z[40]);
                try {
                    Bundle bundle = new Bundle();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(z[24], j5);
                    jSONObject.put(z[27], System.currentTimeMillis());
                    bundle.putString(z[32], jSONObject.toString());
                    cn.jiguang.e.a.a(context, z[31], bundle);
                } catch (JSONException e3) {
                    d.g(z[1], new StringBuilder(z[39]).append(e3.getMessage()).toString());
                    i2 = i6;
                    i6 = 0;
                }
            } else if (i6 == 10000) {
                d.h(z[1], new StringBuilder(z[42]).append(i6).toString());
                i6 = 1;
                i2 = -1;
            } else {
                d.h(z[1], new StringBuilder(z[35]).append(h.a(i6)).toString());
            }
            i2 = i6;
            i6 = 0;
        } else {
            i6 = 1;
            d.h(z[1], new StringBuilder(z[37]).append(i2).toString());
        }
        cn.jiguang.b.f.c.a(context, i2, e - currentTimeMillis, i6);
        return i2;
    }

    private static InetAddress b(String str) {
        InetAddress inetAddress = null;
        d dVar = new d(str);
        try {
            dVar.start();
            dVar.join(3000);
            inetAddress = dVar.a();
        } catch (InterruptedException e) {
            d.i(z[1], z[63]);
        } catch (Exception e2) {
            d.i(z[1], new StringBuilder(z[62]).append(e2).toString());
        }
        return inetAddress;
    }

    public static void b() {
        d.c(z[1], z[53]);
        a.i();
    }

    private static void c() {
        d.c(z[1], z[0]);
        a.j();
    }
}
