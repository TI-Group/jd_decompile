package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.a;
import cn.jpush.android.d.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TbsSdkJava */
public final class d {
    private static volatile d a;
    private static final Object d = new Object();
    private static final String[] z;
    private TagAliasReceiver b;
    private ConcurrentHashMap<Long, a> c = new ConcurrentHashMap();
    private AtomicBoolean e = new AtomicBoolean(false);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 34;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "(yOd";
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
            case 0: goto L_0x019b;
            case 1: goto L_0x019f;
            case 2: goto L_0x01a3;
            case 3: goto L_0x01a7;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
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
            case 30: goto L_0x0179;
            case 31: goto L_0x0184;
            case 32: goto L_0x018f;
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = ",yZd\u0018\byOV\u00115y[E\u0018/hGy\u000e9*bG\b/per\u000e/yOrQ|}Ze\u0012.[Gs\u0018f";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "*yD~\u0019=lMs";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "(yOv\u00115y[H\u000e9iAs";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "=tAv\u000e|oId]0wIs\u001884\ba\u001c0mM-";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = ";}\\7\t=\bx\u000f|yD~\u001c/8Nv\u00140}L7P|}Ze\u0012.\"";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "=tAv\u000e";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "(yOv\u00115y[H\u0018.jGe\u001e3|M";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "|jAsG";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "=tD7\t=[7\n=k\b{\u0012=|MsQ|nI{\b9\"";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "(yOv\u00115y[7\u001e=tDu\u001c?s\b~\u000e|v]{\u0011g8Z~\u0019a";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\byOV\u00115y[X\r9jIc\u0012.";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "?tMv\u0013\bqEr2)lkv\u00110zIt\u0016|lAz\u00183m\\7\u000f5|\u0012";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "|lIp<0qId>=tDu\u001c?s[7G";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "?v\u0006}\r)k@9\u001c2|Zx\u001486Ay\t9v\\9)\u001d_wV1\u0015Y{H)\u0015UmX(\b";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u000f}\\V\u00115y[V\u00138LIp\u000e|~Ay\u0014/p\b-]9jZx\u000f\u001fwLrG";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "={\\~\u001228\u00057\u00122LIp<0qId/9kXx\u0013/}\be\u00148\"";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "?v\u0006}\r)k@9\u001c2|Zx\u001486Ay\t9v\\9)\u001d_wV1\u0015Y{H>\u001dTdU<\u001fS";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "/}\\C\u001c;YFs<0qId]9\"";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "(yO7\u001c0qId]?yD{\u001f={C7\u000f9Ad\t9j\b~\u000e|{I{\u00119|";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "(yOV\u00115y[T\u001c0tJv\u001e7k\b~\u000e|vGc]9uXc\u0004";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = ")vzr\u001a5k\\r\u000f|lIp]=tAv\u000e|{I{\u0011>yK|";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "3l@r\u000f|}Pt\u0018,lAx\u0013";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u000e}Kr\u0014*}Z7\u00133l\be\u0018;q[c\u0018.}L;]?yFy\u0012(8Kv\u001108]y\u000f9Ad\t9jzr\u001e9q^r\u000f";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "2}_7\r.w\\x](aXr]8w\by\u0012(8Kv\u001108]d\u0018.8Kv\u00110zIt\u0016";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "p{I{\u0011\u001eyK|G";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "={\\~\u001228\u00057\u00142nG|\u0018\tkMe>=tDu\u001c?s\u00047\u0018.jGe>3|M-";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        r2 = 27;
        r1 = "={\\~\u001228\u00057\u00122LAz\u00183m\\7\u000f5|\u0012";
        r0 = 26;
        r3 = r4;
        goto L_0x0009;
    L_0x014d:
        r3[r2] = r1;
        r2 = 28;
        r1 = ";}\\7\u0012.qO~\u0013|{@r\u001e78\\v\u001a|~I~\u00119|\u00047\u0018.jGeG";
        r0 = 27;
        r3 = r4;
        goto L_0x0009;
    L_0x0158:
        r3[r2] = r1;
        r2 = 29;
        r1 = "?yD{?={C7\n=k\by\b0t";
        r0 = 28;
        r3 = r4;
        goto L_0x0009;
    L_0x0163:
        r3[r2] = r1;
        r2 = 30;
        r1 = "1}[d\u001c;}wc\u0004,}";
        r0 = 29;
        r3 = r4;
        goto L_0x0009;
    L_0x016e:
        r3[r2] = r1;
        r2 = 31;
        r1 = "\u001d{\\~\u001228\u00057\u00122LIp\u001c0qId)5uMx\b(";
        r0 = 30;
        r3 = r4;
        goto L_0x0009;
    L_0x0179:
        r3[r2] = r1;
        r2 = 32;
        r1 = "3v|v\u001a=tAv\u000e\bqEr\u0012)l\br\u000f.wZ-";
        r0 = 31;
        r3 = r4;
        goto L_0x0009;
    L_0x0184:
        r3[r2] = r1;
        r2 = 33;
        r1 = "?v\u0006}\r)k@9\u001c2|Zx\u001486Ay\t9v\\9/\u0019[m^+\u0019GeR.\u000fYoR";
        r0 = 32;
        r3 = r4;
        goto L_0x0009;
    L_0x018f:
        r3[r2] = r1;
        z = r4;
        r0 = new java.lang.Object;
        r0.<init>();
        d = r0;
        return;
    L_0x019b:
        r9 = 92;
        goto L_0x0020;
    L_0x019f:
        r9 = 24;
        goto L_0x0020;
    L_0x01a3:
        r9 = 40;
        goto L_0x0020;
    L_0x01a7:
        r9 = 23;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.d.<clinit>():void");
    }

    private d() {
    }

    private a a(long j) {
        return (a) this.c.get(Long.valueOf(j));
    }

    public static d a() {
        if (a == null) {
            synchronized (d) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    private static String a(a aVar) {
        if (aVar == null) {
            e.g(z[11], z[29]);
            return null;
        }
        try {
            if (aVar.b != null && aVar.b.size() > 0) {
                return (String) aVar.b.toArray()[0];
            }
        } catch (Throwable th) {
            e.c(z[11], new StringBuilder(z[28]).append(th).toString());
        }
        return null;
    }

    private void a(Context context, long j) {
        e.a(z[11], new StringBuilder(z[27]).append(j).toString());
        a a = a(j);
        if (a == null) {
            e.g(z[11], new StringBuilder(z[10]).append(j).toString());
            return;
        }
        a(a, JPushInterface.a.c);
        b(j);
    }

    private static void a(a aVar, int i) {
        e.c(z[11], new StringBuilder(z[26]).append(i).append(z[25]).append(aVar).toString());
        if (aVar.e != 0) {
            e.g(z[11], z[24]);
        } else if (aVar.c != null) {
            aVar.c.gotResult(i, aVar.a, aVar.b);
        }
    }

    private void b(long j) {
        this.c.remove(Long.valueOf(j));
    }

    private void b(Context context) {
        if (this.c != null && !this.c.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Entry entry : this.c.entrySet()) {
                if (((a) entry.getValue()).a(20000)) {
                    arrayList.add(entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                e.g(z[11], new StringBuilder(z[12]).append(l).toString());
                a(context, l.longValue());
            }
        }
    }

    private synchronized void c(Context context) {
        b(context);
        if (this.e.get() && this.c != null && this.c.isEmpty()) {
            try {
                if (this.b != null) {
                    context.unregisterReceiver(this.b);
                    this.b = null;
                }
            } catch (Throwable e) {
                e.c(z[11], z[23], e);
            } catch (Throwable e2) {
                e.c(z[11], z[22], e2);
            }
            this.e.set(false);
            e.a(z[11], z[21]);
        } else {
            e.a(z[11], z[20]);
        }
    }

    public final JPushMessage a(Intent intent) {
        boolean z = false;
        long longExtra = intent.getLongExtra(z[3], -1);
        int intExtra = intent.getIntExtra(z[7], 0);
        e.a(z[11], new StringBuilder(z[1]).append(intExtra).append(z[8]).append(longExtra).toString());
        a a = a(longExtra);
        if (a == null) {
            e.g(z[11], new StringBuilder(z[10]).append(longExtra).toString());
            return null;
        }
        a().b(longExtra);
        if (intent != null && intExtra == 0) {
            try {
                if (a.f == 5) {
                    if (a.e == 1) {
                        Collection stringArrayListExtra = intent.getStringArrayListExtra(z[0]);
                        if (stringArrayListExtra != null) {
                            a.b = new HashSet(stringArrayListExtra);
                            e.c(z[11], new StringBuilder(z[9]).append(a.b).toString());
                        }
                    } else if (a.e == 2) {
                        a.a = intent.getStringExtra(z[6]);
                        e.c(z[11], new StringBuilder(z[4]).append(a.b).toString());
                    }
                } else if (a.f == 6) {
                    z = intent.getBooleanExtra(z[2], false);
                }
            } catch (Throwable th) {
                e.c(z[11], new StringBuilder(z[5]).append(th).toString());
            }
        }
        JPushMessage jPushMessage = new JPushMessage();
        jPushMessage.setErrorCode(intExtra);
        jPushMessage.setSequence(a.d);
        if (a.e != 1) {
            jPushMessage.setAlias(a.a);
        } else if (a.f == 6) {
            jPushMessage.setCheckTag(a(a));
            jPushMessage.setTagCheckStateResult(z);
            jPushMessage.setTagCheckOperator(true);
        } else {
            jPushMessage.setTags(a.b);
        }
        return jPushMessage;
    }

    public final synchronized void a(Context context) {
        if (this.e.get()) {
            e.c(z[11], z[19]);
        } else {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addCategory(cn.jpush.android.a.c);
                intentFilter.addAction(z[14]);
                intentFilter.addAction(z[17]);
                if (this.b == null) {
                    this.b = new TagAliasReceiver();
                }
                context.registerReceiver(this.b, intentFilter);
                this.e.set(true);
            } catch (Exception e) {
                e.i(z[11], new StringBuilder(z[18]).append(e.getMessage()).toString());
            }
        }
    }

    public final void a(Context context, int i, long j, a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.e != 0) {
            try {
                e.c(z[11], z[31]);
                Intent intent = new Intent();
                intent.addCategory(cn.jpush.android.a.c);
                intent.setAction(z[33]);
                intent.setPackage(context.getPackageName());
                if (aVar.e == 1) {
                    intent.putExtra(z[30], 1);
                } else {
                    intent.putExtra(z[30], 2);
                }
                intent.putExtra(z[7], i);
                intent.putExtra(z[3], j);
                context.sendBroadcast(intent);
            } catch (Throwable th) {
                e.h(z[11], new StringBuilder(z[32]).append(th.getMessage()).toString());
            }
        } else if (aVar.c != null) {
            aVar.c.gotResult(i, aVar.a, aVar.b);
            b(j);
        }
    }

    public final void a(Context context, long j, int i, Intent intent) {
        e.a(z[11], new StringBuilder(z[16]).append(j).append(z[13]).append(String.valueOf(a().c)).toString());
        if (z[14].equals(intent.getAction())) {
            a(context, j);
        } else {
            e.a(z[11], new StringBuilder(z[15]).append(i).append(z[8]).append(j).toString());
            a a = a(j);
            if (a == null) {
                e.g(z[11], new StringBuilder(z[10]).append(j).toString());
            } else {
                a().b(j);
                if (intent != null) {
                    try {
                        if (a.f == 5) {
                            if (a.e == 1) {
                                Collection stringArrayListExtra = intent.getStringArrayListExtra(z[0]);
                                if (stringArrayListExtra != null) {
                                    a.b = new HashSet(stringArrayListExtra);
                                    e.c(z[11], new StringBuilder(z[9]).append(a.b).toString());
                                }
                            } else if (a.e == 2) {
                                a.a = intent.getStringExtra(z[6]);
                                e.c(z[11], new StringBuilder(z[4]).append(a.b).toString());
                            }
                        } else if (a.f == 6) {
                            intent.getBooleanExtra(z[2], false);
                        }
                    } catch (Throwable th) {
                        e.c(z[11], new StringBuilder(z[5]).append(th).toString());
                    }
                }
                a(a, i);
            }
        }
        c(context);
    }

    public final void a(Context context, Long l, a aVar) {
        b(context);
        this.c.put(l, aVar);
    }
}
