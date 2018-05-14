package org.apache.commons.lang.math;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public final class LongRange extends Range implements Serializable {
    private static final long serialVersionUID = 71849363892720L;
    private transient int hashCode = 0;
    private final long max;
    private transient Long maxObject = null;
    private final long min;
    private transient Long minObject = null;
    private transient String toString = null;

    public LongRange(long j) {
        this.min = j;
        this.max = j;
    }

    public LongRange(Number number) {
        if (number == null) {
            throw new IllegalArgumentException("The number must not be null");
        }
        this.min = number.longValue();
        this.max = number.longValue();
        if (number instanceof Long) {
            this.minObject = (Long) number;
            this.maxObject = (Long) number;
        }
    }

    public LongRange(long j, long j2) {
        if (j2 < j) {
            this.min = j2;
            this.max = j;
            return;
        }
        this.min = j;
        this.max = j2;
    }

    public LongRange(Number number, Number number2) {
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        long longValue = number.longValue();
        long longValue2 = number2.longValue();
        if (longValue2 < longValue) {
            this.min = longValue2;
            this.max = longValue;
            if (number2 instanceof Long) {
                this.minObject = (Long) number2;
            }
            if (number instanceof Long) {
                this.maxObject = (Long) number;
                return;
            }
            return;
        }
        this.min = longValue;
        this.max = longValue2;
        if (number instanceof Long) {
            this.minObject = (Long) number;
        }
        if (number2 instanceof Long) {
            this.maxObject = (Long) number2;
        }
    }

    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Long(this.min);
        }
        return this.minObject;
    }

    public long getMinimumLong() {
        return this.min;
    }

    public int getMinimumInteger() {
        return (int) this.min;
    }

    public double getMinimumDouble() {
        return (double) this.min;
    }

    public float getMinimumFloat() {
        return (float) this.min;
    }

    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Long(this.max);
        }
        return this.maxObject;
    }

    public long getMaximumLong() {
        return this.max;
    }

    public int getMaximumInteger() {
        return (int) this.max;
    }

    public double getMaximumDouble() {
        return (double) this.max;
    }

    public float getMaximumFloat() {
        return (float) this.max;
    }

    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsLong(number.longValue());
    }

    public boolean containsLong(long j) {
        return j >= this.min && j <= this.max;
    }

    public boolean containsRange(Range range) {
        if (range != null && containsLong(range.getMinimumLong()) && containsLong(range.getMaximumLong())) {
            return true;
        }
        return false;
    }

    public boolean overlapsRange(Range range) {
        if (range == null) {
            return false;
        }
        if (range.containsLong(this.min) || range.containsLong(this.max) || containsLong(range.getMinimumLong())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LongRange)) {
            return false;
        }
        LongRange longRange = (LongRange) obj;
        if (this.min == longRange.min && this.max == longRange.max) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (this.hashCode * 37) + getClass().hashCode();
            this.hashCode = (this.hashCode * 37) + ((int) (this.min ^ (this.min >> 32)));
            this.hashCode = (this.hashCode * 37) + ((int) (this.max ^ (this.max >> 32)));
        }
        return this.hashCode;
    }

    public String toString() {
        if (this.toString == null) {
            StringBuffer stringBuffer = new StringBuffer(32);
            stringBuffer.append("Range[");
            stringBuffer.append(this.min);
            stringBuffer.append(',');
            stringBuffer.append(this.max);
            stringBuffer.append(']');
            this.toString = stringBuffer.toString();
        }
        return this.toString;
    }
}
