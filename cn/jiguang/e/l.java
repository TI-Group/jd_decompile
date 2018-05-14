package cn.jiguang.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.c.d;
import cn.jiguang.d.c;
import java.lang.reflect.InvocationTargetException;

public final class l {
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 11;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "SJ^p&@XEL(wCKM0\u0014AOJ4[]Aj:DJ\u0010";
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
            case 0: goto L_0x0097;
            case 1: goto L_0x009a;
            case 2: goto L_0x009d;
            case 3: goto L_0x00a0;
            default: goto L_0x001e;
        };
    L_0x001e:
        r9 = 67;
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
            default: goto L_0x003c;
        };
    L_0x003c:
        r3[r2] = r1;
        r2 = 1;
        r1 = "\u0000H";
        r0 = 0;
        r3 = r4;
        goto L_0x0009;
    L_0x0044:
        r3[r2] = r1;
        r2 = 2;
        r1 = "AAAP,CA";
        r0 = 1;
        r3 = r4;
        goto L_0x0009;
    L_0x004c:
        r3[r2] = r1;
        r2 = 3;
        r1 = "W@DP&W[CH*@V";
        r0 = 2;
        r3 = r4;
        goto L_0x0009;
    L_0x0054:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\u0006H";
        r0 = 3;
        r3 = r4;
        goto L_0x0009;
    L_0x005c:
        r3[r2] = r1;
        r2 = 5;
        r1 = "SJ^}6F]OP7zJ^j:DJ\n\u0013c@VZ[y";
        r0 = 4;
        r3 = r4;
        goto L_0x0009;
    L_0x0064:
        r3[r2] = r1;
        r2 = 6;
        r1 = "`JF[,ZVg_-UHOL\u0016@FFM";
        r0 = 5;
        r3 = r4;
        goto L_0x0009;
    L_0x006c:
        r3[r2] = r1;
        r2 = 7;
        r1 = "CFLW";
        r0 = 6;
        r3 = r4;
        goto L_0x0009;
    L_0x0074:
        r3[r2] = r1;
        r2 = 8;
        r1 = "\u0007H";
        r0 = 7;
        r3 = r4;
        goto L_0x0009;
    L_0x007d:
        r3[r2] = r1;
        r2 = 9;
        r1 = "G[ONq\u0014\u0002\nJ:DJ\u0010";
        r0 = 8;
        r3 = r4;
        goto L_0x0009;
    L_0x0087:
        r3[r2] = r1;
        r2 = 10;
        r1 = "SJ^p&@XEL(wCKM0";
        r0 = 9;
        r3 = r4;
        goto L_0x0009;
    L_0x0092:
        r3[r2] = r1;
        z = r4;
        return;
    L_0x0097:
        r9 = 52;
        goto L_0x0020;
    L_0x009a:
        r9 = 47;
        goto L_0x0020;
    L_0x009d:
        r9 = 42;
        goto L_0x0020;
    L_0x00a0:
        r9 = 62;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.l.<clinit>():void");
    }

    public static String a(Context context) {
        String str;
        String str2 = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(z[3])).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str = z[2];
            } else if (activeNetworkInfo.getType() == 1) {
                str = z[7];
            } else {
                if (activeNetworkInfo.getType() == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    d.a(z[6], new StringBuilder(z[0]).append(subtype).toString());
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = z[4];
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str = z[8];
                            break;
                        case 13:
                            str = z[1];
                            break;
                        default:
                            if (subtype != 16) {
                                if (subtype != 17) {
                                    if (subtype != 18) {
                                        str = z[2];
                                        break;
                                    }
                                    str = z[1];
                                    break;
                                }
                                str = z[8];
                                break;
                            }
                            str = z[4];
                            break;
                    }
                }
                str = str2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        d.a(z[6], new StringBuilder(z[5]).append(str).toString());
        return str;
    }

    public static String a(Context context, int i) {
        Object obj;
        CharSequence a = a(context);
        d.a(z[6], new StringBuilder(z[5]).append(a).toString());
        CharSequence charSequence;
        if (TextUtils.isEmpty(a)) {
            try {
                Object a2 = c.a(TelephonyManager.class, z[10], Integer.valueOf(i));
                if (((Integer) a2).intValue() == 0) {
                    obj = z[2];
                } else if (((Integer) a2).intValue() == 1) {
                    obj = z[4];
                } else if (((Integer) a2).intValue() == 2) {
                    obj = z[8];
                } else if (((Integer) a2).intValue() == 3) {
                    obj = z[1];
                } else {
                    charSequence = a;
                }
                try {
                    d.c(z[6], new StringBuilder(z[9]).append(obj).toString());
                } catch (NoSuchMethodException e) {
                } catch (IllegalAccessException e2) {
                } catch (InvocationTargetException e3) {
                } catch (Exception e4) {
                }
            } catch (NoSuchMethodException e5) {
                charSequence = a;
            } catch (IllegalAccessException e6) {
                charSequence = a;
            } catch (InvocationTargetException e7) {
                charSequence = a;
            } catch (Exception e8) {
                charSequence = a;
            }
        } else {
            charSequence = a;
        }
        return TextUtils.isEmpty(obj) ? z[2] : obj;
    }
}
