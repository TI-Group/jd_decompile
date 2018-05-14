package com.jd.fridge.widget.cropavatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* compiled from: TbsSdkJava */
public class ClipImageBorderView extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Paint f;

    public ClipImageBorderView(Context context) {
        this(context, null);
    }

    public ClipImageBorderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipImageBorderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = Color.parseColor("#FFFFFF");
        this.e = 1;
        this.e = (int) TypedValue.applyDimension(1, (float) this.e, getResources().getDisplayMetrics());
        this.f = new Paint();
        this.f.setAntiAlias(true);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c = getWidth() - (this.a * 2);
        this.b = (getHeight() - this.c) / 2;
        this.f.setColor(Color.parseColor("#aa000000"));
        this.f.setStyle(Style.FILL);
        canvas.drawRect(0.0f, 0.0f, (float) this.a, (float) getHeight(), this.f);
        canvas.drawRect((float) (getWidth() - this.a), 0.0f, (float) getWidth(), (float) getHeight(), this.f);
        canvas.drawRect((float) this.a, 0.0f, (float) (getWidth() - this.a), (float) this.b, this.f);
        canvas.drawRect((float) this.a, (float) (getHeight() - this.b), (float) (getWidth() - this.a), (float) getHeight(), this.f);
        this.f.setColor(this.d);
        this.f.setStrokeWidth((float) this.e);
        this.f.setStyle(Style.STROKE);
        canvas.drawRect((float) this.a, (float) this.b, (float) (getWidth() - this.a), (float) (getHeight() - this.b), this.f);
    }

    public void setHorizontalPadding(int i) {
        this.a = i;
    }
}
