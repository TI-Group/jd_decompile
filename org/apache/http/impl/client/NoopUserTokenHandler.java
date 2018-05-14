package org.apache.http.impl.client;

import org.apache.http.annotation.Immutable;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.protocol.HttpContext;

@Immutable
/* compiled from: TbsSdkJava */
public class NoopUserTokenHandler implements UserTokenHandler {
    public static final NoopUserTokenHandler INSTANCE = new NoopUserTokenHandler();

    public Object getUserToken(HttpContext httpContext) {
        return null;
    }
}
