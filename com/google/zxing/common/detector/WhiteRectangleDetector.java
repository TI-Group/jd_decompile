package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* compiled from: TbsSdkJava */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        int i4 = i / 2;
        this.leftInit = i2 - i4;
        this.rightInit = i2 + i4;
        this.upInit = i3 - i4;
        this.downInit = i4 + i3;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i;
        boolean z = false;
        int i2 = 1;
        int i3 = this.leftInit;
        int i4 = this.rightInit;
        int i5 = this.upInit;
        int i6 = this.downInit;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i7 = 1;
        while (i7 != 0) {
            boolean z7 = true;
            boolean z8 = z5;
            z5 = false;
            while (true) {
                if ((z7 || !z8) && i4 < this.width) {
                    z7 = containsBlackPoint(i5, i6, i4, false);
                    if (z7) {
                        i4++;
                        z8 = true;
                        z5 = true;
                    } else if (!z8) {
                        i4++;
                    }
                }
            }
            if (i4 >= this.width) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            z7 = z4;
            z4 = z5;
            z5 = true;
            while (true) {
                if ((z5 || !z7) && i6 < this.height) {
                    z5 = containsBlackPoint(i3, i4, i6, true);
                    if (z5) {
                        i6++;
                        z7 = true;
                        z4 = true;
                    } else if (!z7) {
                        i6++;
                    }
                }
            }
            if (i6 >= this.height) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            z5 = z3;
            z3 = z4;
            z4 = true;
            while (true) {
                if ((z4 || !z5) && i3 >= 0) {
                    z4 = containsBlackPoint(i5, i6, i3, false);
                    if (z4) {
                        i3--;
                        z5 = true;
                        z3 = true;
                    } else if (!z5) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            z4 = z3;
            z3 = z2;
            z2 = true;
            while (true) {
                if ((z2 || !z3) && i5 >= 0) {
                    z2 = containsBlackPoint(i3, i4, i5, true);
                    if (z2) {
                        i5--;
                        z3 = true;
                        z4 = true;
                    } else if (!z3) {
                        i5--;
                    }
                }
            }
            if (i5 < 0) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            if (z4) {
                z6 = true;
            }
            z2 = z3;
            z3 = z5;
            z5 = z8;
            boolean z9 = z7;
            z7 = z4;
            z4 = z9;
        }
        i = i4;
        i4 = i6;
        i6 = i3;
        i3 = i5;
        if (z || !r0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i8;
        ResultPoint resultPoint;
        int i9 = i - i6;
        ResultPoint resultPoint2 = null;
        for (i8 = 1; i8 < i9; i8++) {
            resultPoint2 = getBlackPointOnSegment((float) i6, (float) (i4 - i8), (float) (i6 + i8), (float) i4);
            if (resultPoint2 != null) {
                resultPoint = resultPoint2;
                break;
            }
        }
        resultPoint = resultPoint2;
        if (resultPoint == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint3;
        resultPoint2 = null;
        for (i8 = 1; i8 < i9; i8++) {
            resultPoint2 = getBlackPointOnSegment((float) i6, (float) (i3 + i8), (float) (i6 + i8), (float) i3);
            if (resultPoint2 != null) {
                resultPoint3 = resultPoint2;
                break;
            }
        }
        resultPoint3 = resultPoint2;
        if (resultPoint3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint4;
        resultPoint2 = null;
        for (i8 = 1; i8 < i9; i8++) {
            resultPoint2 = getBlackPointOnSegment((float) i, (float) (i3 + i8), (float) (i - i8), (float) i3);
            if (resultPoint2 != null) {
                resultPoint4 = resultPoint2;
                break;
            }
        }
        resultPoint4 = resultPoint2;
        if (resultPoint4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        resultPoint2 = null;
        while (i2 < i9) {
            resultPoint2 = getBlackPointOnSegment((float) i, (float) (i4 - i2), (float) (i - i2), (float) i4);
            if (resultPoint2 != null) {
                break;
            }
            i2++;
        }
        if (resultPoint2 != null) {
            return centerEdges(resultPoint2, resultPoint, resultPoint4, resultPoint3);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = (f3 - f) / ((float) round);
        float f6 = (f4 - f2) / ((float) round);
        for (int i = 0; i < round; i++) {
            int round2 = MathUtils.round((((float) i) * f5) + f);
            int round3 = MathUtils.round((((float) i) * f6) + f2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.image.get(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
