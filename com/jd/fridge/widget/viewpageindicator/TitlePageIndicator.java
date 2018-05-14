package com.jd.fridge.widget.viewpageindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
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
import java.util.ArrayList;

/* compiled from: TbsSdkJava */
public class TitlePageIndicator extends View implements PageIndicator {
    private c A;
    private ViewPager a;
    private OnPageChangeListener b;
    private int c;
    private float d;
    private int e;
    private final Paint f;
    private boolean g;
    private int h;
    private int i;
    private Path j;
    private final Rect k;
    private final Paint l;
    private a m;
    private b n;
    private final Paint o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private int w;
    private float x;
    private int y;
    private boolean z;

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

    /* compiled from: TbsSdkJava */
    public enum a {
        None(0),
        Triangle(1),
        Underline(2);
        
        public final int value;

        private a(int i) {
            this.value = i;
        }

        public static a fromValue(int i) {
            for (a aVar : values()) {
                if (aVar.value == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    /* compiled from: TbsSdkJava */
    public enum b {
        Bottom(0),
        Top(1);
        
        public final int value;

        private b(int i) {
            this.value = i;
        }

        public static b fromValue(int i) {
            for (b bVar : values()) {
                if (bVar.value == i) {
                    return bVar;
                }
            }
            return null;
        }
    }

    /* compiled from: TbsSdkJava */
    public interface c {
        void a(int i);
    }

    public TitlePageIndicator(Context context) {
        this(context, null);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiTitlePageIndicatorStyle);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = -1;
        this.f = new Paint();
        this.j = new Path();
        this.k = new Rect();
        this.l = new Paint();
        this.o = new Paint();
        this.x = -1.0f;
        this.y = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.default_title_indicator_footer_color);
            float dimension = resources.getDimension(R.dimen.default_title_indicator_footer_line_height);
            int integer = resources.getInteger(R.integer.default_title_indicator_footer_indicator_style);
            float dimension2 = resources.getDimension(R.dimen.default_title_indicator_footer_indicator_height);
            float dimension3 = resources.getDimension(R.dimen.default_title_indicator_footer_indicator_underline_padding);
            float dimension4 = resources.getDimension(R.dimen.default_title_indicator_footer_padding);
            int integer2 = resources.getInteger(R.integer.default_title_indicator_line_position);
            int color2 = resources.getColor(R.color.default_title_indicator_selected_color);
            boolean z = resources.getBoolean(R.bool.default_title_indicator_selected_bold);
            int color3 = resources.getColor(R.color.default_title_indicator_text_color);
            float dimension5 = resources.getDimension(R.dimen.default_title_indicator_text_size);
            float dimension6 = resources.getDimension(R.dimen.default_title_indicator_title_padding);
            float dimension7 = resources.getDimension(R.dimen.default_title_indicator_clip_padding);
            float dimension8 = resources.getDimension(R.dimen.default_title_indicator_top_padding);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TitlePageIndicator, i, 0);
            this.v = obtainStyledAttributes.getDimension(6, dimension);
            this.m = a.fromValue(obtainStyledAttributes.getInteger(7, integer));
            this.p = obtainStyledAttributes.getDimension(8, dimension2);
            this.q = obtainStyledAttributes.getDimension(9, dimension3);
            this.r = obtainStyledAttributes.getDimension(10, dimension4);
            this.n = b.fromValue(obtainStyledAttributes.getInteger(11, integer2));
            this.t = obtainStyledAttributes.getDimension(14, dimension8);
            this.s = obtainStyledAttributes.getDimension(13, dimension6);
            this.u = obtainStyledAttributes.getDimension(4, dimension7);
            this.i = obtainStyledAttributes.getColor(3, color2);
            this.h = obtainStyledAttributes.getColor(1, color3);
            this.g = obtainStyledAttributes.getBoolean(12, z);
            dimension8 = obtainStyledAttributes.getDimension(0, dimension5);
            color = obtainStyledAttributes.getColor(5, color);
            this.f.setTextSize(dimension8);
            this.f.setAntiAlias(true);
            this.l.setStyle(Style.FILL_AND_STROKE);
            this.l.setStrokeWidth(this.v);
            this.l.setColor(color);
            this.o.setStyle(Style.FILL_AND_STROKE);
            this.o.setColor(color);
            Drawable drawable = obtainStyledAttributes.getDrawable(2);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.w = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public int getFooterColor() {
        return this.l.getColor();
    }

    public void setFooterColor(int i) {
        this.l.setColor(i);
        this.o.setColor(i);
        invalidate();
    }

    public float getFooterLineHeight() {
        return this.v;
    }

    public void setFooterLineHeight(float f) {
        this.v = f;
        this.l.setStrokeWidth(this.v);
        invalidate();
    }

    public float getFooterIndicatorHeight() {
        return this.p;
    }

    public void setFooterIndicatorHeight(float f) {
        this.p = f;
        invalidate();
    }

    public float getFooterIndicatorPadding() {
        return this.r;
    }

    public void setFooterIndicatorPadding(float f) {
        this.r = f;
        invalidate();
    }

    public a getFooterIndicatorStyle() {
        return this.m;
    }

    public void setFooterIndicatorStyle(a aVar) {
        this.m = aVar;
        invalidate();
    }

    public b getLinePosition() {
        return this.n;
    }

    public void setLinePosition(b bVar) {
        this.n = bVar;
        invalidate();
    }

    public int getSelectedColor() {
        return this.i;
    }

    public void setSelectedColor(int i) {
        this.i = i;
        invalidate();
    }

    public void setSelectedBold(boolean z) {
        this.g = z;
        invalidate();
    }

    public int getTextColor() {
        return this.h;
    }

    public void setTextColor(int i) {
        this.f.setColor(i);
        this.h = i;
        invalidate();
    }

    public float getTextSize() {
        return this.f.getTextSize();
    }

    public void setTextSize(float f) {
        this.f.setTextSize(f);
        invalidate();
    }

    public float getTitlePadding() {
        return this.s;
    }

    public void setTitlePadding(float f) {
        this.s = f;
        invalidate();
    }

    public float getTopPadding() {
        return this.t;
    }

    public void setTopPadding(float f) {
        this.t = f;
        invalidate();
    }

    public float getClipPadding() {
        return this.u;
    }

    public void setClipPadding(float f) {
        this.u = f;
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        this.f.setTypeface(typeface);
        invalidate();
    }

    public Typeface getTypeface() {
        return this.f.getTypeface();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a != null) {
            int count = this.a.getAdapter().getCount();
            if (count != 0) {
                if (this.c == -1 && this.a != null) {
                    this.c = this.a.getCurrentItem();
                }
                ArrayList a = a(this.f);
                int size = a.size();
                if (this.c >= size) {
                    setCurrentItem(size - 1);
                    return;
                }
                int i;
                float f;
                Object obj;
                int i2;
                Rect rect;
                int i3 = count - 1;
                float width = ((float) getWidth()) / 2.0f;
                int left = getLeft();
                float f2 = ((float) left) + this.u;
                int width2 = getWidth();
                int height = getHeight();
                int i4 = left + width2;
                float f3 = ((float) i4) - this.u;
                int i5 = this.c;
                if (((double) this.d) <= 0.5d) {
                    i = i5;
                    f = this.d;
                } else {
                    i = i5 + 1;
                    f = 1.0f - this.d;
                }
                Object obj2 = f <= 0.25f ? 1 : null;
                if (f <= 0.05f) {
                    obj = 1;
                } else {
                    obj = null;
                }
                float f4 = (0.25f - f) / 0.25f;
                Rect rect2 = (Rect) a.get(this.c);
                f = (float) (rect2.right - rect2.left);
                if (((float) rect2.left) < f2) {
                    b(rect2, f, left);
                }
                if (((float) rect2.right) > f3) {
                    a(rect2, f, i4);
                }
                if (this.c > 0) {
                    for (i2 = this.c - 1; i2 >= 0; i2--) {
                        rect2 = (Rect) a.get(i2);
                        if (((float) rect2.left) < f2) {
                            int i6 = rect2.right - rect2.left;
                            b(rect2, (float) i6, left);
                            rect = (Rect) a.get(i2 + 1);
                            if (((float) rect2.right) + this.s > ((float) rect.left)) {
                                rect2.left = (int) (((float) (rect.left - i6)) - this.s);
                                rect2.right = rect2.left + i6;
                            }
                        }
                    }
                }
                if (this.c < i3) {
                    for (i2 = this.c + 1; i2 < count; i2++) {
                        rect2 = (Rect) a.get(i2);
                        if (((float) rect2.right) > f3) {
                            i3 = rect2.right - rect2.left;
                            a(rect2, (float) i3, i4);
                            rect = (Rect) a.get(i2 - 1);
                            if (((float) rect2.left) - this.s < ((float) rect.right)) {
                                rect2.left = (int) (((float) rect.right) + this.s);
                                rect2.right = rect2.left + i3;
                            }
                        }
                    }
                }
                int i7 = this.h >>> 24;
                int i8 = 0;
                while (i8 < count) {
                    Rect rect3 = (Rect) a.get(i8);
                    if ((rect3.left > left && rect3.left < i4) || (rect3.right > left && rect3.right < i4)) {
                        Object obj3 = i8 == i ? 1 : null;
                        CharSequence a2 = a(i8);
                        Paint paint = this.f;
                        boolean z = (obj3 == null || obj == null || !this.g) ? false : true;
                        paint.setFakeBoldText(z);
                        this.f.setColor(this.h);
                        if (!(obj3 == null || obj2 == null)) {
                            this.f.setAlpha(i7 - ((int) (((float) i7) * f4)));
                        }
                        if (i8 < size - 1) {
                            rect2 = (Rect) a.get(i8 + 1);
                            if (((float) rect3.right) + this.s > ((float) rect2.left)) {
                                i2 = rect3.right - rect3.left;
                                rect3.left = (int) (((float) (rect2.left - i2)) - this.s);
                                rect3.right = rect3.left + i2;
                            }
                        }
                        canvas.drawText(a2, 0, a2.length(), (float) rect3.left, this.t + ((float) rect3.bottom), this.f);
                        if (!(obj3 == null || obj2 == null)) {
                            this.f.setColor(this.i);
                            this.f.setAlpha((int) (((float) (this.i >>> 24)) * f4));
                            canvas.drawText(a2, 0, a2.length(), (float) rect3.left, this.t + ((float) rect3.bottom), this.f);
                        }
                    }
                    i8++;
                }
                f = this.v;
                float f5 = this.p;
                float f6;
                if (this.n == b.Top) {
                    i2 = 0;
                    f6 = -f5;
                    f5 = -f;
                    f = f6;
                } else {
                    i2 = height;
                    f6 = f;
                    f = f5;
                    f5 = f6;
                }
                this.j.reset();
                this.j.moveTo(0.0f, ((float) i2) - (f5 / 2.0f));
                this.j.lineTo((float) width2, ((float) i2) - (f5 / 2.0f));
                this.j.close();
                canvas.drawPath(this.j, this.l);
                float f7 = ((float) i2) - f5;
                switch (this.m) {
                    case Triangle:
                        this.j.reset();
                        this.j.moveTo(width, f7 - f);
                        this.j.lineTo(width + f, f7);
                        this.j.lineTo(width - f, f7);
                        this.j.close();
                        canvas.drawPath(this.j, this.o);
                        return;
                    case Underline:
                        if (obj2 != null && i < size) {
                            rect2 = (Rect) a.get(i);
                            float f8 = ((float) rect2.right) + this.q;
                            f5 = ((float) rect2.left) - this.q;
                            f = f7 - f;
                            this.j.reset();
                            this.j.moveTo(f5, f7);
                            this.j.lineTo(f8, f7);
                            this.j.lineTo(f8, f);
                            this.j.lineTo(f5, f);
                            this.j.close();
                            this.o.setAlpha((int) (255.0f * f4));
                            canvas.drawPath(this.j, this.o);
                            this.o.setAlpha(255);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.a == null || this.a.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.y = MotionEventCompat.getPointerId(motionEvent, 0);
                this.x = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.z) {
                    int count = this.a.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    float f3 = f - f2;
                    f2 += f;
                    f = motionEvent.getX();
                    if (f < f3) {
                        if (this.c > 0) {
                            if (action == 3) {
                                return true;
                            }
                            this.a.setCurrentItem(this.c - 1);
                            return true;
                        }
                    } else if (f > f2) {
                        if (this.c < count - 1) {
                            if (action == 3) {
                                return true;
                            }
                            this.a.setCurrentItem(this.c + 1);
                            return true;
                        }
                    } else if (!(this.A == null || action == 3)) {
                        this.A.a(this.c);
                    }
                }
                this.z = false;
                this.y = -1;
                if (!this.a.isFakeDragging()) {
                    return true;
                }
                this.a.endFakeDrag();
                return true;
            case 2:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.y));
                float f4 = x - this.x;
                if (!this.z && Math.abs(f4) > ((float) this.w)) {
                    this.z = true;
                }
                if (!this.z) {
                    return true;
                }
                this.x = x;
                if (!this.a.isFakeDragging() && !this.a.beginFakeDrag()) {
                    return true;
                }
                this.a.fakeDragBy(f4);
                return true;
            case 5:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.x = MotionEventCompat.getX(motionEvent, i);
                this.y = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case 6:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.y) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.y = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.y));
                return true;
            default:
                return true;
        }
    }

    private void a(Rect rect, float f, int i) {
        rect.right = (int) (((float) i) - this.u);
        rect.left = (int) (((float) rect.right) - f);
    }

    private void b(Rect rect, float f, int i) {
        rect.left = (int) (((float) i) + this.u);
        rect.right = (int) (this.u + f);
    }

    private ArrayList<Rect> a(Paint paint) {
        ArrayList<Rect> arrayList = new ArrayList();
        int count = this.a.getAdapter().getCount();
        int width = getWidth();
        int i = width / 2;
        for (int i2 = 0; i2 < count; i2++) {
            Rect a = a(i2, paint);
            int i3 = a.right - a.left;
            int i4 = a.bottom - a.top;
            a.left = (int) ((((float) i) - (((float) i3) / 2.0f)) + ((((float) (i2 - this.c)) - this.d) * ((float) width)));
            a.right = i3 + a.left;
            a.top = 0;
            a.bottom = i4;
            arrayList.add(a);
        }
        return arrayList;
    }

    private Rect a(int i, Paint paint) {
        Rect rect = new Rect();
        CharSequence a = a(i);
        rect.right = (int) paint.measureText(a, 0, a.length());
        rect.bottom = (int) (paint.descent() - paint.ascent());
        return rect;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.a != viewPager) {
            if (this.a != null) {
                this.a.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.a = viewPager;
            this.a.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void setOnCenterItemClickListener(c cVar) {
        this.A = cVar;
    }

    public void setCurrentItem(int i) {
        if (this.a == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.a.setCurrentItem(i);
        this.c = i;
        invalidate();
    }

    public void onPageScrollStateChanged(int i) {
        this.e = i;
        if (this.b != null) {
            this.b.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.c = i;
        this.d = f;
        invalidate();
        if (this.b != null) {
            this.b.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.e == 0) {
            this.c = i;
            invalidate();
        }
        if (this.b != null) {
            this.b.onPageSelected(i);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.b = onPageChangeListener;
    }

    protected void onMeasure(int i, int i2) {
        float size;
        int size2 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            size = (float) MeasureSpec.getSize(i2);
        } else {
            this.k.setEmpty();
            this.k.bottom = (int) (this.f.descent() - this.f.ascent());
            size = ((((float) (this.k.bottom - this.k.top)) + this.v) + this.r) + this.t;
            if (this.m != a.None) {
                size += this.p;
            }
        }
        setMeasuredDimension(size2, (int) size);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.c = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.c;
        return savedState;
    }

    private CharSequence a(int i) {
        CharSequence pageTitle = this.a.getAdapter().getPageTitle(i);
        if (pageTitle == null) {
            return "";
        }
        return pageTitle;
    }
}
