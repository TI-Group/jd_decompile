package com.jd.fridge;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.X5WebView;

/* compiled from: TbsSdkJava */
public class e<T extends PrivacyPolicyActivity> implements Unbinder {
    protected T a;

    public e(T t, Finder finder, Object obj) {
        this.a = t;
        t.titleBg = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.title_bg, "field 'titleBg'", RelativeLayout.class);
        t.leftIcon = (ImageView) finder.findRequiredViewAsType(obj, R.id.left_icon, "field 'leftIcon'", ImageView.class);
        t.title = (TextView) finder.findRequiredViewAsType(obj, R.id.pp_title, "field 'title'", TextView.class);
        t.mProgressBar = (ProgressBar) finder.findRequiredViewAsType(obj, R.id.wv_progress, "field 'mProgressBar'", ProgressBar.class);
        t.mWebView = (X5WebView) finder.findRequiredViewAsType(obj, R.id.wv_view, "field 'mWebView'", X5WebView.class);
        t.mEmptyLayoutRoot = finder.findRequiredView(obj, R.id.empty_layout_root, "field 'mEmptyLayoutRoot'");
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
        t.cancel = (Button) finder.findRequiredViewAsType(obj, R.id.bt_cancel, "field 'cancel'", Button.class);
        t.accept = (Button) finder.findRequiredViewAsType(obj, R.id.bt_accept, "field 'accept'", Button.class);
        t.rlBottom = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.rl_bottom, "field 'rlBottom'", RelativeLayout.class);
    }

    public void unbind() {
        PrivacyPolicyActivity privacyPolicyActivity = this.a;
        if (privacyPolicyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        privacyPolicyActivity.titleBg = null;
        privacyPolicyActivity.leftIcon = null;
        privacyPolicyActivity.title = null;
        privacyPolicyActivity.mProgressBar = null;
        privacyPolicyActivity.mWebView = null;
        privacyPolicyActivity.mEmptyLayoutRoot = null;
        privacyPolicyActivity.emptyLayout = null;
        privacyPolicyActivity.cancel = null;
        privacyPolicyActivity.accept = null;
        privacyPolicyActivity.rlBottom = null;
        this.a = null;
    }
}
