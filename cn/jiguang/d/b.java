package cn.jiguang.d;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

final class b {
    private static final Class<?>[] a = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
    private static final Map<Class<?>, Class<?>> b;
    private static final Map<Class<?>, Class<?>> c = new HashMap();

    static {
        Map hashMap = new HashMap();
        b = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        b.put(Byte.TYPE, Byte.class);
        b.put(Character.TYPE, Character.class);
        b.put(Short.TYPE, Short.class);
        b.put(Integer.TYPE, Integer.class);
        b.put(Long.TYPE, Long.class);
        b.put(Double.TYPE, Double.class);
        b.put(Float.TYPE, Float.class);
        b.put(Void.TYPE, Void.TYPE);
        for (Class cls : b.keySet()) {
            Class cls2 = (Class) b.get(cls);
            if (!cls.equals(cls2)) {
                c.put(cls2, cls);
            }
        }
    }

    private static float a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f = 0.0f;
        for (int i = 0; i < clsArr.length; i++) {
            float f2;
            Class cls = clsArr[i];
            Class cls2 = clsArr2[i];
            if (cls2.isPrimitive()) {
                if (cls.isPrimitive()) {
                    f2 = 0.0f;
                } else {
                    cls = a(cls);
                    f2 = 0.1f;
                }
                int i2 = 0;
                while (cls != cls2 && i2 < a.length) {
                    if (cls == a[i2]) {
                        f2 += 0.1f;
                        if (i2 < a.length - 1) {
                            cls = a[i2 + 1];
                        }
                    }
                    i2++;
                }
            } else {
                Class cls3 = cls;
                float f3 = 0.0f;
                while (cls3 != null && !cls2.equals(cls3)) {
                    if (cls2.isInterface() && a(cls3, cls2, true)) {
                        f3 += 0.25f;
                        break;
                    }
                    f3 += 1.0f;
                    cls3 = cls3.getSuperclass();
                }
                if (cls3 == null) {
                    f3 += 1.5f;
                }
                f2 = f3;
            }
            f += f2;
        }
        return f;
    }

    static int a(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float a = a(clsArr3, clsArr);
        float a2 = a(clsArr3, clsArr2);
        return a < a2 ? -1 : a2 < a ? 1 : 0;
    }

    private static Class<?> a(Class<?> cls) {
        return (Class) c.get(cls);
    }

    private static boolean a(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        } else {
            Class cls3;
            if (z) {
                if (cls.isPrimitive() && !cls2.isPrimitive()) {
                    if (cls != null && cls.isPrimitive()) {
                        cls3 = (Class) b.get(cls);
                    }
                    if (cls3 == null) {
                        return false;
                    }
                }
                if (cls2.isPrimitive() && !cls3.isPrimitive()) {
                    cls3 = a(cls3);
                    if (cls3 == null) {
                        return false;
                    }
                }
            }
            return cls3.equals(cls2) ? true : cls3.isPrimitive() ? !cls2.isPrimitive() ? false : Integer.TYPE.equals(cls3) ? Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2) : Long.TYPE.equals(cls3) ? Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2) : Boolean.TYPE.equals(cls3) ? false : Double.TYPE.equals(cls3) ? false : Float.TYPE.equals(cls3) ? Double.TYPE.equals(cls2) : Character.TYPE.equals(cls3) ? Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2) : Short.TYPE.equals(cls3) ? Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2) : Byte.TYPE.equals(cls3) ? Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2) : false : cls2.isAssignableFrom(cls3);
        }
    }

    static boolean a(AccessibleObject accessibleObject) {
        if (accessibleObject == null || accessibleObject.isAccessible()) {
            return false;
        }
        Member member = (Member) accessibleObject;
        if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers())) {
            if (((member.getDeclaringClass().getModifiers() & 7) == 0 ? 1 : null) != null) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException e) {
                }
            }
        }
        return false;
    }

    static boolean a(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!d.a((Object[]) clsArr, (Object[]) clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = d.b;
        }
        if (clsArr2 == null) {
            clsArr2 = d.b;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!a(clsArr[i], clsArr2[i], true)) {
                return false;
            }
        }
        return true;
    }
}
