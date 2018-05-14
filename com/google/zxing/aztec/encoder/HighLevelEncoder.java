package com.google.zxing.aztec.encoder;

import android.support.v4.media.TransportMediator;
import com.google.zxing.common.BitArray;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import jd.wjlogin_sdk.util.ReplyCode;

/* compiled from: TbsSdkJava */
public final class HighLevelEncoder {
    private static final int[][] CHAR_MAP = ((int[][]) Array.newInstance(Integer.TYPE, new int[]{5, 256}));
    static final int[][] LATCH_TABLE = new int[][]{new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    static final int MODE_DIGIT = 2;
    static final int MODE_LOWER = 1;
    static final int MODE_MIXED = 3;
    static final String[] MODE_NAMES = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int MODE_PUNCT = 4;
    static final int MODE_UPPER = 0;
    static final int[][] SHIFT_TABLE = ((int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 6}));
    private final byte[] text;

    static {
        int i;
        CHAR_MAP[0][32] = 1;
        for (i = 65; i <= 90; i++) {
            CHAR_MAP[0][i] = (i - 65) + 2;
        }
        CHAR_MAP[1][32] = 1;
        for (i = 97; i <= ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR; i++) {
            CHAR_MAP[1][i] = (i - 97) + 2;
        }
        CHAR_MAP[2][32] = 1;
        for (i = 48; i <= 57; i++) {
            CHAR_MAP[2][i] = (i - 48) + 2;
        }
        CHAR_MAP[2][44] = 12;
        CHAR_MAP[2][46] = 13;
        int[] iArr = new int[]{0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, ErrorCode.DOWNLOAD_REDIRECT_EMPTY, TransportMediator.KEYCODE_MEDIA_PLAY, TransportMediator.KEYCODE_MEDIA_PAUSE};
        for (i = 0; i < iArr.length; i++) {
            CHAR_MAP[3][iArr[i]] = i;
        }
        iArr = new int[]{0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, ErrorCode.DOWNLOAD_THROWABLE};
        for (i = 0; i < iArr.length; i++) {
            if (iArr[i] > 0) {
                CHAR_MAP[4][iArr[i]] = i;
            }
        }
        for (int[] fill : SHIFT_TABLE) {
            Arrays.fill(fill, -1);
        }
        SHIFT_TABLE[0][4] = 0;
        SHIFT_TABLE[1][4] = 0;
        SHIFT_TABLE[1][0] = 28;
        SHIFT_TABLE[3][4] = 0;
        SHIFT_TABLE[2][4] = 0;
        SHIFT_TABLE[2][0] = 15;
    }

    public HighLevelEncoder(byte[] bArr) {
        this.text = bArr;
    }

    public BitArray encode() {
        Object singletonList = Collections.singletonList(State.INITIAL_STATE);
        int i = 0;
        while (i < this.text.length) {
            byte b;
            int i2;
            if (i + 1 < this.text.length) {
                b = this.text[i + 1];
            } else {
                b = (byte) 0;
            }
            switch (this.text[i]) {
                case (byte) 13:
                    if (b != (byte) 10) {
                        i2 = 0;
                        break;
                    }
                    i2 = 2;
                    break;
                case (byte) 44:
                    if (b != ReplyCode.reply0x20) {
                        i2 = 0;
                        break;
                    }
                    i2 = 4;
                    break;
                case (byte) 46:
                    if (b != ReplyCode.reply0x20) {
                        i2 = 0;
                        break;
                    }
                    i2 = 3;
                    break;
                case (byte) 58:
                    if (b != ReplyCode.reply0x20) {
                        i2 = 0;
                        break;
                    }
                    i2 = 5;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (i2 > 0) {
                singletonList = updateStateListForPair(singletonList, i, i2);
                i++;
            } else {
                singletonList = updateStateListForChar(singletonList, i);
            }
            i++;
        }
        return ((State) Collections.min(singletonList, new Comparator<State>() {
            public int compare(State state, State state2) {
                return state.getBitCount() - state2.getBitCount();
            }
        })).toBitArray(this.text);
    }

    private Collection<State> updateStateListForChar(Iterable<State> iterable, int i) {
        Iterable linkedList = new LinkedList();
        for (State updateStateForChar : iterable) {
            updateStateForChar(updateStateForChar, i, linkedList);
        }
        return simplifyStates(linkedList);
    }

    private void updateStateForChar(State state, int i, Collection<State> collection) {
        Object obj;
        char c = (char) (this.text[i] & 255);
        if (CHAR_MAP[state.getMode()][c] > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        State state2 = null;
        int i2 = 0;
        while (i2 <= 4) {
            int i3 = CHAR_MAP[i2][c];
            if (i3 > 0) {
                if (state2 == null) {
                    state2 = state.endBinaryShift(i);
                }
                if (obj == null || i2 == state.getMode() || i2 == 2) {
                    collection.add(state2.latchAndAppend(i2, i3));
                }
                if (obj == null && SHIFT_TABLE[state.getMode()][i2] >= 0) {
                    collection.add(state2.shiftAndAppend(i2, i3));
                }
            }
            i2++;
        }
        if (state.getBinaryShiftByteCount() > 0 || CHAR_MAP[state.getMode()][c] == 0) {
            collection.add(state.addBinaryShiftChar(i));
        }
    }

    private static Collection<State> updateStateListForPair(Iterable<State> iterable, int i, int i2) {
        Iterable linkedList = new LinkedList();
        for (State updateStateForPair : iterable) {
            updateStateForPair(updateStateForPair, i, i2, linkedList);
        }
        return simplifyStates(linkedList);
    }

    private static void updateStateForPair(State state, int i, int i2, Collection<State> collection) {
        State endBinaryShift = state.endBinaryShift(i);
        collection.add(endBinaryShift.latchAndAppend(4, i2));
        if (state.getMode() != 4) {
            collection.add(endBinaryShift.shiftAndAppend(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(endBinaryShift.latchAndAppend(2, 16 - i2).latchAndAppend(2, 1));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            collection.add(state.addBinaryShiftChar(i).addBinaryShiftChar(i + 1));
        }
    }

    private static Collection<State> simplifyStates(Iterable<State> iterable) {
        Collection linkedList = new LinkedList();
        for (State state : iterable) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                State state2 = (State) it.next();
                if (state2.isBetterThanOrEqualTo(state)) {
                    Object obj = null;
                    break;
                } else if (state.isBetterThanOrEqualTo(state2)) {
                    it.remove();
                }
            }
            int i = 1;
            if (obj != null) {
                linkedList.add(state);
            }
        }
        return linkedList;
    }
}
