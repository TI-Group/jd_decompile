package com.jd.fridge.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.base.NoNetworkActivity;
import com.jd.fridge.util.t;

/* compiled from: TbsSdkJava */
public class EmptyLayout extends FrameLayout {
    public ImageView a;
    private ProgressBar b;
    private final Context c;
    private int d;
    private String e = "";
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private View j;
    private TextView k;
    private ImageView l;
    private t m;

    public EmptyLayout(Context context) {
        super(context);
        this.c = context;
        b();
    }

    public EmptyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = context;
        b();
    }

    private void b() {
        this.m = new t(this.c);
        View inflate = View.inflate(this.c, R.layout.view_error_layout, null);
        this.a = (ImageView) inflate.findViewById(R.id.img_error_layout);
        this.f = (TextView) inflate.findViewById(R.id.tv_error_layout);
        this.g = (TextView) inflate.findViewById(R.id.refrush_btn);
        this.b = (ProgressBar) inflate.findViewById(R.id.animProgress);
        this.h = inflate.findViewById(R.id.layout_error);
        this.i = inflate.findViewById(R.id.layout_unbind);
        this.j = inflate.findViewById(R.id.layout_float);
        this.k = (TextView) inflate.findViewById(R.id.tv_float_error_layout);
        this.l = (ImageView) inflate.findViewById(R.id.iv_float_error_arrow);
        this.j.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmptyLayout a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.c.startActivity(new Intent(this.a.c, NoNetworkActivity.class));
            }
        });
        addView(inflate, new LayoutParams(-1, -1));
    }

    public int getErrorState() {
        return this.d;
    }

    public void setErrorImg(int i) {
        try {
            this.a.setImageResource(i);
        } catch (Exception e) {
        }
    }

    public void setRefresh(OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.g.setOnClickListener(onClickListener);
        }
    }

    public void setErrorType(int i) {
        switch (i) {
            case 1:
                this.d = 1;
                setVisibility(0);
                this.h.setVisibility(0);
                this.i.setVisibility(8);
                this.j.setVisibility(8);
                this.f.setVisibility(0);
                this.f.setText(R.string.error_view_app_offline_error);
                this.a.setVisibility(0);
                this.a.setImageResource(R.drawable.ic_no_wifi);
                this.b.setVisibility(8);
                this.g.setVisibility(0);
                return;
            case 2:
                this.d = 2;
                setVisibility(0);
                this.h.setVisibility(0);
                this.i.setVisibility(8);
                this.j.setVisibility(8);
                this.f.setVisibility(8);
                this.a.setVisibility(8);
                this.b.setVisibility(0);
                this.g.setVisibility(8);
                return;
            case 3:
                this.d = 3;
                setVisibility(0);
                this.h.setVisibility(0);
                this.i.setVisibility(8);
                this.j.setVisibility(8);
                this.a.setVisibility(8);
                this.b.setVisibility(8);
                this.f.setVisibility(0);
                a();
                this.g.setVisibility(8);
                return;
            case 4:
                setVisibility(8);
                this.b.setVisibility(8);
                return;
            case 7:
                this.d = 7;
                setVisibility(0);
                this.h.setVisibility(8);
                this.i.setVisibility(8);
                this.j.setVisibility(0);
                this.k.setText(getResources().getString(R.string.error_view_pad_offline_error));
                this.l.setVisibility(8);
                this.j.setEnabled(false);
                return;
            case 8:
                this.d = 8;
                setVisibility(0);
                this.h.setVisibility(0);
                this.i.setVisibility(8);
                this.j.setVisibility(8);
                this.f.setVisibility(0);
                this.f.setText(R.string.error_view_service_error);
                this.a.setVisibility(0);
                this.a.setImageResource(R.drawable.ic_server_error);
                this.b.setVisibility(8);
                this.g.setVisibility(8);
                return;
            case 9:
                this.d = 9;
                setVisibility(0);
                this.h.setVisibility(8);
                this.i.setVisibility(0);
                this.j.setVisibility(8);
                return;
            case 10:
                this.d = 10;
                setVisibility(0);
                this.h.setVisibility(8);
                this.i.setVisibility(8);
                this.j.setVisibility(0);
                this.k.setText(getResources().getString(R.string.error_view_service_float_error));
                this.l.setVisibility(8);
                this.j.setEnabled(false);
                return;
            case 11:
                this.d = 11;
                setVisibility(8);
                this.h.setVisibility(8);
                this.i.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setText(getResources().getString(R.string.error_view_app_offline_float_error));
                this.l.setVisibility(0);
                this.j.setEnabled(true);
                return;
            default:
                return;
        }
    }

    public void setNoDataContent(String str) {
        this.e = str;
    }

    public void a() {
        if (this.e.equals("")) {
            this.f.setText(R.string.error_view_no_data);
        } else {
            this.f.setText(this.e);
        }
    }

    public void setVisibility(int i) {
        if (i == 8) {
            this.d = 4;
        }
        super.setVisibility(i);
    }
}
