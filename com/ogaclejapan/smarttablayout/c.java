package com.ogaclejapan.smarttablayout;

import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: TbsSdkJava */
final class c {
    static int a(View view) {
        return view == null ? 0 : view.getMeasuredWidth();
    }

    static int b(View view) {
        return view == null ? 0 : view.getWidth();
    }

    static int c(View view) {
        return b(view) + k(view);
    }

    static int d(View view) {
        return a(view, false);
    }

    static int a(View view, boolean z) {
        if (view == null) {
            return 0;
        }
        return l(view) ? z ? view.getRight() - f(view) : view.getRight() : z ? view.getLeft() + f(view) : view.getLeft();
    }

    static int e(View view) {
        return b(view, false);
    }

    static int b(View view, boolean z) {
        if (view == null) {
            return 0;
        }
        return l(view) ? z ? view.getLeft() + g(view) : view.getLeft() : z ? view.getRight() - g(view) : view.getRight();
    }

    static int f(View view) {
        if (view == null) {
            return 0;
        }
        return ViewCompat.getPaddingStart(view);
    }

    static int g(View view) {
        if (view == null) {
            return 0;
        }
        return ViewCompat.getPaddingEnd(view);
    }

    static int h(View view) {
        if (view == null) {
            return 0;
        }
        return view.getPaddingLeft() + view.getPaddingRight();
    }

    static int i(View view) {
        if (view == null) {
            return 0;
        }
        return MarginLayoutParamsCompat.getMarginStart((MarginLayoutParams) view.getLayoutParams());
    }

    static int j(View view) {
        if (view == null) {
            return 0;
        }
        return MarginLayoutParamsCompat.getMarginEnd((MarginLayoutParams) view.getLayoutParams());
    }

    static int k(View view) {
        if (view == null) {
            return 0;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
    }

    static boolean l(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }
}
