package com.google.zxing.aztec.encoder;

import android.support.v4.internal.view.SupportMenu;
import com.google.zxing.common.BitArray;
import java.util.Deque;
import java.util.LinkedList;

/* compiled from: TbsSdkJava */
final class State {
    static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token, int i, int i2, int i3) {
        this.token = token;
        this.mode = i;
        this.binaryShiftByteCount = i2;
        this.bitCount = i3;
    }

    int getMode() {
        return this.mode;
    }

    Token getToken() {
        return this.token;
    }

    int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    int getBitCount() {
        return this.bitCount;
    }

    State latchAndAppend(int i, int i2) {
        int i3;
        Token add;
        int i4 = this.bitCount;
        Token token = this.token;
        if (i != this.mode) {
            i3 = HighLevelEncoder.LATCH_TABLE[this.mode][i];
            i3 = i4 + (i3 >> 16);
            add = token.add(SupportMenu.USER_MASK & i3, i3 >> 16);
        } else {
            i3 = i4;
            add = token;
        }
        int i5 = i == 2 ? 4 : 5;
        return new State(add.add(i2, i5), i, 0, i5 + i3);
    }

    State shiftAndAppend(int i, int i2) {
        int i3;
        Token token = this.token;
        if (this.mode == 2) {
            i3 = 4;
        } else {
            i3 = 5;
        }
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[this.mode][i], i3).add(i2, 5), this.mode, 0, (i3 + this.bitCount) + 5);
    }

    State addBinaryShiftChar(int i) {
        Token add;
        Token token = this.token;
        int i2 = this.mode;
        int i3 = this.bitCount;
        if (this.mode == 4 || this.mode == 2) {
            int i4 = HighLevelEncoder.LATCH_TABLE[i2][0];
            i3 += i4 >> 16;
            add = token.add(SupportMenu.USER_MASK & i4, i4 >> 16);
            i2 = 0;
        } else {
            add = token;
        }
        int i5 = (this.binaryShiftByteCount == 0 || this.binaryShiftByteCount == 31) ? 18 : this.binaryShiftByteCount == 62 ? 9 : 8;
        State state = new State(add, i2, this.binaryShiftByteCount + 1, i3 + i5);
        if (state.binaryShiftByteCount == 2078) {
            return state.endBinaryShift(i + 1);
        }
        return state;
    }

    State endBinaryShift(int i) {
        return this.binaryShiftByteCount == 0 ? this : new State(this.token.addBinaryShift(i - this.binaryShiftByteCount, this.binaryShiftByteCount), this.mode, 0, this.bitCount);
    }

    boolean isBetterThanOrEqualTo(State state) {
        int i = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        if (state.binaryShiftByteCount > 0 && (this.binaryShiftByteCount == 0 || this.binaryShiftByteCount > state.binaryShiftByteCount)) {
            i += 10;
        }
        return i <= state.bitCount;
    }

    BitArray toBitArray(byte[] bArr) {
        Deque<Token> linkedList = new LinkedList();
        for (Token token = endBinaryShift(bArr.length).token; token != null; token = token.getPrevious()) {
            linkedList.addFirst(token);
        }
        BitArray bitArray = new BitArray();
        for (Token token2 : linkedList) {
            token2.appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount)});
    }
}
