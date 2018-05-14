package org.apache.commons.lang.enum;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

/* compiled from: TbsSdkJava */
public abstract class Enum implements Serializable, Comparable {
    private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
    private static final Map cEnumClasses = new HashMap();
    static Class class$org$apache$commons$lang$enum$Enum = null;
    static Class class$org$apache$commons$lang$enum$ValuedEnum = null;
    private static final long serialVersionUID = -487045951170455942L;
    private final transient int iHashCode;
    private final String iName;
    protected transient String iToString = null;

    /* compiled from: TbsSdkJava */
    /* renamed from: org.apache.commons.lang.enum.Enum$1 */
    static class AnonymousClass1 {
    }

    /* compiled from: TbsSdkJava */
    private static class Entry {
        final List list;
        final Map map;
        final List unmodifiableList;
        final Map unmodifiableMap;

        Entry(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Entry() {
            this.map = new HashMap();
            this.unmodifiableMap = Collections.unmodifiableMap(this.map);
            this.list = new ArrayList(25);
            this.unmodifiableList = Collections.unmodifiableList(this.list);
        }
    }

    protected Enum(String str) {
        init(str);
        this.iName = str;
        this.iHashCode = (getEnumClass().hashCode() + 7) + (str.hashCode() * 3);
    }

    private void init(String str) {
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The Enum name must not be empty or null");
        }
        Class enumClass = getEnumClass();
        if (enumClass == null) {
            throw new IllegalArgumentException("getEnumClass() must not be null");
        }
        Object obj = null;
        Class cls = getClass();
        while (cls != null) {
            Class class$;
            if (class$org$apache$commons$lang$enum$Enum == null) {
                class$ = class$("org.apache.commons.lang.enum.Enum");
                class$org$apache$commons$lang$enum$Enum = class$;
            } else {
                class$ = class$org$apache$commons$lang$enum$Enum;
            }
            if (cls == class$) {
                break;
            }
            if (class$org$apache$commons$lang$enum$ValuedEnum == null) {
                class$ = class$("org.apache.commons.lang.enum.ValuedEnum");
                class$org$apache$commons$lang$enum$ValuedEnum = class$;
            } else {
                class$ = class$org$apache$commons$lang$enum$ValuedEnum;
            }
            if (cls == class$) {
                break;
            } else if (cls == enumClass) {
                obj = 1;
                break;
            } else {
                cls = cls.getSuperclass();
            }
        }
        if (obj == null) {
            throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
        }
        Entry entry = (Entry) cEnumClasses.get(enumClass);
        if (entry == null) {
            entry = createEntry(enumClass);
            cEnumClasses.put(enumClass, entry);
        }
        if (entry.map.containsKey(str)) {
            throw new IllegalArgumentException(new StringBuffer().append("The Enum name must be unique, '").append(str).append("' has already been added").toString());
        }
        entry.map.put(str, this);
        entry.list.add(this);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    protected Object readResolve() {
        Entry entry = (Entry) cEnumClasses.get(getEnumClass());
        if (entry == null) {
            return null;
        }
        return (Enum) entry.map.get(getName());
    }

    protected static Enum getEnum(Class cls, String str) {
        Entry entry = getEntry(cls);
        if (entry == null) {
            return null;
        }
        return (Enum) entry.map.get(str);
    }

    protected static Map getEnumMap(Class cls) {
        Entry entry = getEntry(cls);
        if (entry == null) {
            return EMPTY_MAP;
        }
        return entry.unmodifiableMap;
    }

    protected static List getEnumList(Class cls) {
        Entry entry = getEntry(cls);
        if (entry == null) {
            return Collections.EMPTY_LIST;
        }
        return entry.unmodifiableList;
    }

    protected static Iterator iterator(Class cls) {
        return getEnumList(cls).iterator();
    }

    private static Entry getEntry(Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException("The Enum Class must not be null");
        }
        Class class$;
        if (class$org$apache$commons$lang$enum$Enum == null) {
            class$ = class$("org.apache.commons.lang.enum.Enum");
            class$org$apache$commons$lang$enum$Enum = class$;
        } else {
            class$ = class$org$apache$commons$lang$enum$Enum;
        }
        if (class$.isAssignableFrom(cls)) {
            return (Entry) cEnumClasses.get(cls);
        }
        throw new IllegalArgumentException("The Class must be a subclass of Enum");
    }

    private static Entry createEntry(Class cls) {
        Entry entry = new Entry(null);
        Class superclass = cls.getSuperclass();
        while (superclass != null) {
            Class class$;
            if (class$org$apache$commons$lang$enum$Enum == null) {
                class$ = class$("org.apache.commons.lang.enum.Enum");
                class$org$apache$commons$lang$enum$Enum = class$;
            } else {
                class$ = class$org$apache$commons$lang$enum$Enum;
            }
            if (superclass != class$) {
                if (class$org$apache$commons$lang$enum$ValuedEnum == null) {
                    class$ = class$("org.apache.commons.lang.enum.ValuedEnum");
                    class$org$apache$commons$lang$enum$ValuedEnum = class$;
                } else {
                    class$ = class$org$apache$commons$lang$enum$ValuedEnum;
                }
                if (superclass == class$) {
                    break;
                }
                Entry entry2 = (Entry) cEnumClasses.get(superclass);
                if (entry2 != null) {
                    entry.list.addAll(entry2.list);
                    entry.map.putAll(entry2.map);
                    break;
                }
                superclass = superclass.getSuperclass();
            } else {
                break;
            }
        }
        return entry;
    }

    public final String getName() {
        return this.iName;
    }

    public Class getEnumClass() {
        return getClass();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == getClass()) {
            return this.iName.equals(((Enum) obj).iName);
        }
        if (!((Enum) obj).getEnumClass().getName().equals(getEnumClass().getName())) {
            return false;
        }
        try {
            return this.iName.equals(((Enum) obj).iName);
        } catch (ClassCastException e) {
            try {
                return this.iName.equals((String) obj.getClass().getMethod("getName", null).invoke(obj, null));
            } catch (NoSuchMethodException e2) {
                return false;
            } catch (IllegalAccessException e3) {
                return false;
            } catch (InvocationTargetException e4) {
                return false;
            }
        }
    }

    public final int hashCode() {
        return this.iHashCode;
    }

    public int compareTo(Object obj) {
        if (obj == this) {
            return 0;
        }
        return this.iName.compareTo(((Enum) obj).iName);
    }

    public String toString() {
        if (this.iToString == null) {
            this.iToString = new StringBuffer().append(ClassUtils.getShortClassName(getEnumClass())).append("[").append(getName()).append("]").toString();
        }
        return this.iToString;
    }
}
