package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

/* compiled from: TbsSdkJava */
public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets = new int[32];
    private byte[] luminances = EMPTY;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        int i2;
        int i3;
        int i4 = 1;
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i, this.luminances);
        int[] iArr = this.buckets;
        for (i2 = 0; i2 < width; i2++) {
            i3 = (row[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        i3 = estimateBlackPoint(iArr);
        i2 = row[1] & 255;
        int i5 = row[0] & 255;
        while (i4 < width - 1) {
            int i6 = row[i4 + 1] & 255;
            if ((((i2 * 4) - i5) - i6) / 2 < i3) {
                bitArray.set(i4);
            }
            i4++;
            i5 = i2;
            i2 = i6;
        }
        return bitArray;
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        int i;
        int i2;
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (i = 1; i < 5; i++) {
            byte[] row = luminanceSource.getRow((height * i) / 5, this.luminances);
            int i3 = (width * 4) / 5;
            for (i2 = width / 5; i2 < i3; i2++) {
                int i4 = (row[i2] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (i = 0; i < height; i++) {
            int i5 = i * width;
            for (i2 = 0; i2 < width; i2++) {
                if ((matrix[i5 + i2] & 255) < estimateBlackPoint) {
                    bitMatrix.set(i2, i);
                }
            }
        }
        return bitMatrix;
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    private void initArrays(int i) {
        if (this.luminances.length < i) {
            this.luminances = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.buckets[i2] = 0;
        }
    }

    private static int estimateBlackPoint(int[] iArr) throws NotFoundException {
        int i;
        int i2 = 0;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (i = 0; i < length; i++) {
            if (iArr[i] > i3) {
                i3 = iArr[i];
                i4 = i;
            }
            if (iArr[i] > i5) {
                i5 = iArr[i];
            }
        }
        i = 0;
        int i6 = 0;
        while (i2 < length) {
            i3 = i2 - i4;
            i3 *= iArr[i2] * i3;
            if (i3 > i) {
                i = i2;
            } else {
                i3 = i;
                i = i6;
            }
            i2++;
            i6 = i;
            i = i3;
        }
        if (i4 <= i6) {
            int i7 = i6;
            i6 = i4;
            i4 = i7;
        }
        if (i4 - i6 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        length = i4 - 1;
        i = -1;
        i2 = i4 - 1;
        while (i2 > i6) {
            i3 = i2 - i6;
            i3 = ((i3 * i3) * (i4 - i2)) * (i5 - iArr[i2]);
            if (i3 > i) {
                i = i2;
            } else {
                i3 = i;
                i = length;
            }
            i2--;
            length = i;
            i = i3;
        }
        return length << 3;
    }
}
