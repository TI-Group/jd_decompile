package com.jd.fridge.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;

/* compiled from: TbsSdkJava */
public class FoodsGridView extends GridView {
    public FoodsGridView(Context context) {
        super(context);
    }

    public FoodsGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FoodsGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
