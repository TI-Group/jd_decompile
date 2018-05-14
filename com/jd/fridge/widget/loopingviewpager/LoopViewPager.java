package com.jd.fridge.widget.loopingviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;

/* compiled from: TbsSdkJava */
public class LoopViewPager extends ViewPager {
    OnPageChangeListener a;
    private LoopPagerAdapterWrapper b;
    private boolean c = false;
    private OnPageChangeListener d = new OnPageChangeListener(this) {
        final /* synthetic */ LoopViewPager a;
        private float b = -1.0f;
        private float c = -1.0f;

        {
            this.a = r2;
        }

        public void onPageSelected(int i) {
            int a = this.a.b.a(i);
            if (this.c != ((float) a)) {
                this.c = (float) a;
                if (this.a.a != null) {
                    this.a.a.onPageSelected(a);
                }
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (this.a.b != null) {
                int a = this.a.b.a(i);
                if (f == 0.0f && this.b == 0.0f && (i == 0 || i == this.a.b.getCount() - 1)) {
                    this.a.setCurrentItem(a, false);
                }
                i = a;
            }
            this.b = f;
            if (this.a.a == null) {
                return;
            }
            if (i != this.a.b.a() - 1) {
                this.a.a.onPageScrolled(i, f, i2);
            } else if (((double) f) > 0.5d) {
                this.a.a.onPageScrolled(0, 0.0f, 0);
            } else {
                this.a.a.onPageScrolled(i, 0.0f, 0);
            }
        }

        public void onPageScrollStateChanged(int i) {
            if (this.a.b != null) {
                int b = super.getCurrentItem();
                int a = this.a.b.a(b);
                if (i == 0 && (b == 0 || b == this.a.b.getCount() - 1)) {
                    this.a.setCurrentItem(a, false);
                }
            }
            if (this.a.a != null) {
                this.a.a.onPageScrollStateChanged(i);
            }
        }
    };

    public static int a(int i, int i2) {
        int i3 = i - 1;
        if (i3 < 0) {
            return i3 + i2;
        }
        return i3 % i2;
    }

    public void setBoundaryCaching(boolean z) {
        this.c = z;
        if (this.b != null) {
            this.b.a(z);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        this.b = new LoopPagerAdapterWrapper(pagerAdapter);
        this.b.a(this.c);
        super.setAdapter(this.b);
        setCurrentItem(0, false);
    }

    public PagerAdapter getAdapter() {
        return this.b != null ? this.b.b() : this.b;
    }

    public int getCurrentItem() {
        return this.b != null ? this.b.a(super.getCurrentItem()) : 0;
    }

    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.b.b(i), z);
    }

    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.a = onPageChangeListener;
    }

    public LoopViewPager(Context context) {
        super(context);
        a();
    }

    public LoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        super.setOnPageChangeListener(this.d);
    }
}
