package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class RFC2965VersionAttributeHandler implements CookieAttributeHandler {
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, SM.COOKIE);
        if (str == null) {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        int parseInt;
        try {
            parseInt = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            parseInt = -1;
        }
        if (parseInt < 0) {
            throw new MalformedCookieException("Invalid cookie version.");
        }
        setCookie.setVersion(parseInt);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, SM.COOKIE);
        if ((cookie instanceof SetCookie2) && (cookie instanceof ClientCookie) && !((ClientCookie) cookie).containsAttribute("version")) {
            throw new CookieRestrictionViolationException("Violates RFC 2965. Version attribute is required.");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        return true;
    }
}
