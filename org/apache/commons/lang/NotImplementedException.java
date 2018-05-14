package org.apache.commons.lang;

/* compiled from: TbsSdkJava */
public class NotImplementedException extends UnsupportedOperationException {
    public NotImplementedException(Class cls) {
        super(new StringBuffer().append("Method is not implemented in class ").append(cls == null ? null : cls.getName()).toString());
    }

    public NotImplementedException(String str) {
        super(str);
    }
}
