package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.p;
import com.tencent.smtt.utils.w;
import com.tencent.smtt.utils.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;

class TbsLogReport {
    private static TbsLogReport a;
    private Handler b = null;
    private Context c;

    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4);
        
        int a;

        private EventType(int i) {
            this.a = i;
        }
    }

    public static class TbsLogInfo implements Cloneable {
        int a;
        private long b;
        private String c;
        private String d;
        private int e;
        private int f;
        private int g;
        private int h;
        private String i;
        private int j;
        private int k;
        private long l;
        private long m;
        private int n;
        private String o;
        private String p;
        private long q;

        private TbsLogInfo() {
            resetArgs();
        }

        protected Object clone() {
            Object clone;
            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
            }
            return clone;
        }

        public int getDownFinalFlag() {
            return this.k;
        }

        public void resetArgs() {
            this.b = 0;
            this.c = null;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 2;
            this.i = EnvironmentCompat.MEDIA_UNKNOWN;
            this.j = 0;
            this.k = 2;
            this.l = 0;
            this.m = 0;
            this.n = 1;
            this.a = 0;
            this.o = null;
            this.p = null;
            this.q = 0;
        }

        public void setApn(String str) {
            this.i = str;
        }

        public void setCheckErrorDetail(String str) {
            setErrorCode(108);
            this.o = str;
        }

        public void setDownConsumeTime(long j) {
            this.m += j;
        }

        public void setDownFinalFlag(int i) {
            this.k = i;
        }

        public void setDownloadCancel(int i) {
            this.g = i;
        }

        public void setDownloadSize(long j) {
            this.q += j;
        }

        public void setDownloadUrl(String str) {
            if (this.c == null) {
                this.c = str;
            } else {
                this.c += ";" + str;
            }
        }

        public void setErrorCode(int i) {
            if (!(i == 100 || i == 110 || i == ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR || i == 111 || i >= 400)) {
                TbsLog.i(TbsDownloader.LOGTAG, "error occured, errorCode:" + i, true);
            }
            if (i == 111) {
                TbsLog.i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.a = i;
        }

        public void setEventTime(long j) {
            this.b = j;
        }

        public void setFailDetail(String str) {
            if (str != null) {
                if (str.length() > 1024) {
                    str = str.substring(0, 1024);
                }
                this.p = str;
            }
        }

        public void setFailDetail(Throwable th) {
            if (th == null) {
                this.p = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.p = stackTraceString;
        }

        public void setHttpCode(int i) {
            this.e = i;
        }

        public void setNetworkChange(int i) {
            this.n = i;
        }

        public void setNetworkType(int i) {
            this.j = i;
        }

        public void setPatchUpdateFlag(int i) {
            this.f = i;
        }

        public void setPkgSize(long j) {
            this.l = j;
        }

        public void setResolveIp(String str) {
            this.d = str;
        }

        public void setUnpkgFlag(int i) {
            this.h = i;
        }
    }

    private static class a {
        private final String a;
        private final String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        private static void a(File file) {
            RandomAccessFile randomAccessFile;
            Exception e;
            Throwable th;
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile != null) {
                    try {
                        int parseInt = Integer.parseInt("00001000", 2);
                        randomAccessFile.seek(7);
                        int read = randomAccessFile.read();
                        if ((read & parseInt) > 0) {
                            randomAccessFile.seek(7);
                            randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
                e.printStackTrace();
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        }

        public void a() {
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream;
            Exception e;
            FileInputStream fileInputStream2;
            Throwable th;
            FileOutputStream fileOutputStream2;
            ZipOutputStream zipOutputStream = null;
            ZipOutputStream zipOutputStream2;
            try {
                fileOutputStream = new FileOutputStream(this.b);
                try {
                    zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                    try {
                        byte[] bArr = new byte[2048];
                        String str = this.a;
                        BufferedInputStream bufferedInputStream;
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                bufferedInputStream = new BufferedInputStream(fileInputStream, 2048);
                            } catch (Exception e2) {
                                e = e2;
                                bufferedInputStream = null;
                                fileInputStream2 = fileInputStream;
                                try {
                                    e.printStackTrace();
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e32) {
                                            e32.printStackTrace();
                                        }
                                    }
                                    a(new File(this.b));
                                    if (zipOutputStream2 != null) {
                                        try {
                                            zipOutputStream2.close();
                                        } catch (IOException e322) {
                                            e322.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e3222) {
                                            e3222.printStackTrace();
                                            return;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e42) {
                                            e42.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedInputStream = null;
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                            try {
                                zipOutputStream2.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf(HttpUtils.PATHS_SEPARATOR) + 1)));
                                while (true) {
                                    int read = bufferedInputStream.read(bArr, 0, 2048);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream2.write(bArr, 0, read);
                                }
                                zipOutputStream2.flush();
                                zipOutputStream2.closeEntry();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e32222) {
                                        e32222.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e322222) {
                                        e322222.printStackTrace();
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
                                fileInputStream2 = fileInputStream;
                                e.printStackTrace();
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                a(new File(this.b));
                                if (zipOutputStream2 != null) {
                                    zipOutputStream2.close();
                                }
                                if (fileOutputStream == null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            bufferedInputStream = null;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            a(new File(this.b));
                            if (zipOutputStream2 != null) {
                                zipOutputStream2.close();
                            }
                            if (fileOutputStream == null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedInputStream = null;
                            fileInputStream = null;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                        a(new File(this.b));
                        if (zipOutputStream2 != null) {
                            zipOutputStream2.close();
                        }
                        if (fileOutputStream == null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e7) {
                        e = e7;
                        zipOutputStream = zipOutputStream2;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            e.printStackTrace();
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e3222222) {
                                    e3222222.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 == null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e32222222) {
                                    e32222222.printStackTrace();
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            zipOutputStream2 = zipOutputStream;
                            fileOutputStream = fileOutputStream2;
                            if (zipOutputStream2 != null) {
                                try {
                                    zipOutputStream2.close();
                                } catch (IOException e422) {
                                    e422.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4222) {
                                    e4222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        if (zipOutputStream2 != null) {
                            zipOutputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (fileOutputStream2 == null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th8) {
                    th = th8;
                    zipOutputStream2 = null;
                    if (zipOutputStream2 != null) {
                        zipOutputStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                fileOutputStream2 = null;
                e.printStackTrace();
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (fileOutputStream2 == null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th9) {
                th = th9;
                zipOutputStream2 = null;
                fileOutputStream = null;
                if (zipOutputStream2 != null) {
                    zipOutputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    private TbsLogReport(Context context) {
        this.c = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new aw(this, handlerThread.getLooper());
    }

    public static TbsLogReport a(Context context) {
        if (a == null) {
            synchronized (TbsLogReport.class) {
                if (a == null) {
                    a = new TbsLogReport(context);
                }
            }
        }
        return a;
    }

    private String a(int i) {
        return i + "|";
    }

    private String a(long j) {
        String str = null;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
        }
        return str;
    }

    private String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        return stringBuilder.append(str).append("|").toString();
    }

    private void a(int i, TbsLogInfo tbsLogInfo) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a(i));
        stringBuilder.append(a(b.c(this.c)));
        stringBuilder.append(a(w.a(this.c)));
        stringBuilder.append(a(ao.a().g(this.c)));
        String str2 = Build.MODEL;
        try {
            str = new String(str2.getBytes(HTTP.UTF_8), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        stringBuilder.append(a(str));
        str = this.c.getPackageName();
        stringBuilder.append(a(str));
        if ("com.tencent.mm".equals(str)) {
            stringBuilder.append(a(b.a(this.c, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
        } else {
            stringBuilder.append(a(b.b(this.c)));
        }
        stringBuilder.append(a(a(tbsLogInfo.b)));
        stringBuilder.append(a(tbsLogInfo.c));
        stringBuilder.append(a(tbsLogInfo.d));
        stringBuilder.append(a(tbsLogInfo.e));
        stringBuilder.append(a(tbsLogInfo.f));
        stringBuilder.append(a(tbsLogInfo.g));
        stringBuilder.append(a(tbsLogInfo.h));
        stringBuilder.append(a(tbsLogInfo.i));
        stringBuilder.append(a(tbsLogInfo.j));
        stringBuilder.append(a(tbsLogInfo.k));
        stringBuilder.append(b(tbsLogInfo.q));
        stringBuilder.append(b(tbsLogInfo.l));
        stringBuilder.append(b(tbsLogInfo.m));
        stringBuilder.append(a(tbsLogInfo.n));
        stringBuilder.append(a(tbsLogInfo.a));
        stringBuilder.append(a(tbsLogInfo.o));
        stringBuilder.append(a(tbsLogInfo.p));
        stringBuilder.append(a(TbsDownloadConfig.getInstance(this.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        stringBuilder.append(a(b.f(this.c)));
        stringBuilder.append(a("3.2.0.1104_43200"));
        stringBuilder.append(false);
        SharedPreferences h = h();
        JSONArray e2 = e();
        e2.put(stringBuilder.toString());
        Editor edit = h.edit();
        edit.putString("tbs_download_upload", e2.toString());
        edit.commit();
        f();
    }

    private void a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.j.onInstallFinish(i);
        a(eventType, tbsLogInfo);
    }

    private String b(long j) {
        return j + "|";
    }

    private JSONArray e() {
        String string = h().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            return new JSONArray(string);
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    private void f() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray e = e();
        if (e == null || e.length() == 0) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] no data");
            return;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + e);
        try {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + n.a(x.a(this.c).c(), e.toString().getBytes(CommonUtil.UTF8), new ay(this), true) + " testcase: " + -1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void g() {
        Editor edit = h().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    private SharedPreferences h() {
        return this.c.getSharedPreferences("tbs_download_stat", 4);
    }

    public TbsLogInfo a() {
        return new TbsLogInfo();
    }

    public void a(int i, String str) {
        a(i, str, EventType.TYPE_INSTALL);
    }

    public void a(int i, String str, EventType eventType) {
        if (!(i == 200 || i == ErrorCode.COPY_INSTALL_SUCCESS || i == ErrorCode.INCRUPDATE_INSTALL_SUCCESS)) {
            TbsLog.i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i, true);
        }
        TbsLogInfo a = a();
        a.setFailDetail(str);
        a(i, a, eventType);
    }

    public void a(int i, Throwable th) {
        TbsLogInfo a = a();
        a.setFailDetail(th);
        a(i, a, EventType.TYPE_INSTALL);
    }

    public void a(EventType eventType, TbsLogInfo tbsLogInfo) {
        try {
            TbsLogInfo tbsLogInfo2 = (TbsLogInfo) tbsLogInfo.clone();
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = eventType.a;
            obtainMessage.obj = tbsLogInfo2;
            this.b.sendMessage(obtainMessage);
        } catch (Throwable th) {
            TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public void b() {
        if (Looper.myLooper() != am.a().getLooper()) {
            throw new RuntimeException("TbsLogReport.dailyReport must run in TbsHandlerThread");
        }
        this.b.sendEmptyMessage(601);
    }

    public void b(int i, String str) {
        TbsLogInfo a = a();
        a.setErrorCode(i);
        a.setEventTime(System.currentTimeMillis());
        a.setFailDetail(str);
        a(EventType.TYPE_LOAD, a);
    }

    public void b(int i, Throwable th) {
        String str = "NULL";
        if (th != null) {
            str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
        }
        b(i, str);
    }

    public void c() {
        File file;
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (Apn.getApnType(this.c) == 3) {
            String tbsLogFilePath = TbsLog.getTbsLogFilePath();
            if (tbsLogFilePath != null) {
                String b = p.a().b();
                String c = b.c(this.c);
                String f = b.f(this.c);
                byte[] bytes = c.getBytes();
                byte[] bytes2 = f.getBytes();
                try {
                    bytes = p.a().a(bytes);
                    bytes2 = p.a().a(bytes2);
                } catch (Exception e2) {
                }
                String b2 = p.b(bytes);
                String str = x.a(this.c).e() + b2 + "&aid=" + p.b(bytes2);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Charset", HTTP.UTF_8);
                hashMap.put("QUA2", w.a(this.c));
                ByteArrayOutputStream byteArrayOutputStream2;
                try {
                    File file2 = new File(k.a);
                    new a(tbsLogFilePath, k.a + "/tbslog_temp.zip").a();
                    file = new File(k.a, "tbslog_temp.zip");
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            bytes2 = new byte[8192];
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int read = fileInputStream.read(bytes2);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bytes2, 0, read);
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            }
                            byteArrayOutputStream2.flush();
                            bytes2 = p.a().a(byteArrayOutputStream2.toByteArray());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e5) {
                                }
                            }
                            if (file != null) {
                                file.delete();
                            }
                        } catch (Exception e6) {
                            e = e6;
                            byteArrayOutputStream2 = null;
                            try {
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e7) {
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e8) {
                                    }
                                }
                                if (file != null) {
                                    bytes2 = null;
                                } else {
                                    file.delete();
                                    bytes2 = null;
                                }
                                n.a(str + "&ek=" + b, hashMap, bytes2, new ax(this), false);
                            } catch (Throwable th2) {
                                th = th2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e9) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e10) {
                                    }
                                }
                                if (file != null) {
                                    file.delete();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (file != null) {
                                file.delete();
                            }
                            throw th;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        byteArrayOutputStream2 = null;
                        fileInputStream = null;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (file != null) {
                            file.delete();
                            bytes2 = null;
                        } else {
                            bytes2 = null;
                        }
                        n.a(str + "&ek=" + b, hashMap, bytes2, new ax(this), false);
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                    byteArrayOutputStream2 = null;
                    file = null;
                    fileInputStream = null;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    if (file != null) {
                        file.delete();
                        bytes2 = null;
                    } else {
                        bytes2 = null;
                    }
                    n.a(str + "&ek=" + b, hashMap, bytes2, new ax(this), false);
                } catch (Throwable th5) {
                    th = th5;
                    file = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (file != null) {
                        file.delete();
                    }
                    throw th;
                }
                n.a(str + "&ek=" + b, hashMap, bytes2, new ax(this), false);
            }
        }
    }

    public void d() {
        try {
            Editor edit = h().edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
    }
}
