package org.apache.http.impl.execchain;

import java.io.InterruptedIOException;
import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class RequestAbortedException extends InterruptedIOException {
    private static final long serialVersionUID = 4973849966012490112L;

    public RequestAbortedException(String str) {
        super(str);
    }

    public RequestAbortedException(String str, Throwable th) {
        super(str);
        if (th != null) {
            initCause(th);
        }
    }
}
