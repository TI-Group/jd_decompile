package cn.jiguang.d;

import android.text.TextUtils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, Field> a = new HashMap();
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
        r3 = 2;
        r2 = 1;
        r1 = 0;
        r0 = 4;
        r5 = new java.lang.String[r0];
        r4 = "\u000e+pxl3&y<*76f,*4,axh?c{-f6";
        r0 = -1;
        r6 = r5;
        r7 = r5;
        r5 = r1;
    L_0x000c:
        r4 = r4.toCharArray();
        r8 = r4.length;
        if (r8 > r2) goto L_0x0072;
    L_0x0013:
        r9 = r1;
    L_0x0014:
        r10 = r4;
        r11 = r9;
        r14 = r8;
        r8 = r4;
        r4 = r14;
    L_0x0019:
        r13 = r8[r9];
        r12 = r11 % 5;
        switch(r12) {
            case 0: goto L_0x0066;
            case 1: goto L_0x0069;
            case 2: goto L_0x006c;
            case 3: goto L_0x006f;
            default: goto L_0x0020;
        };
    L_0x0020:
        r12 = 10;
    L_0x0022:
        r12 = r12 ^ r13;
        r12 = (char) r12;
        r8[r9] = r12;
        r9 = r11 + 1;
        if (r4 != 0) goto L_0x002e;
    L_0x002a:
        r8 = r10;
        r11 = r9;
        r9 = r4;
        goto L_0x0019;
    L_0x002e:
        r8 = r4;
        r4 = r10;
    L_0x0030:
        if (r8 > r9) goto L_0x0014;
    L_0x0032:
        r8 = new java.lang.String;
        r8.<init>(r4);
        r4 = r8.intern();
        switch(r0) {
            case 0: goto L_0x0047;
            case 1: goto L_0x0050;
            case 2: goto L_0x005a;
            default: goto L_0x003e;
        };
    L_0x003e:
        r6[r5] = r4;
        r0 = "\u000e+pxl3&y<*4\"x=*76f,*4,axh?cw4k4(:=g*7l";
        r4 = r0;
        r5 = r2;
        r6 = r7;
        r0 = r1;
        goto L_0x000c;
    L_0x0047:
        r6[r5] = r4;
        r0 = "\b&s=x?-v=*.,5>c?/qx/)c|+*;.w1m/,`+*(&y9~35px~5c0+1z\"55k. }1d=cs1o6'5=r30a+*5-5,}5cz**7,g=*3.e4o7&{,o>c|6~?1s9i?0;";
        r4 = r0;
        r5 = r3;
        r6 = r7;
        r0 = r2;
        goto L_0x000c;
    L_0x0050:
        r6[r5] = r4;
        r4 = 3;
        r0 = "\u000e+pxi6\"f+*76f,*4,axh?c{-f6";
        r5 = r4;
        r6 = r7;
        r4 = r0;
        r0 = r3;
        goto L_0x000c;
    L_0x005a:
        r6[r5] = r4;
        z = r7;
        r0 = new java.util.HashMap;
        r0.<init>();
        a = r0;
        return;
    L_0x0066:
        r12 = 90;
        goto L_0x0022;
    L_0x0069:
        r12 = 67;
        goto L_0x0022;
    L_0x006c:
        r12 = 21;
        goto L_0x0022;
    L_0x006f:
        r12 = 88;
        goto L_0x0022;
    L_0x0072:
        r9 = r1;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.a.<clinit>():void");
    }

    public static Object a(Field field, Object obj) {
        e.a(field != null, z[0], new Object[0]);
        if (field.isAccessible()) {
            b.a((AccessibleObject) field);
        } else {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Field a(Class<?> cls, String str) {
        return a((Class) cls, str, true);
    }

    private static Field a(Class<?> cls, String str, boolean z) {
        e.a(cls != null, z[3], new Object[0]);
        e.a(!TextUtils.isEmpty(str), z[1], new Object[0]);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cls.toString()).append("#").append(str);
        String stringBuilder2 = stringBuilder.toString();
        synchronized (a) {
            Field field = (Field) a.get(stringBuilder2);
        }
        if (field == null) {
            Class cls2 = cls;
            while (cls2 != null) {
                try {
                    field = cls2.getDeclaredField(str);
                    if (!Modifier.isPublic(field.getModifiers())) {
                        field.setAccessible(true);
                    }
                    synchronized (a) {
                        a.put(stringBuilder2, field);
                    }
                    return field;
                } catch (NoSuchFieldException e) {
                    cls2 = cls2.getSuperclass();
                }
            }
            Object obj = null;
            for (Class field2 : d.a((Class) cls)) {
                try {
                    field = field2.getField(str);
                    e.a(obj == null, z[2], str, cls);
                    obj = field;
                } catch (NoSuchFieldException e2) {
                }
            }
            synchronized (a) {
                a.put(stringBuilder2, obj);
            }
            return obj;
        } else if (field.isAccessible()) {
            return field;
        } else {
            field.setAccessible(true);
            return field;
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        e.a(field != null, z[0], new Object[0]);
        if (field.isAccessible()) {
            b.a((AccessibleObject) field);
        } else {
            field.setAccessible(true);
        }
        field.set(obj, obj2);
    }
}
