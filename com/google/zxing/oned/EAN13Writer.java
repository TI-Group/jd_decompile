package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class EAN13Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    public boolean[] encode(String str) {
        if (str.length() != 13) {
            throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
        }
        try {
            if (UPCEANReader.checkStandardUPCEANChecksum(str)) {
                int i;
                int parseInt;
                int i2 = EAN13Reader.FIRST_DIGIT_ENCODINGS[Integer.parseInt(str.substring(0, 1))];
                boolean[] zArr = new boolean[95];
                int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true) + 0;
                for (i = 1; i <= 6; i++) {
                    parseInt = Integer.parseInt(str.substring(i, i + 1));
                    if (((i2 >> (6 - i)) & 1) == 1) {
                        parseInt += 10;
                    }
                    appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.L_AND_G_PATTERNS[parseInt], false);
                }
                i = appendPattern + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, false);
                for (parseInt = 7; parseInt <= 12; parseInt++) {
                    i += OneDimensionalCodeWriter.appendPattern(zArr, i, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(parseInt, parseInt + 1))], true);
                }
                OneDimensionalCodeWriter.appendPattern(zArr, i, UPCEANReader.START_END_PATTERN, true);
                return zArr;
            }
            throw new IllegalArgumentException("Contents do not pass checksum");
        } catch (FormatException e) {
            throw new IllegalArgumentException("Illegal contents");
        }
    }
}
