package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import cn.jpush.android.a;
import cn.jpush.android.c.g;
import cn.jpush.android.c.h;
import cn.jpush.android.d.e;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class PluginMeizuPlatformsReceiver extends MzPushMessageReceiver {
    private static final String[] z;
    private Context a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 20;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "/\u001eNV\u0010\u0011?^X\u0003\n\"WP\r\u0019\u001dI\\\n-\u0017XT\u0010\t\u0017I";
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
            case 0: goto L_0x00fa;
            case 1: goto L_0x00fe;
            case 2: goto L_0x0102;
            case 3: goto L_0x0106;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0010\u001cn_+\u001a\u0015RB\r\u001a\u0000\u001bX\n_\u0011Z]\u0015\u001a\u0016";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0010\u001cvT\n\f\u0013\\TY\u0016\u0001\u001bR\u0018\u0013\u001e^U";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0010\u001cn_+\u001a\u0015RB\r\u001a\u0000hE\u0018\u000b\u0007H\u000b";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0010\u001ciT\u001e\u0016\u0001OT\u000b_\u001bH\u0011\u001a\u001e\u001eWT\u001d";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u000f\u0013IB\u001c_\u0017CE\u000b\u001eR^C\u000b\u0010\u0000\u001b";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "5?^B\n\u001e\u0015^t\u0001\u000b\u0000Z";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u0010\u001cu^\r\u0016\u0014RR\u0018\u000b\u001bT_:\u0013\u001bXZ\u001c\u001bHOX\r\u0013\u0017\u0001";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "S\u0017CE\u000b\u001eH";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "S\u0011T_\r\u001a\u001cO\u000b";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0010\u001ckD\n\u0017!OP\r\n\u0001\u001bX\n_\u0011Z]\u0015\u001a\u0016";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u0010\u001chD\u001b>\u001eRP\n,\u0006ZE\f\fH";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0012\bdA\f\f\u001ad_\u0016\u000b\u001b]X\u001a\u001e\u0006R^\u0017 \u0001VP\u0015\u0013-RR\u0016\u0011";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u001b\u0000ZF\u0018\u001d\u001e^";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\f\u0017O\u0011\u0014\u001a\u001bADY\f\u0006ZE\f\f\u0010ZCY\u0016\u0011T_Y\u001a\u0000I^\u000bE";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u0010\u001cu^\r\u0016\u0014RR\u0018\u000b\u001bT_8\r\u0000RG\u001c\u001bHOX\r\u0013\u0017\u0001";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "*\u0002_P\r\u001aRKD\n\u0017;_\u0011\f\u0011\u0017CA\u001c\u001c\u0006^UY\u001a\u0000I^\u000bE";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u0010\u001ciT\u001e\u0016\u0001OT\u000b,\u0006ZE\f\fH";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "/\u0007HY0\u001bRRBY";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\u0010\u001chD\u001b+\u0013\\B*\u000b\u0013OD\nE";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00fa:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x0020;
    L_0x00fe:
        r9 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        goto L_0x0020;
    L_0x0102:
        r9 = 59;
        goto L_0x0020;
    L_0x0106:
        r9 = 49;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.PluginMeizuPlatformsReceiver.<clinit>():void");
    }

    private static String a(String str) {
        try {
            return new JSONObject(str).optString(z[6]);
        } catch (Throwable th) {
            e.h(z[0], new StringBuilder(z[5]).append(th).toString());
            return null;
        }
    }

    public void onMessage(Context context, String str) {
        e.d(z[0], z[2]);
    }

    public void onNotificationArrived(Context context, String str, String str2, String str3) {
        e.f(z[0], new StringBuilder(z[15]).append(String.valueOf(str)).append(z[9]).append(String.valueOf(str2)).append(z[8]).append(String.valueOf(str3)).toString());
        h.a(context, a(str3), "", 0, false);
    }

    public void onNotificationClicked(Context context, String str, String str2, String str3) {
        e.f(z[0], new StringBuilder(z[7]).append(String.valueOf(str)).append(z[9]).append(String.valueOf(str2)).append(z[8]).append(String.valueOf(str3)).toString());
        h.a(context, a(str3), "", 0, true);
    }

    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
        e.f(z[0], z[10]);
    }

    public void onReceive(Context context, Intent intent) {
        try {
            this.a = context.getApplicationContext();
        } catch (Throwable th) {
        }
        super.onReceive(context, intent);
    }

    public void onRegister(Context context, String str) {
        e.d(z[0], z[4]);
    }

    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        e.f(z[0], new StringBuilder(z[17]).append(String.valueOf(registerStatus)).toString());
        if (registerStatus != null) {
            e.h(z[0], new StringBuilder(z[18]).append(String.valueOf(registerStatus.getPushId())).toString());
        }
        try {
            g.a().e(context);
        } catch (Throwable th) {
            e.h(z[0], new StringBuilder(z[16]).append(th.getMessage()).toString());
        }
    }

    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
        e.f(z[0], new StringBuilder(z[11]).append(String.valueOf(subAliasStatus)).toString());
    }

    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
        e.d(z[0], new StringBuilder(z[19]).append(String.valueOf(subTagsStatus)).toString());
    }

    public void onUnRegister(Context context, boolean z) {
        e.f(z[0], z[1]);
    }

    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
        e.d(z[0], new StringBuilder(z[3]).append(String.valueOf(unRegisterStatus)).toString());
    }

    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        try {
            if (this.a == null) {
                this.a = a.e;
            }
            int identifier = this.a.getResources().getIdentifier(z[12], z[13], this.a.getPackageName());
            if (identifier != 0) {
                pushNotificationBuilder.setmStatusbarIcon(identifier);
            }
        } catch (Throwable th) {
            e.h(z[0], new StringBuilder(z[14]).append(th.toString()).toString());
        }
    }
}
