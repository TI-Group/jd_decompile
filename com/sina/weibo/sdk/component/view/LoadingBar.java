package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: TbsSdkJava */
public class LoadingBar extends TextView {
    private int a;
    private int b;
    private Paint c;
    private Handler d;
    private Runnable e = new Runnable(this) {
        final /* synthetic */ LoadingBar a;

        {
            this.a = r1;
        }

        public void run() {
            LoadingBar loadingBar = this.a;
            loadingBar.a = loadingBar.a + 1;
            this.a.a(this.a.a);
        }
    };

    public LoadingBar(Context context) {
        super(context);
        a(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public LoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.d = new Handler();
        this.c = new Paint();
        a();
    }

    public void a() {
        this.b = -11693826;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c.setColor(this.b);
        canvas.drawRect(getRect(), this.c);
    }

    private Rect getRect() {
        return new Rect(0, 0, (getLeft() + (((getRight() - getLeft()) * this.a) / 100)) - getLeft(), getBottom() - getTop());
    }

    public void a(int i) {
        if (i < 7) {
            this.d.postDelayed(this.e, 70);
        } else {
            this.d.removeCallbacks(this.e);
            this.a = i;
        }
        invalidate();
    }
}
