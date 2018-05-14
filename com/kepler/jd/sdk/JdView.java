package com.kepler.jd.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.net.HttpUtils;
import com.jd.jdsdk.R;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.sdk.bean.KeplerAttachParameter;
import com.kepler.jd.sdk.bean.KeplerGlobalParameter;
import com.kepler.sdk.a;
import com.kepler.sdk.ah;
import com.kepler.sdk.am;
import com.kepler.sdk.ao;
import com.kepler.sdk.ap;
import com.kepler.sdk.aq;
import com.kepler.sdk.ar;
import com.kepler.sdk.as;
import com.kepler.sdk.at;
import com.kepler.sdk.at.b;
import com.kepler.sdk.g;
import com.kepler.sdk.h;
import com.kepler.sdk.i;
import com.kepler.sdk.k;
import com.kepler.sdk.l;
import com.kepler.sdk.m;
import com.kepler.sdk.o;
import com.kepler.sdk.p;
import com.kepler.sdk.q;
import com.kepler.sdk.x;
import com.kepler.sdk.y;
import com.kepler.sdk.z;
import com.tencent.open.SocialConstants;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
class JdView extends RelativeLayout implements OnClickListener {
    @Deprecated
    private static final int CLEANTOKEN = 1006;
    private static final int FILE_CHOOSER_RESULT_CODE = 10000;
    public static final int MAX_TIME = 3000000;
    @Deprecated
    private static final int NOAPPKEY = 1005;
    @Deprecated
    private static final int NOTOKEN = 1001;
    private static final int RESETTOKEN = 1003;
    @Deprecated
    private static final int TIMEOUTTOKEN = 1004;
    private static final String fromKeplerMoreSelcetLoginOut = "#fromKeplerLoginOut";
    private static final String keplerCustomerInfo = "kepler-customerInfo";
    private String NuplSku;
    int RidbtnReload;
    int Ridglobal_loading_container;
    int Ridsdk_back;
    int Ridsdk_closed;
    int Ridsdk_more_select_lay_id;
    int Ridsdk_select_more;
    int Ridsdk_title;
    int Ridsdk_title_id;
    int Ridsdk_title_tabs_layout;
    int Ridsdk_xiangqing;
    int Ridweb_load_progressbar;
    int Ridweb_view_lin;
    int Rlayoutneterror_layout;
    int Rlayoutsdk_title_layout;
    int Rlayoutweb_bottom_layout;
    private JSONObject additiveJson = new JSONObject();
    private ImageButton backImage;
    private TextView checkdetail;
    public ah cookieutil;
    private Map<String, String> headMap = new HashMap();
    private TextView imageClosed;
    private boolean isGetTokenAcFinish;
    private boolean isGetTokenAcFinishCancel;
    private boolean isInKeplerLoginProcess;
    boolean isLoginReSetSIDOnly;
    private boolean isLoginSucceed;
    boolean isQBNopin;
    private y jdWebView;
    private Map<String, String> jsContextMap = new HashMap();
    private long lastTime = 0;
    private String loadingUrl = "";
    private HashSet<String> loginUrlSet = new HashSet();
    g mAuthListener;
    private FaceCommonCallBack mFaceCommonCallBack;
    private Handler mHandler;
    private KeplerAttachParameter mKeplerAttachParameter;
    private at mSelectMoreListView;
    int mUnplAjaxStatus = 0;
    private HashMap<String, Object> mapForOO = new HashMap();
    private Activity myActivity;
    private View netErrorView = null;
    private String oldUrl4View = "";
    private String onFinishUrl = "";
    int progressBarPro = 0;
    private ProgressBar progressbar;
    private String redirect_url = "";
    private ImageButton sdk_more_select;
    private LinearLayout sdk_more_select_lay_id;
    private String startUrl = "";
    private View titleLayout;
    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessageAboveL;
    private TextView webtitle;

    /* compiled from: TbsSdkJava */
    final class InJavaScriptLocalObj {
        InJavaScriptLocalObj() {
        }

        @JavascriptInterface
        public void showSource(String str, String str2) {
            String d = ar.d(str);
            JdView.this.setTitleName(d);
            p.b("suwg", "settitle:" + d + str2);
        }
    }

    /* compiled from: TbsSdkJava */
    class JDBaseWebViewClient extends z {
        JDBaseWebViewClient() {
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            p.b("suwg", "onReceivedError" + i + " " + str + "  " + str2);
        }

        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            String uri = webResourceRequest.getUrl().toString();
            p.b("suwg", "Client should Override--" + uri);
            return JdView.this.loadURlInKeplerStrictMode(uri);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (VERSION.SDK_INT > 21 && !o.u) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            p.b("suwg", "Client should Override--" + str);
            return JdView.this.loadURlInKeplerStrictMode(str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            p.b("suwg", "Client onPageStarted--" + str);
            super.onPageStarted(webView, str, bitmap);
            if (!TextUtils.isEmpty(str)) {
                JdView.this.changeViewByUrl(str);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            p.b("suwg", "Client onPageFinished----" + str);
            if (!TextUtils.isEmpty(str)) {
                JdView.this.onFinishUrl = str;
                JdView.this.jsInject(webView, str);
                if (JdView.this.progressbar != null) {
                    JdView.this.progressbar.setProgress(100);
                    JdView.this.progressBarPro = 0;
                    JdView.this.progressbar.setVisibility(8);
                }
                super.onPageFinished(webView, str);
                if (o.l) {
                    JdView.this.getHandlerKepler().postDelayed(new Runnable() {
                        public void run() {
                            JdView.this.closeActivity();
                        }
                    }, 5000);
                }
            }
        }
    }

    /* compiled from: TbsSdkJava */
    final class JDJsBridgeAndroidUIBack {
        JDJsBridgeAndroidUIBack() {
        }

        @JavascriptInterface
        public String jsLoad(String str, String str2, String str3, String str4) {
            try {
                String[] split = str.split("_");
                String str5 = split[0];
                String str6 = split[1];
                Object obj = JdView.this.mapForOO.get(str5);
                if (obj == null) {
                    obj = getByName(str5);
                    JdView.this.mapForOO.put(str5, obj);
                }
                if (obj != null) {
                    obj = obj.getClass().getMethod(str6, new Class[]{String.class}).invoke(obj, new Object[]{str2});
                    String obj2 = obj == null ? "" : obj.toString();
                    if (TextUtils.isEmpty(str3)) {
                        return obj2;
                    }
                    obj2 = str3 + obj2 + str4;
                    p.b("suwg", obj2);
                    JdView.this.loadJSOnUI(obj2);
                    return "";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        public String getKeplerCustomerInfo(String str) {
            return JdView.this.getmKeplerAttachParameterByKey("keplerCustomerInfo");
        }

        public String getJsContextValueByKey_134(String str) {
            return (String) JdView.this.jsContextMap.get(str);
        }

        public String removeJsContextValueByKey_134(String str) {
            return (String) JdView.this.jsContextMap.remove(str);
        }

        public String setjsContextKeyValue_134(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                return (String) JdView.this.jsContextMap.put(jSONObject.optString("key"), jSONObject.optString("value"));
            } catch (Exception e) {
                return null;
            }
        }

        public void setUNPLParameter(String str) {
            if (o.n) {
                p.b("suwg", "set cookies:" + str);
            }
            if (!aq.b(str)) {
                if (JdView.this.isLoginReSetSIDOnly) {
                    p.b("suwg", "only for SID");
                    JdView.this.isLoginReSetSIDOnly = false;
                } else if ("error".equalsIgnoreCase(str) || "undefined".equalsIgnoreCase(str)) {
                    JdView.this.mUnplAjaxStatus = 0;
                } else {
                    JdView.this.mUnplAjaxStatus = 2;
                    ap.a(JdView.this.myActivity, "cookies_unpl", str);
                    try {
                        String optString = new JSONObject(str).optString("k_unpl");
                        if (!aq.a(optString)) {
                            List arrayList = new ArrayList();
                            arrayList.add("unpl=" + optString + "; DOMAIN=.jd.com;");
                            arrayList.add("unpl=" + optString + "; DOMAIN=.hk.jd.com;");
                            JdView.this.cookieutil.a(JdView.this.myActivity, arrayList);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public String getUNPLParameter(String str) {
            String str2 = "'" + JdView.this.NuplSku + "','" + JdView.this.startUrl + "','" + ap.b(JdView.this.myActivity, "cookies_unpl", "null") + "','" + h.a().f() + "','" + KeplerGlobalParameter.getSingleton().getVirtualAppkey() + "','" + JdView.this.additiveJson.toString() + "'";
            if (o.n) {
                p.b("suwg", "getUNPLParameter:" + str2);
            }
            return str2;
        }

        public String getUNPLParameterCookies(String str) {
            String b = ap.b(JdView.this.myActivity, "cookies_unpl", "null");
            if (o.n) {
                p.b("suwg", "getUNPLParameterCookies:" + b);
            }
            return b;
        }

        public void setCode(String str) {
            if (o.n) {
                p.a("suwg", "获取到code:" + str);
            }
            h.a().a(str);
            h.a().a(null);
        }

        public void openLoginH5(String str) {
            JdView.this.getHandlerKepler().post(new Runnable() {
                public void run() {
                    JdView.this.goH5Login();
                }
            });
        }

        public void log(String str) {
            p.b("suwg", "jslog:" + str);
        }

        public void reLoadAddJs(final String str) {
            if (!aq.a(str)) {
                JdView.this.getHandlerKepler().postDelayed(new Runnable() {
                    public void run() {
                        JdView.this.addJSRun(str, true);
                    }
                }, 200);
            }
        }

        private Object getByName(String str) {
            return this;
        }
    }

    /* compiled from: TbsSdkJava */
    final class JDNet {
        JDNet() {
        }

        @JavascriptInterface
        public boolean check() {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) JdView.this.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
            } catch (Throwable e) {
                p.a(e);
                return true;
            }
        }
    }

    /* compiled from: TbsSdkJava */
    class JDWebChromeClient extends WebChromeClient {
        boolean isShow;

        JDWebChromeClient() {
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }

        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                JdView.this.progressBarPro = 0;
                this.isShow = false;
                JdView.this.progressbar.setVisibility(8);
            } else if (i > JdView.this.progressBarPro) {
                if (!this.isShow) {
                    JdView.this.progressbar.setVisibility(0);
                    this.isShow = true;
                }
                JdView.this.progressbar.setProgress(i);
                JdView.this.progressBarPro = i;
            }
            super.onProgressChanged(webView, i);
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (webView == null) {
                return true;
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            JdView.this.uploadMessage = valueCallback;
            JdView.this.openImageChooserActivity();
        }

        public void openFileChooser(ValueCallback valueCallback, String str) {
            JdView.this.uploadMessage = valueCallback;
            JdView.this.openImageChooserActivity();
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            JdView.this.uploadMessage = valueCallback;
            JdView.this.openImageChooserActivity();
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            JdView.this.uploadMessageAboveL = valueCallback;
            JdView.this.openImageChooserActivity();
            return true;
        }
    }

    /* compiled from: TbsSdkJava */
    abstract class JDjsInsert {
        String body;

        public JDjsInsert(String str) {
            this.body = str;
        }
    }

    /* compiled from: TbsSdkJava */
    class JDjsInsertSrc extends JDjsInsert {
        public JDjsInsertSrc(String str) {
            super(str);
        }
    }

    /* compiled from: TbsSdkJava */
    class JDjsInsertText extends JDjsInsert {
        public JDjsInsertText(String str) {
            super(str);
        }
    }

    private Handler getHandlerKepler() {
        return this.mHandler;
    }

    public JdView(String str, KeplerAttachParameter keplerAttachParameter, boolean z, Context context) {
        super(context);
        this.isGetTokenAcFinish = z;
        if (keplerAttachParameter != null) {
            try {
                this.mKeplerAttachParameter = keplerAttachParameter;
                this.mKeplerAttachParameter.add2Json(this.additiveJson);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.additiveJson.put("actId", KeplerGlobalParameter.getSingleton().getActId());
        this.additiveJson.put("ext", KeplerGlobalParameter.getSingleton().getExt());
        checkConfigChange();
        init(context, str);
    }

    private void checkConfigChange() {
        k.b().a(new FaceCommonCallBack<Boolean>() {
            public boolean callBack(Boolean... boolArr) {
                p.b("suwg", " get the config setting");
                return false;
            }
        });
        x.a().b();
    }

    @TargetApi(11)
    public void onResume() {
        this.jdWebView.onResume();
        long time = new Date().getTime();
        if (this.lastTime == 0) {
            this.lastTime = time;
            return;
        }
        if (time - this.lastTime >= ((long) (am.a ? 100000 : MAX_TIME))) {
            addSession();
            this.lastTime = time;
        }
    }

    @TargetApi(11)
    public void onPause() {
        this.jdWebView.onPause();
    }

    private void init(Context context, String str) {
        try {
            if (checkContext(context)) {
                initContainer();
                initIDs();
                addView(a.a().d("web_bottom_layout"));
                initTitleLayout();
                initWebview();
                initSelectMorelayout();
                initNetErrorLayout();
                loadParamsInKepler(str);
            }
        } catch (Throwable e) {
            l.a(e, "2016061349811");
            p.a(e);
        }
    }

    private void initContainer() {
        this.mHandler = new Handler();
        this.headMap.put("keplerm", "keplerm");
        this.cookieutil = new ah(getContext());
        this.mFaceCommonCallBack = new FaceCommonCallBack() {
            public boolean callBack(Object... objArr) {
                JdView.this.showMoreViewGone();
                return false;
            }
        };
    }

    private boolean checkContext(Context context) {
        try {
            this.myActivity = (Activity) context;
            if (this.myActivity == null || !"com.kepler.jd.sdk.WebViewActivity".equals(this.myActivity.getClass().getName())) {
                Toast.makeText(context, "this activity is not permitted !", 0).show();
                this.myActivity.finish();
                return false;
            }
        } catch (Throwable e) {
            p.a(e);
        }
        return true;
    }

    private boolean loadJSOnUI(final String str) {
        if (this.jdWebView != null) {
            getHandlerKepler().post(new Runnable() {
                public void run() {
                    String str = str;
                    if (!str.startsWith("javascript:")) {
                        str = "javascript:try{ " + str + "  }catch(e){ " + " console.log('js add js e：'+e.message); " + "};";
                    }
                    JdView.this.jdWebView.loadUrl(str);
                    p.b("suwg", str);
                }
            });
            return true;
        }
        p.b("suwg", "js run webview is null");
        return false;
    }

    private void initSelectMorelayout() {
        try {
            this.mSelectMoreListView = new at(this.myActivity);
            this.mSelectMoreListView.a(new FaceCommonCallBack<b>() {
                public boolean callBack(b... bVarArr) {
                    JdView.this.sdk_more_select_lay_id.setVisibility(4);
                    if (JdView.this.jdWebView == null) {
                        return true;
                    }
                    if (bVarArr == null || bVarArr.length <= 0) {
                        return false;
                    }
                    b bVar = bVarArr[0];
                    switch (bVar.d) {
                        case 5:
                            JdView.this.deleteCookieMode();
                            return false;
                        default:
                            if (aq.b(bVar.a)) {
                                return false;
                            }
                            JdView.this.loadURlInKeplerStrictMode(bVar.a);
                            return false;
                    }
                }
            });
            this.sdk_more_select_lay_id = (LinearLayout) a.a().a(this.Ridsdk_more_select_lay_id, (View) this);
            this.sdk_more_select_lay_id.addView(this.mSelectMoreListView);
        } catch (Exception e) {
            e.printStackTrace();
            this.sdk_more_select.setVisibility(8);
        }
    }

    private void deleteCookieMode() {
        this.redirect_url = this.onFinishUrl;
        m.a().a(getContext(), "kepler_token", "");
        this.cookieutil.a(this.myActivity, true);
        Toast.makeText(this.myActivity, a.a().a("loginout_success"), 0).show();
        Object b = h.a().b();
        if (!TextUtils.isEmpty(b)) {
            loadURlInKeplerLooseMode(b + fromKeplerMoreSelcetLoginOut);
        }
    }

    private void initIDs() {
        this.Rlayoutweb_bottom_layout = R.layout.web_bottom_layout;
        this.Ridsdk_title_id = R.id.sdk_title_id;
        this.Ridweb_load_progressbar = R.id.web_load_progressbar;
        this.Ridweb_view_lin = R.id.web_view_lin;
        this.Ridglobal_loading_container = R.id.global_loading_container;
        this.Ridsdk_title = R.id.sdk_title;
        this.Ridsdk_xiangqing = R.id.sdk_xiangqing;
        this.Ridsdk_back = R.id.sdk_back;
        this.RidbtnReload = R.id.btnReload;
        this.Ridsdk_closed = R.id.sdk_closed;
        this.Ridsdk_xiangqing = R.id.sdk_xiangqing;
        this.Ridglobal_loading_container = R.id.global_loading_container;
        this.Ridweb_load_progressbar = R.id.web_load_progressbar;
        this.Rlayoutneterror_layout = R.layout.neterror_layout;
        this.Rlayoutsdk_title_layout = R.layout.sdk_title_layout;
        this.Ridsdk_select_more = R.id.sdk_more_select;
        this.Ridsdk_more_select_lay_id = R.id.sdk_more_select_lay_id;
        this.Ridsdk_title_tabs_layout = R.id.sdk_title_tabs_layout;
    }

    private void initTitleLayout() {
        this.titleLayout = a.a().a(this.Ridsdk_title_id, (View) this);
        this.webtitle = (TextView) a.a().a(this.Ridsdk_title, (View) this);
        this.checkdetail = (TextView) a.a().a(this.Ridsdk_xiangqing, (View) this);
        this.imageClosed = (TextView) a.a().a(this.Ridsdk_closed, (View) this);
        this.backImage = (ImageButton) a.a().a(this.Ridsdk_back, (View) this);
        this.sdk_more_select = (ImageButton) a.a().a(this.Ridsdk_select_more, (View) this);
        this.checkdetail.setOnClickListener(this);
        this.backImage.setOnClickListener(this);
        this.imageClosed.setOnClickListener(this);
        this.sdk_more_select.setOnClickListener(this);
        this.progressbar = (ProgressBar) a.a().a(this.Ridweb_load_progressbar, (View) this);
    }

    private void initNetErrorLayout() {
        try {
            this.netErrorView = a.a().a(this.Ridglobal_loading_container, (View) this);
            a.a().a(this.RidbtnReload, (View) this).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (ao.a(JdView.this.myActivity.getApplicationContext())) {
                        JdView.this.netErrorView.setVisibility(8);
                    } else {
                        Toast.makeText(JdView.this.getContext(), a.a().a("kepler_check_net"), 0).show();
                    }
                }
            });
        } catch (Throwable th) {
            l.a(th, "20160321349813");
            p.a(th);
        }
    }

    boolean showMoreViewGone() {
        if (this.sdk_more_select_lay_id == null || !this.sdk_more_select_lay_id.isShown()) {
            return false;
        }
        this.sdk_more_select_lay_id.setVisibility(4);
        return true;
    }

    private void initWebview() {
        try {
            this.jdWebView = new y(getContext());
            initjsBridge();
            this.jdWebView.setWebViewClient(new JDBaseWebViewClient());
            this.jdWebView.setWebChromeClient(new JDWebChromeClient());
            RelativeLayout relativeLayout = (RelativeLayout) a.a().a(this.Ridweb_view_lin, (View) this);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (o.e.booleanValue()) {
                layoutParams.setMargins(20, 20, 20, 20);
                setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            }
            relativeLayout.addView(this.jdWebView, layoutParams);
        } catch (Throwable e) {
            l.a(e, "201603213498232");
            p.a(e);
        }
    }

    private void loadParamsInKepler(String str) {
        try {
            String str2 = "";
            JSONObject jSONObject = new JSONObject(str);
            if (this.isGetTokenAcFinish) {
                str2 = jSONObject.optString("finalGetUrl");
                this.cookieutil.a(getContext(), str2);
                viewLoadUrl(str2);
                return;
            }
            CharSequence string = jSONObject.getString(SocialConstants.PARAM_TYPE);
            this.NuplSku = jSONObject.optString("sku");
            if ("".equals(this.NuplSku)) {
                this.NuplSku = null;
            }
            if (!TextUtils.isEmpty(string) && com.sina.weibo.sdk.c.a.DEFAULT_AUTH_ERROR_CODE.equals(string)) {
                str2 = jSONObject.optString("finalGetUrl");
                if (aq.a(this.NuplSku) && k.b().j(str2) > 0) {
                    String k = k.b().k(str2);
                    if (!aq.b(k)) {
                        this.NuplSku = k;
                    }
                }
                this.startUrl = str2;
                loadURlInKeplerStrictMode(am.z);
            }
        } catch (Throwable e) {
            l.a(e, "2016032134982323");
            p.a(e);
        }
    }

    private void initjsBridge() {
        this.jdWebView.a(new InJavaScriptLocalObj(), "local_obj");
        this.jdWebView.a(new JDNet(), "JDNet");
        this.jdWebView.a(new JDJsBridgeAndroidUIBack(), "JDJSBridge");
    }

    private boolean isLoginOutUrl(String str) {
        q qVar = new q("判断维度：logout");
        if (aq.a(am.m, str)) {
            m.a().a(getContext(), "kepler_token", "");
            deleteCookieMode();
            qVar.a("是");
            return true;
        }
        qVar.a("非");
        return false;
    }

    private boolean isAndroidLoadTrueUrl(String str) {
        try {
            q qVar = new q("判断维度：必须使用加载true");
            if (k.b().l(str)) {
                qVar.a("是");
                return true;
            }
            qVar.a("非");
            return false;
        } catch (Throwable e) {
            l.a(e, "2016032134983434");
            p.a(e);
        }
    }

    private boolean isUnNeedLoadUrl(String str) {
        q qVar = new q("判断维度：block url");
        try {
            if (!k.b().i(str)) {
                qVar.a("black_url");
                return true;
            } else if (isSchemeUrl(str)) {
                qVar.a("scheme");
                return true;
            } else if (transfer302(str)) {
                qVar.a("302");
                return true;
            } else if (o.t && QBChangeAccount(str)) {
                qVar.a("QBChangeAccount");
                return true;
            } else {
                if (authorizationGetCode(str)) {
                    qVar.a("auth_code");
                    return true;
                }
                qVar.a("");
                return false;
            }
        } catch (Throwable th) {
            l.a(th, "201603213494348");
            p.a(th);
        }
    }

    private String keplerChangeUrl(String str) {
        q qVar = new q("判断维度：换参");
        try {
            String URLParameters = URLParameters(str);
            int j = k.b().j(URLParameters);
            if (j > 0) {
                CharSequence k = k.b().k(URLParameters);
                String m = k.b().m(URLParameters);
                if (!aq.b(k)) {
                    URLParameters = am.t.replace("SKUID", k);
                }
                if (j == 1) {
                    URLParameters = URLParameters + HttpUtils.URL_AND_PARA_SEPARATOR + m;
                }
            }
            URLParameters = k.b().f(k.b().h(URLParameters));
            if (this.isInKeplerLoginProcess) {
                this.loginUrlSet.add(URLParameters);
            }
            qVar.a(URLParameters);
            if (o.m && URLParameters.startsWith("https")) {
                return URLParameters.replace("https", HttpHost.DEFAULT_SCHEME_NAME);
            }
            return URLParameters;
        } catch (Throwable e) {
            l.a(e, "2016032134984545");
            p.a(e);
            return null;
        }
    }

    private void resetCookie(String str) {
        this.cookieutil.a(getContext(), str);
    }

    private void viewLoadUrl(String str) {
        try {
            this.jdWebView.loadUrl(str, this.headMap);
        } catch (Throwable e) {
            l.a(e, "201603213498454");
            p.a(e);
        }
    }

    private boolean QBChangeAccount(String str) {
        try {
            if (TextUtils.isEmpty(str) || !aq.a(am.k, str) || this.myActivity == null) {
                return false;
            }
            p.b("suwg", "QB 使用其他登录");
            goH5Login();
            return true;
        } catch (Throwable e) {
            l.a(e, "2016032134984545");
            p.a(e);
            return false;
        }
    }

    private boolean transfer302(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (aq.a(am.l)) {
                return false;
            }
            String[] strArr = am.l;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                if (!aq.a(strArr[i], str) || this.myActivity == null) {
                    i++;
                } else {
                    try {
                        this.redirect_url = URLDecoder.decode((String) ar.a(str).get("returnurl"), CommonUtil.UTF8);
                        handleCode(1003);
                        return true;
                    } catch (Throwable e) {
                        e.printStackTrace();
                        p.a(e);
                        return false;
                    }
                }
            }
            return false;
        } catch (Throwable e2) {
            l.a(e2, "2016032134984545");
            p.a(e2);
        }
    }

    boolean isdirectBuy(String str) {
        if (aq.b(str)) {
            return false;
        }
        return str.contains("kepler.jd.com/cart/directBuy");
    }

    void goH5Login() {
        Object b = h.a().b();
        if (!TextUtils.isEmpty(b)) {
            loadURlInKeplerStrictMode(b);
        }
    }

    private void setMCookie(List<String> list) {
        for (String a : list) {
            p.a("suwg", a);
        }
        List a2 = this.cookieutil.a(this.myActivity, (List) list);
        if (a2 != null) {
            ap.a(this.myActivity, "Kepler_sdk_delete_cookies", a2);
        }
    }

    public void gettoken() {
        this.isInKeplerLoginProcess = true;
        this.loginUrlSet.clear();
        p.b("suwg", "设置302callback,启动app");
        if (isdirectBuy(this.redirect_url) && this.redirect_url.contains("newpage=1")) {
            goH5Login();
            return;
        }
        try {
            this.mAuthListener = new g<i>() {
                public void authSuccess(i iVar) {
                    JdView.this.isInKeplerLoginProcess = false;
                    JdView.this.isLoginSucceed = true;
                    JdView.this.isQBNopin = false;
                    p.b("suwg", "redirect_url:" + JdView.this.redirect_url);
                    if (iVar != null) {
                        JdView.this.setMCookie(iVar.b);
                    } else {
                        p.a("suwg", "cookie is null");
                    }
                    JdView.this.getHandlerKepler().post(new Runnable() {
                        public void run() {
                            JdView.this.loadURlInKeplerStrictMode(JdView.this.redirect_url);
                        }
                    });
                }

                public void authFailed(final int i) {
                    JdView.this.isInKeplerLoginProcess = false;
                    JdView.this.getHandlerKepler().post(new Runnable() {
                        public void run() {
                            p.b("suwg", "失败" + i + " " + JdView.this.redirect_url);
                            if (!aq.b(JdView.this.redirect_url)) {
                                if (!JdView.this.redirect_url.startsWith(am.p)) {
                                    if (JdView.this.isQBNopin && i == 2) {
                                        return;
                                    }
                                }
                                return;
                            }
                            JdView.this.isQBNopin = false;
                        }
                    });
                }

                public void openQBH5authPage(int i, String str, String str2, String str3) {
                    JdView.this.isQBNopin = false;
                    final String b = h.a().b(str, str2, str3);
                    JdView.this.getHandlerKepler().post(new Runnable() {
                        public void run() {
                            JdView.this.loadURlInKeplerStrictMode(b);
                        }
                    });
                }

                public void openH5authPage() {
                    p.b("suwg", "appXXX，启动H5");
                    JdView.this.isQBNopin = false;
                    JdView.this.getHandlerKepler().post(new Runnable() {
                        public void run() {
                            Object obj = null;
                            if (!aq.a(JdView.this.redirect_url)) {
                                if (JdView.this.isdirectBuy(ar.e(JdView.this.redirect_url))) {
                                    obj = k.b().h() + "?successUrl=" + ar.f(JdView.this.redirect_url);
                                }
                            }
                            if (aq.b(obj) && o.t) {
                                String d = h.a().d();
                                if (!aq.b(d)) {
                                    obj = d;
                                }
                            }
                            if (aq.b(obj)) {
                                obj = h.a().b();
                            }
                            if (!TextUtils.isEmpty(obj)) {
                                JdView.this.loadURlInKeplerStrictMode(obj);
                            }
                        }
                    });
                }
            };
            h.a().b(this.cookieutil.a());
            h.a().a((Activity) getContext(), this.mAuthListener);
        } catch (Throwable e) {
            l.a(e, "20160321349845455");
            p.a(e);
        }
    }

    private void handleCode(int i) {
        switch (i) {
            case 1001:
                gettoken();
                return;
            case 1003:
                m.a().a(getContext(), "kepler_token", "");
                resetCookie(this.onFinishUrl);
                gettoken();
                return;
            case 1004:
                m.a().a(getContext(), "kepler_token", "");
                resetCookie(this.onFinishUrl);
                gettoken();
                return;
            case 1005:
                p.a("error", "appkey不存在");
                return;
            case 1006:
                m.a().a(getContext(), "kepler_token", "");
                resetCookie(this.onFinishUrl);
                return;
            default:
                return;
        }
    }

    private boolean authorizationGetCode(String str) {
        try {
            if (str.contains(k.b().a()) && str.contains("code=")) {
                Map a = ar.a(str);
                if (a.containsKey("code")) {
                    h.a().a((String) a.get("code"));
                    h.a().a(new FaceCommonCallBack() {
                        public boolean callBack(Object[] objArr) {
                            Object obj = 1;
                            if (JdView.this.isGetTokenAcFinishCancel) {
                                return true;
                            }
                            if (objArr != null && objArr.length == 3) {
                                try {
                                    boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                                    if (objArr[0] == null) {
                                        obj = null;
                                    }
                                    i iVar = (i) objArr[2];
                                    if (iVar != null) {
                                        JdView.this.setMCookie(iVar.b);
                                    } else {
                                        p.a("suwg", "cookie is null");
                                    }
                                    if (JdView.this.isGetTokenAcFinish) {
                                        JdView.this.getHandlerKepler().post(new Runnable() {
                                            public void run() {
                                                JdView.this.closeActivity();
                                            }
                                        });
                                        return false;
                                    } else if (booleanValue && r1 == null) {
                                        p.b("suwg", "redirect_url 主动:" + JdView.this.redirect_url);
                                        if (!aq.a(JdView.this.redirect_url)) {
                                            JdView.this.startUrl = JdView.this.redirect_url.replaceAll("sid=", "keplerOutDataSid=");
                                            JdView.this.isLoginReSetSIDOnly = true;
                                            JdView.this.getHandlerKepler().post(new Runnable() {
                                                public void run() {
                                                    JdView.this.loadURlInKeplerStrictMode(am.z);
                                                }
                                            });
                                        }
                                    }
                                } catch (Exception e) {
                                }
                            }
                            return false;
                        }
                    });
                }
                return true;
            }
        } catch (Throwable e) {
            l.a(e, "20160321349845456");
            p.a(e);
        }
        return false;
    }

    public String URLParameters(String str) {
        try {
            k.b().c(str);
            if (k.b().d(str)) {
                str = k.b().e(str);
            }
        } catch (Throwable e) {
            l.a(e, "2016032134985656");
            p.a(e);
        }
        return str;
    }

    private void openImageChooserActivity() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.myActivity.startActivityForResult(Intent.createChooser(intent, "Image Chooser"), 10000);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 10000) {
            return;
        }
        if (this.uploadMessage != null || this.uploadMessageAboveL != null) {
            Object data = (intent == null || i2 != -1) ? null : intent.getData();
            if (this.uploadMessageAboveL != null) {
                onActivityResultAboveL(i, i2, intent);
            } else if (this.uploadMessage != null) {
                this.uploadMessage.onReceiveValue(data);
                this.uploadMessage = null;
            }
        }
    }

    @TargetApi(21)
    public void onActivityResultAboveL(int i, int i2, Intent intent) {
        if (i == 10000 && this.uploadMessageAboveL != null) {
            Object obj;
            if (i2 != -1 || intent == null) {
                obj = null;
            } else {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    Object obj2 = new Uri[clipData.getItemCount()];
                    for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                        obj2[i3] = clipData.getItemAt(i3).getUri();
                    }
                    obj = obj2;
                } else {
                    obj = null;
                }
                if (dataString != null) {
                    obj = new Uri[]{Uri.parse(dataString)};
                }
            }
            this.uploadMessageAboveL.onReceiveValue(obj);
            this.uploadMessageAboveL = null;
        }
    }

    public void setTitleName(final String str) {
        getHandlerKepler().post(new Runnable() {
            public void run() {
                CharSequence charSequence = "";
                try {
                    charSequence = ar.e(str);
                } catch (Throwable e) {
                    l.a(e, "2016032134989898");
                    p.a(e);
                }
                if (!TextUtils.isEmpty(charSequence) && charSequence.length() > 13) {
                    charSequence = charSequence.substring(0, 10) + "...";
                }
                JdView.this.webtitle.setText(charSequence);
            }
        });
    }

    private String getmKeplerAttachParameterByKey(String str) {
        if (keplerCustomerInfo != null) {
            return this.mKeplerAttachParameter.get(str);
        }
        return "null";
    }

    public boolean loadURlInKeplerStrictMode(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (isAndroidLoadTrueUrl(str) || isLoginOutUrl(str)) {
                return false;
            }
            if (isUnNeedLoadUrl(str)) {
                return true;
            }
            String keplerChangeUrl = keplerChangeUrl(str);
            if (aq.a(keplerChangeUrl)) {
                return true;
            }
            loadURlInKeplerLooseMode(keplerChangeUrl);
            return true;
        } catch (Throwable e) {
            l.a(e, "201603213498898");
            p.a(e);
            return false;
        }
    }

    public void loadURlInKeplerLooseMode(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.loadingUrl = str;
                changeViewByUrl(str);
                resetCookie(str);
                viewLoadUrl(str);
            }
        } catch (Throwable e) {
            l.a(e, "201603213498898");
            p.a(e);
        }
    }

    public boolean goBack(int i) {
        p.b("suwg", "goback");
        if (showMoreViewGone()) {
            return true;
        }
        if (this.isGetTokenAcFinish) {
            this.isGetTokenAcFinishCancel = true;
            closeActivity();
            h.a().a(2);
            return true;
        }
        try {
            if (this.jdWebView != null) {
                int i2;
                WebBackForwardList copyBackForwardList = this.jdWebView.copyBackForwardList();
                int currentIndex = copyBackForwardList.getCurrentIndex();
                if (o.k) {
                    for (i2 = currentIndex; i2 >= 0; i2--) {
                        p.b("suwg", "webview history：" + i2 + " " + copyBackForwardList.getItemAtIndex(i2).getUrl());
                    }
                }
                if (currentIndex <= 0) {
                    closeActivity();
                    return true;
                }
                String url = copyBackForwardList.getItemAtIndex(currentIndex).getUrl();
                if (i == 0 && k.b().b(url)) {
                    showPayEndDialog();
                    return false;
                }
                String str = null;
                int i3 = currentIndex - 1;
                int i4 = -1;
                while (i3 >= 0) {
                    String str2;
                    if (copyBackForwardList.getSize() > i3) {
                        url = copyBackForwardList.getItemAtIndex(i3).getUrl();
                        if (str == null) {
                            str = copyBackForwardList.getItemAtIndex(i3 + 1).getUrl();
                        }
                        if (aq.a(str) || !str.endsWith(fromKeplerMoreSelcetLoginOut)) {
                            String str3;
                            if (!aq.a(url) && this.loginUrlSet.contains(url)) {
                                this.loginUrlSet.remove(url);
                                if (this.loginUrlSet.size() == 0) {
                                    this.isInKeplerLoginProcess = false;
                                }
                                if (this.isLoginSucceed) {
                                    str3 = url;
                                    i2 = i4 - 1;
                                    str2 = str3;
                                }
                            }
                            int a = k.b().a(url, str);
                            if (a == 2) {
                                p.b("suwg", "back2 ," + url + "" + str);
                                break;
                            }
                            if (a != 1) {
                                if (a == -1) {
                                    break;
                                }
                            }
                            p.b("suwg", "back1," + url + "" + str);
                            i4--;
                            str3 = url;
                            i2 = i4;
                            str2 = str3;
                        } else {
                            closeActivity();
                            return true;
                        }
                    }
                    i2 = i4;
                    str2 = str;
                    i3--;
                    str = str2;
                    i4 = i2;
                }
                p.b("suwg", "back to " + i4);
                if (currentIndex + i4 < 0) {
                    closeActivity();
                    return true;
                }
                this.jdWebView.goBackOrForward(i4);
            }
        } catch (Throwable e) {
            l.a(e, "201603213492328");
            p.a(e);
        }
        return true;
    }

    private void showPayEndDialog() {
        as.a aVar = new as.a(this.myActivity);
        aVar.a(a.a().b("give_up_message"));
        aVar.b(a.a().b("give_up_title"));
        aVar.a(a.a().b("give_up_goon"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        aVar.b(a.a().b("give_up_affirm"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                JdView.this.goBack(1);
            }
        });
        aVar.a().show();
    }

    private void closeActivity() {
        if (this.myActivity != null) {
            this.myActivity.finish();
        }
    }

    private void changeViewByUrl(String str) {
        try {
            if (str != this.oldUrl4View) {
                this.oldUrl4View = str;
                if (k.b().b(str)) {
                    if (!(this.checkdetail == null || this.checkdetail.isShown())) {
                        this.checkdetail.setVisibility(0);
                    }
                } else if (this.checkdetail != null && this.checkdetail.isShown()) {
                    this.checkdetail.setVisibility(8);
                }
                if (k.b().n(str)) {
                    if (this.imageClosed.isShown()) {
                        this.imageClosed.setVisibility(8);
                    }
                    this.sdk_more_select.setVisibility(8);
                } else {
                    if (!this.imageClosed.isShown()) {
                        this.imageClosed.setVisibility(0);
                    }
                    this.sdk_more_select.setVisibility(0);
                }
                if (this.mSelectMoreListView != null) {
                    this.mSelectMoreListView.a(str, this.sdk_more_select_lay_id.isShown());
                }
            }
        } catch (Throwable e) {
            l.a(e, "201603213498342");
            p.a(e);
        }
    }

    public void onClick(View view) {
        try {
            int id = view.getId();
            if (id == this.Ridsdk_closed) {
                if (this.myActivity != null) {
                    this.myActivity.finish();
                }
            } else if (id == this.Ridsdk_back) {
                goBack(0);
            } else if (id == this.Ridsdk_xiangqing) {
                loadURlInKeplerStrictMode(k.b().c());
            } else if (id == this.Ridsdk_select_more) {
                if (this.sdk_more_select_lay_id == null) {
                    return;
                }
                if (this.sdk_more_select_lay_id.isShown()) {
                    this.sdk_more_select_lay_id.setVisibility(4);
                    this.jdWebView.a(null);
                    return;
                }
                this.sdk_more_select_lay_id.setVisibility(0);
                this.mSelectMoreListView.a();
                this.jdWebView.a(this.mFaceCommonCallBack);
            } else if (id != this.Ridsdk_title) {
            }
        } catch (Throwable e) {
            l.a(e, "201603213434398");
            p.a(e);
        }
    }

    private void jsInject(final WebView webView, final String str) {
        webView.loadUrl("javascript:var ti=document.title; var u= '" + str + "'; " + "window.local_obj.showSource(ti,u);  ");
        if (!am.z.equals(str) && k.b().b && !o.o && this.mUnplAjaxStatus == 0) {
            getHandlerKepler().postDelayed(new Runnable() {
                public void run() {
                    String access$2500 = JdView.this.addJSRun(am.w, true);
                    if (o.p) {
                        p.b("suwg", str + ":  " + access$2500);
                    }
                    webView.loadUrl(access$2500);
                }
            }, 200);
            this.mUnplAjaxStatus = 1;
            getHandlerKepler().postDelayed(new Runnable() {
                public void run() {
                    if (JdView.this.mUnplAjaxStatus == 1) {
                        JdView.this.mUnplAjaxStatus = 0;
                    }
                }
            }, (long) (k.b().a * 1000));
        }
        ArrayList g = k.b().g(str);
        for (int i = 0; i < g.size(); i++) {
            String str2 = (String) g.get(i);
            if (!TextUtils.isEmpty(str2)) {
                if (o.p) {
                    p.b("suwg", str + "  " + str2);
                }
                webView.loadUrl(str2);
            }
        }
    }

    private boolean isSchemeUrl(String str) {
        if (o.t && str.equals("qb://freewifi/?ch=0001")) {
            try {
                Intent intent = new Intent();
                intent.setPackage(this.myActivity.getPackageName());
                intent.setData(Uri.parse("mttbrowser://url=qb://freewifi,newApi=1"));
                intent.addCategory("android.intent.category.BROWSABLE");
                this.myActivity.startActivity(intent);
                return true;
            } catch (Throwable th) {
                p.a(th);
                return true;
            }
        }
        boolean startsWith = str.startsWith("weixin:");
        boolean startsWith2 = str.startsWith("openapp.jdmobile:");
        if (!startsWith && !startsWith2) {
            return false;
        }
        if (startsWith2) {
            return true;
        }
        try {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(805306368);
            getContext().startActivity(intent);
            return true;
        } catch (Throwable th2) {
            p.a(th2, "open url ex");
            return true;
        }
    }

    private void addSession() {
        loadJSOnUI(addJSRun(new JDjsInsertSrc(am.y), true));
    }

    private String addJSRun(String str, boolean z) {
        return addJSRun(new JDjsInsertSrc(str), z);
    }

    private String addJSRun(JDjsInsert jDjsInsert, boolean z) {
        return "javascript: try{ var oSc=document.createElement('script'); " + (jDjsInsert instanceof JDjsInsertText ? "oSc.text='" : " oSc.src='") + jDjsInsert.body + "'; " + "oSc.type='text/javascript'; " + "document.body.appendChild(oSc); " + " }catch(e){" + "console.log('js add js e：'+e.message); " + (z ? "JDJSBridge.jsLoad('webviewCore_reLoadAddJs','" + jDjsInsert + "', null,null);" : "") + " };";
    }
}
