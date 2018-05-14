package org.apache.http.impl.cookie;

import java.util.Locale;
import org.apache.commons.lang.ClassUtils;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class RFC2965DomainAttributeHandler implements CookieAttributeHandler {
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, SM.COOKIE);
        if (str == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        } else if (str.trim().length() == 0) {
            throw new MalformedCookieException("Blank value for domain attribute");
        } else {
            String toLowerCase = str.toLowerCase(Locale.ENGLISH);
            if (!str.startsWith(".")) {
                toLowerCase = ClassUtils.PACKAGE_SEPARATOR_CHAR + toLowerCase;
            }
            setCookie.setDomain(toLowerCase);
        }
    }

    public boolean domainMatch(String str, String str2) {
        return str.equals(str2) || (str2.startsWith(".") && str.endsWith(str2));
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, SM.COOKIE);
        Args.notNull(cookieOrigin, "Cookie origin");
        String toLowerCase = cookieOrigin.getHost().toLowerCase(Locale.ENGLISH);
        if (cookie.getDomain() == null) {
            throw new CookieRestrictionViolationException("Invalid cookie state: domain not specified");
        }
        String toLowerCase2 = cookie.getDomain().toLowerCase(Locale.ENGLISH);
        if ((cookie instanceof ClientCookie) && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR)) {
            if (toLowerCase2.startsWith(".")) {
                int indexOf = toLowerCase2.indexOf(46, 1);
                if ((indexOf < 0 || indexOf == toLowerCase2.length() - 1) && !toLowerCase2.equals(".local")) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
                } else if (!domainMatch(toLowerCase, toLowerCase2)) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
                } else if (toLowerCase.substring(0, toLowerCase.length() - toLowerCase2.length()).indexOf(46) != -1) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
                } else {
                    return;
                }
            }
            throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
        } else if (!cookie.getDomain().equals(toLowerCase)) {
            throw new CookieRestrictionViolationException("Illegal domain attribute: \"" + cookie.getDomain() + "\"." + "Domain of origin: \"" + toLowerCase + "\"");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, SM.COOKIE);
        Args.notNull(cookieOrigin, "Cookie origin");
        String toLowerCase = cookieOrigin.getHost().toLowerCase(Locale.ENGLISH);
        String domain = cookie.getDomain();
        if (domainMatch(toLowerCase, domain) && toLowerCase.substring(0, toLowerCase.length() - domain.length()).indexOf(46) == -1) {
            return true;
        }
        return false;
    }
}
