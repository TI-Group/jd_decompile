package com.jd.fridge.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.jd.fridge.R;
import com.jd.fridge.util.y;

/* compiled from: TbsSdkJava */
public class ArcProgress extends View {
    private final float A;
    private float B;
    private final int C;
    protected Paint a;
    private Paint b;
    private RectF c;
    private float d;
    private float e;
    private float f;
    private String g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private float n;
    private String o;
    private float p;
    private float q;
    private final int r;
    private final int s;
    private final int t;
    private final float u;
    private final float v;
    private final float w;
    private final float x;
    private final String y;
    private final int z;

    public ArcProgress(Context context) {
        this(context, null);
    }

    public ArcProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArcProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new RectF();
        this.j = 0;
        this.o = "%";
        this.r = -1;
        this.s = Color.rgb(72, 106, 176);
        this.t = Color.rgb(66, 145, 241);
        this.z = 100;
        this.A = 288.0f;
        this.B = y.b(getResources(), 18.0f);
        this.C = (int) y.a(getResources(), 100.0f);
        this.B = y.b(getResources(), 40.0f);
        this.u = y.b(getResources(), 15.0f);
        this.v = y.a(getResources(), 4.0f);
        this.y = "%";
        this.w = y.b(getResources(), 10.0f);
        this.x = y.a(getResources(), 4.0f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ArcProgress, i, 0);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        a();
    }

    protected void a(TypedArray typedArray) {
        this.l = typedArray.getColor(5, -1);
        this.m = typedArray.getColor(4, this.s);
        this.i = typedArray.getColor(7, this.t);
        this.h = typedArray.getDimension(6, this.B);
        this.n = typedArray.getFloat(1, 288.0f);
        setMax(typedArray.getInt(3, 100));
        setProgress(typedArray.getInt(0, 0));
        this.d = typedArray.getDimension(2, this.x);
        this.e = typedArray.getDimension(9, this.u);
        this.o = TextUtils.isEmpty(typedArray.getString(8)) ? this.y : typedArray.getString(8);
        this.p = typedArray.getDimension(10, this.v);
        this.f = typedArray.getDimension(12, this.w);
        this.g = typedArray.getString(11);
    }

    protected void a() {
        this.a = new TextPaint();
        this.a.setColor(this.i);
        this.a.setTextSize(this.h);
        this.a.setAntiAlias(true);
        this.b = new Paint();
        this.b.setColor(this.s);
        this.b.setAntiAlias(true);
        this.b.setStrokeWidth(this.d);
        this.b.setStyle(Style.STROKE);
        this.b.setStrokeCap(Cap.ROUND);
    }

    public void invalidate() {
        a();
        super.invalidate();
    }

    public float getStrokeWidth() {
        return this.d;
    }

    public void setStrokeWidth(float f) {
        this.d = f;
        invalidate();
    }

    public float getSuffixTextSize() {
        return this.e;
    }

    public void setSuffixTextSize(float f) {
        this.e = f;
        invalidate();
    }

    public String getBottomText() {
        return this.g;
    }

    public void setBottomText(String str) {
        this.g = str;
        invalidate();
    }

    public int getProgress() {
        return this.j;
    }

    public void setProgress(int i) {
        this.j = i;
        if (this.j > getMax()) {
            this.j %= getMax();
        }
        invalidate();
    }

    public int getMax() {
        return this.k;
    }

    public void setMax(int i) {
        if (i > 0) {
            this.k = i;
            invalidate();
        }
    }

    public float getBottomTextSize() {
        return this.f;
    }

    public void setBottomTextSize(float f) {
        this.f = f;
        invalidate();
    }

    public float getTextSize() {
        return this.h;
    }

    public void setTextSize(float f) {
        this.h = f;
        invalidate();
    }

    public int getTextColor() {
        return this.i;
    }

    public void setTextColor(int i) {
        this.i = i;
        invalidate();
    }

    public int getFinishedStrokeColor() {
        return this.l;
    }

    public void setFinishedStrokeColor(int i) {
        this.l = i;
        invalidate();
    }

    public int getUnfinishedStrokeColor() {
        return this.m;
    }

    public void setUnfinishedStrokeColor(int i) {
        this.m = i;
        invalidate();
    }

    public float getArcAngle() {
        return this.n;
    }

    public void setArcAngle(float f) {
        this.n = f;
        invalidate();
    }

    public String getSuffixText() {
        return this.o;
    }

    public void setSuffixText(String str) {
        this.o = str;
        invalidate();
    }

    public float getSuffixTextPadding() {
        return this.p;
    }

    public void setSuffixTextPadding(float f) {
        this.p = f;
        invalidate();
    }

    protected int getSuggestedMinimumHeight() {
        return this.C;
    }

    protected int getSuggestedMinimumWidth() {
        return this.C;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(i, i2);
        int size = MeasureSpec.getSize(i);
        this.c.set(this.d / 2.0f, this.d / 2.0f, ((float) size) - (this.d / 2.0f), ((float) MeasureSpec.getSize(i2)) - (this.d / 2.0f));
        this.q = (((float) size) / 2.0f) * ((float) (1.0d - Math.cos(((double) (((360.0f - this.n) / 2.0f) / 180.0f)) * 3.141592653589793d)));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = 270.0f - (this.n / 2.0f);
        float max = (((float) this.j) / ((float) getMax())) * this.n;
        this.b.setColor(this.m);
        canvas.drawArc(this.c, f, this.n, false, this.b);
        this.b.setColor(this.l);
        canvas.drawArc(this.c, f, max, false, this.b);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putFloat("stroke_width", getStrokeWidth());
        bundle.putFloat("suffix_text_size", getSuffixTextSize());
        bundle.putFloat("suffix_text_padding", getSuffixTextPadding());
        bundle.putFloat("bottom_text_size", getBottomTextSize());
        bundle.putString("bottom_text", getBottomText());
        bundle.putFloat("text_size", getTextSize());
        bundle.putInt("text_color", getTextColor());
        bundle.putInt("progress", getProgress());
        bundle.putInt("max", getMax());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt("unfinished_stroke_color", getUnfinishedStrokeColor());
        bundle.putFloat("arc_angle", getArcAngle());
        bundle.putString("suffix", getSuffixText());
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.d = bundle.getFloat("stroke_width");
            this.e = bundle.getFloat("suffix_text_size");
            this.p = bundle.getFloat("suffix_text_padding");
            this.f = bundle.getFloat("bottom_text_size");
            this.g = bundle.getString("bottom_text");
            this.h = bundle.getFloat("text_size");
            this.i = bundle.getInt("text_color");
            setMax(bundle.getInt("max"));
            setProgress(bundle.getInt("progress"));
            this.l = bundle.getInt("finished_stroke_color");
            this.m = bundle.getInt("unfinished_stroke_color");
            this.o = bundle.getString("suffix");
            a();
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
