package com.jd.fridge.switchFridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FridgeInfoBean;
import com.jd.fridge.bean.requestBody.CancelRegisterAudienceByUser;
import com.jd.fridge.bean.requestBody.UserPin;
import com.jd.fridge.switchFridge.FridgeListAdapter.b;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class NewSwitchFridgeActivity extends BaseActivity implements b {
    private static final String a = NewSwitchFridgeActivity.class.getSimpleName();
    private FridgeListAdapter b;
    private List<FridgeInfoBean> c = new ArrayList();
    private boolean d;
    private FridgeInfoBean i;
    @BindView(2131559092)
    RecyclerView mFridgeList;
    @BindView(2131558582)
    ProgressBar mLoading;

    protected int a() {
        return R.layout.new_activity_switch_fridge;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        e();
    }

    private void e() {
        this.mFridgeList.setLayoutManager(new LinearLayoutManager(this));
        this.mFridgeList.setHasFixedSize(true);
    }

    protected void c() {
        this.d = getIntent().getBooleanExtra("SWITCH_FRIDGE_VIEW_MODE", false);
        if (this.d) {
            e(4);
            this.c = (List) new Gson().fromJson(getIntent().getStringExtra("FEED_ID_JSON_STRING"), new TypeToken<List<FridgeInfoBean>>(this) {
                final /* synthetic */ NewSwitchFridgeActivity a;

                {
                    this.a = r1;
                }
            }.getType());
            f();
            return;
        }
        e(0);
        g();
    }

    private void f() {
        if (this.b == null) {
            this.b = new FridgeListAdapter(this, this.c, this);
            this.mFridgeList.setAdapter(this.b);
            return;
        }
        this.b.a(this.c);
    }

    private void g() {
        if (y.d(getBaseContext())) {
            p();
            a.a().b(this.e, new UserPin(GlobalVariable.I()));
        }
    }

    protected boolean a(Message message) {
        switch (message.what) {
            case 2000:
                List list = (List) message.obj;
                if (list != null && list.size() > 0) {
                    this.c.clear();
                    this.c.addAll(list);
                    f();
                }
                q();
                break;
            case 2001:
                q();
                break;
            case 6000:
                q();
                com.jd.fridge.util.e.b.a().a(false);
                if (this.i != null) {
                    a(this.i);
                }
                i();
                finish();
                break;
            case 6001:
            case 8001:
                q();
                this.e.sendEmptyMessage(6000);
                break;
        }
        return super.a(message);
    }

    public void a(int i) {
        this.i = (FridgeInfoBean) this.c.get(i);
        if (!TextUtils.equals(this.i.getFeedId(), GlobalVariable.C())) {
            p();
            if (this.d) {
                q();
                a(this.i);
                i();
                aa.a((Activity) this);
                finish();
                return;
            }
            if (!y.d((Context) this)) {
                Toast.makeText(this, R.string.error_view_network_error_toast, 0).show();
            }
            if (GlobalVariable.C().equals("0")) {
                this.e.sendEmptyMessage(6000);
            } else {
                h();
            }
        }
    }

    private void h() {
        a.a().a(this.e, new CancelRegisterAudienceByUser(GlobalVariable.I(), Long.parseLong(GlobalVariable.C()), JPushInterface.getRegistrationID(this)));
    }

    private void a(FridgeInfoBean fridgeInfoBean) {
        GlobalVariable.c(fridgeInfoBean.getFeedId());
        GlobalVariable.d(fridgeInfoBean.getDeviceId());
        GlobalVariable.d(fridgeInfoBean.getRear_camera());
        GlobalVariable.e(fridgeInfoBean.getBrand());
        GlobalVariable.f(fridgeInfoBean.getBug_report());
        GlobalVariable.e(fridgeInfoBean.getControl_page());
        com.jd.fridge.util.e.b.a().c(fridgeInfoBean.getProduct_uuid());
    }

    private void i() {
        sendBroadcast(new Intent("ACTION_SWITCH_FRIDGE_SUCCESS"));
    }

    protected void d() {
    }

    private void p() {
        this.mLoading.setVisibility(0);
    }

    private void q() {
        this.mLoading.setVisibility(8);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && this.g.getVisibility() == 4 && !this.d) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
