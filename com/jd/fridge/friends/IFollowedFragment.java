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
import com.jd.fridge.bean.requestBody.CancelConcern;
import com.jd.fridge.bean.requestBody.ConcernBody;
import com.jd.fridge.util.d.b;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.jd.fridge.widget.zxing.activity.QRCaptureActivity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class IFollowedFragment extends BaseFragment implements d {
    FriendInfo d;
    private Context e;
    @BindView(2131558950)
    TextView empty_hint_textview;
    @BindView(2131558951)
    ImageView empty_icon_imageview;
    @BindView(2131558576)
    View empty_layout;
    private IFollowedAdapter f;
    @BindView(2131558904)
    EmptyLayout friends_content_empty;
    @BindView(2131558903)
    RecyclerView friends_recycler_view;
    private List<FriendInfo> g = new ArrayList();
    private final BroadcastReceiver h = new BroadcastReceiver(this) {
        final /* synthetic */ IFollowedFragment a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Object obj = -1;
            switch (action.hashCode()) {
                case 1591869745:
                    if (action.equals("ACTION_MAKE_FRIENDS_SUCCESS")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.a.g.clear();
                    if (y.d(this.a.getActivity())) {
                        a.a().a(this.a.a, new ConcernBody(GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
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
        a("亲友页面-我关注的");
    }

    private void a() {
        this.empty_hint_textview.setText(R.string.activity_friends_list_no_following_hint);
        this.empty_icon_imageview.setImageResource(R.drawable.scan_icon);
        this.friends_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        this.friends_recycler_view.setHasFixedSize(true);
    }

    private void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_MAKE_FRIENDS_SUCCESS");
        getActivity().registerReceiver(this.h, intentFilter);
        this.f = new IFollowedAdapter(getContext(), this.g);
        this.f.setOnNotifyDataSetChangeListener(this);
        this.friends_recycler_view.setAdapter(this.f);
        this.friends_content_empty.setRefresh(new OnClickListener(this) {
            final /* synthetic */ IFollowedFragment a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (y.d(this.a.getActivity())) {
                    a.a().a(this.a.a, new ConcernBody(GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
                    return;
                }
                this.a.friends_content_empty.setErrorType(1);
            }
        });
        if (y.d(getActivity())) {
            a.a().a(this.a, new ConcernBody(GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
            return;
        }
        this.friends_content_empty.setErrorType(1);
    }

    @OnClick({2131558576})
    void goToQrScanAcitivity() {
        b.a(this.e, "android.permission.CAMERA", new com.jd.fridge.util.d.a(this) {
            final /* synthetic */ IFollowedFragment a;

            {
                this.a = r1;
            }

            public void a() {
                this.a.e.startActivity(new Intent(this.a.e, QRCaptureActivity.class));
            }
        });
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2000:
                this.friends_content_empty.setErrorType(4);
                ConcernListDataBean concernListDataBean = (ConcernListDataBean) message.obj;
                if (concernListDataBean.getStatus() == 0) {
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
                }
                break;
            case 2001:
                this.friends_content_empty.setErrorType(8);
                break;
            case 2014:
                this.friends_content_empty.setErrorType(4);
                d();
                break;
            case 2015:
                ((FriendsListActivity) getActivity()).a(10);
                break;
        }
        return super.handleMessage(message);
    }

    public void a(FriendInfo friendInfo) {
        a("APP_我的_亲友页_不再关注Ta按钮", "fridgeapp_201609146|35");
        this.d = friendInfo;
        if (y.d(getActivity())) {
            ((FriendsListActivity) getActivity()).a(4);
            a.a().a(this.a, new CancelConcern(GlobalVariable.I(), friendInfo.getPin(), friendInfo.getFeedId()));
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
