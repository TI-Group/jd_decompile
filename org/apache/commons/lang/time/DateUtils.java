package org.apache.commons.lang.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TimeZone;

/* compiled from: TbsSdkJava */
public class DateUtils {
    public static final int MILLIS_IN_DAY = 86400000;
    public static final int MILLIS_IN_HOUR = 3600000;
    public static final int MILLIS_IN_MINUTE = 60000;
    public static final int MILLIS_IN_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
    private static final int[][] fields;

    /* compiled from: TbsSdkJava */
    static class DateIterator implements Iterator {
        private final Calendar endFinal;
        private final Calendar spot;

        DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            this.spot.add(5, -1);
        }

        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        public Object next() {
            if (this.spot.equals(this.endFinal)) {
                throw new NoSuchElementException();
            }
            this.spot.add(5, 1);
            return this.spot.clone();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        r0 = new int[8][];
        r0[0] = new int[]{14};
        r0[1] = new int[]{13};
        r0[2] = new int[]{12};
        r0[3] = new int[]{11, 10};
        r0[4] = new int[]{5, 5, 9};
        r0[5] = new int[]{2, 1001};
        r0[6] = new int[]{1};
        r0[7] = new int[]{0};
        fields = r0;
    }

    public static Date round(Date date, int i) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        modify(gregorianCalendar, i, true);
        return gregorianCalendar.getTime();
    }

    public static Calendar round(Calendar calendar, int i) {
        if (calendar == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        modify(calendar2, i, true);
        return calendar2;
    }

    public static Date round(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return round((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i).getTime();
            }
            throw new ClassCastException(new StringBuffer().append("Could not round ").append(obj).toString());
        }
    }

    public static Date truncate(Date date, int i) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        modify(gregorianCalendar, i, false);
        return gregorianCalendar.getTime();
    }

    public static Calendar truncate(Calendar calendar, int i) {
        if (calendar == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar2 = (Calendar) calendar.clone();
        modify(calendar2, i, false);
        return calendar2;
    }

    public static Date truncate(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return truncate((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i).getTime();
            }
            throw new ClassCastException(new StringBuffer().append("Could not truncate ").append(obj).toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void modify(java.util.Calendar r10, int r11, boolean r12) {
        /*
        r8 = 15;
        r7 = 10;
        r6 = 5;
        r4 = 1;
        r1 = 0;
        r0 = r1;
        r2 = r1;
    L_0x0009:
        r3 = fields;
        r3 = r3.length;
        if (r0 >= r3) goto L_0x00be;
    L_0x000e:
        r3 = r1;
    L_0x000f:
        r5 = fields;
        r5 = r5[r0];
        r5 = r5.length;
        if (r3 >= r5) goto L_0x0047;
    L_0x0016:
        r5 = fields;
        r5 = r5[r0];
        r5 = r5[r3];
        if (r5 != r11) goto L_0x0044;
    L_0x001e:
        if (r12 == 0) goto L_0x002f;
    L_0x0020:
        if (r2 == 0) goto L_0x002f;
    L_0x0022:
        r2 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        if (r11 != r2) goto L_0x003a;
    L_0x0026:
        r0 = r10.get(r6);
        if (r0 != r4) goto L_0x0030;
    L_0x002c:
        r10.add(r6, r8);
    L_0x002f:
        return;
    L_0x0030:
        r0 = -15;
        r10.add(r6, r0);
        r0 = 2;
        r10.add(r0, r4);
        goto L_0x002f;
    L_0x003a:
        r2 = fields;
        r0 = r2[r0];
        r0 = r0[r1];
        r10.add(r0, r4);
        goto L_0x002f;
    L_0x0044:
        r3 = r3 + 1;
        goto L_0x000f;
    L_0x0047:
        switch(r11) {
            case 9: goto L_0x009f;
            case 1001: goto L_0x0082;
            default: goto L_0x004a;
        };
    L_0x004a:
        r5 = r1;
        r3 = r2;
        r2 = r1;
    L_0x004d:
        if (r5 != 0) goto L_0x00dd;
    L_0x004f:
        r2 = fields;
        r2 = r2[r0];
        r2 = r2[r1];
        r2 = r10.getActualMinimum(r2);
        r3 = fields;
        r3 = r3[r0];
        r3 = r3[r1];
        r5 = r10.getActualMaximum(r3);
        r3 = fields;
        r3 = r3[r0];
        r3 = r3[r1];
        r3 = r10.get(r3);
        r3 = r3 - r2;
        r2 = r5 - r2;
        r2 = r2 / 2;
        if (r3 <= r2) goto L_0x00bc;
    L_0x0074:
        r2 = r4;
    L_0x0075:
        r5 = fields;
        r5 = r5[r0];
        r5 = r5[r1];
        r3 = -r3;
        r10.add(r5, r3);
        r0 = r0 + 1;
        goto L_0x0009;
    L_0x0082:
        r3 = fields;
        r3 = r3[r0];
        r3 = r3[r1];
        if (r3 != r6) goto L_0x004a;
    L_0x008a:
        r2 = r10.get(r6);
        r3 = r2 + -1;
        if (r3 < r8) goto L_0x0094;
    L_0x0092:
        r3 = r3 + -15;
    L_0x0094:
        r2 = 7;
        if (r3 <= r2) goto L_0x009d;
    L_0x0097:
        r2 = r4;
    L_0x0098:
        r5 = r4;
        r9 = r3;
        r3 = r2;
        r2 = r9;
        goto L_0x004d;
    L_0x009d:
        r2 = r1;
        goto L_0x0098;
    L_0x009f:
        r3 = fields;
        r3 = r3[r0];
        r3 = r3[r1];
        if (r3 != r7) goto L_0x004a;
    L_0x00a7:
        r3 = r10.get(r7);
        r2 = 12;
        if (r3 < r2) goto L_0x00b1;
    L_0x00af:
        r3 = r3 + -12;
    L_0x00b1:
        r2 = 6;
        if (r3 <= r2) goto L_0x00ba;
    L_0x00b4:
        r2 = r4;
    L_0x00b5:
        r5 = r4;
        r9 = r3;
        r3 = r2;
        r2 = r9;
        goto L_0x004d;
    L_0x00ba:
        r2 = r1;
        goto L_0x00b5;
    L_0x00bc:
        r2 = r1;
        goto L_0x0075;
    L_0x00be:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r2 = "The field ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " is not supported";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00dd:
        r9 = r2;
        r2 = r3;
        r3 = r9;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.time.DateUtils.modify(java.util.Calendar, int, boolean):void");
    }

    public static Iterator iterator(Date date, int i) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return iterator(gregorianCalendar, i);
    }

    public static Iterator iterator(Calendar calendar, int i) {
        int i2 = 2;
        if (calendar == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar truncate;
        Calendar truncate2;
        int i3;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                truncate = truncate(calendar, 5);
                truncate2 = truncate(calendar, 5);
                switch (i) {
                    case 1:
                        i3 = 7;
                        i2 = 1;
                        break;
                    case 2:
                        i3 = 1;
                        break;
                    case 3:
                        i2 = calendar.get(7);
                        i3 = i2 - 1;
                        break;
                    case 4:
                        i2 = calendar.get(7) - 3;
                        i3 = calendar.get(7) + 3;
                        break;
                    default:
                        i3 = 7;
                        i2 = 1;
                        break;
                }
            case 5:
            case 6:
                truncate2 = truncate(calendar, 2);
                Calendar calendar2 = (Calendar) truncate2.clone();
                calendar2.add(2, 1);
                calendar2.add(5, -1);
                if (i != 6) {
                    i2 = 1;
                    truncate = truncate2;
                    truncate2 = calendar2;
                    i3 = 7;
                    break;
                }
                truncate = truncate2;
                truncate2 = calendar2;
                i3 = 1;
                break;
            default:
                throw new IllegalArgumentException(new StringBuffer().append("The range style ").append(i).append(" is not valid.").toString());
        }
        if (i2 < 1) {
            i2 += 7;
        }
        if (i2 > 7) {
            i2 -= 7;
        }
        if (i3 < 1) {
            i3 += 7;
        }
        if (i3 > 7) {
            i3 -= 7;
        }
        while (truncate.get(7) != i2) {
            truncate.add(5, -1);
        }
        while (truncate2.get(7) != i3) {
            truncate2.add(5, 1);
        }
        return new DateIterator(truncate, truncate2);
    }

    public static Iterator iterator(Object obj, int i) {
        if (obj == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else if (obj instanceof Date) {
            return iterator((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i);
            }
            throw new ClassCastException(new StringBuffer().append("Could not iterate based on ").append(obj).toString());
        }
    }
}
