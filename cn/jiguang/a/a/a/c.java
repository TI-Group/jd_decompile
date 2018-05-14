package cn.jiguang.a.a.a;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.c.d;
import cn.jiguang.e.a;
import cn.jiguang.e.j;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang.ClassUtils;

public final class c {
    private static AtomicInteger a = new AtomicInteger(2);
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 18;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "^[Ww9_W((";
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
            case 0: goto L_0x00ec;
            case 1: goto L_0x00f0;
            case 2: goto L_0x00f4;
            case 3: goto L_0x00f8;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 65;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "{FxG5SX";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "[Zl`.SP&b$HYaa2S[f<\u0000ywMA\u0012ecAT\beg\\S\u0015";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "M]n{";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "N\\aaaTQ|e.H_(z I\u0014zw1UF|w%\u0016\u0014f}5\u001aFmb$[@({/\u001a";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "Y[ff$B@({2\u001aZ}~-\u0016\u0014o{7_\u0014}baHQx}3N\u0014Es\"v]{fo";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "[Fx{/\\[W`$J[zf\u001e_Zip-_";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "_Zip-_\u0014aaa\\Uda$\u0016\u0014o{7_\u0014}baHQx}3N\u0014Es\"v]{fo";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "m}N[";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "HQx}3N\u0014N`$KAm|\"C\u000e(";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u001aGmq.TP{";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "XG{{%\u0000\u0014";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "IGav{\u001a";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "m]n{\f[Ziu$H\u0014aaaTAd~m\u001aSad$\u001aAx23_Dg`5\u001ayiq\rSG|<";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "NU{yaSG(`4TZa|&\u0016\u0014x~$[Gm26[]|2'UF(t(T]{zo";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "{wKW\u0012ik_[\u0007sk[F\u0000nq(|.N\u0014ow5";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "M]|z.O@(g(^\u0018(u(LQ(g1\u001aFmb.H@(_ Yxaa5\u0014";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "YAz`$T@(q.TZmq5S[f25CDm2(I\u0014f}5\u001aCat(\u0016\u0014o{7_\u0014}baHQx}3N\u0014Es\"v]{fo";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        z = r4;
        r0 = new java.util.concurrent.atomic.AtomicInteger;
        r1 = 2;
        r0.<init>(r1);
        a = r0;
        return;
    L_0x00ec:
        r9 = 58;
        goto L_0x0020;
    L_0x00f0:
        r9 = 52;
        goto L_0x0020;
    L_0x00f4:
        r9 = 8;
        goto L_0x0020;
    L_0x00f8:
        r9 = 18;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.a.c.<clinit>():void");
    }

    static /* synthetic */ String a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i & 255);
        stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        stringBuffer.append((i >> 8) & 255);
        stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        stringBuffer.append((i >> 16) & 255);
        stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        stringBuffer.append((i >> 24) & 255);
        return stringBuffer.toString();
    }

    static /* synthetic */ String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bArr[0] & 255);
        stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        stringBuffer.append(bArr[1] & 255);
        stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        stringBuffer.append(bArr[2] & 255);
        stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        stringBuffer.append(bArr[3] & 255);
        return stringBuffer.toString();
    }

    public static void a(Context context) {
        if (a.get() != 2) {
            d.c(z[1], z[14]);
            return;
        }
        c(1);
        if (context == null) {
            d.c(z[1], z[5]);
            c(2);
        } else if (!a.c(context).toUpperCase().startsWith(z[8])) {
            d.c(z[1], z[17]);
            c(2);
        } else if (!((Boolean) cn.jiguang.b.a.d.b(context, z[6], Boolean.valueOf(false))).booleanValue()) {
            d.c(z[1], z[7]);
            c(2);
        } else if (cn.jiguang.b.a.d.f(context)) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(z[3]);
            if (wifiManager == null) {
                d.c(z[1], z[13]);
                c(2);
            } else if (a.b(context, z[2])) {
                String str;
                String str2;
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                CharSequence charSequence = "";
                CharSequence charSequence2 = "";
                if (connectionInfo != null) {
                    charSequence2 = j.c(connectionInfo.getSSID());
                    charSequence = connectionInfo.getBSSID();
                    d.e(z[1], new StringBuilder(z[12]).append(charSequence2).toString());
                    d.e(z[1], new StringBuilder(z[11]).append(charSequence).toString());
                }
                if (TextUtils.isEmpty(charSequence)) {
                    str = "";
                } else {
                    CharSequence charSequence3 = charSequence;
                }
                if (TextUtils.isEmpty(charSequence2)) {
                    str2 = "";
                } else {
                    CharSequence charSequence4 = charSequence2;
                }
                String str3 = TextUtils.isEmpty(str) ? str2 : str;
                boolean b = a.a().b(context, str3);
                a.a();
                int a = (int) (a.a(context) / 1000);
                if (b) {
                    d.e(z[1], new StringBuilder(z[9]).append(a).append(z[10]).toString());
                    new h(wifiManager, str3, str, str2, context).start();
                    return;
                }
                d.e(z[1], new StringBuilder(z[4]).append(a).append(z[10]).toString());
                c(2);
            } else {
                d.g(z[1], z[15]);
                c(2);
            }
        } else {
            d.c(z[1], z[16]);
            c(2);
        }
    }

    private static Process b(String str) {
        Process process = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                process = Runtime.getRuntime().exec(str);
                try {
                    process.waitFor();
                } catch (InterruptedException e) {
                }
            } catch (IOException e2) {
                d.i(z[1], new StringBuilder(z[0]).append(e2.toString()).toString());
            }
        }
        return process;
    }

    private static void c(int i) {
        a.getAndSet(i);
    }
}
