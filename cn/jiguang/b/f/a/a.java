package cn.jiguang.b.f.a;

import android.util.Base64;
import cn.jiguang.b.a.d;
import cn.jiguang.d.c;
import java.lang.reflect.InvocationTargetException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {
    private static String a = "";
    private static int b = 0;
    private static final String[] z;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = 7;
        r3 = new java.lang.String[r0];
        r2 = 0;
        r1 = "=\u001e@";
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
            case 0: goto L_0x0077;
            case 1: goto L_0x007a;
            case 2: goto L_0x007d;
            case 3: goto L_0x0080;
            default: goto L_0x001d;
        };
    L_0x001d:
        r9 = 19;
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
            case 5: goto L_0x006b;
            default: goto L_0x003b;
        };
    L_0x003b:
        r3[r2] = r1;
        r2 = 1;
        r1 = "=\bP&Z";
        r0 = 0;
        r3 = r4;
        goto L_0x0008;
    L_0x0043:
        r3[r2] = r1;
        r2 = 2;
        r1 = "=\u001e@@P>\u0018<?X?\b&?r\u0018?z\u0001t";
        r0 = 1;
        r3 = r4;
        goto L_0x0008;
    L_0x004b:
        r3[r2] = r1;
        r2 = 3;
        r1 = "=\u001e@@V?\u0019<!|,:w\u000bz\u0012<";
        r0 = 2;
        r3 = r4;
        goto L_0x0008;
    L_0x0053:
        r3[r2] = r1;
        r2 = 4;
        r1 = "\t/uB+";
        r0 = 3;
        r3 = r4;
        goto L_0x0008;
    L_0x005b:
        r3[r2] = r1;
        r2 = 5;
        r1 = "=\u001e@@V?\u0019<?X?\b$?r\u0018?z\u0001t";
        r0 = 4;
        r3 = r4;
        goto L_0x0008;
    L_0x0063:
        r3[r2] = r1;
        r2 = 6;
        r1 = "6\u0018X?";
        r0 = 5;
        r3 = r4;
        goto L_0x0008;
    L_0x006b:
        r3[r2] = r1;
        z = r4;
        r0 = "";
        a = r0;
        r0 = 0;
        b = r0;
        return;
    L_0x0077:
        r9 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        goto L_0x001f;
    L_0x007a:
        r9 = 91;
        goto L_0x001f;
    L_0x007d:
        r9 = 19;
        goto L_0x001f;
    L_0x0080:
        r9 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.b.f.a.a.<clinit>():void");
    }

    public static String a() {
        return a;
    }

    private static String a(long j) {
        long j2;
        String valueOf = String.valueOf(j);
        int length = valueOf.length();
        if (length >= 2) {
            valueOf = valueOf.substring(length - 2, length);
        }
        switch (Integer.parseInt(valueOf) % 10) {
            case 1:
                j2 = (5 * j) + (j % 88);
                break;
            case 2:
                j2 = (23 * j) + (j % 15);
                break;
            case 3:
                j2 = (3 * j) + (j % 73);
                break;
            case 4:
                j2 = (13 * j) + (j % 96);
                break;
            case 5:
                j2 = (17 * j) + (j % 49);
                break;
            case 6:
                j2 = (7 * j) + (j % 68);
                break;
            case 7:
                j2 = (31 * j) + (j % 39);
                break;
            case 8:
                j2 = (29 * j) + (j % 41);
                break;
            case 9:
                j2 = (37 * j) + (j % 91);
                break;
            default:
                j2 = (8 * j) + (j % 74);
                break;
        }
        valueOf = cn.jiguang.e.a.a(new StringBuilder(z[6]).append(String.valueOf(j2)).toString());
        a = valueOf;
        return valueOf;
    }

    public static String a(String str, String str2) {
        if (str2.length() != 16) {
            return null;
        }
        byte[] c = c(str2, z[1]);
        Cipher instance = Cipher.getInstance(z[2]);
        instance.init(1, new SecretKeySpec(c, z[0]), a(c));
        return Base64.encodeToString(instance.doFinal(str.getBytes()), 2);
    }

    private static IvParameterSpec a(byte[] bArr) {
        try {
            return (IvParameterSpec) c.a(IvParameterSpec.class, new Object[]{bArr}, new Class[]{byte[].class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (InstantiationException e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static void a(int i) {
        b = i;
    }

    public static byte[] a(String str, byte[] bArr) {
        try {
            Key secretKeySpec = new SecretKeySpec(c(str, z[4]), z[0]);
            Cipher instance = Cipher.getInstance(z[3]);
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        byte[] bArr2;
        Exception e;
        int length = bArr.length - 24;
        Object obj = new byte[24];
        Object obj2 = new byte[length];
        System.arraycopy(bArr, 0, obj, 0, 24);
        System.arraycopy(bArr, 24, obj2, 0, length);
        String str = "";
        if (i == 1) {
            str = a(d.e(null));
        } else if (i == 0) {
            str = a((long) b);
        }
        try {
            Key secretKeySpec = new SecretKeySpec(c(str, z[4]), z[0]);
            Cipher instance = Cipher.getInstance(z[5]);
            instance.init(1, secretKeySpec);
            obj2 = instance.doFinal(obj2);
            int length2 = obj2.length + 24;
            bArr2 = new byte[length2];
            try {
                System.arraycopy(obj, 0, bArr2, 0, 24);
                System.arraycopy(obj2, 0, bArr2, 24, obj2.length);
                bArr2[0] = (byte) ((length2 >>> 8) & 255);
                bArr2[1] = (byte) (length2 & 255);
                bArr2[0] = (byte) (bArr2[0] | 128);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return bArr2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            bArr2 = null;
            e = exception;
            e.printStackTrace();
            return bArr2;
        }
        return bArr2;
    }

    public static String b(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            if (str2.length() != 16) {
                return null;
            }
            byte[] c = c(str2, z[1]);
            Cipher instance = Cipher.getInstance(z[2]);
            instance.init(2, new SecretKeySpec(c, z[0]), a(c));
            try {
                return new String(instance.doFinal(Base64.decode(str, 2)));
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private static byte[] c(String str, String str2) {
        Object obj = new byte[str.length()];
        Object bytes = str.substring(0, str.length() / 2).getBytes(str2);
        Object bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, obj, 0, bytes.length);
        System.arraycopy(bytes2, 0, obj, bytes.length, bytes2.length);
        return obj;
    }
}
