package org.apache.commons.lang.math;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public final class NumberRange extends Range implements Serializable {
    private static final long serialVersionUID = 71849363892710L;
    private transient int hashCode = 0;
    private final Number max;
    private final Number min;
    private transient String toString = null;

    public NumberRange(Number number) {
        if (number == null) {
            throw new IllegalArgumentException("The number must not be null");
        } else if (!(number instanceof Comparable)) {
            throw new IllegalArgumentException("The number must implement Comparable");
        } else if ((number instanceof Double) && ((Double) number).isNaN()) {
            throw new IllegalArgumentException("The number must not be NaN");
        } else if ((number instanceof Float) && ((Float) number).isNaN()) {
            throw new IllegalArgumentException("The number must not be NaN");
        } else {
            this.min = number;
            this.max = number;
        }
    }

    public NumberRange(Number number, Number number2) {
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        } else if (number.getClass() != number2.getClass()) {
            throw new IllegalArgumentException("The numbers must be of the same type");
        } else if (number instanceof Comparable) {
            if (number instanceof Double) {
                if (((Double) number).isNaN() || ((Double) number2).isNaN()) {
                    throw new IllegalArgumentException("The number must not be NaN");
                }
            } else if ((number instanceof Float) && (((Float) number).isNaN() || ((Float) number2).isNaN())) {
                throw new IllegalArgumentException("The number must not be NaN");
            }
            int compareTo = ((Comparable) number).compareTo(number2);
            if (compareTo == 0) {
                this.min = number;
                this.max = number;
            } else if (compareTo > 0) {
                this.min = number2;
                this.max = number;
            } else {
                this.min = number;
                this.max = number2;
            }
        } else {
            throw new IllegalArgumentException("The numbers must implement Comparable");
        }
    }

    public Number getMinimumNumber() {
        return this.min;
    }

    public Number getMaximumNumber() {
        return this.max;
    }

    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        if (number.getClass() != this.min.getClass()) {
            throw new IllegalArgumentException("The number must be of the same type as the range numbers");
        }
        boolean z = ((Comparable) this.min).compareTo(number) <= 0 && ((Comparable) this.max).compareTo(number) >= 0;
        return z;
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
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (this.hashCode * 37) + getClass().hashCode();
            this.hashCode = (this.hashCode * 37) + this.min.hashCode();
            this.hashCode = (this.hashCode * 37) + this.max.hashCode();
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
