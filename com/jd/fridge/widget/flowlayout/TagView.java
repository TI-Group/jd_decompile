package com.jd.fridge.widget.flowlayout;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* compiled from: TbsSdkJava */
public class TagView extends FrameLayout implements Checkable {
    private static final int[] b = new int[]{16842912};
    private boolean a;

    public TagView(Context context) {
        super(context);
    }

    public View getTagView() {
        return getChildAt(0);
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, b);
        }
        return onCreateDrawableState;
    }

    public void setChecked(boolean z) {
        if (this.a != z) {
            this.a = z;
            refreshDrawableState();
        }
    }

    public boolean isChecked() {
        return this.a;
    }

    public void toggle() {
        setChecked(!this.a);
    }
}
