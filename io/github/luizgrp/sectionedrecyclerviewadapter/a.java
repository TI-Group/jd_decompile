package io.github.luizgrp.sectionedrecyclerviewadapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter.EmptyViewHolder;

/* compiled from: TbsSdkJava */
public abstract class a {
    boolean a = true;
    boolean b = false;
    boolean c = false;
    Integer d;
    Integer e;
    int f;
    private a g = a.LOADED;
    private Integer h;
    private Integer i;

    /* compiled from: TbsSdkJava */
    public enum a {
        LOADING,
        LOADED,
        FAILED
    }

    public abstract void b(ViewHolder viewHolder, int i);

    public abstract ViewHolder c(View view);

    public abstract int k();

    a() {
    }

    public final a a() {
        return this.g;
    }

    public final boolean b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }

    public final Integer e() {
        return this.d;
    }

    public final Integer f() {
        return this.e;
    }

    public final int g() {
        return this.f;
    }

    public final Integer h() {
        return this.h;
    }

    public final Integer i() {
        return this.i;
    }

    public final void a(ViewHolder viewHolder, int i) {
        switch (this.g) {
            case LOADING:
                c(viewHolder);
                return;
            case LOADED:
                b(viewHolder, i);
                return;
            case FAILED:
                d(viewHolder);
                return;
            default:
                throw new IllegalStateException("Invalid state");
        }
    }

    public final int j() {
        int i;
        int i2;
        int i3 = 1;
        switch (this.g) {
            case LOADING:
                i = 1;
                break;
            case LOADED:
                i = k();
                break;
            case FAILED:
                i = 1;
                break;
            default:
                throw new IllegalStateException("Invalid state");
        }
        if (this.b) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        i += i2;
        if (!this.c) {
            i3 = 0;
        }
        return i + i3;
    }

    public ViewHolder a(View view) {
        return new EmptyViewHolder(view);
    }

    public void a(ViewHolder viewHolder) {
    }

    public ViewHolder b(View view) {
        return new EmptyViewHolder(view);
    }

    public void b(ViewHolder viewHolder) {
    }

    public ViewHolder d(View view) {
        return new EmptyViewHolder(view);
    }

    public void c(ViewHolder viewHolder) {
    }

    public ViewHolder e(View view) {
        return new EmptyViewHolder(view);
    }

    public void d(ViewHolder viewHolder) {
    }
}
