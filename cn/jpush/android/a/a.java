package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.d.e;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.service.d;

/* compiled from: TbsSdkJava */
public class a {
    private static a a;
    private static final String[] z;
    private Handler b;

    /* compiled from: TbsSdkJava */
    private class a implements Runnable {
        private static final String[] z;
        final /* synthetic */ a a;
        private Context b;
        private JPushMessageReceiver c;
        private Intent d;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static {
            /*
            r0 = 9;
            r3 = new java.lang.String[r0];
            r2 = 0;
            r1 = "ztV\u0007\u0015ptq\r\u0004r+";
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
                case 0: goto L_0x0082;
                case 1: goto L_0x0085;
                case 2: goto L_0x0088;
                case 3: goto L_0x008b;
                default: goto L_0x001e;
            };
        L_0x001e:
            r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
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
                default: goto L_0x003c;
            };
        L_0x003c:
            r3[r2] = r1;
            r2 = 1;
            r1 = "bV\u0001\u0004g~W\u0000TvrQ\u001d\u001by1Q\r\u0004r";
            r0 = 0;
            r3 = r4;
            goto L_0x0009;
        L_0x0044:
            r3[r2] = r1;
            r2 = 2;
            r1 = "bV\u0001\u0004g~W\u0000TztV\u0007\u0015pt\u0005\u0000\rgt";
            r0 = 1;
            r3 = r4;
            goto L_0x0009;
        L_0x004c:
            r3[r2] = r1;
            r2 = 3;
            r1 = "ztV\u0007\u0015ptz\u0000\rgt";
            r0 = 2;
            r3 = r4;
            goto L_0x0009;
        L_0x0054:
            r3[r2] = r1;
            r2 = 4;
            r1 = ";{u\u0001\u0007\\@\u0007\u0007vv@N";
            r0 = 3;
            r3 = r4;
            goto L_0x0009;
        L_0x005c:
            r3[r2] = r1;
            r2 = 5;
            r1 = "~Q\u0011\u001ac1R\u0015\u00077P\u0018\u0018";
            r0 = 4;
            r3 = r4;
            goto L_0x0009;
        L_0x0064:
            r3[r2] = r1;
            r2 = 6;
            r1 = "]\\@\u0007\u0007vv@&\u0011ttL\u0002\u0011eY@\u0018\u0004rc";
            r0 = 5;
            r3 = r4;
            goto L_0x0009;
        L_0x006c:
            r3[r2] = r1;
            r2 = 7;
            r1 = "gpW\u0007\u00117eD\u0013\u0015{xD\u0007TztV\u0007\u0015pt\u0005\u0012\u0015~}@\u0010";
            r0 = 6;
            r3 = r4;
            goto L_0x0009;
        L_0x0074:
            r3[r2] = r1;
            r2 = 8;
            r1 = "t\u000b\u001e\u0004bbMZ\u0015yuW\u001b\u001ds?L\u001a\u0000rQZ&RR`=\"RNh1'DPb1";
            r0 = 7;
            r3 = r4;
            goto L_0x0009;
        L_0x007d:
            r3[r2] = r1;
            z = r4;
            return;
        L_0x0082:
            r9 = 23;
            goto L_0x0020;
        L_0x0085:
            r9 = 17;
            goto L_0x0020;
        L_0x0088:
            r9 = 37;
            goto L_0x0020;
        L_0x008b:
            r9 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
            goto L_0x0020;
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.a.a.<clinit>():void");
        }

        public a(a aVar, Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
            this.a = aVar;
            this.b = context;
            this.c = jPushMessageReceiver;
            this.d = intent;
        }

        public final void run() {
            if (this.d == null) {
                e.g(z[6], z[5]);
                return;
            }
            if (z[8].equals(this.d.getAction())) {
                int intExtra = this.d.getIntExtra(z[3], -1);
                JPushMessage a = d.a().a(this.d);
                e.c(z[6], new StringBuilder(z[0]).append(intExtra).append(z[4]).append(a).toString());
                if (a == null) {
                    e.g(z[6], z[7]);
                    return;
                } else if (intExtra == 1) {
                    if (a.isTagCheckOperator()) {
                        this.c.onCheckTagOperatorResult(this.b, a);
                        return;
                    } else {
                        this.c.onTagOperatorResult(this.b, a);
                        return;
                    }
                } else if (intExtra == 2) {
                    this.c.onAliasOperatorResult(this.b, a);
                    return;
                } else {
                    e.g(z[6], z[2]);
                    return;
                }
            }
            e.g(z[6], z[1]);
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = 1;
        r1 = 0;
        r0 = 3;
        r4 = new java.lang.String[r0];
        r3 = "yqpM0R[pl&PY|H&AtpR3VN";
        r0 = -1;
        r5 = r4;
        r6 = r4;
        r4 = r1;
    L_0x000b:
        r3 = r3.toCharArray();
        r7 = r3.length;
        if (r7 > r2) goto L_0x0061;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r3;
        r10 = r8;
        r13 = r7;
        r7 = r3;
        r3 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x0055;
            case 1: goto L_0x0058;
            case 2: goto L_0x005b;
            case 3: goto L_0x005e;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 67;
    L_0x0021:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r3 != 0) goto L_0x002d;
    L_0x0029:
        r7 = r9;
        r10 = r8;
        r8 = r3;
        goto L_0x0018;
    L_0x002d:
        r7 = r3;
        r3 = r9;
    L_0x002f:
        if (r7 > r8) goto L_0x0013;
    L_0x0031:
        r7 = new java.lang.String;
        r7.<init>(r3);
        r3 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0046;
            case 1: goto L_0x0050;
            default: goto L_0x003d;
        };
    L_0x003d:
        r5[r4] = r3;
        r0 = "PNp_7V\u001c}_-WPpLcU]|R&W\u0010pL1\\N/";
        r3 = r0;
        r4 = r2;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r4] = r3;
        r3 = 2;
        r0 = "~YfM\"TYG[ VUc[1";
        r4 = r3;
        r5 = r6;
        r3 = r0;
        r0 = r2;
        goto L_0x000b;
    L_0x0050:
        r5[r4] = r3;
        z = r6;
        return;
    L_0x0055:
        r11 = 51;
        goto L_0x0021;
    L_0x0058:
        r11 = 60;
        goto L_0x0021;
    L_0x005b:
        r11 = 21;
        goto L_0x0021;
    L_0x005e:
        r11 = 62;
        goto L_0x0021;
    L_0x0061:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.a.<clinit>():void");
    }

    private a() {
        try {
            HandlerThread handlerThread = new HandlerThread(z[2]);
            handlerThread.start();
            this.b = new Handler(handlerThread.getLooper());
        } catch (Throwable th) {
            e.g(z[0], new StringBuilder(z[1]).append(th).toString());
            this.b = new Handler();
        }
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public final void a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        this.b.post(new a(this, context, jPushMessageReceiver, intent));
    }
}
