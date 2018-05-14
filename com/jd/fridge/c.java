package com.jd.fridge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.jd.fridge.bean.FoodsAlarmBaseBean;
import com.jd.fridge.bean.requestBody.AlarmsBatchDeleteByUser;
import com.jd.fridge.bean.requestBody.ResetGoodsAlarm;
import com.jd.fridge.util.g;
import com.jd.fridge.util.w;
import com.jd.fridge.widget.ClockSettingView;
import com.jd.fridge.widget.ClockSettingView.a;
import com.jd.fridge.widget.ClockSettingView.b;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class c extends PopupWindow {
    private static final String a = c.class.getSimpleName();
    private Context b;
    private View c;
    private ViewGroup d;
    private ClockSettingView e;
    private TextView f;
    private Button g;
    private FoodsAlarmBaseBean h;
    private boolean i = false;
    private Handler j;

    public c(Context context, Handler handler) {
        super(context);
        this.b = context;
        this.j = handler;
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.pop_edit_food_clock_view, null, false);
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setAnimationStyle(R.style.PopupWindowBottomAnimation);
        setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onDismiss() {
                this.a.a();
                this.a.e.a();
                if (this.a.i) {
                    this.a.j.sendEmptyMessage(1001);
                }
            }
        });
        this.e = (ClockSettingView) inflate.findViewById(R.id.clock_setting_view);
        this.e.setOnOnWheelChangedListener(new b(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void a(boolean z, Object obj) {
                this.a.a(z ? obj + "天" : obj + "月");
            }
        });
        this.e.setOnDeletListener(new a(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.c();
                this.a.dismiss();
                this.a.i = true;
            }
        });
        this.g = (Button) inflate.findViewById(R.id.btn_sure);
        this.g.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.b();
                this.a.i = true;
            }
        });
        this.f = (TextView) inflate.findViewById(R.id.tv_indate_tip);
    }

    public void a(FoodsAlarmBaseBean foodsAlarmBaseBean) {
        this.h = foodsAlarmBaseBean;
        a(g.b(this.h.getAlarm_date()) + "天");
        this.e.setFoodsName(this.h.getGoods_name());
        this.e.setFoodsDate(g.b(this.h.getAlarm_date()));
    }

    private void a(String str) {
        if (TextUtils.equals(str.substring(str.length() - 1, str.length()), "天")) {
            int intValue = Integer.valueOf(str.substring(0, str.length() - 1)).intValue();
            if (intValue == 0) {
                this.f.setText(String.format(this.b.getResources().getString(R.string.pop_edit_clock_today_expire), new Object[]{this.h.getGoods_name()}));
                return;
            } else if (intValue < 0) {
                this.f.setText(String.format(this.b.getResources().getString(R.string.pop_edit_clock_expire), new Object[]{this.h.getGoods_name(), Integer.valueOf(Math.abs(intValue))}));
                return;
            }
        }
        String format = String.format(this.b.getResources().getString(R.string.pop_edit_clock_tip), new Object[]{this.h.getGoods_name(), str});
        w.a(this.f, format, format.indexOf("于") + 1, format.indexOf("后") - 1, ContextCompat.getColor(this.b, R.color.jd_bg_range_color2));
    }

    public void a(ViewGroup viewGroup) {
        this.d = viewGroup;
        if (this.c == null) {
            this.c = new View(this.b);
            this.c.setBackgroundColor(-16777216);
            this.c.setAlpha(0.0f);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.c.setLayoutParams(layoutParams);
        }
        if (this.c.getParent() == null) {
            viewGroup.addView(this.c);
        }
        this.c.setVisibility(0);
        this.c.animate().alphaBy(0.0f).alpha(0.5f).setDuration(300).setListener(null);
    }

    private void a() {
        if (this.d != null) {
            this.c.animate().alpha(0.5f).alpha(0.0f).setDuration(300).setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public void onAnimationEnd(Animator animator) {
                    this.a.c.setVisibility(8);
                    this.a.d.removeView(this.a.c);
                }
            });
        }
    }

    private void b() {
        ResetGoodsAlarm resetGoodsAlarm = new ResetGoodsAlarm();
        resetGoodsAlarm.setFeed_id(Long.parseLong(GlobalVariable.C()));
        try {
            resetGoodsAlarm.setPin(URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resetGoodsAlarm.setAlarm_id(this.h.getAlarm_id());
        resetGoodsAlarm.setExpire(this.e.getFinalValue());
        resetGoodsAlarm.setExpire_unit(0);
        resetGoodsAlarm.setFoods_name(this.h.getGoods_name());
        a.a().a(this.j, resetGoodsAlarm);
    }

    private void c() {
        List arrayList = new ArrayList();
        arrayList.add(Long.valueOf(this.h.getAlarm_id()));
        a.a().a(this.j, new AlarmsBatchDeleteByUser(Long.valueOf(GlobalVariable.C()), arrayList));
    }
}
