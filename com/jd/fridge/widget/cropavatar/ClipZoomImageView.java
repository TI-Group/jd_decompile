package com.jd.fridge.widget.cropavatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/* compiled from: TbsSdkJava */
public class ClipZoomImageView extends ImageView implements OnScaleGestureListener, OnTouchListener, OnGlobalLayoutListener {
    public static float a = 4.0f;
    private static float b = 2.0f;
    private float c;
    private boolean d;
    private final float[] e;
    private ScaleGestureDetector f;
    private final Matrix g;
    private GestureDetector h;
    private boolean i;
    private int j;
    private float k;
    private float l;
    private boolean m;
    private int n;
    private int o;

    /* compiled from: TbsSdkJava */
    private class a implements Runnable {
        final /* synthetic */ ClipZoomImageView a;
        private float b;
        private float c;
        private float d;
        private float e;

        public a(ClipZoomImageView clipZoomImageView, float f, float f2, float f3) {
            this.a = clipZoomImageView;
            this.b = f;
            this.d = f2;
            this.e = f3;
            if (clipZoomImageView.getScale() < this.b) {
                this.c = 1.07f;
            } else {
                this.c = 0.93f;
            }
        }

        public void run() {
            this.a.g.postScale(this.c, this.c, this.d, this.e);
            this.a.c();
            this.a.setImageMatrix(this.a.g);
            float scale = this.a.getScale();
            if ((this.c <= 1.0f || scale >= this.b) && (this.c >= 1.0f || this.b >= scale)) {
                scale = this.b / scale;
                this.a.g.postScale(scale, scale, this.d, this.e);
                this.a.c();
                this.a.setImageMatrix(this.a.g);
                this.a.i = false;
                return;
            }
            this.a.postDelayed(this, 16);
        }
    }

    public ClipZoomImageView(Context context) {
        this(context, null);
    }

    public ClipZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 1.0f;
        this.d = true;
        this.e = new float[9];
        this.f = null;
        this.g = new Matrix();
        setScaleType(ScaleType.MATRIX);
        this.h = new GestureDetector(context, new SimpleOnGestureListener(this) {
            final /* synthetic */ ClipZoomImageView a;

            {
                this.a = r1;
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!this.a.i) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (this.a.getScale() < ClipZoomImageView.b) {
                        this.a.postDelayed(new a(this.a, ClipZoomImageView.b, x, y), 16);
                        this.a.i = true;
                    } else {
                        this.a.postDelayed(new a(this.a, this.a.c, x, y), 16);
                        this.a.i = true;
                    }
                }
                return true;
            }
        });
        this.f = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() != null && ((scale < a && scaleFactor > 1.0f) || (scale > this.c && scaleFactor < 1.0f))) {
            if (scaleFactor * scale < this.c) {
                scaleFactor = this.c / scale;
            }
            if (scaleFactor * scale > a) {
                scaleFactor = a / scale;
            }
            this.g.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            c();
            setImageMatrix(this.g);
        }
        return true;
    }

    private RectF getMatrixRectF() {
        Matrix matrix = this.g;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        float f = 0.0f;
        if (!this.h.onTouchEvent(motionEvent)) {
            this.f.onTouchEvent(motionEvent);
            int pointerCount = motionEvent.getPointerCount();
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i = 0; i < pointerCount; i++) {
                f3 += motionEvent.getX(i);
                f2 += motionEvent.getY(i);
            }
            f3 /= (float) pointerCount;
            f2 /= (float) pointerCount;
            if (pointerCount != this.n) {
                this.m = false;
                this.k = f3;
                this.l = f2;
            }
            this.n = pointerCount;
            switch (motionEvent.getAction()) {
                case 1:
                case 3:
                    this.n = 0;
                    break;
                case 2:
                    float f4 = f3 - this.k;
                    float f5 = f2 - this.l;
                    if (!this.m) {
                        this.m = a(f4, f5);
                    }
                    if (this.m && getDrawable() != null) {
                        RectF matrixRectF = getMatrixRectF();
                        if (matrixRectF.width() <= ((float) (getWidth() - (this.o * 2)))) {
                            f4 = 0.0f;
                        }
                        if (matrixRectF.height() > ((float) (getHeight() - (getHVerticalPadding() * 2)))) {
                            f = f5;
                        }
                        this.g.postTranslate(f4, f);
                        c();
                        setImageMatrix(this.g);
                    }
                    this.k = f3;
                    this.l = f2;
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public final float getScale() {
        this.g.getValues(this.e);
        return this.e[0];
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    public void onGlobalLayout() {
        if (this.d) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                float f;
                int width = getWidth();
                int height = getHeight();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int width2 = getWidth() - (this.o * 2);
                if (intrinsicWidth > width2 && intrinsicHeight < width2) {
                    f = (((float) width2) * 1.0f) / ((float) intrinsicHeight);
                } else if (intrinsicHeight > width2 && intrinsicWidth < width2) {
                    f = (((float) width2) * 1.0f) / ((float) intrinsicWidth);
                } else if (intrinsicWidth <= width2 || intrinsicHeight <= width2) {
                    f = 1.0f;
                } else {
                    f = Math.max((((float) width2) * 1.0f) / ((float) intrinsicWidth), (((float) width2) * 1.0f) / ((float) intrinsicHeight));
                }
                if (intrinsicWidth < width2 && intrinsicHeight > width2) {
                    f = (((float) width2) * 1.0f) / ((float) intrinsicWidth);
                } else if (intrinsicHeight < width2 && intrinsicWidth > width2) {
                    f = (((float) width2) * 1.0f) / ((float) intrinsicHeight);
                } else if (intrinsicWidth < width2 && intrinsicHeight < width2) {
                    f = Math.max((((float) width2) * 1.0f) / ((float) intrinsicWidth), (1.0f * ((float) width2)) / ((float) intrinsicHeight));
                }
                this.c = f;
                b = this.c * 2.0f;
                a = this.c * 4.0f;
                this.g.postTranslate((float) ((width - intrinsicWidth) / 2), (float) ((height - intrinsicHeight) / 2));
                this.g.postScale(f, f, (float) (getWidth() / 2), (float) (getHeight() / 2));
                setImageMatrix(this.g);
                this.d = false;
            }
        }
    }

    public Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        return Bitmap.createBitmap(createBitmap, this.o, getHVerticalPadding(), getWidth() - (this.o * 2), getWidth() - (this.o * 2));
    }

    private void c() {
        float f;
        float f2 = 0.0f;
        RectF matrixRectF = getMatrixRectF();
        int width = getWidth();
        int height = getHeight();
        if (((double) matrixRectF.width()) + 0.01d >= ((double) (width - (this.o * 2)))) {
            if (matrixRectF.left > ((float) this.o)) {
                f = (-matrixRectF.left) + ((float) this.o);
            } else {
                f = 0.0f;
            }
            if (matrixRectF.right < ((float) (width - this.o))) {
                f = ((float) (width - this.o)) - matrixRectF.right;
            }
        } else {
            f = 0.0f;
        }
        if (((double) matrixRectF.height()) + 0.01d >= ((double) (height - (getHVerticalPadding() * 2)))) {
            if (matrixRectF.top > ((float) getHVerticalPadding())) {
                f2 = (-matrixRectF.top) + ((float) getHVerticalPadding());
            }
            if (matrixRectF.bottom < ((float) (height - getHVerticalPadding()))) {
                f2 = ((float) (height - getHVerticalPadding())) - matrixRectF.bottom;
            }
        }
        this.g.postTranslate(f, f2);
    }

    private boolean a(float f, float f2) {
        return Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.j);
    }

    public void setHorizontalPadding(int i) {
        this.o = i;
    }

    private int getHVerticalPadding() {
        return (getHeight() - (getWidth() - (this.o * 2))) / 2;
    }
}
