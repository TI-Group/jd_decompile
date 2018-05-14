package com.jd.fridge.mine;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import com.jd.fridge.R;
import com.jd.fridge.widget.CircularImageView;

/* compiled from: TbsSdkJava */
public class b<T extends NewMineFragment> implements Unbinder {
    protected T a;

    public b(T t, Finder finder, Object obj) {
        this.a = t;
        t.right_appbar_btn = (ImageView) finder.findRequiredViewAsType(obj, R.id.right_appbar_btn, "field 'right_appbar_btn'", ImageView.class);
        t.app_title_textview = (TextView) finder.findRequiredViewAsType(obj, R.id.app_title_textview, "field 'app_title_textview'", TextView.class);
        t.user_info_layout = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.user_info_layout, "field 'user_info_layout'", LinearLayout.class);
        t.user_avatar = (CircularImageView) finder.findRequiredViewAsType(obj, R.id.user_avatar, "field 'user_avatar'", CircularImageView.class);
        t.user_name = (TextView) finder.findRequiredViewAsType(obj, R.id.user_name, "field 'user_name'", TextView.class);
        t.user_account = (TextView) finder.findRequiredViewAsType(obj, R.id.user_account, "field 'user_account'", TextView.class);
        t.binding_view = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.binding_view, "field 'binding_view'", LinearLayout.class);
        t.layout_aboutMe = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.layout_aboutMe, "field 'layout_aboutMe'", LinearLayout.class);
        t.view_shareMyFridge = (TextView) finder.findRequiredViewAsType(obj, R.id.view_shareMyFridge, "field 'view_shareMyFridge'", TextView.class);
        t.view_comment = (TextView) finder.findRequiredViewAsType(obj, R.id.view_comment, "field 'view_comment'", TextView.class);
        t.view_friendFridge = (TextView) finder.findRequiredViewAsType(obj, R.id.view_friendFridge, "field 'view_friendFridge'", TextView.class);
        t.view_messageBoard = (TextView) finder.findRequiredViewAsType(obj, R.id.view_messageBoard, "field 'view_messageBoard'", TextView.class);
        t.view_collectMenu = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.view_collectMenu, "field 'view_collectMenu'", LinearLayout.class);
        t.tv_menuCount = (TextView) finder.findRequiredViewAsType(obj, R.id.tv_menuCount, "field 'tv_menuCount'", TextView.class);
        t.view_shopping = (TextView) finder.findRequiredViewAsType(obj, R.id.view_shopping, "field 'view_shopping'", TextView.class);
        t.view_order = (TextView) finder.findRequiredViewAsType(obj, R.id.view_order, "field 'view_order'", TextView.class);
        t.view_problemDeclare = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.view_problemDeclare, "field 'view_problemDeclare'", LinearLayout.class);
        t.tv_phone = (TextView) finder.findRequiredViewAsType(obj, R.id.tv_phone, "field 'tv_phone'", TextView.class);
        t.view_setting = (TextView) finder.findRequiredViewAsType(obj, R.id.view_setting, "field 'view_setting'", TextView.class);
        t.unbinding_view = (LinearLayout) finder.findRequiredViewAsType(obj, R.id.unbinding_view, "field 'unbinding_view'", LinearLayout.class);
        t.view_friendFridge_unbinding = (TextView) finder.findRequiredViewAsType(obj, R.id.view_friendFridge_unbinding, "field 'view_friendFridge_unbinding'", TextView.class);
        t.view_setting_unbinding = (TextView) finder.findRequiredViewAsType(obj, R.id.view_setting_unbinding, "field 'view_setting_unbinding'", TextView.class);
    }

    public void unbind() {
        NewMineFragment newMineFragment = this.a;
        if (newMineFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        newMineFragment.right_appbar_btn = null;
        newMineFragment.app_title_textview = null;
        newMineFragment.user_info_layout = null;
        newMineFragment.user_avatar = null;
        newMineFragment.user_name = null;
        newMineFragment.user_account = null;
        newMineFragment.binding_view = null;
        newMineFragment.layout_aboutMe = null;
        newMineFragment.view_shareMyFridge = null;
        newMineFragment.view_comment = null;
        newMineFragment.view_friendFridge = null;
        newMineFragment.view_messageBoard = null;
        newMineFragment.view_collectMenu = null;
        newMineFragment.tv_menuCount = null;
        newMineFragment.view_shopping = null;
        newMineFragment.view_order = null;
        newMineFragment.view_problemDeclare = null;
        newMineFragment.tv_phone = null;
        newMineFragment.view_setting = null;
        newMineFragment.unbinding_view = null;
        newMineFragment.view_friendFridge_unbinding = null;
        newMineFragment.view_setting_unbinding = null;
        this.a = null;
    }
}
