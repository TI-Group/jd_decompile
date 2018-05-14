package com.jd.fridge.relatives;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class a<T extends RelativesFragment> implements Unbinder {
    protected T a;
    private View b;
    private View c;

    public a(final T t, Finder finder, Object obj) {
        this.a = t;
        t.mNoticeRedPoint = (TextView) finder.findRequiredViewAsType(obj, R.id.notice_red_point, "field 'mNoticeRedPoint'", TextView.class);
        t.friends_webview = (WebView) finder.findRequiredViewAsType(obj, R.id.friends_webview, "field 'friends_webview'", WebView.class);
        t.empty_layout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'empty_layout'", EmptyLayout.class);
        t.empty_layout_root = finder.findRequiredView(obj, R.id.empty_layout_root, "field 'empty_layout_root'");
        View findRequiredView = finder.findRequiredView(obj, R.id.left_appbar_btn, "field 'left_appbar_btn' and method 'goToMyMessageActivity'");
        t.left_appbar_btn = (ImageView) finder.castView(findRequiredView, R.id.left_appbar_btn, "field 'left_appbar_btn'", ImageView.class);
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.goToMyMessageActivity();
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.right_appbar_btn, "field 'right_appbar_btn' and method 'goToScanQrActivity'");
        t.right_appbar_btn = (ImageView) finder.castView(findRequiredView, R.id.right_appbar_btn, "field 'right_appbar_btn'", ImageView.class);
        this.c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.goToScanQrActivity();
            }
        });
        t.app_title_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.app_title_textview, "field 'app_title_textview'", TextView.class);
    }

    public void unbind() {
        RelativesFragment relativesFragment = this.a;
        if (relativesFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        relativesFragment.mNoticeRedPoint = null;
        relativesFragment.friends_webview = null;
        relativesFragment.empty_layout = null;
        relativesFragment.empty_layout_root = null;
        relativesFragment.left_appbar_btn = null;
        relativesFragment.right_appbar_btn = null;
        relativesFragment.app_title_textview = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.a = null;
    }
}
