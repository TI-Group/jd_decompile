package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* compiled from: TbsSdkJava */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        int totalBitsInLayer;
        int i3;
        int i4;
        int i5;
        boolean z;
        BitArray bitArray;
        int i6;
        int i7;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        int abs;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            abs = Math.abs(i2);
            if (abs > (z2 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
            totalBitsInLayer = totalBitsInLayer(abs, z2);
            i3 = WORD_SIZE[abs];
            i4 = totalBitsInLayer - (totalBitsInLayer % i3);
            BitArray stuffBits = stuffBits(encode, i3);
            if (stuffBits.getSize() + size > i4) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            } else if (!z2 || stuffBits.getSize() <= i3 * 64) {
                BitArray bitArray2 = stuffBits;
                i5 = i3;
                i3 = totalBitsInLayer;
                totalBitsInLayer = abs;
                z = z2;
                bitArray = bitArray2;
            } else {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        }
        i5 = 0;
        bitArray = null;
        totalBitsInLayer = 0;
        while (totalBitsInLayer <= 32) {
            boolean z3 = totalBitsInLayer <= 3;
            if (z3) {
                i3 = totalBitsInLayer + 1;
            } else {
                i3 = totalBitsInLayer;
            }
            abs = totalBitsInLayer(i3, z3);
            if (size2 <= abs) {
                if (i5 != WORD_SIZE[i3]) {
                    i5 = WORD_SIZE[i3];
                    bitArray = stuffBits(encode, i5);
                }
                int i8 = abs - (abs % i5);
                if ((!z3 || r2.getSize() <= i5 * 64) && r2.getSize() + size <= i8) {
                    totalBitsInLayer = i3;
                    i3 = abs;
                    z = z3;
                }
            }
            totalBitsInLayer++;
        }
        throw new IllegalArgumentException("Data too large for an Aztec code");
        BitArray generateCheckWords = generateCheckWords(bitArray, i3, i5);
        int size3 = bitArray.getSize() / i5;
        BitArray generateModeMessage = generateModeMessage(z, totalBitsInLayer, size3);
        if (z) {
            i6 = (totalBitsInLayer * 4) + 11;
        } else {
            i6 = (totalBitsInLayer * 4) + 14;
        }
        int[] iArr = new int[i6];
        if (z) {
            for (i5 = 0; i5 < iArr.length; i5++) {
                iArr[i5] = i5;
            }
            i5 = i6;
        } else {
            i5 = (i6 + 1) + ((((i6 / 2) - 1) / 15) * 2);
            i4 = i6 / 2;
            i7 = i5 / 2;
            for (i3 = 0; i3 < i4; i3++) {
                size = (i3 / 15) + i3;
                iArr[(i4 - i3) - 1] = (i7 - size) - 1;
                iArr[i4 + i3] = (size + i7) + 1;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i5);
        size = 0;
        for (size2 = 0; size2 < totalBitsInLayer; size2++) {
            i3 = z ? ((totalBitsInLayer - size2) * 4) + 9 : ((totalBitsInLayer - size2) * 4) + 12;
            for (i7 = 0; i7 < i3; i7++) {
                int i9 = i7 * 2;
                for (i4 = 0; i4 < 2; i4++) {
                    if (generateCheckWords.get((size + i9) + i4)) {
                        bitMatrix.set(iArr[(size2 * 2) + i4], iArr[(size2 * 2) + i7]);
                    }
                    if (generateCheckWords.get((((i3 * 2) + size) + i9) + i4)) {
                        bitMatrix.set(iArr[(size2 * 2) + i7], iArr[((i6 - 1) - (size2 * 2)) - i4]);
                    }
                    if (generateCheckWords.get((((i3 * 4) + size) + i9) + i4)) {
                        bitMatrix.set(iArr[((i6 - 1) - (size2 * 2)) - i4], iArr[((i6 - 1) - (size2 * 2)) - i7]);
                    }
                    if (generateCheckWords.get((((i3 * 6) + size) + i9) + i4)) {
                        bitMatrix.set(iArr[((i6 - 1) - (size2 * 2)) - i7], iArr[(size2 * 2) + i4]);
                    }
                }
            }
            size = (i3 * 8) + size;
        }
        drawModeMessage(bitMatrix, z, i5, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i5 / 2, 5);
        } else {
            drawBullsEye(bitMatrix, i5 / 2, 7);
            i4 = 0;
            i3 = 0;
            while (i4 < (i6 / 2) - 1) {
                for (i7 = (i5 / 2) & 1; i7 < i5; i7 += 2) {
                    bitMatrix.set((i5 / 2) - i3, i7);
                    bitMatrix.set((i5 / 2) + i3, i7);
                    bitMatrix.set(i7, (i5 / 2) - i3);
                    bitMatrix.set(i7, (i5 / 2) + i3);
                }
                i4 += 15;
                i3 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i5);
        aztecCode.setLayers(totalBitsInLayer);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            for (int i4 = i - i3; i4 <= i + i3; i4++) {
                bitMatrix.set(i4, i - i3);
                bitMatrix.set(i4, i + i3);
                bitMatrix.set(i - i3, i4);
                bitMatrix.set(i + i3, i4);
            }
        }
        bitMatrix.set(i - i2, i - i2);
        bitMatrix.set((i - i2) + 1, i - i2);
        bitMatrix.set(i - i2, (i - i2) + 1);
        bitMatrix.set(i + i2, i - i2);
        bitMatrix.set(i + i2, (i - i2) + 1);
        bitMatrix.set(i + i2, (i + i2) - 1);
    }

    static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = 0;
        int i3 = i / 2;
        int i4;
        if (z) {
            while (i2 < 7) {
                i4 = (i3 - 3) + i2;
                if (bitArray.get(i2)) {
                    bitMatrix.set(i4, i3 - 5);
                }
                if (bitArray.get(i2 + 7)) {
                    bitMatrix.set(i3 + 5, i4);
                }
                if (bitArray.get(20 - i2)) {
                    bitMatrix.set(i4, i3 + 5);
                }
                if (bitArray.get(27 - i2)) {
                    bitMatrix.set(i3 - 5, i4);
                }
                i2++;
            }
            return;
        }
        while (i2 < 10) {
            i4 = ((i3 - 5) + i2) + (i2 / 5);
            if (bitArray.get(i2)) {
                bitMatrix.set(i4, i3 - 7);
            }
            if (bitArray.get(i2 + 10)) {
                bitMatrix.set(i3 + 7, i4);
            }
            if (bitArray.get(29 - i2)) {
                bitMatrix.set(i4, i3 + 7);
            }
            if (bitArray.get(39 - i2)) {
                bitMatrix.set(i3 - 7, i4);
            }
            i2++;
        }
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        int size = bitArray.getSize() / i2;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i4 = i / i2;
        int[] bitsToWords = bitsToWords(bitArray, i2, i4);
        reedSolomonEncoder.encode(bitsToWords, i4 - size);
        size = i % i2;
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, size);
        size = bitsToWords.length;
        while (i3 < size) {
            bitArray2.appendBits(bitsToWords[i3], i2);
            i3++;
        }
        return bitArray2;
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6;
                if (bitArray.get((i3 * i) + i5)) {
                    i6 = 1 << ((i - i5) - 1);
                } else {
                    i6 = 0;
                }
                i4 |= i6;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static GenericGF getGF(int i) {
        switch (i) {
            case 4:
                return GenericGF.AZTEC_PARAM;
            case 6:
                return GenericGF.AZTEC_DATA_6;
            case 8:
                return GenericGF.AZTEC_DATA_8;
            case 10:
                return GenericGF.AZTEC_DATA_10;
            case 12:
                return GenericGF.AZTEC_DATA_12;
            default:
                return null;
        }
    }

    static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i) {
                if (i3 + i4 >= size || bitArray.get(i3 + i4)) {
                    i5 |= 1 << ((i - 1) - i4);
                }
                i4++;
            }
            if ((i5 & i2) == i2) {
                bitArray2.appendBits(i5 & i2, i);
                i5 = i3 - 1;
            } else if ((i5 & i2) == 0) {
                bitArray2.appendBits(i5 | 1, i);
                i5 = i3 - 1;
            } else {
                bitArray2.appendBits(i5, i);
                i5 = i3;
            }
            i3 = i5 + i;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }
}
