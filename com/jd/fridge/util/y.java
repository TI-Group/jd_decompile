package com.jd.fridge.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import cn.jiguang.net.HttpUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.h5.H5Action;
import com.jd.fridge.util.c.a;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.apache.http.conn.util.InetAddressUtils;

/* compiled from: TbsSdkJava */
public class y {
    private static final ThreadLocal<SimpleDateFormat> a = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected SimpleDateFormat a() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    private static final ThreadLocal<SimpleDateFormat> b = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected SimpleDateFormat a() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    private static final ThreadLocal<SimpleDateFormat> c = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected SimpleDateFormat a() {
            return new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        }
    };
    private static final ThreadLocal<SimpleDateFormat> d = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected SimpleDateFormat a() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    private static final ThreadLocal<SimpleDateFormat> e = new ThreadLocal<SimpleDateFormat>() {
        protected /* synthetic */ Object initialValue() {
            return a();
        }

        protected SimpleDateFormat a() {
            return new SimpleDateFormat("HH:mm");
        }
    };
    private static long f = 0;

    public static Date a(long j) {
        return new Date(j);
    }

    public static String a(long j, String str) {
        return new SimpleDateFormat(str).format(a(j));
    }

    public static String a(String str) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            return "--";
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(2);
        int i2 = instance.get(5);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i + 1);
        stringBuilder.append("-");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    public static String a() {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(2) + 1;
        int i2 = instance.get(5);
        int i3 = instance.get(7);
        if (i3 == 1) {
            instance.add(6, -6);
        } else if (i3 == 2) {
            instance.add(6, 0);
        } else if (i3 == 3) {
            instance.add(6, -1);
        } else if (i3 == 4) {
            instance.add(6, -2);
        } else if (i3 == 5) {
            instance.add(6, -3);
        } else if (i3 == 6) {
            instance.add(6, -4);
        } else if (i3 == 7) {
            instance.add(6, -5);
        }
        i3 = instance.get(2) + 1;
        int i4 = instance.get(5);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i3);
        stringBuilder.append("月");
        stringBuilder.append(i4);
        stringBuilder.append("日");
        stringBuilder.append("至");
        stringBuilder.append(i);
        stringBuilder.append("月");
        stringBuilder.append(i2);
        stringBuilder.append("日");
        return stringBuilder.toString();
    }

    public static String b() {
        return new SimpleDateFormat("M月d日").format(new Date());
    }

    public static String b(long j) {
        String str = "";
        long currentTimeMillis = (System.currentTimeMillis() - j) / 1000;
        if (currentTimeMillis - 3600 <= 0) {
            if (currentTimeMillis - 60 <= 0) {
                return "刚刚";
            }
            return (((int) currentTimeMillis) / 60) + "分钟前";
        } else if (currentTimeMillis - TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC <= 0) {
            return (((int) currentTimeMillis) / 3600) + "小时前";
        } else {
            return (((int) currentTimeMillis) / 86400) + "天前";
        }
    }

    public static String a(Context context, long j) {
        if (context == null) {
            return "";
        }
        String str = "";
        long currentTimeMillis = System.currentTimeMillis();
        if (((currentTimeMillis - j) / 1000) - TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC > 0) {
            return ((SimpleDateFormat) c.get()).format(new Date(j));
        }
        String str2;
        if (((SimpleDateFormat) d.get()).format(new Date(j)).equals(((SimpleDateFormat) d.get()).format(new Date(currentTimeMillis)))) {
            str2 = context.getResources().getString(R.string.today) + ((SimpleDateFormat) e.get()).format(new Date(j));
        } else {
            str2 = ((SimpleDateFormat) c.get()).format(new Date(j));
        }
        r.b("infos", "date===" + ((SimpleDateFormat) c.get()).format(new Date(j)) + "===date==" + ((SimpleDateFormat) c.get()).format(new Date(currentTimeMillis)));
        return str2;
    }

    public static byte[] b(String str) {
        char[] toCharArray = str.toCharArray();
        byte[] bArr = new byte[toCharArray.length];
        for (int i = 0; i < toCharArray.length; i++) {
            bArr[i] = (byte) toCharArray[i];
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i));
        }
        return stringBuffer.toString();
    }

    public static String a(String str, int i) {
        if (!StringUtils.isNotEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        if (str.contains(HttpUtils.URL_AND_PARA_SEPARATOR)) {
            stringBuilder.append("&type=");
            stringBuilder.append(i);
        } else {
            stringBuilder.append("?type=");
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    public static boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f < 1000) {
            return true;
        }
        f = currentTimeMillis;
        return false;
    }

    public static boolean c(String str) {
        if (str == null) {
            return false;
        }
        try {
            if (new File(URLDecoder.decode(str, CommonUtil.UTF8)).exists()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static int a(float f, float f2) {
        return (int) ((f * f2) + 0.5f);
    }

    private static String f(Context context) {
        return ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
    }

    public static boolean a(Context context) {
        if (!(context instanceof Activity)) {
            return false;
        }
        String f = f(context);
        String className = ((Activity) context).getComponentName().getClassName();
        if (StringUtils.isNotBlank(f)) {
            return f.equalsIgnoreCase(className);
        }
        return false;
    }

    public static boolean b(Context context) {
        if (context instanceof Activity) {
            return a(context);
        }
        return true;
    }

    public static byte[] d(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        byte[] bArr = null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(1000);
            } catch (FileNotFoundException e3) {
                e = e3;
                byteArrayOutputStream = bArr;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e222) {
                            e222.printStackTrace();
                        }
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e22222) {
                            e22222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e22222 = e4;
                byteArrayOutputStream = bArr;
                e22222.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e222222) {
                        e222222.printStackTrace();
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2222222) {
                        e2222222.printStackTrace();
                    }
                }
                return bArr;
            } catch (Throwable th3) {
                byteArrayOutputStream = bArr;
                th = th3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr2 = new byte[1000];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                fileInputStream.close();
                byteArrayOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e22222222) {
                        e22222222.printStackTrace();
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e222222222) {
                        e222222222.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            } catch (IOException e6) {
                e222222222 = e6;
                e222222222.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return bArr;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            e.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return bArr;
        } catch (IOException e8) {
            e222222222 = e8;
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            e222222222.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return bArr;
        } catch (Throwable th32) {
            byteArrayOutputStream = bArr;
            fileInputStream = bArr;
            th = th32;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
        return bArr;
    }

    public static File c(Context context) {
        return context.getFilesDir();
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        if (activeNetworkInfo.getState() == State.CONNECTED) {
            return true;
        }
        return false;
    }

    public static boolean e(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        if (activeNetworkInfo.getState() == State.CONNECTED && activeNetworkInfo.getType() == 1) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        if (((ConnectivityManager) GlobalVariable.a().getSystemService("connectivity")).getActiveNetworkInfo() != null) {
            return true;
        }
        return false;
    }

    public static float a(Resources resources, float f) {
        return (resources.getDisplayMetrics().density * f) + 0.5f;
    }

    public static float b(Resources resources, float f) {
        return resources.getDisplayMetrics().scaledDensity * f;
    }

    public static String e() {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (InetAddressUtils.isIPv4Address(hostAddress)) {
                            return hostAddress;
                        }
                    }
                }
            }
        } catch (SocketException e) {
        }
        return "";
    }

    public static void a(Context context, WebView webView, String str) {
        HttpCookie httpCookie = null;
        HttpCookie httpCookie2;
        if (VERSION.SDK_INT >= 21) {
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptThirdPartyCookies(webView, true);
            httpCookie2 = new HttpCookie("fid", GlobalVariable.C());
            httpCookie2.setDomain(GlobalVariable.B().g());
            httpCookie2.setPath(HttpUtils.PATHS_SEPARATOR);
            httpCookie2.setMaxAge(2147483647L);
            instance.setCookie(str, httpCookie2.toString());
            httpCookie2 = new HttpCookie("wskey", a.b().getA2());
            httpCookie2.setDomain(GlobalVariable.B().g());
            httpCookie2.setPath(HttpUtils.PATHS_SEPARATOR);
            httpCookie2.setMaxAge(2147483647L);
            instance.setCookie(str, httpCookie2.toString());
            try {
                httpCookie2 = new HttpCookie("pin", URLEncoder.encode(a.b().getPin(), CommonUtil.UTF8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                httpCookie2 = null;
            }
            httpCookie2.setDomain(GlobalVariable.B().g());
            httpCookie2.setPath(HttpUtils.PATHS_SEPARATOR);
            httpCookie2.setMaxAge(2147483647L);
            instance.setCookie(str, httpCookie2.toString());
            instance.flush();
            return;
        }
        CookieSyncManager.createInstance(context);
        instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        httpCookie2 = new HttpCookie("fid", GlobalVariable.C());
        httpCookie2.setDomain(GlobalVariable.B().g());
        httpCookie2.setPath(HttpUtils.PATHS_SEPARATOR);
        httpCookie2.setMaxAge(2147483647L);
        instance.setCookie(str, httpCookie2.toString());
        httpCookie2 = new HttpCookie("wskey", a.b().getA2());
        httpCookie2.setDomain(GlobalVariable.B().g());
        httpCookie2.setPath(HttpUtils.PATHS_SEPARATOR);
        httpCookie2.setMaxAge(2147483647L);
        instance.setCookie(str, httpCookie2.toString());
        try {
            httpCookie = new HttpCookie("pin", URLEncoder.encode(a.b().getPin(), CommonUtil.UTF8));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        httpCookie.setDomain(GlobalVariable.B().g());
        httpCookie.setPath(HttpUtils.PATHS_SEPARATOR);
        httpCookie.setMaxAge(2147483647L);
        instance.setCookie(str, httpCookie.toString());
        CookieSyncManager.getInstance().sync();
    }

    public static void a(Handler handler, int i) {
        if (handler != null) {
            handler.removeMessages(i);
            handler.sendEmptyMessageDelayed(i, 15000);
        }
    }

    public static void b(Handler handler, int i) {
        if (handler != null) {
            handler.removeMessages(i);
        }
    }

    public static H5Action e(String str) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (!str.startsWith("fridgenative://")) {
            return new H5Action(str2, str3, str);
        }
        str3 = "fridgenative://";
        str2 = str.substring(str3.length());
        String substring = str2.substring(0, str2.indexOf("/?"));
        if (!substring.equals("recipeTitle")) {
            str2.indexOf("/?url=");
            str4 = str2.substring(substring.length() + 6);
        }
        return new H5Action(str3, substring, str4);
    }
}
