package com.jd.fridge.qrCode;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.jd.fridge.util.p;
import com.jd.fridge.util.u;
import com.jd.fridge.util.z;

/* compiled from: TbsSdkJava */
public class NewDampingView extends LinearLayout {
    private static final String a = NewDampingView.class.getSimpleName();
    private int b = -1;
    private int c = 0;
    private int d = 0;
    private View e;
    private View f;
    private boolean g = true;
    private boolean h = true;
    private int i;
    private MarginLayoutParams j;
    private int k;
    private a l;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(boolean z);
    }

    /* compiled from: TbsSdkJava */
    class b implements Runnable {
        final /* synthetic */ NewDampingView a;
        private final Interpolator b;
        private final int c;
        private final int d;
        private final long e;
        private long f = -1;
        private int g = -1;

        public b(NewDampingView newDampingView, int i, int i2, long j) {
            this.a = newDampingView;
            this.d = i;
            this.c = i2;
            this.e = j;
            this.b = new DecelerateInterpolator();
        }

        public void run() {
            if (this.f == -1) {
                this.f = System.currentTimeMillis();
            } else {
                float f = (float) (this.d - this.c);
                this.g = this.d - Math.round(this.b.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.f) * 1000) / this.e, 1000), 0)) / 1000.0f) * f);
                this.a.scrollTo(0, this.g);
            }
            if (this.c != this.g) {
                z.a(this.a, this);
            }
        }
    }

    public NewDampingView(Context context) {
        super(context);
    }

    public NewDampingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.i = u.a(context);
        this.k = (int) u.a(getResources(), 150.0f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.e = getChildAt(0);
        ((MarginLayoutParams) this.e.getLayoutParams()).height = this.i - this.k;
        this.f = getChildAt(1);
        this.j = (MarginLayoutParams) this.f.getLayoutParams();
        this.j.topMargin = 60;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.c = y;
                p.a(a, "onInterceptTouchEvent ACTION_DOWN");
                return false;
            case 1:
                p.a(a, "onInterceptTouchEvent ACTION_UP");
                return false;
            case 2:
                y = this.c - y;
                p.a(a, "onInterceptTouchEvent move: " + y);
                if (Math.abs(y) <= 10) {
                    return false;
                }
                if (this.g) {
                    return true;
                }
                if (!d() || y >= 0) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    private boolean c() {
        if (this.f instanceof AbsListView) {
            return true;
        }
        return false;
    }

    private boolean d() {
        if (!c()) {
            return true;
        }
        ListView listView = (ListView) this.f;
        Adapter adapter = listView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            p.a(a, "adapter == null");
            return true;
        }
        if (listView.getFirstVisiblePosition() <= 1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                return childAt.getTop() == 0;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 1:
                if (this.b != -1) {
                    if (Math.abs(this.d) < 500 || !f()) {
                        e();
                    } else if (this.b == 1 && this.g) {
                        e();
                    } else if (this.b != 0 || this.g) {
                        a();
                    } else {
                        e();
                    }
                    this.b = -1;
                    break;
                }
                break;
            case 2:
                this.d = this.c - y;
                p.a(a, " move: " + this.d + "  scrollY: " + getScrollY());
                if (this.d > 0) {
                    this.b = 0;
                } else if (this.d < 0) {
                    this.b = 1;
                }
                scrollTo(0, (this.g ? 0 : -60) + (getScrollStartY() + (this.d / 2)));
                break;
        }
        return true;
    }

    private int getScrollStartY() {
        return this.g ? 0 : this.e.getTop() + this.e.getHeight();
    }

    private void e() {
        post(new b(this, getScrollY(), this.g ? 0 : (this.e.getTop() + this.e.getHeight()) - 60, 200));
    }

    public void a() {
        boolean z = false;
        post(new b(this, getScrollY(), this.g ? (this.e.getTop() + this.e.getHeight()) - 60 : 0, 200));
        if (!this.g) {
            z = true;
        }
        this.g = z;
        if (this.l != null) {
            this.l.a(this.g);
        }
    }

    private boolean f() {
        return this.h;
    }

    public void setEnableScrollUp(boolean z) {
        this.h = z;
    }

    public boolean b() {
        return this.g;
    }

    public void setScrollFinishListener(a aVar) {
        this.l = aVar;
    }
}
