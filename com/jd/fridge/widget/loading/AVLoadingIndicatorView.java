package com.jd.fridge.widget.loading;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.jd.fridge.R;
import com.jd.fridge.widget.loading.a.a;
import com.jd.fridge.widget.loading.a.aa;
import com.jd.fridge.widget.loading.a.ab;
import com.jd.fridge.widget.loading.a.ac;
import com.jd.fridge.widget.loading.a.b;
import com.jd.fridge.widget.loading.a.c;
import com.jd.fridge.widget.loading.a.d;
import com.jd.fridge.widget.loading.a.e;
import com.jd.fridge.widget.loading.a.f;
import com.jd.fridge.widget.loading.a.g;
import com.jd.fridge.widget.loading.a.h;
import com.jd.fridge.widget.loading.a.i;
import com.jd.fridge.widget.loading.a.j;
import com.jd.fridge.widget.loading.a.k;
import com.jd.fridge.widget.loading.a.l;
import com.jd.fridge.widget.loading.a.m;
import com.jd.fridge.widget.loading.a.n;
import com.jd.fridge.widget.loading.a.o;
import com.jd.fridge.widget.loading.a.p;
import com.jd.fridge.widget.loading.a.q;
import com.jd.fridge.widget.loading.a.r;
import com.jd.fridge.widget.loading.a.s;
import com.jd.fridge.widget.loading.a.t;
import com.jd.fridge.widget.loading.a.u;
import com.jd.fridge.widget.loading.a.v;
import com.jd.fridge.widget.loading.a.w;
import com.jd.fridge.widget.loading.a.x;
import com.jd.fridge.widget.loading.a.y;
import com.jd.fridge.widget.loading.a.z;

/* compiled from: TbsSdkJava */
public class AVLoadingIndicatorView extends View {
    int a;
    int b;
    Paint c;
    s d;
    private boolean e;

    public AVLoadingIndicatorView(Context context) {
        super(context);
        a(null, 0);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, i);
    }

    @TargetApi(21)
    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(attributeSet, i);
    }

    private void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AVLoadingIndicatorView);
        this.a = obtainStyledAttributes.getInt(0, 23);
        this.b = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.jd_green_1));
        obtainStyledAttributes.recycle();
        this.c = new Paint();
        this.c.setColor(this.b);
        this.c.setStyle(Style.FILL);
        this.c.setAntiAlias(true);
        b();
    }

    private void b() {
        switch (this.a) {
            case 0:
                this.d = new g();
                break;
            case 1:
                this.d = new f();
                break;
            case 2:
                this.d = new b();
                break;
            case 3:
                this.d = new d();
                break;
            case 4:
                this.d = new ab();
                break;
            case 5:
                this.d = new c();
                break;
            case 6:
                this.d = new h();
                break;
            case 7:
                this.d = new j();
                break;
            case 8:
                this.d = new t();
                break;
            case 9:
                this.d = new r();
                break;
            case 10:
                this.d = new q();
                break;
            case 11:
                this.d = new p();
                break;
            case 12:
                this.d = new k();
                break;
            case 13:
                this.d = new u();
                break;
            case 14:
                this.d = new v();
                break;
            case 15:
                this.d = new l();
                break;
            case 16:
                this.d = new i();
                break;
            case 17:
                this.d = new a();
                break;
            case 18:
                this.d = new w();
                break;
            case 19:
                this.d = new x();
                break;
            case 20:
                this.d = new m();
                break;
            case 21:
                this.d = new n();
                break;
            case 22:
                this.d = new o();
                break;
            case 23:
                this.d = new y();
                break;
            case 24:
                this.d = new ac();
                break;
            case 25:
                this.d = new z();
                break;
            case 26:
                this.d = new e();
                break;
            case 27:
                this.d = new aa();
                break;
        }
        this.d.a((View) this);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(a(a(45), i), a(a(45), i2));
    }

    private int a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        return i;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.e) {
            this.e = true;
            a();
        }
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 8 || i == 4) {
                this.d.a(s.a.END);
            } else {
                this.d.a(s.a.START);
            }
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e) {
            this.d.a(s.a.START);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.a(s.a.CANCEL);
    }

    void a(Canvas canvas) {
        this.d.a(canvas, this.c);
    }

    void a() {
        this.d.f();
    }

    private int a(int i) {
        return ((int) getContext().getResources().getDisplayMetrics().density) * i;
    }
}
