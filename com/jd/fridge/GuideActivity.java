package com.jd.fridge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.widget.viewpageindicator.CirclePageIndicator;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class GuideActivity extends BaseActivity {
    private List<GuideFragment> a;
    private ViewPager b;
    private a c;
    private boolean d = false;

    /* compiled from: TbsSdkJava */
    class a extends FragmentPagerAdapter {
        final /* synthetic */ GuideActivity a;

        public a(GuideActivity guideActivity, FragmentManager fragmentManager) {
            this.a = guideActivity;
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            return (Fragment) this.a.a.get(i);
        }

        public int getCount() {
            return this.a.a.size();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getIntent().getBooleanExtra("need_login", false);
    }

    protected int a() {
        return R.layout.guide_view;
    }

    protected void b() {
        k();
        b(true);
        this.b = (ViewPager) findViewById(R.id.guide_viewpager);
        this.a = new ArrayList();
        this.a.add(GuideFragment.a(1, R.drawable.guide_bg_1));
        this.a.add(GuideFragment.a(2, R.drawable.guide_bg_2));
        this.a.add(GuideFragment.a(3, R.drawable.guide_bg_3));
        this.c = new a(this, getSupportFragmentManager());
        this.b.setAdapter(this.c);
        ((CirclePageIndicator) findViewById(R.id.guide_bg_CPI)).setViewPager(this.b);
        setResult(-1);
    }

    protected void c() {
    }

    protected void d() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
