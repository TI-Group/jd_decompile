package com.jd.fridge;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.util.k;
import com.jd.fridge.util.r;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class HomeWebViewActivity extends BaseActivity {
    String a;
    String b = null;
    boolean c = false;
    WebView d = null;
    private String i;
    private WebSettings j = null;
    private String k = "";
    private EmptyLayout l;
    private View m;
    private final WebViewClient n = new WebViewClient(this) {
        final /* synthetic */ HomeWebViewActivity a;

        {
            this.a = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            r.b("infos", "_url====" + str);
            if (str.equals("https://plogin.m.jd.com/user/login.action?appid=194&returnurl=http%3A%2F%2Fwjlogina%3Fstatus%3Dtrue%26action%3Dlogin&show_title=0")) {
                this.a.finish();
                return true;
            } else if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
                intent.setFlags(268435456);
                this.a.startActivity(intent);
                return true;
            } else if (str.contains("http://wjlogina/?status=true&action=login")) {
                this.a.finish();
                return true;
            } else if (str.contains("http%3a%2f%2fwjlogina%3fstatus%3dtrue%26action%3dlogin")) {
                this.a.finish();
                return true;
            } else {
                this.a.c = false;
                return false;
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            k.a("错误码：" + i + "错误信息：" + str);
            this.a.d.loadData(this.a.k, "text/html", HTTP.UTF_8);
            this.a.i = str2;
            this.a.m.setVisibility(0);
            this.a.l.setErrorType(1);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            webView.getSettings().setBlockNetworkImage(true);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            webView.getSettings().setBlockNetworkImage(false);
            this.a.d.setVisibility(0);
        }
    };

    protected int a() {
        return R.layout.home_webview;
    }

    protected void b() {
        this.a = getIntent().getStringExtra("url");
        this.b = getIntent().getStringExtra("title");
        c(this.b);
        setAppbarBackBtnClickListener(new OnClickListener(this) {
            final /* synthetic */ HomeWebViewActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (this.a.d.canGoBack()) {
                        this.a.d.goBack();
                    } else {
                        this.a.finish();
                    }
                }
            }
        });
        this.m = findViewById(R.id.empty_layout_root);
        this.l = (EmptyLayout) findViewById(R.id.empty_layout);
        this.l.setRefresh(new OnClickListener(this) {
            final /* synthetic */ HomeWebViewActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.d.loadUrl(this.a.i);
                    this.a.m.setVisibility(8);
                    this.a.l.setErrorType(4);
                }
            }
        });
        this.d = new WebView(getApplicationContext());
        ((RelativeLayout) findViewById(R.id.home_webview_root_layout)).addView(this.d, 0, new LayoutParams(-1, -1));
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.getSettings().setPluginState(PluginState.ON);
        this.d.requestFocus();
        this.d.setInitialScale(100);
        this.j = this.d.getSettings();
        this.j.setJavaScriptCanOpenWindowsAutomatically(true);
        this.j.setAllowFileAccess(true);
        this.j.setJavaScriptEnabled(true);
        this.j.setBuiltInZoomControls(false);
        this.j.setSupportZoom(false);
        this.j.setDomStorageEnabled(true);
        this.j.setAppCacheMaxSize(8388608);
        this.j.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        this.j.setAllowFileAccess(true);
        this.j.setAppCacheEnabled(true);
        this.j.setUseWideViewPort(true);
        this.j.setLoadWithOverviewMode(true);
        this.d.setWebViewClient(this.n);
        if (StringUtils.isNotBlank(this.a) && this.a.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.d.loadUrl(this.a);
        } else {
            this.d.loadUrl("about:blank");
        }
        this.d.setWebChromeClient(new WebChromeClient());
        this.d.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ HomeWebViewActivity a;

            {
                this.a = r1;
            }

            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.d.setVisibility(4);
    }

    protected void c() {
    }

    protected void d() {
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.a = getIntent().getStringExtra("url");
        if ("fromPush".equals(Boolean.valueOf(getIntent().hasExtra("fromPush")))) {
            intent.setClass(this, HomeWebViewActivity.class);
            startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onPause() {
        super.onPause();
        this.d.onPause();
        this.d.pauseTimers();
        if (isFinishing()) {
            this.d.loadUrl("about:blank");
            setContentView(new FrameLayout(this));
        }
    }

    protected void onDestroy() {
        this.d.loadUrl("about:blank");
        this.d.stopLoading();
        this.d.removeAllViews();
        this.d.setWebChromeClient(null);
        this.d.setWebViewClient(null);
        this.d.destroy();
        this.d = null;
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        this.d.onResume();
        this.d.resumeTimers();
    }

    public void finish() {
        super.finish();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.d.canGoBack()) {
            this.d.goBack();
            return true;
        }
        finish();
        return true;
    }

    protected boolean a(Message message) {
        return super.a(message);
    }
}
