package com.jd.fridge;

import android.app.Application;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import com.jd.fridge.kepler.KeplerAuthorizationActivity;
import com.jd.fridge.util.f;
import com.jd.fridge.util.k;
import com.jd.fridge.util.m;
import com.jd.fridge.util.r;
import com.jd.fridge.util.v;
import com.jingdong.crash.a.a;
import com.jingdong.crash.a.b;
import com.jingdong.jdma.JDMaInterface;
import com.jingdong.jdma.minterface.MaInitCommonInfo;
import com.kepler.jd.Listener.AsyncInitListener;
import com.kepler.jd.login.KeplerApiManager;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import java.io.File;
import org.apache.commons.lang.StringUtils;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig.Builder;

/* compiled from: TbsSdkJava */
public class GlobalVariable extends Application {
    private static String A;
    private static boolean B = false;
    private static String C = "";
    public static String a = "a188caaf009839ba200bb55bb8fa38407a595c2a";
    public static String b = "e685c8d1daa7e4dec8821a3df41c0b34a56db779";
    public static boolean c = false;
    public static final String d = (Environment.getExternalStorageDirectory() + File.separator + "fridgeJD" + File.separator);
    public static final String e = (d + "imageCache" + File.separator);
    public static final String f = (d + "updateCache" + File.separator);
    public static final String g = ("fridgeJD" + File.separator + "updateCache" + File.separator);
    public static final String h = (d + "audioCache" + File.separator);
    public static String i = "wxe07db2664ba22dd1";
    public static GlobalVariable l;
    private static String m = "";
    private static String n = "";
    private static Context w;
    private static boolean y = false;
    private static String z;
    NotificationManager j;
    MaInitCommonInfo k = new MaInitCommonInfo();
    private String o = "";
    private String p = "";
    private float q = 1.0f;
    private int r;
    private int s;
    private String t = "";
    private String u = "";
    private a v;
    private boolean x;

    public static synchronized GlobalVariable a() {
        GlobalVariable globalVariable;
        synchronized (GlobalVariable.class) {
            globalVariable = (GlobalVariable) w;
        }
        return globalVariable;
    }

    public void onCreate() {
        super.onCreate();
        w = getApplicationContext();
        CalligraphyConfig.initDefault(new Builder().setDefaultFontPath("fonts/FZLTH_GBK.ttf").setFontAttrId(R.attr.fontPath).build());
        a.b(l());
        a.a("jingdong");
        b.a(this, "92dd036a15a94fc186a2dada0fcde8c8", "16e0d4630b1841c6ac7beb98382e4bcb", null, null);
        KeplerApiManager.asyncInitSdk(this, "10d63b68b737400091fe7bb8edd7e4b4", "54e4e84eb424493baf117f75fe10fdf1", new AsyncInitListener(this) {
            final /* synthetic */ GlobalVariable a;

            {
                this.a = r1;
            }

            public void onSuccess() {
            }

            public void onFailure() {
                k.a("KeplerApiManager onFailure");
            }
        });
        KeplerApiManager.setJDInwardL(KeplerAuthorizationActivity.class);
        JPushInterface.setDebugMode(false);
        JPushInterface.init(getApplicationContext());
        this.v = a.a(this);
        l = this;
        this.j = (NotificationManager) getSystemService("notification");
        this.p = ((TelephonyManager) getSystemService("phone")).getDeviceId();
        N();
        r.a(false);
        QbSdk.initX5Environment(getApplicationContext(), new PreInitCallback(this) {
            final /* synthetic */ GlobalVariable a;

            {
                this.a = r1;
            }

            public void onViewInitFinished(boolean z) {
                this.a.x = z;
                r.c("infos", " onViewInitFinished is " + z);
            }

            public void onCoreInitFinished() {
                r.c("infos", " onViewInitFinished coreInit ");
            }
        });
        DisplayImageOptions build = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).showImageOnLoading((int) R.drawable.bg_default_image).showImageForEmptyUri((int) R.drawable.bg_default_image).showImageOnFail((int) R.drawable.bg_default_image).build();
        File ownCacheDirectory = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "fridgeJD/imageCache");
        r.c("infos", "cacheDir==" + ownCacheDirectory + "==imageCache==" + s());
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(build).memoryCache(new UsingFreqLimitedMemoryCache(2097152)).memoryCacheSize(2097152).diskCacheSize(52428800).diskCacheFileCount(50).diskCacheFileNameGenerator(new m()).diskCache(new UnlimitedDiskCache(ownCacheDirectory)).imageDownloader(new com.jd.fridge.util.b(this)).build());
    }

    public a b() {
        return this.v;
    }

    private void N() {
        JDMaInterface.acceptProtocal(true);
        this.k.site_id = "JA2016_313516";
        this.k.app_device = "android";
        this.k.appv = f.a(getApplicationContext());
        this.k.appc = f.b(getApplicationContext()) + "";
        this.k.build = f.b(getApplicationContext()) + "";
        this.k.guid = r();
        String c = f.c(getApplicationContext());
        MaInitCommonInfo maInitCommonInfo = this.k;
        if (TextUtils.isEmpty(c)) {
            c = "android";
        }
        maInitCommonInfo.channel = c;
        JDMaInterface.init(getApplicationContext(), this.k);
    }

    public MaInitCommonInfo c() {
        return this.k;
    }

    public NotificationManager d() {
        return this.j;
    }

    public void a(String str) {
        this.t = str;
        sendBroadcast(new Intent("wechat_login_broadcast"));
    }

    public String e() {
        return "https://sfapi.jd.com";
    }

    public String f() {
        return "https://sf.jd.com";
    }

    public String g() {
        return ".jd.com";
    }

    public void h() {
        v.a(getApplicationContext()).a("KEY_NEW_REPLY", true);
    }

    public void i() {
        v.a(getApplicationContext()).a("KEY_NEW_REPLY", false);
    }

    public boolean j() {
        return v.a(getApplicationContext()).b("KEY_NEW_REPLY", false);
    }

    public void k() {
        v.a(getApplicationContext()).a("KEY_NEW_REPLY");
    }

    public String l() {
        if (StringUtils.isEmpty(this.o)) {
            try {
                this.o = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return this.o;
    }

    public int m() {
        int i = -1;
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    public String n() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        try {
            k.a(telephonyManager.getSimState() + "");
            return telephonyManager.getDeviceId();
        } catch (Throwable th) {
            return "";
        }
    }

    public String o() {
        return VERSION.RELEASE;
    }

    public void a(float f) {
        this.q = f;
    }

    public float p() {
        return this.q;
    }

    public int q() {
        return this.r;
    }

    public void a(int i) {
        this.r = i;
    }

    public void b(int i) {
        this.s = i;
    }

    public String r() {
        return this.p;
    }

    public File s() {
        File file = new File(e);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public void b(String str) {
        DownloadManager downloadManager = (DownloadManager) getSystemService("download");
        Request request = new Request(Uri.parse(str));
        try {
            r.b("infos", "updateCacheDir==" + f + "===downloadDir==" + g + "==url==" + str);
            request.setDestinationInExternalPublicDir(g, str.substring(str.lastIndexOf(47) + 1));
            request.setNotificationVisibility(2);
            request.setMimeType("application/vnd.android.package-archive");
            request.allowScanningByMediaScanner();
            request.setVisibleInDownloadsUi(true);
            a(downloadManager.enqueue(request));
        } catch (Exception e) {
            e.printStackTrace();
            r.b("infos", "trace.print==" + e.toString());
        }
    }

    public void a(long j) {
        getSharedPreferences("sysInfo", 0).edit().putLong("updateId", j).commit();
    }

    public long t() {
        return getSharedPreferences("sysInfo", 0).getLong("updateId", 0);
    }

    public boolean u() {
        return getSharedPreferences("sysInfo", 0).getBoolean("privacyPolicy", false);
    }

    public void a(boolean z) {
        getSharedPreferences("sysInfo", 0).edit().putBoolean("privacyPolicy", z).commit();
    }

    public int v() {
        return getSharedPreferences("sysInfo", 0).getInt("versionCode", 0);
    }

    public void c(int i) {
        getSharedPreferences("sysInfo", 0).edit().putInt("versionCode", i).commit();
    }

    public void b(boolean z) {
        getSharedPreferences("sysInfo", 0).edit().putBoolean("skipUpdate", z).commit();
    }

    public boolean w() {
        return getSharedPreferences("sysInfo", 0).getBoolean("skipUpdate", false);
    }

    public void c(boolean z) {
        getSharedPreferences("sysInfo", 0).edit().putBoolean("wifiDownload", z).commit();
    }

    public boolean x() {
        return getSharedPreferences("sysInfo", 0).getBoolean("wifiDownload", true);
    }

    public void d(boolean z) {
        getSharedPreferences("sysInfo", 0).edit().putBoolean("hasNewVersion", z).commit();
    }

    public boolean y() {
        return getSharedPreferences("sysInfo", 0).getBoolean("hasNewVersion", false);
    }

    public boolean z() {
        return getSharedPreferences("sysInfo", 0).getBoolean("shortcut", false);
    }

    public void e(boolean z) {
        getSharedPreferences("sysInfo", 0).edit().putBoolean("shortcut", z).commit();
    }

    public void f(boolean z) {
        getSharedPreferences("sysInfo", 0).edit().putBoolean("showGuideFlag", z).commit();
    }

    public boolean A() {
        return getSharedPreferences("sysInfo", 0).getBoolean("showGuideFlag", true);
    }

    public static GlobalVariable B() {
        return l;
    }

    public void onTerminate() {
        com.jd.fridge.util.c.a.b().reportAppStatus((byte) 4);
        super.onTerminate();
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        Editor edit = B().getSharedPreferences("Fridge", 0).edit();
        edit.putString("feed_id", str);
        edit.apply();
    }

    public static String C() {
        String string = B().getSharedPreferences("Fridge", 0).getString("feed_id", "0");
        if (TextUtils.isEmpty(string)) {
            return "0";
        }
        return string;
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        Editor edit = B().getSharedPreferences("Fridge", 0).edit();
        edit.putString("device_id", str);
        edit.apply();
    }

    public static String D() {
        String string = B().getSharedPreferences("Fridge", 0).getString("device_id", "0");
        if (TextUtils.isEmpty(string)) {
            return "0";
        }
        return string;
    }

    public static void e(String str) {
        Editor edit = B().getSharedPreferences("Fridge", 0).edit();
        edit.putString("fridge_brand", str);
        edit.apply();
    }

    public static void d(int i) {
        if (i < 0) {
            k.a("判断是否有后置摄像头，参数非法");
            return;
        }
        Editor edit = B().getSharedPreferences("Fridge", 0).edit();
        edit.putInt("rear_camera", i);
        edit.apply();
    }

    public static int E() {
        return B().getSharedPreferences("Fridge", 0).getInt("rear_camera", 1);
    }

    public static void e(int i) {
        Editor edit = B().getSharedPreferences("Fridge", 0).edit();
        edit.putInt("control_mode", i);
        edit.apply();
    }

    public static boolean F() {
        if (B().getSharedPreferences("Fridge", 0).getInt("control_mode", 0) == 0) {
            return true;
        }
        return false;
    }

    public static void f(int i) {
        Editor edit = B().getSharedPreferences("Fridge", 0).edit();
        edit.putInt("bug_report_mode", i);
        edit.apply();
    }

    public static int G() {
        return B().getSharedPreferences("Fridge", 0).getInt("bug_report_mode", 0);
    }

    public void g(boolean z) {
        getSharedPreferences("sysInfo", 0).edit().putBoolean("isUpdate", z).commit();
    }

    public boolean H() {
        return getSharedPreferences("sysInfo", 0).getBoolean("isUpdate", false);
    }

    public static void f(String str) {
        n = str;
    }

    public static String I() {
        if (StringUtils.isNotEmpty(n)) {
            return n;
        }
        return "";
    }

    public static void g(String str) {
        z = str;
    }

    public static void h(String str) {
        A = str;
    }

    public static String J() {
        return z;
    }

    public static String K() {
        return A;
    }

    public static void i(String str) {
        C = str;
    }

    public static String L() {
        return C;
    }

    public boolean M() {
        return this.x;
    }
}
