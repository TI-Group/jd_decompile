package com.jd.fridge.food;

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
import com.jd.fridge.util.p;

/* compiled from: TbsSdkJava */
public class NewDividerGridItemDecoration extends ItemDecoration {
    private static final String a = NewDividerGridItemDecoration.class.getSimpleName();
    private static final int[] b = new int[]{16843284};
    private Drawable c;
    private int d;
    private int e;
    private int f;
    private int g;

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        this.f = recyclerView.getChildCount();
        this.g = a(recyclerView);
        this.d = this.f <= this.g ? 1 : ((this.f - 1) / this.g) + 1;
        p.a(a, "horizontalCount: " + this.d);
        p.a(a, "childCount: " + this.f);
        this.e = this.g - 1;
        a(canvas, recyclerView);
        b(canvas, recyclerView);
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        for (int i = 0; i < this.d; i++) {
            View childAt = recyclerView.getChildAt(this.g * i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int bottom = layoutParams.bottomMargin + childAt.getBottom();
            int intrinsicHeight = this.c.getIntrinsicHeight() + bottom;
            p.a(a, "h--  " + paddingLeft + "  " + width + "  " + bottom + "  " + intrinsicHeight);
            this.c.setBounds(paddingLeft, bottom, width, intrinsicHeight);
            this.c.draw(canvas);
        }
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        for (int i = 0; i < this.e; i++) {
            View childAt = recyclerView.getChildAt(0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int right = ((childAt.getRight() + layoutParams.rightMargin) * (i + 1)) + (this.c.getIntrinsicWidth() * i);
            int intrinsicWidth = this.c.getIntrinsicWidth() + right;
            int top = childAt.getTop() - layoutParams.topMargin;
            int height = childAt.getHeight() * this.d;
            p.a(a, "v--  " + right + "  " + intrinsicWidth + "  " + top + "  " + height);
            this.c.setBounds(right, top, intrinsicWidth, height);
            this.c.draw(canvas);
        }
    }

    private int a(RecyclerView recyclerView) {
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        rect.set(0, 0, this.c.getIntrinsicWidth(), this.c.getIntrinsicHeight());
    }
}
