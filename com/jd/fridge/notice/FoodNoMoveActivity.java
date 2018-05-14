package com.jd.fridge.notice;

import android.content.Context;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.NotMoveBeanResult;
import com.jd.fridge.bean.NotMoveDataBean;
import com.jd.fridge.bean.NotMoveGoodsBean;
import com.jd.fridge.bean.requestBody.NotMoveBean;
import com.jd.fridge.util.p;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;

/* compiled from: TbsSdkJava */
public class FoodNoMoveActivity extends BaseActivity {
    private static final String a = FoodNoMoveActivity.class.getSimpleName();
    private CanvasImageView b;
    private TextView c;
    private TextView d;
    private EmptyLayout i;
    private String j;
    private String k;
    private String l;

    protected int a() {
        return R.layout.food_no_move;
    }

    protected void b() {
        this.b = (CanvasImageView) findViewById(R.id.iv_food);
        this.c = (TextView) findViewById(R.id.tv_show_tip);
        this.d = (TextView) findViewById(R.id.tv_show_time);
        this.i = (EmptyLayout) findViewById(R.id.empty_layout);
        e();
    }

    private void e() {
        b((int) R.string.activity_food_notice_title);
    }

    protected void c() {
        if (!y.d((Context) this)) {
            this.e.sendEmptyMessage(2001);
        } else if (GlobalVariable.C().equals("0")) {
            Toast.makeText(getApplicationContext(), getString(R.string.error_message_unbind_fridge), 0).show();
        } else {
            this.i.setVisibility(0);
            this.i.setErrorType(2);
            this.j = getIntent().getStringExtra("tip");
            this.k = getIntent().getStringExtra("time");
            if (this.j == null) {
                this.j = "";
            }
            if (this.k == null) {
                this.k = "";
            }
            this.l = getIntent().getStringExtra("recognition_date");
            if (this.l == null) {
                this.l = "";
            }
            if (y.d((Context) this)) {
                a.a().a(this.e, new NotMoveBean(Long.valueOf(GlobalVariable.C()).longValue(), GlobalVariable.I(), this.l));
            }
        }
    }

    protected void d() {
    }

    protected boolean a(Message message) {
        this.i.setErrorType(4);
        switch (message.what) {
            case 2000:
                NotMoveBeanResult result = ((NotMoveDataBean) message.obj).getResult();
                if (result != null) {
                    ImageLoader.getInstance().displayImage(result.getPic_url(), this.b);
                    List<NotMoveGoodsBean> goods = result.getGoods();
                    p.a(a, "goodsList: " + goods.size());
                    List list = null;
                    for (NotMoveGoodsBean positions : goods) {
                        list = positions.getPositions();
                    }
                    if (list != null && list.size() > 0) {
                        this.b.setPositions(list);
                    }
                    this.c.setText(this.j);
                    this.d.setText(this.k);
                    break;
                }
                break;
            case 2001:
                Toast.makeText(getApplicationContext(), getString(R.string.error_view_network_error_toast), 0).show();
                finish();
                break;
        }
        return super.a(message);
    }
}
