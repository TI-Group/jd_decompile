package com.jd.fridge.widget.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;

/* compiled from: TbsSdkJava */
public class b {
    private SparseArray<View> a = new SparseArray();
    private int b;
    private View c;
    private Context d;
    private int e;

    public b(Context context, ViewGroup viewGroup, int i, int i2) {
        this.d = context;
        this.e = i;
        this.b = i2;
        this.c = LayoutInflater.from(context).inflate(i, viewGroup, false);
        this.c.setTag(this);
    }

    public static b a(Context context, View view, ViewGroup viewGroup, int i, int i2) {
        if (view == null) {
            return new b(context, viewGroup, i, i2);
        }
        b bVar = (b) view.getTag();
        bVar.b = i2;
        return bVar;
    }

    public <T extends View> T a(int i) {
        View view = (View) this.a.get(i);
        if (view != null) {
            return view;
        }
        T findViewById = this.c.findViewById(i);
        this.a.put(i, findViewById);
        return findViewById;
    }

    public View a() {
        return this.c;
    }

    public b a(int i, String str) {
        ((TextView) a(i)).setText(str);
        return this;
    }

    public b a(int i, int i2) {
        ((ImageView) a(i)).setImageResource(i2);
        return this;
    }

    public b a(int i, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView = (TextView) a(i);
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
        }
        textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        textView.setCompoundDrawablePadding(10);
        return this;
    }

    public b b(int i, int i2) {
        ((TextView) a(i)).setTextColor(this.d.getResources().getColor(i2));
        return this;
    }

    public b c(int i, int i2) {
        a(i).setVisibility(i2);
        return this;
    }

    public b b(int i, String str) {
        ImageLoader.getInstance().displayImage(str, (ImageView) a(i));
        return this;
    }

    public b d(int i, int i2) {
        ((ImageView) a(i)).setImageResource(i2);
        return this;
    }

    public b a(int i, OnClickListener onClickListener) {
        a(i).setOnClickListener(onClickListener);
        return this;
    }
}
