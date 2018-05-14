package org.apache.http.client.utils;

import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
/* compiled from: TbsSdkJava */
public final class DateUtils {
    private static final String[] DEFAULT_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
    private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
    public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    /* compiled from: TbsSdkJava */
    static final class DateFormatHolder {
        private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = new ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>() {
            protected SoftReference<Map<String, SimpleDateFormat>> initialValue() {
                return new SoftReference(new HashMap());
            }
        };

        DateFormatHolder() {
        }

        public static SimpleDateFormat formatFor(String str) {
            Map map;
            Map map2 = (Map) ((SoftReference) THREADLOCAL_FORMATS.get()).get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                THREADLOCAL_FORMATS.set(new SoftReference(hashMap));
                map = hashMap;
            } else {
                map = map2;
            }
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) map.get(str);
            if (simpleDateFormat != null) {
                return simpleDateFormat;
            }
            simpleDateFormat = new SimpleDateFormat(str, Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            map.put(str, simpleDateFormat);
            return simpleDateFormat;
        }

        public static void clearThreadLocal() {
            THREADLOCAL_FORMATS.remove();
        }
    }

    static {
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(GMT);
        instance.set(2000, 0, 1, 0, 0, 0);
        instance.set(14, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = instance.getTime();
    }

    public static Date parseDate(String str) {
        return parseDate(str, null, null);
    }

    public static Date parseDate(String str, String[] strArr) {
        return parseDate(str, strArr, null);
    }

    public static Date parseDate(String str, String[] strArr, Date date) {
        Args.notNull(str, "Date value");
        if (strArr == null) {
            strArr = DEFAULT_PATTERNS;
        }
        if (date == null) {
            date = DEFAULT_TWO_DIGIT_YEAR_START;
        }
        if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1);
        }
        for (String formatFor : r6) {
            SimpleDateFormat formatFor2 = DateFormatHolder.formatFor(formatFor);
            formatFor2.set2DigitYearStart(date);
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = formatFor2.parse(str, parsePosition);
            if (parsePosition.getIndex() != 0) {
                return parse;
            }
        }
        return null;
    }

    public static String formatDate(Date date) {
        return formatDate(date, "EEE, dd MMM yyyy HH:mm:ss zzz");
    }

    public static String formatDate(Date date, String str) {
        Args.notNull(date, "Date");
        Args.notNull(str, "Pattern");
        return DateFormatHolder.formatFor(str).format(date);
    }

    public static void clearThreadLocal() {
        DateFormatHolder.clearThreadLocal();
    }

    private DateUtils() {
    }
}
