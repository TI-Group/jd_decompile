package com.jd.fridge.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: TbsSdkJava */
public class MenuRecommendFrameLayout extends FrameLayout {
    public MenuRecommendFrameLayout(Context context) {
        super(context);
    }

    public MenuRecommendFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) (((((float) (getMeasuredWidth() * 9)) * 1.0f) / 16.0f) + 0.5f));
    }
}
