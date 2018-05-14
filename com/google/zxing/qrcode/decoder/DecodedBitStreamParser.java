package com.google.zxing.qrcode.decoder;

import android.support.v4.media.TransportMediator;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.ClassUtils;

/* compiled from: TbsSdkJava */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ClassUtils.INNER_CLASS_SEPARATOR_CHAR, '%', '*', '+', '-', ClassUtils.PACKAGE_SEPARATOR_CHAR, '/', ':'};
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        int i;
        int i2;
        List list;
        String str;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder stringBuilder = new StringBuilder(50);
        List arrayList = new ArrayList(1);
        CharacterSetECI characterSetECI = null;
        int i3 = -1;
        int i4 = -1;
        boolean z = false;
        while (true) {
            Mode mode;
            boolean z2;
            if (bitSource.available() < 4) {
                mode = Mode.TERMINATOR;
            } else {
                mode = Mode.forBits(bitSource.readBits(4));
            }
            if (mode == Mode.TERMINATOR) {
                z2 = z;
                i = i4;
                i2 = i3;
            } else if (mode == Mode.FNC1_FIRST_POSITION || mode == Mode.FNC1_SECOND_POSITION) {
                z2 = true;
                i = i4;
                i2 = i3;
            } else if (mode == Mode.STRUCTURED_APPEND) {
                if (bitSource.available() < 16) {
                    throw FormatException.getFormatInstance();
                }
                try {
                    z2 = z;
                    i = bitSource.readBits(8);
                    i2 = bitSource.readBits(8);
                } catch (IllegalArgumentException e) {
                    throw FormatException.getFormatInstance();
                }
            } else if (mode == Mode.ECI) {
                characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                if (characterSetECI == null) {
                    throw FormatException.getFormatInstance();
                }
                z2 = z;
                i = i4;
                i2 = i3;
            } else if (mode == Mode.HANZI) {
                r2 = bitSource.readBits(4);
                i = bitSource.readBits(mode.getCharacterCountBits(version));
                if (r2 == 1) {
                    decodeHanziSegment(bitSource, stringBuilder, i);
                }
                z2 = z;
                i = i4;
                i2 = i3;
            } else {
                r2 = bitSource.readBits(mode.getCharacterCountBits(version));
                if (mode == Mode.NUMERIC) {
                    decodeNumericSegment(bitSource, stringBuilder, r2);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else if (mode == Mode.ALPHANUMERIC) {
                    decodeAlphanumericSegment(bitSource, stringBuilder, r2, z);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else if (mode == Mode.BYTE) {
                    decodeByteSegment(bitSource, stringBuilder, r2, characterSetECI, arrayList, map);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else if (mode == Mode.KANJI) {
                    decodeKanjiSegment(bitSource, stringBuilder, r2);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (mode == Mode.TERMINATOR) {
                break;
            }
            i3 = i2;
            i4 = i;
            z = z2;
        }
        String stringBuilder2 = stringBuilder.toString();
        if (arrayList.isEmpty()) {
            list = null;
        } else {
            list = arrayList;
        }
        if (errorCorrectionLevel == null) {
            str = null;
        } else {
            str = errorCorrectionLevel.toString();
        }
        return new DecoderResult(bArr, stringBuilder2, list, str, i, i2);
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder stringBuilder, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int readBits = bitSource.readBits(13);
            readBits = (readBits % 96) | ((readBits / 96) << 8);
            if (readBits < 959) {
                readBits += 41377;
            } else {
                readBits += 42657;
            }
            bArr[i2] = (byte) ((readBits >> 8) & 255);
            bArr[i2 + 1] = (byte) (readBits & 255);
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, StringUtils.GB2312));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder stringBuilder, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int readBits = bitSource.readBits(13);
            readBits = (readBits % 192) | ((readBits / 192) << 8);
            if (readBits < 7936) {
                readBits += 33088;
            } else {
                readBits += 49472;
            }
            bArr[i2] = (byte) (readBits >> 8);
            bArr[i2 + 1] = (byte) readBits;
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder stringBuilder, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if (i * 8 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        String guessEncoding;
        Object obj = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            obj[i2] = (byte) bitSource.readBits(8);
        }
        if (characterSetECI == null) {
            guessEncoding = StringUtils.guessEncoding(obj, map);
        } else {
            guessEncoding = characterSetECI.name();
        }
        try {
            stringBuilder.append(new String(obj, guessEncoding));
            collection.add(obj);
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static char toAlphaNumericChar(int i) throws FormatException {
        if (i < ALPHANUMERIC_CHARS.length) {
            return ALPHANUMERIC_CHARS[i];
        }
        throw FormatException.getFormatInstance();
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder stringBuilder, int i, boolean z) throws FormatException {
        int length = stringBuilder.length();
        while (i > 1) {
            if (bitSource.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(11);
            stringBuilder.append(toAlphaNumericChar(readBits / 45));
            stringBuilder.append(toAlphaNumericChar(readBits % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z) {
            while (length < stringBuilder.length()) {
                if (stringBuilder.charAt(length) == '%') {
                    if (length >= stringBuilder.length() - 1 || stringBuilder.charAt(length + 1) != '%') {
                        stringBuilder.setCharAt(length, '\u001d');
                    } else {
                        stringBuilder.deleteCharAt(length + 1);
                    }
                }
                length++;
            }
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder stringBuilder, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(10);
            if (readBits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(readBits / 100));
            stringBuilder.append(toAlphaNumericChar((readBits / 10) % 10));
            stringBuilder.append(toAlphaNumericChar(readBits % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            readBits = bitSource.readBits(7);
            if (readBits >= 100) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(readBits / 10));
            stringBuilder.append(toAlphaNumericChar(readBits % 10));
        } else if (i != 1) {
        } else {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            readBits = bitSource.readBits(4);
            if (readBits >= 10) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(readBits));
        }
    }

    private static int parseECIValue(BitSource bitSource) throws FormatException {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & TransportMediator.KEYCODE_MEDIA_PAUSE;
        }
        if ((readBits & 192) == 128) {
            return ((readBits & 63) << 8) | bitSource.readBits(8);
        } else if ((readBits & ErrorCode.EXCEED_INCR_UPDATE) == 192) {
            return ((readBits & 31) << 16) | bitSource.readBits(16);
        } else {
            throw FormatException.getFormatInstance();
        }
    }
}
