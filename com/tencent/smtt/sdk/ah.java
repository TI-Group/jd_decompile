package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.aa;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

class ah {
    private static int d = 5;
    private static int e = 1;
    private static final String[] f = new String[]{"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private Set<String> A;
    private int B = d;
    private boolean C;
    String a;
    String[] b = null;
    int c = 0;
    private Context g;
    private String h;
    private String i;
    private String j;
    private File k;
    private long l;
    private int m = CommonUtil.POST_TIMEOUT;
    private int n = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private HttpURLConnection t;
    private String u;
    private TbsLogInfo v;
    private String w;
    private int x;
    private boolean y;
    private Handler z;

    public ah(Context context) {
        this.g = context.getApplicationContext();
        this.v = TbsLogReport.a(this.g).a();
        this.A = new HashSet();
        this.u = "tbs_downloading_" + this.g.getPackageName();
        ao.a();
        this.k = ao.m(this.g);
        if (this.k == null) {
            throw new NullPointerException("TbsCorePrivateDir is null!");
        }
        e();
        this.w = null;
        this.x = -1;
    }

    private long a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.v.setDownConsumeTime(currentTimeMillis - j);
        this.v.setDownloadSize(j2);
        return currentTimeMillis;
    }

    @TargetApi(8)
    static File a(Context context) {
        try {
            File file = VERSION.SDK_INT >= 8 ? new File(k.a(context, 4)) : null;
            if (file == null || file.exists() || file.isDirectory()) {
                return file;
            }
            file.mkdirs();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    private static File a(Context context, int i) {
        File file = new File(k.a(context, i));
        if (file == null || !file.exists() || !file.isDirectory()) {
            return null;
        }
        File file2 = new File(file, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        return (file2 == null || !file2.exists()) ? null : file;
    }

    private String a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    private String a(URL url) {
        String str = "";
        try {
            str = InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e2) {
            e2.printStackTrace();
        }
        return str;
    }

    private void a(int i, String str, boolean z) {
        if (z || this.p > this.B) {
            this.v.setErrorCode(i);
            this.v.setFailDetail(str);
        }
    }

    private void a(long j) {
        this.p++;
        if (j <= 0) {
            try {
                j = m();
            } catch (Exception e) {
                return;
            }
        }
        Thread.sleep(j);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(File file, Context context) {
        if (file != null && file.exists()) {
            try {
                File a = a(context);
                if (a != null) {
                    File file2 = new File(a, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                    file2.delete();
                    k.b(file, file2);
                }
            } catch (Exception e) {
            }
        }
    }

    private void a(String str) {
        URL url = new URL(str);
        if (this.t != null) {
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        this.t = (HttpURLConnection) url.openConnection();
        this.t.setRequestProperty("User-Agent", TbsDownloader.a(this.g));
        this.t.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
        this.t.setRequestMethod("GET");
        this.t.setInstanceFollowRedirects(false);
        this.t.setConnectTimeout(this.n);
        this.t.setReadTimeout(this.m);
    }

    @TargetApi(8)
    static File b(Context context) {
        try {
            if (VERSION.SDK_INT < 8) {
                return null;
            }
            File a = a(context, 4);
            if (a == null) {
                a = a(context, 3);
            }
            if (a == null) {
                a = a(context, 2);
            }
            return a == null ? a(context, 1) : a;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    private void b(boolean z) {
        aa.a(this.g);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.g);
        instance.a.put(TbsConfigKey.KEY_FULL_PACKAGE, Boolean.valueOf(false));
        instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(false));
        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-123));
        instance.commit();
        QbSdk.j.onDownloadFinish(z ? 100 : ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
        int i = instance.mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean z2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1;
        if (i == 3 || i > 10000) {
            File a = a(this.g);
            if (a != null) {
                File file = new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                int a2 = a.a(this.g, file);
                File file2 = new File(this.k, "x5.tbs");
                String absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
                int i2 = instance.mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", i);
                bundle.putInt("old_core_ver", a2);
                bundle.putInt("new_core_ver", i2);
                bundle.putString("old_apk_location", file.getAbsolutePath());
                bundle.putString("new_apk_location", absolutePath);
                bundle.putString("diff_file_location", absolutePath);
                ao.a().b(this.g, bundle);
                return;
            }
            c();
            instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
            instance.commit();
            return;
        }
        ao.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), instance.mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
        if (!z2) {
            a(new File(this.k, "x5.tbs"), this.g);
        }
    }

    public static void c(Context context) {
        try {
            ao.a();
            File m = ao.m(context);
            new File(m, "x5.tbs").delete();
            new File(m, "x5.tbs.temp").delete();
            m = a(context);
            if (m != null) {
                new File(m, "x5.tbs.org").delete();
                new File(m, "x5.oversea.tbs.org").delete();
            }
        } catch (Exception e) {
        }
    }

    private boolean c(boolean z) {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=" + z);
        File file = z ? new File(this.k, "x5.tbs") : new File(this.k, "x5.tbs.temp");
        return (file == null || !file.exists()) ? true : file.delete();
    }

    private boolean c(boolean z, boolean z2) {
        long j = 0;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z);
        File file = new File(this.k, !z ? "x5.tbs" : "x5.tbs.temp");
        if (!file.exists()) {
            return false;
        }
        String string = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsConfigKey.KEY_TBSAPK_MD5, null);
        String a = a.a(file);
        if (string == null || !string.equals(a)) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " md5 failed");
            if (!z) {
                return false;
            }
            this.v.setCheckErrorDetail("fileMd5 not match");
            return false;
        }
        boolean renameTo;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] md5(" + a + ") successful!");
        if (z) {
            long j2;
            long j3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
            if (file == null || !file.exists()) {
                j2 = 0;
            } else if (j3 > 0) {
                j2 = file.length();
                if (j3 == j2) {
                    j = j2;
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " filelength failed");
            this.v.setCheckErrorDetail("fileLength:" + j2 + ",contentLength:" + j3);
            return false;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] length(" + j + ") successful!");
        int i = -1;
        if (z2) {
            i = a.a(this.g, file);
            int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            if (i2 != i) {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " versionCode failed");
                if (!z) {
                    return false;
                }
                this.v.setCheckErrorDetail("fileVersion:" + i + ",configVersion:" + i2);
                return false;
            }
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
        if (z2) {
            string = b.a(this.g, file);
            if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(string)) {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " signature failed");
                if (!z) {
                    return false;
                }
                this.v.setCheckErrorDetail("signature:" + (string == null ? "null" : Integer.valueOf(string.length())));
                return false;
            }
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] signature successful!");
        if (z) {
            Throwable th;
            try {
                renameTo = file.renameTo(new File(this.k, "x5.tbs"));
                th = null;
            } catch (Throwable e) {
                th = e;
                renameTo = false;
            }
            if (!renameTo) {
                a(109, a(th), true);
                return false;
            }
        }
        renameTo = false;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] rename(" + renameTo + ") successful!");
        return true;
    }

    private void e() {
        this.p = 0;
        this.q = 0;
        this.l = -1;
        this.j = null;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
    }

    private void f() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        if (this.t != null) {
            if (!this.r) {
                this.v.setResolveIp(a(this.t.getURL()));
            }
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.t = null;
        }
        int i = this.v.a;
        if (this.r || !this.y) {
            TbsDownloader.a = false;
            return;
        }
        this.v.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.g);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = Apn.getApnType(this.g);
        this.v.setApn(apnInfo);
        this.v.setNetworkType(apnType);
        if (!(apnType == this.x && apnInfo.equals(this.w))) {
            this.v.setNetworkChange(0);
        }
        if ((this.v.a == 0 || this.v.a == 107) && this.v.getDownFinalFlag() == 0) {
            if (!Apn.isNetworkAvailable(this.g)) {
                a(101, null, true);
            } else if (!l()) {
                a(101, null, true);
            }
        }
        if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
        } else {
            TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD, this.v);
        }
        this.v.resetArgs();
        if (i != 100) {
            QbSdk.j.onDownloadFinish(i);
        }
    }

    private boolean g() {
        try {
            File file = new File(this.k, "x5.tbs");
            File a = a(this.g);
            if (a == null) {
                return false;
            }
            File file2 = new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            file.delete();
            k.b(file2, file);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e.getMessage());
            return false;
        }
    }

    private boolean h() {
        File file = new File(k.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        int i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i == 0) {
            i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        return a.a(this.g, file, 0, i);
    }

    private void i() {
        try {
            File file = new File(k.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file != null && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean j() {
        File file = new File(this.k, "x5.tbs.temp");
        return file != null && file.exists();
    }

    private long k() {
        File file = new File(this.k, "x5.tbs.temp");
        return (file == null || !file.exists()) ? 0 : file.length();
    }

    private boolean l() {
        Closeable inputStream;
        Closeable inputStreamReader;
        Throwable th;
        Closeable closeable;
        Throwable th2;
        boolean z = false;
        Closeable closeable2 = null;
        try {
            inputStream = Runtime.getRuntime().exec("ping " + "www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
            } catch (Throwable th3) {
                th2 = th3;
                inputStreamReader = null;
                a(inputStream);
                a(inputStreamReader);
                a(closeable2);
                throw th2;
            }
            try {
                closeable = new BufferedReader(inputStreamReader);
                int i = 0;
                do {
                    try {
                        String readLine = closeable.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.contains("TTL") || readLine.contains("ttl")) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        closeable2 = closeable;
                    }
                } while (i < 5);
                a(inputStream);
                a(inputStreamReader);
                a(closeable);
            } catch (Throwable th5) {
                th2 = th5;
                a(inputStream);
                a(inputStreamReader);
                a(closeable2);
                throw th2;
            }
        } catch (Throwable th6) {
            th2 = th6;
            inputStreamReader = null;
            inputStream = null;
            a(inputStream);
            a(inputStreamReader);
            a(closeable2);
            throw th2;
        }
        return z;
    }

    private long m() {
        switch (this.p) {
            case 1:
            case 2:
                return 20000 * ((long) this.p);
            case 3:
            case 4:
                return 20000 * 5;
            default:
                return 20000 * 10;
        }
    }

    private boolean n() {
        CharSequence charSequence;
        Object obj;
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2 = null;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = Apn.getApnType(this.g) == 3;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z3);
        if (z3) {
            String wifiSSID = Apn.getWifiSSID(this.g);
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + wifiSSID);
            try {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL("http://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection3.setInstanceFollowRedirects(false);
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setReadTimeout(10000);
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.getInputStream();
                    int responseCode = httpURLConnection3.getResponseCode();
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    if (responseCode != 204) {
                        z = false;
                    }
                    if (httpURLConnection3 != null) {
                        try {
                            httpURLConnection3.disconnect();
                            charSequence = wifiSSID;
                            z2 = z;
                        } catch (Exception e) {
                            obj = wifiSSID;
                            z2 = z;
                        }
                    } else {
                        obj = wifiSSID;
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    httpURLConnection2 = httpURLConnection3;
                    th = th2;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
        if (!(z2 || TextUtils.isEmpty(charSequence) || this.A.contains(charSequence))) {
            this.A.add(charSequence);
            o();
            this.z.sendMessageDelayed(this.z.obtainMessage(150, charSequence), 120000);
        }
        if (z2 && this.A.contains(charSequence)) {
            this.A.remove(charSequence);
        }
        return z2;
    }

    private void o() {
        if (this.z == null) {
            this.z = new ai(this, am.a().getLooper());
        }
    }

    public int a() {
        File a = a(this.g);
        if (a == null) {
            return 0;
        }
        return a.a(this.g, new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
    }

    public void a(int i) {
        try {
            File file = new File(this.k, "x5.tbs");
            int a = a.a(this.g, file);
            if (-1 == a || (i > 0 && i == a)) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }

    public boolean a(boolean z) {
        if ((z && !n() && (!QbSdk.getDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.g))) || this.b == null || this.c < 0 || this.c >= this.b.length) {
            return false;
        }
        String[] strArr = this.b;
        int i = this.c;
        this.c = i + 1;
        this.j = strArr[i];
        this.p = 0;
        this.q = 0;
        this.l = -1;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
        return true;
    }

    public boolean a(boolean z, boolean z2) {
        int i;
        int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int e = ao.a().e(this.g);
        if (i2 == 0) {
            i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            this.a = "by default key";
            i = i2;
        } else {
            this.a = "by new key";
            i = i2;
        }
        if (i == 0 || i == e) {
            return false;
        }
        if (z2) {
            boolean z3;
            File a = TbsDownloader.a(i);
            if (a != null && a.exists()) {
                try {
                    k.b(a, new File(k.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                    z3 = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (h()) {
                    i();
                    if (!a.a(this.g, a, 0, i)) {
                        k.b(a);
                    }
                } else if (g()) {
                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                    b(false);
                    if (z3) {
                        return true;
                    }
                    a(100, "use local backup apk in startDownload" + this.a, true);
                    if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
                        TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
                    } else {
                        TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD, this.v);
                    }
                    this.v.resetArgs();
                    return true;
                }
            }
            z3 = false;
            if (h()) {
                i();
                if (a.a(this.g, a, 0, i)) {
                    k.b(a);
                }
            } else if (g()) {
                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                b(false);
                if (z3) {
                    return true;
                }
                a(100, "use local backup apk in startDownload" + this.a, true);
                if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
                    TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD, this.v);
                } else {
                    TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
                }
                this.v.resetArgs();
                return true;
            }
        }
        if (c(false, z2)) {
            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
            b(false);
            return true;
        }
        if (!(c(true) || c(true))) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader] delete file failed!");
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
        }
        return false;
    }

    public void b() {
        this.r = true;
        if (TbsShareManager.isThirdPartyApp(this.g)) {
            TbsLogInfo a = TbsLogReport.a(this.g).a();
            a.setErrorCode(-309);
            a.setFailDetail(new Exception());
            if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD_DECOUPLE, a);
            } else {
                TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD, a);
            }
        }
    }

    public void b(boolean z, boolean z2) {
        Throwable th;
        Throwable th2;
        Closeable inflaterInputStream;
        FileOutputStream fileOutputStream;
        int i;
        FileOutputStream fileOutputStream2;
        Object obj;
        boolean z3;
        boolean z4;
        long j;
        long j2;
        TbsDownloadConfig instance;
        if (!ao.a().b(this.g) || z) {
            int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
            z3 = i2 == 1 || i2 == 2 || i2 == 4;
            if (z2 || !a(z, z3)) {
                this.C = z;
                this.h = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsConfigKey.KEY_TBSDOWNLOADURL, null);
                String string = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsConfigKey.KEY_DOWNLOADURL_LIST, null);
                TbsLog.i(TbsDownloader.LOGTAG, "backupUrlStrings:" + string, true);
                this.b = null;
                this.c = 0;
                if (!(z || string == null || "".equals(string.trim()))) {
                    this.b = string.trim().split(";");
                }
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mDownloadUrl=" + this.h + " backupUrlStrings=" + string + " mLocation=" + this.j + " mCanceled=" + this.r + " mHttpRequest=" + this.t);
                if (this.h == null && this.j == null) {
                    QbSdk.j.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-302);
                    return;
                } else if (this.t != null && !this.r) {
                    QbSdk.j.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-303);
                    return;
                } else if (z || !this.A.contains(Apn.getWifiSSID(this.g))) {
                    e();
                    TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...", true);
                    long downloadMaxflow = TbsDownloadConfig.getInstance(this.g).getDownloadMaxflow();
                    z4 = false;
                    j = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                    if (z) {
                        this.B = e;
                    } else {
                        this.B = d;
                    }
                    while (this.p <= this.B) {
                        if (this.q > 8) {
                            a(ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, null, true);
                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-306);
                            break;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!z) {
                            if (currentTimeMillis - TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) > 86400000) {
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD");
                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, Long.valueOf(currentTimeMillis));
                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(0));
                                TbsDownloadConfig.getInstance(this.g).commit();
                                j2 = 0;
                            } else {
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] downloadFlow=" + j);
                                if (j >= downloadMaxflow) {
                                    TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                    a(112, null, true);
                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-307);
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else {
                                    j2 = j;
                                }
                            }
                            try {
                                if (k.b(this.g)) {
                                    j = j2;
                                } else {
                                    TbsLog.i(TbsDownloader.LOGTAG, "DownloadBegin FreeSpace too small", true);
                                    a(105, null, true);
                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                }
                            } catch (Throwable th3) {
                                th2 = th3;
                            }
                        }
                        this.y = true;
                        String str = this.j != null ? this.j : this.h;
                        TbsLog.i(TbsDownloader.LOGTAG, "try url:" + str + ",mRetryTimes:" + this.p, true);
                        if (!str.equals(this.i)) {
                            this.v.setDownloadUrl(str);
                        }
                        this.i = str;
                        a(str);
                        long j3 = 0;
                        if (!this.o) {
                            j3 = k();
                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] range=" + j3);
                            if (this.l <= 0) {
                                TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...current" + j3, true);
                                this.t.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j3 + "-");
                            } else {
                                TbsLog.i(TbsDownloader.LOGTAG, "#1 STEP 1/2 begin downloading...current/total=" + j3 + HttpUtils.PATHS_SEPARATOR + this.l, true);
                                this.t.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j3 + "-" + this.l);
                            }
                        }
                        this.v.setDownloadCancel(j3 == 0 ? 0 : 1);
                        int apnType = Apn.getApnType(this.g);
                        String apnInfo = Apn.getApnInfo(this.g);
                        if (this.w == null && this.x == -1) {
                            this.w = apnInfo;
                            this.x = apnType;
                        } else if (!(apnType == this.x && apnInfo.equals(this.w))) {
                            this.v.setNetworkChange(0);
                            this.w = apnInfo;
                            this.x = apnType;
                        }
                        if (this.p >= 1) {
                            this.t.addRequestProperty(HttpHeaders.REFERER, this.h);
                        }
                        apnType = this.t.getResponseCode();
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] responseCode=" + apnType);
                        this.v.setHttpCode(apnType);
                        if (!(z || TbsDownloader.getOverSea(this.g) || ((Apn.getApnType(this.g) == 3 || QbSdk.getDownloadWithoutWifi()) && Apn.getApnType(this.g) != 0))) {
                            b();
                            if (QbSdk.j != null) {
                                QbSdk.j.onDownloadFinish(111);
                            }
                            TbsLog.i(TbsDownloader.LOGTAG, "Download is canceled due to NOT_WIFI error!", false);
                        }
                        if (this.r) {
                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                            if (!z) {
                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                TbsDownloadConfig.getInstance(this.g).commit();
                            }
                        } else if (apnType == 200 || apnType == 206) {
                            this.l = ((long) this.t.getContentLength()) + j3;
                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mContentLength=" + this.l);
                            this.v.setPkgSize(this.l);
                            j2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
                            if (j2 == 0 || this.l == j2) {
                                Closeable closeable = null;
                                Closeable closeable2 = null;
                                Closeable closeable3 = null;
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] begin readResponse");
                                Closeable inputStream;
                                try {
                                    inputStream = this.t.getInputStream();
                                    if (inputStream != null) {
                                        try {
                                            byte[] bArr;
                                            str = this.t.getContentEncoding();
                                            if (str == null || !str.contains("gzip")) {
                                                if (str != null) {
                                                    if (str.contains("deflate")) {
                                                        inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                                                    }
                                                }
                                                inflaterInputStream = inputStream;
                                            } else {
                                                inflaterInputStream = new GZIPInputStream(inputStream);
                                            }
                                            try {
                                                bArr = new byte[8192];
                                                fileOutputStream = new FileOutputStream(new File(this.k, "x5.tbs.temp"), true);
                                            } catch (IOException e) {
                                                th = e;
                                                closeable3 = inflaterInputStream;
                                                closeable2 = inputStream;
                                                try {
                                                    th.printStackTrace();
                                                    if (!(th instanceof SocketTimeoutException) || (th instanceof SocketException)) {
                                                        this.m = 100000;
                                                        a(0);
                                                        a(103, a(th), false);
                                                        a(closeable);
                                                        a(closeable3);
                                                        a(closeable2);
                                                        if (z) {
                                                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                                            TbsDownloadConfig.getInstance(this.g).commit();
                                                        }
                                                    } else {
                                                        if (!z) {
                                                            if (!k.b(this.g)) {
                                                                a(105, "freespace=" + aa.a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace(), true);
                                                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                                a(closeable);
                                                                a(closeable3);
                                                                a(closeable2);
                                                                if (!z) {
                                                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                                                    TbsDownloadConfig.getInstance(this.g).commit();
                                                                }
                                                                if (!this.r) {
                                                                    if (this.s) {
                                                                        z4 = c(true, z3);
                                                                        this.v.setUnpkgFlag(z4 ? 0 : 1);
                                                                        if (z3) {
                                                                            this.v.setPatchUpdateFlag(z4 ? 2 : 1);
                                                                        } else {
                                                                            this.v.setPatchUpdateFlag(0);
                                                                        }
                                                                        if (z4) {
                                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                                                            c(false);
                                                                        } else {
                                                                            b(true);
                                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                                                            a(100, "success", true);
                                                                        }
                                                                    }
                                                                    instance = TbsDownloadConfig.getInstance(this.g);
                                                                    if (z4) {
                                                                        i = instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) + 1;
                                                                        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(i));
                                                                        if (i == instance.getDownloadFailedMaxRetrytimes()) {
                                                                            this.v.setDownloadCancel(2);
                                                                        }
                                                                    } else {
                                                                        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) + 1));
                                                                    }
                                                                    instance.commit();
                                                                    this.v.setDownFinalFlag(z4 ? 0 : 1);
                                                                }
                                                                f();
                                                                return;
                                                            }
                                                        }
                                                        a(0);
                                                        if (j()) {
                                                            a(104, a(th), false);
                                                        } else {
                                                            a(106, a(th), false);
                                                        }
                                                        try {
                                                            a(closeable);
                                                            a(closeable3);
                                                            a(closeable2);
                                                            if (!z) {
                                                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                                                TbsDownloadConfig.getInstance(this.g).commit();
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                        }
                                                    }
                                                } catch (Throwable th5) {
                                                    inflaterInputStream = closeable3;
                                                    inputStream = closeable2;
                                                    fileOutputStream2 = closeable;
                                                    j2 = j;
                                                    th2 = th5;
                                                    a((Closeable) fileOutputStream2);
                                                    a(inflaterInputStream);
                                                    a(inputStream);
                                                    throw th2;
                                                }
                                            } catch (Throwable th52) {
                                                fileOutputStream2 = null;
                                                j2 = j;
                                                th2 = th52;
                                                a((Closeable) fileOutputStream2);
                                                a(inflaterInputStream);
                                                a(inputStream);
                                                throw th2;
                                            }
                                            try {
                                                long currentTimeMillis2 = System.currentTimeMillis();
                                                r7 = null;
                                                long j4 = currentTimeMillis;
                                                j2 = j;
                                                currentTimeMillis = j3;
                                                j = j3;
                                                while (!this.r) {
                                                    try {
                                                        int read = inflaterInputStream.read(bArr, 0, 8192);
                                                        if (read > 0) {
                                                            fileOutputStream.write(bArr, 0, read);
                                                            fileOutputStream.flush();
                                                            if (!z) {
                                                                j2 += (long) read;
                                                                if (j2 < downloadMaxflow) {
                                                                    if (!k.b(this.g)) {
                                                                        TbsLog.i(TbsDownloader.LOGTAG, "DownloadEnd FreeSpace too small ", true);
                                                                        a(105, "freespace=" + aa.a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace(), true);
                                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                                        j = j2;
                                                                        break;
                                                                    }
                                                                }
                                                                TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                                                a(112, "downloadFlow=" + j2 + " downloadMaxflow=" + downloadMaxflow, true);
                                                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-307);
                                                                j = j2;
                                                                break;
                                                            }
                                                            j3 = j2;
                                                            try {
                                                                long a = a(j4, (long) read);
                                                                j4 = System.currentTimeMillis();
                                                                j2 = ((long) read) + currentTimeMillis;
                                                                if (j4 - currentTimeMillis2 > 1000) {
                                                                    TbsLog.i(TbsDownloader.LOGTAG, "#2 STEP 1/2 begin downloading...current/total=" + j2 + HttpUtils.PATHS_SEPARATOR + this.l, true);
                                                                    if (QbSdk.j != null) {
                                                                        QbSdk.j.onDownloadProgress((int) ((((double) j2) / ((double) this.l)) * 100.0d));
                                                                    }
                                                                    if (!z && j2 - j > 1048576) {
                                                                        if (TbsDownloader.getOverSea(this.g) || ((Apn.getApnType(this.g) == 3 || QbSdk.getDownloadWithoutWifi()) && Apn.getApnType(this.g) != 0)) {
                                                                            j = j2;
                                                                        } else {
                                                                            b();
                                                                            if (QbSdk.j != null) {
                                                                                QbSdk.j.onDownloadFinish(111);
                                                                            }
                                                                            TbsLog.i(TbsDownloader.LOGTAG, "Download is paused due to NOT_WIFI error!", false);
                                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                                                                            j = j3;
                                                                        }
                                                                    }
                                                                    long j5 = j4;
                                                                    j4 = j;
                                                                    j = j5;
                                                                } else {
                                                                    j4 = j;
                                                                    j = currentTimeMillis2;
                                                                }
                                                                currentTimeMillis2 = j;
                                                                currentTimeMillis = j2;
                                                                j = j4;
                                                                j2 = j3;
                                                                j4 = a;
                                                            } catch (Throwable th22) {
                                                                th52 = th22;
                                                                closeable3 = inflaterInputStream;
                                                                closeable2 = inputStream;
                                                                obj = fileOutputStream;
                                                                j = j3;
                                                            } catch (Throwable th6) {
                                                                th22 = th6;
                                                                j2 = j3;
                                                            }
                                                        } else if (this.b == null || c(true, z3)) {
                                                            this.s = true;
                                                            if (this.b != null) {
                                                                z4 = true;
                                                            }
                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-311);
                                                            j = j2;
                                                        } else if (z || !a(false)) {
                                                            this.s = true;
                                                            z4 = false;
                                                            j = j2;
                                                        } else {
                                                            apnType = 1;
                                                            j = j2;
                                                        }
                                                    } catch (Throwable th222) {
                                                        th52 = th222;
                                                        obj = fileOutputStream;
                                                        j = j2;
                                                        closeable3 = inflaterInputStream;
                                                        closeable2 = inputStream;
                                                    } catch (Throwable th7) {
                                                        th222 = th7;
                                                    }
                                                }
                                                TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...Canceled!", true);
                                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                j = j2;
                                                if (r7 != null) {
                                                    a((Closeable) fileOutputStream);
                                                    a(inflaterInputStream);
                                                    a(inputStream);
                                                    if (!z) {
                                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                                        TbsDownloadConfig.getInstance(this.g).commit();
                                                    }
                                                } else {
                                                    j2 = j;
                                                }
                                            } catch (IOException e2) {
                                                th52 = e2;
                                                closeable3 = inflaterInputStream;
                                                closeable2 = inputStream;
                                                obj = fileOutputStream;
                                                th52.printStackTrace();
                                                if (th52 instanceof SocketTimeoutException) {
                                                }
                                                this.m = 100000;
                                                a(0);
                                                a(103, a(th52), false);
                                                a(closeable);
                                                a(closeable3);
                                                a(closeable2);
                                                if (z) {
                                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                                    TbsDownloadConfig.getInstance(this.g).commit();
                                                }
                                            } catch (Throwable th522) {
                                                j2 = j;
                                                th222 = th522;
                                                a((Closeable) fileOutputStream2);
                                                a(inflaterInputStream);
                                                a(inputStream);
                                                throw th222;
                                            }
                                        } catch (IOException e3) {
                                            th522 = e3;
                                            closeable2 = inputStream;
                                            th522.printStackTrace();
                                            if (th522 instanceof SocketTimeoutException) {
                                            }
                                            this.m = 100000;
                                            a(0);
                                            a(103, a(th522), false);
                                            a(closeable);
                                            a(closeable3);
                                            a(closeable2);
                                            if (z) {
                                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                                TbsDownloadConfig.getInstance(this.g).commit();
                                            }
                                        } catch (Throwable th5222) {
                                            inflaterInputStream = null;
                                            fileOutputStream2 = null;
                                            j2 = j;
                                            th222 = th5222;
                                            a((Closeable) fileOutputStream2);
                                            a(inflaterInputStream);
                                            a(inputStream);
                                            throw th222;
                                        }
                                    }
                                    inflaterInputStream = null;
                                    fileOutputStream2 = null;
                                    j2 = j;
                                    a((Closeable) fileOutputStream2);
                                    a(inflaterInputStream);
                                    a(inputStream);
                                    if (!this.s) {
                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-319);
                                    }
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } catch (IOException e4) {
                                    th5222 = e4;
                                    th5222.printStackTrace();
                                    if (th5222 instanceof SocketTimeoutException) {
                                    }
                                    this.m = 100000;
                                    a(0);
                                    a(103, a(th5222), false);
                                    a(closeable);
                                    a(closeable3);
                                    a(closeable2);
                                    if (z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } catch (Throwable th52222) {
                                    inflaterInputStream = null;
                                    inputStream = null;
                                    fileOutputStream2 = null;
                                    j2 = j;
                                    th222 = th52222;
                                    a((Closeable) fileOutputStream2);
                                    a(inflaterInputStream);
                                    a(inputStream);
                                    throw th222;
                                }
                            }
                            TbsLog.i(TbsDownloader.LOGTAG, "DownloadBegin tbsApkFileSize=" + j2 + "  but contentLength=" + this.l, true);
                            if (z || !(n() || (QbSdk.getDownloadWithoutWifi() && Apn.isNetworkAvailable(this.g)))) {
                                a(101, "WifiNetworkUnAvailable", true);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                            } else if (this.b == null || !a(false)) {
                                a(113, "tbsApkFileSize=" + j2 + "  but contentLength=" + this.l, true);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-310);
                            } else if (!z) {
                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                TbsDownloadConfig.getInstance(this.g).commit();
                            }
                            if (!z) {
                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                TbsDownloadConfig.getInstance(this.g).commit();
                            }
                        } else if (apnType < 300 || apnType > 307) {
                            a(102, String.valueOf(apnType), false);
                            if (apnType != 416) {
                                if (apnType == 403 || apnType == 406) {
                                    if (this.l == -1) {
                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-314);
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                            TbsDownloadConfig.getInstance(this.g).commit();
                                        }
                                    }
                                }
                                if (apnType == 202) {
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else if (this.p < this.B && apnType == 503) {
                                    a(Long.parseLong(this.t.getHeaderField(HttpHeaders.RETRY_AFTER)));
                                    if (this.r) {
                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                            TbsDownloadConfig.getInstance(this.g).commit();
                                        }
                                    } else if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else if (this.p < this.B && (apnType == 408 || apnType == 504 || apnType == 502 || apnType == 408)) {
                                    a(0);
                                    if (this.r) {
                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                            TbsDownloadConfig.getInstance(this.g).commit();
                                        }
                                    } else if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else if (k() > 0 || this.o || apnType == 410) {
                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-315);
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else {
                                    this.o = true;
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                }
                            } else if (c(true, z3)) {
                                z4 = true;
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            } else {
                                c(false);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-313);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            }
                        } else {
                            r7 = this.t.getHeaderField(HttpHeaders.LOCATION);
                            if (TextUtils.isEmpty(r7)) {
                                a(ErrorCode.DOWNLOAD_REDIRECT_EMPTY, null, true);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-312);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            } else {
                                this.j = r7;
                                this.q++;
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            }
                        }
                    }
                    if (this.r) {
                        if (this.s) {
                            if (this.b == null && !r6) {
                                z4 = c(true, z3);
                            }
                            if (z4) {
                            }
                            this.v.setUnpkgFlag(z4 ? 0 : 1);
                            if (z3) {
                                if (z4) {
                                }
                                this.v.setPatchUpdateFlag(z4 ? 2 : 1);
                            } else {
                                this.v.setPatchUpdateFlag(0);
                            }
                            if (z4) {
                                b(true);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                a(100, "success", true);
                            } else {
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                c(false);
                            }
                        }
                        instance = TbsDownloadConfig.getInstance(this.g);
                        if (z4) {
                            instance.a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) + 1));
                        } else {
                            i = instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) + 1;
                            instance.a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(i));
                            if (i == instance.getDownloadFailedMaxRetrytimes()) {
                                this.v.setDownloadCancel(2);
                            }
                        }
                        instance.commit();
                        if (z4) {
                        }
                        this.v.setDownFinalFlag(z4 ? 0 : 1);
                    }
                    f();
                    return;
                } else {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] WIFI Unavailable");
                    QbSdk.j.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                    return;
                }
            }
            TbsDownloader.a = false;
            return;
        }
        TbsDownloader.a = false;
        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-322);
        return;
        if (!z) {
            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
            TbsDownloadConfig.getInstance(this.g).commit();
        }
        throw th222;
        if (!(th52222 instanceof SSLHandshakeException) || z || this.b == null || !a(false)) {
            try {
                th52222.printStackTrace();
                a(0);
                a(107, a(th52222), false);
                if (this.r) {
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                    if (!z) {
                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
                        TbsDownloadConfig.getInstance(this.g).commit();
                    }
                    if (this.r) {
                        if (this.s) {
                            z4 = c(true, z3);
                            if (z4) {
                            }
                            this.v.setUnpkgFlag(z4 ? 0 : 1);
                            if (z3) {
                                if (z4) {
                                }
                                this.v.setPatchUpdateFlag(z4 ? 2 : 1);
                            } else {
                                this.v.setPatchUpdateFlag(0);
                            }
                            if (z4) {
                                b(true);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                a(100, "success", true);
                            } else {
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                c(false);
                            }
                        }
                        instance = TbsDownloadConfig.getInstance(this.g);
                        if (z4) {
                            instance.a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) + 1));
                        } else {
                            i = instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) + 1;
                            instance.a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(i));
                            if (i == instance.getDownloadFailedMaxRetrytimes()) {
                                this.v.setDownloadCancel(2);
                            }
                        }
                        instance.commit();
                        if (z4) {
                        }
                        this.v.setDownFinalFlag(z4 ? 0 : 1);
                    }
                    f();
                    return;
                }
            } catch (Throwable th8) {
                j2 = j;
                th222 = th8;
            }
        } else {
            TbsLog.e(TbsDownloader.LOGTAG, "[startdownload]url:" + this.j + " download exception：" + th52222.toString());
            a(ErrorCode.DOWNLOAD_THROWABLE, null, true);
        }
        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-316);
        if (!z) {
            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j));
            TbsDownloadConfig.getInstance(this.g).commit();
        }
    }

    public void c() {
        b();
        c(false);
        c(true);
    }

    public boolean d() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
        return this.C;
    }
}
