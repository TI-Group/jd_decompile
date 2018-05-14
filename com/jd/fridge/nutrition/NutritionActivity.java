package com.jd.fridge.nutrition;

import android.app.Activity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.base.a;
import com.jd.fridge.widget.CustomViewPager;
import com.jd.fridge.widget.EmptyLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class NutritionActivity extends BaseActivity implements OnPageChangeListener, a {
    @BindView(2131558576)
    EmptyLayout mEmptyLayout;
    @BindView(2131558616)
    View mTabIndicator1;
    @BindView(2131558617)
    View mTabIndicator2;
    @BindView(2131558618)
    View mTabIndicator3;
    @BindView(2131558613)
    CheckedTextView mTabTxt1;
    @BindView(2131558614)
    CheckedTextView mTabTxt2;
    @BindView(2131558615)
    CheckedTextView mTabTxt3;
    @BindView(2131558612)
    LinearLayout mTabbar;
    @BindView(2131558607)
    CustomViewPager mViewpager;

    protected int a() {
        return R.layout.activity_nutrition;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        c(getResources().getString(R.string.activity_nutrition_title));
        List arrayList = new ArrayList();
        arrayList.add(DistributionFragment.b("", ""));
        arrayList.add(HCHSFragment.b("", ""));
        arrayList.add(DetailFragment.b("", ""));
        this.mViewpager.setAdapter(new NutritionFragmentPagerAdapter(getSupportFragmentManager(), arrayList));
        this.mViewpager.setOffscreenPageLimit(2);
        this.mViewpager.addOnPageChangeListener(this);
    }

    protected void c() {
    }

    protected void d() {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                p();
                a("营养分析-营养分布");
                return;
            case 1:
                i();
                a("营养分析-高卡高糖");
                return;
            case 2:
                h();
                a("营养分析-营养明细");
                return;
            default:
                return;
        }
    }

    private void h() {
        this.mTabIndicator1.setVisibility(4);
        this.mTabIndicator2.setVisibility(4);
        this.mTabIndicator3.setVisibility(0);
        this.mTabTxt1.setChecked(false);
        this.mTabTxt2.setChecked(false);
        this.mTabTxt3.setChecked(true);
    }

    private void i() {
        this.mTabIndicator1.setVisibility(4);
        this.mTabIndicator2.setVisibility(0);
        this.mTabIndicator3.setVisibility(4);
        this.mTabTxt1.setChecked(false);
        this.mTabTxt2.setChecked(true);
        this.mTabTxt3.setChecked(false);
    }

    private void p() {
        this.mTabIndicator1.setVisibility(0);
        this.mTabIndicator2.setVisibility(4);
        this.mTabIndicator3.setVisibility(4);
        this.mTabTxt1.setChecked(true);
        this.mTabTxt2.setChecked(false);
        this.mTabTxt3.setChecked(false);
    }

    public void onPageScrollStateChanged(int i) {
    }

    @OnClick({2131558613, 2131558614, 2131558615})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_txt_1:
                p();
                this.mViewpager.setCurrentItem(0);
                return;
            case R.id.tab_txt_2:
                i();
                this.mViewpager.setCurrentItem(1);
                return;
            case R.id.tab_txt_3:
                h();
                this.mViewpager.setCurrentItem(3);
                return;
            default:
                return;
        }
    }

    public void e() {
        this.mEmptyLayout.setErrorType(10);
    }

    public void f() {
        this.mEmptyLayout.setErrorType(11);
    }

    public void g() {
        this.mEmptyLayout.setErrorType(4);
    }
}
