package io.github.luizgrp.sectionedrecyclerviewadapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: TbsSdkJava */
public class SectionedRecyclerViewAdapter extends Adapter<ViewHolder> {
    private LinkedHashMap<String, a> a = new LinkedHashMap();
    private HashMap<String, Integer> b = new HashMap();
    private int c = 0;

    /* compiled from: TbsSdkJava */
    public static class EmptyViewHolder extends ViewHolder {
        public EmptyViewHolder(View view) {
            super(view);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder viewHolder = null;
        for (Entry entry : this.b.entrySet()) {
            ViewHolder viewHolder2;
            if (i < ((Integer) entry.getValue()).intValue() || i >= ((Integer) entry.getValue()).intValue() + 5) {
                viewHolder2 = viewHolder;
            } else {
                a aVar = (a) this.a.get(entry.getKey());
                Integer e;
                switch (i - ((Integer) entry.getValue()).intValue()) {
                    case 0:
                        e = aVar.e();
                        if (e != null) {
                            viewHolder2 = aVar.a(LayoutInflater.from(viewGroup.getContext()).inflate(e.intValue(), viewGroup, false));
                            break;
                        }
                        throw new NullPointerException("Missing 'header' resource id");
                    case 1:
                        e = aVar.f();
                        if (e != null) {
                            viewHolder2 = aVar.b(LayoutInflater.from(viewGroup.getContext()).inflate(e.intValue(), viewGroup, false));
                            break;
                        }
                        throw new NullPointerException("Missing 'footer' resource id");
                    case 2:
                        viewHolder2 = aVar.c(LayoutInflater.from(viewGroup.getContext()).inflate(aVar.g(), viewGroup, false));
                        break;
                    case 3:
                        e = aVar.h();
                        if (e != null) {
                            viewHolder2 = aVar.d(LayoutInflater.from(viewGroup.getContext()).inflate(e.intValue(), viewGroup, false));
                            break;
                        }
                        throw new NullPointerException("Missing 'loading state' resource id");
                    case 4:
                        e = aVar.i();
                        if (e != null) {
                            viewHolder2 = aVar.e(LayoutInflater.from(viewGroup.getContext()).inflate(e.intValue(), viewGroup, false));
                            break;
                        }
                        throw new NullPointerException("Missing 'failed state' resource id");
                    default:
                        throw new IllegalArgumentException("Invalid viewType");
                }
            }
            viewHolder = viewHolder2;
        }
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int i2 = 0;
        for (Entry value : this.a.entrySet()) {
            a aVar = (a) value.getValue();
            if (aVar.b()) {
                int j = aVar.j();
                if (i < i2 || i > (i2 + j) - 1) {
                    i2 += j;
                } else if (aVar.c() && i == i2) {
                    a(i).a(viewHolder);
                    return;
                } else if (aVar.d() && i == (i2 + j) - 1) {
                    a(i).b(viewHolder);
                    return;
                } else {
                    a(i).a(viewHolder, b(i));
                    return;
                }
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public int getItemCount() {
        int i = 0;
        for (Entry value : this.a.entrySet()) {
            a aVar = (a) value.getValue();
            if (aVar.b()) {
                i = aVar.j() + i;
            }
        }
        return i;
    }

    public int getItemViewType(int i) {
        int i2 = 0;
        for (Entry entry : this.a.entrySet()) {
            a aVar = (a) entry.getValue();
            if (aVar.b()) {
                int j = aVar.j();
                if (i < i2 || i > (i2 + j) - 1) {
                    i2 += j;
                } else {
                    int intValue = ((Integer) this.b.get(entry.getKey())).intValue();
                    if (aVar.c() && i == i2) {
                        return intValue;
                    }
                    if (aVar.d() && i == (i2 + j) - 1) {
                        return intValue + 1;
                    }
                    switch (aVar.a()) {
                        case LOADED:
                            return intValue + 2;
                        case LOADING:
                            return intValue + 3;
                        case FAILED:
                            return intValue + 4;
                        default:
                            throw new IllegalStateException("Invalid state");
                    }
                }
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public a a(int i) {
        int i2 = 0;
        for (Entry value : this.a.entrySet()) {
            a aVar = (a) value.getValue();
            if (aVar.b()) {
                int j = aVar.j();
                if (i >= i2 && i <= (i2 + j) - 1) {
                    return aVar;
                }
                i2 += j;
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }

    public int b(int i) {
        int i2 = 0;
        int i3 = 0;
        for (Entry value : this.a.entrySet()) {
            a aVar = (a) value.getValue();
            if (aVar.b()) {
                int j = aVar.j();
                if (i < i3 || i > (i3 + j) - 1) {
                    i3 += j;
                } else {
                    i3 = i - i3;
                    if (aVar.c()) {
                        i2 = 1;
                    }
                    return i3 - i2;
                }
            }
        }
        throw new IndexOutOfBoundsException("Invalid position");
    }
}
