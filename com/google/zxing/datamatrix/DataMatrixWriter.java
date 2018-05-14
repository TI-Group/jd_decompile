package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

/* compiled from: TbsSdkJava */
public final class DataMatrixWriter implements Writer {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Dimension dimension = null;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            Dimension dimension2;
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            if (map != null) {
                SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (symbolShapeHint2 != null) {
                    symbolShapeHint = symbolShapeHint2;
                }
                Dimension dimension3 = (Dimension) map.get(EncodeHintType.MIN_SIZE);
                if (dimension3 != null) {
                    dimension2 = dimension3;
                } else {
                    dimension2 = null;
                }
                dimension3 = (Dimension) map.get(EncodeHintType.MAX_SIZE);
                if (dimension3 != null) {
                    dimension = dimension3;
                }
            } else {
                dimension2 = null;
            }
            String encodeHighLevel = HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension2, dimension);
            SymbolInfo lookup = SymbolInfo.lookup(encodeHighLevel.length(), symbolShapeHint, dimension2, dimension, true);
            DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(encodeHighLevel, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
            defaultPlacement.place();
            return encodeLowLevel(defaultPlacement, lookup);
        }
    }

    private static BitMatrix encodeLowLevel(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo) {
        int symbolDataWidth = symbolInfo.getSymbolDataWidth();
        int symbolDataHeight = symbolInfo.getSymbolDataHeight();
        ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
        int i = 0;
        int i2 = 0;
        while (i < symbolDataHeight) {
            int i3;
            int i4;
            int i5;
            if (i % symbolInfo.matrixHeight == 0) {
                i3 = 0;
                for (i4 = 0; i4 < symbolInfo.getSymbolWidth(); i4++) {
                    boolean z;
                    if (i4 % 2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    byteMatrix.set(i3, i2, z);
                    i3++;
                }
                i4 = i2 + 1;
            } else {
                i4 = i2;
            }
            i3 = 0;
            for (i2 = 0; i2 < symbolDataWidth; i2++) {
                if (i2 % symbolInfo.matrixWidth == 0) {
                    byteMatrix.set(i3, i4, true);
                    i3++;
                }
                byteMatrix.set(i3, i4, defaultPlacement.getBit(i2, i));
                i5 = i3 + 1;
                if (i2 % symbolInfo.matrixWidth == symbolInfo.matrixWidth - 1) {
                    boolean z2;
                    if (i % 2 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    byteMatrix.set(i5, i4, z2);
                    i3 = i5 + 1;
                } else {
                    i3 = i5;
                }
            }
            i5 = i4 + 1;
            if (i % symbolInfo.matrixHeight == symbolInfo.matrixHeight - 1) {
                i3 = 0;
                for (i4 = 0; i4 < symbolInfo.getSymbolWidth(); i4++) {
                    byteMatrix.set(i3, i5, true);
                    i3++;
                }
                i4 = i5 + 1;
            } else {
                i4 = i5;
            }
            i++;
            i2 = i4;
        }
        return convertByteMatrixToBitMatrix(byteMatrix);
    }

    private static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix byteMatrix) {
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        bitMatrix.clear();
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                if (byteMatrix.get(i, i2) == (byte) 1) {
                    bitMatrix.set(i, i2);
                }
            }
        }
        return bitMatrix;
    }
}
