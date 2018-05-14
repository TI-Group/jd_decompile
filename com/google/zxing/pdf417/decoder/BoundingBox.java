package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* compiled from: TbsSdkJava */
final class BoundingBox {
    private ResultPoint bottomLeft;
    private ResultPoint bottomRight;
    private BitMatrix image;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private ResultPoint topLeft;
    private ResultPoint topRight;

    BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        if (!(resultPoint == null && resultPoint3 == null) && (!(resultPoint2 == null && resultPoint4 == null) && ((resultPoint == null || resultPoint2 != null) && (resultPoint3 == null || resultPoint4 != null)))) {
            init(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    BoundingBox(BoundingBox boundingBox) {
        init(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox.topRight, boundingBox.bottomRight);
    }

    private void init(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        this.image = bitMatrix;
        this.topLeft = resultPoint;
        this.bottomLeft = resultPoint2;
        this.topRight = resultPoint3;
        this.bottomRight = resultPoint4;
        calculateMinMaxValues();
    }

    static BoundingBox merge(BoundingBox boundingBox, BoundingBox boundingBox2) throws NotFoundException {
        if (boundingBox == null) {
            return boundingBox2;
        }
        if (boundingBox2 == null) {
            return boundingBox;
        }
        return new BoundingBox(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox2.topRight, boundingBox2.bottomRight);
    }

    BoundingBox addMissingRows(int i, int i2, boolean z) throws NotFoundException {
        int y;
        ResultPoint resultPoint;
        ResultPoint resultPoint2 = this.topLeft;
        ResultPoint resultPoint3 = this.bottomLeft;
        ResultPoint resultPoint4 = this.topRight;
        ResultPoint resultPoint5 = this.bottomRight;
        if (i > 0) {
            ResultPoint resultPoint6 = z ? this.topLeft : this.topRight;
            y = ((int) resultPoint6.getY()) - i;
            if (y < 0) {
                y = 0;
            }
            resultPoint = new ResultPoint(resultPoint6.getX(), (float) y);
            if (!z) {
                resultPoint4 = resultPoint;
                resultPoint = resultPoint2;
            }
        } else {
            resultPoint = resultPoint2;
        }
        if (i2 > 0) {
            resultPoint6 = z ? this.bottomLeft : this.bottomRight;
            y = ((int) resultPoint6.getY()) + i2;
            if (y >= this.image.getHeight()) {
                y = this.image.getHeight() - 1;
            }
            resultPoint2 = new ResultPoint(resultPoint6.getX(), (float) y);
            if (!z) {
                resultPoint5 = resultPoint2;
                resultPoint2 = resultPoint3;
            }
        } else {
            resultPoint2 = resultPoint3;
        }
        calculateMinMaxValues();
        return new BoundingBox(this.image, resultPoint, resultPoint2, resultPoint4, resultPoint5);
    }

    private void calculateMinMaxValues() {
        if (this.topLeft == null) {
            this.topLeft = new ResultPoint(0.0f, this.topRight.getY());
            this.bottomLeft = new ResultPoint(0.0f, this.bottomRight.getY());
        } else if (this.topRight == null) {
            this.topRight = new ResultPoint((float) (this.image.getWidth() - 1), this.topLeft.getY());
            this.bottomRight = new ResultPoint((float) (this.image.getWidth() - 1), this.bottomLeft.getY());
        }
        this.minX = (int) Math.min(this.topLeft.getX(), this.bottomLeft.getX());
        this.maxX = (int) Math.max(this.topRight.getX(), this.bottomRight.getX());
        this.minY = (int) Math.min(this.topLeft.getY(), this.topRight.getY());
        this.maxY = (int) Math.max(this.bottomLeft.getY(), this.bottomRight.getY());
    }

    int getMinX() {
        return this.minX;
    }

    int getMaxX() {
        return this.maxX;
    }

    int getMinY() {
        return this.minY;
    }

    int getMaxY() {
        return this.maxY;
    }

    ResultPoint getTopLeft() {
        return this.topLeft;
    }

    ResultPoint getTopRight() {
        return this.topRight;
    }

    ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }

    ResultPoint getBottomRight() {
        return this.bottomRight;
    }
}
