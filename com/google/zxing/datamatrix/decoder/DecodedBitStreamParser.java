package com.google.zxing.datamatrix.decoder;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang.ClassUtils;

/* compiled from: TbsSdkJava */
final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] C40_SHIFT2_SET_CHARS = new char[]{'!', '\"', '#', ClassUtils.INNER_CLASS_SEPARATOR_CHAR, '%', '&', '\'', '(', ')', '*', '+', ',', '-', ClassUtils.PACKAGE_SEPARATOR_CHAR, '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
    private static final char[] TEXT_BASIC_SET_CHARS = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] TEXT_SHIFT3_SET_CHARS = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', ''};

    /* compiled from: TbsSdkJava */
    private enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] bArr) throws FormatException {
        String stringBuilder;
        List list;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder stringBuilder2 = new StringBuilder(100);
        CharSequence stringBuilder3 = new StringBuilder(0);
        Collection arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            if (mode == Mode.ASCII_ENCODE) {
                mode = decodeAsciiSegment(bitSource, stringBuilder2, stringBuilder3);
            } else {
                switch (mode) {
                    case C40_ENCODE:
                        decodeC40Segment(bitSource, stringBuilder2);
                        break;
                    case TEXT_ENCODE:
                        decodeTextSegment(bitSource, stringBuilder2);
                        break;
                    case ANSIX12_ENCODE:
                        decodeAnsiX12Segment(bitSource, stringBuilder2);
                        break;
                    case EDIFACT_ENCODE:
                        decodeEdifactSegment(bitSource, stringBuilder2);
                        break;
                    case BASE256_ENCODE:
                        decodeBase256Segment(bitSource, stringBuilder2, arrayList);
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
                mode = Mode.ASCII_ENCODE;
            }
            if (mode != Mode.PAD_ENCODE) {
            }
            if (stringBuilder3.length() > 0) {
                stringBuilder2.append(stringBuilder3);
            }
            stringBuilder = stringBuilder2.toString();
            if (arrayList.isEmpty()) {
                Collection collection = arrayList;
            } else {
                list = null;
            }
            return new DecoderResult(bArr, stringBuilder, list, null);
        } while (bitSource.available() > 0);
        if (stringBuilder3.length() > 0) {
            stringBuilder2.append(stringBuilder3);
        }
        stringBuilder = stringBuilder2.toString();
        if (arrayList.isEmpty()) {
            Collection collection2 = arrayList;
        } else {
            list = null;
        }
        return new DecoderResult(bArr, stringBuilder, list, null);
    }

    private static Mode decodeAsciiSegment(BitSource bitSource, StringBuilder stringBuilder, StringBuilder stringBuilder2) throws FormatException {
        int i = 0;
        do {
            int readBits = bitSource.readBits(8);
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            } else if (readBits <= 128) {
                if (i != 0) {
                    i = readBits + 128;
                } else {
                    i = readBits;
                }
                stringBuilder.append((char) (i - 1));
                return Mode.ASCII_ENCODE;
            } else if (readBits == 129) {
                return Mode.PAD_ENCODE;
            } else {
                if (readBits <= 229) {
                    readBits -= 130;
                    if (readBits < 10) {
                        stringBuilder.append('0');
                    }
                    stringBuilder.append(readBits);
                } else if (readBits == 230) {
                    return Mode.C40_ENCODE;
                } else {
                    if (readBits == 231) {
                        return Mode.BASE256_ENCODE;
                    }
                    if (readBits == 232) {
                        stringBuilder.append('\u001d');
                    } else if (!(readBits == 233 || readBits == 234)) {
                        if (readBits == 235) {
                            i = 1;
                        } else if (readBits == 236) {
                            stringBuilder.append("[)>\u001e05\u001d");
                            stringBuilder2.insert(0, "\u001e\u0004");
                        } else if (readBits == 237) {
                            stringBuilder.append("[)>\u001e06\u001d");
                            stringBuilder2.insert(0, "\u001e\u0004");
                        } else if (readBits == 238) {
                            return Mode.ANSIX12_ENCODE;
                        } else {
                            if (readBits == 239) {
                                return Mode.TEXT_ENCODE;
                            }
                            if (readBits == 240) {
                                return Mode.EDIFACT_ENCODE;
                            }
                            if (!(readBits == 241 || readBits < 242 || (readBits == 254 && bitSource.available() == 0))) {
                                throw FormatException.getFormatInstance();
                            }
                        }
                    }
                }
            }
        } while (bitSource.available() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void decodeC40Segment(BitSource bitSource, StringBuilder stringBuilder) throws FormatException {
        int[] iArr = new int[3];
        int i = 0;
        Object obj = null;
        while (bitSource.available() != 8) {
            int readBits = bitSource.readBits(8);
            if (readBits != 254) {
                parseTwoBytes(readBits, bitSource.readBits(8), iArr);
                for (readBits = 0; readBits < 3; readBits++) {
                    int i2 = iArr[readBits];
                    switch (i) {
                        case 0:
                            if (i2 < 3) {
                                i = i2 + 1;
                                break;
                            } else if (i2 < C40_BASIC_SET_CHARS.length) {
                                char c = C40_BASIC_SET_CHARS[i2];
                                if (obj == null) {
                                    stringBuilder.append(c);
                                    break;
                                }
                                stringBuilder.append((char) (c + 128));
                                obj = null;
                                break;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        case 1:
                            if (obj != null) {
                                stringBuilder.append((char) (i2 + 128));
                                obj = null;
                            } else {
                                stringBuilder.append((char) i2);
                            }
                            i = 0;
                            break;
                        case 2:
                            if (i2 < C40_SHIFT2_SET_CHARS.length) {
                                char c2 = C40_SHIFT2_SET_CHARS[i2];
                                if (obj != null) {
                                    stringBuilder.append((char) (c2 + 128));
                                    obj = null;
                                } else {
                                    stringBuilder.append(c2);
                                }
                            } else if (i2 == 27) {
                                stringBuilder.append('\u001d');
                            } else if (i2 == 30) {
                                obj = 1;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            i = 0;
                            break;
                        case 3:
                            if (obj != null) {
                                stringBuilder.append((char) (i2 + ErrorCode.EXCEED_INCR_UPDATE));
                                obj = null;
                            } else {
                                stringBuilder.append((char) (i2 + 96));
                            }
                            i = 0;
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                }
                if (bitSource.available() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    private static void decodeTextSegment(BitSource bitSource, StringBuilder stringBuilder) throws FormatException {
        int[] iArr = new int[3];
        int i = 0;
        Object obj = null;
        while (bitSource.available() != 8) {
            int readBits = bitSource.readBits(8);
            if (readBits != 254) {
                parseTwoBytes(readBits, bitSource.readBits(8), iArr);
                for (readBits = 0; readBits < 3; readBits++) {
                    int i2 = iArr[readBits];
                    char c;
                    switch (i) {
                        case 0:
                            if (i2 < 3) {
                                i = i2 + 1;
                                break;
                            } else if (i2 < TEXT_BASIC_SET_CHARS.length) {
                                char c2 = TEXT_BASIC_SET_CHARS[i2];
                                if (obj == null) {
                                    stringBuilder.append(c2);
                                    break;
                                }
                                stringBuilder.append((char) (c2 + 128));
                                obj = null;
                                break;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        case 1:
                            if (obj != null) {
                                stringBuilder.append((char) (i2 + 128));
                                obj = null;
                            } else {
                                stringBuilder.append((char) i2);
                            }
                            i = 0;
                            break;
                        case 2:
                            if (i2 < C40_SHIFT2_SET_CHARS.length) {
                                c = C40_SHIFT2_SET_CHARS[i2];
                                if (obj != null) {
                                    stringBuilder.append((char) (c + 128));
                                    obj = null;
                                } else {
                                    stringBuilder.append(c);
                                }
                            } else if (i2 == 27) {
                                stringBuilder.append('\u001d');
                            } else if (i2 == 30) {
                                obj = 1;
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                            i = 0;
                            break;
                        case 3:
                            if (i2 < TEXT_SHIFT3_SET_CHARS.length) {
                                c = TEXT_SHIFT3_SET_CHARS[i2];
                                if (obj != null) {
                                    stringBuilder.append((char) (c + 128));
                                    obj = null;
                                } else {
                                    stringBuilder.append(c);
                                }
                                i = 0;
                                break;
                            }
                            throw FormatException.getFormatInstance();
                        default:
                            throw FormatException.getFormatInstance();
                    }
                }
                if (bitSource.available() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    private static void decodeAnsiX12Segment(BitSource bitSource, StringBuilder stringBuilder) throws FormatException {
        int[] iArr = new int[3];
        while (bitSource.available() != 8) {
            int readBits = bitSource.readBits(8);
            if (readBits != 254) {
                parseTwoBytes(readBits, bitSource.readBits(8), iArr);
                for (readBits = 0; readBits < 3; readBits++) {
                    int i = iArr[readBits];
                    if (i == 0) {
                        stringBuilder.append('\r');
                    } else if (i == 1) {
                        stringBuilder.append('*');
                    } else if (i == 2) {
                        stringBuilder.append('>');
                    } else if (i == 3) {
                        stringBuilder.append(' ');
                    } else if (i < 14) {
                        stringBuilder.append((char) (i + 44));
                    } else if (i < 40) {
                        stringBuilder.append((char) (i + 51));
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                if (bitSource.available() <= 0) {
                    return;
                }
            }
            return;
        }
    }

    private static void parseTwoBytes(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / 1600;
        iArr[0] = i4;
        i3 -= i4 * 1600;
        i4 = i3 / 40;
        iArr[1] = i4;
        iArr[2] = i3 - (i4 * 40);
    }

    private static void decodeEdifactSegment(BitSource bitSource, StringBuilder stringBuilder) {
        while (bitSource.available() > 16) {
            for (int i = 0; i < 4; i++) {
                int readBits = bitSource.readBits(6);
                if (readBits == 31) {
                    readBits = 8 - bitSource.getBitOffset();
                    if (readBits != 8) {
                        bitSource.readBits(readBits);
                        return;
                    }
                    return;
                }
                if ((readBits & 32) == 0) {
                    readBits |= 64;
                }
                stringBuilder.append((char) readBits);
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeBase256Segment(BitSource bitSource, StringBuilder stringBuilder, Collection<byte[]> collection) throws FormatException {
        int available;
        int byteOffset = bitSource.getByteOffset() + 1;
        int i = byteOffset + 1;
        byteOffset = unrandomize255State(bitSource.readBits(8), byteOffset);
        if (byteOffset == 0) {
            available = bitSource.available() / 8;
        } else if (byteOffset < Callback.DEFAULT_SWIPE_ANIMATION_DURATION) {
            available = byteOffset;
        } else {
            available = ((byteOffset - 249) * Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + unrandomize255State(bitSource.readBits(8), i);
            i++;
        }
        if (available < 0) {
            throw FormatException.getFormatInstance();
        }
        Object obj = new byte[available];
        byteOffset = 0;
        while (byteOffset < available) {
            if (bitSource.available() < 8) {
                throw FormatException.getFormatInstance();
            }
            int i2 = i + 1;
            obj[byteOffset] = (byte) unrandomize255State(bitSource.readBits(8), i);
            byteOffset++;
            i = i2;
        }
        collection.add(obj);
        try {
            stringBuilder.append(new String(obj, "ISO8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Platform does not support required encoding: " + e);
        }
    }

    private static int unrandomize255State(int i, int i2) {
        int i3 = i - (((i2 * 149) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
