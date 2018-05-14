package com.jd.fridge.favorMenu;

import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;

/* compiled from: TbsSdkJava */
public class b<T extends MenuCategoryActivity> implements Unbinder {
    protected T a;

    public b(T t, Finder finder, Object obj) {
        this.a = t;
        t.mWebViewProgressBar = (ProgressBar) finder.findRequiredViewAsType(obj, R.id.web_view_progress, "field 'mWebViewProgressBar'", ProgressBar.class);
        t.mEmptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'mEmptyLayout'", EmptyLayout.class);
        t.mEmptyLayoutRoot = finder.findRequiredView(obj, R.id.empty_layout_root, "field 'mEmptyLayoutRoot'");
        t.mWebView = (X5WebView) finder.findRequiredViewAsType(obj, R.id.favor_menu_webview, "field 'mWebView'", X5WebView.class);
    }

    public void unbind() {
        MenuCategoryActivity menuCategoryActivity = this.a;
        if (menuCategoryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        menuCategoryActivity.mWebViewProgressBar = null;
        menuCategoryActivity.mEmptyLayout = null;
        menuCategoryActivity.mEmptyLayoutRoot = null;
        menuCategoryActivity.mWebView = null;
        this.a = null;
    }
}
