package android.support.v7.widget;

import android.graphics.Rect;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;

@RestrictTo({Scope.GROUP_ID})
/* compiled from: TbsSdkJava */
public interface FitWindowsViewGroup {

    /* compiled from: TbsSdkJava */
    public interface OnFitSystemWindowsListener {
        void onFitSystemWindows(Rect rect);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener);
}
