package com.jd.fridge.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* compiled from: TbsSdkJava */
public class CustomViewPager extends ViewPager {
    private boolean a = true;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(i, z);
    }

    public void setCurrentItem(int i) {
        super.setCurrentItem(i, false);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z) {
        this.a = z;
    }
}
