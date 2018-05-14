package org.apache.http.impl.auth;

import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthenticationException;

@Immutable
/* compiled from: TbsSdkJava */
public class NTLMEngineException extends AuthenticationException {
    private static final long serialVersionUID = 6027981323731768824L;

    public NTLMEngineException(String str) {
        super(str);
    }

    public NTLMEngineException(String str, Throwable th) {
        super(str, th);
    }
}
