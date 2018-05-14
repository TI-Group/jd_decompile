package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class AztecReader implements Reader {
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        AztecDetectorResult detect;
        ResultPoint[] points;
        DecoderResult decode;
        NotFoundException notFoundException;
        NotFoundException e;
        DecoderResult decoderResult;
        ResultPoint[] resultPointArr;
        FormatException e2;
        ResultPointCallback resultPointCallback;
        Result result;
        List byteSegments;
        String eCLevel;
        FormatException formatException;
        FormatException formatException2 = null;
        Detector detector = new Detector(binaryBitmap.getBlackMatrix());
        try {
            detect = detector.detect(false);
            points = detect.getPoints();
            try {
                decode = new Decoder().decode(detect);
                notFoundException = null;
            } catch (NotFoundException e3) {
                e = e3;
                notFoundException = e;
                decode = null;
                if (decode == null) {
                    decoderResult = decode;
                    resultPointArr = points;
                } else {
                    try {
                        detect = detector.detect(true);
                        decoderResult = new Decoder().decode(detect);
                        resultPointArr = detect.getPoints();
                    } catch (NotFoundException e4) {
                        e2 = e4;
                        if (notFoundException != null) {
                            throw notFoundException;
                        } else if (formatException2 == null) {
                            throw formatException2;
                        } else {
                            throw e2;
                        }
                    } catch (FormatException e5) {
                        e2 = e5;
                        if (notFoundException != null) {
                            throw notFoundException;
                        } else if (formatException2 == null) {
                            throw e2;
                        } else {
                            throw formatException2;
                        }
                    }
                }
                if (map != null) {
                    resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                    if (resultPointCallback != null) {
                        for (ResultPoint foundPossibleResultPoint : resultPointArr) {
                            resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                        }
                    }
                }
                result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), resultPointArr, BarcodeFormat.AZTEC);
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                return result;
            } catch (FormatException e6) {
                e2 = e6;
                notFoundException = null;
                formatException = e2;
                decode = null;
                formatException2 = formatException;
                if (decode == null) {
                    detect = detector.detect(true);
                    decoderResult = new Decoder().decode(detect);
                    resultPointArr = detect.getPoints();
                } else {
                    decoderResult = decode;
                    resultPointArr = points;
                }
                if (map != null) {
                    resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                    if (resultPointCallback != null) {
                        while (r1 < r5) {
                            resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                        }
                    }
                }
                result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), resultPointArr, BarcodeFormat.AZTEC);
                byteSegments = decoderResult.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                eCLevel = decoderResult.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                return result;
            }
        } catch (NotFoundException e7) {
            e = e7;
            points = null;
            notFoundException = e;
            decode = null;
            if (decode == null) {
                decoderResult = decode;
                resultPointArr = points;
            } else {
                detect = detector.detect(true);
                decoderResult = new Decoder().decode(detect);
                resultPointArr = detect.getPoints();
            }
            if (map != null) {
                resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                if (resultPointCallback != null) {
                    while (r1 < r5) {
                        resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                    }
                }
            }
            result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), resultPointArr, BarcodeFormat.AZTEC);
            byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
                result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
            }
            eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
                result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
            }
            return result;
        } catch (FormatException e8) {
            e2 = e8;
            points = null;
            notFoundException = null;
            formatException = e2;
            decode = null;
            formatException2 = formatException;
            if (decode == null) {
                detect = detector.detect(true);
                decoderResult = new Decoder().decode(detect);
                resultPointArr = detect.getPoints();
            } else {
                decoderResult = decode;
                resultPointArr = points;
            }
            if (map != null) {
                resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                if (resultPointCallback != null) {
                    while (r1 < r5) {
                        resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                    }
                }
            }
            result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), resultPointArr, BarcodeFormat.AZTEC);
            byteSegments = decoderResult.getByteSegments();
            if (byteSegments != null) {
                result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
            }
            eCLevel = decoderResult.getECLevel();
            if (eCLevel != null) {
                result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
            }
            return result;
        }
        if (decode == null) {
            detect = detector.detect(true);
            decoderResult = new Decoder().decode(detect);
            resultPointArr = detect.getPoints();
        } else {
            decoderResult = decode;
            resultPointArr = points;
        }
        if (map != null) {
            resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                while (r1 < r5) {
                    resultPointCallback.foundPossibleResultPoint(foundPossibleResultPoint);
                }
            }
        }
        result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), resultPointArr, BarcodeFormat.AZTEC);
        byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        eCLevel = decoderResult.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }

    public void reset() {
    }
}
