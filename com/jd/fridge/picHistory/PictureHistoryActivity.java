package com.jd.fridge.picHistory;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.FridgeSnapshot;
import com.jd.fridge.bean.GetPicHistoryDataBean;
import com.jd.fridge.bean.requestBody.PicHistory;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class PictureHistoryActivity extends BaseActivity {
    private PictureHistoryListAdapter a;
    private List<FridgeSnapshot> b = new ArrayList();
    private LinearLayoutManager c;
    private boolean d = true;
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    private int i = 0;
    private boolean j = true;
    private final OnScrollListener k = new OnScrollListener(this) {
        final /* synthetic */ PictureHistoryActivity a;

        {
            this.a = r1;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.a.d && this.a.i + 1 >= this.a.a.getItemCount() && i == 0) {
                this.a.a(((FridgeSnapshot) this.a.b.get(this.a.i)).getTime(), 10);
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            this.a.i = this.a.c.findLastVisibleItemPosition();
        }
    };
    @BindView(2131558605)
    RecyclerView picture_history_recyclerview;

    protected int a() {
        return R.layout.activity_fridge_snapshot_history;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        b((int) R.string.activity_picture_history_title_text);
        this.emptyLayout.setErrorType(4);
        this.emptyLayout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ PictureHistoryActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a(System.currentTimeMillis(), 10);
            }
        });
        this.c = new LinearLayoutManager(getBaseContext());
        this.picture_history_recyclerview.setLayoutManager(this.c);
        this.picture_history_recyclerview.setOnScrollListener(this.k);
        this.picture_history_recyclerview.setHasFixedSize(true);
        a("内景拍摄图页面");
    }

    protected void c() {
        a(System.currentTimeMillis(), 10);
    }

    private void a(long j, int i) {
        if (y.d((Context) this)) {
            a.a().a(this.e, new PicHistory(Long.parseLong(GlobalVariable.C()), j, i));
        } else if (this.j) {
            this.emptyLayout.setErrorType(1);
        } else {
            this.emptyLayout.setErrorType(11);
        }
    }

    protected void d() {
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 2000:
                this.emptyLayout.setErrorType(4);
                this.picture_history_recyclerview.setVisibility(0);
                GetPicHistoryDataBean getPicHistoryDataBean = (GetPicHistoryDataBean) message.obj;
                if (getPicHistoryDataBean.getStatus() == 0 && getPicHistoryDataBean.getResult() != null) {
                    if (getPicHistoryDataBean.getResult().getCount() > 0) {
                        this.b.addAll(getPicHistoryDataBean.getResult().getData());
                        if (this.a == null) {
                            this.a = new PictureHistoryListAdapter(getBaseContext(), getSupportFragmentManager(), this.b);
                            this.picture_history_recyclerview.setAdapter(this.a);
                        }
                        if (getPicHistoryDataBean.getResult().getCount() < 10) {
                            this.d = false;
                            this.a.a(true);
                        }
                        this.a.notifyDataSetChanged();
                    } else {
                        this.d = false;
                    }
                    this.j = false;
                    break;
                }
            case 2001:
                this.emptyLayout.setErrorType(4);
                if (!this.j) {
                    this.emptyLayout.setErrorType(10);
                    break;
                }
                this.emptyLayout.setErrorType(8);
                break;
        }
        return super.a(message);
    }
}
