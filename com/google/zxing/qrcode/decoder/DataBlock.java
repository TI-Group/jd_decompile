package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version.ECB;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;

/* compiled from: TbsSdkJava */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        int i;
        ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int i2 = 0;
        for (ECB count : eCBlocks) {
            i2 += count.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i2];
        int length = eCBlocks.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            ECB ecb = eCBlocks[i3];
            i2 = i4;
            i4 = 0;
            while (i4 < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                i = i2 + 1;
                dataBlockArr[i2] = new DataBlock(dataCodewords, new byte[(eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords)]);
                i4++;
                i2 = i;
            }
            i3++;
            i4 = i2;
        }
        i = dataBlockArr[0].codewords.length;
        i2 = dataBlockArr.length - 1;
        while (i2 >= 0 && dataBlockArr[i2].codewords.length != i) {
            i2--;
        }
        length = i2 + 1;
        i -= eCBlocksForLevel.getECCodewordsPerBlock();
        int i5 = 0;
        i2 = 0;
        while (i5 < i) {
            i3 = i2;
            i2 = 0;
            while (i2 < i4) {
                int i6 = i3 + 1;
                dataBlockArr[i2].codewords[i5] = bArr[i3];
                i2++;
                i3 = i6;
            }
            i5++;
            i2 = i3;
        }
        i3 = length;
        while (i3 < i4) {
            i6 = i2 + 1;
            dataBlockArr[i3].codewords[i] = bArr[i2];
            i3++;
            i2 = i6;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (i < length2) {
            i3 = 0;
            i6 = i2;
            while (i3 < i4) {
                i5 = i6 + 1;
                dataBlockArr[i3].codewords[i3 < length ? i : i + 1] = bArr[i6];
                i3++;
                i6 = i5;
            }
            i++;
            i2 = i6;
        }
        return dataBlockArr;
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    byte[] getCodewords() {
        return this.codewords;
    }
}
