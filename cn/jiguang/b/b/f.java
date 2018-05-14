package cn.jiguang.b.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import cn.jiguang.b.a;
import cn.jiguang.b.d.b;
import cn.jiguang.b.d.c;
import cn.jiguang.b.d.h;
import cn.jiguang.c.d;
import cn.jiguang.e.j;
import com.kepler.jd.login.KeplerApiManager;

final class f extends Handler {
    private static final String[] z;
    final /* synthetic */ e a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 15;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u0018-\u0002Qf\u0019<,Pj\u0007-\u001cQw";
        r0 = -1;
        r4 = r3;
    L_0x0009:
        r1 = r1.toCharArray();
        r5 = r1.length;
        r6 = 0;
        r7 = 1;
        if (r5 > r7) goto L_0x002d;
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
            case 0: goto L_0x00c2;
            case 1: goto L_0x00c6;
            case 2: goto L_0x00ca;
            case 3: goto L_0x00ce;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 3;
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
        goto L_0x0017;
    L_0x002b:
        r5 = r1;
        r1 = r7;
    L_0x002d:
        if (r5 > r6) goto L_0x0012;
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
            case 5: goto L_0x006b;
            case 6: goto L_0x0073;
            case 7: goto L_0x007c;
            case 8: goto L_0x0086;
            case 9: goto L_0x0091;
            case 10: goto L_0x009c;
            case 11: goto L_0x00a7;
            case 12: goto L_0x00b2;
            case 13: goto L_0x00bd;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0002)\u001d@o\u000f\u0005\u0016Wp\u000b/\u0016\u001e";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "9-\u0001Rj\t-SOj\u0006$\u0016@#\b1SMw\u0019-\u001fB#\u000e=\u0016\u0004w\u0005h\u0000Ao\fh\u0018Mo\u0006-\u0017\u0004n\u0005,\u0016";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "?&\u0016\\s\u000f+\u0007AgJeSSb\u0004<SPlJ;\u0016JgJ&\u0006HoJ:\u0016Uv\u000f;\u0007\n";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0018-\u0002Qf\u0019<,@b\u001e)";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = " !\u0014Qb\u0004/'Gs')\u001dEd\u000f:";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\t'\u001dJf\t<\u001aKm";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006b:
        r3[r2] = r1;
        r2 = 7;
        r1 = "?&\u0016\\s\u000f+\u0007AgJ%\u0000C-\u0005*\u0019\u0004j\u0019h\u001dKwJ\u001a\u0016Uv\u000f;\u0007Mm\rh\u0004Lf\u0004h\u0000Am\u001eh\u0007Mn\u000f'\u0006P-";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0073:
        r3[r2] = r1;
        r2 = 8;
        r1 = "++\u0007Ml\u0004h^\u0004k\u000b&\u0017Hf)'\u0001AN\u000f;\u0000Ed\u000fh_\u0004v\u0004 \u0012Jg\u0006-SIp\re";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007c:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0018-\u0002Qf\u0019<,Wg\u0001<\nTf";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0086:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u0019,\u0018Pz\u001a-";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0091:
        r3[r2] = r1;
        r2 = 11;
        r1 = "?&\u0016\\s\u000f+\u0007AgJeSIp\rh\u0001Ap\u001a'\u001dWfJ*\u0006Jg\u0006-SMpJ&\u0006HoD";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009c:
        r3[r2] = r1;
        r2 = 12;
        r1 = "?&\u0016\\s\u000f+\u0007AgPh\u001eWdJ'\u0011N#\u0003;SJv\u0006$SSk\u000f&SWf\u0004<SPj\u0007-\u001cQwD";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a7:
        r3[r2] = r1;
        r2 = 13;
        r1 = "?&\u0016\\s\u000f+\u0007AgJ%\u0000C-\u0005*\u0019\u0004j\u0019h\u001dKwJ\u001b\u0007Vj\u0004/S\u0004q\u000f9\u0006Ap\u001eh\u0004Lf\u0004h\u0000Am\u001eh\u0007Mn\u000f'\u0006P-";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b2:
        r3[r2] = r1;
        r2 = 14;
        r1 = "?&\u0016\\s\u000f+\u0007AgPh\u0011Qm\u000e$\u0016\u0004j\u0019h\u001dQo\u0006h\u0004Lf\u0004h\u0001Ar\u001f-\u0000P#\u001e!\u001eAl\u001f<]";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00bd:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00c2:
        r9 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        goto L_0x001f;
    L_0x00c6:
        r9 = 72;
        goto L_0x001f;
    L_0x00ca:
        r9 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        goto L_0x001f;
    L_0x00ce:
        r9 = 36;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.b.f.<clinit>():void");
    }

    public f(e eVar, Looper looper) {
        this.a = eVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        d.a(z[5], new StringBuilder(z[1]).append(message.toString()).toString());
        try {
            String str = "";
            Object data = message.getData();
            if (data != null) {
                str = data.getString(z[10]);
            }
            if (j.a(str) || str.equals(a.a)) {
                Bundle data2;
                switch (message.what) {
                    case 1001:
                        d.c(z[5], z[2]);
                        cn.jiguang.e.a.h(this.a.h.getApplicationContext());
                        c.a(this.a.h, a.b);
                        return;
                    case PointerIconCompat.TYPE_HAND /*1002*/:
                        cn.jiguang.a.c.c.a(this.a.h);
                        return;
                    case 1003:
                        e.b(this.a);
                        return;
                    case 1004:
                        e.a(this.a, true);
                        return;
                    case KeplerApiManager.KeplerApiManagerActionErr_AppKeyNotExist /*1005*/:
                        e.a(this.a, false);
                        return;
                    case PointerIconCompat.TYPE_CELL /*1006*/:
                        removeMessages(PointerIconCompat.TYPE_COPY);
                        removeMessages(PointerIconCompat.TYPE_ALIAS);
                        sendEmptyMessageDelayed(PointerIconCompat.TYPE_COPY, 3000);
                        return;
                    case PointerIconCompat.TYPE_CROSSHAIR /*1007*/:
                        sendEmptyMessageDelayed(PointerIconCompat.TYPE_ALIAS, 200);
                        return;
                    case PointerIconCompat.TYPE_ALIAS /*1010*/:
                        if (this.a.a != null) {
                            this.a.a.c();
                            return;
                        }
                        return;
                    case PointerIconCompat.TYPE_COPY /*1011*/:
                        this.a.e();
                        return;
                    case KeplerApiManager.KeplerApiManagerActionErr_TokenLast /*1022*/:
                        e.d(this.a);
                        return;
                    case 1031:
                        cn.jiguang.e.a.h(this.a.h.getApplicationContext());
                        return;
                    case 1032:
                        h.a().a(this.a.h);
                        return;
                    case 7301:
                        e.b(this.a, message.getData().getLong(z[6]));
                        return;
                    case 7303:
                        e.c(this.a, message.getData().getLong(z[6]));
                        return;
                    case 7304:
                        e.a(this.a, message.getData().getLong(z[6]));
                        return;
                    case 7306:
                        d.d(e.z[2], new StringBuilder(e.z[8]).append(message.getData().getLong(z[6])).append(e.z[9]).append(message.arg2).toString());
                        return;
                    case 7307:
                        g.b.set(false);
                        return;
                    case 7401:
                        data2 = message.getData();
                        if (data2 == null) {
                            d.h(z[5], z[3]);
                            return;
                        }
                        int i = data2.getInt(z[0]);
                        h.a().b(data2.getByteArray(z[4]), data2.getString(z[9]), i);
                        return;
                    case 7402:
                        data2 = message.getData();
                        if (data2 == null) {
                            d.h(z[5], z[11]);
                            return;
                        }
                        h.a().a(message.getData().getLong(z[6]), data2.getString(z[9]), message.obj);
                        return;
                    case 7403:
                        if (message.obj == null) {
                            d.g(z[5], z[14]);
                            return;
                        } else if (message.obj instanceof i) {
                            h.a().b((i) message.obj);
                            return;
                        } else {
                            d.g(z[5], z[7]);
                            return;
                        }
                    case 7404:
                        if (message.obj == null) {
                            d.g(z[5], z[12]);
                            return;
                        } else if (message.obj instanceof i) {
                            h.a().a((i) message.obj);
                            return;
                        } else {
                            d.g(z[5], z[13]);
                            return;
                        }
                    default:
                        d.g(z[5], new StringBuilder(z[8]).append(message.what).toString());
                        return;
                }
            }
            b.a();
            b.a(this.a.h, str, data);
        } catch (Exception e) {
        }
    }
}
