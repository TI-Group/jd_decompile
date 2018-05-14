package com.jd.fridge.nutrition;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.LazyFragment;
import com.jd.fridge.bean.NutritionDistributionDataBean;
import com.jd.fridge.bean.NutritionFoodDataBean;
import com.jd.fridge.bean.requestBody.GetNutritionDistribution;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.FoodsGridView;
import com.jd.fridge.widget.a.a;
import com.jd.fridge.widget.a.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class DistributionFragment extends LazyFragment {
    private static final String e = (DistributionFragment.class.getSimpleName() + ".");
    private String f = "week";
    private String g = "week";
    private String h = "day";
    private String i;
    private String j;
    private NutritionDistributionDataBean k;
    private boolean l = false;
    private boolean m = false;
    @BindView(2131558860)
    CheckedTextView mCtvTabBtnDay;
    @BindView(2131558859)
    CheckedTextView mCtvTabBtnWeek;
    @BindView(2131558861)
    TextView mDate;
    @BindView(2131558872)
    View mDiv;
    @BindView(2131558870)
    TextView mDoc1;
    @BindView(2131558871)
    TextView mDoc2;
    @BindView(2131558873)
    RelativeLayout mDoc3;
    @BindView(2131558874)
    TextView mDoc31;
    @BindView(2131558875)
    ImageView mDoc321;
    @BindView(2131558876)
    TextView mDoc322;
    @BindView(2131558877)
    ImageView mDoc331;
    @BindView(2131558878)
    TextView mDoc332;
    @BindView(2131558879)
    ImageView mDoc341;
    @BindView(2131558880)
    TextView mDoc342;
    @BindView(2131558881)
    ImageView mDoc351;
    @BindView(2131558882)
    TextView mDoc352;
    @BindView(2131558883)
    ImageView mDoc361;
    @BindView(2131558884)
    TextView mDoc362;
    @BindView(2131558885)
    ImageView mDoc371;
    @BindView(2131558886)
    TextView mDoc372;
    @BindView(2131558887)
    ImageView mDoc381;
    @BindView(2131558888)
    TextView mDoc382;
    @BindView(2131558576)
    EmptyLayout mEmptyLayout;
    @BindView(2131558858)
    ScrollView mLayoutContent;
    @BindView(2131558863)
    FoodsGridView mQuarter1Gridview;
    @BindView(2131558862)
    TextView mQuarter1Text;
    @BindView(2131558865)
    FoodsGridView mQuarter2Gridview;
    @BindView(2131558864)
    TextView mQuarter2Text;
    @BindView(2131558867)
    FoodsGridView mQuarter3Gridview;
    @BindView(2131558866)
    TextView mQuarter3Text;
    @BindView(2131558869)
    FoodsGridView mQuarter4Gridview;
    @BindView(2131558868)
    TextView mQuarter4Text;

    public static DistributionFragment b(String str, String str2) {
        DistributionFragment distributionFragment = new DistributionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        distributionFragment.setArguments(bundle);
        return distributionFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.i = getArguments().getString("param1");
            this.j = getArguments().getString("param2");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_distribution, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mLayoutContent.setVisibility(8);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.l = true;
        c();
    }

    protected void c() {
        if (this.l && this.d && !this.m) {
            this.m = true;
            if ("0".equals(GlobalVariable.C())) {
                this.mLayoutContent.setVisibility(8);
                this.mEmptyLayout.setErrorType(8);
                return;
            }
            if (this.k == null) {
                this.mLayoutContent.setVisibility(8);
            }
            b(this.f);
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2000:
                NutritionDistributionDataBean nutritionDistributionDataBean = (NutritionDistributionDataBean) message.obj;
                if (nutritionDistributionDataBean == null) {
                    this.a.sendEmptyMessage(2001);
                    break;
                }
                this.k = nutritionDistributionDataBean;
                this.mEmptyLayout.setErrorType(4);
                if (b() instanceof NutritionActivity) {
                    ((NutritionActivity) b()).g();
                }
                this.mLayoutContent.setVisibility(0);
                e();
                break;
            case 2001:
                if (this.k != null) {
                    if (b() instanceof NutritionActivity) {
                        ((NutritionActivity) b()).e();
                        break;
                    }
                }
                this.mLayoutContent.setVisibility(8);
                this.mEmptyLayout.setErrorType(8);
                break;
                break;
            case 2002:
                if (this.k != null) {
                    if (b() instanceof NutritionActivity) {
                        ((NutritionActivity) b()).f();
                        break;
                    }
                }
                this.mEmptyLayout.setErrorType(1);
                this.mLayoutContent.setVisibility(8);
                this.mEmptyLayout.setRefresh(new OnClickListener(this) {
                    final /* synthetic */ DistributionFragment a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        if (!y.c()) {
                            this.a.b(this.a.f);
                        }
                    }
                });
                break;
                break;
        }
        return super.handleMessage(message);
    }

    private void e() {
        if (this.g.equals(this.k.getType())) {
            this.mDate.setText(y.a());
            this.mDiv.setVisibility(8);
            this.mDoc3.setVisibility(8);
            this.mDoc1.setVisibility(0);
            this.mDoc1.setVisibility(0);
            this.mDoc2.setText(getResources().getString(R.string.fragment_distribution_doc2));
            if (this.k.getFruits() == null || this.k.getFruits().size() <= 0 || this.k.getVegetables() == null || this.k.getVegetables().size() <= 0 || this.k.getProteins() == null || this.k.getProteins().size() <= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                if (this.k.getFruits() == null || this.k.getFruits().size() == 0) {
                    stringBuilder.append(getString(R.string.fragment_distribution_txt1));
                }
                if (this.k.getVegetables() == null || this.k.getVegetables().size() == 0) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("、");
                    }
                    stringBuilder.append(getString(R.string.fragment_distribution_txt3));
                }
                if (this.k.getProteins() == null || this.k.getProteins().size() == 0) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("、");
                    }
                    stringBuilder.append(getString(R.string.fragment_distribution_txt4));
                }
                this.mDoc1.setText(getResources().getString(R.string.fragment_distribution_doc1_2, new Object[]{stringBuilder.toString()}));
            } else {
                this.mDoc1.setText(getResources().getString(R.string.fragment_distribution_doc1_week));
            }
        } else if (this.h.equals(this.k.getType())) {
            this.mDate.setText(y.b());
            this.mDiv.setVisibility(0);
            this.mDoc3.setVisibility(0);
            this.mDoc2.setText(getResources().getString(R.string.fragment_distribution_doc2_day));
            this.mDoc1.setVisibility(8);
            this.mDoc2.setVisibility(0);
        }
        f();
    }

    private void f() {
        int[] iArr;
        int i = 0;
        List fruits = this.k.getFruits();
        if (fruits == null || fruits.size() == 0) {
            if (fruits == null) {
                fruits = new ArrayList();
            }
            this.mQuarter1Text.setBackgroundResource(R.drawable.ic_quadrant_empty);
            int[] iArr2 = new int[]{R.drawable.ic_default_pingguo, R.drawable.ic_default_chengzi, R.drawable.ic_default_putao, R.drawable.ic_default_li};
            for (int defaultRes : iArr2) {
                NutritionFoodDataBean nutritionFoodDataBean = new NutritionFoodDataBean();
                nutritionFoodDataBean.setDefaultRes(defaultRes);
                nutritionFoodDataBean.setDefault(true);
                fruits.add(nutritionFoodDataBean);
            }
        } else {
            this.mQuarter1Text.setBackgroundResource(R.drawable.ic_quadrant);
        }
        List grains = this.k.getGrains();
        if (grains == null || grains.size() == 0) {
            if (grains == null) {
                grains = new ArrayList();
            }
            this.mQuarter2Text.setBackgroundResource(R.drawable.ic_quadrant_empty);
            int[] iArr3 = new int[]{R.drawable.ic_default_mianbao, R.drawable.ic_default_miantiao, R.drawable.ic_default_yumi, R.drawable.ic_default_mifan};
            for (int defaultRes2 : iArr3) {
                NutritionFoodDataBean nutritionFoodDataBean2 = new NutritionFoodDataBean();
                nutritionFoodDataBean2.setDefaultRes(defaultRes2);
                nutritionFoodDataBean2.setDefault(true);
                grains.add(nutritionFoodDataBean2);
            }
        } else {
            this.mQuarter2Text.setBackgroundResource(R.drawable.ic_quadrant);
        }
        List vegetables = this.k.getVegetables();
        if (vegetables == null || vegetables.size() == 0) {
            if (vegetables == null) {
                vegetables = new ArrayList();
            }
            this.mQuarter3Text.setBackgroundResource(R.drawable.ic_quadrant_empty);
            iArr = new int[]{R.drawable.ic_default_huluobo, R.drawable.ic_default_fanqie, R.drawable.ic_default_huagua, R.drawable.ic_default_qiezi};
            for (int defaultRes3 : iArr) {
                NutritionFoodDataBean nutritionFoodDataBean3 = new NutritionFoodDataBean();
                nutritionFoodDataBean3.setDefaultRes(defaultRes3);
                nutritionFoodDataBean3.setDefault(true);
                vegetables.add(nutritionFoodDataBean3);
            }
        } else {
            this.mQuarter3Text.setBackgroundResource(R.drawable.ic_quadrant);
        }
        List proteins = this.k.getProteins();
        if (proteins == null || proteins.size() == 0) {
            if (proteins == null) {
                proteins = new ArrayList();
            }
            this.mQuarter4Text.setBackgroundResource(R.drawable.ic_quadrant_empty);
            iArr = new int[]{R.drawable.ic_default_dan, R.drawable.ic_default_yu, R.drawable.ic_default_zhurou, R.drawable.ic_default_jirou};
            while (i < iArr.length) {
                nutritionFoodDataBean3 = new NutritionFoodDataBean();
                nutritionFoodDataBean3.setDefaultRes(iArr[i]);
                nutritionFoodDataBean3.setDefault(true);
                proteins.add(nutritionFoodDataBean3);
                i++;
            }
        } else {
            this.mQuarter4Text.setBackgroundResource(R.drawable.ic_quadrant);
        }
        this.mQuarter1Gridview.setAdapter(new a<NutritionFoodDataBean>(this, b(), fruits, R.layout.item_quarter) {
            final /* synthetic */ DistributionFragment a;

            public void a(b bVar, NutritionFoodDataBean nutritionFoodDataBean) {
                if (nutritionFoodDataBean.isDefault()) {
                    bVar.a((int) R.id.food_img, nutritionFoodDataBean.getDefaultRes());
                } else {
                    bVar.b((int) R.id.food_img, nutritionFoodDataBean.getIcon_url());
                }
            }
        });
        this.mQuarter2Gridview.setAdapter(new a<NutritionFoodDataBean>(this, b(), grains, R.layout.item_quarter) {
            final /* synthetic */ DistributionFragment a;

            public void a(b bVar, NutritionFoodDataBean nutritionFoodDataBean) {
                if (nutritionFoodDataBean.isDefault()) {
                    bVar.a((int) R.id.food_img, nutritionFoodDataBean.getDefaultRes());
                } else {
                    bVar.b((int) R.id.food_img, nutritionFoodDataBean.getIcon_url());
                }
            }
        });
        this.mQuarter3Gridview.setAdapter(new a<NutritionFoodDataBean>(this, b(), vegetables, R.layout.item_quarter) {
            final /* synthetic */ DistributionFragment a;

            public void a(b bVar, NutritionFoodDataBean nutritionFoodDataBean) {
                if (nutritionFoodDataBean.isDefault()) {
                    bVar.a((int) R.id.food_img, nutritionFoodDataBean.getDefaultRes());
                } else {
                    bVar.b((int) R.id.food_img, nutritionFoodDataBean.getIcon_url());
                }
            }
        });
        this.mQuarter4Gridview.setAdapter(new a<NutritionFoodDataBean>(this, b(), proteins, R.layout.item_quarter) {
            final /* synthetic */ DistributionFragment a;

            public void a(b bVar, NutritionFoodDataBean nutritionFoodDataBean) {
                if (nutritionFoodDataBean.isDefault()) {
                    bVar.a((int) R.id.food_img, nutritionFoodDataBean.getDefaultRes());
                } else {
                    bVar.b((int) R.id.food_img, nutritionFoodDataBean.getIcon_url());
                }
            }
        });
    }

    private void b(String str) {
        GetNutritionDistribution getNutritionDistribution = new GetNutritionDistribution();
        getNutritionDistribution.setFeed_id(Long.parseLong(GlobalVariable.C()));
        getNutritionDistribution.setType(str);
        com.jd.fridge.a.a().a(this.a, getNutritionDistribution);
    }

    @OnClick({2131558859, 2131558860})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ctv_tab_btn_week:
                if (!this.mCtvTabBtnWeek.isChecked()) {
                    this.mCtvTabBtnWeek.setChecked(true);
                    this.mCtvTabBtnDay.setChecked(false);
                    this.f = this.g;
                    b(this.f);
                    return;
                }
                return;
            case R.id.ctv_tab_btn_day:
                if (!this.mCtvTabBtnDay.isChecked()) {
                    this.mCtvTabBtnWeek.setChecked(false);
                    this.mCtvTabBtnDay.setChecked(true);
                    this.f = this.h;
                    b(this.f);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
