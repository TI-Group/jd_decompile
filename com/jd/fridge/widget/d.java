package com.jd.fridge.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;

/* compiled from: TbsSdkJava */
public class d {
    private a a;
    private Context b;
    private GestureDetector c;
    private Scroller d;
    private int e;
    private float f;
    private boolean g;
    private SimpleOnGestureListener h = new SimpleOnGestureListener(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.a.e = 0;
            this.a.d.fling(0, this.a.e, (int) (-f), 0, -2147483647, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, 0);
            this.a.a(0);
            return true;
        }
    };
    private final int i = 0;
    private final int j = 1;
    private Handler k = new Handler(new Callback(this) {
        final /* synthetic */ d a;

        {
            this.a = r1;
        }

        public boolean handleMessage(Message message) {
            this.a.d.computeScrollOffset();
            int currX = this.a.d.getCurrX();
            int a = this.a.e - currX;
            this.a.e = currX;
            if (a != 0) {
                this.a.a.a(a);
            }
            if (Math.abs(currX - this.a.d.getFinalX()) < 1) {
                this.a.e = this.a.d.getFinalX();
                this.a.d.forceFinished(true);
            }
            if (!this.a.d.isFinished()) {
                this.a.k.sendEmptyMessage(message.what);
            } else if (message.what == 0) {
                this.a.c();
            } else {
                this.a.a();
            }
            return true;
        }
    });

    /* compiled from: TbsSdkJava */
    public interface a {
        void a();

        void a(int i);

        void b();

        void c();
    }

    public d(Context context, a aVar) {
        this.c = new GestureDetector(context, this.h);
        this.c.setIsLongpressEnabled(false);
        this.d = new Scroller(context);
        this.d.setFriction(0.05f);
        this.a = aVar;
        this.b = context;
    }

    public void a(int i, int i2) {
        this.d.forceFinished(true);
        this.e = 0;
        this.d.startScroll(0, 0, i, 0, i2 != 0 ? i2 : 400);
        a(0);
        d();
    }

    public boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f = motionEvent.getX();
                this.d.forceFinished(true);
                b();
                break;
            case 2:
                int x = (int) (motionEvent.getX() - this.f);
                if (x != 0) {
                    d();
                    this.a.a(x);
                    this.f = motionEvent.getX();
                    break;
                }
                break;
        }
        if (!this.c.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            c();
        }
        return true;
    }

    private void a(int i) {
        b();
        this.k.sendEmptyMessage(i);
    }

    private void b() {
        this.k.removeMessages(0);
        this.k.removeMessages(1);
    }

    private void c() {
        this.a.c();
        a(1);
    }

    private void d() {
        if (!this.g) {
            this.g = true;
            this.a.a();
        }
    }

    void a() {
        if (this.g) {
            this.a.b();
            this.g = false;
        }
    }
}
