package com.ogaclejapan.smarttablayout.utils;

import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* compiled from: TbsSdkJava */
public class ViewPagerItemAdapter extends PagerAdapter {
    private final d a;
    private final SparseArrayCompat<WeakReference<View>> b;
    private final LayoutInflater c;

    public int getCount() {
        return this.a.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View a = a(i).a(this.c, viewGroup);
        viewGroup.addView(a);
        this.b.put(i, new WeakReference(a));
        return a;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.b.remove(i);
        viewGroup.removeView((View) obj);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return obj == view;
    }

    public CharSequence getPageTitle(int i) {
        return a(i).a();
    }

    public float getPageWidth(int i) {
        return a(i).b();
    }

    protected c a(int i) {
        return (c) this.a.get(i);
    }
}
