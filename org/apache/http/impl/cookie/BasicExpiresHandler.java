package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public class BasicExpiresHandler extends AbstractCookieAttributeHandler {
    private final String[] datepatterns;

    public BasicExpiresHandler(String[] strArr) {
        Args.notNull(strArr, "Array of date patterns");
        this.datepatterns = strArr;
    }

    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, SM.COOKIE);
        if (str == null) {
            throw new MalformedCookieException("Missing value for expires attribute");
        }
        Date parseDate = DateUtils.parseDate(str, this.datepatterns);
        if (parseDate == null) {
            throw new MalformedCookieException("Unable to parse expires attribute: " + str);
        }
        setCookie.setExpiryDate(parseDate);
    }
}
