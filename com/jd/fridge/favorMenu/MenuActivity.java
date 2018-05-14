package com.jd.fridge.favorMenu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.h5.H5Action;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.ArrayList;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class MenuActivity extends BaseActivity {
    private static final String d = MenuActivity.class.getSimpleName();
    final String a = "https://appfridge.jd.com/recipe.html#/";
    TextView b;
    TextView c;
    private Context i;
    private X5WebView j;
    private EmptyLayout k;
    private View l;
    private ProgressBar m;
    private String n = "";
    private String o = "";
    private String p = "";
    private String q;
    private ArrayList<String> r = new ArrayList();
    private String s = "";
    private final WebViewClient t = new WebViewClient(this) {
        final /* synthetic */ MenuActivity b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            aa.a(this.b, this.b.d(str).getUrl());
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!str.equals("data:text/html,")) {
                if (!str.endsWith("list")) {
                    this.b.b.setVisibility(8);
                } else if (GlobalVariable.E() == 0) {
                    this.b.b.setVisibility(8);
                } else {
                    this.b.b.setVisibility(0);
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.b.j.loadData(this.b.s, "text/html", HTTP.UTF_8);
            this.b.q = str2;
            if (this.b.l != null) {
                this.b.l.setVisibility(0);
            }
            if (this.b.k != null) {
                this.b.k.setErrorType(1);
            }
            if (this.b.c != null) {
                this.b.c.setText("我收藏的菜谱");
            }
        }
    };
    private String u = HttpUtils.PATHS_SEPARATOR;

    protected int a() {
        return R.layout.activity_favor_menu;
    }

    protected void c() {
    }

    protected void d() {
        if (getIntent().getStringExtra("api_name") != null) {
            this.o = getIntent().getStringExtra("api_name");
        }
        if (getIntent().getStringExtra("menu_id") != null) {
            this.p = getIntent().getStringExtra("menu_id");
        }
        this.n = "https://appfridge.jd.com/recipe.html#/" + this.o;
        if (this.o.equals("detail")) {
            this.n += HttpUtils.PATHS_SEPARATOR + this.p;
        }
        p.a(d, "url: " + this.n);
    }

    private void e() {
        this.c = (TextView) findViewById(R.id.app_title_textview);
        getIntent().getStringExtra("title_text");
        ImageView imageView = (ImageView) findViewById(R.id.left_appbar_btn);
        imageView.setImageResource(R.drawable.appbar_back_selector);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MenuActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.f();
            }
        });
        this.b = (TextView) findViewById(R.id.right_text_btn);
        if (this.o.equals("list")) {
            this.b.setText(R.string.activity_switch_fridge_right_text);
            this.b.setVisibility(4);
            if (GlobalVariable.E() == 0) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
            }
            this.b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MenuActivity a;

                {
                    this.a = r1;
                }

                public void onClick(View view) {
                    r.a("syp", "冰箱食材button点击事件触发");
                    if (!y.c()) {
                        this.a.startActivity(new Intent(this.a, FridgeGoodsActivity.class));
                    }
                }
            });
        }
        this.j = (X5WebView) findViewById(R.id.favor_menu_webview);
        this.m = (ProgressBar) findViewById(R.id.web_view_progress);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    protected void b() {
        a.a(this.e);
        this.i = this;
        k();
        e();
        this.l = findViewById(R.id.empty_layout_root);
        this.k = (EmptyLayout) findViewById(R.id.empty_layout);
        this.k.setRefresh(new OnClickListener(this) {
            final /* synthetic */ MenuActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (y.d(this.a)) {
                        this.a.j.loadUrl(this.a.q);
                        this.a.l.setVisibility(8);
                        this.a.k.setErrorType(4);
                        return;
                    }
                    x.a(this.a, "网络断了哦，请检查网络设置");
                }
            }
        });
        this.j.setWebViewClient(this.t);
        this.j.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ MenuActivity a;

            {
                this.a = r1;
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (!TextUtils.isEmpty(str) && !str.equals(this.a.getResources().getString(R.string.no_web_page)) && !str.equals("data:text/html,")) {
                    this.a.c.setText(str);
                }
            }

            public void onProgressChanged(WebView webView, int i) {
                r.c("infos", "onProgressChanged.newProgress==" + i);
                if (i <= 0 || i >= 100) {
                    if (i == 100) {
                        this.a.m.setVisibility(8);
                    }
                } else if (this.a.m.getVisibility() == 8) {
                    this.a.m.setVisibility(0);
                }
                this.a.m.setProgress(i);
                super.onProgressChanged(webView, i);
            }
        });
        this.j.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ MenuActivity a;

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
            this.j.a(this.i, this.n);
            this.j.loadUrl(this.n);
            this.r.add(this.n);
        } else {
            this.j.a(this.i, this.n);
            this.j.loadUrl(this.n);
            this.r.add(this.n);
        }
    }

    private void f() {
        this.j.clearHistory();
        int size = this.r.size();
        if (size > 1) {
            this.r.remove(size - 1);
            String str = (String) this.r.get(this.r.size() - 1);
            this.j.loadUrl(str);
            if (!str.endsWith("list")) {
                this.b.setVisibility(8);
                return;
            } else if (GlobalVariable.E() == 0) {
                this.b.setVisibility(8);
                return;
            } else {
                this.b.setVisibility(0);
                return;
            }
        }
        finish();
    }

    private H5Action d(String str) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (!str.startsWith("fridgenative://")) {
            return new H5Action(str2, str3, str);
        }
        str3 = "fridgenative://";
        str2 = str.substring(str3.length());
        String substring = str2.substring(0, str2.indexOf("/?"));
        if (!substring.equals("recipeTitle")) {
            str2.indexOf("/?url=");
            str4 = str2.substring(substring.length() + 6);
        }
        return new H5Action(str3, substring, str4);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.j.clearHistory();
        int size = this.r.size();
        if (size > 1) {
            this.r.remove(size - 1);
            String str = (String) this.r.get(this.r.size() - 1);
            this.j.loadUrl(str);
            if (str.endsWith("list")) {
                if (GlobalVariable.E() == 0) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                }
                c(getIntent().getStringExtra("title_text"));
            } else {
                this.b.setVisibility(8);
            }
        } else {
            finish();
        }
        return true;
    }

    protected void onPause() {
        super.onPause();
        if (this.j == null) {
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.j == null) {
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.j != null) {
            this.j.removeAllViews();
            this.j.clearHistory();
            this.j.destroy();
            this.j = null;
        }
    }
}
