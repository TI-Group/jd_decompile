package com.jd.fridge.util.socket;

import android.content.res.Resources.NotFoundException;
import com.jd.fridge.util.p;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* compiled from: TbsSdkJava */
public class b {
    private static b b;
    private static AtomicInteger h = new AtomicInteger();
    Runnable a = new Runnable(this) {
        final /* synthetic */ b a;

        {
            this.a = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r6 = this;
            r0 = "jd-socket";
            r1 = "init:  StartConnectSSL---";
            com.jd.fridge.util.p.a(r0, r1);
            r0 = r6.a;
            r0 = r0.c;
            if (r0 != 0) goto L_0x0010;
        L_0x000f:
            return;
        L_0x0010:
            r0 = r6.a;
            r0 = r0.d();
            if (r0 == 0) goto L_0x0024;
        L_0x0018:
            r0 = "jd-socket";
            r1 = "disconnectSocket";
            com.jd.fridge.util.p.a(r0, r1);
            r0 = r6.a;
            r0.g();
        L_0x0024:
            r0 = r6.a;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r1 = "smart-applive.jd.com";
            r0 = r0.a(r1);	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r1 = new java.net.Socket;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
            r1.<init>(r0, r2);	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r2 = r6.a;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r3 = r6.a;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r3 = r3.c;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
            r5 = 0;
            r0 = r3.createSocket(r1, r0, r4, r5);	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r0 = (javax.net.ssl.SSLSocket) r0;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r2.d = r0;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r0 = r6.a;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r0 = r0.d;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r1 = 1;
            r0.setKeepAlive(r1);	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r0 = r6.a;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r0 = r0.d;	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r0.startHandshake();	 Catch:{ UnknownHostException -> 0x008d, IOException -> 0x00cd }
            r0 = r6.a;
            r0 = r0.g;
            if (r0 != 0) goto L_0x0069;
        L_0x0062:
            r0 = "LeakLog";
            r1 = "GC: connectHelper listener";
            com.jd.fridge.util.p.a(r0, r1);
        L_0x0069:
            r0 = r6.a;
            r0 = r0.d();
            if (r0 == 0) goto L_0x0083;
        L_0x0071:
            r0 = r6.a;
            r0 = r0.g;
            if (r0 == 0) goto L_0x0083;
        L_0x0079:
            r0 = r6.a;
            r0 = r0.g;
            r0.b();
            goto L_0x000f;
        L_0x0083:
            r0 = r6.a;
            r0 = r0.g;
            r0.c();
            goto L_0x000f;
        L_0x008d:
            r0 = move-exception;
            r0.printStackTrace();	 Catch:{ all -> 0x010d }
            r0 = "jd-socket";
            r1 = "UnknownHostException e";
            com.jd.fridge.util.p.c(r0, r1);	 Catch:{ all -> 0x010d }
            r0 = r6.a;
            r0 = r0.g;
            if (r0 != 0) goto L_0x00a7;
        L_0x00a0:
            r0 = "LeakLog";
            r1 = "GC: connectHelper listener";
            com.jd.fridge.util.p.a(r0, r1);
        L_0x00a7:
            r0 = r6.a;
            r0 = r0.d();
            if (r0 == 0) goto L_0x00c2;
        L_0x00af:
            r0 = r6.a;
            r0 = r0.g;
            if (r0 == 0) goto L_0x00c2;
        L_0x00b7:
            r0 = r6.a;
            r0 = r0.g;
            r0.b();
            goto L_0x000f;
        L_0x00c2:
            r0 = r6.a;
            r0 = r0.g;
            r0.c();
            goto L_0x000f;
        L_0x00cd:
            r0 = move-exception;
            r0.printStackTrace();	 Catch:{ all -> 0x010d }
            r0 = "jd-socket";
            r1 = "IOException e";
            com.jd.fridge.util.p.c(r0, r1);	 Catch:{ all -> 0x010d }
            r0 = r6.a;
            r0 = r0.g;
            if (r0 != 0) goto L_0x00e7;
        L_0x00e0:
            r0 = "LeakLog";
            r1 = "GC: connectHelper listener";
            com.jd.fridge.util.p.a(r0, r1);
        L_0x00e7:
            r0 = r6.a;
            r0 = r0.d();
            if (r0 == 0) goto L_0x0102;
        L_0x00ef:
            r0 = r6.a;
            r0 = r0.g;
            if (r0 == 0) goto L_0x0102;
        L_0x00f7:
            r0 = r6.a;
            r0 = r0.g;
            r0.b();
            goto L_0x000f;
        L_0x0102:
            r0 = r6.a;
            r0 = r0.g;
            r0.c();
            goto L_0x000f;
        L_0x010d:
            r0 = move-exception;
            r1 = r6.a;
            r1 = r1.g;
            if (r1 != 0) goto L_0x011d;
        L_0x0116:
            r1 = "LeakLog";
            r2 = "GC: connectHelper listener";
            com.jd.fridge.util.p.a(r1, r2);
        L_0x011d:
            r1 = r6.a;
            r1 = r1.d();
            if (r1 == 0) goto L_0x0137;
        L_0x0125:
            r1 = r6.a;
            r1 = r1.g;
            if (r1 == 0) goto L_0x0137;
        L_0x012d:
            r1 = r6.a;
            r1 = r1.g;
            r1.b();
        L_0x0136:
            throw r0;
        L_0x0137:
            r1 = r6.a;
            r1 = r1.g;
            r1.c();
            goto L_0x0136;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.fridge.util.socket.b.1.run():void");
        }
    };
    private SSLSocketFactory c;
    private SSLSocket d;
    private PrintWriter e;
    private BufferedReader f;
    private a g;

    /* compiled from: TbsSdkJava */
    public interface a {
        void b();

        void c();
    }

    private b(a aVar) {
        if (aVar != null) {
            this.g = aVar;
        }
    }

    public static b a(a aVar) {
        if (b == null) {
            synchronized (b.class) {
                b = new b(aVar);
            }
        }
        return b;
    }

    public static void a() {
        if (b != null) {
            b = null;
        }
    }

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                b = new b(null);
            }
        }
        return b;
    }

    public void c() {
        if (this.c == null) {
            h();
        }
        new Thread(this.a).start();
    }

    public boolean d() {
        if (this.d == null || !this.d.isConnected() || this.d.isClosed()) {
            return false;
        }
        return true;
    }

    public SSLSocket e() {
        return this.d;
    }

    private void g() {
        try {
            if (this.d != null) {
                this.d.close();
            }
            if (this.f != null) {
                this.f.close();
            }
            if (this.e != null) {
                this.e.close();
            }
            this.d = null;
            this.f = null;
            this.e = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void f() {
        new Thread(new Runnable(this) {
            final /* synthetic */ b a;

            {
                this.a = r1;
            }

            public void run() {
                this.a.g();
            }
        }).start();
        if (this.g != null) {
            this.g = null;
        }
        a();
    }

    private void h() {
        try {
            TrustManager[] trustManagerArr = new TrustManager[]{new c()};
            SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, trustManagerArr, new SecureRandom());
            this.c = instance.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NotFoundException e2) {
            e2.printStackTrace();
        } catch (KeyManagementException e3) {
            e3.printStackTrace();
        }
    }

    private String a(String str) {
        String str2 = str.replace("[", "").replace("]", "").replace("\"", "").split(":")[0];
        String str3 = null;
        try {
            str3 = InetAddress.getByName(str2).getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        p.a("jd-socket", "init:  url:" + str2 + "  ip:" + str3);
        return str3;
    }
}
