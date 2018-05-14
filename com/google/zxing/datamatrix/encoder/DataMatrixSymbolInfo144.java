package com.google.zxing.datamatrix.encoder;

/* compiled from: TbsSdkJava */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    public int getInterleavedBlockCount() {
        return 10;
    }

    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? 156 : 155;
    }
}
