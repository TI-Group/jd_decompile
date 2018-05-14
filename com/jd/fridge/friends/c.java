package com.jd.fridge.friends;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class c<T extends IFollowedFragment> implements Unbinder {
    protected T a;
    private View b;

    public c(final T t, Finder finder, Object obj) {
        this.a = t;
        View findRequiredView = finder.findRequiredView(obj, R.id.empty_layout, "field 'empty_layout' and method 'goToQrScanAcitivity'");
        t.empty_layout = findRequiredView;
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ c b;

            public void doClick(View view) {
                t.goToQrScanAcitivity();
            }
        });
        t.empty_hint_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.empty_hint_textview, "field 'empty_hint_textview'", TextView.class);
        t.empty_icon_imageview = (ImageView) finder.findRequiredViewAsType(obj, R.id.empty_icon_imageview, "field 'empty_icon_imageview'", ImageView.class);
        t.friends_recycler_view = (RecyclerView) finder.findRequiredViewAsType(obj, R.id.friends_recycler_view, "field 'friends_recycler_view'", RecyclerView.class);
        t.friends_content_empty = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.friends_content_empty, "field 'friends_content_empty'", EmptyLayout.class);
    }

    public void unbind() {
        IFollowedFragment iFollowedFragment = this.a;
        if (iFollowedFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        iFollowedFragment.empty_layout = null;
        iFollowedFragment.empty_hint_textview = null;
        iFollowedFragment.empty_icon_imageview = null;
        iFollowedFragment.friends_recycler_view = null;
        iFollowedFragment.friends_content_empty = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.a = null;
    }
}
