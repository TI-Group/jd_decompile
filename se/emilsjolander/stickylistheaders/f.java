package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.widget.SectionIndexer;

/* compiled from: TbsSdkJava */
class f extends a implements SectionIndexer {
    SectionIndexer b;

    f(Context context, g gVar) {
        super(context, gVar);
        this.b = (SectionIndexer) gVar;
    }

    public int getPositionForSection(int i) {
        return this.b.getPositionForSection(i);
    }

    public int getSectionForPosition(int i) {
        return this.b.getSectionForPosition(i);
    }

    public Object[] getSections() {
        return this.b.getSections();
    }
}
