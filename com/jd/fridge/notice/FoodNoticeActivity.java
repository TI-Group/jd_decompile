package com.jd.fridge.notice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.b;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FoodNoticeDataBean;
import com.jd.fridge.bean.FoodNoticeStatusDataBean;
import com.jd.fridge.bean.JPushReceiverMsgDataBean;
import com.jd.fridge.bean.MenuBean;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.e;
import com.jd.fridge.util.e.a;
import com.jd.fridge.util.h;
import com.jd.fridge.util.k;
import com.jd.fridge.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.util.TextUtils;

/* compiled from: TbsSdkJava */
public class FoodNoticeActivity extends BaseActivity implements OnItemLongClickListener {
    private Context a;
    private RelativeLayout b;
    private TextView c;
    private ImageView d;
    private ImageView i;
    private LinearLayout j;
    private PopupWindow k;
    private ListView l;
    private RelativeLayout m;
    private List<FoodNoticeDataBean> n;
    private List<FoodNoticeDataBean> o = new ArrayList();
    private HashMap<String, FoodNoticeStatusDataBean> p;
    private HashMap<String, ArrayList<MenuBean>> q;
    private int r = R.id.filter_all;
    private final BroadcastReceiver s = new BroadcastReceiver(this) {
        final /* synthetic */ FoodNoticeActivity a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            boolean z = true;
            switch (action.hashCode()) {
                case -1916666563:
                    if (action.equals("ACTION_REFRESH_FOOD_NOTICE_DATA")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    List list;
                    List list2 = (List) e.a(b.b(), this.a.a, a.CACHE_MODEL_MAX);
                    if (list2 == null) {
                        list = (List) e.a(b.c(), this.a.a, a.CACHE_MODEL_MAX);
                    } else {
                        list = list2;
                    }
                    HashMap hashMap = (HashMap) e.a(b.a(), this.a.a, a.CACHE_MODEL_MAX);
                    HashMap hashMap2 = (HashMap) e.a(b.d(), this.a.a, a.CACHE_MODEL_MAX);
                    if (!(list == null || list.isEmpty())) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            FoodNoticeDataBean foodNoticeDataBean = (FoodNoticeDataBean) list.get(size);
                            String noticeId = foodNoticeDataBean.getNoticeId();
                            if (!this.a.n.contains(foodNoticeDataBean)) {
                                this.a.n.add(0, foodNoticeDataBean);
                                if (hashMap2 != null) {
                                    k.a("GaoPeng: ACTION_REFRESH_FOOD_NOTICE_DATA------menuData not null, noticeId = " + noticeId);
                                    this.a.q.put(noticeId, hashMap2.get(noticeId));
                                }
                                if (hashMap != null) {
                                    k.a("GaoPeng: ACTION_REFRESH_FOOD_NOTICE_DATA------statusData not null, noticeId = " + noticeId);
                                    this.a.p.put(noticeId, hashMap.get(noticeId));
                                } else {
                                    k.a("GaoPeng: ACTION_REFRESH_FOOD_NOTICE_DATA------statusData is null, create a new status, noticeId = " + noticeId);
                                    FoodNoticeStatusDataBean foodNoticeStatusDataBean = new FoodNoticeStatusDataBean();
                                    foodNoticeStatusDataBean.setDeleted(false);
                                    foodNoticeStatusDataBean.setReaded(false);
                                    this.a.p.put(noticeId, foodNoticeStatusDataBean);
                                }
                            }
                        }
                    }
                    this.a.o.clear();
                    this.a.o.addAll(this.a.a(this.a.r));
                    ((com.jd.fridge.widget.a.a) this.a.l.getAdapter()).notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
    };
    private OnClickListener t = new OnClickListener(this) {
        final /* synthetic */ FoodNoticeActivity a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            if (!y.c()) {
                this.a.r = view.getId();
                this.a.o.clear();
                this.a.o.addAll(this.a.a(this.a.r));
                ((com.jd.fridge.widget.a.a) this.a.l.getAdapter()).notifyDataSetChanged();
                this.a.k.dismiss();
            }
        }
    };

    protected int a() {
        return R.layout.activity_food_notice;
    }

    protected void b() {
        this.a = this;
        k();
        f();
        g();
        this.l = (ListView) findViewById(R.id.listview);
        this.l.setOnItemLongClickListener(this);
        this.m = (RelativeLayout) findViewById(R.id.notice_empty_layout);
        this.a.registerReceiver(this.s, new IntentFilter());
        a("消息提醒页面");
    }

    protected void c() {
        this.n = (List) d(b.b());
        this.p = (HashMap) d(b.a());
        this.q = (HashMap) d(b.d());
        if (this.n == null) {
            this.n = (List) d(b.c());
            if (this.n == null) {
                this.n = new ArrayList();
            }
        }
        if (this.p == null) {
            this.p = new HashMap();
        }
        for (FoodNoticeDataBean foodNoticeDataBean : this.n) {
            if (this.p.get(foodNoticeDataBean.getNoticeId()) == null) {
                this.p.put(foodNoticeDataBean.getNoticeId(), new FoodNoticeStatusDataBean());
            }
        }
        if (this.q == null) {
            this.q = new HashMap();
        }
        this.l.setEmptyView(this.m);
        this.l.setVisibility(0);
        this.o.clear();
        this.o.addAll(a(this.r));
        this.l.setAdapter(new com.jd.fridge.widget.a.a<FoodNoticeDataBean>(this, this, this.o, R.layout.item_food_notice) {
            final /* synthetic */ FoodNoticeActivity a;

            public void a(com.jd.fridge.widget.a.b bVar, FoodNoticeDataBean foodNoticeDataBean) {
                String code = foodNoticeDataBean.getMsg_content().getCode();
                bVar.a((int) R.id.tip, foodNoticeDataBean.getTitle());
                bVar.a((int) R.id.time, y.a(foodNoticeDataBean.getMsg_content().getTime(), "MM-dd HH:mm"));
                String str = "";
                if (code.equals("not_move_region")) {
                    str = foodNoticeDataBean.getMsg_content().getData().getPic_url();
                } else {
                    str = foodNoticeDataBean.getMsg_content().getData().getImg_url();
                }
                if (TextUtils.isEmpty(str)) {
                    bVar.d(R.id.img, R.drawable.default_img);
                } else {
                    bVar.b((int) R.id.img, str);
                }
                FoodNoticeStatusDataBean foodNoticeStatusDataBean = (FoodNoticeStatusDataBean) this.a.p.get(foodNoticeDataBean.getNoticeId());
                if (!code.equals("not_move_region")) {
                    if (foodNoticeStatusDataBean == null || !foodNoticeStatusDataBean.isReaded()) {
                        bVar.a((int) R.id.msg_status, "");
                        bVar.b((int) R.id.tip, (int) R.color.jd_orange_color_n);
                        bVar.b((int) R.id.time, (int) R.color.jd_orange_color_n);
                        bVar.b((int) R.id.title, (int) R.color.jd_orange_color_n);
                    } else {
                        bVar.a((int) R.id.msg_status, "");
                        bVar.b((int) R.id.tip, (int) R.color.jd_gray_8);
                        bVar.b((int) R.id.time, (int) R.color.jd_gray_8);
                        bVar.b((int) R.id.title, (int) R.color.jd_gray_8);
                    }
                    bVar.a((int) R.id.msg_status, null, null, null, null);
                }
                if (code.equals("cus_alarm")) {
                    bVar.a((int) R.id.title, this.a.getResources().getString(R.string.activity_food_notice_type1title, new Object[]{foodNoticeDataBean.getMsg_content().getData().getGoods_name()}));
                } else if (code.equals("sys_expired")) {
                    bVar.a((int) R.id.title, this.a.getResources().getString(R.string.activity_food_notice_type2title, new Object[]{foodNoticeDataBean.getMsg_content().getData().getGoods_name()}));
                } else if (code.equals("not_move_region")) {
                    int day_count = foodNoticeDataBean.getMsg_content().getData().getDay_count();
                    bVar.a((int) R.id.title, this.a.getString(R.string.activity_food_no_move_tip, new Object[]{Integer.valueOf(day_count)}));
                    bVar.a((int) R.id.msg_status, "");
                    bVar.a((int) R.id.msg_status, null, null, this.a.getResources().getDrawable(R.drawable.ic_arrow_range), null);
                }
                ArrayList arrayList = (ArrayList) this.a.q.get(foodNoticeDataBean.getNoticeId());
                if (arrayList == null) {
                    bVar.c(R.id.layout_notice_menu, 8);
                } else if (arrayList.size() == 0) {
                    bVar.c(R.id.layout_notice_menu, 8);
                } else if (arrayList.size() == 1) {
                    r0 = (MenuBean) arrayList.get(0);
                    bVar.c(R.id.layout_notice_menu, 0);
                    bVar.c(R.id.item_menu_1, 0);
                    bVar.c(R.id.item_menu_2, 4);
                    bVar.a((int) R.id.txt_menu_1, r0.getMenuName());
                    bVar.b((int) R.id.img_menu_1, r0.getMenuImage());
                    bVar.a((int) R.id.item_menu_1, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 b;

                        public void onClick(View view) {
                            if (!y.c()) {
                                aa.b(this.b.a, r0.getMenuId(), r0.getMenuName());
                            }
                        }
                    });
                } else if (arrayList.size() > 1) {
                    final MenuBean menuBean = (MenuBean) arrayList.get(0);
                    r0 = (MenuBean) arrayList.get(1);
                    bVar.c(R.id.layout_notice_menu, 0);
                    bVar.c(R.id.item_menu_1, 0);
                    bVar.c(R.id.item_menu_2, 0);
                    bVar.a((int) R.id.txt_menu_1, menuBean.getMenuName());
                    bVar.b((int) R.id.img_menu_1, menuBean.getMenuImage());
                    bVar.a((int) R.id.item_menu_1, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 b;

                        public void onClick(View view) {
                            if (!y.c()) {
                                this.b.a.b("APP_消息提醒页_所有菜谱区域", "fridgeapp_201609146|6");
                                aa.b(this.b.a, menuBean.getMenuId(), menuBean.getMenuName());
                            }
                        }
                    });
                    bVar.a((int) R.id.txt_menu_2, r0.getMenuName());
                    bVar.b((int) R.id.img_menu_2, r0.getMenuImage());
                    bVar.a((int) R.id.item_menu_2, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 b;

                        public void onClick(View view) {
                            if (!y.c()) {
                                this.b.a.b("APP_消息提醒页_所有菜谱区域", "fridgeapp_201609146|6");
                                aa.b(this.b.a, r0.getMenuId(), r0.getMenuName());
                            }
                        }
                    });
                }
            }
        });
        this.l.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FoodNoticeActivity a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                JPushReceiverMsgDataBean msg_content = ((FoodNoticeDataBean) this.a.o.get(i)).getMsg_content();
                if (!msg_content.getCode().equals("not_move_region")) {
                    return;
                }
                if (y.d(this.a.getApplicationContext())) {
                    Intent intent = new Intent(this.a, FoodNoMoveActivity.class);
                    intent.putExtra("recognition_date", msg_content.getData().getRecognition_date() == null ? "" : msg_content.getData().getRecognition_date());
                    intent.putExtra("time", y.a(msg_content.getTime(), "MM-dd HH:mm"));
                    int day_count = msg_content.getData().getDay_count();
                    intent.putExtra("tip", this.a.getString(R.string.activity_food_no_move_tip, new Object[]{Integer.valueOf(day_count)}));
                    this.a.startActivity(intent);
                    return;
                }
                Toast.makeText(this.a.getApplicationContext(), this.a.getString(R.string.error_view_network_error_toast), 0).show();
            }
        });
    }

    private Object d(String str) {
        return e.a(str, (Context) this, a.CACHE_MODEL_MAX);
    }

    private List<FoodNoticeDataBean> a(int i) {
        ArrayList arrayList;
        switch (i) {
            case R.id.filter_all:
                this.c.setText(R.string.activity_food_notice_title);
                return this.n;
            case R.id.filter_due:
                this.c.setText(R.string.activity_food_notice_cus_alarm_title);
                arrayList = new ArrayList();
                for (FoodNoticeDataBean foodNoticeDataBean : this.n) {
                    if (foodNoticeDataBean.getMsg_content().getCode().equals("cus_alarm")) {
                        arrayList.add(foodNoticeDataBean);
                    }
                }
                return arrayList;
            case R.id.filter_overdue:
                this.c.setText(R.string.activity_food_notice_sys_expired_title);
                arrayList = new ArrayList();
                for (FoodNoticeDataBean foodNoticeDataBean2 : this.n) {
                    if (foodNoticeDataBean2.getMsg_content().getCode().equals("sys_expired")) {
                        arrayList.add(foodNoticeDataBean2);
                    }
                }
                return arrayList;
            default:
                return this.n;
        }
    }

    protected void onDestroy() {
        List list;
        this.a.unregisterReceiver(this.s);
        List list2 = (List) e.a(b.b(), this.a, a.CACHE_MODEL_MAX);
        if (list2 == null) {
            k.a("data==null==");
            list = (List) e.a(b.c(), this.a, a.CACHE_MODEL_MAX);
        } else {
            list = list2;
        }
        k.a("data==" + list);
        if (list != null && list.size() > 0) {
            k.a("data.size==" + list.size());
            HashMap hashMap = (HashMap) e.a(b.a(), this.a, a.CACHE_MODEL_MAX);
            HashMap hashMap2 = (HashMap) e.a(b.d(), this.a, a.CACHE_MODEL_MAX);
            for (int size = list.size() - 1; size >= 0; size--) {
                FoodNoticeDataBean foodNoticeDataBean = (FoodNoticeDataBean) list.get(size);
                String noticeId = foodNoticeDataBean.getNoticeId();
                if (!this.p.containsKey(noticeId)) {
                    this.n.add(0, foodNoticeDataBean);
                    if (hashMap2 != null) {
                        k.a("GaoPeng: FoodNoticeActivity, OnDestory------menuData not null, noticeId = " + noticeId);
                        this.q.put(noticeId, hashMap2.get(noticeId));
                    }
                    if (hashMap != null) {
                        k.a("GaoPeng: FoodNoticeActivity, OnDestory------statusData not null, noticeId = " + noticeId);
                        this.p.put(noticeId, hashMap.get(noticeId));
                    } else {
                        k.a("GaoPeng: FoodNoticeActivity, OnDestory------statusData is null, create a new status, noticeId = " + noticeId);
                        FoodNoticeStatusDataBean foodNoticeStatusDataBean = new FoodNoticeStatusDataBean();
                        foodNoticeStatusDataBean.setDeleted(false);
                        foodNoticeStatusDataBean.setReaded(true);
                        this.p.put(noticeId, foodNoticeStatusDataBean);
                    }
                }
            }
            e();
            e.a(b.b(), (Context) this, this.n);
            e.a(b.d(), (Context) this, this.q);
        }
        super.onDestroy();
    }

    private void e() {
        if (this.p != null) {
            if (this.n != null) {
                for (FoodNoticeDataBean foodNoticeDataBean : this.n) {
                    if (this.p.get(foodNoticeDataBean.getNoticeId()) != null) {
                        ((FoodNoticeStatusDataBean) this.p.get(foodNoticeDataBean.getNoticeId())).setReaded(true);
                    }
                }
            }
            e.a(b.a(), (Context) this, this.p);
        }
    }

    protected void d() {
    }

    private void f() {
        this.b = (RelativeLayout) findViewById(R.id.app_title);
        this.c = (TextView) findViewById(R.id.app_title_textview);
        this.c.setText(R.string.activity_food_notice_title);
        this.d = (ImageView) findViewById(R.id.left_appbar_btn);
        this.d.setImageResource(R.drawable.appbar_back_selector);
        this.d.setVisibility(0);
        this.d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FoodNoticeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.finish();
            }
        });
        this.i = (ImageView) findViewById(R.id.right_appbar_btn);
        this.i.setImageResource(R.drawable.appbar_filter_selector);
        this.i.setVisibility(8);
        this.i.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FoodNoticeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.h();
            }
        });
    }

    private void g() {
        this.j = (LinearLayout) getLayoutInflater().inflate(R.layout.food_notice_filter_popup_layout, null);
        this.j.findViewById(R.id.filter_all).setOnClickListener(this.t);
        this.j.findViewById(R.id.filter_due).setOnClickListener(this.t);
        this.j.findViewById(R.id.filter_overdue).setOnClickListener(this.t);
        this.k = new PopupWindow(this.j, (int) getResources().getDimension(R.dimen.filter_popup_width), -2);
        this.k.setFocusable(true);
        this.k.setOutsideTouchable(true);
        this.k.setTouchable(true);
        this.k.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_window_bg_drawable));
    }

    private void h() {
        this.k.showAsDropDown(this.b, GlobalVariable.a().q() - ((int) (((float) (h.a(getBaseContext(), getResources().getDimension(R.dimen.filter_popup_x_offset)) + h.a(getBaseContext(), getResources().getDimension(R.dimen.filter_popup_width)))) / GlobalVariable.a().p())), 0);
        this.k.update();
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
        if (!y.c()) {
            new com.jd.fridge.widget.b.a(this).a((int) R.string.activity_food_notice_deleted_hint).a(com.jd.fridge.widget.b.a.b.DOUBLE_BTN).b((int) R.string.activity_food_notice_no_btn).c((int) R.string.activity_food_notice_yes_btn).a(new com.jd.fridge.widget.b.a.a(this) {
                final /* synthetic */ FoodNoticeActivity b;

                public void a() {
                    FoodNoticeDataBean foodNoticeDataBean = (FoodNoticeDataBean) this.b.o.get(i);
                    this.b.o.remove(i);
                    ((com.jd.fridge.widget.a.a) this.b.l.getAdapter()).notifyDataSetChanged();
                    this.b.p.remove(foodNoticeDataBean.getNoticeId());
                    this.b.n.remove(foodNoticeDataBean);
                    this.b.q.remove(foodNoticeDataBean.getNoticeId());
                    e.a(b.b(), this.b.getBaseContext(), this.b.n);
                    e.a(b.d(), this.b.getBaseContext(), this.b.q);
                    e.a(b.a(), this.b.getBaseContext(), this.b.p);
                }

                public void b() {
                }
            }).show();
        }
        return false;
    }
}
