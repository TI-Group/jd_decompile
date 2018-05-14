package com.jd.fridge.widget.cropavatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

/* compiled from: TbsSdkJava */
public class ClipImageLayout extends RelativeLayout {
    private ClipZoomImageView a;
    private ClipImageBorderView b;
    private int c = 0;

    public ClipImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ClipZoomImageView(context);
        this.b = new ClipImageBorderView(context);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.a, layoutParams);
        addView(this.b, layoutParams);
        this.c = (int) TypedValue.applyDimension(1, (float) this.c, getResources().getDisplayMetrics());
        this.a.setHorizontalPadding(this.c);
        this.b.setHorizontalPadding(this.c);
    }

    public void setImageDrawable(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.a.setImageBitmap(bitmap);
    }

    public void setHorizontalPadding(int i) {
        this.c = i;
    }

    public Bitmap a() {
        return this.a.a();
    }
}
