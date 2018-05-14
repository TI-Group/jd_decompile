package cn.jiguang.e.b.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.c.d;
import cn.jiguang.e.b.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class c extends a {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 21;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "j;!f'g0>'/mz%&2l&\")*' )$#y<#&?'\u001d\u0018-*l$$'(p\u0006)//z >1";
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
            case 0: goto L_0x0105;
            case 1: goto L_0x0109;
            case 2: goto L_0x010d;
            case 3: goto L_0x0111;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 70;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "D\u0000\u0007\u001c#e\u001d!8*";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = ")\"-$3ln";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "n18h5`9l;*f ?h h= -\"%t):4f&v";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "n18\u001b/d\u001b<-4h #:\bh9)\u000f#d=\"!";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "n18\u001b/d\u0007):/h8\u0002=+k1>\u000f#d=\"!";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "y<#&#";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "n18\f#=/-\u000fm\u0013)%/g=";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "z=!\u0001(o;?r";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "e;-,fz=!";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "e;-,fo5%$#mxl-4{;>r";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        r2 = 11;
        r1 = "n18\u0004/g1}\u00063d6):\u0001l9%&/";
        r0 = 10;
        r3 = r4;
        goto L_0x0009;
    L_0x009d:
        r3[r2] = r1;
        r2 = 12;
        r1 = "n18\u001b3k'/:/k1>\u0001\"N1!!(`";
        r0 = 11;
        r3 = r4;
        goto L_0x0009;
    L_0x00a8:
        r3[r2] = r1;
        r2 = 13;
        r1 = "n18\u0018.f:)\u001c?y1\u000b-+`:%";
        r0 = 12;
        r3 = r4;
        goto L_0x0009;
    L_0x00b3:
        r3[r2] = r1;
        r2 = 14;
        r1 = "n18\u0006#}##:-F$):'};>\u0006'd1\u000b-+`:%";
        r0 = 13;
        r3 = r4;
        goto L_0x0009;
    L_0x00be:
        r3[r2] = r1;
        r2 = 15;
        r1 = ")=\".))2-!*l0v";
        r0 = 14;
        r3 = r4;
        goto L_0x0009;
    L_0x00c9:
        r3[r2] = r1;
        r2 = 16;
        r1 = "g!!*#{n";
        r0 = 15;
        r3 = r4;
        goto L_0x0009;
    L_0x00d4:
        r3[r2] = r1;
        r2 = 17;
        r1 = "z=!";
        r0 = 16;
        r3 = r4;
        goto L_0x0009;
    L_0x00df:
        r3[r2] = r1;
        r2 = 18;
        r1 = "d '\u000f#d=\"!\u0015|$<'4}\u0002-$3ln";
        r0 = 17;
        r3 = r4;
        goto L_0x0009;
    L_0x00ea:
        r3[r2] = r1;
        r2 = 19;
        r1 = "j<)+-)2-!*l0v";
        r0 = 18;
        r3 = r4;
        goto L_0x0009;
    L_0x00f5:
        r3[r2] = r1;
        r2 = 20;
        r1 = "d '\u000f#d=\"!\u0015|$<'4}";
        r0 = 19;
        r3 = r4;
        goto L_0x0009;
    L_0x0100:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0105:
        r9 = 9;
        goto L_0x0020;
    L_0x0109:
        r9 = 84;
        goto L_0x0020;
    L_0x010d:
        r9 = 76;
        goto L_0x0020;
    L_0x0111:
        r9 = 72;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.b.a.c.<clinit>():void");
    }

    private static ArrayList<Integer> a(TelephonyManager telephonyManager) {
        ArrayList<Integer> arrayList = new ArrayList();
        try {
            int i = 0;
            for (Field field : TelephonyManager.class.getDeclaredFields()) {
                field.setAccessible(true);
                if (TextUtils.equals(field.getType().getName(), z[0])) {
                    Object obj = field.get(telephonyManager);
                    d.g(z[1], field.getName() + z[2] + obj);
                    if (obj != null) {
                        arrayList.add(Integer.valueOf(i));
                        i++;
                    }
                }
            }
        } catch (Throwable th) {
            d.g(z[1], new StringBuilder(z[3]).append(th).toString());
            arrayList.clear();
            arrayList.add(Integer.valueOf(0));
            arrayList.add(Integer.valueOf(1));
        }
        return arrayList;
    }

    public final ArrayList<a> a(Context context) {
        ArrayList<a> arrayList = new ArrayList();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(z[6]);
        Method declaredMethod = TelephonyManager.class.getDeclaredMethod(z[12], new Class[]{Integer.TYPE});
        Method declaredMethod2 = TelephonyManager.class.getDeclaredMethod(z[7], new Class[]{Integer.TYPE});
        Method declaredMethod3 = TelephonyManager.class.getDeclaredMethod(z[13], new Class[]{Integer.TYPE});
        Method declaredMethod4 = TelephonyManager.class.getDeclaredMethod(z[14], new Class[]{Integer.TYPE});
        Method declaredMethod5 = TelephonyManager.class.getDeclaredMethod(z[5], new Class[]{Integer.TYPE});
        Method declaredMethod6 = TelephonyManager.class.getDeclaredMethod(z[4], new Class[]{Integer.TYPE});
        Method declaredMethod7 = TelephonyManager.class.getDeclaredMethod(z[7], new Class[]{Integer.TYPE});
        Method declaredMethod8 = TelephonyManager.class.getDeclaredMethod(z[11], new Class[]{Integer.TYPE});
        ArrayList a = a(telephonyManager);
        for (int i = 0; i < a.size(); i++) {
            a aVar = new a();
            try {
                int intValue = ((Integer) a.get(i)).intValue();
                aVar.c = (String) declaredMethod.invoke(telephonyManager, new Object[]{Integer.valueOf(intValue)});
                aVar.b = (String) declaredMethod2.invoke(telephonyManager, new Object[]{Integer.valueOf(intValue)});
                aVar.d = ((Integer) declaredMethod3.invoke(telephonyManager, new Object[]{Integer.valueOf(intValue)})).intValue();
                aVar.g = (String) declaredMethod4.invoke(telephonyManager, new Object[]{Integer.valueOf(intValue)});
                aVar.f = (String) declaredMethod6.invoke(telephonyManager, new Object[]{Integer.valueOf(intValue)});
                aVar.e = (String) declaredMethod5.invoke(telephonyManager, new Object[]{Integer.valueOf(intValue)});
                aVar.a = (String) declaredMethod7.invoke(telephonyManager, new Object[]{Integer.valueOf(intValue)});
                d.e(z[1], new StringBuilder(z[16]).append(declaredMethod8.invoke(telephonyManager, new Object[]{Integer.valueOf(intValue)})).toString());
            } catch (Throwable th) {
                d.g(z[1], new StringBuilder(z[10]).append(th).toString());
                return null;
            }
            arrayList.add(aVar);
            d.e(z[1], new StringBuilder(z[17]).append(i).append(":").append(aVar).toString());
        }
        d.e(z[1], new StringBuilder(z[8]).append(arrayList).toString());
        return arrayList;
    }

    public final boolean b(Context context) {
        try {
            a((TelephonyManager) context.getSystemService(z[6]));
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod(z[12], new Class[]{Integer.TYPE});
            Method declaredMethod2 = TelephonyManager.class.getDeclaredMethod(z[7], new Class[]{Integer.TYPE});
            Method declaredMethod3 = TelephonyManager.class.getDeclaredMethod(z[13], new Class[]{Integer.TYPE});
            Field declaredField = TelephonyManager.class.getDeclaredField(z[20]);
            if (!(declaredMethod == null || declaredMethod2 == null || declaredMethod3 == null || declaredField == null)) {
                declaredField.setAccessible(true);
                boolean booleanValue = ((Boolean) declaredField.get(null)).booleanValue();
                d.e(z[1], new StringBuilder(z[18]).append(booleanValue).toString());
                if (booleanValue) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            d.g(z[1], new StringBuilder(z[19]).append(th).toString());
            return false;
        }
    }
}
