package com.kepler.jd.login;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.kepler.jd.Listener.ActionCallBck;
import com.kepler.jd.Listener.AsyncInitListener;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.Listener.LoginListener;
import com.kepler.jd.Listener.OpenAppAction;
import com.kepler.jd.Listener.OpenIDCallBck;
import com.kepler.jd.sdk.bean.KelperTask;
import com.kepler.jd.sdk.bean.KeplerAttachParameter;
import com.kepler.jd.sdk.bean.KeplerGlobalParameter;
import com.kepler.jd.sdk.exception.KeplerBufferOverflowException;
import com.kepler.jd.sdk.exception.KeplerNoThisCategoryException;
import com.kepler.sdk.aa;
import com.kepler.sdk.ab;
import com.kepler.sdk.ac;
import com.kepler.sdk.ad;
import com.kepler.sdk.ah;
import com.kepler.sdk.ai;
import com.kepler.sdk.am;
import com.kepler.sdk.ap;
import com.kepler.sdk.aq;
import com.kepler.sdk.aw;
import com.kepler.sdk.az;
import com.kepler.sdk.g;
import com.kepler.sdk.h;
import com.kepler.sdk.i;
import com.kepler.sdk.j;
import com.kepler.sdk.k;
import com.kepler.sdk.l;
import com.kepler.sdk.m;
import com.kepler.sdk.n;
import com.kepler.sdk.o;
import com.kepler.sdk.p;
import com.kepler.sdk.x;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import uk.co.chrisjenx.calligraphy.BuildConfig;

/* compiled from: TbsSdkJava */
public class KeplerApiManager {
    public static final String Category_Err_Info = "no has category name:";
    public static final int KeplerApiManagerActionErr = 500;
    public static final int KeplerApiManagerActionErr_AppKeyErr = 1021;
    public static final int KeplerApiManagerActionErr_AppKeyLast = 1020;
    public static final int KeplerApiManagerActionErr_AppKeyNotExist = 1005;
    public static final int KeplerApiManagerActionErr_CartFullErr = 8969;
    public static final int KeplerApiManagerActionErr_DataErr = -2004;
    public static final int KeplerApiManagerActionErr_ParameterErr = -2002;
    public static final int KeplerApiManagerActionErr_ParserErr = -2003;
    public static final int KeplerApiManagerActionErr_TokenLast = 1022;
    public static final int KeplerApiManagerActionErr_TokenNotExist = 1003;
    public static final int KeplerApiManagerActionErr_TokenTimeOutTErr = 1004;
    public static final int KeplerApiManagerActionErr_UNLogin = -2001;
    public static final int KeplerApiManagerActionServerErr = 3000;
    public static final int KeplerApiManagerLoginErr_AuthErr_ActivityOpen = -3004;
    public static final int KeplerApiManagerLoginErr_Init = -3001;
    public static final int KeplerApiManagerLoginErr_InitIng = -3002;
    public static final int KeplerApiManagerLoginErr_JDAppFail = 1;
    public static final int KeplerApiManagerLoginErr_User_Cancel = 2;
    public static final int KeplerApiManagerLoginErr_getTokenErr = -1;
    public static final int KeplerApiManagerLoginErr_openH5authPageURLSettingNull = -3003;
    public static final int KeplerApiManagerLoginErr_settingNotOpenH5authPage = -3005;
    public static final int NetLinker_Err_ClientProtocolException = -1001;
    public static final int NetLinker_Err_IOException = -1002;
    public static final int NetLinker_Err_NetException = -1011;
    public static final int NetLinker_Err_NoNetwork = -1100;
    public static final int NetLinker_Err_NoSuchAlgorithmException = -1003;
    public static final int NetLinker_Err_Not_200 = -1010;
    public static final int NetLinker_Err_UnsupportedEncodingException = -1000;
    static FaceCommonCallBack<OpenIDCallBck> a;
    private static volatile boolean b = false;
    private static Context c;
    private static String[] d = new String[]{"kepler.jd"};
    private static Class<Activity> e;
    private static final Set<String> f = new HashSet();

    /* compiled from: TbsSdkJava */
    static class a {
        private static final KeplerApiManager a = new KeplerApiManager();
    }

    static {
        f.add("com.jd.jrapp");
        f.add("com.example.sdkdemo");
        f.add("com.wangyin.payment");
        f.add("com.jd.fridge");
        f.add("com.jingdong.app.reader");
        f.add("com.jd.smart");
    }

    public static final KeplerApiManager getWebViewService() {
        return a.a;
    }

    private KeplerApiManager() {
    }

    public Context getApplicatonContext() {
        return c;
    }

    public static final void asyncInitSdkQB(Application application, String str, String str2, String str3, FaceCommonCallBack<OpenIDCallBck> faceCommonCallBack, FaceCommonCallBack<Boolean> faceCommonCallBack2, AsyncInitListener asyncInitListener) {
        if (application == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            asyncInitListener.onFailure();
            return;
        }
        a = faceCommonCallBack;
        try {
            if (!b) {
                c = application.getApplicationContext();
                com.kepler.sdk.a.a().a(application, str3);
                h.a().a("", str, str2);
                if (h.a().a(c)) {
                    a((FaceCommonCallBack) faceCommonCallBack2);
                    if (asyncInitListener != null) {
                        asyncInitListener.onSuccess();
                    }
                } else if (asyncInitListener != null) {
                    asyncInitListener.onFailure();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            asyncInitListener.onFailure();
        }
    }

    public static final void asyncInitSdk(Application application, String str, String str2, AsyncInitListener asyncInitListener) {
        asyncInitSdkQB(application, str, str2, null, null, null, asyncInitListener);
    }

    private static void a(final FaceCommonCallBack<Boolean> faceCommonCallBack) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                k.b().a(faceCommonCallBack);
                x.a().a(KeplerApiManager.c);
                az.a().a(KeplerApiManager.c, "http://orbit.jd.com/upload", h.a().f());
                az.a().c();
                KeplerApiManager.d();
                KeplerApiManager.b = true;
            }
        }, " JD init asyncTask ");
        thread.setPriority(1);
        thread.start();
    }

    @Deprecated
    public void openCategoryListWebViewPage(String str, String str2) throws KeplerBufferOverflowException, KeplerNoThisCategoryException {
        openCategoryListWebViewPage(str, new KeplerAttachParameter().setCustomerInfo(str2));
    }

    public void openCategoryListWebViewPage(String str, KeplerAttachParameter keplerAttachParameter) throws KeplerBufferOverflowException, KeplerNoThisCategoryException {
        String str2 = (String) am.e.get(str);
        if (TextUtils.isEmpty(str2)) {
            throw new KeplerNoThisCategoryException(Category_Err_Info + str);
        }
        openWebViewPage(am.q + str2, null, false, keplerAttachParameter, true);
    }

    @Deprecated
    public KelperTask openCategoryListPage(String str, String str2, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, KeplerNoThisCategoryException, JSONException {
        return openCategoryListPage(str, new KeplerAttachParameter().setCustomerInfo(str2), context, openAppAction, i);
    }

    public KelperTask openCategoryListPage(String str, KeplerAttachParameter keplerAttachParameter, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, KeplerNoThisCategoryException, JSONException {
        String str2 = (String) am.e.get(str);
        if (TextUtils.isEmpty(str2)) {
            throw new KeplerNoThisCategoryException(Category_Err_Info + str);
        }
        return a(context, am.q + str2, null, false, keplerAttachParameter, true, openAppAction, i);
    }

    @Deprecated
    public void openNavigationWebViewPage(String str) throws KeplerBufferOverflowException {
        openNavigationWebViewPage(new KeplerAttachParameter().setCustomerInfo(str));
    }

    public void openNavigationWebViewPage(KeplerAttachParameter keplerAttachParameter) throws KeplerBufferOverflowException {
        openWebViewPage(k.b().f(), null, false, keplerAttachParameter, true);
    }

    @Deprecated
    public KelperTask openNavigationPage(String str, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return openNavigationPage(new KeplerAttachParameter().setCustomerInfo(str), context, openAppAction, i);
    }

    public KelperTask openNavigationPage(KeplerAttachParameter keplerAttachParameter, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return a(context, k.b().f(), null, false, keplerAttachParameter, true, openAppAction, i);
    }

    @Deprecated
    public void openSearchWebViewPage(String str, String str2) throws KeplerBufferOverflowException {
        openSearchWebViewPage(str, new KeplerAttachParameter().setCustomerInfo(str2));
    }

    public void openSearchWebViewPage(String str, KeplerAttachParameter keplerAttachParameter) throws KeplerBufferOverflowException {
        openWebViewPage(am.r + str, null, false, keplerAttachParameter, true);
    }

    @Deprecated
    public KelperTask openSearchPage(String str, String str2, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return openSearchPage(str, new KeplerAttachParameter().setCustomerInfo(str2), context, openAppAction, i);
    }

    public KelperTask openSearchPage(String str, KeplerAttachParameter keplerAttachParameter, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return a(context, am.r + str, null, false, keplerAttachParameter, true, openAppAction, i);
    }

    @Deprecated
    public void openItemDetailsWebViewPage(String str, String str2) throws KeplerBufferOverflowException {
        openItemDetailsWebViewPage(str, new KeplerAttachParameter().setCustomerInfo(str2));
    }

    public void openItemDetailsWebViewPage(String str, KeplerAttachParameter keplerAttachParameter) throws KeplerBufferOverflowException {
        String replace = am.t.replace("SKUID", str);
        p.b("suwg", "item:" + str + "  " + keplerAttachParameter + "  " + replace);
        openWebViewPage(replace, str, false, keplerAttachParameter, true);
        if (!TextUtils.isEmpty(str)) {
            aw.b(str);
            aw.c();
        }
    }

    @Deprecated
    public KelperTask openItemDetailsPage(String str, String str2, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return openItemDetailsPage(str, new KeplerAttachParameter().setCustomerInfo(str2), context, openAppAction, i);
    }

    public KelperTask openItemDetailsPage(String str, KeplerAttachParameter keplerAttachParameter, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        String replace = am.t.replace("SKUID", str);
        if (!TextUtils.isEmpty(str)) {
            aw.b(str);
            aw.c();
        }
        return a(context, replace, str, false, keplerAttachParameter, true, openAppAction, i);
    }

    @Deprecated
    public void openJDUrlWebViewPage(String str, String str2) throws KeplerBufferOverflowException {
        openWebViewPage(str, null, false, new KeplerAttachParameter().setCustomerInfo(str2), true);
    }

    public void openJDUrlWebViewPage(String str, KeplerAttachParameter keplerAttachParameter) throws KeplerBufferOverflowException {
        openWebViewPage(str, null, false, keplerAttachParameter, true);
    }

    @Deprecated
    public KelperTask openJDUrlPage(String str, String str2, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return openJDUrlPage(str, new KeplerAttachParameter().setCustomerInfo(str2), context, openAppAction, i);
    }

    public KelperTask openJDUrlPage(String str, KeplerAttachParameter keplerAttachParameter, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return a(context, str, null, false, keplerAttachParameter, true, openAppAction, i);
    }

    @Deprecated
    public void openOrderListWebViewPage(String str) throws KeplerBufferOverflowException {
        openOrderListWebViewPage(new KeplerAttachParameter().setCustomerInfo(str));
    }

    public void openOrderListWebViewPage(KeplerAttachParameter keplerAttachParameter) throws KeplerBufferOverflowException {
        openWebViewPage(k.b().c(), null, false, keplerAttachParameter, true);
    }

    @Deprecated
    public KelperTask openOrderListPage(String str, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return openOrderListPage(new KeplerAttachParameter().setCustomerInfo(str), context, openAppAction, i);
    }

    public KelperTask openOrderListPage(KeplerAttachParameter keplerAttachParameter, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return a(context, k.b().c(), null, false, keplerAttachParameter, true, openAppAction, i);
    }

    @Deprecated
    public void openCartWebViewPage(String str) throws KeplerBufferOverflowException {
        openCartWebViewPage(new KeplerAttachParameter().setCustomerInfo(str));
    }

    public void openCartWebViewPage(KeplerAttachParameter keplerAttachParameter) throws KeplerBufferOverflowException {
        openWebViewPage(k.b().e(), null, false, keplerAttachParameter, true);
    }

    @Deprecated
    public KelperTask openCartPage(String str, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return openCartPage(new KeplerAttachParameter().setCustomerInfo(str), context, openAppAction, i);
    }

    public KelperTask openCartPage(KeplerAttachParameter keplerAttachParameter, Context context, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        return a(context, k.b().e(), null, false, keplerAttachParameter, true, openAppAction, i);
    }

    public void add2Cart(Context context, String[] strArr, int[] iArr, final ActionCallBck actionCallBck) {
        int i = 0;
        if (isKeplerLogined()) {
            a(strArr, "SKUArray", iArr, "SKUNumber");
            String str = "{";
            try {
                String str2 = "[";
                for (String str3 : strArr) {
                    str2 = str2 + "\"" + str3 + "\",";
                }
                String str4 = "[";
                while (i < iArr.length) {
                    str4 = str4 + iArr[i] + ",";
                    i++;
                }
                String str5 = (str + "\"numList\":" + str4.subSequence(0, str4.length() - 1) + "],") + "\"skuList\":" + str2.subSequence(0, str2.length() - 1) + "]}";
                Map hashtable = new Hashtable();
                hashtable.put("v", "1.0");
                hashtable.put(Constants.PARAM_ACCESS_TOKEN, c());
                hashtable.put("app_key", h.a().f());
                hashtable.put("param_json", str5);
                hashtable.put("method", "jd.kepler.cart.add");
                new aa(new ab(am.f, hashtable, "get"), "add2Cart", 19, new ad(this) {
                    final /* synthetic */ KeplerApiManager b;

                    public void a(ac acVar) {
                        try {
                            JSONObject jSONObject = new JSONObject(acVar.b());
                            JSONObject optJSONObject = jSONObject.optJSONObject("jd_kepler_cart_add_response");
                            if (optJSONObject != null) {
                                int optInt = optJSONObject.optInt("errCode");
                                String optString = optJSONObject.optString("errMsg");
                                switch (optInt) {
                                    case 0:
                                        actionCallBck.onDateCall(optInt, optString);
                                        return;
                                    default:
                                        actionCallBck.onErrCall(optInt, optString);
                                        return;
                                }
                            }
                            jSONObject = jSONObject.optJSONObject("errorResponse");
                            if (jSONObject != null) {
                                int optInt2 = jSONObject.optInt("code");
                                String optString2 = jSONObject.optString("msg");
                                if (optInt2 >= 3000 || optInt2 <= 4000) {
                                    actionCallBck.onErrCall(3000, optString2);
                                    return;
                                } else {
                                    actionCallBck.onErrCall(optInt2, optString2);
                                    return;
                                }
                            }
                            actionCallBck.onErrCall(KeplerApiManager.KeplerApiManagerActionErr_DataErr, "parse json  is null  ex");
                        } catch (Throwable e) {
                            actionCallBck.onErrCall(KeplerApiManager.KeplerApiManagerActionErr_ParserErr, "parse json ex");
                            p.a(e, null);
                        } catch (Throwable e2) {
                            actionCallBck.onErrCall(0, "" + e2.getMessage());
                            l.a(e2, "2330166113451212");
                            p.a(e2, null);
                        }
                    }

                    public void a(int i, String str) {
                        actionCallBck.onDateCall(i, str);
                    }
                }).c();
                return;
            } catch (Throwable e) {
                p.a(e, null);
                actionCallBck.onErrCall(KeplerApiManagerActionErr_ParameterErr, "input parameter Exception ");
                return;
            }
        }
        actionCallBck.onErrCall(KeplerApiManagerActionErr_UNLogin, com.kepler.sdk.a.a().b("not_login"));
    }

    private String a(String[] strArr, String str, int[] iArr, String str2) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException(str + " is null");
        } else if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException(str2 + " is null");
        } else if (strArr.length < iArr.length) {
            throw new IllegalArgumentException(str + " size must >= " + str2 + " size");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("skuList=");
            for (Object obj : strArr) {
                if (TextUtils.isEmpty(obj)) {
                    throw new IllegalArgumentException(str + " item  is null");
                }
                stringBuffer.append(obj).append(",");
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("numList=");
            for (int i : iArr) {
                if (i <= 0) {
                    throw new IllegalArgumentException(str2 + " item  is null");
                }
                stringBuffer2.append(i).append(",");
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(stringBuffer.subSequence(0, stringBuffer.length() - 1)).append(HttpUtils.PARAMETERS_SEPARATOR).append(stringBuffer2.subSequence(0, stringBuffer2.length() - 1));
            return stringBuffer3.toString();
        }
    }

    public void openWebViewPage(String str, String str2, boolean z, KeplerAttachParameter keplerAttachParameter, boolean z2) throws KeplerBufferOverflowException {
        String str3 = "";
        try {
            JSONObject put = new JSONObject().put(SocialConstants.PARAM_TYPE, com.sina.weibo.sdk.c.a.DEFAULT_AUTH_ERROR_CODE).put("finalGetUrl", str);
            String str4 = "sku";
            if (aq.a(str2)) {
                str2 = "";
            }
            str3 = put.put(str4, str2).toString();
            try {
                if (c == null) {
                    throw new Exception(" Context is null, check init ");
                }
                Intent intent = new Intent();
                if (!(c instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                if (keplerAttachParameter != null) {
                    intent.putExtra(j.EXTRA_Auxiliary, keplerAttachParameter);
                }
                intent.putExtra(j.EXTRA_PARAMS, str3);
                intent.putExtra(j.EXTRA_isGetTokenAcFinish, z);
                if (!z2 || KeplerGlobalParameter.getSingleton().isOpenByH5Mode()) {
                    intent.setClassName(c, "com.kepler.jd.sdk.WebViewActivity");
                } else {
                    Object obj = ai.e(c) > 0 ? 1 : null;
                    boolean a = k.b().a(str);
                    if (obj == null || a) {
                        intent.setClassName(c, "com.kepler.jd.sdk.WebViewActivity");
                    } else {
                        intent.setClassName(c, "com.kepler.jd.sdk.KeplerMidActivity");
                    }
                }
                c.startActivity(intent);
                az.a().a("active");
            } catch (Throwable e) {
                p.a(e, "");
            }
        } catch (Throwable e2) {
            p.a(e2, "new JSONObject err ,can not cache");
        }
    }

    private KelperTask a(Context context, String str, String str2, boolean z, KeplerAttachParameter keplerAttachParameter, boolean z2, OpenAppAction openAppAction, int i) throws KeplerBufferOverflowException, JSONException {
        String str3 = "";
        try {
            Object obj;
            JSONObject put = new JSONObject().put(SocialConstants.PARAM_TYPE, com.sina.weibo.sdk.c.a.DEFAULT_AUTH_ERROR_CODE).put("finalGetUrl", str);
            String str4 = "sku";
            if (aq.a(str2)) {
                obj = "";
            } else {
                str3 = str2;
            }
            put.put(str4, obj).toString();
            obj = ai.e(c) > 0 ? 1 : null;
            boolean a = k.b().a(str);
            if (obj == null && openAppAction != null) {
                openAppAction.onStatus(4);
            }
            if (a && openAppAction != null) {
                openAppAction.onStatus(5);
            }
            if (obj != null && !a) {
                return new n(context, str, str2, z, keplerAttachParameter, openAppAction, i).a();
            }
            openWebViewPage(str, str2, z, keplerAttachParameter, true);
            return null;
        } catch (Throwable e) {
            p.a(e, "put into jSONObject err ,can not catch");
            throw e;
        }
    }

    public void cancelAuth(Context context) {
        m.a().a(context, "kepler_token", "");
        new ah(context).a(context, false);
    }

    private String c() {
        if (c == null) {
            return null;
        }
        return m.a().b(c, "kepler_token");
    }

    public boolean isKeplerLogined() {
        return !TextUtils.isEmpty(c());
    }

    public static String getKeplerVersion() {
        if (o.a.booleanValue()) {
            return "debug_2.2.0";
        }
        return BuildConfig.VERSION_NAME;
    }

    private void a(final Activity activity, final boolean z, final LoginListener<String> loginListener) {
        if (loginListener != null) {
            if (c == null) {
                loginListener.authFailed(KeplerApiManagerLoginErr_Init);
            } else if (b) {
                try {
                    g anonymousClass3 = new g<i>(this) {
                        final /* synthetic */ KeplerApiManager d;

                        public /* synthetic */ void authSuccess(Object obj) {
                            a((i) obj);
                        }

                        public void a(i iVar) {
                            if (iVar != null) {
                                List a = new ah(activity).a(activity, iVar.b);
                                if (a != null) {
                                    ap.a(activity, "Kepler_sdk_delete_cookies", a);
                                }
                            }
                            loginListener.authSuccess(null);
                        }

                        public void authFailed(int i) {
                            loginListener.authFailed(i);
                        }

                        public void openH5authPage() {
                            if (z) {
                                Object b = h.a().b();
                                if (TextUtils.isEmpty(b)) {
                                    loginListener.authFailed(KeplerApiManager.KeplerApiManagerLoginErr_openH5authPageURLSettingNull);
                                    return;
                                }
                                try {
                                    KeplerApiManager.getWebViewService().openWebViewPage(b, null, true, null, false);
                                    return;
                                } catch (KeplerBufferOverflowException e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            loginListener.authFailed(KeplerApiManager.KeplerApiManagerLoginErr_settingNotOpenH5authPage);
                        }
                    };
                    h.a().b(new ah(activity.getApplicationContext()).a());
                    h.a().a(activity, anonymousClass3);
                } catch (Throwable e) {
                    l.a(e, "2016053113498");
                }
            } else {
                loginListener.authFailed(KeplerApiManagerLoginErr_Init);
            }
        }
    }

    public void login(Activity activity, LoginListener<String> loginListener) {
        a(activity, true, loginListener);
    }

    public static Class<Activity> getC() {
        return e;
    }

    public static boolean setJDInwardL(Class cls) {
        if (c != null) {
            if (f.contains(c.getPackageName())) {
                e = cls;
                return true;
            }
        }
        return false;
    }

    public static void setInJDCode(final Context context, String str, final FaceCommonCallBack faceCommonCallBack) {
        h.a().a(str);
        h.a().a(new FaceCommonCallBack() {
            public boolean callBack(Object[] objArr) {
                if (objArr != null) {
                    try {
                        if (objArr.length >= 2) {
                            i iVar = (i) objArr[2];
                            if (((Boolean) objArr[1]).booleanValue() && iVar != null) {
                                List a = new ah(context).a(context, iVar.b);
                                if (a != null) {
                                    ap.a(context, "Kepler_sdk_delete_cookies", a);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                faceCommonCallBack.callBack(objArr);
                return false;
            }
        });
    }

    private static void d() {
    }

    public static String getMode() {
        return o.a();
    }

    public static void setD(boolean z) {
        o.l = z;
    }
}
