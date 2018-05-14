package com.jd.fridge.switchFridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FridgeInfoBean;
import com.jd.fridge.bean.requestBody.CancelRegisterAudienceByUser;
import com.jd.fridge.bean.requestBody.UserPin;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.e.b;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.RecyclerItemClickListener;
import com.jd.fridge.widget.RecyclerItemClickListener.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class SwitchFridgeActivity extends BaseActivity {
    private static final String c = SwitchFridgeActivity.class.getSimpleName();
    boolean a = true;
    boolean b = false;
    private FridgeListAdapter d;
    @BindView(2131558576)
    EmptyLayout empty_layout;
    private List<FridgeInfoBean> i = new ArrayList();
    private FridgeInfoBean j;
    @BindView(2131558664)
    RecyclerView mFridgeListview;
    @BindView(2131558582)
    ProgressBar progress_loading;

    protected int a() {
        return R.layout.activity_switch_fridge;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        this.a = getIntent().getBooleanExtra("SWITCH_FRIDGE_VIEW_MODE", false);
        this.b = getIntent().getBooleanExtra("FromHome", false);
        c(getResources().getString(R.string.activity_switch_fridge_title_text));
        g();
        this.mFridgeListview.setLayoutManager(new LinearLayoutManager(this));
        this.mFridgeListview.setHasFixedSize(true);
        this.d = new FridgeListAdapter(this, this.i);
        this.mFridgeListview.setAdapter(this.d);
        this.mFridgeListview.addOnItemTouchListener(new RecyclerItemClickListener(this, new a(this) {
            final /* synthetic */ SwitchFridgeActivity a;

            {
                this.a = r1;
            }

            public void a(View view, int i) {
                if (!y.c()) {
                    this.a.j = (FridgeInfoBean) this.a.i.get(i);
                    if (this.a.j != null && !TextUtils.equals(this.a.j.getFeedId(), GlobalVariable.C())) {
                        this.a.a(this.a.j);
                    }
                }
            }
        }));
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(0, 0);
    }

    protected void c() {
        if (this.a) {
            e(4);
            this.empty_layout.setErrorType(4);
            this.i = (List) new Gson().fromJson(getIntent().getStringExtra("FEED_ID_JSON_STRING"), new TypeToken<List<FridgeInfoBean>>(this) {
                final /* synthetic */ SwitchFridgeActivity a;

                {
                    this.a = r1;
                }
            }.getType());
            this.d.a(this.i);
            return;
        }
        e(0);
        setAppbarBackBtnClickListener(new OnClickListener(this) {
            final /* synthetic */ SwitchFridgeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.finish();
                }
            }
        });
        this.empty_layout.setErrorType(4);
        if (y.d(getBaseContext())) {
            com.jd.fridge.a.a().b(this.e, new UserPin(GlobalVariable.I()));
            h();
            return;
        }
        this.empty_layout.setErrorType(1);
    }

    protected boolean a(Message message) {
        switch (message.what) {
            case 2000:
                List list = (List) message.obj;
                if (list != null && list.size() > 0) {
                    this.i.clear();
                    this.i.addAll(list);
                    this.d.a(this.i);
                    this.empty_layout.setErrorType(4);
                }
                i();
                break;
            case 2001:
                this.empty_layout.setErrorType(8);
                i();
                break;
            case 2002:
                this.empty_layout.setErrorType(1);
                break;
            case 6000:
                b(this.j);
                f();
                this.empty_layout.setErrorType(4);
                finish();
                i();
                break;
            case 6001:
            case 8001:
                this.e.sendEmptyMessage(6000);
                break;
        }
        return super.a(message);
    }

    private void a(FridgeInfoBean fridgeInfoBean) {
        h();
        if (this.a) {
            b(fridgeInfoBean);
            f();
            if (!this.b) {
                aa.a((Activity) this);
            }
            finish();
            i();
        } else if (!y.d((Context) this)) {
            Toast.makeText(this, R.string.error_view_network_error_toast, 0).show();
        } else if (GlobalVariable.C().equals("0")) {
            this.e.sendEmptyMessage(6000);
        } else {
            e();
        }
    }

    private void e() {
        com.jd.fridge.a.a().a(this.e, new CancelRegisterAudienceByUser(GlobalVariable.I(), Long.parseLong(GlobalVariable.C()), JPushInterface.getRegistrationID(this)));
    }

    private void b(FridgeInfoBean fridgeInfoBean) {
        GlobalVariable.c(fridgeInfoBean.getFeedId());
        GlobalVariable.d(fridgeInfoBean.getDeviceId());
        GlobalVariable.d(fridgeInfoBean.getRear_camera());
        GlobalVariable.e(fridgeInfoBean.getBrand());
        GlobalVariable.f(fridgeInfoBean.getBug_report());
        GlobalVariable.e(fridgeInfoBean.getControl_page());
        b.a().c(fridgeInfoBean.getProduct_uuid());
    }

    private void f() {
        sendBroadcast(new Intent("ACTION_SWITCH_FRIDGE_SUCCESS"));
    }

    private void g() {
        this.empty_layout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ SwitchFridgeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.empty_layout.setErrorType(2);
                    com.jd.fridge.a.a().b(this.a.e, new UserPin(GlobalVariable.I()));
                }
            }
        });
    }

    protected void d() {
    }

    private void h() {
        this.progress_loading.setVisibility(0);
    }

    private void i() {
        this.progress_loading.setVisibility(8);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && this.g.getVisibility() == 4 && !this.a) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
