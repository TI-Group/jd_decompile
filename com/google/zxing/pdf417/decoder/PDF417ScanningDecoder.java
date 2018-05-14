package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.List;

/* compiled from: TbsSdkJava */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException, FormatException, ChecksumException {
        DetectionResultColumn detectionResultColumn = null;
        int i3 = 0;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        DetectionResult detectionResult = null;
        DetectionResultColumn detectionResultColumn2 = null;
        while (i3 < 2) {
            DetectionResultColumn rowIndicatorColumn;
            DetectionResultColumn rowIndicatorColumn2;
            if (resultPoint != null) {
                rowIndicatorColumn = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i, i2);
            } else {
                rowIndicatorColumn = detectionResultColumn2;
            }
            if (resultPoint3 != null) {
                rowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i, i2);
            } else {
                rowIndicatorColumn2 = detectionResultColumn;
            }
            DetectionResult merge = merge(rowIndicatorColumn, rowIndicatorColumn2);
            if (merge == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (i3 != 0 || merge.getBoundingBox() == null || (merge.getBoundingBox().getMinY() >= boundingBox.getMinY() && merge.getBoundingBox().getMaxY() <= boundingBox.getMaxY())) {
                merge.setBoundingBox(boundingBox);
                detectionResultColumn = rowIndicatorColumn2;
                detectionResult = merge;
                detectionResultColumn2 = rowIndicatorColumn;
                break;
            } else {
                i3++;
                detectionResultColumn = rowIndicatorColumn2;
                detectionResult = merge;
                boundingBox = merge.getBoundingBox();
                detectionResultColumn2 = rowIndicatorColumn;
            }
        }
        int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultColumn2);
        detectionResult.setDetectionResultColumn(barcodeColumnCount, detectionResultColumn);
        boolean z = detectionResultColumn2 != null;
        int i4 = 1;
        int i5 = i2;
        i3 = i;
        while (i4 <= barcodeColumnCount) {
            int i6 = z ? i4 : barcodeColumnCount - i4;
            if (detectionResult.getDetectionResultColumn(i6) == null) {
                DetectionResultColumn detectionResultRowIndicatorColumn;
                if (i6 == 0 || i6 == barcodeColumnCount) {
                    detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, i6 == 0);
                } else {
                    detectionResultRowIndicatorColumn = new DetectionResultColumn(boundingBox);
                }
                detectionResult.setDetectionResultColumn(i6, detectionResultRowIndicatorColumn);
                int minY = boundingBox.getMinY();
                int i7 = -1;
                while (minY <= boundingBox.getMaxY()) {
                    int i8;
                    int startColumn = getStartColumn(detectionResult, i6, minY, z);
                    if (startColumn < 0 || startColumn > boundingBox.getMaxX()) {
                        if (i7 == -1) {
                            i8 = i7;
                            minY++;
                            i7 = i8;
                        } else {
                            startColumn = i7;
                        }
                    }
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z, startColumn, minY, i3, i5);
                    if (detectCodeword != null) {
                        detectionResultRowIndicatorColumn.setCodeword(minY, detectCodeword);
                        i3 = Math.min(i3, detectCodeword.getWidth());
                        i5 = Math.max(i5, detectCodeword.getWidth());
                        i8 = startColumn;
                    } else {
                        i8 = i7;
                    }
                    minY++;
                    i7 = i8;
                }
            }
            i4++;
        }
        return createDecoderResult(detectionResult);
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException, FormatException {
        if (detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2);
        if (barcodeMetadata != null) {
            return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
        }
        return null;
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException, FormatException {
        if (detectionResultRowIndicatorColumn == null) {
            return null;
        }
        int[] rowHeights = detectionResultRowIndicatorColumn.getRowHeights();
        if (rowHeights == null) {
            return null;
        }
        int length;
        int max = getMax(rowHeights);
        int i = 0;
        for (int i2 : rowHeights) {
            i += max - i2;
            if (i2 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        int i3 = i;
        i = 0;
        while (i3 > 0 && codewords[i] == null) {
            i3--;
            i++;
        }
        i = 0;
        for (length = rowHeights.length - 1; length >= 0; length--) {
            i += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        length = i;
        i = codewords.length - 1;
        while (length > 0 && codewords[i] == null) {
            length--;
            i--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i3, length, detectionResultRowIndicatorColumn.isLeft());
    }

    private static int getMax(int[] iArr) {
        int i = -1;
        for (int max : iArr) {
            i = Math.max(i, max);
        }
        return i;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        if (detectionResultRowIndicatorColumn != null) {
            BarcodeMetadata barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata();
            if (barcodeMetadata != null) {
                if (detectionResultRowIndicatorColumn2 != null) {
                    BarcodeMetadata barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata();
                    if (barcodeMetadata2 != null) {
                        if (barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
                            return barcodeMetadata;
                        }
                        return null;
                    }
                }
                return barcodeMetadata;
            }
        }
        if (detectionResultRowIndicatorColumn2 == null) {
            return null;
        }
        return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z, int i, int i2) {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z);
        for (int i3 = 0; i3 < 2; i3++) {
            int i4;
            if (i3 == 0) {
                i4 = 1;
            } else {
                i4 = -1;
            }
            int x = (int) resultPoint.getX();
            int y = (int) resultPoint.getY();
            while (y <= boundingBox.getMaxY() && y >= boundingBox.getMinY()) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y, detectCodeword);
                    if (z) {
                        x = detectCodeword.getStartX();
                    } else {
                        x = detectCodeword.getEndX();
                    }
                }
                y += i4;
            }
        }
        return detectionResultRowIndicatorColumn;
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        int[] value = barcodeValueArr[0][1].getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length == 0) {
            if (barcodeColumnCount < 1 || barcodeColumnCount > PDF417Common.MAX_CODEWORDS_IN_BARCODE) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        } else if (value[0] != barcodeColumnCount) {
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        }
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        int i = 0;
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        Collection arrayList = new ArrayList();
        int[] iArr = new int[(detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount())];
        List arrayList2 = new ArrayList();
        Collection arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < detectionResult.getBarcodeRowCount(); i2++) {
            for (int i3 = 0; i3 < detectionResult.getBarcodeColumnCount(); i3++) {
                Object value = createBarcodeMatrix[i2][i3 + 1].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i2) + i3;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        while (i < iArr2.length) {
            iArr2[i] = (int[]) arrayList2.get(i);
            i++;
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int[] iArr5 = new int[iArr3.length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (i2 = 0; i2 < iArr5.length; i2++) {
                    iArr[iArr3[i2]] = iArr4[i2][iArr5[i2]];
                }
                try {
                    break;
                } catch (ChecksumException e) {
                    if (iArr5.length == 0) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    for (i2 = 0; i2 < iArr5.length; i2++) {
                        if (iArr5[i2] < iArr4[i2].length - 1) {
                            iArr5[i2] = iArr5[i2] + 1;
                            break;
                        }
                        iArr5[i2] = 0;
                        if (i2 == iArr5.length - 1) {
                            throw ChecksumException.getChecksumInstance();
                        }
                    }
                    i2 = i3;
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
        return decodeCodewords(iArr, i, iArr2);
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) throws FormatException {
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, new int[]{detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2});
        for (int i = 0; i < barcodeValueArr.length; i++) {
            for (int i2 = 0; i2 < barcodeValueArr[i].length; i2++) {
                barcodeValueArr[i][i2] = new BarcodeValue();
            }
        }
        int i3 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null) {
                        int rowNumber = codeword.getRowNumber();
                        if (rowNumber < 0) {
                            continue;
                        } else if (rowNumber >= barcodeValueArr.length) {
                            throw FormatException.getFormatInstance();
                        } else {
                            barcodeValueArr[rowNumber][i3].setValue(codeword.getValue());
                        }
                    }
                }
                continue;
            }
            i3++;
        }
        return barcodeValueArr;
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        Codeword codeword = null;
        if (isValidBarcodeColumn(detectionResult, i - i3)) {
            codeword = detectionResult.getDetectionResultColumn(i - i3).getCodeword(i2);
        }
        if (codeword == null) {
            codeword = detectionResult.getDetectionResultColumn(i).getCodewordNearby(i2);
            if (codeword != null) {
                return z ? codeword.getStartX() : codeword.getEndX();
            } else {
                if (isValidBarcodeColumn(detectionResult, i - i3)) {
                    codeword = detectionResult.getDetectionResultColumn(i - i3).getCodewordNearby(i2);
                }
                if (codeword != null) {
                    return z ? codeword.getEndX() : codeword.getStartX();
                } else {
                    int i4 = 0;
                    while (isValidBarcodeColumn(detectionResult, i - i3)) {
                        i -= i3;
                        for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i).getCodewords()) {
                            if (codeword2 != null) {
                                return ((i3 * i4) * (codeword2.getEndX() - codeword2.getStartX())) + (z ? codeword2.getEndX() : codeword2.getStartX());
                            }
                        }
                        i4++;
                    }
                    return z ? detectionResult.getBoundingBox().getMinX() : detectionResult.getBoundingBox().getMaxX();
                }
            }
        } else if (z) {
            return codeword.getEndX();
        } else {
            return codeword.getStartX();
        }
    }

    private static Codeword detectCodeword(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i, i2, z, i3, i4);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i, i2, z, adjustCodewordStartColumn, i4);
        if (moduleBitCount == null) {
            return null;
        }
        int i7;
        int bitCountSum = PDF417Common.getBitCountSum(moduleBitCount);
        if (z) {
            i7 = adjustCodewordStartColumn;
            adjustCodewordStartColumn += bitCountSum;
        } else {
            for (i7 = 0; i7 < moduleBitCount.length / 2; i7++) {
                int i8 = moduleBitCount[i7];
                moduleBitCount[i7] = moduleBitCount[(moduleBitCount.length - 1) - i7];
                moduleBitCount[(moduleBitCount.length - 1) - i7] = i8;
            }
            i7 = adjustCodewordStartColumn - bitCountSum;
        }
        if (!checkCodewordSkew(bitCountSum, i5, i6)) {
            return null;
        }
        bitCountSum = PDF417CodewordDecoder.getDecodedValue(moduleBitCount);
        i8 = PDF417Common.getCodeword(bitCountSum);
        if (i8 == -1) {
            return null;
        }
        return new Codeword(i7, adjustCodewordStartColumn, getCodewordBucketNumber(bitCountSum), i8);
    }

    private static int[] getModuleBitCount(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        boolean z2 = z;
        int i6 = 0;
        while (true) {
            if (((z && i3 < i2) || (!z && i3 >= i)) && i6 < iArr.length) {
                if (bitMatrix.get(i3, i4) == z2) {
                    iArr[i6] = iArr[i6] + 1;
                    i3 += i5;
                } else {
                    i6++;
                    z2 = !z2;
                }
            }
        }
        if (i6 == iArr.length || (((z && i3 == i2) || (!z && i3 == i)) && i6 == iArr.length - 1)) {
            return iArr;
        }
        return null;
    }

    private static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    private static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5 = 0;
        int i6 = z ? -1 : 1;
        int i7 = i3;
        while (i5 < 2) {
            int i8 = i7;
            while (true) {
                if (((!z || i8 < i) && (z || i8 >= i2)) || z != bitMatrix.get(i8, i4)) {
                    i6 = -i6;
                } else if (Math.abs(i3 - i8) > 2) {
                    return i3;
                } else {
                    i8 += i6;
                }
            }
            i6 = -i6;
            i5++;
            z = !z;
            i7 = i8;
        }
        return i7;
    }

    private static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 + -2 <= i && i <= i3 + 2;
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i2 = 1 << (i + 1);
        int correctErrors = correctErrors(iArr, iArr2, i2);
        verifyCodewordCount(iArr, i2);
        DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i));
        decode.setErrorsCorrected(Integer.valueOf(correctErrors));
        decode.setErasures(Integer.valueOf(iArr2.length));
        return decode;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return errorCorrection.decode(iArr, i, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static void verifyCodewordCount(int[] iArr, int i) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw FormatException.getFormatInstance();
        } else if (i2 != 0) {
        } else {
            if (i < iArr.length) {
                iArr[0] = iArr.length - i;
                return;
            }
            throw FormatException.getFormatInstance();
        }
    }

    private static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int length = iArr.length - 1;
        while (true) {
            if ((i & 1) != i2) {
                i2 = i & 1;
                length--;
                if (length < 0) {
                    return iArr;
                }
            }
            iArr[length] = iArr[length] + 1;
            i >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        Formatter formatter = new Formatter();
        for (int i = 0; i < barcodeValueArr.length; i++) {
            formatter.format("Row %2d: ", new Object[]{Integer.valueOf(i)});
            for (BarcodeValue value : barcodeValueArr[i]) {
                if (value.getValue().length == 0) {
                    formatter.format("        ", (Object[]) null);
                } else {
                    formatter.format("%4d(%2d)", new Object[]{Integer.valueOf(barcodeValueArr[i][r3].getValue()[0]), barcodeValueArr[i][r3].getConfidence(barcodeValueArr[i][r3].getValue()[0])});
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
