package cn.jiguang.b.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.b.a.a;
import cn.jiguang.b.d.c;
import cn.jiguang.b.d.h;
import cn.jiguang.b.d.o;
import cn.jiguang.b.f.b;
import cn.jiguang.c.d;
import cn.jiguang.service.Protocol;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class g implements Runnable {
    public static AtomicLong a = new AtomicLong(0);
    public static AtomicBoolean b = new AtomicBoolean(false);
    private static final String[] z;
    private Context c;
    private Handler d;
    private volatile boolean e = false;
    private boolean f;
    private ExecutorService g;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 31;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "O\u000eCv\u000es\u0000^o\u0006B\u0007^d\u000fu";
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
            case 0: goto L_0x0184;
            case 1: goto L_0x0187;
            case 2: goto L_0x018b;
            case 3: goto L_0x018f;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 97;
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
            case 15: goto L_0x00d4;
            case 16: goto L_0x00df;
            case 17: goto L_0x00ea;
            case 18: goto L_0x00f5;
            case 19: goto L_0x0100;
            case 20: goto L_0x010b;
            case 21: goto L_0x0116;
            case 22: goto L_0x0121;
            case 23: goto L_0x012c;
            case 24: goto L_0x0137;
            case 25: goto L_0x0142;
            case 26: goto L_0x014d;
            case 27: goto L_0x0158;
            case 28: goto L_0x0163;
            case 29: goto L_0x016e;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "S\u000eCt\u0013oKXgAB\u0007Xr\u0004!\u0001YhAb\u0004Yo\u0004b\u001f^n\u000f!F\u0017";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "T\u0005Ry\u0011d\bCd\u0005!F\u0017O\u000e!\bXo\u000fd\bCh\u000eoKCnAb\u0007Xr\u0004/K";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "B\u0007Xr\u0004!\bXo\u000fd\bCh\u000eoKRs\u0013n\u0019";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "@\bCh\u000eoK\u001a!\u0002m\u0004Dd\"n\u0005Yd\u0002u\u0002XoA,KTn\u000fo\u000eTu\bn\u0005\r";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "S\u000ePh\u0012u\u000e\u0017g\u0000h\u0007ReM!\u0018Cn\u0011!\u001f_dAr\u000eEw\bb\u000e\u0016";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "m\u0004Ph\u000fU\u0002Zd\u0012;";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "l(Xo\u000fd\bCh\u000eoK^rAs\u000eDd\u0015!\u001fX!Q!\u001c_d\u000f!\u0018C`\u0015dKUd\u0015v\u000eRoAm\u0004Ph\u000f!\nYeAn\u0005{n\u0006f\u000eSN\u000f/Kry\buKSh\u0013d\bCm\u0018/";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "o\u000eReAo\u0004C!\nd\u000eG!\u0015b\u001b\u0017b\u000eo\u0005Rb\u0015-\u001c^m\r!\b[n\u0012dKTn\u000fo\u000eTu\bn\u0005";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "@\bCh\u000eoK\u001a!\u000eo'Xf\u0006d\u000f~oA,KTn\u000fo\u000eTu\bn\u0005\r";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "m\u0004Ph\u000f!\u000eEs\u000esGEd\u0015s\u0012\u0017m\u000ef\u0002Y!\u0015n\u0004\u0017l\u0000o\u0012\u0017u\bl\u000eD";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "@\bCh\u000eoK\u001a!\u000eo'Xf\bo-Vh\rd\u000f\u0017,As\u000eDq\"n\u000fR;";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "S\u000ePh\u0012u\u000e\u0017g\u0000h\u0007ReM!\b[n\u0012dKCi\u0004!\bXo\u000fd\bCh\u000eoJ";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "@\bCh\u000eoK\u001a!\u0015s\u0012du\u000eqK\u001a!\u0002n\u0005Yd\u0002u\u0002Xo[";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "-KGj\u0006;";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "-KTn\u000fo\u000eTu\bn\u0005\r";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "O\u000eCv\u000es\u0000\u0017m\br\u001fRo\bo\f\u0019/O";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "S\u000eTd\bw\u000eS!\u0003x\u001fRrA,K[d\u000f;";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "R\u0002DH\u000fg\u0004";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "t\u0005Ry\u0011d\bCd\u0005 Kgt\u0012i;En\u0015n\bXmOR\u001fXq";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "C\u0019R`\n!\u0019Rb\u0004h\u001d^o\u0006!\tN!\u0016`\u0005CR\u0015n\u001b\u0017,Ab\u0004Yo\u0004b\u001f^n\u000f;";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "G\n^m\u0004eKCnAq\nEr\u0004!\u0002GrL3K\u001a!\u0005d\rVt\ruK^qO";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "B\u0019R`\u0015d\u000f\u0017b\u000eo\u0005Rb\u0015h\u0004Y!L!";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "N\u0005[xAl\n^oAh\u001b\u0017h\u000f!\u0018^rO";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "l(Xo\u000fd\bCh\u000eoK^rAs\u000eDd\u0015!\u001fX!Q!\u001c_d\u000f!\u0005Ru\u0016n\u0019\\!\rh\u0018Cd\u000fh\u0005P/AC\u0019R`\n!\u0005XvO";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "C\u000ePh\u000f!\u001fX!\u0013t\u0005\u0017h\u000f!(Xo\u000fd\bCh\u000ff?_s\u0004`\u000f\u0017,Ah\u000f\r";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "O\u0004\u0017s\u0004q\u0004EuAc\nTj\u0014qK^qO";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "U\u0002Zd\u000et\u001f\u0017h\u000f!!yHO!/X!\u000fn\u001f\u0017c\u0013d\n\\/";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "镾辵排夰资-K]q\u0014r\u0003\u0019r\u000e务輖張帹";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "D\u0013Td\u0011u\u0002XoAs\u000eTd\bw\u000eS/AO\u0004@!\u0003s\u000eVjA,KEd\u0015;";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "d\u0013Rb\u0014u\u000e\u0017o\u0004u\u001cXs\nh\u0005PB\rh\u000eYuAd\u0013Td\u0011u\u0002XoA;";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        z = r4;
        r0 = new java.util.concurrent.atomic.AtomicLong;
        r2 = 0;
        r0.<init>(r2);
        a = r0;
        r0 = new java.util.concurrent.atomic.AtomicBoolean;
        r1 = 0;
        r0.<init>(r1);
        b = r0;
        return;
    L_0x0184:
        r9 = 1;
        goto L_0x0020;
    L_0x0187:
        r9 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        goto L_0x0020;
    L_0x018b:
        r9 = 55;
        goto L_0x0020;
    L_0x018f:
        r9 = 1;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.b.g.<clinit>():void");
    }

    public g(Context context, Handler handler) {
        this.c = context;
        this.d = handler;
        this.f = true;
    }

    private boolean a(int i) {
        while (!this.e) {
            if (i <= 0) {
                d.d(z[0], z[10]);
                return false;
            }
            boolean z;
            int b;
            d.c(z[0], new StringBuilder(z[6]).append(i).toString());
            if (!cn.jiguang.b.a.d.f(this.c) || TextUtils.isEmpty(cn.jiguang.b.a.d.g(this.c))) {
                if (!c.a(this.c, a.get())) {
                    if (a.k()) {
                        d.a(z[0], z[5]);
                        this.d.sendEmptyMessageDelayed(1001, 100);
                    } else {
                        d.a(z[0], z[12]);
                    }
                    f();
                    z = false;
                    if (z) {
                        return false;
                    }
                    b = c.b(this.c, a.get());
                    if (b >= 0) {
                        return false;
                    }
                    if (b > 0) {
                        long j = a.get();
                        d.a(z[0], new StringBuilder(z[11]).append(b).toString());
                        c.a(Message.obtain(this.d, 7306), j);
                        if (b == 108) {
                            cn.jiguang.e.a.m(this.c);
                            i--;
                        } else if (b == 102) {
                            return false;
                        } else {
                            a.j();
                            this.d.sendEmptyMessageDelayed(1003, 100);
                            return false;
                        }
                    } else if (0 == a.get()) {
                        long j2 = a.get();
                        d.b(z[0], new StringBuilder(z[9]).append(j2).toString());
                        c.a(Message.obtain(this.d, 7304), j2);
                        if (!h.a().b(this.c)) {
                            return true;
                        }
                        d.d(z[0], z[8]);
                        return false;
                    } else {
                        d.g(z[0], z[7]);
                        return false;
                    }
                } else if (c.a()) {
                    c.b();
                    this.d.sendEmptyMessageDelayed(1031, 100);
                }
            }
            z = true;
            if (z) {
                return false;
            }
            b = c.b(this.c, a.get());
            if (b >= 0) {
                return false;
            }
            if (b > 0) {
                long j3 = a.get();
                d.a(z[0], new StringBuilder(z[11]).append(b).toString());
                c.a(Message.obtain(this.d, 7306), j3);
                if (b == 108) {
                    cn.jiguang.e.a.m(this.c);
                    i--;
                } else if (b == 102) {
                    return false;
                } else {
                    a.j();
                    this.d.sendEmptyMessageDelayed(1003, 100);
                    return false;
                }
            } else if (0 == a.get()) {
                d.g(z[0], z[7]);
                return false;
            } else {
                long j22 = a.get();
                d.b(z[0], new StringBuilder(z[9]).append(j22).toString());
                c.a(Message.obtain(this.d, 7304), j22);
                if (!h.a().b(this.c)) {
                    return true;
                }
                d.d(z[0], z[8]);
                return false;
            }
        }
        return false;
    }

    private void f() {
        d.d(z[0], new StringBuilder(z[4]).append(a.get()).toString());
        if (0 != a.get()) {
            try {
                b.set(true);
                a.set((long) Protocol.Close(a.get()));
                d.d(z[0], new StringBuilder(z[1]).append(a.get()).toString());
                b.set(false);
            } catch (Throwable e) {
                d.c(z[0], z[3], e);
            }
            this.f = false;
            if (h.a().g()) {
                c.a(Message.obtain(this.d, 7301), a.get());
                return;
            }
            return;
        }
        d.c(z[0], z[2]);
    }

    public final void a() {
        d.d(z[0], new StringBuilder(z[13]).append(a.get()).toString());
        this.e = true;
        this.f = false;
        if (a.get() != 0) {
            Protocol.Stop(a.get());
        }
    }

    public final synchronized void b() {
        if (this.f) {
            this.g = Executors.newSingleThreadExecutor();
            try {
                this.g.execute(this);
            } catch (RejectedExecutionException e) {
                d.h(z[0], new StringBuilder(z[30]).append(e).toString());
                a();
            }
        }
    }

    public final synchronized void c() {
        a();
        cn.jiguang.b.f.d.a();
        cn.jiguang.b.f.d.a(this.g);
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.f;
    }

    public final void run() {
        d.f(z[0], new StringBuilder(z[25]).append(Thread.currentThread().getId()).toString());
        b.e().a(this.c);
        try {
            a.set(Protocol.InitConn());
            d.c(z[0], new StringBuilder(z[22]).append(a.get()).toString());
            j a = c.a(this.c);
            if (a != null) {
                int size = a.a.size();
                if (size != 0) {
                    a.c(a.h);
                    if (size > 1) {
                        try {
                            k kVar = new k((String) a.a.get(1));
                            a.b(kVar.a, kVar.b);
                        } catch (Throwable e) {
                            d.d(z[18], z[21], e);
                        }
                    } else {
                        d.h(z[18], z[23]);
                    }
                    if (size > 2) {
                        o.a((String) a.a.get(2));
                        cn.jiguang.b.a.d.a((String) a.a.get(2));
                    } else {
                        d.h(z[18], z[26]);
                    }
                    if (a.c != null) {
                        a.b(a.c);
                    }
                }
            }
            if (this.e) {
                d.g(z[0], z[19]);
                f();
            } else if (!c.a(this, a.get(), a)) {
                f();
            } else if (a(2)) {
                Object obj = new byte[8192];
                while (!this.e) {
                    d.d(z[0], z[16]);
                    int RecvPush = Protocol.RecvPush(a.get(), obj, 86400);
                    d.d(z[0], new StringBuilder(z[17]).append(RecvPush).append(z[15]).append(a.get()).append(z[14]).append(cn.jiguang.b.a.c).toString());
                    if (0 != a.get()) {
                        if (RecvPush <= 0) {
                            if (RecvPush != -994) {
                                d.d(z[0], new StringBuilder(z[29]).append(RecvPush).toString());
                                break;
                            }
                            d.c(z[0], z[27]);
                        } else {
                            byte[] bArr = new byte[RecvPush];
                            System.arraycopy(obj, 0, bArr, 0, RecvPush);
                            cn.jiguang.b.e.a.a.a.a(this.c, bArr);
                        }
                    } else {
                        d.h(z[0], z[24]);
                        return;
                    }
                }
                if (this.e) {
                    d.d(z[0], new StringBuilder(z[20]).append(a.get()).toString());
                }
                f();
            } else {
                f();
            }
        } catch (Throwable e2) {
            d.f(z[0], z[28], e2);
        }
    }
}
