package com.jd.fridge.widget.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.jd.fridge.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FlowLayout extends ViewGroup {
    protected List<List<View>> a;
    protected List<Integer> b;
    protected List<Integer> c;
    private int d;
    private List<View> e;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.d = obtainStyledAttributes.getInt(2, -1);
        obtainStyledAttributes.recycle();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = (childAt.getMeasuredWidth() + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin;
                measuredHeight = marginLayoutParams.bottomMargin + (childAt.getMeasuredHeight() + marginLayoutParams.topMargin);
                if (i5 + measuredWidth > (size - getPaddingLeft()) - getPaddingRight()) {
                    i3 = Math.max(i3, i5);
                    i5 = i4 + i6;
                    i6 = measuredWidth;
                    i4 = i3;
                } else {
                    i5 += measuredWidth;
                    measuredHeight = Math.max(i6, measuredHeight);
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                }
                if (i7 == childCount - 1) {
                    i4 = Math.max(i6, i4);
                    i5 += measuredHeight;
                }
            } else if (i7 == childCount - 1) {
                measuredHeight = i4 + i6;
                i4 = Math.max(i5, i3);
                int i8 = i5;
                i5 = measuredHeight;
                measuredHeight = i6;
                i6 = i8;
            } else {
                measuredHeight = i6;
                i6 = i5;
                i5 = i4;
                i4 = i3;
            }
            i7++;
            i3 = i4;
            i4 = i5;
            i5 = i6;
            i6 = measuredHeight;
        }
        if (mode == 1073741824) {
            i6 = size;
        } else {
            i6 = (getPaddingLeft() + i3) + getPaddingRight();
        }
        if (mode2 == 1073741824) {
            measuredHeight = size2;
        } else {
            measuredHeight = (getPaddingTop() + i4) + getPaddingBottom();
        }
        setMeasuredDimension(i6, measuredHeight);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int measuredWidth;
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.e.clear();
        int width = getWidth();
        int i6 = 0;
        int i7 = 0;
        int childCount = getChildCount();
        for (i5 = 0; i5 < childCount; i5++) {
            int measuredHeight;
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                measuredWidth = childAt.getMeasuredWidth();
                measuredHeight = childAt.getMeasuredHeight();
                if (((measuredWidth + i6) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.b.add(Integer.valueOf(i7));
                    this.a.add(this.e);
                    this.c.add(Integer.valueOf(i6));
                    i6 = 0;
                    i7 = (marginLayoutParams.topMargin + measuredHeight) + marginLayoutParams.bottomMargin;
                    this.e = new ArrayList();
                }
                i6 += (measuredWidth + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin;
                i7 = Math.max(i7, marginLayoutParams.bottomMargin + (marginLayoutParams.topMargin + measuredHeight));
                this.e.add(childAt);
            }
        }
        this.b.add(Integer.valueOf(i7));
        this.c.add(Integer.valueOf(i6));
        this.a.add(this.e);
        i5 = getPaddingLeft();
        i7 = getPaddingTop();
        measuredWidth = this.a.size();
        childCount = 0;
        int i8 = i7;
        i7 = i5;
        while (childCount < measuredWidth) {
            this.e = (List) this.a.get(childCount);
            measuredHeight = ((Integer) this.b.get(childCount)).intValue();
            int intValue = ((Integer) this.c.get(childCount)).intValue();
            switch (this.d) {
                case -1:
                    intValue = getPaddingLeft();
                    break;
                case 0:
                    intValue = ((width - intValue) / 2) + getPaddingLeft();
                    break;
                case 1:
                    intValue = (width - intValue) + getPaddingLeft();
                    break;
                default:
                    intValue = i7;
                    break;
            }
            i6 = 0;
            i5 = intValue;
            while (i6 < this.e.size()) {
                View view = (View) this.e.get(i6);
                if (view.getVisibility() == 8) {
                    i7 = i5;
                } else {
                    MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) view.getLayoutParams();
                    int i9 = marginLayoutParams2.leftMargin + i5;
                    int i10 = marginLayoutParams2.topMargin + i8;
                    view.layout(i9, i10, view.getMeasuredWidth() + i9, view.getMeasuredHeight() + i10);
                    i7 = i5 + ((view.getMeasuredWidth() + marginLayoutParams2.leftMargin) + marginLayoutParams2.rightMargin);
                }
                i6++;
                i5 = i7;
            }
            childCount++;
            i8 += measuredHeight;
            i7 = i5;
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-2, -2);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new MarginLayoutParams(layoutParams);
    }
}
