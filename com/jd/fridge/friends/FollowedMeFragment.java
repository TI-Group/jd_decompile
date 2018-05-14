package com.jd.fridge.friends;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseFragment;
import com.jd.fridge.bean.ConcernListDataBean;
import com.jd.fridge.bean.FriendInfo;
import com.jd.fridge.bean.requestBody.ConcernBody;
import com.jd.fridge.bean.requestBody.RefuseConcern;
import com.jd.fridge.qrCode.QrCodeActivity;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FollowedMeFragment extends BaseFragment implements d {
    FriendInfo d;
    private Context e;
    @BindView(2131558950)
    TextView empty_hint_textview;
    @BindView(2131558951)
    ImageView empty_icon_imageview;
    @BindView(2131558576)
    View empty_layout;
    private FollowedMeAdapter f;
    @BindView(2131558904)
    EmptyLayout friends_content_empty;
    @BindView(2131558903)
    RecyclerView friends_recycler_view;
    private List<FriendInfo> g = new ArrayList();
    private final BroadcastReceiver h = new BroadcastReceiver(this) {
        final /* synthetic */ FollowedMeFragment a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Object obj = -1;
            switch (action.hashCode()) {
                case -1508464358:
                    if (action.equals("ACTION_REFRESH_FOLLOWED_ME")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.a.g.clear();
                    if (y.d(this.a.getActivity())) {
                        a.a().b(this.a.a, new ConcernBody(GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
                        return;
                    }
                    this.a.f.notifyDataSetChanged();
                    this.a.friends_content_empty.setErrorType(1);
                    return;
                default:
                    return;
            }
        }
    };

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_friends_content, viewGroup, false);
        this.e = getContext();
        ButterKnife.bind((Object) this, inflate);
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a();
        c();
        a("亲友页面-关注我的");
    }

    private void a() {
        this.empty_hint_textview.setText(R.string.activity_friends_list_no_follower_hint);
        this.empty_icon_imageview.setImageResource(R.drawable.qr_icon);
        this.friends_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        this.friends_recycler_view.setHasFixedSize(true);
    }

    private void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_REFRESH_FOLLOWED_ME");
        getActivity().registerReceiver(this.h, intentFilter);
        this.f = new FollowedMeAdapter(getContext(), this.g);
        this.f.setOnNotifyDataSetChangeListener(this);
        this.friends_recycler_view.setAdapter(this.f);
        this.friends_content_empty.setErrorType(4);
        this.friends_content_empty.setRefresh(new OnClickListener(this) {
            final /* synthetic */ FollowedMeFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (y.d(this.a.getActivity())) {
                    a.a().b(this.a.a, new ConcernBody(GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
                    return;
                }
                this.a.friends_content_empty.setErrorType(1);
            }
        });
        if (y.d(getActivity())) {
            a.a().b(this.a, new ConcernBody(GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
            return;
        }
        this.friends_content_empty.setErrorType(1);
    }

    @OnClick({2131558576})
    void goToQrAcitivity() {
        Intent intent = new Intent(this.e, QrCodeActivity.class);
        intent.putExtra("refresh_broadcast", true);
        this.e.startActivity(intent);
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2000:
                this.friends_content_empty.setErrorType(4);
                ConcernListDataBean concernListDataBean = (ConcernListDataBean) message.obj;
                if (concernListDataBean.getResult() != null && concernListDataBean.getResult().size() != 0) {
                    this.g.clear();
                    this.g.addAll(concernListDataBean.getResult());
                    this.f.notifyDataSetChanged();
                    this.friends_recycler_view.setVisibility(0);
                    this.empty_layout.setVisibility(8);
                    break;
                }
                this.empty_layout.setVisibility(0);
                this.friends_recycler_view.setVisibility(8);
                break;
            case 2001:
                this.friends_content_empty.setErrorType(8);
                break;
            case 2016:
                this.friends_content_empty.setErrorType(4);
                d();
                break;
            case 2017:
                ((FriendsListActivity) getActivity()).a(10);
                break;
        }
        return super.handleMessage(message);
    }

    public void a(FriendInfo friendInfo) {
        a("APP_我的_亲友页_不再让Ta关注按钮", "fridgeapp_201609146|36");
        this.d = friendInfo;
        if (y.d(getActivity())) {
            ((FriendsListActivity) getActivity()).a(4);
            a.a().a(this.a, new RefuseConcern(friendInfo.getPin(), GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
            return;
        }
        ((FriendsListActivity) getActivity()).a(11);
    }

    private void d() {
        if (this.d != null) {
            this.g.remove(this.d);
            this.f.notifyDataSetChanged();
            if (this.f.getItemCount() == 0) {
                this.friends_recycler_view.setVisibility(8);
                this.empty_layout.setVisibility(0);
            }
            this.d = null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(this.h);
    }
}
