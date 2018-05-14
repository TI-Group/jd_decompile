package com.jd.fridge.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.jd.fridge.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class RulerWheel extends View {
    private boolean A;
    private int B;
    private Bitmap C;
    private boolean D;
    private boolean E;
    private boolean F;
    private Paint G;
    private Paint H;
    private TextPaint I;
    private float J;
    private int K;
    private int L;
    private List<String> M;
    private CharSequence[] N;
    private float O;
    private float P;
    private boolean Q;
    private a R;
    com.jd.fridge.widget.d.a a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private d z;

    /* compiled from: TbsSdkJava */
    public interface a<T> {
        void a(RulerWheel rulerWheel);

        void a(RulerWheel rulerWheel, T t, T t2);

        void b(RulerWheel rulerWheel);
    }

    public RulerWheel(Context context) {
        this(context, null);
    }

    public RulerWheel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RulerWheel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = getClass().getSimpleName();
        this.c = 1;
        this.d = 36;
        this.r = 0;
        this.s = 100;
        this.t = 0;
        this.u = 30;
        this.v = 4;
        this.w = 0;
        this.x = 5;
        this.E = false;
        this.F = false;
        this.G = new Paint(1);
        this.H = new Paint(1);
        this.I = new TextPaint(1);
        this.a = new com.jd.fridge.widget.d.a(this) {
            final /* synthetic */ RulerWheel a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.A = true;
                this.a.b();
            }

            public void a(int i) {
                this.a.c(i);
            }

            public void b() {
                if (!this.a.a()) {
                    if (this.a.A) {
                        this.a.c();
                        this.a.A = false;
                    }
                    this.a.B = 0;
                    this.a.invalidate();
                }
            }

            public void c() {
                if (this.a.a() || Math.abs(this.a.B) <= 1) {
                    return;
                }
                if (this.a.B < (-this.a.y) / 2) {
                    this.a.z.a(this.a.y + this.a.B, 0);
                } else if (this.a.B > this.a.y / 2) {
                    this.a.z.a(this.a.B - this.a.y, 0);
                } else {
                    this.a.z.a(this.a.B, 0);
                }
            }
        };
        a(context, attributeSet);
    }

    public void a(Context context, AttributeSet attributeSet) {
        int resourceId;
        this.z = new d(context, this.a);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RulerWheel);
        this.K = obtainStyledAttributes.getDimensionPixelSize(8, this.v);
        this.G.setStrokeWidth((float) this.K);
        this.i = obtainStyledAttributes.getColor(0, -16777216);
        this.l = obtainStyledAttributes.getColor(1, -16777216);
        this.n = obtainStyledAttributes.getColor(2, -16777216);
        this.d = obtainStyledAttributes.getInteger(10, this.u);
        this.o = obtainStyledAttributes.getInteger(12, this.t);
        this.p = obtainStyledAttributes.getInteger(13, this.s);
        this.q = obtainStyledAttributes.getInteger(14, this.r);
        if (this.o < this.q) {
            this.o = this.q;
        }
        this.x = a(obtainStyledAttributes.getInteger(17, 0));
        this.c = obtainStyledAttributes.getInteger(20, 1);
        if (this.c == 0) {
            resourceId = obtainStyledAttributes.getResourceId(15, R.drawable.ruler_mid_arraw);
        } else {
            resourceId = obtainStyledAttributes.getResourceId(15, R.drawable.ruler_mid_arraw_down);
        }
        this.C = BitmapFactory.decodeResource(getResources(), resourceId);
        this.y = b(obtainStyledAttributes.getDimensionPixelSize(9, this.w));
        this.D = obtainStyledAttributes.getBoolean(6, true);
        this.I.setTextSize((float) this.d);
        this.I.setTextAlign(Align.CENTER);
        this.J = Layout.getDesiredWidth("0", this.I);
        this.f = obtainStyledAttributes.getDimensionPixelSize(3, this.K);
        this.g = obtainStyledAttributes.getDimensionPixelSize(4, this.K);
        this.h = obtainStyledAttributes.getDimensionPixelSize(5, this.K);
        this.E = obtainStyledAttributes.getBoolean(7, false);
        this.F = obtainStyledAttributes.getBoolean(16, false);
        this.j = obtainStyledAttributes.getColor(11, -16777216);
        this.L = obtainStyledAttributes.getInteger(18, 0);
        if (this.L == 1) {
            this.N = obtainStyledAttributes.getTextArray(19);
            this.M = new ArrayList();
            if (this.N != null) {
                for (Object valueOf : this.N) {
                    this.M.add(String.valueOf(valueOf));
                }
                this.q = 0;
                this.p = this.N.length - 1;
            } else {
                for (resourceId = 0; resourceId < 20; resourceId++) {
                    this.M.add((resourceId * 2) + "");
                }
                this.q = 0;
                this.p = 19;
            }
        }
        this.I.setColor(this.j);
        obtainStyledAttributes.recycle();
    }

    private int a(int i) {
        if (i == 1) {
            return 2;
        }
        return 5;
    }

    private int b(int i) {
        if (i != 0) {
            return i;
        }
        if (this.x == 2) {
            this.y = 80;
        } else {
            this.y = 20;
        }
        return this.y;
    }

    private void c(int i) {
        this.B += i;
        int i2 = this.B / this.y;
        if (i2 != 0) {
            int min = Math.min(Math.max(this.q, this.o), this.p);
            this.o -= i2;
            this.B -= i2 * this.y;
            if (this.R != null) {
                this.R.a(this, ((String) this.M.get(min)) + "", this.M.get(Math.min(Math.max(this.q, this.o), this.p)));
            }
        }
        invalidate();
    }

    private boolean a() {
        int i = this.o < this.q ? (this.o - this.q) * this.y : this.o > this.p ? (this.o - this.p) * this.y : 0;
        if (i == 0) {
            return false;
        }
        this.B = 0;
        this.z.a(-i, 100);
        return true;
    }

    public int getValue() {
        return Math.min(Math.max(this.q, this.o), this.p);
    }

    protected void onMeasure(int i, int i2) {
        int height;
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i);
        if (this.c == 1) {
            if (this.C != null) {
                height = (int) (((float) ((this.C.getHeight() + getPaddingTop()) + getPaddingBottom())) + (2.0f * this.I.getTextSize()));
            } else {
                height = getPaddingTop() + getPaddingBottom();
            }
        } else if (this.C != null) {
            height = (int) getResources().getDimension(R.dimen.activity_food_add_alarm_pop_rule_height);
        } else {
            height = getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(defaultSize, height);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != 0 && i2 != 0) {
            int paddingTop = (i2 - getPaddingTop()) - getPaddingBottom();
            this.e = paddingTop / 2;
            this.k = paddingTop / 6;
            this.m = paddingTop / 7;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.m != 0) {
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            b(canvas, width, height);
            a(canvas, width, height);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        int width;
        if (this.c == 1) {
            width = (i - this.C.getWidth()) / 2;
        } else {
            width = (i - this.C.getWidth()) / 2;
        }
        canvas.drawBitmap(this.C, (float) width, (float) 0, this.H);
    }

    private void b(Canvas canvas, int i, int i2) {
        int ceil = ((int) Math.ceil((double) ((((float) i) / 2.0f) / ((float) this.y)))) + 2;
        int i3 = this.B;
        int i4 = this.o;
        if (this.c == 0) {
            a(canvas, ceil, i3, i4, i, i2);
        } else {
            b(canvas, ceil, i3, i4, i, i2);
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i; i6++) {
            float f = ((float) i2) + ((((float) i4) / 2.0f) + ((float) (this.y * i6)));
            int i7 = i3 + i6;
            if (f <= ((float) i4) && i7 >= this.q && i7 <= this.p) {
                if (i7 % this.x == 0) {
                    if (this.x == 2) {
                        this.G.setColor(this.i);
                        this.G.setStrokeWidth((float) this.f);
                        this.G.setAlpha(a(i, i6));
                        canvas.drawLine(f, (float) null, f, (float) (this.e + 0), this.G);
                        if (this.D) {
                            if (this.F) {
                                this.I.setAlpha(a(i, i6));
                            }
                            if (this.L == 0) {
                                canvas.drawText(String.valueOf(i7 / 2), f, ((float) null) - this.J, this.I);
                            } else {
                                canvas.drawText(String.valueOf(this.M.get(i7)), f, ((float) i5) - this.J, this.I);
                            }
                        }
                    } else if (this.x == 5) {
                        if (i7 % 10 == 0) {
                            this.G.setColor(this.i);
                            this.G.setStrokeWidth((float) this.f);
                            this.G.setAlpha(a(i, i6));
                            canvas.drawLine(f, (float) null, f, (float) (this.e + 0), this.G);
                            if (this.D) {
                                if (this.F) {
                                    this.I.setAlpha(a(i, i6));
                                }
                                if (this.L == 0) {
                                    canvas.drawText(String.valueOf(i7), f, ((float) null) - this.J, this.I);
                                } else {
                                    canvas.drawText(String.valueOf(this.M.get(i7)), f, ((float) i5) - this.J, this.I);
                                }
                            }
                        } else {
                            this.G.setStrokeWidth((float) this.g);
                            this.G.setColor(this.l);
                            this.G.setAlpha(a(i, i6));
                            canvas.drawLine(f, (float) null, f, (float) (this.k + 0), this.G);
                        }
                    }
                } else if (this.x == 2) {
                    this.G.setStrokeWidth((float) this.g);
                    this.G.setColor(this.l);
                    this.G.setAlpha(a(i, i6));
                    canvas.drawLine(f, (float) null, f, (float) (this.k + 0), this.G);
                } else {
                    this.G.setColor(this.n);
                    this.G.setStrokeWidth((float) this.h);
                    this.G.setAlpha(a(i, i6));
                    canvas.drawLine(f, (float) null, f, (float) (this.m + 0), this.G);
                }
            }
            f = ((float) i2) + ((((float) i4) / 2.0f) - ((float) (this.y * i6)));
            i7 = i3 - i6;
            if (f > ((float) getPaddingLeft()) && i7 >= this.q && i7 <= this.p) {
                if (i7 % this.x == 0) {
                    if (this.x == 2) {
                        this.G.setColor(this.i);
                        this.G.setStrokeWidth((float) this.f);
                        this.G.setAlpha(a(i, i6));
                        canvas.drawLine(f, (float) null, f, (float) (this.e + 0), this.G);
                        if (this.D) {
                            if (this.F) {
                                this.I.setAlpha(a(i, i6));
                            }
                            if (this.L == 0) {
                                canvas.drawText(String.valueOf(i7 / 2), f, ((float) null) - this.J, this.I);
                            } else {
                                canvas.drawText(String.valueOf(this.M.get(i7)), f, ((float) i5) - this.J, this.I);
                            }
                        }
                    } else if (this.x == 5) {
                        if (i7 % 10 == 0) {
                            this.G.setColor(this.i);
                            this.G.setStrokeWidth((float) this.f);
                            this.G.setAlpha(a(i, i6));
                            canvas.drawLine(f, (float) null, f, (float) (this.e + 0), this.G);
                            if (this.D) {
                                if (this.F) {
                                    this.I.setAlpha(a(i, i6));
                                }
                                if (this.L == 0) {
                                    canvas.drawText(String.valueOf(i7), f, ((float) null) - this.J, this.I);
                                } else {
                                    canvas.drawText(String.valueOf(this.M.get(i7)), f, ((float) i5) - this.J, this.I);
                                }
                            }
                        } else {
                            this.G.setColor(this.l);
                            this.G.setStrokeWidth((float) this.g);
                            this.G.setAlpha(a(i, i6));
                            canvas.drawLine(f, (float) null, f, (float) (this.k + 0), this.G);
                        }
                    }
                } else if (this.x == 2) {
                    this.G.setStrokeWidth((float) this.g);
                    this.G.setColor(this.l);
                    this.G.setAlpha(a(i, i6));
                    canvas.drawLine(f, (float) null, f, (float) (this.k + 0), this.G);
                } else {
                    this.G.setColor(this.n);
                    this.G.setStrokeWidth((float) this.h);
                    this.G.setAlpha(a(i, i6));
                    canvas.drawLine(f, (float) null, f, (float) (this.m + 0), this.G);
                }
            }
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3, int i4, int i5) {
        int textSize = ((int) ((((float) i5) - this.J) - this.I.getTextSize())) - getPaddingBottom();
        for (int i6 = 0; i6 < i; i6++) {
            float f = ((float) i2) + ((((float) i4) / 2.0f) + ((float) (this.y * i6)));
            int i7 = i3 + i6;
            if (f <= ((float) i4) && i7 >= this.q && i7 <= this.p) {
                if (i7 % this.x == 0) {
                    if (this.x == 2) {
                        this.G.setColor(this.i);
                        this.G.setStrokeWidth((float) this.f);
                        this.G.setAlpha(a(i, i6));
                        canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.e), this.G);
                        if (this.D) {
                            if (this.F) {
                                this.I.setAlpha(a(i, i6));
                            }
                            if (this.L == 0) {
                                canvas.drawText(String.valueOf(i7 / 2), f, ((float) i5) - this.J, this.I);
                            } else {
                                canvas.drawText(String.valueOf(this.M.get(i7)), f, ((float) i5) - this.J, this.I);
                            }
                        }
                    } else if (this.x == 5) {
                        if (i7 % 10 == 0) {
                            this.G.setColor(this.i);
                            this.G.setStrokeWidth((float) this.f);
                            this.G.setAlpha(a(i, i6));
                            canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.e), this.G);
                            if (this.D) {
                                if (this.F) {
                                    this.I.setAlpha(a(i, i6));
                                }
                                if (this.L == 0) {
                                    canvas.drawText(String.valueOf(i7), f, ((float) i5) - this.J, this.I);
                                } else {
                                    canvas.drawText(String.valueOf(this.M.get(i7)), f, ((float) i5) - this.J, this.I);
                                }
                            }
                        } else {
                            this.G.setStrokeWidth((float) this.g);
                            this.G.setColor(this.l);
                            this.G.setAlpha(a(i, i6));
                            canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.k), this.G);
                        }
                    }
                } else if (this.x == 2) {
                    this.G.setStrokeWidth((float) this.g);
                    this.G.setColor(this.l);
                    this.G.setAlpha(a(i, i6));
                    canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.k), this.G);
                } else {
                    this.G.setColor(this.n);
                    this.G.setStrokeWidth((float) this.h);
                    this.G.setAlpha(a(i, i6));
                    canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.m), this.G);
                }
            }
            f = ((float) i2) + ((((float) i4) / 2.0f) - ((float) (this.y * i6)));
            i7 = i3 - i6;
            if (f > ((float) getPaddingLeft()) && i7 >= this.q && i7 <= this.p) {
                if (i7 % this.x == 0) {
                    if (this.x == 2) {
                        this.G.setColor(this.i);
                        this.G.setStrokeWidth((float) this.f);
                        this.G.setAlpha(a(i, i6));
                        canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.e), this.G);
                        if (this.D) {
                            if (this.L == 0) {
                                if (this.F) {
                                    this.I.setAlpha(a(i, i6));
                                }
                                canvas.drawText(String.valueOf(i7 / 2), f, ((float) i5) - this.J, this.I);
                            } else {
                                canvas.drawText(String.valueOf(this.M.get(i7)), f, ((float) i5) - this.J, this.I);
                            }
                        }
                    } else if (this.x == 5) {
                        if (i7 % 10 == 0) {
                            this.G.setColor(this.i);
                            this.G.setStrokeWidth((float) this.f);
                            this.G.setAlpha(a(i, i6));
                            canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.e), this.G);
                            if (this.D) {
                                if (this.F) {
                                    this.I.setAlpha(a(i, i6));
                                }
                                if (this.L == 0) {
                                    canvas.drawText(String.valueOf(i7), f, ((float) i5) - this.J, this.I);
                                } else {
                                    canvas.drawText(String.valueOf(this.M.get(i7)), f, ((float) i5) - this.J, this.I);
                                }
                            }
                        } else {
                            this.G.setStrokeWidth((float) this.g);
                            this.G.setColor(this.l);
                            this.G.setAlpha(a(i, i6));
                            canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.k), this.G);
                        }
                    }
                } else if (this.x == 2) {
                    this.G.setStrokeWidth((float) this.g);
                    this.G.setColor(this.l);
                    this.G.setAlpha(a(i, i6));
                    canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.k), this.G);
                } else {
                    this.G.setColor(this.n);
                    this.G.setStrokeWidth((float) this.h);
                    this.G.setAlpha(a(i, i6));
                    canvas.drawLine(f, (float) textSize, f, (float) (textSize - this.m), this.G);
                }
            }
        }
    }

    private int a(int i, int i2) {
        if (this.E) {
            return (255 / i) * (i - i2);
        }
        return 255;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.O = motionEvent.getX();
                this.P = motionEvent.getY();
                break;
            case 1:
            case 3:
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                this.Q = false;
                break;
            case 2:
                if (!this.Q && Math.abs(motionEvent.getY() - this.P) < Math.abs(motionEvent.getX() - this.O)) {
                    this.Q = true;
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                }
                break;
        }
        return this.z.a(motionEvent);
    }

    public void setData(List<String> list) {
        setDataModel(1);
        this.q = 0;
        this.p = list.size() - 1;
        this.M = list;
        invalidate();
    }

    public void setDataModel(int i) {
        this.L = i;
    }

    public void setScrollingListener(a aVar) {
        this.R = aVar;
    }

    private void b() {
        if (this.R != null) {
            this.R.a(this);
        }
    }

    private void c() {
        if (this.R != null) {
            this.R.b(this);
        }
    }

    public void setSelectedValue(String str) {
        if (this.L == 1 && this.M != null && str != null) {
            int indexOf = this.M.indexOf(str);
            if (indexOf == -1) {
                indexOf = this.q;
            }
            this.o = indexOf;
        }
    }
}
