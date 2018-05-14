package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.e;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.data.d;
import com.jingdong.jdma.common.utils.CommonUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TbsSdkJava */
public final class a {
    private static volatile a a = null;
    private static ExecutorService b = Executors.newSingleThreadExecutor();
    private static final Object f = new Object();
    private static final String[] z;
    private Handler c = null;
    private Context d = null;
    private String e = "";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 31;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "US.\u0016M\u0010S(";
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
            case 0: goto L_0x0183;
            case 1: goto L_0x0187;
            case 2: goto L_0x018b;
            case 3: goto L_0x018f;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 46;
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
        r1 = "\u0016L>\u0014\\UA7\u0019\u000e\u0019O8\u0014BUN4\u0001G\u0013I8\u0014Z\u001cO5U";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "?p.\u0006F9O8\u0014B;O/\u001cH\u001cC:\u0001G\u001aN\u0018\u0010@\u0001E)";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "9O8\u0014B;O/\u001cH\u001cC:\u0001G\u001aN{\u001a@=E:\u0007Z7E:\u0001";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0018E(\u0006O\u0012E";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u0014P+<J";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\u0006E5\u0011K\u0007i?";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001bO/\u001cH\u001cC:\u001cA\u001b/\f^\u0010";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0006T:\u0007ZUl4\u0016O\u0019n4\u0001G\u0013I8\u0014Z\u001cO5UL\u0007O:\u0011m\u0014S/!A%U(\u001d|\u0010C>\u001cX\u0010R";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0010N?Ub\u001aC:\u0019`\u001aT2\u0013G\u0016A/\u001cA\u001b\u00009\u0007A\u0014D\u0018\u0014]\u0001t4%[\u0006H\t\u0010M\u0010I-\u0010\\";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "[P>\u0007C\u001cS(\u001cA\u001b\u000e\u0011%{&h\u00048k&s\u001a2k";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u0016Nu\u001f^\u0000S3[O\u001bD)\u001aG\u0011\u000e2\u001bZ\u0010N/[`:t\u00123g6a\u000f<a;\t0m0i\r0j*p\t:v,";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u0014D?Ub\u001aC:\u0019`\u001aT2\u0013G\u0016A/\u001cA\u001b";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u0005U(\u001d\u000e\u001dA(U]\u0001O+\u0005K\u0011";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u0010X8\u0010^\u0001I4\u001b\u0014";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "9O8\u0014B;O/\u001cH\u001cC:\u0001G\u001aN{\u0006M\u001dE?\u0000B\u0010r>\u0014J\u001cE?9`";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u0005O(\u0001\u000e\u0007I<\u001dZUN4\u0002\u000e";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u0005O(\u0001\u000e\u0011E7\u0014W\u0010D{O\u000e";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\u0012E/<@\u0006T:\u001bM\u0010";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "6O5\u0006Z\u0007U8\u0001A\u0007\u0000aUd%U(\u001db\u001aC:\u0019`\u001aT2\u0013G\u0016A/\u001cA\u001bc>\u001bZ\u0010R";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0001R2\u0012I\u0010R\u0017;e\u001cL7%\\\u001aC>\u0006]O\u0000";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\u001cN2\u0001\u000e9O8\u0014B;O/\u001cH\u001cC:\u0001G\u001aN{\u0016O\u0006T{\u0010V\u0005TaUJ\u0017\u00004\u0005K\u001b\u0000=\u0014G\u0019E?";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0001R2\u0012I\u0010R\u0017;e\u001cL7%\\\u001aC>\u0006]";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u0019O8\u0014B*N4\u0001G\u0013I8\u0014Z\u001cO5";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "\u0018U7\u0001G*T\"\u0005K";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "\u0016Nu\u001f^\u0000S3[O\u001bD)\u001aG\u0011\u000e2\u001bZ\u0010N/[c l\u000f<q%r\u00146k&s";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "\u0014C/\u001cA\u001b";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "\u0007E6\u001aX\u0010\u00007\u001aM\u0014L{\u0016A\u0000N/U\u0014U";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = "\u0007E6\u001aX\u0010\u0000\u0017\u001aM\u0014L\u0015\u001aZ\u001cF2\u0016O\u0001I4\u001b\u000e";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "\u001cN2\u0001\u000e9O8\u0014B;O/\u001cH\u001cC:\u0001G\u001aN{\u0016O\u0006T{\u0010V\u0005Ta";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "\u001cN2\u0001\u000e9O8\u0014B;O/\u001cH\u001cC:\u0001G\u001aN";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        z = r4;
        r0 = 0;
        a = r0;
        r0 = java.util.concurrent.Executors.newSingleThreadExecutor();
        b = r0;
        r0 = new java.lang.Object;
        r0.<init>();
        f = r0;
        return;
    L_0x0183:
        r9 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        goto L_0x0020;
    L_0x0187:
        r9 = 32;
        goto L_0x0020;
    L_0x018b:
        r9 = 91;
        goto L_0x0020;
    L_0x018f:
        r9 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.a.<clinit>():void");
    }

    private a(Context context) {
        e.c(z[2], z[19]);
        this.c = new Handler(Looper.getMainLooper());
        this.d = context;
        this.e = this.d.getPackageName();
    }

    public static a a(Context context) {
        e.c(z[2], z[18]);
        if (a == null) {
            synchronized (f) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private synchronized void a(final long j, long j2) {
        e.c(z[2], z[15]);
        if (this.c != null) {
            Runnable anonymousClass2 = new Runnable(this) {
                private static final String[] z;
                final /* synthetic */ a b;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                static {
                    /*
                    r0 = 6;
                    r3 = new java.lang.String[r0];
                    r2 = 0;
                    r1 = "t\u001ett%r[eu ";
                    r0 = -1;
                    r4 = r3;
                L_0x0008:
                    r1 = r1.toCharArray();
                    r5 = r1.length;
                    r6 = 0;
                    r7 = 1;
                    if (r5 > r7) goto L_0x002d;
                L_0x0011:
                    r7 = r1;
                    r8 = r6;
                    r11 = r5;
                    r5 = r1;
                    r1 = r11;
                L_0x0016:
                    r10 = r5[r6];
                    r9 = r8 % 5;
                    switch(r9) {
                        case 0: goto L_0x0068;
                        case 1: goto L_0x006a;
                        case 2: goto L_0x006d;
                        case 3: goto L_0x006f;
                        default: goto L_0x001d;
                    };
                L_0x001d:
                    r9 = 68;
                L_0x001f:
                    r9 = r9 ^ r10;
                    r9 = (char) r9;
                    r5[r6] = r9;
                    r6 = r8 + 1;
                    if (r1 != 0) goto L_0x002b;
                L_0x0027:
                    r5 = r7;
                    r8 = r6;
                    r6 = r1;
                    goto L_0x0016;
                L_0x002b:
                    r5 = r1;
                    r1 = r7;
                L_0x002d:
                    if (r5 > r6) goto L_0x0011;
                L_0x002f:
                    r5 = new java.lang.String;
                    r5.<init>(r1);
                    r1 = r5.intern();
                    switch(r0) {
                        case 0: goto L_0x0043;
                        case 1: goto L_0x004b;
                        case 2: goto L_0x0053;
                        case 3: goto L_0x005b;
                        case 4: goto L_0x0063;
                        default: goto L_0x003b;
                    };
                L_0x003b:
                    r3[r2] = r1;
                    r2 = 1;
                    r1 = "L+qb,J\u0014gp(H\u0014px\"o\u0018ee-i\u0015Gt*r\u001ev";
                    r0 = 0;
                    r3 = r4;
                    goto L_0x0008;
                L_0x0043:
                    r3[r2] = r1;
                    r2 = 2;
                    r1 = "t\u001ei~2c[";
                    r0 = 1;
                    r3 = r4;
                    goto L_0x0008;
                L_0x004b:
                    r3[r2] = r1;
                    r2 = 3;
                    r1 = "c\u0003gt4r\u0012k~";
                    r0 = 2;
                    r3 = r4;
                    goto L_0x0008;
                L_0x0053:
                    r3[r2] = r1;
                    r2 = 4;
                    r1 = "g\u0017vt%b\u0002$e6o\u001cct6c\u001f";
                    r0 = 3;
                    r3 = r4;
                    goto L_0x0008;
                L_0x005b:
                    r3[r2] = r1;
                    r2 = 5;
                    r1 = "u\u001ejudd\tkp e\u001awe";
                    r0 = 4;
                    r3 = r4;
                    goto L_0x0008;
                L_0x0063:
                    r3[r2] = r1;
                    z = r4;
                    return;
                L_0x0068:
                    r9 = 6;
                    goto L_0x001f;
                L_0x006a:
                    r9 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
                    goto L_0x001f;
                L_0x006d:
                    r9 = 4;
                    goto L_0x001f;
                L_0x006f:
                    r9 = 17;
                    goto L_0x001f;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.a.2.<clinit>():void");
                }

                public final void run() {
                    try {
                        d a = d.a(this.b.d);
                        cn.jpush.android.data.e a2 = a.a(j, 0);
                        if (a2 == null) {
                            return;
                        }
                        if (a2.c() == 1) {
                            e.c(z[1], z[2]);
                            a.b(a2.a(), 0, 1, 0, a2.d(), a2.f(), a2.e());
                        } else if (a2.b() > 1) {
                            e.c(z[1], z[0]);
                            a.b(a2.a(), a2.b() - 1, 0, 0, a2.d(), a2.f(), a2.e());
                        } else if (a2.b() == 1) {
                            e.c(z[1], z[5]);
                            if (a2.f() > System.currentTimeMillis()) {
                                e.c(z[1], z[0]);
                                return;
                            }
                            this.b.a(this.b.d, a2.d(), this.b.e, "");
                            a.b(a2.a(), 0, 0, 0, a2.d(), a2.f(), a2.e());
                        } else {
                            e.c(z[1], z[4]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        e.i(z[1], new StringBuilder(z[3]).append(e.getMessage()).toString());
                    }
                }
            };
            if (j2 <= 0) {
                e.c(z[2], z[16]);
                this.c.post(anonymousClass2);
            } else {
                e.c(z[2], new StringBuilder(z[17]).append(j2).toString());
                this.c.postDelayed(anonymousClass2, j2);
            }
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        e.c(z[2], z[8]);
        Intent intent = new Intent(z[11]);
        intent.putExtra(z[6], str3);
        intent.putExtra(z[5], str2);
        intent.putExtra(z[4], str);
        intent.putExtra(z[7], 1);
        intent.addCategory(str2);
        context.sendOrderedBroadcast(intent, str2 + z[10]);
        e.c(z[2], z[9]);
    }

    private synchronized boolean a(Context context, JPushLocalNotification jPushLocalNotification) {
        boolean z;
        e.d(z[2], z[12]);
        long currentTimeMillis = System.currentTimeMillis();
        long broadcastTime = jPushLocalNotification.getBroadcastTime() - currentTimeMillis;
        if (ServiceInterface.d(context)) {
            e.c(z[2], z[13]);
        }
        long notificationId = jPushLocalNotification.getNotificationId();
        try {
            d a = d.a(context);
            if (a.a(notificationId, 0) != null) {
                a.b(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            } else {
                a.a(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.i(z[2], new StringBuilder(z[14]).append(e.getMessage()).toString());
        }
        if (broadcastTime < CommonUtil.REPORT_ERROR_SLEEP_TIME) {
            a(jPushLocalNotification.getNotificationId(), broadcastTime);
            z = true;
        } else {
            z = true;
        }
        return z;
    }

    private synchronized void e(Context context) {
        Cursor a;
        Exception e;
        Throwable th;
        e.c(z[2], z[22]);
        d a2 = d.a(context);
        if (a2.a(false)) {
            Cursor cursor = null;
            try {
                a = a2.a(1, System.currentTimeMillis());
                try {
                    if (a.moveToFirst()) {
                        do {
                            cn.jpush.android.data.e a3 = d.a(a);
                            if (a3 != null) {
                                a(context, a3.d(), this.e, "");
                                a2.b(a3.a(), 0, 0, 0, a3.d(), a3.f(), a3.e());
                            }
                        } while (a.moveToNext());
                    }
                    if (a != null) {
                        a.close();
                    }
                    a2.b(false);
                } catch (Exception e2) {
                    e = e2;
                    cursor = a;
                    try {
                        e.h(z[2], new StringBuilder(z[20]).append(e.getMessage()).toString());
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.b(false);
                    } catch (Throwable th2) {
                        th = th2;
                        a = cursor;
                        if (a != null) {
                            a.close();
                        }
                        a2.b(false);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (a != null) {
                        a.close();
                    }
                    a2.b(false);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                e.h(z[2], new StringBuilder(z[20]).append(e.getMessage()).toString());
                if (cursor != null) {
                    cursor.close();
                }
                a2.b(false);
            } catch (Throwable th4) {
                th = th4;
                a = null;
                if (a != null) {
                    a.close();
                }
                a2.b(false);
                throw th;
            }
        }
        e.i(z[2], z[21]);
    }

    public final synchronized boolean a(Context context, long j) {
        boolean z = false;
        synchronized (this) {
            e.d(z[2], z[28]);
            try {
                d a = d.a(context);
                cn.jpush.android.data.e a2 = a.a(j, 0);
                if (a2 != null) {
                    e.c(z[2], new StringBuilder(z[27]).append(a2.b()).toString());
                    a.a(j);
                    JPushInterface.clearNotificationById(this.d, (int) j);
                    z = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.i(z[2], new StringBuilder(z[14]).append(e.getMessage()).toString());
            }
        }
        return z;
    }

    public final synchronized boolean a(Context context, JPushLocalNotification jPushLocalNotification, boolean z) {
        if (z) {
            a(context, jPushLocalNotification);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(z[26], z[25]);
            bundle.putInt(z[24], 6);
            bundle.putSerializable(z[23], jPushLocalNotification);
            JCoreInterface.sendAction(context, cn.jpush.android.a.a, bundle);
        }
        return true;
    }

    public final synchronized void b(Context context) {
        synchronized (this) {
            e.d(z[2], z[1]);
            int[] a = d.a(context).a();
            if (a != null && a.length > 0) {
                e.c(z[2], z[0]);
                for (int clearNotificationById : a) {
                    JPushInterface.clearNotificationById(this.d, clearNotificationById);
                }
            }
        }
    }

    public final synchronized void c(Context context) {
        e.c(z[2], z[30]);
        d a = d.a(context);
        if (a.a(false)) {
            Cursor cursor = null;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                cursor = a.a(currentTimeMillis, (long) CommonUtil.REPORT_ERROR_SLEEP_TIME);
                if (cursor.moveToFirst()) {
                    do {
                        cn.jpush.android.data.e a2 = d.a(cursor);
                        if (a2 != null) {
                            a(a2.a(), a2.f() - currentTimeMillis);
                        }
                    } while (cursor.moveToNext());
                }
                if (cursor != null) {
                    cursor.close();
                }
                a.b(false);
            } catch (Exception e) {
                e.i(z[2], new StringBuilder(z[29]).append(e).toString());
                if (cursor != null) {
                    cursor.close();
                }
                a.b(false);
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                a.b(false);
            }
        } else {
            e.i(z[2], z[21]);
        }
    }

    public final void d(final Context context) {
        e.c(z[2], z[3]);
        b.execute(new Runnable(this) {
            final /* synthetic */ a b;

            public final void run() {
                this.b.e(context);
                this.b.c(context);
            }
        });
    }
}
