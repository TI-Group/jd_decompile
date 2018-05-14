package com.jd.fridge.switchFridge;

import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class b<T extends SwitchFridgeActivity> implements Unbinder {
    protected T a;

    public b(T t, Finder finder, Object obj) {
        this.a = t;
        t.mFridgeListview = (RecyclerView) finder.findRequiredViewAsType(obj, R.id.fridge_listview, "field 'mFridgeListview'", RecyclerView.class);
        t.progress_loading = (ProgressBar) finder.findRequiredViewAsType(obj, R.id.progress_loading, "field 'progress_loading'", ProgressBar.class);
        t.empty_layout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'empty_layout'", EmptyLayout.class);
    }

    public void unbind() {
        SwitchFridgeActivity switchFridgeActivity = this.a;
        if (switchFridgeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        switchFridgeActivity.mFridgeListview = null;
        switchFridgeActivity.progress_loading = null;
        switchFridgeActivity.empty_layout = null;
        this.a = null;
    }
}
