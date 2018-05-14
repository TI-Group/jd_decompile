package org.apache.commons.lang;

import org.apache.commons.lang.exception.NestableRuntimeException;

/* compiled from: TbsSdkJava */
public class UnhandledException extends NestableRuntimeException {
    public UnhandledException(Throwable th) {
        super(th);
    }

    public UnhandledException(String str, Throwable th) {
        super(str, th);
    }
}
