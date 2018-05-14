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
import android.view.ViewConfiguration;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class UnderlinePageIndicator extends View implements PageIndicator {
    private final Paint a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private ViewPager f;
    private OnPageChangeListener g;
    private int h;
    private int i;
    private float j;
    private int k;
    private float l;
    private int m;
    private boolean n;
    private final Runnable o;

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

    public UnderlinePageIndicator(Context context) {
        this(context, null);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiUnderlinePageIndicatorStyle);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Paint(1);
        this.l = -1.0f;
        this.m = -1;
        this.o = new Runnable(this) {
            final /* synthetic */ UnderlinePageIndicator a;

            {
                this.a = r1;
            }

            public void run() {
                if (this.a.b) {
                    int max = Math.max(this.a.a.getAlpha() - this.a.e, 0);
                    this.a.a.setAlpha(max);
                    this.a.invalidate();
                    if (max > 0) {
                        this.a.postDelayed(this, 30);
                    }
                }
            }
        };
        if (!isInEditMode()) {
            Resources resources = getResources();
            boolean z = resources.getBoolean(R.bool.default_underline_indicator_fades);
            int integer = resources.getInteger(R.integer.default_underline_indicator_fade_delay);
            int integer2 = resources.getInteger(R.integer.default_underline_indicator_fade_length);
            int color = resources.getColor(R.color.default_underline_indicator_selected_color);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlinePageIndicator, i, 0);
            setFades(obtainStyledAttributes.getBoolean(2, z));
            setSelectedColor(obtainStyledAttributes.getColor(1, color));
            setFadeDelay(obtainStyledAttributes.getInteger(3, integer));
            setFadeLength(obtainStyledAttributes.getInteger(4, integer2));
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.k = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public boolean getFades() {
        return this.b;
    }

    public void setFades(boolean z) {
        if (z != this.b) {
            this.b = z;
            if (z) {
                post(this.o);
                return;
            }
            removeCallbacks(this.o);
            this.a.setAlpha(255);
            invalidate();
        }
    }

    public int getFadeDelay() {
        return this.c;
    }

    public void setFadeDelay(int i) {
        this.c = i;
    }

    public int getFadeLength() {
        return this.d;
    }

    public void setFadeLength(int i) {
        this.d = i;
        this.e = 255 / (this.d / 30);
    }

    public int getSelectedColor() {
        return this.a.getColor();
    }

    public void setSelectedColor(int i) {
        this.a.setColor(i);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f != null) {
            int count = this.f.getAdapter().getCount();
            if (count == 0) {
                return;
            }
            if (this.i >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int paddingLeft = getPaddingLeft();
            float width = ((float) ((getWidth() - paddingLeft) - getPaddingRight())) / (((float) count) * 1.0f);
            float f = ((float) paddingLeft) + ((((float) this.i) + this.j) * width);
            float f2 = f + width;
            canvas.drawRect(f, (float) getPaddingTop(), f2, (float) (getHeight() - getPaddingBottom()), this.a);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f == null || this.f.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.m = MotionEventCompat.getPointerId(motionEvent, 0);
                this.l = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.n) {
                    int count = this.f.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.i <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.i < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.f.setCurrentItem(this.i + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f.setCurrentItem(this.i - 1);
                        return true;
                    }
                }
                this.n = false;
                this.m = -1;
                if (!this.f.isFakeDragging()) {
                    return true;
                }
                this.f.endFakeDrag();
                return true;
            case 2:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.m));
                float f3 = x - this.l;
                if (!this.n && Math.abs(f3) > ((float) this.k)) {
                    this.n = true;
                }
                if (!this.n) {
                    return true;
                }
                this.l = x;
                if (!this.f.isFakeDragging() && !this.f.beginFakeDrag()) {
                    return true;
                }
                this.f.fakeDragBy(f3);
                return true;
            case 5:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.l = MotionEventCompat.getX(motionEvent, i);
                this.m = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case 6:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.m) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.m = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.l = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.m));
                return true;
            default:
                return true;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f != viewPager) {
            if (this.f != null) {
                this.f.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f = viewPager;
            this.f.setOnPageChangeListener(this);
            invalidate();
            post(new Runnable(this) {
                final /* synthetic */ UnderlinePageIndicator a;

                {
                    this.a = r1;
                }

                public void run() {
                    if (this.a.b) {
                        this.a.post(this.a.o);
                    }
                }
            });
        }
    }

    public void setCurrentItem(int i) {
        if (this.f == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f.setCurrentItem(i);
        this.i = i;
        invalidate();
    }

    public void onPageScrollStateChanged(int i) {
        this.h = i;
        if (this.g != null) {
            this.g.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.i = i;
        this.j = f;
        if (this.b) {
            if (i2 > 0) {
                removeCallbacks(this.o);
                this.a.setAlpha(255);
            } else if (this.h != 1) {
                postDelayed(this.o, (long) this.c);
            }
        }
        invalidate();
        if (this.g != null) {
            this.g.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.h == 0) {
            this.i = i;
            this.j = 0.0f;
            invalidate();
            this.o.run();
        }
        if (this.g != null) {
            this.g.onPageSelected(i);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.g = onPageChangeListener;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.i = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.i;
        return savedState;
    }
}
