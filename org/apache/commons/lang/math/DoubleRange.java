package org.apache.commons.lang.math;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public final class DoubleRange extends Range implements Serializable {
    private static final long serialVersionUID = 71849363892740L;
    private transient int hashCode = 0;
    private final double max;
    private transient Double maxObject = null;
    private final double min;
    private transient Double minObject = null;
    private transient String toString = null;

    public DoubleRange(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("The number must not be NaN");
        }
        this.min = d;
        this.max = d;
    }

    public DoubleRange(Number number) {
        if (number == null) {
            throw new IllegalArgumentException("The number must not be null");
        }
        this.min = number.doubleValue();
        this.max = number.doubleValue();
        if (Double.isNaN(this.min) || Double.isNaN(this.max)) {
            throw new IllegalArgumentException("The number must not be NaN");
        } else if (number instanceof Double) {
            this.minObject = (Double) number;
            this.maxObject = (Double) number;
        }
    }

    public DoubleRange(double d, double d2) {
        if (Double.isNaN(d) || Double.isNaN(d2)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (d2 < d) {
            this.min = d2;
            this.max = d;
        } else {
            this.min = d;
            this.max = d2;
        }
    }

    public DoubleRange(Number number, Number number2) {
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        double doubleValue = number.doubleValue();
        double doubleValue2 = number2.doubleValue();
        if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (doubleValue2 < doubleValue) {
            this.min = doubleValue2;
            this.max = doubleValue;
            if (number2 instanceof Double) {
                this.minObject = (Double) number2;
            }
            if (number instanceof Double) {
                this.maxObject = (Double) number;
            }
        } else {
            this.min = doubleValue;
            this.max = doubleValue2;
            if (number instanceof Double) {
                this.minObject = (Double) number;
            }
            if (number2 instanceof Double) {
                this.maxObject = (Double) number2;
            }
        }
    }

    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Double(this.min);
        }
        return this.minObject;
    }

    public long getMinimumLong() {
        return (long) this.min;
    }

    public int getMinimumInteger() {
        return (int) this.min;
    }

    public double getMinimumDouble() {
        return this.min;
    }

    public float getMinimumFloat() {
        return (float) this.min;
    }

    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Double(this.max);
        }
        return this.maxObject;
    }

    public long getMaximumLong() {
        return (long) this.max;
    }

    public int getMaximumInteger() {
        return (int) this.max;
    }

    public double getMaximumDouble() {
        return this.max;
    }

    public float getMaximumFloat() {
        return (float) this.max;
    }

    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsDouble(number.doubleValue());
    }

    public boolean containsDouble(double d) {
        return d >= this.min && d <= this.max;
    }

    public boolean containsRange(Range range) {
        if (range != null && containsDouble(range.getMinimumDouble()) && containsDouble(range.getMaximumDouble())) {
            return true;
        }
        return false;
    }

    public boolean overlapsRange(Range range) {
        if (range == null) {
            return false;
        }
        if (range.containsDouble(this.min) || range.containsDouble(this.max) || containsDouble(range.getMinimumDouble())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DoubleRange)) {
            return false;
        }
        DoubleRange doubleRange = (DoubleRange) obj;
        if (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(doubleRange.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(doubleRange.max)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (this.hashCode * 37) + getClass().hashCode();
            long doubleToLongBits = Double.doubleToLongBits(this.min);
            this.hashCode = ((int) (doubleToLongBits ^ (doubleToLongBits >> 32))) + (this.hashCode * 37);
            doubleToLongBits = Double.doubleToLongBits(this.max);
            this.hashCode = ((int) (doubleToLongBits ^ (doubleToLongBits >> 32))) + (this.hashCode * 37);
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
