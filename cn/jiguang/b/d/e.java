package cn.jiguang.b.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.api.BasePreferenceManager;
import cn.jiguang.api.SdkType;
import cn.jiguang.b.f.a.a;
import cn.jiguang.c.d;
import cn.jiguang.e.i;
import cn.jiguang.e.j;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private static e b;
    private static final String[] z;
    private Context a = null;
    private Handler c = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 69;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "CB[b\u0013DVCo\u001aRYLf7A";
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
            case 0: goto L_0x0315;
            case 1: goto L_0x0319;
            case 2: goto L_0x031d;
            case 3: goto L_0x0321;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 82;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "C\\wg6";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "C\\wf;@C";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "AR[>GhKe6V";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "yv_k9VvxZ\u0007G^Dy";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "PY\u0006`\"FD@$3]SZe;W\u0019[o E^Ko|wVMg=]dMx$ZTM";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "PXF~7KC\b7o\u0013Y]f>";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "PVKb7\u0013QAf7\u0013^[*<\\C\bo*ZD\\*\"RC@*";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "yG]y:lV_k9VhNc>VhDc!G";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "TR\\I3P_MK%R\\MF;@C\bO*PRX~;\\Y";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "PVKb7\u0013QAf7\u0013^[*<\\C\bo*ZD\\";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "wqi2fq\u0006\u0018HertlN`\u0006";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "C\\wd3^R";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "~~ol\u001fr\u0007oI\u0001Bp{C0\u0000syO\u0010rf}K\u0013\u0007pfK\u0016puA[\u0019qPyI$\\NO3#Xc\u0007g\u001aR\u0003i|}Izz(e\u0007Dy\b\\ri=7pCRCbgPzg\u0014\u0000f[Z'Zma9(Jc@a\u0004KNbG+d``9}[YI@=B}qD\u001bwz\u0007e\u0006aCAs\u001bpuMM}\u0003{\u0003H\"in\\f$\u0002\u0018n\\\u0000c\\{<\u001d\u0004|=7\u0001o^=kg\u0006OI\u0004A\u000e\u001c2\n\u0000\u0000\u0018f\u001aVUch\u0017In^<!d[R?\u0001DPey}AEcY#\nUx@#]Zkd%zsi[\u0013q";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "CVZy7yDGd\u001dQ]M~r\u0013[Ay&\t";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "CVZy7yDGd\u001dQ]M~r\u0013rPi7CCAe<\t";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "@Awd3^R";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "adi%\u0017pu\u0007Z\u0019pd\u0019Z3WSAd5";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "tR\\*\u001fw\u0002\bo AXZ";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "~s\u001d";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "FCN'j";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "pXFd7PCAe<";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "pV\\i:\u0013v[y7ACAe<vEZe \u0013CG*3EXAnr[C\\zrP[Gy7\u0013TZk![\u0017\u0005*";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "|C@o \u0013@Ze<T\u0017Zo!CXFy7\u0013D\\k&FD\b'r";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "ZSMd&ZCQ";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "fcn'j";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "rTKo\"G\u001amd1\\SAd5";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "[C\\zh\u001c\u0018]z6RCM$!W\\\u0006`;TBId5\u001dTF%$\u0002\u0018X![\u0018[n9\u001cGGy&_^[~";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "[C\\z\u0001ZZXf7cX[~r@CI~'@tGn7\t";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "RGXf;PV\\c=]\u0018By=]";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "[C\\zrP[Ao<G\u0017Mr7PB\\orVEZe ";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "p[Gy7";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "[C\\z|XRMz\u0013_^^o";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "\u001f\u0017]x>\t";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "UVDy7";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "cx{^";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "YG]y:lV_k9VhIz\"lGC";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = "pXF~7]C\u0005^+CR";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "@SCU$VE";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "CX[~\rGNXo";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "\\D";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "RGXU9VN";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "曇文Dc!G夆贍旼厄缠孯倔０";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "莄叡曜斺>ZD\\０ｈ";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "莄叡曜斺>ZD\\*奵尼不\u0019＆乆C\\O*稨丁［刈陮旕仅";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "R@Ia7\u0013缤孰丧>ZD\\０ｈ";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "莄叡曜斺>ZD\\*奵尼不\u0019＆乆C\\O*稨丁［Ｒ０";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "u^Do\u001c\\Cne']Smr1VG\\c=]\u0017\u0012";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = "兟钒靶泟";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "兟钒敘捤乨穉";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        r2 = 50;
        r1 = "旓歓箿泟";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x024a:
        r3[r2] = r1;
        r2 = 51;
        r1 = "adi";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0255:
        r3[r2] = r1;
        r2 = 52;
        r1 = "PXEg3]S\bi3P_M*南吘ＭＲ";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x0260:
        r3[r2] = r1;
        r2 = 53;
        r1 = "PXEg3]S\bi3P_M*6V[M~7\u0013DAp7\u0013ＭＲ";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026b:
        r3[r2] = r1;
        r2 = 54;
        r1 = "PXEg3]S\bi3P_M*6V[M~7ＩＭ";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0276:
        r3[r2] = r1;
        r2 = 55;
        r1 = "PXEg3]S\bi3P_M*ｈＩ";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0281:
        r3[r2] = r1;
        r2 = 56;
        r1 = "PXEg3]S\bi3P_M*也匶吜Ｒ０";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028c:
        r3[r2] = r1;
        r2 = 57;
        r1 = "PXEg3]S\bi3P_M*6V[M~7\u0013D]x\"_B[*ｈＩ";
        r0 = 56;
        r3 = r4;
        goto L_0x0009;
    L_0x0297:
        r3[r2] = r1;
        r2 = 58;
        r1 = "R@Ia7lGI~:";
        r0 = 57;
        r3 = r4;
        goto L_0x0009;
    L_0x02a2:
        r3[r2] = r1;
        r2 = 59;
        r1 = "R@Ia7lTG<G";
        r0 = 58;
        r3 = r4;
        goto L_0x0009;
    L_0x02ad:
        r3[r2] = r1;
        r2 = 60;
        r1 = "@BKi7@D";
        r0 = 59;
        r3 = r4;
        goto L_0x0009;
    L_0x02b8:
        r3[r2] = r1;
        r2 = 61;
        r1 = "R@Ia7lTDk!@";
        r0 = 60;
        r3 = r4;
        goto L_0x0009;
    L_0x02c3:
        r3[r2] = r1;
        r2 = 62;
        r1 = "R@Ia7lQZe?";
        r0 = 61;
        r3 = r4;
        goto L_0x0009;
    L_0x02ce:
        r3[r2] = r1;
        r2 = 63;
        r1 = "R@Ia7lCG";
        r0 = 62;
        r3 = r4;
        goto L_0x0009;
    L_0x02d9:
        r3[r2] = r1;
        r2 = 64;
        r1 = "ARXe G\u0017Iz\"\u0013[Ay&ＩＭEI=]CMr&\u0013\n\u0015*<F[D";
        r0 = 63;
        r3 = r4;
        goto L_0x0009;
    L_0x02e4:
        r3[r2] = r1;
        r2 = 65;
        r1 = "ZCAg7";
        r0 = 64;
        r3 = r4;
        goto L_0x0009;
    L_0x02ef:
        r3[r2] = r1;
        r2 = 66;
        r1 = "RGXU3DVCo";
        r0 = 65;
        r3 = r4;
        goto L_0x0009;
    L_0x02fa:
        r3[r2] = r1;
        r2 = 67;
        r1 = "ARXe G\u0017Iz\"\u0013[Ay&ＩＭ";
        r0 = 66;
        r3 = r4;
        goto L_0x0009;
    L_0x0305:
        r3[r2] = r1;
        r2 = 68;
        r1 = "GNXo";
        r0 = 67;
        r3 = r4;
        goto L_0x0009;
    L_0x0310:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0315:
        r9 = 51;
        goto L_0x0020;
    L_0x0319:
        r9 = 55;
        goto L_0x0020;
    L_0x031d:
        r9 = 40;
        goto L_0x0020;
    L_0x0321:
        r9 = 10;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.e.<clinit>():void");
    }

    public e() {
        HandlerThread handlerThread = new HandlerThread(z[0]);
        handlerThread.start();
        this.c = new f(this, handlerThread.getLooper());
    }

    public static e a() {
        if (b == null) {
            b = new e();
        }
        return b;
    }

    private synchronized <T> ArrayList<T> a(Context context, String str) {
        Exception e;
        Throwable th;
        ArrayList<T> arrayList = null;
        synchronized (this) {
            if (context != null) {
                File file = new File(context.getFilesDir(), z[8]);
                if (file.exists()) {
                    d.c(z[4], new StringBuilder(z[7]).append(file.getAbsolutePath()).toString());
                    ArrayList<T> arrayList2 = new ArrayList();
                    ObjectInputStream objectInputStream;
                    try {
                        objectInputStream = new ObjectInputStream(context.openFileInput(str));
                        try {
                            arrayList = (ArrayList) objectInputStream.readObject();
                            try {
                                objectInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            try {
                                d.c(z[4], new StringBuilder(z[9]).append(e).toString());
                                e.printStackTrace();
                                if (objectInputStream == null) {
                                    try {
                                        objectInputStream.close();
                                        arrayList = arrayList2;
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                        arrayList = arrayList2;
                                    }
                                } else {
                                    arrayList = arrayList2;
                                }
                                return arrayList;
                            } catch (Throwable th2) {
                                th = th2;
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e22) {
                                        e22.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e5) {
                        Exception exception = e5;
                        objectInputStream = null;
                        e4 = exception;
                        d.c(z[4], new StringBuilder(z[9]).append(e4).toString());
                        e4.printStackTrace();
                        if (objectInputStream == null) {
                            arrayList = arrayList2;
                        } else {
                            objectInputStream.close();
                            arrayList = arrayList2;
                        }
                        return arrayList;
                    } catch (Throwable th3) {
                        objectInputStream = null;
                        th = th3;
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        throw th;
                    }
                }
                d.c(z[4], z[10]);
            }
        }
        return arrayList;
    }

    private ArrayList<a> a(String str) {
        ArrayList<a> arrayList = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(z[3]) == 0) {
                arrayList = a(jSONObject.optString(z[1]), jSONObject.optString(z[2]));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static ArrayList<a> a(String str, String str2) {
        try {
            Key b = b(z[13]);
            Cipher instance = Cipher.getInstance(z[17]);
            instance.init(2, b);
            String str3 = new String(instance.doFinal(Base64.decode(str.getBytes(), 2)));
            String b2 = a.b(str2, z[11]);
            String c = c(b2);
            if (b2 == null || c == null) {
                return null;
            }
            if (str3.compareToIgnoreCase(c) != 0) {
                return null;
            }
            ArrayList<a> arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(b2);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                a aVar = new a();
                aVar.a = jSONObject.optString(z[12]);
                aVar.b = jSONObject.optString(z[16]);
                arrayList.add(aVar);
            }
            d.c(z[4], new StringBuilder(z[14]).append(arrayList).toString());
            return arrayList;
        } catch (Exception e) {
            d.c(z[4], new StringBuilder(z[15]).append(e).toString());
            e.printStackTrace();
            return null;
        }
    }

    private synchronized <T> void a(Context context, String str, ArrayList<T> arrayList) {
        ObjectOutputStream objectOutputStream;
        Exception e;
        Object e2;
        Throwable th;
        if (!(context == null || arrayList == null)) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
                try {
                    objectOutputStream.writeObject(arrayList);
                    try {
                        objectOutputStream.flush();
                        objectOutputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (FileNotFoundException e4) {
                    e2 = e4;
                    try {
                        d.c(z[4], new StringBuilder(z[47]).append(e2).toString());
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.flush();
                                objectOutputStream.close();
                            } catch (Exception e32) {
                                e32.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.flush();
                                objectOutputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e32 = e6;
                    objectOutputStream2 = objectOutputStream;
                    try {
                        e32.printStackTrace();
                        if (objectOutputStream2 != null) {
                            try {
                                objectOutputStream2.flush();
                                objectOutputStream2.close();
                            } catch (Exception e322) {
                                e322.printStackTrace();
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            objectOutputStream.flush();
                            objectOutputStream.close();
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException e7) {
                e2 = e7;
                objectOutputStream = null;
                d.c(z[4], new StringBuilder(z[47]).append(e2).toString());
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
            } catch (Exception e8) {
                e322 = e8;
                e322.printStackTrace();
                if (objectOutputStream2 != null) {
                    objectOutputStream2.flush();
                    objectOutputStream2.close();
                }
            } catch (Throwable th4) {
                th = th4;
                objectOutputStream = null;
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
                throw th;
            }
        }
    }

    static /* synthetic */ void a(e eVar) {
        try {
            BasePreferenceManager.init(eVar.a);
            ArrayList a;
            if (Math.abs((System.currentTimeMillis() / 1000) - cn.jiguang.b.a.a.h(z[36])) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                ArrayList c = eVar.c();
                if (c == null || c.size() <= 0) {
                    a = eVar.a(eVar.a, z[8]);
                    if (a != null && a.size() > 0) {
                        d.c(z[4], new StringBuilder(z[42]).append(a).toString());
                        eVar.a(a);
                        return;
                    }
                    return;
                } else if (c.size() == 1 && j.a(((a) c.get(0)).a)) {
                    File file = new File(eVar.a.getFilesDir(), z[8]);
                    d.c(z[4], new StringBuilder(z[46]).append(c).toString());
                    if (file.exists()) {
                        file.delete();
                        d.c(z[4], new StringBuilder(z[44]).append(file.getAbsolutePath()).toString());
                        return;
                    }
                    return;
                } else {
                    eVar.a(eVar.a, z[8], c);
                    d.c(z[4], new StringBuilder(z[43]).append(c).toString());
                    eVar.a(c);
                    return;
                }
            }
            a = eVar.a(eVar.a, z[8]);
            if (a != null && a.size() > 0) {
                d.c(z[4], new StringBuilder(z[45]).append(a).toString());
                eVar.a(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static /* synthetic */ void a(e eVar, Message message) {
        if (message.obj instanceof g) {
            g gVar = (g) message.obj;
            String a = gVar.b;
            String b = gVar.c;
            int c = gVar.d;
            ArrayList arrayList = new ArrayList();
            a aVar = new a();
            if (!j.a(a)) {
                String str = b == null ? "" : b;
                aVar.a = a;
                aVar.b = str;
                arrayList.add(aVar);
                try {
                    ArrayList a2 = eVar.a(eVar.a, z[8]);
                    if (c == 1) {
                        if (a2 == null || (a2 != null && a2.size() == 0)) {
                            d.c(z[4], new StringBuilder(z[55]).append(a2).toString());
                            eVar.a(eVar.a, z[8], arrayList);
                        } else if (a2 == null || a2.contains(aVar)) {
                            d.c(z[4], new StringBuilder(z[52]).append(aVar).toString());
                        } else {
                            d.c(z[4], new StringBuilder(z[56]).append(aVar).toString());
                            a2.add(aVar);
                            eVar.a(eVar.a, z[8], a2);
                        }
                    } else if (c == 2 && a2 != null && a2.contains(aVar)) {
                        a2.remove(aVar);
                        d.c(z[4], new StringBuilder(z[53]).append(a2.size()).toString());
                        if (a2.size() == 0) {
                            File file = new File(eVar.a.getFilesDir(), z[8]);
                            if (file.exists()) {
                                file.delete();
                                d.c(z[4], new StringBuilder(z[54]).append(file.getAbsolutePath()).toString());
                                return;
                            }
                            return;
                        }
                        d.c(z[4], new StringBuilder(z[57]).append(a2).toString());
                        eVar.a(eVar.a, z[8], a2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void a(ArrayList<a> arrayList) {
        if (this.a == null) {
            d.c(z[4], z[6]);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) arrayList.get(i);
            if (!j.a(aVar.a) && !j.a(aVar.b)) {
                Intent intent = new Intent();
                intent.setClassName(aVar.a, aVar.b);
                ComponentName startService = this.a.startService(intent);
                if (startService != null) {
                    arrayList2.add(startService);
                } else {
                    arrayList3.add(new ComponentName(aVar.a, aVar.b));
                }
            } else if (!j.a(aVar.a) && j.a(aVar.b)) {
                String str = z[5];
                Intent intent2 = new Intent();
                intent2.setClassName(aVar.a, str);
                ComponentName startService2 = this.a.startService(intent2);
                if (startService2 != null) {
                    arrayList2.add(startService2);
                } else {
                    arrayList3.add(new ComponentName(aVar.a, str));
                }
            }
        }
        a(arrayList2, arrayList3);
    }

    private static RSAPublicKey b(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(z[51]).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception(z[50]);
        } catch (InvalidKeySpecException e2) {
            throw new Exception(z[48]);
        } catch (Exception e3) {
            throw new Exception(z[49]);
        }
    }

    private static String c(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(z[19]).digest(str.getBytes(z[20]));
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
            d.c(z[4], z[18]);
            return "";
        }
    }

    private ArrayList<a> c() {
        Throwable th;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        HttpURLConnection httpURLConnection2;
        AssertionError assertionError;
        AssertionError assertionError2;
        InputStream inputStream2 = null;
        String str = z[27];
        Object d = d();
        InputStream inputStream3;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.addRequestProperty(z[21], z[31]);
                httpURLConnection3.setRequestProperty(z[26], z[24]);
                httpURLConnection3.setRequestProperty(z[37], z[29]);
                if (Integer.parseInt(VERSION.SDK) < 8) {
                    System.setProperty(z[32], z[34]);
                }
                httpURLConnection3.setRequestMethod(z[35]);
                if (!TextUtils.isEmpty(d)) {
                    httpURLConnection3.setDoOutput(true);
                    httpURLConnection3.getOutputStream().write(d.getBytes());
                }
                int responseCode = httpURLConnection3.getResponseCode();
                d.g(z[4], new StringBuilder(z[28]).append(responseCode).toString());
                if (responseCode == 200) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    BasePreferenceManager.init(this.a);
                    cn.jiguang.b.a.a.a(z[36], currentTimeMillis);
                    inputStream3 = httpURLConnection3.getInputStream();
                    try {
                        str = new String(i.a(inputStream3), z[25]);
                        if (str == null) {
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                            }
                            return inputStream2;
                        }
                        ArrayList<a> a = a(str);
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        return a;
                    } catch (Throwable e3) {
                        th = e3;
                        inputStream = inputStream3;
                        httpURLConnection = httpURLConnection3;
                        th2 = th;
                        try {
                            d.e(z[4], z[30], th2);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return inputStream2;
                        } catch (Throwable th3) {
                            th2 = th3;
                            inputStream2 = inputStream;
                            httpURLConnection2 = httpURLConnection;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th2;
                        }
                    } catch (AssertionError e6) {
                        assertionError = e6;
                        httpURLConnection2 = httpURLConnection3;
                        assertionError2 = assertionError;
                        try {
                            d.i(z[4], new StringBuilder(z[22]).append(assertionError2.toString()).toString());
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException e42) {
                                    e42.printStackTrace();
                                }
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            return inputStream2;
                        } catch (Throwable th4) {
                            th2 = th4;
                            inputStream2 = inputStream3;
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th2;
                        }
                    } catch (Throwable th5) {
                        httpURLConnection2 = httpURLConnection3;
                        th2 = th5;
                        inputStream2 = inputStream3;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th2;
                    }
                }
                d.c(z[4], new StringBuilder(z[23]).append(responseCode).append(z[33]).append(str).toString());
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return inputStream2;
            } catch (Throwable e32) {
                httpURLConnection = httpURLConnection3;
                th2 = e32;
                inputStream = inputStream2;
                d.e(z[4], z[30], th2);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return inputStream2;
            } catch (AssertionError e62) {
                inputStream3 = inputStream2;
                assertionError = e62;
                httpURLConnection2 = httpURLConnection3;
                assertionError2 = assertionError;
                d.i(z[4], new StringBuilder(z[22]).append(assertionError2.toString()).toString());
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return inputStream2;
            } catch (Throwable e322) {
                th = e322;
                httpURLConnection2 = httpURLConnection3;
                th2 = th;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th2;
            }
        } catch (Exception e7) {
            th2 = e7;
            inputStream = inputStream2;
            httpURLConnection = inputStream2;
            d.e(z[4], z[30], th2);
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return inputStream2;
        } catch (AssertionError e8) {
            assertionError2 = e8;
            inputStream3 = inputStream2;
            httpURLConnection2 = inputStream2;
            d.i(z[4], new StringBuilder(z[22]).append(assertionError2.toString()).toString());
            if (inputStream3 != null) {
                inputStream3.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return inputStream2;
        } catch (Throwable th6) {
            th2 = th6;
            httpURLConnection2 = inputStream2;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th2;
        }
    }

    private String d() {
        JSONObject jSONObject = new JSONObject();
        Object i = cn.jiguang.b.a.d.i(this.a);
        if (i == null) {
            i = "";
        }
        try {
            jSONObject.put(z[41], i);
            String str = z[38];
            b.a();
            jSONObject.put(str, b.d(SdkType.JPUSH.name(), ""));
            jSONObject.put(z[40], VERSION.RELEASE + "," + Integer.toString(VERSION.SDK_INT));
            jSONObject.put(z[39], 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final void a(Context context) {
        this.a = context;
    }

    public final void a(String str, String str2, int i) {
        if (this.c != null) {
            g gVar = new g();
            gVar.b = str;
            gVar.c = str2;
            gVar.d = i;
            Message message = new Message();
            message.obj = gVar;
            message.what = 1;
            this.c.sendMessage(message);
        }
    }

    public final void a(ArrayList<ComponentName> arrayList, ArrayList<ComponentName> arrayList2) {
        int i = 0;
        try {
            if (this.a == null) {
                d.c(z[4], z[64]);
                return;
            }
            int i2;
            ComponentName componentName;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(z[65], cn.jiguang.b.a.a.q());
            jSONObject.put(z[68], z[66]);
            JSONArray jSONArray = new JSONArray();
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                for (i2 = 0; i2 < size; i2++) {
                    JSONObject jSONObject2 = new JSONObject();
                    componentName = (ComponentName) arrayList.get(i2);
                    jSONObject2.put(z[62], this.a.getApplicationContext().getPackageName());
                    jSONObject2.put(z[63], componentName.getPackageName());
                    jSONObject2.put(z[61], componentName.getClassName());
                    jSONObject2.put(z[59], 1);
                    jSONObject2.put(z[60], true);
                    jSONArray.put(jSONObject2);
                }
            }
            if (arrayList2.size() > 0) {
                i2 = arrayList2.size();
                while (i < i2) {
                    JSONObject jSONObject3 = new JSONObject();
                    componentName = (ComponentName) arrayList2.get(i);
                    jSONObject3.put(z[62], this.a.getApplicationContext().getPackageName());
                    jSONObject3.put(z[63], componentName.getPackageName());
                    jSONObject3.put(z[61], componentName.getClassName());
                    jSONObject3.put(z[59], 1);
                    jSONObject3.put(z[60], false);
                    jSONArray.put(jSONObject3);
                    i++;
                }
            }
            d.c(z[4], new StringBuilder(z[67]).append(jSONArray).toString());
            jSONObject.put(z[58], jSONArray);
            o.a(this.a, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        if (this.c != null) {
            this.c.sendEmptyMessage(2);
        }
    }
}
