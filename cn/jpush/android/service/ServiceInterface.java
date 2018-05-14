package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a;
import cn.jpush.android.api.DefaultPushNotificationBuilder;
import cn.jpush.android.b;
import cn.jpush.android.c.g;
import cn.jpush.android.d.e;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class ServiceInterface {
    private static boolean a = false;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 25;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0015)TE\t8b\u0012B\u0005-\u001dD\blf\u0015SF\"~\u0019\u000b\\l";
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
            case 0: goto L_0x0134;
            case 1: goto L_0x0138;
            case 2: goto L_0x013c;
            case 3: goto L_0x0140;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 43;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "5)y\u0002B\u0005)B\u001a_\u0003>m\u0015H\u0003";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0015):D\u0012%m\u001dH\u00078b\u001bE(9f\u0016N\u0014l&TH\t\"\u0011S\u0012lb\u0007\u000b\b9g\u0018\n";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0005\"%\u001e[\u0013?cZJ\b(y\u001bB\u0002bb\u001a_\u0003\"Zj*\u0005J't2\rL'";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0007/\u001dD\b";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0016>d\u0000D98r\u0004N";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0012-l\u0007";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u0007 b\u0015X";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0015)z+B\u0002";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0016>d\u0000D\u0007/\u001dD\b\u0013\r[\u0003";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0005\"%\u001e[\u0013?cZJ\b(y\u001bB\u0002bb\u001a_\u0003\"Zx2\u0003[$~5\u0004";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u0015)y\u0002B\u0005)T\u0007_\t<n\u0010";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0007<{";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u00158j\u0006_+%e\u0007";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u00158j\u0006_.#~\u0006";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u0003\"o\u0000f\u000f\"x";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u0003\"o<D\u0013>";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "Ub;Z\u0013";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\u0005\"%\u001e[\u0013?cZJ\b(y\u001bB\u0002bb\u001a_\u0003\"Zy#\u001f_;y#\u001c^'c";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\u0016%oN";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "Jlx\u0000D\u0016\u0018r\u0004N\\";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "(9g\u0018\u000b\u0005#e\u0000N\u001e8'T[\n)j\u0007NF%e\u001d_F\u0006[\u0001X\u000em";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "Klx\u0011_(#\u001dM\u000f/j\u0000B\t\"I\u0001B\n(n\u0006\u000bKl";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u0005 n\u0015Y' g:D\u0012%m\u001dH\u00078b\u001bEFa+\u0017D\b8n\f_F%xTE\u0013 gU";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "2$nTX\u0003>}\u001dH\u0003lb\u0007\u000b\u00158d\u0004[\u0003('TB\u0012l|\u001dG\nll\u001d]\u0003l~\u0004\u000b\u0007 gT_\u000e)+\u0015H\u0012%d\u001aXF9e\u0000B\nlr\u001b^F/j\u0018GF>n\u0007^\u000b)[\u0001X\u000elf\u0011_\u000e#oT_\tly\u0011X\u0013!nT_\u000e)+\u0007N\u0014:b\u0017NH";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        a = r0;
        return;
    L_0x0134:
        r9 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        goto L_0x0020;
    L_0x0138:
        r9 = 76;
        goto L_0x0020;
    L_0x013c:
        r9 = 11;
        goto L_0x0020;
    L_0x0140:
        r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.ServiceInterface.<clinit>():void");
    }

    public static String a() {
        return z[17];
    }

    public static void a(Context context) {
        if (!d(context)) {
            JCoreInterface.restart(context, a.a, new Bundle(), false);
            g.a().a(context);
        }
    }

    public static void a(Context context, int i) {
        e(context);
        MultiSpHelper.commitInt(context, z[11], 1);
        Bundle bundle = new Bundle();
        bundle.putString(z[4], z[10]);
        bundle.putString(z[12], context.getPackageName());
        JCoreInterface.stop(context, a.a, bundle);
    }

    public static void a(Context context, Integer num, DefaultPushNotificationBuilder defaultPushNotificationBuilder) {
        if (context == null) {
            e.j(z[1], z[21]);
            return;
        }
        e.e(z[1], new StringBuilder(z[22]).append(defaultPushNotificationBuilder.toString()).toString());
        b.a(context, num, defaultPushNotificationBuilder.toString(), false);
    }

    public static void a(Context context, String str) {
        if (context != null && !d(context)) {
            b.a(context, str, false);
        }
    }

    public static void a(Context context, String str, Set<String> set, long j, cn.jpush.android.api.a aVar) {
        int i = 0;
        Bundle bundle = new Bundle();
        bundle.putString(z[4], z[3]);
        bundle.putString(z[7], str);
        ArrayList arrayList = null;
        if (set != null) {
            arrayList = new ArrayList(set);
        }
        bundle.putStringArrayList(z[6], arrayList);
        bundle.putLong(z[8], j);
        bundle.putString(z[5], (aVar != null ? aVar.e : 0));
        String str2 = z[9];
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar != null) {
            i = aVar.f;
        }
        bundle.putString(str2, stringBuilder.append(i).toString());
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static boolean a(Context context, int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(z[14], i);
            jSONObject.put(z[13], i2);
            jSONObject.put(z[16], i3);
            jSONObject.put(z[15], i4);
            a(context, jSONObject.toString());
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public static void b(Context context) {
        if (context == null) {
            e.h(z[1], z[23]);
        } else {
            cn.jpush.android.api.b.a(context.getApplicationContext(), false);
        }
    }

    public static void b(Context context, int i) {
        e(context);
        MultiSpHelper.commitInt(context, z[11], 0);
        Bundle bundle = new Bundle();
        bundle.putString(z[4], z[18]);
        bundle.putString(z[12], context.getPackageName());
        JCoreInterface.restart(context, a.a, bundle, true);
    }

    public static void c(Context context, int i) {
        if (context == null) {
            e.h(z[1], z[2]);
            return;
        }
        e.a(z[1], new StringBuilder(z[0]).append(i).toString());
        b.a(context, i, false);
    }

    public static boolean c(Context context) {
        return e(context) > 0;
    }

    public static boolean d(Context context) {
        boolean c = c(context);
        if (c) {
            e.d(z[1], z[24]);
        }
        return c;
    }

    private static int e(Context context) {
        int i = MultiSpHelper.getInt(context, z[11], 0);
        e.c(z[1], new StringBuilder(z[19]).append(Process.myPid()).append(z[20]).append(i).toString());
        return i;
    }
}
