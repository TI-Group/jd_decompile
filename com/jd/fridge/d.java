package com.jd.fridge;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.widget.CustomViewPager;
import com.jd.fridge.widget.viewpageindicator.UnderlinePageIndicator;

/* compiled from: TbsSdkJava */
public class d<T extends HomeActivity> implements Unbinder {
    protected T a;

    public d(T t, Finder finder, Object obj) {
        this.a = t;
        t.mBtTab1 = (RadioButton) finder.findRequiredViewAsType(obj, R.id.bt_fridge, "field 'mBtTab1'", RadioButton.class);
        t.mBtControl = (RadioButton) finder.findRequiredViewAsType(obj, R.id.bt_control, "field 'mBtControl'", RadioButton.class);
        t.mBtRelatives = (RadioButton) finder.findRequiredViewAsType(obj, R.id.bt_relatives, "field 'mBtRelatives'", RadioButton.class);
        t.mBtMenu = (RadioButton) finder.findRequiredViewAsType(obj, R.id.bt_menu, "field 'mBtMenu'", RadioButton.class);
        t.mBtMine = (RadioButton) finder.findRequiredViewAsType(obj, R.id.bt_mine, "field 'mBtMine'", RadioButton.class);
        t.mHomeViewpager = (CustomViewPager) finder.findRequiredViewAsType(obj, R.id.home_viewpager, "field 'mHomeViewpager'", CustomViewPager.class);
        t.mHomeIndicator = (UnderlinePageIndicator) finder.findRequiredViewAsType(obj, R.id.home_indicator, "field 'mHomeIndicator'", UnderlinePageIndicator.class);
        t.mFridgeRedPoint = (TextView) finder.findRequiredViewAsType(obj, R.id.fridge_red_point, "field 'mFridgeRedPoint'", TextView.class);
        t.mRelativesRedPoint = (TextView) finder.findRequiredViewAsType(obj, R.id.relatives_red_point, "field 'mRelativesRedPoint'", TextView.class);
        t.mMineRedPoint = (TextView) finder.findRequiredViewAsType(obj, R.id.mine_red_point, "field 'mMineRedPoint'", TextView.class);
        t.mHomeTabsview = (RadioGroup) finder.findRequiredViewAsType(obj, R.id.home_tabsview, "field 'mHomeTabsview'", RadioGroup.class);
        t.mHomeTabviewsLayout = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.home_tabviews_layout, "field 'mHomeTabviewsLayout'", RelativeLayout.class);
    }

    public void unbind() {
        HomeActivity homeActivity = this.a;
        if (homeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        homeActivity.mBtTab1 = null;
        homeActivity.mBtControl = null;
        homeActivity.mBtRelatives = null;
        homeActivity.mBtMenu = null;
        homeActivity.mBtMine = null;
        homeActivity.mHomeViewpager = null;
        homeActivity.mHomeIndicator = null;
        homeActivity.mFridgeRedPoint = null;
        homeActivity.mRelativesRedPoint = null;
        homeActivity.mMineRedPoint = null;
        homeActivity.mHomeTabsview = null;
        homeActivity.mHomeTabviewsLayout = null;
        this.a = null;
    }
}
