package com.google.zxing.datamatrix.encoder;

/* compiled from: TbsSdkJava */
class C40Encoder implements Encoder {
    C40Encoder() {
    }

    public int getEncodingMode() {
        return 1;
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder stringBuilder = new StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int encodeChar = encodeChar(currentChar, stringBuilder);
            int length = ((stringBuilder.length() / 3) * 2) + encoderContext.getCodewordCount();
            encoderContext.updateSymbolInfo(length);
            length = encoderContext.getSymbolInfo().getDataCapacity() - length;
            if (!encoderContext.hasMoreCharacters()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder.length() % 3 == 2 && (length < 2 || length > 2)) {
                    encodeChar = backtrackOneCharacter(encoderContext, stringBuilder, stringBuilder2, encodeChar);
                }
                while (stringBuilder.length() % 3 == 1 && ((encodeChar <= 3 && length != 1) || encodeChar > 3)) {
                    encodeChar = backtrackOneCharacter(encoderContext, stringBuilder, stringBuilder2, encodeChar);
                }
            } else if (stringBuilder.length() % 3 == 0) {
                encodeChar = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
                if (encodeChar != getEncodingMode()) {
                    encoderContext.signalEncoderChange(encodeChar);
                    break;
                }
            }
        }
        handleEOD(encoderContext, stringBuilder);
    }

    private int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder stringBuilder, StringBuilder stringBuilder2, int i) {
        int length = stringBuilder.length();
        stringBuilder.delete(length - i, length);
        encoderContext.pos--;
        length = encodeChar(encoderContext.getCurrentChar(), stringBuilder2);
        encoderContext.resetSymbolInfo();
        return length;
    }

    static void writeNextTriplet(EncoderContext encoderContext, StringBuilder stringBuilder) {
        encoderContext.writeCodewords(encodeToCodewords(stringBuilder, 0));
        stringBuilder.delete(0, 3);
    }

    void handleEOD(EncoderContext encoderContext, StringBuilder stringBuilder) {
        int length = stringBuilder.length() % 3;
        int length2 = ((stringBuilder.length() / 3) * 2) + encoderContext.getCodewordCount();
        encoderContext.updateSymbolInfo(length2);
        length2 = encoderContext.getSymbolInfo().getDataCapacity() - length2;
        if (length == 2) {
            stringBuilder.append('\u0000');
            while (stringBuilder.length() >= 3) {
                writeNextTriplet(encoderContext, stringBuilder);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword('þ');
            }
        } else if (length2 == 1 && length == 1) {
            while (stringBuilder.length() >= 3) {
                writeNextTriplet(encoderContext, stringBuilder);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword('þ');
            }
            encoderContext.pos--;
        } else if (length == 0) {
            while (stringBuilder.length() >= 3) {
                writeNextTriplet(encoderContext, stringBuilder);
            }
            if (length2 > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword('þ');
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        encoderContext.signalEncoderChange(0);
    }

    int encodeChar(char c, StringBuilder stringBuilder) {
        if (c == ' ') {
            stringBuilder.append('\u0003');
            return 1;
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            stringBuilder.append((char) ((c - 65) + 14));
            return 1;
        } else if (c >= '\u0000' && c <= '\u001f') {
            stringBuilder.append('\u0000');
            stringBuilder.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            stringBuilder.append('\u0001');
            stringBuilder.append((char) (c - 33));
            return 2;
        } else if (c >= ':' && c <= '@') {
            stringBuilder.append('\u0001');
            stringBuilder.append((char) ((c - 58) + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            stringBuilder.append('\u0001');
            stringBuilder.append((char) ((c - 91) + 22));
            return 2;
        } else if (c >= '`' && c <= '') {
            stringBuilder.append('\u0002');
            stringBuilder.append((char) (c - 96));
            return 2;
        } else if (c >= '') {
            stringBuilder.append("\u0001\u001e");
            return encodeChar((char) (c - 128), stringBuilder) + 2;
        } else {
            throw new IllegalArgumentException("Illegal character: " + c);
        }
    }

    private static String encodeToCodewords(CharSequence charSequence, int i) {
        char charAt = (char) (((((charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * 40)) + charSequence.charAt(i + 2)) + 1) % 256);
        return new String(new char[]{(char) (r0 / 256), charAt});
    }
}
