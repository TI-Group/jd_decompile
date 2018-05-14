package cn.jiguang.e.b.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import cn.jiguang.e.b.a;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class d extends a {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 12;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "TW\bU\u0005{R\u0014R\r";
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
            case 0: goto L_0x00a2;
            case 1: goto L_0x00a6;
            case 2: goto L_0x00aa;
            case 3: goto L_0x00ae;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 96;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "EQ\u0003I\u000fM[IO\u0005HZ\u0017S\u000fJFIv3MR3^\fAO\u000fT\u000e]r\u0006U\u0001CZ\u0015";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "uJ\u0006W\u0003KR\no\u0005Hv\nK\f";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "CZ\u0013\u0005RV\u0004^)@";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "CZ\u0013\u0001P^4O\u0001PZ";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "CZ\u0013h\u0015FL\u0004I\tFZ\u0015r\u0004";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "GW\u0002X\u000b\u0004[\u0002M\tGZG]\u0001MS\u0002_L\u0004Z\u0015I\u000fV\u0005";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "WV\nr\u000eBP\u0014\u0001";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "HP\u0006_@B^\u000eW\u0005@\u0013G^\u0012VP\u0015\u0001";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "TW\bU\u0005";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "HP\u0006_@WV\n\t@MQ\u0001T@B^\u000eW\u0005@\u0005";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "HP\u0006_@WV\n\n@MQ\u0001T@B^\u000eW\u0005@\u0005";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x00a2:
        r9 = 36;
        goto L_0x0020;
    L_0x00a6:
        r9 = 63;
        goto L_0x0020;
    L_0x00aa:
        r9 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        goto L_0x0020;
    L_0x00ae:
        r9 = 59;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.b.a.d.<clinit>():void");
    }

    public final ArrayList<a> a(Context context) {
        ArrayList<a> arrayList = new ArrayList();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(z[9]);
        Class cls = Class.forName(z[1]);
        Object systemService = context.getSystemService(z[0]);
        Method method = cls.getMethod(z[4], new Class[0]);
        Method method2 = cls.getMethod(z[3], new Class[]{Integer.TYPE});
        Method method3 = cls.getMethod(z[5], new Class[]{Integer.TYPE});
        a aVar = new a();
        try {
            aVar.b = (String) method2.invoke(systemService, new Object[]{Integer.valueOf(0)});
            aVar.c = (String) method3.invoke(systemService, new Object[]{Integer.valueOf(0)});
            aVar.d = telephonyManager.getDataState();
        } catch (Throwable th) {
            cn.jiguang.c.d.g(z[2], new StringBuilder(z[8]).append(th).toString());
            return null;
        }
        arrayList.add(aVar);
        a aVar2 = new a();
        try {
            aVar2.b = (String) method2.invoke(systemService, new Object[]{Integer.valueOf(1)});
            aVar2.c = (String) method3.invoke(systemService, new Object[]{Integer.valueOf(1)});
            aVar2.d = ((Integer) method.invoke(systemService, new Object[0])).intValue();
        } catch (Throwable th2) {
            cn.jiguang.c.d.g(z[2], new StringBuilder(z[10]).append(th2).toString());
        }
        arrayList.add(aVar2);
        cn.jiguang.c.d.e(z[2], new StringBuilder(z[7]).append(arrayList).toString());
        return arrayList;
    }

    public final boolean b(Context context) {
        try {
            Class cls = Class.forName(z[1]);
            Object systemService = context.getSystemService(z[0]);
            cls.getMethod(z[4], new Class[0]);
            return (systemService == null || cls.getMethod(z[3], new Class[]{Integer.TYPE}) == null || cls.getMethod(z[5], new Class[]{Integer.TYPE}) == null) ? false : true;
        } catch (Throwable th) {
            cn.jiguang.c.d.g(z[2], new StringBuilder(z[6]).append(th).toString());
            return false;
        }
    }
}
