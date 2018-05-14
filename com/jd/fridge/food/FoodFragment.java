package com.jd.fridge.food;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.HomeActivity;
import com.jd.fridge.R;
import com.jd.fridge.base.LazyFragment;
import com.jd.fridge.bean.Event;
import com.jd.fridge.bean.FoodsListDataBean;
import com.jd.fridge.bean.FridgeDoorImgBean;
import com.jd.fridge.bean.GetCodeBean;
import com.jd.fridge.bean.GetShareContentBean;
import com.jd.fridge.bean.ShareContent;
import com.jd.fridge.bean.ShareDataBean;
import com.jd.fridge.bean.StockDataBean;
import com.jd.fridge.bean.requestBody.FeedId;
import com.jd.fridge.bean.requestBody.Share;
import com.jd.fridge.bean.requestBody.Stock;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.e;
import com.jd.fridge.util.h;
import com.jd.fridge.util.k;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.GoodsGridView;
import com.jd.fridge.widget.viewpageindicator.CirclePageIndicator;
import com.jingdong.jdma.JDMaInterface;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.login.KeplerApiManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class FoodFragment extends LazyFragment {
    @BindView(2131558894)
    LinearLayout cameraBreakLayout;
    @BindView(2131558962)
    ImageView cameraTopImage;
    @BindView(2131558604)
    ScrollView data_layout;
    private Gson e;
    private Bundle f;
    @BindView(2131558956)
    RelativeLayout fridge_inner_picture_layout;
    private List<FridgeDoorImgBean> g = new ArrayList();
    @BindView(2131558967)
    GoodsGridView goodsGridView;
    private a h;
    @BindView(2131558961)
    LinearLayout hxCameraLayout;
    @BindView(2131558963)
    TextView hxCameraTimeText;
    private b i;
    private List<FoodsListDataBean> j;
    private boolean k;
    private ShareDataBean l = null;
    @BindView(2131558576)
    EmptyLayout mEmptyLayout;
    @BindView(2131558892)
    TextView mFoodTitleTxt;
    @BindView(2131558958)
    CirclePageIndicator mFridgeImgCPI;
    @BindView(2131558957)
    ViewPager mFridgeImgVP;
    @BindView(2131558959)
    TextView mImgTime;
    @BindView(2131558890)
    ImageView mNoticeBtn;
    @BindView(2131558891)
    TextView mNoticeNum;
    @BindView(2131558893)
    ImageView mNutritionBtn;
    @BindView(2131558960)
    ImageView mShareBtn;
    @BindView(2131558966)
    FrameLayout recommend_goodsList;
    @BindView(2131558965)
    View recommend_tip;

    /* compiled from: TbsSdkJava */
    private class a extends FragmentStatePagerAdapter {
        final /* synthetic */ FoodFragment a;
        private List<FridgeDoorImgBean> b = null;

        public a(FoodFragment foodFragment, List<FridgeDoorImgBean> list) {
            this.a = foodFragment;
            super(foodFragment.getFragmentManager());
            this.b = list;
        }

        public Fragment getItem(int i) {
            Bundle bundle = new Bundle();
            if (!(this.b == null || this.b.size() <= 0 || this.b.get(i) == null)) {
                bundle.putString("url", ((FridgeDoorImgBean) this.b.get(i)).getPic_url());
            }
            return Fragment.instantiate(this.a.getActivity(), FridgeImageFragment.class.getName(), bundle);
        }

        public int getCount() {
            if (this.b != null) {
                return this.b.size();
            }
            return 0;
        }
    }

    /* compiled from: TbsSdkJava */
    class b extends BroadcastReceiver {
        final /* synthetic */ FoodFragment a;

        b(FoodFragment foodFragment) {
            this.a = foodFragment;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("BR_ACTION_FRIDGE_UNBINDED_2001")) {
                this.a.f();
                return;
            }
            k.a("intent.hasExtra(FLAG_ACTION_UPDATE_NEW_NOTICE_NUM)====" + intent.hasExtra("FLAG_ACTION_UPDATE_NEW_NOTICE_NUM"));
            if (intent.hasExtra("FLAG_ACTION_UPDATE_VIEW_FOOD")) {
                this.a.h();
            }
            if (intent.hasExtra("FLAG_ACTION_UPDATE_NEW_NOTICE_NUM")) {
                this.a.g();
            }
            if (intent.hasExtra("FLAG_ACTION_HAVE_NETWORK") && this.a.mEmptyLayout.getErrorState() == 11) {
                this.a.mEmptyLayout.setErrorType(4);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f = getArguments();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = new Gson();
        View inflate = layoutInflater.inflate(R.layout.fragment_food, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        this.recommend_tip.setVisibility(8);
        this.recommend_goodsList.setVisibility(8);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("updateViewFood");
        intentFilter.addAction("BR_ACTION_FRIDGE_UNBINDED_2001");
        this.i = new b(this);
        b().registerReceiver(this.i, intentFilter);
        this.k = true;
        if ("0".equals(GlobalVariable.C()) || TextUtils.isEmpty(GlobalVariable.C())) {
            f();
            ((HomeActivity) b()).f();
            return;
        }
        this.mEmptyLayout.setErrorType(2);
        HashMap hashMap = (HashMap) e.a("fridgeImgList.cac", b(), com.jd.fridge.util.e.a.CACHE_MODEL_MAX);
        if (hashMap != null) {
            this.g = (List) hashMap.get(GlobalVariable.C());
            a(false);
        }
        c();
    }

    protected void c() {
        if (this.k && this.d) {
            g();
            h();
            a("食物首页");
            com.jd.fridge.kepler.a.a(this.a, com.jd.fridge.util.c.a.b());
        }
    }

    public void onDestroy() {
        if (this.i != null) {
            b().unregisterReceiver(this.i);
        }
        super.onDestroy();
    }

    public boolean handleMessage(Message message) {
        List list;
        HashMap hashMap;
        switch (message.what) {
            case 2000:
                list = (List) message.obj;
                if (list == null) {
                    list = new ArrayList();
                }
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                if (list.size() > 0) {
                    this.g.clear();
                    for (int i = 0; i < list.size(); i++) {
                        this.g.add(list.get(i));
                    }
                    a(this.g);
                }
                Object hashMap2 = new HashMap();
                hashMap2.put(GlobalVariable.C(), this.g);
                e.a("fridgeImgList.cac", b(), hashMap2);
                a(false);
                if (!(TextUtils.equals(GlobalVariable.C(), "0") || com.jd.fridge.util.e.b.a().d().equalsIgnoreCase("RUY8KB") || com.jd.fridge.util.e.b.a().d().equalsIgnoreCase("D84DD0"))) {
                    com.jd.fridge.a.a().a(this.a, new Stock(Long.parseLong(GlobalVariable.C()), new int[]{1}));
                    break;
                }
            case 2001:
                if (com.jd.fridge.util.e.b.a().d().equalsIgnoreCase("RUY8KB") || com.jd.fridge.util.e.b.a().d().equalsIgnoreCase("D84DD0")) {
                    x.b(getActivity(), "服务器开小差啦，请稍等一下");
                }
                hashMap = (HashMap) e.a("fridgeImgList.cac", b(), com.jd.fridge.util.e.a.CACHE_MODEL_MAX);
                if (hashMap != null) {
                    this.g = (List) hashMap.get(GlobalVariable.C());
                }
                if (this.g != null) {
                    a(false);
                    this.mEmptyLayout.setErrorType(10);
                    break;
                }
                this.data_layout.setVisibility(8);
                this.mNutritionBtn.setVisibility(0);
                this.mEmptyLayout.setErrorType(8);
                break;
            case 2002:
                hashMap = (HashMap) e.a("fridgeImgList.cac", b(), com.jd.fridge.util.e.a.CACHE_MODEL_MAX);
                if (hashMap != null) {
                    this.g = (List) hashMap.get(GlobalVariable.C());
                }
                if (this.g != null) {
                    a(false);
                    this.mEmptyLayout.setErrorType(11);
                    break;
                }
                this.data_layout.setVisibility(8);
                this.mNutritionBtn.setVisibility(0);
                this.mEmptyLayout.setErrorType(1);
                this.mEmptyLayout.setRefresh(new OnClickListener(this) {
                    final /* synthetic */ FoodFragment a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        if (!y.c()) {
                            this.a.h();
                        }
                    }
                });
                break;
            case 2018:
                GetShareContentBean getShareContentBean = (GetShareContentBean) message.obj;
                if (getShareContentBean.getStatus() == 0 && getShareContentBean.getError() == null) {
                    ShareContent result = getShareContentBean.getResult();
                    this.l = new ShareDataBean();
                    this.l.setSharePicUrl(result.getShareImg());
                    this.l.setShareText(result.getShareDes());
                    this.l.setShareTitle(result.getShareTitle());
                    this.l.setShareUrl(result.getShareLink());
                    break;
                }
            case 3000:
                this.j = (List) message.obj;
                if (this.j != null && this.j.size() > 0) {
                    if (this.j.size() > 10) {
                        this.j = this.j.subList(0, 10);
                    }
                    this.recommend_tip.setVisibility(0);
                    this.recommend_goodsList.setVisibility(0);
                    this.goodsGridView.setAdapter(new com.jd.fridge.widget.a.a<FoodsListDataBean>(this, b(), this.j, R.layout.item_goods) {
                        final /* synthetic */ FoodFragment a;

                        public void a(com.jd.fridge.widget.a.b bVar, FoodsListDataBean foodsListDataBean) {
                            double d = JDMaInterface.PV_UPPERLIMIT;
                            bVar.a((int) R.id.tv_product_name, foodsListDataBean.getTitle());
                            DecimalFormat decimalFormat = new DecimalFormat("0.00");
                            StringBuilder append = new StringBuilder().append("¥ ");
                            if (foodsListDataBean.getPrice() > JDMaInterface.PV_UPPERLIMIT) {
                                d = foodsListDataBean.getPrice();
                            }
                            String stringBuilder = append.append(decimalFormat.format(d)).toString();
                            bVar.a((int) R.id.tv_product_origin_price, "");
                            bVar.c(R.id.tv_product_origin_price, 8);
                            bVar.a((int) R.id.tv_product_current_price, stringBuilder);
                            bVar.c(R.id.tv_tip_fridge_only, 4);
                            bVar.b((int) R.id.iv_product_img, foodsListDataBean.getImgUrl());
                        }
                    });
                    this.goodsGridView.setOnItemClickListener(new OnItemClickListener(this) {
                        final /* synthetic */ FoodFragment a;

                        {
                            this.a = r1;
                        }

                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            try {
                                this.a.a("APP_食物首页_鸡蛋缺货SKU区域", "fridgeapp_201609146|4");
                                KeplerApiManager.getWebViewService().openItemDetailsWebViewPage(String.valueOf(((FoodsListDataBean) this.a.j.get(i)).getSku()), "统计0");
                            } catch (Exception e) {
                            }
                        }
                    });
                    break;
                }
                this.recommend_tip.setVisibility(8);
                this.recommend_goodsList.setVisibility(8);
                break;
            case 4000:
                list = (List) message.obj;
                if (list != null && list.size() == 1) {
                    if (((StockDataBean) list.get(0)).getCurr_count() <= 2) {
                        try {
                            com.jd.fridge.a.a().a(this.a, URLEncoder.encode("鸡蛋", HTTP.UTF_8), 10);
                            break;
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                } else if (list != null && list.size() == 0) {
                    this.recommend_tip.setVisibility(8);
                    this.recommend_goodsList.setVisibility(8);
                    break;
                }
                break;
            case 7021:
                GetCodeBean getCodeBean = (GetCodeBean) message.obj;
                if (getCodeBean != null && "0".equals(getCodeBean.getCode()) && getCodeBean.isSuccess()) {
                    b(getCodeBean.getData());
                    break;
                }
            case 7024:
                a(true);
                break;
            case 8001:
                if (this.mEmptyLayout.getErrorState() != 9) {
                    f();
                    break;
                }
                break;
        }
        return super.handleMessage(message);
    }

    private void a(List<FridgeDoorImgBean> list) {
        Collections.sort(list, new Comparator<FridgeDoorImgBean>(this) {
            final /* synthetic */ FoodFragment a;

            {
                this.a = r1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return a((FridgeDoorImgBean) obj, (FridgeDoorImgBean) obj2);
            }

            public int a(FridgeDoorImgBean fridgeDoorImgBean, FridgeDoorImgBean fridgeDoorImgBean2) {
                if (fridgeDoorImgBean == null || fridgeDoorImgBean2 == null) {
                    return 0;
                }
                if (fridgeDoorImgBean.getPosition_type() > fridgeDoorImgBean2.getPosition_type()) {
                    return 1;
                }
                if (fridgeDoorImgBean.getPosition_type() != fridgeDoorImgBean2.getPosition_type()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    private void b(String str) {
        r.b("infos", "code====" + str);
        KeplerApiManager.setInJDCode(b(), str, new FaceCommonCallBack(this) {
            final /* synthetic */ FoodFragment a;

            {
                this.a = r1;
            }

            public boolean callBack(Object[] objArr) {
                if (objArr != null && objArr.length >= 2) {
                    r.b("infos", "isOk==" + ((Boolean) objArr[1]).booleanValue());
                }
                return false;
            }
        });
    }

    private void a(boolean z) {
        this.mEmptyLayout.setErrorType(4);
        this.mNutritionBtn.setVisibility(0);
        if (z) {
            this.data_layout.setVisibility(8);
            this.cameraBreakLayout.setVisibility(0);
        } else {
            this.cameraBreakLayout.setVisibility(8);
            this.data_layout.setVisibility(0);
        }
        int i = 960;
        int i2 = 1280;
        if (this.g != null && this.g.size() > 0) {
            i = ((FridgeDoorImgBean) this.g.get(0)).getPic_pixel_w();
            i2 = ((FridgeDoorImgBean) this.g.get(0)).getPic_pixel_h();
        }
        r.b("infos", "picwidth==" + i + "==picHeight==" + i2);
        int a = h.a(b().getApplicationContext());
        int a2 = h.a(b().getApplicationContext(), 15.0f);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (i2 * (a - (a2 * 2))) / i);
        layoutParams.setMargins(a2, a2, a2, a2);
        this.fridge_inner_picture_layout.setLayoutParams(layoutParams);
        this.fridge_inner_picture_layout.setBackgroundResource(R.drawable.bg_fridge_img_container);
        this.h = new a(this, this.g);
        if (com.jd.fridge.util.e.b.a().d().equalsIgnoreCase("RUY8KB") || com.jd.fridge.util.e.b.a().d().equalsIgnoreCase("D84DD0")) {
            this.mFridgeImgVP.setAdapter(this.h);
        } else {
            this.mFridgeImgVP.setAdapter(this.h);
            this.mFridgeImgCPI.setViewPager(this.mFridgeImgVP);
        }
        if (this.g != null) {
            if (this.g.size() <= 0 || ((FridgeDoorImgBean) this.g.get(0)).getTimestamp() <= 0) {
                this.mImgTime.setText("");
                this.mShareBtn.setVisibility(4);
            } else if (com.jd.fridge.util.e.b.a().d().equalsIgnoreCase("RUY8KB") || com.jd.fridge.util.e.b.a().d().equalsIgnoreCase("D84DD0")) {
                if (com.jd.fridge.util.e.b.a().d().equalsIgnoreCase("D84DD0")) {
                    this.cameraTopImage.setPadding(0, 70, 0, 0);
                } else {
                    this.cameraTopImage.setPadding(0, 0, 0, 0);
                }
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams2.setMargins(0, 0, 0, 0);
                this.hxCameraLayout.setLayoutParams(layoutParams2);
                this.hxCameraLayout.setVisibility(0);
                this.data_layout.setBackgroundColor(ContextCompat.getColor(b(), R.color.jd_fridge_app_gray_bg_color));
                this.mImgTime.setVisibility(8);
                this.hxCameraTimeText.setText(y.a(getContext(), ((FridgeDoorImgBean) this.g.get(0)).getTimestamp()));
            } else {
                this.data_layout.setBackgroundColor(-1);
                this.mImgTime.setVisibility(0);
                this.hxCameraTimeText.setVisibility(8);
                String b = y.b(((FridgeDoorImgBean) this.g.get(0)).getTimestamp());
                this.mImgTime.setText(getResources().getString(R.string.fragment_fridge_text_time_offset, new Object[]{b}));
            }
        }
        this.mShareBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FoodFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.a("APP_食物首页_分享按钮", "fridgeapp_201609146|5");
                    if (!(this.a.b() instanceof HomeActivity)) {
                        return;
                    }
                    if (this.a.l != null) {
                        ((HomeActivity) this.a.b()).a(this.a.l);
                    } else {
                        this.a.e();
                    }
                }
            }
        });
        e();
    }

    public void onResume() {
        super.onResume();
        if (this.k && this.d) {
            h();
        }
        g();
    }

    private void e() {
        if (this.h != null && this.g != null) {
            if (this.h.getCount() > 0 || this.g.size() > 0) {
                String str = "";
                String str2 = "";
                for (int i = 0; i < this.g.size(); i++) {
                    FridgeDoorImgBean fridgeDoorImgBean = (FridgeDoorImgBean) this.g.get(i);
                    if (fridgeDoorImgBean.getPosition_type() == 0) {
                        str = fridgeDoorImgBean.getPic_url();
                    } else if (fridgeDoorImgBean.getPosition_type() == 1) {
                        str2 = fridgeDoorImgBean.getPic_url();
                    }
                }
                com.jd.fridge.a.a().a(this.a, new Share(GlobalVariable.I(), Long.parseLong(GlobalVariable.C()), str, str2, y.a(((FridgeDoorImgBean) this.g.get(0)).getTimestamp(), "yyyy-MM-dd HH:mm:ss")));
            }
        }
    }

    private void f() {
        this.data_layout.setVisibility(8);
        this.mEmptyLayout.setErrorType(9);
        this.mNutritionBtn.setVisibility(4);
        this.mNoticeBtn.setVisibility(4);
        this.mNutritionBtn.setVisibility(4);
    }

    private void g() {
        if (this.mNoticeNum != null) {
            int g = com.jd.fridge.util.e.b.a().g();
            k.a("num====" + g);
            if (g > 0) {
                this.mNoticeNum.setVisibility(0);
                if (g > 99) {
                    this.mNoticeNum.setText("99+");
                    return;
                } else {
                    this.mNoticeNum.setText(g + "");
                    return;
                }
            }
            this.mNoticeNum.setVisibility(8);
        }
    }

    @OnClick({2131558890, 2131558893})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.notice_btn:
                com.jd.fridge.util.e.b.a().h();
                aa.d(b());
                break;
            case R.id.nutrition_btn:
                if (this.mEmptyLayout.getErrorState() != 9) {
                    aa.c(b());
                    break;
                }
                break;
        }
        this.a.postDelayed(new Runnable(this) {
            final /* synthetic */ FoodFragment a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.data_layout.setScrollY(0);
                this.a.data_layout.smoothScrollTo(0, 0);
            }
        }, 800);
    }

    private void h() {
        if ("0".equals(GlobalVariable.C())) {
            f();
            ((HomeActivity) b()).f();
            return;
        }
        com.jd.fridge.a.a().a(this.a, new FeedId(Long.parseLong(GlobalVariable.C())));
    }

    protected void d() {
        super.d();
        if (this.a != null) {
            this.a.post(new Runnable(this) {
                final /* synthetic */ FoodFragment a;

                {
                    this.a = r1;
                }

                public void run() {
                    if (this.a.data_layout != null) {
                        this.a.data_layout.setScrollY(0);
                        this.a.data_layout.smoothScrollTo(0, 0);
                    }
                }
            });
        }
    }

    public void onEventMainThread(Event event) {
        super.onEventMainThread(event);
        switch (event.getType()) {
            case 1:
                if (this.k && this.d) {
                    h();
                }
                r.b("infos", "==type==" + event.getType() + "==isPrepared==" + this.k + "==isVisible==" + this.d);
                return;
            default:
                return;
        }
    }
}
