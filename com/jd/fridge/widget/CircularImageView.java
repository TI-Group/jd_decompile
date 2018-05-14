package com.jd.fridge.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class CircularImageView extends ImageView {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private BitmapShader h;
    private Bitmap i;
    private Paint j;
    private Paint k;
    private Paint l;
    private ColorFilter m;

    public CircularImageView(Context context) {
        this(context, null);
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.k = new Paint();
        this.k.setAntiAlias(true);
        this.l = new Paint();
        this.l.setAntiAlias(true);
        b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircularImageView, i, 0);
        this.a = obtainStyledAttributes.getBoolean(0, false);
        this.b = obtainStyledAttributes.getBoolean(3, false);
        if (this.a) {
            setBorderWidth(obtainStyledAttributes.getDimensionPixelOffset(2, (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f)));
            setBorderColor(obtainStyledAttributes.getColor(1, -1));
        }
        if (this.b) {
            int i2 = (int) ((context.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
            setSelectorColor(obtainStyledAttributes.getColor(4, 0));
            setSelectorStrokeWidth(obtainStyledAttributes.getDimensionPixelOffset(6, i2));
            setSelectorStrokeColor(obtainStyledAttributes.getColor(5, -16776961));
        }
        if (obtainStyledAttributes.getBoolean(7, false)) {
            setShadow(true);
        }
        obtainStyledAttributes.recycle();
    }

    public void setBorderWidth(int i) {
        this.e = i;
        requestLayout();
        invalidate();
    }

    public void setBorderColor(int i) {
        if (this.k != null) {
            this.k.setColor(i);
        }
        invalidate();
    }

    public void setSelectorColor(int i) {
        this.m = new PorterDuffColorFilter(i, Mode.SRC_ATOP);
        invalidate();
    }

    public void setSelectorStrokeWidth(int i) {
        this.g = i;
        requestLayout();
        invalidate();
    }

    public void setSelectorStrokeColor(int i) {
        if (this.l != null) {
            this.l.setColor(i);
        }
        invalidate();
    }

    public void setShadow(boolean z) {
        this.d = true;
        if (z) {
            this.k.setShadowLayer(4.0f, 0.0f, 2.0f, -16777216);
            this.l.setShadowLayer(4.0f, 0.0f, 2.0f, -16777216);
            return;
        }
        this.k.setShadowLayer(0.0f, 0.0f, 2.0f, -16777216);
        this.l.setShadowLayer(0.0f, 0.0f, 2.0f, -16777216);
    }

    public void onDraw(Canvas canvas) {
        if (this.i != null && this.i.getHeight() != 0 && this.i.getWidth() != 0) {
            int i = this.f;
            this.f = canvas.getWidth();
            if (canvas.getHeight() < this.f) {
                this.f = canvas.getHeight();
            }
            if (i != this.f) {
                a();
            }
            this.j.setShader(this.h);
            int i2 = 0;
            i = this.f / 2;
            if (this.b && this.c) {
                i2 = this.g;
                i = (this.f - (i2 * 2)) / 2;
                this.j.setColorFilter(this.m);
                canvas.drawCircle((float) (i + i2), (float) (i + i2), ((float) (((this.f - (i2 * 2)) / 2) + i2)) - 4.0f, this.l);
            } else if (this.a) {
                i2 = this.e;
                i = (this.f - (i2 * 2)) / 2;
                this.j.setColorFilter(null);
                this.k.setStyle(Style.STROKE);
                this.k.setStrokeWidth((float) i2);
                canvas.drawCircle((float) (i + i2), (float) (i + i2), ((float) (((this.f - (i2 * 2)) / 2) + i2)) - 4.0f, this.k);
            } else {
                this.j.setColorFilter(null);
            }
            canvas.drawCircle((float) (i + i2), (float) (i + i2), ((float) ((this.f - (i2 * 2)) / 2)) - 4.0f, this.j);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.c = true;
                    break;
                case 1:
                case 3:
                case 4:
                case 8:
                    this.c = false;
                    break;
            }
            invalidate();
            return super.dispatchTouchEvent(motionEvent);
        }
        this.c = false;
        return super.onTouchEvent(motionEvent);
    }

    public void invalidate(Rect rect) {
        super.invalidate(rect);
        if (getDrawable() != null) {
            this.i = a(getDrawable());
            if (this.h != null || this.f > 0) {
                a();
            }
        }
    }

    public void invalidate(int i, int i2, int i3, int i4) {
        super.invalidate(i, i2, i3, i4);
        if (getDrawable() != null) {
            this.i = a(getDrawable());
            if (this.h != null || this.f > 0) {
                a();
            }
        }
    }

    public void invalidate() {
        super.invalidate();
        if (getDrawable() != null) {
            this.i = a(getDrawable());
            if (this.h != null || this.f > 0) {
                a();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(i), b(i2));
    }

    private int a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            return size;
        }
        return this.f;
    }

    private int b(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (!(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            size = this.f;
        }
        return size + 2;
    }

    @TargetApi(11)
    private void b() {
        if (VERSION.SDK_INT >= 11) {
            setLayerType(1, this.k);
        }
    }

    public Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public void a() {
        this.h = new BitmapShader(Bitmap.createScaledBitmap(this.i, this.f, this.f, false), TileMode.CLAMP, TileMode.CLAMP);
    }

    public boolean isSelected() {
        return this.c;
    }
}
