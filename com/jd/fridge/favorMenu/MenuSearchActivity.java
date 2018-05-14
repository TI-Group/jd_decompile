package com.jd.fridge.favorMenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.MenuHotSearchListDataBaseBean;
import com.jd.fridge.bean.MenuKeyWordsSearchListDataBaseBean;
import com.jd.fridge.bean.h5.H5Action;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.e.b;
import com.jd.fridge.util.o;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.TagCloudView;
import com.jd.fridge.widget.X5WebView;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class MenuSearchActivity extends BaseActivity implements TextWatcher, OnClickListener, OnItemClickListener, OnEditorActionListener {
    private Timer a;
    private TimerTask b;
    @BindView(2131558641)
    ImageView backImageView;
    private String c = "https://appfridge.jd.com/recipe.html#/search?token=";
    @BindView(2131558645)
    ImageView closeImageView;
    private List<String> d = new ArrayList();
    @BindView(2131558636)
    View dividerView;
    @BindView(2131558648)
    TagCloudView hotTagView;
    @BindView(2131558647)
    TextView hotTextView;
    private List<String> i = new ArrayList();
    private List<String> j = new ArrayList();
    private Gson k;
    private String l;
    private boolean m;
    @BindView(2131558576)
    EmptyLayout mEmptyLayout;
    @BindView(2131558580)
    View mEmptyLayoutRoot;
    @BindView(2131558581)
    ProgressBar mWebViewProgressBar;
    private boolean n;
    @BindView(2131558654)
    RelativeLayout noResultLayout;
    private int o;
    private final WebViewClient p = new WebViewClient(this) {
        final /* synthetic */ MenuSearchActivity b;

        {
            this.b = r1;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            H5Action e = y.e(str);
            r.b("infoss", "action==" + e.getAction() + "==url==" + e.getUrl());
            aa.a(this.b, e.getUrl());
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.b.webView.getVisibility() == 8) {
                this.b.webView.setVisibility(0);
            }
            if (this.b.tagRootView.getVisibility() == 0) {
                this.b.tagRootView.setVisibility(8);
            }
            y.b(this.b.e, 7016);
            this.b.searchEditText.setFocusable(true);
            this.b.searchEditText.setFocusableInTouchMode(true);
            this.b.m = false;
            r.c("infos", "===onPageFinished===" + str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.b.searchEditText.setFocusable(true);
            this.b.searchEditText.setFocusableInTouchMode(true);
            this.b.m = false;
            y.a(this.b.e, 7016);
            r.c("infos", "===onPageStarted===");
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            r.c("infos", ".error==" + i + "==des==" + str + "==failingurl==" + str2);
            this.b.webView.loadData("", "text/html", HTTP.UTF_8);
            if (this.b.mEmptyLayoutRoot != null) {
                this.b.mEmptyLayoutRoot.setVisibility(0);
            }
            if (this.b.mEmptyLayout != null) {
                this.b.mEmptyLayout.setErrorType(1);
            }
            y.b(this.b.e, 7016);
            if (this.b.searchEditText != null) {
                this.b.searchEditText.setFocusable(true);
                this.b.searchEditText.setFocusableInTouchMode(true);
            }
            this.b.m = false;
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            r.c("infos", "intercept==" + str);
            if (str.endsWith(".jpg") || str.endsWith("JPG")) {
                this.b.n = true;
            } else {
                this.b.n = false;
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    };
    @BindView(2131558651)
    ImageView recentSearchCloseImageView;
    @BindView(2131558649)
    RelativeLayout recentTagRootView;
    @BindView(2131558652)
    TagCloudView recentTagView;
    @BindView(2131558644)
    EditText searchEditText;
    @BindView(2131558653)
    ListView searchListView;
    @BindView(2131558646)
    LinearLayout tagRootView;
    @BindView(2131558656)
    X5WebView webView;

    protected int a() {
        return R.layout.activity_search_menu;
    }

    protected void c() {
        this.k = new Gson();
        List list = (List) this.k.fromJson(b.a().b(), new TypeToken<List<String>>(this) {
            final /* synthetic */ MenuSearchActivity a;

            {
                this.a = r1;
            }
        }.getType());
        if (!(list == null || list.isEmpty())) {
            this.i.addAll(list);
        }
        if (!TextUtils.isEmpty(b.a().c())) {
            list = (List) this.k.fromJson(b.a().c(), new TypeToken<List<String>>(this) {
                final /* synthetic */ MenuSearchActivity a;

                {
                    this.a = r1;
                }
            }.getType());
            if (!(list == null || list.isEmpty())) {
                this.d.addAll(list);
            }
        }
        a.a().d(this.e);
        if (!y.d((Context) this)) {
            this.mEmptyLayoutRoot.setVisibility(0);
            this.mEmptyLayout.setErrorType(1);
        } else if (this.d.isEmpty()) {
            this.noResultLayout.setVisibility(0);
        } else {
            this.tagRootView.setVisibility(0);
        }
    }

    protected void b() {
        com.jd.fridge.util.c.a.a(this.e);
        ButterKnife.bind((Activity) this);
        k();
        this.closeImageView.setVisibility(8);
        this.recentTagRootView.setVisibility(8);
        this.noResultLayout.setVisibility(8);
        this.backImageView.setOnClickListener(this);
        this.closeImageView.setOnClickListener(this);
        this.searchEditText.setFocusable(true);
        this.searchEditText.addTextChangedListener(this);
        this.searchEditText.setOnEditorActionListener(this);
        this.searchListView.setOnItemClickListener(this);
        this.recentSearchCloseImageView.setOnClickListener(this);
        this.hotTagView.setOnTagClickListener(new TagCloudView.a(this) {
            final /* synthetic */ MenuSearchActivity a;

            {
                this.a = r1;
            }

            public void a(int i) {
                if (i >= 0) {
                    if (y.d(this.a)) {
                        this.a.m = true;
                        if (!this.a.d.isEmpty() && i <= this.a.d.size()) {
                            this.a.searchEditText.setFocusable(false);
                            this.a.searchEditText.setFocusableInTouchMode(false);
                            this.a.searchEditText.setText((CharSequence) this.a.d.get(i));
                            this.a.searchEditText.setSelection(((String) this.a.d.get(i)).length());
                        }
                        this.a.a(i, this.a.d);
                        this.a.tagRootView.setVisibility(8);
                        this.a.f((String) this.a.d.get(i));
                        return;
                    }
                    this.a.mEmptyLayoutRoot.setVisibility(0);
                    this.a.mEmptyLayout.setErrorType(1);
                }
            }
        });
        this.recentTagView.setOnTagClickListener(new TagCloudView.a(this) {
            final /* synthetic */ MenuSearchActivity a;

            {
                this.a = r1;
            }

            public void a(int i) {
                if (i >= 0) {
                    if (y.d(this.a)) {
                        this.a.m = true;
                        if (!this.a.i.isEmpty() && i <= this.a.i.size()) {
                            this.a.searchEditText.setFocusable(false);
                            this.a.searchEditText.setFocusableInTouchMode(false);
                            this.a.searchEditText.setText((CharSequence) this.a.i.get(i));
                            this.a.searchEditText.setSelection(((String) this.a.i.get(i)).length());
                        }
                        this.a.a(i, this.a.i);
                        this.a.f((String) this.a.i.get(i));
                        this.a.recentTagView.setTags(this.a.i);
                        this.a.tagRootView.setVisibility(8);
                        return;
                    }
                    this.a.mEmptyLayoutRoot.setVisibility(0);
                    this.a.mEmptyLayout.setErrorType(1);
                }
            }
        });
        this.mEmptyLayout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ MenuSearchActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (y.d(this.a)) {
                        r.b("infos", "loadUrl==" + this.a.l + "===hot==" + this.a.d.size());
                        if (TextUtils.isEmpty(this.a.l)) {
                            a.a().d(this.a.e);
                        } else {
                            this.a.tagRootView.setVisibility(8);
                            this.a.webView.loadUrl(this.a.l);
                        }
                        this.a.mEmptyLayoutRoot.setVisibility(8);
                        this.a.mEmptyLayout.setErrorType(4);
                        return;
                    }
                    x.a(this.a, "网络断了哦，请检查网络设置");
                }
            }
        });
        e();
        h();
    }

    private void e() {
        this.webView.setWebViewClient(this.p);
        this.webView.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ MenuSearchActivity a;

            {
                this.a = r1;
            }

            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                r.c("infoss", "title==" + str);
            }

            public void onProgressChanged(WebView webView, int i) {
                r.c("infos", "search.onProgressChanged.newProgress==" + i);
                this.a.o = i;
                if (i <= 0 || i >= 100) {
                    if (i == 100) {
                        this.a.mWebViewProgressBar.setVisibility(8);
                    }
                } else if (this.a.mWebViewProgressBar.getVisibility() == 8) {
                    this.a.mWebViewProgressBar.setVisibility(0);
                }
                this.a.mWebViewProgressBar.setProgress(i);
                super.onProgressChanged(webView, i);
            }
        });
        this.webView.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ MenuSearchActivity a;

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
        if (VERSION.SDK_INT < 21) {
        }
    }

    protected void d() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_food, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu_search_back_imageView:
                if (this.webView.getVisibility() == 0 && this.n) {
                    q();
                    this.searchEditText.setFocusable(true);
                    this.searchEditText.setFocusableInTouchMode(true);
                    this.m = false;
                    return;
                }
                finish();
                return;
            case R.id.menu_search_close_imageView:
                this.e.postDelayed(new Runnable(this) {
                    final /* synthetic */ MenuSearchActivity a;

                    {
                        this.a = r1;
                    }

                    public void run() {
                        this.a.closeImageView.setVisibility(8);
                    }
                }, 200);
                this.m = false;
                this.searchEditText.setFocusable(true);
                this.searchEditText.setFocusableInTouchMode(true);
                this.searchListView.setVisibility(8);
                this.dividerView.setVisibility(8);
                this.searchEditText.setText("");
                this.webView.setVisibility(8);
                if (this.o == 100) {
                    f();
                    return;
                }
                return;
            case R.id.recent_search_close_imageView:
                this.i.clear();
                b.a().a("");
                this.recentTagRootView.setVisibility(8);
                this.m = false;
                this.searchEditText.setFocusable(true);
                this.searchEditText.setFocusableInTouchMode(true);
                return;
            default:
                return;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i >= 0 && i < this.j.size()) {
            g((String) this.j.get(i));
            a(i, this.j);
            this.searchListView.setVisibility(8);
            this.dividerView.setVisibility(8);
        }
    }

    public boolean a(Message message) {
        List list;
        switch (message.what) {
            case 7009:
                MenuHotSearchListDataBaseBean menuHotSearchListDataBaseBean = (MenuHotSearchListDataBaseBean) message.obj;
                if (menuHotSearchListDataBaseBean == null) {
                    if (!TextUtils.isEmpty(b.a().c())) {
                        list = (List) this.k.fromJson(b.a().c(), new TypeToken<List<String>>(this) {
                            final /* synthetic */ MenuSearchActivity a;

                            {
                                this.a = r1;
                            }
                        }.getType());
                        if (!(list == null || list.isEmpty())) {
                            this.d.clear();
                            this.d.addAll(list);
                            break;
                        }
                    }
                    g();
                    break;
                }
                Object asList = Arrays.asList(menuHotSearchListDataBaseBean.getData());
                this.tagRootView.setVisibility(0);
                if (asList.isEmpty()) {
                    this.hotTextView.setVisibility(8);
                    g();
                } else {
                    this.d.clear();
                    this.d.addAll(asList);
                    this.hotTextView.setVisibility(0);
                    this.hotTagView.setTags(asList);
                    this.noResultLayout.setVisibility(8);
                    p();
                }
                if (!this.i.isEmpty()) {
                    this.recentTagRootView.setVisibility(0);
                    this.recentTagView.setTags(this.i);
                    break;
                }
                this.recentTagRootView.setVisibility(8);
                break;
            case 7010:
                if (!TextUtils.isEmpty(b.a().c())) {
                    list = (List) this.k.fromJson(b.a().c(), new TypeToken<List<String>>(this) {
                        final /* synthetic */ MenuSearchActivity a;

                        {
                            this.a = r1;
                        }
                    }.getType());
                    if (!(list == null || list.isEmpty())) {
                        this.d.clear();
                        this.d.addAll(list);
                        break;
                    }
                }
                g();
                break;
            case 7011:
                r.c("infos", "text==" + this.searchEditText.getText().toString() + "===webview==" + this.webView.getVisibility());
                if (!TextUtils.isEmpty(this.searchEditText.getText()) && this.webView.getVisibility() == 8) {
                    MenuKeyWordsSearchListDataBaseBean menuKeyWordsSearchListDataBaseBean = (MenuKeyWordsSearchListDataBaseBean) message.obj;
                    if (menuKeyWordsSearchListDataBaseBean == null) {
                        g();
                        break;
                    }
                    String[] data = menuKeyWordsSearchListDataBaseBean.getData();
                    this.j.clear();
                    this.j.addAll(Arrays.asList(data));
                    this.searchListView.setVisibility(0);
                    this.dividerView.setVisibility(0);
                    List arrayList = new ArrayList();
                    if (r4 <= 0) {
                        g();
                        break;
                    }
                    for (Object add : data) {
                        arrayList.add(add);
                    }
                    this.searchListView.setAdapter(new ArrayAdapter(this, 17367043, arrayList));
                    this.noResultLayout.setVisibility(8);
                    this.tagRootView.setVisibility(8);
                    break;
                }
            case 7012:
                g();
                break;
            case 7016:
                if (this.o < 70) {
                    this.mEmptyLayoutRoot.setVisibility(0);
                    this.mEmptyLayout.setErrorType(1);
                    break;
                }
                break;
        }
        return super.a(message);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence.toString().replaceAll("\\s*", ""))) {
            this.tagRootView.setVisibility(0);
            this.closeImageView.setVisibility(8);
            this.searchListView.setVisibility(8);
            this.dividerView.setVisibility(8);
            f();
            return;
        }
        this.closeImageView.setVisibility(0);
        if (!y.d((Context) this)) {
            x.a((Context) this, "网络断了哦，请检查网络设置");
        } else if (!this.m) {
            a.a().a(this.e, charSequence.toString().replaceAll("\\s*", ""));
        }
    }

    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable.toString().replaceAll("\\s*", ""))) {
            q();
        } else if (this.webView.getVisibility() == 0) {
            this.webView.setVisibility(8);
        }
    }

    private void f() {
        if (this.d.isEmpty()) {
            this.noResultLayout.setVisibility(0);
        } else {
            this.noResultLayout.setVisibility(8);
            this.tagRootView.setVisibility(0);
            this.hotTextView.setVisibility(0);
            if (!this.i.isEmpty()) {
                this.recentTagRootView.setVisibility(0);
                this.recentTagView.setTags(this.i);
            }
        }
        if (y.d((Context) this)) {
            this.mEmptyLayoutRoot.setVisibility(8);
        }
    }

    private void g() {
        this.searchListView.setVisibility(8);
        this.dividerView.setVisibility(8);
        this.noResultLayout.setVisibility(0);
    }

    private void h() {
        if (this.a == null) {
            this.a = new Timer();
        }
        this.b = new TimerTask(this) {
            final /* synthetic */ MenuSearchActivity a;

            {
                this.a = r1;
            }

            public void run() {
                o.a(this.a.searchEditText);
            }
        };
        this.a.schedule(this.b, 500);
    }

    private void i() {
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.a != null) {
            this.a.cancel();
            this.a.purge();
            this.a = null;
        }
    }

    private void a(int i, List<String> list) {
        if (!list.isEmpty() && i >= 0 && i < list.size()) {
            e(this.c + ((String) list.get(i)));
        }
    }

    private void d(String str) {
        e(this.c + str.replaceAll("\\s*", ""));
    }

    private void e(String str) {
        this.l = str;
        this.webView.a((Context) this, str);
        this.webView.loadUrl(str);
        r.c("infos", "url=====" + str);
    }

    private void f(String str) {
        if (this.i.isEmpty()) {
            this.i.add(str);
        } else {
            int i = 0;
            while (i < this.i.size()) {
                if (((String) this.i.get(i)).equals(str)) {
                    this.i.remove(i);
                    i--;
                }
                i++;
            }
            this.i.add(0, str);
        }
        if (this.i.size() > 10) {
            this.i = this.i.subList(0, 10);
        }
        b.a().a(this.k.toJson(this.i));
    }

    private void p() {
        if (!this.d.isEmpty()) {
            b.a().b(this.k.toJson(this.d));
        }
    }

    private void g(String str) {
        if (!TextUtils.isEmpty(str.replaceAll("\\s*", ""))) {
            f(str.replaceAll("\\s*", ""));
            this.recentTagView.setTags(this.i);
        }
    }

    private void q() {
        this.webView.setVisibility(8);
        if (y.d((Context) this)) {
            this.mEmptyLayoutRoot.setVisibility(8);
        }
        if (this.d.isEmpty()) {
            this.noResultLayout.setVisibility(0);
            return;
        }
        this.tagRootView.setVisibility(0);
        if (!this.i.isEmpty()) {
            this.recentTagRootView.setVisibility(0);
            this.recentTagView.setTags(this.i);
        }
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 3) {
            o.b(this.searchEditText);
            String replaceAll = this.searchEditText.getText().toString().replaceAll("\\s*", "");
            if (y.d((Context) this)) {
                this.mEmptyLayoutRoot.setVisibility(8);
                if (!TextUtils.isEmpty(replaceAll)) {
                    g(replaceAll);
                    d(replaceAll);
                    this.tagRootView.setVisibility(8);
                    this.searchListView.setVisibility(8);
                    this.dividerView.setVisibility(8);
                }
            } else {
                this.mEmptyLayoutRoot.setVisibility(0);
                this.mEmptyLayout.setErrorType(1);
            }
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.webView.getVisibility() == 0 && this.n) {
            this.webView.clearHistory();
            this.webView.setVisibility(8);
            this.tagRootView.setVisibility(0);
            if (!this.i.isEmpty()) {
                this.recentTagRootView.setVisibility(0);
                this.recentTagView.setTags(this.i);
            }
            this.searchEditText.setFocusable(true);
            this.searchEditText.setFocusableInTouchMode(true);
            this.m = false;
            return true;
        }
        finish();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        i();
        if (this.webView != null) {
            this.webView.loadUrl("about:blank");
            this.webView.stopLoading();
            this.webView.setWebChromeClient(null);
            this.webView.setWebViewClient(null);
            this.webView.removeAllViews();
            this.webView.clearHistory();
            this.webView.destroy();
            this.webView = null;
        }
        y.b(this.e, 7016);
    }
}
