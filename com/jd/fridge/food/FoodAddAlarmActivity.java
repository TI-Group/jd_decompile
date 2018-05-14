package com.jd.fridge.food;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FoodCategoryListDataBean;
import com.jd.fridge.bean.FoodDishListDataBaseBean;
import com.jd.fridge.bean.FoodDishListDataBean;
import com.jd.fridge.bean.ParamsCommonFoodDishListBean;
import com.jd.fridge.bean.ParamsFoodDishListBean;
import com.jd.fridge.bean.requestBody.AddGoodsList;
import com.jd.fridge.food.a.c;
import com.jd.fridge.food.a.c.b;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.d.a;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView.d;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView.e;

/* compiled from: TbsSdkJava */
public class FoodAddAlarmActivity extends BaseActivity implements OnClickListener, b, a, d, e {
    private List<FoodCategoryListDataBean> a;
    private List<FoodDishListDataBean> b;
    @BindView(2131558590)
    RelativeLayout bottomLayout;
    @BindView(2131558597)
    RelativeLayout bottomLeftLayout;
    private List<FoodDishListDataBean> c;
    @BindView(2131558591)
    ListView categoryListView;
    @BindView(2131558594)
    TextView clearTextView;
    @BindView(2131558596)
    TextView confirmTextView;
    private List<FoodDishListDataBean> d;
    @BindView(2131558592)
    StickyListHeadersListView dishListView;
    @BindView(2131558598)
    ImageView fridgeImageView;
    private List<FoodDishListDataBean> i;
    private com.jd.fridge.food.a.b j;
    private c k;
    private ArrayList<Integer> l;
    @BindView(2131558673)
    ImageView leftIconBtn;
    private com.jd.fridge.util.d m;
    @BindView(2131558580)
    RelativeLayout mEmptyLayout;
    @BindView(2131558576)
    EmptyLayout mEmptyLayoutRoot;
    private boolean n = true;
    private com.jd.fridge.food.a.a o;
    private com.jd.fridge.widget.b.b.a p = new com.jd.fridge.widget.b.b.a(this) {
        final /* synthetic */ FoodAddAlarmActivity a;

        {
            this.a = r1;
        }

        public void a(List<FoodDishListDataBean> list, FoodDishListDataBean foodDishListDataBean, boolean z) {
            if (z) {
                this.a.a(foodDishListDataBean, false);
                this.a.k.notifyDataSetChanged();
            }
            if (this.a.i.size() <= 0) {
                this.a.t();
                this.a.n = true;
                this.a.bottomLeftLayout.setEnabled(false);
                this.a.confirmTextView.setEnabled(false);
                this.a.pointTextView.setVisibility(8);
                this.a.confirmTextView.setBackgroundColor(ContextCompat.getColor(this.a, R.color.jd_gray_5));
                return;
            }
            this.a.pointTextView.setText(String.valueOf(this.a.i.size()));
        }
    };
    @BindView(2131558599)
    TextView pointTextView;
    @BindView(2131558593)
    RelativeLayout popupLayout;
    @BindView(2131558595)
    ListView popupListView;
    @BindView(2131558582)
    ProgressBar progressBar;
    @BindView(2131558585)
    RelativeLayout rootLayout;
    @BindView(2131558587)
    EditText searchEditText;
    @BindView(2131558586)
    RelativeLayout searchLayout;
    @BindView(2131558675)
    TextView titleTextView;

    protected int a() {
        return R.layout.activity_food_add_alarm;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        k();
        this.titleTextView.setText(getResources().getString(R.string.activity_food_add_alarm_title));
        this.leftIconBtn.setImageResource(R.drawable.appbar_back_selector);
        this.leftIconBtn.setVisibility(0);
        this.leftIconBtn.setOnClickListener(this);
        this.dishListView.setAreHeadersSticky(true);
        this.dishListView.setOnStickyHeaderChangedListener(this);
        this.categoryListView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FoodAddAlarmActivity a;

            {
                this.a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.a.a((FoodCategoryListDataBean) this.a.a.get(i), i);
            }
        });
        this.searchEditText.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FoodAddAlarmActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                aa.h(this.a);
            }
        });
        this.confirmTextView.setOnClickListener(this);
        this.bottomLeftLayout.setOnClickListener(this);
        this.popupLayout.setOnClickListener(this);
        this.clearTextView.setOnClickListener(this);
        this.mEmptyLayoutRoot.setRefresh(new OnClickListener(this) {
            final /* synthetic */ FoodAddAlarmActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (y.d(this.a)) {
                        this.a.f();
                        this.a.mEmptyLayout.setVisibility(8);
                        this.a.mEmptyLayoutRoot.setErrorType(4);
                        this.a.bottomLeftLayout.setVisibility(0);
                        this.a.bottomLayout.setVisibility(0);
                        return;
                    }
                    this.a.mEmptyLayout.setVisibility(0);
                    this.a.mEmptyLayoutRoot.setErrorType(1);
                    x.a(this.a, "网络断了哦，请检查网络设置");
                }
            }
        });
        if (!y.d((Context) this)) {
            this.mEmptyLayout.setVisibility(0);
            this.mEmptyLayoutRoot.setErrorType(1);
            this.bottomLeftLayout.setVisibility(8);
            this.bottomLayout.setVisibility(8);
            this.progressBar.setVisibility(8);
        }
    }

    protected void c() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.i = new ArrayList();
        this.m = new com.jd.fridge.util.d();
        this.m.setOnAnimationEndListener(this);
        f();
    }

    protected void d() {
    }

    private void f() {
        com.jd.fridge.a.a().c(this.e);
    }

    private long g() {
        long j = 0;
        try {
            j = Long.parseLong(GlobalVariable.C());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        r.c("infos", "feedid-----" + j + "---pin----" + GlobalVariable.I());
        return j;
    }

    private void h() {
        if (!this.a.isEmpty()) {
            this.categoryListView.setVisibility(0);
            this.j = new com.jd.fridge.food.a.b(this, this.a, (FoodCategoryListDataBean) this.a.get(0));
            this.categoryListView.setAdapter(this.j);
        }
    }

    private void i() {
        this.k = new c(this, this.d, this.a);
        this.k.setAddAlarmClickListener(this);
        this.dishListView.setAdapter(this.k);
    }

    private void p() {
        Collections.sort(this.d, new Comparator<FoodDishListDataBean>(this) {
            final /* synthetic */ FoodAddAlarmActivity a;

            {
                this.a = r1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return a((FoodDishListDataBean) obj, (FoodDishListDataBean) obj2);
            }

            public int a(FoodDishListDataBean foodDishListDataBean, FoodDishListDataBean foodDishListDataBean2) {
                if (foodDishListDataBean == null || foodDishListDataBean2 == null) {
                    return 0;
                }
                if (foodDishListDataBean.getCategory_id() > foodDishListDataBean2.getCategory_id()) {
                    return 1;
                }
                if (foodDishListDataBean.getCategory_id() != foodDishListDataBean2.getCategory_id()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    private void q() {
        FoodCategoryListDataBean foodCategoryListDataBean = new FoodCategoryListDataBean();
        foodCategoryListDataBean.setCategory_id(-1);
        foodCategoryListDataBean.setCategory_name(getResources().getString(R.string.common));
        this.a.add(foodCategoryListDataBean);
        Collections.sort(this.a, new Comparator<FoodCategoryListDataBean>(this) {
            final /* synthetic */ FoodAddAlarmActivity a;

            {
                this.a = r1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return a((FoodCategoryListDataBean) obj, (FoodCategoryListDataBean) obj2);
            }

            public int a(FoodCategoryListDataBean foodCategoryListDataBean, FoodCategoryListDataBean foodCategoryListDataBean2) {
                if (foodCategoryListDataBean == null || foodCategoryListDataBean2 == null) {
                    return 0;
                }
                if (foodCategoryListDataBean.getCategory_id() > foodCategoryListDataBean2.getCategory_id()) {
                    return 1;
                }
                if (foodCategoryListDataBean.getCategory_id() != foodCategoryListDataBean2.getCategory_id()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    private void r() {
        this.l = new ArrayList();
        if (!this.d.isEmpty() && ((FoodDishListDataBean) this.d.get(0)).getCategoryBean() != null) {
            int category_id = ((FoodDishListDataBean) this.d.get(0)).getCategoryBean().getCategory_id();
            this.l.add(Integer.valueOf(0));
            int i = category_id;
            for (category_id = 1; category_id < this.d.size(); category_id++) {
                int category_id2 = ((FoodDishListDataBean) this.d.get(category_id)).getCategoryBean().getCategory_id();
                if (category_id2 != i) {
                    this.l.add(Integer.valueOf(category_id));
                    i = category_id2;
                }
            }
        }
    }

    private void a(FoodCategoryListDataBean foodCategoryListDataBean, int i) {
        if (!(this.l == null || this.l.isEmpty() || i >= this.l.size())) {
            int intValue = ((Integer) this.l.get(i)).intValue();
            r.c("infos", "index===" + i + "==dishIndex==" + intValue);
            this.dishListView.setSelection(intValue);
        }
        this.j.a(foodCategoryListDataBean);
    }

    public boolean a(Message message) {
        FoodDishListDataBaseBean foodDishListDataBaseBean;
        switch (message.what) {
            case 2000:
                this.a = (List) message.obj;
                if (!(this.a == null || this.a.isEmpty())) {
                    q();
                    r.c("infos", "2222222222===" + this.a.size());
                    com.jd.fridge.a.a().a(this.e, new ParamsCommonFoodDishListBean(g(), GlobalVariable.I()));
                }
                r.c("infos", "===左侧加载成功===");
                break;
            case 2001:
                r.c("infos", "===左侧加载失败===");
                break;
            case 7000:
                this.b = (List) message.obj;
                if (!(this.b == null || this.b.isEmpty())) {
                    this.d.addAll(this.b);
                    if (!(this.a == null || this.a.isEmpty())) {
                        for (FoodCategoryListDataBean foodCategoryListDataBean : this.a) {
                            for (FoodDishListDataBean foodDishListDataBean : this.d) {
                                if (foodDishListDataBean.getCategory_id() == foodCategoryListDataBean.getCategory_id()) {
                                    foodDishListDataBean.setCategoryBean(foodCategoryListDataBean);
                                    foodCategoryListDataBean.setCount(foodCategoryListDataBean.getCount() + 1);
                                }
                            }
                        }
                    }
                    p();
                    r();
                    h();
                    i();
                    this.progressBar.setVisibility(8);
                    this.bottomLeftLayout.setVisibility(0);
                    this.bottomLayout.setVisibility(0);
                    this.searchLayout.setVisibility(0);
                    r.c("infos", "555555555555===" + this.d.size());
                    break;
                }
            case 7001:
                r.c("infos", "===右侧加载失败===");
                break;
            case 7002:
                this.c = (List) message.obj;
                if (!(this.c == null || this.c.isEmpty())) {
                    this.d.addAll(this.c);
                    for (FoodDishListDataBean foodDishListDataBean2 : this.c) {
                        foodDishListDataBean2.setTemp_category_id(foodDishListDataBean2.getCategory_id());
                        foodDishListDataBean2.setCategory_id(-1);
                        r.c("infos", "dish.name==" + foodDishListDataBean2.getGoods_name() + "==cateid=" + foodDishListDataBean2.getCategory_id() + "==tempid==" + foodDishListDataBean2.getTemp_category_id() + "==expire=" + foodDishListDataBean2.getDefault_expire());
                    }
                }
                com.jd.fridge.a.a().a(this.e, new ParamsFoodDishListBean(0, 0, g(), GlobalVariable.I()));
                break;
            case 7003:
                r.c("infos", "===右侧常用加载失败===");
                break;
            case 7006:
                x.a((Context) this, getResources().getString(R.string.add_food_alarm_success_string));
                t();
                setResult(-1);
                finish();
                break;
            case 7007:
                r.c("infos", "===添加食物闹钟失败===");
                break;
            case 7008:
                List<FoodDishListDataBean> list = (List) message.obj;
                String str = "";
                if (!(list == null || list.isEmpty() || this.i.isEmpty())) {
                    for (FoodDishListDataBean foodDishListDataBean3 : list) {
                        r.c("infoss", "name==" + foodDishListDataBean3.getCustomized_name() + "==id==" + foodDishListDataBean3.getGoods_id());
                        for (FoodDishListDataBean foodDishListDataBean4 : this.i) {
                            String str2;
                            if (foodDishListDataBean3.getGoods_id() == foodDishListDataBean4.getGoods_id()) {
                                str2 = str + foodDishListDataBean4.getGoods_name() + "、";
                            } else {
                                str2 = str;
                            }
                            str = str2;
                        }
                    }
                    str = str.substring(0, str.length() - 1);
                }
                a(str + getResources().getString(R.string.add_food_alarm_have_repeat_alarm), getResources().getString(R.string.confirm), (List) list);
                break;
            case 7018:
                foodDishListDataBaseBean = (FoodDishListDataBaseBean) message.obj;
                if (!(foodDishListDataBaseBean == null || foodDishListDataBaseBean.getError() == null)) {
                    x.a((Context) this, foodDishListDataBaseBean.getError().getErrorInfo());
                    break;
                }
            case 7019:
                String str3 = (String) message.obj;
                if (!TextUtils.isEmpty(str3)) {
                    x.a((Context) this, str3);
                    break;
                }
                break;
            case 7020:
                foodDishListDataBaseBean = (FoodDishListDataBaseBean) message.obj;
                if (!(foodDishListDataBaseBean == null || foodDishListDataBaseBean.getError() == null)) {
                    x.a((Context) this, foodDishListDataBaseBean.getError().getErrorInfo());
                    break;
                }
        }
        return super.a(message);
    }

    public void a(StickyListHeadersListView stickyListHeadersListView, View view, int i, long j) {
        if (j >= 0 && !this.a.isEmpty()) {
            this.categoryListView.setSelection((int) j);
            this.j.a((FoodCategoryListDataBean) this.a.get((int) j));
        }
    }

    public void a(StickyListHeadersListView stickyListHeadersListView, View view, int i) {
    }

    public void a(View view, ImageView imageView, FoodDishListDataBean foodDishListDataBean) {
        if (!a(foodDishListDataBean)) {
            this.i.add(foodDishListDataBean);
        }
        if (this.i.size() >= 1) {
            this.confirmTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.food_dish_adapter_right_button_add_textColor));
            this.bottomLeftLayout.setEnabled(true);
            this.confirmTextView.setEnabled(true);
        }
        this.m.a(this, this.rootLayout, view, imageView, this.fridgeImageView);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 10001) {
            int intExtra = intent.getIntExtra("category_id", -2);
            int intExtra2 = intent.getIntExtra("goods_id", -2);
            if (intExtra >= -1) {
                int indexOf = this.a.indexOf(this.a.get(intExtra));
                a((FoodCategoryListDataBean) this.a.get(indexOf), indexOf);
                if (this.d != null && !this.d.isEmpty()) {
                    for (indexOf = 0; indexOf < this.d.size(); indexOf++) {
                        if (((FoodDishListDataBean) this.d.get(indexOf)).getGoods_id() == intExtra2) {
                            this.k.a((FoodDishListDataBean) this.d.get(indexOf));
                            this.dishListView.setSelection(indexOf);
                            r.c("infos", "i====" + indexOf);
                        }
                    }
                }
            }
        }
    }

    public void e() {
        if (this.pointTextView.getVisibility() == 8) {
            this.pointTextView.setVisibility(0);
        }
        this.pointTextView.setText(String.valueOf(this.i.size()));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.food_add_alarm_popup_layout:
                b(this.popupLayout);
                this.n = true;
                return;
            case R.id.food_add_alarm_popup_window_clear_textView:
                if (!this.i.isEmpty()) {
                    for (FoodDishListDataBean a : this.i) {
                        a(a, false);
                    }
                }
                this.k.notifyDataSetChanged();
                s();
                return;
            case R.id.food_add_alarm_bottom_layout_confirm_textView:
                if (this.i != null && !this.i.isEmpty()) {
                    if (y.d((Context) this)) {
                        com.jd.fridge.a.a().a(this.e, new AddGoodsList(GlobalVariable.I(), g(), a(this.i)));
                        return;
                    }
                    x.a((Context) this, getResources().getString(R.string.error_view_network_error_toast));
                    return;
                }
                return;
            case R.id.food_add_alarm_bottom_left_layout:
                if (!this.n || this.i.isEmpty()) {
                    this.n = true;
                    t();
                    return;
                }
                this.n = false;
                this.popupLayout.setVisibility(0);
                this.o = new com.jd.fridge.food.a.a(this, this.i, this.p);
                this.popupListView.setAdapter(this.o);
                a(this.popupLayout);
                return;
            case R.id.left_appbar_btn:
                finish();
                return;
            default:
                return;
        }
    }

    private boolean a(FoodDishListDataBean foodDishListDataBean) {
        if (!this.i.isEmpty()) {
            for (FoodDishListDataBean goods_id : this.i) {
                if (goods_id.getGoods_id() == foodDishListDataBean.getGoods_id()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(FoodDishListDataBean foodDishListDataBean, boolean z) {
        if (!this.d.isEmpty()) {
            for (FoodDishListDataBean foodDishListDataBean2 : this.d) {
                if (foodDishListDataBean != null && foodDishListDataBean.getGoods_id() == foodDishListDataBean2.getGoods_id()) {
                    if (z) {
                        foodDishListDataBean2.setHas_alarm(true);
                    } else {
                        foodDishListDataBean2.setHas_alarm(false);
                    }
                }
            }
        }
    }

    private String a(List<FoodDishListDataBean> list) {
        String str = "";
        if (list == null || list.isEmpty()) {
            return str;
        }
        String str2 = str;
        for (int i = 0; i < list.size(); i++) {
            int default_expire;
            if (((FoodDishListDataBean) list.get(i)).getCategory_id() < 0) {
                default_expire = ((FoodDishListDataBean) list.get(i)).getDefault_expire();
            } else {
                default_expire = ((FoodDishListDataBean) list.get(i)).getDefault_expired();
            }
            StringBuilder append = new StringBuilder().append(str2).append("{\"goods_id\":").append(((FoodDishListDataBean) list.get(i)).getGoods_id()).append(",\"expire\":");
            if (default_expire < 1) {
                default_expire = 1;
            }
            str2 = append.append(default_expire).append(",\"expire_unit\":").append(((FoodDishListDataBean) list.get(i)).getDefault_expire_unit()).append(",\"add_source\":").append(1).append(",\"zone\":").append(0).append("},").toString();
        }
        return "[" + str2.substring(0, str2.length() - 1) + "]";
    }

    private List<FoodDishListDataBean> b(List<FoodDishListDataBean> list) {
        List<FoodDishListDataBean> arrayList = new ArrayList();
        arrayList.addAll(this.i);
        if (!(list == null || list.isEmpty() || this.i.isEmpty())) {
            for (FoodDishListDataBean foodDishListDataBean : list) {
                for (FoodDishListDataBean foodDishListDataBean2 : this.i) {
                    if (foodDishListDataBean.getGoods_id() == foodDishListDataBean2.getGoods_id()) {
                        arrayList.remove(foodDishListDataBean2);
                    }
                }
            }
        }
        return arrayList;
    }

    private void s() {
        this.i.clear();
        t();
        this.n = true;
        this.bottomLeftLayout.setEnabled(false);
        this.confirmTextView.setEnabled(false);
        this.pointTextView.setVisibility(8);
        this.confirmTextView.setBackgroundColor(ContextCompat.getColor(this, R.color.jd_gray_5));
    }

    private void t() {
        if (this.popupLayout.getVisibility() == 0) {
            b(this.popupLayout);
        }
    }

    private void a(String str, String str2, final List<FoodDishListDataBean> list) {
        new com.jd.fridge.widget.b.a(this, R.layout.unbind_phone_confirm_dlg_layout).b(str).a(com.jd.fridge.widget.b.a.b.DOUBLE_BTN).c(str2).b((int) R.string.cancel_exit).a(new com.jd.fridge.widget.b.a.a(this) {
            final /* synthetic */ FoodAddAlarmActivity b;

            public void a() {
                if (list != null && list.size() > 0) {
                    if (this.b.b(list).isEmpty()) {
                        this.b.s();
                        return;
                    }
                    com.jd.fridge.a.a().a(this.b.e, new AddGoodsList(GlobalVariable.I(), this.b.g(), this.b.a(this.b.b(list))));
                }
            }

            public void b() {
            }
        }).show();
    }

    private void a(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.addfood_pop_enter);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FoodAddAlarmActivity b;

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
                aa.a(this.b, 0.9f);
            }

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void b(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.addfood_pop_out);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ FoodAddAlarmActivity b;

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
                aa.a(this.b, 1.0f);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
