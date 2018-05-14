package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class AztecWriter implements Writer {
    private static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        String str2 = map == null ? null : (String) map.get(EncodeHintType.CHARACTER_SET);
        Number number = map == null ? null : (Number) map.get(EncodeHintType.ERROR_CORRECTION);
        Number number2 = map == null ? null : (Number) map.get(EncodeHintType.AZTEC_LAYERS);
        return encode(str, barcodeFormat, i, i2, str2 == null ? DEFAULT_CHARSET : Charset.forName(str2), number == null ? 33 : number.intValue(), number2 == null ? 0 : number2.intValue());
    }

    private static BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return renderResult(Encoder.encode(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    private static BitMatrix renderResult(AztecCode aztecCode, int i, int i2) {
        BitMatrix matrix = aztecCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int max = Math.max(i, width);
        int max2 = Math.max(i2, height);
        int min = Math.min(max / width, max2 / height);
        int i3 = (max - (width * min)) / 2;
        int i4 = (max2 - (height * min)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        max2 = i4;
        for (int i5 = 0; i5 < height; i5++) {
            i4 = i3;
            max = 0;
            while (max < width) {
                if (matrix.get(max, i5)) {
                    bitMatrix.setRegion(i4, max2, min, min);
                }
                max++;
                i4 += min;
            }
            max2 += min;
        }
        return bitMatrix;
    }
}
