package org.apache.commons.lang.time;

import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: TbsSdkJava */
public class FastDateFormat extends Format {
    public static final int FULL = 0;
    static final double LOG_10 = Math.log(10.0d);
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static Map cDateInstanceCache = new HashMap(7);
    private static Map cDateTimeInstanceCache = new HashMap(7);
    private static String cDefaultPattern;
    private static Map cInstanceCache = new HashMap(7);
    private static Map cTimeInstanceCache = new HashMap(7);
    private static Map cTimeZoneDisplayCache = new HashMap(7);
    private final Locale mLocale;
    private final boolean mLocaleForced;
    private int mMaxLengthEstimate;
    private final String mPattern;
    private Rule[] mRules;
    private final TimeZone mTimeZone;
    private final boolean mTimeZoneForced;

    /* compiled from: TbsSdkJava */
    private interface Rule {
        void appendTo(StringBuffer stringBuffer, Calendar calendar);

        int estimateLength();
    }

    /* compiled from: TbsSdkJava */
    private static class CharacterLiteral implements Rule {
        private final char mValue;

        CharacterLiteral(char c) {
            this.mValue = c;
        }

        public int estimateLength() {
            return 1;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }
    }

    /* compiled from: TbsSdkJava */
    private interface NumberRule extends Rule {
        void appendTo(StringBuffer stringBuffer, int i);
    }

    /* compiled from: TbsSdkJava */
    private static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        PaddedNumberField(int i, int i2) {
            if (i2 < 3) {
                throw new IllegalArgumentException();
            }
            this.mField = i;
            this.mSize = i2;
        }

        public int estimateLength() {
            return 4;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            int i2;
            if (i < 100) {
                i2 = this.mSize;
                while (true) {
                    i2--;
                    if (i2 >= 2) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append((char) ((i / 10) + 48));
                        stringBuffer.append((char) ((i % 10) + 48));
                        return;
                    }
                }
            }
            if (i < 1000) {
                i2 = 3;
            } else {
                i2 = ((int) (Math.log((double) i) / FastDateFormat.LOG_10)) + 1;
            }
            int i3 = this.mSize;
            while (true) {
                i3--;
                if (i3 >= i2) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append(Integer.toString(i));
                    return;
                }
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private static class Pair {
        private final Object mObj1;
        private final Object mObj2;

        public Pair(Object obj, Object obj2) {
            this.mObj1 = obj;
            this.mObj2 = obj2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
            r4 = this;
            r0 = 1;
            r1 = 0;
            if (r4 != r5) goto L_0x0005;
        L_0x0004:
            return r0;
        L_0x0005:
            r2 = r5 instanceof org.apache.commons.lang.time.FastDateFormat.Pair;
            if (r2 != 0) goto L_0x000b;
        L_0x0009:
            r0 = r1;
            goto L_0x0004;
        L_0x000b:
            r5 = (org.apache.commons.lang.time.FastDateFormat.Pair) r5;
            r2 = r4.mObj1;
            if (r2 != 0) goto L_0x001f;
        L_0x0011:
            r2 = r5.mObj1;
            if (r2 != 0) goto L_0x001d;
        L_0x0015:
            r2 = r4.mObj2;
            if (r2 != 0) goto L_0x002a;
        L_0x0019:
            r2 = r5.mObj2;
            if (r2 == 0) goto L_0x0004;
        L_0x001d:
            r0 = r1;
            goto L_0x0004;
        L_0x001f:
            r2 = r4.mObj1;
            r3 = r5.mObj1;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x001d;
        L_0x0029:
            goto L_0x0015;
        L_0x002a:
            r2 = r4.mObj2;
            r3 = r5.mObj2;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x001d;
        L_0x0034:
            goto L_0x0004;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.time.FastDateFormat.Pair.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.mObj1 == null ? 0 : this.mObj1.hashCode();
            if (this.mObj2 != null) {
                i = this.mObj2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return new StringBuffer().append("[").append(this.mObj1).append(':').append(this.mObj2).append(']').toString();
        }
    }

    /* compiled from: TbsSdkJava */
    private static class StringLiteral implements Rule {
        private final String mValue;

        StringLiteral(String str) {
            this.mValue = str;
        }

        public int estimateLength() {
            return this.mValue.length();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValue);
        }
    }

    /* compiled from: TbsSdkJava */
    private static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        TextField(int i, String[] strArr) {
            this.mField = i;
            this.mValues = strArr;
        }

        public int estimateLength() {
            int i = 0;
            int length = this.mValues.length;
            while (true) {
                int i2 = length - 1;
                if (i2 < 0) {
                    return i;
                }
                length = this.mValues[i2].length();
                if (length <= i) {
                    length = i;
                }
                i = length;
                length = i2;
            }
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            stringBuffer.append(this.mValues[calendar.get(this.mField)]);
        }
    }

    /* compiled from: TbsSdkJava */
    private static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        TimeZoneDisplayKey(TimeZone timeZone, boolean z, int i, Locale locale) {
            this.mTimeZone = timeZone;
            if (z) {
                i |= Integer.MIN_VALUE;
            }
            this.mStyle = i;
            this.mLocale = locale;
        }

        public int hashCode() {
            return (this.mStyle * 31) + this.mLocale.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            if (this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: TbsSdkJava */
    private static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;
        private final TimeZone mTimeZone;
        private final boolean mTimeZoneForced;

        TimeZoneNameRule(TimeZone timeZone, boolean z, Locale locale, int i) {
            this.mTimeZone = timeZone;
            this.mTimeZoneForced = z;
            this.mLocale = locale;
            this.mStyle = i;
            if (z) {
                this.mStandard = FastDateFormat.getTimeZoneDisplay(timeZone, false, i, locale);
                this.mDaylight = FastDateFormat.getTimeZoneDisplay(timeZone, true, i, locale);
                return;
            }
            this.mStandard = null;
            this.mDaylight = null;
        }

        public int estimateLength() {
            if (this.mTimeZoneForced) {
                return Math.max(this.mStandard.length(), this.mDaylight.length());
            }
            if (this.mStyle == 0) {
                return 4;
            }
            return 40;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            if (!this.mTimeZoneForced) {
                TimeZone timeZone = calendar.getTimeZone();
                if (!timeZone.useDaylightTime() || calendar.get(16) == 0) {
                    stringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
                } else {
                    stringBuffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
                }
            } else if (!this.mTimeZone.useDaylightTime() || calendar.get(16) == 0) {
                stringBuffer.append(this.mStandard);
            } else {
                stringBuffer.append(this.mDaylight);
            }
        }
    }

    /* compiled from: TbsSdkJava */
    private static class TimeZoneNumberRule implements Rule {
        static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        final boolean mColon;

        TimeZoneNumberRule(boolean z) {
            this.mColon = z;
        }

        public int estimateLength() {
            return 5;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(15) + calendar.get(16);
            if (i < 0) {
                stringBuffer.append('-');
                i = -i;
            } else {
                stringBuffer.append('+');
            }
            int i2 = i / DateUtils.MILLIS_IN_HOUR;
            stringBuffer.append((char) ((i2 / 10) + 48));
            stringBuffer.append((char) ((i2 % 10) + 48));
            if (this.mColon) {
                stringBuffer.append(':');
            }
            i = (i / DateUtils.MILLIS_IN_MINUTE) - (i2 * 60);
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    /* compiled from: TbsSdkJava */
    private static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(10);
            if (i == 0) {
                i = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(stringBuffer, i);
        }

        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }
    }

    /* compiled from: TbsSdkJava */
    private static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            int i = calendar.get(11);
            if (i == 0) {
                i = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(stringBuffer, i);
        }

        public void appendTo(StringBuffer stringBuffer, int i) {
            this.mRule.appendTo(stringBuffer, i);
        }
    }

    /* compiled from: TbsSdkJava */
    private static class TwoDigitMonthField implements NumberRule {
        static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        TwoDigitMonthField() {
        }

        public int estimateLength() {
            return 2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    /* compiled from: TbsSdkJava */
    private static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        TwoDigitNumberField(int i) {
            this.mField = i;
        }

        public int estimateLength() {
            return 2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 100) {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
                return;
            }
            stringBuffer.append(Integer.toString(i));
        }
    }

    /* compiled from: TbsSdkJava */
    private static class TwoDigitYearField implements NumberRule {
        static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        TwoDigitYearField() {
        }

        public int estimateLength() {
            return 2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(1) % 100);
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    /* compiled from: TbsSdkJava */
    private static class UnpaddedMonthField implements NumberRule {
        static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        UnpaddedMonthField() {
        }

        public int estimateLength() {
            return 2;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(2) + 1);
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
                return;
            }
            stringBuffer.append((char) ((i / 10) + 48));
            stringBuffer.append((char) ((i % 10) + 48));
        }
    }

    /* compiled from: TbsSdkJava */
    private static class UnpaddedNumberField implements NumberRule {
        static final UnpaddedNumberField INSTANCE_YEAR = new UnpaddedNumberField(1);
        private final int mField;

        UnpaddedNumberField(int i) {
            this.mField = i;
        }

        public int estimateLength() {
            return 4;
        }

        public void appendTo(StringBuffer stringBuffer, Calendar calendar) {
            appendTo(stringBuffer, calendar.get(this.mField));
        }

        public final void appendTo(StringBuffer stringBuffer, int i) {
            if (i < 10) {
                stringBuffer.append((char) (i + 48));
            } else if (i < 100) {
                stringBuffer.append((char) ((i / 10) + 48));
                stringBuffer.append((char) ((i % 10) + 48));
            } else {
                stringBuffer.append(Integer.toString(i));
            }
        }
    }

    public static FastDateFormat getInstance() {
        return getInstance(getDefaultPattern(), null, null);
    }

    public static FastDateFormat getInstance(String str) {
        return getInstance(str, null, null);
    }

    public static FastDateFormat getInstance(String str, TimeZone timeZone) {
        return getInstance(str, timeZone, null);
    }

    public static FastDateFormat getInstance(String str, Locale locale) {
        return getInstance(str, null, locale);
    }

    public static synchronized FastDateFormat getInstance(String str, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        synchronized (FastDateFormat.class) {
            FastDateFormat fastDateFormat2 = new FastDateFormat(str, timeZone, locale);
            fastDateFormat = (FastDateFormat) cInstanceCache.get(fastDateFormat2);
            if (fastDateFormat == null) {
                fastDateFormat2.init();
                cInstanceCache.put(fastDateFormat2, fastDateFormat2);
                fastDateFormat = fastDateFormat2;
            }
        }
        return fastDateFormat;
    }

    public static synchronized FastDateFormat getDateInstance(int i, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        synchronized (FastDateFormat.class) {
            Object pair;
            Integer num = new Integer(i);
            if (timeZone != null) {
                pair = new Pair(num, timeZone);
            } else {
                Integer num2 = num;
            }
            if (locale == null) {
                pair = new Pair(pair, locale);
            }
            fastDateFormat = (FastDateFormat) cDateInstanceCache.get(pair);
            if (fastDateFormat == null) {
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                try {
                    fastDateFormat = getInstance(((SimpleDateFormat) DateFormat.getDateInstance(i, locale)).toPattern(), timeZone, locale);
                    cDateInstanceCache.put(pair, fastDateFormat);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException(new StringBuffer().append("No date pattern for locale: ").append(locale).toString());
                }
            }
        }
        return fastDateFormat;
    }

    public static synchronized FastDateFormat getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        synchronized (FastDateFormat.class) {
            Object pair;
            Integer num = new Integer(i);
            if (timeZone != null) {
                pair = new Pair(num, timeZone);
            } else {
                Integer num2 = num;
            }
            if (locale != null) {
                pair = new Pair(pair, locale);
            }
            fastDateFormat = (FastDateFormat) cTimeInstanceCache.get(pair);
            if (fastDateFormat == null) {
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                try {
                    fastDateFormat = getInstance(((SimpleDateFormat) DateFormat.getTimeInstance(i, locale)).toPattern(), timeZone, locale);
                    cTimeInstanceCache.put(pair, fastDateFormat);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException(new StringBuffer().append("No date pattern for locale: ").append(locale).toString());
                }
            }
        }
        return fastDateFormat;
    }

    public static synchronized FastDateFormat getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        FastDateFormat fastDateFormat;
        synchronized (FastDateFormat.class) {
            Object pair;
            Pair pair2 = new Pair(new Integer(i), new Integer(i2));
            if (timeZone != null) {
                pair = new Pair(pair2, timeZone);
            } else {
                Pair pair3 = pair2;
            }
            if (locale != null) {
                pair = new Pair(pair, locale);
            }
            fastDateFormat = (FastDateFormat) cDateTimeInstanceCache.get(pair);
            if (fastDateFormat == null) {
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                try {
                    fastDateFormat = getInstance(((SimpleDateFormat) DateFormat.getDateTimeInstance(i, i2, locale)).toPattern(), timeZone, locale);
                    cDateTimeInstanceCache.put(pair, fastDateFormat);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException(new StringBuffer().append("No date time pattern for locale: ").append(locale).toString());
                }
            }
        }
        return fastDateFormat;
    }

    static synchronized String getTimeZoneDisplay(TimeZone timeZone, boolean z, int i, Locale locale) {
        String str;
        synchronized (FastDateFormat.class) {
            TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z, i, locale);
            str = (String) cTimeZoneDisplayCache.get(timeZoneDisplayKey);
            if (str == null) {
                str = timeZone.getDisplayName(z, i, locale);
                cTimeZoneDisplayCache.put(timeZoneDisplayKey, str);
            }
        }
        return str;
    }

    private static synchronized String getDefaultPattern() {
        String str;
        synchronized (FastDateFormat.class) {
            if (cDefaultPattern == null) {
                cDefaultPattern = new SimpleDateFormat().toPattern();
            }
            str = cDefaultPattern;
        }
        return str;
    }

    protected FastDateFormat(String str, TimeZone timeZone, Locale locale) {
        boolean z = true;
        if (str == null) {
            throw new IllegalArgumentException("The pattern must not be null");
        }
        this.mPattern = str;
        this.mTimeZoneForced = timeZone != null;
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        this.mTimeZone = timeZone;
        if (locale == null) {
            z = false;
        }
        this.mLocaleForced = z;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        this.mLocale = locale;
    }

    protected void init() {
        List parsePattern = parsePattern();
        this.mRules = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        int i = 0;
        int length = this.mRules.length;
        while (true) {
            length--;
            if (length >= 0) {
                i += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i;
                return;
            }
        }
    }

    protected List parsePattern() {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        List arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i = 0;
        while (i < length) {
            iArr[0] = i;
            String parseToken = parseToken(this.mPattern, iArr);
            int i2 = iArr[0];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            Object stringLiteral;
            switch (parseToken.charAt(0)) {
                case '\'':
                    String substring = parseToken.substring(1);
                    if (substring.length() != 1) {
                        stringLiteral = new StringLiteral(substring);
                        break;
                    }
                    stringLiteral = new CharacterLiteral(substring.charAt(0));
                    break;
                case 'D':
                    stringLiteral = selectNumberRule(6, length2);
                    break;
                case 'E':
                    String[] strArr;
                    if (length2 < 4) {
                        strArr = shortWeekdays;
                    } else {
                        strArr = weekdays;
                    }
                    TextField textField = new TextField(7, strArr);
                    break;
                case 'F':
                    stringLiteral = selectNumberRule(8, length2);
                    break;
                case 'G':
                    stringLiteral = new TextField(0, eras);
                    break;
                case 'H':
                    stringLiteral = selectNumberRule(11, length2);
                    break;
                case 'K':
                    stringLiteral = selectNumberRule(10, length2);
                    break;
                case 'M':
                    if (length2 < 4) {
                        if (length2 != 3) {
                            if (length2 != 2) {
                                stringLiteral = UnpaddedMonthField.INSTANCE;
                                break;
                            }
                            stringLiteral = TwoDigitMonthField.INSTANCE;
                            break;
                        }
                        stringLiteral = new TextField(2, shortMonths);
                        break;
                    }
                    stringLiteral = new TextField(2, months);
                    break;
                case 'S':
                    stringLiteral = selectNumberRule(14, length2);
                    break;
                case 'W':
                    stringLiteral = selectNumberRule(4, length2);
                    break;
                case 'Z':
                    if (length2 != 1) {
                        stringLiteral = TimeZoneNumberRule.INSTANCE_COLON;
                        break;
                    }
                    stringLiteral = TimeZoneNumberRule.INSTANCE_NO_COLON;
                    break;
                case 'a':
                    stringLiteral = new TextField(9, amPmStrings);
                    break;
                case 'd':
                    stringLiteral = selectNumberRule(5, length2);
                    break;
                case 'h':
                    stringLiteral = new TwelveHourField(selectNumberRule(10, length2));
                    break;
                case 'k':
                    stringLiteral = new TwentyFourHourField(selectNumberRule(11, length2));
                    break;
                case 'm':
                    stringLiteral = selectNumberRule(12, length2);
                    break;
                case 's':
                    stringLiteral = selectNumberRule(13, length2);
                    break;
                case 'w':
                    stringLiteral = selectNumberRule(3, length2);
                    break;
                case ErrorCode.THREAD_INIT_ERROR /*121*/:
                    if (length2 < 4) {
                        stringLiteral = TwoDigitYearField.INSTANCE;
                        break;
                    }
                    stringLiteral = UnpaddedNumberField.INSTANCE_YEAR;
                    break;
                case ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR /*122*/:
                    if (length2 < 4) {
                        stringLiteral = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
                        break;
                    }
                    stringLiteral = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1);
                    break;
                default:
                    throw new IllegalArgumentException(new StringBuffer().append("Illegal pattern component: ").append(parseToken).toString());
            }
            arrayList.add(stringLiteral);
            i = i2 + 1;
        }
        return arrayList;
    }

    protected String parseToken(String str, int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i);
        if ((charAt < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z')) {
            stringBuffer.append('\'');
            int i2 = 0;
            while (i < length) {
                char charAt2 = str.charAt(i);
                if (charAt2 != '\'') {
                    if (i2 == 0 && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i--;
                        break;
                    }
                    stringBuffer.append(charAt2);
                } else if (i + 1 >= length || str.charAt(i + 1) != '\'') {
                    i2 = i2 == 0 ? 1 : 0;
                } else {
                    i++;
                    stringBuffer.append(charAt2);
                }
                i++;
            }
        } else {
            stringBuffer.append(charAt);
            while (i + 1 < length && str.charAt(i + 1) == charAt) {
                stringBuffer.append(charAt);
                i++;
            }
        }
        iArr[0] = i;
        return stringBuffer.toString();
    }

    protected NumberRule selectNumberRule(int i, int i2) {
        switch (i2) {
            case 1:
                return new UnpaddedNumberField(i);
            case 2:
                return new TwoDigitNumberField(i);
            default:
                return new PaddedNumberField(i, i2);
        }
    }

    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown class: ").append(obj == null ? "<null>" : obj.getClass().getName()).toString());
    }

    public String format(Date date) {
        Calendar gregorianCalendar = new GregorianCalendar(this.mTimeZone);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public String format(Calendar calendar) {
        return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar gregorianCalendar = new GregorianCalendar(this.mTimeZone);
        gregorianCalendar.setTime(date);
        return applyRules(gregorianCalendar, stringBuffer);
    }

    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        Calendar calendar2;
        if (this.mTimeZoneForced) {
            calendar2 = (Calendar) calendar.clone();
            calendar2.setTimeZone(this.mTimeZone);
        } else {
            calendar2 = calendar;
        }
        return applyRules(calendar2, stringBuffer);
    }

    protected StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        Rule[] ruleArr = this.mRules;
        int length = this.mRules.length;
        for (int i = 0; i < length; i++) {
            ruleArr[i].appendTo(stringBuffer, calendar);
        }
        return stringBuffer;
    }

    public Object parseObject(String str, ParsePosition parsePosition) {
        parsePosition.setIndex(0);
        parsePosition.setErrorIndex(0);
        return null;
    }

    public String getPattern() {
        return this.mPattern;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public boolean getTimeZoneOverridesCalendar() {
        return this.mTimeZoneForced;
    }

    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDateFormat)) {
            return false;
        }
        FastDateFormat fastDateFormat = (FastDateFormat) obj;
        if (this.mPattern != fastDateFormat.mPattern && !this.mPattern.equals(fastDateFormat.mPattern)) {
            return false;
        }
        if (this.mTimeZone != fastDateFormat.mTimeZone && !this.mTimeZone.equals(fastDateFormat.mTimeZone)) {
            return false;
        }
        if ((this.mLocale == fastDateFormat.mLocale || this.mLocale.equals(fastDateFormat.mLocale)) && this.mTimeZoneForced == fastDateFormat.mTimeZoneForced && this.mLocaleForced == fastDateFormat.mLocaleForced) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        int hashCode = this.mTimeZone.hashCode() + (this.mPattern.hashCode() + 0);
        if (this.mTimeZoneForced) {
            i = 1;
        } else {
            i = 0;
        }
        i = (i + hashCode) + this.mLocale.hashCode();
        if (!this.mLocaleForced) {
            i2 = 0;
        }
        return i + i2;
    }

    public String toString() {
        return new StringBuffer().append("FastDateFormat[").append(this.mPattern).append("]").toString();
    }
}
