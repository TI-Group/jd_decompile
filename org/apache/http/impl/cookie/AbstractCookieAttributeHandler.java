package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

@Immutable
/* compiled from: TbsSdkJava */
public abstract class AbstractCookieAttributeHandler implements CookieAttributeHandler {
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        return true;
    }
}
