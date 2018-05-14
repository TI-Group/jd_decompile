package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.pdf417.PDF417Common;

/* compiled from: TbsSdkJava */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(PDF417Common.NUMBER_OF_CODEWORDS, 3);
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final ModulusPoly one;
    private final ModulusPoly zero;

    private ModulusGF(int i, int i2) {
        int i3;
        this.modulus = i;
        this.expTable = new int[i];
        this.logTable = new int[i];
        int i4 = 1;
        for (i3 = 0; i3 < i; i3++) {
            this.expTable[i3] = i4;
            i4 = (i4 * i2) % i;
        }
        for (i3 = 0; i3 < i - 1; i3++) {
            this.logTable[this.expTable[i3]] = i3;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    ModulusPoly getZero() {
        return this.zero;
    }

    ModulusPoly getOne() {
        return this.one;
    }

    ModulusPoly buildMonomial(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.zero;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new ModulusPoly(this, iArr);
        }
    }

    int add(int i, int i2) {
        return (i + i2) % this.modulus;
    }

    int subtract(int i, int i2) {
        return ((this.modulus + i) - i2) % this.modulus;
    }

    int exp(int i) {
        return this.expTable[i];
    }

    int log(int i) {
        if (i != 0) {
            return this.logTable[i];
        }
        throw new IllegalArgumentException();
    }

    int inverse(int i) {
        if (i != 0) {
            return this.expTable[(this.modulus - this.logTable[i]) - 1];
        }
        throw new ArithmeticException();
    }

    int multiply(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.expTable[(this.logTable[i] + this.logTable[i2]) % (this.modulus - 1)];
    }

    int getSize() {
        return this.modulus;
    }
}
