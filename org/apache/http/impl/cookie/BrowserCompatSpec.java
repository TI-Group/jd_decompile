package org.apache.http.impl.cookie;

import cn.jiguang.net.HttpUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory.SecurityLevel;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class BrowserCompatSpec extends CookieSpecBase {
    private static final String[] DEFAULT_DATE_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};
    private final String[] datepatterns;

    public BrowserCompatSpec(String[] strArr, SecurityLevel securityLevel) {
        if (strArr != null) {
            this.datepatterns = (String[]) strArr.clone();
        } else {
            this.datepatterns = DEFAULT_DATE_PATTERNS;
        }
        switch (securityLevel) {
            case SECURITYLEVEL_DEFAULT:
                registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
                break;
            case SECURITYLEVEL_IE_MEDIUM:
                registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler() {
                    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
                    }
                });
                break;
            default:
                throw new RuntimeException("Unknown security level");
        }
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new BasicDomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(this.datepatterns));
        registerAttribHandler("version", new BrowserCompatVersionAttributeHandler());
    }

    public BrowserCompatSpec(String[] strArr) {
        this(strArr, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpec() {
        this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (header.getName().equalsIgnoreCase(SM.SET_COOKIE)) {
            HeaderElement[] headerElementArr;
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
                headerElementArr = new HeaderElement[]{netscapeDraftHeaderParser.parseHeader(buffer, parserCursor)};
            } else {
                headerElementArr = elements;
            }
            return parse(headerElementArr, cookieOrigin);
        }
        throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
    }

    private static boolean isQuoteEnclosed(String str) {
        return str != null && str.startsWith("\"") && str.endsWith("\"");
    }

    public List<Header> formatCookies(List<Cookie> list) {
        Args.notEmpty((Collection) list, "List of cookies");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(list.size() * 20);
        charArrayBuffer.append(SM.COOKIE);
        charArrayBuffer.append(": ");
        for (int i = 0; i < list.size(); i++) {
            Cookie cookie = (Cookie) list.get(i);
            if (i > 0) {
                charArrayBuffer.append("; ");
            }
            String name = cookie.getName();
            String value = cookie.getValue();
            if (cookie.getVersion() <= 0 || isQuoteEnclosed(value)) {
                charArrayBuffer.append(name);
                charArrayBuffer.append(HttpUtils.EQUAL_SIGN);
                if (value != null) {
                    charArrayBuffer.append(value);
                }
            } else {
                BasicHeaderValueFormatter.INSTANCE.formatHeaderElement(charArrayBuffer, new BasicHeaderElement(name, value), false);
            }
        }
        List<Header> arrayList = new ArrayList(1);
        arrayList.add(new BufferedHeader(charArrayBuffer));
        return arrayList;
    }

    public int getVersion() {
        return 0;
    }

    public Header getVersionHeader() {
        return null;
    }

    public String toString() {
        return "compatibility";
    }
}
