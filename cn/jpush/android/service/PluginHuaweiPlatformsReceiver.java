package cn.jpush.android.service;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.c.g;
import cn.jpush.android.c.h;
import cn.jpush.android.d.e;
import com.huawei.hms.support.api.push.PushReceiver;
import com.huawei.hms.support.api.push.PushReceiver.Event;

/* compiled from: TbsSdkJava */
public class PluginHuaweiPlatformsReceiver extends PushReceiver {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 12;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u001eZWN{\u0019gsZ|\u0014\u000e";
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
            case 0: goto L_0x00a2;
            case 1: goto L_0x00a6;
            case 2: goto L_0x00aa;
            case 3: goto L_0x00ad;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 8;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "!Xr\\a\u001f|rZ\u0014]WWi\u0005RhIe\u0002fbXm\u0018BbI";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0013QkTf\u0016}c";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0004DkTi\u0015fb\\A5\u0014aZa\u001dQc\u001b%QQuIg\u0003\u000e";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0005[l^fK";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "]VbWg\u001fSN_2";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0001AtSE\u0002S";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001f[sRn\u0018WfOa\u001eZ";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0001UuHmQYbH{\u0010Sb\u001bm\u0003FhI2";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0001AtSF\u001e@n]q8P";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u001eZBMm\u001f@=";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u0003Qd^a\u0007Q'^p\u0005QiOm\u0015\u0014iT|\u0018RnXi\u0005]hU(\u001cQtHi\u0016Q=\u001b";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00a2:
        r9 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        goto L_0x0020;
    L_0x00a6:
        r9 = 52;
        goto L_0x0020;
    L_0x00aa:
        r9 = 7;
        goto L_0x0020;
    L_0x00ad:
        r9 = 59;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.PluginHuaweiPlatformsReceiver.<clinit>():void");
    }

    public void onEvent(Context context, Event event, Bundle bundle) {
        int i = 0;
        e.e(z[1], new StringBuilder(z[10]).append(event != null ? event.name() : null).toString());
        if (event != null && Event.NOTIFICATION_OPENED.equals(event)) {
            if (bundle != null) {
                i = bundle.getInt(z[9], 0);
            }
            if (i != 0) {
                ((NotificationManager) context.getSystemService(z[7])).cancel(i);
            }
            try {
                String string = bundle.getString(z[6]);
                if (!TextUtils.isEmpty(string)) {
                    string = string.substring(1, string.length() - 1);
                }
                e.e(z[1], new StringBuilder(z[11]).append(string).toString());
                h.a(context.getApplicationContext(), string, "", i, true);
            } catch (Throwable th) {
                e.c(z[1], new StringBuilder(z[8]).append(th).toString());
            }
        }
        super.onEvent(context, event, bundle);
    }

    public void onPushState(Context context, boolean z) {
        e.d(z[1], new StringBuilder(z[0]).append(z).toString());
        super.onPushState(context, z);
    }

    public void onToken(Context context, String str, Bundle bundle) {
        super.onToken(context, str, bundle);
        String str2 = null;
        if (bundle != null) {
            str2 = bundle.getString(z[2]);
        }
        e.f(z[1], new StringBuilder(z[4]).append(str).append(z[5]).append(str2).toString());
        try {
            g.a().a(context.getApplicationContext(), str);
        } catch (Throwable th) {
            e.g(z[1], new StringBuilder(z[3]).append(th).toString());
        }
    }
}
