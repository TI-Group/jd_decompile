package com.jd.fridge.widget.viewpageindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class TabPageIndicator extends HorizontalScrollView implements PageIndicator {
    private static final CharSequence a = "";
    private Runnable b;
    private final OnClickListener c;
    private final b d;
    private ViewPager e;
    private OnPageChangeListener f;
    private int g;
    private int h;
    private a i;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(int i);
    }

    /* compiled from: TbsSdkJava */
    private class b extends TextView {
        final /* synthetic */ TabPageIndicator a;
        private int b;

        public b(TabPageIndicator tabPageIndicator, Context context) {
            this.a = tabPageIndicator;
            super(context, null, R.attr.vpiTabPageIndicatorStyle);
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.a.g > 0 && getMeasuredWidth() > this.a.g) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.a.g, 1073741824), i2);
            }
        }

        public int a() {
            return this.b;
        }
    }

    public TabPageIndicator(Context context) {
        this(context, null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new OnClickListener(this) {
            final /* synthetic */ TabPageIndicator a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                b bVar = (b) view;
                int currentItem = this.a.e.getCurrentItem();
                int a = bVar.a();
                this.a.e.setCurrentItem(a);
                if (currentItem == a && this.a.i != null) {
                    this.a.i.a(a);
                }
            }
        };
        setHorizontalScrollBarEnabled(false);
        this.d = new b(context, R.attr.vpiTabPageIndicatorStyle);
        addView(this.d, new LayoutParams(-2, -1));
    }

    public void setOnTabReselectedListener(a aVar) {
        this.i = aVar;
    }

    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.g = -1;
        } else if (childCount > 2) {
            this.g = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
        } else {
            this.g = MeasureSpec.getSize(i) / 2;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        mode = getMeasuredWidth();
        if (z && measuredWidth != mode) {
            setCurrentItem(this.h);
        }
    }

    private void a(int i) {
        final View childAt = this.d.getChildAt(i);
        if (this.b != null) {
            removeCallbacks(this.b);
        }
        this.b = new Runnable(this) {
            final /* synthetic */ TabPageIndicator b;

            public void run() {
                this.b.smoothScrollTo(childAt.getLeft() - ((this.b.getWidth() - childAt.getWidth()) / 2), 0);
                this.b.b = null;
            }
        };
        post(this.b);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b != null) {
            post(this.b);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            removeCallbacks(this.b);
        }
    }

    private void a(int i, CharSequence charSequence, int i2) {
        View bVar = new b(this, getContext());
        bVar.b = i;
        bVar.setFocusable(true);
        bVar.setOnClickListener(this.c);
        bVar.setText(charSequence);
        if (i2 != 0) {
            bVar.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        }
        this.d.addView(bVar, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    public void onPageScrollStateChanged(int i) {
        if (this.f != null) {
            this.f.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f != null) {
            this.f.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        setCurrentItem(i);
        if (this.f != null) {
            this.f.onPageSelected(i);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.e != viewPager) {
            if (this.e != null) {
                this.e.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.e = viewPager;
            viewPager.setOnPageChangeListener(this);
            a();
        }
    }

    public void a() {
        this.d.removeAllViews();
        PagerAdapter adapter = this.e.getAdapter();
        a aVar = null;
        if (adapter instanceof a) {
            aVar = (a) adapter;
        }
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            CharSequence charSequence;
            int a;
            CharSequence pageTitle = adapter.getPageTitle(i);
            if (pageTitle == null) {
                charSequence = a;
            } else {
                charSequence = pageTitle;
            }
            if (aVar != null) {
                a = aVar.a(i);
            } else {
                a = 0;
            }
            a(i, charSequence, a);
        }
        if (this.h > count) {
            this.h = count - 1;
        }
        setCurrentItem(this.h);
        requestLayout();
    }

    public void setCurrentItem(int i) {
        if (this.e == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.h = i;
        this.e.setCurrentItem(i);
        int childCount = this.d.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.d.getChildAt(i2);
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
        this.f = onPageChangeListener;
    }
}
