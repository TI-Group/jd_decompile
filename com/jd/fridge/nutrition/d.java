package com.jd.fridge.nutrition;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.CustomViewPager;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class d<T extends NutritionActivity> implements Unbinder {
    protected T a;
    private View b;
    private View c;
    private View d;

    public d(final T t, Finder finder, Object obj) {
        this.a = t;
        View findRequiredView = finder.findRequiredView(obj, R.id.tab_txt_1, "field 'mTabTxt1' and method 'onClick'");
        t.mTabTxt1 = (CheckedTextView) finder.castView(findRequiredView, R.id.tab_txt_1, "field 'mTabTxt1'", CheckedTextView.class);
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ d b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.tab_txt_2, "field 'mTabTxt2' and method 'onClick'");
        t.mTabTxt2 = (CheckedTextView) finder.castView(findRequiredView, R.id.tab_txt_2, "field 'mTabTxt2'", CheckedTextView.class);
        this.c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ d b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        findRequiredView = finder.findRequiredView(obj, R.id.tab_txt_3, "field 'mTabTxt3' and method 'onClick'");
        t.mTabTxt3 = (CheckedTextView) finder.castView(findRequiredView, R.id.tab_txt_3, "field 'mTabTxt3'", CheckedTextView.class);
        this.d = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ d b;

            public void doClick(View view) {
                t.onClick(view);
            }
        });
        t.mTabIndicator1 = finder.findRequiredView(obj, R.id.tab_indicator_1, "field 'mTabIndicator1'");
        t.mTabIndicator2 = finder.findRequiredView(obj, R.id.tab_indicator_2, "field 'mTabIndicator2'");
        t.mTabIndicator3 = finder.findRequiredView(obj, R.id.tab_indicator_3, "field 'mTabIndicator3'");
        t.mTabbar = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.tabbar, "field 'mTabbar'", LinearLayout.class);
        t.mViewpager = (CustomViewPager) finder.findRequiredViewAsType(obj, R.id.viewpager, "field 'mViewpager'", CustomViewPager.class);
        t.mEmptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'mEmptyLayout'", EmptyLayout.class);
    }

    public void unbind() {
        NutritionActivity nutritionActivity = this.a;
        if (nutritionActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        nutritionActivity.mTabTxt1 = null;
        nutritionActivity.mTabTxt2 = null;
        nutritionActivity.mTabTxt3 = null;
        nutritionActivity.mTabIndicator1 = null;
        nutritionActivity.mTabIndicator2 = null;
        nutritionActivity.mTabIndicator3 = null;
        nutritionActivity.mTabbar = null;
        nutritionActivity.mViewpager = null;
        nutritionActivity.mEmptyLayout = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.a = null;
    }
}
