package com.jd.fridge.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.jd.fridge.util.p;

/* compiled from: TbsSdkJava */
public abstract class PullUpLoadOnScrollListener extends OnScrollListener {
    private LinearLayoutManager a;
    private int b;
    private int c;
    private int d;
    private int e = 0;
    private int f = 0;
    private boolean g = true;

    public abstract void a(int i);

    public PullUpLoadOnScrollListener(LinearLayoutManager linearLayoutManager) {
        this.a = linearLayoutManager;
    }

    public void a() {
        this.f = 0;
        this.e = 0;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        this.b = recyclerView.getChildCount();
        this.c = this.a.findFirstVisibleItemPosition();
        this.d = this.a.getItemCount();
        p.a("MessagBoardActivity", "visibleItemCount:" + this.b + "  firstVisibleItem:" + this.c + " totalItemCount:" + this.d);
        if (this.g) {
            p.a("MessagBoardActivity", "totalItemCount:" + this.d + " previousTotal:" + this.e);
            if (this.d > this.e) {
                this.g = false;
                this.e = this.d;
            }
        }
        if (!this.g && this.d - this.b <= this.c) {
            this.f++;
            a(this.f);
            this.g = true;
        }
    }
}
