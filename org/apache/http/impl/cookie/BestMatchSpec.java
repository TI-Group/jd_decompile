package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BestMatchSpec implements CookieSpec {
    private BrowserCompatSpec compat;
    private final String[] datepatterns;
    private RFC2109Spec obsoleteStrict;
    private final boolean oneHeader;
    private RFC2965Spec strict;

    public BestMatchSpec(String[] strArr, boolean z) {
        this.datepatterns = strArr == null ? null : (String[]) strArr.clone();
        this.oneHeader = z;
    }

    public BestMatchSpec() {
        this(null, false);
    }

    private RFC2965Spec getStrict() {
        if (this.strict == null) {
            this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        }
        return this.strict;
    }

    private RFC2109Spec getObsoleteStrict() {
        if (this.obsoleteStrict == null) {
            this.obsoleteStrict = new RFC2109Spec(this.datepatterns, this.oneHeader);
        }
        return this.obsoleteStrict;
    }

    private BrowserCompatSpec getCompat() {
        if (this.compat == null) {
            this.compat = new BrowserCompatSpec(this.datepatterns);
        }
        return this.compat;
    }

    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        HeaderElement[] elements = header.getElements();
        int i = 0;
        int i2 = 0;
        for (HeaderElement headerElement : elements) {
            if (headerElement.getParameterByName("version") != null) {
                i2 = 1;
            }
            if (headerElement.getParameterByName(ClientCookie.EXPIRES_ATTR) != null) {
                i = 1;
            }
        }
        if (i != 0 || r0 == 0) {
            CharArrayBuffer buffer;
            ParserCursor parserCursor;
            NetscapeDraftHeaderParser netscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
            if (header instanceof FormattedHeader) {
                buffer = ((FormattedHeader) header).getBuffer();
                parserCursor = new ParserCursor(((FormattedHeader) header).getValuePos(), buffer.length());
            } else {
                String value = header.getValue();
                if (value == null) {
                    throw new MalformedCookieException("Header value is null");
                }
                buffer = new CharArrayBuffer(value.length());
                buffer.append(value);
                parserCursor = new ParserCursor(0, buffer.length());
            }
            return getCompat().parse(new HeaderElement[]{netscapeDraftHeaderParser.parseHeader(buffer, parserCursor)}, cookieOrigin);
        } else if (SM.SET_COOKIE2.equals(header.getName())) {
            return getStrict().parse(elements, cookieOrigin);
        } else {
            return getObsoleteStrict().parse(elements, cookieOrigin);
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, SM.COOKIE);
        Args.notNull(cookieOrigin, "Cookie origin");
        if (cookie.getVersion() <= 0) {
            getCompat().validate(cookie, cookieOrigin);
        } else if (cookie instanceof SetCookie2) {
            getStrict().validate(cookie, cookieOrigin);
        } else {
            getObsoleteStrict().validate(cookie, cookieOrigin);
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, SM.COOKIE);
        Args.notNull(cookieOrigin, "Cookie origin");
        if (cookie.getVersion() <= 0) {
            return getCompat().match(cookie, cookieOrigin);
        }
        if (cookie instanceof SetCookie2) {
            return getStrict().match(cookie, cookieOrigin);
        }
        return getObsoleteStrict().match(cookie, cookieOrigin);
    }

    public List<Header> formatCookies(List<Cookie> list) {
        Args.notNull(list, "List of cookies");
        int i = Integer.MAX_VALUE;
        Object obj = 1;
        for (Cookie cookie : list) {
            int version;
            if (!(cookie instanceof SetCookie2)) {
                obj = null;
            }
            if (cookie.getVersion() < i) {
                version = cookie.getVersion();
            } else {
                version = i;
            }
            i = version;
        }
        if (i <= 0) {
            return getCompat().formatCookies(list);
        }
        if (obj != null) {
            return getStrict().formatCookies(list);
        }
        return getObsoleteStrict().formatCookies(list);
    }

    public int getVersion() {
        return getStrict().getVersion();
    }

    public Header getVersionHeader() {
        return getStrict().getVersionHeader();
    }

    public String toString() {
        return "best-match";
    }
}
