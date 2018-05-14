package cn.jiguang.d;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<String, Method> a = new HashMap();
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
        r1 = 0;
        r2 = 1;
        r0 = 5;
        r6 = new java.lang.String[r0];
        r5 = "\u0002-oaT\u00137bfO\u0013bbsN\u000f-u2B\u0004bogL\r";
        r0 = -1;
        r7 = r6;
        r8 = r6;
        r6 = r1;
    L_0x000d:
        r5 = r5.toCharArray();
        r9 = r5.length;
        if (r9 > r2) goto L_0x007b;
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
            case 0: goto L_0x0070;
            case 1: goto L_0x0073;
            case 2: goto L_0x0076;
            case 3: goto L_0x0078;
            default: goto L_0x0021;
        };
    L_0x0021:
        r13 = 32;
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
        r0 = "\u0002.`aSA!`|N\u000e6!pEA,t~L";
        r5 = r0;
        r6 = r2;
        r7 = r8;
        r0 = r1;
        goto L_0x000d;
    L_0x0048:
        r7[r6] = r5;
        r0 = "/-!aU\u0002*!sC\u0002'raI\u0003.d2M\u00046i}D[b";
        r5 = r0;
        r6 = r3;
        r7 = r8;
        r0 = r2;
        goto L_0x000d;
    L_0x0051:
        r7[r6] = r5;
        r0 = "Ik!}NA-cxE\u00026;2";
        r5 = r0;
        r6 = r4;
        r7 = r8;
        r0 = r3;
        goto L_0x000d;
    L_0x005a:
        r7[r6] = r5;
        r5 = 4;
        r0 = "/-!aU\u0002*!sC\u0002'raI\u0003.d2C\u000e,rfR\u0014!u}RA-o2O\u0003(dqT[b";
        r6 = r5;
        r7 = r8;
        r5 = r0;
        r0 = r4;
        goto L_0x000d;
    L_0x0064:
        r7[r6] = r5;
        z = r8;
        r0 = new java.util.HashMap;
        r0.<init>();
        a = r0;
        return;
    L_0x0070:
        r13 = 97;
        goto L_0x0023;
    L_0x0073:
        r13 = 66;
        goto L_0x0023;
    L_0x0076:
        r13 = r2;
        goto L_0x0023;
    L_0x0078:
        r13 = 18;
        goto L_0x0023;
    L_0x007b:
        r10 = r1;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.c.<clinit>():void");
    }

    public static Object a(Class cls, String str, Object... objArr) {
        Object[] b = d.b(objArr);
        Class[] a = d.a(d.a(b));
        b = d.b(b);
        Method c = c(cls, str, a);
        if (c != null) {
            return c.invoke(null, b);
        }
        throw new NoSuchMethodException(new StringBuilder(z[2]).append(str).append(z[3]).append(cls.getName()).toString());
    }

    public static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        Object[] b = d.b(objArr);
        Constructor a = a(cls, d.a((Class[]) clsArr));
        if (a != null) {
            return a.newInstance(b);
        }
        throw new NoSuchMethodException(new StringBuilder(z[4]).append(cls.getName()).toString());
    }

    private static <T> Constructor<T> a(Class<T> cls, Class<?>... clsArr) {
        e.a(cls != null, z[1], new Object[0]);
        try {
            AccessibleObject constructor = cls.getConstructor(clsArr);
            b.a(constructor);
            return constructor;
        } catch (NoSuchMethodException e) {
            Constructor<T> constructor2 = null;
            for (Member member : cls.getConstructors()) {
                if (b.a((Class[]) clsArr, member.getParameterTypes(), true)) {
                    AccessibleObject accessibleObject;
                    e.a(member != null, z[0], new Object[0]);
                    if (b.a(member)) {
                        int i;
                        for (Class declaringClass = member.getDeclaringClass(); declaringClass != null; declaringClass = declaringClass.getEnclosingClass()) {
                            if (!Modifier.isPublic(declaringClass.getModifiers())) {
                                i = 0;
                                break;
                            }
                        }
                        boolean z = true;
                        if (i != 0) {
                            accessibleObject = member;
                            if (accessibleObject != null) {
                                b.a(accessibleObject);
                                if (constructor2 != null || b.a(accessibleObject.getParameterTypes(), constructor2.getParameterTypes(), (Class[]) clsArr) < 0) {
                                    constructor2 = accessibleObject;
                                }
                            }
                        }
                    }
                    accessibleObject = null;
                    if (accessibleObject != null) {
                        b.a(accessibleObject);
                        if (constructor2 != null) {
                        }
                        constructor2 = accessibleObject;
                    }
                }
            }
            return constructor2;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        Class superclass = cls.getSuperclass();
        while (superclass != null) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    method = superclass.getMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e) {
                }
            } else {
                superclass = superclass.getSuperclass();
            }
        }
        return method;
    }

    private static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        Class superclass;
        while (superclass != null) {
            Class[] interfaces = superclass.getInterfaces();
            int i = 0;
            while (i < interfaces.length) {
                if (Modifier.isPublic(interfaces[i].getModifiers())) {
                    try {
                        return interfaces[i].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException e) {
                        Method b = b(interfaces[i], str, clsArr);
                        if (b != null) {
                            return b;
                        }
                    }
                } else {
                    i++;
                }
            }
            superclass = superclass.getSuperclass();
        }
        return null;
    }

    private static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cls.toString()).append("#").append(str);
        if (clsArr == null || clsArr.length <= 0) {
            stringBuilder.append(Void.class.toString());
        } else {
            for (Class cls2 : clsArr) {
                stringBuilder.append(cls2.toString()).append("#");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        synchronized (a) {
            method = (Method) a.get(stringBuilder2);
        }
        if (method == null) {
            AccessibleObject method2;
            try {
                method2 = cls.getMethod(str, clsArr);
                b.a(method2);
                synchronized (a) {
                    a.put(stringBuilder2, method2);
                }
            } catch (NoSuchMethodException e) {
                method = null;
                for (Method method3 : cls.getMethods()) {
                    Method method32;
                    if (method32.getName().equals(str) && b.a((Class[]) clsArr, method32.getParameterTypes(), true)) {
                        if (b.a((Member) method32)) {
                            Class declaringClass = method32.getDeclaringClass();
                            if (!Modifier.isPublic(declaringClass.getModifiers())) {
                                String name = method32.getName();
                                Class[] parameterTypes = method32.getParameterTypes();
                                method32 = b(declaringClass, name, parameterTypes);
                                if (method32 == null) {
                                    method32 = a(declaringClass, name, parameterTypes);
                                }
                            }
                        } else {
                            method32 = null;
                        }
                        if (method32 != null && (method2 == null || b.a(method32.getParameterTypes(), method2.getParameterTypes(), (Class[]) clsArr) < 0)) {
                            method = method32;
                        }
                    }
                }
                if (method2 != null) {
                    b.a(method2);
                }
                synchronized (a) {
                    a.put(stringBuilder2, method2);
                }
            }
        } else if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        return method;
    }
}
