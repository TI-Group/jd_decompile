package com.google.zxing.datamatrix.detector;

import cn.jiguang.net.HttpUtils;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: TbsSdkJava */
public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    /* compiled from: TbsSdkJava */
    private static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i;
        }

        ResultPoint getFrom() {
            return this.from;
        }

        ResultPoint getTo() {
            return this.to;
        }

        public int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + HttpUtils.PATHS_SEPARATOR + this.to + '/' + this.transitions;
        }
    }

    /* compiled from: TbsSdkJava */
    private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    public DetectorResult detect() throws NotFoundException {
        ResultPoint[] detect = this.rectangleDetector.detect();
        ResultPoint resultPoint = detect[0];
        ResultPoint resultPoint2 = detect[1];
        ResultPoint resultPoint3 = detect[2];
        ResultPoint resultPoint4 = detect[3];
        List arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint, resultPoint2));
        arrayList.add(transitionsBetween(resultPoint, resultPoint3));
        arrayList.add(transitionsBetween(resultPoint2, resultPoint4));
        arrayList.add(transitionsBetween(resultPoint3, resultPoint4));
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        Map hashMap = new HashMap();
        increment(hashMap, resultPointsAndTransitions.getFrom());
        increment(hashMap, resultPointsAndTransitions.getTo());
        increment(hashMap, resultPointsAndTransitions2.getFrom());
        increment(hashMap, resultPointsAndTransitions2.getTo());
        ResultPoint resultPoint5 = null;
        ResultPoint resultPoint6 = null;
        ResultPoint resultPoint7 = null;
        for (Entry entry : hashMap.entrySet()) {
            ResultPoint resultPoint8;
            ResultPoint resultPoint9 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                resultPoint8 = resultPoint9;
                resultPoint9 = resultPoint7;
                resultPoint7 = resultPoint5;
            } else if (resultPoint5 == null) {
                resultPoint8 = resultPoint6;
                ResultPoint resultPoint10 = resultPoint7;
                resultPoint7 = resultPoint9;
                resultPoint9 = resultPoint10;
            } else {
                resultPoint8 = resultPoint6;
                resultPoint7 = resultPoint5;
            }
            resultPoint6 = resultPoint8;
            resultPoint5 = resultPoint7;
            resultPoint7 = resultPoint9;
        }
        if (resultPoint5 == null || resultPoint6 == null || resultPoint7 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        BitMatrix sampleGrid;
        detect = new ResultPoint[]{resultPoint5, resultPoint6, resultPoint7};
        ResultPoint.orderBestPatterns(detect);
        resultPoint7 = detect[0];
        resultPoint9 = detect[1];
        resultPoint6 = detect[2];
        if (!hashMap.containsKey(resultPoint)) {
            resultPoint5 = resultPoint;
        } else if (!hashMap.containsKey(resultPoint2)) {
            resultPoint5 = resultPoint2;
        } else if (hashMap.containsKey(resultPoint3)) {
            resultPoint5 = resultPoint4;
        } else {
            resultPoint5 = resultPoint3;
        }
        int transitions = transitionsBetween(resultPoint6, resultPoint5).getTransitions();
        int transitions2 = transitionsBetween(resultPoint7, resultPoint5).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        transitions += 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i = transitions2 + 2;
        int transitions3;
        if (transitions * 4 >= i * 7 || i * 4 >= transitions * 7) {
            resultPoint4 = correctTopRightRectangular(resultPoint9, resultPoint7, resultPoint6, resultPoint5, transitions, i);
            if (resultPoint4 == null) {
                resultPoint4 = resultPoint5;
            }
            transitions3 = transitionsBetween(resultPoint6, resultPoint4).getTransitions();
            int transitions4 = transitionsBetween(resultPoint7, resultPoint4).getTransitions();
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            if ((transitions4 & 1) == 1) {
                transitions4++;
            }
            sampleGrid = sampleGrid(this.image, resultPoint6, resultPoint9, resultPoint7, resultPoint4, transitions3, transitions4);
        } else {
            resultPoint4 = correctTopRight(resultPoint9, resultPoint7, resultPoint6, resultPoint5, Math.min(i, transitions));
            if (resultPoint4 == null) {
                resultPoint4 = resultPoint5;
            }
            transitions3 = Math.max(transitionsBetween(resultPoint6, resultPoint4).getTransitions(), transitionsBetween(resultPoint7, resultPoint4).getTransitions()) + 1;
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            sampleGrid = sampleGrid(this.image, resultPoint6, resultPoint9, resultPoint7, resultPoint4, transitions3, transitions3);
        }
        return new DetectorResult(sampleGrid, new ResultPoint[]{resultPoint6, resultPoint9, resultPoint7, resultPoint4});
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) {
        float distance = ((float) distance(resultPoint, resultPoint2)) / ((float) i);
        int distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint((((resultPoint4.getX() - resultPoint3.getX()) / ((float) distance2)) * distance) + resultPoint4.getX(), (distance * ((resultPoint4.getY() - resultPoint3.getY()) / ((float) distance2))) + resultPoint4.getY());
        float distance3 = ((float) distance(resultPoint, resultPoint3)) / ((float) i2);
        int distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint((((resultPoint4.getX() - resultPoint2.getX()) / ((float) distance4)) * distance3) + resultPoint4.getX(), (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / ((float) distance4))) + resultPoint4.getY());
        if (isValid(resultPoint5)) {
            if (!isValid(resultPoint6)) {
                return resultPoint5;
            }
            if (Math.abs(i - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(i - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
                return resultPoint5;
            }
            return resultPoint6;
        } else if (isValid(resultPoint6)) {
            return resultPoint6;
        } else {
            return null;
        }
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float distance = ((float) distance(resultPoint, resultPoint2)) / ((float) i);
        int distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint((((resultPoint4.getX() - resultPoint3.getX()) / ((float) distance2)) * distance) + resultPoint4.getX(), (distance * ((resultPoint4.getY() - resultPoint3.getY()) / ((float) distance2))) + resultPoint4.getY());
        float distance3 = ((float) distance(resultPoint, resultPoint3)) / ((float) i);
        int distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint((((resultPoint4.getX() - resultPoint2.getX()) / ((float) distance4)) * distance3) + resultPoint4.getX(), (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / ((float) distance4))) + resultPoint4.getY());
        if (isValid(resultPoint5)) {
            return (!isValid(resultPoint6) || Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint5 : resultPoint6;
        } else {
            if (isValid(resultPoint6)) {
                return resultPoint6;
            }
            return null;
        }
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = (Integer) map.get(resultPoint);
        map.put(resultPoint, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, ((float) i) - 0.5f, 0.5f, ((float) i) - 0.5f, ((float) i2) - 0.5f, 0.5f, ((float) i2) - 0.5f, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        Object obj;
        int i;
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        if (Math.abs(y2 - y) > Math.abs(x2 - x)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            int i2 = y2;
            y2 = x2;
            x2 = i2;
            int i3 = y;
            y = x;
            x = i3;
        }
        int abs = Math.abs(y2 - y);
        int abs2 = Math.abs(x2 - x);
        int i4 = (-abs) / 2;
        int i5 = x < x2 ? 1 : -1;
        int i6 = y < y2 ? 1 : -1;
        int i7 = 0;
        BitMatrix bitMatrix = this.image;
        if (obj != null) {
            i = x;
        } else {
            i = y;
        }
        boolean z = bitMatrix.get(i, obj != null ? y : x);
        int i8 = x;
        int i9 = i4;
        while (y != y2) {
            BitMatrix bitMatrix2 = this.image;
            if (obj != null) {
                i4 = i8;
            } else {
                i4 = y;
            }
            boolean z2 = bitMatrix2.get(i4, obj != null ? y : i8);
            if (z2 != z) {
                i7++;
                z = z2;
            }
            x = i9 + abs2;
            if (x > 0) {
                if (i8 == x2) {
                    x2 = i7;
                    break;
                }
                i8 += i5;
                x -= abs;
            }
            y += i6;
            i9 = x;
        }
        x2 = i7;
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, x2);
    }
}
