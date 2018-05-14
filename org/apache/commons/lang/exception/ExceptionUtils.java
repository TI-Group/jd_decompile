package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

/* compiled from: TbsSdkJava */
public class ExceptionUtils {
    private static String[] CAUSE_METHOD_NAMES = new String[]{"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested"};
    private static final Method THROWABLE_CAUSE_METHOD;
    static final String WRAPPED_MARKER = " [wrapped] ";
    static Class class$java$lang$Throwable;

    static {
        Method method = null;
        try {
            Class class$;
            if (class$java$lang$Throwable == null) {
                class$ = class$("java.lang.Throwable");
                class$java$lang$Throwable = class$;
            } else {
                class$ = class$java$lang$Throwable;
            }
            method = class$.getMethod("getCause", null);
        } catch (Exception e) {
        }
        THROWABLE_CAUSE_METHOD = method;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static void addCauseMethodName(String str) {
        if (StringUtils.isNotEmpty(str)) {
            List arrayList = new ArrayList(Arrays.asList(CAUSE_METHOD_NAMES));
            arrayList.add(str);
            CAUSE_METHOD_NAMES = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
    }

    public static Throwable getCause(Throwable th) {
        return getCause(th, CAUSE_METHOD_NAMES);
    }

    public static Throwable getCause(Throwable th, String[] strArr) {
        if (th == null) {
            return null;
        }
        Throwable causeUsingWellKnownTypes = getCauseUsingWellKnownTypes(th);
        if (causeUsingWellKnownTypes != null) {
            return causeUsingWellKnownTypes;
        }
        if (strArr == null) {
            strArr = CAUSE_METHOD_NAMES;
        }
        for (String str : strArr) {
            if (str != null) {
                causeUsingWellKnownTypes = getCauseUsingMethodName(th, str);
                if (causeUsingWellKnownTypes != null) {
                    break;
                }
            }
        }
        if (causeUsingWellKnownTypes == null) {
            return getCauseUsingFieldName(th, "detail");
        }
        return causeUsingWellKnownTypes;
    }

    public static Throwable getRootCause(Throwable th) {
        Throwable cause = getCause(th);
        if (cause != null) {
            Throwable th2 = cause;
            while (true) {
                th2 = getCause(th2);
                if (th2 == null) {
                    break;
                }
                cause = th2;
            }
        }
        return cause;
    }

    private static Throwable getCauseUsingWellKnownTypes(Throwable th) {
        if (th instanceof Nestable) {
            return ((Nestable) th).getCause();
        }
        if (th instanceof SQLException) {
            return ((SQLException) th).getNextException();
        }
        if (th instanceof InvocationTargetException) {
            return ((InvocationTargetException) th).getTargetException();
        }
        return null;
    }

    private static Throwable getCauseUsingMethodName(Throwable th, String str) {
        Method method;
        try {
            method = th.getClass().getMethod(str, null);
        } catch (NoSuchMethodException e) {
            method = null;
        } catch (SecurityException e2) {
            method = null;
        }
        if (method != null) {
            Class class$;
            if (class$java$lang$Throwable == null) {
                class$ = class$("java.lang.Throwable");
                class$java$lang$Throwable = class$;
            } else {
                class$ = class$java$lang$Throwable;
            }
            if (class$.isAssignableFrom(method.getReturnType())) {
                try {
                    return (Throwable) method.invoke(th, ArrayUtils.EMPTY_OBJECT_ARRAY);
                } catch (IllegalAccessException e3) {
                } catch (IllegalArgumentException e4) {
                } catch (InvocationTargetException e5) {
                }
            }
        }
        return null;
    }

    private static Throwable getCauseUsingFieldName(Throwable th, String str) {
        Field field;
        try {
            field = th.getClass().getField(str);
        } catch (NoSuchFieldException e) {
            field = null;
        } catch (SecurityException e2) {
            field = null;
        }
        if (field != null) {
            Class class$;
            if (class$java$lang$Throwable == null) {
                class$ = class$("java.lang.Throwable");
                class$java$lang$Throwable = class$;
            } else {
                class$ = class$java$lang$Throwable;
            }
            if (class$.isAssignableFrom(field.getType())) {
                try {
                    return (Throwable) field.get(th);
                } catch (IllegalAccessException e3) {
                } catch (IllegalArgumentException e4) {
                }
            }
        }
        return null;
    }

    public static boolean isThrowableNested() {
        return THROWABLE_CAUSE_METHOD != null;
    }

    public static boolean isNestedThrowable(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof Nestable) {
            return true;
        }
        if (th instanceof SQLException) {
            return true;
        }
        if (th instanceof InvocationTargetException) {
            return true;
        }
        if (isThrowableNested()) {
            return true;
        }
        Class cls = th.getClass();
        for (String method : CAUSE_METHOD_NAMES) {
            try {
                Method method2 = cls.getMethod(method, null);
                if (method2 == null) {
                    continue;
                } else {
                    Class class$;
                    if (class$java$lang$Throwable == null) {
                        class$ = class$("java.lang.Throwable");
                        class$java$lang$Throwable = class$;
                    } else {
                        class$ = class$java$lang$Throwable;
                    }
                    if (class$.isAssignableFrom(method2.getReturnType())) {
                        return true;
                    }
                }
            } catch (NoSuchMethodException e) {
            } catch (SecurityException e2) {
            }
        }
        try {
            if (cls.getField("detail") != null) {
                return true;
            }
            return false;
        } catch (NoSuchFieldException e3) {
            return false;
        } catch (SecurityException e4) {
            return false;
        }
    }

    public static int getThrowableCount(Throwable th) {
        int i = 0;
        while (th != null) {
            i++;
            th = getCause(th);
        }
        return i;
    }

    public static Throwable[] getThrowables(Throwable th) {
        List arrayList = new ArrayList();
        while (th != null) {
            arrayList.add(th);
            th = getCause(th);
        }
        return (Throwable[]) arrayList.toArray(new Throwable[arrayList.size()]);
    }

    public static int indexOfThrowable(Throwable th, Class cls) {
        return indexOfThrowable(th, cls, 0);
    }

    public static int indexOfThrowable(Throwable th, Class cls, int i) {
        if (th == null) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        Throwable[] throwables = getThrowables(th);
        if (i >= throwables.length) {
            return -1;
        }
        while (i < throwables.length) {
            if (throwables[i].getClass().equals(cls)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void printRootCauseStackTrace(Throwable th) {
        printRootCauseStackTrace(th, System.err);
    }

    public static void printRootCauseStackTrace(Throwable th, PrintStream printStream) {
        if (th != null) {
            if (printStream == null) {
                throw new IllegalArgumentException("The PrintStream must not be null");
            }
            String[] rootCauseStackTrace = getRootCauseStackTrace(th);
            for (String println : rootCauseStackTrace) {
                printStream.println(println);
            }
            printStream.flush();
        }
    }

    public static void printRootCauseStackTrace(Throwable th, PrintWriter printWriter) {
        if (th != null) {
            if (printWriter == null) {
                throw new IllegalArgumentException("The PrintWriter must not be null");
            }
            String[] rootCauseStackTrace = getRootCauseStackTrace(th);
            for (String println : rootCauseStackTrace) {
                printWriter.println(println);
            }
            printWriter.flush();
        }
    }

    public static String[] getRootCauseStackTrace(Throwable th) {
        if (th == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] throwables = getThrowables(th);
        int length = throwables.length;
        ArrayList arrayList = new ArrayList();
        List stackFrameList = getStackFrameList(throwables[length - 1]);
        int i = length;
        while (true) {
            int i2 = i - 1;
            if (i2 < 0) {
                return (String[]) arrayList.toArray(new String[0]);
            }
            List list;
            if (i2 != 0) {
                List stackFrameList2 = getStackFrameList(throwables[i2 - 1]);
                removeCommonFrames(stackFrameList, stackFrameList2);
                list = stackFrameList2;
            } else {
                list = stackFrameList;
            }
            if (i2 == length - 1) {
                arrayList.add(throwables[i2].toString());
            } else {
                arrayList.add(new StringBuffer().append(WRAPPED_MARKER).append(throwables[i2].toString()).toString());
            }
            for (i = 0; i < stackFrameList.size(); i++) {
                arrayList.add(stackFrameList.get(i));
            }
            i = i2;
            stackFrameList = list;
        }
    }

    public static void removeCommonFrames(List list, List list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int size = list2.size() - 1;
        for (int size2 = list.size() - 1; size2 >= 0 && size >= 0; size2--) {
            if (((String) list.get(size2)).equals((String) list2.get(size))) {
                list.remove(size2);
            }
            size--;
        }
    }

    public static String getStackTrace(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static String getFullStackTrace(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        Throwable[] throwables = getThrowables(th);
        for (int i = 0; i < throwables.length; i++) {
            throwables[i].printStackTrace(printWriter);
            if (isNestedThrowable(throwables[i])) {
                break;
            }
        }
        return stringWriter.getBuffer().toString();
    }

    public static String[] getStackFrames(Throwable th) {
        if (th == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return getStackFrames(getStackTrace(th));
    }

    static String[] getStackFrames(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, SystemUtils.LINE_SEPARATOR);
        List linkedList = new LinkedList();
        while (stringTokenizer.hasMoreTokens()) {
            linkedList.add(stringTokenizer.nextToken());
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    static List getStackFrameList(Throwable th) {
        StringTokenizer stringTokenizer = new StringTokenizer(getStackTrace(th), SystemUtils.LINE_SEPARATOR);
        List linkedList = new LinkedList();
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().length() == 0) {
                i = 1;
                linkedList.add(nextToken);
            } else if (i != 0) {
                break;
            }
        }
        return linkedList;
    }
}
