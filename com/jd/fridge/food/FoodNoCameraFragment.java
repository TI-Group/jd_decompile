package com.jd.fridge.food;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.GuideFragment;
import com.jd.fridge.HomeActivity;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseFragment;
import com.jd.fridge.bean.FoodsAlarmBaseBean;
import com.jd.fridge.bean.requestBody.AlarmsBatchDeleteByUser;
import com.jd.fridge.bean.requestBody.CurrentGoodsListByUser;
import com.jd.fridge.c;
import com.jd.fridge.food.FoodNoCameraAdapter.b;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.e;
import com.jd.fridge.util.k;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;
import com.jd.fridge.util.u;
import com.jd.fridge.util.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FoodNoCameraFragment extends BaseFragment implements com.jd.fridge.HomeActivity.a {
    private static final String d = FoodNoCameraFragment.class.getSimpleName();
    @BindView(2131558896)
    ImageView add_food_img;
    @BindView(2131558897)
    TextView cancle_select_tv;
    private Context e;
    private FoodNoCameraAdapter f;
    @BindView(2131558900)
    RecyclerView food_clock_recycler_view;
    @BindView(2131558892)
    TextView food_title_txt;
    @BindView(2131558898)
    LinearLayout foods_list_view;
    private List<FoodsAlarmBaseBean> g;
    private PopupWindow h;
    private PopupWindow i;
    private boolean j = false;
    private List<Integer> k = new ArrayList();
    private Button l;
    @BindView(2131558895)
    LinearLayout ll_content;
    private CheckBox m;
    private ViewGroup n;
    @BindView(2131558901)
    TextView no_foods_view;
    @BindView(2131558890)
    ImageView notice_btn;
    @BindView(2131558891)
    TextView notice_num;
    private a o;
    private int p = -1;

    /* compiled from: TbsSdkJava */
    class a extends BroadcastReceiver {
        final /* synthetic */ FoodNoCameraFragment a;

        a(FoodNoCameraFragment foodNoCameraFragment) {
            this.a = foodNoCameraFragment;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("updateViewFood")) {
                this.a.m();
                k.a("===NoticeBroadcastReceiver==updateNewNoticeNum=");
            }
            if (!intent.getAction().equals("FLAG_ACTION_HAVE_NETWORK")) {
            }
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_food_no_camera, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.e = getActivity();
        this.n = (ViewGroup) getActivity().getWindow().getDecorView();
        n();
        j();
        m();
        k.a("===onActivityCreated==updateNewNoticeNum=");
    }

    public void onResume() {
        super.onResume();
        p.a(d, "FoodNoCameraFragment onResume...");
        j();
        m();
        k.a("===onResume==updateNewNoticeNum=");
    }

    private void c() {
        this.foods_list_view.setVisibility(0);
        this.no_foods_view.setVisibility(8);
        if (this.f == null) {
            this.f = new FoodNoCameraAdapter(this.e, this.g);
            this.food_clock_recycler_view.setLayoutManager(new GridLayoutManager(this.e, 4));
            this.food_clock_recycler_view.addItemDecoration(new DividerGridItemDecoration(this.e));
            this.food_clock_recycler_view.setAdapter(this.f);
            this.f.setOnItemClickListener(new b(this) {
                final /* synthetic */ FoodNoCameraFragment a;

                {
                    this.a = r1;
                }

                public void a(View view, int i) {
                    if (this.a.j) {
                        int a = this.a.f.a(i);
                        if (a == 0) {
                            this.a.l.setEnabled(false);
                            return;
                        }
                        this.a.l.setEnabled(true);
                        if (a == this.a.g.size()) {
                            this.a.m.setChecked(true);
                            return;
                        } else {
                            this.a.m.setChecked(false);
                            return;
                        }
                    }
                    this.a.a(i);
                }

                public void b(View view, int i) {
                    boolean z = true;
                    this.a.j = true;
                    this.a.g();
                    int a = this.a.f.a(i);
                    Button c = this.a.l;
                    if (a == 0) {
                        z = false;
                    }
                    c.setEnabled(z);
                }
            });
            return;
        }
        this.f.a(this.g);
    }

    private void d() {
        this.foods_list_view.setVisibility(8);
        this.no_foods_view.setVisibility(0);
        this.no_foods_view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FoodNoCameraFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.k();
            }
        });
    }

    private void e() {
        if (this.g.size() > 0) {
            c();
        } else {
            d();
        }
    }

    @OnClick({2131558897})
    public void cancleSelectClick(View view) {
        h();
    }

    @OnClick({2131558896})
    public void addGoodsClick(View view) {
        k();
    }

    @OnClick({2131558890})
    public void noticeClick(View view) {
        com.jd.fridge.util.e.b.a().h();
        aa.d(b());
        m();
        k.a("===noticeClick==updateNewNoticeNum=");
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                this.f.notifyItemRangeChanged(0, this.g.size());
                break;
            case 2001:
                List list = (List) e.a(String.valueOf(message.obj), GlobalVariable.a(), com.jd.fridge.util.e.a.CACHE_MODEL_MAX);
                if (list != null) {
                    this.g = list;
                    e();
                    break;
                }
                break;
            case 10001:
                this.g = (List) message.obj;
                e();
                break;
            case 10002:
                a(this.k);
                if (GuideFragment.a && this.h == null && this.g.size() > 0) {
                    GuideFragment.a = false;
                    l();
                    break;
                }
            case 10003:
                Toast.makeText(this.e, "删除失败", 0).show();
                this.l.setEnabled(true);
                break;
            case 10004:
                i();
                Toast.makeText(this.e, (this.p != -1 ? ((FoodsAlarmBaseBean) this.g.get(this.p)).getGoods_name() : "") + "食物闹钟修改成功", 0).show();
                j();
                break;
            case 10005:
                i();
                if (!y.d(this.e)) {
                    Toast.makeText(this.e, "网络断了哦，请检查你的网络设置", 0).show();
                    break;
                }
                String obj = message.obj.toString();
                String substring = obj.substring(0, obj.indexOf("|"));
                if (obj.length() - 1 > obj.indexOf("|")) {
                    Toast.makeText(this.e, "修改不成功，" + substring + "食物闹钟已经被删除", 0).show();
                    j();
                    break;
                }
                break;
        }
        return super.handleMessage(message);
    }

    private void f() {
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.pop_select_all_bar, null, false);
        this.h = new PopupWindow(inflate, -1, -2, false);
        this.m = (CheckBox) inflate.findViewById(R.id.cb_select_all);
        this.m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FoodNoCameraFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    this.a.l.setEnabled(true);
                    this.a.f.a();
                    return;
                }
                this.a.l.setEnabled(false);
                this.a.f.b();
            }
        });
        this.l = (Button) inflate.findViewById(R.id.delete_food_btn);
        this.l.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FoodNoCameraFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.l.setEnabled(false);
                this.a.k.clear();
                this.a.k = this.a.f.c();
                List arrayList = new ArrayList();
                for (int i = 0; i < this.a.k.size(); i++) {
                    arrayList.add(Long.valueOf(((FoodsAlarmBaseBean) this.a.g.get(((Integer) this.a.k.get(i)).intValue())).getAlarm_id()));
                }
                com.jd.fridge.a.a().a(this.a.a, new AlarmsBatchDeleteByUser(Long.valueOf(GlobalVariable.C()), arrayList));
            }
        });
    }

    private void g() {
        if (this.h == null) {
            f();
        } else if (this.h.isShowing()) {
            return;
        }
        this.h.showAsDropDown(this.ll_content);
        this.add_food_img.setVisibility(8);
        this.cancle_select_tv.setVisibility(0);
        this.notice_btn.setVisibility(4);
        this.food_title_txt.setText("删除食材");
        ((HomeActivity) getActivity()).a((com.jd.fridge.HomeActivity.a) this);
    }

    private void h() {
        if (this.h != null) {
            this.h.dismiss();
            this.add_food_img.setVisibility(0);
            this.cancle_select_tv.setVisibility(8);
            this.notice_btn.setVisibility(0);
            this.food_title_txt.setText("食物管理");
            this.f.b();
            this.j = false;
            this.m.setChecked(false);
        }
        ((HomeActivity) getActivity()).h();
    }

    private void a(int i) {
        if (this.i == null) {
            this.i = new c(this.e, this.a);
        } else if (this.i.isShowing()) {
            return;
        }
        this.p = i;
        this.k.clear();
        this.k.add(Integer.valueOf(i));
        ((c) this.i).a((FoodsAlarmBaseBean) this.g.get(i));
        this.i.showAtLocation(getActivity().findViewById(R.id.layout_main), 81, 0, u.e(this.e));
        r.a(d, "VirtualKeyHeight: " + u.e(this.e));
        ((c) this.i).a(this.n);
    }

    private void i() {
        if (this.i != null) {
            this.i.dismiss();
        }
    }

    private void a(List<Integer> list) {
        Toast.makeText(this.e, (list.size() == 1 ? ((FoodsAlarmBaseBean) this.g.get(((Integer) list.get(0)).intValue())).getGoods_name() : "") + "闹钟删除成功", 0).show();
        this.f.b((List) list);
        if (this.h != null) {
            this.l.setEnabled(false);
        }
        if (this.g.size() == 0) {
            h();
            d();
        }
    }

    private void j() {
        if (!TextUtils.equals(GlobalVariable.C(), "0")) {
            CurrentGoodsListByUser currentGoodsListByUser = new CurrentGoodsListByUser();
            currentGoodsListByUser.setFeed_id(Long.parseLong(GlobalVariable.C()));
            currentGoodsListByUser.setPin(GlobalVariable.I());
            com.jd.fridge.a.a().a(this.a, currentGoodsListByUser);
        }
    }

    private void k() {
        if (this.g == null || this.g.size() < 50) {
            aa.g(b());
        } else {
            Toast.makeText(this.e, "最多添加50个食物闹钟", 0).show();
        }
    }

    private void l() {
        final View inflate = LayoutInflater.from(this.e).inflate(R.layout.view_delete_guide_tip, null);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        inflate.setLayoutParams(layoutParams);
        this.n.addView(inflate);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FoodNoCameraFragment b;

            public void onClick(View view) {
                ((ViewGroup) inflate.getParent()).removeView(inflate);
            }
        });
    }

    private void m() {
        if (this.notice_num != null) {
            int g = com.jd.fridge.util.e.b.a().g();
            k.a("num------" + g);
            if (g > 0) {
                this.notice_num.setVisibility(0);
                if (g > 99) {
                    this.notice_num.setText("99+");
                    return;
                } else {
                    this.notice_num.setText(g + "");
                    return;
                }
            }
            this.notice_num.setVisibility(8);
        }
    }

    private void n() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("FLAG_ACTION_UPDATE_NEW_NOTICE_NUM");
        intentFilter.addAction("FLAG_ACTION_HAVE_NETWORK");
        intentFilter.addAction("updateViewFood");
        this.o = new a(this);
        b().registerReceiver(this.o, intentFilter);
    }

    public void a() {
        if (this.i != null && this.i.isShowing()) {
            i();
        } else if (this.h != null && this.h.isShowing()) {
            h();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.o != null) {
            b().unregisterReceiver(this.o);
        }
    }
}
