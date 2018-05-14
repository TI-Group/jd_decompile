package org.apache.commons.lang;

import java.util.Arrays;

/* compiled from: TbsSdkJava */
public class IncompleteArgumentException extends IllegalArgumentException {
    public IncompleteArgumentException(String str) {
        super(new StringBuffer().append(str).append(" is incomplete.").toString());
    }

    public IncompleteArgumentException(String str, String[] strArr) {
        super(new StringBuffer().append(str).append(" is missing the following items: ").append(safeArrayToString(strArr)).toString());
    }

    private static final String safeArrayToString(Object[] objArr) {
        return objArr == null ? null : Arrays.asList(objArr).toString();
    }
}
