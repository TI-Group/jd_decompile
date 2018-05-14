package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.c.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class ByteBufferUtils {
    public static final int ERROR_CODE = 10000;
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
        r4 = 3;
        r3 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 5;
        r6 = new java.lang.String[r0];
        r5 = ">\u0005*\u0007\u0002n\u00009\u0000\u0006n\u0001*\u0006\b<D+\u0000\u0006-\u000f\f\u0006\u0006-\u0001b";
        r0 = -1;
        r7 = r6;
        r8 = r6;
        r6 = r1;
    L_0x000d:
        r5 = r5.toCharArray();
        r9 = r5.length;
        if (r9 > r2) goto L_0x0075;
    L_0x0014:
        r10 = r1;
    L_0x0015:
        r11 = r5;
        r12 = r10;
        r15 = r9;
        r9 = r5;
        r5 = r15;
    L_0x001a:
        r14 = r9[r10];
        r13 = r12 % 5;
        switch(r13) {
            case 0: goto L_0x0069;
            case 1: goto L_0x006c;
            case 2: goto L_0x006f;
            case 3: goto L_0x0072;
            default: goto L_0x0021;
        };
    L_0x0021:
        r13 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
    L_0x0023:
        r13 = r13 ^ r14;
        r13 = (char) r13;
        r9[r10] = r13;
        r10 = r12 + 1;
        if (r5 != 0) goto L_0x002f;
    L_0x002b:
        r9 = r11;
        r12 = r10;
        r10 = r5;
        goto L_0x001a;
    L_0x002f:
        r9 = r5;
        r5 = r11;
    L_0x0031:
        if (r9 > r10) goto L_0x0015;
    L_0x0033:
        r9 = new java.lang.String;
        r9.<init>(r5);
        r5 = r9.intern();
        switch(r0) {
            case 0: goto L_0x0048;
            case 1: goto L_0x0051;
            case 2: goto L_0x005a;
            case 3: goto L_0x0064;
            default: goto L_0x003f;
        };
    L_0x003f:
        r7[r6] = r5;
        r0 = ",\u001d,\u0011%;\u0002>\u0011\u0015n\r6\u0012\bt";
        r5 = r0;
        r6 = r2;
        r7 = r8;
        r0 = r1;
        goto L_0x000d;
    L_0x0048:
        r7[r6] = r5;
        r0 = ",\u001d,\u0011%;\u0002>\u0011\u0015n\r+T\t;\b4";
        r5 = r0;
        r6 = r3;
        r7 = r8;
        r0 = r2;
        goto L_0x000d;
    L_0x0051:
        r7[r6] = r5;
        r0 = "2\u0006!\u0000\u0002,\u0011>\u0012\u0002<^";
        r5 = r0;
        r6 = r4;
        r7 = r8;
        r0 = r3;
        goto L_0x000d;
    L_0x005a:
        r7[r6] = r5;
        r5 = 4;
        r0 = "\f\u001d,\u0011%;\u0002>\u0011\u0015\u001b\u00101\u0018\u0014";
        r6 = r5;
        r7 = r8;
        r5 = r0;
        r0 = r4;
        goto L_0x000d;
    L_0x0064:
        r7[r6] = r5;
        z = r8;
        return;
    L_0x0069:
        r13 = 78;
        goto L_0x0023;
    L_0x006c:
        r13 = 100;
        goto L_0x0023;
    L_0x006f:
        r13 = 88;
        goto L_0x0023;
    L_0x0072:
        r13 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
        goto L_0x0023;
    L_0x0075:
        r10 = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.<clinit>():void");
    }

    private static String a(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        StringBuilder stringBuilder = new StringBuilder();
        if (jResponse != null) {
            stringBuilder.append(jResponse.toString());
            stringBuilder.append(new StringBuilder(z[3]).append(byteBuffer == null ? z[2] : byteBuffer.toString()).toString());
        }
        d.j(z[4], new StringBuilder(z[1]).append(stringBuilder.toString()).toString());
        try {
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            d.j(z[4], new StringBuilder(z[0]).append(stringWriter.toString()).toString());
        } catch (Exception e) {
        }
        return stringBuilder.toString();
    }

    public static Byte get(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return Byte.valueOf(byteBuffer.get());
        } catch (BufferUnderflowException e) {
            a(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return null;
        } catch (BufferOverflowException e2) {
            a(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return null;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return null;
        }
    }

    public static ByteBuffer get(ByteBuffer byteBuffer, byte[] bArr, JResponse jResponse) {
        try {
            return byteBuffer.get(bArr);
        } catch (BufferUnderflowException e) {
            a(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return null;
        } catch (BufferOverflowException e2) {
            a(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return null;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return null;
        }
    }

    public static int getInt(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getInt();
        } catch (BufferUnderflowException e) {
            a(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return -1;
        } catch (BufferOverflowException e2) {
            a(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return -1;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return -1;
        }
    }

    public static long getLong(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getLong();
        } catch (BufferUnderflowException e) {
            a(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return 0;
        } catch (BufferOverflowException e2) {
            a(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return 0;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return 0;
        }
    }

    public static short getShort(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getShort();
        } catch (BufferUnderflowException e) {
            a(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return (short) -1;
        } catch (BufferOverflowException e2) {
            a(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return (short) -1;
        } catch (Exception e3) {
            a(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse != null) {
                jResponse.code = 10000;
            }
            return (short) -1;
        }
    }
}
