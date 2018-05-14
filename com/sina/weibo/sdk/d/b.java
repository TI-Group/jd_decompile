package com.sina.weibo.sdk.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.support.v4.os.EnvironmentCompat;
import android.support.v4.view.PointerIconCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.sina.weibo.sdk.net.f;
import com.tencent.connect.common.Constants;
import com.tencent.stat.DeviceInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Cipher;
import jd.wjlogin_sdk.util.NetworkType;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class b {
    private static b a;
    private Context b;
    private String c;
    private a d;
    private volatile ReentrantLock e = new ReentrantLock(true);
    private c f;

    /* compiled from: TbsSdkJava */
    public static final class a {
        private String a;
        private String b;

        public String a() {
            return this.a;
        }

        public static a a(String str) throws com.sina.weibo.sdk.c.b {
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("error") || jSONObject.has("error_code")) {
                    d.a("AidTask", "loadAidFromNet has error !!!");
                    throw new com.sina.weibo.sdk.c.b("loadAidFromNet has error !!!");
                }
                aVar.a = jSONObject.optString(DeviceInfo.TAG_ANDROID_ID, "");
                aVar.b = jSONObject.optString("sub", "");
                return aVar;
            } catch (JSONException e) {
                d.a("AidTask", "loadAidFromNet JSONException Msg : " + e.getMessage());
                throw new com.sina.weibo.sdk.c.b("loadAidFromNet has error !!!");
            }
        }

        a b() {
            a aVar = new a();
            aVar.a = this.a;
            aVar.b = this.b;
            return aVar;
        }
    }

    /* compiled from: TbsSdkJava */
    public interface b {
        void a(a aVar);

        void a(Exception exception);
    }

    /* compiled from: TbsSdkJava */
    private static class c extends Handler {
        private WeakReference<b> a;

        public c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            b bVar = (b) this.a.get();
            switch (message.what) {
                case 1001:
                    if (bVar != null) {
                        bVar.a(((a) message.obj).b());
                        return;
                    }
                    return;
                case PointerIconCompat.TYPE_HAND /*1002*/:
                    if (bVar != null) {
                        bVar.a((com.sina.weibo.sdk.c.b) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private b(Context context) {
        this.b = context.getApplicationContext();
        this.f = new c(this.b.getMainLooper());
        new Thread(new Runnable(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void run() {
                for (int i = 0; i < 1; i++) {
                    try {
                        this.a.a(i).delete();
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(context);
            }
            bVar = a;
        }
        return bVar;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            d.c("AidTask", "aidTaskInit ");
            c(str);
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
            new Thread(new Runnable(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void run() {
                    if (this.a.e.tryLock()) {
                        a b = this.a.a();
                        if (b == null) {
                            int i = 1;
                            do {
                                i++;
                                try {
                                    String c = this.a.b();
                                    a a = a.a(c);
                                    this.a.d(c);
                                    this.a.d = a;
                                    break;
                                } catch (com.sina.weibo.sdk.c.b e) {
                                    d.c("AidTask", "AidTaskInit WeiboException Msg : " + e.getMessage());
                                    if (i >= 3) {
                                    }
                                }
                            } while (i >= 3);
                        } else {
                            this.a.d = b;
                        }
                        this.a.e.unlock();
                        return;
                    }
                    d.c("AidTask", "tryLock : false, return");
                }
            }).start();
        }
    }

    public a b(String str) throws com.sina.weibo.sdk.c.b {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d.c("AidTask", "getAidSync ");
        if (this.d == null) {
            a(str);
        }
        return this.d;
    }

    private synchronized a a() {
        FileInputStream fileInputStream;
        Throwable th;
        a aVar = null;
        synchronized (this) {
            try {
                fileInputStream = new FileInputStream(a(1));
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    aVar = a.a(new String(bArr));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return aVar;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream = aVar;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return aVar;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = aVar;
                th = th4;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        }
        return aVar;
    }

    private File a(int i) {
        return new File(this.b.getFilesDir(), "weibo_sdk_aid" + i);
    }

    private String b() throws com.sina.weibo.sdk.c.b {
        String str = "https://api.weibo.com/oauth2/getaid.json";
        str = this.b.getPackageName();
        String a = j.a(this.b, str);
        String b = b(this.b);
        f fVar = new f(this.c);
        fVar.a("appkey", this.c);
        fVar.a("mfp", b);
        fVar.a("packagename", str);
        fVar.a("key_hash", a);
        try {
            str = com.sina.weibo.sdk.net.c.b(this.b, "https://api.weibo.com/oauth2/getaid.json", "GET", fVar);
            d.a("AidTask", "loadAidFromNet response : " + str);
            return str;
        } catch (com.sina.weibo.sdk.c.b e) {
            d.a("AidTask", "loadAidFromNet WeiboException Msg : " + e.getMessage());
            throw e;
        }
    }

    private synchronized void d(String str) {
        FileOutputStream fileOutputStream;
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(a(1));
                try {
                    fileOutputStream.write(str.getBytes());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fileOutputStream2 = fileOutputStream;
                    th = th3;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return;
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
        return;
    }

    private static String b(Context context) {
        String str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB";
        String str2 = "";
        try {
            str = new String(c(context).getBytes(), HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            str = str2;
        }
        d.a("AidTask", "genMfpString() utf-8 string : " + str);
        try {
            str = a(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
            d.a("AidTask", "encryptRsa() string : " + str);
            return str;
        } catch (Exception e2) {
            d.c("AidTask", e2.getMessage());
            return "";
        }
    }

    private static String c(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence c = c();
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("1", c);
            }
            c = d(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("2", c);
            }
            c = e(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("3", c);
            }
            c = f(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("4", c);
            }
            c = g(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("5", c);
            }
            c = h(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put(Constants.VIA_SHARE_TYPE_INFO, c);
            }
            c = d();
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("7", c);
            }
            c = i(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, c);
            }
            c = e();
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, c);
            }
            c = f();
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, c);
            }
            c = g();
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, c);
            }
            c = j(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, c);
            }
            c = k(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, c);
            }
            c = h();
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("18", c);
            }
            c = l(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, c);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    private static String a(String str, String str2) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, e(str2));
        byte[] bytes = str.getBytes(HTTP.UTF_8);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (true) {
                int a = a(bytes, i, 117);
                if (a == -1) {
                    break;
                }
                try {
                    byte[] doFinal = instance.doFinal(bytes, i, a);
                    byteArrayOutputStream.write(doFinal);
                    d.a("AidTask", "encryptRsa offset = " + i + "     len = " + a + "     enBytes len = " + doFinal.length);
                    i += a;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            byteArrayOutputStream.flush();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            d.a("AidTask", "encryptRsa total enBytes len = " + toByteArray.length);
            toByteArray = c.b(toByteArray);
            d.a("AidTask", "encryptRsa total base64byte len = " + toByteArray.length);
            String str3 = "01";
            String str4 = "01" + new String(toByteArray, HTTP.UTF_8);
            d.a("AidTask", "encryptRsa total base64string : " + str4);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
            return str4;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
    }

    private static int a(byte[] bArr, int i, int i2) {
        if (i >= bArr.length) {
            return -1;
        }
        return Math.min(bArr.length - i, i2);
    }

    private static PublicKey e(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(c.a(str.getBytes())));
    }

    private static String c() {
        try {
            return "Android " + VERSION.RELEASE;
        } catch (Exception e) {
            return "";
        }
    }

    private static String d(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String e(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String f(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String g(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkType.WIFI_STRING);
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getMacAddress() : "";
        } catch (Exception e) {
            return "";
        }
    }

    private static String h(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            return "";
        }
    }

    private static String d() {
        String str = "";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.serialno", EnvironmentCompat.MEDIA_UNKNOWN});
        } catch (Exception e) {
            return str;
        }
    }

    private static String i(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return "";
        }
    }

    private static String e() {
        try {
            return Build.CPU_ABI;
        } catch (Exception e) {
            return "";
        }
    }

    private static String f() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return "";
        }
    }

    private static String g() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
        } catch (Exception e) {
            return "";
        }
    }

    private static String j(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return new StringBuilder(String.valueOf(String.valueOf(displayMetrics.widthPixels))).append("*").append(String.valueOf(displayMetrics.heightPixels)).toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static String k(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService(NetworkType.WIFI_STRING)).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
        } catch (Exception e) {
        }
        return "";
    }

    private static String h() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            return "";
        }
    }

    private static String l(Context context) {
        String str = "none";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return "none";
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    return NetworkType.WIFI_STRING;
                }
            }
            return str;
        } catch (Exception e) {
            return str;
        }
    }
}
