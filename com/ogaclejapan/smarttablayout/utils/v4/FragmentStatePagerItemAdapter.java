package com.ogaclejapan.smarttablayout.utils.v4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* compiled from: TbsSdkJava */
public class FragmentStatePagerItemAdapter extends FragmentStatePagerAdapter {
    private final b a;
    private final SparseArrayCompat<WeakReference<Fragment>> b;

    public int getCount() {
        return this.a.size();
    }

    public Fragment getItem(int i) {
        return a(i).a(this.a.getContext(), i);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        if (instantiateItem instanceof Fragment) {
            this.b.put(i, new WeakReference((Fragment) instantiateItem));
        }
        return instantiateItem;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.b.remove(i);
        super.destroyItem(viewGroup, i, obj);
    }

    public CharSequence getPageTitle(int i) {
        return a(i).a();
    }

    public float getPageWidth(int i) {
        return a(i).b();
    }

    protected a a(int i) {
        return (a) this.a.get(i);
    }
}
