package org.apache.http.message;

import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
/* compiled from: TbsSdkJava */
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        } else if (i > i2) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        } else {
            this.lowerBound = i;
            this.upperBound = i2;
            this.pos = i;
        }
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public int getPos() {
        return this.pos;
    }

    public void updatePos(int i) {
        if (i < this.lowerBound) {
            throw new IndexOutOfBoundsException("pos: " + i + " < lowerBound: " + this.lowerBound);
        } else if (i > this.upperBound) {
            throw new IndexOutOfBoundsException("pos: " + i + " > upperBound: " + this.upperBound);
        } else {
            this.pos = i;
        }
    }

    public boolean atEnd() {
        return this.pos >= this.upperBound;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(Integer.toString(this.lowerBound));
        stringBuilder.append('>');
        stringBuilder.append(Integer.toString(this.pos));
        stringBuilder.append('>');
        stringBuilder.append(Integer.toString(this.upperBound));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
