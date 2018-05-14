package org.apache.commons.lang.math;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public final class FloatRange extends Range implements Serializable {
    private static final long serialVersionUID = 71849363892750L;
    private transient int hashCode = 0;
    private final float max;
    private transient Float maxObject = null;
    private final float min;
    private transient Float minObject = null;
    private transient String toString = null;

    public FloatRange(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("The number must not be NaN");
        }
        this.min = f;
        this.max = f;
    }

    public FloatRange(Number number) {
        if (number == null) {
            throw new IllegalArgumentException("The number must not be null");
        }
        this.min = number.floatValue();
        this.max = number.floatValue();
        if (Float.isNaN(this.min) || Float.isNaN(this.max)) {
            throw new IllegalArgumentException("The number must not be NaN");
        } else if (number instanceof Float) {
            this.minObject = (Float) number;
            this.maxObject = (Float) number;
        }
    }

    public FloatRange(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (f2 < f) {
            this.min = f2;
            this.max = f;
        } else {
            this.min = f;
            this.max = f2;
        }
    }

    public FloatRange(Number number, Number number2) {
        if (number == null || number2 == null) {
            throw new IllegalArgumentException("The numbers must not be null");
        }
        float floatValue = number.floatValue();
        float floatValue2 = number2.floatValue();
        if (Float.isNaN(floatValue) || Float.isNaN(floatValue2)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        } else if (floatValue2 < floatValue) {
            this.min = floatValue2;
            this.max = floatValue;
            if (number2 instanceof Float) {
                this.minObject = (Float) number2;
            }
            if (number instanceof Float) {
                this.maxObject = (Float) number;
            }
        } else {
            this.min = floatValue;
            this.max = floatValue2;
            if (number instanceof Float) {
                this.minObject = (Float) number;
            }
            if (number2 instanceof Float) {
                this.maxObject = (Float) number2;
            }
        }
    }

    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Float(this.min);
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
        return (double) this.min;
    }

    public float getMinimumFloat() {
        return this.min;
    }

    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Float(this.max);
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
        return (double) this.max;
    }

    public float getMaximumFloat() {
        return this.max;
    }

    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsFloat(number.floatValue());
    }

    public boolean containsFloat(float f) {
        return f >= this.min && f <= this.max;
    }

    public boolean containsRange(Range range) {
        if (range != null && containsFloat(range.getMinimumFloat()) && containsFloat(range.getMaximumFloat())) {
            return true;
        }
        return false;
    }

    public boolean overlapsRange(Range range) {
        if (range == null) {
            return false;
        }
        if (range.containsFloat(this.min) || range.containsFloat(this.max) || containsFloat(range.getMinimumFloat())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FloatRange)) {
            return false;
        }
        FloatRange floatRange = (FloatRange) obj;
        if (Float.floatToIntBits(this.min) == Float.floatToIntBits(floatRange.min) && Float.floatToIntBits(this.max) == Float.floatToIntBits(floatRange.max)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (this.hashCode * 37) + getClass().hashCode();
            this.hashCode = (this.hashCode * 37) + Float.floatToIntBits(this.min);
            this.hashCode = (this.hashCode * 37) + Float.floatToIntBits(this.max);
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
