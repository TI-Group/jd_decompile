package cn.jiguang.e.b.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import cn.jiguang.c.d;
import cn.jiguang.e.b.a;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class b extends a {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 27;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "\u000eUHj<\u0000]\u001c) \u001c^Hj)\bYP/+E\u0010Y8=\u0006B\u0006";
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
            case 0: goto L_0x0147;
            case 1: goto L_0x014b;
            case 2: goto L_0x014f;
            case 3: goto L_0x0153;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 79;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u000eUH\u0019&\u0004sS?!\u001d";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "(^X8 \u0000Th/# ]L&";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "\u000eUH\u0019:\u000byX";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u001aE^#+S";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "\u000eUHj<\u001cRU.o\u000fQU&*\r\u001cY8=\u0006B\u0006";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "\b^X8 \u0000T\u0012>*\u0005UL\" \u0007I\u0012\u0019:\u000bC_8&\u0019DU%!$QR+(\fB";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "\u001d]\u001c=.\u001a\u0010R?#\u0005";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u000eUHj+\fV]?#\u001d\u0010O#\"IYR, IV]##\fT\u0010j*\u001bBS8u";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "\u0019XS$* T\u0006";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "\u000eUH\u001a'\u0006^Y\u0003+";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "\u000eUH\u0003\"\fY";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "\u000eUHj<\u0000]\u001c#!\u000f_\u001c,.\u0000\\Y.c\fBN%=S";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "\u000eUH\u0019&\u0004cY8&\b\\r?\"\u000bUN";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "\u001aYQ";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = "\u000eUH\u0004*\u001dGS8$&@Y8.\u001d_N\u0004.\u0004U";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "\u001aYQ\u0003!\u000f_Op";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "\u000eUH\u0019&\u0004L/=\bDS8\u0001\b]Y\f \u001b`T%!\f";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "\u000eUH\u000e*\u001fY_/\u0006\r";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "\nXY)$ITY<&\nU\u001c,.\u0000\\Y.c\fBN%=S";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "\u0005_].o\u001aYQj&\u0007VSj*\u001bBS8u";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        r2 = 21;
        r1 = "\u000eUH\u0019:\u000bC_8&\u000bUN\u0003+";
        r0 = 20;
        r3 = r4;
        goto L_0x0009;
    L_0x010b:
        r3[r2] = r1;
        r2 = 22;
        r1 = "\u0019XS$*";
        r0 = 21;
        r3 = r4;
        goto L_0x0009;
    L_0x0116:
        r3[r2] = r1;
        r2 = 23;
        r1 = "\u001aYQ\t \u001c^Hp";
        r0 = 22;
        r3 = r4;
        goto L_0x0009;
    L_0x0121:
        r3[r2] = r1;
        r2 = 24;
        r1 = "IYR, S";
        r0 = 23;
        r3 = r4;
        goto L_0x0009;
    L_0x012c:
        r3[r2] = r1;
        r2 = 25;
        r1 = "\u000eUH\t:\u001bBY$;9XS$*=IL/";
        r0 = 24;
        r3 = r4;
        goto L_0x0009;
    L_0x0137:
        r3[r2] = r1;
        r2 = 26;
        r1 = "\nXY)$ITY<&\nU\u001c,.\u0000\\Y.cIUN8 \u001b\n";
        r0 = 25;
        r3 = r4;
        goto L_0x0009;
    L_0x0142:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0147:
        r9 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        goto L_0x0020;
    L_0x014b:
        r9 = 48;
        goto L_0x0020;
    L_0x014f:
        r9 = 60;
        goto L_0x0020;
    L_0x0153:
        r9 = 74;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.b.a.b.<clinit>():void");
    }

    private static int a(int i) {
        try {
            Method declaredMethod = Class.forName(z[6]).getDeclaredMethod(z[3], new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            int[] iArr = (int[]) declaredMethod.invoke(null, new Object[]{Integer.valueOf(i)});
            if (iArr.length <= 0) {
                return i;
            }
            d.e(z[2], new StringBuilder(z[4]).append(iArr[0]).toString());
            return iArr[0];
        } catch (Throwable th) {
            d.g(z[2], new StringBuilder(z[5]).append(th).toString());
            return i;
        }
    }

    private static int a(int i, int i2) {
        try {
            Method declaredMethod = Class.forName(z[6]).getDeclaredMethod(z[10], new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(null, new Object[]{Integer.valueOf(i2)})).intValue();
            d.e(z[2], new StringBuilder(z[9]).append(intValue).toString());
            return intValue;
        } catch (Throwable th) {
            d.g(z[2], new StringBuilder(z[5]).append(th).toString());
            return i;
        }
    }

    private static a a(TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            d.g(z[2], z[7]);
            return null;
        }
        a aVar = new a();
        try {
            aVar.b = telephonyManager.getDeviceId();
            aVar.c = telephonyManager.getSubscriberId();
            aVar.g = telephonyManager.getNetworkOperatorName();
            aVar.f = telephonyManager.getSimOperatorName();
            aVar.d = telephonyManager.getPhoneType();
            aVar.e = telephonyManager.getSimSerialNumber();
            return aVar;
        } catch (Throwable th) {
            d.g(z[2], new StringBuilder(z[8]).append(th).toString());
            return aVar;
        }
    }

    private static int b(TelephonyManager telephonyManager) {
        try {
            return ((Integer) telephonyManager.getClass().getMethod(z[1], new Class[0]).invoke(telephonyManager, new Object[0])).intValue();
        } catch (Throwable th) {
            d.g(z[2], new StringBuilder(z[0]).append(th).toString());
            return -1;
        }
    }

    public final ArrayList<a> a(Context context) {
        ArrayList<a> arrayList = new ArrayList();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(z[22]);
            int b = b(telephonyManager);
            d.e(z[2], new StringBuilder(z[23]).append(b).toString());
            if (b > 0) {
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(z[18], new Class[]{Integer.TYPE});
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = telephonyManager.getClass().getDeclaredMethod(z[11], new Class[]{Integer.TYPE});
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = telephonyManager.getClass().getDeclaredMethod(z[15], new Class[]{Integer.TYPE});
                declaredMethod3.setAccessible(true);
                Method declaredMethod4 = telephonyManager.getClass().getDeclaredMethod(z[17], new Class[]{Integer.TYPE});
                declaredMethod4.setAccessible(true);
                Method declaredMethod5 = telephonyManager.getClass().getDeclaredMethod(z[13], new Class[]{Integer.TYPE});
                declaredMethod5.setAccessible(true);
                Method declaredMethod6 = telephonyManager.getClass().getDeclaredMethod(z[21], new Class[]{Integer.TYPE});
                declaredMethod6.setAccessible(true);
                Method declaredMethod7 = telephonyManager.getClass().getDeclaredMethod(z[25], new Class[]{Integer.TYPE});
                declaredMethod7.setAccessible(true);
                for (int i = 0; i < b; i++) {
                    int a = a(i, a(i));
                    a aVar = new a();
                    try {
                        aVar.a = (String) declaredMethod.invoke(telephonyManager, new Object[]{Integer.valueOf(i)});
                        aVar.b = (String) declaredMethod2.invoke(telephonyManager, new Object[]{Integer.valueOf(i)});
                        aVar.e = (String) declaredMethod5.invoke(telephonyManager, new Object[]{Integer.valueOf(r13)});
                        aVar.g = (String) declaredMethod3.invoke(telephonyManager, new Object[]{Integer.valueOf(r13)});
                        aVar.f = (String) declaredMethod4.invoke(telephonyManager, new Object[]{Integer.valueOf(a)});
                        aVar.d = ((Integer) declaredMethod7.invoke(telephonyManager, new Object[]{Integer.valueOf(r13)})).intValue();
                        aVar.c = (String) declaredMethod6.invoke(telephonyManager, new Object[]{Integer.valueOf(r13)});
                    } catch (Throwable th) {
                        d.g(z[2], new StringBuilder(z[20]).append(th).toString());
                        arrayList.clear();
                        arrayList.add(a(telephonyManager));
                    }
                    d.e(z[2], new StringBuilder(z[14]).append(i).append(z[24]).append(aVar).toString());
                    arrayList.add(aVar);
                }
                d.e(z[2], new StringBuilder(z[16]).append(arrayList).toString());
                return arrayList;
            }
            arrayList.add(a(telephonyManager));
            d.e(z[2], new StringBuilder(z[16]).append(arrayList).toString());
            return arrayList;
        } catch (Throwable th2) {
            d.g(z[2], new StringBuilder(z[19]).append(th2).toString());
            arrayList.clear();
        }
    }

    public final boolean b(Context context) {
        try {
            if (TelephonyManager.class.getMethod(z[1], new Class[0]) != null) {
                return true;
            }
        } catch (Throwable th) {
            d.g(z[2], new StringBuilder(z[26]).append(th).toString());
        }
        return false;
    }
}
