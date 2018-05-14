package com.jd.fridge.control;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseFragment;
import com.jd.fridge.bean.ControlCommand;
import com.jd.fridge.bean.requestBody.FridgeControlSendBean;
import com.jd.fridge.bean.requestBody.FridgeStatus;
import com.jd.fridge.bean.requestBody.StreamsAndH5Info;
import com.jd.fridge.util.b.b;
import com.jd.fridge.util.b.b.a;
import com.jd.fridge.util.p;
import com.jd.fridge.util.socket.LongSocketService;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class ControlH5Fragment extends BaseFragment implements a {
    private static String f = ControlH5Fragment.class.getSimpleName();
    private static String g = "https://__bridge_loaded__/";
    BroadcastReceiver d = new BroadcastReceiver(this) {
        final /* synthetic */ ControlH5Fragment a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("get_snap_shot")) {
                String stringExtra = intent.getStringExtra("data");
                p.a(ControlH5Fragment.f, "广播收到数据：" + stringExtra);
                if (stringExtra != null) {
                    this.a.j.a(stringExtra);
                }
            }
        }
    };
    private Context e;
    private WebView h;
    private EmptyLayout i;
    private b j;
    private String k = "";
    private String l = HttpUtils.PATHS_SEPARATOR;
    private boolean m = false;
    private WebViewClient n = new WebViewClient(this) {
        final /* synthetic */ ControlH5Fragment a;

        {
            this.a = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            p.a(ControlH5Fragment.f, "shouldOverrideUrlLoading : " + str);
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            p.a(ControlH5Fragment.f, "onPageFinished : " + str);
            if (y.d(this.a.e)) {
                this.a.a(this.a.h);
                this.a.m = true;
                this.a.f();
                if (!TextUtils.isEmpty(LongSocketService.e())) {
                    p.a(ControlH5Fragment.f, "first: " + LongSocketService.e());
                    this.a.j.a(LongSocketService.e());
                }
            }
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            p.b(ControlH5Fragment.f, "onReceiverdError..." + webResourceError.getDescription().toString() + "  -  " + webResourceError.getErrorCode() + " request_url: " + webResourceRequest.getUrl());
            if (!webResourceRequest.getUrl().toString().equals(ControlH5Fragment.g) && webResourceError.getErrorCode() != -11) {
                this.a.a(1);
            }
        }
    };

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_control_h5, viewGroup, false);
        b(inflate);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.e = getActivity();
        d();
        e();
    }

    public void onResume() {
        super.onResume();
        p.a(f, "ControlH5Fragment onResume...");
        if ("0".equals(GlobalVariable.C())) {
            a(9);
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            p.a(f, "isVisibleToUser");
            if ("0".equals(GlobalVariable.C())) {
                a(9);
            } else if (this.m) {
                b("");
            }
        }
    }

    public void onPause() {
        super.onPause();
        p.a(f, "ControlH5Fragment onPause...");
    }

    private void d() {
        if ("0".equals(GlobalVariable.C())) {
            a(9);
            return;
        }
        a(2);
        String str = null;
        try {
            str = URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        com.jd.fridge.a.a().a(this.a, new StreamsAndH5Info(str, Long.parseLong(GlobalVariable.C())));
    }

    private void a(View view) {
        this.h = (WebView) view.findViewById(R.id.control_webview);
        this.h.setWebViewClient(this.n);
        this.j = new b(getActivity(), this.h, this);
        WebSettings settings = this.h.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(2);
        settings.setBlockNetworkImage(false);
        settings.setDomStorageEnabled(true);
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.h.addJavascriptInterface(this.j, "_WebViewJavascriptBridge");
        this.h.setWebChromeClient(new WebChromeClient());
    }

    private void b(View view) {
        a(view);
        ((TextView) view.findViewById(R.id.app_title_textview)).setText(getResources().getString(R.string.tab_control));
        this.i = (EmptyLayout) view.findViewById(R.id.empty_layout);
        this.i.setRefresh(new OnClickListener(this) {
            final /* synthetic */ ControlH5Fragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (TextUtils.isEmpty(this.a.k)) {
                        this.a.d();
                    } else {
                        this.a.h.loadUrl(this.a.k);
                    }
                }
            }
        });
    }

    public boolean handleMessage(Message message) {
        Bundle data;
        String string;
        switch (message.what) {
            case 7006:
                this.k = message.obj.toString();
                a(this.e, this.k);
                this.h.loadUrl(this.k);
                p.a(f, "network url: " + this.k);
                break;
            case 7007:
                p.b(f, "MESSAGE_CODE_RESULT_FAILED_SET_FOODS");
                f();
                a(1);
                break;
            case 10006:
                a(1);
                break;
            case 10007:
                data = message.getData();
                string = data.getString("result");
                String string2 = data.getString("responesId");
                if (TextUtils.isEmpty(string2)) {
                    this.j.a(string);
                } else {
                    this.j.a(string2, string);
                }
                p.a(f, "snap shot result (" + string2 + "): " + string);
                break;
            case 10008:
                data = message.getData();
                string = data.getString("result");
                this.j.a(data.getString("responesId"), string);
                p.a(f, "control result: " + string);
                break;
        }
        return super.handleMessage(message);
    }

    private void a(WebView webView) {
        com.jd.fridge.util.b.a.a(webView, "jswebviewjavascriptbridge.js");
    }

    private void e() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("get_snap_shot");
            getActivity().registerReceiver(this.d, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, String str) {
        if (y.d(this.e)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            List arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                arrayList.add(new ControlCommand(optJSONObject.optString("stream_id"), optJSONObject.optString("current_value")));
            }
            com.jd.fridge.a.a().a(this.a, new FridgeControlSendBean(Long.parseLong(GlobalVariable.C()), arrayList), str);
            return;
        }
        this.a.sendEmptyMessage(10006);
    }

    public void b(String str) {
        if (!GlobalVariable.C().equals("0")) {
            com.jd.fridge.a.a().a(this.a, new FridgeStatus(Long.parseLong(GlobalVariable.C()), GlobalVariable.L()), str);
        }
    }

    public void c(String str) {
    }

    private void a(int i) {
        this.i.setVisibility(0);
        this.i.setErrorType(i);
    }

    private void f() {
        this.i.setVisibility(8);
    }

    public void a(Context context, String str) {
        if (VERSION.SDK_INT >= 21) {
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptThirdPartyCookies(this.h, true);
            HttpCookie httpCookie = new HttpCookie("fid", GlobalVariable.C());
            httpCookie.setDomain(GlobalVariable.B().g());
            httpCookie.setPath(this.l);
            httpCookie.setMaxAge(2147483647L);
            instance.setCookie(str, httpCookie.toString());
            httpCookie = new HttpCookie("wskey", com.jd.fridge.util.c.a.b().getA2());
            httpCookie.setDomain(GlobalVariable.B().g());
            httpCookie.setPath(this.l);
            httpCookie.setMaxAge(2147483647L);
            instance.setCookie(str, httpCookie.toString());
            instance.flush();
            return;
        }
        CookieSyncManager.createInstance(context);
        instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        instance.removeSessionCookie();
        httpCookie = new HttpCookie("fid", GlobalVariable.C());
        httpCookie.setDomain(GlobalVariable.B().g());
        httpCookie.setPath(this.l);
        httpCookie.setMaxAge(2147483647L);
        instance.setCookie(str, httpCookie.toString());
        httpCookie = new HttpCookie("wskey", com.jd.fridge.util.c.a.b().getA2());
        httpCookie.setDomain(GlobalVariable.B().g());
        httpCookie.setPath(this.l);
        httpCookie.setMaxAge(2147483647L);
        instance.setCookie(str, httpCookie.toString());
        CookieSyncManager.getInstance().sync();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            p.a(f, "onDestroy...");
            this.h.loadUrl("about:blank");
            this.h.stopLoading();
            this.h.setWebChromeClient(null);
            this.h.setWebViewClient(null);
            this.h.removeAllViews();
            this.h.clearHistory();
            this.h.destroy();
            this.h = null;
            if (this.d != null) {
                getActivity().unregisterReceiver(this.d);
            }
        }
    }
}
