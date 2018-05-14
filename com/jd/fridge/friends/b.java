package com.jd.fridge.friends;

import android.support.v4.view.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/* compiled from: TbsSdkJava */
public class b<T extends FriendsListActivity> implements Unbinder {
    protected T a;

    public b(T t, Finder finder, Object obj) {
        this.a = t;
        t.viewpager = (ViewPager) finder.findRequiredViewAsType(obj, R.id.viewpager, "field 'viewpager'", ViewPager.class);
        t.viewpagertab = (SmartTabLayout) finder.findRequiredViewAsType(obj, R.id.viewpagertab, "field 'viewpagertab'", SmartTabLayout.class);
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
    }

    public void unbind() {
        FriendsListActivity friendsListActivity = this.a;
        if (friendsListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        friendsListActivity.viewpager = null;
        friendsListActivity.viewpagertab = null;
        friendsListActivity.emptyLayout = null;
        this.a = null;
    }
}
