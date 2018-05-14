package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a;
import cn.jpush.android.d.e;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.ui.PopWinActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class MultiActionsNotificationBuilder extends DefaultPushNotificationBuilder {
    private static final String NOTI_ACT_EXTRA_STR;
    private static final String NOTI_ACT_RES_ID;
    private static final String NOTI_ACT_TEXT;
    private static final String TAG;
    private static final String[] z;
    private JSONArray actionJSONArray = new JSONArray();
    protected Context mContext;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 10;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "+x80m,t--b*y\u00138h1~#7T o8+j\u001ad8+b+p";
        r0 = 9;
        r4 = r3;
    L_0x000a:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x004a;
    L_0x0013:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0018:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x00ab;
            case 1: goto L_0x00af;
            case 2: goto L_0x00b3;
            case 3: goto L_0x00b7;
            default: goto L_0x001f;
        };
    L_0x001f:
        r9 = 11;
    L_0x0021:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x0048;
    L_0x0029:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0018;
    L_0x002d:
        NOTI_ACT_EXTRA_STR = r1;
        r1 = "+x80m,t--b*y\u00138h1~#7T7r?\u0006b!";
        r0 = 10;
        goto L_0x000a;
    L_0x0034:
        NOTI_ACT_RES_ID = r1;
        r1 = "\bb -b\u0004t80d+d\u00026,q%:j1~#7I0~ =n7";
        r0 = 11;
        goto L_0x000a;
    L_0x003b:
        TAG = r1;
        r1 = "+x80m,t--b*y\u00138h1~#7T1r4-";
        r0 = 12;
        goto L_0x000a;
    L_0x0042:
        NOTI_ACT_TEXT = r1;
        r1 = "\u0015v>*neu90g!r>ym7x!y{7r*<y y/<+#v%5n!6";
        r0 = -1;
        goto L_0x000a;
    L_0x0048:
        r5 = r1;
        r1 = r7;
    L_0x004a:
        if (r5 > r6) goto L_0x0013;
    L_0x004c:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0060;
            case 1: goto L_0x0068;
            case 2: goto L_0x0070;
            case 3: goto L_0x0078;
            case 4: goto L_0x0080;
            case 5: goto L_0x0088;
            case 6: goto L_0x0091;
            case 7: goto L_0x009b;
            case 8: goto L_0x00a6;
            case 9: goto L_0x002d;
            case 10: goto L_0x0034;
            case 11: goto L_0x003b;
            case 12: goto L_0x0042;
            default: goto L_0x0058;
        };
    L_0x0058:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0004s(ye*c%?b&v80d+7-:,x\"c+7r?y&e";
        r0 = 0;
        r3 = r4;
        goto L_0x000a;
    L_0x0060:
        r3[r2] = r1;
        r2 = 2;
        r1 = "&yb3{0d$wj+s>6b!9\u0002\u0016_\fQ\u0005\u0018H\u0004C\u0005\u0016E\u001aV\u000f\rB\nY\u0013\u001cS\u0011E\r";
        r0 = 1;
        r3 = r4;
        goto L_0x000a;
    L_0x0068:
        r3[r2] = r1;
        r2 = 3;
        r1 = "i7?-y,y+y&e";
        r0 = 2;
        r3 = r4;
        goto L_0x000a;
    L_0x0070:
        r3[r2] = r1;
        r2 = 4;
        r1 = ",d\u00026,q%:j1~#7";
        r0 = 3;
        r3 = r4;
        goto L_0x000a;
    L_0x0078:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0015v>*neV/-b*yl?y*zl)y q)+n+t)y{7r*<y y/<+#v%5n!6";
        r0 = 4;
        r3 = r4;
        goto L_0x000a;
    L_0x0080:
        r3[r2] = r1;
        r2 = 6;
        r1 = "i7)!7vlt+";
        r0 = 5;
        r3 = r4;
        goto L_0x000a;
    L_0x0088:
        r3[r2] = r1;
        r2 = 7;
        r1 = "&yb3{0d$wj+s>6b!9%7 y8wE\nC\u0005\u001fB\u0006V\u0018\u0010D\u000bH\u000f\u0015B\u0006\\\u0013\u0018H\u0011^\u0003\u0017T\u0015E\u0003\u0001R";
        r0 = 6;
        r3 = r4;
        goto L_0x000a;
    L_0x0091:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0001r:0h 7;0-7\u001f\u001d@\u001aA\t\u000bX\fX\u0002y7e&zu+6#.+*e%>b+v ye*c%?b&v80d+7?-r)rb";
        r0 = 7;
        r3 = r4;
        goto L_0x000a;
    L_0x009b:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0006x\"*7b/-+$t80d+7*8b)r(x";
        r0 = 8;
        r3 = r4;
        goto L_0x000a;
    L_0x00a6:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00ab:
        r9 = 69;
        goto L_0x0021;
    L_0x00af:
        r9 = 23;
        goto L_0x0021;
    L_0x00b3:
        r9 = 76;
        goto L_0x0021;
    L_0x00b7:
        r9 = 89;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.MultiActionsNotificationBuilder.<clinit>():void");
    }

    public MultiActionsNotificationBuilder(Context context) {
        this.mContext = context;
    }

    static PushNotificationBuilder parseFromPreference(String str) {
        PushNotificationBuilder multiActionsNotificationBuilder = new MultiActionsNotificationBuilder(a.e);
        try {
            multiActionsNotificationBuilder.actionJSONArray = new JSONArray(str);
        } catch (JSONException e) {
            e.h(TAG, z[0]);
            e.printStackTrace();
        }
        return multiActionsNotificationBuilder;
    }

    public void addJPushAction(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NOTI_ACT_RES_ID, i);
            jSONObject.put(NOTI_ACT_TEXT, str);
            jSONObject.put(NOTI_ACT_EXTRA_STR, str2);
            this.actionJSONArray.put(jSONObject);
            e.e(TAG, this.actionJSONArray.toString());
        } catch (JSONException e) {
            e.h(TAG, z[9]);
            e.printStackTrace();
        }
    }

    @TargetApi(11)
    Notification getNotification(Builder builder) {
        if (VERSION.SDK_INT >= 16) {
            for (int i = 0; i < this.actionJSONArray.length(); i++) {
                try {
                    PendingIntent activity;
                    JSONObject jSONObject = this.actionJSONArray.getJSONObject(i);
                    Intent intent = new Intent(z[7]);
                    intent.putExtra(z[2], jSONObject.getString(NOTI_ACT_EXTRA_STR));
                    if (JCoreInterface.getRuningFlag()) {
                        intent.setClass(this.mContext, PopWinActivity.class);
                        intent.putExtra(z[4], true);
                        activity = PendingIntent.getActivity(this.mContext, i, intent, 134217728);
                    } else {
                        intent.setClass(this.mContext, PushReceiver.class);
                        activity = PendingIntent.getBroadcast(this.mContext, i, intent, 134217728);
                    }
                    e.e(TAG, new StringBuilder(z[1]).append(jSONObject.getInt(NOTI_ACT_RES_ID)).append(z[3]).append(jSONObject.getString(NOTI_ACT_TEXT)).append(z[6]).append(jSONObject.getString(NOTI_ACT_EXTRA_STR)).toString());
                    builder.addAction(jSONObject.getInt(NOTI_ACT_RES_ID), jSONObject.getString(NOTI_ACT_TEXT), activity).setAutoCancel(true);
                } catch (JSONException e) {
                    e.h(TAG, z[5]);
                    e.printStackTrace();
                }
            }
            return builder.build();
        }
        e.e(TAG, z[8]);
        return builder.getNotification();
    }

    public String toString() {
        return this.actionJSONArray.toString();
    }
}
