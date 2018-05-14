package com.jd.fridge.switchFridge;

import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;

/* compiled from: TbsSdkJava */
public class a<T extends NewSwitchFridgeActivity> implements Unbinder {
    protected T a;

    public a(T t, Finder finder, Object obj) {
        this.a = t;
        t.mFridgeList = (RecyclerView) finder.findRequiredViewAsType(obj, R.id.rc_fridges, "field 'mFridgeList'", RecyclerView.class);
        t.mLoading = (ProgressBar) finder.findRequiredViewAsType(obj, R.id.progress_loading, "field 'mLoading'", ProgressBar.class);
    }

    public void unbind() {
        NewSwitchFridgeActivity newSwitchFridgeActivity = this.a;
        if (newSwitchFridgeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        newSwitchFridgeActivity.mFridgeList = null;
        newSwitchFridgeActivity.mLoading = null;
        this.a = null;
    }
}
