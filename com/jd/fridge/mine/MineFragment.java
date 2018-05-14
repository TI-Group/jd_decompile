package com.jd.fridge.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseFragment;
import com.jd.fridge.bean.FavorMenuListDataBaseBean;
import com.jd.fridge.bean.FridgeInfoBean;
import com.jd.fridge.bean.FridgeUserInfo;
import com.jd.fridge.bean.requestBody.FavorMenu;
import com.jd.fridge.bean.requestBody.UserPin;
import com.jd.fridge.failurReport.FailurReportActivity;
import com.jd.fridge.favorMenu.MenuActivity;
import com.jd.fridge.friends.FriendsListActivity;
import com.jd.fridge.messageBoard.MessagBoardActivity;
import com.jd.fridge.picHistory.PictureHistoryActivity;
import com.jd.fridge.qrCode.QrCodeActivity;
import com.jd.fridge.settings.SettingsActivity;
import com.jd.fridge.userInfo.UserInfoActivity;
import com.jd.fridge.util.aa;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.CircularImageView;
import com.kepler.jd.login.KeplerApiManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.HashMap;
import java.util.List;
import jd.wjlogin_sdk.util.Config;

/* compiled from: TbsSdkJava */
public class MineFragment extends BaseFragment {
    @BindView(2131558920)
    View all_order_layout;
    @BindView(2131558675)
    TextView app_title_textview;
    @BindView(2131558912)
    View change_fridge_layout;
    Boolean d = Boolean.valueOf(false);
    boolean e = false;
    private Context f;
    @BindView(2131558916)
    View fridge_fail_layout;
    @BindView(2131558915)
    View fridge_friend_layout;
    @BindView(2131558913)
    View fridge_indoor_layout;
    @BindView(2131558918)
    View fridge_message_layout;
    @BindView(2131558914)
    View fridge_qr_layout;
    private FridgeUserInfo g;
    private Gson h = new Gson();
    private int i = 0;
    private a j;
    private final BroadcastReceiver k = new BroadcastReceiver(this) {
        final /* synthetic */ MineFragment a;

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
                    if (!TextUtils.isEmpty(stringExtra)) {
                        this.a.user_name.setText(stringExtra);
                        this.a.g.setNickname(stringExtra);
                        GlobalVariable.g(stringExtra);
                        return;
                    }
                    return;
                case true:
                    this.a.g = (FridgeUserInfo) this.a.h.fromJson(intent.getStringExtra("user_info"), FridgeUserInfo.class);
                    ImageLoader.getInstance().displayImage(this.a.g.getPhotoUrl(), this.a.user_avatar);
                    GlobalVariable.h(this.a.g.getPhotoUrl());
                    return;
                case true:
                    this.a.e = false;
                    return;
                default:
                    return;
            }
        }
    };
    @BindView(2131558911)
    LinearLayout mine_fridge_binded;
    @BindView(2131558940)
    RelativeLayout mine_fridge_unbinded;
    @BindView(2131558917)
    View mine_menu_layout;
    @BindView(2131558676)
    ImageView right_appbar_btn;
    @BindView(2131558919)
    View shopping_cart_layout;
    @BindView(2131558942)
    TextView user_account;
    @BindView(2131558621)
    CircularImageView user_avatar;
    @BindView(2131558665)
    View user_info_layout;
    @BindView(2131558622)
    TextView user_name;

    /* compiled from: TbsSdkJava */
    class a extends BroadcastReceiver {
        final /* synthetic */ MineFragment a;

        a(MineFragment mineFragment) {
            this.a = mineFragment;
        }

        public void onReceive(Context context, Intent intent) {
            this.a.f();
            this.a.b(GlobalVariable.C());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mine, viewGroup, false);
        this.f = getContext();
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a();
        f();
        c();
        this.d = Boolean.valueOf(true);
    }

    private void a() {
        this.app_title_textview.setText(R.string.fragment_mine_title);
        this.right_appbar_btn.setImageResource(R.drawable.appbar_setting_selector);
        this.right_appbar_btn.setVisibility(0);
        a(this.change_fridge_layout, R.drawable.change_fridge_icon, R.string.fragment_mine_switch_fridge_text);
        a(this.fridge_indoor_layout, R.drawable.fridge_indoor_icon, R.string.fragment_mine_fridge_indoor_text);
        a(this.fridge_qr_layout, R.drawable.fridge_qr_icon, R.string.fragment_mine_fridge_qr_text);
        a(this.fridge_friend_layout, R.drawable.fridge_friend_icon, R.string.fragment_mine_friends_text);
        a(this.fridge_fail_layout, R.drawable.fridge_fail_icon, R.string.fragment_mine_report_failur_text);
        a(this.mine_menu_layout, R.drawable.mine_menu_icon, R.string.fragment_mine_favor_menu_text);
        a(this.fridge_message_layout, R.drawable.fridge_message_icon, R.string.fragment_mine_fridge_message_board_text);
        a(this.shopping_cart_layout, R.drawable.shopping_cart_icon, R.string.fragment_mine_shopping_cart_text);
        a(this.all_order_layout, R.drawable.all_order_icon, R.string.fragment_mine_all_orders_text);
    }

    private void a(View view, int i, int i2) {
        ((ImageView) view.findViewById(R.id.navigation_item_icon_imageview)).setImageResource(i);
        ((TextView) view.findViewById(R.id.navigation_item_name_textview)).setText(i2);
    }

    private void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_MODIFY_NICKNAME_SUCCESS");
        intentFilter.addAction("ACTION_MODIFY_AVATAR_SUCCESS");
        intentFilter.addAction("ACTION_SWITCH_FRIDGE_SUCCESS");
        this.f.registerReceiver(this.k, intentFilter);
        intentFilter = new IntentFilter("updateViewMine");
        this.j = new a(this);
        b().registerReceiver(this.j, intentFilter);
        e();
        b(GlobalVariable.C());
        d();
    }

    private void b(String str) {
        if (!"0".equals(str)) {
            com.jd.fridge.a.a().a(this.a, new FavorMenu(Long.parseLong(str)));
        }
    }

    private void d() {
        if (y.d(b())) {
            com.jd.fridge.a.a().a(this.a, new UserPin(GlobalVariable.I()));
        }
    }

    public void onResume() {
        super.onResume();
    }

    private void e() {
        com.jd.fridge.a.a().a(this.a, new HashMap());
    }

    private void a(View view, int i) {
        TextView textView = (TextView) view.findViewById(R.id.navigation_item_badge_textview);
        textView.setText(i > 0 ? i + "" : "");
        textView.setVisibility(0);
    }

    private void f() {
        if ("0".equals(GlobalVariable.C())) {
            this.mine_fridge_binded.setVisibility(8);
            this.mine_fridge_unbinded.setVisibility(0);
            return;
        }
        this.mine_fridge_binded.setVisibility(0);
        this.mine_fridge_unbinded.setVisibility(8);
        this.change_fridge_layout.setVisibility(0);
    }

    public void onDestroy() {
        this.f.unregisterReceiver(this.k);
        if (this.j != null) {
            b().unregisterReceiver(this.j);
        }
        super.onDestroy();
    }

    @OnClick({2131558665})
    void startUserInfoActivity() {
        if (!y.c() && this.g != null) {
            Intent intent = new Intent(this.f, UserInfoActivity.class);
            intent.putExtra(Config.USERINFO_LOCALNAME, this.h.toJson(this.g));
            this.f.startActivity(intent);
        }
    }

    @OnClick({2131558676})
    void startSettingView() {
        if (!y.c()) {
            a("APP_我的_设置icon", "fridgeapp_201609146|32");
            this.f.startActivity(new Intent(this.f, SettingsActivity.class));
        }
    }

    @OnClick({2131558912})
    void startChangeFridgeView() {
        if (!y.c()) {
            a("APP_我的_切换冰箱菜单", "fridgeapp_201609146|23");
            aa.a(b(), false);
        }
    }

    @OnClick({2131558913})
    void startFridgeIndoorPicturesView() {
        if (!y.c()) {
            a("APP_我的_冰箱内景拍摄图菜单", "fridgeapp_201609146|26");
            if (this.e) {
                g();
                return;
            }
            this.f.startActivity(new Intent(this.f, PictureHistoryActivity.class));
        }
    }

    @OnClick({2131558914})
    void startFridgeQrView() {
        if (!y.c()) {
            a("APP_我的_冰箱二维码菜单", "fridgeapp_201609146|24");
            if (this.e) {
                g();
                return;
            }
            this.f.startActivity(new Intent(this.f, QrCodeActivity.class));
        }
    }

    @OnClick({2131558915})
    void startFriendsView() {
        if (!y.c()) {
            a("APP_我的_亲友菜单", "fridgeapp_201609146|25");
            if (this.e) {
                g();
                return;
            }
            this.f.startActivity(new Intent(this.f, FriendsListActivity.class));
        }
    }

    @OnClick({2131558916})
    void startFailurReportView() {
        if (!y.c()) {
            a("APP_我的_故障申报菜单", "fridgeapp_201609146|31");
            if (this.e) {
                g();
                return;
            }
            this.f.startActivity(new Intent(this.f, FailurReportActivity.class));
        }
    }

    @OnClick({2131558917})
    void startFavorMenuView() {
        if (!y.c()) {
            a("APP_我的_我的菜谱菜单", "fridgeapp_201609146|27");
            if (this.e) {
                g();
            } else if (this.i > 0) {
                Intent intent = new Intent(this.f, MenuActivity.class);
                intent.putExtra("api_name", "list");
                intent.putExtra("title_text", getString(R.string.fragment_mine_favor_menu_text));
                this.f.startActivity(intent);
            } else if (y.d(this.f)) {
                Toast.makeText(this.f, R.string.fragment_mine_no_favor_menu_toast, 0).show();
            } else {
                Toast.makeText(this.f, "网络断了哦，请检查网络设置", 0).show();
            }
        }
    }

    @OnClick({2131558918})
    void startFridgeMessageBoardView() {
        if (!y.c()) {
            a("APP_我的_冰箱留言板菜单", "fridgeapp_201609146|28");
            if (this.e) {
                g();
                return;
            }
            this.f.startActivity(new Intent(this.f, MessagBoardActivity.class));
        }
    }

    @OnClick({2131558919})
    void startShoppingCartView() {
        if (!y.c()) {
            a("APP_我的_购物车菜单", "fridgeapp_201609146|29");
            try {
                KeplerApiManager.getWebViewService().openCartWebViewPage("统计5cart");
            } catch (Exception e) {
            }
        }
    }

    @OnClick({2131558920})
    void startOrderListView() {
        if (!y.c()) {
            a("APP_我的_全部订单菜单", "fridgeapp_201609146|30");
            try {
                KeplerApiManager.getWebViewService().openOrderListWebViewPage("统计6");
            } catch (Exception e) {
            }
        }
    }

    private void g() {
        Toast.makeText(this.f, R.string.error_message_current_fridge_unbinded, 0).show();
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2000:
                List<FridgeInfoBean> list = (List) message.obj;
                if (list == null || list.size() <= 0) {
                    this.mine_fridge_binded.setVisibility(8);
                    this.mine_fridge_unbinded.setVisibility(0);
                    break;
                }
                boolean z;
                this.mine_fridge_binded.setVisibility(0);
                this.mine_fridge_unbinded.setVisibility(8);
                this.change_fridge_layout.setVisibility(0);
                a(this.change_fridge_layout, list.size());
                for (FridgeInfoBean feedId : list) {
                    if (feedId.getFeedId().equals(GlobalVariable.C())) {
                        z = false;
                        this.e = z;
                        break;
                    }
                }
                z = true;
                this.e = z;
                break;
            case 2006:
                FavorMenuListDataBaseBean favorMenuListDataBaseBean = (FavorMenuListDataBaseBean) message.obj;
                if (favorMenuListDataBaseBean.getStatus() == 0 && favorMenuListDataBaseBean.getResult() != null) {
                    this.i = favorMenuListDataBaseBean.getResult().getTotalCount();
                }
                a(this.mine_menu_layout, this.i);
                break;
            case 2022:
                this.g = (FridgeUserInfo) message.obj;
                ImageLoader.getInstance().displayImage(this.g.getPhotoUrl(), this.user_avatar);
                GlobalVariable.h(this.g.getPhotoUrl());
                this.user_name.setText(this.g.getNickname());
                GlobalVariable.g(this.g.getNickname());
                this.user_account.setText(getString(R.string.fragment_mine_user_account_text, this.g.getPhoneNumber()));
                break;
        }
        return super.handleMessage(message);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.d.booleanValue() && z) {
            e();
            b(GlobalVariable.C());
            d();
            a("我的主页");
        }
    }
}
