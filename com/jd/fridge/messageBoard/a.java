package com.jd.fridge.messageBoard;

import android.support.v7.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class a<T extends MessagBoardActivity> implements Unbinder {
    protected T a;

    public a(T t, Finder finder, Object obj) {
        this.a = t;
        t.message_board_recyclerview = (RecyclerView) finder.findRequiredViewAsType(obj, R.id.message_board_recyclerview, "field 'message_board_recyclerview'", RecyclerView.class);
        t.emptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'emptyLayout'", EmptyLayout.class);
    }

    public void unbind() {
        MessagBoardActivity messagBoardActivity = this.a;
        if (messagBoardActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        messagBoardActivity.message_board_recyclerview = null;
        messagBoardActivity.emptyLayout = null;
        this.a = null;
    }
}
