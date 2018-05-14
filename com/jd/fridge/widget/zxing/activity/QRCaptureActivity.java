package com.jd.fridge.widget.zxing.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.zxing.Result;
import com.google.zxing.client.result.ResultParser;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.ResponseDataBaseBean;
import com.jd.fridge.bean.requestBody.AddFriend;
import com.jd.fridge.util.r;
import com.jd.fridge.util.x;
import com.jd.fridge.widget.zxing.a.c;
import com.jd.fridge.widget.zxing.d.b;
import com.jd.fridge.widget.zxing.d.d;
import java.lang.ref.WeakReference;

/* compiled from: TbsSdkJava */
public final class QRCaptureActivity extends Activity implements Callback, OnClickListener {
    private static final String a = QRCaptureActivity.class.getSimpleName();
    private c b;
    private com.jd.fridge.widget.zxing.d.c c;
    private d d;
    private com.jd.fridge.widget.zxing.d.a e;
    private SurfaceView f = null;
    private RelativeLayout g;
    private RelativeLayout h;
    private ImageView i;
    private Rect j = null;
    private boolean k;
    private Context l;
    private String m;
    private Handler n = new a(this);
    private boolean o = false;

    /* compiled from: TbsSdkJava */
    static class a extends Handler {
        private WeakReference<Activity> a;

        public a(Activity activity) {
            this.a = new WeakReference(activity);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 200:
                    String obj = message.obj.toString();
                    com.jd.fridge.a.a().a((Handler) this, new AddFriend(Long.parseLong(GlobalVariable.C()), obj.substring(obj.indexOf("--") + 2)));
                    break;
                case 300:
                    if (this.a != null) {
                        x.a((Context) this.a.get(), "解析图片失败");
                        ((QRCaptureActivity) this.a.get()).d();
                        break;
                    }
                    return;
                case 2000:
                    if (this.a != null) {
                        ResponseDataBaseBean responseDataBaseBean = (ResponseDataBaseBean) message.obj;
                        if (responseDataBaseBean.getStatus() != 0) {
                            if (responseDataBaseBean.getStatus() == 101) {
                                x.a((Context) this.a.get(), (int) R.string.parse_code_zxing_error);
                                ((QRCaptureActivity) this.a.get()).d();
                                break;
                            }
                        }
                        x.a((Context) this.a.get(), (int) R.string.activity_qr_capture_follow_success);
                        ((Activity) this.a.get()).sendBroadcast(new Intent("ACTION_MAKE_FRIENDS_SUCCESS"));
                        new Handler().postDelayed(new Runnable(this) {
                            final /* synthetic */ a a;

                            {
                                this.a = r1;
                            }

                            public void run() {
                                ((Activity) this.a.a.get()).finish();
                            }
                        }, 1000);
                        break;
                    }
                    return;
                    break;
                case 2001:
                    if (this.a != null) {
                        if (!String.valueOf(message.obj).equals("")) {
                            x.a((Context) this.a.get(), String.valueOf(message.obj));
                        }
                        ((QRCaptureActivity) this.a.get()).d();
                        break;
                    }
                    return;
            }
            super.handleMessage(message);
        }
    }

    public Handler a() {
        return this.c;
    }

    public c b() {
        return this.b;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.l = this;
        getWindow().addFlags(128);
        setContentView(R.layout.qr_activity_capture);
        this.f = (SurfaceView) findViewById(R.id.capture_preview);
        this.g = (RelativeLayout) findViewById(R.id.capture_container);
        this.h = (RelativeLayout) findViewById(R.id.capture_crop_view);
        this.i = (ImageView) findViewById(R.id.capture_scan_line);
        this.d = new d(this);
        this.e = new com.jd.fridge.widget.zxing.d.a(this);
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 0.9f);
        translateAnimation.setDuration(4500);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        this.i.startAnimation(translateAnimation);
        findViewById(R.id.layout_base_bar_back).setOnClickListener(this);
        findViewById(R.id.fl_base_btn_container).setOnClickListener(this);
    }

    protected void onResume() {
        super.onResume();
        this.b = new c(getApplication());
        this.c = null;
        if (this.o) {
            a(this.f.getHolder());
        } else {
            this.f.getHolder().addCallback(this);
        }
        this.d.c();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onPause() {
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
        this.d.b();
        this.e.close();
        this.b.b();
        if (!this.o) {
            this.f.getHolder().removeCallback(this);
        }
        super.onPause();
    }

    protected void onDestroy() {
        this.d.d();
        super.onDestroy();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            r.b(a, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.o) {
            this.o = true;
            a(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.o = false;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void a(Result result, Bundle bundle) {
        this.d.a();
        this.e.a();
        if (result != null) {
            Message obtainMessage = this.n.obtainMessage();
            obtainMessage.what = 200;
            obtainMessage.obj = ResultParser.parseResult(result).toString();
            this.n.sendMessage(obtainMessage);
            return;
        }
        obtainMessage = this.n.obtainMessage();
        obtainMessage.what = 300;
        this.n.sendMessage(obtainMessage);
    }

    private void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (this.b.a()) {
            r.d(a, "initCamera() while already open -- late SurfaceView callback?");
        } else {
            try {
                this.b.a(surfaceHolder);
                if (this.c == null) {
                    this.c = new com.jd.fridge.widget.zxing.d.c(this, this.b, 768);
                }
                f();
            } catch (Throwable e) {
                r.a(a, e);
                e();
            } catch (Throwable e2) {
                r.b(a, "Unexpected error initializing camera", e2);
                e();
            }
        }
    }

    private void d() {
        a(this.f.getHolder());
        new Handler().postDelayed(new Runnable(this) {
            final /* synthetic */ QRCaptureActivity a;

            {
                this.a = r1;
            }

            public void run() {
                if (this.a.c != null) {
                    this.a.c.b();
                }
            }
        }, 3000);
    }

    private void e() {
        Builder builder = new Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage("相机打开出错，请稍后重试");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener(this) {
            final /* synthetic */ QRCaptureActivity a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.finish();
            }
        });
        builder.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ QRCaptureActivity a;

            {
                this.a = r1;
            }

            public void onCancel(DialogInterface dialogInterface) {
                this.a.finish();
            }
        });
        builder.show();
    }

    public Rect c() {
        return this.j;
    }

    private void f() {
        int i = this.b.e().y;
        int i2 = this.b.e().x;
        int[] iArr = new int[2];
        this.h.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int g = iArr[1] - g();
        int width = this.h.getWidth();
        int height = this.h.getHeight();
        int width2 = this.g.getWidth();
        int height2 = this.g.getHeight();
        i3 = (i3 * i) / width2;
        g = (g * i2) / height2;
        this.j = new Rect(i3, g, ((i * width) / width2) + i3, ((i2 * height) / height2) + g);
    }

    private int g() {
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            return getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 100:
                    this.m = b.a(this, intent.getData());
                    final ProgressDialog progressDialog = new ProgressDialog(this);
                    progressDialog.setMessage("正在扫描...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    new Thread(new Runnable(this) {
                        final /* synthetic */ QRCaptureActivity b;

                        public void run() {
                            Result a = new com.jd.fridge.widget.zxing.b.a(this.b).a(b.a(this.b.m));
                            if (a != null) {
                                Message obtainMessage = this.b.n.obtainMessage();
                                obtainMessage.what = 200;
                                obtainMessage.obj = ResultParser.parseResult(a).toString();
                                this.b.n.sendMessage(obtainMessage);
                            } else {
                                Message obtainMessage2 = this.b.n.obtainMessage();
                                obtainMessage2.what = 300;
                                this.b.n.sendMessage(obtainMessage2);
                            }
                            progressDialog.dismiss();
                        }
                    }).start();
                    return;
                default:
                    return;
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_base_bar_back:
                finish();
                return;
            case R.id.fl_base_btn_container:
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "选择二维码图片"), 100);
                return;
            case R.id.capture_flashlight:
                if (this.k) {
                    this.b.a(false);
                    this.k = false;
                    return;
                }
                this.b.a(true);
                this.k = true;
                return;
            default:
                return;
        }
    }
}
