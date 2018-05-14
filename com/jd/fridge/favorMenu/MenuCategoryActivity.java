package com.jd.fridge.favorMenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jiguang.net.HttpUtils;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.h5.H5Action;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class MenuCategoryActivity extends BaseActivity implements OnClickListener {
    private String a = "https://appfridge.jd.com/recipe.html#/category";
    private String b = "";
    private String c = HttpUtils.PATHS_SEPARATOR;
    private ImageView d;
    private TextView i;
    private int j;
    private final WebViewClient k = new WebViewClient(this) {
        final /* synthetic */ MenuCategoryActivity b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            H5Action e = y.e(str);
            r.c("infos", "---url---" + str);
            aa.b(this.b, e.getUrl());
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            y.b(this.b.e, 7013);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            y.a(this.b.e, 7013);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            r.c("infos", "menuCategory.error==" + i + "==descpriton==" + str + "==failingurl==" + str2);
            this.b.mWebView.loadData(this.b.b, "text/html", HTTP.UTF_8);
            if (this.b.mEmptyLayoutRoot != null) {
                this.b.mEmptyLayoutRoot.setVisibility(0);
            }
            if (this.b.mEmptyLayout != null) {
                this.b.mEmptyLayout.setErrorType(1);
            }
            y.b(this.b.e, 7013);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            r.c("infos", "intercept.url==" + str);
            return super.shouldInterceptRequest(webView, str);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    };
    @BindView(2131558576)
    EmptyLayout mEmptyLayout;
    @BindView(2131558580)
    View mEmptyLayoutRoot;
    @BindView(2131558579)
    X5WebView mWebView;
    @BindView(2131558581)
    ProgressBar mWebViewProgressBar;

    protected int a() {
        return R.layout.activity_favor_menu;
    }

    protected void b() {
        a.a(this.e);
        ButterKnife.bind((Activity) this);
        k();
        e();
        this.mEmptyLayout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ MenuCategoryActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (y.d(this.a)) {
                        this.a.mWebView.loadUrl(this.a.a);
                        this.a.mEmptyLayoutRoot.setVisibility(8);
                        this.a.mEmptyLayout.setErrorType(4);
                        return;
                    }
                    x.a(this.a, "网络断了哦，请检查网络设置");
                }
            }
        });
        this.mWebView.setWebViewClient(this.k);
        this.mWebView.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ MenuCategoryActivity a;

            {
                this.a = r1;
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (!TextUtils.isEmpty(str) && !str.equals(this.a.getResources().getString(R.string.no_web_page)) && !str.contains(".jd.com") && !str.equals("data:text/html,")) {
                    this.a.i.setText(str);
                }
            }

            public void onProgressChanged(WebView webView, int i) {
                r.c("infos", "onProgressChanged.newProgress==" + i);
                this.a.j = i;
                this.a.mWebViewProgressBar.setProgress(i);
                if (i <= 0 || i >= 100) {
                    if (i == 100) {
                        this.a.mWebViewProgressBar.setVisibility(8);
                    }
                } else if (this.a.mWebViewProgressBar.getVisibility() == 8) {
                    this.a.mWebViewProgressBar.setVisibility(0);
                }
                super.onProgressChanged(webView, i);
            }
        });
        this.mWebView.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ MenuCategoryActivity a;

            {
                this.a = r1;
            }

            public boolean onLongClick(View view) {
                return true;
            }
        });
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (VERSION.SDK_INT >= 21) {
            this.mWebView.a((Context) this, this.a);
        } else {
            this.mWebView.a((Context) this, this.a);
        }
        if (y.d((Context) this)) {
            this.mWebView.loadUrl(this.a);
            return;
        }
        this.mEmptyLayoutRoot.setVisibility(0);
        this.mEmptyLayout.setErrorType(1);
    }

    protected void c() {
    }

    protected void d() {
    }

    private void e() {
        this.i = (TextView) findViewById(R.id.app_title_textview);
        this.i.setText(getResources().getString(R.string.activity_menu_category_title));
        ImageView imageView = (ImageView) findViewById(R.id.left_appbar_btn);
        imageView.setOnClickListener(this);
        imageView.setVisibility(0);
        imageView.setImageResource(R.drawable.appbar_back_selector);
        this.d = (ImageView) findViewById(R.id.right_image_view);
        this.d.setOnClickListener(this);
        this.d.setVisibility(0);
        this.d.setImageResource(R.drawable.menu_right_icon_selector);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_appbar_btn:
                finish();
                return;
            case R.id.right_image_view:
                aa.f(this);
                return;
            default:
                return;
        }
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 7013:
                r.c("infos", "category==" + this.j);
                if (this.j < 80) {
                    this.mEmptyLayoutRoot.setVisibility(0);
                    this.mEmptyLayout.setErrorType(1);
                    break;
                }
                break;
        }
        return super.a(message);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mWebView != null) {
            this.mWebView.loadUrl("about:blank");
            this.mWebView.stopLoading();
            this.mWebView.setWebChromeClient(null);
            this.mWebView.setWebViewClient(null);
            this.mWebView.removeAllViews();
            this.mWebView.clearHistory();
            this.mWebView.destroy();
            this.mWebView = null;
        }
        y.b(this.e, 7013);
    }
}
