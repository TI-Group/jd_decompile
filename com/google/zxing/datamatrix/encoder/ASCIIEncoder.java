package com.google.zxing.datamatrix.encoder;

import android.support.v4.media.TransportMediator;

/* compiled from: TbsSdkJava */
final class ASCIIEncoder implements Encoder {
    ASCIIEncoder() {
    }

    public int getEncodingMode() {
        return 0;
    }

    public void encode(EncoderContext encoderContext) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(encoderContext.getMessage(), encoderContext.pos) >= 2) {
            encoderContext.writeCodeword(encodeASCIIDigits(encoderContext.getMessage().charAt(encoderContext.pos), encoderContext.getMessage().charAt(encoderContext.pos + 1)));
            encoderContext.pos += 2;
            return;
        }
        char currentChar = encoderContext.getCurrentChar();
        int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
        if (lookAheadTest != getEncodingMode()) {
            switch (lookAheadTest) {
                case 1:
                    encoderContext.writeCodeword('æ');
                    encoderContext.signalEncoderChange(1);
                    return;
                case 2:
                    encoderContext.writeCodeword('ï');
                    encoderContext.signalEncoderChange(2);
                    return;
                case 3:
                    encoderContext.writeCodeword('î');
                    encoderContext.signalEncoderChange(3);
                    return;
                case 4:
                    encoderContext.writeCodeword('ð');
                    encoderContext.signalEncoderChange(4);
                    return;
                case 5:
                    encoderContext.writeCodeword('ç');
                    encoderContext.signalEncoderChange(5);
                    return;
                default:
                    throw new IllegalStateException("Illegal mode: " + lookAheadTest);
            }
        } else if (HighLevelEncoder.isExtendedASCII(currentChar)) {
            encoderContext.writeCodeword('ë');
            encoderContext.writeCodeword((char) ((currentChar - 128) + 1));
            encoderContext.pos++;
        } else {
            encoderContext.writeCodeword((char) (currentChar + 1));
            encoderContext.pos++;
        }
    }

    private static char encodeASCIIDigits(char c, char c2) {
        if (HighLevelEncoder.isDigit(c) && HighLevelEncoder.isDigit(c2)) {
            return (char) ((((c - 48) * 10) + (c2 - 48)) + TransportMediator.KEYCODE_MEDIA_RECORD);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }
}
