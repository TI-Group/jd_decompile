package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* compiled from: TbsSdkJava */
public class ReflectionToStringBuilder extends ToStringBuilder {
    private static ThreadLocal registry = new ThreadLocal() {
        protected synchronized Object initialValue() {
            return new HashSet();
        }
    };
    private boolean appendTransients = false;
    private Class upToClass = null;

    static Set getRegistry() {
        return (Set) registry.get();
    }

    static boolean isRegistered(Object obj) {
        return getRegistry().contains(obj);
    }

    static void register(Object obj) {
        getRegistry().add(obj);
    }

    public static String toString(Object obj) {
        return toString(obj, null, false, null);
    }

    public static String toString(Object obj, ToStringStyle toStringStyle) {
        return toString(obj, toStringStyle, false, null);
    }

    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z) {
        return toString(obj, toStringStyle, z, null);
    }

    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z, Class cls) {
        return new ReflectionToStringBuilder(obj, toStringStyle, null, cls, z).toString();
    }

    static void unregister(Object obj) {
        getRegistry().remove(obj);
    }

    public ReflectionToStringBuilder(Object obj) {
        super(obj);
    }

    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        super(obj, toStringStyle);
    }

    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        super(obj, toStringStyle, stringBuffer);
    }

    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class cls, boolean z) {
        super(obj, toStringStyle, stringBuffer);
        setUpToClass(cls);
        setAppendTransients(z);
    }

    protected boolean accept(Field field) {
        return field.getName().indexOf(36) == -1 && ((isAppendTransients() || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()));
    }

    protected void appendFieldsIn(Class cls) {
        if (isRegistered(getObject())) {
            appendAsObjectToString(getObject());
            return;
        }
        try {
            registerObject();
            if (cls.isArray()) {
                reflectionAppendArray(getObject());
                unregisterObject();
                return;
            }
            AccessibleObject[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                String name = field.getName();
                if (accept(field)) {
                    Object value = getValue(field);
                    if (!isRegistered(value) || field.getType().isPrimitive()) {
                        registerObject();
                        append(name, value);
                        unregisterObject();
                    } else {
                        getStyle().appendFieldStart(getStringBuffer(), name);
                        appendAsObjectToString(value);
                    }
                }
            }
            unregisterObject();
        } catch (Throwable e) {
            throw new InternalError(new StringBuffer().append("Unexpected IllegalAccessException: ").append(e.getMessage()).toString());
        } catch (Throwable th) {
            unregisterObject();
        }
    }

    public Class getUpToClass() {
        return this.upToClass;
    }

    protected Object getValue(Field field) throws IllegalArgumentException, IllegalAccessException {
        return field.get(getObject());
    }

    public boolean isAppendTransients() {
        return this.appendTransients;
    }

    public ToStringBuilder reflectionAppendArray(Object obj) {
        getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, obj);
        return this;
    }

    void registerObject() {
        register(getObject());
    }

    public void setAppendTransients(boolean z) {
        this.appendTransients = z;
    }

    public void setUpToClass(Class cls) {
        this.upToClass = cls;
    }

    public String toString() {
        if (getObject() == null) {
            return getStyle().getNullText();
        }
        Class cls = getObject().getClass();
        appendFieldsIn(cls);
        while (cls.getSuperclass() != null && cls != getUpToClass()) {
            cls = cls.getSuperclass();
            appendFieldsIn(cls);
        }
        return super.toString();
    }

    void unregisterObject() {
        unregister(getObject());
    }
}
