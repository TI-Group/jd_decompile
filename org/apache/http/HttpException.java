package org.apache.http;

/* compiled from: TbsSdkJava */
public class HttpException extends Exception {
    private static final long serialVersionUID = -5437299376222011036L;

    public HttpException(String str) {
        super(str);
    }

    public HttpException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
