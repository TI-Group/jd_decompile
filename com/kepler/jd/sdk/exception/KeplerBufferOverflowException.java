package com.kepler.jd.sdk.exception;

/* compiled from: TbsSdkJava */
public class KeplerBufferOverflowException extends Exception {
    private static final long serialVersionUID = 1;

    public KeplerBufferOverflowException(String str, Throwable th) {
        super(str, th);
    }

    public KeplerBufferOverflowException(String str) {
        super(str);
    }

    public KeplerBufferOverflowException(Throwable th) {
        super(th);
    }
}
