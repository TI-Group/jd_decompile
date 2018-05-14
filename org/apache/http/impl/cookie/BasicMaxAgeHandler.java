package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.Immutable;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class BasicMaxAgeHandler extends AbstractCookieAttributeHandler {
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, SM.COOKIE);
        if (str == null) {
            throw new MalformedCookieException("Missing value for max-age attribute");
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0) {
                throw new MalformedCookieException("Negative max-age attribute: " + str);
            }
            setCookie.setExpiryDate(new Date(System.currentTimeMillis() + (((long) parseInt) * 1000)));
        } catch (NumberFormatException e) {
            throw new MalformedCookieException("Invalid max-age attribute: " + str);
        }
    }
}
