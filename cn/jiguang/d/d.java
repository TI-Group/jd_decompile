package cn.jiguang.d;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public final class d {
    static final Object[] a = new Object[0];
    static final Class<?>[] b = new Class[0];

    public static List<Class<?>> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        HashSet linkedHashSet = new LinkedHashSet();
        a((Class) cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    private static void a(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class superclass;
        while (superclass != null) {
            for (Class cls2 : superclass.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    a(cls2, (HashSet) hashSet);
                }
            }
            superclass = superclass.getSuperclass();
        }
    }

    static boolean a(Object[] objArr, Object[] objArr2) {
        return (objArr != null || objArr2 == null || objArr2.length <= 0) && ((objArr2 != null || objArr == null || objArr.length <= 0) && (objArr == null || objArr2 == null || objArr.length == objArr2.length));
    }

    static Class<?>[] a(Class<?>[] clsArr) {
        return (clsArr == null || clsArr.length == 0) ? b : clsArr;
    }

    static Class<?>[] a(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return b;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i] == null ? null : objArr[i].getClass();
        }
        return clsArr;
    }

    static Object[] b(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? a : objArr;
    }
}
