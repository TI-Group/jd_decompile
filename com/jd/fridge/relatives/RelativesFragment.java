package com.jd.fridge.relatives;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.LazyFragment;
import com.jd.fridge.bean.h5.H5Action;
import com.jd.fridge.comments.AddCommentsActivity;
import com.jd.fridge.util.r;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.zxing.activity.QRCaptureActivity;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class RelativesFragment extends LazyFragment {
    @BindView(2131558675)
    TextView app_title_textview;
    private boolean e = false;
    @BindView(2131558576)
    EmptyLayout empty_layout;
    @BindView(2131558580)
    View empty_layout_root;
    private String f;
    @BindView(2131558943)
    WebView friends_webview;
    private String g;
    private Context h;
    private String i = "";
    private String j = "/friends/";
    private View k;
    private String l;
    @BindView(2131558673)
    ImageView left_appbar_btn;
    private String m = "";
    @BindView(2131558674)
    TextView mNoticeRedPoint;
    private boolean n;
    private final WebViewClient o = new WebViewClient(this) {
        final /* synthetic */ RelativesFragment a;

        {
            this.a = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            H5Action a = this.a.b(str);
            if (!a.getProtocol().equals("fridgenative://")) {
                webView.loadUrl(a.getUrl());
            } else if (a.getAction().equals("ToFridgeComment")) {
                Intent intent = new Intent(this.a.h, AddCommentsActivity.class);
                intent.putExtra("url", a.getUrl());
                this.a.startActivityForResult(intent, 1);
                r.b("infos", "=====11111112=====");
            }
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.a.friends_webview.loadData(this.a.m, "text/html", HTTP.UTF_8);
            this.a.l = str2;
            this.a.empty_layout_root.setVisibility(0);
            this.a.empty_layout.setErrorType(1);
        }
    };
    private final BroadcastReceiver p = new BroadcastReceiver(this) {
        final /* synthetic */ RelativesFragment a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Object obj = -1;
            switch (action.hashCode()) {
                case -663047239:
                    if (action.equals("updateViewRelatives")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 1591869745:
                    if (action.equals("ACTION_MAKE_FRIENDS_SUCCESS")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.a.friends_webview.reload();
                    return;
                case 1:
                    this.a.f();
                    return;
                default:
                    return;
            }
        }
    };
    @BindView(2131558676)
    ImageView right_appbar_btn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f = getArguments().getString("param1");
            this.g = getArguments().getString("param2");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = layoutInflater.inflate(R.layout.fragment_relatives, viewGroup, false);
        this.h = getContext();
        ButterKnife.bind((Object) this, this.k);
        this.i = GlobalVariable.B().f() + this.j + "myFocus";
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_MAKE_FRIENDS_SUCCESS");
        intentFilter.addAction("updateViewRelatives");
        getActivity().registerReceiver(this.p, intentFilter);
        e();
        return this.k;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.n = true;
        c();
        this.e = true;
    }

    protected void c() {
        if (this.n && this.d) {
            f();
        }
    }

    private void e() {
        this.app_title_textview.setText(R.string.fragment_friend_title);
        this.left_appbar_btn.setImageResource(R.drawable.appbar_back_selector);
        this.left_appbar_btn.setVisibility(0);
        this.right_appbar_btn.setImageResource(R.drawable.appbar_scan_qr_selector);
        this.right_appbar_btn.setVisibility(0);
        this.friends_webview = (WebView) this.k.findViewById(R.id.friends_webview);
        this.friends_webview.setWebViewClient(this.o);
        this.friends_webview.setWebChromeClient(new WebChromeClient());
        this.friends_webview.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ RelativesFragment a;

            {
                this.a = r1;
            }

            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.empty_layout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ RelativesFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.friends_webview.loadUrl(this.a.l);
                    this.a.empty_layout_root.setVisibility(8);
                    this.a.empty_layout.setErrorType(4);
                }
            }
        });
        WebSettings settings = this.friends_webview.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(2);
        settings.setBlockNetworkImage(false);
        if (VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
            WebView webView = this.friends_webview;
            WebView.enableSlowWholeDocumentDraw();
        }
        y.a(this.h, this.friends_webview, this.i);
        this.friends_webview.loadUrl(this.i);
    }

    private H5Action b(String str) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (str.startsWith("fridgenative://")) {
            str2 = "fridgenative://";
            str4 = str.substring(str2.length());
            str3 = str4.substring(0, str4.indexOf("/?url="));
            str = str4.substring(str3.length() + "/?url=".length());
        }
        return new H5Action(str2, str3, str);
    }

    @OnClick({2131558673})
    void goToMyMessageActivity() {
        if (!y.c()) {
            getActivity().finish();
            GlobalVariable.a().i();
        }
    }

    @OnClick({2131558676})
    void goToScanQrActivity() {
        if (!y.c()) {
            startActivity(new Intent(getContext(), QRCaptureActivity.class));
        }
    }

    public void onDestroy() {
        getActivity().unregisterReceiver(this.p);
        super.onDestroy();
    }

    private void f() {
        if (((GlobalVariable) b().getApplication()).j()) {
            this.mNoticeRedPoint.setVisibility(0);
        } else {
            this.mNoticeRedPoint.setVisibility(8);
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.e && z && y.d(getActivity().getApplicationContext())) {
            this.friends_webview.reload();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (this.friends_webview != null) {
                        this.friends_webview.reload();
                        r.b("infos", "===reload===");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
