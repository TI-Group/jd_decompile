package org.apache.commons.lang.time;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: TbsSdkJava */
public class DateFormatUtils {
    public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
    public static final FastDateFormat ISO_DATETIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ssZZ");
    public static final FastDateFormat ISO_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");
    public static final FastDateFormat ISO_DATE_TIME_ZONE_FORMAT = FastDateFormat.getInstance("yyyy-MM-ddZZ");
    public static final FastDateFormat ISO_TIME_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ss");
    public static final FastDateFormat ISO_TIME_NO_T_FORMAT = FastDateFormat.getInstance("HH:mm:ss");
    public static final FastDateFormat ISO_TIME_NO_T_TIME_ZONE_FORMAT = FastDateFormat.getInstance("HH:mm:ssZZ");
    public static final FastDateFormat ISO_TIME_TIME_ZONE_FORMAT = FastDateFormat.getInstance("'T'HH:mm:ssZZ");
    public static final FastDateFormat SMTP_DATETIME_FORMAT = FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);

    public static String formatUTC(long j, String str) {
        return format(new Date(j), str, DateUtils.UTC_TIME_ZONE, null);
    }

    public static String formatUTC(Date date, String str) {
        return format(date, str, DateUtils.UTC_TIME_ZONE, null);
    }

    public static String formatUTC(long j, String str, Locale locale) {
        return format(new Date(j), str, DateUtils.UTC_TIME_ZONE, locale);
    }

    public static String formatUTC(Date date, String str, Locale locale) {
        return format(date, str, DateUtils.UTC_TIME_ZONE, locale);
    }

    public static String format(long j, String str) {
        return format(new Date(j), str, null, null);
    }

    public static String format(Date date, String str) {
        return format(date, str, null, null);
    }

    public static String format(long j, String str, TimeZone timeZone) {
        return format(new Date(j), str, timeZone, null);
    }

    public static String format(Date date, String str, TimeZone timeZone) {
        return format(date, str, timeZone, null);
    }

    public static String format(long j, String str, Locale locale) {
        return format(new Date(j), str, null, locale);
    }

    public static String format(Date date, String str, Locale locale) {
        return format(date, str, null, locale);
    }

    public static String format(long j, String str, TimeZone timeZone, Locale locale) {
        return format(new Date(j), str, timeZone, locale);
    }

    public static String format(Date date, String str, TimeZone timeZone, Locale locale) {
        return FastDateFormat.getInstance(str, timeZone, locale).format(date);
    }
}
