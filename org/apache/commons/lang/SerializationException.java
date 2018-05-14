package org.apache.commons.lang;

import org.apache.commons.lang.exception.NestableRuntimeException;

/* compiled from: TbsSdkJava */
public class SerializationException extends NestableRuntimeException {
    public SerializationException(String str) {
        super(str);
    }

    public SerializationException(Throwable th) {
        super(th);
    }

    public SerializationException(String str, Throwable th) {
        super(str, th);
    }
}
