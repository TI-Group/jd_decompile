package com.google.zxing.common;

import java.util.Arrays;
import org.apache.commons.lang.ClassUtils;

/* compiled from: TbsSdkJava */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    public BitArray(int i) {
        this.size = i;
        this.bits = makeArray(i);
    }

    BitArray(int[] iArr, int i) {
        this.bits = iArr;
        this.size = i;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int i) {
        if (i > this.bits.length * 32) {
            Object makeArray = makeArray(i);
            System.arraycopy(this.bits, 0, makeArray, 0, this.bits.length);
            this.bits = makeArray;
        }
    }

    public boolean get(int i) {
        return (this.bits[i / 32] & (1 << (i & 31))) != 0;
    }

    public void set(int i) {
        int[] iArr = this.bits;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] | (1 << (i & 31));
    }

    public void flip(int i) {
        int[] iArr = this.bits;
        int i2 = i / 32;
        iArr[i2] = iArr[i2] ^ (1 << (i & 31));
    }

    public int getNextSet(int i) {
        if (i >= this.size) {
            return this.size;
        }
        int i2 = i / 32;
        int i3 = this.bits[i2] & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.bits.length) {
                return this.size;
            }
            i3 = this.bits[i2];
        }
        i3 = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        return i3 > this.size ? this.size : i3;
    }

    public int getNextUnset(int i) {
        if (i >= this.size) {
            return this.size;
        }
        int i2 = i / 32;
        int i3 = (this.bits[i2] ^ -1) & (((1 << (i & 31)) - 1) ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.bits.length) {
                return this.size;
            }
            i3 = this.bits[i2] ^ -1;
        }
        i3 = Integer.numberOfTrailingZeros(i3) + (i2 * 32);
        return i3 > this.size ? this.size : i3;
    }

    public void setBulk(int i, int i2) {
        this.bits[i / 32] = i2;
    }

    public void setRange(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 != i) {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = i6 > i4 ? 0 : i & 31;
                int i8 = i6 < i5 ? 31 : i3 & 31;
                if (i7 == 0 && i8 == 31) {
                    i7 = -1;
                } else {
                    int i9 = i7;
                    i7 = 0;
                    while (i9 <= i8) {
                        int i10 = (1 << i9) | i7;
                        i9++;
                        i7 = i10;
                    }
                }
                int[] iArr = this.bits;
                iArr[i6] = i7 | iArr[i6];
                i6++;
            }
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i = 0; i < length; i++) {
            this.bits[i] = 0;
        }
    }

    public boolean isRange(int i, int i2, boolean z) {
        if (i2 < i) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7;
                int i8 = i6 > i4 ? 0 : i & 31;
                int i9 = i6 < i5 ? 31 : i3 & 31;
                if (i8 == 0 && i9 == 31) {
                    i8 = -1;
                } else {
                    i7 = i8;
                    i8 = 0;
                    while (i7 <= i9) {
                        int i10 = (1 << i7) | i8;
                        i7++;
                        i8 = i10;
                    }
                }
                i7 = this.bits[i6] & i8;
                if (!z) {
                    i8 = 0;
                }
                if (i7 != i8) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public void appendBit(boolean z) {
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.bits;
            int i = this.size / 32;
            iArr[i] = iArr[i] | (1 << (this.size & 31));
        }
        this.size++;
    }

    public void appendBits(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            appendBit(((i >> (i2 + -1)) & 1) == 1);
            i2--;
        }
    }

    public void appendBitArray(BitArray bitArray) {
        int i = bitArray.size;
        ensureCapacity(this.size + i);
        for (int i2 = 0; i2 < i; i2++) {
            appendBit(bitArray.get(i2));
        }
    }

    public void xor(BitArray bitArray) {
        if (this.bits.length != bitArray.bits.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.bits.length; i++) {
            int[] iArr = this.bits;
            iArr[i] = iArr[i] ^ bitArray.bits[i];
        }
    }

    public void toBytes(int i, byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int i5 = i;
        while (i4 < i3) {
            int i6 = i5;
            i5 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (get(i6)) {
                    i5 |= 1 << (7 - i7);
                }
                i6++;
            }
            bArr[i2 + i4] = (byte) i5;
            i4++;
            i5 = i6;
        }
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public void reverse() {
        int i;
        int i2 = 1;
        int[] iArr = new int[this.bits.length];
        int i3 = (this.size - 1) / 32;
        int i4 = i3 + 1;
        for (i = 0; i < i4; i++) {
            long j = (long) this.bits[i];
            j = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            j = ((j & 858993459) << 2) | ((j >> 2) & 858993459);
            j = ((j & 252645135) << 4) | ((j >> 4) & 252645135);
            j = ((j & 16711935) << 8) | ((j >> 8) & 16711935);
            iArr[i3 - i] = (int) (((j & 65535) << 16) | ((j >> 16) & 65535));
        }
        if (this.size != i4 * 32) {
            int i5 = (i4 * 32) - this.size;
            i3 = 1;
            for (i = 0; i < 31 - i5; i++) {
                i3 = (i3 << 1) | 1;
            }
            i = (iArr[0] >> i5) & i3;
            while (i2 < i4) {
                int i6 = iArr[i2];
                iArr[i2 - 1] = i | (i6 << (32 - i5));
                i = (i6 >> i5) & i3;
                i2++;
            }
            iArr[i4 - 1] = i;
        }
        this.bits = iArr;
    }

    private static int[] makeArray(int i) {
        return new int[((i + 31) / 32)];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        if (this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.size);
        for (int i = 0; i < this.size; i++) {
            if ((i & 7) == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(get(i) ? 'X' : ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        return stringBuilder.toString();
    }

    public BitArray clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }
}
