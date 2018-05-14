package com.jd.fridge.widget.viewpageindicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class IconPageIndicator extends HorizontalScrollView implements PageIndicator {
    private final b a;
    private ViewPager b;
    private OnPageChangeListener c;
    private Runnable d;
    private int e;

    public IconPageIndicator(Context context) {
        this(context, null);
    }

    public IconPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setHorizontalScrollBarEnabled(false);
        this.a = new b(context, R.attr.vpiIconPageIndicatorStyle);
        addView(this.a, new LayoutParams(-2, -1, 17));
    }

    private void a(int i) {
        final View childAt = this.a.getChildAt(i);
        if (this.d != null) {
            removeCallbacks(this.d);
        }
        this.d = new Runnable(this) {
            final /* synthetic */ IconPageIndicator b;

            public void run() {
                this.b.smoothScrollTo(childAt.getLeft() - ((this.b.getWidth() - childAt.getWidth()) / 2), 0);
                this.b.d = null;
            }
        };
        post(this.d);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d != null) {
            post(this.d);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            removeCallbacks(this.d);
        }
    }

    public void onPageScrollStateChanged(int i) {
        if (this.c != null) {
            this.c.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.c != null) {
            this.c.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        setCurrentItem(i);
        if (this.c != null) {
            this.c.onPageSelected(i);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.b != viewPager) {
            if (this.b != null) {
                this.b.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.b = viewPager;
            viewPager.setOnPageChangeListener(this);
            a();
        }
    }

    public void a() {
        this.a.removeAllViews();
        a aVar = (a) this.b.getAdapter();
        int a = aVar.a();
        for (int i = 0; i < a; i++) {
            View imageView = new ImageView(getContext(), null, R.attr.vpiIconPageIndicatorStyle);
            imageView.setImageResource(aVar.a(i));
            this.a.addView(imageView);
        }
        if (this.e > a) {
            this.e = a - 1;
        }
        setCurrentItem(this.e);
        requestLayout();
    }

    public void setCurrentItem(int i) {
        if (this.b == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.e = i;
        this.b.setCurrentItem(i);
        int childCount = this.a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.a.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.c = onPageChangeListener;
    }
}
