package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JRequest;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jpush.a.b;
import cn.jpush.android.a;
import cn.jpush.android.api.JPushInterface;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

/* compiled from: TbsSdkJava */
public final class e {
    private static e b = null;
    private static final String[] z;
    private Context a = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 16;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "Oi}G\fAk@G\u0018tnDC\u0004Us\tC\u0019Rh[\u001c";
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
            case 0: goto L_0x00d1;
            case 1: goto L_0x00d5;
            case 2: goto L_0x00d8;
            case 3: goto L_0x00dc;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "TfNG\u0007IfZy\u000eRuFT\bOcL";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "jW\\U\u0003rbXS\u000eSsaC\u0007Pb[";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "MbZU\nGbvR\u0012Pb";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "Ci\u0007L\u001bUtA\b\nNc[I\u0002D)@H\u001fEi]\b?a@vg'iFzy?iJli>t";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "TfNG\u0007IfZy\u0018Ev@B";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "Ci\u0007L\u001bUtA\b\nNc[I\u0002D)@H\u001fEi]\b9eDlo=eXdc8sFnc";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "ad]O\u0004N'\u0004\u0006\u0004NSHA\nLnHU?IjLI\u001eT";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\f']N\u0019EfMo\u000f\u001a";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\f'CS\u0002D=";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "rbXS\u000eSs\tV\nRfDUK\r'JK\u000f\u001a";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "uiYT\u0004CbZU\u000eD'[C\u001aUbZRKYb]\b";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\f'ZO\u000f\u001a";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "SbGB9Ev\\C\u0018T'OG\u0002LbM\n\u0019Ev\\C\u0018T'@UKNrEJ";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\fu@BQ";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "ad]O\u0004N'\u0004\u0006\u0018EiMl;UtAt\u000eQrLU\u001f\f']O\u0006Eh\\RQ";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        b = r0;
        return;
    L_0x00d1:
        r9 = 32;
        goto L_0x0020;
    L_0x00d5:
        r9 = 7;
        goto L_0x0020;
    L_0x00d8:
        r9 = 41;
        goto L_0x0020;
    L_0x00dc:
        r9 = 38;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.e.<clinit>():void");
    }

    private e(Context context) {
        this.a = context;
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                b = new e(context);
            }
            eVar = b;
        }
        return eVar;
    }

    public final void a(long j) {
        try {
            cn.jpush.android.d.e.c(z[2], z[7]);
            int a = k.a().a(j);
            Intent intent = new Intent();
            intent.addCategory(a.c);
            if (a == 0) {
                intent.setAction(z[4]);
            } else {
                intent.setAction(z[6]);
                intent.setPackage(this.a.getPackageName());
                if (a == 1) {
                    intent.putExtra(z[3], 1);
                } else {
                    intent.putExtra(z[3], 2);
                }
            }
            intent.putExtra(z[1], JPushInterface.a.c);
            intent.putExtra(z[5], j);
            this.a.sendBroadcast(intent);
        } catch (Throwable th) {
            cn.jpush.android.d.e.h(z[2], new StringBuilder(z[0]).append(th.getMessage()).toString());
        }
    }

    public final void a(JRequest jRequest, int i) {
        if (jRequest == null) {
            cn.jpush.android.d.e.g(z[2], z[13]);
            return;
        }
        cn.jpush.android.d.e.d(z[2], new StringBuilder(z[15]).append(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT).append(z[8]).append(Thread.currentThread().getId()).toString());
        cn.jpush.android.d.e.a(z[2], jRequest.toString());
        Long rid = jRequest.getRid();
        int command = jRequest.getCommand();
        long uid = JCoreInterface.getUid();
        int sid = JCoreInterface.getSid();
        cn.jpush.android.d.e.c(z[2], new StringBuilder(z[10]).append(command).append(z[12]).append(sid).append(z[9]).append(uid).append(z[14]).append(rid).toString());
        switch (command) {
            case 10:
            case 28:
            case 29:
                long longValue = rid.longValue();
                String appKey = JCoreInterface.getAppKey();
                short version = (short) jRequest.getVersion();
                short command2 = (short) jRequest.getCommand();
                String a = ((b) jRequest).a();
                OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
                outputDataUtil.writeU16(0);
                outputDataUtil.writeU8(version);
                outputDataUtil.writeU8(command2);
                outputDataUtil.writeU64(longValue);
                outputDataUtil.writeU32((long) sid);
                outputDataUtil.writeU64(uid);
                if (command2 == (short) 10) {
                    outputDataUtil.writeByteArrayincludeLength(appKey.getBytes());
                }
                outputDataUtil.writeByteArrayincludeLength(a.getBytes());
                outputDataUtil.writeU16At(outputDataUtil.current(), 0);
                JCoreInterface.sendRequestData(this.a, a.a, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT, outputDataUtil.toByteArray());
                return;
            default:
                cn.jpush.android.d.e.g(z[2], z[11]);
                return;
        }
    }
}
