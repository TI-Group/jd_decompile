package org.apache.http.impl.cookie;

import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class BrowserCompatVersionAttributeHandler extends AbstractCookieAttributeHandler {
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, SM.COOKIE);
        if (str == null) {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }
        setCookie.setVersion(i);
    }
}
