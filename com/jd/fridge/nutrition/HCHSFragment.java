package com.jd.fridge.nutrition;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.LazyFragment;
import com.jd.fridge.bean.HGHCDataBean;
import com.jd.fridge.bean.HGHCItemDataBean;
import com.jd.fridge.bean.requestBody.GetHighGlucoseAndHighCalorie;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.DividerItemDecoration;
import com.jd.fridge.widget.EmptyLayout;

/* compiled from: TbsSdkJava */
public class HCHSFragment extends LazyFragment {
    private static final String e = (HCHSFragment.class.getSimpleName() + ".");
    private String f;
    private String g;
    private boolean h = false;
    private HGHCDataBean i;
    private HCHSRecyclerAdapter j;
    private int k = 0;
    private boolean l = false;
    @BindView(2131558906)
    CheckedTextView mCtvTabBtnAll;
    @BindView(2131558907)
    CheckedTextView mCtvTabBtnHc;
    @BindView(2131558908)
    CheckedTextView mCtvTabBtnHs;
    @BindView(2131558576)
    EmptyLayout mEmptyLayout;
    @BindView(2131558905)
    LinearLayout mLayoutContent;
    @BindView(2131558910)
    FrameLayout rcv_container;
    @BindView(2131558909)
    ScrollView scroll_layout;

    public static HCHSFragment b(String str, String str2) {
        HCHSFragment hCHSFragment = new HCHSFragment();
        Bundle bundle = new Bundle();
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        hCHSFragment.setArguments(bundle);
        return hCHSFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f = getArguments().getString("param1");
            this.g = getArguments().getString("param2");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_hchs, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mLayoutContent.setVisibility(8);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.h = true;
        c();
    }

    protected void c() {
        if (this.h && this.d && !this.l) {
            this.l = true;
            if ("0".equals(GlobalVariable.C())) {
                this.mLayoutContent.setVisibility(8);
                this.mEmptyLayout.setErrorType(8);
                return;
            }
            if (this.i == null) {
                this.mLayoutContent.setVisibility(8);
            }
            b(this.k);
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2000:
                HGHCDataBean hGHCDataBean = (HGHCDataBean) message.obj;
                if (hGHCDataBean == null) {
                    this.a.sendEmptyMessage(2001);
                    break;
                }
                this.i = hGHCDataBean;
                this.mEmptyLayout.setErrorType(4);
                if (b() instanceof NutritionActivity) {
                    ((NutritionActivity) b()).g();
                }
                this.mLayoutContent.setVisibility(0);
                e();
                break;
            case 2001:
                if (this.i != null) {
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
                if (this.i != null) {
                    if (b() instanceof NutritionActivity) {
                        ((NutritionActivity) b()).f();
                        break;
                    }
                }
                this.mEmptyLayout.setErrorType(1);
                this.mLayoutContent.setVisibility(8);
                this.mEmptyLayout.setRefresh(new OnClickListener(this) {
                    final /* synthetic */ HCHSFragment a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        if (!y.c()) {
                            this.a.b(this.a.k);
                        }
                    }
                });
                break;
                break;
        }
        return super.handleMessage(message);
    }

    private void e() {
        RecyclerView a = a(f());
        this.j.a(this.i.getResult());
        a.setAdapter(this.j);
        a(this.scroll_layout, this.rcv_container);
    }

    public void a(final View view, final View view2) {
        this.a.post(new Runnable(this) {
            final /* synthetic */ HCHSFragment c;

            public void run() {
                if (view != null && view2 != null) {
                    int measuredHeight = view2.getMeasuredHeight() - view.getHeight();
                    if (measuredHeight < 0) {
                        measuredHeight = 0;
                    }
                    view.scrollTo(0, measuredHeight);
                }
            }
        });
    }

    private int f() {
        int i = 0;
        for (HGHCItemDataBean hGHCItemDataBean : this.i.getResult()) {
            int size;
            if (hGHCItemDataBean.getGoods().size() > i) {
                size = hGHCItemDataBean.getGoods().size();
            } else {
                size = i;
            }
            i = size;
        }
        return (((((i * 29) + 20) + 5) + 5) + 12) + 15;
    }

    private RecyclerView a(int i) {
        this.rcv_container.removeAllViews();
        View recyclerView = new RecyclerView(b());
        recyclerView.setId(R.id.hchs_rcv);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, y.a((float) i, GlobalVariable.a().p()));
        layoutParams.gravity = 80;
        this.rcv_container.addView(recyclerView, layoutParams);
        LayoutManager linearLayoutManager = new LinearLayoutManager(b(), 0, false);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(b(), 0));
        this.j = new HCHSRecyclerAdapter(b());
        return recyclerView;
    }

    private void b(int i) {
        GetHighGlucoseAndHighCalorie getHighGlucoseAndHighCalorie = new GetHighGlucoseAndHighCalorie();
        getHighGlucoseAndHighCalorie.setFeed_id(Long.parseLong(GlobalVariable.C()));
        getHighGlucoseAndHighCalorie.setType(i);
        getHighGlucoseAndHighCalorie.setCount(30);
        getHighGlucoseAndHighCalorie.setStart_index(0);
        a.a().a(this.a, getHighGlucoseAndHighCalorie);
    }

    @OnClick({2131558906, 2131558907, 2131558908})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ctv_tab_btn_all:
                if (!this.mCtvTabBtnAll.isChecked()) {
                    this.mCtvTabBtnAll.setChecked(true);
                    this.mCtvTabBtnHc.setChecked(false);
                    this.mCtvTabBtnHs.setChecked(false);
                    this.k = 0;
                    b(this.k);
                    return;
                }
                return;
            case R.id.ctv_tab_btn_hc:
                if (!this.mCtvTabBtnHc.isChecked()) {
                    this.mCtvTabBtnAll.setChecked(false);
                    this.mCtvTabBtnHc.setChecked(true);
                    this.mCtvTabBtnHs.setChecked(false);
                    this.k = 2;
                    b(this.k);
                    return;
                }
                return;
            case R.id.ctv_tab_btn_hs:
                if (!this.mCtvTabBtnHs.isChecked()) {
                    this.mCtvTabBtnAll.setChecked(false);
                    this.mCtvTabBtnHc.setChecked(false);
                    this.mCtvTabBtnHs.setChecked(true);
                    this.k = 1;
                    b(this.k);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
