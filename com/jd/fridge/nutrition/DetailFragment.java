package com.jd.fridge.nutrition;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jiguang.net.HttpConstants;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.LazyFragment;
import com.jd.fridge.bean.NutritionDetailDataBean;
import com.jd.fridge.bean.NutritionFoodDataBean;
import com.jd.fridge.bean.requestBody.GetNutritionDetail;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.a.b;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class DetailFragment extends LazyFragment {
    private static final String e = (DetailFragment.class.getSimpleName() + ".");
    private String f;
    private String g;
    private boolean h = false;
    private NutritionDetailDataBean i;
    private boolean j = false;
    private boolean k = false;
    private LinearLayout l;
    private RelativeLayout m;
    @BindView(2131558870)
    TextView mDoc1;
    @BindView(2131558576)
    EmptyLayout mEmptyLayout;
    @BindView(2131558858)
    LinearLayout mLayoutContent;
    @BindView(2131558600)
    ListView mListview;
    private TextView n;
    private View o;
    private a p;
    private boolean q = false;

    /* compiled from: TbsSdkJava */
    static class a extends com.jd.fridge.widget.a.a<NutritionFoodDataBean> {
        public a(Context context, List<NutritionFoodDataBean> list, int i) {
            super(context, list, i);
        }

        public List<NutritionFoodDataBean> a() {
            return this.c;
        }

        public void a(b bVar, NutritionFoodDataBean nutritionFoodDataBean) {
            bVar.b((int) R.id.food_img, nutritionFoodDataBean.getImg_url());
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            DecimalFormat decimalFormat2 = new DecimalFormat("0");
            bVar.a((int) R.id.data1, nutritionFoodDataBean.getHeat() > 100.0f ? decimalFormat2.format((double) nutritionFoodDataBean.getHeat()) : decimalFormat.format((double) nutritionFoodDataBean.getHeat()));
            bVar.a((int) R.id.data2, nutritionFoodDataBean.getProtein() > 100.0f ? decimalFormat2.format((double) nutritionFoodDataBean.getProtein()) : decimalFormat.format((double) nutritionFoodDataBean.getProtein()));
            bVar.a((int) R.id.data3, nutritionFoodDataBean.getFat() > 100.0f ? decimalFormat2.format((double) nutritionFoodDataBean.getFat()) : decimalFormat.format((double) nutritionFoodDataBean.getFat()));
            bVar.a((int) R.id.data4, nutritionFoodDataBean.getDf() > 100.0f ? decimalFormat2.format((double) nutritionFoodDataBean.getDf()) : decimalFormat.format((double) nutritionFoodDataBean.getDf()));
            if (nutritionFoodDataBean.getHeat() <= 60.0f) {
                bVar.c(R.id.tipLowCalorie, 0);
            } else {
                bVar.c(R.id.tipLowCalorie, 8);
            }
            if (nutritionFoodDataBean.getDf() >= 1.0f) {
                bVar.c(R.id.tipHighFibre, 0);
            } else {
                bVar.c(R.id.tipHighFibre, 8);
            }
        }
    }

    public static DetailFragment b(String str, String str2) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f = getArguments().getString("param1");
            this.g = getArguments().getString("param2");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_nutritiondetail, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mLayoutContent.setVisibility(8);
        this.l = (LinearLayout) LayoutInflater.from(b()).inflate(R.layout.pull_to_refresh_footer, null);
        this.m = (RelativeLayout) this.l.findViewById(R.id.footer_layout);
        this.m.setVisibility(8);
        this.n = (TextView) this.l.findViewById(R.id.pull_to_refresh_text);
        this.n.setText(R.string.pull_to_refresh_footer_label);
        this.n.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DetailFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c() && !this.a.k) {
                    this.a.a.sendEmptyMessage(1000);
                }
            }
        });
        this.o = this.l.findViewById(R.id.pull_to_refresh_progress);
        this.p = new a(b(), new ArrayList(), R.layout.item_nutrition_detail);
        this.mListview.addFooterView(this.l);
        this.mListview.setAdapter(this.p);
        this.mListview.setOnScrollListener(new OnScrollListener(this) {
            int a = 0;
            int b = 0;
            final /* synthetic */ DetailFragment c;

            {
                this.c = r2;
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && !this.c.j && this.a == this.b && !this.c.k) {
                    this.c.a.sendEmptyMessage(1000);
                }
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (this.c.j) {
                    this.c.m.setVisibility(8);
                } else {
                    this.c.m.setVisibility(0);
                }
                this.a = i + i2;
                this.b = i3;
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.h = true;
        c();
    }

    protected void c() {
        if (this.h && this.d && !this.q) {
            this.q = true;
            if ("0".equals(GlobalVariable.C())) {
                this.mLayoutContent.setVisibility(8);
                this.mEmptyLayout.setErrorType(8);
                return;
            }
            if (this.i == null) {
                this.mLayoutContent.setVisibility(8);
            }
            a(0);
        }
    }

    public boolean handleMessage(Message message) {
        NutritionDetailDataBean nutritionDetailDataBean;
        switch (message.what) {
            case 1000:
                this.k = true;
                this.o.setVisibility(0);
                this.n.setEnabled(false);
                this.n.setText(R.string.pull_to_refresh_footer_refreshing_label);
                a(this.p.a().size());
                break;
            case 2000:
                nutritionDetailDataBean = (NutritionDetailDataBean) message.obj;
                if (nutritionDetailDataBean == null) {
                    this.a.sendEmptyMessage(2001);
                    break;
                }
                this.i = nutritionDetailDataBean;
                this.j = nutritionDetailDataBean.getResult().size() < 4;
                if (this.k) {
                    this.k = false;
                }
                this.mEmptyLayout.setErrorType(4);
                if (b() instanceof NutritionActivity) {
                    ((NutritionActivity) b()).g();
                }
                this.mLayoutContent.setVisibility(0);
                e();
                if (this.i.getResult().size() != 0) {
                    this.mDoc1.setVisibility(0);
                    break;
                }
                this.mEmptyLayout.setNoDataContent(getString(R.string.fragment_nutrition_detail_empty_text));
                this.mEmptyLayout.a();
                this.mEmptyLayout.setErrorType(3);
                this.mDoc1.setVisibility(8);
                break;
            case 2001:
                if (this.k) {
                    this.k = false;
                }
                if (this.i != null) {
                    if (b() instanceof NutritionActivity) {
                        ((NutritionActivity) b()).e();
                        break;
                    }
                }
                this.mEmptyLayout.setErrorType(8);
                this.mLayoutContent.setVisibility(8);
                break;
                break;
            case 2002:
                if (this.k) {
                    this.k = false;
                }
                if (this.i != null) {
                    if (b() instanceof NutritionActivity) {
                        ((NutritionActivity) b()).f();
                        break;
                    }
                }
                this.mEmptyLayout.setErrorType(1);
                this.mLayoutContent.setVisibility(8);
                this.mEmptyLayout.setRefresh(new OnClickListener(this) {
                    final /* synthetic */ DetailFragment a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        if (!y.c()) {
                            this.a.a(0);
                        }
                    }
                });
                break;
                break;
            case 3000:
                nutritionDetailDataBean = (NutritionDetailDataBean) message.obj;
                if (nutritionDetailDataBean == null) {
                    this.a.sendEmptyMessage(HttpConstants.NET_TIMEOUT_CODE);
                    break;
                }
                this.j = nutritionDetailDataBean.getResult().size() < 4;
                this.o.setVisibility(8);
                this.n.setEnabled(true);
                this.k = false;
                if (this.j) {
                    this.m.setVisibility(8);
                } else {
                    this.m.setVisibility(0);
                }
                this.p.b(nutritionDetailDataBean.getResult());
                break;
            case HttpConstants.NET_TIMEOUT_CODE /*3001*/:
                this.o.setVisibility(8);
                this.n.setEnabled(true);
                this.k = false;
                break;
        }
        return super.handleMessage(message);
    }

    private void e() {
        this.p.a(this.i.getResult());
    }

    private void a(int i) {
        GetNutritionDetail getNutritionDetail = new GetNutritionDetail();
        getNutritionDetail.setFeed_id(Long.parseLong(GlobalVariable.C()));
        getNutritionDetail.setCount(4);
        getNutritionDetail.setStart_index(i);
        com.jd.fridge.a.a().a(this.a, getNutritionDetail);
    }
}
