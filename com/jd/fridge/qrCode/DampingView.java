package com.jd.fridge.qrCode;

import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.jd.fridge.R;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;

/* compiled from: TbsSdkJava */
public class DampingView extends LinearLayout {
    private static final String a = DampingView.class.getSimpleName();
    private View b;
    private ListView c;
    private MarginLayoutParams d;
    private int e;
    private boolean f = true;
    private int g;
    private int h = 0;
    private int i = 0;
    private boolean j;
    private a k;
    private b l;
    private boolean m = true;
    private c n;

    /* compiled from: TbsSdkJava */
    class a extends AsyncTask<Void, Integer, Integer> {
        int a = 0;
        final /* synthetic */ DampingView b;

        a(DampingView dampingView) {
            this.b = dampingView;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((Void[]) objArr);
        }

        protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
            a((Integer[]) objArr);
        }

        protected Integer a(Void... voidArr) {
            int i = this.b.d.topMargin;
            while (true) {
                i += 20;
                if (i >= 0) {
                    publishProgress(new Integer[]{Integer.valueOf(0)});
                    return null;
                }
                publishProgress(new Integer[]{Integer.valueOf(i)});
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        protected void a(Integer... numArr) {
            super.onProgressUpdate(numArr);
            this.b.d.topMargin = numArr[0].intValue();
            this.b.b.setLayoutParams(this.b.d);
        }
    }

    /* compiled from: TbsSdkJava */
    class b extends AsyncTask<Void, Integer, Integer> {
        final /* synthetic */ DampingView a;

        b(DampingView dampingView) {
            this.a = dampingView;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            a((Integer) obj);
        }

        protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
            a((Integer[]) objArr);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected java.lang.Integer a(java.lang.Void... r9) {
            /*
            r8 = this;
            r7 = 2;
            r6 = 1;
            r1 = 0;
            r0 = r8.a;
            r0 = r0.e;
            if (r0 != r6) goto L_0x000b;
        L_0x000b:
            r0 = r8.a;
            r0 = r0.e;
            if (r0 != r7) goto L_0x006a;
        L_0x0013:
            r0 = r8.a;
            r0 = r0.g;
            r0 = -r0;
        L_0x001a:
            r2 = r8.a;
            r2 = r2.d;
            r2 = r2.topMargin;
        L_0x0022:
            r2 = r2 + -20;
            r3 = r8.a;
            r3 = r3.e;
            if (r3 != r6) goto L_0x003b;
        L_0x002c:
            if (r2 > 0) goto L_0x003b;
        L_0x002e:
            r2 = new java.lang.Integer[r6];
            r0 = java.lang.Integer.valueOf(r0);
            r2[r1] = r0;
            r8.publishProgress(r2);
            r0 = 0;
            return r0;
        L_0x003b:
            r3 = r8.a;
            r3 = r3.e;
            if (r3 != r7) goto L_0x0054;
        L_0x0043:
            r3 = -r2;
            r4 = r8.a;
            r4 = r4.g;
            if (r3 < r4) goto L_0x0054;
        L_0x004c:
            r2 = r8.a;
            r2 = r2.g;
            r2 = -r2;
            goto L_0x002e;
        L_0x0054:
            r3 = new java.lang.Integer[r6];
            r4 = java.lang.Integer.valueOf(r2);
            r3[r1] = r4;
            r8.publishProgress(r3);
            r4 = 5;
            java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0065 }
            goto L_0x0022;
        L_0x0065:
            r3 = move-exception;
            r3.printStackTrace();
            goto L_0x0022;
        L_0x006a:
            r0 = r1;
            goto L_0x001a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.fridge.qrCode.DampingView.b.a(java.lang.Void[]):java.lang.Integer");
        }

        protected void a(Integer... numArr) {
            super.onProgressUpdate(numArr);
            this.a.d.topMargin = numArr[0].intValue();
            this.a.b.setLayoutParams(this.a.d);
        }

        protected void a(Integer num) {
            super.onPostExecute(num);
        }
    }

    /* compiled from: TbsSdkJava */
    interface c {
        void a(boolean z);
    }

    public DampingView(Context context) {
        super(context);
    }

    public DampingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.b = LayoutInflater.from(context).inflate(R.layout.activity_qr_code, null, false);
        addView(this.b, 0);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.g = this.b.getHeight() - 50;
            this.d = (MarginLayoutParams) this.b.getLayoutParams();
            this.d.topMargin = 0;
            this.c = (ListView) getChildAt(1);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        r.a(a, "onInterceptTouchEvent " + motionEvent.getAction());
        int rawY = (int) motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                this.h = rawY;
                return false;
            case 2:
                if (!this.f || rawY - this.h <= 0) {
                    rawY -= this.h;
                    r.a(a, "onIntercept-distance: " + rawY);
                    if (rawY <= 0) {
                        return false;
                    }
                    e();
                    if (this.j) {
                        return true;
                    }
                    return false;
                }
                p.a(a, "onInterceptTouchEvent：true");
                return true;
            default:
                return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 2;
        r.a(a, "onTouchEvent...." + motionEvent.getAction());
        if (!this.f) {
            switch (motionEvent.getAction()) {
                case 1:
                    if (this.i >= 800) {
                        a();
                        this.f = true;
                        this.n.a(true);
                        break;
                    }
                    b();
                    break;
                case 2:
                    this.i = ((int) motionEvent.getRawY()) - this.h;
                    p.a(a, "下拉-distance：" + this.i);
                    this.d.topMargin = (this.i / 2) - this.g;
                    this.b.setLayoutParams(this.d);
                    break;
                default:
                    break;
            }
        }
        switch (motionEvent.getAction()) {
            case 1:
                if (this.f) {
                    if ((this.i <= 0 && this.i >= -800) || !this.m) {
                        r.a(a, "没有滑动到临界值");
                        a();
                        break;
                    }
                    b();
                    if (this.e == 2) {
                        this.f = false;
                        this.n.a(false);
                        break;
                    }
                }
                break;
            case 2:
                this.i = ((int) motionEvent.getRawY()) - this.h;
                r.a(a, "onTouchEvent-distance: " + this.i);
                if (this.i > 0) {
                    i = 1;
                }
                this.e = i;
                this.d.topMargin = this.i / 2;
                this.b.setLayoutParams(this.d);
                break;
        }
        return true;
    }

    public void setHeaderShowing(boolean z) {
        this.f = z;
    }

    public void a() {
        if (this.k != null) {
            if (this.k.getStatus() == Status.RUNNING) {
                this.k.cancel(true);
            }
            this.k = null;
        }
        this.k = new a(this);
        this.k.execute(new Void[0]);
    }

    public void b() {
        if (this.l != null) {
            if (this.l.getStatus() == Status.RUNNING) {
                this.l.cancel(true);
            }
            this.l = null;
        }
        this.l = new b(this);
        this.l.execute(new Void[0]);
    }

    public void c() {
        this.e = 2;
        b();
        this.f = false;
    }

    private void e() {
        View childAt = this.c.getChildAt(0);
        if (childAt == null) {
            this.j = true;
        } else if (this.c.getFirstVisiblePosition() == 0 && childAt.getTop() == 0) {
            this.j = true;
        } else {
            this.j = false;
        }
    }

    public boolean d() {
        return this.f;
    }

    public void setListViewStatus(boolean z) {
        this.m = z;
    }

    public void setViewChangeListener(c cVar) {
        this.n = cVar;
    }
}
