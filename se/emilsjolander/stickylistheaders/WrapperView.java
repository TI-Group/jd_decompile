package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/* compiled from: TbsSdkJava */
public class WrapperView extends ViewGroup {
    View a;
    Drawable b;
    int c;
    View d;
    int e;

    WrapperView(Context context) {
        super(context);
    }

    public boolean a() {
        return this.d != null;
    }

    public View getItem() {
        return this.a;
    }

    public View getHeader() {
        return this.d;
    }

    void a(View view, View view2, Drawable drawable, int i) {
        if (view == null) {
            throw new NullPointerException("List view item must not be null.");
        }
        if (this.a != view) {
            removeView(this.a);
            this.a = view;
            Object parent = view.getParent();
            if (!(parent == null || parent == this || !(parent instanceof ViewGroup))) {
                ((ViewGroup) parent).removeView(view);
            }
            addView(view);
        }
        if (this.d != view2) {
            if (this.d != null) {
                removeView(this.d);
            }
            this.d = view2;
            if (view2 != null) {
                addView(view2);
            }
        }
        if (this.b != drawable) {
            this.b = drawable;
            this.c = i;
            invalidate();
        }
    }

    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int size = MeasureSpec.getSize(i);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(size, 1073741824);
        if (this.d != null) {
            LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                this.d.measure(makeMeasureSpec, MeasureSpec.makeMeasureSpec(0, 0));
            } else {
                this.d.measure(makeMeasureSpec, MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
            }
            measuredHeight = this.d.getMeasuredHeight() + 0;
        } else if (this.b == null || this.a.getVisibility() == 8) {
            measuredHeight = 0;
        } else {
            measuredHeight = this.c + 0;
        }
        LayoutParams layoutParams2 = this.a.getLayoutParams();
        if (this.a.getVisibility() == 8) {
            this.a.measure(makeMeasureSpec, MeasureSpec.makeMeasureSpec(0, 1073741824));
        } else if (layoutParams2 == null || layoutParams2.height < 0) {
            this.a.measure(makeMeasureSpec, MeasureSpec.makeMeasureSpec(0, 0));
            measuredHeight += this.a.getMeasuredHeight();
        } else {
            this.a.measure(makeMeasureSpec, MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824));
            measuredHeight += this.a.getMeasuredHeight();
        }
        setMeasuredDimension(size, measuredHeight);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        if (this.d != null) {
            int measuredHeight = this.d.getMeasuredHeight();
            this.d.layout(0, 0, width, measuredHeight);
            this.e = measuredHeight;
            this.a.layout(0, measuredHeight, width, height);
        } else if (this.b != null) {
            this.b.setBounds(0, 0, width, this.c);
            this.e = this.c;
            this.a.layout(0, this.c, width, height);
        } else {
            this.e = 0;
            this.a.layout(0, 0, width, height);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.d == null && this.b != null && this.a.getVisibility() != 8) {
            if (VERSION.SDK_INT < 11) {
                canvas.clipRect(0, 0, getWidth(), this.c);
            }
            this.b.draw(canvas);
        }
    }
}
