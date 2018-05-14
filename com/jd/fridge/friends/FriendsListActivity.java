package com.jd.fridge.friends;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.base.a;
import com.jd.fridge.widget.EmptyLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.b;

/* compiled from: TbsSdkJava */
public class FriendsListActivity extends BaseActivity implements a {
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    @BindView(2131558607)
    ViewPager viewpager;
    @BindView(2131558606)
    SmartTabLayout viewpagertab;

    protected int a() {
        return R.layout.activity_friends;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        b((int) R.string.activity_friends_list_title_text);
        this.viewpager.setAdapter(new FragmentPagerItemAdapter(getSupportFragmentManager(), b.with(getBaseContext()).a(getString(R.string.activity_friends_list_i_followed), IFollowedFragment.class).a(getString(R.string.activity_friends_list_followed_me), FollowedMeFragment.class).a()));
        this.viewpagertab.setViewPager(this.viewpager);
        this.emptyLayout.setErrorType(4);
    }

    protected void c() {
    }

    protected void d() {
    }

    public void a(int i) {
        this.emptyLayout.setErrorType(i);
    }
}
