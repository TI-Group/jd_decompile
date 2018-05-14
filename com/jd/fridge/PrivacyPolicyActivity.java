package com.jd.fridge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.switchFridge.SwitchFridgeActivity;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* compiled from: TbsSdkJava */
public class PrivacyPolicyActivity extends BaseActivity implements OnClickListener {
    int a;
    @BindView(2131559144)
    Button accept;
    String b = "http://static.360buyimg.com/nsng/common/fridge/html/agreement/privacy.html";
    String c = null;
    @BindView(2131559143)
    Button cancel;
    String d = null;
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    private final WebViewClient i = new WebViewClient(this) {
        final /* synthetic */ PrivacyPolicyActivity b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.b.mEmptyLayoutRoot.setVisibility(0);
            this.b.emptyLayout.setErrorType(1);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return super.shouldInterceptRequest(webView, str);
        }
    };
    @BindView(2131559139)
    ImageView leftIcon;
    @BindView(2131558580)
    View mEmptyLayoutRoot;
    @BindView(2131559141)
    ProgressBar mProgressBar;
    @BindView(2131559145)
    X5WebView mWebView;
    @BindView(2131559142)
    RelativeLayout rlBottom;
    @BindView(2131559140)
    TextView title;
    @BindView(2131559138)
    RelativeLayout titleBg;

    protected int a() {
        return R.layout.privacy_policy_activity;
    }

    @SuppressLint({"ResourceType"})
    protected void b() {
        ButterKnife.bind((Activity) this);
        getWindow().setFormat(-3);
        k();
        if (this.a == 0) {
            this.title.setTextColor(-1);
            this.leftIcon.setVisibility(0);
            this.leftIcon.setImageResource(R.drawable.appbar_back_selector);
            this.titleBg.setBackgroundColor(Color.parseColor(getString(R.color.jd_green_1)));
            this.rlBottom.setVisibility(8);
        } else {
            this.leftIcon.setVisibility(8);
            this.rlBottom.setVisibility(0);
            this.title.setTextColor(Color.parseColor(getString(R.color.jd_fridge_app_edit_text_color)));
            this.titleBg.setBackgroundColor(-1);
        }
        this.leftIcon.setOnClickListener(this);
        this.emptyLayout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ PrivacyPolicyActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (!y.d(this.a)) {
                        this.a.mEmptyLayoutRoot.setVisibility(0);
                        this.a.emptyLayout.setErrorType(1);
                        x.a(this.a, "网络断了哦，请检查网络设置");
                    } else if (!TextUtils.isEmpty(this.a.b)) {
                        this.a.mWebView.loadUrl(this.a.b);
                        this.a.mWebView.setVisibility(0);
                        this.a.mEmptyLayoutRoot.setVisibility(8);
                        this.a.emptyLayout.setErrorType(4);
                    }
                }
            }
        });
        this.accept.setOnClickListener(this);
        this.cancel.setOnClickListener(this);
        if (TextUtils.isEmpty(this.d)) {
            this.title.setText(getString(R.string.privacy_policy));
        } else {
            this.title.setText(this.d);
        }
        this.mWebView.setWebViewClient(this.i);
        this.mWebView.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ PrivacyPolicyActivity a;

            {
                this.a = r1;
            }

            public void onProgressChanged(WebView webView, int i) {
                if (i <= 0 || i >= 100) {
                    if (i == 100) {
                        this.a.mProgressBar.setVisibility(8);
                    }
                } else if (this.a.mProgressBar.getVisibility() == 8) {
                    this.a.mProgressBar.setVisibility(0);
                }
                this.a.mProgressBar.setProgress(i);
                super.onProgressChanged(webView, i);
            }
        });
        if (y.d(getBaseContext())) {
            this.mWebView.loadUrl(this.b);
        } else {
            this.mEmptyLayoutRoot.setVisibility(0);
            this.emptyLayout.setErrorType(1);
            this.mWebView.setVisibility(8);
        }
        this.mWebView.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ PrivacyPolicyActivity a;

            {
                this.a = r1;
            }

            public boolean onLongClick(View view) {
                return true;
            }
        });
    }

    protected void c() {
    }

    protected void d() {
        this.a = getIntent().getIntExtra("style", 0);
        this.c = getIntent().getStringExtra("FEED_ID_JSON_STRING");
        if (!TextUtils.isEmpty(getIntent().getStringExtra("url"))) {
            this.b = getIntent().getStringExtra("url");
        }
        this.d = getIntent().getStringExtra("title");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_icon:
                finish();
                return;
            case R.id.bt_cancel:
                finish();
                return;
            case R.id.bt_accept:
                if (y.d((Context) this)) {
                    ((GlobalVariable) getApplication()).a(false);
                    if (TextUtils.isEmpty(this.c)) {
                        aa.a((Activity) this);
                    } else {
                        Intent intent = new Intent(this, SwitchFridgeActivity.class);
                        intent.putExtra("SWITCH_FRIDGE_VIEW_MODE", true);
                        intent.putExtra("FEED_ID_JSON_STRING", this.c);
                        startActivity(intent);
                    }
                    finish();
                    return;
                }
                x.a((Context) this, "网络断了哦，请检查网络设置");
                return;
            default:
                return;
        }
    }
}
