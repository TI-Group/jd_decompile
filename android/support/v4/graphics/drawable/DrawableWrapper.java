package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.GROUP_ID})
/* compiled from: TbsSdkJava */
public interface DrawableWrapper {
    Drawable getWrappedDrawable();

    void setWrappedDrawable(Drawable drawable);
}
