package com.google.zxing.maxicode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class Decoder {
    private static final int ALL = 0;
    private static final int EVEN = 1;
    private static final int ODD = 2;
    private final ReedSolomonDecoder rsDecoder = new ReedSolomonDecoder(GenericGF.MAXICODE_FIELD_64);

    public DecoderResult decode(BitMatrix bitMatrix) throws ChecksumException, FormatException {
        return decode(bitMatrix, null);
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        Object obj;
        Object readCodewords = new BitMatrixParser(bitMatrix).readCodewords();
        correctErrors(readCodewords, 0, 10, 10, 0);
        int i = readCodewords[0] & 15;
        switch (i) {
            case 2:
            case 3:
            case 4:
                correctErrors(readCodewords, 20, 84, 40, 1);
                correctErrors(readCodewords, 20, 84, 40, 2);
                obj = new byte[94];
                break;
            case 5:
                correctErrors(readCodewords, 20, 68, 56, 1);
                correctErrors(readCodewords, 20, 68, 56, 2);
                obj = new byte[78];
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        System.arraycopy(readCodewords, 0, obj, 0, 10);
        System.arraycopy(readCodewords, 20, obj, 10, obj.length - 10);
        return DecodedBitStreamParser.decode(obj, i);
    }

    private void correctErrors(byte[] bArr, int i, int i2, int i3, int i4) throws ChecksumException {
        int i5 = 0;
        int i6 = i2 + i3;
        int i7 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[(i6 / i7)];
        int i8 = 0;
        while (i8 < i6) {
            if (i4 == 0 || i8 % 2 == i4 - 1) {
                iArr[i8 / i7] = bArr[i8 + i] & 255;
            }
            i8++;
        }
        try {
            this.rsDecoder.decode(iArr, i3 / i7);
            while (i5 < i2) {
                if (i4 == 0 || i5 % 2 == i4 - 1) {
                    bArr[i5 + i] = (byte) iArr[i5 / i7];
                }
                i5++;
            }
        } catch (ReedSolomonException e) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
