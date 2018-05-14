package com.jd.fridge.picHistory;

import android.support.v7.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class a<T extends PictureHistoryActivity> implements Unbinder {
    protected T a;

    public a(T t, Finder finder, Object obj) {
        this.a = t;
        t.picture_history_recyclerview = (RecyclerView) finder.findRequiredViewAsType(obj, R.id.picture_history_recyclerview, "field 'picture_history_recyclerview'", RecyclerView.class);
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
    }

    public void unbind() {
        PictureHistoryActivity pictureHistoryActivity = this.a;
        if (pictureHistoryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        pictureHistoryActivity.picture_history_recyclerview = null;
        pictureHistoryActivity.emptyLayout = null;
        this.a = null;
    }
}
