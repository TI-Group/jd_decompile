package com.jd.fridge.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: TbsSdkJava */
public class RecyclerItemClickListener implements OnItemTouchListener {
    GestureDetector a;
    private a b;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(View view, int i);
    }

    public RecyclerItemClickListener(Context context, a aVar) {
        this.b = aVar;
        this.a = new GestureDetector(context, new SimpleOnGestureListener(this) {
            final /* synthetic */ RecyclerItemClickListener a;

            {
                this.a = r1;
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder == null || this.b == null || !this.a.onTouchEvent(motionEvent)) {
            return false;
        }
        this.b.a(findChildViewUnder, recyclerView.getChildPosition(findChildViewUnder));
        return true;
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }
}
