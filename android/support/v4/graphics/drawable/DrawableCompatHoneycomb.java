package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* compiled from: TbsSdkJava */
class DrawableCompatHoneycomb {
    DrawableCompatHoneycomb() {
    }

    public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        if (drawable instanceof TintAwareDrawable) {
            return drawable;
        }
        return new DrawableWrapperHoneycomb(drawable);
    }
}
