package com.google.zxing.oned.rss.expanded;

import android.support.v4.media.TransportMediator;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int[] EVEN_TOTAL_SUBSET = new int[]{4, 20, 52, 104, 204};
    private static final int[][] FINDER_PATTERNS = new int[][]{new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = new int[][]{new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int[] GSUM = new int[]{0, 348, 1388, 2948, 3988};
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = new int[]{7, 5, 4, 3, 1};
    private static final int[][] WEIGHTS = new int[][]{new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, ErrorCode.DEXOPT_EXCEPTION, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, ErrorCode.DOWNLOAD_THROWABLE, 164}, new int[]{70, ErrorCode.ROM_NOT_ENOUGH, ErrorCode.EXCEED_DEXOPT_RETRY_NUM, 202, 184, TransportMediator.KEYCODE_MEDIA_RECORD, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, 149, 25, 75, 14, 42, TransportMediator.KEYCODE_MEDIA_PLAY, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, ErrorCode.DOWNLOAD_REDIRECT_EMPTY}, new int[]{161, 61, 183, TransportMediator.KEYCODE_MEDIA_PAUSE, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven = false;

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i, bitArray));
        } catch (NotFoundException e) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i, bitArray));
        }
    }

    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    List<ExpandedPair> decodeRow2pairs(int i, BitArray bitArray) throws NotFoundException {
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i));
            } catch (NotFoundException e) {
                if (this.pairs.isEmpty()) {
                    throw e;
                } else if (checkChecksum()) {
                    return this.pairs;
                } else {
                    boolean z = !this.rows.isEmpty();
                    storeRow(i, false);
                    if (z) {
                        List<ExpandedPair> checkRows = checkRows(false);
                        if (checkRows != null) {
                            return checkRows;
                        }
                        checkRows = checkRows(true);
                        if (checkRows != null) {
                            return checkRows;
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    private List<ExpandedPair> checkRows(boolean z) {
        List<ExpandedPair> list = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
        } else {
            this.pairs.clear();
            if (z) {
                Collections.reverse(this.rows);
            }
            try {
                list = checkRows(new ArrayList(), 0);
            } catch (NotFoundException e) {
            }
            if (z) {
                Collections.reverse(this.rows);
            }
        }
        return list;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i) throws NotFoundException {
        while (i < this.rows.size()) {
            ExpandedRow expandedRow = (ExpandedRow) this.rows.get(i);
            this.pairs.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.pairs.addAll(((ExpandedRow) list.get(i2)).getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i + 1);
                } catch (NotFoundException e) {
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        for (int[] iArr : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr.length) {
                boolean z;
                for (int i = 0; i < list.size(); i++) {
                    if (((ExpandedPair) list.get(i)).getFinderPattern().getValue() != iArr[i]) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private void storeRow(int i, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i2 < this.rows.size()) {
            ExpandedRow expandedRow = (ExpandedRow) this.rows.get(i2);
            if (expandedRow.getRowNumber() > i) {
                z2 = expandedRow.isEquivalent(this.pairs);
                break;
            }
            i2++;
            z3 = expandedRow.isEquivalent(this.pairs);
        }
        if (!z2 && !r1 && !isPartialRow(this.pairs, this.rows)) {
            this.rows.add(i2, new ExpandedRow(this.pairs, i, z));
            removePartialRows(this.pairs, this.rows);
        }
    }

    private static void removePartialRows(List<ExpandedPair> list, List<ExpandedRow> list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ExpandedRow expandedRow = (ExpandedRow) it.next();
            if (expandedRow.getPairs().size() != list.size()) {
                Object obj;
                for (ExpandedPair expandedPair : expandedRow.getPairs()) {
                    for (ExpandedPair equals : list) {
                        if (expandedPair.equals(equals)) {
                            obj = 1;
                            continue;
                            break;
                        }
                    }
                    obj = null;
                    continue;
                    if (obj == null) {
                        obj = null;
                        break;
                    }
                }
                int i = 1;
                if (obj != null) {
                    it.remove();
                }
            }
        }
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        for (ExpandedRow expandedRow : iterable2) {
            for (ExpandedPair expandedPair : iterable) {
                Object obj;
                for (ExpandedPair equals : expandedRow.getPairs()) {
                    if (expandedPair.equals(equals)) {
                        obj = 1;
                        continue;
                        break;
                    }
                }
                obj = null;
                continue;
                if (obj == null) {
                    Object obj2 = null;
                    continue;
                    break;
                }
            }
            int i = 1;
            continue;
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    List<ExpandedRow> getRows() {
        return this.rows;
    }

    static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = ((ExpandedPair) list.get(0)).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = ((ExpandedPair) list.get(list.size() - 1)).getFinderPattern().getResultPoints();
        return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private boolean checkChecksum() {
        boolean z = true;
        ExpandedPair expandedPair = (ExpandedPair) this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int i = 2;
        int checksumPortion = rightChar.getChecksumPortion();
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            expandedPair = (ExpandedPair) this.pairs.get(i2);
            checksumPortion += expandedPair.getLeftChar().getChecksumPortion();
            i++;
            rightChar = expandedPair.getRightChar();
            if (rightChar != null) {
                checksumPortion += rightChar.getChecksumPortion();
                i++;
            }
        }
        if ((checksumPortion % ErrorCode.EXCEED_COPY_RETRY_NUM) + ((i - 4) * ErrorCode.EXCEED_COPY_RETRY_NUM) != leftChar.getValue()) {
            z = false;
        }
        return z;
    }

    private static int getNextSecondBar(BitArray bitArray, int i) {
        if (bitArray.get(i)) {
            return bitArray.getNextSet(bitArray.getNextUnset(i));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        boolean z;
        FinderPattern parseFoundFinderPattern;
        boolean z2 = list.size() % 2 == 0;
        if (this.startFromEven) {
            if (z2) {
                z2 = false;
            } else {
                z2 = true;
            }
            z = z2;
        } else {
            z = z2;
        }
        int i2 = -1;
        boolean z3 = true;
        do {
            findNextPair(bitArray, list, i2);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
            if (parseFoundFinderPattern == null) {
                i2 = getNextSecondBar(bitArray, this.startEnd[0]);
                continue;
            } else {
                z3 = false;
                continue;
            }
        } while (z3);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, true);
        if (list.isEmpty() || !((ExpandedPair) list.get(list.size() - 1)).mustBeLast()) {
            DataCharacter decodeDataCharacter2;
            try {
                decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, false);
            } catch (NotFoundException e) {
                decodeDataCharacter2 = null;
            }
            return new ExpandedPair(decodeDataCharacter, decodeDataCharacter2, parseFoundFinderPattern, true);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            if (list.isEmpty()) {
                i = 0;
            } else {
                i = ((ExpandedPair) list.get(list.size() - 1)).getFinderPattern().getStartEnd()[1];
            }
        }
        Object obj = list.size() % 2 != 0 ? 1 : null;
        if (this.startFromEven) {
            obj = obj == null ? 1 : null;
        }
        int i2 = 0;
        int i3 = i;
        while (i3 < size) {
            i2 = !bitArray.get(i3) ? 1 : 0;
            if (i2 == 0) {
                break;
            }
            i3++;
        }
        int i4 = i3;
        i3 = 0;
        int i5 = i2;
        i2 = i4;
        for (int i6 = i3; i6 < size; i6++) {
            if ((bitArray.get(i6) ^ i5) != 0) {
                decodeFinderCounters[i3] = decodeFinderCounters[i3] + 1;
            } else {
                if (i3 == 3) {
                    if (obj != null) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        this.startEnd[0] = i2;
                        this.startEnd[1] = i6;
                        return;
                    }
                    if (obj != null) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i2 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i3--;
                } else {
                    i3++;
                }
                decodeFinderCounters[i3] = 1;
                i5 = i5 == 0 ? 1 : 0;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            iArr[i] = iArr[(length - i) - 1];
            iArr[(length - i) - 1] = i2;
        }
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            i2 = this.startEnd[0] - 1;
            while (i2 >= 0 && !bitArray.get(i2)) {
                i2--;
            }
            i3 = i2 + 1;
            i2 = this.startEnd[0] - i3;
            i4 = this.startEnd[1];
        } else {
            i3 = this.startEnd[0];
            i4 = bitArray.getNextUnset(this.startEnd[1] + 1);
            i2 = i4 - this.startEnd[1];
        }
        Object decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i2;
        try {
            return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i3, i4}, i3, i4, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        int i;
        int length;
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z2) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            i = 0;
            for (length = dataCharacterCounters.length - 1; i < length; length--) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        float count = ((float) AbstractRSSReader.count(dataCharacterCounters)) / ((float) 17);
        float f = ((float) (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0])) / 15.0f;
        if (Math.abs(count - f) / f > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int length2;
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (length = 0; length < dataCharacterCounters.length; length++) {
            float f2 = (1.0f * ((float) dataCharacterCounters[length])) / count;
            i = (int) (0.5f + f2);
            if (i < 1) {
                if (f2 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i = 1;
            } else if (i > 8) {
                if (f2 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i = 8;
            }
            int i3 = length / 2;
            if ((length & 1) == 0) {
                oddCounts[i3] = i;
                oddRoundingErrors[i3] = f2 - ((float) i);
            } else {
                evenCounts[i3] = i;
                evenRoundingErrors[i3] = f2 - ((float) i);
            }
        }
        adjustOddEvenCounts(17);
        i = (finderPattern.getValue() * 4) + (z ? 0 : 2);
        if (z2) {
            length = 0;
        } else {
            length = 1;
        }
        int i4 = (length + i) - 1;
        i2 = 0;
        i = oddCounts.length - 1;
        length = 0;
        while (i >= 0) {
            if (isNotA1left(finderPattern, z, z2)) {
                length += WEIGHTS[i4][i * 2] * oddCounts[i];
            }
            i--;
            i2 = oddCounts[i] + i2;
        }
        i = 0;
        for (length2 = evenCounts.length - 1; length2 >= 0; length2--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i += WEIGHTS[i4][(length2 * 2) + 1] * evenCounts[length2];
            }
        }
        length += i;
        if ((i2 & 1) != 0 || i2 > 13 || i2 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        i = (13 - i2) / 2;
        length2 = SYMBOL_WIDEST[i];
        i2 = 9 - length2;
        return new DataCharacter(GSUM[i] + ((RSSUtils.getRSSvalue(oddCounts, length2, true) * EVEN_TOTAL_SUBSET[i]) + RSSUtils.getRSSvalue(evenCounts, i2, false)), length);
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return (finderPattern.getValue() == 0 && z && z2) ? false : true;
    }

    private void adjustOddEvenCounts(int i) throws NotFoundException {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5 = null;
        Object obj6 = 1;
        int count = AbstractRSSReader.count(getOddCounts());
        int count2 = AbstractRSSReader.count(getEvenCounts());
        int i2 = (count + count2) - i;
        Object obj7 = (count & 1) == 1 ? 1 : null;
        if ((count2 & 1) == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (count > 13) {
            obj2 = 1;
            obj3 = null;
        } else if (count < 4) {
            obj2 = null;
            int i3 = 1;
        } else {
            obj2 = null;
            obj3 = null;
        }
        if (count2 > 13) {
            obj4 = null;
            obj5 = 1;
        } else if (count2 < 4) {
            int i4 = 1;
        } else {
            obj4 = null;
        }
        int i5;
        if (i2 == 1) {
            if (obj7 != null) {
                if (obj != null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                obj2 = obj3;
                obj6 = obj4;
                obj4 = 1;
            } else if (obj == null) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                i5 = 1;
                obj6 = obj4;
                obj4 = obj2;
                obj2 = obj3;
            }
        } else if (i2 == -1) {
            if (obj7 != null) {
                if (obj != null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                r12 = obj4;
                obj4 = obj2;
                r3 = 1;
                obj6 = r12;
            } else if (obj == null) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                obj4 = obj2;
                obj2 = obj3;
            }
        } else if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else if (obj7 != null) {
            if (obj == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (count < count2) {
                i5 = 1;
                r12 = obj4;
                obj4 = obj2;
                r3 = 1;
                obj6 = r12;
            } else {
                i4 = 1;
                obj2 = obj3;
            }
        } else if (obj != null) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            obj6 = obj4;
            obj4 = obj2;
            obj2 = obj3;
        }
        if (obj2 != null) {
            if (obj4 != null) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (obj4 != null) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (obj6 != null) {
            if (obj5 != null) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (obj5 != null) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }
}
