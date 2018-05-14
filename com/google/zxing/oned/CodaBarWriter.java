package com.google.zxing.oned;

import java.util.Arrays;
import org.apache.commons.lang.ClassUtils;

/* compiled from: TbsSdkJava */
public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = new char[]{'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = new char[]{'/', ':', '+', ClassUtils.PACKAGE_SEPARATOR_CHAR};
    private static final char[] START_END_CHARS = new char[]{'A', 'B', 'C', 'D'};

    public boolean[] encode(String str) {
        if (str.length() < 2) {
            throw new IllegalArgumentException("Codabar should start/end with start/stop symbols");
        }
        char toUpperCase = Character.toUpperCase(str.charAt(0));
        char toUpperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
        boolean z = CodaBarReader.arrayContains(START_END_CHARS, toUpperCase) && CodaBarReader.arrayContains(START_END_CHARS, toUpperCase2);
        boolean z2;
        if (CodaBarReader.arrayContains(ALT_START_END_CHARS, toUpperCase) && CodaBarReader.arrayContains(ALT_START_END_CHARS, toUpperCase2)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || r3) {
            int i = 20;
            int i2 = 1;
            while (i2 < str.length() - 1) {
                if (Character.isDigit(str.charAt(i2)) || str.charAt(i2) == '-' || str.charAt(i2) == ClassUtils.INNER_CLASS_SEPARATOR_CHAR) {
                    i += 9;
                } else if (CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i2))) {
                    i += 10;
                } else {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i2) + '\'');
                }
                i2++;
            }
            boolean[] zArr = new boolean[((str.length() - 1) + i)];
            i2 = 0;
            i = 0;
            while (i2 < str.length()) {
                int i3;
                int i4;
                boolean z3;
                int i5;
                toUpperCase2 = Character.toUpperCase(str.charAt(i2));
                if (i2 == 0 || i2 == str.length() - 1) {
                    switch (toUpperCase2) {
                        case '*':
                            toUpperCase2 = 'C';
                            break;
                        case 'E':
                            toUpperCase2 = 'D';
                            break;
                        case 'N':
                            toUpperCase2 = 'B';
                            break;
                        case 'T':
                            toUpperCase2 = 'A';
                            break;
                    }
                }
                int i6 = 0;
                while (i6 < CodaBarReader.ALPHABET.length) {
                    if (toUpperCase2 == CodaBarReader.ALPHABET[i6]) {
                        i3 = CodaBarReader.CHARACTER_ENCODINGS[i6];
                        i6 = 0;
                        i4 = 0;
                        z3 = true;
                        while (i6 < 7) {
                            zArr[i] = z3;
                            i5 = i + 1;
                            if (((i3 >> (6 - i6)) & 1) != 0 || i4 == 1) {
                                i6++;
                                i4 = 0;
                                z3 = z3;
                                i = i5;
                            } else {
                                i4++;
                                i = i5;
                            }
                        }
                        if (i2 < str.length() - 1) {
                            zArr[i] = false;
                            i++;
                        }
                        i2++;
                    } else {
                        i6++;
                    }
                }
                i3 = 0;
                i6 = 0;
                i4 = 0;
                z3 = true;
                while (i6 < 7) {
                    zArr[i] = z3;
                    i5 = i + 1;
                    if (((i3 >> (6 - i6)) & 1) != 0) {
                    }
                    if (z3) {
                    }
                    i6++;
                    i4 = 0;
                    z3 = z3;
                    i = i5;
                }
                if (i2 < str.length() - 1) {
                    zArr[i] = false;
                    i++;
                }
                i2++;
            }
            return zArr;
        }
        throw new IllegalArgumentException("Codabar should start/end with " + Arrays.toString(START_END_CHARS) + ", or start/end with " + Arrays.toString(ALT_START_END_CHARS));
    }
}
