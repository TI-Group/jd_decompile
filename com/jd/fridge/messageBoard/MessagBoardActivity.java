package com.jd.fridge.messageBoard;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.base.PullUpLoadOnScrollListener;
import com.jd.fridge.bean.FridgeMessage;
import com.jd.fridge.bean.GetMessageDataBaseBean;
import com.jd.fridge.bean.requestBody.GetMessages;
import com.jd.fridge.createMessage.CreateFridgeMessageActivity;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.EmptyLayout;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class MessagBoardActivity extends BaseActivity {
    private static final String b = MessagBoardActivity.class.getSimpleName();
    PullUpLoadOnScrollListener a = new PullUpLoadOnScrollListener(this, this.i) {
        final /* synthetic */ MessagBoardActivity a;

        public void a(int i) {
            this.a.a(i * 10, 10);
        }
    };
    private MessageBoardListAdapter c;
    private List<FridgeMessage> d = new ArrayList();
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    private LinearLayoutManager i = new LinearLayoutManager(getBaseContext());
    private boolean j = true;
    private boolean k = true;
    private final BroadcastReceiver l = new BroadcastReceiver(this) {
        final /* synthetic */ MessagBoardActivity a;

        {
            this.a = r1;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            int i = -1;
            switch (action.hashCode()) {
                case 1422781041:
                    if (action.equals("ACTION_CREATE_MESSAGE_SUCCESS")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    this.a.d.clear();
                    this.a.c = null;
                    this.a.a(0, 10);
                    this.a.a.a();
                    return;
                default:
                    return;
            }
        }
    };
    @BindView(2131558608)
    RecyclerView message_board_recyclerview;

    protected int a() {
        return R.layout.activity_message_board;
    }

    protected void b() {
        ButterKnife.bind((Activity) this);
        b((int) R.string.activity_message_board_title_text);
        d((int) R.drawable.appbar_add_selector);
        setAppbarRightBtnClickListener(new OnClickListener(this) {
            final /* synthetic */ MessagBoardActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                if (!y.c()) {
                    this.a.b("APP_我的_留言板页_新建按钮", "fridgeapp_201609146|33");
                    this.a.startActivity(new Intent(this.a.getBaseContext(), CreateFridgeMessageActivity.class));
                }
            }
        });
        g(0);
        this.emptyLayout.setErrorType(4);
        this.emptyLayout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ MessagBoardActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.a(0, 10);
            }
        });
        this.message_board_recyclerview.setLayoutManager(this.i);
        this.message_board_recyclerview.setHasFixedSize(true);
        this.message_board_recyclerview.addOnScrollListener(this.a);
        a("留言板列表页面");
    }

    protected void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_CREATE_MESSAGE_SUCCESS");
        registerReceiver(this.l, intentFilter);
        a(0, 10);
    }

    private void a(int i, int i2) {
        if (y.d((Context) this)) {
            a.a().a(this.e, new GetMessages(GlobalVariable.I(), Long.parseLong(GlobalVariable.C()), i, i2));
        } else if (this.k) {
            this.emptyLayout.setErrorType(1);
        } else {
            this.emptyLayout.setErrorType(11);
        }
    }

    protected void d() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        ((GlobalVariable) getApplication()).a(displayMetrics.density);
        ((GlobalVariable) getApplication()).a(displayMetrics.widthPixels);
        ((GlobalVariable) getApplication()).b(displayMetrics.heightPixels);
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.l);
    }

    public boolean a(Message message) {
        switch (message.what) {
            case 2000:
                this.emptyLayout.setErrorType(4);
                this.message_board_recyclerview.setVisibility(0);
                GetMessageDataBaseBean getMessageDataBaseBean = (GetMessageDataBaseBean) message.obj;
                if (getMessageDataBaseBean.getStatus() == 0) {
                    if (this.c == null) {
                        this.c = new MessageBoardListAdapter(getBaseContext(), this.d);
                        this.message_board_recyclerview.setAdapter(this.c);
                    }
                    if (getMessageDataBaseBean.getResult().getTotal() > 0) {
                        this.d.addAll(getMessageDataBaseBean.getResult().getMessages());
                        if (this.d.size() == getMessageDataBaseBean.getResult().getTotal()) {
                            this.j = false;
                        }
                    } else {
                        this.j = false;
                    }
                    this.c.notifyDataSetChanged();
                    this.k = false;
                    break;
                }
                break;
            case 2001:
                if (!this.k) {
                    this.emptyLayout.setErrorType(10);
                    break;
                }
                this.emptyLayout.setErrorType(8);
                break;
        }
        return super.a(message);
    }
}
