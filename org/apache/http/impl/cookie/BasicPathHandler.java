package org.apache.http.impl.cookie;

import cn.jiguang.net.HttpUtils;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

@Immutable
/* compiled from: TbsSdkJava */
public class BasicPathHandler implements CookieAttributeHandler {
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, SM.COOKIE);
        if (TextUtils.isBlank(str)) {
            str = HttpUtils.PATHS_SEPARATOR;
        }
        setCookie.setPath(str);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        if (!match(cookie, cookieOrigin)) {
            throw new CookieRestrictionViolationException("Illegal path attribute \"" + cookie.getPath() + "\". Path of origin: \"" + cookieOrigin.getPath() + "\"");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, SM.COOKIE);
        Args.notNull(cookieOrigin, "Cookie origin");
        String path = cookieOrigin.getPath();
        String path2 = cookie.getPath();
        if (path2 == null) {
            path2 = HttpUtils.PATHS_SEPARATOR;
        }
        if (path2.length() > 1 && path2.endsWith(HttpUtils.PATHS_SEPARATOR)) {
            path2 = path2.substring(0, path2.length() - 1);
        }
        boolean startsWith = path.startsWith(path2);
        if (!startsWith || path.length() == path2.length() || path2.endsWith(HttpUtils.PATHS_SEPARATOR)) {
            return startsWith;
        }
        if (path.charAt(path2.length()) == '/') {
            return true;
        }
        return false;
    }
}
