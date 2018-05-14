package cn.jpush.android.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.api.SdkType;
import cn.jpush.android.a;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.e;
import cn.jpush.android.service.PushReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TbsSdkJava */
public class g {
    private static volatile g d;
    private static final String[] z;
    private AtomicBoolean a = new AtomicBoolean(false);
    private byte b = (byte) 0;
    private e c;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 24;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "*\u000f^X\u0015\u00143G^\b\u001c\fYR\u000f3\r_Z\u000e\u001c\u0002HZ";
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
            case 0: goto L_0x0126;
            case 1: goto L_0x012a;
            case 2: goto L_0x012e;
            case 3: goto L_0x0132;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\r\u000bB\\\u0014Z3G^\b\u001c\u0011DRF";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "\u0019\fEK\u0019\u0002\u0017\u000bH\u001d\tCEJ\u0010\u0016";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u0019\u0002E\u001f\u0012\u0015\u0017\u000bY\u0015\u0014\u0007\u000bK\u0014\u001fC[S\t\u001d\nE\u001f\f\u0016\u0002_Y\u0013\b\u000e\u000b^\u001f\u000e\nDQ";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u000f\u0013GP\u001d\u001e1NX5>CYZ\u001b\u0013\u0007\u0011";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "Z\u0011NX\u0015\t\u0017NM\\\u001f\u0011YP\u000e@";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\n\u000f^X\u0015\u0014C[S\u001d\u000e\u0005DM\u0011Z\u0002HK\u0015\u0015\r\u000bH\u001d\tCEJ\u0010\u0016";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "Z\u0010_P\f*\u0016XW\\\u001f\u0011YP\u000e@";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "Z\u0011NL\t\u0017\u0006{J\u000f\u0012CNM\u000e\u0015\u0011\u0011";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\r\u000bB\\\u0014*\u000fJK\u001a\u0015\u0011F\u001fQZ";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u000f\u0013GP\u001d\u001e1NX5>";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "Z\u0016[S\u0013\u001b\u0007yZ\u001b3\u0007\u000bZ\u000e\b\fY\u0005";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\n\u000f^X\u0015\u00143G^\b\u001c\fYR.\u001f\u0004B[";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u001b\u0000_V\u0013\u0014";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\n\u000f^X\u0015\u0014M[S\u001d\u000e\u0005DM\u0011T\u0011NX\u0015\u001eC";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u001e\f\u000bQ\u0013\u000eCEZ\u0019\u001eCYZ\u001a\b\u0006XL\u0014Z\u0013GJ\u001b\u0013\r\u000bO\u0010\u001b\u0017MP\u000e\u0017CYZ\u001b\u0013\u0010_Z\u000e\u0013\u0007";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u000f\u0013GP\u001d\u001e1NX5>C\u0007\u001f\f\u0016\u0016LV\u0012*\u000fJK\u001a\u0015\u0011Fm\u0019\u001d*o\u0005";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\n\u000f^X\u0015\u0014M[S\u001d\u000e\u0005DM\u0011T\u0017RO\u0019";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\n\u000f^X\u0015\u00143G^\b\u001c\fYR.\u001f\u0004b{F";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "V\tBJ\u001b\u001b\rL|\u001d\u0019\u000bNm\u0019\u001d*o\u0005";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "03^L\u0014Z\u0007D\u001f\u0012\u0015\u0017\u000bM\u0019\u001d\nXK\u0019\b";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\u0019\r\u0005U\f\u000f\u0010C\u0011\u001d\u0014\u0007YP\u0015\u001eMBQ\b\u001f\r_\u0011\f\u0016\u0016LV\u0012T\u0013G^\b\u001c\fYRR(&mm9)0c`.?$b{";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\t\u0007@K\u0005\n\u0006";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\t\u0006_\u001f(\u001b\u0004X\u001f\u001a\u001b\nGZ\u0018@";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0126:
        r9 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        goto L_0x0020;
    L_0x012a:
        r9 = 99;
        goto L_0x0020;
    L_0x012e:
        r9 = 43;
        goto L_0x0020;
    L_0x0132:
        r9 = 63;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.g.<clinit>():void");
    }

    private g() {
    }

    public static g a() {
        if (d == null) {
            synchronized (g.class) {
                if (d == null) {
                    d = new g();
                }
            }
        }
        return d;
    }

    private void b(Context context, String str) {
        int i = 1;
        try {
            if (this.c == null) {
                e.h(z[0], z[6]);
            } else if (JCoreInterface.isValidRegistered()) {
                CharSequence string = MultiSpHelper.getString(context, new StringBuilder(z[12]).append(this.b).toString(), null);
                e.c(z[0], new StringBuilder(z[16]).append(str).append(z[19]).append(string).toString());
                if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(str) || !TextUtils.equals(str, string))) {
                    i = 0;
                }
                if (i != 0) {
                    e.c(z[0], new StringBuilder(z[18]).append(str).toString());
                    byte b = this.b;
                    Bundle bundle = new Bundle();
                    bundle.putString(z[13], z[21]);
                    bundle.putString(z[14], str);
                    bundle.putByte(z[17], b);
                    JCoreInterface.sendAction(context, a.a, bundle);
                    return;
                }
                e.c(z[0], z[15]);
            } else {
                e.h(z[0], z[20]);
            }
        } catch (Throwable th) {
            e.h(z[0], this.b + z[11] + th);
        }
    }

    private void g(Context context) {
        this.b = i.a(context);
        e.c(z[0], new StringBuilder(z[1]).append(this.b).toString());
        switch (this.b) {
            case (byte) 1:
                this.c = new j();
                return;
            case (byte) 2:
                this.c = new b(context);
                return;
            case (byte) 3:
                this.c = new d(context);
                return;
            default:
                return;
        }
    }

    private synchronized boolean h(Context context) {
        boolean z = false;
        synchronized (this) {
            if (context == null) {
                e.h(z[0], z[2]);
            } else {
                if (!this.a.get()) {
                    g(context);
                    this.a.set(true);
                }
                e.f(z[0], new StringBuilder(z[9]).append(this.b).toString());
                if (this.b != (byte) 0) {
                    if (this.c == null) {
                        g(context);
                    }
                    z = true;
                }
            }
        }
        return z;
    }

    public final void a(Context context) {
        if (context == null) {
            e.i(z[0], z[2]);
        } else if (h(context)) {
            try {
                if (this.c == null || JPushInterface.isPushStopped(context.getApplicationContext())) {
                    e.h(z[0], z[6]);
                } else {
                    this.c.a(context);
                }
            } catch (Throwable th) {
                e.h(z[0], this.b + z[5] + th);
            }
        } else {
            e.g(z[0], z[3]);
        }
    }

    public final void a(Context context, String str) {
        if (context == null) {
            e.i(z[0], z[2]);
            return;
        }
        e.c(z[0], new StringBuilder(z[4]).append(str).toString());
        if (h(context)) {
            b(context, str);
        } else {
            e.g(z[0], z[3]);
        }
    }

    public final void b(Context context) {
        if (context == null) {
            e.i(z[0], z[2]);
        } else if (h(context)) {
            try {
                if (this.c != null) {
                    this.c.b(context);
                } else {
                    e.h(z[0], z[6]);
                }
            } catch (Throwable th) {
                e.h(z[0], this.b + z[8] + th);
            }
        } else {
            e.g(z[0], z[3]);
        }
    }

    public final void c(Context context) {
        if (context == null) {
            e.i(z[0], z[2]);
        } else if (h(context)) {
            try {
                if (this.c != null) {
                    this.c.d(context);
                } else {
                    e.h(z[0], z[6]);
                }
            } catch (Throwable th) {
                e.h(z[0], this.b + z[7] + th);
            }
        } else {
            e.g(z[0], z[3]);
        }
    }

    public final void d(Context context) {
        if (context == null) {
            e.i(z[0], z[2]);
        } else if (h(context)) {
            try {
                Intent intent = new Intent(context, PushReceiver.class);
                intent.setAction(z[21]);
                Bundle bundle = new Bundle();
                bundle.putString(z[22], SdkType.JPUSH.name());
                intent.putExtras(bundle);
                context.sendBroadcast(intent);
            } catch (Throwable th) {
                e.i(z[0], new StringBuilder(z[23]).append(th).toString());
            }
        } else {
            e.g(z[0], z[3]);
        }
    }

    public final void e(Context context) {
        if (context == null) {
            e.i(z[0], z[2]);
            return;
        }
        e.c(z[0], z[10]);
        if (h(context)) {
            try {
                if (this.c == null) {
                    e.h(z[0], z[6]);
                    return;
                } else if (this.b == (byte) 2) {
                    this.c.c(context);
                    return;
                } else {
                    b(context, this.c.c(context));
                    return;
                }
            } catch (Throwable th) {
                e.h(z[0], this.b + z[11] + th);
                return;
            }
        }
        e.g(z[0], z[3]);
    }

    public final byte f(Context context) {
        h(context);
        return this.b;
    }
}
