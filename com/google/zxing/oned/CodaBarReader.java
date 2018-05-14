package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class CodaBarReader extends OneDReader {
    static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCD";
    static final int[] CHARACTER_ENCODINGS = new int[]{3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final float MAX_ACCEPTABLE = 2.0f;
    private static final int MIN_CHARACTER_LENGTH = 3;
    private static final float PADDING = 1.5f;
    private static final char[] STARTEND_ENCODING = new char[]{'A', 'B', 'C', 'D'};
    private int counterLength = 0;
    private int[] counters = new int[80];
    private final StringBuilder decodeRowResult = new StringBuilder(20);

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.counters, 0);
        setCounters(bitArray);
        int findStartPattern = findStartPattern();
        this.decodeRowResult.setLength(0);
        int i2 = findStartPattern;
        do {
            int toNarrowWidePattern = toNarrowWidePattern(i2);
            if (toNarrowWidePattern != -1) {
                this.decodeRowResult.append((char) toNarrowWidePattern);
                i2 += 8;
                if (this.decodeRowResult.length() > 1 && arrayContains(STARTEND_ENCODING, ALPHABET[toNarrowWidePattern])) {
                    break;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } while (i2 < this.counterLength);
        int i3 = this.counters[i2 - 1];
        int i4 = 0;
        for (toNarrowWidePattern = -8; toNarrowWidePattern < -1; toNarrowWidePattern++) {
            i4 += this.counters[i2 + toNarrowWidePattern];
        }
        if (i2 >= this.counterLength || i3 >= i4 / 2) {
            validatePattern(findStartPattern);
            for (toNarrowWidePattern = 0; toNarrowWidePattern < this.decodeRowResult.length(); toNarrowWidePattern++) {
                this.decodeRowResult.setCharAt(toNarrowWidePattern, ALPHABET[this.decodeRowResult.charAt(toNarrowWidePattern)]);
            }
            if (arrayContains(STARTEND_ENCODING, this.decodeRowResult.charAt(0))) {
                if (!arrayContains(STARTEND_ENCODING, this.decodeRowResult.charAt(this.decodeRowResult.length() - 1))) {
                    throw NotFoundException.getNotFoundInstance();
                } else if (this.decodeRowResult.length() <= 3) {
                    throw NotFoundException.getNotFoundInstance();
                } else {
                    if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                        this.decodeRowResult.deleteCharAt(this.decodeRowResult.length() - 1);
                        this.decodeRowResult.deleteCharAt(0);
                    }
                    i4 = 0;
                    toNarrowWidePattern = 0;
                    while (i4 < findStartPattern) {
                        i3 = this.counters[i4] + toNarrowWidePattern;
                        i4++;
                        toNarrowWidePattern = i3;
                    }
                    float f = (float) toNarrowWidePattern;
                    while (findStartPattern < i2 - 1) {
                        toNarrowWidePattern += this.counters[findStartPattern];
                        findStartPattern++;
                    }
                    float f2 = (float) toNarrowWidePattern;
                    return new Result(this.decodeRowResult.toString(), null, new ResultPoint[]{new ResultPoint(f, (float) i), new ResultPoint(f2, (float) i)}, BarcodeFormat.CODABAR);
                }
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    void validatePattern(int i) throws NotFoundException {
        int i2;
        int[] iArr = new int[]{0, 0, 0, 0};
        int[] iArr2 = new int[]{0, 0, 0, 0};
        int length = this.decodeRowResult.length() - 1;
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i3)];
            for (i2 = 6; i2 >= 0; i2--) {
                int i6 = (i2 & 1) + ((i5 & 1) * 2);
                iArr[i6] = iArr[i6] + this.counters[i4 + i2];
                iArr2[i6] = iArr2[i6] + 1;
                i5 >>= 1;
            }
            if (i3 >= length) {
                break;
            }
            i4 += 8;
            i3++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (i3 = 0; i3 < 2; i3++) {
            fArr2[i3] = 0.0f;
            fArr2[i3 + 2] = ((((float) iArr[i3]) / ((float) iArr2[i3])) + (((float) iArr[i3 + 2]) / ((float) iArr2[i3 + 2]))) / MAX_ACCEPTABLE;
            fArr[i3] = fArr2[i3 + 2];
            fArr[i3 + 2] = ((((float) iArr[i3 + 2]) * MAX_ACCEPTABLE) + PADDING) / ((float) iArr2[i3 + 2]);
        }
        i3 = 0;
        loop3:
        while (true) {
            i2 = CHARACTER_ENCODINGS[this.decodeRowResult.charAt(i3)];
            i4 = 6;
            while (i4 >= 0) {
                int i7 = (i4 & 1) + ((i2 & 1) * 2);
                int i8 = this.counters[i + i4];
                if (((float) i8) >= fArr2[i7] && ((float) i8) <= fArr[i7]) {
                    i2 >>= 1;
                    i4--;
                }
            }
            if (i3 < length) {
                i += 8;
                i3++;
            } else {
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void setCounters(BitArray bitArray) throws NotFoundException {
        this.counterLength = 0;
        int nextUnset = bitArray.getNextUnset(0);
        int size = bitArray.getSize();
        if (nextUnset >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = 1;
        nextUnset = 0;
        for (int i2 = nextUnset; i2 < size; i2++) {
            if ((bitArray.get(i2) ^ i) != 0) {
                nextUnset++;
            } else {
                counterAppend(nextUnset);
                i = i == 0 ? 1 : 0;
                nextUnset = 1;
            }
        }
        counterAppend(nextUnset);
    }

    private void counterAppend(int i) {
        this.counters[this.counterLength] = i;
        this.counterLength++;
        if (this.counterLength >= this.counters.length) {
            Object obj = new int[(this.counterLength * 2)];
            System.arraycopy(this.counters, 0, obj, 0, this.counterLength);
            this.counters = obj;
        }
    }

    private int findStartPattern() throws NotFoundException {
        int i = 1;
        while (i < this.counterLength) {
            int toNarrowWidePattern = toNarrowWidePattern(i);
            if (toNarrowWidePattern != -1 && arrayContains(STARTEND_ENCODING, ALPHABET[toNarrowWidePattern])) {
                int i2 = 0;
                for (toNarrowWidePattern = i; toNarrowWidePattern < i + 7; toNarrowWidePattern++) {
                    i2 += this.counters[toNarrowWidePattern];
                }
                if (i == 1 || this.counters[i - 1] >= i2 / 2) {
                    return i;
                }
            }
            i += 2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static boolean arrayContains(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    private int toNarrowWidePattern(int i) {
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = i + 7;
        if (i3 >= this.counterLength) {
            return -1;
        }
        int[] iArr = this.counters;
        int i4 = i;
        int i5 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = iArr[i4];
            if (i7 < i5) {
                i5 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        i5 = (i5 + i6) / 2;
        i4 = i + 1;
        i6 = 0;
        while (i4 < i3) {
            i7 = iArr[i4];
            if (i7 < i2) {
                i2 = i7;
            }
            if (i7 <= i6) {
                i7 = i6;
            }
            i4 += 2;
            i6 = i7;
        }
        i6 = (i2 + i6) / 2;
        i4 = 0;
        i2 = 0;
        i3 = 128;
        while (i4 < 7) {
            if ((i4 & 1) == 0) {
                i7 = i5;
            } else {
                i7 = i6;
            }
            i3 >>= 1;
            if (iArr[i + i4] > i7) {
                i7 = i2 | i3;
            } else {
                i7 = i2;
            }
            i4++;
            i2 = i7;
        }
        for (i7 = 0; i7 < CHARACTER_ENCODINGS.length; i7++) {
            if (CHARACTER_ENCODINGS[i7] == i2) {
                return i7;
            }
        }
        return -1;
    }
}
