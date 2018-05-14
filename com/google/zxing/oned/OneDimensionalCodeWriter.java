package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* compiled from: TbsSdkJava */
public abstract class OneDimensionalCodeWriter implements Writer {
    public abstract boolean[] encode(String str);

    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) throws WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int intValue;
            int defaultMargin = getDefaultMargin();
            if (map != null) {
                Integer num = (Integer) map.get(EncodeHintType.MARGIN);
                if (num != null) {
                    intValue = num.intValue();
                    return renderResult(encode(str), i, i2, intValue);
                }
            }
            intValue = defaultMargin;
            return renderResult(encode(str), i, i2, intValue);
        }
    }

    private static BitMatrix renderResult(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = length + i3;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        i4 = (max - (length * i5)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        max = 0;
        while (max < length) {
            if (zArr[max]) {
                bitMatrix.setRegion(i4, 0, i5, max2);
            }
            max++;
            i4 += i5;
        }
        return bitMatrix;
    }

    protected static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (i2 < length) {
            int i5 = iArr[i2];
            int i6 = i4;
            i4 = 0;
            while (i4 < i5) {
                int i7 = i6 + 1;
                zArr[i6] = z;
                i4++;
                i6 = i7;
            }
            i3 += i5;
            i2++;
            z = !z;
            i4 = i6;
        }
        return i3;
    }

    public int getDefaultMargin() {
        return 10;
    }
}
