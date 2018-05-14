package com.ogaclejapan.smarttablayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/* compiled from: TbsSdkJava */
public class SmartTabLayout extends HorizontalScrollView {
    protected final b a;
    private int b;
    private int c;
    private boolean d;
    private ColorStateList e;
    private float f;
    private int g;
    private int h;
    private ViewPager i;
    private OnPageChangeListener j;
    private c k;
    private g l;
    private a m;
    private d n;
    private boolean o;

    /* compiled from: TbsSdkJava */
    private class a implements OnClickListener {
        final /* synthetic */ SmartTabLayout a;

        private a(SmartTabLayout smartTabLayout) {
            this.a = smartTabLayout;
        }

        public void onClick(View view) {
            for (int i = 0; i < this.a.a.getChildCount(); i++) {
                if (view == this.a.a.getChildAt(i)) {
                    if (this.a.n != null) {
                        this.a.n.a(i);
                    }
                    this.a.i.setCurrentItem(i);
                    return;
                }
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class b implements OnPageChangeListener {
        final /* synthetic */ SmartTabLayout a;
        private int b;

        private b(SmartTabLayout smartTabLayout) {
            this.a = smartTabLayout;
        }

        public void onPageScrolled(int i, float f, int i2) {
            int childCount = this.a.a.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                this.a.a.a(i, f);
                this.a.a(i, f);
                if (this.a.j != null) {
                    this.a.j.onPageScrolled(i, f, i2);
                }
            }
        }

        public void onPageScrollStateChanged(int i) {
            this.b = i;
            if (this.a.j != null) {
                this.a.j.onPageScrollStateChanged(i);
            }
        }

        public void onPageSelected(int i) {
            if (this.b == 0) {
                this.a.a.a(i, 0.0f);
                this.a.a(i, 0.0f);
            }
            int childCount = this.a.a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.a.a.getChildAt(i2);
                if (i == i2) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
            if (this.a.j != null) {
                this.a.j.onPageSelected(i);
            }
        }
    }

    /* compiled from: TbsSdkJava */
    public interface c {
        void a(int i, int i2);
    }

    /* compiled from: TbsSdkJava */
    public interface d {
        void a(int i);
    }

    /* compiled from: TbsSdkJava */
    public interface g {
        View a(ViewGroup viewGroup, int i, PagerAdapter pagerAdapter);
    }

    /* compiled from: TbsSdkJava */
    private static class e implements g {
        private final LayoutInflater a;
        private final int b;
        private final int c;

        private e(Context context, int i, int i2) {
            this.a = LayoutInflater.from(context);
            this.b = i;
            this.c = i2;
        }

        public View a(ViewGroup viewGroup, int i, PagerAdapter pagerAdapter) {
            View inflate;
            TextView textView = null;
            if (this.b != -1) {
                inflate = this.a.inflate(this.b, viewGroup, false);
            } else {
                inflate = null;
            }
            if (!(this.c == -1 || inflate == null)) {
                textView = (TextView) inflate.findViewById(this.c);
            }
            if (textView == null && TextView.class.isInstance(inflate)) {
                textView = (TextView) inflate;
            }
            if (textView != null) {
                textView.setText(pagerAdapter.getPageTitle(i));
            }
            return inflate;
        }
    }

    /* compiled from: TbsSdkJava */
    public interface f {
        int a(int i);

        int b(int i);
    }

    public SmartTabLayout(Context context) {
        this(context, null);
    }

    public SmartTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartTabLayout(Context context, AttributeSet attributeSet, int i) {
        a aVar;
        super(context, attributeSet, i);
        setHorizontalScrollBarEnabled(false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        float applyDimension = TypedValue.applyDimension(2, 12.0f, displayMetrics);
        int i2 = (int) (16.0f * f);
        int i3 = (int) (0.0f * f);
        int i4 = (int) (24.0f * f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.stl_SmartTabLayout, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.stl_SmartTabLayout_stl_defaultTabBackground, -1);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.stl_SmartTabLayout_stl_defaultTabTextAllCaps, true);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.stl_SmartTabLayout_stl_defaultTabTextColor);
        applyDimension = obtainStyledAttributes.getDimension(R.styleable.stl_SmartTabLayout_stl_defaultTabTextSize, applyDimension);
        i2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.stl_SmartTabLayout_stl_defaultTabTextHorizontalPadding, i2);
        i3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.stl_SmartTabLayout_stl_defaultTabTextMinWidth, i3);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.stl_SmartTabLayout_stl_customTabTextLayoutId, -1);
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.stl_SmartTabLayout_stl_customTabTextViewId, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.stl_SmartTabLayout_stl_distributeEvenly, false);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.stl_SmartTabLayout_stl_clickable, true);
        i4 = obtainStyledAttributes.getLayoutDimension(R.styleable.stl_SmartTabLayout_stl_titleOffset, i4);
        obtainStyledAttributes.recycle();
        this.b = i4;
        this.c = resourceId;
        this.d = z;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-67108864);
        }
        this.e = colorStateList;
        this.f = applyDimension;
        this.g = i2;
        this.h = i3;
        if (z3) {
            SmartTabLayout smartTabLayout = this;
            aVar = new a();
        } else {
            aVar = null;
        }
        this.m = aVar;
        this.o = z2;
        if (resourceId2 != -1) {
            a(resourceId2, resourceId3);
        }
        this.a = new b(context, attributeSet);
        if (z2 && this.a.a()) {
            throw new UnsupportedOperationException("'distributeEvenly' and 'indicatorAlwaysInCenter' both use does not support");
        }
        setFillViewport(!this.a.a());
        addView(this.a, -1, -1);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.k != null) {
            this.k.a(i, i3);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.a.a() && this.a.getChildCount() > 0) {
            View childAt = this.a.getChildAt(0);
            View childAt2 = this.a.getChildAt(this.a.getChildCount() - 1);
            int a = ((i - c.a(childAt)) / 2) - c.i(childAt);
            int a2 = ((i - c.a(childAt2)) / 2) - c.j(childAt2);
            this.a.setMinimumWidth(this.a.getMeasuredWidth());
            ViewCompat.setPaddingRelative(this, a, getPaddingTop(), a2, getPaddingBottom());
            setClipToPadding(false);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.i != null) {
            a(this.i.getCurrentItem(), 0.0f);
        }
    }

    public void setIndicationInterpolator(a aVar) {
        this.a.a(aVar);
    }

    public void setCustomTabColorizer(f fVar) {
        this.a.a(fVar);
    }

    public void setDefaultTabTextColor(int i) {
        this.e = ColorStateList.valueOf(i);
    }

    public void setDefaultTabTextColor(ColorStateList colorStateList) {
        this.e = colorStateList;
    }

    public void setDistributeEvenly(boolean z) {
        this.o = z;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.a.a(iArr);
    }

    public void setDividerColors(int... iArr) {
        this.a.b(iArr);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.j = onPageChangeListener;
    }

    public void setOnScrollChangeListener(c cVar) {
        this.k = cVar;
    }

    public void setOnTabClickListener(d dVar) {
        this.n = dVar;
    }

    public void a(int i, int i2) {
        this.l = new e(getContext(), i, i2);
    }

    public void setCustomTabView(g gVar) {
        this.l = gVar;
    }

    public void setViewPager(ViewPager viewPager) {
        this.a.removeAllViews();
        this.i = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            viewPager.addOnPageChangeListener(new b());
            a();
        }
    }

    protected TextView a(CharSequence charSequence) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(charSequence);
        textView.setTextColor(this.e);
        textView.setTextSize(0, this.f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLayoutParams(new LayoutParams(-2, -1));
        if (this.c != -1) {
            textView.setBackgroundResource(this.c);
        } else if (VERSION.SDK_INT >= 11) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(16843534, typedValue, true);
            textView.setBackgroundResource(typedValue.resourceId);
        }
        if (VERSION.SDK_INT >= 14) {
            textView.setAllCaps(this.d);
        }
        textView.setPadding(this.g, 0, this.g, 0);
        if (this.h > 0) {
            textView.setMinWidth(this.h);
        }
        return textView;
    }

    private void a() {
        PagerAdapter adapter = this.i.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            View a;
            if (this.l == null) {
                a = a(adapter.getPageTitle(i));
            } else {
                a = this.l.a(this.a, i, adapter);
            }
            if (a == null) {
                throw new IllegalStateException("tabView is null.");
            }
            if (this.o) {
                LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            }
            if (this.m != null) {
                a.setOnClickListener(this.m);
            }
            this.a.addView(a);
            if (i == this.i.getCurrentItem()) {
                a.setSelected(true);
            }
        }
    }

    private void a(int i, float f) {
        int childCount = this.a.getChildCount();
        if (childCount != 0 && i >= 0 && i < childCount) {
            boolean l = c.l(this);
            View childAt = this.a.getChildAt(i);
            childCount = (int) (((float) (c.b(childAt) + c.k(childAt))) * f);
            View childAt2;
            if (this.a.a()) {
                if (0.0f < f && f < 1.0f) {
                    childAt2 = this.a.getChildAt(i + 1);
                    childCount = Math.round(((float) ((c.i(childAt2) + (c.b(childAt2) / 2)) + ((c.b(childAt) / 2) + c.j(childAt)))) * f);
                }
                View childAt3 = this.a.getChildAt(0);
                if (l) {
                    childCount = ((c.e(childAt) - c.j(childAt)) - childCount) - (((c.j(childAt3) + c.b(childAt3)) - (c.b(childAt) + c.j(childAt))) / 2);
                } else {
                    childCount = (childCount + (c.d(childAt) - c.i(childAt))) - (((c.i(childAt3) + c.b(childAt3)) - (c.b(childAt) + c.i(childAt))) / 2);
                }
                scrollTo(childCount, 0);
                return;
            }
            int width;
            if (this.b == -1) {
                if (0.0f < f && f < 1.0f) {
                    childAt2 = this.a.getChildAt(i + 1);
                    childCount = Math.round(((float) ((c.i(childAt2) + (c.b(childAt2) / 2)) + ((c.b(childAt) / 2) + c.j(childAt)))) * f);
                }
                width = l ? (((-c.c(childAt)) / 2) + (getWidth() / 2)) - c.f(this) : ((c.c(childAt) / 2) - (getWidth() / 2)) + c.f(this);
            } else {
                width = l ? (i > 0 || f > 0.0f) ? this.b : 0 : (i > 0 || f > 0.0f) ? -this.b : 0;
            }
            int d = c.d(childAt);
            int i2 = c.i(childAt);
            if (l) {
                childCount = ((((d + i2) - childCount) - getWidth()) + c.h(this)) + width;
            } else {
                childCount = (childCount + (d - i2)) + width;
            }
            scrollTo(childCount, 0);
        }
    }
}
