package com.tencent.smtt.sdk.a;

import a.a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.q;
import com.tencent.smtt.utils.w;
import com.tencent.smtt.utils.x;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import jd.wjlogin_sdk.util.Config;
import org.json.JSONObject;

public class b {
    public static byte[] a;

    static {
        a = null;
        try {
            a = "65dRa93L".getBytes(CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
        }
    }

    private static String a(Context context) {
        String str = null;
        try {
            byte[] toByteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (toByteArray != null) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(toByteArray);
                toByteArray = instance.digest();
                if (toByteArray != null) {
                    StringBuilder stringBuilder = new StringBuilder("");
                    if (toByteArray != null && toByteArray.length > 0) {
                        for (int i = 0; i < toByteArray.length; i++) {
                            String toUpperCase = Integer.toHexString(toByteArray[i] & 255).toUpperCase();
                            if (i > 0) {
                                stringBuilder.append(":");
                            }
                            if (toUpperCase.length() < 2) {
                                stringBuilder.append(0);
                            }
                            stringBuilder.append(toUpperCase);
                        }
                        str = stringBuilder.toString();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void a(a aVar, Context context) {
        new c("HttpUtils", context, aVar).start();
    }

    public static void a(Context context, String str, String str2, String str3, int i, boolean z, long j) {
        String str4;
        String str5 = "";
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ("com.tencent.mobileqq".equals(applicationInfo.packageName)) {
                str5 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                    str5 = str5 + "." + QbSdk.getQQBuildNumber();
                }
            }
            str4 = str5;
        } catch (Exception e) {
            Exception exception = e;
            str4 = str5;
            exception.printStackTrace();
        }
        try {
            a aVar = new a();
            aVar.a = context.getApplicationContext().getApplicationInfo().packageName;
            x.a(context);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            aVar.b = simpleDateFormat.format(Calendar.getInstance().getTime());
            aVar.e = str;
            if (z) {
                aVar.c = str2;
            } else {
                aVar.c = w.a(context);
            }
            aVar.d = str3;
            str5 = com.tencent.smtt.utils.b.e(context);
            String c = com.tencent.smtt.utils.b.c(context);
            String d = com.tencent.smtt.utils.b.d(context);
            Object f = com.tencent.smtt.utils.b.f(context);
            if (!(c == null || "".equals(c))) {
                aVar.f = c;
            }
            if (!(d == null || "".equals(d))) {
                aVar.g = d;
            }
            if (!TextUtils.isEmpty(f)) {
                aVar.m = f;
            }
            if (!(str5 == null || "".equals(str5))) {
                aVar.h = str5;
            }
            aVar.i = (long) i;
            if (!TbsShareManager.isThirdPartyApp(context)) {
                aVar.j = z ? 1 : 0;
            } else if (!z) {
                aVar.j = 0;
            } else if (TbsShareManager.getCoreFormOwn()) {
                aVar.j = 2;
            } else {
                aVar.j = 1;
            }
            aVar.k = str4;
            aVar.l = a(context);
            if (!z) {
                aVar.n = j;
                aVar.o = QbSdk.getTbsVersion(context);
            }
            a(aVar, context.getApplicationContext());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static JSONObject c(a aVar, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", aVar.a);
            jSONObject.put("TIME", aVar.b);
            jSONObject.put("QUA2", aVar.c);
            jSONObject.put("LC", aVar.d);
            jSONObject.put(Config.GUID_LOCALNAME, aVar.e);
            jSONObject.put("IMEI", aVar.f);
            jSONObject.put("IMSI", aVar.g);
            jSONObject.put("MAC", aVar.h);
            jSONObject.put("PV", aVar.i);
            jSONObject.put("CORETYPE", aVar.j);
            jSONObject.put("APPVN", aVar.k);
            if (aVar.l == null) {
                jSONObject.put("SIGNATURE", "0");
            } else {
                jSONObject.put("SIGNATURE", aVar.l);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", aVar.m);
            if (TbsShareManager.isThirdPartyApp(context)) {
                jSONObject.put("HOST_COREVERSION", TbsShareManager.getHostCoreVersions(context));
            } else {
                jSONObject.put("DECOUPLE_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersion());
            }
            if (aVar.j == 0) {
                jSONObject.put("WIFICONNECTEDTIME", aVar.n);
                jSONObject.put("CORE_EXIST", aVar.o);
                int i = TbsCoreLoadStat.mLoadErrorCode;
                if (aVar.o <= 0) {
                    jSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i);
                }
                if (i == -1) {
                    TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
            }
            try {
                if (QbSdk.getTID() == null) {
                    return jSONObject;
                }
                if (aVar.a.equals("com.tencent.mobileqq")) {
                    jSONObject.put("TID", q.a().a(QbSdk.getTID()));
                    jSONObject.put("TIDTYPE", 1);
                    return jSONObject;
                } else if (!aVar.a.equals("com.tencent.mm")) {
                    return jSONObject;
                } else {
                    jSONObject.put("TID", QbSdk.getTID());
                    jSONObject.put("TIDTYPE", 0);
                    return jSONObject;
                }
            } catch (Exception e) {
                return jSONObject;
            }
        } catch (Exception e2) {
            TbsLog.e("sdkreport", "getPostData exception!");
            return null;
        }
    }
}
