package com.jd.fridge.comments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.h5.H5Action;
import com.jd.fridge.bean.requestBody.CancelConcern;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;
import com.jd.fridge.widget.b.a;
import com.jd.fridge.widget.b.a.b;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class AddCommentsActivity extends BaseActivity {
    private Context a;
    private X5WebView b;
    private EmptyLayout c;
    private View d;
    private String i;
    private String j = "/friends/";
    private String k;
    private final WebViewClient l = new WebViewClient(this) {
        final /* synthetic */ AddCommentsActivity b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            H5Action a = this.b.e(str);
            r.b("infos", "=====1111111url==" + a.getUrl() + "==url==" + str);
            if (!a.getProtocol().equals("fridgenative://")) {
                webView.loadUrl(a.getUrl());
            } else if (a.getAction().equals("ToFridgeMyFocus")) {
                final Map d = this.b.d(a.getUrl());
                new a(this.b).a((int) R.string.activity_cancel_concern_friends_hint).a(b.DOUBLE_BTN).b((int) R.string.activity_setting_no_btn).c((int) R.string.activity_setting_yes_btn).a(new a.a(this) {
                    final /* synthetic */ AnonymousClass4 b;

                    public void a() {
                        com.jd.fridge.a.a().a(this.b.b.e, new CancelConcern(d.get("pin").toString(), d.get("friends").toString(), Long.parseLong(d.get("feedId").toString())));
                    }

                    public void b() {
                    }
                }).show();
            }
            return true;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.b.k = str2;
            this.b.b.loadData(this.b.m, "text/html", HTTP.UTF_8);
            this.b.d.setVisibility(0);
            this.b.c.setErrorType(1);
        }
    };
    private String m = "";

    protected int a() {
        return R.layout.activity_favor_menu;
    }

    private void e() {
        ((TextView) findViewById(R.id.app_title_textview)).setText(R.string.activity_add_comments_title_text);
        ImageView imageView = (ImageView) findViewById(R.id.left_appbar_btn);
        imageView.setImageResource(R.drawable.appbar_back_selector);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AddCommentsActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.finish();
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    protected void b() {
        this.a = this;
        this.i = getIntent().getStringExtra("url");
        k();
        e();
        this.d = findViewById(R.id.empty_layout_root);
        this.c = (EmptyLayout) findViewById(R.id.empty_layout);
        this.c.setRefresh(new OnClickListener(this) {
            final /* synthetic */ AddCommentsActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.b.loadUrl(this.a.k);
                    this.a.d.setVisibility(8);
                    this.a.c.setErrorType(4);
                }
            }
        });
        this.b = (X5WebView) findViewById(R.id.favor_menu_webview);
        this.b.setWebViewClient(this.l);
        this.b.setWebChromeClient(new WebChromeClient());
        this.b.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ AddCommentsActivity a;

            {
                this.a = r1;
            }

            public boolean onLongClick(View view) {
                return true;
            }
        });
        WebSettings settings = this.b.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(2);
        settings.setBlockNetworkImage(false);
        this.b.a(this.a, this.i);
        this.b.loadUrl(this.i);
        r.b("infos", "=====1111111=====");
    }

    protected void c() {
    }

    protected void d() {
    }

    private H5Action e(String str) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (!str.startsWith("fridgenative://")) {
            return new H5Action(str2, str3, str);
        }
        str2 = "fridgenative://";
        str4 = str.substring(str2.length());
        str3 = str4.substring(0, str4.indexOf("/?url="));
        return new H5Action(str2, str3, str4.substring(str3.length() + 6));
    }

    public Map<String, Object> d(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        Map<String, Object> hashMap = new HashMap();
        int i;
        for (int i2 = 0; i2 < str.length(); i2 = i + 1) {
            if (str.substring(i2, i2 + 1).equals(HttpUtils.EQUAL_SIGN)) {
                i = i2 + 1;
                while (i < str.length()) {
                    if (str.substring(i, i + 1).equals(HttpUtils.PARAMETERS_SEPARATOR) || i == str.length() - 1) {
                        if (i == str.length() - 1) {
                            stringBuffer2.append(str.substring(i, i + 1));
                        }
                        hashMap.put(stringBuffer.toString(), stringBuffer2);
                        stringBuffer = new StringBuffer("");
                        stringBuffer2 = new StringBuffer("");
                    } else {
                        stringBuffer2.append(str.substring(i, i + 1));
                        i++;
                    }
                }
                i = i2;
            } else {
                stringBuffer.append(str.substring(i2, i2 + 1));
                i = i2;
            }
        }
        return hashMap;
    }

    protected boolean a(Message message) {
        switch (message.what) {
            case 2014:
                setResult(-1);
                finish();
                r.b("infos", "====finish====");
                break;
            case 2015:
                x.a((Context) this, getResources().getString(R.string.please_try_again_later));
                break;
        }
        return super.a(message);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        finish();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.b.removeAllViews();
        this.b.destroy();
    }
}
