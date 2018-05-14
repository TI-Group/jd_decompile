package com.google.zxing.datamatrix.decoder;

/* compiled from: TbsSdkJava */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        int i;
        int i2;
        ECBlocks eCBlocks = version.getECBlocks();
        ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i3 = 0;
        for (ECB count : eCBlocks2) {
            i3 += count.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i3];
        int length = eCBlocks2.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            ECB ecb = eCBlocks2[i4];
            i3 = i5;
            i5 = 0;
            while (i5 < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                i = i3 + 1;
                dataBlockArr[i3] = new DataBlock(dataCodewords, new byte[(eCBlocks.getECCodewords() + dataCodewords)]);
                i5++;
                i3 = i;
            }
            i4++;
            i5 = i3;
        }
        i = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        length = i - 1;
        int i6 = 0;
        for (i2 = 0; i2 < length; i2++) {
            i3 = 0;
            while (i3 < i5) {
                i4 = i6 + 1;
                dataBlockArr[i3].codewords[i2] = bArr[i6];
                i3++;
                i6 = i4;
            }
        }
        if (version.getVersionNumber() == 24) {
            length = 1;
        } else {
            length = 0;
        }
        if (length != 0) {
            i3 = 8;
        } else {
            i3 = i5;
        }
        i4 = 0;
        while (i4 < i3) {
            i2 = i6 + 1;
            dataBlockArr[i4].codewords[i - 1] = bArr[i6];
            i4++;
            i6 = i2;
        }
        int length2 = dataBlockArr[0].codewords.length;
        i3 = i6;
        while (i < length2) {
            i4 = 0;
            i6 = i3;
            while (i4 < i5) {
                if (length == 0 || i4 <= 7) {
                    i3 = i;
                } else {
                    i3 = i - 1;
                }
                i2 = i6 + 1;
                dataBlockArr[i4].codewords[i3] = bArr[i6];
                i4++;
                i6 = i2;
            }
            i++;
            i3 = i6;
        }
        if (i3 == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    byte[] getCodewords() {
        return this.codewords;
    }
}
