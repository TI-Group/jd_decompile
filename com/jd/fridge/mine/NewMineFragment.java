package com.jd.fridge.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseFragment;
import com.jd.fridge.bean.FavorMenuListDataBaseBean;
import com.jd.fridge.bean.FridgeInfoBean;
import com.jd.fridge.bean.FridgeUserInfo;
import com.jd.fridge.bean.GetCodeBean;
import com.jd.fridge.bean.requestBody.FavorMenu;
import com.jd.fridge.bean.requestBody.UserPin;
import com.jd.fridge.comments.MyFridgeCommentsActivity;
import com.jd.fridge.failurReport.FailurReportActivity;
import com.jd.fridge.favorMenu.MenuActivity;
import com.jd.fridge.friends.FollowFriendActivity;
import com.jd.fridge.kepler.a;
import com.jd.fridge.messageBoard.MessagBoardActivity;
import com.jd.fridge.qrCode.NewQrCodeActivity;
import com.jd.fridge.settings.SettingsActivity;
import com.jd.fridge.userInfo.UserInfoActivity;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.CircularImageView;
import com.kepler.jd.Listener.FaceCommonCallBack;
import com.kepler.jd.login.KeplerApiManager;
import com.kepler.jd.sdk.exception.KeplerBufferOverflowException;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.List;
import jd.wjlogin_sdk.util.Config;

/* compiled from: TbsSdkJava */
public class NewMineFragment extends BaseFragment implements OnClickListener {
    private static final String e = NewMineFragment.class.getSimpleName();
    @BindView(2131558675)
    TextView app_title_textview;
    @BindView(2131558924)
    LinearLayout binding_view;
    private Context d;
    private boolean f;
    private FridgeUserInfo g;
    private int h;
    private boolean i = false;
    private Gson j = new Gson();
    private BroadcastReceiver k = new BroadcastReceiver(this) {
        final /* synthetic */ NewMineFragment a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            this.a.c(GlobalVariable.C());
        }
    };
    private final BroadcastReceiver l = new BroadcastReceiver(this) {
        final /* synthetic */ NewMineFragment a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            boolean z = true;
            switch (action.hashCode()) {
                case -1726546983:
                    if (action.equals("ACTION_MODIFY_AVATAR_SUCCESS")) {
                        z = true;
                        break;
                    }
                    break;
                case -1470352658:
                    if (action.equals("ACTION_MODIFY_NICKNAME_SUCCESS")) {
                        z = false;
                        break;
                    }
                    break;
                case 2087752395:
                    if (action.equals("ACTION_SWITCH_FRIDGE_SUCCESS")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    String stringExtra = intent.getStringExtra("nickname");
                    if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
                        this.a.user_name.setText(stringExtra);
                        this.a.g.setNickname(stringExtra);
                        GlobalVariable.g(stringExtra);
                        return;
                    }
                    return;
                case true:
                    this.a.g = (FridgeUserInfo) this.a.j.fromJson(intent.getStringExtra("user_info"), FridgeUserInfo.class);
                    ImageLoader.getInstance().displayImage(this.a.g.getPhotoUrl(), this.a.user_avatar);
                    GlobalVariable.h(this.a.g.getPhotoUrl());
                    return;
                case true:
                    this.a.i = true;
                    return;
                default:
                    return;
            }
        }
    };
    @BindView(2131558925)
    LinearLayout layout_aboutMe;
    @BindView(2131558676)
    ImageView right_appbar_btn;
    @BindView(2131558931)
    TextView tv_menuCount;
    @BindView(2131558935)
    TextView tv_phone;
    @BindView(2131558937)
    LinearLayout unbinding_view;
    @BindView(2131558942)
    TextView user_account;
    @BindView(2131558621)
    CircularImageView user_avatar;
    @BindView(2131558665)
    LinearLayout user_info_layout;
    @BindView(2131558622)
    TextView user_name;
    @BindView(2131558930)
    LinearLayout view_collectMenu;
    @BindView(2131558927)
    TextView view_comment;
    @BindView(2131558928)
    TextView view_friendFridge;
    @BindView(2131558938)
    TextView view_friendFridge_unbinding;
    @BindView(2131558929)
    TextView view_messageBoard;
    @BindView(2131558933)
    TextView view_order;
    @BindView(2131558934)
    LinearLayout view_problemDeclare;
    @BindView(2131558936)
    TextView view_setting;
    @BindView(2131558939)
    TextView view_setting_unbinding;
    @BindView(2131558926)
    TextView view_shareMyFridge;
    @BindView(2131558932)
    TextView view_shopping;

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mine, viewGroup, false);
        this.d = getActivity();
        ButterKnife.bind((Object) this, inflate);
        p.a(e, "onCreateView...");
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f = true;
        a();
        d();
        a.a(this.a, com.jd.fridge.util.c.a.b());
    }

    public void onResume() {
        super.onResume();
        if (y.d(getActivity())) {
            f();
            c(GlobalVariable.C());
            g();
            return;
        }
        Toast.makeText(getActivity(), "网络断了哦，请检查网络设置", 0).show();
    }

    private void a() {
        this.app_title_textview.setText("我的");
        this.right_appbar_btn.setImageResource(R.drawable.switch_fridge_icon_white);
        this.right_appbar_btn.setVisibility(0);
        this.right_appbar_btn.setOnClickListener(this);
        this.user_info_layout.setOnClickListener(this);
        this.view_shareMyFridge.setOnClickListener(this);
        this.view_comment.setOnClickListener(this);
        this.view_friendFridge.setOnClickListener(this);
        this.view_messageBoard.setOnClickListener(this);
        this.view_collectMenu.setOnClickListener(this);
        this.view_shopping.setOnClickListener(this);
        this.view_order.setOnClickListener(this);
        this.view_problemDeclare.setOnClickListener(this);
        this.view_setting.setOnClickListener(this);
        this.view_friendFridge_unbinding.setOnClickListener(this);
        this.view_setting_unbinding.setOnClickListener(this);
        if (GlobalVariable.G() == 1) {
            this.tv_phone.setText("");
        } else {
            this.tv_phone.setText(getResources().getText(R.string.probelem_service_phone));
        }
        if (!y.d(getActivity())) {
            c();
        }
    }

    private void c() {
        if (GlobalVariable.C().equals("0")) {
            this.binding_view.setVisibility(8);
            this.unbinding_view.setVisibility(0);
            this.right_appbar_btn.setVisibility(8);
            return;
        }
        int i;
        this.binding_view.setVisibility(0);
        this.unbinding_view.setVisibility(8);
        p.a(e, e() ? "havingCamera" : "noHavingCamera  " + GlobalVariable.E());
        LinearLayout linearLayout = this.layout_aboutMe;
        if (e()) {
            i = 0;
        } else {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.right_appbar_btn.setVisibility(0);
    }

    private void d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_MODIFY_NICKNAME_SUCCESS");
        intentFilter.addAction("ACTION_MODIFY_AVATAR_SUCCESS");
        intentFilter.addAction("ACTION_SWITCH_FRIDGE_SUCCESS");
        this.d.registerReceiver(this.l, intentFilter);
        b().registerReceiver(this.k, new IntentFilter("updateViewMine"));
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.user_info_layout:
                if (!y.c() && this.g != null) {
                    intent = new Intent(this.d, UserInfoActivity.class);
                    intent.putExtra(Config.USERINFO_LOCALNAME, this.j.toJson(this.g));
                    this.d.startActivity(intent);
                    return;
                }
                return;
            case R.id.right_appbar_btn:
                if (!y.c()) {
                    a("APP_我的_切换冰箱菜单", "fridgeapp_201609146|23");
                    aa.a(b(), false);
                    return;
                }
                return;
            case R.id.view_shareMyFridge:
                if (!y.c()) {
                    this.d.startActivity(new Intent(this.d, NewQrCodeActivity.class));
                    return;
                }
                return;
            case R.id.view_comment:
                startActivity(new Intent(getContext(), MyFridgeCommentsActivity.class));
                return;
            case R.id.view_friendFridge:
            case R.id.view_friendFridge_unbinding:
                if (!y.c()) {
                    this.d.startActivity(new Intent(this.d, FollowFriendActivity.class));
                    return;
                }
                return;
            case R.id.view_messageBoard:
                if (!y.c()) {
                    a("APP_我的_冰箱留言板菜单", "fridgeapp_201609146|28");
                    this.d.startActivity(new Intent(this.d, MessagBoardActivity.class));
                    return;
                }
                return;
            case R.id.view_collectMenu:
                if (!y.c()) {
                    a("APP_我的_我的菜谱菜单", "fridgeapp_201609146|27");
                    intent = new Intent(this.d, MenuActivity.class);
                    intent.putExtra("api_name", "list");
                    intent.putExtra("title_text", getString(R.string.fragment_mine_favor_menu_text));
                    this.d.startActivity(intent);
                    return;
                }
                return;
            case R.id.view_shopping:
                if (!y.c()) {
                    a("APP_我的_购物车菜单", "fridgeapp_201609146|29");
                    try {
                        KeplerApiManager.getWebViewService().openCartWebViewPage("统计5cart");
                        return;
                    } catch (KeplerBufferOverflowException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            case R.id.view_order:
                if (!y.c()) {
                    a("APP_我的_全部订单菜单", "fridgeapp_201609146|30");
                    try {
                        KeplerApiManager.getWebViewService().openOrderListWebViewPage("统计6");
                        return;
                    } catch (KeplerBufferOverflowException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            case R.id.view_problemDeclare:
                if (!y.c()) {
                    a("APP_我的_故障申报菜单", "fridgeapp_201609146|31");
                    if (GlobalVariable.G() == 1) {
                        this.d.startActivity(new Intent(this.d, FailurReportActivity.class));
                        return;
                    }
                    startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + getString(R.string.activity_failur_report_service_tel_number))));
                    return;
                }
                return;
            case R.id.view_setting:
            case R.id.view_setting_unbinding:
                if (!y.c()) {
                    a("APP_我的_设置icon", "fridgeapp_201609146|32");
                    this.d.startActivity(new Intent(this.d, SettingsActivity.class));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2000:
                List<FridgeInfoBean> list = (List) message.obj;
                if (list != null && list.size() > 0) {
                    for (FridgeInfoBean feedId : list) {
                        if (feedId.getFeedId().equals(GlobalVariable.C())) {
                            this.i = true;
                        }
                    }
                }
                c();
                break;
            case 2006:
                FavorMenuListDataBaseBean favorMenuListDataBaseBean = (FavorMenuListDataBaseBean) message.obj;
                if (favorMenuListDataBaseBean.getStatus() == 0 && favorMenuListDataBaseBean.getResult() != null) {
                    this.h = favorMenuListDataBaseBean.getResult().getTotalCount();
                }
                this.tv_menuCount.setText(this.h > 0 ? this.h + "" : "");
                break;
            case 2022:
                this.g = (FridgeUserInfo) message.obj;
                ImageLoader.getInstance().displayImage(this.g.getPhotoUrl(), this.user_avatar);
                GlobalVariable.h(this.g.getPhotoUrl());
                this.user_name.setText(this.g.getNickname());
                GlobalVariable.g(this.g.getNickname());
                this.user_account.setText(getString(R.string.fragment_mine_user_account_text, com.jd.fridge.util.c.a.b().getPin()));
                break;
            case 7021:
                GetCodeBean getCodeBean = (GetCodeBean) message.obj;
                if (getCodeBean != null && "0".equals(getCodeBean.getCode()) && getCodeBean.isSuccess()) {
                    b(getCodeBean.getData());
                    break;
                }
        }
        return super.handleMessage(message);
    }

    private void b(String str) {
        r.b("infos", "code====" + str);
        KeplerApiManager.setInJDCode(b(), str, new FaceCommonCallBack(this) {
            final /* synthetic */ NewMineFragment a;

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

    private boolean e() {
        return GlobalVariable.E() != 0;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!this.f) {
            return;
        }
        if (!y.d(getActivity())) {
            Toast.makeText(getActivity(), "网络断了哦，请检查网络设置", 0).show();
        } else if (z) {
            f();
            c(GlobalVariable.C());
            g();
        }
    }

    private void f() {
        com.jd.fridge.a.a().a(this.a, new HashMap());
    }

    private void c(String str) {
        if (!"0".equals(str)) {
            com.jd.fridge.a.a().a(this.a, new FavorMenu(Long.parseLong(str)));
        }
    }

    private void g() {
        if (y.d(b())) {
            UserPin userPin = new UserPin(GlobalVariable.I());
            p.a(e, "userPin: " + com.jd.fridge.util.c.a.b().getPin() + "  urlEncoder: " + GlobalVariable.I());
            com.jd.fridge.a.a().a(this.a, userPin);
        }
    }
}
