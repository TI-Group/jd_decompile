package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.util.AttributeSet;
import android.widget.LinearLayout;

@RestrictTo({Scope.GROUP_ID})
/* compiled from: TbsSdkJava */
public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {
    private OnFitSystemWindowsListener mListener;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener) {
        this.mListener = onFitSystemWindowsListener;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.mListener != null) {
            this.mListener.onFitSystemWindows(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
