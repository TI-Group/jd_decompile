package org.apache.commons.lang;

import com.jingdong.jdma.JDMaInterface;

/* compiled from: TbsSdkJava */
public final class NumberRange {
    private final Number max;
    private final Number min;

    public NumberRange(Number number) {
        if (number == null) {
            throw new NullPointerException("The number must not be null");
        }
        this.min = number;
        this.max = number;
    }

    public NumberRange(Number number, Number number2) {
        if (number == null) {
            throw new NullPointerException("The minimum value must not be null");
        } else if (number2 == null) {
            throw new NullPointerException("The maximum value must not be null");
        } else if (number2.doubleValue() < number.doubleValue()) {
            this.max = number;
            this.min = number;
        } else {
            this.min = number;
            this.max = number2;
        }
    }

    public Number getMinimum() {
        return this.min;
    }

    public Number getMaximum() {
        return this.max;
    }

    public boolean includesNumber(Number number) {
        if (number != null && this.min.doubleValue() <= number.doubleValue() && this.max.doubleValue() >= number.doubleValue()) {
            return true;
        }
        return false;
    }

    public boolean includesRange(NumberRange numberRange) {
        if (numberRange != null && includesNumber(numberRange.min) && includesNumber(numberRange.max)) {
            return true;
        }
        return false;
    }

    public boolean overlaps(NumberRange numberRange) {
        if (numberRange == null) {
            return false;
        }
        if (numberRange.includesNumber(this.min) || numberRange.includesNumber(this.max) || includesRange(numberRange)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NumberRange)) {
            return false;
        }
        NumberRange numberRange = (NumberRange) obj;
        if (this.min.equals(numberRange.min) && this.max.equals(numberRange.max)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.min.hashCode() + 629) * 37) + this.max.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.min.doubleValue() < JDMaInterface.PV_UPPERLIMIT) {
            stringBuffer.append('(').append(this.min).append(')');
        } else {
            stringBuffer.append(this.min);
        }
        stringBuffer.append('-');
        if (this.max.doubleValue() < JDMaInterface.PV_UPPERLIMIT) {
            stringBuffer.append('(').append(this.max).append(')');
        } else {
            stringBuffer.append(this.max);
        }
        return stringBuffer.toString();
    }
}
