package com.jd.fridge.favorMenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class MenuCategorySecondActivity extends BaseActivity implements OnClickListener {
    private X5WebView a;
    private EmptyLayout b;
    private View c;
    private ProgressBar d;
    private String i;
    private String j = "";
    private String k = HttpUtils.PATHS_SEPARATOR;
    private TextView l;
    private String m;
    private int n;
    private ImageView o;
    private final WebViewClient p = new WebViewClient(this) {
        final /* synthetic */ MenuCategorySecondActivity b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            H5Action e = y.e(str);
            if (str.contains("recipeTitle")) {
                this.b.d(str);
                r.c("infos", "Url==" + str);
            } else {
                aa.a(this.b, e.getUrl());
            }
            r.c("infos", "second.url====" + e.getUrl() + "---url---" + str);
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            y.b(this.b.e, 7014);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            y.a(this.b.e, 7014);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            r.c("infos", "menuCategory.error==" + i + "==descpriton==" + str + "==failingurl==" + str2);
            this.b.a.loadData(this.b.j, "text/html", HTTP.UTF_8);
            if (this.b.c != null) {
                this.b.c.setVisibility(0);
            }
            if (this.b.b != null) {
                this.b.b.setErrorType(1);
            }
            y.b(this.b.e, 7014);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            return super.shouldInterceptRequest(webView, str);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }
    };

    protected int a() {
        return R.layout.activity_favor_menu;
    }

    protected void b() {
        a.a(this.e);
        k();
        e();
        this.c = findViewById(R.id.empty_layout_root);
        this.b = (EmptyLayout) findViewById(R.id.empty_layout);
        this.d = (ProgressBar) findViewById(R.id.web_view_progress);
        this.a = (X5WebView) findViewById(R.id.favor_menu_webview);
        this.b.setRefresh(new OnClickListener(this) {
            final /* synthetic */ MenuCategorySecondActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (!y.d(this.a)) {
                        x.a(this.a, "网络断了哦，请检查网络设置");
                    } else if (!TextUtils.isEmpty(this.a.i)) {
                        this.a.a.loadUrl(this.a.i);
                        this.a.c.setVisibility(8);
                        this.a.b.setErrorType(4);
                    }
                }
            }
        });
        this.a.setWebViewClient(this.p);
        this.a.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ MenuCategorySecondActivity a;

            {
                this.a = r1;
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                r.c("infos", "title====" + str);
                if (!TextUtils.isEmpty(str) && !str.equals(this.a.getResources().getString(R.string.no_web_page)) && !str.contains(".jd.com") && !str.equals("data:text/html,")) {
                    this.a.l.setText(str);
                }
            }

            public void onProgressChanged(WebView webView, int i) {
                r.c("infos", "onProgressChanged.newProgress==" + i);
                this.a.n = i;
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
        });
        this.a.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ MenuCategorySecondActivity a;

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
            this.a.a((Context) this, this.i);
            this.a.loadUrl(this.i);
        } else {
            this.a.a((Context) this, this.i);
            this.a.loadUrl(this.i);
        }
    }

    protected void c() {
    }

    protected void d() {
        this.i = getIntent().getStringExtra("category_second_url");
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("title=")) {
            try {
                this.m = URLDecoder.decode(str.split("title=")[1], CommonUtil.UTF8);
                if (this.l != null) {
                    this.l.setText(this.m);
                }
                r.c("infoss", "str[1]==" + this.m);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    private void e() {
        this.l = (TextView) findViewById(R.id.app_title_textview);
        ImageView imageView = (ImageView) findViewById(R.id.left_appbar_btn);
        imageView.setOnClickListener(this);
        imageView.setVisibility(0);
        imageView.setImageResource(R.drawable.appbar_back_selector);
        this.o = (ImageView) findViewById(R.id.right_image_view);
        this.o.setOnClickListener(this);
        this.o.setVisibility(0);
        this.o.setImageResource(R.drawable.menu_right_icon_selector);
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
            case 7014:
                r.c("infos", "===CATEGORY_SECOND==mIsTimeOut===" + this.n);
                if (this.n < 80) {
                    this.c.setVisibility(0);
                    this.b.setErrorType(1);
                    break;
                }
                break;
        }
        return super.a(message);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.loadUrl("about:blank");
            this.a.stopLoading();
            this.a.setWebChromeClient(null);
            this.a.setWebViewClient(null);
            this.a.removeAllViews();
            this.a.clearHistory();
            this.a.destroy();
            this.a = null;
        }
        y.b(this.e, 7014);
    }
}
