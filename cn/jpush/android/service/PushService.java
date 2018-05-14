package cn.jpush.android.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import cn.jiguang.android.b;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.b.b.e;
import cn.jiguang.b.b.g;
import cn.jiguang.c.d;
import cn.jiguang.e.a.a;
import cn.jiguang.e.m;
import cn.jiguang.e.n;

public class PushService extends Service {
    private static final String[] z;
    private b a = null;
    private long b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 16;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "t}hRRzgN\b\u001e";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002e;
    L_0x0012:
        r7 = r1;
        r8 = r6;
        r11 = r5;
        r5 = r1;
        r1 = r11;
    L_0x0017:
        r10 = r5[r6];
        r9 = r8 % 5;
        switch(r9) {
            case 0: goto L_0x00ce;
            case 1: goto L_0x00d2;
            case 2: goto L_0x00d6;
            case 3: goto L_0x00da;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 55;
    L_0x0020:
        r9 = r9 ^ r10;
        r9 = (char) r9;
        r5[r6] = r9;
        r6 = r8 + 1;
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r5 = r7;
        r8 = r6;
        r6 = r1;
        goto L_0x0017;
    L_0x002c:
        r5 = r1;
        r1 = r7;
    L_0x002e:
        if (r5 > r6) goto L_0x0012;
    L_0x0030:
        r5 = new java.lang.String;
        r5.<init>(r1);
        r1 = r5.intern();
        switch(r0) {
            case 0: goto L_0x0044;
            case 1: goto L_0x004c;
            case 2: goto L_0x0054;
            case 3: goto L_0x005c;
            case 4: goto L_0x0064;
            case 5: goto L_0x006c;
            case 6: goto L_0x0074;
            case 7: goto L_0x007d;
            case 8: goto L_0x0087;
            case 9: goto L_0x0092;
            case 10: goto L_0x009d;
            case 11: goto L_0x00a8;
            case 12: goto L_0x00b3;
            case 13: goto L_0x00be;
            case 14: goto L_0x00c9;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "KfXHd~a]IT~";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "KfXHd~a]IT~3DNtivJTR";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "t}hRRzgN\u001a}X|YE~ugNRQzpN\u0000^uz_\u0000QzzGES";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "]rBL\u0017o|\u000bSCza_\u0000Xo{NR\u0017zc[\u0000TzfXES;qR\u0000xngdFz~~DRN5";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "HvYV^xv\u000bMVr}\u000bT_ivJD\u001763_HE~rOiS!";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "t}oEDoaDY\u001763[RXxvXS~)";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "KfXHd~a]IT~3DNdorYTtt~FAY3NREta\u0011";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "t}xTVighOZvrED\u001763BNC~}_\u001a";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "|v_\u0000^ugNNC;vSTEz`\u000bFVrND\u001b;vYRXi)";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "HvYV^xv\u000bBBuwGE\u001763";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "t}xTVighOZvrED\rQPDRRR}_EE}rHE\u0017r}BT\u0017}rBLR";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "73HOYuvHT^t}\u0011";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "73[KP!";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "zp_IXu3\u0006\u0000XuFEb^uw";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "zp_IXu3\u0006\u0000XuQBNS";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00ce:
        r9 = 27;
        goto L_0x0020;
    L_0x00d2:
        r9 = 19;
        goto L_0x0020;
    L_0x00d6:
        r9 = 43;
        goto L_0x0020;
    L_0x00da:
        r9 = 32;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.PushService.<clinit>():void");
    }

    public IBinder onBind(Intent intent) {
        d.c(z[1], z[15]);
        cn.jiguang.b.b.b.a(this);
        return this.a;
    }

    public void onCreate() {
        d.e(z[1], z[0]);
        d.a(z[1], new StringBuilder(z[5]).append(Thread.currentThread().getId()).toString());
        m mVar = new m();
        if (JCoreInterface.init(this, false)) {
            cn.jiguang.b.b.b.a(this);
            this.b = Thread.currentThread().getId();
            this.a = new a();
            cn.jiguang.e.a.l(getApplicationContext());
            e.a().a((Context) this);
            e.a().a((Service) this);
            try {
                n.a(getApplicationContext(), 0);
            } catch (OutOfMemoryError e) {
                d.g(z[1], z[4]);
            }
            mVar.a(z[1], z[2]);
            super.onCreate();
            return;
        }
        d.h(z[1], z[3]);
    }

    public void onDestroy() {
        super.onDestroy();
        d.c(z[1], new StringBuilder(z[6]).append(Process.myPid()).toString());
        e a = e.a();
        getApplicationContext();
        a.c();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        String action;
        Object th;
        Bundle bundle = null;
        d.d(z[1], new StringBuilder(z[8]).append(intent).append(z[13]).append(cn.jiguang.b.a.c).append(z[12]).append(g.a.get()).toString());
        cn.jiguang.b.b.b.a(this);
        if (JCoreInterface.init(this, false)) {
            if (intent != null) {
                try {
                    action = intent.getAction();
                    try {
                        bundle = intent.getExtras();
                    } catch (Throwable th2) {
                        th = th2;
                        d.i(z[1], new StringBuilder(z[9]).append(th).toString());
                        if (bundle != null) {
                            try {
                                d.a(z[1], new StringBuilder(z[10]).append(bundle.toString()).toString());
                            } catch (Throwable th3) {
                                d.h(z[1], new StringBuilder(z[7]).append(th3.getMessage()).toString());
                            }
                        }
                        cn.jiguang.b.d.m.a().a((Context) this, action, bundle);
                        return 1;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    action = bundle;
                    d.i(z[1], new StringBuilder(z[9]).append(th).toString());
                    if (bundle != null) {
                        d.a(z[1], new StringBuilder(z[10]).append(bundle.toString()).toString());
                    }
                    cn.jiguang.b.d.m.a().a((Context) this, action, bundle);
                    return 1;
                }
            }
            Object obj = bundle;
            if (bundle != null) {
                d.a(z[1], new StringBuilder(z[10]).append(bundle.toString()).toString());
            }
            if (!(action == null || bundle == null)) {
                cn.jiguang.b.d.m.a().a((Context) this, action, bundle);
            }
        } else {
            d.h(z[1], z[11]);
        }
        return 1;
    }

    public boolean onUnbind(Intent intent) {
        d.i(z[1], z[14]);
        return super.onUnbind(intent);
    }
}
