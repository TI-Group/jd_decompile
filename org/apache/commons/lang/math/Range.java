package org.apache.commons.lang.math;

/* compiled from: TbsSdkJava */
public abstract class Range {
    public abstract boolean containsNumber(Number number);

    public abstract Number getMaximumNumber();

    public abstract Number getMinimumNumber();

    public long getMinimumLong() {
        return getMinimumNumber().longValue();
    }

    public int getMinimumInteger() {
        return getMinimumNumber().intValue();
    }

    public double getMinimumDouble() {
        return getMinimumNumber().doubleValue();
    }

    public float getMinimumFloat() {
        return getMinimumNumber().floatValue();
    }

    public long getMaximumLong() {
        return getMaximumNumber().longValue();
    }

    public int getMaximumInteger() {
        return getMaximumNumber().intValue();
    }

    public double getMaximumDouble() {
        return getMaximumNumber().doubleValue();
    }

    public float getMaximumFloat() {
        return getMaximumNumber().floatValue();
    }

    public boolean containsLong(Number number) {
        if (number == null) {
            return false;
        }
        return containsLong(number.longValue());
    }

    public boolean containsLong(long j) {
        return j >= getMinimumLong() && j <= getMaximumLong();
    }

    public boolean containsInteger(Number number) {
        if (number == null) {
            return false;
        }
        return containsInteger(number.intValue());
    }

    public boolean containsInteger(int i) {
        return i >= getMinimumInteger() && i <= getMaximumInteger();
    }

    public boolean containsDouble(Number number) {
        if (number == null) {
            return false;
        }
        return containsDouble(number.doubleValue());
    }

    public boolean containsDouble(double d) {
        return NumberUtils.compare(getMinimumDouble(), d) <= 0 && NumberUtils.compare(getMaximumDouble(), d) >= 0;
    }

    public boolean containsFloat(Number number) {
        if (number == null) {
            return false;
        }
        return containsFloat(number.floatValue());
    }

    public boolean containsFloat(float f) {
        return NumberUtils.compare(getMinimumFloat(), f) <= 0 && NumberUtils.compare(getMaximumFloat(), f) >= 0;
    }

    public boolean containsRange(Range range) {
        if (range != null && containsNumber(range.getMinimumNumber()) && containsNumber(range.getMaximumNumber())) {
            return true;
        }
        return false;
    }

    public boolean overlapsRange(Range range) {
        if (range == null) {
            return false;
        }
        if (range.containsNumber(getMinimumNumber()) || range.containsNumber(getMaximumNumber()) || containsNumber(range.getMinimumNumber())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Range range = (Range) obj;
        if (getMinimumNumber().equals(range.getMinimumNumber()) && getMaximumNumber().equals(range.getMaximumNumber())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((getClass().hashCode() + 629) * 37) + getMinimumNumber().hashCode()) * 37) + getMaximumNumber().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(32);
        stringBuffer.append("Range[");
        stringBuffer.append(getMinimumNumber());
        stringBuffer.append(',');
        stringBuffer.append(getMaximumNumber());
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}
