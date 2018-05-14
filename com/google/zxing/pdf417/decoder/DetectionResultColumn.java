package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* compiled from: TbsSdkJava */
class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    DetectionResultColumn(BoundingBox boundingBox) {
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[((boundingBox.getMaxY() - boundingBox.getMinY()) + 1)];
    }

    final Codeword getCodewordNearby(int i) {
        Codeword codeword = getCodeword(i);
        if (codeword != null) {
            return codeword;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int imageRowToCodewordIndex = imageRowToCodewordIndex(i) - i2;
            if (imageRowToCodewordIndex >= 0) {
                codeword = this.codewords[imageRowToCodewordIndex];
                if (codeword != null) {
                    return codeword;
                }
            }
            imageRowToCodewordIndex = imageRowToCodewordIndex(i) + i2;
            if (imageRowToCodewordIndex < this.codewords.length) {
                codeword = this.codewords[imageRowToCodewordIndex];
                if (codeword != null) {
                    return codeword;
                }
            }
        }
        return null;
    }

    final int imageRowToCodewordIndex(int i) {
        return i - this.boundingBox.getMinY();
    }

    final void setCodeword(int i, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i)] = codeword;
    }

    final Codeword getCodeword(int i) {
        return this.codewords[imageRowToCodewordIndex(i)];
    }

    final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    final Codeword[] getCodewords() {
        return this.codewords;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        Codeword[] codewordArr = this.codewords;
        int length = codewordArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            Codeword codeword = codewordArr[i];
            if (codeword == null) {
                Object[] objArr = new Object[1];
                i3 = i2 + 1;
                objArr[0] = Integer.valueOf(i2);
                formatter.format("%3d:    |   %n", objArr);
            } else {
                r9 = new Object[3];
                i3 = i2 + 1;
                r9[0] = Integer.valueOf(i2);
                r9[1] = Integer.valueOf(codeword.getRowNumber());
                r9[2] = Integer.valueOf(codeword.getValue());
                formatter.format("%3d: %3d|%3d%n", r9);
            }
            i++;
            i2 = i3;
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
