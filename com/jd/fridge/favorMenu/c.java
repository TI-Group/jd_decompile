package com.jd.fridge.favorMenu;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.TagCloudView;
import com.jd.fridge.widget.X5WebView;

/* compiled from: TbsSdkJava */
public class c<T extends MenuSearchActivity> implements Unbinder {
    protected T a;

    public c(T t, Finder finder, Object obj) {
        this.a = t;
        t.searchEditText = (EditText) finder.findRequiredViewAsType(obj, R.id.menu_search_editText, "field 'searchEditText'", EditText.class);
        t.backImageView = (ImageView) finder.findRequiredViewAsType(obj, R.id.menu_search_back_imageView, "field 'backImageView'", ImageView.class);
        t.closeImageView = (ImageView) finder.findRequiredViewAsType(obj, R.id.menu_search_close_imageView, "field 'closeImageView'", ImageView.class);
        t.searchListView = (ListView) finder.findRequiredViewAsType(obj, R.id.menu_search_listView, "field 'searchListView'", ListView.class);
        t.dividerView = finder.findRequiredView(obj, R.id.divider_view, "field 'dividerView'");
        t.noResultLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.menu_search_no_result_layout, "field 'noResultLayout'", RelativeLayout.class);
        t.tagRootView = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.tag_root_view, "field 'tagRootView'", LinearLayout.class);
        t.hotTagView = (TagCloudView) finder.findRequiredViewAsType(obj, R.id.hot_tag_view, "field 'hotTagView'", TagCloudView.class);
        t.recentTagRootView = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.recent_tag_root_view, "field 'recentTagRootView'", RelativeLayout.class);
        t.recentSearchCloseImageView = (ImageView) finder.findRequiredViewAsType(obj, R.id.recent_search_close_imageView, "field 'recentSearchCloseImageView'", ImageView.class);
        t.recentTagView = (TagCloudView) finder.findRequiredViewAsType(obj, R.id.recent_tag_view, "field 'recentTagView'", TagCloudView.class);
        t.webView = (X5WebView) finder.findRequiredViewAsType(obj, R.id.menu_search_webView, "field 'webView'", X5WebView.class);
        t.mWebViewProgressBar = (ProgressBar) finder.findRequiredViewAsType(obj, R.id.web_view_progress, "field 'mWebViewProgressBar'", ProgressBar.class);
        t.hotTextView = (TextView) finder.findRequiredViewAsType(obj, R.id.hot_tag_textView, "field 'hotTextView'", TextView.class);
        t.mEmptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'mEmptyLayout'", EmptyLayout.class);
        t.mEmptyLayoutRoot = finder.findRequiredView(obj, R.id.empty_layout_root, "field 'mEmptyLayoutRoot'");
    }

    public void unbind() {
        MenuSearchActivity menuSearchActivity = this.a;
        if (menuSearchActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        menuSearchActivity.searchEditText = null;
        menuSearchActivity.backImageView = null;
        menuSearchActivity.closeImageView = null;
        menuSearchActivity.searchListView = null;
        menuSearchActivity.dividerView = null;
        menuSearchActivity.noResultLayout = null;
        menuSearchActivity.tagRootView = null;
        menuSearchActivity.hotTagView = null;
        menuSearchActivity.recentTagRootView = null;
        menuSearchActivity.recentSearchCloseImageView = null;
        menuSearchActivity.recentTagView = null;
        menuSearchActivity.webView = null;
        menuSearchActivity.mWebViewProgressBar = null;
        menuSearchActivity.hotTextView = null;
        menuSearchActivity.mEmptyLayout = null;
        menuSearchActivity.mEmptyLayoutRoot = null;
        this.a = null;
    }
}
