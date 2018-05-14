package com.jd.fridge.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.widget.viewpageindicator.UnderlinePageIndicator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FragmentTabPager extends FragmentPagerAdapter implements OnPageChangeListener {
    private final Context a;
    private final ViewPager b;
    private final RadioGroup c;
    private UnderlinePageIndicator d;
    private FragmentManager e;
    private HashMap<String, a> f;
    private List<Boolean> g = new ArrayList();
    private final ArrayList<b> h = new ArrayList();

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(int i);
    }

    /* compiled from: TbsSdkJava */
    static final class b {
        private final Class<?> a;
        private final Bundle b;

        b(Class<?> cls, Bundle bundle) {
            this.a = cls;
            this.b = bundle;
        }
    }

    public FragmentTabPager(FragmentActivity fragmentActivity, ViewPager viewPager, RadioGroup radioGroup, UnderlinePageIndicator underlinePageIndicator, FragmentManager fragmentManager) {
        super(fragmentActivity.getSupportFragmentManager());
        this.a = fragmentActivity;
        this.b = viewPager;
        this.b.setAdapter(this);
        this.e = fragmentManager;
        this.c = radioGroup;
        this.c.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ FragmentTabPager a;

            {
                this.a = r1;
            }

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                for (int i2 = 0; i2 < radioGroup.getChildCount(); i2++) {
                    if (i == radioGroup.getChildAt(i2).getId()) {
                        this.a.b.setCurrentItem(i2);
                        if (i == R.id.bt_mine) {
                            ((BaseActivity) this.a.a).b(true);
                        } else {
                            ((BaseActivity) this.a.a).b(false);
                        }
                    }
                }
            }
        });
        this.d = underlinePageIndicator;
        this.d.setViewPager(this.b);
        this.d.setFades(false);
        this.d.setOnPageChangeListener(this);
        if (this.f == null) {
            this.f = new HashMap();
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
        String tag = fragment.getTag();
        if (!((Boolean) this.g.get(i)).booleanValue()) {
            return fragment;
        }
        FragmentTransaction beginTransaction = this.e.beginTransaction();
        beginTransaction.remove(fragment);
        fragment = Fragment.instantiate(this.a, ((b) this.h.get(i)).a.getName(), ((b) this.h.get(i)).b);
        beginTransaction.add(viewGroup.getId(), fragment, tag);
        beginTransaction.attach(fragment);
        beginTransaction.commitAllowingStateLoss();
        this.g.set(i, Boolean.valueOf(false));
        return fragment;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public void a(Class<?> cls, Bundle bundle) {
        this.h.add(new b(cls, bundle));
        this.g.add(Boolean.valueOf(false));
        notifyDataSetChanged();
    }

    public void a(Class<?> cls, Bundle bundle, int i) {
        this.h.set(i, new b(cls, bundle));
        this.g.set(i, Boolean.valueOf(true));
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.h.size();
    }

    public Fragment getItem(int i) {
        b bVar = (b) this.h.get(i);
        return Fragment.instantiate(this.a, bVar.a.getName(), bVar.b);
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        ((RadioButton) this.c.getChildAt(i)).setChecked(true);
        for (String str : this.f.keySet()) {
            if (this.f.get(str) != null) {
                ((a) this.f.get(str)).a(i);
            }
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void a(String str, a aVar) {
        this.f.put(str, aVar);
    }
}
