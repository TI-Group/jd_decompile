package com.jd.fridge.widget.loopingviewpager;

import android.os.Parcelable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: TbsSdkJava */
public class LoopPagerAdapterWrapper extends PagerAdapter {
    private PagerAdapter a;
    private SparseArray<a> b = new SparseArray();
    private boolean c;

    /* compiled from: TbsSdkJava */
    static class a {
        ViewGroup a;
        int b;
        Object c;

        public a(ViewGroup viewGroup, int i, Object obj) {
            this.a = viewGroup;
            this.b = i;
            this.c = obj;
        }
    }

    void a(boolean z) {
        this.c = z;
    }

    LoopPagerAdapterWrapper(PagerAdapter pagerAdapter) {
        this.a = pagerAdapter;
    }

    public void notifyDataSetChanged() {
        this.b = new SparseArray();
        super.notifyDataSetChanged();
    }

    int a(int i) {
        int a = a();
        if (a == 0) {
            return 0;
        }
        int i2 = (i - 1) % a;
        if (i2 < 0) {
            return i2 + a;
        }
        return i2;
    }

    public int b(int i) {
        return i + 1;
    }

    private int c() {
        return 1;
    }

    private int d() {
        return (c() + a()) - 1;
    }

    public int getCount() {
        return this.a.getCount() + 2;
    }

    public int a() {
        return this.a.getCount();
    }

    public PagerAdapter b() {
        return this.a;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int i2;
        if ((this.a instanceof FragmentPagerAdapter) || (this.a instanceof FragmentStatePagerAdapter)) {
            i2 = i;
        } else {
            i2 = a(i);
        }
        if (this.c) {
            a aVar = (a) this.b.get(i);
            if (aVar != null) {
                this.b.remove(i);
                return aVar.c;
            }
        }
        return this.a.instantiateItem(viewGroup, i2);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int i2;
        int c = c();
        int d = d();
        if ((this.a instanceof FragmentPagerAdapter) || (this.a instanceof FragmentStatePagerAdapter)) {
            i2 = i;
        } else {
            i2 = a(i);
        }
        if (this.c && (i == c || i == d)) {
            this.b.put(i, new a(viewGroup, i2, obj));
        } else {
            this.a.destroyItem(viewGroup, i2, obj);
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        this.a.finishUpdate(viewGroup);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return this.a.isViewFromObject(view, obj);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.a.restoreState(parcelable, classLoader);
    }

    public Parcelable saveState() {
        return this.a.saveState();
    }

    public void startUpdate(ViewGroup viewGroup) {
        this.a.startUpdate(viewGroup);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.a.setPrimaryItem(viewGroup, i, obj);
    }
}
