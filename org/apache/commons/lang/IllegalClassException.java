package org.apache.commons.lang;

/* compiled from: TbsSdkJava */
public class IllegalClassException extends IllegalArgumentException {
    public IllegalClassException(Class cls, Class cls2) {
        super(new StringBuffer().append("Expected: ").append(safeGetClassName(cls)).append(", actual: ").append(safeGetClassName(cls2)).toString());
    }

    public IllegalClassException(String str) {
        super(str);
    }

    private static final String safeGetClassName(Class cls) {
        return cls == null ? null : cls.getName();
    }
}
