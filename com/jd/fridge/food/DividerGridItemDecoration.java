package com.jd.fridge.food;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: TbsSdkJava */
public class DividerGridItemDecoration extends ItemDecoration {
    private static final int[] a = new int[]{16843284};
    private Drawable b;

    public DividerGridItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
        this.b = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        a(canvas, recyclerView);
        b(canvas, recyclerView);
    }

    private int a(RecyclerView recyclerView) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int left = childAt.getLeft() - layoutParams.leftMargin;
            int right = (childAt.getRight() + layoutParams.rightMargin) + this.b.getIntrinsicWidth();
            int bottom = layoutParams.bottomMargin + childAt.getBottom();
            this.b.setBounds(left, bottom, right, this.b.getIntrinsicHeight() + bottom);
            this.b.draw(canvas);
        }
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int top = childAt.getTop() - layoutParams.topMargin;
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            int right = layoutParams.rightMargin + childAt.getRight();
            this.b.setBounds(right, top, this.b.getIntrinsicWidth() + right, bottom);
            this.b.draw(canvas);
        }
    }

    private boolean a(RecyclerView recyclerView, int i, int i2, int i3) {
        if ((recyclerView.getLayoutManager() instanceof GridLayoutManager) && (i + 1) % i2 == 0) {
            return true;
        }
        return false;
    }

    private boolean b(RecyclerView recyclerView, int i, int i2, int i3) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager) || i < i3 - (i3 % i2)) {
            return false;
        }
        return true;
    }

    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        int a = a(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (b(recyclerView, i, a, itemCount)) {
            rect.set(0, 0, this.b.getIntrinsicWidth(), 0);
        } else if (a(recyclerView, i, a, itemCount)) {
            rect.set(0, 0, 0, this.b.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
        }
    }
}
