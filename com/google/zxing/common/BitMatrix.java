package com.google.zxing.common;

import java.util.Arrays;

/* compiled from: TbsSdkJava */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i) {
        this(i, i);
    }

    public BitMatrix(int i, int i2) {
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i;
        this.height = i2;
        this.rowSize = (i + 31) / 32;
        this.bits = new int[(this.rowSize * i2)];
    }

    private BitMatrix(int i, int i2, int i3, int[] iArr) {
        this.width = i;
        this.height = i2;
        this.rowSize = i3;
        this.bits = iArr;
    }

    public boolean get(int i, int i2) {
        return ((this.bits[(this.rowSize * i2) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void set(int i, int i2) {
        int i3 = (this.rowSize * i2) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public void flip(int i, int i2) {
        int i3 = (this.rowSize * i2) + (i / 32);
        int[] iArr = this.bits;
        iArr[i3] = iArr[i3] ^ (1 << (i & 31));
    }

    public void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public void setRegion(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 < 1 || i3 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.height || i5 > this.width) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = i2 * this.rowSize;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.bits;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public BitArray getRow(int i, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        } else {
            bitArray.clear();
        }
        int i2 = i * this.rowSize;
        for (int i3 = 0; i3 < this.rowSize; i3++) {
            bitArray.setBulk(i3 * 32, this.bits[i2 + i3]);
        }
        return bitArray;
    }

    public void setRow(int i, BitArray bitArray) {
        System.arraycopy(bitArray.getBitArray(), 0, this.bits, this.rowSize * i, this.rowSize);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (width = 0; width < (height + 1) / 2; width++) {
            bitArray = getRow(width, bitArray);
            bitArray2 = getRow((height - 1) - width, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(width, bitArray2);
            setRow((height - 1) - width, bitArray);
        }
    }

    public int[] getEnclosingRectangle() {
        int i = this.width;
        int i2 = this.height;
        int i3 = i;
        i = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.height; i5++) {
            int i6 = 0;
            while (i6 < this.rowSize) {
                int i7;
                int i8 = this.bits[(this.rowSize * i5) + i6];
                if (i8 != 0) {
                    if (i5 < i2) {
                        i2 = i5;
                    }
                    if (i5 > i4) {
                        i4 = i5;
                    }
                    if (i6 * 32 < i3) {
                        i7 = 0;
                        while ((i8 << (31 - i7)) == 0) {
                            i7++;
                        }
                        if ((i6 * 32) + i7 < i3) {
                            i7 = (i6 * 32) + i7;
                            if ((i6 * 32) + 31 > i) {
                                i3 = 31;
                                while ((i8 >>> i3) == 0) {
                                    i3--;
                                }
                                if ((i6 * 32) + i3 > i) {
                                    i = (i6 * 32) + i3;
                                    i3 = i2;
                                    i2 = i;
                                    i = i4;
                                }
                            }
                            i3 = i2;
                            i2 = i;
                            i = i4;
                        }
                    }
                    i7 = i3;
                    if ((i6 * 32) + 31 > i) {
                        i3 = 31;
                        while ((i8 >>> i3) == 0) {
                            i3--;
                        }
                        if ((i6 * 32) + i3 > i) {
                            i = (i6 * 32) + i3;
                            i3 = i2;
                            i2 = i;
                            i = i4;
                        }
                    }
                    i3 = i2;
                    i2 = i;
                    i = i4;
                } else {
                    i7 = i3;
                    i3 = i2;
                    i2 = i;
                    i = i4;
                }
                i6++;
                i4 = i;
                i = i2;
                i2 = i3;
                i3 = i7;
            }
        }
        i4 -= i2;
        if (i - i3 < 0 || i4 < 0) {
            return null;
        }
        return new int[]{i3, i2, i, i4};
    }

    public int[] getTopLeftOnBit() {
        int i = 0;
        while (i < this.bits.length && this.bits[i] == 0) {
            i++;
        }
        if (i == this.bits.length) {
            return null;
        }
        int i2 = i / this.rowSize;
        int i3 = (i % this.rowSize) * 32;
        int i4 = this.bits[i];
        i = 0;
        while ((i4 << (31 - i)) == 0) {
            i++;
        }
        i3 += i;
        return new int[]{i3, i2};
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.rowSize;
        int i2 = (length % this.rowSize) * 32;
        int i3 = this.bits[length];
        length = 31;
        while ((i3 >>> length) == 0) {
            length--;
        }
        i2 += length;
        return new int[]{i2, i};
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        if (this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.width * 31) + this.width) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                stringBuilder.append(get(i2, i) ? "X " : "  ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    public BitMatrix clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }
}
