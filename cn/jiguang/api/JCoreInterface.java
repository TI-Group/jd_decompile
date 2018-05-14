package cn.jiguang.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import cn.jiguang.a.a.c.e;
import cn.jiguang.a.a.d.a.a.c;
import cn.jiguang.b.a.d;
import cn.jiguang.b.b.b;
import cn.jiguang.b.d.m;
import cn.jiguang.b.d.o;
import cn.jiguang.e.a.a;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class JCoreInterface {
    public static String a;
    private static boolean b = false;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 27;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "y`\u0014/}za";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
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
            case 0: goto L_0x016c;
            case 1: goto L_0x0170;
            case 2: goto L_0x0173;
            case 3: goto L_0x0177;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 4;
    L_0x001f:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002b;
    L_0x0027:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0017;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0012;
    L_0x002f:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004b;
            case 2: goto L_0x0053;
            case 3: goto L_0x005b;
            case 4: goto L_0x0063;
            case 5: goto L_0x006b;
            case 6: goto L_0x0073;
            case 7: goto L_0x007c;
            case 8: goto L_0x0086;
            case 9: goto L_0x0091;
            case 10: goto L_0x009c;
            case 11: goto L_0x00a7;
            case 12: goto L_0x00b2;
            case 13: goto L_0x00bd;
            case 14: goto L_0x00c8;
            case 15: goto L_0x00d3;
            case 16: goto L_0x00de;
            case 17: goto L_0x00e9;
            case 18: goto L_0x00f4;
            case 19: goto L_0x00ff;
            case 20: goto L_0x010a;
            case 21: goto L_0x0115;
            case 22: goto L_0x0120;
            case 23: goto L_0x012b;
            case 24: goto L_0x0136;
            case 25: goto L_0x0141;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "xq\u0011ueip\u00164j";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "j\u001a#got\u000b>`*)_8kdp\u001a#p*s\u001e($dq\u00137";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "@G\u0010)a*m\u00112p*b\u001e2ho`";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "@G\u0010)aCj\u000b>vle\u001c>";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "ya\u0011?vou\n>w~`\u001e/e$e\u001c/mej";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "ne\u000b:w";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "~m\u0012>kp";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "kg\u000b2kd$R{wop66HHW:5ehh\u001avgej\u000b)kf";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        r2 = 9;
        r1 = "*t\u0010)p0";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0086:
        r3[r2] = r1;
        r2 = 10;
        r1 = "Kg\u000b2kd$R{wop+>w~G\u00105jCT/4v~$\u0016+>";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0091:
        r3[r2] = r1;
        r2 = 11;
        r1 = "ijQ1tw\u0017ued`\r4mn*\u00165poj\u000buMDM+";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009c:
        r3[r2] = r1;
        r2 = 12;
        r1 = "Kg\u000b2kd$R{mdm\u000b{voc\u0016(pov05hs>";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a7:
        r3[r2] = r1;
        r2 = 13;
        r1 = "ijQ1tw\u0017ued`\r4mn*\u00165poj\u000buVOW+\u0014VOT*\bL";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b2:
        r3[r2] = r1;
        r2 = 14;
        r1 = "ijQ1tw\u0017ued`\r4mn*\u00165poj\u000buW^K/\u000bQYL";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00bd:
        r3[r2] = r1;
        r2 = 15;
        r1 = "ya\u0011?`kp\u001eueip\u00164j";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c8:
        r3[r2] = r1;
        r2 = 16;
        r1 = "ii\u001b";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d3:
        r3[r2] = r1;
        r2 = 17;
        r1 = "kj\u001b)kc`Q+axi\u0016(wck\u0011uVOE;\u0004ARP:\tJKH \bPEV>\u001cA";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00de:
        r3[r2] = r1;
        r2 = 18;
        r1 = "kj\u001b)kc`Q+axi\u0016(wck\u0011uSXM+\u001e[O\\+\u001eVDE3\u0004W^K-\u001aCO";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00e9:
        r3[r2] = r1;
        r2 = 19;
        r1 = "kj\u001b)kc`Q:tz*>8pcr\u0016/}";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f4:
        r3[r2] = r1;
        r2 = 20;
        r1 = "fe\u001c0Tov\u00122wym\u00105w0";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x00ff:
        r3[r2] = r1;
        r2 = 21;
        r1 = "xa\u000e.ayp/>vgm\f(mej\f";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010a:
        r3[r2] = r1;
        r2 = 22;
        r1 = "Qv\u001a*qow\u000b\u000baxi\u0016(wck\u0011\u0006$ik\u0011/arp_,ey$\u0011.hf";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0115:
        r3[r2] = r1;
        r2 = 23;
        r1 = "kj\u001b)kc`Q+axi\u0016(wck\u0011uEIG:\bWUB6\u0015AUH0\u0018E^M0\u0015";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0120:
        r3[r2] = r1;
        r2 = 24;
        r1 = "kj\u001b)kc`Q+axi\u0016(wck\u0011uVOE;\u0004TBK1\u001e[YP>\u000fA";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012b:
        r3[r2] = r1;
        r2 = 25;
        r1 = ")q\u0011>|ia\u000f/an$R{vou\n>w~T\u001a)icw\f2kd$\u001aa";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0136:
        r3[r2] = r1;
        r2 = 26;
        r1 = "Qv\u001a*qow\u000b\u000baxi\u0016(wck\u0011\u0006$ik\u0011/arp_6qyp_2jyp\u001e5gok\u0019{Eip\u0016-m~}";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0141:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        b = r0;
        r0 = "ijQ1tw\u0017ued`\r4mn*\u00165poj\u000bu@ka\u00124jYa\r-mia";
        r0 = r0.toCharArray();
        r1 = r0.length;
        r2 = 0;
        r3 = 1;
        if (r1 > r3) goto L_0x0188;
    L_0x0153:
        r3 = r0;
        r4 = r2;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x0158:
        r6 = r1[r2];
        r5 = r4 % 5;
        switch(r5) {
            case 0: goto L_0x017b;
            case 1: goto L_0x017e;
            case 2: goto L_0x0180;
            case 3: goto L_0x0183;
            default: goto L_0x015f;
        };
    L_0x015f:
        r5 = 4;
    L_0x0160:
        r5 = r5 ^ r6;
        r5 = (char) r5;
        r1[r2] = r5;
        r2 = r4 + 1;
        if (r0 != 0) goto L_0x0186;
    L_0x0168:
        r1 = r3;
        r4 = r2;
        r2 = r0;
        goto L_0x0158;
    L_0x016c:
        r9 = 10;
        goto L_0x001f;
    L_0x0170:
        r9 = 4;
        goto L_0x001f;
    L_0x0173:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x001f;
    L_0x0177:
        r9 = 91;
        goto L_0x001f;
    L_0x017b:
        r5 = 10;
        goto L_0x0160;
    L_0x017e:
        r5 = 4;
        goto L_0x0160;
    L_0x0180:
        r5 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x0160;
    L_0x0183:
        r5 = 91;
        goto L_0x0160;
    L_0x0186:
        r1 = r0;
        r0 = r3;
    L_0x0188:
        if (r1 > r2) goto L_0x0153;
    L_0x018a:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1.intern();
        a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.JCoreInterface.<clinit>():void");
    }

    public static boolean canCallDirect() {
        return a.c();
    }

    public static boolean getAesConfig() {
        return true;
    }

    public static String getAppKey() {
        return d.i(null);
    }

    public static IBinder getBinderByType(String str, String str2) {
        if (a.c()) {
            try {
                return a.b().a(str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getChannel() {
        return !b ? null : cn.jiguang.b.a.a.d("");
    }

    public static String getCommonConfigAppkey() {
        return !b ? "" : d.i(null);
    }

    public static boolean getConnectionState(Context context) {
        return init(context, false) && cn.jiguang.b.b.a.a == d.j(context);
    }

    public static String getDaemonAction() {
        return a;
    }

    public static boolean getDebugMode() {
        return cn.jiguang.b.a.b;
    }

    public static String getDeviceId(Context context) {
        return !cn.jiguang.b.a.a(context) ? "" : cn.jiguang.e.a.g(context);
    }

    public static String getHttpConfig(Context context, String str) {
        if (!cn.jiguang.b.a.a(context)) {
            return "";
        }
        HttpResponse httpGet = HttpUtils.httpGet(null, o.c(str));
        return (httpGet == null || httpGet.getResponseCode() != 200) ? null : httpGet.getResponseBody();
    }

    public static int getJCoreSDKVersionInt() {
        return 116;
    }

    public static long getNextRid() {
        return !b ? 0 : cn.jiguang.b.a.a.g();
    }

    public static String getRegistrationID(Context context) {
        return !init(context, false) ? "" : d.c(context);
    }

    public static long getReportTime() {
        return !b ? System.currentTimeMillis() / 1000 : cn.jiguang.b.a.a.q();
    }

    public static boolean getRuningFlag() {
        return b.a();
    }

    public static int getSid() {
        return !b ? 0 : d.a();
    }

    public static boolean getTestConn() {
        return cn.jiguang.b.a.a.c;
    }

    public static long getUid() {
        return !b ? 0 : d.e(null);
    }

    public static boolean init(Context context, boolean z) {
        if (b) {
            return true;
        }
        if (context == null) {
            cn.jiguang.c.d.h(z[4], z[2]);
            return false;
        }
        cn.jiguang.a.a.d.a.a.a().a(context);
        if (cn.jiguang.b.a.a(context)) {
            b = true;
            return true;
        }
        cn.jiguang.c.d.h(z[4], z[3]);
        return false;
    }

    public static void initAction(String str, Class<? extends JAction> cls) {
        cn.jiguang.b.d.b.a(str, cls.getName());
    }

    public static void initActionExtra(String str, Class<? extends JActionExtra> cls) {
        cn.jiguang.b.d.b.b(str, cls.getName());
    }

    public static void initCrashHandler(Context context) {
        if (cn.jiguang.b.a.a(context)) {
            e.a().b(context);
        }
    }

    public static boolean isServiceStoped(Context context) {
        return d.k(context);
    }

    public static boolean isTcpConnected() {
        return d.d();
    }

    public static boolean isValidRegistered() {
        return d.f(null);
    }

    public static void onFragmentPause(Context context, String str) {
        if (cn.jiguang.b.a.a(context)) {
            cn.jiguang.a.a.d.b.a().b(context, str);
        }
    }

    public static void onFragmentResume(Context context, String str) {
        if (cn.jiguang.b.a.a(context)) {
            cn.jiguang.a.a.d.b.a().a(context, str);
        }
    }

    public static void onKillProcess(Context context) {
        if (cn.jiguang.b.a.a(context)) {
            cn.jiguang.a.a.d.b.a().c(context);
        }
    }

    public static void onPause(Context context) {
        if (cn.jiguang.b.a.a(context) && c.a) {
            cn.jiguang.a.a.d.b.a().b(context);
        }
    }

    public static void onResume(Context context) {
        if (cn.jiguang.b.a.a(context) && c.a) {
            cn.jiguang.a.a.d.b.a().a(context);
        }
    }

    public static void processCtrlReport(int i) {
        cn.jiguang.a.c.a.a(i);
    }

    public static void register(Context context) {
        if (init(context, true)) {
            cn.jiguang.c.d.c(z[4], z[12]);
            m.a().b(context, z[11], new Bundle());
        }
    }

    public static boolean reportHttpData(Context context, Object obj, String str) {
        if (obj != null) {
            if (obj instanceof JSONObject) {
                o.a(context, (JSONObject) obj, str);
            } else if (obj instanceof JSONArray) {
                o.a(context, (JSONArray) obj, str);
            }
        }
        return true;
    }

    public static void requestPermission(Context context) {
        if (context == null) {
            cn.jiguang.c.d.h(z[4], z[22]);
        } else if (!(context instanceof Activity)) {
            cn.jiguang.c.d.h(z[4], z[26]);
        } else if (VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                List a = cn.jiguang.e.a.a(context, new String[]{z[18], z[17], z[23], z[24]});
                if (a != null && !a.isEmpty()) {
                    cn.jiguang.c.d.a(z[4], new StringBuilder(z[20]).append(a).toString());
                    Class.forName(z[19]).getDeclaredMethod(z[21], new Class[]{String[].class, Integer.TYPE}).invoke(context, new Object[]{a.toArray(new String[a.size()]), Integer.valueOf(1)});
                }
            } catch (Exception e) {
                cn.jiguang.c.d.h(z[4], new StringBuilder(z[25]).append(e.getMessage()).toString());
            }
        }
    }

    public static void restart(Context context, String str, Bundle bundle, boolean z) {
        if (context == null) {
            cn.jiguang.c.d.h(z[4], z[2]);
        } else if (init(context, false)) {
            bundle.putString(z[0], str);
            m.a().b(context, z ? z[13] : z[11], bundle);
        }
    }

    public static void sendAction(Context context, String str, Bundle bundle) {
        if (cn.jiguang.b.a.a(context)) {
            bundle.putString(z[0], str);
            m.a().b(context, z[1], bundle);
        }
    }

    public static void sendData(Context context, String str, int i, byte[] bArr) {
        if (init(context, false)) {
            Bundle bundle = new Bundle();
            bundle.putString(z[0], str);
            bundle.putByteArray(z[6], bArr);
            bundle.putInt(z[16], i);
            m.a().b(context, z[15], bundle);
        }
    }

    public static void sendRequestData(Context context, String str, int i, byte[] bArr) {
        if (init(context, false)) {
            Bundle bundle = new Bundle();
            bundle.putString(z[0], str);
            bundle.putByteArray(z[6], bArr);
            bundle.putInt(z[7], i);
            m.a().b(context, z[5], bundle);
        }
    }

    public static void setAnalysisAction(JAnalyticsAction jAnalyticsAction) {
        if (jAnalyticsAction != null) {
            cn.jiguang.a.a.a = jAnalyticsAction;
        }
    }

    public static void setCanLaunchedStoppedService(boolean z) {
        cn.jiguang.b.a.j = z;
    }

    public static void setDaemonAction(String str) {
        a = str;
    }

    public static void setDebugMode(boolean z) {
        cn.jiguang.b.a.b = z;
    }

    public static void setImLBSEnable(Context context, boolean z) {
        cn.jiguang.c.d.c(z[4], z[8]);
        if (cn.jiguang.b.a.a(context)) {
            cn.jiguang.a.b.a.a(context, z);
        }
    }

    public static void setLogEnable(boolean z) {
        BaseLogger.a = z;
    }

    public static void setTestConn(boolean z) {
        cn.jiguang.b.a.a.c = z;
    }

    public static void setTestConnIPPort(String str, int i) {
        cn.jiguang.c.d.c(z[4], new StringBuilder(z[10]).append(str).append(z[9]).append(i).toString());
        cn.jiguang.b.a.a.a = str;
        cn.jiguang.b.a.a.b = i;
    }

    public static void stop(Context context, String str, Bundle bundle) {
        if (init(context, false)) {
            bundle.putString(z[0], str);
            m.a().b(context, z[14], bundle);
        }
    }

    public static void stopCrashHandler(Context context) {
        if (cn.jiguang.b.a.a(context)) {
            e.a().c(context);
        }
    }
}
