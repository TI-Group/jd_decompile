package com.jd.fridge.qrCode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.a;
import com.jd.fridge.base.BaseActivity;
import com.jd.fridge.bean.ConcernListDataBean;
import com.jd.fridge.bean.FriendInfo;
import com.jd.fridge.bean.QrResult;
import com.jd.fridge.bean.requestBody.ConcernBody;
import com.jd.fridge.bean.requestBody.FeedId;
import com.jd.fridge.bean.requestBody.RefuseConcern;
import com.jd.fridge.friends.d;
import com.jd.fridge.util.c;
import com.jd.fridge.util.d.b;
import com.jd.fridge.util.h;
import com.jd.fridge.util.p;
import com.jd.fridge.util.r;
import com.jd.fridge.util.u;
import com.jd.fridge.util.y;
import com.jd.fridge.widget.CircularImageView;
import com.jd.fridge.widget.EmptyLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class QrCodeActivity extends BaseActivity implements d, c {
    private static final String b = QrCodeActivity.class.getSimpleName();
    FeedId a;
    private final int c = 100;
    private DampingView d;
    @BindView(2131558576)
    EmptyLayout emptyLayout;
    private Context i;
    private Bitmap j;
    private IWXAPI k;
    private Timer l;
    @BindView(2131558560)
    ListView lv_followme;
    private RelativeLayout m;
    private PopupWindow n;
    private boolean o = true;
    private boolean p;
    private List<FriendInfo> q = new ArrayList();
    @BindView(2131558620)
    LinearLayout qr_code_view;
    @BindView(2131558625)
    ImageView qr_imageview;
    @BindView(2131558623)
    ImageView qr_shared_imageview;
    @BindView(2131558624)
    LinearLayout qr_visible_view;
    private a r;
    private OnClickListener s = new OnClickListener(this) {
        final /* synthetic */ QrCodeActivity a;

        {
            this.a = r1;
        }

        public void onClick(View view) {
            this.a.h();
        }
    };
    @BindView(2131558626)
    ImageView save_qr_btn;
    @BindView(2131558627)
    ImageView share_qr_btn;
    private FriendInfo t;
    @BindView(2131558621)
    CircularImageView user_avatar;
    @BindView(2131558622)
    TextView user_name;

    protected int a() {
        return R.layout.qr_activity_view;
    }

    private void e() {
        int c = (u.c(this.i) - 40) - 120;
        LayoutParams layoutParams = (LayoutParams) this.qr_visible_view.getLayoutParams();
        layoutParams.height = (int) u.a(getResources(), (float) c);
        this.qr_visible_view.setLayoutParams(layoutParams);
        layoutParams = (LayoutParams) this.emptyLayout.getLayoutParams();
        layoutParams.height = (int) u.a(getResources(), (float) c);
        this.emptyLayout.setLayoutParams(layoutParams);
    }

    protected void b() {
        this.i = this;
        ButterKnife.bind((Activity) this);
        e();
        this.d = (DampingView) findViewById(R.id.dampingView);
        this.d.setViewChangeListener(this);
        this.emptyLayout.setErrorType(4);
        this.emptyLayout.setRefresh(new OnClickListener(this) {
            final /* synthetic */ QrCodeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.c();
            }
        });
        this.k = WXAPIFactory.createWXAPI(this, GlobalVariable.i);
        b((int) R.string.activity_qr_code_title_text);
        c((int) R.string.activity_qr_code_save_text);
        f(8);
        setAppbarRightTextBtnClickListener(this.s);
        ImageLoader.getInstance().displayImage(GlobalVariable.K(), this.user_avatar);
        this.user_name.setText(GlobalVariable.J());
        p();
        this.p = getIntent().getBooleanExtra("refresh_broadcast", false);
        a("冰箱二维码页面");
    }

    protected void c() {
        f();
        g();
    }

    private void f() {
        if (y.d((Context) this)) {
            a.a().b(this.e, new ConcernBody(GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
        }
    }

    private void g() {
        if (y.d((Context) this)) {
            this.emptyLayout.setErrorType(2);
            this.a = new FeedId(Long.parseLong(GlobalVariable.C()));
            a.a().b(this.e, this.a);
        } else if (this.o) {
            this.emptyLayout.setErrorType(1);
        } else {
            this.emptyLayout.setErrorType(11);
        }
    }

    protected void d() {
    }

    private void h() {
        if (!y.c() && this.j != null) {
            this.qr_code_view.setBackgroundColor(-1);
            this.qr_code_view.setDrawingCacheEnabled(true);
            this.qr_code_view.buildDrawingCache();
            b.a(getBaseContext(), "android.permission.WRITE_EXTERNAL_STORAGE", new com.jd.fridge.util.d.a(this) {
                final /* synthetic */ QrCodeActivity a;

                {
                    this.a = r1;
                }

                public void a() {
                    if (c.a(this.a.getApplicationContext(), this.a.qr_code_view.getDrawingCache(), "我的冰箱二维码" + System.currentTimeMillis() + ".jpg")) {
                        Toast.makeText(this.a.i, R.string.activity_qr_pic_saved_toast_text, 1).show();
                    }
                }
            });
            this.qr_code_view.setDrawingCacheEnabled(false);
        }
    }

    public boolean a(Message message) {
        boolean z = false;
        switch (message.what) {
            case 100:
                g();
                break;
            case 2000:
                ConcernListDataBean concernListDataBean = (ConcernListDataBean) message.obj;
                this.q.clear();
                this.q.addAll(concernListDataBean.getResult());
                this.d.setListViewStatus(this.q.size() > 0);
                if (this.r != null) {
                    this.r.notifyDataSetChanged();
                    break;
                }
                this.r = new a(this.i, this.q, this);
                this.r.a(this.d);
                this.lv_followme.setAdapter(this.r);
                this.lv_followme.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ QrCodeActivity a;

                    {
                        this.a = r1;
                    }

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.a.d.d() && i == 0) {
                            this.a.d.c();
                        }
                    }
                });
                break;
            case 2004:
                this.qr_visible_view.setVisibility(0);
                this.emptyLayout.setErrorType(4);
                try {
                    this.j = d("b=" + GlobalVariable.C() + "--" + ((QrResult) message.obj).getQr());
                    this.qr_imageview.setImageBitmap(this.j);
                    this.qr_shared_imageview.setImageBitmap(this.j);
                    i();
                } catch (WriterException e) {
                    r.b("QrCodeActivity", e.getMessage());
                }
                this.o = false;
                break;
            case 2005:
                if (!this.o) {
                    this.emptyLayout.setErrorType(10);
                    break;
                }
                this.qr_visible_view.setVisibility(8);
                this.emptyLayout.setErrorType(8);
                break;
            case 2016:
                this.q.remove(this.t);
                this.r.notifyDataSetChanged();
                DampingView dampingView = this.d;
                if (this.q.size() > 0) {
                    z = true;
                }
                dampingView.setListViewStatus(z);
                if (this.q.size() == 0) {
                    p.a(b, "data.size = 0 滚动");
                    this.d.a();
                    this.d.setHeaderShowing(true);
                    break;
                }
                break;
            case 2017:
                Toast.makeText(this.i, "删除失败", 0).show();
                break;
        }
        return super.a(message);
    }

    private void i() {
        if (this.l != null) {
            this.l.cancel();
        }
        this.l = new Timer();
        this.l.schedule(new TimerTask(this) {
            final /* synthetic */ QrCodeActivity a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.e.sendEmptyMessage(100);
            }
        }, 1140000);
    }

    protected void onDestroy() {
        if (this.p) {
            sendBroadcast(new Intent("ACTION_REFRESH_FOLLOWED_ME"));
        }
        super.onDestroy();
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
        if (this.j != null) {
            this.j.recycle();
        }
    }

    @OnClick({2131558627})
    void shareQr() {
        p.a(b, "shareQr.");
        if (this.j != null) {
            q();
        } else {
            new com.jd.fridge.widget.b.a(this).a((int) R.string.activity_qr_pic_generating_toast_text).a(com.jd.fridge.widget.b.a.b.SINGLE_BTN).d(R.string.activity_qr_pic_saved_toast_btn).show();
        }
    }

    @OnClick({2131558626})
    void saveQrClick() {
        p.a(b, "saveQrClick.");
        h();
    }

    private void p() {
        this.m = (RelativeLayout) getLayoutInflater().inflate(R.layout.share_qr_popup_layout, null, false);
        this.m.findViewById(R.id.share_to_wx).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QrCodeActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.r();
                this.a.n.dismiss();
            }
        });
        this.n = new PopupWindow(this.m, -1, (int) getResources().getDimension(R.dimen.share_popup_height));
        this.n.setAnimationStyle(R.style.AnimBottom);
        this.n.setFocusable(true);
        this.n.setOutsideTouchable(true);
        this.n.setTouchable(true);
        this.n.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ QrCodeActivity a;

            {
                this.a = r1;
            }

            public void onDismiss() {
                this.a.a(1.0f);
            }
        });
        this.n.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_window_bg_drawable));
    }

    private void a(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    private void q() {
        a(0.4f);
        this.n.showAtLocation(findViewById(R.id.share_qr_root_layout), 81, 0, 0);
    }

    private void r() {
        if (this.k.isWXAppInstalled()) {
            this.qr_code_view.setBackgroundColor(-1);
            this.qr_code_view.setDrawingCacheEnabled(true);
            this.qr_code_view.buildDrawingCache();
            Bitmap createBitmap = Bitmap.createBitmap(this.qr_code_view.getDrawingCache());
            IMediaObject wXImageObject = new WXImageObject(createBitmap);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.qr_code_view.getDrawingCache(), 150, (h.a(getApplicationContext(), 430.0f) * 150) / h.a(getApplicationContext()), true);
            createBitmap.recycle();
            wXMediaMessage.setThumbImage(createScaledBitmap);
            BaseReq req = new Req();
            req.transaction = e(SocialConstants.PARAM_IMG_URL);
            req.message = wXMediaMessage;
            req.scene = 0;
            this.k.sendReq(req);
            this.qr_code_view.setDrawingCacheEnabled(false);
            return;
        }
        Toast.makeText(this, getString(R.string.wx_share_no_wx), 0).show();
    }

    public Bitmap d(String str) throws WriterException {
        Map hashtable = new Hashtable();
        hashtable.put(EncodeHintType.CHARACTER_SET, HTTP.UTF_8);
        BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 580, 580, hashtable);
        int width = encode.getWidth();
        int height = encode.getHeight();
        int[] iArr = new int[(width * height)];
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                if (encode.get(i2, i)) {
                    iArr[(i * width) + i2] = -16777216;
                } else {
                    iArr[(i * width) + i2] = -1;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    private String e(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    public void a(FriendInfo friendInfo) {
        if (y.d(this.i)) {
            this.t = friendInfo;
            a.a().a(this.e, new RefuseConcern(friendInfo.getPin(), GlobalVariable.I(), Long.parseLong(GlobalVariable.C())));
        }
    }

    public void a(boolean z) {
        if (this.r != null) {
            this.r.notifyDataSetChanged();
            return;
        }
        this.r = new a(this.i, this.q, this);
        this.r.a(this.d);
        this.lv_followme.setAdapter(this.r);
    }
}
