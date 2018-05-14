package com.jd.fridge.base;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.R;
import com.jd.fridge.bean.Event;
import com.jd.fridge.bean.ShareDataBean;
import com.jd.fridge.util.c;
import com.jd.fridge.util.k;
import com.jd.fridge.util.r;
import com.jd.fridge.util.t;
import com.jd.fridge.util.y;
import com.jingdong.jdma.JDMaInterface;
import com.jingdong.jdma.common.utils.CommonUtil;
import com.jingdong.jdma.minterface.ClickInterfaceParam;
import com.jingdong.jdma.minterface.PvInterfaceParam;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.commons.lang.StringUtils;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.j;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/* compiled from: TbsSdkJava */
public abstract class BaseActivity extends AppCompatActivity implements com.jd.fridge.widget.b.a {
    private static final String p = BaseActivity.class.getSimpleName();
    private com.jd.fridge.widget.a a = null;
    private TextView b;
    private FrameLayout c;
    private ImageView d;
    protected Handler e = null;
    protected com.jd.fridge.widget.b f;
    public FrameLayout g;
    public TextView h;
    private ViewGroup i;
    private t j;
    private ProgressDialog k;
    private IWXAPI l = null;
    private View m;
    private boolean n = false;
    private NetworkReceiver o;

    /* compiled from: TbsSdkJava */
    public class NetworkReceiver extends BroadcastReceiver {
        final /* synthetic */ BaseActivity a;

        public NetworkReceiver(BaseActivity baseActivity) {
            this.a = baseActivity;
        }

        public void onReceive(Context context, Intent intent) {
            intent.getAction();
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction()) || "android.net.wifi.STATE_CHANGE".equals(intent.getAction()) || "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                k.a("网络变化广播");
                r.b("infos", "==网络变化广播==");
                if (!this.a.n) {
                    if (y.d(this.a.getApplicationContext())) {
                        if (this.a.m.getVisibility() == 0) {
                            this.a.m.setVisibility(8);
                        }
                    } else if (this.a.m.getVisibility() == 8) {
                        this.a.m.setVisibility(0);
                    }
                }
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private static class a<T extends BaseActivity> extends Handler {
        private WeakReference<? extends BaseActivity> a;

        public a(T t) {
            this.a = new WeakReference(t);
        }

        public void handleMessage(Message message) {
            BaseActivity baseActivity = this.a == null ? null : (BaseActivity) this.a.get();
            if (baseActivity != null && !baseActivity.isFinishing()) {
                baseActivity.a(message);
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class b extends AsyncTask<String, Integer, Boolean> {
        final /* synthetic */ BaseActivity a;
        private final int b;
        private final ShareDataBean c;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            a((Boolean) obj);
        }

        public b(BaseActivity baseActivity, int i, ShareDataBean shareDataBean) {
            this.a = baseActivity;
            this.b = i;
            this.c = shareDataBean;
        }

        protected void onPreExecute() {
            super.onPreExecute();
            this.a.k = ProgressDialog.show(this.a, "", this.a.getString(R.string.wx_share_loading), true, false);
        }

        protected Boolean a(String... strArr) {
            this.a.l = WXAPIFactory.createWXAPI(this.a, GlobalVariable.i);
            this.a.l.registerApp(GlobalVariable.i);
            if (!this.a.l.isWXAppInstalled()) {
                this.a.b(this.a.getString(R.string.wx_share_no_wx));
                return Boolean.valueOf(true);
            } else if (this.b != 1 || this.a.l.getWXAppSupportAPI() >= Build.TIMELINE_SUPPORTED_SDK_INT) {
                Bitmap decodeStream;
                IMediaObject wXWebpageObject = new WXWebpageObject();
                wXWebpageObject.webpageUrl = this.c.getShareUrl();
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
                wXMediaMessage.title = this.c.getShareTitle();
                wXMediaMessage.description = this.c.getShareText();
                try {
                    decodeStream = BitmapFactory.decodeStream(new URL(this.c.getSharePicUrl()).openStream());
                } catch (Exception e) {
                    decodeStream = null;
                }
                if (decodeStream != null) {
                    try {
                        if (decodeStream.getWidth() * decodeStream.getHeight() > 40000) {
                            decodeStream = c.b(decodeStream, 200, 200);
                        }
                        wXMediaMessage.setThumbImage(decodeStream);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return Boolean.valueOf(false);
                    }
                }
                wXMediaMessage.setThumbImage(BitmapFactory.decodeResource(this.a.getResources(), R.mipmap.ic_launcher));
                BaseReq req = new Req();
                req.transaction = this.a.d("webpage");
                req.message = wXMediaMessage;
                req.scene = this.b;
                this.a.l.sendReq(req);
                return Boolean.valueOf(true);
            } else {
                this.a.b(this.a.getString(R.string.wx_share_error_tip));
                return Boolean.valueOf(true);
            }
        }

        protected void a(Boolean bool) {
            super.onPostExecute(bool);
            if (!bool.booleanValue()) {
                this.a.b(this.a.getString(R.string.wx_share_failed));
            }
            if (this.a.k != null && this.a.k.isShowing()) {
                this.a.k.dismiss();
            }
        }
    }

    protected abstract int a();

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        org.greenrobot.eventbus.c.a().a((Object) this);
        com.jd.fridge.util.a.a().a(this);
        d();
        setContentView((int) R.layout.activity_base_no_actionbar);
        this.i = (ViewGroup) findViewById(R.id.appbar);
        this.i.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(l(), this.i);
        if (l() == R.layout.view_base_appbar) {
            this.g = (FrameLayout) inflate.findViewById(R.id.layout_base_bar_back);
            this.b = (TextView) inflate.findViewById(R.id.tv_base_bar_title);
            this.c = (FrameLayout) inflate.findViewById(R.id.fl_base_btn_container);
            this.h = (TextView) inflate.findViewById(R.id.tv_base_btn_menu);
            this.d = (ImageView) inflate.findViewById(R.id.base_right_appbar_btn);
            if (this.g != null) {
                this.g.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BaseActivity a;

                    {
                        this.a = r1;
                    }

                    public void onClick(View view) {
                        if (!y.c()) {
                            this.a.finish();
                        }
                    }
                });
            }
            if (this.c != null && m() > 0) {
                this.c.removeAllViews();
                LayoutInflater.from(this).inflate(m(), this.c);
            }
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        if (a() <= 0) {
            throw new RuntimeException("implement getContentView() in first, please");
        }
        LayoutInflater.from(this).inflate(a(), viewGroup);
        this.e = new a(this);
        this.a = new com.jd.fridge.widget.a(this);
        this.j = new t(this);
        this.f = new com.jd.fridge.widget.b(this);
        this.m = findViewById(R.id.net_work_float).findViewById(R.id.layout_float);
        this.m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BaseActivity a;

            {
                this.a = r1;
            }

            public void onClick(View view) {
                this.a.startActivity(new Intent(this.a, NoNetworkActivity.class));
            }
        });
        this.o = new NetworkReceiver(this);
        a(this.o);
        if (y.d(getApplicationContext())) {
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
        }
        b();
        c();
    }

    protected void onResume() {
        if (this.n) {
            JDMaInterface.onResume(this);
            super.onResume();
        } else {
            JDMaInterface.onResume(this);
            super.onResume();
        }
    }

    protected void onPause() {
        JDMaInterface.onPause();
        super.onPause();
    }

    protected void onDestroy() {
        org.greenrobot.eventbus.c.a().b(this);
        com.jd.fridge.util.a.a().b(this);
        this.e.removeCallbacksAndMessages(null);
        if (this.a != null && this.a.isShowing()) {
            this.a.dismiss();
        }
        if (this.f != null && this.f.isShowing()) {
            this.f.dismiss();
        }
        o();
        super.onDestroy();
    }

    public void a(String str) {
        PvInterfaceParam pvInterfaceParam = new PvInterfaceParam();
        pvInterfaceParam.page_name = str;
        String str2 = null;
        try {
            str2 = URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        pvInterfaceParam.pin = str2;
        pvInterfaceParam.page_param = "";
        pvInterfaceParam.lat = "1.0";
        pvInterfaceParam.lon = "1.0";
        JDMaInterface.sendPvData(getBaseContext(), GlobalVariable.B().c(), pvInterfaceParam);
    }

    public void b(String str, String str2) {
        ClickInterfaceParam clickInterfaceParam = new ClickInterfaceParam();
        clickInterfaceParam.page_name = str;
        String str3 = null;
        try {
            str3 = URLEncoder.encode(com.jd.fridge.util.c.a.b().getPin(), CommonUtil.UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        clickInterfaceParam.pin = str3;
        clickInterfaceParam.next_page_name = "";
        clickInterfaceParam.event_id = str2;
        clickInterfaceParam.event_param = "";
        JDMaInterface.sendClickData(getBaseContext(), GlobalVariable.B().c(), clickInterfaceParam);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (a(currentFocus, motionEvent)) {
                a(currentFocus.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean a(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = new int[]{0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int height = view.getHeight() + i2;
        int width = view.getWidth() + i;
        if (motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) height)) {
            return true;
        }
        return false;
    }

    public void a(IBinder iBinder) {
        if (iBinder != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 2);
        }
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }

    protected boolean a(Message message) {
        switch (message.what) {
            case 10001:
                if (this.a != null && this.a.isShowing()) {
                    this.a.dismiss();
                    break;
                }
            case 10002:
                if (this.a != null) {
                    this.a.a(((Boolean) message.obj).booleanValue());
                    this.a.show();
                    break;
                }
                break;
        }
        return false;
    }

    public void a_(boolean z) {
        this.e.sendMessage(this.e.obtainMessage(10002, Boolean.valueOf(z)));
    }

    public void j() {
        this.e.sendEmptyMessage(10001);
    }

    public void b(String str) {
        if (StringUtils.isNotBlank(str)) {
            r.b("infos", "msg==" + str + "===dialog==" + this.j);
            k.a("msg==" + str + "===dialog==" + this.j);
            this.j.a(str);
        }
    }

    public void b(boolean z) {
        if (this.m != null) {
            this.n = z;
            if (z) {
                this.m.setVisibility(8);
            } else if (y.d(getApplicationContext())) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
            }
        }
    }

    public void k() {
        if (this.i != null) {
            this.i.setVisibility(8);
        }
    }

    protected int l() {
        return R.layout.view_base_appbar;
    }

    protected void c(String str) {
        if (this.b != null && StringUtils.isNotBlank(str)) {
            this.b.setText(str);
        }
    }

    protected void b(int i) {
        if (this.b != null) {
            this.b.setText(i);
        }
    }

    protected void setAppbarBackBtnClickListener(OnClickListener onClickListener) {
        if (this.g != null) {
            this.g.setOnClickListener(onClickListener);
        }
    }

    protected void setAppbarRightTextBtnClickListener(OnClickListener onClickListener) {
        if (this.h != null) {
            this.h.setOnClickListener(onClickListener);
        } else {
            this.h.setOnClickListener(onClickListener);
        }
    }

    protected void c(int i) {
        if (this.h != null) {
            this.h.setText(i);
        }
    }

    protected void setAppbarRightBtnClickListener(OnClickListener onClickListener) {
        if (this.d != null) {
            this.d.setOnClickListener(onClickListener);
        } else {
            this.d.setOnClickListener(onClickListener);
        }
    }

    protected void d(int i) {
        if (this.d != null) {
            this.d.setImageResource(i);
        }
    }

    protected void e(int i) {
        if (this.g != null) {
            this.g.setVisibility(i);
        }
    }

    protected void f(int i) {
        if (this.h != null) {
            this.h.setVisibility(i);
        }
    }

    protected void g(int i) {
        if (this.d != null) {
            this.d.setVisibility(i);
        }
    }

    protected int m() {
        return 0;
    }

    protected void n() {
        this.f = new com.jd.fridge.widget.b(this);
    }

    public void a(ShareDataBean shareDataBean) {
        if (this.f != null && shareDataBean != null) {
            this.f.a(shareDataBean.getShareUrl(), shareDataBean.getSharePicUrl(), shareDataBean.getShareText(), shareDataBean.getShareTitle());
            this.f.show();
        }
    }

    public void b(ShareDataBean shareDataBean) {
        new b(this, 0, shareDataBean).execute(new String[0]);
    }

    public void c(ShareDataBean shareDataBean) {
        new b(this, 1, shareDataBean).execute(new String[0]);
    }

    private String d(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (com.jd.fridge.util.d.b.a() != null) {
            Object obj = 1;
            for (int i2 : iArr) {
                if (i2 != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                com.jd.fridge.util.d.b.a().a();
                com.jd.fridge.util.d.b.b();
                return;
            }
            com.jd.fridge.util.d.b.a().b();
            com.jd.fridge.util.d.b.b();
            new com.jd.fridge.widget.b.a(this).a((int) R.string.no_premission_granted).a(com.jd.fridge.widget.b.a.b.SINGLE_BTN).d(R.string.activity_modify_user_nickname_toast_btn).show();
        }
    }

    private void a(NetworkReceiver networkReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.setPriority(1000);
        registerReceiver(networkReceiver, intentFilter);
    }

    public void o() {
        if (this.o != null) {
            unregisterReceiver(this.o);
        }
    }

    @j(a = ThreadMode.MAIN)
    public void onEventMainThread(Event event) {
        if (event != null) {
            r.b("infos", "base.type===" + event.getType());
            switch (event.getType()) {
                case 2:
                    if (this.m != null && !this.n) {
                        this.m.setVisibility(0);
                        return;
                    }
                    return;
                case 3:
                    if (this.m != null && this.m.getVisibility() == 0) {
                        this.m.setVisibility(8);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.fontScale != 1.0f) {
            getResources();
        }
        super.onConfigurationChanged(configuration);
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        if (resources.getConfiguration().fontScale != 1.0f) {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            if (VERSION.SDK_INT >= 17) {
                createConfigurationContext(configuration);
            } else {
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
        }
        return resources;
    }
}
