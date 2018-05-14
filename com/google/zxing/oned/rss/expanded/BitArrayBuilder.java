package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;

/* compiled from: TbsSdkJava */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    static BitArray buildBitArray(List<ExpandedPair> list) {
        int i;
        int size = (list.size() * 2) - 1;
        if (((ExpandedPair) list.get(list.size() - 1)).getRightChar() == null) {
            i = size - 1;
        } else {
            i = size;
        }
        BitArray bitArray = new BitArray(i * 12);
        int value = ((ExpandedPair) list.get(0)).getRightChar().getValue();
        size = 11;
        i = 0;
        while (size >= 0) {
            if (((1 << size) & value) != 0) {
                bitArray.set(i);
            }
            size--;
            i++;
        }
        int i2 = i;
        for (size = 1; size < list.size(); size++) {
            ExpandedPair expandedPair = (ExpandedPair) list.get(size);
            int value2 = expandedPair.getLeftChar().getValue();
            value = 11;
            while (value >= 0) {
                if (((1 << value) & value2) != 0) {
                    bitArray.set(i2);
                }
                value--;
                i2++;
            }
            if (expandedPair.getRightChar() != null) {
                value = expandedPair.getRightChar().getValue();
                for (i = 11; i >= 0; i--) {
                    if (((1 << i) & value) != 0) {
                        bitArray.set(i2);
                    }
                    i2++;
                }
            }
        }
        return bitArray;
    }
}
