package com.jd.fridge.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.google.gson.Gson;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FridgeInfoBean;
import com.jd.fridge.bean.requestBody.UserPin;
import com.jd.fridge.switchFridge.SwitchFridgeActivity;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.e.b;
import com.jd.fridge.widget.EmptyLayout;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.kepler.sdk.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import jd.wjlogin_sdk.common.listener.OnCommonCallback;
import jd.wjlogin_sdk.model.FailResult;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class BindWebActivity extends BaseActivity {
    private WebView a;
    private RelativeLayout b;
    private EmptyLayout c;
    private String d;

    protected int a() {
        return R.layout.bind_web_webview;
    }

    protected void b() {
        c(getString(R.string.input_message_code_title_text));
    }

    protected void c() {
    }

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("url");
        intent.getStringExtra("token");
        this.d = intent.getStringExtra("callBackActivity");
        this.a = new WebView(getApplicationContext());
        ((LinearLayout) findViewById(R.id.web_activity_root_layout)).addView(this.a, 0, new LayoutParams(-1, -1));
        this.c = (EmptyLayout) findViewById(R.id.empty_layout);
        this.b = (RelativeLayout) findViewById(R.id.empty_layout_root);
        this.a.getSettings().setJavaScriptEnabled(true);
        this.a.loadUrl(stringExtra);
        this.a.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ BindWebActivity a;

            {
                this.a = r1;
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                try {
                    Uri parse = Uri.parse(str);
                    if (str.toLowerCase().startsWith("openapp.jdmobile")) {
                        String query;
                        String str2 = "";
                        if (!parse.isOpaque()) {
                            str2 = parse.getQueryParameter(j.EXTRA_PARAMS);
                        }
                        if (StringUtils.isEmpty(str2)) {
                            query = parse.getQuery();
                        } else {
                            query = str2;
                        }
                        str2 = null;
                        if (TextUtils.isEmpty(query)) {
                            str2 = parse.getQueryParameter("safe_token");
                        } else if (query.contains("safe_token")) {
                            try {
                                str2 = new JSONObject(query).getString("safe_token");
                            } catch (Exception e) {
                            }
                        }
                        if (!StringUtils.isEmpty(str2)) {
                            a.b().h5BackToApp(str2, new OnCommonCallback(this) {
                                final /* synthetic */ AnonymousClass1 a;

                                {
                                    this.a = r1;
                                }

                                public void onSuccess() {
                                    try {
                                        com.jd.fridge.a.a().b(this.a.a.e, new UserPin(URLEncoder.encode(a.b().getPin(), CommonUtil.UTF8)));
                                    } catch (UnsupportedEncodingException e) {
                                        e.printStackTrace();
                                    }
                                }

                                public void onError(String str) {
                                    String str2 = "";
                                    if (str != null) {
                                        try {
                                            str2 = new JSONObject(str).getString("errMsg");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    this.a.a.b(str2);
                                }

                                public void onFail(FailResult failResult) {
                                    this.a.a.b(failResult.getMessage());
                                }
                            });
                        }
                    } else {
                        if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                            str = "http://" + str;
                        }
                        webView.loadUrl(str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.a.b("关联帐号失败");
                }
                return true;
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                this.a.b.setVisibility(0);
                this.a.c.setErrorType(1);
                this.a.c.setRefresh(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        this.a.a.b.setVisibility(8);
                        this.a.a.a.loadUrl(this.a.a.getIntent().getStringExtra("url"));
                    }
                });
            }
        });
    }

    protected void d() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.a.canGoBack()) {
            this.a.goBack();
            return true;
        }
        finish();
        return super.onKeyDown(i, keyEvent);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.a.removeAllViews();
        this.a.destroy();
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 2000:
                Object obj = (List) message.obj;
                if (obj != null && obj.size() != 0) {
                    if (obj.size() != 1) {
                        j();
                        b(getString(R.string.login_success));
                        String toJson = new Gson().toJson(obj);
                        Intent intent = new Intent(this, SwitchFridgeActivity.class);
                        intent.putExtra("SWITCH_FRIDGE_VIEW_MODE", true);
                        intent.putExtra("FEED_ID_JSON_STRING", toJson);
                        startActivity(intent);
                        finish();
                        break;
                    }
                    GlobalVariable.c(((FridgeInfoBean) obj.get(0)).getFeedId());
                    GlobalVariable.d(((FridgeInfoBean) obj.get(0)).getDeviceId());
                    GlobalVariable.f(((FridgeInfoBean) obj.get(0)).getBug_report());
                    GlobalVariable.e(((FridgeInfoBean) obj.get(0)).getControl_page());
                    GlobalVariable.f(((FridgeInfoBean) obj.get(0)).getBug_report());
                    GlobalVariable.e(((FridgeInfoBean) obj.get(0)).getControl_page());
                    b.a().c(((FridgeInfoBean) obj.get(0)).getProduct_uuid());
                    e();
                    break;
                }
                e();
                break;
                break;
            case 2001:
                e();
                break;
        }
        return true;
    }

    private void e() {
        j();
        b(getString(R.string.login_success));
        aa.a((Activity) this);
        finish();
    }
}
