package com.jd.fridge.util;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

/* compiled from: TbsSdkJava */
public class d {
    public a a;
    private PathMeasure b;
    private float[] c = new float[2];

    /* compiled from: TbsSdkJava */
    public interface a {
        void e();
    }

    public void setOnAnimationEndListener(a aVar) {
        this.a = aVar;
    }

    public void a(Context context, final RelativeLayout relativeLayout, View view, ImageView imageView, ImageView imageView2) {
        final View imageView3 = new ImageView(context);
        imageView.setDrawingCacheEnabled(true);
        imageView3.setImageDrawable(imageView.getDrawable());
        imageView.setDrawingCacheEnabled(false);
        relativeLayout.addView(imageView3, new LayoutParams(100, 100));
        int[] iArr = new int[2];
        relativeLayout.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        imageView.getLocationInWindow(iArr2);
        int[] iArr3 = new int[2];
        imageView2.getLocationInWindow(iArr3);
        float width = (float) ((iArr2[0] - iArr[0]) + (view.getWidth() / 2));
        float height = (float) ((iArr2[1] - iArr[1]) + (view.getHeight() / 2));
        float width2 = (float) ((iArr3[0] - iArr[0]) + (imageView2.getWidth() / 5));
        float f = (float) (iArr3[1] - iArr[1]);
        Path path = new Path();
        path.moveTo(width - ((float) (imageView.getWidth() / 2)), height - ((float) (imageView.getHeight() / 2)));
        path.quadTo(width - ((float) (imageView.getWidth() * 2)), height - ((float) (imageView.getHeight() * 4)), width2, f);
        this.b = new PathMeasure(path, false);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView3, "rotation", new float[]{0.0f, 360.0f});
        ofFloat.setDuration(800);
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, this.b.getLength()});
        ofFloat2.setDuration(800);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ d b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.b.b.getPosTan(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.b.c, null);
                imageView3.setTranslationX(this.b.c[0]);
                imageView3.setTranslationY(this.b.c[1]);
            }
        });
        ofFloat2.start();
        ofFloat2.addListener(new AnimatorListener(this) {
            final /* synthetic */ d c;

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (this.c.a != null) {
                    this.c.a.e();
                }
                relativeLayout.removeView(imageView3);
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }
        });
    }
}
