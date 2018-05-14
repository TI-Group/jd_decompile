package com.jd.fridge.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* compiled from: TbsSdkJava */
public class MySwipeRefreshLayout extends SwipeRefreshLayout {
    private float a;
    private float b;
    private float c;
    private float d;

    public MySwipeRefreshLayout(Context context) {
        super(context);
    }

    public MySwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.b = 0.0f;
                this.a = 0.0f;
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.a += Math.abs(x - this.c);
                this.b += Math.abs(y - this.d);
                this.c = x;
                this.d = y;
                if (this.a > this.b) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
