package com.jd.fridge.nutrition;

import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class a<T extends DetailFragment> implements Unbinder {
    protected T a;

    public a(T t, Finder finder, Object obj) {
        this.a = t;
        t.mDoc1 = (TextView) finder.findRequiredViewAsType(obj, R.id.doc1, "field 'mDoc1'", TextView.class);
        t.mListview = (ListView) finder.findRequiredViewAsType(obj, R.id.listview, "field 'mListview'", ListView.class);
        t.mLayoutContent = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.layout_content, "field 'mLayoutContent'", LinearLayout.class);
        t.mEmptyLayout = (EmptyLayout) finder.findRequiredViewAsType(obj, R.id.empty_layout, "field 'mEmptyLayout'", EmptyLayout.class);
    }

    public void unbind() {
        DetailFragment detailFragment = this.a;
        if (detailFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        detailFragment.mDoc1 = null;
        detailFragment.mListview = null;
        detailFragment.mLayoutContent = null;
        detailFragment.mEmptyLayout = null;
        this.a = null;
    }
}
