package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        List arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i, int i2, int i3) {
        if (i3 <= 4) {
            try {
                Object obj;
                Result decode = this.delegate.decode(binaryBitmap, map);
                for (Result text : list) {
                    if (text.getText().equals(decode.getText())) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    list.add(translateResultPoints(decode, i, i2));
                }
                ResultPoint[] resultPoints = decode.getResultPoints();
                if (resultPoints != null && resultPoints.length != 0) {
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    float f = (float) width;
                    float f2 = (float) height;
                    float f3 = 0.0f;
                    float f4 = 0.0f;
                    int length = resultPoints.length;
                    int i4 = 0;
                    while (i4 < length) {
                        float f5;
                        ResultPoint resultPoint = resultPoints[i4];
                        float x = resultPoint.getX();
                        float y = resultPoint.getY();
                        if (x < f) {
                            f5 = x;
                        } else {
                            f5 = f;
                        }
                        if (y < f2) {
                            f = y;
                        } else {
                            f = f2;
                        }
                        if (x <= f3) {
                            x = f3;
                        }
                        if (y <= f4) {
                            y = f4;
                        }
                        i4++;
                        f4 = y;
                        f3 = x;
                        f2 = f;
                        f = f5;
                    }
                    if (f > 100.0f) {
                        doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f, height), map, list, i, i2, i3 + 1);
                    }
                    if (f2 > 100.0f) {
                        doDecodeMultiple(binaryBitmap.crop(0, 0, width, (int) f2), map, list, i, i2, i3 + 1);
                    }
                    if (f3 < ((float) (width - 100))) {
                        doDecodeMultiple(binaryBitmap.crop((int) f3, 0, width - ((int) f3), height), map, list, i + ((int) f3), i2, i3 + 1);
                    }
                    if (f4 < ((float) (height - 100))) {
                        doDecodeMultiple(binaryBitmap.crop(0, (int) f4, width, height - ((int) f4)), map, list, i, i2 + ((int) f4), i3 + 1);
                    }
                }
            } catch (ReaderException e) {
            }
        }
    }

    private static Result translateResultPoints(Result result, int i, int i2) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            ResultPoint resultPoint = resultPoints[i3];
            resultPointArr[i3] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), resultPointArr, result.getBarcodeFormat());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }
}
