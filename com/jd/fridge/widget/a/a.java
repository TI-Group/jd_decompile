package com.jd.fridge.widget.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/* compiled from: TbsSdkJava */
public abstract class a<T> extends BaseAdapter {
    private int a;
    protected Context b;
    protected List<T> c;
    protected LayoutInflater d;

    public abstract void a(b bVar, T t);

    public a(Context context, List<T> list, int i) {
        this.b = context;
        this.d = LayoutInflater.from(context);
        this.c = list;
        this.a = i;
    }

    public int getCount() {
        return this.c.size();
    }

    public T getItem(int i) {
        return this.c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b a = b.a(this.b, view, viewGroup, this.a, i);
        a(a, getItem(i));
        return a.a();
    }

    public void a(List<T> list) {
        this.c = list;
        notifyDataSetChanged();
    }

    public void b(List<T> list) {
        this.c.addAll(list);
        notifyDataSetChanged();
    }
}
