package cn.jiguang.e;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public final class j {
    private static String a = z[1];
    private static final String[] z;

    static {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = 0;
        r2 = 1;
        r0 = 3;
        r4 = new java.lang.String[r0];
        r3 = "\u000b\u0011D";
        r0 = -1;
        r5 = r4;
        r6 = r4;
        r4 = r1;
    L_0x000b:
        r3 = r3.toCharArray();
        r7 = r3.length;
        if (r7 > r2) goto L_0x0067;
    L_0x0012:
        r8 = r1;
    L_0x0013:
        r9 = r3;
        r10 = r8;
        r13 = r7;
        r7 = r3;
        r3 = r13;
    L_0x0018:
        r12 = r7[r8];
        r11 = r10 % 5;
        switch(r11) {
            case 0: goto L_0x005b;
            case 1: goto L_0x005e;
            case 2: goto L_0x0061;
            case 3: goto L_0x0064;
            default: goto L_0x001f;
        };
    L_0x001f:
        r11 = 18;
    L_0x0021:
        r11 = r11 ^ r12;
        r11 = (char) r11;
        r7[r8] = r11;
        r8 = r10 + 1;
        if (r3 != 0) goto L_0x002d;
    L_0x0029:
        r7 = r9;
        r10 = r8;
        r8 = r3;
        goto L_0x0018;
    L_0x002d:
        r7 = r3;
        r3 = r9;
    L_0x002f:
        if (r7 > r8) goto L_0x0013;
    L_0x0031:
        r7 = new java.lang.String;
        r7.<init>(r3);
        r3 = r7.intern();
        switch(r0) {
            case 0: goto L_0x0046;
            case 1: goto L_0x0050;
            default: goto L_0x003d;
        };
    L_0x003d:
        r5[r4] = r3;
        r0 = "vdC\u001d&scF\u0016+\u0007\u00172jW\u0000";
        r3 = r0;
        r4 = r2;
        r5 = r6;
        r0 = r1;
        goto L_0x000b;
    L_0x0046:
        r5[r4] = r3;
        r3 = 2;
        r0 = "\u001d\u000b-Y1b\u0015-\u0003丒k鿰,\u0005";
        r4 = r3;
        r5 = r6;
        r3 = r0;
        r0 = r2;
        goto L_0x000b;
    L_0x0050:
        r5[r4] = r3;
        z = r6;
        r0 = z;
        r0 = r0[r2];
        a = r0;
        return;
    L_0x005b:
        r11 = 70;
        goto L_0x0021;
    L_0x005e:
        r11 = 85;
        goto L_0x0021;
    L_0x0061:
        r11 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        goto L_0x0021;
    L_0x0064:
        r11 = 46;
        goto L_0x0021;
    L_0x0067:
        r8 = r1;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.e.j.<clinit>():void");
    }

    public static CharSequence a(CharSequence charSequence, int i) {
        return (i < 0 || i >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i);
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            a(stringBuffer, a);
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append(z[1].charAt((b >> 4) & 15)).append(z[1].charAt(b & 15));
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static boolean a(String str, String str2) {
        return (str == null || str2 == null) ? false : str.equals(str2);
    }

    public static String b(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(z[0]);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
            for (byte a : digest) {
                a(stringBuffer, a);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String c(String str) {
        return a(str) ? "" : Pattern.compile(z[2]).matcher(str).replaceAll("");
    }

    public static boolean d(String str) {
        return !a(str);
    }

    public static boolean e(String str) {
        return !a(str);
    }
}
