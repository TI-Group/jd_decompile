package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.Nullable;

/* compiled from: TbsSdkJava */
public interface TintableCompoundButton {
    @Nullable
    ColorStateList getSupportButtonTintList();

    @Nullable
    Mode getSupportButtonTintMode();

    void setSupportButtonTintList(@Nullable ColorStateList colorStateList);

    void setSupportButtonTintMode(@Nullable Mode mode);
}
