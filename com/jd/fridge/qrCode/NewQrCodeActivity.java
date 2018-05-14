package com.jd.fridge.qrCode;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.ConcernListDataBean;
import com.jd.fridge.bean.FriendInfo;
import com.jd.fridge.bean.QrResult;
import com.jd.fridge.bean.requestBody.ConcernBody;
import com.jd.fridge.bean.requestBody.FeedId;
import com.jd.fridge.bean.requestBody.RefuseConcern;
import com.jd.fridge.friends.d;
import com.jd.fridge.qrCode.NewDampingView.a;
import com.jd.fridge.util.u;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: TbsSdkJava */
public class NewQrCodeActivity extends BaseActivity implements d, a {
    private Context a;
    private NewDampingView b;
    private QrCodeView c;
    private ListView d;
    private List<FriendInfo> i = new ArrayList();
    private a j;
    private EmptyLayout k;
    private TextView l;
    private FriendInfo m;
    private List<FriendInfo> n = new ArrayList();

    protected int a() {
        return R.layout.activity_damping_view;
    }

    protected void b() {
        this.a = this;
        b((int) R.string.activity_qr_code_title_text);
        c((int) R.string.activity_qr_code_save_text);
        f(8);
        this.b = (NewDampingView) findViewById(R.id.dampingView);
        ((LayoutParams) this.b.getLayoutParams()).height = u.a(this) * 2;
        this.b.setScrollFinishListener(this);
        this.c = (QrCodeView) findViewById(R.id.qr_view);
        this.d = (ListView) findViewById(R.id.lv_followme);
        this.l = new TextView(this.a);
        this.l.setBackgroundResource(R.drawable.bg_overlay_qr);
        this.c.setEmptLayout(4);
        this.k = this.c.getEmptyLayout();
        this.k.setRefresh(new OnClickListener(this) {
            final /* synthetic */ NewQrCodeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.c();
            }
        });
    }

    protected void c() {
        e();
        f();
        g();
    }

    protected void d() {
    }

    protected boolean a(Message message) {
        boolean z = true;
        switch (message.what) {
            case 2000:
                ConcernListDataBean concernListDataBean = (ConcernListDataBean) message.obj;
                this.i.clear();
                this.i.addAll(concernListDataBean.getResult());
                Collections.reverse(this.i);
                this.b.setEnableScrollUp(this.i.size() > 0);
                a(this.l);
                if (this.j != null) {
                    this.j.notifyDataSetChanged();
                    break;
                }
                this.j = new a(this.a, this.i, this, this.b);
                this.d.setAdapter(this.j);
                this.d.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ NewQrCodeActivity a;

                    {
                        this.a = r1;
                    }

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.a.b.b() && i == 0) {
                            this.a.b.a();
                        }
                    }
                });
                break;
            case 2004:
                this.c.setEmptLayout(4);
                this.c.setQR("b=" + GlobalVariable.C() + "--" + ((QrResult) message.obj).getQr());
                break;
            case 2005:
                this.c.setEmptLayout(8);
                break;
            case 2016:
                this.i.remove(this.m);
                this.j.notifyDataSetChanged();
                NewDampingView newDampingView = this.b;
                if (this.i.size() <= 0) {
                    z = false;
                }
                newDampingView.setEnableScrollUp(z);
                if (this.i.size() == 0) {
                    this.b.a();
                    b(this.l);
                    break;
                }
                break;
            case 2017:
                Toast.makeText(this.a, "删除失败", 0).show();
                break;
        }
        return super.a(message);
    }

    private void e() {
        if (y.d((Context) this)) {
            this.c.setEmptLayout(2);
            com.jd.fridge.a.a().b(this.e, new FeedId(Long.parseLong(GlobalVariable.C())));
            return;
        }
        this.c.setEmptLayout(8);
    }

    private void f() {
        if (y.d((Context) this)) {
            com.jd.fridge.a.a().b(this.e, new ConcernBody(GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
        }
    }

    public void a(FriendInfo friendInfo) {
        if (y.d(this.a)) {
            this.m = friendInfo;
            com.jd.fridge.a.a().a(this.e, new RefuseConcern(friendInfo.getPin(), GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.c.a();
    }

    private void g() {
        for (int i = 0; i < 2; i++) {
            this.n.add(new FriendInfo("", (i + 1) + "", "", 0));
        }
    }

    private void a(View view) {
        if (this.i.size() > 0) {
            this.d.addHeaderView(view);
        }
    }

    private void b(View view) {
        this.d.removeHeaderView(view);
    }

    public void a(boolean z) {
        if (this.j != null) {
            this.j.notifyDataSetChanged();
        } else {
            this.j = new a(this.a, this.i, this, this.b);
            this.d.setAdapter(this.j);
        }
        if (this.l != null) {
            if (z) {
                a(this.l);
            } else {
                b(this.l);
            }
        }
    }
}
