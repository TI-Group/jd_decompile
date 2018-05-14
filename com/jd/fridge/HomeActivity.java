package com.jd.fridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.webkit.MimeTypeMap;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;
import com.google.gson.Gson;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.Event;
import com.jd.fridge.bean.FridgeInfoBean;
import com.jd.fridge.bean.UpdateDataBean;
import com.jd.fridge.bean.requestBody.RegisterAudienceByUser;
import com.jd.fridge.bean.requestBody.UpdateSendBean;
import com.jd.fridge.bean.requestBody.UserPin;
import com.jd.fridge.control.ControlFragment;
import com.jd.fridge.control.NewControlH5Fragment;
import com.jd.fridge.favorMenu.MenuFragment;
import com.jd.fridge.food.FoodFragment;
import com.jd.fridge.food.FoodNoCameraFragment;
import com.jd.fridge.mine.NewMineFragment;
import com.jd.fridge.switchFridge.SwitchFridgeActivity;
import com.jd.fridge.util.e.b;
import com.jd.fridge.util.k;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;
import com.jd.fridge.util.s;
import com.jd.fridge.util.socket.LongSocketService;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.CustomViewPager;
import com.jd.fridge.widget.FragmentTabPager;
import com.jd.fridge.widget.viewpageindicator.UnderlinePageIndicator;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.c;

/* compiled from: TbsSdkJava */
public class HomeActivity extends BaseActivity implements com.jd.fridge.base.a, com.jd.fridge.widget.FragmentTabPager.a {
    public static boolean a = false;
    private static final String b = HomeActivity.class.getSimpleName();
    private FragmentTabPager c;
    private HomeReceiver d;
    private boolean i = false;
    private int j = 0;
    private List<FridgeInfoBean> k = new ArrayList();
    private a l;
    @BindView(2131558975)
    RadioButton mBtControl;
    @BindView(2131558974)
    RadioButton mBtMenu;
    @BindView(2131558976)
    RadioButton mBtMine;
    @BindView(2131558977)
    RadioButton mBtRelatives;
    @BindView(2131558973)
    RadioButton mBtTab1;
    @BindView(2131558978)
    TextView mFridgeRedPoint;
    @BindView(2131558981)
    UnderlinePageIndicator mHomeIndicator;
    @BindView(2131558972)
    RadioGroup mHomeTabsview;
    @BindView(2131558971)
    RelativeLayout mHomeTabviewsLayout;
    @BindView(2131558969)
    CustomViewPager mHomeViewpager;
    @BindView(2131558980)
    TextView mMineRedPoint;
    @BindView(2131558979)
    TextView mRelativesRedPoint;

    /* compiled from: TbsSdkJava */
    public class HomeReceiver extends BroadcastReceiver {
        final /* synthetic */ HomeActivity a;

        public HomeReceiver(HomeActivity homeActivity) {
            this.a = homeActivity;
        }

        public void onReceive(Context context, Intent intent) {
            r.c(HomeActivity.b, "BroadcastReceiver: " + intent.getAction());
            k.a("====BroadcastReceiver:====" + intent.getAction());
            String action = intent.getAction();
            if ("com.jd.fridge.MESSAGE_RECEIVED_ACTION".equals(intent.getAction())) {
                k.a("====MESSAGE_RECEIVED_ACTION====" + intent.getStringExtra("code"));
                if ("cus_alarm".equals(intent.getStringExtra("code")) || "sys_expired".equals(intent.getStringExtra("code")) || "not_move_region".equals(intent.getStringExtra("code"))) {
                    this.a.q();
                }
                if ("message_friends".equals(intent.getStringExtra("code"))) {
                    this.a.s();
                }
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && y.d()) {
                Intent intent2 = new Intent("updateViewFood");
                intent2.putExtra("FLAG_ACTION_UPDATE_VIEW_FOOD", "");
                this.a.sendBroadcast(intent2);
            }
            if ("ACTION_SWITCH_FRIDGE_SUCCESS".equals(intent.getAction())) {
                this.a.i = true;
                b.a().a(false);
                GlobalVariable.a().k();
                this.a.t();
                this.a.e.sendEmptyMessage(101);
                Bundle bundle = new Bundle();
                bundle.putString("name", "Tab 1");
                if (GlobalVariable.E() > 0) {
                    this.a.c.a(FoodFragment.class, bundle, 0);
                } else {
                    this.a.c.a(FoodNoCameraFragment.class, bundle, 0);
                }
                bundle = new Bundle();
                bundle.putString("name", "Tab 3");
                if (GlobalVariable.F()) {
                    this.a.c.a(NewControlH5Fragment.class, bundle, 2);
                } else {
                    this.a.c.a(ControlFragment.class, bundle, 2);
                }
            }
            if ("BR_ACTION_FRIDGE_UNBINDED_2001".equals(action)) {
                Bundle bundle2;
                GlobalVariable.c("0");
                this.a.e.sendEmptyMessage(101);
                if (GlobalVariable.E() == 0) {
                    bundle2 = new Bundle();
                    bundle2.putString("name", "Tab 1");
                    this.a.c.a(FoodFragment.class, bundle2, 0);
                }
                bundle2 = new Bundle();
                bundle2.putString("name", "Tab 4");
                this.a.c.a(NewMineFragment.class, bundle2, 3);
            }
        }
    }

    /* compiled from: TbsSdkJava */
    public interface a {
        void a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x002b in list [B:5:0x0028]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r1 = 0;
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0.<init>();	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r2 = "chmod ";	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.append(r4);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r2 = " ";	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.append(r5);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        r0 = r2.exec(r0);	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        if (r0 == 0) goto L_0x002b;
    L_0x0028:
        r0.destroy();
    L_0x002b:
        return;
    L_0x002c:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ IOException -> 0x002c, all -> 0x0036 }
        if (r1 == 0) goto L_0x002b;
    L_0x0032:
        r1.destroy();
        goto L_0x002b;
    L_0x0036:
        r0 = move-exception;
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.destroy();
    L_0x003c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.fridge.HomeActivity.a(java.lang.String, java.lang.String):void");
    }

    protected int a() {
        return R.layout.home_layout;
    }

    private void p() {
        startService(new Intent(this, LongSocketService.class));
    }

    protected void b() {
        g();
        k();
        n();
        ButterKnife.bind((Activity) this);
        this.mHomeIndicator.setSelectedColor(getResources().getColor(R.color.jd_green_1));
        this.mFridgeRedPoint.setVisibility(8);
        this.mRelativesRedPoint.setVisibility(8);
        this.mMineRedPoint.setVisibility(8);
        this.mHomeViewpager.setOffscreenPageLimit(3);
        this.mHomeViewpager.setPagingEnabled(false);
        this.c = new FragmentTabPager(this, this.mHomeViewpager, this.mHomeTabsview, this.mHomeIndicator, getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putString("name", "Tab 1");
        if ("0".equals(GlobalVariable.C()) || "".equals(GlobalVariable.C())) {
            this.c.a(FoodFragment.class, bundle);
        } else if (GlobalVariable.E() > 0) {
            this.c.a(FoodFragment.class, bundle);
        } else {
            this.c.a(FoodNoCameraFragment.class, bundle);
        }
        bundle = new Bundle();
        bundle.putString("name", "Tab 2");
        this.c.a(MenuFragment.class, bundle);
        bundle = new Bundle();
        bundle.putString("name", "Tab 3");
        if (GlobalVariable.F()) {
            this.c.a(NewControlH5Fragment.class, bundle);
        } else {
            this.c.a(ControlFragment.class, bundle);
        }
        bundle = new Bundle();
        bundle.putString("name", "Tab 4");
        this.c.a(NewMineFragment.class, bundle);
        this.c.a(HomeActivity.class.getSimpleName(), (com.jd.fridge.widget.FragmentTabPager.a) this);
        if (((GlobalVariable) getApplication()).H()) {
            GlobalVariable.c("");
            ((GlobalVariable) getApplication()).g(false);
        }
        p();
        r.b("infos", "tbsVersion===" + QbSdk.getTbsVersion(this));
        k.a("audienceId====" + JPushInterface.getRegistrationID(this) + "===pin==" + com.jd.fridge.util.c.a.b().getPin() + "==glo_pin==" + GlobalVariable.I() + "==isJpushStop==" + JPushInterface.isPushStopped(getApplicationContext()));
        if (JPushInterface.isPushStopped(getApplicationContext())) {
            JPushInterface.init(getApplicationContext());
            r.b("infos", "====home.JpushInit=====");
            k.a("====home.JpushInit======");
        }
    }

    protected void c() {
        GlobalVariable.f(com.jd.fridge.util.c.a.b().getPin());
        if (((GlobalVariable) getApplication()).x()) {
            r.b("infos", "versionName==" + GlobalVariable.B().l() + "===code==" + GlobalVariable.B().m());
            a.a().a(this.e, new UpdateSendBean(((GlobalVariable) getApplication()).l()));
        }
    }

    protected void d() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ((GlobalVariable) getApplication()).a(displayMetrics.density);
        ((GlobalVariable) getApplication()).a(displayMetrics.widthPixels);
        ((GlobalVariable) getApplication()).b(displayMetrics.heightPixels);
    }

    public void a(int i) {
        this.j = i;
        GlobalVariable globalVariable;
        switch (i) {
            case 0:
                globalVariable = (GlobalVariable) getApplication();
                if ("0".equals(GlobalVariable.C()) && !y.d(getBaseContext())) {
                    b(getString(R.string.error_view_network_error_toast));
                }
                b("APP_食物主菜单icon", "fridgeapp_201609146|3");
                c.a().c(Event.newEvent(1, null));
                return;
            case 1:
                globalVariable = (GlobalVariable) getApplication();
                if ("0".equals(GlobalVariable.C()) && !y.d(getBaseContext())) {
                    b(getString(R.string.error_view_network_error_toast));
                }
                b("APP_控制主菜单icon", "fridgeapp_201609146|7");
                return;
            case 2:
                b("APP_亲友主菜单icon", "fridgeapp_201609146|21");
                return;
            case 3:
                b("APP_我的主菜单icon", "fridgeapp_201609146|22");
                return;
            default:
                return;
        }
    }

    public int e() {
        return this.j;
    }

    public void f() {
        this.e.removeMessages(1111);
        if ("0".equals(GlobalVariable.C())) {
            this.e.sendEmptyMessageDelayed(1111, 5000);
        }
    }

    protected void onResume() {
        super.onResume();
        a = true;
        q();
        s();
        k.a("getJpushRegister====" + b.a().e());
        if (!b.a().e()) {
            u();
        }
        this.e.sendEmptyMessage(1111);
        if (this.c != null && this.i) {
            this.c.notifyDataSetChanged();
            this.i = false;
            p.a(b, "notifyDataSetChanged");
        }
    }

    protected void onPause() {
        a = false;
        this.e.removeMessages(1111);
        super.onPause();
    }

    protected void onDestroy() {
        if (this.d != null) {
            unregisterReceiver(this.d);
        }
        p.a(b, "onDestroy...");
        LongSocketService.a((Activity) this);
        super.onDestroy();
    }

    private void q() {
        Intent intent = new Intent("updateViewFood");
        intent.putExtra("FLAG_ACTION_UPDATE_NEW_NOTICE_NUM", "");
        sendBroadcast(intent);
        if (b.a().g() > 0) {
            this.mFridgeRedPoint.setVisibility(0);
        } else {
            this.mFridgeRedPoint.setVisibility(8);
        }
    }

    private void r() {
        if (b.a().g() > 0) {
            this.mFridgeRedPoint.setVisibility(0);
        } else {
            this.mFridgeRedPoint.setVisibility(8);
        }
    }

    private void s() {
        Intent intent = new Intent("updateViewRelatives");
        intent.putExtra("FLAG_ACTION_UPDATE_REPLY_RED_POINT", "");
        sendBroadcast(intent);
        if (!((GlobalVariable) getApplication()).j() || this.mHomeTabsview.getCheckedRadioButtonId() == R.id.bt_relatives) {
            this.mRelativesRedPoint.setVisibility(8);
        } else {
            this.mRelativesRedPoint.setVisibility(8);
        }
    }

    private void t() {
        Intent intent = new Intent("updateViewFood");
        intent.putExtra("FLAG_ACTION_UPDATE_VIEW_FOOD", "");
        sendBroadcast(intent);
        sendBroadcast(new Intent("updateViewControl"));
        sendBroadcast(new Intent("updateViewMine"));
    }

    private void u() {
        if (!"0".equals(GlobalVariable.C()) && y.d()) {
            b.a().a(false);
            RegisterAudienceByUser registerAudienceByUser = new RegisterAudienceByUser();
            registerAudienceByUser.setFeed_id(Long.parseLong(GlobalVariable.C()));
            registerAudienceByUser.setOs("android");
            registerAudienceByUser.setPlatform("app");
            registerAudienceByUser.setDevice_uuid(GlobalVariable.B().r());
            registerAudienceByUser.setAudience_id(JPushInterface.getRegistrationID(this));
            k.a("RegistrationID:" + JPushInterface.getRegistrationID(this));
            r.c("infos", "RegistrationID==" + JPushInterface.getRegistrationID(this));
            registerAudienceByUser.setAudience_ip(y.e());
            a.a().a(this.e, registerAudienceByUser);
        }
    }

    public void g() {
        this.d = new HomeReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(1000);
        intentFilter.addAction("com.jd.fridge.MESSAGE_RECEIVED_ACTION");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("ACTION_SWITCH_FRIDGE_SUCCESS");
        intentFilter.addAction("BR_ACTION_FRIDGE_UNBINDED_2001");
        registerReceiver(this.d, intentFilter);
    }

    private void a(boolean z, String str, String str2) {
        try {
            final String decode = URLDecoder.decode(str2, CommonUtil.UTF8);
            if (z) {
                new com.jd.fridge.widget.b.c(this).a(false).a((int) R.string.update_dialog_title).b((int) R.string.update_dialog_title_tip).b(str).a(com.jd.fridge.widget.b.c.b.SINGLE_BTN).e(R.string.update_dialog_right_btn).a(new com.jd.fridge.widget.b.c.a(this) {
                    final /* synthetic */ HomeActivity b;

                    public void a() {
                        this.b.d(decode);
                        this.b.finish();
                    }

                    public void b() {
                    }
                }).show();
            } else {
                new com.jd.fridge.widget.b.c(this).a(false).a((int) R.string.update_dialog_title).b((int) R.string.update_dialog_title_tip).b(str).a(com.jd.fridge.widget.b.c.b.DOUBLE_BTN).d(R.string.update_dialog_right_btn).c(R.string.update_dialog_left_btn).a(new com.jd.fridge.widget.b.c.a(this) {
                    final /* synthetic */ HomeActivity b;

                    public void a() {
                        this.b.d(decode);
                        this.b.finish();
                    }

                    public void b() {
                        ((GlobalVariable) this.b.getApplication()).b(true);
                    }
                }).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d(String str) {
        a("777", str);
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (VERSION.SDK_INT < 23) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setDataAndType(Uri.parse("file://" + file.toString()), "application/vnd.android.package-archive");
            startActivity(intent);
            return;
        }
        a(file, (Context) this);
    }

    public void a(File file, Context context) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), a(file));
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String a(File file) {
        String str = "";
        str = file.getName();
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(str.lastIndexOf(".") + 1, str.length()).toLowerCase());
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    protected boolean a(Message message) {
        String str;
        switch (message.what) {
            case 101:
                r();
                break;
            case 1111:
                if ("0".equals(GlobalVariable.C())) {
                    if (!y.d((Context) this)) {
                        this.e.sendEmptyMessageDelayed(1111, 5000);
                        break;
                    }
                    str = null;
                    try {
                        str = URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    a.a().a(this.e, new UserPin(str));
                    break;
                }
                break;
            case 2000:
                this.k = (List) message.obj;
                if (this.k != null && this.k.size() > 0) {
                    if (this.k.size() <= 1) {
                        String feedId = ((FridgeInfoBean) this.k.get(0)).getFeedId();
                        str = ((FridgeInfoBean) this.k.get(0)).getDeviceId();
                        GlobalVariable.c(feedId);
                        GlobalVariable.d(str);
                        GlobalVariable.d(((FridgeInfoBean) this.k.get(0)).getRear_camera());
                        GlobalVariable.e(((FridgeInfoBean) this.k.get(0)).getBrand());
                        b.a().c(((FridgeInfoBean) this.k.get(0)).getProduct_uuid());
                        GlobalVariable.f(((FridgeInfoBean) this.k.get(0)).getBug_report());
                        GlobalVariable.e(((FridgeInfoBean) this.k.get(0)).getControl_page());
                        sendBroadcast(new Intent("ACTION_SWITCH_FRIDGE_SUCCESS"));
                        break;
                    }
                    str = new Gson().toJson(this.k);
                    Intent intent = new Intent(this, SwitchFridgeActivity.class);
                    intent.putExtra("SWITCH_FRIDGE_VIEW_MODE", true);
                    intent.putExtra("FromHome", true);
                    intent.putExtra("FEED_ID_JSON_STRING", str);
                    startActivity(intent);
                    break;
                }
                this.e.sendEmptyMessageDelayed(1111, 5000);
                break;
                break;
            case 2001:
                this.e.sendEmptyMessageDelayed(1111, 5000);
                break;
            case 5000:
                b.a().a(true);
                k.a("注册推送成功=" + JPushInterface.getRegistrationID(this));
                r.c("infos", "注册推送成功==" + JPushInterface.getRegistrationID(this));
                break;
            case ReaderCallback.HIDDEN_BAR /*5001*/:
                b.a().a(false);
                k.a("注册推送失败=" + JPushInterface.getRegistrationID(this));
                r.c("infos", "注册推送失败==" + JPushInterface.getRegistrationID(this));
                break;
            case 9000:
                UpdateDataBean updateDataBean = (UpdateDataBean) message.obj;
                r.b("infos", "versionName==" + GlobalVariable.B().l() + "===code==" + GlobalVariable.B().m() + "==bean==" + updateDataBean);
                if (updateDataBean != null && !TextUtils.isEmpty(updateDataBean.getUrl())) {
                    String str2 = GlobalVariable.f + updateDataBean.getUrl().substring(updateDataBean.getUrl().lastIndexOf(47) + 1);
                    r.b("infos", "fileMD5==" + s.b(str2) + "==md5==" + updateDataBean.getMd5() + "==has_new==" + updateDataBean.getHas_new());
                    if (updateDataBean.getHas_new() != 1) {
                        ((GlobalVariable) getApplication()).d(false);
                        r.b("infos", "newVersion===" + GlobalVariable.B().y() + "===updateDataBean==" + updateDataBean);
                        break;
                    }
                    ((GlobalVariable) getApplication()).d(true);
                    if (!y.c(str2) || !s.b(str2).equals(updateDataBean.getMd5())) {
                        if (((GlobalVariable) getApplication()).x() && !y.c(str2) && y.e((Context) this) && !y.c(str2)) {
                            ((GlobalVariable) getApplication()).b(updateDataBean.getUrl());
                            break;
                        }
                    } else if (updateDataBean.getIs_forced_upgrade() == 1) {
                        a(true, updateDataBean.getDesc(), str2);
                        break;
                    } else {
                        r.b("infos", "forced_upgrade==" + updateDataBean.getIs_forced_upgrade() + "===isSkipUpdate===" + ((GlobalVariable) getApplication()).w());
                        if (!((GlobalVariable) getApplication()).w()) {
                            a(false, updateDataBean.getDesc(), str2);
                            break;
                        }
                    }
                }
                ((GlobalVariable) getApplication()).d(false);
                break;
                break;
            case 9001:
                r.b("infos", "versionName==" + GlobalVariable.B().l() + "===code==" + GlobalVariable.B().m() + "==error==");
                break;
        }
        return super.a(message);
    }

    public void a(a aVar) {
        this.l = aVar;
    }

    public void h() {
        this.l = null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.l == null) {
            return super.onKeyDown(i, keyEvent);
        }
        this.l.a();
        return true;
    }
}
