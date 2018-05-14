package com.jd.fridge.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.CircularImageView;

/* compiled from: TbsSdkJava */
public class a<T extends MineFragment> implements Unbinder {
    protected T a;
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;

    public a(final T t, Finder finder, Object obj) {
        this.a = t;
        View findRequiredView = finder.findRequiredView(obj, R.id.right_appbar_btn, "field 'right_appbar_btn' and method 'startSettingView'");
        t.right_appbar_btn = (ImageView) finder.castView(findRequiredView, R.id.right_appbar_btn, "field 'right_appbar_btn'", ImageView.class);
        this.b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startSettingView();
            }
        });
        t.app_title_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.app_title_textview, "field 'app_title_textview'", TextView.class);
        View findRequiredView2 = finder.findRequiredView(obj, R.id.user_info_layout, "field 'user_info_layout' and method 'startUserInfoActivity'");
        t.user_info_layout = findRequiredView2;
        this.c = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startUserInfoActivity();
            }
        });
        t.user_avatar = (CircularImageView) finder.findRequiredViewAsType(obj, R.id.user_avatar, "field 'user_avatar'", CircularImageView.class);
        t.user_name = (TextView) finder.findRequiredViewAsType(obj, R.id.user_name, "field 'user_name'", TextView.class);
        t.user_account = (TextView) finder.findRequiredViewAsType(obj, R.id.user_account, "field 'user_account'", TextView.class);
        t.mine_fridge_unbinded = (RelativeLayout) finder.findRequiredViewAsType(obj, R.id.mine_fridge_unbinded, "field 'mine_fridge_unbinded'", RelativeLayout.class);
        t.mine_fridge_binded = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.mine_fridge_binded, "field 'mine_fridge_binded'", LinearLayout.class);
        findRequiredView2 = finder.findRequiredView(obj, R.id.change_fridge_layout, "field 'change_fridge_layout' and method 'startChangeFridgeView'");
        t.change_fridge_layout = findRequiredView2;
        this.d = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startChangeFridgeView();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.fridge_indoor_layout, "field 'fridge_indoor_layout' and method 'startFridgeIndoorPicturesView'");
        t.fridge_indoor_layout = findRequiredView2;
        this.e = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startFridgeIndoorPicturesView();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.fridge_qr_layout, "field 'fridge_qr_layout' and method 'startFridgeQrView'");
        t.fridge_qr_layout = findRequiredView2;
        this.f = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startFridgeQrView();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.fridge_friend_layout, "field 'fridge_friend_layout' and method 'startFriendsView'");
        t.fridge_friend_layout = findRequiredView2;
        this.g = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startFriendsView();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.fridge_fail_layout, "field 'fridge_fail_layout' and method 'startFailurReportView'");
        t.fridge_fail_layout = findRequiredView2;
        this.h = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startFailurReportView();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.mine_menu_layout, "field 'mine_menu_layout' and method 'startFavorMenuView'");
        t.mine_menu_layout = findRequiredView2;
        this.i = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startFavorMenuView();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.fridge_message_layout, "field 'fridge_message_layout' and method 'startFridgeMessageBoardView'");
        t.fridge_message_layout = findRequiredView2;
        this.j = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startFridgeMessageBoardView();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.shopping_cart_layout, "field 'shopping_cart_layout' and method 'startShoppingCartView'");
        t.shopping_cart_layout = findRequiredView2;
        this.k = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startShoppingCartView();
            }
        });
        findRequiredView2 = finder.findRequiredView(obj, R.id.all_order_layout, "field 'all_order_layout' and method 'startOrderListView'");
        t.all_order_layout = findRequiredView2;
        this.l = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener(this) {
            final /* synthetic */ a b;

            public void doClick(View view) {
                t.startOrderListView();
            }
        });
    }

    public void unbind() {
        MineFragment mineFragment = this.a;
        if (mineFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        mineFragment.right_appbar_btn = null;
        mineFragment.app_title_textview = null;
        mineFragment.user_info_layout = null;
        mineFragment.user_avatar = null;
        mineFragment.user_name = null;
        mineFragment.user_account = null;
        mineFragment.mine_fridge_unbinded = null;
        mineFragment.mine_fridge_binded = null;
        mineFragment.change_fridge_layout = null;
        mineFragment.fridge_indoor_layout = null;
        mineFragment.fridge_qr_layout = null;
        mineFragment.fridge_friend_layout = null;
        mineFragment.fridge_fail_layout = null;
        mineFragment.mine_menu_layout = null;
        mineFragment.fridge_message_layout = null;
        mineFragment.shopping_cart_layout = null;
        mineFragment.all_order_layout = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
        this.j.setOnClickListener(null);
        this.j = null;
        this.k.setOnClickListener(null);
        this.k = null;
        this.l.setOnClickListener(null);
        this.l = null;
        this.a = null;
    }
}
