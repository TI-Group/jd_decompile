package com.jd.fridge.favorMenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class MenuSecondActivity extends BaseActivity implements OnClickListener {
    protected static final LayoutParams a = new LayoutParams(-1, -1);
    private X5WebView b;
    private EmptyLayout c;
    private ProgressBar d;
    private View i;
    private String j = "";
    private String k = "";
    private String l = HttpUtils.PATHS_SEPARATOR;
    private TextView m;
    private TextView n;
    private View o;
    private FrameLayout p;
    private CustomViewCallback q;
    private int r;
    private final WebViewClient s = new WebViewClient(this) {
        final /* synthetic */ MenuSecondActivity b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            y.b(this.b.e, 7017);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            y.a(this.b.e, 7017);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            r.c("infos", "MenuSecondActivity.error==" + i + "==des==" + str + "==failingurl==" + str2);
            this.b.b.loadData(this.b.k, "text/html", HTTP.UTF_8);
            if (this.b.i != null) {
                this.b.i.setVisibility(0);
            }
            if (this.b.c != null) {
                this.b.c.setErrorType(1);
            }
            y.b(this.b.e, 7017);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            r.c("infos", "MenuSecondActivity.intercept==" + str);
            return super.shouldInterceptRequest(webView, str);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    };

    /* compiled from: TbsSdkJava */
    static class a extends FrameLayout {
        public a(Context context) {
            super(context);
            setBackgroundColor(ContextCompat.getColor(context, 17170444));
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: TbsSdkJava */
    final class b {
        final /* synthetic */ MenuSecondActivity a;

        b(MenuSecondActivity menuSecondActivity) {
            this.a = menuSecondActivity;
        }

        @JavascriptInterface
        public boolean isInit() {
            return GlobalVariable.B().M();
        }
    }

    protected int a() {
        return R.layout.activity_second_menu;
    }

    protected void b() {
        com.jd.fridge.util.c.a.a(this.e);
        getWindow().setFormat(-3);
        k();
        e();
        this.i = findViewById(R.id.empty_layout_root);
        this.c = (EmptyLayout) findViewById(R.id.empty_layout);
        this.d = (ProgressBar) findViewById(R.id.web_view_progress);
        this.c.setRefresh(new OnClickListener(this) {
            final /* synthetic */ MenuSecondActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (!y.d(this.a)) {
                        this.a.i.setVisibility(0);
                        this.a.c.setErrorType(1);
                        x.a(this.a, "网络断了哦，请检查网络设置");
                    } else if (!TextUtils.isEmpty(this.a.j)) {
                        this.a.b.loadUrl(this.a.j);
                        this.a.i.setVisibility(8);
                        this.a.c.setErrorType(4);
                    }
                }
            }
        });
        this.b = (X5WebView) findViewById(R.id.favor_menu_webview);
        this.b.setWebViewClient(this.s);
        this.b.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ MenuSecondActivity a;

            {
                this.a = r1;
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                r.c("infoss", "title==" + str);
                if (!TextUtils.isEmpty(str) && !str.equals(this.a.getResources().getString(R.string.no_web_page)) && !str.contains(".jd.com") && !str.equals("data:text/html,")) {
                    this.a.n.setText(str);
                }
            }

            public void onProgressChanged(WebView webView, int i) {
                r.c("infos", "onProgressChanged.newProgress==" + i);
                this.a.r = i;
                if (i <= 0 || i >= 100) {
                    if (i == 100) {
                        this.a.d.setVisibility(8);
                    }
                } else if (this.a.d.getVisibility() == 8) {
                    this.a.d.setVisibility(0);
                }
                this.a.d.setProgress(i);
                super.onProgressChanged(webView, i);
            }

            public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
                r.b("infos", "onShowCustomView.view======" + view);
                this.a.a(view, customViewCallback);
            }

            public void onHideCustomView() {
                super.onHideCustomView();
                r.b("infos", "=====onHideCustomView====");
                this.a.f();
            }
        });
        this.b.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ MenuSecondActivity a;

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
            this.b.a((Context) this, this.j);
            this.b.loadUrl(this.j);
            this.b.addJavascriptInterface(new b(this), "Android");
        } else {
            this.b.a((Context) this, this.j);
            this.b.loadUrl(this.j);
            this.b.addJavascriptInterface(new b(this), "Android");
        }
    }

    protected void c() {
    }

    protected void d() {
        this.j = getIntent().getStringExtra("second_url");
    }

    private void e() {
        this.n = (TextView) findViewById(R.id.app_title_textview);
        ImageView imageView = (ImageView) findViewById(R.id.left_appbar_btn);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this);
        imageView.setImageResource(R.drawable.appbar_back_selector);
        this.m = (TextView) findViewById(R.id.right_text_btn);
        this.m.setVisibility(8);
    }

    private void a(View view, CustomViewCallback customViewCallback) {
        if (this.o != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        getWindow().getDecorView();
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        this.p = new a(this);
        this.p.addView(view, a);
        frameLayout.addView(this.p, a);
        this.o = view;
        c(false);
        this.q = customViewCallback;
        setRequestedOrientation(4);
    }

    private void f() {
        if (this.o != null) {
            c(true);
            ((FrameLayout) getWindow().getDecorView()).removeView(this.p);
            this.p = null;
            this.o = null;
            this.q.onCustomViewHidden();
            this.b.setVisibility(0);
            setRequestedOrientation(1);
        }
    }

    private void c(boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 1024;
        }
        getWindow().setFlags(i, 1024);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_appbar_btn:
                finish();
                return;
            default:
                return;
        }
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 7017:
                r.c("infos", "===menu.second==mIsTimeOut===" + this.r);
                if (this.r < 70) {
                    this.i.setVisibility(0);
                    this.c.setErrorType(1);
                    break;
                }
                break;
        }
        return super.a(message);
    }

    protected void onPause() {
        super.onPause();
        if (this.b != null) {
            this.b.onPause();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.b != null) {
            this.b.onResume();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.b != null) {
            this.b.loadUrl("about:blank");
            this.b.stopLoading();
            this.b.setWebChromeClient(null);
            this.b.setWebViewClient(null);
            this.b.removeAllViews();
            this.b.clearHistory();
            this.b.destroy();
            this.b = null;
        }
        y.b(this.e, 7017);
    }
}
