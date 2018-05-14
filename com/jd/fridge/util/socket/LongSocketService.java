package com.jd.fridge.util.socket;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.jd.fridge.util.p;
import com.jd.fridge.util.y;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class LongSocketService extends Service implements com.jd.fridge.util.socket.a.a, com.jd.fridge.util.socket.b.a {
    private static String d;
    private b a;
    private a b;
    private b c;
    private a e;

    /* compiled from: TbsSdkJava */
    private class a extends Handler {
        WeakReference<Service> a;
        final /* synthetic */ LongSocketService b;

        public a(LongSocketService longSocketService, Looper looper, Service service) {
            this.b = longSocketService;
            super(looper);
            this.a = new WeakReference(service);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (((Service) this.a.get()) != null) {
                switch (message.what) {
                    case 1:
                        if (y.d(this.b)) {
                            this.b.a();
                            return;
                        } else if (this.b.e != null) {
                            this.b.e.sendEmptyMessageDelayed(1, 5000);
                            return;
                        } else {
                            return;
                        }
                    case 2:
                        if (this.b.b != null && !this.b.b.e()) {
                            p.a("jd-socket", "heart beat is not sync");
                            this.b.f();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private class b extends BroadcastReceiver {
        final /* synthetic */ LongSocketService a;

        private b(LongSocketService longSocketService) {
            this.a = longSocketService;
        }

        public void onReceive(Context context, Intent intent) {
            CharSequence action = intent.getAction();
            p.a("jd-socket", "switch device register...");
            if (!TextUtils.equals(action, "ACTION_SWITCH_FRIDGE_SUCCESS")) {
                return;
            }
            if (this.a.b != null) {
                this.a.b.b();
            } else {
                this.a.f();
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        g();
        p.a("jd-socket", "onCreate...");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        p.a("jd-socket", "service onStartCommand");
        if (this.e == null) {
            this.e = new a(this, getMainLooper(), this);
        }
        if (this.a == null || this.b == null || !this.b.e() || !this.b.h()) {
            if (this.e == null) {
                this.e = new a(this, getMainLooper(), this);
            }
            this.e.sendEmptyMessage(1);
        }
        return super.onStartCommand(intent, i, i2);
    }

    private void f() {
        if (this.b != null) {
            this.b.i();
        }
        a();
    }

    public void a() {
        if (y.d((Context) this)) {
            if (this.a != null) {
                this.a = null;
            }
            b.a();
            this.a = b.a((com.jd.fridge.util.socket.b.a) this);
            this.a.c();
        }
    }

    public void b() {
        p.a("jd-socket", "init: SSL Connect success");
        if (this.b != null) {
            this.b = null;
        }
        a.f();
        if (this.e == null) {
            this.e = new a(this, getMainLooper(), this);
        }
        this.b = a.a(b.b().e(), this, this.e);
        this.b.a();
    }

    public void c() {
        if (this.e != null) {
            p.c("jd-socket", "init: SSL Connect Failed");
            this.e.sendEmptyMessageDelayed(1, 5000);
        }
    }

    public void a(String str) {
        String str2 = "";
        try {
            str2 = new JSONObject(str).optJSONObject("header").optString("code");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (TextUtils.equals(str2, "auth_resp")) {
            p.a("jd-socket", "result-认证信息：" + str);
            this.b.b();
            this.b.c();
        }
        if (str2.equals("sub_snapshot_resp")) {
            p.a("jd-socket", "result-订阅信息：" + str);
            d = str;
            b(str);
        }
        if (str2.equals("heartbeat_resp")) {
            p.a("jd-socket", "result-心跳：" + str);
            this.b.d();
        }
        if (str2.equals("snapshot")) {
            p.a("jd-socket", "result-快照：" + str);
            b(str);
        }
        if (str2.equals("unsub_snapshot_resp")) {
            p.a("jd-socket", "reusult-取消订阅: " + str);
            this.b.b();
        }
    }

    public void d() {
        f();
    }

    private void b(String str) {
        Intent intent = new Intent("get_snap_shot");
        intent.putExtra("data", str);
        sendBroadcast(intent);
    }

    public static String e() {
        return d;
    }

    public void onDestroy() {
        super.onDestroy();
        p.c("jd-socket", "service is destroy....");
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        if (this.e != null) {
            this.e.removeCallbacksAndMessages(null);
            this.e = null;
        }
        if (this.c != null) {
            unregisterReceiver(this.c);
            this.c = null;
        }
        if (this.a != null) {
            this.a.f();
            this.a = null;
        }
    }

    public static void a(Activity activity) {
        activity.stopService(new Intent(activity, LongSocketService.class));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void g() {
        this.c = new b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ACTION_SWITCH_FRIDGE_SUCCESS");
        registerReceiver(this.c, intentFilter);
    }
}
