package cn.jpush.android.c;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jpush.android.a;
import cn.jpush.android.a.d;
import cn.jpush.android.d.e;
import cn.jpush.android.data.b;
import cn.jpush.android.data.g;
import com.tencent.smtt.utils.TbsLog;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public final class h {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 23;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0018=F\r\u0000\u001a\u0007";
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
        r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
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
        r1 = "\u0018=Q\u000b\u001a\u0002\u0007\\\u0010";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "8-\u0012)'1+v";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0006\u0003@\u0017\u00115\r\\\u0010\u0011\u0018\u0016\u0012\u0001\u0006\u0004\r@^";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "&\u000eG\u0003\u001d\u00182^\u0005\u0000\u0010\r@\t\u00078\rF\r\u0012\u001f\u0001S\u0010\u001d\u0019\fz\u0001\u0018\u0006\u0007@";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0018=W\u001c\u0000\u0004\u0003A";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0004\u000bQ\f+\u0015\r\\\u0010\u0011\u0018\u0016";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001b=Q\u000b\u001a\u0002\u0007\\\u0010";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = ")\b_\u0017\u0013\u001f\u0006m";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0005\n]\u0013+\u0002\u001bB\u0001";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0019\f|\u000b\u0000\u001f\u0004[\u0007\u0015\u0002\u000b]\n;\u0006\u0007\\D\u0007\u0013\fV&\u0006\u0019\u0001S\u0010T\u0013\u0010@\u000b\u0006L";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u0005\u0006Y\u0010\r\u0006\u0007";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0015\f\u001c\u000e\u0004\u0003\u0011ZJ\u0015\u0018\u0006@\u000b\u001d\u0012L[\n\u0000\u0013\fFJ:96{\"=5#f-;8=}418'v";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "X\u0012W\u0016\u0019\u001f\u0011A\r\u001b\u0018Lx4!%*m)1%1s#1";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "%\u0007\\\u0000T\u0014\u0010]\u0005\u0010\u0015\u0003A\u0010T\u0002\r\u0012\u0005\u0004\u0006X\u0012";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u001b\u0007A\u0017\u0015\u0011\u0007\u0012\u0007\u001b\u0018\u0016W\n\u0000L";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u0013\fF\r\u0000\u000fX";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u001b\u0007A\u0017\u0015\u0011\u0007\u0012\r\u0010V\u0015AD\u0011\u001b\u0012F\u001d";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "7\u0001F\r\u001b\u0018B\u001fD\u001b\u0018,]\u0010\u001d\u0010\u000bQ\u0005\u0000\u001f\r\\)\u0011\u0005\u0011S\u0003\u00117\u0010@\r\u0002\u0013\u0006";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\u0013\fF\r\u0000\u000fBE\u0005\u0007V\fG\b\u0018";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0015\r\\\u0010\u0011\u000e\u0016\u0012\u0013\u0015\u0005B\\\u0011\u0018\u001a";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "7\u0001F\r\u001b\u0018B\u001fD\u001b\u0018,]\u0010\u001d\u0010\u000bQ\u0005\u0000\u001f\r\\)\u0011\u0005\u0011S\u0003\u00115\u000e[\u0007\u001f";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0015\r\\\u0010\u0011\u0018\u0016\u0012\u0013\u0015\u0005B\\\u0011\u0018\u001a";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x011b:
        r9 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        goto L_0x0020;
    L_0x011f:
        r9 = 98;
        goto L_0x0020;
    L_0x0123:
        r9 = 50;
        goto L_0x0020;
    L_0x0127:
        r9 = 100;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.h.<clinit>():void");
    }

    private static b a(Context context, String str, String str2) {
        b gVar = new g();
        try {
            JSONObject jSONObject = new JSONObject(str);
            gVar.c = jSONObject.optString(z[8]);
            int optInt = jSONObject.optInt(z[9], -1);
            jSONObject = jSONObject.optJSONObject(z[7]);
            if (jSONObject != null) {
                gVar.u = jSONObject.optString(z[1]);
                gVar.t = jSONObject.optString(z[0]);
                gVar.m = jSONObject.optString(z[5]);
                jSONObject = jSONObject.optJSONObject(z[6]);
                if (jSONObject != null) {
                    gVar.a(jSONObject);
                    gVar.b = 3;
                } else {
                    gVar.b = 4;
                    gVar.K = -1;
                }
            }
            if (optInt != -1) {
                gVar.b = optInt;
            }
            gVar.p = 0;
            gVar.q = true;
            return gVar;
        } catch (Throwable th) {
            e.i(z[4], new StringBuilder(z[3]).append(th).toString());
            String str3 = z[2];
            if (!TextUtils.isEmpty(gVar.c)) {
                str3 = gVar.c;
            }
            d.a(str3, str2, g.a().f(context), TbsLog.TBSLOG_CODE_SDK_SELF_MODE, context);
            return null;
        }
    }

    private static void a(Context context, b bVar, String str, int i) {
        if (!TextUtils.isEmpty(bVar.c)) {
            Intent intent = new Intent(z[12]);
            try {
                cn.jpush.android.api.b.a(intent, cn.jpush.android.api.b.a(bVar), i);
                intent.putExtra(z[11], a.a);
                String packageName = TextUtils.isEmpty(bVar.n) ? context.getPackageName() : bVar.n;
                intent.addCategory(packageName);
                e.e(z[4], new StringBuilder(z[14]).append(packageName).toString());
                context.sendBroadcast(intent, packageName + z[13]);
                d.a(bVar.c, str, g.a().f(context), 1000, context);
            } catch (Throwable th) {
                e.h(z[4], new StringBuilder(z[10]).append(th.getMessage()).toString());
                cn.jpush.android.d.a.b(context, intent, context.getPackageName() + z[13]);
            }
        }
    }

    public static void a(Context context, String str, String str2, int i, boolean z) {
        if (context == null) {
            e.h(z[4], z[20]);
        } else if (TextUtils.isEmpty(str)) {
            e.h(z[4], z[22]);
        } else {
            e.a(z[4], new StringBuilder(z[15]).append(str).toString());
            b a = a(context, str, str2);
            e.a(z[4], new StringBuilder(z[16]).append(a).toString());
            if (a == null) {
                e.h(z[4], z[19]);
            } else if (TextUtils.isEmpty(a.c)) {
                e.h(z[4], z[17]);
            } else if (z) {
                e.a(z[4], z[21]);
                if (!(a instanceof g)) {
                    return;
                }
                if (((g) a).K == -1) {
                    a(context, a, str2, i);
                    return;
                }
                Intent c = cn.jpush.android.api.b.c(context, a);
                if (c != null) {
                    c.addFlags(268435456);
                    context.getApplicationContext().startActivity(c);
                }
            } else {
                e.a(z[4], z[18]);
                if (a instanceof g) {
                    cn.jpush.android.api.b.a(context, cn.jpush.android.api.b.a(a), i, null, context.getPackageName(), a);
                    d.a(a.c, str2, g.a().f(context), PointerIconCompat.TYPE_ZOOM_IN, context);
                }
            }
        }
    }
}
