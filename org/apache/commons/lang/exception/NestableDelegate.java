package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: TbsSdkJava */
public class NestableDelegate implements Serializable {
    private static final transient String MUST_BE_THROWABLE = "The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable";
    static Class class$org$apache$commons$lang$exception$Nestable;
    public static boolean topDown = true;
    public static boolean trimStackFrames = true;
    private Throwable nestable = null;

    public NestableDelegate(Nestable nestable) {
        if (nestable instanceof Throwable) {
            this.nestable = (Throwable) nestable;
            return;
        }
        throw new IllegalArgumentException(MUST_BE_THROWABLE);
    }

    public String getMessage(int i) {
        Class class$;
        Throwable throwable = getThrowable(i);
        if (class$org$apache$commons$lang$exception$Nestable == null) {
            class$ = class$("org.apache.commons.lang.exception.Nestable");
            class$org$apache$commons$lang$exception$Nestable = class$;
        } else {
            class$ = class$org$apache$commons$lang$exception$Nestable;
        }
        if (class$.isInstance(throwable)) {
            return ((Nestable) throwable).getMessage(0);
        }
        return throwable.getMessage();
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public String getMessage(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        Throwable cause = ExceptionUtils.getCause(this.nestable);
        if (cause != null) {
            String message = cause.getMessage();
            if (message != null) {
                if (str != null) {
                    stringBuffer.append(": ");
                }
                stringBuffer.append(message);
            }
        }
        return stringBuffer.length() > 0 ? stringBuffer.toString() : null;
    }

    public String[] getMessages() {
        Throwable[] throwables = getThrowables();
        String[] strArr = new String[throwables.length];
        for (int i = 0; i < throwables.length; i++) {
            Class class$;
            if (class$org$apache$commons$lang$exception$Nestable == null) {
                class$ = class$("org.apache.commons.lang.exception.Nestable");
                class$org$apache$commons$lang$exception$Nestable = class$;
            } else {
                class$ = class$org$apache$commons$lang$exception$Nestable;
            }
            strArr[i] = class$.isInstance(throwables[i]) ? ((Nestable) throwables[i]).getMessage(0) : throwables[i].getMessage();
        }
        return strArr;
    }

    public Throwable getThrowable(int i) {
        if (i == 0) {
            return this.nestable;
        }
        return getThrowables()[i];
    }

    public int getThrowableCount() {
        return ExceptionUtils.getThrowableCount(this.nestable);
    }

    public Throwable[] getThrowables() {
        return ExceptionUtils.getThrowables(this.nestable);
    }

    public int indexOfThrowable(Class cls, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("The start index was out of bounds: ").append(i).toString());
        }
        Throwable[] throwables = ExceptionUtils.getThrowables(this.nestable);
        if (i >= throwables.length) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("The start index was out of bounds: ").append(i).append(" >= ").append(throwables.length).toString());
        }
        while (i < throwables.length) {
            if (throwables[i].getClass().equals(cls)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter(printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        Throwable th = this.nestable;
        if (!ExceptionUtils.isThrowableNested()) {
            List arrayList = new ArrayList();
            while (th != null) {
                arrayList.add(getStackFrames(th));
                th = ExceptionUtils.getCause(th);
            }
            String str = "Caused by: ";
            if (!topDown) {
                str = "Rethrown as: ";
                Collections.reverse(arrayList);
            }
            String str2 = str;
            if (trimStackFrames) {
                trimStackFrames(arrayList);
            }
            synchronized (printWriter) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    for (String println : (String[]) it.next()) {
                        printWriter.println(println);
                    }
                    if (it.hasNext()) {
                        printWriter.print(str2);
                    }
                }
            }
        } else if (th instanceof Nestable) {
            ((Nestable) th).printPartialStackTrace(printWriter);
        } else {
            th.printStackTrace(printWriter);
        }
    }

    protected String[] getStackFrames(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        if (th instanceof Nestable) {
            ((Nestable) th).printPartialStackTrace(printWriter);
        } else {
            th.printStackTrace(printWriter);
        }
        return ExceptionUtils.getStackFrames(stringWriter.getBuffer().toString());
    }

    protected void trimStackFrames(List list) {
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            String[] strArr2 = (String[]) list.get(size - 1);
            List arrayList = new ArrayList(Arrays.asList(strArr));
            ExceptionUtils.removeCommonFrames(arrayList, new ArrayList(Arrays.asList(strArr2)));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                arrayList.add(new StringBuffer().append("\t... ").append(length).append(" more").toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
    }
}
