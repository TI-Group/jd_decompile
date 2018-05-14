package org.apache.http.cookie;

import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class MalformedCookieException extends ProtocolException {
    private static final long serialVersionUID = -6695462944287282185L;

    public MalformedCookieException(String str) {
        super(str);
    }

    public MalformedCookieException(String str, Throwable th) {
        super(str, th);
    }
}
