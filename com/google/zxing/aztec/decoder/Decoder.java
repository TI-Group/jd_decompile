package com.google.zxing.aztec.decoder;

import cn.jiguang.net.HttpUtils;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.tencent.connect.common.Constants;
import java.util.Arrays;

/* compiled from: TbsSdkJava */
public final class Decoder {
    private static final String[] DIGIT_TABLE = new String[]{"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", Constants.VIA_SHARE_TYPE_INFO, "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private static final String[] LOWER_TABLE = new String[]{"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = new String[]{"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = new String[]{"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", HttpUtils.PARAMETERS_SEPARATOR, "'", "(", ")", "*", "+", ",", "-", ".", HttpUtils.PATHS_SEPARATOR, ":", ";", "<", HttpUtils.EQUAL_SIGN, ">", HttpUtils.URL_AND_PARA_SEPARATOR, "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] UPPER_TABLE = new String[]{"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private AztecDetectorResult ddata;

    /* compiled from: TbsSdkJava */
    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        return new DecoderResult(null, getEncodedData(correctBits(extractBits(aztecDetectorResult.getBits()))), null, null);
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        Table table2 = Table.UPPER;
        StringBuilder stringBuilder = new StringBuilder(20);
        int i = 0;
        Table table3 = table2;
        table2 = table;
        while (i < length) {
            int i2;
            if (table3 != Table.BINARY) {
                i2 = table3 == Table.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int readCode = readCode(zArr, i, i2);
                i += i2;
                String character = getCharacter(table3, readCode);
                if (character.startsWith("CTRL_")) {
                    table = getTable(character.charAt(5));
                    if (character.charAt(6) == 'L') {
                        table2 = table;
                    }
                } else {
                    stringBuilder.append(character);
                    table = table2;
                }
                table3 = table;
            } else if (length - i < 5) {
                break;
            } else {
                i2 = readCode(zArr, i, 5);
                i += 5;
                if (i2 == 0) {
                    if (length - i < 11) {
                        break;
                    }
                    i2 = readCode(zArr, i, 11) + 31;
                    i += 11;
                }
                int i3 = 0;
                while (i3 < i2) {
                    if (length - i < 8) {
                        i2 = length;
                        break;
                    }
                    stringBuilder.append((char) readCode(zArr, i, 8));
                    i3++;
                    i += 8;
                }
                i2 = i;
                i = i2;
                table3 = table2;
            }
        }
        return stringBuilder.toString();
    }

    private static Table getTable(char c) {
        switch (c) {
            case 'B':
                return Table.BINARY;
            case 'D':
                return Table.DIGIT;
            case 'L':
                return Table.LOWER;
            case 'M':
                return Table.MIXED;
            case 'P':
                return Table.PUNCT;
            default:
                return Table.UPPER;
        }
    }

    private static String getCharacter(Table table, int i) {
        switch (table) {
            case UPPER:
                return UPPER_TABLE[i];
            case LOWER:
                return LOWER_TABLE[i];
            case MIXED:
                return MIXED_TABLE[i];
            case PUNCT:
                return PUNCT_TABLE[i];
            case DIGIT:
                return DIGIT_TABLE[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int i = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            i = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i;
        if (length < nbDatablocks) {
            throw FormatException.getFormatInstance();
        }
        int i2 = length - nbDatablocks;
        int[] iArr = new int[length];
        int length2 = zArr.length % i;
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = readCode(zArr, length2, i);
            i3++;
            length2 += i;
        }
        try {
            new ReedSolomonDecoder(genericGF).decode(iArr, i2);
            int i4 = (1 << i) - 1;
            int i5 = 0;
            for (i3 = 0; i3 < nbDatablocks; i3++) {
                length2 = iArr[i3];
                if (length2 == 0 || length2 == i4) {
                    throw FormatException.getFormatInstance();
                }
                if (length2 == 1 || length2 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[((nbDatablocks * i) - i5)];
            i2 = 0;
            i3 = 0;
            while (i2 < nbDatablocks) {
                int i6 = iArr[i2];
                boolean z;
                if (i6 == 1 || i6 == i4 - 1) {
                    length2 = (i3 + i) - 1;
                    if (i6 > 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Arrays.fill(zArr2, i3, length2, z);
                    i5 = (i - 1) + i3;
                } else {
                    length2 = i - 1;
                    while (length2 >= 0) {
                        length = i3 + 1;
                        if (((1 << length2) & i6) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zArr2[i3] = z;
                        length2--;
                        i3 = length;
                    }
                    i5 = i3;
                }
                i2++;
                i3 = i5;
            }
            return zArr2;
        } catch (ReedSolomonException e) {
            throw FormatException.getFormatInstance();
        }
    }

    boolean[] extractBits(BitMatrix bitMatrix) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i5 = isCompact ? (nbLayers * 4) + 11 : (nbLayers * 4) + 14;
        int[] iArr = new int[i5];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        if (isCompact) {
            for (i = 0; i < iArr.length; i++) {
                iArr[i] = i;
            }
        } else {
            i2 = i5 / 2;
            i3 = ((i5 + 1) + ((((i5 / 2) - 1) / 15) * 2)) / 2;
            for (i = 0; i < i2; i++) {
                i4 = (i / 15) + i;
                iArr[(i2 - i) - 1] = (i3 - i4) - 1;
                iArr[i2 + i] = (i4 + i3) + 1;
            }
        }
        i4 = 0;
        for (int i6 = 0; i6 < nbLayers; i6++) {
            i = isCompact ? ((nbLayers - i6) * 4) + 9 : ((nbLayers - i6) * 4) + 12;
            int i7 = i6 * 2;
            int i8 = (i5 - 1) - i7;
            for (i3 = 0; i3 < i; i3++) {
                int i9 = i3 * 2;
                for (i2 = 0; i2 < 2; i2++) {
                    zArr[(i4 + i9) + i2] = bitMatrix.get(iArr[i7 + i2], iArr[i7 + i3]);
                    zArr[(((i * 2) + i4) + i9) + i2] = bitMatrix.get(iArr[i7 + i3], iArr[i8 - i2]);
                    zArr[(((i * 4) + i4) + i9) + i2] = bitMatrix.get(iArr[i8 - i2], iArr[i8 - i3]);
                    zArr[(((i * 6) + i4) + i9) + i2] = bitMatrix.get(iArr[i8 - i3], iArr[i7 + i2]);
                }
            }
            i4 = (i * 8) + i4;
        }
        return zArr;
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }
}
