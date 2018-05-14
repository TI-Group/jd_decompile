package com.jd.fridge.qrCode;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.util.c;
import com.jd.fridge.util.d.a;
import com.jd.fridge.util.d.b;
import com.jd.fridge.util.h;
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
import java.util.Hashtable;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* compiled from: TbsSdkJava */
public class QrCodeView extends RelativeLayout implements OnClickListener {
    private View a;
    private Context b;
    private Activity c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private Bitmap g;
    private LinearLayout h;
    private CircularImageView i;
    private TextView j;
    private ImageView k;
    private EmptyLayout l;
    private IWXAPI m;
    private RelativeLayout n;
    private PopupWindow o;

    public QrCodeView(Context context) {
        super(context);
    }

    public QrCodeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = (Activity) context;
        this.b = context;
        this.a = LayoutInflater.from(context).inflate(R.layout.qr_code_view, this);
        b();
    }

    private void b() {
        this.d = (ImageView) findViewById(R.id.save_qr);
        this.d.setOnClickListener(this);
        this.e = (ImageView) findViewById(R.id.share_qr);
        this.e.setOnClickListener(this);
        this.f = (ImageView) findViewById(R.id.iv_qr);
        this.h = (LinearLayout) findViewById(R.id.qr_save_view);
        this.i = (CircularImageView) findViewById(R.id.user_avatar);
        this.j = (TextView) findViewById(R.id.user_name);
        this.k = (ImageView) findViewById(R.id.qr_save_iv);
        ImageLoader.getInstance().displayImage(GlobalVariable.K(), this.i);
        this.j.setText(GlobalVariable.J());
        this.l = (EmptyLayout) findViewById(R.id.empty_layout);
    }

    public void setQR(String str) {
        try {
            this.g = a(str);
            this.f.setImageBitmap(this.g);
            this.k.setImageBitmap(this.g);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public void setEmptLayout(int i) {
        this.l.setErrorType(i);
    }

    public EmptyLayout getEmptyLayout() {
        return this.l;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_qr:
                c();
                return;
            case R.id.share_qr:
                g();
                return;
            default:
                return;
        }
    }

    private void c() {
        if (!y.c() && this.g != null) {
            b.a(this.b, "android.permission.WRITE_EXTERNAL_STORAGE", new a(this) {
                final /* synthetic */ QrCodeView a;

                {
                    this.a = r1;
                }

                public void a() {
                    if (c.a(this.a.b, this.a.d(), "我的冰箱二维码" + System.currentTimeMillis() + ".jpg")) {
                        Toast.makeText(this.a.b, R.string.activity_qr_pic_saved_toast_text, 1).show();
                    }
                }
            });
            this.h.setDrawingCacheEnabled(false);
        }
    }

    private Bitmap d() {
        this.i.setDrawingCacheEnabled(true);
        this.h.setBackgroundColor(-1);
        this.h.setDrawingCacheEnabled(true);
        this.h.buildDrawingCache();
        return this.h.getDrawingCache();
    }

    private Bitmap a(String str) throws WriterException {
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

    private void e() {
        if (this.m == null) {
            this.m = WXAPIFactory.createWXAPI(this.c, GlobalVariable.i);
        }
        if (this.m.isWXAppInstalled()) {
            Bitmap createBitmap = Bitmap.createBitmap(d());
            IMediaObject wXImageObject = new WXImageObject(createBitmap);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(d(), 150, (h.a(this.c.getApplicationContext(), 430.0f) * 150) / h.a(this.c.getApplicationContext()), true);
            createBitmap.recycle();
            wXMediaMessage.setThumbImage(createScaledBitmap);
            BaseReq req = new Req();
            req.transaction = b(SocialConstants.PARAM_IMG_URL);
            req.message = wXMediaMessage;
            req.scene = 0;
            this.m.sendReq(req);
            this.h.setDrawingCacheEnabled(false);
            return;
        }
        Toast.makeText(this.c, this.c.getString(R.string.wx_share_no_wx), 0).show();
    }

    private String b(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : str + System.currentTimeMillis();
    }

    private void f() {
        this.n = (RelativeLayout) this.c.getLayoutInflater().inflate(R.layout.share_qr_popup_layout, null, false);
        this.n.findViewById(R.id.share_to_wx).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QrCodeView a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.e();
                this.a.o.dismiss();
            }
        });
        this.o = new PopupWindow(this.n, -1, (int) getResources().getDimension(R.dimen.share_popup_height));
        this.o.setAnimationStyle(R.style.AnimBottom);
        this.o.setFocusable(true);
        this.o.setOutsideTouchable(true);
        this.o.setTouchable(true);
        this.o.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ QrCodeView a;

            {
                this.a = r1;
            }

            public void onDismiss() {
                this.a.a(1.0f);
            }
        });
        this.o.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_window_bg_drawable));
    }

    private void a(float f) {
        LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.alpha = f;
        this.c.getWindow().setAttributes(attributes);
    }

    private void g() {
        if (this.o == null) {
            f();
        }
        a(0.4f);
        this.o.showAtLocation(findViewById(R.id.share_qr_root_layout), 81, 0, 0);
    }

    public void a() {
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
    }
}
