package cn.jiguang.e.b.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import cn.jiguang.c.d;
import cn.jiguang.e.b.a;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class e extends a {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 8;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "d\u0007\u000b\u0017LS#\u001c\u001edZ\u0007\u0015";
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
            case 0: goto L_0x0079;
            case 1: goto L_0x007c;
            case 2: goto L_0x007f;
            case 3: goto L_0x0082;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 45;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "G\u001f\u0016\u001cH";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "T\u0018\u0014\\LY\u0013\u000b\u001dDSY\u0010\u001cYR\u0005\u0017\u0013A\u0019\u0003\u001c\u001eHG\u001f\u0016\u001cT\u0019'\u0011\u001dCR1\u0018\u0011YX\u0005\u0000";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "P\u0012\r!HE\u0001\u0010\u0011Hy\u0016\u0014\u0017";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "T\u001f\u001c\u0011F\u0017\u0013\u001c\u0004DT\u0012Y\u0014L^\u001b\u001c\u0016\u0001\u0017\u0012\u000b\u0000BEM";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "[\u0018\u0018\u0016\rQ\u0016\u0010\u001eHS[Y\u0017_E\u0018\u000bH";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "[\u0018\u0018\u0016\rD\u001e\u0014@\r^\u0019\u001f\u001d\rQ\u0016\u0010\u001eHSM";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "[\u0018\u0018\u0016\rD\u001e\u0014C\r^\u0019\u001f\u001d\rQ\u0016\u0010\u001eHSM";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0079:
        r9 = 55;
        goto L_0x0020;
    L_0x007c:
        r9 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        goto L_0x0020;
    L_0x007f:
        r9 = 121; // 0x79 float:1.7E-43 double:6.0E-322;
        goto L_0x0020;
    L_0x0082:
        r9 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.b.a.e.<clinit>():void");
    }

    public final ArrayList<a> a(Context context) {
        ArrayList<a> arrayList = new ArrayList();
        Class cls = Class.forName(z[2]);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService((String) cls.getMethod(z[3], new Class[]{String.class, Integer.TYPE}).invoke(cls, new Object[]{z[1], Integer.valueOf(1)}));
        TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService(z[1]);
        a aVar = new a();
        try {
            aVar.c = telephonyManager2.getSubscriberId();
            aVar.b = telephonyManager2.getDeviceId();
            aVar.e = telephonyManager2.getSimSerialNumber();
            aVar.d = telephonyManager2.getPhoneType();
        } catch (Throwable th) {
            d.g(z[0], new StringBuilder(z[5]).append(th).toString());
            return null;
        }
        arrayList.add(aVar);
        a aVar2 = new a();
        try {
            aVar2.c = telephonyManager.getSubscriberId();
            aVar2.b = telephonyManager.getDeviceId();
            aVar2.e = telephonyManager.getSimSerialNumber();
            aVar2.d = telephonyManager.getPhoneType();
        } catch (Throwable th2) {
            d.g(z[0], new StringBuilder(z[6]).append(th2).toString());
        }
        arrayList.add(aVar2);
        return arrayList;
    }

    public final boolean b(Context context) {
        try {
            Class cls = Class.forName(z[2]);
            Method method = cls.getMethod(z[3], new Class[]{String.class, Integer.TYPE});
            String str = (String) method.invoke(cls, new Object[]{z[1], Integer.valueOf(1)});
            return (method == null || str == null || ((TelephonyManager) context.getSystemService(str)) == null) ? false : true;
        } catch (Throwable th) {
            d.g(z[0], new StringBuilder(z[4]).append(th).toString());
            return false;
        }
    }
}
