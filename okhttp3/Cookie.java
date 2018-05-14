package okhttp3;

import cn.jiguang.net.HttpUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import org.apache.commons.lang.ClassUtils;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.SM;

/* compiled from: TbsSdkJava */
public final class Cookie {
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    /* compiled from: TbsSdkJava */
    public static final class Builder {
        String domain;
        long expiresAt = HttpDate.MAX_DATE;
        boolean hostOnly;
        boolean httpOnly;
        String name;
        String path = HttpUtils.PATHS_SEPARATOR;
        boolean persistent;
        boolean secure;
        String value;

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.name = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.value = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }

        public Builder expiresAt(long j) {
            long j2;
            long j3 = HttpDate.MAX_DATE;
            if (j <= 0) {
                j2 = Long.MIN_VALUE;
            } else {
                j2 = j;
            }
            if (j2 <= HttpDate.MAX_DATE) {
                j3 = j2;
            }
            this.expiresAt = j3;
            this.persistent = true;
            return this;
        }

        public Builder domain(String str) {
            return domain(str, false);
        }

        public Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        private Builder domain(String str, boolean z) {
            if (str == null) {
                throw new IllegalArgumentException("domain == null");
            }
            String domainToAscii = Util.domainToAscii(str);
            if (domainToAscii == null) {
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            this.domain = domainToAscii;
            this.hostOnly = z;
            return this;
        }

        public Builder path(String str) {
            if (str.startsWith(HttpUtils.PATHS_SEPARATOR)) {
                this.path = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Cookie build() {
            return new Cookie();
        }
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    private Cookie(Builder builder) {
        if (builder.name == null) {
            throw new IllegalArgumentException("builder.name == null");
        } else if (builder.value == null) {
            throw new IllegalArgumentException("builder.value == null");
        } else if (builder.domain == null) {
            throw new IllegalArgumentException("builder.domain == null");
        } else {
            this.name = builder.name;
            this.value = builder.value;
            this.expiresAt = builder.expiresAt;
            this.domain = builder.domain;
            this.path = builder.path;
            this.secure = builder.secure;
            this.httpOnly = builder.httpOnly;
            this.persistent = builder.persistent;
            this.hostOnly = builder.hostOnly;
        }
    }

    public String name() {
        return this.name;
    }

    public String value() {
        return this.value;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public String domain() {
        return this.domain;
    }

    public String path() {
        return this.path;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean secure() {
        return this.secure;
    }

    public boolean matches(HttpUrl httpUrl) {
        boolean equals;
        if (this.hostOnly) {
            equals = httpUrl.host().equals(this.domain);
        } else {
            equals = domainMatch(httpUrl, this.domain);
        }
        if (!equals || !pathMatch(httpUrl, this.path)) {
            return false;
        }
        if (!this.secure || httpUrl.isHttps()) {
            return true;
        }
        return false;
    }

    private static boolean domainMatch(HttpUrl httpUrl, String str) {
        String host = httpUrl.host();
        if (host.equals(str)) {
            return true;
        }
        if (host.endsWith(str) && host.charAt((host.length() - str.length()) - 1) == ClassUtils.PACKAGE_SEPARATOR_CHAR && !Util.verifyAsIpAddress(host)) {
            return true;
        }
        return false;
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (encodedPath.startsWith(str) && (str.endsWith(HttpUtils.PATHS_SEPARATOR) || encodedPath.charAt(str.length()) == '/')) {
            return true;
        }
        return false;
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    static Cookie parse(long j, HttpUrl httpUrl, String str) {
        int length = str.length();
        int delimiterOffset = Util.delimiterOffset(str, 0, length, ';');
        int delimiterOffset2 = Util.delimiterOffset(str, 0, delimiterOffset, '=');
        if (delimiterOffset2 == delimiterOffset) {
            return null;
        }
        String trimSubstring = Util.trimSubstring(str, 0, delimiterOffset2);
        if (trimSubstring.isEmpty()) {
            return null;
        }
        String substring;
        String trimSubstring2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
        long j2 = HttpDate.MAX_DATE;
        long j3 = -1;
        String str2 = null;
        String str3 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        delimiterOffset++;
        while (delimiterOffset < length) {
            long j4;
            int delimiterOffset3 = Util.delimiterOffset(str, delimiterOffset, length, ';');
            int delimiterOffset4 = Util.delimiterOffset(str, delimiterOffset, delimiterOffset3, '=');
            String trimSubstring3 = Util.trimSubstring(str, delimiterOffset, delimiterOffset4);
            String trimSubstring4 = delimiterOffset4 < delimiterOffset3 ? Util.trimSubstring(str, delimiterOffset4 + 1, delimiterOffset3) : "";
            if (trimSubstring3.equalsIgnoreCase(ClientCookie.EXPIRES_ATTR)) {
                try {
                    j2 = parseExpires(trimSubstring4, 0, trimSubstring4.length());
                    z4 = true;
                    trimSubstring4 = str2;
                    j4 = j2;
                } catch (IllegalArgumentException e) {
                    trimSubstring4 = str2;
                    j4 = j2;
                }
            } else {
                if (trimSubstring3.equalsIgnoreCase(ClientCookie.MAX_AGE_ATTR)) {
                    try {
                        j3 = parseMaxAge(trimSubstring4);
                        z4 = true;
                        trimSubstring4 = str2;
                        j4 = j2;
                    } catch (NumberFormatException e2) {
                        trimSubstring4 = str2;
                        j4 = j2;
                    }
                } else {
                    if (trimSubstring3.equalsIgnoreCase(ClientCookie.DOMAIN_ATTR)) {
                        try {
                            trimSubstring4 = parseDomain(trimSubstring4);
                            z3 = false;
                            j4 = j2;
                        } catch (IllegalArgumentException e3) {
                            trimSubstring4 = str2;
                            j4 = j2;
                        }
                    } else {
                        if (trimSubstring3.equalsIgnoreCase(ClientCookie.PATH_ATTR)) {
                            str3 = trimSubstring4;
                            trimSubstring4 = str2;
                            j4 = j2;
                        } else {
                            if (trimSubstring3.equalsIgnoreCase(ClientCookie.SECURE_ATTR)) {
                                z = true;
                                trimSubstring4 = str2;
                                j4 = j2;
                            } else {
                                if (trimSubstring3.equalsIgnoreCase("httponly")) {
                                    z2 = true;
                                    trimSubstring4 = str2;
                                    j4 = j2;
                                } else {
                                    trimSubstring4 = str2;
                                    j4 = j2;
                                }
                            }
                        }
                    }
                }
            }
            String str4 = trimSubstring4;
            delimiterOffset = delimiterOffset3 + 1;
            j2 = j4;
            str2 = str4;
        }
        if (j3 == Long.MIN_VALUE) {
            j3 = Long.MIN_VALUE;
        } else if (j3 != -1) {
            j3 = (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE) + j;
            if (j3 < j || j3 > HttpDate.MAX_DATE) {
                j3 = HttpDate.MAX_DATE;
            }
        } else {
            j3 = j2;
        }
        if (str2 == null) {
            str2 = httpUrl.host();
        } else if (!domainMatch(httpUrl, str2)) {
            return null;
        }
        if (str3 == null || !str3.startsWith(HttpUtils.PATHS_SEPARATOR)) {
            str3 = httpUrl.encodedPath();
            delimiterOffset = str3.lastIndexOf(47);
            substring = delimiterOffset != 0 ? str3.substring(0, delimiterOffset) : HttpUtils.PATHS_SEPARATOR;
        } else {
            substring = str3;
        }
        return new Cookie(trimSubstring, trimSubstring2, j3, str2, substring, z, z2, z3, z4);
    }

    private static long parseExpires(String str, int i, int i2) {
        int dateCharacterOffset = dateCharacterOffset(str, i, i2, false);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        Matcher matcher = TIME_PATTERN.matcher(str);
        while (dateCharacterOffset < i2) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i2, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i3 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
                i4 = Integer.parseInt(matcher.group(2));
                i5 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                i7 = MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i8 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                i8 = Integer.parseInt(matcher.group(1));
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i2, false);
        }
        if (i8 >= 70 && i8 <= 99) {
            i8 += 1900;
        }
        if (i8 >= 0 && i8 <= 69) {
            i8 += 2000;
        }
        if (i8 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i4 < 0 || i4 > 59) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 59) {
            throw new IllegalArgumentException();
        } else {
            Calendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i8);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i4);
            gregorianCalendar.set(13, i5);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            Object obj;
            char charAt = str.charAt(i3);
            Object obj2 = ((charAt >= ' ' || charAt == '\t') && charAt < '' && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) ? null : 1;
            if (z) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj2 == obj) {
                return i3;
            }
        }
        return i2;
    }

    private static long parseMaxAge(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            } else if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }
    }

    private static String parseDomain(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String domainToAscii = Util.domainToAscii(str);
        if (domainToAscii != null) {
            return domainToAscii;
        }
        throw new IllegalArgumentException();
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List values = headers.values(SM.SET_COOKIE);
        List list = null;
        int size = values.size();
        for (int i = 0; i < size; i++) {
            Cookie parse = parse(httpUrl, (String) values.get(i));
            if (parse != null) {
                List arrayList;
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = list;
                }
                arrayList.add(parse);
                list = arrayList;
            }
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append('=');
        stringBuilder.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            stringBuilder.append("; domain=").append(this.domain);
        }
        stringBuilder.append("; path=").append(this.path);
        if (this.secure) {
            stringBuilder.append("; secure");
        }
        if (this.httpOnly) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = (((((((((this.name.hashCode() + 527) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + ((int) (this.expiresAt ^ (this.expiresAt >>> 32)))) * 31;
        if (this.secure) {
            i = 0;
        } else {
            i = 1;
        }
        hashCode = (i + hashCode) * 31;
        if (this.httpOnly) {
            i = 0;
        } else {
            i = 1;
        }
        hashCode = (i + hashCode) * 31;
        if (this.persistent) {
            i = 0;
        } else {
            i = 1;
        }
        i = (i + hashCode) * 31;
        if (!this.hostOnly) {
            i2 = 1;
        }
        return i + i2;
    }
}
