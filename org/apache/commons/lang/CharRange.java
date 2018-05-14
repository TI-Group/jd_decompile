package org.apache.commons.lang;

import java.io.Serializable;

/* compiled from: TbsSdkJava */
public final class CharRange implements Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    public CharRange(char c) {
        this(c, c, false);
    }

    public CharRange(char c, boolean z) {
        this(c, c, z);
    }

    public CharRange(char c, char c2) {
        this(c, c2, false);
    }

    public CharRange(char c, char c2, boolean z) {
        if (c <= c2) {
            char c3 = c2;
            c2 = c;
            c = c3;
        }
        this.start = c2;
        this.end = c;
        this.negated = z;
    }

    public char getStart() {
        return this.start;
    }

    public char getEnd() {
        return this.end;
    }

    public boolean isNegated() {
        return this.negated;
    }

    public boolean contains(char c) {
        boolean z = c >= this.start && c <= this.end;
        return z != this.negated;
    }

    public boolean contains(CharRange charRange) {
        boolean z = false;
        if (charRange == null) {
            throw new IllegalArgumentException("The Range must not be null");
        } else if (this.negated) {
            if (!charRange.negated) {
                if (charRange.end < this.start || charRange.start > this.end) {
                    z = true;
                }
                return z;
            } else if (this.start < charRange.start || this.end > charRange.end) {
                return false;
            } else {
                return true;
            }
        } else if (charRange.negated) {
            if (this.start == '\u0000' && this.end == '￿') {
                return true;
            }
            return false;
        } else if (this.start > charRange.start || this.end < charRange.end) {
            return false;
        } else {
            return true;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        if (this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.negated ? 1 : 0) + ((this.end * 7) + (this.start + 83));
    }

    public String toString() {
        if (this.iToString == null) {
            StringBuffer stringBuffer = new StringBuffer(4);
            if (isNegated()) {
                stringBuffer.append('^');
            }
            stringBuffer.append(this.start);
            if (this.start != this.end) {
                stringBuffer.append('-');
                stringBuffer.append(this.end);
            }
            this.iToString = stringBuffer.toString();
        }
        return this.iToString;
    }
}
