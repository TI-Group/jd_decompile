package com.jd.fridge.userInfo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class b<T extends UserInfoActivity> implements Unbinder {
    protected T a;
    private View b;
    private View c;

    public b(final T t, Finder finder, Object obj) {
        this.a = t;
        t.user_avatar_caption_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.user_avatar_caption_textview, "field 'user_avatar_caption_textview'", TextView.class);
        t.user_avatar = (ImageView) finder.findRequiredViewAsType(obj, R.id.user_avatar, "field 'user_avatar'", ImageView.class);
        t.user_nickname_caption_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.user_nickname_caption_textview, "field 'user_nickname_caption_textview'", TextView.class);
        t.user_nickname_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.user_nickname_textview, "field 'user_nickname_textview'", TextView.class);
        t.user_account_caption_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.user_account_caption_textview, "field 'user_account_caption_textview'", TextView.class);
        t.user_account_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.user_account_textview, "field 'user_account_textview'", TextView.class);
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
        View findRequiredView = finder.findRequiredView(obj, R.id.user_avatar_layout, "method 'modifyUserAvatar'");
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.modifyUserAvatar();
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.user_nickname_layout, "method 'modifyUserNick'");
        this.c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ b b;

            public void doClick(View view) {
                t.modifyUserNick();
            }
        });
    }

    public void unbind() {
        UserInfoActivity userInfoActivity = this.a;
        if (userInfoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        userInfoActivity.user_avatar_caption_textview = null;
        userInfoActivity.user_avatar = null;
        userInfoActivity.user_nickname_caption_textview = null;
        userInfoActivity.user_nickname_textview = null;
        userInfoActivity.user_account_caption_textview = null;
        userInfoActivity.user_account_textview = null;
        userInfoActivity.emptyLayout = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.a = null;
    }
}
