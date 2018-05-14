package com.jd.fridge.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class DividerItemDecoration extends ItemDecoration {
    private static final int[] a = new int[]{R.attr.recyclerviewDiv};
    private Drawable b;
    private int c;

    public DividerItemDecoration(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
        this.b = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        a(i);
    }

    public void a(int i) {
        if (i == 0 || i == 1) {
            this.c = i;
            return;
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        if (this.c == 1) {
            a(canvas, recyclerView);
        } else {
            b(canvas, recyclerView);
        }
    }

    public void a(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int bottom = (layoutParams.bottomMargin + childAt.getBottom()) + Math.round(ViewCompat.getTranslationY(childAt));
            this.b.setBounds(paddingLeft, bottom, width, this.b.getIntrinsicHeight() + bottom);
            this.b.draw(canvas);
        }
    }

    public void b(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int right = (layoutParams.rightMargin + childAt.getRight()) + Math.round(ViewCompat.getTranslationX(childAt));
            this.b.setBounds(right, paddingTop, this.b.getIntrinsicHeight() + right, height);
            this.b.draw(canvas);
        }
    }

    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        if (this.c == 1) {
            rect.set(0, 0, 0, this.b.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.b.getIntrinsicWidth(), 0);
        }
    }
}
