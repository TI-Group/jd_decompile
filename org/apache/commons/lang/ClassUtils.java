package org.apache.commons.lang;

import java.util.ArrayList;
import java.util.List;

/* compiled from: TbsSdkJava */
public class ClassUtils {
    public static final String INNER_CLASS_SEPARATOR = String.valueOf(INNER_CLASS_SEPARATOR_CHAR);
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final String PACKAGE_SEPARATOR = String.valueOf(PACKAGE_SEPARATOR_CHAR);
    public static final char PACKAGE_SEPARATOR_CHAR = '.';

    public static String getShortClassName(Object obj, String str) {
        return obj == null ? str : getShortClassName(obj.getClass().getName());
    }

    public static String getShortClassName(Class cls) {
        if (cls != null) {
            return getShortClassName(cls.getName());
        }
        throw new IllegalArgumentException("The class must not be null");
    }

    public static String getShortClassName(String str) {
        int i = 0;
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The class name must not be empty");
        }
        char[] toCharArray = str.toCharArray();
        int i2 = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] == PACKAGE_SEPARATOR_CHAR) {
                i2 = i + 1;
            } else if (toCharArray[i] == INNER_CLASS_SEPARATOR_CHAR) {
                toCharArray[i] = PACKAGE_SEPARATOR_CHAR;
            }
            i++;
        }
        return new String(toCharArray, i2, toCharArray.length - i2);
    }

    public static String getPackageName(Object obj, String str) {
        return obj == null ? str : getPackageName(obj.getClass().getName());
    }

    public static String getPackageName(Class cls) {
        if (cls != null) {
            return getPackageName(cls.getName());
        }
        throw new IllegalArgumentException("The class must not be null");
    }

    public static String getPackageName(String str) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The class name must not be empty");
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    public static List getAllSuperclasses(Class cls) {
        if (cls == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        return arrayList;
    }

    public static List getAllInterfaces(Class cls) {
        if (cls == null) {
            return null;
        }
        List arrayList = new ArrayList();
        while (cls != null) {
            Class[] interfaces = cls.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (!arrayList.contains(interfaces[i])) {
                    arrayList.add(interfaces[i]);
                }
                for (Class cls2 : getAllInterfaces(interfaces[i])) {
                    if (!arrayList.contains(cls2)) {
                        arrayList.add(cls2);
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static List convertClassNamesToClasses(List list) {
        if (list == null) {
            return null;
        }
        List arrayList = new ArrayList(list.size());
        for (String cls : list) {
            try {
                arrayList.add(Class.forName(cls));
            } catch (Exception e) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public static List convertClassesToClassNames(List list) {
        if (list == null) {
            return null;
        }
        List arrayList = new ArrayList(list.size());
        for (Class cls : list) {
            if (cls == null) {
                arrayList.add(null);
            } else {
                arrayList.add(cls.getName());
            }
        }
        return arrayList;
    }

    public static boolean isAssignable(Class[] clsArr, Class[] clsArr2) {
        if (!ArrayUtils.isSameLength((Object[]) clsArr, (Object[]) clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (clsArr2 == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!isAssignable(clsArr[i], clsArr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAssignable(Class cls, Class cls2) {
        boolean z = true;
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            if (cls2.isPrimitive()) {
                z = false;
            }
            return z;
        } else if (cls.equals(cls2)) {
            return true;
        } else {
            if (!cls.isPrimitive()) {
                return cls2.isAssignableFrom(cls);
            }
            if (!cls2.isPrimitive()) {
                return false;
            }
            if (Integer.TYPE.equals(cls)) {
                if (Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    return true;
                }
                return false;
            } else if (Long.TYPE.equals(cls)) {
                if (Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                    return true;
                }
                return false;
            } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                return false;
            } else {
                if (Float.TYPE.equals(cls)) {
                    return Double.TYPE.equals(cls2);
                }
                if (Character.TYPE.equals(cls)) {
                    if (Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                        return true;
                    }
                    return false;
                } else if (Short.TYPE.equals(cls)) {
                    if (Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                        return true;
                    }
                    return false;
                } else if (!Byte.TYPE.equals(cls)) {
                    return false;
                } else {
                    if (Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2)) {
                        return true;
                    }
                    return false;
                }
            }
        }
    }

    public static boolean isInnerClass(Class cls) {
        if (cls != null && cls.getName().indexOf(36) >= 0) {
            return true;
        }
        return false;
    }
}
