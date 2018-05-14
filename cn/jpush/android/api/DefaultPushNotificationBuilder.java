package cn.jpush.android.api;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.Notification.Style;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.a;
import cn.jpush.android.d.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class DefaultPushNotificationBuilder implements PushNotificationBuilder {
    private static final String TAG;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 25;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0001\u0018\u000e\u001ff)\t8\u000b`-3\u0007\nz#\u0014\u000b\u001fg,\u0012\u0006<f,\u0011\f\u001ba";
        r0 = 24;
        r4 = r3;
    L_0x000a:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x0035;
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
            case 0: goto L_0x0139;
            case 1: goto L_0x013d;
            case 2: goto L_0x0141;
            case 3: goto L_0x0145;
            default: goto L_0x001f;
        };
    L_0x001f:
        r9 = 19;
    L_0x0021:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x0033;
    L_0x0029:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0018;
    L_0x002d:
        TAG = r1;
        r1 = "eVH";
        r0 = -1;
        goto L_0x000a;
    L_0x0033:
        r5 = r1;
        r1 = r7;
    L_0x0035:
        if (r5 > r6) goto L_0x0013;
    L_0x0037:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x004b;
            case 1: goto L_0x0053;
            case 2: goto L_0x005b;
            case 3: goto L_0x0063;
            case 4: goto L_0x006b;
            case 5: goto L_0x0073;
            case 6: goto L_0x007b;
            case 7: goto L_0x0084;
            case 8: goto L_0x008f;
            case 9: goto L_0x009a;
            case 10: goto L_0x00a5;
            case 11: goto L_0x00b0;
            case 12: goto L_0x00bb;
            case 13: goto L_0x00c6;
            case 14: goto L_0x00d1;
            case 15: goto L_0x00dc;
            case 16: goto L_0x00e7;
            case 17: goto L_0x00f2;
            case 18: goto L_0x00fd;
            case 19: goto L_0x0108;
            case 20: goto L_0x0113;
            case 21: goto L_0x011e;
            case 22: goto L_0x0129;
            case 23: goto L_0x0134;
            case 24: goto L_0x002d;
            default: goto L_0x0043;
        };
    L_0x0043:
        r3[r2] = r1;
        r2 = 1;
        r1 = "6\u0018\u001c=r1\u0018\u000f\u0011a<";
        r0 = 0;
        r3 = r4;
        goto L_0x000a;
    L_0x004b:
        r3[r2] = r1;
        r2 = 2;
        r1 = "&\u0013F\u0014c0\u000e\u0000Pr+\u0019\u001a\u0011z!S)2V\u0017)";
        r0 = 1;
        r3 = r4;
        goto L_0x000a;
    L_0x0053:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0016\u0018\u001c^}*\t\u0001\u0018z&\u001c\u001c\u0017|+]*.@e\n\u0001\n{e\r\u0001\u001dg0\u000f\r^c$\t\u0000D";
        r0 = 2;
        r3 = r4;
        goto L_0x000a;
    L_0x005b:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0006\u000f\r\u001fg ]\n\u0017g(\u001c\u0018^u$\u0014\u0004\u001bwe\u001e\t\u000b` \u0019H\u001cje2\u001d\n\\#0\r\u0013|7\u0004-\fa*\u000fF";
        r0 = 3;
        r3 = r4;
        goto L_0x000a;
    L_0x0063:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0001\u0018\u001e\u0017p ]\u001a\u0011~e.,53y]ZO?e\u001e\t\u00103+\u0012\u001c^` \tH\u0010|1\u0014\u000e\u0017p$\t\u0001\u0011}e\u001e\t\nv\"\u0012\u001a\u00072";
        r0 = 4;
        r3 = r4;
        goto L_0x000a;
    L_0x006b:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u000b\u0012H\u0010|1\u0014\u000e\u0017p$\t\u0001\u0011}e\u001e\u0007\u0010g \u0013\u001c^g*]\u001b\u0016|2SH9z3\u0018H\u000bck";
        r0 = 5;
        r3 = r4;
        goto L_0x000a;
    L_0x0073:
        r3[r2] = r1;
        r2 = 7;
        r1 = "$\u0013\f\f|,\u0019F\u001fc5S&\u0011g,\u001b\u0001\u001dr1\u0014\u0007\u00107\u0007\b\u0001\u0012w \u000f";
        r0 = 6;
        r3 = r4;
        goto L_0x000a;
    L_0x007b:
        r3[r2] = r1;
        r2 = 8;
        r1 = "&\u0013F\u0014c0\u000e\u0000Pr+\u0019\u001a\u0011z!S&1G\f;!=R\u00114'0L\u00062&*V\u000b)7*Z\u00111-";
        r0 = 7;
        r3 = r4;
        goto L_0x000a;
    L_0x0084:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0006\u000f\r\u001fg ]\n\u0017te\r\u0001\u001dg0\u000f\r^`1\u0004\u0004\u001b3#\u001c\u0001\u0012v!S";
        r0 = 8;
        r3 = r4;
        goto L_0x000a;
    L_0x008f:
        r3[r2] = r1;
        r2 = 10;
        r1 = "e\u0013\r\t3(\u0018\u001b\rr\"\u0018\u001b";
        r0 = 9;
        r3 = r4;
        goto L_0x000a;
    L_0x009a:
        r3[r2] = r1;
        r2 = 11;
        r1 = "&\u0013F\u0014c0\u000e\u0000Pr+\u0019\u001a\u0011z!S!0Q\n%";
        r0 = 10;
        r3 = r4;
        goto L_0x000a;
    L_0x00a5:
        r3[r2] = r1;
        r2 = 12;
        r1 = "e(\u001b\u001b3!\u0018\u000e\u001ff)\tH\u0010|1\u0014\u000e\u0017p$\t\u0001\u0011}e\u000b\u0001\u001bdd]";
        r0 = 11;
        r3 = r4;
        goto L_0x000a;
    L_0x00b0:
        r3[r2] = r1;
        r2 = 13;
        r1 = "&\u0013F\u0014c0\u000e\u0000Pr+\u0019\u001a\u0011z!S&1G\f\"8,Z\n/!*J";
        r0 = 12;
        r3 = r4;
        goto L_0x000a;
    L_0x00bb:
        r3[r2] = r1;
        r2 = 14;
        r1 = "#\u001c\u0001\u0012v!]\u001c\u00113\"\u0018\u001c^r5\r\u0004\u0017p$\t\u0001\u0011}e\u0014\u0006\u0018|e\u001c\u0006\u001a3,\u001e\u0007\u0010=";
        r0 = 13;
        r3 = r4;
        goto L_0x000a;
    L_0x00c6:
        r3[r2] = r1;
        r2 = 15;
        r1 = "&\u0013F\u0014c0\u000e\u0000Pr+\u0019\u001a\u0011z!S*7T\u001a-!=L\u0015<<6";
        r0 = 14;
        r3 = r4;
        goto L_0x000a;
    L_0x00d1:
        r3[r2] = r1;
        r2 = 16;
        r1 = "!\u000f\t\tr'\u0011\r";
        r0 = 15;
        r3 = r4;
        goto L_0x000a;
    L_0x00dc:
        r3[r2] = r1;
        r2 = 17;
        r1 = "&\u0013F\u0014c0\u000e\u0000Pr+\u0019\u001a\u0011z!S)2V\u0017)7*J\u00158";
        r0 = 16;
        r3 = r4;
        goto L_0x000a;
    L_0x00e7:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\u0006\u001c\u0006Yge\u001b\u0001\u0010we\u000b\t\u0012z!]\u000b\u0011}1\u0018\u0010\n32\u0015\r\u00103'\b\u0001\u0012we\u0013\u0007\nz#\u0014\u000b\u001fg,\u0012\u0006P";
        r0 = 17;
        r3 = r4;
        goto L_0x000a;
    L_0x00f2:
        r3[r2] = r1;
        r2 = 19;
        r1 = "/\r\u001d\r{\u001a\u0013\u0007\nz#\u0014\u000b\u001fg,\u0012\u0006!z&\u0012\u0006";
        r0 = 18;
        r3 = r4;
        goto L_0x000a;
    L_0x00fd:
        r3[r2] = r1;
        r2 = 20;
        r1 = "$\u0013\f\f|,\u0019F\u001fc5S&\u0011g,\u001b\u0001\u001dr1\u0014\u0007\u0010";
        r0 = 19;
        r3 = r4;
        goto L_0x000a;
    L_0x0108:
        r3[r2] = r1;
        r2 = 21;
        r1 = "&\u0013F\u0014c0\u000e\u0000Pr+\u0019\u001a\u0011z!S&1G\f\"+?G\u0000:',J";
        r0 = 20;
        r3 = r4;
        goto L_0x000a;
    L_0x0113:
        r3[r2] = r1;
        r2 = 22;
        r1 = "6\u0018\u001c2r1\u0018\u001b\nV3\u0018\u0006\nZ+\u001b\u0007";
        r0 = 21;
        r3 = r4;
        goto L_0x000a;
    L_0x011e:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u000f-\u001d\r{k\u00108\u001fp.\u001c\u000f\u001bZ+\u001e\u0007\u0010Z!]UC3u]WR3\"\u0018\u001c^z&\u0012\u0006^u7\u0012\u0005^r5\r\u0004\u0017p$\t\u0001\u0011}e\u0014\u0006\u0018|k";
        r0 = 22;
        r3 = r4;
        goto L_0x000a;
    L_0x0129:
        r3[r2] = r1;
        r2 = 24;
        r1 = "&\u0013F\u0014c0\u000e\u0000Pr+\u0019\u001a\u0011z!S*7T\u001a)-&G";
        r0 = 23;
        r3 = r4;
        goto L_0x000a;
    L_0x0134:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0139:
        r9 = 69;
        goto L_0x0021;
    L_0x013d:
        r9 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        goto L_0x0021;
    L_0x0141:
        r9 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        goto L_0x0021;
    L_0x0145:
        r9 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.DefaultPushNotificationBuilder.<clinit>():void");
    }

    RemoteViews buildContentView(String str, String str2) {
        return null;
    }

    public Notification buildNotification(Map<String, String> map) {
        CharSequence charSequence = a.d;
        String str = "";
        CharSequence charSequence2 = "";
        Object obj = "";
        int i = 0;
        CharSequence charSequence3 = "";
        String str2 = "";
        if (map.containsKey(z[2])) {
            CharSequence charSequence4 = (String) map.get(z[2]);
        } else {
            Object obj2 = str;
        }
        if (TextUtils.isEmpty(charSequence4)) {
            e.h(TAG, z[6]);
            return null;
        }
        if (map.containsKey(z[8])) {
            charSequence = (String) map.get(z[8]);
        }
        if (map.containsKey(z[24])) {
            charSequence2 = (String) map.get(z[24]);
        }
        if (map.containsKey(z[11])) {
            obj = (String) map.get(z[11]);
        }
        if (map.containsKey(z[13])) {
            i = Integer.parseInt((String) map.get(z[13]));
        }
        if (map.containsKey(z[21])) {
            charSequence3 = (String) map.get(z[21]);
        }
        if (map.containsKey(z[15])) {
            str2 = (String) map.get(z[15]);
        }
        int parseInt = map.containsKey(z[17]) ? Integer.parseInt((String) map.get(z[17])) : -1;
        int i2 = (parseInt < -1 || parseInt > 7) ? -1 : parseInt;
        if (a.e != null) {
            parseInt = a.e.getResources().getIdentifier(z[19], z[16], a.e.getPackageName());
            if (parseInt == 0) {
                if (a.b != 0) {
                    parseInt = a.b;
                } else {
                    try {
                        parseInt = a.e.getPackageManager().getApplicationInfo(a.e.getPackageName(), 0).icon;
                        e.e(TAG, z[23]);
                    } catch (Throwable th) {
                        e.e(TAG, z[14], th);
                        return null;
                    }
                }
            }
            RemoteViews buildContentView = buildContentView(charSequence4, charSequence);
            if (VERSION.SDK_INT >= 11) {
                Builder smallIcon = new Builder(a.e).setContentTitle(charSequence).setContentText(charSequence4).setTicker(charSequence4).setSmallIcon(parseInt);
                if (VERSION.SDK_INT >= 16) {
                    Style bigTextStyle;
                    if (!TextUtils.isEmpty(charSequence2)) {
                        bigTextStyle = new BigTextStyle();
                        bigTextStyle.bigText(charSequence2);
                        smallIcon.setStyle(bigTextStyle);
                    }
                    if (!TextUtils.isEmpty(obj)) {
                        Style inboxStyle = new InboxStyle();
                        try {
                            JSONObject jSONObject = new JSONObject(obj);
                            Iterator keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                inboxStyle.addLine(jSONObject.optString(((String) keys.next()).toString()));
                            }
                            inboxStyle.setSummaryText(new StringBuilder(z[0]).append(jSONObject.length()).append(z[10]).toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        smallIcon.setStyle(inboxStyle);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        e.e(TAG, new StringBuilder(z[3]).append(str2).toString());
                        try {
                            bigTextStyle = new BigPictureStyle();
                            bigTextStyle.bigPicture(BitmapFactory.decodeFile(str2));
                            smallIcon.setStyle(bigTextStyle);
                        } catch (OutOfMemoryError e2) {
                            e.h(TAG, z[4]);
                            e2.printStackTrace();
                        } catch (Exception e3) {
                            e.h(TAG, z[9]);
                            e3.printStackTrace();
                        }
                    }
                    if (i != 0) {
                        if (i == 1) {
                            smallIcon.setPriority(1);
                        } else if (i == 2) {
                            smallIcon.setPriority(2);
                        } else if (i == -1) {
                            smallIcon.setPriority(-1);
                        } else if (i == -2) {
                            smallIcon.setPriority(-2);
                        } else {
                            smallIcon.setPriority(0);
                        }
                    }
                    if (!TextUtils.isEmpty(charSequence3)) {
                        if (VERSION.SDK_INT >= 21) {
                            try {
                                Class.forName(z[7]).getDeclaredMethod(z[1], new Class[]{String.class}).invoke(smallIcon, new Object[]{charSequence3});
                            } catch (ClassNotFoundException e4) {
                                e4.printStackTrace();
                            } catch (NoSuchMethodException e5) {
                                e5.printStackTrace();
                            } catch (Exception e32) {
                                e32.printStackTrace();
                            }
                        } else {
                            e.h(TAG, z[5]);
                        }
                    }
                }
                if (buildContentView != null) {
                    smallIcon.setContent(buildContentView);
                } else {
                    e.e(TAG, z[12]);
                }
                smallIcon.setDefaults(i2);
                return getNotification(smallIcon);
            }
            Notification notification = new Notification(parseInt, charSequence4, System.currentTimeMillis());
            resetNotificationParams(notification);
            notification.defaults = i2;
            if (charSequence == null) {
                charSequence = a.d;
            }
            if (buildContentView != null) {
                notification.contentView = buildContentView;
            } else {
                Context context = a.e;
                try {
                    Class.forName(z[20]).getDeclaredMethod(z[22], new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class}).invoke(notification, new Object[]{context, charSequence, charSequence4, null});
                } catch (Exception e322) {
                    e322.printStackTrace();
                }
            }
            return notification;
        }
        e.g(TAG, z[18]);
        return null;
    }

    public String getDeveloperArg0() {
        return null;
    }

    Notification getNotification(Builder builder) {
        return VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
    }

    void resetNotificationParams(Notification notification) {
    }

    public String toString() {
        return "";
    }
}
