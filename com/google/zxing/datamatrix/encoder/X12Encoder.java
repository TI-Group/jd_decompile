package com.google.zxing.datamatrix.encoder;

/* compiled from: TbsSdkJava */
final class X12Encoder extends C40Encoder {
    X12Encoder() {
    }

    public int getEncodingMode() {
        return 3;
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder stringBuilder = new StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            encodeChar(currentChar, stringBuilder);
            if (stringBuilder.length() % 3 == 0) {
                C40Encoder.writeNextTriplet(encoderContext, stringBuilder);
                int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
                if (lookAheadTest != getEncodingMode()) {
                    encoderContext.signalEncoderChange(lookAheadTest);
                    break;
                }
            }
        }
        handleEOD(encoderContext, stringBuilder);
    }

    int encodeChar(char c, StringBuilder stringBuilder) {
        if (c == '\r') {
            stringBuilder.append('\u0000');
        } else if (c == '*') {
            stringBuilder.append('\u0001');
        } else if (c == '>') {
            stringBuilder.append('\u0002');
        } else if (c == ' ') {
            stringBuilder.append('\u0003');
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
        } else if (c < 'A' || c > 'Z') {
            HighLevelEncoder.illegalCharacter(c);
        } else {
            stringBuilder.append((char) ((c - 65) + 14));
        }
        return 1;
    }

    void handleEOD(EncoderContext encoderContext, StringBuilder stringBuilder) {
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
        int length = stringBuilder.length();
        if (length == 2) {
            encoderContext.writeCodeword('þ');
            encoderContext.pos -= 2;
            encoderContext.signalEncoderChange(0);
        } else if (length == 1) {
            encoderContext.pos--;
            if (dataCapacity > 1) {
                encoderContext.writeCodeword('þ');
            }
            encoderContext.signalEncoderChange(0);
        }
    }
}
