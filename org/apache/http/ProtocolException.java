package org.apache.http;

/* compiled from: TbsSdkJava */
public class ProtocolException extends HttpException {
    private static final long serialVersionUID = -2143571074341228994L;

    public ProtocolException(String str) {
        super(str);
    }

    public ProtocolException(String str, Throwable th) {
        super(str, th);
    }
}
