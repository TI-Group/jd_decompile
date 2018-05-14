package org.apache.http;

/* compiled from: TbsSdkJava */
public class MethodNotSupportedException extends HttpException {
    private static final long serialVersionUID = 3365359036840171201L;

    public MethodNotSupportedException(String str) {
        super(str);
    }

    public MethodNotSupportedException(String str, Throwable th) {
        super(str, th);
    }
}
