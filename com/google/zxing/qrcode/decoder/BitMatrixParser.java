package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* compiled from: TbsSdkJava */
final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix;
    }

    FormatInformation readFormatInformation() throws FormatException {
        int i = 0;
        if (this.parsedFormatInfo != null) {
            return this.parsedFormatInfo;
        }
        int i2;
        int i3 = 0;
        for (i2 = 0; i2 < 6; i2++) {
            i3 = copyBit(i2, 8, i3);
        }
        i3 = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, i3)));
        for (i2 = 5; i2 >= 0; i2--) {
            i3 = copyBit(8, i2, i3);
        }
        int height = this.bitMatrix.getHeight();
        int i4 = height - 7;
        for (i2 = height - 1; i2 >= i4; i2--) {
            i = copyBit(8, i2, i);
        }
        for (i2 = height - 8; i2 < height; i2++) {
            i = copyBit(i2, 8, i);
        }
        this.parsedFormatInfo = FormatInformation.decodeFormatInformation(i3, i);
        if (this.parsedFormatInfo != null) {
            return this.parsedFormatInfo;
        }
        throw FormatException.getFormatInstance();
    }

    Version readVersion() throws FormatException {
        if (this.parsedVersion != null) {
            return this.parsedVersion;
        }
        int height = this.bitMatrix.getHeight();
        int i = (height - 17) / 4;
        if (i <= 6) {
            return Version.getVersionForNumber(i);
        }
        int i2 = height - 11;
        int i3 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (i = height - 9; i >= i2; i--) {
                i3 = copyBit(i, i4, i3);
            }
        }
        Version decodeVersionInformation = Version.decodeVersionInformation(i3);
        if (decodeVersionInformation == null || decodeVersionInformation.getDimensionForVersion() != height) {
            int i5 = 0;
            for (int i6 = 5; i6 >= 0; i6--) {
                for (i = height - 9; i >= i2; i--) {
                    i5 = copyBit(i6, i, i5);
                }
            }
            decodeVersionInformation = Version.decodeVersionInformation(i5);
            if (decodeVersionInformation == null || decodeVersionInformation.getDimensionForVersion() != height) {
                throw FormatException.getFormatInstance();
            }
            this.parsedVersion = decodeVersionInformation;
            return decodeVersionInformation;
        }
        this.parsedVersion = decodeVersionInformation;
        return decodeVersionInformation;
    }

    private int copyBit(int i, int i2, int i3) {
        return this.mirror ? this.bitMatrix.get(i2, i) : this.bitMatrix.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    byte[] readCodewords() throws FormatException {
        FormatInformation readFormatInformation = readFormatInformation();
        Version readVersion = readVersion();
        DataMask forReference = DataMask.forReference(readFormatInformation.getDataMask());
        int height = this.bitMatrix.getHeight();
        forReference.unmaskBitMatrix(this.bitMatrix, height);
        BitMatrix buildFunctionPattern = readVersion.buildFunctionPattern();
        byte[] bArr = new byte[readVersion.getTotalCodewords()];
        int i = height - 1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i > 0) {
            if (i == 6) {
                i--;
            }
            for (int i6 = 0; i6 < height; i6++) {
                int i7;
                if (i5 != 0) {
                    i7 = (height - 1) - i6;
                } else {
                    i7 = i6;
                }
                for (int i8 = 0; i8 < 2; i8++) {
                    if (!buildFunctionPattern.get(i - i8, i7)) {
                        i2++;
                        i3 <<= 1;
                        if (this.bitMatrix.get(i - i8, i7)) {
                            i3 |= 1;
                        }
                        if (i2 == 8) {
                            i2 = i4 + 1;
                            bArr[i4] = (byte) i3;
                            i3 = 0;
                            i4 = i2;
                            i2 = 0;
                        }
                    }
                }
            }
            i -= 2;
            i5 ^= 1;
        }
        if (i4 == readVersion.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    void remask() {
        if (this.parsedFormatInfo != null) {
            DataMask.forReference(this.parsedFormatInfo.getDataMask()).unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
        }
    }

    void setMirror(boolean z) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = z;
    }

    void mirror() {
        for (int i = 0; i < this.bitMatrix.getWidth(); i++) {
            for (int i2 = i + 1; i2 < this.bitMatrix.getHeight(); i2++) {
                if (this.bitMatrix.get(i, i2) != this.bitMatrix.get(i2, i)) {
                    this.bitMatrix.flip(i2, i);
                    this.bitMatrix.flip(i, i2);
                }
            }
        }
    }
}
