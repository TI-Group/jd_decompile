package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final int[] INDEXES_START_PATTERN = new int[]{0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = new int[]{6, 2, 7, 3};
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] START_PATTERN = new int[]{8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = new int[]{7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List detect = detect(z, blackMatrix);
        if (detect.isEmpty()) {
            blackMatrix = blackMatrix.clone();
            blackMatrix.rotate180();
            detect = detect(z, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, detect);
    }

    private static List<ResultPoint[]> detect(boolean z, BitMatrix bitMatrix) {
        List<ResultPoint[]> arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < bitMatrix.getHeight()) {
            Object findVertices = findVertices(bitMatrix, i3, i2);
            if (findVertices[0] != null || findVertices[3] != null) {
                arrayList.add(findVertices);
                if (!z) {
                    break;
                }
                if (findVertices[2] != null) {
                    i = (int) findVertices[2].getX();
                    i2 = (int) findVertices[2].getY();
                } else {
                    i = (int) findVertices[4].getX();
                    i2 = (int) findVertices[4].getY();
                }
                i3 = i2;
                i2 = i;
                i = 1;
            } else if (i == 0) {
                break;
            } else {
                for (ResultPoint[] resultPointArr : arrayList) {
                    if (resultPointArr[1] != null) {
                        i3 = (int) Math.max((float) i3, resultPointArr[1].getY());
                    }
                    if (resultPointArr[3] != null) {
                        i3 = Math.max(i3, (int) resultPointArr[3].getY());
                    }
                }
                i2 = 0;
                i3 += 5;
                i = 0;
            }
        }
        return arrayList;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i, int i2) {
        int x;
        int y;
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, START_PATTERN), INDEXES_START_PATTERN);
        if (resultPointArr[4] != null) {
            x = (int) resultPointArr[4].getX();
            y = (int) resultPointArr[4].getY();
        } else {
            x = i2;
            y = i;
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, y, x, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            resultPointArr[iArr[i]] = resultPointArr2[i];
        }
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        Object obj;
        int i6;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i7 = i3;
        while (i7 < i) {
            int[] findGuardPattern = findGuardPattern(bitMatrix, i4, i7, i2, false, iArr, iArr2);
            int[] iArr3;
            int i8;
            int i9;
            if (findGuardPattern != null) {
                iArr3 = findGuardPattern;
                i5 = i7;
                while (i5 > 0) {
                    i7 = i5 - 1;
                    findGuardPattern = findGuardPattern(bitMatrix, i4, i7, i2, false, iArr, iArr2);
                    if (findGuardPattern == null) {
                        i5 = i7 + 1;
                        break;
                    }
                    iArr3 = findGuardPattern;
                    i5 = i7;
                }
                resultPointArr[0] = new ResultPoint((float) iArr3[0], (float) i5);
                resultPointArr[1] = new ResultPoint((float) iArr3[1], (float) i5);
                obj = 1;
                i6 = i5;
                i5 = i6 + 1;
                if (obj != null) {
                    iArr3 = new int[]{(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
                    i8 = 0;
                    i7 = i5;
                    while (i7 < i) {
                        findGuardPattern = findGuardPattern(bitMatrix, iArr3[0], i7, i2, false, iArr, iArr2);
                        if (findGuardPattern == null && Math.abs(iArr3[0] - findGuardPattern[0]) < 5 && Math.abs(iArr3[1] - findGuardPattern[1]) < 5) {
                            i9 = 0;
                        } else if (i8 > 25) {
                            break;
                        } else {
                            i9 = i8 + 1;
                            findGuardPattern = iArr3;
                        }
                        i7++;
                        iArr3 = findGuardPattern;
                        i8 = i9;
                    }
                    i5 = i7 - (i8 + 1);
                    resultPointArr[2] = new ResultPoint((float) iArr3[0], (float) i5);
                    resultPointArr[3] = new ResultPoint((float) iArr3[1], (float) i5);
                }
                if (i5 - i6 < 10) {
                    for (i5 = 0; i5 < resultPointArr.length; i5++) {
                        resultPointArr[i5] = null;
                    }
                }
                return resultPointArr;
            }
            i7 += 5;
        }
        obj = null;
        i6 = i7;
        i5 = i6 + 1;
        if (obj != null) {
            iArr3 = new int[]{(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            i8 = 0;
            i7 = i5;
            while (i7 < i) {
                findGuardPattern = findGuardPattern(bitMatrix, iArr3[0], i7, i2, false, iArr, iArr2);
                if (findGuardPattern == null) {
                }
                if (i8 > 25) {
                    break;
                }
                i9 = i8 + 1;
                findGuardPattern = iArr3;
                i7++;
                iArr3 = findGuardPattern;
                i8 = i9;
            }
            i5 = i7 - (i8 + 1);
            resultPointArr[2] = new ResultPoint((float) iArr3[0], (float) i5);
            resultPointArr[3] = new ResultPoint((float) iArr3[1], (float) i5);
        }
        if (i5 - i6 < 10) {
            for (i5 = 0; i5 < resultPointArr.length; i5++) {
                resultPointArr[i5] = null;
            }
        }
        return resultPointArr;
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        int i4;
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i5 = 0;
        while (bitMatrix.get(i, i2) && i > 0) {
            i4 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i--;
            i5 = i4;
        }
        i5 = 0;
        i4 = i;
        int i6 = z;
        while (i < i3) {
            if ((bitMatrix.get(i, i2) ^ i6) != 0) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                    return new int[]{i4, i};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                i6 = i6 == 0 ? 1 : 0;
            }
            i++;
        }
        if (i5 != length - 1 || patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) >= MAX_AVG_VARIANCE) {
            return null;
        }
        return new int[]{i4, i - 1};
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int i;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (i = 0; i < length; i++) {
            i3 += iArr[i];
            i2 += iArr2[i];
        }
        if (i3 < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = ((float) i3) / ((float) i2);
        float f3 = f * f2;
        float f4 = 0.0f;
        for (i = 0; i < length; i++) {
            int i4 = iArr[i];
            float f5 = ((float) iArr2[i]) * f2;
            float f6 = ((float) i4) > f5 ? ((float) i4) - f5 : f5 - ((float) i4);
            if (f6 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f6;
        }
        return f4 / ((float) i3);
    }
}
