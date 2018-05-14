package com.jd.fridge.kepler;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import butterknife.ButterKnife;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.GetCodeBean;
import com.jd.fridge.util.k;
import com.jd.fridge.util.r;
import jd.wjlogin_sdk.common.WJLoginHelper;
import jd.wjlogin_sdk.common.listener.OnCommonCallback;
import jd.wjlogin_sdk.common.listener.OnLoginCallback;
import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.JumpResult;
import jd.wjlogin_sdk.model.PicDataInfo;

/* compiled from: TbsSdkJava */
public class KeplerAuthorizationActivity extends BaseActivity {
    String a;
    String b;
    String c;
    String d;
    String i;
    String j;
    String k;
    String l;
    int m;
    boolean n;
    volatile boolean o;
    private WJLoginHelper p;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        r.b("infos", "=====KeplerAuthorizationActivity===onCreate=====");
    }

    private void a(int i, String str) {
        r.c("infos", "isonBackPressed====" + this.o + "oautherror=====" + i + "==code==" + str);
        k.a("isonBackPressed====" + this.o + "oautherror=====" + i);
        if (!this.o) {
            switch (i) {
                case -1:
                case 1:
                case 2:
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                case 3:
                    Bundle bundle = new Bundle();
                    r.b("infos", "code----" + str + "===backActivity==" + this.b);
                    if (!TextUtils.isEmpty(str)) {
                        bundle.putString("code", str);
                    }
                    bundle.putInt("oautherror", i);
                    Intent intent = new Intent();
                    ComponentName componentName = new ComponentName(this, this.b);
                    intent.putExtras(bundle);
                    intent.setComponent(componentName);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                default:
                    return;
            }
        }
    }

    private void e() {
        this.a = this.p.getA2();
        a.a().b(this.e);
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 7021:
                k.a("kepler====success");
                GetCodeBean getCodeBean = (GetCodeBean) message.obj;
                r.c("infos", "====isonBackPressed==kepler success=====" + getCodeBean.getCode() + "==suceess==" + getCodeBean.isSuccess());
                if (!"0".equals(getCodeBean.getCode()) || !getCodeBean.isSuccess()) {
                    k.a("kepler====success" + getCodeBean.getCode() + "bean.isSuccess==" + getCodeBean.isSuccess());
                    a(-1, null);
                    break;
                }
                a(3, getCodeBean.getData());
                break;
                break;
            case 7022:
                k.a("kepler====fail");
                r.c("infos", "====isonBackPressed==kepler failed=====");
                a(-1, null);
                break;
        }
        return super.a(message);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1000) {
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        System.out.println("按下了back键   onBackPressed()");
        this.o = true;
        a(2, "");
    }

    protected void onResume() {
        super.onResume();
        this.o = false;
    }

    protected int a() {
        return R.layout.activity_kepler_authorization;
    }

    protected void b() {
        k();
        ButterKnife.bind((Activity) this);
        this.p = com.jd.fridge.util.c.a.b();
    }

    protected void c() {
        Bundle extras = getIntent().getExtras();
        this.b = extras.getString("actName");
        this.c = extras.getString("redirect_url");
        this.d = extras.getString("appId");
        this.i = extras.getString("appKey");
        this.j = extras.getString("pkgName");
        this.k = extras.getString("sourceType");
        this.l = extras.getString("sourceValue");
        this.m = extras.getInt("moduleId");
        this.n = extras.getBoolean("ifNoLoginToLogin");
        f();
    }

    protected void d() {
    }

    private void f() {
        if (this.p.isExistsUserInfo()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        if (!this.n) {
        }
    }

    private void h() {
        if (this.p.isExistsA2()) {
            i();
        } else {
            q();
        }
    }

    private void i() {
        if (this.p.checkA2TimeOut()) {
            q();
        } else {
            p();
        }
    }

    private void p() {
        if (this.p.checkA2IsNeedRefresh()) {
            r();
        } else {
            e();
        }
    }

    private void q() {
        if (this.p.isNeedPwdInput()) {
            g();
        } else {
            s();
        }
    }

    private void r() {
        this.p.refreshA2(new OnCommonCallback(this) {
            final /* synthetic */ KeplerAuthorizationActivity a;

            {
                this.a = r1;
            }

            public void onSuccess() {
                this.a.e();
            }

            public void onError(String str) {
                this.a.g();
            }

            public void onFail(FailResult failResult) {
                this.a.g();
            }
        });
    }

    private void s() {
        this.p.quickLogin(new OnLoginCallback(this) {
            final /* synthetic */ KeplerAuthorizationActivity a;

            {
                this.a = r1;
            }

            public void onSuccess() {
                this.a.e();
            }

            public void onError(String str) {
                this.a.g();
            }

            public void onFail(FailResult failResult, PicDataInfo picDataInfo) {
                this.a.g();
            }

            public void onFail(FailResult failResult, JumpResult jumpResult, PicDataInfo picDataInfo) {
                this.a.g();
            }
        });
    }
}
