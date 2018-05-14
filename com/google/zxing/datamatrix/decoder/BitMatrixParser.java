package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* compiled from: TbsSdkJava */
final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        this.mappingBitMatrix = extractDataRegion(bitMatrix);
        this.readMappingMatrix = new BitMatrix(this.mappingBitMatrix.getWidth(), this.mappingBitMatrix.getHeight());
    }

    Version getVersion() {
        return this.version;
    }

    private static Version readVersion(BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    byte[] readCodewords() throws FormatException {
        Object obj = null;
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int i = 0;
        int i2 = 4;
        int i3 = 0;
        while (true) {
            int i4;
            if (i2 == height && i == 0 && r4 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) readCorner1(height, width);
                int i5 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i5;
                obj4 = 1;
            } else if (i2 == height - 2 && i == 0 && (width & 3) != 0 && r3 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) readCorner2(height, width);
                int i6 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i6;
                i6 = 1;
            } else if (i2 == height + 4 && i == 2 && (width & 7) == 0 && r2 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) readCorner3(height, width);
                int i7 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i7;
                i7 = 1;
            } else if (i2 == height - 2 && i == 0 && (width & 7) == 4 && r0 == null) {
                i4 = i3 + 1;
                bArr[i3] = (byte) readCorner4(height, width);
                int i8 = i + 2;
                i = i4;
                i4 = i2 - 2;
                i2 = i8;
                i8 = 1;
            } else {
                i4 = i;
                int i9 = i2;
                i2 = i3;
                i3 = i9;
                while (true) {
                    if (i3 >= height || i4 < 0 || this.readMappingMatrix.get(i4, i3)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        bArr[i2] = (byte) readUtah(i3, i4, height, width);
                    }
                    i3 -= 2;
                    i2 = i4 + 2;
                    if (i3 < 0 || i2 >= width) {
                        i3++;
                        i4 = i2 + 3;
                        i2 = i;
                    } else {
                        i4 = i2;
                        i2 = i;
                    }
                }
                i3++;
                i4 = i2 + 3;
                i2 = i;
                while (true) {
                    if (i3 < 0 || i4 >= width || this.readMappingMatrix.get(i4, i3)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        bArr[i2] = (byte) readUtah(i3, i4, height, width);
                    }
                    i3 += 2;
                    i2 = i4 - 2;
                    if (i3 >= height || i2 < 0) {
                        i4 = i3 + 3;
                        i2++;
                    } else {
                        i4 = i2;
                        i2 = i;
                    }
                }
                i4 = i3 + 3;
                i2++;
            }
            if (i4 >= height && i2 >= width) {
                break;
            }
            i3 = i;
            i = i2;
            i2 = i4;
        }
        if (i == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    boolean readModule(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i < 0) {
            i5 = i + i3;
            i6 = (4 - ((i3 + 4) & 7)) + i2;
        } else {
            i6 = i2;
            i5 = i;
        }
        if (i6 < 0) {
            i6 += i4;
            i5 += 4 - ((i4 + 4) & 7);
        }
        this.readMappingMatrix.set(i6, i5);
        return this.mappingBitMatrix.get(i6, i5);
    }

    int readUtah(int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (readModule(i - 2, i2 - 2, i3, i4)) {
            i5 = 1;
        }
        i5 <<= 1;
        if (readModule(i - 2, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i - 1, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i - 1, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i - 1, i2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i, i2, i3, i4)) {
            return i5 | 1;
        }
        return i5;
    }

    int readCorner1(int i, int i2) {
        int i3;
        if (readModule(i - 1, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (readModule(i - 1, 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(i - 1, 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(3, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    int readCorner2(int i, int i2) {
        int i3;
        if (readModule(i - 3, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (readModule(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    int readCorner3(int i, int i2) {
        int i3;
        if (readModule(i - 1, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (readModule(i - 1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    int readCorner4(int i, int i2) {
        int i3;
        if (readModule(i - 3, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (readModule(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(3, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() != symbolSizeRows) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int dataRegionSizeRows = this.version.getDataRegionSizeRows();
        int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
        int i = symbolSizeRows / dataRegionSizeRows;
        int i2 = symbolSizeColumns / dataRegionSizeColumns;
        BitMatrix bitMatrix2 = new BitMatrix(i2 * dataRegionSizeColumns, i * dataRegionSizeRows);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * dataRegionSizeRows;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * dataRegionSizeColumns;
                for (symbolSizeColumns = 0; symbolSizeColumns < dataRegionSizeRows; symbolSizeColumns++) {
                    int i7 = (((dataRegionSizeRows + 2) * i3) + 1) + symbolSizeColumns;
                    int i8 = i4 + symbolSizeColumns;
                    for (symbolSizeRows = 0; symbolSizeRows < dataRegionSizeColumns; symbolSizeRows++) {
                        if (bitMatrix.get((((dataRegionSizeColumns + 2) * i5) + 1) + symbolSizeRows, i7)) {
                            bitMatrix2.set(i6 + symbolSizeRows, i8);
                        }
                    }
                }
            }
        }
        return bitMatrix2;
    }
}
