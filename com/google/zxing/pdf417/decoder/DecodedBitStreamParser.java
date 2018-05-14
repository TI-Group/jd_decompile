package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.math.BigInteger;
import java.util.Arrays;
import org.apache.commons.lang.ClassUtils;

/* compiled from: TbsSdkJava */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final BigInteger[] EXP900 = new BigInteger[16];
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', '\r', '\t', ',', ':', '#', '-', ClassUtils.PACKAGE_SEPARATOR_CHAR, ClassUtils.INNER_CLASS_SEPARATOR_CHAR, '/', '+', '%', '*', '=', '^'};
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = new char[]{';', '<', '>', '@', '[', '\\', ']', '_', '`', '~', '!', '\r', '\t', ',', ':', '\n', '-', ClassUtils.PACKAGE_SEPARATOR_CHAR, ClassUtils.INNER_CLASS_SEPARATOR_CHAR, '/', '\"', '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    /* compiled from: TbsSdkJava */
    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        EXP900[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        for (int i = 2; i < EXP900.length; i++) {
            EXP900[i] = EXP900[i - 1].multiply(valueOf);
        }
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        StringBuilder stringBuilder = new StringBuilder(iArr.length * 2);
        int i = 2;
        int i2 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        while (i < iArr[0]) {
            switch (i2) {
                case TEXT_COMPACTION_MODE_LATCH /*900*/:
                    i2 = textCompaction(iArr, i, stringBuilder);
                    break;
                case BYTE_COMPACTION_MODE_LATCH /*901*/:
                case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /*913*/:
                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                    i2 = byteCompaction(i2, iArr, i, stringBuilder);
                    break;
                case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                    i2 = numericCompaction(iArr, i, stringBuilder);
                    break;
                case MACRO_PDF417_TERMINATOR /*922*/:
                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                    throw FormatException.getFormatInstance();
                case 928:
                    i2 = decodeMacroBlock(iArr, i, pDF417ResultMetadata);
                    break;
                default:
                    i2 = textCompaction(iArr, i - 1, stringBuilder);
                    break;
            }
            if (i2 < iArr.length) {
                i = i2 + 1;
                i2 = iArr[i2];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (stringBuilder.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, stringBuilder.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder stringBuilder = new StringBuilder();
        int textCompaction = textCompaction(iArr, i, stringBuilder);
        pDF417ResultMetadata.setFileId(stringBuilder.toString());
        if (iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            i2 = textCompaction + 1;
            int[] iArr3 = new int[(iArr[0] - i2)];
            int i3 = 0;
            textCompaction = i2;
            i2 = 0;
            while (textCompaction < iArr[0] && r0 == 0) {
                int i4 = textCompaction + 1;
                int i5 = iArr[textCompaction];
                if (i5 < TEXT_COMPACTION_MODE_LATCH) {
                    textCompaction = i3 + 1;
                    iArr3[i3] = i5;
                    i3 = textCompaction;
                    textCompaction = i4;
                } else {
                    switch (i5) {
                        case MACRO_PDF417_TERMINATOR /*922*/:
                            pDF417ResultMetadata.setLastSegment(true);
                            textCompaction = i4 + 1;
                            i2 = true;
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                }
            }
            pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i3));
            return textCompaction;
        } else if (iArr[textCompaction] != MACRO_PDF417_TERMINATOR) {
            return textCompaction;
        } else {
            pDF417ResultMetadata.setLastSegment(true);
            return textCompaction + 1;
        }
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder stringBuilder) {
        int[] iArr2 = new int[((iArr[0] - i) * 2)];
        int[] iArr3 = new int[((iArr[0] - i) * 2)];
        int i2 = 0;
        int i3 = 0;
        while (i < iArr[0] && r0 == 0) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 >= TEXT_COMPACTION_MODE_LATCH) {
                switch (i5) {
                    case TEXT_COMPACTION_MODE_LATCH /*900*/:
                        i5 = i3 + 1;
                        iArr2[i3] = TEXT_COMPACTION_MODE_LATCH;
                        i3 = i5;
                        i = i4;
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /*901*/:
                    case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                    case MACRO_PDF417_TERMINATOR /*922*/:
                    case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                    case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                    case 928:
                        i = i4 - 1;
                        i2 = 1;
                        break;
                    case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /*913*/:
                        iArr2[i3] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                        i = i4 + 1;
                        iArr3[i3] = iArr[i4];
                        i3++;
                        break;
                    default:
                        i = i4;
                        break;
                }
            }
            iArr2[i3] = i5 / 30;
            iArr2[i3 + 1] = i5 % 30;
            i3 += 2;
            i = i4;
        }
        decodeTextCompaction(iArr2, iArr3, i3, stringBuilder);
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decodeTextCompaction(int[] r8, int[] r9, int r10, java.lang.StringBuilder r11) {
        /*
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r0 = 0;
        r3 = r0;
    L_0x0006:
        if (r3 >= r10) goto L_0x0146;
    L_0x0008:
        r4 = r8[r3];
        r0 = 0;
        r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;
        r6 = r2.ordinal();
        r5 = r5[r6];
        switch(r5) {
            case 1: goto L_0x001f;
            case 2: goto L_0x0058;
            case 3: goto L_0x0094;
            case 4: goto L_0x00dd;
            case 5: goto L_0x0103;
            case 6: goto L_0x011e;
            default: goto L_0x0016;
        };
    L_0x0016:
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r11.append(r0);
    L_0x001b:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0006;
    L_0x001f:
        r5 = 26;
        if (r4 >= r5) goto L_0x0027;
    L_0x0023:
        r0 = r4 + 65;
        r0 = (char) r0;
        goto L_0x0016;
    L_0x0027:
        r5 = 26;
        if (r4 != r5) goto L_0x002e;
    L_0x002b:
        r0 = 32;
        goto L_0x0016;
    L_0x002e:
        r5 = 27;
        if (r4 != r5) goto L_0x0035;
    L_0x0032:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER;
        goto L_0x0016;
    L_0x0035:
        r5 = 28;
        if (r4 != r5) goto L_0x003c;
    L_0x0039:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED;
        goto L_0x0016;
    L_0x003c:
        r5 = 29;
        if (r4 != r5) goto L_0x0046;
    L_0x0040:
        r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0016;
    L_0x0046:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x0051;
    L_0x004a:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0016;
    L_0x0051:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0016;
    L_0x0055:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0016;
    L_0x0058:
        r5 = 26;
        if (r4 >= r5) goto L_0x0060;
    L_0x005c:
        r0 = r4 + 97;
        r0 = (char) r0;
        goto L_0x0016;
    L_0x0060:
        r5 = 26;
        if (r4 != r5) goto L_0x0067;
    L_0x0064:
        r0 = 32;
        goto L_0x0016;
    L_0x0067:
        r5 = 27;
        if (r4 != r5) goto L_0x0071;
    L_0x006b:
        r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0016;
    L_0x0071:
        r5 = 28;
        if (r4 != r5) goto L_0x0078;
    L_0x0075:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED;
        goto L_0x0016;
    L_0x0078:
        r5 = 29;
        if (r4 != r5) goto L_0x0082;
    L_0x007c:
        r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0016;
    L_0x0082:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x008d;
    L_0x0086:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0016;
    L_0x008d:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0016;
    L_0x0091:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0016;
    L_0x0094:
        r5 = 25;
        if (r4 >= r5) goto L_0x009e;
    L_0x0098:
        r0 = MIXED_CHARS;
        r0 = r0[r4];
        goto L_0x0016;
    L_0x009e:
        r5 = 25;
        if (r4 != r5) goto L_0x00a6;
    L_0x00a2:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT;
        goto L_0x0016;
    L_0x00a6:
        r5 = 26;
        if (r4 != r5) goto L_0x00ae;
    L_0x00aa:
        r0 = 32;
        goto L_0x0016;
    L_0x00ae:
        r5 = 27;
        if (r4 != r5) goto L_0x00b6;
    L_0x00b2:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER;
        goto L_0x0016;
    L_0x00b6:
        r5 = 28;
        if (r4 != r5) goto L_0x00be;
    L_0x00ba:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0016;
    L_0x00be:
        r5 = 29;
        if (r4 != r5) goto L_0x00c9;
    L_0x00c2:
        r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x0016;
    L_0x00c9:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x00d5;
    L_0x00cd:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0016;
    L_0x00d5:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0016;
    L_0x00d9:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0016;
    L_0x00dd:
        r5 = 29;
        if (r4 >= r5) goto L_0x00e7;
    L_0x00e1:
        r0 = PUNCT_CHARS;
        r0 = r0[r4];
        goto L_0x0016;
    L_0x00e7:
        r5 = 29;
        if (r4 != r5) goto L_0x00ef;
    L_0x00eb:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0016;
    L_0x00ef:
        r5 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r5) goto L_0x00fb;
    L_0x00f3:
        r4 = r9[r3];
        r4 = (char) r4;
        r11.append(r4);
        goto L_0x0016;
    L_0x00fb:
        r5 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r5) goto L_0x0016;
    L_0x00ff:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0016;
    L_0x0103:
        r2 = 26;
        if (r4 >= r2) goto L_0x010d;
    L_0x0107:
        r0 = r4 + 65;
        r0 = (char) r0;
        r2 = r1;
        goto L_0x0016;
    L_0x010d:
        r2 = 26;
        if (r4 != r2) goto L_0x0116;
    L_0x0111:
        r0 = 32;
        r2 = r1;
        goto L_0x0016;
    L_0x0116:
        r2 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r2) goto L_0x0147;
    L_0x011a:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0016;
    L_0x011e:
        r2 = 29;
        if (r4 >= r2) goto L_0x0129;
    L_0x0122:
        r0 = PUNCT_CHARS;
        r0 = r0[r4];
        r2 = r1;
        goto L_0x0016;
    L_0x0129:
        r2 = 29;
        if (r4 != r2) goto L_0x0131;
    L_0x012d:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0016;
    L_0x0131:
        r2 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        if (r4 != r2) goto L_0x013e;
    L_0x0135:
        r2 = r9[r3];
        r2 = (char) r2;
        r11.append(r2);
        r2 = r1;
        goto L_0x0016;
    L_0x013e:
        r2 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        if (r4 != r2) goto L_0x0147;
    L_0x0142:
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        goto L_0x0016;
    L_0x0146:
        return;
    L_0x0147:
        r2 = r1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int byteCompaction(int i, int[] iArr, int i2, StringBuilder stringBuilder) {
        int i3;
        long j;
        int i4;
        int i5;
        if (i == BYTE_COMPACTION_MODE_LATCH) {
            i3 = 0;
            j = 0;
            char[] cArr = new char[6];
            int[] iArr2 = new int[6];
            Object obj = null;
            i4 = i2 + 1;
            int i6 = iArr[i2];
            int i7 = i4;
            while (i7 < iArr[0] && r1 == null) {
                i4 = i3 + 1;
                iArr2[i3] = i6;
                j = (j * 900) + ((long) i6);
                int i8 = i7 + 1;
                i6 = iArr[i7];
                if (i6 == TEXT_COMPACTION_MODE_LATCH || i6 == BYTE_COMPACTION_MODE_LATCH || i6 == NUMERIC_COMPACTION_MODE_LATCH || i6 == BYTE_COMPACTION_MODE_LATCH_6 || i6 == 928 || i6 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i6 == MACRO_PDF417_TERMINATOR) {
                    obj = 1;
                    i7 = i8 - 1;
                    i3 = i4;
                } else if (i4 % 5 != 0 || i4 <= 0) {
                    i3 = i4;
                    i7 = i8;
                } else {
                    i3 = 0;
                    while (i3 < 6) {
                        cArr[5 - i3] = (char) ((int) (j % 256));
                        i3++;
                        j >>= 8;
                    }
                    stringBuilder.append(cArr);
                    i3 = 0;
                    i7 = i8;
                }
            }
            if (i7 == iArr[0] && i6 < TEXT_COMPACTION_MODE_LATCH) {
                i5 = i3 + 1;
                iArr2[i3] = i6;
                i3 = i5;
            }
            for (i6 = 0; i6 < i3; i6++) {
                stringBuilder.append((char) iArr2[i6]);
            }
            return i7;
        } else if (i != BYTE_COMPACTION_MODE_LATCH_6) {
            return i2;
        } else {
            i5 = 0;
            j = 0;
            Object obj2 = null;
            while (i2 < iArr[0] && r0 == null) {
                i3 = i2 + 1;
                i4 = iArr[i2];
                if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                    i5++;
                    j = (j * 900) + ((long) i4);
                    i2 = i3;
                } else if (i4 == TEXT_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == NUMERIC_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == 928 || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                    i2 = i3 - 1;
                    obj2 = 1;
                } else {
                    i2 = i3;
                }
                if (i5 % 5 == 0 && i5 > 0) {
                    char[] cArr2 = new char[6];
                    for (i5 = 0; i5 < 6; i5++) {
                        cArr2[5 - i5] = (char) ((int) (255 & j));
                        j >>= 8;
                    }
                    stringBuilder.append(cArr2);
                    i5 = 0;
                }
            }
            return i2;
        }
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder stringBuilder) throws FormatException {
        int[] iArr2 = new int[15];
        int i2 = 0;
        int i3 = 0;
        while (i < iArr[0] && r0 == 0) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i4 == iArr[0]) {
                i2 = 1;
            }
            if (i5 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i3] = i5;
                i3++;
                i = i4;
            } else if (i5 == TEXT_COMPACTION_MODE_LATCH || i5 == BYTE_COMPACTION_MODE_LATCH || i5 == BYTE_COMPACTION_MODE_LATCH_6 || i5 == 928 || i5 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i5 == MACRO_PDF417_TERMINATOR) {
                i = i4 - 1;
                i2 = 1;
            } else {
                i = i4;
            }
            if (i3 % 15 == 0 || i5 == NUMERIC_COMPACTION_MODE_LATCH || r0 != 0) {
                stringBuilder.append(decodeBase900toBase10(iArr2, i3));
                i3 = 0;
            }
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
