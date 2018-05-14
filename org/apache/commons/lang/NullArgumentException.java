package org.apache.commons.lang;

/* compiled from: TbsSdkJava */
public class NullArgumentException extends IllegalArgumentException {
    public NullArgumentException(String str) {
        super(new StringBuffer().append(str).append(" must not be null.").toString());
    }
}
