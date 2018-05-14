package com.jd.fridge;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import cn.jpush.android.api.InstrumentedActivity;
import com.google.gson.Gson;
import com.jd.fridge.bean.FridgeInfoBean;
import com.jd.fridge.bean.requestBody.UserPin;
import com.jd.fridge.login.LoginActivity;
import com.jd.fridge.switchFridge.SwitchFridgeActivity;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.c.a;
import com.jd.fridge.util.e.b;
import java.util.List;
import jd.wjlogin_sdk.common.WJLoginHelper;
import jd.wjlogin_sdk.common.listener.OnCommonCallback;
import jd.wjlogin_sdk.common.listener.OnLoginCallback;
import jd.wjlogin_sdk.model.FailResult;
import jd.wjlogin_sdk.model.JumpResult;
import jd.wjlogin_sdk.model.PicDataInfo;

/* compiled from: TbsSdkJava */
public class MainActivity extends InstrumentedActivity {
    private boolean a = false;
    private WJLoginHelper b;
    private Context c;
    private boolean d = false;
    private Handler e = new Handler(new Callback(this) {
        final /* synthetic */ MainActivity a;

        {
            this.a = r1;
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            switch (message.what) {
                case 2000:
                    Object obj = (List) message.obj;
                    if (obj != null && obj.size() != 0) {
                        if (obj.size() != 1) {
                            Object toJson = new Gson().toJson(obj);
                            if (((GlobalVariable) this.a.getApplication()).u()) {
                                aa.a(this.a, 1, toJson);
                            } else if (TextUtils.isEmpty(toJson)) {
                                aa.a(this.a);
                            } else {
                                Intent intent = new Intent(this.a, SwitchFridgeActivity.class);
                                intent.putExtra("SWITCH_FRIDGE_VIEW_MODE", true);
                                intent.putExtra("FEED_ID_JSON_STRING", toJson);
                                this.a.startActivity(intent);
                            }
                            this.a.finish();
                            break;
                        }
                        GlobalVariable.c(((FridgeInfoBean) obj.get(0)).getFeedId());
                        GlobalVariable.d(((FridgeInfoBean) obj.get(0)).getDeviceId());
                        GlobalVariable.d(((FridgeInfoBean) obj.get(0)).getRear_camera());
                        GlobalVariable.e(((FridgeInfoBean) obj.get(0)).getBrand());
                        GlobalVariable.f(((FridgeInfoBean) obj.get(0)).getBug_report());
                        GlobalVariable.e(((FridgeInfoBean) obj.get(0)).getControl_page());
                        b.a().c(((FridgeInfoBean) obj.get(0)).getProduct_uuid());
                        if (((GlobalVariable) this.a.getApplication()).u()) {
                            aa.a(this.a, 1, null);
                        } else {
                            aa.a(this.a);
                        }
                        this.a.finish();
                        break;
                    }
                    GlobalVariable.c("");
                    GlobalVariable.d("");
                    GlobalVariable.d(-1);
                    GlobalVariable.e("");
                    GlobalVariable.f(0);
                    GlobalVariable.e(0);
                    if (((GlobalVariable) this.a.getApplication()).u()) {
                        aa.a(this.a, 1, null);
                    } else {
                        aa.a(this.a);
                    }
                    this.a.finish();
                    break;
                    break;
                case 2001:
                case 2002:
                    if (((GlobalVariable) this.a.getApplication()).u()) {
                        aa.a(this.a, 1, null);
                    } else {
                        aa.a(this.a);
                    }
                    this.a.finish();
                    break;
            }
            return true;
        }
    });
    private boolean f;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = this;
        setContentView(R.layout.activity_main);
        a(this.c);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        ((GlobalVariable) getApplication()).a(displayMetrics.widthPixels);
        ((GlobalVariable) getApplication()).b(displayMetrics.heightPixels);
        ((GlobalVariable) getApplication()).a(displayMetrics.density);
        this.b = a.b();
        int v = ((GlobalVariable) getApplication()).v();
        int m = ((GlobalVariable) getApplication()).m();
        if (v == -1 || v == 0) {
            ((GlobalVariable) getApplication()).c(m);
            ((GlobalVariable) getApplication()).a(false);
            this.d = true;
            this.f = false;
        } else if (v != m) {
            this.d = false;
            this.f = true;
            ((GlobalVariable) getApplication()).g(true);
            ((GlobalVariable) getApplication()).c(m);
        }
        this.e.postDelayed(new Runnable(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.a();
            }
        }, 500);
        this.e.postDelayed(new Runnable(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.a = true;
            }
        }, 3000);
    }

    private void a() {
        if (this.b.isExistsUserInfo()) {
            d();
        } else {
            b();
        }
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(0, 0);
    }

    private void b() {
        if (this.d) {
            Intent intent = new Intent(this, GuideActivity.class);
            intent.putExtra("need_login", true);
            startActivity(intent);
            finish();
            return;
        }
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void c() {
        if (this.f) {
            ((GlobalVariable) getApplication()).a(true);
        }
        if (this.d) {
            Intent intent = new Intent(this, GuideActivity.class);
            intent.putExtra("need_login", false);
            startActivity(intent);
            finish();
        } else if ("0".equals(GlobalVariable.C())) {
            a.a().b(this.e, new UserPin(this.b.getPin()));
        } else {
            if (((GlobalVariable) getApplication()).u()) {
                aa.a(this, 1, null);
            } else {
                aa.a((Activity) this);
            }
            finish();
        }
    }

    private void d() {
        if (this.b.isExistsA2()) {
            e();
        } else {
            g();
        }
    }

    private void e() {
        if (this.b.checkA2TimeOut()) {
            g();
        } else {
            f();
        }
    }

    private void f() {
        if (this.b.checkA2IsNeedRefresh()) {
            h();
        } else {
            c();
        }
    }

    private void g() {
        if (this.b.isNeedPwdInput()) {
            b();
        } else {
            i();
        }
    }

    private void h() {
        this.b.refreshA2(new OnCommonCallback(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void onSuccess() {
                this.a.c();
            }

            public void onError(String str) {
                this.a.b();
            }

            public void onFail(FailResult failResult) {
                this.a.b();
            }
        });
    }

    private void i() {
        this.b.quickLogin(new OnLoginCallback(this) {
            final /* synthetic */ MainActivity a;

            {
                this.a = r1;
            }

            public void onSuccess() {
                this.a.c();
            }

            public void onError(String str) {
                this.a.b();
            }

            public void onFail(FailResult failResult, PicDataInfo picDataInfo) {
                this.a.b();
            }

            public void onFail(FailResult failResult, JumpResult jumpResult, PicDataInfo picDataInfo) {
                this.a.b();
            }
        });
    }

    private void a(Context context) {
        if (!((GlobalVariable) getApplication()).z()) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            Parcelable intent2 = new Intent();
            intent2.setComponent(new ComponentName(getPackageName(), getClass().getName()));
            intent2.setAction("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            String str = null;
            try {
                PackageManager packageManager = context.getPackageManager();
                str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", str);
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.mipmap.main_app_icon));
            context.sendBroadcast(intent);
            ((GlobalVariable) getApplication()).e(true);
        }
    }

    protected void onResume() {
        super.onResume();
        if (((GlobalVariable) getApplication()).A()) {
            this.d = true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i || this.a) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }
}
