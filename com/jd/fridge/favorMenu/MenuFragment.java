package com.jd.fridge.favorMenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseFragment;
import com.jd.fridge.bean.h5.H5Action;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class MenuFragment extends BaseFragment implements OnClickListener {
    final String d = "https://appfridge.jd.com/recipe.html#/index";
    private Bundle e = null;
    private Context f;
    private X5WebView g;
    private EmptyLayout h;
    private View i;
    private ProgressBar j;
    private String k = "";
    private ImageView l;
    private TextView m;
    private ImageView n;
    private int o;
    private ProgressBar p;
    private final WebViewClient q = new WebViewClient(this) {
        final /* synthetic */ MenuFragment b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            H5Action e = y.e(str);
            r.b("infoss", "action==" + e.getAction() + "==action.url==" + e.getUrl() + "==url==" + str);
            aa.a(this.b.b(), e.getUrl());
            return true;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            y.a(this.b.a, 7015);
            r.c("infos", "=====mIsTimeOut1111===");
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.b.p.getVisibility() == 0) {
                this.b.p.setVisibility(8);
            }
            if (this.b.g.getVisibility() == 8) {
                this.b.g.setVisibility(0);
            }
            y.b(this.b.a, 7015);
            r.c("infos", "=====onPageFinished===");
            if (!y.d(this.b.b())) {
                if (this.b.i != null) {
                    this.b.i.setVisibility(0);
                }
                if (this.b.h != null) {
                    this.b.h.setErrorType(1);
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            r.c("infos", "menu.error==" + i + "==descpriton==" + str + "==failingurl==" + str2);
            this.b.g.loadData(this.b.k, "text/html", HTTP.UTF_8);
            if (this.b.i != null) {
                this.b.i.setVisibility(0);
            }
            if (this.b.h != null) {
                this.b.h.setErrorType(1);
            }
            y.b(this.b.a, 7015);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.e = getArguments();
        }
        this.f = getContext();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_favor_menu, viewGroup, false);
        a(inflate);
        b(inflate);
        return inflate;
    }

    private void a(View view) {
        this.m = (TextView) view.findViewById(R.id.app_title_textview);
        this.m.setText(getResources().getString(R.string.tab_menu));
        this.n = (ImageView) view.findViewById(R.id.left_appbar_btn);
        this.n.setImageResource(R.drawable.menu_left_icon_selector);
        this.n.setVisibility(0);
        this.n.setOnClickListener(this);
        this.l = (ImageView) view.findViewById(R.id.right_image_view);
        this.l.setImageResource(R.drawable.menu_right_icon_selector);
        this.l.setVisibility(0);
        this.l.setOnClickListener(this);
        this.g = (X5WebView) view.findViewById(R.id.favor_menu_webview);
    }

    private void b(View view) {
        this.i = view.findViewById(R.id.empty_layout_root);
        this.h = (EmptyLayout) view.findViewById(R.id.empty_layout);
        this.j = (ProgressBar) view.findViewById(R.id.web_view_progress);
        this.p = (ProgressBar) view.findViewById(R.id.progress_loading);
        this.h.setRefresh(new OnClickListener(this) {
            final /* synthetic */ MenuFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (y.d(this.a.b())) {
                        r.b("infos", "murl==https://appfridge.jd.com/recipe.html#/index");
                        if (this.a.p.getVisibility() == 8) {
                            this.a.p.setVisibility(0);
                        }
                        if (this.a.g.getVisibility() == 0) {
                            this.a.g.setVisibility(8);
                        }
                        this.a.g.loadUrl("https://appfridge.jd.com/recipe.html#/index");
                        this.a.i.setVisibility(8);
                        this.a.h.setErrorType(4);
                        return;
                    }
                    x.a(this.a.getActivity(), "网络断了哦，请检查网络设置");
                }
            }
        });
        this.g.setWebViewClient(this.q);
        this.g.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ MenuFragment a;

            {
                this.a = r1;
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                r.c("infos", "title==" + str);
            }

            public void onProgressChanged(WebView webView, int i) {
                r.c("infos", "onProgressChanged.newProgress==" + i);
                this.a.o = i;
                if (i <= 0 || i >= 100) {
                    if (i == 100) {
                        this.a.j.setVisibility(8);
                    }
                } else if (this.a.j.getVisibility() == 8) {
                    this.a.j.setVisibility(0);
                }
                this.a.j.setProgress(i);
                super.onProgressChanged(webView, i);
            }
        });
        this.g.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ MenuFragment a;

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
            this.g.a(this.f, "https://appfridge.jd.com/recipe.html#/index");
            this.g.loadUrl("https://appfridge.jd.com/recipe.html#/index");
            r.c("infoss", "url===https://appfridge.jd.com/recipe.html#/index");
        } else {
            this.g.a(this.f, "https://appfridge.jd.com/recipe.html#/index");
            this.g.loadUrl("https://appfridge.jd.com/recipe.html#/index");
            r.c("infoss", "url===https://appfridge.jd.com/recipe.html#/index");
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_appbar_btn:
                aa.e(b());
                return;
            case R.id.right_image_view:
                aa.f(b());
                return;
            default:
                return;
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 7015:
                r.c("infos", "====menu=mIsTimeOut===" + this.o);
                if (this.o < 80 || !y.d(b())) {
                    this.i.setVisibility(0);
                    this.h.setErrorType(1);
                    break;
                }
        }
        return super.handleMessage(message);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.g != null) {
            this.g.loadUrl("about:blank");
            this.g.stopLoading();
            this.g.setWebChromeClient(null);
            this.g.setWebViewClient(null);
            this.g.removeAllViews();
            this.g.clearHistory();
            this.g.destroy();
            this.g = null;
        }
        y.b(this.a, 7015);
    }
}
