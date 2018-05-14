package com.jd.fridge.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jd.fridge.R;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.w;

/* compiled from: TbsSdkJava */
public class ClockSettingView extends LinearLayout implements OnClickListener {
    private static int b = 30;
    private Context a;
    private b c;
    private a d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private RulerWheel i;
    private ImageView j;
    private boolean k = true;
    private int l;

    /* compiled from: TbsSdkJava */
    public interface b {
        void a(boolean z, Object obj);
    }

    /* compiled from: TbsSdkJava */
    public interface a {
        void a();
    }

    public ClockSettingView(Context context) {
        super(context);
    }

    public ClockSettingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        LayoutInflater.from(context).inflate(R.layout.view_set_food_clock, this);
        b();
    }

    private void b() {
        this.e = (TextView) findViewById(R.id.tv_day);
        this.e.getPaint().setFlags(8);
        this.e.setOnClickListener(this);
        this.f = (TextView) findViewById(R.id.tv_month);
        this.f.setOnClickListener(this);
        this.g = (TextView) findViewById(R.id.tv_foods_date);
        this.h = (TextView) findViewById(R.id.tv_foods_name);
        this.i = (RulerWheel) findViewById(R.id.ruler_view);
        this.i.setData(aa.a(true));
        this.i.setScrollingListener(new com.jd.fridge.widget.RulerWheel.a(this) {
            final /* synthetic */ ClockSettingView a;

            {
                this.a = r1;
            }

            public void a(RulerWheel rulerWheel, Object obj, Object obj2) {
                String str = obj2 + (this.a.k ? "天" : "月");
                w.b(this.a.g, str, 0, str.length() - 1, w.a(this.a.a, 25.0f));
                if (this.a.c != null) {
                    this.a.c.a(this.a.k, obj2);
                }
            }

            public void b(RulerWheel rulerWheel) {
            }

            public void a(RulerWheel rulerWheel) {
            }
        });
        this.j = (ImageView) findViewById(R.id.iv_delete);
        this.j.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ClockSettingView a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (this.a.d != null) {
                    this.a.d.a();
                }
            }
        });
    }

    public void setFoodsName(String str) {
        this.h.setText(str);
    }

    public void setFoodsDate(long j) {
        this.i.setSelectedValue(String.valueOf(j));
        if (((int) j) < 0) {
            j = 0;
        }
        String str = this.k ? j + "天" : j + "月";
        w.b(this.g, str, 0, str.length() - 1, w.a(this.a, 25.0f));
    }

    public int getFinalValue() {
        return this.k ? this.i.getValue() + 1 : (this.i.getValue() + 1) * b;
    }

    public void onClick(View view) {
        this.l = this.i.getValue() + 1;
        switch (view.getId()) {
            case R.id.tv_day:
                if (!this.k) {
                    this.k = true;
                    c();
                    this.i.setData(aa.a(true));
                    setFoodsDate((long) (this.l * b));
                    if (this.c != null) {
                        this.c.a(this.k, Integer.valueOf(this.l * b));
                        return;
                    }
                    return;
                }
                return;
            case R.id.tv_month:
                if (this.k) {
                    this.k = false;
                    d();
                    this.i.setData(aa.a(false));
                    setFoodsDate((long) Math.max(this.l / b, 1));
                    if (this.c != null) {
                        this.c.a(this.k, Integer.valueOf(Math.max(this.l / b, 1)));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void c() {
        this.e.setTextColor(ContextCompat.getColor(this.a, R.color.jd_bg_range_color2));
        this.e.getPaint().setFlags(8);
        this.f.setTextColor(ContextCompat.getColor(this.a, R.color.jd_gray_5));
        this.f.getPaint().setFlags(0);
    }

    private void d() {
        this.e.setTextColor(ContextCompat.getColor(this.a, R.color.jd_gray_5));
        this.e.getPaint().setFlags(0);
        this.f.setTextColor(ContextCompat.getColor(this.a, R.color.jd_bg_range_color2));
        this.f.getPaint().setFlags(8);
    }

    public void a() {
        c();
        this.k = true;
        this.i.setData(aa.a(true));
    }

    public void setOnOnWheelChangedListener(b bVar) {
        this.c = bVar;
    }

    public void setOnDeletListener(a aVar) {
        this.d = aVar;
    }
}
