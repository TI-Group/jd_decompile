package com.jd.fridge.favorMenu;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FoodsListDataBean;
import com.jd.fridge.bean.FridgeDoorImgBean;
import com.jd.fridge.bean.GetShareContentBean;
import com.jd.fridge.bean.ShareContent;
import com.jd.fridge.bean.ShareDataBean;
import com.jd.fridge.bean.StockDataBean;
import com.jd.fridge.bean.requestBody.FeedId;
import com.jd.fridge.bean.requestBody.Share;
import com.jd.fridge.bean.requestBody.Stock;
import com.jd.fridge.food.FridgeImageFragment;
import com.jd.fridge.util.e;
import com.jd.fridge.util.h;
import com.jd.fridge.util.r;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.GoodsGridView;
import com.jd.fridge.widget.loopingviewpager.LoopViewPager;
import com.jd.fridge.widget.viewpageindicator.CirclePageIndicator;
import com.jingdong.jdma.JDMaInterface;
import com.kepler.jd.login.KeplerApiManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class FridgeGoodsActivity extends BaseActivity {
    private List<FridgeDoorImgBean> a = new ArrayList();
    private a b;
    private View c;
    private b d;
    @BindView(2131558956)
    RelativeLayout fridge_inner_picture_layout;
    private View i;
    private FrameLayout j;
    private List<FoodsListDataBean> k;
    private GoodsGridView l;
    private ShareDataBean m = null;
    @BindView(2131558576)
    EmptyLayout mEmptyLayout;
    @BindView(2131558958)
    CirclePageIndicator mFridgeImgCPI;
    @BindView(2131558957)
    ViewPager mFridgeImgVP;
    @BindView(2131558959)
    TextView mImgTime;
    @BindView(2131558960)
    ImageView mShareBtn;

    /* compiled from: TbsSdkJava */
    private class a extends FragmentStatePagerAdapter {
        final /* synthetic */ FridgeGoodsActivity a;
        private List<FridgeDoorImgBean> b = null;

        public a(FridgeGoodsActivity fridgeGoodsActivity, List<FridgeDoorImgBean> list) {
            this.a = fridgeGoodsActivity;
            super(fridgeGoodsActivity.getSupportFragmentManager());
            this.b = list;
        }

        public Fragment getItem(int i) {
            int a;
            if (getCount() > 0) {
                a = LoopViewPager.a(i, getCount());
            } else {
                a = 0;
            }
            Bundle bundle = new Bundle();
            if (!(this.b == null || this.b.size() <= 0 || this.b.get(a) == null)) {
                bundle.putString("url", ((FridgeDoorImgBean) this.b.get(a)).getPic_url());
            }
            return Fragment.instantiate(this.a.getBaseContext(), FridgeImageFragment.class.getName(), bundle);
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
        final /* synthetic */ FridgeGoodsActivity a;

        b(FridgeGoodsActivity fridgeGoodsActivity) {
            this.a = fridgeGoodsActivity;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("BR_ACTION_FRIDGE_UNBINDED_2001")) {
                this.a.g();
                return;
            }
            if (intent.hasExtra("FLAG_ACTION_UPDATE_VIEW_FOOD")) {
                this.a.h();
            }
            if (intent.hasExtra("FLAG_ACTION_HAVE_NETWORK") && this.a.mEmptyLayout.getErrorState() == 11) {
                this.a.mEmptyLayout.setErrorType(4);
            }
        }
    }

    protected int a() {
        return R.layout.activity_fridge_goods;
    }

    protected void b() {
        try {
            ButterKnife.bind((Activity) this);
        } catch (Exception e) {
            e.printStackTrace();
            r.a("syp", e.toString());
        }
        b((int) R.string.activity_picture_history_title_text);
        this.mEmptyLayout.setErrorType(4);
        this.mShareBtn.setVisibility(4);
        this.c = findViewById(R.id.data_layout);
        this.i = findViewById(R.id.recommend_tip);
        this.i.setVisibility(8);
        this.j = (FrameLayout) findViewById(R.id.recommend_goodsList);
        this.j.setVisibility(8);
        this.l = (GoodsGridView) findViewById(R.id.goodsGridView);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("updateViewFood");
        intentFilter.addAction("BR_ACTION_FRIDGE_UNBINDED_2001");
        this.d = new b(this);
        registerReceiver(this.d, intentFilter);
        if ("0".equals(GlobalVariable.C())) {
            g();
        } else {
            h();
        }
    }

    protected void c() {
    }

    protected void d() {
    }

    public void onDestroy() {
        if (this.d != null) {
            unregisterReceiver(this.d);
        }
        super.onDestroy();
    }

    public boolean a(Message message) {
        HashMap hashMap;
        switch (message.what) {
            case 2000:
                this.a = (List) message.obj;
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                e();
                if (!TextUtils.equals(GlobalVariable.C(), "0")) {
                    com.jd.fridge.a.a().a(this.e, new Stock(Long.parseLong(GlobalVariable.C()), new int[]{1}));
                    break;
                }
                break;
            case 2001:
                hashMap = (HashMap) e.a("fridgeImgList.cac", getBaseContext(), com.jd.fridge.util.e.a.CACHE_MODEL_MAX);
                if (hashMap != null) {
                    this.a = (List) hashMap.get(GlobalVariable.C());
                }
                if (this.a != null) {
                    e();
                    this.mEmptyLayout.setErrorType(10);
                    break;
                }
                this.c.setVisibility(8);
                this.mEmptyLayout.setErrorType(8);
                break;
            case 2002:
                hashMap = (HashMap) e.a("fridgeImgList.cac", getBaseContext(), com.jd.fridge.util.e.a.CACHE_MODEL_MAX);
                if (hashMap != null) {
                    this.a = (List) hashMap.get(GlobalVariable.C());
                }
                if (this.a != null) {
                    e();
                    this.mEmptyLayout.setErrorType(11);
                    break;
                }
                this.c.setVisibility(8);
                this.mEmptyLayout.setErrorType(1);
                this.mEmptyLayout.setRefresh(new OnClickListener(this) {
                    final /* synthetic */ FridgeGoodsActivity a;

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
                    this.m = new ShareDataBean();
                    this.m.setSharePicUrl(result.getShareImg());
                    this.m.setShareText(result.getShareDes());
                    this.m.setShareTitle(result.getShareTitle());
                    this.m.setShareUrl(result.getShareLink());
                    break;
                }
            case 3000:
                this.k = (List) message.obj;
                if (this.k != null && this.k.size() > 0) {
                    if (this.k.size() > 10) {
                        this.k = this.k.subList(0, 10);
                    }
                    this.i.setVisibility(0);
                    this.j.setVisibility(0);
                    this.l.setAdapter(new com.jd.fridge.widget.a.a<FoodsListDataBean>(this, this, this.k, R.layout.item_goods) {
                        final /* synthetic */ FridgeGoodsActivity a;

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
                    this.l.setOnItemClickListener(new OnItemClickListener(this) {
                        final /* synthetic */ FridgeGoodsActivity a;

                        {
                            this.a = r1;
                        }

                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            try {
                                KeplerApiManager.getWebViewService().openItemDetailsWebViewPage(String.valueOf(((FoodsListDataBean) this.a.k.get(i)).getSku()), "统计0");
                            } catch (Exception e) {
                            }
                        }
                    });
                    break;
                }
                this.i.setVisibility(8);
                this.j.setVisibility(8);
                break;
            case 4000:
                List list = (List) message.obj;
                if (list != null && list.size() == 1) {
                    int curr_count = ((StockDataBean) list.get(0)).getCurr_count();
                    if (((StockDataBean) list.get(0)).getOut_of_stock() == 1 && curr_count <= 2) {
                        try {
                            com.jd.fridge.a.a().a(this.e, URLEncoder.encode("鸡蛋", HTTP.UTF_8), 10);
                            break;
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            case 8001:
                if (this.mEmptyLayout.getErrorState() != 9) {
                    g();
                    break;
                }
                break;
        }
        return super.a(message);
    }

    private void e() {
        this.mEmptyLayout.setErrorType(4);
        this.c.setVisibility(0);
        int i = 960;
        int i2 = 1280;
        if (this.a != null && this.a.size() > 0) {
            i = ((FridgeDoorImgBean) this.a.get(0)).getPic_pixel_w();
            i2 = ((FridgeDoorImgBean) this.a.get(0)).getPic_pixel_h();
            this.mShareBtn.setVisibility(0);
        }
        int a = h.a(getApplicationContext());
        int a2 = h.a(getApplicationContext(), 15.0f);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (i2 * (a - (a2 * 2))) / i);
        layoutParams.setMargins(a2, a2, a2, a2);
        this.fridge_inner_picture_layout.setLayoutParams(layoutParams);
        this.fridge_inner_picture_layout.setBackgroundResource(R.drawable.bg_fridge_img_container);
        this.b = new a(this, this.a);
        this.mFridgeImgVP.setAdapter(this.b);
        this.mFridgeImgCPI.setViewPager(this.mFridgeImgVP);
        if (this.a.size() <= 0 || ((FridgeDoorImgBean) this.a.get(0)).getTimestamp() <= 0) {
            this.mImgTime.setText("");
        } else {
            String b = y.b(((FridgeDoorImgBean) this.a.get(0)).getTimestamp());
            this.mImgTime.setText(getResources().getString(R.string.fragment_fridge_text_time_offset, new Object[]{b}));
        }
        this.mShareBtn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FridgeGoodsActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    if (this.a.m != null) {
                        this.a.a(this.a.m);
                    } else {
                        this.a.f();
                    }
                }
            }
        });
        f();
    }

    private void f() {
        if (this.b.getCount() > 0 && this.a.size() > 0) {
            String pic_url = ((FridgeDoorImgBean) this.a.get(0)).getPic_url();
            String str = "";
            if (this.a.size() > 1) {
                str = ((FridgeDoorImgBean) this.a.get(1)).getPic_url();
            }
            com.jd.fridge.a.a().a(this.e, new Share(GlobalVariable.I(), Long.parseLong(GlobalVariable.C()), pic_url, str, y.a(((FridgeDoorImgBean) this.a.get(0)).getTimestamp(), "yyyy-MM-dd HH:mm:ss")));
        }
    }

    private void g() {
        this.c.setVisibility(8);
        this.mEmptyLayout.setErrorType(9);
    }

    private void h() {
        if (!"0".equals(GlobalVariable.C())) {
            com.jd.fridge.a.a().a(this.e, new FeedId(Long.parseLong(GlobalVariable.C())));
        }
    }
}
