package cn.jpush.android.service;

import android.content.Context;
import cn.jpush.android.c.g;
import cn.jpush.android.c.h;
import cn.jpush.android.d.e;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

/* compiled from: TbsSdkJava */
public class PluginXiaomiPlatformsReceiver extends PushMessageReceiver {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "W\u0019\bf\b]\u0019[b\bI\\\u0015`\u0005V";
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
            case 0: goto L_0x008c;
            case 1: goto L_0x008f;
            case 2: goto L_0x0092;
            case 3: goto L_0x0095;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "U\u00125z\u001dS\u001a\u0012v\bN\u0015\u0014{$_\u000f\bt\u000e_=\tg\u0000L\u0019\u001f5\u0000I\\\u0018t\u0005V\u0019\u001f;I";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "j\u0010\u000er\u0000T$\u0012t\u0006W\u0015+y\bN\u001a\u0014g\u0004I.\u001ev\fS\n\u001eg";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "U\u0012)p\n_\u0015\rp9[\u000f\bA\u0001H\u0013\u000er\u0001w\u0019\bf\b]\u0019[|\u001a\u001a\u001f\u001ay\u0005_\u0018U5";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "H\u0019\u001c|\u001aN\u0019\t";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "U\u00128z\u0004W\u001d\u0015q;_\u000f\u000ey\u001d\u001a\u0015\b5\n[\u0010\u0017p\r\u0014\\";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "U\u00125z\u001dS\u001a\u0012v\bN\u0015\u0014{$_\u000f\bt\u000e_?\u0017|\nQ\u0019\u001f5\u0000I\\\u0018t\u0005V\u0019\u001f;I";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "B\u0015\u001azIW\u0015[e\u001cI\u0014[g\f]\u0015\ba\fH\\\b`\nY\u0019\bf";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "B\u0015\u001azIW\u0015[e\u001cI\u0014[g\f]\u0015\ba\fH\\\u001dt\u0000V\u0019\u001f5D\u001a\u0019\tg\u0006H?\u0014q\f\u0000";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0016\u000e\u001et\u001aU\u0012A";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x008c:
        r9 = 58;
        goto L_0x0020;
    L_0x008f:
        r9 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        goto L_0x0020;
    L_0x0092:
        r9 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        goto L_0x0020;
    L_0x0095:
        r9 = 21;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.PluginXiaomiPlatformsReceiver.<clinit>():void");
    }

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        e.a(z[2], new StringBuilder(z[5]).append(miPushCommandMessage).toString());
        if (miPushCommandMessage == null) {
            e.a(z[2], z[0]);
            return;
        }
        if (z[4].equals(miPushCommandMessage.getCommand()) && miPushCommandMessage.getResultCode() == 0) {
            g.a().e(context.getApplicationContext());
        }
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        e.a(z[2], new StringBuilder(z[1]).append(miPushMessage).toString());
        if (miPushMessage == null) {
            e.a(z[2], z[0]);
        } else {
            h.a(context, miPushMessage.getContent(), miPushMessage.getMessageId(), miPushMessage.getNotifyId(), false);
        }
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        e.a(z[2], new StringBuilder(z[6]).append(miPushMessage).toString());
        if (miPushMessage == null) {
            e.a(z[2], z[0]);
        } else {
            h.a(context, miPushMessage.getContent(), miPushMessage.getMessageId(), miPushMessage.getNotifyId(), true);
        }
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        e.a(z[2], new StringBuilder(z[3]).append(miPushMessage).toString());
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        if (miPushCommandMessage == null) {
            return;
        }
        if (miPushCommandMessage.getResultCode() == 0) {
            e.d(z[2], z[7]);
        } else {
            e.j(z[2], new StringBuilder(z[8]).append(miPushCommandMessage.getResultCode()).append(z[9]).append(miPushCommandMessage.getReason()).toString());
        }
    }
}
