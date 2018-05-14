package cn.jiguang.b.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.b.b.b;
import cn.jiguang.b.b.e;
import cn.jiguang.b.b.g;
import cn.jiguang.c.d;
import cn.jiguang.e.a;
import cn.jiguang.service.Protocol;
import cn.jpush.android.service.PushService;

public final class m {
    private static final Object c = new Object();
    private static volatile m d;
    private static final String[] z;
    private boolean a;
    private Context b;
    private boolean e;
    private boolean f;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 23;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "P\u0007,O\u001bF\u001aj\u000b\n]\rpJ\u0002WGkK\u001fV\u0007v\u000b9g*";
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
            case 0: goto L_0x0122;
            case 1: goto L_0x0126;
            case 2: goto L_0x012a;
            case 3: goto L_0x012d;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "G\u0000o@\u0004F\u001d";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "f\u0007jD\u0005W\u0005gAK@\fpS\u0002P\f\"D\bG\u0000mKK\u001eI";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "@\riQ\u0012C\f";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0013\u000bwK\u000f_\f8";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "P\u0004f";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "P\u0007,O\u001bF\u001aj\u000b\n]\rpJ\u0002WGkK\u001fV\u0007v\u000b8g&Ru>`!";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "P\u0007,O\u001bF\u001aj\u000b\n]\rpJ\u0002WGkK\u001fV\u0007v\u000b(|'L`(g Tl?j6Am*}.G";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "@\flA\u000fR\u001dc\u000b\nP\u001dkJ\u0005";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "y:gW\u001dZ\ngf\u0004^\u0004cK\u000f{\fnU\u000eA";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "P\u0007,O\u001bF\u001aj\u000b\n]\rpJ\u0002WGkK\u001fV\u0007v\u000b9v:Vj9v9Wv#";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "P\u0007,O\u001bF\u001aj\u000b\n]\rpJ\u0002WGkK\u001fV\u0007v\u000b\"} V";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "W\bvD\u0018";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "@\flA\u0019V\u0018w@\u0018G\rcQ\n\u001d\baQ\u0002\\\u0007";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "A\u001cl\u000b\nP\u001dkJ\u0005";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "r\nvL\u0004]I/\u0005\u0003R\u0007fI\u000er\nvL\u0004]S";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "]\u001cnI";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "P\bnI*P\u001dkJ\u0005\u0013\baQ\u0002\\\u00078";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "G\u0001pJ\u001cR\u000bn@K\u001f\ncK\u001f\u0013\u001avD\u0019GIq@\u0019E\u0000a@";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "F\u0007g]\bV\u0019vL\u0004]I.F\n]\u001d\"V\u001fR\u001bv\u0005\u0018V\u001btL\bV";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\\\u0007RP\u0018[(aQ\u0002\\\u0007\"F\u0004]\u001dg]\u001f\u0013\u0000q\u0005\u0005F\u0005n";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\\\u0007CF\u001fZ\u0006l\u0005\nP\u001dkJ\u0005\t";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0013\ncI\u0007z\u0007v@\u0019U\ba@KY\nmW\u000e\u0013\u0000lL\u001f\u0013\u000fcL\u0007V\r";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        z = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        c = r0;
        return;
    L_0x0122:
        r9 = 51;
        goto L_0x0020;
    L_0x0126:
        r9 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        goto L_0x0020;
    L_0x012a:
        r9 = 2;
        goto L_0x0020;
    L_0x012d:
        r9 = 37;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.d.m.<clinit>():void");
    }

    public static m a() {
        if (d == null) {
            synchronized (c) {
                if (d == null) {
                    d = new m();
                }
            }
        }
        return d;
    }

    private void a(Context context) {
        if (!this.a) {
            this.b = context.getApplicationContext();
            this.e = a.p(context);
            if (!this.e) {
                b.a = 0;
            }
            String b = b.b(this.b);
            String packageName = this.b.getPackageName();
            if (b == null || packageName == null || !this.b.getPackageName().equals(b)) {
                this.f = false;
            } else {
                this.f = true;
            }
            this.a = true;
        }
    }

    static /* synthetic */ void a(m mVar, String str, Bundle bundle) {
        d.c(z[9], new StringBuilder(z[15]).append(str).append(z[4]).append(bundle).toString());
        e.a().a(mVar.b);
        if (str.equals(z[11])) {
            if (g.a.get() == 0) {
                e.a().f();
            }
        } else if (str.equals(z[8])) {
            if (g.a.get() == 0) {
                e.a().f();
                return;
            }
            Protocol.SendData(g.a.get(), cn.jiguang.b.e.a.a.b.a(bundle.getByteArray(z[12]), 1), bundle.getInt(z[5]));
        } else if (z[0].equals(str)) {
            e.a().b(bundle);
        } else if (z[7].equals(str)) {
            e.a().a(bundle);
        } else if (str.equals(z[14])) {
            String string = bundle.getString(z[3]);
            b.a();
            b.a(mVar.b, string, g.a.get(), bundle, e.a().b());
        } else if (str.equals(z[6])) {
            e.a().a(bundle.getString(z[3]), bundle, cn.jiguang.b.a.d.i(mVar.b));
        } else if (str.equals(z[10])) {
            String string2 = bundle.getString(z[3]);
            e a = e.a();
            cn.jiguang.b.a.d.i(mVar.b);
            a.a(string2, bundle);
        } else if (str.equals(z[13])) {
            byte[] byteArray = bundle.getByteArray(z[12]);
            int i = bundle.getInt(z[1]);
            String string3 = bundle.getString(z[3]);
            e.a();
            e.a(byteArray, string3, i);
        } else {
            d.g(z[9], new StringBuilder(z[2]).append(str).toString());
        }
    }

    private static boolean c(Context context, String str, Bundle bundle) {
        try {
            Intent intent = new Intent(context, PushService.class);
            intent.setAction(str);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startService(intent);
            return true;
        } catch (SecurityException e) {
            d.h(z[9], new StringBuilder(z[19]).append(e.getMessage()).toString());
            return false;
        } catch (Throwable th) {
            d.h(z[9], new StringBuilder(z[18]).append(th.getMessage()).toString());
            return false;
        }
    }

    public final void a(Context context, String str, Bundle bundle) {
        d.c(z[9], new StringBuilder(z[17]).append(str).append(z[4]).append(bundle == null ? z[16] : bundle.toString()).toString());
        a(context);
        if (this.b == null) {
            this.b = context.getApplicationContext();
        }
        cn.jiguang.b.f.d.a().a(new n(this, context, str, bundle, 1));
    }

    public final void b(Context context, String str, Bundle bundle) {
        d.c(z[9], new StringBuilder(z[21]).append(str).append(z[4]).append(bundle == null ? z[16] : bundle.toString()).toString());
        if (JCoreInterface.init(context, false)) {
            a(context);
            if (context == null) {
                d.g(z[9], z[20]);
                return;
            } else if (b.c()) {
                c(context, str, bundle);
                return;
            } else {
                cn.jiguang.b.f.d.a().a(new n(this, context, str, bundle, 0));
                return;
            }
        }
        d.g(z[9], z[22]);
    }
}
