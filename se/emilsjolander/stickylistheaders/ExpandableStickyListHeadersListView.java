package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: TbsSdkJava */
public class ExpandableStickyListHeadersListView extends StickyListHeadersListView {
    e a;
    a b = new a(this) {
        final /* synthetic */ ExpandableStickyListHeadersListView a;

        {
            this.a = r1;
        }
    };

    /* compiled from: TbsSdkJava */
    public interface a {
    }

    public ExpandableStickyListHeadersListView(Context context) {
        super(context);
    }

    public ExpandableStickyListHeadersListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandableStickyListHeadersListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public e getAdapter() {
        return this.a;
    }

    public void setAdapter(g gVar) {
        this.a = new e(gVar);
        super.setAdapter(this.a);
    }

    public void setAnimExecutor(a aVar) {
        this.b = aVar;
    }
}
