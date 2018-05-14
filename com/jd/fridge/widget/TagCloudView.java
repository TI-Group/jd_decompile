package com.jd.fridge.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.jd.fridge.R;
import java.util.List;

/* compiled from: TbsSdkJava */
public class TagCloudView extends ViewGroup {
    private static final String a = TagCloudView.class.getSimpleName();
    private List<String> b;
    private LayoutInflater c;
    private a d;
    private int e;
    private int f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private String s;
    private int t;
    private int u;
    private ImageView v;
    private int w;
    private int x;
    private TextView y;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(int i);
    }

    public TagCloudView(Context context) {
        this(context, null);
    }

    public TagCloudView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagCloudView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.v = null;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.c = LayoutInflater.from(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TagCloudView, i, i);
        this.g = (float) obtainStyledAttributes.getInteger(3, 14);
        this.h = obtainStyledAttributes.getColor(1, -1);
        this.i = obtainStyledAttributes.getResourceId(0, R.drawable.tag_background);
        this.j = obtainStyledAttributes.getDimensionPixelSize(2, 6);
        this.k = obtainStyledAttributes.getDimensionPixelSize(6, 8);
        this.l = obtainStyledAttributes.getDimensionPixelSize(5, 5);
        this.r = obtainStyledAttributes.getBoolean(12, true);
        this.n = obtainStyledAttributes.getResourceId(11, R.drawable.arrow_right);
        this.o = obtainStyledAttributes.getBoolean(7, false);
        this.p = obtainStyledAttributes.getBoolean(9, true);
        this.q = obtainStyledAttributes.getBoolean(8, true);
        this.s = obtainStyledAttributes.getString(10);
        this.m = obtainStyledAttributes.getResourceId(13, R.layout.item_tag);
        obtainStyledAttributes.recycle();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (!this.r && this.o) || super.onInterceptTouchEvent(motionEvent);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        int b;
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i2);
        this.e = MeasureSpec.getSize(i);
        this.f = MeasureSpec.getSize(i2);
        measureChildren(i, i2);
        a(i, i2);
        int i3 = this.l;
        if (this.o) {
            b = b(0, i3);
        } else {
            b = c(0, i3);
        }
        i3 = this.e;
        if (mode == 1073741824) {
            b = this.f;
        }
        setMeasuredDimension(i3, b);
    }

    private void a(int i, int i2) {
        if (this.o) {
            if (this.p) {
                this.v = new ImageView(getContext());
                this.v.setImageResource(this.n);
                this.v.setLayoutParams(new LayoutParams(-2, -2));
                this.v.setScaleType(ScaleType.CENTER_INSIDE);
                measureChild(this.v, i, i2);
                this.t = this.v.getMeasuredWidth();
                this.u = this.v.getMeasuredHeight();
                addView(this.v);
            }
            if (this.q) {
                this.y = (TextView) this.c.inflate(this.m, null);
                if (this.m == R.layout.item_tag) {
                    this.y.setBackgroundResource(this.i);
                    this.y.setTextSize(2, this.g);
                    this.y.setTextColor(this.h);
                }
                this.y.setLayoutParams(new LayoutParams(-2, -2));
                TextView textView = this.y;
                CharSequence charSequence = (this.s == null || this.s.equals("")) ? " … " : this.s;
                textView.setText(charSequence);
                measureChild(this.y, i, i2);
                this.x = this.y.getMeasuredHeight();
                this.w = this.y.getMeasuredWidth();
                addView(this.y);
                this.y.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ TagCloudView a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        if (this.a.d != null) {
                            this.a.d.a(-1);
                        }
                    }
                });
            }
        }
    }

    private int b(int i, int i2) {
        int i3 = this.j + i;
        if (getTextTotalWidth() < this.e - this.t) {
            this.y = null;
            this.w = 0;
        }
        int i4 = i3;
        i3 = 0;
        while (i3 < getChildCount()) {
            int i5;
            View childAt = getChildAt(i3);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (i3 == 0) {
                i5 = i4 + measuredWidth;
                i2 = measuredHeight + this.j;
            } else {
                i5 = (this.k + measuredWidth) + i4;
            }
            if (childAt.getTag() != null && ((Integer) childAt.getTag()).intValue() == 1) {
                if (((((this.k + i5) + this.j) + this.j) + this.w) + this.t >= this.e) {
                    i4 = i5 - (this.j + measuredWidth);
                    break;
                }
                childAt.layout((i5 - measuredWidth) + this.l, i2 - measuredHeight, this.l + i5, i2);
            }
            i3++;
            i4 = i5;
        }
        if (this.y != null) {
            this.y.layout((this.j + i4) + this.l, i2 - this.x, ((i4 + this.j) + this.l) + this.w, i2);
        }
        i4 = this.j + i2;
        if (this.v != null) {
            this.v.layout((this.e - this.t) - this.j, (i4 - this.u) / 2, this.e - this.j, ((i4 - this.u) / 2) + this.u);
        }
        return i4;
    }

    private int c(int i, int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i += this.j + measuredWidth;
            if (i3 == 0) {
                i2 = measuredHeight + this.j;
            }
            if ((this.k + i) + this.j > this.e) {
                int i4 = this.j;
                i2 += this.l + measuredHeight;
                childAt.layout(this.k + i4, i2 - measuredHeight, (i4 + measuredWidth) + this.k, i2);
                i = i4 + measuredWidth;
            } else {
                childAt.layout((i - measuredWidth) + this.k, i2 - measuredHeight, this.k + i, i2);
            }
        }
        return this.j + i2;
    }

    private int getTextTotalWidth() {
        if (getChildCount() == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getTag() != null && ((Integer) childAt.getTag()).intValue() == 1) {
                i += childAt.getMeasuredWidth() + this.j;
            }
        }
        return (this.k * 2) + i;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public void setTags(List<String> list) {
        this.b = list;
        removeAllViews();
        if (this.b != null && this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                TextView textView = (TextView) this.c.inflate(this.m, null);
                if (this.m == R.layout.item_tag) {
                    textView.setBackgroundResource(this.i);
                    textView.setTextSize(2, this.g);
                    textView.setTextColor(this.h);
                }
                textView.setLayoutParams(new LayoutParams(-2, -2));
                CharSequence charSequence = (String) this.b.get(i);
                if (charSequence.length() > 7) {
                    String substring = charSequence.substring(0, 3);
                    charSequence = substring + "..." + charSequence.substring(charSequence.length() - 3, charSequence.length());
                }
                textView.setText(charSequence);
                textView.setTag(Integer.valueOf(1));
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ TagCloudView b;

                    public void onClick(View view) {
                        if (this.b.d != null) {
                            this.b.d.a(i);
                        }
                    }
                });
                addView(textView);
            }
        }
        postInvalidate();
    }

    public void setOnTagClickListener(a aVar) {
        this.d = aVar;
    }
}
