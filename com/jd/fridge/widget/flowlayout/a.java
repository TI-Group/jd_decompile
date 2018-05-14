package com.jd.fridge.widget.flowlayout;

import android.view.View;
import java.util.HashSet;
import java.util.List;

/* compiled from: TbsSdkJava */
public abstract class a<T> {
    private List<T> a;
    private a b;
    private HashSet<Integer> c;

    /* compiled from: TbsSdkJava */
    interface a {
    }

    public abstract View a(TagView tagView, int i, T t);

    void setOnDataChangedListener(a aVar) {
        this.b = aVar;
    }

    HashSet<Integer> a() {
        return this.c;
    }

    public int b() {
        return this.a == null ? 0 : this.a.size();
    }

    public T a(int i) {
        return this.a.get(i);
    }
}
