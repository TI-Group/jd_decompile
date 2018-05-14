package com.jd.fridge.widget.viewpageindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class LinePageIndicator extends View implements PageIndicator {
    private final Paint a;
    private final Paint b;
    private ViewPager c;
    private OnPageChangeListener d;
    private int e;
    private boolean f;
    private float g;
    private float h;
    private int i;
    private float j;
    private int k;
    private boolean l;

    /* compiled from: TbsSdkJava */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return a(i);
            }

            public SavedState a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i) {
                return new SavedState[i];
            }
        };
        int a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    public LinePageIndicator(Context context) {
        this(context, null);
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiLinePageIndicatorStyle);
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint(1);
        this.b = new Paint(1);
        this.j = -1.0f;
        this.k = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_line_indicator_selected_color);
            int color2 = resources.getColor(R.color.default_line_indicator_unselected_color);
            float dimension = resources.getDimension(R.dimen.default_line_indicator_line_width);
            float dimension2 = resources.getDimension(R.dimen.default_line_indicator_gap_width);
            float dimension3 = resources.getDimension(R.dimen.default_line_indicator_stroke_width);
            boolean z = resources.getBoolean(R.bool.default_line_indicator_centered);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinePageIndicator, i, 0);
            this.f = obtainStyledAttributes.getBoolean(1, z);
            this.g = obtainStyledAttributes.getDimension(5, dimension);
            this.h = obtainStyledAttributes.getDimension(6, dimension2);
            setStrokeWidth(obtainStyledAttributes.getDimension(3, dimension3));
            this.a.setColor(obtainStyledAttributes.getColor(4, color2));
            this.b.setColor(obtainStyledAttributes.getColor(2, color));
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.i = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.f = z;
        invalidate();
    }

    public void setUnselectedColor(int i) {
        this.a.setColor(i);
        invalidate();
    }

    public int getUnselectedColor() {
        return this.a.getColor();
    }

    public void setSelectedColor(int i) {
        this.b.setColor(i);
        invalidate();
    }

    public int getSelectedColor() {
        return this.b.getColor();
    }

    public void setLineWidth(float f) {
        this.g = f;
        invalidate();
    }

    public float getLineWidth() {
        return this.g;
    }

    public void setStrokeWidth(float f) {
        this.b.setStrokeWidth(f);
        this.a.setStrokeWidth(f);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.b.getStrokeWidth();
    }

    public void setGapWidth(float f) {
        this.h = f;
        invalidate();
    }

    public float getGapWidth() {
        return this.h;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c != null) {
            int count = this.c.getAdapter().getCount();
            if (count == 0) {
                return;
            }
            if (this.e >= count) {
                setCurrentItem(count - 1);
                return;
            }
            float width;
            float f = this.g + this.h;
            float f2 = (((float) count) * f) - this.h;
            float paddingTop = (float) getPaddingTop();
            float paddingLeft = (float) getPaddingLeft();
            float paddingRight = (float) getPaddingRight();
            paddingTop += ((((float) getHeight()) - paddingTop) - ((float) getPaddingBottom())) / 2.0f;
            if (this.f) {
                width = paddingLeft + ((((((float) getWidth()) - paddingLeft) - paddingRight) / 2.0f) - (f2 / 2.0f));
            } else {
                width = paddingLeft;
            }
            int i = 0;
            while (i < count) {
                f2 = width + (((float) i) * f);
                canvas.drawLine(f2, paddingTop, f2 + this.g, paddingTop, i == this.e ? this.b : this.a);
                i++;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.c == null || this.c.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.k = MotionEventCompat.getPointerId(motionEvent, 0);
                this.j = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.l) {
                    int count = this.c.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.e <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.e < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.c.setCurrentItem(this.e + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.c.setCurrentItem(this.e - 1);
                        return true;
                    }
                }
                this.l = false;
                this.k = -1;
                if (!this.c.isFakeDragging()) {
                    return true;
                }
                this.c.endFakeDrag();
                return true;
            case 2:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.k));
                float f3 = x - this.j;
                if (!this.l && Math.abs(f3) > ((float) this.i)) {
                    this.l = true;
                }
                if (!this.l) {
                    return true;
                }
                this.j = x;
                if (!this.c.isFakeDragging() && !this.c.beginFakeDrag()) {
                    return true;
                }
                this.c.fakeDragBy(f3);
                return true;
            case 5:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.j = MotionEventCompat.getX(motionEvent, i);
                this.k = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case 6:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.k) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.k = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.j = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.k));
                return true;
            default:
                return true;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.c != viewPager) {
            if (this.c != null) {
                this.c.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.c = viewPager;
            this.c.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        if (this.c == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.c.setCurrentItem(i);
        this.e = i;
        invalidate();
    }

    public void onPageScrollStateChanged(int i) {
        if (this.d != null) {
            this.d.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.d != null) {
            this.d.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        this.e = i;
        invalidate();
        if (this.d != null) {
            this.d.onPageSelected(i);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.d = onPageChangeListener;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(i), b(i2));
    }

    private int a(int i) {
        float f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.c == null) {
            f = (float) size;
        } else {
            int count = this.c.getAdapter().getCount();
            f = (((float) (count - 1)) * this.h) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) count) * this.g));
            if (mode == Integer.MIN_VALUE) {
                f = Math.min(f, (float) size);
            }
        }
        return (int) Math.ceil((double) f);
    }

    private int b(int i) {
        float f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            f = (float) size;
        } else {
            f = (this.b.getStrokeWidth() + ((float) getPaddingTop())) + ((float) getPaddingBottom());
            if (mode == Integer.MIN_VALUE) {
                f = Math.min(f, (float) size);
            }
        }
        return (int) Math.ceil((double) f);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.e = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.e;
        return savedState;
    }
}
