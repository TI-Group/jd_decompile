package com.jd.fridge.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.jd.fridge.R;
import com.jd.fridge.util.h;

/* compiled from: TbsSdkJava */
public class GoodsGridView extends GridView {
    public GoodsGridView(Context context) {
        super(context);
    }

    public GoodsGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GoodsGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    protected void dispatchDraw(Canvas canvas) {
        int width;
        int i = 0;
        super.dispatchDraw(canvas);
        View childAt = getChildAt(0);
        if (childAt != null) {
            width = getWidth() / childAt.getWidth();
        } else {
            width = 4;
        }
        int childCount = getChildCount();
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth((float) h.a(getContext(), 4.0f));
        paint.setColor(getContext().getResources().getColor(R.color.jd_gray_line_color2));
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = getChildAt(i2);
            if ((i2 + 1) % width == 0) {
                canvas.drawLine((float) childAt2.getLeft(), (float) childAt2.getBottom(), (float) childAt2.getRight(), (float) childAt2.getBottom(), paint);
            } else if (i2 + 1 > childCount - (childCount % width)) {
                canvas.drawLine((float) childAt2.getRight(), (float) childAt2.getTop(), (float) childAt2.getRight(), (float) childAt2.getBottom(), paint);
            } else {
                canvas.drawLine((float) childAt2.getRight(), (float) childAt2.getTop(), (float) childAt2.getRight(), (float) childAt2.getBottom(), paint);
                canvas.drawLine((float) childAt2.getLeft(), (float) childAt2.getBottom(), (float) childAt2.getRight(), (float) childAt2.getBottom(), paint);
            }
        }
        if (childCount % width != 0) {
            while (i < width - (childCount % width)) {
                View childAt3 = getChildAt(childCount - 1);
                canvas.drawLine((float) (childAt3.getRight() + (childAt3.getWidth() * i)), (float) childAt3.getTop(), (float) (childAt3.getRight() + (childAt3.getWidth() * i)), (float) childAt3.getBottom(), paint);
                i++;
            }
        }
    }
}
