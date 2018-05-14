package org.apache.http.auth;

import org.apache.http.annotation.Immutable;

@Immutable
/* compiled from: TbsSdkJava */
public class InvalidCredentialsException extends AuthenticationException {
    private static final long serialVersionUID = -4834003835215460648L;

    public InvalidCredentialsException(String str) {
        super(str);
    }

    public InvalidCredentialsException(String str, Throwable th) {
        super(str, th);
    }
}
