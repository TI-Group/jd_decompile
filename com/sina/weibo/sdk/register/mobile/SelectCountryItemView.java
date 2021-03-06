package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.d.g;

/* compiled from: TbsSdkJava */
public class SelectCountryItemView extends RelativeLayout {
    private TextView a;
    private TextView b;

    public SelectCountryItemView(Context context, String str, String str2) {
        super(context);
        b(str, str2);
    }

    private void b(String str, String str2) {
        setLayoutParams(new LayoutParams(-1, g.a(getContext(), 40)));
        this.a = new TextView(getContext());
        this.a.setTextSize(16.0f);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = g.a(getContext(), 15);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        this.a.setGravity(16);
        this.a.setLayoutParams(layoutParams);
        this.a.setText(str);
        this.a.setTextColor(-13421773);
        addView(this.a);
        this.b = new TextView(getContext());
        this.b.setTextSize(16.0f);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = g.a(getContext(), 40);
        this.b.setLayoutParams(layoutParams);
        this.b.setText(str2);
        this.b.setTextColor(-11502161);
        this.b.setGravity(16);
        addView(this.b);
        c(str, str2);
    }

    public void a(String str, String str2) {
        c(str, str2);
    }

    private void c(String str, String str2) {
        this.a.setText(str);
        this.b.setText(str2);
    }
}
