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
public class a<T extends FollowedMeFragment> implements Unbinder {
    protected T a;
    private View b;

    public a(final T t, Finder finder, Object obj) {
        this.a = t;
        View findRequiredView = finder.findRequiredView(obj, R.id.empty_layout, "field 'empty_layout' and method 'goToQrAcitivity'");
        t.empty_layout = findRequiredView;
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.goToQrAcitivity();
            }
        });
        t.empty_hint_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.empty_hint_textview, "field 'empty_hint_textview'", TextView.class);
        t.empty_icon_imageview = (ImageView) finder.findRequiredViewAsType(obj, R.id.empty_icon_imageview, "field 'empty_icon_imageview'", ImageView.class);
        t.friends_recycler_view = (RecyclerView) finder.findRequiredViewAsType(obj, R.id.friends_recycler_view, "field 'friends_recycler_view'", RecyclerView.class);
        t.friends_content_empty = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.friends_content_empty, "field 'friends_content_empty'", EmptyLayout.class);
    }

    public void unbind() {
        FollowedMeFragment followedMeFragment = this.a;
        if (followedMeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        followedMeFragment.empty_layout = null;
        followedMeFragment.empty_hint_textview = null;
        followedMeFragment.empty_icon_imageview = null;
        followedMeFragment.friends_recycler_view = null;
        followedMeFragment.friends_content_empty = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.a = null;
    }
}
