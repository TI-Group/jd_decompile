package com.google.zxing.datamatrix.encoder;

import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;

/* compiled from: TbsSdkJava */
final class Base256Encoder implements Encoder {
    Base256Encoder() {
    }

    public int getEncodingMode() {
        return 5;
    }

    public void encode(EncoderContext encoderContext) {
        int lookAheadTest;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\u0000');
        while (encoderContext.hasMoreCharacters()) {
            stringBuilder.append(encoderContext.getCurrentChar());
            encoderContext.pos++;
            lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
            if (lookAheadTest != getEncodingMode()) {
                encoderContext.signalEncoderChange(lookAheadTest);
                break;
            }
        }
        int length = stringBuilder.length() - 1;
        lookAheadTest = (encoderContext.getCodewordCount() + length) + 1;
        encoderContext.updateSymbolInfo(lookAheadTest);
        lookAheadTest = encoderContext.getSymbolInfo().getDataCapacity() - lookAheadTest > 0 ? 1 : 0;
        if (encoderContext.hasMoreCharacters() || lookAheadTest != 0) {
            if (length <= 249) {
                stringBuilder.setCharAt(0, (char) length);
            } else if (length <= 249 || length > 1555) {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            } else {
                stringBuilder.setCharAt(0, (char) ((length / Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                stringBuilder.insert(1, (char) (length % Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            }
        }
        lookAheadTest = stringBuilder.length();
        while (i < lookAheadTest) {
            encoderContext.writeCodeword(randomize255State(stringBuilder.charAt(i), encoderContext.getCodewordCount() + 1));
            i++;
        }
    }

    private static char randomize255State(char c, int i) {
        int i2 = (((i * 149) % 255) + 1) + c;
        if (i2 <= 255) {
            return (char) i2;
        }
        return (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }
}
