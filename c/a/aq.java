package c.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.b.a.d;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Locale;
import jd.wjlogin_sdk.util.NetworkType;
import org.apache.commons.lang.time.DateUtils;

/* compiled from: TbsSdkJava */
public class aq {
    protected static final String a = aq.class.getName();

    public static String a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (VERSION.SDK_INT >= 23) {
            try {
                boolean z;
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } catch (Exception e) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static String b() {
        int i = 0;
        if (d.a) {
            String[] strArr = new String[]{"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
            while (i < strArr.length) {
                try {
                    String a = a(strArr[i]);
                    if (a != null) {
                        return a;
                    }
                    i++;
                } catch (Throwable e) {
                    as.d(a, "open file  Failed", e);
                }
            }
        }
        return null;
    }

    private static String a(String str) throws FileNotFoundException {
        Throwable e;
        Throwable th;
        String str2 = null;
        Reader fileReader = new FileReader(str);
        if (fileReader != null) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(fileReader, 1024);
                try {
                    str2 = bufferedReader.readLine();
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        as.d(a, "Could not read from file " + str, e);
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2222) {
                                e2222.printStackTrace();
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e22222) {
                                e22222.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e222222) {
                                e222222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = str2;
                as.d(a, "Could not read from file " + str, e);
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return str2;
            } catch (Throwable e5) {
                bufferedReader = str2;
                th = e5;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        return str2;
    }

    public static String a() {
        Throwable th;
        String str;
        Throwable th2;
        String str2 = null;
        try {
            Reader fileReader = new FileReader("/proc/cpuinfo");
            if (fileReader != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                    str2 = bufferedReader.readLine();
                    bufferedReader.close();
                    fileReader.close();
                } catch (Throwable e) {
                    try {
                        as.d(a, "Could not read from file /proc/cpuinfo", e);
                    } catch (Throwable e2) {
                        th = e2;
                        str = str2;
                        th2 = th;
                        as.d(a, "Could not open file /proc/cpuinfo", th2);
                        str2 = str;
                        if (str2 != null) {
                            return "";
                        }
                        return str2.substring(str2.indexOf(58) + 1).trim();
                    }
                }
            }
        } catch (Throwable e22) {
            th = e22;
            str = str2;
            th2 = th;
            as.d(a, "Could not open file /proc/cpuinfo", th2);
            str2 = str;
            if (str2 != null) {
                return str2.substring(str2.indexOf(58) + 1).trim();
            }
            return "";
        }
        if (str2 != null) {
            return str2.substring(str2.indexOf(58) + 1).trim();
        }
        return "";
    }

    public static String c(Context context) {
        String deviceId;
        Throwable e;
        CharSequence charSequence = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (VERSION.SDK_INT >= 23) {
            try {
                if (a(context, "android.permission.READ_PHONE_STATE")) {
                    deviceId = telephonyManager.getDeviceId();
                    try {
                        as.a(a, "getDeviceId, IMEI: " + deviceId);
                    } catch (Exception e2) {
                        e = e2;
                        as.c(a, "No IMEI.", e);
                        if (TextUtils.isEmpty(deviceId)) {
                            return deviceId;
                        }
                        deviceId = b();
                        as.a(a, "getDeviceId, mc: " + deviceId);
                        if (TextUtils.isEmpty(deviceId)) {
                            return deviceId;
                        }
                        deviceId = Secure.getString(context.getContentResolver(), "android_id");
                        as.a(a, "getDeviceId, android_id: " + deviceId);
                        if (TextUtils.isEmpty(deviceId)) {
                            return deviceId;
                        }
                        if (VERSION.SDK_INT >= 9) {
                            deviceId = Build.SERIAL;
                        }
                        as.a(a, "getDeviceId, serial no: " + deviceId);
                        return deviceId;
                    }
                }
                CharSequence charSequence2 = charSequence;
            } catch (Throwable e3) {
                Throwable th = e3;
                deviceId = charSequence;
                e = th;
                as.c(a, "No IMEI.", e);
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                deviceId = b();
                as.a(a, "getDeviceId, mc: " + deviceId);
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                deviceId = Secure.getString(context.getContentResolver(), "android_id");
                as.a(a, "getDeviceId, android_id: " + deviceId);
                if (TextUtils.isEmpty(deviceId)) {
                    return deviceId;
                }
                if (VERSION.SDK_INT >= 9) {
                    deviceId = Build.SERIAL;
                }
                as.a(a, "getDeviceId, serial no: " + deviceId);
                return deviceId;
            }
            if (TextUtils.isEmpty(deviceId)) {
                return deviceId;
            }
            deviceId = b();
            as.a(a, "getDeviceId, mc: " + deviceId);
            if (TextUtils.isEmpty(deviceId)) {
                return deviceId;
            }
            deviceId = Secure.getString(context.getContentResolver(), "android_id");
            as.a(a, "getDeviceId, android_id: " + deviceId);
            if (TextUtils.isEmpty(deviceId)) {
                return deviceId;
            }
            if (VERSION.SDK_INT >= 9) {
                deviceId = Build.SERIAL;
            }
            as.a(a, "getDeviceId, serial no: " + deviceId);
            return deviceId;
        }
        if (telephonyManager == null) {
            as.c(a, "No IMEI.");
        }
        try {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                charSequence = telephonyManager.getDeviceId();
            }
        } catch (Throwable e32) {
            as.c(a, "No IMEI.", e32);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        as.c(a, "No IMEI.");
        deviceId = k(context);
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        as.c(a, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
        deviceId = Secure.getString(context.getContentResolver(), "android_id");
        as.a(a, "getDeviceId: Secure.ANDROID_ID: " + deviceId);
        return deviceId;
    }

    public static String d(Context context) {
        return ar.b(c(context));
    }

    public static String[] e(Context context) {
        String[] strArr = new String[]{"", ""};
        try {
            if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    strArr[0] = "";
                    return strArr;
                } else if (connectivityManager.getNetworkInfo(1).getState() == State.CONNECTED) {
                    strArr[0] = "Wi-Fi";
                    return strArr;
                } else {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                    if (networkInfo.getState() == State.CONNECTED) {
                        strArr[0] = "2G/3G";
                        strArr[1] = networkInfo.getSubtypeName();
                        return strArr;
                    }
                    return strArr;
                }
            }
            strArr[0] = "";
            return strArr;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean f(Context context) {
        return "Wi-Fi".equals(e(context)[0]);
    }

    public static boolean g(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static int h(Context context) {
        try {
            Calendar instance = Calendar.getInstance(s(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / DateUtils.MILLIS_IN_HOUR;
            }
        } catch (Throwable e) {
            as.b(a, "error in getTimeZone", e);
        }
        return 8;
    }

    public static String[] i(Context context) {
        String[] strArr = new String[2];
        try {
            Locale s = s(context);
            if (s != null) {
                strArr[0] = s.getCountry();
                strArr[1] = s.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
        } catch (Throwable e) {
            as.d(a, "error in getLocaleInfo", e);
        }
        return strArr;
    }

    private static Locale s(Context context) {
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Exception e) {
            as.b(a, "fail to read user config locale");
        }
        if (locale == null) {
            return Locale.getDefault();
        }
        return locale;
    }

    public static String j(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                if (string != null) {
                    return string.trim();
                }
                as.b(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Throwable e) {
            as.d(a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", e);
        }
        return null;
    }

    public static String k(Context context) {
        if (VERSION.SDK_INT < 23) {
            return t(context);
        }
        String b = b();
        if (b == null) {
            return t(context);
        }
        return b;
    }

    private static String t(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkType.WIFI_STRING);
            if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            as.c(a, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            return "";
        } catch (Exception e) {
            as.c(a, "Could not get mac address." + e.toString());
            return "";
        }
    }

    public static int[] l(Context context) {
        try {
            int a;
            int a2;
            int i;
            Object displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                a = a(displayMetrics, "noncompatWidthPixels");
                a2 = a(displayMetrics, "noncompatHeightPixels");
            } else {
                a2 = -1;
                a = -1;
            }
            if (a == -1 || a2 == -1) {
                i = displayMetrics.widthPixels;
                a = displayMetrics.heightPixels;
            } else {
                i = a;
                a = a2;
            }
            int[] iArr = new int[2];
            if (i > a) {
                iArr[0] = a;
                iArr[1] = i;
                return iArr;
            }
            iArr[0] = i;
            iArr[1] = a;
            return iArr;
        } catch (Throwable e) {
            as.d(a, "read resolution fail", e);
            return null;
        }
    }

    private static int a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String m(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Throwable e) {
            as.b(a, "read carrier fail", e);
            return "Unknown";
        }
    }

    public static String n(Context context) {
        String str = "Unknown";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("UMENG_CHANNEL");
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (obj2 != null) {
                        return obj2;
                    }
                    as.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
                }
            }
        } catch (Exception e) {
            as.a(a, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            e.printStackTrace();
        }
        return str;
    }

    public static String o(Context context) {
        return context.getPackageName();
    }

    public static String p(Context context) {
        PackageInfo packageInfo;
        String str = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(o(context), 64);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            Object obj = str;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X509");
        } catch (CertificateException e2) {
            e2.printStackTrace();
            obj = str;
        }
        try {
            X509Certificate x509Certificate = (X509Certificate) instance.generateCertificate(byteArrayInputStream);
        } catch (CertificateException e22) {
            e22.printStackTrace();
            obj = str;
        }
        try {
            str = a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        } catch (CertificateEncodingException e4) {
            e4.printStackTrace();
        }
        return str;
    }

    private static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String toHexString = Integer.toHexString(bArr[i]);
            int length = toHexString.length();
            if (length == 1) {
                toHexString = "0" + toHexString;
            }
            if (length > 2) {
                toHexString = toHexString.substring(length - 2, length);
            }
            stringBuilder.append(toHexString.toUpperCase());
            if (i < bArr.length - 1) {
                stringBuilder.append(':');
            }
        }
        return stringBuilder.toString();
    }

    public static String q(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static String r(Context context) {
        String str = null;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable e) {
            as.a(a, e);
        }
        return str;
    }
}
