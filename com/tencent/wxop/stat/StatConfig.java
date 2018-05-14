package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.a.a.a.a.g;
import com.tencent.stat.DeviceInfo;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.q;
import java.net.URI;
import java.util.Iterator;
import org.apache.commons.lang.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class StatConfig {
    private static String A = null;
    private static String B;
    private static String C;
    private static String D = "mta_channel";
    private static int E = 180;
    private static int F = 1024;
    private static long G = 0;
    private static long H = CommonUtil.REPORT_ERROR_SLEEP_TIME;
    private static volatile String I = StatConstants.MTA_REPORT_FULL_URL;
    private static int J = 0;
    private static volatile int K = 0;
    private static int L = 20;
    private static int M = 0;
    private static boolean N = false;
    private static int O = 4096;
    private static boolean P = false;
    private static String Q = null;
    private static boolean R = false;
    private static g S = null;
    static f a = new f(2);
    static f b = new f(1);
    static String c = "__HIBERNATE__";
    static String d = "__HIBERNATE__TIME";
    static String e = "__MTA_KILL__";
    static String f = "";
    static boolean g = false;
    static int h = 100;
    static long i = 10000;
    public static boolean isAutoExceptionCaught = true;
    static boolean j = true;
    static volatile String k = "pingma.qq.com:80";
    static boolean l = true;
    static int m = 0;
    static long n = 10000;
    static int o = 512;
    private static StatLogger p = l.b();
    private static StatReportStrategy q = StatReportStrategy.APP_LAUNCH;
    private static boolean r = false;
    private static boolean s = true;
    private static int t = CommonUtil.POST_TIMEOUT;
    private static int u = 100000;
    private static int v = 30;
    private static int w = 10;
    private static int x = 100;
    private static int y = 30;
    private static int z = 1;

    static int a() {
        return v;
    }

    static String a(String str, String str2) {
        try {
            String string = b.b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            p.w("can't find custom key:" + str);
            return str2;
        }
    }

    static synchronized void a(int i) {
        synchronized (StatConfig.class) {
            K = i;
        }
    }

    static void a(long j) {
        q.b(i.a(), c, j);
        setEnableStatService(false);
        p.warn("MTA is disable for current SDK version");
    }

    static void a(Context context, f fVar) {
        if (fVar.a == b.a) {
            b = fVar;
            a(fVar.b);
            if (!b.b.isNull("iplist")) {
                a.a(context).a(b.b.getString("iplist"));
            }
        } else if (fVar.a == a.a) {
            a = fVar;
        }
    }

    static void a(Context context, f fVar, JSONObject jSONObject) {
        Object obj = null;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(str);
                    Object obj2 = fVar.d != i ? 1 : obj;
                    fVar.d = i;
                    obj = obj2;
                } else if (str.equalsIgnoreCase("c")) {
                    str = jSONObject.getString("c");
                    if (str.length() > 0) {
                        fVar.b = new JSONObject(str);
                    }
                } else if (str.equalsIgnoreCase("m")) {
                    fVar.c = jSONObject.getString("m");
                }
            }
            if (obj == 1) {
                au a = au.a(i.a());
                if (a != null) {
                    a.a(fVar);
                }
                if (fVar.a == b.a) {
                    a(fVar.b);
                    b(fVar.b);
                }
            }
            a(context, fVar);
        } catch (Throwable e) {
            p.e(e);
        } catch (Throwable e2) {
            p.e(e2);
        }
    }

    static void a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase(Integer.toString(b.a))) {
                    a(context, b, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase(Integer.toString(a.a))) {
                    a(context, a, jSONObject.getJSONObject(str));
                } else if (str.equalsIgnoreCase("rs")) {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(str));
                    if (statReportStrategy != null) {
                        q = statReportStrategy;
                        if (isDebugEnable()) {
                            p.d("Change to ReportStrategy:" + statReportStrategy.name());
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Throwable e) {
            p.e(e);
        }
    }

    static void a(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                setStatSendStrategy(statReportStrategy);
            }
        } catch (JSONException e) {
            if (isDebugEnable()) {
                p.i("rs not found.");
            }
        }
    }

    static boolean a(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    static boolean a(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (l.c(str2) && l.c(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    static void b() {
        M++;
    }

    static void b(int i) {
        if (i >= 0) {
            M = i;
        }
    }

    static void b(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(e);
            if (l.c(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.length() != 0) {
                    Object obj;
                    if (!jSONObject2.isNull("sm")) {
                        obj = jSONObject2.get("sm");
                        int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof String ? Integer.valueOf((String) obj).intValue() : 0;
                        if (intValue > 0) {
                            if (isDebugEnable()) {
                                p.i("match sleepTime:" + intValue + " minutes");
                            }
                            q.b(context, d, System.currentTimeMillis() + ((long) ((intValue * 60) * 1000)));
                            setEnableStatService(false);
                            p.warn("MTA is disable for current SDK version");
                        }
                    }
                    if (a(jSONObject2, "sv", StatConstants.VERSION)) {
                        p.i("match sdk version:2.0.4");
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (a(jSONObject2, "md", Build.MODEL)) {
                        p.i("match MODEL:" + Build.MODEL);
                        obj = 1;
                    }
                    if (a(jSONObject2, "av", l.h(context))) {
                        p.i("match app version:" + l.h(context));
                        obj = 1;
                    }
                    if (a(jSONObject2, "mf", Build.MANUFACTURER)) {
                        p.i("match MANUFACTURER:" + Build.MANUFACTURER);
                        obj = 1;
                    }
                    if (a(jSONObject2, "osv", VERSION.SDK_INT)) {
                        p.i("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (a(jSONObject2, "ov", VERSION.SDK_INT)) {
                        p.i("match android SDK version:" + VERSION.SDK_INT);
                        obj = 1;
                    }
                    if (a(jSONObject2, DeviceInfo.TAG_IMEI, au.a(context).b(context).b())) {
                        p.i("match imei:" + au.a(context).b(context).b());
                        obj = 1;
                    }
                    if (a(jSONObject2, DeviceInfo.TAG_MID, getLocalMidOnly(context))) {
                        p.i("match mid:" + getLocalMidOnly(context));
                        obj = 1;
                    }
                    if (obj != null) {
                        a(l.b(StatConstants.VERSION));
                    }
                }
            }
        } catch (Throwable e) {
            p.e(e);
        }
    }

    static void b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                b(i.a(), jSONObject);
                String string = jSONObject.getString(c);
                if (isDebugEnable()) {
                    p.d("hibernateVer:" + string + ", current version:2.0.4");
                }
                long b = l.b(string);
                if (l.b(StatConstants.VERSION) <= b) {
                    a(b);
                }
            } catch (JSONException e) {
                p.d("__HIBERNATE__ not found.");
            }
        }
    }

    static int c() {
        return M;
    }

    public static synchronized String getAppKey(Context context) {
        String str;
        synchronized (StatConfig.class) {
            str = B;
        }
        return str;
    }

    public static int getCurSessionStatReportCount() {
        return K;
    }

    public static g getCustomLogger() {
        return S;
    }

    public static String getCustomProperty(String str) {
        try {
            return a.b.getString(str);
        } catch (Throwable th) {
            p.e(th);
            return null;
        }
    }

    public static String getCustomProperty(String str, String str2) {
        try {
            String string = a.b.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            p.e(th);
            return str2;
        }
    }

    public static String getCustomUserId(Context context) {
        if (context == null) {
            p.error((Object) "Context for getCustomUid is null.");
            return null;
        }
        if (Q == null) {
            Q = q.a(context, "MTA_CUSTOM_UID", "");
        }
        return Q;
    }

    public static long getFlushDBSpaceMS() {
        return n;
    }

    public static synchronized String getInstallChannel(Context context) {
        String str;
        synchronized (StatConfig.class) {
            str = C;
        }
        return str;
    }

    public static String getLocalMidOnly(Context context) {
        return context != null ? g.C(context).p().a() : "0";
    }

    public static int getMaxBatchReportCount() {
        return y;
    }

    public static int getMaxDaySessionNumbers() {
        return L;
    }

    public static int getMaxImportantDataSendRetryCount() {
        return x;
    }

    public static int getMaxParallelTimmingEvents() {
        return F;
    }

    public static int getMaxReportEventLength() {
        return O;
    }

    public static int getMaxSendRetryCount() {
        return w;
    }

    public static int getMaxSessionStatReportCount() {
        return J;
    }

    public static int getMaxStoreEventCount() {
        return u;
    }

    public static String getMid(Context context) {
        return getLocalMidOnly(context);
    }

    public static long getMsPeriodForMethodsCalledLimitClear() {
        return i;
    }

    public static int getNumEventsCachedInMemory() {
        return m;
    }

    public static int getNumEventsCommitPerSec() {
        return z;
    }

    public static int getNumOfMethodsCalledLimit() {
        return h;
    }

    public static String getQQ(Context context) {
        return q.a(context, "mta.acc.qq", f);
    }

    public static int getReportCompressedSize() {
        return o;
    }

    public static int getSendPeriodMinutes() {
        return E;
    }

    public static int getSessionTimoutMillis() {
        return t;
    }

    public static String getStatReportHost() {
        return k;
    }

    public static String getStatReportUrl() {
        return I;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return q;
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    public static boolean isDebugEnable() {
        return r;
    }

    public static boolean isEnableConcurrentProcess() {
        return P;
    }

    public static boolean isEnableSmartReporting() {
        return j;
    }

    public static boolean isEnableStatService() {
        return s;
    }

    public static boolean isReportEventsByOrder() {
        return l;
    }

    public static boolean isXGProMode() {
        return R;
    }

    public static void setAppKey(Context context, String str) {
        if (context == null) {
            p.error((Object) "ctx in StatConfig.setAppKey() is null");
        } else if (str == null || str.length() > 256) {
            p.error((Object) "appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
        } else {
            B = str;
        }
    }

    public static void setAppKey(String str) {
        if (str == null) {
            p.error((Object) "appkey in StatConfig.setAppKey() is null");
        } else if (str.length() > 256) {
            p.error((Object) "The length of appkey cann't exceed 256 bytes.");
        } else {
            B = str;
        }
    }

    public static void setAutoExceptionCaught(boolean z) {
        isAutoExceptionCaught = z;
    }

    public static void setCustomLogger(g gVar) {
        S = gVar;
    }

    public static void setCustomUserId(Context context, String str) {
        if (context == null) {
            p.error((Object) "Context for setCustomUid is null.");
            return;
        }
        q.b(context, "MTA_CUSTOM_UID", str);
        Q = str;
    }

    public static void setDebugEnable(boolean z) {
        r = z;
        l.b().setDebugEnable(z);
    }

    public static void setEnableConcurrentProcess(boolean z) {
        P = z;
    }

    public static void setEnableSmartReporting(boolean z) {
        j = z;
    }

    public static void setEnableStatService(boolean z) {
        s = z;
        if (!z) {
            p.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static void setFlushDBSpaceMS(long j) {
        if (j > 0) {
            n = j;
        }
    }

    public static void setInstallChannel(Context context, String str) {
        if (str.length() > 128) {
            p.error((Object) "the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            C = str;
        }
    }

    public static void setInstallChannel(String str) {
        C = str;
    }

    public static void setMaxBatchReportCount(int i) {
        if (a(i, 2, 1000)) {
            y = i;
        } else {
            p.error((Object) "setMaxBatchReportCount can not exceed the range of [2,1000].");
        }
    }

    public static void setMaxDaySessionNumbers(int i) {
        if (i <= 0) {
            p.e((Object) "maxDaySessionNumbers must be greater than 0.");
        } else {
            L = i;
        }
    }

    public static void setMaxImportantDataSendRetryCount(int i) {
        if (i > 100) {
            x = i;
        }
    }

    public static void setMaxParallelTimmingEvents(int i) {
        if (a(i, 1, 4096)) {
            F = i;
        } else {
            p.error((Object) "setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        }
    }

    public static void setMaxReportEventLength(int i) {
        if (i <= 0) {
            p.error((Object) "maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            O = i;
        }
    }

    public static void setMaxSendRetryCount(int i) {
        if (a(i, 1, 1000)) {
            w = i;
        } else {
            p.error((Object) "setMaxSendRetryCount can not exceed the range of [1,1000].");
        }
    }

    public static void setMaxSessionStatReportCount(int i) {
        if (i < 0) {
            p.error((Object) "maxSessionStatReportCount cannot be less than 0.");
        } else {
            J = i;
        }
    }

    public static void setMaxStoreEventCount(int i) {
        if (a(i, 0, 500000)) {
            u = i;
        } else {
            p.error((Object) "setMaxStoreEventCount can not exceed the range of [0, 500000].");
        }
    }

    public static void setNumEventsCachedInMemory(int i) {
        if (i >= 0) {
            m = i;
        }
    }

    public static void setNumEventsCommitPerSec(int i) {
        if (i > 0) {
            z = i;
        }
    }

    public static void setNumOfMethodsCalledLimit(int i, long j) {
        h = i;
        if (j >= 1000) {
            i = j;
        }
    }

    public static void setQQ(Context context, String str) {
        q.b(context, "mta.acc.qq", str);
        f = str;
    }

    public static void setReportCompressedSize(int i) {
        if (i > 0) {
            o = i;
        }
    }

    public static void setReportEventsByOrder(boolean z) {
        l = z;
    }

    public static void setSendPeriodMinutes(int i) {
        if (a(i, 1, 10080)) {
            E = i;
        } else {
            p.error((Object) "setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }

    public static void setSessionTimoutMillis(int i) {
        if (a(i, 1000, (int) DateUtils.MILLIS_IN_DAY)) {
            t = i;
        } else {
            p.error((Object) "setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        }
    }

    public static void setStatReportUrl(String str) {
        if (str == null || str.length() == 0) {
            p.error((Object) "statReportUrl cannot be null or empty.");
            return;
        }
        I = str;
        try {
            k = new URI(I).getHost();
        } catch (Exception e) {
            p.w(e);
        }
        if (isDebugEnable()) {
            p.i("url:" + I + ", domain:" + k);
        }
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        q = statReportStrategy;
        if (statReportStrategy != StatReportStrategy.PERIOD) {
            StatServiceImpl.c = 0;
        }
        if (isDebugEnable()) {
            p.d("Change to statSendStrategy: " + statReportStrategy);
        }
    }

    public static void setXGProMode(boolean z) {
        R = z;
    }
}
