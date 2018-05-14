package com.tencent.wxop.stat.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import cn.jiguang.net.HttpUtils;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class l {
    private static String a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static Random e = null;
    private static DisplayMetrics f = null;
    private static String g = null;
    private static String h = "";
    private static String i = "";
    private static int j = -1;
    private static StatLogger k = null;
    private static String l = null;
    private static String m = null;
    private static volatile int n = -1;
    private static String o = null;
    private static String p = null;
    private static long q = -1;
    private static String r = "";
    private static o s = null;
    private static String t = "__MTA_FIRST_ACTIVATE__";
    private static int u = -1;
    private static long v = -1;
    private static int w = 0;
    private static String x = "";

    public static String A(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) ? null : resolveActivity.activityInfo.packageName;
    }

    private static long B(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static int a() {
        return g().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static int a(Context context, boolean z) {
        if (z) {
            w = y(context);
        }
        return w;
    }

    public static Long a(String str, String str2, int i, int i2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != i2) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i3 = 0;
            while (i3 < split.length) {
                Long valueOf2 = Long.valueOf(((long) i) * (valueOf.longValue() + Long.valueOf(split[i3]).longValue()));
                i3++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    public static String a(int i) {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, i);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static String a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String a(Context context, String str) {
        if (!StatConfig.isEnableConcurrentProcess()) {
            return str;
        }
        if (m == null) {
            m = o(context);
        }
        return m != null ? str + "_" + m : str;
    }

    public static String a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "0";
        }
    }

    public static HttpHost a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                return new HttpHost("10.0.0.172", 80);
            }
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            k.e(th);
        }
    }

    public static void a(Context context, int i) {
        w = i;
        q.b(context, "mta.qq.com.difftime", i);
    }

    public static boolean a(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        return statSpecifyReportedInfo == null ? false : c(statSpecifyReportedInfo.getAppKey());
    }

    public static byte[] a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            }
        }
    }

    public static long b(String str) {
        return a(str, ".", 100, 3, Long.valueOf(0)).longValue();
    }

    public static synchronized StatLogger b() {
        StatLogger statLogger;
        synchronized (l.class) {
            if (k == null) {
                statLogger = new StatLogger(StatConstants.LOG_TAG);
                k = statLogger;
                statLogger.setDebugEnable(false);
            }
            statLogger = k;
        }
        return statLogger;
    }

    public static synchronized String b(Context context) {
        String a;
        synchronized (l.class) {
            if (a == null || a.trim().length() == 0) {
                a = r.a(context);
                a = a;
                if (a == null || a.trim().length() == 0) {
                    a = Integer.toString(g().nextInt(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
                }
                a = a;
            } else {
                a = a;
            }
        }
        return a;
    }

    public static long c() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            k.e(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static synchronized String c(Context context) {
        String str;
        synchronized (l.class) {
            if (c == null || c.trim().length() == 0) {
                c = r.b(context);
            }
            str = c;
        }
        return str;
    }

    public static boolean c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static DisplayMetrics d(Context context) {
        if (f == null) {
            f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f);
        }
        return f;
    }

    public static String d() {
        if (c(p)) {
            return p;
        }
        long e = e() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + HttpUtils.PATHS_SEPARATOR + String.valueOf(e);
        p = str;
        return str;
    }

    public static long e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static boolean e(Context context) {
        try {
            if (r.a(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            k.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            k.e(th);
        }
    }

    public static String f(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    public static String g(Context context) {
        if (g != null) {
            return g;
        }
        try {
            if (!r.a(context, "android.permission.READ_PHONE_STATE")) {
                k.e((Object) "Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (i(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    g = telephonyManager.getSimOperator();
                }
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return g;
    }

    private static synchronized Random g() {
        Random random;
        synchronized (l.class) {
            if (e == null) {
                e = new Random();
            }
            random = e;
        }
        return random;
    }

    private static long h() {
        if (q > 0) {
            return q;
        }
        long j = 1;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
        } catch (Exception e) {
        }
        q = j;
        return j;
    }

    public static String h(Context context) {
        if (c(h)) {
            return h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            h = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return h;
    }

    public static boolean i(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static String j(Context context) {
        String str = "";
        try {
            if (r.a(context, "android.permission.INTERNET") && r.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                String typeName;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo != null) {
                                return extraInfo;
                            }
                            return typeName;
                        }
                    }
                }
                typeName = str;
                return typeName;
            }
            k.e((Object) "can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            k.e(th);
            return str;
        }
    }

    public static Integer k(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String l(Context context) {
        if (c(i)) {
            return i;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            i = str;
            if (str == null || i.length() == 0) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return i;
    }

    public static int m(Context context) {
        if (j != -1) {
            return j;
        }
        try {
            if (p.a()) {
                j = 1;
            }
        } catch (Throwable th) {
            k.e(th);
        }
        j = 0;
        return 0;
    }

    public static String n(Context context) {
        if (c(l)) {
            return l;
        }
        try {
            if (r.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        externalStorageState = String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + HttpUtils.PATHS_SEPARATOR + String.valueOf(blockCount);
                        l = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            k.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            k.e(th);
        }
    }

    static String o(Context context) {
        try {
            if (m != null) {
                return m;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    m = runningAppProcessInfo.processName;
                    break;
                }
            }
            return m;
        } catch (Throwable th) {
        }
    }

    public static String p(Context context) {
        return a(context, StatConstants.DATABASE_NAME);
    }

    public static synchronized Integer q(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (l.class) {
            if (n <= 0) {
                n = q.a(context, "MTA_EVENT_INDEX", 0);
                q.b(context, "MTA_EVENT_INDEX", n + 1000);
            } else if (n % 1000 == 0) {
                try {
                    int i2 = n + 1000;
                    if (n < 2147383647) {
                        i = i2;
                    }
                    q.b(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    k.w(th);
                }
            }
            i = n + 1;
            n = i;
            valueOf = Integer.valueOf(i);
        }
        return valueOf;
    }

    public static String r(Context context) {
        try {
            return String.valueOf(B(context) / 1000000) + HttpUtils.PATHS_SEPARATOR + String.valueOf(h() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static JSONObject s(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("n", m.a());
            String d = m.d();
            if (d != null && d.length() > 0) {
                jSONObject.put("na", d);
            }
            int b = m.b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            b = m.c();
            if (b > 0) {
                jSONObject.put("fn", b / 1000000);
            }
        } catch (Throwable th) {
            Log.w(StatConstants.LOG_TAG, "get cpu error", th);
        }
        return jSONObject;
    }

    public static String t(Context context) {
        if (c(r)) {
            return r;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(",");
                        }
                    }
                    r = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return r;
    }

    public static synchronized int u(Context context) {
        int i;
        synchronized (l.class) {
            if (u != -1) {
                i = u;
            } else {
                v(context);
                i = u;
            }
        }
        return i;
    }

    public static void v(Context context) {
        int a = q.a(context, t, 1);
        u = a;
        if (a == 1) {
            q.b(context, t, 0);
        }
    }

    public static boolean w(Context context) {
        if (v < 0) {
            v = q.a(context, "mta.qq.com.checktime", 0);
        }
        return Math.abs(System.currentTimeMillis() - v) > 86400000;
    }

    public static void x(Context context) {
        v = System.currentTimeMillis();
        q.b(context, "mta.qq.com.checktime", v);
    }

    public static int y(Context context) {
        return q.a(context, "mta.qq.com.difftime", 0);
    }

    public static boolean z(Context context) {
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.startsWith(packageName)) {
                return runningAppProcessInfo.importance == 400;
            }
        }
        return false;
    }
}
