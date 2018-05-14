package com.jd.fridge.util.socket;

import android.os.Handler;
import com.jd.fridge.GlobalVariable;
import com.jd.fridge.util.p;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLSocket;
import jd.wjlogin_sdk.util.NetworkType;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TbsSdkJava */
public class a {
    private static final int c = Runtime.getRuntime().availableProcessors();
    private static a e;
    ScheduledThreadPoolExecutor a;
    Runnable b = new Runnable(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public void run() {
            if (this.a.k != null && this.a.k.isConnected() && !this.a.k.isClosed() && !this.a.k.isOutputShutdown()) {
                if (this.a.h.get()) {
                    this.a.i.set(false);
                } else {
                    this.a.h.set(true);
                }
                String jSONObject = this.a.a("heartbeat", new JSONObject()).toString();
                p.a("jd-socket", "send-心跳: " + jSONObject);
                this.a.a(jSONObject);
                if (this.a.j != null) {
                    boolean sendEmptyMessageDelayed = this.a.j.sendEmptyMessageDelayed(2, 8000);
                    p.a("jd-socket", sendEmptyMessageDelayed ? "handler send success" : "handler send failed");
                    if (!sendEmptyMessageDelayed && !sendEmptyMessageDelayed) {
                        if (this.a.g != null) {
                            this.a.g.d();
                            return;
                        } else {
                            p.a("LeakLog", "GC: listener 1");
                            return;
                        }
                    }
                    return;
                }
                p.c("jd-socket", "心跳匹配：handler == null");
                if (this.a.g != null) {
                    this.a.g.d();
                } else {
                    p.a("LeakLog", "GC: listener 2");
                }
            }
        }
    };
    private final int d = ((c * 2) + 1);
    private AtomicInteger f = new AtomicInteger(0);
    private a g;
    private AtomicBoolean h = new AtomicBoolean(false);
    private AtomicBoolean i = new AtomicBoolean(false);
    private Handler j;
    private SSLSocket k;
    private BufferedReader l;
    private PrintWriter m;
    private b n;

    /* compiled from: TbsSdkJava */
    public interface a {
        void a(String str);

        void d();
    }

    /* compiled from: TbsSdkJava */
    class b extends Thread {
        final /* synthetic */ a a;

        b(a aVar) {
            this.a = aVar;
        }

        public void run() {
            if (this.a.k != null) {
                try {
                    this.a.l = new BufferedReader(new InputStreamReader(this.a.k.getInputStream()));
                    while (this.a.h()) {
                        String readLine = this.a.l.readLine();
                        if (readLine == null) {
                            return;
                        }
                        if (this.a.g != null) {
                            this.a.g.a(readLine);
                        } else {
                            p.a("LeakLog", "GC: listener 3");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    p.c("jd-socket", "Thread.currentThread().interrupt()");
                    this.a.i();
                    if (this.a.j != null) {
                        this.a.j.sendEmptyMessageDelayed(1, 5000);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    p.c("jd-socket", "NewHeartBearHelper Exception e");
                    this.a.i();
                    if (this.a.j != null) {
                        this.a.j.sendEmptyMessageDelayed(1, 5000);
                    }
                }
            }
        }
    }

    private a(SSLSocket sSLSocket, a aVar, Handler handler) {
        if (sSLSocket != null) {
            this.k = sSLSocket;
            try {
                this.l = new BufferedReader(new InputStreamReader(this.k.getInputStream()));
                this.m = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.k.getOutputStream(), CommonUtil.UTF8)), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (aVar != null) {
            this.g = aVar;
        }
        if (handler != null) {
            this.j = handler;
        }
    }

    public static a a(SSLSocket sSLSocket, a aVar, Handler handler) {
        if (e == null) {
            synchronized (a.class) {
                e = new a(sSLSocket, aVar, handler);
            }
        }
        return e;
    }

    public void a() {
        new Thread(new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void run() {
                String jSONObject = this.a.a("auth", this.a.m()).toString();
                p.a("jd-socket", "send-认证: " + jSONObject);
                this.a.a(jSONObject);
            }
        }).start();
        j();
    }

    public void b() {
        new Thread(new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    GlobalVariable.B();
                    jSONObject.put("feed_id", GlobalVariable.C());
                    jSONObject = this.a.a("sub_snapshot", jSONObject);
                    p.a("jd-socket", "send-设备订阅: " + jSONObject.toString());
                    this.a.a(jSONObject.toString());
                } catch (JSONException e) {
                    p.c("jd-socket", "sendRegisterRequest..");
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void c() {
        g();
        this.a = new ScheduledThreadPoolExecutor(this.d);
        this.a.scheduleAtFixedRate(this.b, 1, 50, TimeUnit.SECONDS);
    }

    public void d() {
        this.i.set(true);
    }

    public boolean e() {
        return this.h.get() && this.i.get();
    }

    private void a(String str) {
        try {
            if (this.m != null && str != null) {
                p.a("jd-socket", "sending normal");
                this.m.println(str);
                this.m.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            p.c("jd-socket", "send params exception");
        }
    }

    public static void f() {
        if (e != null) {
            e = null;
        }
    }

    private void j() {
        this.n = new b(this);
        this.n.start();
    }

    public void g() {
        if (!(this.a == null || this.a.isShutdown())) {
            this.a.shutdownNow();
            this.a = null;
        }
        this.h.set(false);
        this.i.set(false);
    }

    public boolean h() {
        return (this.k == null || !this.k.isConnected() || this.k.isOutputShutdown() || this.k.isClosed()) ? false : true;
    }

    public void i() {
        new Thread(new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.k();
                this.a.l();
                if (this.a.n != null) {
                    this.a.n.interrupt();
                }
                a.f();
            }
        }).start();
    }

    private void k() {
        try {
            if (this.k != null) {
                this.k.close();
                this.k = null;
            }
            if (this.l != null) {
                this.l.close();
                this.l = null;
            }
            if (this.m != null) {
                this.m.close();
                this.m = null;
            }
            if (this.g != null) {
                this.g = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void l() {
        if (this.a != null) {
            this.a.shutdown();
            this.a = null;
        }
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("code", str);
            jSONObject3.put("version", "1.0");
            jSONObject3.put("device_id", GlobalVariable.B().n());
            jSONObject3.put("plat", "Android");
            jSONObject3.put("os_version", GlobalVariable.B().o());
            jSONObject3.put("app", "xinxianGO");
            jSONObject3.put("app_version", GlobalVariable.B().m());
            jSONObject3.put("network", NetworkType.WIFI_STRING);
            int incrementAndGet = this.f.incrementAndGet();
            jSONObject3.put("seq", incrementAndGet);
            p.a("jd-socket", "seq: " + incrementAndGet);
            jSONObject2.put("header", jSONObject3);
            jSONObject2.put("body", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject2;
    }

    private JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sys_id", "114");
            jSONObject.put("tgt", com.jd.fridge.util.c.a.b().getA2());
            jSONObject.put("pin", GlobalVariable.I());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
