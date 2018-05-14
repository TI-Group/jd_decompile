package uk.co.chrisjenx.calligraphy;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TbsSdkJava */
class ReflectionUtils {
    private static final String TAG = ReflectionUtils.class.getSimpleName();

    ReflectionUtils() {
    }

    static Field getField(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    static Object getValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    static void setValue(Field field, Object obj, Object obj2) {
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
        }
    }

    static Method getMethod(Class cls, String str) {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    static void invokeMethod(Object obj, Method method, Object... objArr) {
        Throwable e;
        if (method != null) {
            try {
                method.invoke(obj, objArr);
            } catch (IllegalAccessException e2) {
                e = e2;
                Log.d(TAG, "Can't invoke method using reflection", e);
            } catch (InvocationTargetException e3) {
                e = e3;
                Log.d(TAG, "Can't invoke method using reflection", e);
            }
        }
    }
}
