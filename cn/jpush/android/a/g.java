package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jpush.a.a;
import cn.jpush.android.d.e;
import cn.jpush.android.d.f;
import cn.jpush.android.d.j;
import cn.jpush.android.data.b;
import cn.jpush.android.data.c;
import cn.jpush.android.service.ServiceInterface;
import java.io.LineNumberReader;
import java.io.StringReader;

/* compiled from: TbsSdkJava */
public final class g {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 23;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "y\u0015_Z&G\u001b_D\"eT\u0000\tcd\u0007J`'3";
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
            case 0: goto L_0x011b;
            case 1: goto L_0x011f;
            case 2: goto L_0x0123;
            case 3: goto L_0x0127;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 67;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "y\u0006BJ&z\u0007oH0`\u0017hG7`\u0000T\t7p\u0004H\u0013";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "h\u0017Y@,gN_L l\u001d[L'Y\u0001^A\u000el\u0007^H$lT@Z$@\u0010\r\u0014c";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "]\u001d@Lc}\u001b\rY1f\u0017HZ0)\u0006HJ&`\u0002HMcd\u0007J\u0007";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "d\u0007Jj,g\u0000HG73T'";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "L\u0019]]:)\u0019^Nm)3D_&)\u0001]\t3h\u0006^L1'";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "%T^L-m\u0011_`'3";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "G\u001b\rD0n7BG7l\u001aY";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "Z\u0011__*j\u0011\r@0)\u0007YF3l\u0010\u0001\t$`\u0002H\t6yTLE/)\u0000ELcd\u0011^Z\"n\u0011";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "G;\rH3y=I";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = ">\u0012HOuhCI\u001eujC\u0015\u001b!8\u0012\u001dL'h@\u0019\u001f!;\u0017\u001bJw9\u0015";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "D\u0011^Z\"n\u0011\ro*l\u0018IZc$TLY3@\u0010\u0017";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "%T@Z$@\u0010\r\u0014c";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "Y\u0015_Z&)\u0019^N\u0000f\u001aYL-}TKH*e\u0011I";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "y\u0006BJ&z\u0007oH0`\u0017hG7`\u0000T\t6z\u0011_\u0004'l\u0012DG&mT@L0z\u0015JLm";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "Y\u0001^A\u000el\u0007^H$l$_F l\u0007^F1";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "y\u0001^Ac`\u0007\rJ/f\u0007HMｏ@\u001aYL1j\u0011]]c}\u001cH\t.l\u0007^H$l";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "d\u0007J}:y\u0011\r\u0014c";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "%T@Z$J\u001bC]&g\u0000\u0017";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\\\u001aFG,~\u001a\rL1{\u001b_";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "G;\rZ&g\u0010H[\nm";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "L\u0019]]:)\u0007HG'l\u0006DMcf\u0006\rH3y\u001dI\u0007cN\u001d[Lc|\u0004\rY\"{\u0007H[m";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "y\u0006BJ&z\u0007oH0`\u0017hG7`\u0000T\t-f\u0000DO*j\u0015Y@,g";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x011b:
        r9 = 9;
        goto L_0x0020;
    L_0x011f:
        r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        goto L_0x0020;
    L_0x0123:
        r9 = 45;
        goto L_0x0020;
    L_0x0127:
        r9 = 41;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.g.<clinit>():void");
    }

    public static long a(Context context, long j, JResponse jResponse) {
        a aVar = (a) jResponse;
        int a = aVar.a();
        long b = aVar.b();
        long longValue = aVar.getRid().longValue();
        long uid = JCoreInterface.getUid();
        byte b2 = (byte) a;
        int sid = JCoreInterface.getSid();
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(1);
        outputDataUtil.writeU8(4);
        outputDataUtil.writeU64(longValue);
        outputDataUtil.writeU32((long) sid);
        outputDataUtil.writeU64(uid);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(b2);
        outputDataUtil.writeU64(b);
        outputDataUtil.writeU16At(outputDataUtil.current(), 0);
        JCoreInterface.sendData(cn.jpush.android.a.e, cn.jpush.android.a.a, 4, outputDataUtil.toByteArray());
        b = aVar.b();
        a = aVar.a();
        String c = aVar.c();
        e.c(z[15], new StringBuilder(z[17]).append(a).append(z[12]).append(b).toString());
        e.a(z[15], new StringBuilder(z[4]).append(c).toString());
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(c));
        try {
            Object readLine = lineNumberReader.readLine();
            if (readLine == null) {
                e.i(z[15], z[9]);
                return -1;
            }
            String readLine2 = lineNumberReader.readLine();
            if (readLine2 == null) {
                e.i(z[15], z[20]);
                return -1;
            }
            int length = (readLine.length() + readLine2.length()) + 2;
            if (c.length() > length + 1) {
                c = c.substring(length);
            } else {
                e.c(z[15], z[7]);
                c = "";
            }
            e.a(z[15], new StringBuilder(z[11]).append(readLine).append(z[6]).append(readLine2).append(z[18]).append(c).toString());
            switch (a) {
                case 0:
                case 2:
                    try {
                        e.c(z[15], new StringBuilder(z[0]).append(b).toString());
                        j jVar = new j(z[15], z[3]);
                        if (TextUtils.isEmpty(readLine) || TextUtils.isEmpty(readLine2)) {
                            e.g(z[15], z[21]);
                        } else if (TextUtils.isEmpty(c)) {
                            e.i(z[15], z[5]);
                        } else {
                            e.c(z[15], new StringBuilder(z[2]).append(b).toString());
                            b a2 = f.a(context, c, readLine, readLine2, b);
                            if (a2 != null) {
                                if (!f.a(context, new c(a2))) {
                                    int i = 0;
                                    if (readLine2.equalsIgnoreCase(z[10])) {
                                        f.a(context, (cn.jpush.android.data.a) a2);
                                    } else if (a2.e) {
                                        i = 1;
                                        if (a2.b == 4) {
                                            i = 3;
                                        }
                                    } else {
                                        i = 2;
                                    }
                                    new StringBuilder().append(b);
                                    e.c(z[15], new StringBuilder(z[1]).append(i).toString());
                                    if ((i & 1) != 0) {
                                        e.c(z[15], z[22]);
                                        if (ServiceInterface.d(context)) {
                                            e.e(z[15], z[8]);
                                        } else if (cn.jpush.android.d.a.c(context)) {
                                            a2.h = true;
                                            f.a(context, (cn.jpush.android.data.a) a2);
                                        } else {
                                            e.e(z[15], z[16]);
                                        }
                                    }
                                    if ((i & 2) != 0) {
                                        e.c(z[15], z[14]);
                                        if (!(TextUtils.isEmpty(a2.i) && TextUtils.isEmpty(a2.m))) {
                                            cn.jpush.android.d.a.a(context, a2);
                                        }
                                    }
                                }
                            }
                        }
                        jVar.a();
                        break;
                    } catch (Throwable e) {
                        e.d(z[15], z[19], e);
                        break;
                    }
                    break;
                case 20:
                    return j.a(context, c, 0, -1);
                default:
                    JCoreInterface.processCtrlReport(a);
                    break;
            }
            return jResponse.getRid().longValue();
        } catch (Throwable e2) {
            e.d(z[15], z[13], e2);
            return -1;
        }
    }
}
