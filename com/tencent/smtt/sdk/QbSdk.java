package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.sdk.b.a.f;
import com.tencent.smtt.sdk.b.a.i;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.v;
import com.tencent.stat.DeviceInfo;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import jd.wjlogin_sdk.util.Config;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class QbSdk {
    private static boolean A = false;
    private static boolean B = false;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    public static final String FILERADER_MENUDATA = "menuData";
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final int SVNVERSION = 454340;
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    static boolean a = false;
    static boolean b = false;
    static boolean c = true;
    static String d;
    static boolean e = false;
    static long f = 0;
    static long g = 0;
    static Object h = new Object();
    static volatile boolean i = a;
    public static boolean isDefaultDialog = false;
    static TbsListener j = new l();
    static Map<String, Object> k = null;
    private static int l = 0;
    private static String m = "";
    private static Class<?> n;
    private static Object o;
    private static boolean p = false;
    private static String[] q;
    private static String r = "NULL";
    private static String s = "UNKNOWN";
    public static boolean sIsVersionPrinted = false;
    private static int t = 0;
    private static int u = 170;
    private static String v = null;
    private static String w = null;
    private static boolean x = true;
    private static TbsListener y = null;
    private static TbsListener z = null;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    static Bundle a(Context context, Bundle bundle) {
        if (a(context)) {
            Object a = v.a(o, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (a != null) {
                return (Bundle) a;
            }
            TbsLogReport.a(context).a((int) ErrorCode.INCR_UPDATE_ERROR, "incrUpdate return null!");
            return null;
        }
        TbsLogReport.a(context).a((int) ErrorCode.INCR_UPDATE_ERROR, "initForPatch return false!");
        return null;
    }

    private static Bundle a(Context context, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("style", map.get("style") == null ? "0" : (String) map.get("style"));
            try {
                bundle.putInt("topBarBgColor", Color.parseColor((String) map.get("topBarBgColor")));
            } catch (Exception e) {
            }
            if (map != null) {
                if (map.containsKey(FILERADER_MENUDATA)) {
                    JSONObject jSONObject = new JSONObject((String) map.get(FILERADER_MENUDATA));
                    JSONArray jSONArray = jSONObject.getJSONArray("menuItems");
                    if (jSONArray != null) {
                        ArrayList arrayList = new ArrayList();
                        int i = 0;
                        while (i < jSONArray.length() && i < 5) {
                            try {
                                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                                arrayList.add(i, BitmapFactory.decodeResource(context.getResources(), jSONObject2.getInt("iconResId")));
                                jSONObject2.put("iconResId", i);
                            } catch (Exception e2) {
                            }
                            i++;
                        }
                        bundle.putParcelableArrayList("resArray", arrayList);
                    }
                    bundle.putString(FILERADER_MENUDATA, jSONObject.toString());
                }
            }
            return bundle;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    static Object a(Context context, String str, Bundle bundle) {
        if (!a(context)) {
            return Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        Object a = v.a(o, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
        return a == null ? null : a;
    }

    static String a() {
        return m;
    }

    static synchronized void a(Context context, String str) {
        synchronized (QbSdk.class) {
            if (!a) {
                a = true;
                s = "forceSysWebViewInner: " + str;
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + s);
                TbsCoreLoadStat.getInstance().a(context, 401, new Throwable(s));
            }
        }
    }

    static boolean a(Context context) {
        try {
            if (n != null) {
                return true;
            }
            File k = ao.a().k(context);
            if (k == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(k, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                n = new DexClassLoader(file.getAbsolutePath(), k.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                o = n.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, context});
                return true;
            }
            TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    static boolean a(Context context, int i) {
        return a(context, i, (int) BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
    }

    static boolean a(Context context, int i, int i2) {
        if (!b(context)) {
            return true;
        }
        Object a = v.a(o, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43200), Integer.valueOf(i2));
        if (a != null) {
            return ((Boolean) a).booleanValue();
        }
        a = v.a(o, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43200));
        return a != null ? ((Boolean) a).booleanValue() : true;
    }

    private static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        intent.setDataAndType(Uri.fromFile(new File(str)), "mtt/" + str2);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.contains(TbsConfig.APP_QB)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private static boolean a(Context context, boolean z) {
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: 454340; SDK_VERSION_CODE: 43200; SDK_VERSION_NAME: 3.2.0.1104");
            sIsVersionPrinted = true;
        }
        if (a && !z) {
            TbsLog.e("QbSdk", "QbSdk init: " + s, false);
            TbsCoreLoadStat.getInstance().a(context, 414, new Throwable(s));
            return false;
        } else if (b) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable(r));
            return false;
        } else {
            if (!x) {
                c(context);
            }
            try {
                File k = ao.a().k(context);
                if (k == null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    TbsCoreLoadStat.getInstance().a(context, ErrorCode.ERROR_TBSCORE_SHARE_DIR, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int a;
                    if (l != 0) {
                        a = ao.a().a(true, context);
                        if (l != a) {
                            n = null;
                            o = null;
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + a, true);
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + l, true);
                            TbsCoreLoadStat.getInstance().a(context, 303, new Throwable("sTbsVersion: " + l + "; tbsCoreInstalledVer: " + a));
                            return false;
                        }
                    }
                    a = 0;
                    l = a;
                }
                if (n != null) {
                    return true;
                }
                File file;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    file = new File(ao.a().k(context), "tbs_sdk_extension_dex.jar");
                } else if (TbsShareManager.i(context)) {
                    file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                } else {
                    TbsCoreLoadStat.getInstance().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    return false;
                }
                if (file.exists()) {
                    n = new DexClassLoader(file.getAbsolutePath(), k.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    Constructor constructor = n.getConstructor(new Class[]{Context.class, Context.class});
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        if (TbsShareManager.e(context) == null) {
                            TbsLogReport.a(context.getApplicationContext()).b((int) ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                            return false;
                        }
                        o = constructor.newInstance(new Object[]{context, TbsShareManager.e(context)});
                    } else {
                        o = constructor.newInstance(new Object[]{context, context});
                    }
                    v.a(o, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, b.a, b.b, b.c, b.d);
                    v.a(o, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                    return true;
                }
                TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                int e = ao.a().e(context);
                if (new File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                    if (e > 0) {
                        TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + e));
                        return false;
                    }
                    TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + e));
                    return false;
                } else if (e > 0) {
                    TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + e));
                    return false;
                } else {
                    TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + e));
                    return false;
                }
            } catch (Throwable th) {
                TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th));
                TbsCoreLoadStat.getInstance().a(context, ErrorCode.THROWABLE_QBSDK_INIT, th);
                return false;
            }
        }
    }

    static boolean a(Context context, boolean z, boolean z2) {
        int i = 1;
        boolean z3 = false;
        if (TbsShareManager.isThirdPartyApp(context) && !TbsShareManager.h(context)) {
            TbsCoreLoadStat.getInstance().a(context, 302);
        } else if (a(context, z)) {
            Object a = v.a(o, "canLoadX5Core", new Class[]{Integer.TYPE}, Integer.valueOf(43200));
            boolean a2;
            if (a == null) {
                a = v.a(o, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
                if (a == null) {
                    TbsCoreLoadStat.getInstance().a(context, 308);
                } else if (!((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail"))) {
                    if (a instanceof Boolean) {
                        l = q.d();
                        a2 = a(context, q.d());
                        if (((Boolean) a).booleanValue() && !a2) {
                            z3 = true;
                        }
                        if (!z3) {
                            TbsLog.e(TbsListener.tag_load_error, "318");
                            TbsLog.w(TbsListener.tag_load_error, "isX5Disable:" + a2);
                            TbsLog.w(TbsListener.tag_load_error, "(Boolean) ret:" + ((Boolean) a));
                        }
                    }
                }
            } else if (!((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail"))) {
                if (a instanceof Bundle) {
                    Bundle bundle = (Bundle) a;
                    if (bundle.isEmpty()) {
                        TbsCoreLoadStat.getInstance().a(context, ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, new Throwable("" + a));
                        TbsLog.e(TbsListener.tag_load_error, "empty bundle");
                    } else {
                        int i2;
                        try {
                            i2 = bundle.getInt("result_code", -1);
                        } catch (Exception e) {
                            TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + e.toString());
                            i2 = -1;
                        }
                        a2 = i2 == 0;
                        if (TbsShareManager.isThirdPartyApp(context)) {
                            q.a(TbsShareManager.d(context));
                            m = String.valueOf(TbsShareManager.d(context));
                            if (m.length() == 5) {
                                m = "0" + m;
                            }
                            if (m.length() != 6) {
                                m = "";
                            }
                        } else {
                            if (VERSION.SDK_INT >= 12) {
                                m = bundle.getString("tbs_core_version", "0");
                            } else {
                                m = bundle.getString("tbs_core_version");
                                if (m == null) {
                                    m = "0";
                                }
                            }
                            try {
                                l = Integer.parseInt(m);
                            } catch (NumberFormatException e2) {
                                l = 0;
                            }
                            q.a(l);
                            if (l == 0) {
                                TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("sTbsVersion is 0"));
                            } else {
                                if ((l <= 0 || l > 25442) && l != 25472) {
                                    i = 0;
                                }
                                if (i != 0) {
                                    TbsLog.e(TbsDownloader.LOGTAG, "is_obsolete --> delete old core:" + l);
                                    k.b(ao.a().k(context));
                                    TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("is_obsolete --> delete old core:" + l));
                                }
                            }
                        }
                        try {
                            q = bundle.getStringArray("tbs_jarfiles");
                            if (q instanceof String[]) {
                                d = bundle.getString("tbs_librarypath");
                                a = null;
                                if (i2 != 0) {
                                    try {
                                        a = v.a(o, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                switch (i2) {
                                    case -2:
                                        if (!(a instanceof Integer)) {
                                            TbsCoreLoadStat.getInstance().a(context, 404, new Throwable("detail: " + a));
                                            break;
                                        }
                                        TbsCoreLoadStat.getInstance().a(context, ((Integer) a).intValue(), new Throwable("detail: " + a));
                                        break;
                                    case -1:
                                        if (!(a instanceof Integer)) {
                                            TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("detail: " + a));
                                            break;
                                        }
                                        TbsCoreLoadStat.getInstance().a(context, ((Integer) a).intValue(), new Throwable("detail: " + a));
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        TbsCoreLoadStat.getInstance().a(context, 415, new Throwable("detail: " + a + "errcode" + i2));
                                        break;
                                }
                                z3 = a2;
                            } else {
                                TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + q));
                            }
                        } catch (Throwable th) {
                            TbsCoreLoadStat.getInstance().a(context, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, th);
                        }
                    }
                } else {
                    TbsCoreLoadStat.getInstance().a(context, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, new Throwable("" + a));
                    TbsLog.e(TbsListener.tag_load_error, "ret not instance of bundle");
                }
            }
            if (!z3) {
                TbsLog.e(TbsListener.tag_load_error, "319");
            }
        } else {
            TbsLog.e("QbSdk", "QbSdk.init failure!");
        }
        return z3;
    }

    protected static String b() {
        bo b = bo.b();
        if (b != null && b.c()) {
            Object invokeStaticMethod = b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                return (String) invokeStaticMethod;
            }
        }
        return null;
    }

    private static boolean b(Context context) {
        try {
            if (n != null) {
                return true;
            }
            File k = ao.a().k(context);
            if (k == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            File file;
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(ao.a().k(context), "tbs_sdk_extension_dex.jar");
            } else if (TbsShareManager.i(context)) {
                file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
            } else {
                TbsCoreLoadStat.getInstance().a(context, 304);
                return false;
            }
            if (file.exists()) {
                n = new DexClassLoader(file.getAbsolutePath(), k.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                Constructor constructor = n.getConstructor(new Class[]{Context.class, Context.class});
                if (TbsShareManager.isThirdPartyApp(context)) {
                    if (TbsShareManager.e(context) == null) {
                        TbsLogReport.a(context.getApplicationContext()).b((int) ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                        return false;
                    }
                    o = constructor.newInstance(new Object[]{context, TbsShareManager.e(context)});
                } else {
                    o = constructor.newInstance(new Object[]{context, context});
                }
                v.a(o, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, b.a, b.b, b.c, b.d);
                v.a(o, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                return true;
            }
            TbsCoreLoadStat.getInstance().a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    private static void c(Context context) {
        Throwable th;
        int i;
        File a;
        int i2 = -1;
        x = true;
        SharedPreferences sharedPreferences;
        int i3;
        int i4;
        Editor edit;
        try {
            sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            try {
                i3 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
                if (i3 >= 0) {
                    i3++;
                    if (i3 <= 4) {
                        i4 = i3;
                    } else {
                        return;
                    }
                }
                i4 = i3;
                i3 = -1;
            } catch (Throwable th2) {
                th = th2;
                i3 = -1;
                i = -1;
                TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                i4 = -1;
                if (i4 <= 3) {
                    TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                    bo.b().a(context, null);
                    TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                    i2 = 0;
                    try {
                        i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i4 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4 - 1).commit();
                        }
                    } catch (Throwable th3) {
                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th3));
                    }
                    TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                }
                try {
                    i4 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                    edit = sharedPreferences.edit();
                    if (i4 != i) {
                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i + "; value:" + i4);
                    } else {
                        k.a(ao.a().k(context), false);
                        a = aj.a(context).a();
                        if (a != null) {
                            k.a(a, false);
                        }
                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i + " is deleted!");
                    }
                    edit.putInt("tbs_precheck_disable_version", i4);
                    edit.commit();
                } catch (Throwable th32) {
                    TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th32));
                    return;
                }
            }
            try {
                i = ao.a().e(context);
                if (i > 0) {
                    if (i4 <= 4) {
                        try {
                            sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i4).commit();
                        } catch (Throwable th4) {
                            th32 = th4;
                            TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                            i4 = -1;
                            if (i4 <= 3) {
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                bo.b().a(context, null);
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                i2 = 0;
                                i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i4 > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4 - 1).commit();
                                }
                                TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                            }
                            i4 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            edit = sharedPreferences.edit();
                            if (i4 != i) {
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i + "; value:" + i4);
                            } else {
                                k.a(ao.a().k(context), false);
                                a = aj.a(context).a();
                                if (a != null) {
                                    k.a(a, false);
                                }
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i + " is deleted!");
                            }
                            edit.putInt("tbs_precheck_disable_version", i4);
                            edit.commit();
                        }
                    }
                    i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                    if (i4 >= 0) {
                        i4++;
                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4).commit();
                        if (i4 <= 3) {
                            i4 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            edit = sharedPreferences.edit();
                            if (i4 != i) {
                                k.a(ao.a().k(context), false);
                                a = aj.a(context).a();
                                if (a != null) {
                                    k.a(a, false);
                                }
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i + " is deleted!");
                            } else {
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i + "; value:" + i4);
                            }
                            edit.putInt("tbs_precheck_disable_version", i4);
                            edit.commit();
                        }
                        if (i3 > 0 && i3 <= 3) {
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                            bo.b().a(context, null);
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                            i2 = 0;
                        }
                        i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i4 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4 - 1).commit();
                        }
                        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                    }
                    i4 = -1;
                    if (i4 <= 3) {
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                        bo.b().a(context, null);
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                        i2 = 0;
                        i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i4 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4 - 1).commit();
                        }
                        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
                    }
                    i4 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                    edit = sharedPreferences.edit();
                    if (i4 != i) {
                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i + "; value:" + i4);
                    } else {
                        k.a(ao.a().k(context), false);
                        a = aj.a(context).a();
                        if (a != null) {
                            k.a(a, false);
                        }
                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i + " is deleted!");
                    }
                    edit.putInt("tbs_precheck_disable_version", i4);
                    edit.commit();
                }
            } catch (Throwable th5) {
                th32 = th5;
                i = -1;
                TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                i4 = -1;
                if (i4 <= 3) {
                    i4 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                    edit = sharedPreferences.edit();
                    if (i4 != i) {
                        k.a(ao.a().k(context), false);
                        a = aj.a(context).a();
                        if (a != null) {
                            k.a(a, false);
                        }
                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i + " is deleted!");
                    } else {
                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i + "; value:" + i4);
                    }
                    edit.putInt("tbs_precheck_disable_version", i4);
                    edit.commit();
                }
                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                bo.b().a(context, null);
                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                i2 = 0;
                i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                if (i4 > 0) {
                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4 - 1).commit();
                }
                TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
            }
        } catch (Throwable th6) {
            th32 = th6;
            i3 = -1;
            sharedPreferences = null;
            i = -1;
            TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
            i4 = -1;
            if (i4 <= 3) {
                i4 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                edit = sharedPreferences.edit();
                if (i4 != i) {
                    k.a(ao.a().k(context), false);
                    a = aj.a(context).a();
                    if (a != null) {
                        k.a(a, false);
                    }
                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i + " is deleted!");
                } else {
                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i + "; value:" + i4);
                }
                edit.putInt("tbs_precheck_disable_version", i4);
                edit.commit();
            }
            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
            bo.b().a(context, null);
            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
            i2 = 0;
            i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
            if (i4 > 0) {
                sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4 - 1).commit();
            }
            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
        }
    }

    public static boolean canLoadVideo(Context context) {
        Object a = v.a(o, "canLoadVideo", new Class[]{Integer.TYPE}, Integer.valueOf(0));
        if (a == null) {
            TbsCoreLoadStat.getInstance().a(context, ErrorCode.ERROR_CANLOADVIDEO_RETURN_NULL);
        } else if (!((Boolean) a).booleanValue()) {
            TbsCoreLoadStat.getInstance().a(context, ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE);
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public static boolean canLoadX5(Context context) {
        return a(context, false, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        try {
            if (n == null) {
                File k = ao.a().k(context);
                if (k == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    n = new DexClassLoader(file.getAbsolutePath(), k.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                } else {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
            }
            if (o == null) {
                if (TbsShareManager.e(context) == null) {
                    TbsLogReport.a(context.getApplicationContext()).b((int) ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                    return false;
                }
                o = n.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, TbsShareManager.e(context)});
            }
            Object a = v.a(o, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void canOpenFile(Context context, String str, ValueCallback<Boolean> valueCallback) {
        new e(context, str, valueCallback).start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        return !a(context, false) ? false : false;
    }

    public static boolean canOpenWebPlus(Context context) {
        InputStream fileInputStream;
        boolean z;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        InputStream inputStream = null;
        boolean z2 = true;
        if (t == 0) {
            t = a.a();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + t);
        if (VERSION.SDK_INT < 7 || t < u || context == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream2;
        try {
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(ao.a().k(context), "tbs.conf")));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(VERSION.SDK);
                if (parseInt3 > parseInt || parseInt3 < parseInt2) {
                    TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                    if (bufferedInputStream2 == null) {
                        return false;
                    }
                    try {
                        bufferedInputStream2.close();
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                int parseInt4 = Integer.parseInt(properties.getProperty("tbs_core_version"));
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e2) {
                    }
                }
                try {
                    fileInputStream = new FileInputStream(new File(ao.m(context), "tbs_extension.conf"));
                    try {
                        Properties properties2 = new Properties();
                        properties2.load(fileInputStream);
                        parseInt = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                        parseInt2 = Integer.parseInt(properties2.getProperty(TbsConfigKey.KEY_APP_VERSIONCODE_FOR_SWITCH));
                        if (parseInt4 == 88888888 || parseInt == 88888888) {
                            z = false;
                        } else if (parseInt4 > parseInt) {
                            z = false;
                        } else if (parseInt4 == parseInt) {
                            if (parseInt2 > 0) {
                                if (parseInt2 != b.b(context)) {
                                    z = false;
                                }
                            }
                            z = Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getBoolean(TbsConfigKey.KEY_SWITCH_BACKUPCORE_ENABLE, false);
                        } else {
                            z = false;
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
                if (z) {
                    z2 = false;
                }
                return z2;
            } catch (Throwable th4) {
                th = th4;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream2 = null;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object a = v.a(o, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
    }

    public static boolean checkApkExist(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static void clear(Context context) {
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        try {
            WebView webView = new WebView(context);
            if (VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th));
        }
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                bo b = bo.b();
                if (b != null && b.c()) {
                    b.d().a(context, z);
                }
            }
        } catch (Throwable th2) {
        }
    }

    public static void closeFileReader(Context context) {
        bo b = bo.b();
        b.a(context, null);
        if (b.c()) {
            b.d().o();
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        if (context == null) {
            return false;
        }
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        if (isMiniQBShortCutExist(context, str, str2)) {
            return false;
        }
        bo b = bo.b();
        if (b == null || !b.c()) {
            return false;
        }
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        DexLoader b2 = b.d().b();
        TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
        Object invokeStaticMethod = b2.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
        TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
        return invokeStaticMethod != null;
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        if (context == null || TbsDownloader.getOverSea(context)) {
            return false;
        }
        bo b = bo.b();
        if (b == null || !b.c()) {
            return false;
        }
        return b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) != null;
    }

    public static void disAllowThirdAppDownload() {
        c = false;
    }

    public static void forceSysWebView() {
        b = true;
        r = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        return context != null ? TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0) : 0;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        if (q instanceof String[]) {
            int length = q.length;
            String[] strArr = new String[length];
            while (i < length) {
                strArr[i] = str + q[i];
                i++;
            }
            return strArr;
        }
        Object a = v.a(o, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (!(a instanceof String[])) {
            a = new String[]{""};
        }
        return (String[]) a;
    }

    public static boolean getDownloadWithoutWifi() {
        return A;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return b;
    }

    public static String getMiniQBVersion(Context context) {
        bo b = bo.b();
        b.a(context, null);
        return (b == null || !b.c()) ? null : b.d().f();
    }

    public static String getQQBuildNumber() {
        return w;
    }

    public static boolean getTBSInstalling() {
        return B;
    }

    public static String getTID() {
        return v;
    }

    public static int getTbsVersion(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.a(context, false);
        }
        int e = ao.a().e(context);
        if (e != 0 || aj.a(context).c() != 3) {
            return e;
        }
        reset(context);
        return e;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (k == null) {
            k = map;
            return;
        }
        try {
            k.putAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initX5Environment(Context context, PreInitCallback preInitCallback) {
        z = new j(context, preInitCallback);
        if (TbsShareManager.isThirdPartyApp(context)) {
            ao.a().b(context, true);
        }
        TbsDownloader.needDownload(context, false, false, new k(context, preInitCallback));
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        q a = q.a(true);
        a.a(context, false, false, null);
        return (a == null || !a.b()) ? false : a.a().a(context, str, str2, bundle);
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            Object obj = EnvironmentCompat.MEDIA_UNKNOWN;
            try {
                obj = context.getApplicationInfo().packageName;
            } catch (Exception e) {
                e.printStackTrace();
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, obj);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (d.a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                bo b = bo.b();
                if (b != null && b.c() && b.d().a(context, substring, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        bo b = bo.b();
        if (b == null || !b.c()) {
            return false;
        }
        Object invokeStaticMethod = b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return (invokeStaticMethod instanceof Boolean ? (Boolean) invokeStaticMethod : Boolean.valueOf(false)).booleanValue();
    }

    public static boolean isSuportOpenFile(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = new String[]{"rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", "xml", "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", DeviceInfo.TAG_MID, "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", DeviceInfo.TAG_TIMESTAMPS, "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx"};
        String[] strArr2 = new String[]{"doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub"};
        switch (i) {
            case 1:
                return Arrays.asList(strArr2).contains(str.toLowerCase());
            case 2:
                return Arrays.asList(strArr).contains(str.toLowerCase());
            default:
                return false;
        }
    }

    public static boolean isTbsCoreInited() {
        q a = q.a(false);
        return a != null && a.g();
    }

    public static boolean isX5DisabledSync(Context context) {
        if (aj.a(context).c() == 2) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            return false;
        }
        if (!b(context)) {
            return true;
        }
        i = ao.a().e(context);
        Object a = v.a(o, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43200));
        return a != null ? ((Boolean) a).booleanValue() : true;
    }

    public static void openBrowserList(Context context, String str, ValueCallback<String> valueCallback) {
        if (context != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(str));
            String c = i.c(str);
            isDefaultDialog = false;
            f fVar = new f(context, "选择其它应用打开", intent, valueCallback, c);
            String a = fVar.a();
            if (a != null && !TextUtils.isEmpty(a)) {
                if (TbsConfig.APP_QB.equals(a)) {
                    intent.putExtra(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                    intent.putExtra(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
                }
                intent.setPackage(a);
                context.startActivity(intent);
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("default browser:" + a);
                }
            } else if (isDefaultDialog) {
                new Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new o()).show();
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("can not open");
                }
            } else {
                fVar.show();
                fVar.setOnDismissListener(new g(valueCallback));
            }
        }
    }

    public static int openFileReader(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, 505);
        if (str != null) {
            String substring = str.substring(str.lastIndexOf(".") + 1, str.length());
            if ("apk".equalsIgnoreCase(substring)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
                context.startActivity(intent);
                TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_APKFILE);
                return 4;
            }
            HashMap hashMap2;
            if (!d.b(context)) {
                Log.d("QbSdk", "openFileReader QQ browser not installed");
            } else if (a(context, str, substring)) {
                if (startQBForDoc(context, str, 4, 0, substring, a(context, (Map) hashMap))) {
                    if (valueCallback != null) {
                        valueCallback.onReceiveValue("open QB");
                    }
                    TbsCoreLoadStat.getInstance().a(context, 507);
                    return 1;
                }
                Log.d("QbSdk", "openFileReader startQBForDoc return false");
            } else {
                openFileReaderListWithQBDownload(context, str, valueCallback);
                TbsCoreLoadStat.getInstance().a(context, 507);
                return 3;
            }
            if (hashMap == null) {
                hashMap2 = new HashMap();
            }
            hashMap2.put("local", "true");
            int startMiniQBToLoadUrl = startMiniQBToLoadUrl(context, str, hashMap2, valueCallback);
            if (startMiniQBToLoadUrl != 0) {
                openFileReaderListWithQBDownload(context, str, valueCallback);
                TbsLogReport.a(context).b((int) ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED, "" + startMiniQBToLoadUrl);
                return 3;
            }
            TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBSUCCESS);
            return 2;
        }
        if (valueCallback != null) {
            valueCallback.onReceiveValue("filepath error");
        }
        TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_FILEPATHISNULL);
        return -1;
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, ValueCallback<String> valueCallback) {
        if (context != null && !context.getApplicationInfo().packageName.equals("com.tencent.androidqqmail")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            String c = i.c(str);
            intent.setDataAndType(Uri.fromFile(new File(str)), c);
            isDefaultDialog = false;
            f fVar = new f(context, "选择其它应用打开", intent, valueCallback, c);
            String a = fVar.a();
            if (a != null && !TextUtils.isEmpty(a) && checkApkExist(context, a)) {
                if (TbsConfig.APP_QB.equals(a)) {
                    intent.putExtra(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getPackageName());
                    intent.putExtra(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "4");
                }
                intent.setPackage(a);
                context.startActivity(intent);
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("default browser:" + a);
                }
            } else if ("com.tencent.rtxlite".equalsIgnoreCase(context.getApplicationContext().getPackageName()) && isDefaultDialog) {
                new Builder(context).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new m()).show();
            } else if (!isDefaultDialog) {
                fVar.show();
                fVar.setOnDismissListener(new n(valueCallback));
            } else if (valueCallback != null) {
                valueCallback.onReceiveValue("can not open");
            }
        }
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static synchronized void preInit(Context context, PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            i = a;
            if (!p) {
                Thread iVar = new i(context, new h(Looper.getMainLooper(), preInitCallback, context));
                iVar.setName("tbs_preinit");
                iVar.setPriority(10);
                iVar.start();
                p = true;
            }
        }
    }

    public static void reset(Context context) {
        TbsLog.e("QbSdk", "QbSdk reset!", true);
        try {
            TbsDownloader.stopDownload();
            TbsDownloader.b(context);
            k.b(context.getDir("tbs", 0));
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            ao.a.set(Integer.valueOf(0));
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(TID_QQNumber_Prefix.length());
            v = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDeviceInfo(String str, String str2, String str3, String str4) {
        b.a = str;
        b.b = str2;
        b.c = str3;
        b.d = str4;
    }

    public static void setDownloadWithoutWifi(boolean z) {
        A = z;
    }

    public static void setQQBuildNumber(String str) {
        w = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        B = z;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        y = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, 501);
        if (context == null) {
            return -100;
        }
        bo b = bo.b();
        b.a(context, null);
        if (!b.c()) {
            TbsCoreLoadStat.getInstance().a(context, 502);
            return Config.ERR_CODE_RESPONSE_DATA_ERR;
        } else if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return Config.ERR_CODE_REQUEST_FAILED_OR_TIMEOUT;
        } else {
            int a = b.d().a(context, str, hashMap, null, valueCallback);
            if (a == 0) {
                TbsCoreLoadStat.getInstance().a(context, 503);
                return a;
            }
            TbsLogReport.a(context).b(504, "" + a);
            return a;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return d.a(context, str, i2, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return d.a(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (str2 == "com.tencent.mm" || str2 == "com.tencent.mobileqq") {
                    bo b = bo.b();
                    if (b != null && b.c()) {
                        Object invokeStaticMethod = b.d().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
                        if (invokeStaticMethod != null) {
                            IX5WebViewBase iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
                            if (iX5WebViewBase != null) {
                                webView = (WebView) iX5WebViewBase.getView().getParent();
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return d.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQBWithBrowserlist(Context context, String str, int i) {
        boolean startQBToLoadurl = startQBToLoadurl(context, str, i, null);
        if (!startQBToLoadurl) {
            openBrowserList(context, str, null);
        }
        return startQBToLoadurl;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (context == null) {
            return false;
        }
        bo b = bo.b();
        b.a(context, null);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && b.c() && ((Bundle) b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0])) == null) {
        }
        if (d.a(context, str, hashMap, str2, null) == 0) {
            return true;
        }
        if (b.c()) {
            if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                return false;
            }
            if (b.d().a(context, str, hashMap, null, valueCallback) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void unForceSysWebView() {
        b = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static boolean useSoftWare() {
        if (o == null) {
            return false;
        }
        Object a = v.a(o, "useSoftWare", new Class[0], new Object[0]);
        if (a == null) {
            a = v.a(o, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }
}
