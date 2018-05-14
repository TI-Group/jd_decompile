package com.sina.weibo.sdk.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.c.b;
import com.sina.weibo.sdk.component.view.LoadingBar;
import com.sina.weibo.sdk.d.d;
import com.sina.weibo.sdk.d.g;
import com.sina.weibo.sdk.d.j;
import com.sina.weibo.sdk.net.f;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class WeiboSdkBrowser extends Activity implements d {
    private static final String a = WeiboSdkBrowser.class.getName();
    private String b;
    private String c;
    private boolean d;
    private String e;
    private boolean f;
    private TextView g;
    private TextView h;
    private WebView i;
    private LoadingBar j;
    private LinearLayout k;
    private Button l;
    private Boolean m = Boolean.valueOf(false);
    private e n;
    private k o;

    /* compiled from: TbsSdkJava */
    private class a extends WebChromeClient {
        final /* synthetic */ WeiboSdkBrowser a;

        private a(WeiboSdkBrowser weiboSdkBrowser) {
            this.a = weiboSdkBrowser;
        }

        public void onProgressChanged(WebView webView, int i) {
            this.a.j.a(i);
            if (i == 100) {
                this.a.d = false;
                this.a.a();
            } else if (!this.a.d) {
                this.a.d = true;
                this.a.a();
            }
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (!this.a.b(this.a.e) && !this.a.m.booleanValue()) {
                this.a.c = str;
                this.a.f();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a(getIntent())) {
            g();
            d();
            if (a(this.n)) {
                c();
                return;
            } else {
                a(this.e);
                return;
            }
        }
        finish();
    }

    private boolean a(Intent intent) {
        Bundle extras = intent.getExtras();
        this.n = a(extras);
        if (this.n != null) {
            this.e = this.n.e();
            this.b = this.n.g();
        } else {
            String string = extras.getString("key_url");
            String string2 = extras.getString("key_specify_title");
            if (!TextUtils.isEmpty(string) && string.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.e = string;
                this.b = string2;
            }
        }
        if (TextUtils.isEmpty(this.e)) {
            return false;
        }
        d.a(a, "LOAD URL : " + this.e);
        return true;
    }

    private void a(String str) {
        this.i.loadUrl(str);
    }

    private void c() {
        d.a(a, "Enter startShare()............");
        final g gVar = (g) this.n;
        if (gVar.a()) {
            d.a(a, "loadUrl hasImage............");
            new com.sina.weibo.sdk.net.a(this).a("http://service.weibo.com/share/mobilesdk_uppic.php", gVar.a(new f(gVar.b())), "POST", new com.sina.weibo.sdk.net.d(this) {
                final /* synthetic */ WeiboSdkBrowser a;

                public void a(b bVar) {
                    d.a(WeiboSdkBrowser.a, "post onWeiboException " + bVar.getMessage());
                    gVar.a(this.a, bVar.getMessage());
                    this.a.finish();
                }

                public void a(String str) {
                    d.a(WeiboSdkBrowser.a, "post onComplete : " + str);
                    com.sina.weibo.sdk.component.g.a a = com.sina.weibo.sdk.component.g.a.a(str);
                    if (a == null || a.a() != 1 || TextUtils.isEmpty(a.b())) {
                        gVar.a(this.a, "upload pic faild");
                        this.a.finish();
                        return;
                    }
                    this.a.a(gVar.c(a.b()));
                }
            });
            return;
        }
        a(this.e);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.i.getSettings().setJavaScriptEnabled(true);
        if (a(this.n)) {
            this.i.getSettings().setUserAgentString(j.a((Context) this));
        }
        this.i.getSettings().setSavePassword(false);
        this.i.setWebViewClient(this.o);
        this.i.setWebChromeClient(new a());
        this.i.requestFocus();
        this.i.setScrollBarStyle(0);
        if (VERSION.SDK_INT >= 11) {
            this.i.removeJavascriptInterface("searchBoxJavaBridge_");
        } else {
            a(this.i);
        }
    }

    private void e() {
        this.h.setText(this.b);
        this.g.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WeiboSdkBrowser a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.n != null) {
                    this.a.n.a(this.a, 3);
                }
                this.a.finish();
            }
        });
    }

    private void f() {
        CharSequence charSequence = "";
        if (!TextUtils.isEmpty(this.c)) {
            charSequence = this.c;
        } else if (!TextUtils.isEmpty(this.b)) {
            charSequence = this.b;
        }
        this.h.setText(charSequence);
    }

    private void g() {
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(-1);
        View linearLayout = new LinearLayout(this);
        linearLayout.setId(1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2));
        View h = h();
        View textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, g.a((Context) this, 2)));
        textView.setBackgroundDrawable(g.b(this, "weibosdk_common_shadow_top.9.png"));
        this.j = new LoadingBar(this);
        this.j.setBackgroundColor(0);
        this.j.a(0);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, g.a((Context) this, 3)));
        linearLayout.addView(h);
        linearLayout.addView(textView);
        linearLayout.addView(this.j);
        this.i = new WebView(this);
        this.i.setBackgroundColor(-1);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 1);
        this.i.setLayoutParams(layoutParams);
        this.k = new LinearLayout(this);
        this.k.setVisibility(8);
        this.k.setOrientation(1);
        this.k.setGravity(17);
        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 1);
        this.k.setLayoutParams(layoutParams);
        h = new ImageView(this);
        h.setImageDrawable(g.a((Context) this, "weibosdk_empty_failed.png"));
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        int a = g.a((Context) this, 8);
        layoutParams2.bottomMargin = a;
        layoutParams2.rightMargin = a;
        layoutParams2.topMargin = a;
        layoutParams2.leftMargin = a;
        h.setLayoutParams(layoutParams2);
        this.k.addView(h);
        h = new TextView(this);
        h.setGravity(1);
        h.setTextColor(-4342339);
        h.setTextSize(2, 14.0f);
        h.setText(g.a(this, "A network error occurs, please tap the button to reload", "网络出错啦，请点击按钮重新加载", "網路出錯啦，請點擊按鈕重新載入"));
        h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.k.addView(h);
        this.l = new Button(this);
        this.l.setGravity(17);
        this.l.setTextColor(-8882056);
        this.l.setTextSize(2, 16.0f);
        this.l.setText(g.a(this, "channel_data_error", "重新加载", "重新載入"));
        this.l.setBackgroundDrawable(g.a((Context) this, "weibosdk_common_button_alpha.9.png", "weibosdk_common_button_alpha_highlighted.9.png"));
        layoutParams = new LinearLayout.LayoutParams(g.a((Context) this, 142), g.a((Context) this, 46));
        layoutParams.topMargin = g.a((Context) this, 10);
        this.l.setLayoutParams(layoutParams);
        this.l.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WeiboSdkBrowser a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a(this.a.e);
                this.a.f = false;
            }
        });
        this.k.addView(this.l);
        relativeLayout.addView(linearLayout);
        relativeLayout.addView(this.i);
        relativeLayout.addView(this.k);
        setContentView(relativeLayout);
        e();
    }

    private View h() {
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LayoutParams(-1, g.a((Context) this, 45)));
        relativeLayout.setBackgroundDrawable(g.b(this, "weibosdk_navigationbar_background.9.png"));
        this.g = new TextView(this);
        this.g.setClickable(true);
        this.g.setTextSize(2, 17.0f);
        this.g.setTextColor(g.a(-32256, 1728020992));
        this.g.setText(g.a(this, HTTP.CONN_CLOSE, "关闭", "关闭"));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(5);
        layoutParams.addRule(15);
        layoutParams.leftMargin = g.a((Context) this, 10);
        layoutParams.rightMargin = g.a((Context) this, 10);
        this.g.setLayoutParams(layoutParams);
        relativeLayout.addView(this.g);
        this.h = new TextView(this);
        this.h.setTextSize(2, 18.0f);
        this.h.setTextColor(-11382190);
        this.h.setEllipsize(TruncateAt.END);
        this.h.setSingleLine(true);
        this.h.setGravity(17);
        this.h.setMaxWidth(g.a((Context) this, 160));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.h.setLayoutParams(layoutParams);
        relativeLayout.addView(this.h);
        return relativeLayout;
    }

    protected void a() {
        if (this.d) {
            j();
        } else {
            i();
        }
    }

    private void i() {
        f();
        this.j.setVisibility(8);
    }

    private void j() {
        this.h.setText(g.a(this, "Loading....", "加载中....", "載入中...."));
        this.j.setVisibility(0);
    }

    private void b(WebView webView, int i, String str, String str2) {
        if (!str2.startsWith("sinaweibo")) {
            this.f = true;
            k();
        }
    }

    private void k() {
        this.k.setVisibility(0);
        this.i.setVisibility(8);
    }

    private void l() {
        this.k.setVisibility(8);
        this.i.setVisibility(0);
    }

    private boolean b(String str) {
        if (!TextUtils.isEmpty(str) && "sinaweibo".equalsIgnoreCase(Uri.parse(str).getAuthority())) {
            return true;
        }
        return false;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        com.sina.weibo.sdk.d.f.d(this);
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.n != null) {
            this.n.a(this, 3);
        }
        finish();
        return true;
    }

    private e a(Bundle bundle) {
        this.m = Boolean.valueOf(false);
        c cVar = (c) bundle.getSerializable("key_launcher");
        if (cVar == c.AUTH) {
            a aVar = new a(this);
            aVar.c(bundle);
            a(aVar);
            return aVar;
        } else if (cVar == c.SHARE) {
            g gVar = new g(this);
            gVar.c(bundle);
            a(gVar);
            return gVar;
        } else if (cVar == c.WIDGET) {
            l lVar = new l(this);
            lVar.c(bundle);
            a(lVar);
            return lVar;
        } else if (cVar != c.GAME) {
            return null;
        } else {
            this.m = Boolean.valueOf(true);
            f fVar = new f(this);
            fVar.c(bundle);
            a(fVar);
            return fVar;
        }
    }

    private boolean a(e eVar) {
        return eVar != null && eVar.f() == c.SHARE;
    }

    private void a(a aVar) {
        this.o = new b(this, aVar);
        this.o.a(this);
    }

    private void a(g gVar) {
        k hVar = new h(this, gVar);
        hVar.a(this);
        this.o = hVar;
    }

    private void a(l lVar) {
        k mVar = new m(this, lVar);
        mVar.a(this);
        this.o = mVar;
    }

    private void a(f fVar) {
        k jVar = new j(this, fVar);
        jVar.a(this);
        this.o = jVar;
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        d.a(a, "onPageStarted URL: " + str);
        this.e = str;
        if (!b(str)) {
            this.c = "";
        }
    }

    public boolean a(WebView webView, String str) {
        d.b(a, "shouldOverrideUrlLoading URL: " + str);
        return false;
    }

    public void b(WebView webView, String str) {
        d.a(a, "onPageFinished URL: " + str);
        if (this.f) {
            k();
            return;
        }
        this.f = false;
        l();
    }

    public void a(WebView webView, int i, String str, String str2) {
        d.a(a, "onReceivedError: errorCode = " + i + ", description = " + str + ", failingUrl = " + str2);
        b(webView, i, str, str2);
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        d.a(a, "onReceivedSslErrorCallBack.........");
    }

    public static void a(Activity activity, String str, String str2) {
        i a = i.a(activity.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
            a.b(str);
            activity.finish();
        }
        if (!TextUtils.isEmpty(str2)) {
            a.d(str2);
            activity.finish();
        }
    }

    public void a(WebView webView) {
        if (VERSION.SDK_INT < 11) {
            try {
                webView.getClass().getDeclaredMethod("removeJavascriptInterface", new Class[0]).invoke("searchBoxJavaBridge_", new Object[0]);
            } catch (Exception e) {
                d.c(a, e.toString());
            }
        }
    }
}
