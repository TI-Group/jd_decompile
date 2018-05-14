package com.ogaclejapan.smarttablayout;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: TbsSdkJava */
public abstract class a {
    public static final a a = new b();
    public static final a b = new a();

    /* compiled from: TbsSdkJava */
    public static class a extends a {
        public float a(float f) {
            return f;
        }

        public float b(float f) {
            return f;
        }
    }

    /* compiled from: TbsSdkJava */
    public static class b extends a {
        private final Interpolator c;
        private final Interpolator d;

        public b() {
            this(3.0f);
        }

        public b(float f) {
            this.c = new AccelerateInterpolator(f);
            this.d = new DecelerateInterpolator(f);
        }

        public float a(float f) {
            return this.c.getInterpolation(f);
        }

        public float b(float f) {
            return this.d.getInterpolation(f);
        }

        public float c(float f) {
            return 1.0f / ((1.0f - a(f)) + b(f));
        }
    }

    public abstract float a(float f);

    public abstract float b(float f);

    public static a a(int i) {
        switch (i) {
            case 0:
                return a;
            case 1:
                return b;
            default:
                throw new IllegalArgumentException("Unknown id: " + i);
        }
    }

    public float c(float f) {
        return 1.0f;
    }
}
