package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import java.io.File;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jd.wjlogin_sdk.util.Config;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    static boolean a;
    private static String b;
    private static Context c;
    private static Handler d;
    private static String e;
    private static Object f = new byte[0];
    private static ah g;
    private static HandlerThread h;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;

    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    protected static File a(int i) {
        File file = null;
        for (String str : TbsShareManager.getCoreProviderAppList()) {
            if (!str.equals(c.getApplicationInfo().packageName)) {
                file = new File(k.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (file == null || !file.exists()) {
                    TbsLog.i(LOGTAG, "can not find local backup core file");
                } else if (a.a(c, file) == i) {
                    TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                } else {
                    TbsLog.i(LOGTAG, "version is not match");
                }
            }
        }
        return file;
    }

    static String a(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String str;
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = VERSION.RELEASE;
        try {
            str = new String(str2.getBytes(HTTP.UTF_8), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        str = locale.getLanguage();
        if (str != null) {
            stringBuffer.append(str.toLowerCase());
            str = locale.getCountry();
            if (str != null) {
                stringBuffer.append("-");
                stringBuffer.append(str.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(VERSION.CODENAME)) {
            str2 = Build.MODEL;
            try {
                str = new String(str2.getBytes(HTTP.UTF_8), "ISO8859-1");
            } catch (Exception e2) {
                str = str2;
            }
            if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        str = Build.ID.replaceAll("[一-龥]", "");
        if (str.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str);
        }
        str = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[]{stringBuffer});
        b = str;
        return str;
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static void a(boolean z, TbsDownloaderCallback tbsDownloaderCallback) {
        int i = 0;
        TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        d.removeMessages(100);
        Message obtain = Message.obtain(d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = 0;
        if (z) {
            i = 1;
        }
        obtain.arg1 = i;
        obtain.sendToTarget();
    }

    private static boolean a(Context context, boolean z, TbsDownloaderCallback tbsDownloaderCallback) {
        Matcher matcher = null;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        if (VERSION.SDK_INT < 8) {
            instance.setDownloadInterruptCode(Config.ERR_CODE_RESPONSE_DATA_ERR);
            return false;
        } else if (QbSdk.c || !TbsShareManager.isThirdPartyApp(c) || c()) {
            if (!instance.mPreferences.contains(TbsConfigKey.KEY_IS_OVERSEA)) {
                if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                    TbsLog.i(LOGTAG, "needDownload-oversea is true, but not WX");
                    z = false;
                }
                instance.a.put(TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z));
                instance.commit();
                j = z;
                TbsLog.i(LOGTAG, "needDownload-first-called--isoversea = " + z);
            }
            if (!getOverSea(context) || VERSION.SDK_INT == 16 || VERSION.SDK_INT == 17 || VERSION.SDK_INT == 18) {
                e = instance.mPreferences.getString(TbsConfigKey.KEY_DEVICE_CPUABI, matcher);
                if (!TextUtils.isEmpty(e)) {
                    try {
                        matcher = Pattern.compile("i686|mips|x86_64").matcher(e);
                    } catch (Exception e) {
                    }
                    if (matcher != null && matcher.find()) {
                        if (tbsDownloaderCallback != null) {
                            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                        }
                        instance.setDownloadInterruptCode(-104);
                        return false;
                    }
                }
                return true;
            }
            TbsLog.i(LOGTAG, "needDownload- return false,  because of  version is " + VERSION.SDK_INT + ", and overea");
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            instance.setDownloadInterruptCode(Config.ERR_CODE_SDK_BLOCKED);
            return false;
        } else if (tbsDownloaderCallback == null) {
            return false;
        } else {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            return false;
        }
    }

    private static boolean a(Context context, boolean z, boolean z2) {
        boolean z3;
        String str;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        if (z) {
            z3 = true;
            str = null;
        } else {
            String string = instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i = instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null);
            String a = b.a(c);
            int b = b.b(c);
            String a2 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + a + " oldAppVersionName=" + string + " appVersionCode=" + b + " oldAppVersionCode=" + i + " appMetadata=" + a2 + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j = instance.mPreferences.getLong(TbsConfigKey.KEY_LAST_CHECK, 0);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + j + " timeNow=" + currentTimeMillis);
            if (z2) {
                boolean contains = instance.mPreferences.contains(TbsConfigKey.KEY_LAST_CHECK);
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + contains);
                if (contains && j == 0) {
                    j = currentTimeMillis;
                }
            }
            long retryInterval = instance.getRetryInterval();
            TbsLog.i(LOGTAG, "retryInterval = " + retryInterval + " s");
            if (currentTimeMillis - j > retryInterval * 1000) {
                z3 = true;
                str = null;
            } else if (TbsShareManager.isThirdPartyApp(c) && TbsShareManager.findCoreForThirdPartyApp(c) == 0 && !e()) {
                k.b(c.getDir("tbs", 0));
                ao.a.set(Integer.valueOf(0));
                z3 = true;
                str = null;
            } else {
                if (a == null || b == 0 || a2 == null) {
                    if (TbsShareManager.isThirdPartyApp(c)) {
                        str = "timeNow - timeLastCheck is " + (currentTimeMillis - j) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + a + " appVersionCode is " + b + " appMetadata is " + a2 + " oldAppVersionName is " + string + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + string2;
                        z3 = false;
                    }
                } else if (!(a.equals(string) && b == i && a2.equals(string2))) {
                    z3 = true;
                    str = null;
                }
                str = null;
                z3 = false;
            }
        }
        if (!z3 && TbsShareManager.isThirdPartyApp(c)) {
            TbsLogInfo a3 = TbsLogReport.a(c).a();
            a3.setErrorCode(-119);
            a3.setFailDetail(str);
            TbsLogReport.a(c).a(EventType.TYPE_DOWNLOAD, a3);
        }
        return z3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    private static boolean a(java.lang.String r28, int r29, boolean r30, boolean r31) {
        /*
        r2 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "[TbsDownloader.readResponse] response=";
        r3 = r3.append(r4);
        r0 = r28;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = c;
        r10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = android.text.TextUtils.isEmpty(r28);
        if (r2 == 0) goto L_0x0035;
    L_0x0026:
        if (r30 == 0) goto L_0x002f;
    L_0x0028:
        r2 = -108; // 0xffffffffffffff94 float:NaN double:NaN;
        r10.setDownloadInterruptCode(r2);
    L_0x002d:
        r2 = 0;
    L_0x002e:
        return r2;
    L_0x002f:
        r2 = -208; // 0xffffffffffffff30 float:NaN double:NaN;
        r10.setDownloadInterruptCode(r2);
        goto L_0x002d;
    L_0x0035:
        r11 = new org.json.JSONObject;
        r0 = r28;
        r11.<init>(r0);
        r2 = "RET";
        r2 = r11.getInt(r2);
        if (r2 == 0) goto L_0x0053;
    L_0x0044:
        if (r30 == 0) goto L_0x004d;
    L_0x0046:
        r2 = -109; // 0xffffffffffffff93 float:NaN double:NaN;
        r10.setDownloadInterruptCode(r2);
    L_0x004b:
        r2 = 0;
        goto L_0x002e;
    L_0x004d:
        r2 = -209; // 0xffffffffffffff2f float:NaN double:NaN;
        r10.setDownloadInterruptCode(r2);
        goto L_0x004b;
    L_0x0053:
        r2 = "RESPONSECODE";
        r12 = r11.getInt(r2);
        r2 = "DOWNLOADURL";
        r13 = r11.getString(r2);
        r2 = "URLLIST";
        r3 = "";
        r14 = r11.optString(r2, r3);
        r2 = "TBSAPKSERVERVERSION";
        r15 = r11.getInt(r2);
        r2 = "DOWNLOADMAXFLOW";
        r16 = r11.getInt(r2);
        r2 = "DOWNLOAD_MIN_FREE_SPACE";
        r17 = r11.getInt(r2);
        r2 = "DOWNLOAD_SUCCESS_MAX_RETRYTIMES";
        r18 = r11.getInt(r2);
        r2 = "DOWNLOAD_FAILED_MAX_RETRYTIMES";
        r19 = r11.getInt(r2);
        r2 = "DOWNLOAD_SINGLE_TIMEOUT";
        r20 = r11.getLong(r2);
        r2 = "TBSAPKFILESIZE";
        r22 = r11.getLong(r2);
        r2 = "RETRY_INTERVAL";
        r4 = 0;
        r8 = r11.optLong(r2, r4);
        r2 = "FLOWCTR";
        r3 = -1;
        r24 = r11.optInt(r2, r3);
        r2 = 0;
        r3 = "USEBBACKUPVER";
        r2 = r11.getInt(r3);	 Catch:{ Exception -> 0x04b6 }
    L_0x00a7:
        r3 = r10.a;
        r4 = "use_backup_version";
        r2 = java.lang.Integer.valueOf(r2);
        r3.put(r4, r2);
        r7 = 0;
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r3 = "";
        r2 = "PKGMD5";
        r7 = r11.getString(r2);	 Catch:{ Exception -> 0x0149 }
        r2 = "RESETX5";
        r6 = r11.getInt(r2);	 Catch:{ Exception -> 0x04af }
        r2 = "UPLOADLOG";
        r5 = r11.getInt(r2);	 Catch:{ Exception -> 0x04af }
        r2 = "RESETTOKEN";
        r2 = r11.has(r2);	 Catch:{ Exception -> 0x04af }
        if (r2 == 0) goto L_0x00dc;
    L_0x00d2:
        r2 = "RESETTOKEN";
        r2 = r11.getInt(r2);	 Catch:{ Exception -> 0x04af }
        if (r2 == 0) goto L_0x0147;
    L_0x00da:
        r2 = 1;
    L_0x00db:
        r4 = r2;
    L_0x00dc:
        r2 = "SETTOKEN";
        r2 = r11.has(r2);	 Catch:{ Exception -> 0x04af }
        if (r2 == 0) goto L_0x04bf;
    L_0x00e4:
        r2 = "SETTOKEN";
        r2 = r11.getString(r2);	 Catch:{ Exception -> 0x04af }
    L_0x00ea:
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
    L_0x00ee:
        r7 = f;
        monitor-enter(r7);
        if (r3 == 0) goto L_0x0100;
    L_0x00f3:
        r3 = r10.a;	 Catch:{ all -> 0x0154 }
        r25 = "tbs_deskey_token";
        r26 = "";
        r0 = r25;
        r1 = r26;
        r3.put(r0, r1);	 Catch:{ all -> 0x0154 }
    L_0x0100:
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0154 }
        if (r3 != 0) goto L_0x0134;
    L_0x0106:
        r3 = r2.length();	 Catch:{ all -> 0x0154 }
        r25 = 96;
        r0 = r25;
        if (r3 != r0) goto L_0x0134;
    L_0x0110:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0154 }
        r3.<init>();	 Catch:{ all -> 0x0154 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0154 }
        r3 = "&";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0154 }
        r3 = com.tencent.smtt.utils.p.c();	 Catch:{ all -> 0x0154 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0154 }
        r2 = r2.toString();	 Catch:{ all -> 0x0154 }
        r3 = r10.a;	 Catch:{ all -> 0x0154 }
        r25 = "tbs_deskey_token";
        r0 = r25;
        r3.put(r0, r2);	 Catch:{ all -> 0x0154 }
    L_0x0134:
        monitor-exit(r7);	 Catch:{ all -> 0x0154 }
        r2 = 1;
        if (r5 != r2) goto L_0x015d;
    L_0x0138:
        if (r30 == 0) goto L_0x0157;
    L_0x013a:
        r2 = -110; // 0xffffffffffffff92 float:NaN double:NaN;
        r10.setDownloadInterruptCode(r2);
    L_0x013f:
        r2 = c;
        com.tencent.smtt.sdk.QbSdk.reset(r2);
        r2 = 0;
        goto L_0x002e;
    L_0x0147:
        r2 = 0;
        goto L_0x00db;
    L_0x0149:
        r2 = move-exception;
        r2 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
    L_0x014e:
        r27 = r3;
        r3 = r2;
        r2 = r27;
        goto L_0x00ee;
    L_0x0154:
        r2 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0154 }
        throw r2;
    L_0x0157:
        r2 = -210; // 0xffffffffffffff2e float:NaN double:NaN;
        r10.setDownloadInterruptCode(r2);
        goto L_0x013f;
    L_0x015d:
        r2 = 1;
        if (r4 != r2) goto L_0x0172;
    L_0x0160:
        r2 = d;
        r3 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r2.removeMessages(r3);
        r2 = d;
        r3 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r2 = android.os.Message.obtain(r2, r3);
        r2.sendToTarget();
    L_0x0172:
        r4 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r2 = 1;
        r0 = r24;
        if (r0 != r2) goto L_0x04b9;
    L_0x017a:
        r2 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x04bc;
    L_0x0181:
        r2 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
    L_0x0184:
        r8 = 0;
        r7 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r7 <= 0) goto L_0x04b9;
    L_0x018a:
        r4 = r10.a;
        r5 = "retry_interval";
        r2 = java.lang.Long.valueOf(r2);
        r4.put(r5, r2);
        r2 = 0;
        r3 = "DECOUPLECOREVERSION";
        r11.getInt(r3);	 Catch:{ Exception -> 0x04ac }
        r3 = c;	 Catch:{ Exception -> 0x04ac }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);	 Catch:{ Exception -> 0x04ac }
        r3 = r3.mPreferences;	 Catch:{ Exception -> 0x04ac }
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r2 = r3.getInt(r4, r5);	 Catch:{ Exception -> 0x04ac }
    L_0x01aa:
        r3 = 0;
        r4 = r10.a;
        r5 = "tbs_decouplecoreversion";
        r3 = java.lang.Integer.valueOf(r3);
        r4.put(r5, r3);
        r3 = r10.a;
        r4 = "tbs_downloaddecouplecore";
        r2 = java.lang.Integer.valueOf(r2);
        r3.put(r4, r2);
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r2);
        if (r2 != 0) goto L_0x01d6;
    L_0x01c9:
        r2 = com.tencent.smtt.sdk.ao.a();	 Catch:{ Throwable -> 0x04a9 }
        r3 = c;	 Catch:{ Throwable -> 0x04a9 }
        r2 = r2.j(r3);	 Catch:{ Throwable -> 0x04a9 }
        com.tencent.smtt.utils.k.b(r2);	 Catch:{ Throwable -> 0x04a9 }
    L_0x01d6:
        r2 = android.text.TextUtils.isEmpty(r13);
        if (r2 == 0) goto L_0x01fe;
    L_0x01dc:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r2);
        if (r2 == 0) goto L_0x01fe;
    L_0x01e4:
        r2 = r10.a;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r10.commit();
        if (r30 == 0) goto L_0x01fb;
    L_0x01f5:
        r2 = c;
        r3 = 0;
        com.tencent.smtt.sdk.TbsShareManager.writeCoreInfoForThirdPartyApp(r2, r15, r3);
    L_0x01fb:
        r2 = 0;
        goto L_0x002e;
    L_0x01fe:
        if (r12 != 0) goto L_0x024a;
    L_0x0200:
        r2 = r10.a;
        r3 = "tbs_responsecode";
        r4 = java.lang.Integer.valueOf(r12);
        r2.put(r3, r4);
        r2 = r10.a;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        if (r30 == 0) goto L_0x0237;
    L_0x0219:
        r2 = r10.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -111; // 0xffffffffffffff91 float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x0226:
        r10.commit();
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r2);
        if (r2 != 0) goto L_0x0234;
    L_0x0231:
        startDecoupleCoreIfNeeded();
    L_0x0234:
        r2 = 0;
        goto L_0x002e;
    L_0x0237:
        r2 = r10.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -211; // 0xffffffffffffff2d float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = -211; // 0xffffffffffffff2d float:NaN double:NaN;
        r10.setDownloadInterruptCode(r2);
        goto L_0x0226;
    L_0x024a:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.mPreferences;
        r3 = "tbs_download_version";
        r4 = 0;
        r3 = r2.getInt(r3, r4);
        if (r3 <= r15) goto L_0x0269;
    L_0x025b:
        r2 = g;
        r2.c();
        r2 = com.tencent.smtt.sdk.ao.a();
        r4 = c;
        r2.i(r4);
    L_0x0269:
        r0 = r29;
        if (r0 >= r15) goto L_0x0273;
    L_0x026d:
        r2 = android.text.TextUtils.isEmpty(r13);
        if (r2 == 0) goto L_0x0328;
    L_0x0273:
        r2 = r10.a;
        r4 = "tbs_needdownload";
        r5 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        r2.put(r4, r5);
        if (r30 == 0) goto L_0x0302;
    L_0x0281:
        r2 = android.text.TextUtils.isEmpty(r13);
        if (r2 == 0) goto L_0x02d2;
    L_0x0287:
        r2 = r10.a;
        r4 = "tbs_download_interrupt_code_reason";
        r5 = -124; // 0xffffffffffffff84 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
    L_0x0294:
        r10.commit();
        r2 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "version error or downloadUrl empty ,return ahead tbsLocalVersion=";
        r4 = r4.append(r5);
        r0 = r29;
        r4 = r4.append(r0);
        r5 = " tbsDownloadVersion=";
        r4 = r4.append(r5);
        r4 = r4.append(r15);
        r5 = " tbsLastDownloadVersion=";
        r4 = r4.append(r5);
        r3 = r4.append(r3);
        r4 = " downloadUrl=";
        r3 = r3.append(r4);
        r3 = r3.append(r13);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = 0;
        goto L_0x002e;
    L_0x02d2:
        if (r15 > 0) goto L_0x02e2;
    L_0x02d4:
        r2 = r10.a;
        r4 = "tbs_download_interrupt_code_reason";
        r5 = -125; // 0xffffffffffffff83 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        goto L_0x0294;
    L_0x02e2:
        r0 = r29;
        if (r0 < r15) goto L_0x02f4;
    L_0x02e6:
        r2 = r10.a;
        r4 = "tbs_download_interrupt_code_reason";
        r5 = -127; // 0xffffffffffffff81 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        goto L_0x0294;
    L_0x02f4:
        r2 = r10.a;
        r4 = "tbs_download_interrupt_code_reason";
        r5 = -112; // 0xffffffffffffff90 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        goto L_0x0294;
    L_0x0302:
        r2 = -212; // 0xffffffffffffff2c float:NaN double:NaN;
        r4 = android.text.TextUtils.isEmpty(r13);
        if (r4 == 0) goto L_0x031c;
    L_0x030a:
        r2 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
    L_0x030c:
        r4 = r10.a;
        r5 = "tbs_download_interrupt_code_reason";
        r6 = java.lang.Integer.valueOf(r2);
        r4.put(r5, r6);
        r10.setDownloadInterruptCode(r2);
        goto L_0x0294;
    L_0x031c:
        if (r15 > 0) goto L_0x0321;
    L_0x031e:
        r2 = -218; // 0xffffffffffffff26 float:NaN double:NaN;
        goto L_0x030c;
    L_0x0321:
        r0 = r29;
        if (r0 < r15) goto L_0x030c;
    L_0x0325:
        r2 = -219; // 0xffffffffffffff25 float:NaN double:NaN;
        goto L_0x030c;
    L_0x0328:
        r2 = r10.mPreferences;
        r3 = "tbs_downloadurl";
        r4 = 0;
        r2 = r2.getString(r3, r4);
        r2 = r13.equals(r2);
        if (r2 != 0) goto L_0x0354;
    L_0x0337:
        r2 = g;
        r2.c();
        r2 = r10.a;
        r3 = "tbs_download_failed_retrytimes";
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = r10.a;
        r3 = "tbs_download_success_retrytimes";
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x0354:
        r2 = r10.a;
        r3 = "tbs_download_version";
        r4 = java.lang.Integer.valueOf(r15);
        r2.put(r3, r4);
        r2 = r10.a;
        r3 = "tbs_downloadurl";
        r2.put(r3, r13);
        r2 = r10.a;
        r3 = "tbs_downloadurl_list";
        r2.put(r3, r14);
        r2 = r10.a;
        r3 = "tbs_responsecode";
        r4 = java.lang.Integer.valueOf(r12);
        r2.put(r3, r4);
        r2 = r10.a;
        r3 = "tbs_download_maxflow";
        r4 = java.lang.Integer.valueOf(r16);
        r2.put(r3, r4);
        r2 = r10.a;
        r3 = "tbs_download_min_free_space";
        r4 = java.lang.Integer.valueOf(r17);
        r2.put(r3, r4);
        r2 = r10.a;
        r3 = "tbs_download_success_max_retrytimes";
        r4 = java.lang.Integer.valueOf(r18);
        r2.put(r3, r4);
        r2 = r10.a;
        r3 = "tbs_download_failed_max_retrytimes";
        r4 = java.lang.Integer.valueOf(r19);
        r2.put(r3, r4);
        r2 = r10.a;
        r3 = "tbs_single_timeout";
        r4 = java.lang.Long.valueOf(r20);
        r2.put(r3, r4);
        r2 = r10.a;
        r3 = "tbs_apkfilesize";
        r4 = java.lang.Long.valueOf(r22);
        r2.put(r3, r4);
        r10.commit();
        if (r6 == 0) goto L_0x03c6;
    L_0x03bf:
        r2 = r10.a;
        r3 = "tbs_apk_md5";
        r2.put(r3, r6);
    L_0x03c6:
        if (r31 != 0) goto L_0x041e;
    L_0x03c8:
        r2 = com.tencent.smtt.sdk.ao.a();
        r3 = c;
        r2 = r2.a(r3, r15);
        if (r2 == 0) goto L_0x041e;
    L_0x03d4:
        if (r30 == 0) goto L_0x040b;
    L_0x03d6:
        r2 = r10.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -113; // 0xffffffffffffff8f float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x03e3:
        r2 = r10.a;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
    L_0x03ef:
        r2 = "stop_pre_oat";
        r3 = 0;
        r2 = r11.optInt(r2, r3);
        r3 = 1;
        if (r2 != r3) goto L_0x0405;
    L_0x03f9:
        r2 = r10.a;
        r3 = "tbs_stop_preoat";
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
    L_0x0405:
        r10.commit();
        r2 = 1;
        goto L_0x002e;
    L_0x040b:
        r2 = r10.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        r10.setDownloadInterruptCode(r2);
        goto L_0x03e3;
    L_0x041e:
        if (r31 != 0) goto L_0x0494;
    L_0x0420:
        r3 = g;
        r2 = 1;
        if (r12 == r2) goto L_0x0428;
    L_0x0425:
        r2 = 2;
        if (r12 != r2) goto L_0x0485;
    L_0x0428:
        r2 = 1;
    L_0x0429:
        r0 = r31;
        r2 = r3.a(r0, r2);
        if (r2 == 0) goto L_0x0494;
    L_0x0431:
        r2 = r10.a;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsLogReport.a(r2);
        r2 = r2.a();
        r3 = 100;
        r2.setErrorCode(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "use local backup apk in needDownload";
        r3 = r3.append(r4);
        r4 = g;
        r4 = r4.a;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.setFailDetail(r3);
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.mPreferences;
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r3 = r3.getInt(r4, r5);
        r4 = 1;
        if (r3 != r4) goto L_0x0487;
    L_0x0478:
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r3);
        r4 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
        r3.a(r4, r2);
        goto L_0x03ef;
    L_0x0485:
        r2 = 0;
        goto L_0x0429;
    L_0x0487:
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r3);
        r4 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
        r3.a(r4, r2);
        goto L_0x03ef;
    L_0x0494:
        if (r30 != 0) goto L_0x049b;
    L_0x0496:
        r2 = -216; // 0xffffffffffffff28 float:NaN double:NaN;
        r10.setDownloadInterruptCode(r2);
    L_0x049b:
        r2 = r10.a;
        r3 = "tbs_needdownload";
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        goto L_0x03ef;
    L_0x04a9:
        r2 = move-exception;
        goto L_0x01d6;
    L_0x04ac:
        r3 = move-exception;
        goto L_0x01aa;
    L_0x04af:
        r2 = move-exception;
        r2 = r4;
        r4 = r5;
        r5 = r6;
        r6 = r7;
        goto L_0x014e;
    L_0x04b6:
        r3 = move-exception;
        goto L_0x00a7;
    L_0x04b9:
        r2 = r4;
        goto L_0x018a;
    L_0x04bc:
        r2 = r8;
        goto L_0x0184;
    L_0x04bf:
        r2 = r3;
        goto L_0x00ea;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(java.lang.String, int, boolean, boolean):boolean");
    }

    private static JSONObject b(boolean z, boolean z2, boolean z3) {
        JSONObject jSONObject;
        int g;
        int i;
        JSONArray h;
        Object obj = null;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        String a = a(c);
        String d = b.d(c);
        String c = b.c(c);
        String f = b.f(c);
        String str = "";
        String str2 = "";
        String str3 = "";
        str3 = TimeZone.getDefault().getID();
        if (str3 != null) {
            Object obj2 = str3;
        } else {
            String str4 = str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
            if (telephonyManager != null) {
                Object simCountryIso;
                simCountryIso = telephonyManager.getSimCountryIso();
                if (simCountryIso == null) {
                    str = str2;
                }
                jSONObject = new JSONObject();
                jSONObject.put("TIMEZONEID", obj2);
                jSONObject.put("COUNTRYISO", simCountryIso);
                jSONObject.put("PROTOCOLVERSION", 1);
                if (TbsShareManager.isThirdPartyApp(c)) {
                    g = ao.a().g(c);
                    if (g == 0 && ao.a().f(c)) {
                        g = -1;
                    }
                    TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + g + " isDownloadForeground=" + z2);
                    if (z2) {
                        i = g;
                    } else {
                        if (!ao.a().f(c)) {
                            g = 0;
                        }
                        i = g;
                    }
                } else {
                    i = QbSdk.c ? TbsShareManager.a(c, false) : TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                }
                if (z) {
                    jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                } else {
                    jSONObject.put("FUNCTION", 2);
                }
                if (TbsShareManager.isThirdPartyApp(c)) {
                    h = h();
                    if (Apn.getApnType(c) != 3 && h.length() != 0 && i == 0 && z) {
                        jSONObject.put("TBSBACKUPARR", h);
                    }
                } else {
                    h = f();
                    jSONObject.put("TBSVLARR", h);
                    instance.a.put(TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, h.toString());
                    instance.commit();
                    if (QbSdk.c) {
                        jSONObject.put("THIRDREQ", 1);
                    }
                }
                jSONObject.put("APPN", c.getPackageName());
                jSONObject.put("APPVN", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null)));
                jSONObject.put("APPVC", instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0));
                jSONObject.put("APPMETA", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null)));
                jSONObject.put("TBSSDKV", 43200);
                jSONObject.put("TBSV", i);
                jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                instance.a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
                instance.commit();
                if (i != 0) {
                    jSONObject.put("TBSBACKUPV", g.a());
                }
                jSONObject.put("CPU", e);
                jSONObject.put("UA", a);
                jSONObject.put("IMSI", a(d));
                jSONObject.put("IMEI", a(c));
                jSONObject.put("ANDROID_ID", a(f));
                if (!TbsShareManager.isThirdPartyApp(c)) {
                    if (i == 0) {
                        jSONObject.put("STATUS", QbSdk.a(c, i) ? 0 : 1);
                    } else {
                        jSONObject.put("STATUS", 0);
                    }
                }
                boolean z4 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean(TbsConfigKey.KEY_FULL_PACKAGE, false);
                simCountryIso = QbSdk.a(c, "can_unlzma", null);
                boolean booleanValue = (simCountryIso == null && (simCountryIso instanceof Boolean)) ? ((Boolean) simCountryIso).booleanValue() : false;
                if (booleanValue && !z4) {
                    obj = 1;
                }
                if (obj != null) {
                    jSONObject.put("REQUEST_LZMA", 1);
                }
                if (getOverSea(c)) {
                    jSONObject.put("OVERSEA", 1);
                }
                if (z2) {
                    jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                return jSONObject;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        str = str3;
        if (simCountryIso == null) {
            str = str2;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("TIMEZONEID", obj2);
            jSONObject.put("COUNTRYISO", simCountryIso);
            jSONObject.put("PROTOCOLVERSION", 1);
            if (TbsShareManager.isThirdPartyApp(c)) {
                g = ao.a().g(c);
                g = -1;
                TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + g + " isDownloadForeground=" + z2);
                if (z2) {
                    i = g;
                } else {
                    if (ao.a().f(c)) {
                        g = 0;
                    }
                    i = g;
                }
            } else if (QbSdk.c) {
            }
            if (z) {
                if (i != 0) {
                }
                jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
            } else {
                jSONObject.put("FUNCTION", 2);
            }
            if (TbsShareManager.isThirdPartyApp(c)) {
                h = h();
                jSONObject.put("TBSBACKUPARR", h);
            } else {
                h = f();
                jSONObject.put("TBSVLARR", h);
                instance.a.put(TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, h.toString());
                instance.commit();
                if (QbSdk.c) {
                    jSONObject.put("THIRDREQ", 1);
                }
            }
            jSONObject.put("APPN", c.getPackageName());
            jSONObject.put("APPVN", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 43200);
            jSONObject.put("TBSV", i);
            if (z3) {
            }
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            if (z3) {
            }
            instance.a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
            instance.commit();
            if (i != 0) {
                jSONObject.put("TBSBACKUPV", g.a());
            }
            jSONObject.put("CPU", e);
            jSONObject.put("UA", a);
            jSONObject.put("IMSI", a(d));
            jSONObject.put("IMEI", a(c));
            jSONObject.put("ANDROID_ID", a(f));
            if (TbsShareManager.isThirdPartyApp(c)) {
                if (i == 0) {
                    jSONObject.put("STATUS", 0);
                } else {
                    if (QbSdk.a(c, i)) {
                    }
                    jSONObject.put("STATUS", QbSdk.a(c, i) ? 0 : 1);
                }
            }
            boolean z42 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean(TbsConfigKey.KEY_FULL_PACKAGE, false);
            simCountryIso = QbSdk.a(c, "can_unlzma", null);
            if (simCountryIso == null) {
            }
            obj = 1;
            if (obj != null) {
                jSONObject.put("REQUEST_LZMA", 1);
            }
            if (getOverSea(c)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", 1);
            }
        } catch (Exception e2) {
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    @TargetApi(11)
    static void b(Context context) {
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.a(context).d();
        ah.c(context);
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    private static boolean b(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    private static boolean c() {
        try {
            for (String sharedTbsCoreVersion : TbsShareManager.getCoreProviderAppList()) {
                if (TbsShareManager.getSharedTbsCoreVersion(c, sharedTbsCoreVersion) > 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c(boolean r12, boolean r13, boolean r14) {
        /*
        r1 = 1;
        r3 = -1;
        r11 = -104; // 0xffffffffffffff98 float:NaN double:NaN;
        r10 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
        r2 = 0;
        r0 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "[TbsDownloader.sendRequest]isQuery: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r4);
        r0 = com.tencent.smtt.sdk.ao.a();
        r4 = c;
        r0 = r0.b(r4);
        if (r0 == 0) goto L_0x0033;
    L_0x002b:
        r0 = "TbsDownload";
        r1 = "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
    L_0x0032:
        return r2;
    L_0x0033:
        r0 = c;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r0);
        r5 = new java.io.File;
        r0 = c;
        r6 = com.tencent.smtt.utils.k.a(r0, r1);
        r0 = c;
        r0 = getOverSea(r0);
        if (r0 == 0) goto L_0x019d;
    L_0x0049:
        r0 = "x5.oversea.tbs.org";
    L_0x004b:
        r5.<init>(r6, r0);
        r6 = new java.io.File;
        r0 = c;
        r7 = 2;
        r7 = com.tencent.smtt.utils.k.a(r0, r7);
        r0 = c;
        r0 = getOverSea(r0);
        if (r0 == 0) goto L_0x01a1;
    L_0x005f:
        r0 = "x5.oversea.tbs.org";
    L_0x0061:
        r6.<init>(r7, r0);
        r7 = new java.io.File;
        r0 = c;
        r8 = 3;
        r8 = com.tencent.smtt.utils.k.a(r0, r8);
        r0 = c;
        r0 = getOverSea(r0);
        if (r0 == 0) goto L_0x01a5;
    L_0x0075:
        r0 = "x5.oversea.tbs.org";
    L_0x0077:
        r7.<init>(r8, r0);
        r8 = new java.io.File;
        r0 = c;
        r9 = 4;
        r9 = com.tencent.smtt.utils.k.a(r0, r9);
        r0 = c;
        r0 = getOverSea(r0);
        if (r0 == 0) goto L_0x01a9;
    L_0x008b:
        r0 = "x5.oversea.tbs.org";
    L_0x008d:
        r8.<init>(r9, r0);
        r0 = r8.exists();
        if (r0 != 0) goto L_0x009f;
    L_0x0096:
        r0 = r7.exists();
        if (r0 == 0) goto L_0x01ad;
    L_0x009c:
        r7.renameTo(r8);
    L_0x009f:
        r0 = e;
        if (r0 != 0) goto L_0x00b5;
    L_0x00a3:
        r0 = com.tencent.smtt.utils.b.a();
        e = r0;
        r0 = r4.a;
        r5 = "device_cpuabi";
        r6 = e;
        r0.put(r5, r6);
        r4.commit();
    L_0x00b5:
        r0 = e;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x01f2;
    L_0x00bd:
        r0 = 0;
        r5 = "i686|mips|x86_64";
        r5 = java.util.regex.Pattern.compile(r5);	 Catch:{ Exception -> 0x01ef }
        r6 = e;	 Catch:{ Exception -> 0x01ef }
        r0 = r5.matcher(r6);	 Catch:{ Exception -> 0x01ef }
    L_0x00ca:
        if (r0 == 0) goto L_0x01f2;
    L_0x00cc:
        r0 = r0.find();
        if (r0 == 0) goto L_0x01f2;
    L_0x00d2:
        r0 = c;
        r0 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r0);
        if (r0 == 0) goto L_0x01cb;
    L_0x00da:
        r0 = c;
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r0);
        r0 = r0.a();
        if (r12 == 0) goto L_0x01c3;
    L_0x00e6:
        r4.setDownloadInterruptCode(r11);
        r0.setErrorCode(r11);
    L_0x00ec:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "mycpu is ";
        r5 = r5.append(r6);
        r6 = e;
        r5 = r5.append(r6);
        r5 = r5.toString();
        r0.setFailDetail(r5);
        r5 = c;
        r5 = com.tencent.smtt.sdk.TbsLogReport.a(r5);
        r6 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
        r5.a(r6, r0);
    L_0x010f:
        r0 = r1;
    L_0x0110:
        r5 = b(r12, r13, r14);
        r1 = "TBSV";
        r1 = r5.getInt(r1);	 Catch:{ Exception -> 0x01d7 }
    L_0x011a:
        if (r0 != 0) goto L_0x011e;
    L_0x011c:
        if (r1 == r3) goto L_0x015f;
    L_0x011e:
        r6 = java.lang.System.currentTimeMillis();
        r8 = r4.a;
        r9 = "last_check";
        r6 = java.lang.Long.valueOf(r6);
        r8.put(r9, r6);
        r6 = r4.a;
        r7 = "app_versionname";
        r8 = c;
        r8 = com.tencent.smtt.utils.b.a(r8);
        r6.put(r7, r8);
        r6 = r4.a;
        r7 = "app_versioncode";
        r8 = c;
        r8 = com.tencent.smtt.utils.b.b(r8);
        r8 = java.lang.Integer.valueOf(r8);
        r6.put(r7, r8);
        r6 = r4.a;
        r7 = "app_metadata";
        r8 = c;
        r9 = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
        r8 = com.tencent.smtt.utils.b.a(r8, r9);
        r6.put(r7, r8);
        r4.commit();
        if (r0 != 0) goto L_0x0032;
    L_0x015f:
        if (r1 == r3) goto L_0x0032;
    L_0x0161:
        r0 = c;	 Catch:{ Throwable -> 0x01db }
        r0 = com.tencent.smtt.utils.x.a(r0);	 Catch:{ Throwable -> 0x01db }
        r0 = r0.d();	 Catch:{ Throwable -> 0x01db }
        r3 = "TbsDownload";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01db }
        r6.<init>();	 Catch:{ Throwable -> 0x01db }
        r7 = "[TbsDownloader.sendRequest] postUrl=";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x01db }
        r6 = r6.append(r0);	 Catch:{ Throwable -> 0x01db }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x01db }
        com.tencent.smtt.utils.TbsLog.i(r3, r6);	 Catch:{ Throwable -> 0x01db }
        r3 = r5.toString();	 Catch:{ Throwable -> 0x01db }
        r5 = "utf-8";
        r3 = r3.getBytes(r5);	 Catch:{ Throwable -> 0x01db }
        r5 = new com.tencent.smtt.sdk.al;	 Catch:{ Throwable -> 0x01db }
        r5.<init>(r12, r4);	 Catch:{ Throwable -> 0x01db }
        r6 = 0;
        r0 = com.tencent.smtt.utils.n.a(r0, r3, r5, r6);	 Catch:{ Throwable -> 0x01db }
        r2 = a(r0, r1, r12, r13);	 Catch:{ Throwable -> 0x01db }
        goto L_0x0032;
    L_0x019d:
        r0 = "x5.tbs.org";
        goto L_0x004b;
    L_0x01a1:
        r0 = "x5.tbs.org";
        goto L_0x0061;
    L_0x01a5:
        r0 = "x5.tbs.org";
        goto L_0x0077;
    L_0x01a9:
        r0 = "x5.tbs.org";
        goto L_0x008d;
    L_0x01ad:
        r0 = r6.exists();
        if (r0 == 0) goto L_0x01b8;
    L_0x01b3:
        r6.renameTo(r8);
        goto L_0x009f;
    L_0x01b8:
        r0 = r5.exists();
        if (r0 == 0) goto L_0x009f;
    L_0x01be:
        r5.renameTo(r8);
        goto L_0x009f;
    L_0x01c3:
        r4.setDownloadInterruptCode(r10);
        r0.setErrorCode(r10);
        goto L_0x00ec;
    L_0x01cb:
        if (r12 == 0) goto L_0x01d2;
    L_0x01cd:
        r4.setDownloadInterruptCode(r11);
        goto L_0x010f;
    L_0x01d2:
        r4.setDownloadInterruptCode(r10);
        goto L_0x010f;
    L_0x01d7:
        r1 = move-exception;
        r1 = r3;
        goto L_0x011a;
    L_0x01db:
        r0 = move-exception;
        r0.printStackTrace();
        if (r12 == 0) goto L_0x01e8;
    L_0x01e1:
        r0 = -106; // 0xffffffffffffff96 float:NaN double:NaN;
        r4.setDownloadInterruptCode(r0);
        goto L_0x0032;
    L_0x01e8:
        r0 = -206; // 0xffffffffffffff32 float:NaN double:NaN;
        r4.setDownloadInterruptCode(r0);
        goto L_0x0032;
    L_0x01ef:
        r5 = move-exception;
        goto L_0x00ca;
    L_0x01f2:
        r0 = r2;
        goto L_0x0110;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.c(boolean, boolean, boolean):boolean");
    }

    private static synchronized void d() {
        synchronized (TbsDownloader.class) {
            if (h == null) {
                h = am.a();
                try {
                    g = new ah(c);
                    d = new ak(h.getLooper());
                } catch (Exception e) {
                    i = true;
                    TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception");
                }
            }
        }
    }

    private static boolean e() {
        try {
            return TbsDownloadConfig.getInstance(c).mPreferences.getString(TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(f().toString());
        } catch (Exception e) {
            return false;
        }
    }

    private static JSONArray f() {
        if (!TbsShareManager.isThirdPartyApp(c)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Object coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        String packageName = c.getApplicationContext().getPackageName();
        Object obj;
        if (packageName.equals(TbsShareManager.f(c))) {
            int length = coreProviderAppList.length;
            obj = new String[(length + 1)];
            System.arraycopy(coreProviderAppList, 0, obj, 0, length);
            obj[length] = packageName;
        } else {
            obj = coreProviderAppList;
        }
        for (String str : r0) {
            Context a;
            int i;
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(c, str);
            if (sharedTbsCoreVersion > 0) {
                a = TbsShareManager.a(c, str);
                if (a == null || ao.a().c(a)) {
                    for (i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray.optInt(i) == sharedTbsCoreVersion) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                }
            }
        }
        for (String str2 : r0) {
            sharedTbsCoreVersion = TbsShareManager.getCoreShareDecoupleCoreVersion(c, str2);
            if (sharedTbsCoreVersion > 0) {
                a = TbsShareManager.a(c, str2);
                if (a == null || ao.a().c(a)) {
                    for (i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray.optInt(i) == sharedTbsCoreVersion) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str2);
                }
            }
        }
        return jSONArray;
    }

    private static boolean g() {
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        if (instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= instance.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            instance.setDownloadInterruptCode(-115);
            return false;
        } else if (instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= instance.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            instance.setDownloadInterruptCode(-116);
            return false;
        } else if (k.b(c)) {
            if (System.currentTimeMillis() - instance.mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) <= 86400000) {
                long j = instance.mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j);
                if (j >= instance.getDownloadMaxflow()) {
                    TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    instance.setDownloadInterruptCode(-120);
                    return false;
                }
            }
            return true;
        } else {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            instance.setDownloadInterruptCode(-117);
            return false;
        }
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return ao.a().d(c);
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            if (!k) {
                k = true;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
                if (instance.mPreferences.contains(TbsConfigKey.KEY_IS_OVERSEA)) {
                    j = instance.mPreferences.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
                    TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + j);
            }
            z = j;
        }
        return z;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return h;
    }

    private static JSONArray h() {
        JSONArray jSONArray = new JSONArray();
        for (String a : TbsShareManager.getCoreProviderAppList()) {
            File file = new File(k.a(c, a, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file != null && file.exists()) {
                long a2 = (long) a.a(c, file);
                if (a2 > 0) {
                    boolean z;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (((long) jSONArray.optInt(i)) == a2) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        jSONArray.put(a2);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static boolean isDownloadForeground() {
        return g != null && g.d();
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading]");
            z = a;
        }
        return z;
    }

    public static boolean needDownload(Context context, boolean z) {
        return needDownload(context, z, false, null);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        TbsLog.initIfNeed(context);
        if (!ao.b) {
            TbsLog.app_extra(LOGTAG, context);
            c = context.getApplicationContext();
            TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
            instance.setDownloadInterruptCode(-100);
            if (!a(c, z, tbsDownloaderCallback)) {
                return false;
            }
            d();
            if (i) {
                if (tbsDownloaderCallback != null) {
                    tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                }
                instance.setDownloadInterruptCode(-105);
                return false;
            }
            boolean contains;
            boolean a = a(c, z2, false);
            if (a) {
                a(z2, tbsDownloaderCallback);
                instance.setDownloadInterruptCode(-114);
            }
            d.removeMessages(102);
            Message.obtain(d, 102).sendToTarget();
            if (QbSdk.c || !TbsShareManager.isThirdPartyApp(context)) {
                contains = instance.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + contains);
                contains = (contains || TbsShareManager.isThirdPartyApp(context)) ? instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
            } else {
                contains = false;
            }
            if (!contains) {
                int g = ao.a().g(c);
                if (a || g <= 0) {
                    d.removeMessages(103);
                    if (g > 0 || a) {
                        Message.obtain(d, 103, 1, 0, c).sendToTarget();
                    } else {
                        Message.obtain(d, 103, 0, 0, c).sendToTarget();
                    }
                    instance.setDownloadInterruptCode(-121);
                } else {
                    instance.setDownloadInterruptCode(-119);
                }
            } else if (g()) {
                instance.setDownloadInterruptCode(-118);
            } else {
                contains = false;
            }
            if (!(a || tbsDownloaderCallback == null)) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] needDownload=" + contains);
            return contains;
        } else if (tbsDownloaderCallback == null) {
            return false;
        } else {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            return false;
        }
    }

    public static boolean needSendRequest(Context context, boolean z) {
        boolean z2 = true;
        c = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (!a(c, z, null)) {
            return false;
        }
        int g = ao.a().g(context);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=" + g);
        if (g > 0) {
            return false;
        }
        if (a(c, false, true)) {
            return true;
        }
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        boolean contains = instance.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + contains);
        boolean z3 = !contains ? true : instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] needDownload=" + z3);
        if (!(z3 && g())) {
            z2 = false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] ret=" + z2);
        return z2;
    }

    public static boolean startDecoupleCoreIfNeeded() {
        if (TbsShareManager.isThirdPartyApp(c) || TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            return false;
        }
        long j = TbsDownloadConfig.getInstance(c).mPreferences.getLong(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0);
        if (System.currentTimeMillis() - j < 1000 * TbsDownloadConfig.getInstance(c).getRetryInterval()) {
            return false;
        }
        int i = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        if (i <= 0 || i == ao.a().d(c) || TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) == i) {
            return false;
        }
        d.removeMessages(108);
        Message obtain = Message.obtain(d, 108, QbSdk.j);
        obtain.arg1 = 0;
        obtain.sendToTarget();
        TbsDownloadConfig.getInstance(c).a.put(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        int i = 1;
        synchronized (TbsDownloader.class) {
            TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + c);
            if (!ao.b) {
                a = true;
                c = context.getApplicationContext();
                TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-200);
                if (VERSION.SDK_INT < 8) {
                    QbSdk.j.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-201);
                } else {
                    d();
                    if (i) {
                        QbSdk.j.onDownloadFinish(ErrorCode.THREAD_INIT_ERROR);
                        TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
                    } else {
                        if (z) {
                            stopDownload();
                        }
                        d.removeMessages(101);
                        d.removeMessages(100);
                        Message obtain = Message.obtain(d, 101, QbSdk.j);
                        if (!z) {
                            i = 0;
                        }
                        obtain.arg1 = i;
                        obtain.sendToTarget();
                    }
                }
            }
        }
    }

    public static void stopDownload() {
        if (!i) {
            TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
            if (g != null) {
                g.b();
            }
            if (d != null) {
                d.removeMessages(100);
                d.removeMessages(101);
                d.removeMessages(108);
            }
        }
    }
}
