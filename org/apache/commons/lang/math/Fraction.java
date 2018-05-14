package org.apache.commons.lang.math;

import com.jingdong.jdma.JDMaInterface;
import java.io.Serializable;

/* compiled from: TbsSdkJava */
public final class Fraction extends Number implements Serializable, Comparable {
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ZERO = new Fraction(0, 1);
    private static final long serialVersionUID = 65382027393090L;
    private final int denominator;
    private transient int hashCode = 0;
    private final int numerator;
    private transient String toProperString = null;
    private transient String toString = null;

    private Fraction(int i, int i2) {
        this.numerator = i;
        this.denominator = i2;
    }

    public static Fraction getFraction(int i, int i2) {
        if (i2 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i2 < 0) {
            i = -i;
            i2 = -i2;
        }
        return new Fraction(i, i2);
    }

    public static Fraction getFraction(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i3 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        } else if (i2 < 0) {
            throw new ArithmeticException("The numerator must not be negative");
        } else {
            double d;
            if (i < 0) {
                d = (((double) i) * ((double) i3)) - ((double) i2);
            } else {
                d = (((double) i) * ((double) i3)) + ((double) i2);
            }
            if (Math.abs(d) <= 2.147483647E9d) {
                return new Fraction((int) d, i3);
            }
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        }
    }

    public static Fraction getReducedFraction(int i, int i2) {
        if (i2 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i2 < 0) {
            i = -i;
            i2 = -i2;
        }
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i), i2);
        return new Fraction(i / greatestCommonDivisor, i2 / greatestCommonDivisor);
    }

    public static Fraction getFraction(double d) {
        int i = d < JDMaInterface.PV_UPPERLIMIT ? -1 : 1;
        double abs = Math.abs(d);
        if (abs > 2.147483647E9d || Double.isNaN(abs)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i2 = (int) abs;
        double d2 = abs - ((double) i2);
        int i3 = (int) d2;
        abs = Double.MAX_VALUE;
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        int i9 = i3;
        double d3 = 1.0d;
        double d4 = d2 - ((double) i3);
        while (true) {
            int i10 = (int) (d3 / d4);
            double d5 = d3 - (((double) i10) * d4);
            i6 += i9 * i8;
            i9 = (i9 * i7) + i5;
            d3 = Math.abs(d2 - (((double) i6) / ((double) i9)));
            i4++;
            if (abs > d3 && i9 <= 10000 && i9 > 0 && i4 < 25) {
                abs = d3;
                i5 = i7;
                d3 = d4;
                i7 = i9;
                i9 = i10;
                d4 = d5;
                int i11 = i6;
                i6 = i8;
                i8 = i11;
            }
        }
        if (i4 != 25) {
            return getReducedFraction(i * ((i2 * i7) + i8), i7);
        }
        throw new ArithmeticException("Unable to convert double to fraction");
    }

    public static Fraction getFraction(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The string must not be null");
        } else if (str.indexOf(46) >= 0) {
            return getFraction(Double.parseDouble(str));
        } else {
            int indexOf = str.indexOf(32);
            if (indexOf > 0) {
                int parseInt = Integer.parseInt(str.substring(0, indexOf));
                String substring = str.substring(indexOf + 1);
                int indexOf2 = substring.indexOf(47);
                if (indexOf2 < 0) {
                    throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
                }
                int parseInt2 = Integer.parseInt(substring.substring(indexOf2 + 1));
                return getFraction(Integer.parseInt(substring.substring(0, indexOf2)) + (parseInt * parseInt2), parseInt2);
            }
            indexOf = str.indexOf(47);
            if (indexOf < 0) {
                return getFraction(Integer.parseInt(str), 1);
            }
            return getFraction(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        }
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int intValue() {
        return this.numerator / this.denominator;
    }

    public long longValue() {
        return ((long) this.numerator) / ((long) this.denominator);
    }

    public float floatValue() {
        return ((float) this.numerator) / ((float) this.denominator);
    }

    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public Fraction reduce() {
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(this.numerator), this.denominator);
        return getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
    }

    public Fraction invert() {
        if (this.numerator != 0) {
            return getFraction(this.denominator, this.numerator);
        }
        throw new ArithmeticException("Unable to invert a fraction with a zero numerator");
    }

    public Fraction negate() {
        return getFraction(-this.numerator, this.denominator);
    }

    public Fraction abs() {
        return this.numerator >= 0 ? this : getFraction(-this.numerator, this.denominator);
    }

    public Fraction pow(int i) {
        if (i == 1) {
            return this;
        }
        if (i == 0) {
            return ONE;
        }
        double pow = Math.pow((double) this.denominator, (double) i);
        if (Math.pow((double) this.numerator, (double) i) > 2.147483647E9d || pow > 2.147483647E9d) {
            throw new ArithmeticException("Integer overflow");
        } else if (i < 0) {
            return getFraction((int) Math.pow((double) this.denominator, (double) (-i)), (int) Math.pow((double) this.numerator, (double) (-i)));
        } else {
            return getFraction((int) Math.pow((double) this.numerator, (double) i), (int) Math.pow((double) this.denominator, (double) i));
        }
    }

    private static int greatestCommonDivisor(int i, int i2) {
        int i3 = i % i2;
        while (i3 != 0) {
            int i4 = i2 % i3;
            i2 = i3;
            i3 = i4;
        }
        return i2;
    }

    public Fraction add(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (this.numerator == 0) {
            return fraction;
        } else {
            if (fraction.numerator == 0) {
                return this;
            }
            int greatestCommonDivisor = greatestCommonDivisor(Math.abs(fraction.denominator), Math.abs(this.denominator));
            int i = this.denominator / greatestCommonDivisor;
            int i2 = fraction.denominator / greatestCommonDivisor;
            double abs = Math.abs((((double) greatestCommonDivisor) * ((double) i)) * ((double) i2));
            double d = ((double) (fraction.numerator * i)) + (((double) i2) * ((double) this.numerator));
            if (Math.abs(d) <= 2.147483647E9d && Math.abs(abs) <= 2.147483647E9d) {
                return getReducedFraction((int) d, (int) abs);
            }
            throw new ArithmeticException("Integer overflow");
        }
    }

    public Fraction subtract(Fraction fraction) {
        if (fraction != null) {
            return add(fraction.negate());
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    public Fraction multiplyBy(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (this.numerator == 0 || fraction.numerator == 0) {
            return ZERO;
        } else {
            double d = ((double) this.numerator) * ((double) fraction.numerator);
            double d2 = ((double) this.denominator) * ((double) fraction.denominator);
            if (Math.abs(d) <= 2.147483647E9d && Math.abs(d2) <= 2.147483647E9d) {
                return getReducedFraction((int) d, (int) d2);
            }
            throw new ArithmeticException("Integer overflow");
        }
    }

    public Fraction divideBy(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (fraction.numerator == 0) {
            throw new ArithmeticException("The fraction to divide by must not be zero");
        } else if (this.numerator == 0) {
            return ZERO;
        } else {
            double d = ((double) this.numerator) * ((double) fraction.denominator);
            double d2 = ((double) this.denominator) * ((double) fraction.numerator);
            if (Math.abs(d) <= 2.147483647E9d && Math.abs(d2) <= 2.147483647E9d) {
                return getReducedFraction((int) d, (int) d2);
            }
            throw new ArithmeticException("Integer overflow");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        if (this.numerator == fraction.numerator && this.denominator == fraction.denominator) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (this.hashCode * 37) + this.numerator;
            this.hashCode = (this.hashCode * 37) + this.denominator;
        }
        return this.hashCode;
    }

    public int compareTo(Object obj) {
        Fraction fraction = (Fraction) obj;
        if (this.numerator == fraction.numerator && this.denominator == fraction.denominator) {
            return 0;
        }
        long j = ((long) this.numerator) * ((long) fraction.denominator);
        long j2 = ((long) fraction.numerator) * ((long) this.denominator);
        if (j == j2) {
            return 0;
        }
        if (j < j2) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = new StringBuffer(32).append(this.numerator).append('/').append(this.denominator).toString();
        }
        return this.toString;
    }

    public String toProperString() {
        if (this.toProperString == null) {
            if (this.numerator == 0) {
                this.toProperString = "0";
            } else if (this.numerator == this.denominator) {
                this.toProperString = "1";
            } else if (Math.abs(this.numerator) > this.denominator) {
                int properNumerator = getProperNumerator();
                if (properNumerator == 0) {
                    this.toProperString = Integer.toString(getProperWhole());
                } else {
                    this.toProperString = new StringBuffer(32).append(getProperWhole()).append(' ').append(properNumerator).append('/').append(this.denominator).toString();
                }
            } else {
                this.toProperString = new StringBuffer(32).append(this.numerator).append('/').append(this.denominator).toString();
            }
        }
        return this.toProperString;
    }
}
