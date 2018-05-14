package com.ogaclejapan.smarttablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout.f;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
class b extends LinearLayout {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final Paint e;
    private final RectF f = new RectF();
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final Paint n;
    private final int o;
    private final Paint p;
    private final float q;
    private final a r;
    private final boolean s;
    private int t;
    private int u;
    private float v;
    private a w;
    private f x;

    /* compiled from: TbsSdkJava */
    private static class a implements f {
        private int[] a;
        private int[] b;

        private a() {
        }

        public final int a(int i) {
            return this.a[i % this.a.length];
        }

        public final int b(int i) {
            return this.b[i % this.b.length];
        }

        void a(int... iArr) {
            this.a = iArr;
        }

        void b(int... iArr) {
            this.b = iArr;
        }
    }

    b(Context context, AttributeSet attributeSet) {
        super(context);
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i = typedValue.data;
        int i2 = (int) (8.0f * f);
        float f2 = 0.0f * f;
        int a = a(i, (byte) ReplyCode.reply0x26);
        int i3 = (int) (0.0f * f);
        int a2 = a(i, ReplyCode.reply0x26);
        int i4 = (int) (2.0f * f);
        i = a(i, ReplyCode.reply0x20);
        int i5 = (int) (f * 1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.stl_SmartTabLayout);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.stl_SmartTabLayout_stl_indicatorAlwaysInCenter, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.stl_SmartTabLayout_stl_indicatorWithoutPadding, false);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.stl_SmartTabLayout_stl_indicatorInFront, false);
        int i6 = obtainStyledAttributes.getInt(R.styleable.stl_SmartTabLayout_stl_indicatorInterpolation, 0);
        int i7 = obtainStyledAttributes.getInt(R.styleable.stl_SmartTabLayout_stl_indicatorGravity, 0);
        int color = obtainStyledAttributes.getColor(R.styleable.stl_SmartTabLayout_stl_indicatorColor, -13388315);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.stl_SmartTabLayout_stl_indicatorColors, -1);
        i2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.stl_SmartTabLayout_stl_indicatorThickness, i2);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.stl_SmartTabLayout_stl_indicatorWidth, -1);
        f2 = obtainStyledAttributes.getDimension(R.styleable.stl_SmartTabLayout_stl_indicatorCornerRadius, f2);
        a = obtainStyledAttributes.getColor(R.styleable.stl_SmartTabLayout_stl_overlineColor, a);
        i3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.stl_SmartTabLayout_stl_overlineThickness, i3);
        a2 = obtainStyledAttributes.getColor(R.styleable.stl_SmartTabLayout_stl_underlineColor, a2);
        i4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.stl_SmartTabLayout_stl_underlineThickness, i4);
        int color2 = obtainStyledAttributes.getColor(R.styleable.stl_SmartTabLayout_stl_dividerColor, i);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.stl_SmartTabLayout_stl_dividerColors, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.stl_SmartTabLayout_stl_dividerThickness, i5);
        boolean z4 = obtainStyledAttributes.getBoolean(R.styleable.stl_SmartTabLayout_stl_drawDecorationAfterTab, false);
        obtainStyledAttributes.recycle();
        int[] intArray = resourceId == -1 ? new int[]{color} : getResources().getIntArray(resourceId);
        int[] intArray2 = resourceId2 == -1 ? new int[]{color2} : getResources().getIntArray(resourceId2);
        this.r = new a();
        this.r.a(intArray);
        this.r.b(intArray2);
        this.a = i3;
        this.b = a;
        this.c = i4;
        this.d = a2;
        this.e = new Paint(1);
        this.h = z;
        this.g = z2;
        this.i = z3;
        this.j = i2;
        this.k = layoutDimension;
        this.n = new Paint(1);
        this.m = f2;
        this.l = i7;
        this.q = 0.5f;
        this.p = new Paint(1);
        this.p.setStrokeWidth((float) dimensionPixelSize);
        this.o = dimensionPixelSize;
        this.s = z4;
        this.w = a.a(i6);
    }

    private static int a(int i, byte b) {
        return Color.argb(b, Color.red(i), Color.green(i), Color.blue(i));
    }

    private static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((((float) Color.red(i)) * f) + (((float) Color.red(i2)) * f2)), (int) ((((float) Color.green(i)) * f) + (((float) Color.green(i2)) * f2)), (int) ((f2 * ((float) Color.blue(i2))) + (((float) Color.blue(i)) * f)));
    }

    void a(a aVar) {
        this.w = aVar;
        invalidate();
    }

    void a(f fVar) {
        this.x = fVar;
        invalidate();
    }

    void a(int... iArr) {
        this.x = null;
        this.r.a(iArr);
        invalidate();
    }

    void b(int... iArr) {
        this.x = null;
        this.r.b(iArr);
        invalidate();
    }

    void a(int i, float f) {
        this.u = i;
        this.v = f;
        if (f == 0.0f && this.t != this.u) {
            this.t = this.u;
        }
        invalidate();
    }

    boolean a() {
        return this.h;
    }

    f b() {
        return this.x != null ? this.x : this.r;
    }

    protected void onDraw(Canvas canvas) {
        if (!this.s) {
            a(canvas);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.s) {
            a(canvas);
        }
    }

    private void a(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        int childCount = getChildCount();
        f b = b();
        boolean l = c.l(this);
        if (this.i) {
            b(canvas, 0, width);
            a(canvas, 0, width, height);
        }
        if (childCount > 0) {
            int i;
            int i2;
            View childAt = getChildAt(this.u);
            int a = c.a(childAt, this.g);
            int b2 = c.b(childAt, this.g);
            if (!l) {
                int i3 = b2;
                b2 = a;
                a = i3;
            }
            int a2 = b.a(this.u);
            float f = (float) this.j;
            if (this.v <= 0.0f || this.u >= getChildCount() - 1) {
                i = a2;
                i2 = a;
                a2 = b2;
            } else {
                i2 = b.a(this.u + 1);
                if (a2 != i2) {
                    a2 = a(i2, a2, this.v);
                }
                float a3 = this.w.a(this.v);
                float b3 = this.w.b(this.v);
                float c = this.w.c(this.v);
                View childAt2 = getChildAt(this.u + 1);
                int a4 = c.a(childAt2, this.g);
                int b4 = c.b(childAt2, this.g);
                if (l) {
                    b2 = (int) ((((float) b2) * (1.0f - b3)) + (((float) b4) * b3));
                    a = (int) ((((float) a) * (1.0f - a3)) + (((float) a4) * a3));
                } else {
                    b2 = (int) ((((float) b2) * (1.0f - a3)) + (((float) a4) * a3));
                    a = (int) ((((float) a) * (1.0f - b3)) + (((float) b4) * b3));
                }
                f *= c;
                i = a2;
                i2 = a;
                a2 = b2;
            }
            a(canvas, a2, i2, height, f, i);
        }
        if (!this.i) {
            b(canvas, 0, width);
            a(canvas, 0, getWidth(), height);
        }
        a(canvas, height, childCount);
    }

    private void a(Canvas canvas, int i, int i2) {
        if (this.o > 0) {
            int min = (int) (Math.min(Math.max(0.0f, this.q), 1.0f) * ((float) i));
            f b = b();
            int i3 = (i - min) / 2;
            int i4 = i3 + min;
            boolean l = c.l(this);
            for (int i5 = 0; i5 < i2 - 1; i5++) {
                View childAt = getChildAt(i5);
                int e = c.e(childAt);
                min = c.j(childAt);
                min = l ? e - min : min + e;
                this.p.setColor(b.b(i5));
                canvas.drawLine((float) min, (float) i3, (float) min, (float) i4, this.p);
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3, float f, int i4) {
        if (this.j > 0 && this.k != 0) {
            float f2;
            float f3;
            switch (this.l) {
                case 1:
                    f2 = ((float) this.j) / 2.0f;
                    f3 = f2 - (f / 2.0f);
                    f2 += f / 2.0f;
                    break;
                case 2:
                    f2 = ((float) i3) / 2.0f;
                    f3 = f2 - (f / 2.0f);
                    f2 += f / 2.0f;
                    break;
                default:
                    f2 = ((float) i3) - (((float) this.j) / 2.0f);
                    f3 = f2 - (f / 2.0f);
                    f2 += f / 2.0f;
                    break;
            }
            this.n.setColor(i4);
            if (this.k == -1) {
                this.f.set((float) i, f3, (float) i2, f2);
            } else {
                float abs = ((float) (Math.abs(i - i2) - this.k)) / 2.0f;
                this.f.set(((float) i) + abs, f3, ((float) i2) - abs, f2);
            }
            if (this.m > 0.0f) {
                canvas.drawRoundRect(this.f, this.m, this.m, this.n);
            } else {
                canvas.drawRect(this.f, this.n);
            }
        }
    }

    private void b(Canvas canvas, int i, int i2) {
        if (this.a > 0) {
            this.e.setColor(this.b);
            canvas.drawRect((float) i, 0.0f, (float) i2, (float) this.a, this.e);
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.c > 0) {
            this.e.setColor(this.d);
            canvas.drawRect((float) i, (float) (i3 - this.c), (float) i2, (float) i3, this.e);
        }
    }
}
