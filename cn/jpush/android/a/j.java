package cn.jpush.android.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.a.b;
import cn.jpush.android.api.JPushInterface.a;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.d.e;
import cn.jpush.android.d.g;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.service.d;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public final class j {
    private static ConcurrentLinkedQueue<Long> a = new ConcurrentLinkedQueue();
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 62;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "vv\u001cAqkv\b\u0000xzt\u001ePikx\u0015\u001a";
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
            case 0: goto L_0x02cf;
            case 1: goto L_0x02d2;
            case 2: goto L_0x02d6;
            case 3: goto L_0x02da;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 29;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "ct\u000fIrl-\bEiC{\u0012AnCy\u001ft|ed[\r=c{\u0012An8";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "c{\u0012An";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "r{\u001aT{me\u0016";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = ".7\u000fAzq-";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "Vv\u001caqkv\bhxng\u001eR";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "vv\u001cS";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "vv\u001cAqkv\b\u0000ogf\u000eEnv7\u001aCikx\u0015\u0000jcd[Eprc\u0002";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "vv\u001cAqkv\b\u0000nveA";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "LB7l=c{\u0012An\"v\u0015D=vv\u001cS3\"P\u0012Vx\"b\u000b\u0000|ac\u0012Os,";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "qc\u001aGn\"`\u001aS=gz\u000bTd,7<Ikg7\u000eP=ct\u000fIrl9";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "vv\u001c\u0000ogf\u000eEnv7\u001aCikx\u0015\u0000jcd[Eprc\u0002";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "vv\u001c\u0000xzt\u001ePikx\u0015\u001a";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "wy\bUmrx\tT=vv\u001c\u0000|ac\u0012Os\"c\u0002Px";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "vv\u001c\u0000nveA";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "ab\tR";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "vv\u001cS=uv\b\u0000xog\u000fY3\"P\u0012Vx\"b\u000b\u0000|ac\u0012Os,";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "vv\u001cS=nr\u0015Gij-";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\"u\u0002Txq9";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "V\u001e\u0000qgy\u001cTu\"x\u001d\u0000icp\b\u0000njx\u000eLy\"u\u001e\u0000qgd\b\u0000ijv\u0015\u0000";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "LB7l=ax\u0015Txzc";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "Ky\rAqks[T|edW\u0000jk{\u0017\u0000smc[Sxv7\u000fAzq7\u000fHtq7\u000fIpg9";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "vv\u001c\u0000|n~\u001aS=p~\u001f\u0000 \"";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "c{\u0012An\"d\u000fR'";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "wy\bUmrx\tT=c{\u0012An\"v\u0018Ttmy[Tdrr";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "c{\u0012An\"r\u0003Cxrc\u0012Os8";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "c{\u0012An\"e\u001eQhgd\u000f\u0000|ac\u0012Os\"`\u001aS=gz\u000bTd";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "c{\u0012An\"`\u001aS=gz\u000bTd,7<Ikg7\u000eP=ct\u000fIrl9";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "vv\u001cAqkv\bngf\u0012D";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "vv\u001cAqkv\bxpe\u0014R~ms\u001e";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "ayUJmwd\u0013\u000e|ls\tOtf9\u0012Nigy\u000f\u000eICP$aQKV(^C[7b\\A\\";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "or\bS|er$Tdrr";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "Lx\u000fI{{C\u001aG\\n~\u001aSXpe\u0014R'";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "ayUJmwd\u0013\u000e|ls\tOtf9\u0012Nigy\u000f\u000eOGT>iKGH6eNQV<e";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        r2 = 34;
        r1 = "vv\u001cAqkv\b\u001a";
        r0 = 33;
        r3 = r4;
        goto L_0x0009;
    L_0x019a:
        r3[r2] = r1;
        r2 = 35;
        r1 = "vv\u001cAqkv\brxsb\u001eSi\"`\u001aS=lb\u0017L";
        r0 = 34;
        r3 = r4;
        goto L_0x0009;
    L_0x01a5:
        r3[r2] = r1;
        r2 = 36;
        r1 = "Ky\rAqks[Aqkv\b\u001a=";
        r0 = 35;
        r3 = r4;
        goto L_0x0009;
    L_0x01b0:
        r3[r2] = r1;
        r2 = 37;
        r1 = ".7\fIqn7\u0015Oi\"d\u001eT=c{\u0012An\"c\u0013In\"c\u0012Mx,";
        r0 = 36;
        r3 = r4;
        goto L_0x0009;
    L_0x01bb:
        r3[r2] = r1;
        r2 = 38;
        r1 = "vv\u001cAqkv\b\u0000pqp8Osvr\u0015T'";
        r0 = 37;
        r3 = r4;
        goto L_0x0009;
    L_0x01c6:
        r3[r2] = r1;
        r2 = 39;
        r1 = "re\u0014Tr]c\u0002Px";
        r0 = 38;
        r3 = r4;
        goto L_0x0009;
    L_0x01d1:
        r3[r2] = r1;
        r2 = 40;
        r1 = "ct\u000fIrl7V\u0000rlE\u001eCkVv\u001caqkv\bc|n{9A~i";
        r0 = 39;
        r3 = r4;
        goto L_0x0009;
    L_0x01dc:
        r3[r2] = r1;
        r2 = 41;
        r1 = "ax\u001fE";
        r0 = 40;
        r3 = r4;
        goto L_0x0009;
    L_0x01e7:
        r3[r2] = r1;
        r2 = 42;
        r1 = "qr\nUxlt\u001e";
        r0 = 41;
        r3 = r4;
        goto L_0x0009;
    L_0x01f2:
        r3[r2] = r1;
        r2 = 43;
        r1 = "nx\u001aD=vv\u001c\u000f|n~\u001aS=ct\u000fIrl7\u000fYmg7\u001dAtnr\u001f\u00000\"r\tRrp-";
        r0 = 42;
        r3 = r4;
        goto L_0x0009;
    L_0x01fd:
        r3[r2] = r1;
        r2 = 44;
        r1 = "m{\u001f\u0000icpTAqkv\b\u0000mpx\u000fO";
        r0 = 43;
        r3 = r4;
        goto L_0x0009;
    L_0x0208:
        r3[r2] = r1;
        r2 = 45;
        r1 = "vv\u001c";
        r0 = 44;
        r3 = r4;
        goto L_0x0009;
    L_0x0213:
        r3[r2] = r1;
        r2 = 46;
        r1 = "nx\u001aD=vv\u001c\u000f|n~\u001aS=re\u0014Tr\"c\u0002Px\"q\u001aIqgs[\r=ge\tOo8";
        r0 = 45;
        r3 = r4;
        goto L_0x0009;
    L_0x021e:
        r3[r2] = r1;
        r2 = 47;
        r1 = "\"~\b\u0000rrr\tAime\u0012Nz.7\u000bLxcd\u001e\u0000jc~\u000f\u0000qcd\u000f\u0000rrr\tAime[Crog\u0017Eig";
        r0 = 46;
        r3 = r4;
        goto L_0x0009;
    L_0x0229:
        r3[r2] = r1;
        r2 = 48;
        r1 = "qr\u000f\u0000icp\b\u000f|n~\u001aS=vx\u0014\u0000nmx\u0015\frtr\t\u0000,27\u000fIpgd[Is\"&KS";
        r0 = 47;
        r3 = r4;
        goto L_0x0009;
    L_0x0234:
        r3[r2] = r1;
        r2 = 49;
        r1 = "qr\ntf";
        r0 = 48;
        r3 = r4;
        goto L_0x0009;
    L_0x023f:
        r3[r2] = r1;
        r2 = 50;
        r1 = "qr\u000f\u0000icp\b\u000f|n~\u001aS=dv\u0012Lxf;\u000fIpg7\bH|dc[Eopx\tＬmnr\u001aSx\"c\tY=cp\u001aIs";
        r0 = 49;
        r3 = r4;
        goto L_0x0009;
    L_0x024a:
        r3[r2] = r1;
        r2 = 51;
        r1 = "re\u0014Trct\u000fIrlH\u000fYmg";
        r0 = 50;
        r3 = r4;
        goto L_0x0009;
    L_0x0255:
        r3[r2] = r1;
        r2 = 52;
        r1 = "Ky\rAqks[T|e7A\u0000";
        r0 = 51;
        r3 = r4;
        goto L_0x0009;
    L_0x0260:
        r3[r2] = r1;
        r2 = 53;
        r1 = "V\u001e\u0000qgy\u001cHi\"x\u001d\u0000icp\b\u0000pcn\u0019E=ox\tE=v\u001aN=3'K\u00103";
        r0 = 52;
        r3 = r4;
        goto L_0x0009;
    L_0x026b:
        r3[r2] = r1;
        r2 = 54;
        r1 = "a{\u001eAs";
        r0 = 53;
        r3 = r4;
        goto L_0x0009;
    L_0x0276:
        r3[r2] = r1;
        r2 = 55;
        r1 = "tv\u0017Iy";
        r0 = 54;
        r3 = r4;
        goto L_0x0009;
    L_0x0281:
        r3[r2] = r1;
        r2 = 56;
        r1 = "er\u000f";
        r0 = 55;
        r3 = r4;
        goto L_0x0009;
    L_0x028c:
        r3[r2] = r1;
        r2 = 57;
        r1 = "fr\u0017";
        r0 = 56;
        r3 = r4;
        goto L_0x0009;
    L_0x0297:
        r3[r2] = r1;
        r2 = 58;
        r1 = "mg";
        r0 = 57;
        r3 = r4;
        goto L_0x0009;
    L_0x02a2:
        r3[r2] = r1;
        r2 = 59;
        r1 = "qr\u000f";
        r0 = 58;
        r3 = r4;
        goto L_0x0009;
    L_0x02ad:
        r3[r2] = r1;
        r2 = 60;
        r1 = "cs\u001f";
        r0 = 59;
        r3 = r4;
        goto L_0x0009;
    L_0x02b8:
        r3[r2] = r1;
        r2 = 61;
        r1 = "Ky\rAqks[T|e-[";
        r0 = 60;
        r3 = r4;
        goto L_0x0009;
    L_0x02c3:
        r3[r2] = r1;
        z = r4;
        r0 = new java.util.concurrent.ConcurrentLinkedQueue;
        r0.<init>();
        a = r0;
        return;
    L_0x02cf:
        r9 = 2;
        goto L_0x0020;
    L_0x02d2:
        r9 = 23;
        goto L_0x0020;
    L_0x02d6:
        r9 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        goto L_0x0020;
    L_0x02da:
        r9 = 32;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.j.<clinit>():void");
    }

    private static int a(long j) {
        if (a.size() < 10) {
            a.offer(Long.valueOf(j));
            return 0;
        }
        long longValue = j - ((Long) a.element()).longValue();
        if (longValue < 0) {
            a.clear();
            return 2;
        } else if (longValue <= 10000) {
            return 1;
        } else {
            while (a.size() >= 10) {
                a.poll();
            }
            a.offer(Long.valueOf(j));
            return 0;
        }
    }

    protected static long a(Context context, String str, int i, long j) {
        e.c(z[5], z[40]);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(z[41], a.j);
            long optLong = i == 0 ? jSONObject.optLong(z[42]) : j;
            Intent intent = new Intent();
            intent.addCategory(cn.jpush.android.a.c);
            intent.putExtra(z[39], i);
            if (i == 0) {
                intent.setAction(z[30]);
            } else {
                intent.setAction(z[33]);
                intent.setPackage(context.getPackageName());
                if (i == 1) {
                    intent.putExtra(z[31], 1);
                } else {
                    intent.putExtra(z[31], 2);
                }
            }
            intent.putExtra(z[29], optInt);
            intent.putExtra(z[28], optLong);
            Intent a = k.a().a(context, optLong, optInt, jSONObject, intent);
            if (a == null) {
                return optLong;
            }
            context.sendBroadcast(a);
            return optLong;
        } catch (Throwable th) {
            e.g(z[5], new StringBuilder(z[38]).append(str).toString());
            return -1;
        }
    }

    protected static b a(Context context, String str, long j, int i) {
        Object obj = 1;
        Object obj2 = (i == 2 || i == 3 || i == 5) ? 1 : null;
        if (obj2 != null) {
            try {
                JSONObject a = a(i);
                if (i != 2) {
                    obj = null;
                }
                if (obj != null) {
                    if (TextUtils.isEmpty(str)) {
                        e.j(z[5], z[27]);
                        a(context, 2, a.b, j);
                        return null;
                    } else if (!a(context, 2, str, j)) {
                        return null;
                    } else {
                        a.put(z[2], str);
                    }
                }
                Object jSONObject = a.toString();
                e.c(z[5], new StringBuilder(z[23]).append(jSONObject).toString());
                if (TextUtils.isEmpty(jSONObject)) {
                    e.c(z[5], z[26]);
                } else {
                    return new b(1, 29, j, JCoreInterface.getAppKey(), jSONObject);
                }
            } catch (Throwable th) {
                e.g(z[5], new StringBuilder(z[25]).append(th).toString());
                a(context, 2, a.j, j);
            }
        } else {
            e.i(z[5], z[24]);
            a(context, 2, a.j, j);
        }
        return null;
    }

    protected static b a(Context context, List<String> list, long j, int i, int i2) {
        if (i != 0) {
            try {
                String str;
                JSONObject a = a(i);
                Object obj = (i == 1 || i == 2 || i == 3 || i == 6) ? 1 : null;
                if (obj != null) {
                    if (list == null || list.isEmpty()) {
                        e.j(z[5], z[16]);
                        a(context, 1, a.b, j);
                        return null;
                    }
                    Set hashSet = new HashSet(list);
                    if (!a(context, 1, hashSet, j)) {
                        return null;
                    }
                    CharSequence b = b(hashSet);
                    if (!b(context, b, j, 1)) {
                        return null;
                    }
                    if (i != 6) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str2 : list) {
                            jSONArray.put(str2);
                        }
                        a.put(z[6], jSONArray);
                    } else if (TextUtils.isEmpty(b)) {
                        e.j(z[5], z[10]);
                        a(context, 1, a.b, j);
                        return null;
                    } else {
                        a.put(z[6], b);
                    }
                }
                if (i == 5) {
                    str2 = z[15];
                    if (i2 == -1) {
                        i2 = 1;
                    }
                    a.put(str2, i2);
                }
                Object jSONObject = a.toString();
                e.c(z[5], new StringBuilder(z[14]).append(jSONObject).toString());
                if (TextUtils.isEmpty(jSONObject)) {
                    e.c(z[5], z[11]);
                } else {
                    return new b(1, 28, j, JCoreInterface.getAppKey(), jSONObject);
                }
            } catch (Throwable th) {
                e.g(z[5], new StringBuilder(z[12]).append(th).toString());
                a(context, 1, a.j, j);
            }
        } else {
            e.i(z[5], z[13]);
            a(context, 1, a.j, j);
        }
        return null;
    }

    private static b a(Context context, List<String> list, String str, long j) {
        Set hashSet = list != null ? new HashSet(list) : null;
        if (str != null && !a(context, 0, str, j)) {
            return null;
        }
        if (hashSet != null && !a(context, 0, hashSet, j)) {
            return null;
        }
        String b = b(hashSet);
        if (!b(context, b, j, 0)) {
            return null;
        }
        if (b == null && str == null) {
            e.j(z[5], z[9]);
            a(context, 0, a.b, j);
            return null;
        }
        e.d(z[5], new StringBuilder(z[1]).append(str).append(z[4]).append(b).toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(z[3], "a");
            if (str != null) {
                jSONObject.put(z[2], str);
            }
            if (hashSet != null) {
                jSONObject.put(z[6], b);
            }
            Object jSONObject2 = jSONObject.toString();
            e.c(z[5], new StringBuilder(z[8]).append(jSONObject2).toString());
            if (TextUtils.isEmpty(jSONObject2)) {
                e.c(z[5], z[7]);
                return null;
            }
            return new b(4, 10, j, JCoreInterface.getAppKey(), jSONObject2);
        } catch (Throwable th) {
            e.g(z[5], new StringBuilder(z[0]).append(th).toString());
            a(context, 0, a.j, j);
        }
    }

    public static Set<String> a(Set<String> set) {
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return set;
        }
        Set<String> linkedHashSet = new LinkedHashSet();
        int i = 0;
        for (String str : set) {
            int i2;
            if (TextUtils.isEmpty(str) || !g.a(str)) {
                e.j(z[5], new StringBuilder(z[52]).append(str).toString());
                i2 = i;
            } else {
                linkedHashSet.add(str);
                i2 = i + 1;
                if (i2 >= 1000) {
                    e.h(z[5], z[53]);
                    return linkedHashSet;
                }
            }
            i = i2;
        }
        return linkedHashSet;
    }

    private static JSONObject a(int i) throws JSONException {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(z[3], "a");
        String str = z[58];
        switch (i) {
            case 1:
                obj = z[60];
                break;
            case 2:
                obj = z[59];
                break;
            case 3:
                obj = z[57];
                break;
            case 4:
                obj = z[54];
                break;
            case 5:
                obj = z[56];
                break;
            case 6:
                obj = z[55];
                break;
            default:
                obj = null;
                break;
        }
        jSONObject.put(str, obj);
        return jSONObject;
    }

    protected static void a(Context context, int i, int i2, long j) {
        try {
            Intent intent = new Intent();
            intent.addCategory(context.getPackageName());
            intent.setPackage(context.getPackageName());
            if (i == 0) {
                intent.setAction(z[30]);
            } else {
                intent.setAction(z[33]);
                if (i == 1) {
                    intent.putExtra(z[31], 1);
                } else {
                    intent.putExtra(z[31], 2);
                }
            }
            intent.putExtra(z[29], i2);
            intent.putExtra(z[28], j);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            e.h(z[5], new StringBuilder(z[32]).append(th.getMessage()).toString());
        }
    }

    public static void a(Context context, int i, String str, int i2, int i3) {
        if (context == null) {
            throw new IllegalArgumentException(z[20]);
        }
        a(context, str, null, new cn.jpush.android.api.a(i, str, System.currentTimeMillis(), 2, i3));
    }

    public static void a(Context context, int i, Set<String> set, int i2, int i3) {
        if (context == null) {
            throw new IllegalArgumentException(z[20]);
        }
        a(context, null, (Set) set, new cn.jpush.android.api.a(i, (Set) set, System.currentTimeMillis(), 1, i3));
    }

    public static void a(Context context, Bundle bundle) {
        int parseInt;
        int i = 0;
        String string = bundle.getString(z[2]);
        List stringArrayList = bundle.getStringArrayList(z[6]);
        long j = bundle.getLong(z[49], 0);
        try {
            parseInt = Integer.parseInt(bundle.getString(z[39]));
        } catch (Throwable th) {
            e.g(z[5], new StringBuilder(z[46]).append(th).toString());
            a(context, i, a.j, j);
            parseInt = i;
        }
        try {
            i = Integer.parseInt(bundle.getString(z[51]));
        } catch (Throwable th2) {
            e.g(z[5], new StringBuilder(z[43]).append(th2).toString());
            a(context, parseInt, a.j, j);
        }
        int a = a(System.currentTimeMillis());
        if (a != 0) {
            if (a == 1) {
                e.g(z[5], z[48]);
            } else {
                e.g(z[5], z[50]);
            }
            a(context, parseInt, a == 1 ? a.l : a.n, j);
            return;
        }
        k.a();
        if (k.a(context, parseInt, j)) {
            a(context, parseInt, a.u, j);
            return;
        }
        b bVar = null;
        if (parseInt == 0) {
            e.c(z[5], z[44]);
            bVar = a(context, stringArrayList, string, j);
        } else if (parseInt == 1) {
            bVar = a(context, stringArrayList, j, i, -1);
        } else if (parseInt == 2) {
            bVar = a(context, string, j, i);
        }
        if (bVar != null && (parseInt == 1 || parseInt == 2)) {
            if (k.a().a(parseInt)) {
                k.a().a(parseInt, i, j, (ArrayList) stringArrayList, string);
            } else {
                e.g(z[5], (parseInt == 1 ? z[45] : z[2]) + z[47]);
                a(context, parseInt, parseInt == 1 ? a.v : a.w, j);
                return;
            }
        }
        a(context, bVar);
    }

    protected static void a(Context context, b bVar) {
        e.d(z[5], new StringBuilder(z[34]).append(bVar).toString());
        if (bVar != null) {
            e.a(context).a(bVar, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        } else {
            e.g(z[5], z[35]);
        }
    }

    public static void a(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback, int i, int i2) {
        if (context == null) {
            throw new IllegalArgumentException(z[20]);
        }
        a(context, str, (Set) set, new cn.jpush.android.api.a(str, set, tagAliasCallback, System.currentTimeMillis(), 0, 0));
    }

    private static void a(Context context, String str, Set<String> set, cn.jpush.android.api.a aVar) {
        long nextRid = JCoreInterface.getNextRid();
        if (aVar != null) {
            d.a().a(context, Long.valueOf(nextRid), aVar);
        }
        e.e(z[5], new StringBuilder(z[22]).append(nextRid).toString());
        if (ServiceInterface.d(context)) {
            d.a().a(context, a.m, nextRid, aVar);
            return;
        }
        Context applicationContext = !(context instanceof Application) ? context.getApplicationContext() : context;
        if (cn.jpush.android.a.a(applicationContext)) {
            if (aVar.e == 0) {
                d.a().a(applicationContext);
            }
            ServiceInterface.a(applicationContext, str, (Set) set, nextRid, aVar);
            return;
        }
        d.a().a(applicationContext, a.j, nextRid, aVar);
    }

    private static boolean a(Context context, int i, String str, long j) {
        int b = g.b(str);
        if (b == 0) {
            return true;
        }
        e.d(z[5], new StringBuilder(z[36]).append(str).append(z[37]).toString());
        a(context, i, b, j);
        return false;
    }

    private static boolean a(Context context, int i, Set<String> set, long j) {
        int a = g.a((Set) set);
        if (a == 0) {
            return true;
        }
        e.d(z[5], z[21]);
        a(context, i, a, j);
        return false;
    }

    public static String b(Set<String> set) {
        String str = null;
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return "";
        }
        int i = 0;
        for (String str2 : set) {
            int i2;
            String str3;
            if (TextUtils.isEmpty(str2) || !g.a(str2)) {
                e.j(z[5], new StringBuilder(z[61]).append(str2).toString());
                i2 = i;
                str3 = str;
            } else {
                str = str == null ? str2 : str + "," + str2;
                i2 = i + 1;
                if (i2 >= 1000) {
                    return str;
                }
                str3 = str;
            }
            str = str3;
            i = i2;
        }
        return str;
    }

    private static boolean b(Context context, String str, long j, int i) {
        if (str != null) {
            Object replaceAll = str.replaceAll(",", "");
            boolean z = i != 0;
            int length = !TextUtils.isEmpty(replaceAll) ? replaceAll.getBytes().length + 0 : 0;
            e.a(z[5], new StringBuilder(z[17]).append(length).toString());
            z = z ? length <= 5000 : length <= 7000;
            if (!z) {
                a(context, i, a.i, j);
                e.h(z[5], new StringBuilder(z[19]).append(i != 0 ? 5000 : 7000).append(z[18]).toString());
                return false;
            }
        }
        return true;
    }
}
